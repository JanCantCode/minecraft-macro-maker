package tk.jandev.macromaker.tasks;

import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;

public class RightClickTask implements Task {
    private final Hand hand;
    public RightClickTask(Hand hand) {
        this.hand = hand;
    }
    @Override
    public void execute() {
        if (mc.crosshairTarget instanceof BlockHitResult blockHitResult) {
            mc.interactionManager.interactBlock(mc.player, this.hand, blockHitResult);
        } else {
            if (mc.crosshairTarget instanceof EntityHitResult entityHitResult) {
                mc.interactionManager.interactEntity(mc.player, entityHitResult.getEntity(), this.hand);
            } else {
                mc.interactionManager.interactItem(mc.player, this.hand);
            }
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean isSingularTickTask() {
        return true;
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
