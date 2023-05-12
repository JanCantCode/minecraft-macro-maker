package tk.jandev.macromaker.tasks;

public class SelectHotBarSlotTask implements Task{
    private final int slot;
    public SelectHotBarSlotTask(int slot) {
        this.slot = slot;
    }
    @Override
    public void execute() {
        mc.player.getInventory().selectedSlot = this.slot;
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
