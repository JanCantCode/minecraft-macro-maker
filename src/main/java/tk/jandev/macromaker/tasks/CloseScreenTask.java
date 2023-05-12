package tk.jandev.macromaker.tasks;

public class CloseScreenTask implements Task{
    @Override
    public void execute() {
        mc.setScreen(null);
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
