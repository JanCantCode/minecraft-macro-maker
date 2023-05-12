package tk.jandev.macromaker.tasks;

public class SetYawTask implements Task {
    private final float yaw;
    public SetYawTask(float yaw) {
        this.yaw = yaw;
    }
    @Override
    public void execute() {
        mc.player.setYaw(this.yaw);
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
