package tk.jandev.macromaker.tasks;

public class SendCommandTask implements Task{
    private final String command;
    public SendCommandTask(String command) {
        this.command = command;
    }
    @Override
    public void execute() {
        mc.getNetworkHandler().sendChatCommand(this.command);
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
