package tk.jandev.macromaker.tasks;

import net.minecraft.screen.slot.SlotActionType;

public class MoveSlotsTask implements Task {
    private final int slot;
    private final int button;
    private final SlotActionType slotActionType;

    public MoveSlotsTask(int slot, int button, SlotActionType slotActionType) {
        this.slot = slot;
        this.button = button;
        this.slotActionType = slotActionType;
    }
    @Override
    public void execute() {
        int syncID = mc.player.currentScreenHandler.syncId;
        mc.interactionManager.clickSlot(syncID, this.slot, this.button, this.slotActionType, mc.player);
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
