package tk.jandev.macromaker.tasks;

public class SetPitchTask implements Task{
    private final float pitch;
    public SetPitchTask(float yaw) {
        this.pitch = yaw;
    }
    @Override
    public void execute() {
        mc.player.setPitch(this.pitch);
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
