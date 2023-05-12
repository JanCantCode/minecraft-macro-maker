package tk.jandev.macromaker.tasks;

public class WaitTask implements Task {
    private int ticks;
    private int cooldown;

    public WaitTask(int ticks) {
        this.cooldown = ticks;
        this.ticks = cooldown;
    }
    @Override
    public void execute() {

    }

    @Override
    public void tick() {
        ticks--;
    }

    @Override
    public boolean isSingularTickTask() {
        return false;
    }

    @Override
    public boolean isCompleted() {
        if (ticks == 0) {
            ticks = this.cooldown;
            return true;
        }
        return false;
    }
}
