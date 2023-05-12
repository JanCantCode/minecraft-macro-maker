package tk.jandev.macromaker.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import tk.jandev.macromaker.Macro;
import tk.jandev.macromaker.MacroBuilder;
import tk.jandev.macromaker.macroRunner.MacroRunner;
import tk.jandev.macromaker.tasks.*;

import java.awt.*;

public class MacromakerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() { // simple macro to buy and sell experience bottles from the typical crystal pvp shop.
        MinecraftClient mc = MinecraftClient.getInstance();
        KeyBinding stop = KeyBindingHelper.registerKeyBinding(new KeyBinding("stop macro", 0, "macro"));

        Macro armorMacro = MacroBuilder.newBuilder()
                .add(new CloseScreenTask())
                .add(new SendCommandTask("shop"))
                .add(new WaitTask(5))
                .add(new MoveSlotsTask(22, 0, SlotActionType.PICKUP))
                .add(new WaitTask(5))
                .add(new MoveSlotsTask(4, 0, SlotActionType.PICKUP))
                .add(new WaitTask(5))
                .add(new MoveSlotsTask(31, 0, SlotActionType.PICKUP))
                .add(new WaitTask(5))
                .add(new MoveSlotsTask(25, 0, SlotActionType.PICKUP))
                .add(new WaitTask(5))
                .add(new MoveSlotsTask(13, 0, SlotActionType.PICKUP))
                .add(new CloseScreenTask())
                .add(new WaitTask(5))
                .add(new SendCommandTask("sellall EXPERIENCE_BOTTLE"))
                .add(new WaitTask(5))
        .build();



        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("firearmor").executes(context -> {
            MacroRunner.setCurrent((Macro) armorMacro.copy());
            return 1;
        })));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (mc.player == null) return;
            if (stop.isPressed()) {
                MacroRunner.setCurrent(null);
            }
            MacroRunner.tick();
        });


    }

    public static void renderHandledScreen(MinecraftClient mc, TextRenderer textRenderer, MatrixStack matrices) { // stuff that makes creating macros easier, nothin more!
        int height = 9;
        for (int i = 0; i < mc.player.currentScreenHandler.getStacks().size(); i++) {
            textRenderer.draw(matrices, i+" "+mc.player.currentScreenHandler.getStacks().get(i), 600, height+(i*9), Color.WHITE.getRGB());
        }
    }
}
