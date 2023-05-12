package tk.jandev.macromaker.tasks;

import net.minecraft.client.MinecraftClient;

public abstract interface Task {
    final MinecraftClient mc = MinecraftClient.getInstance();
    public void execute();
    public void tick();
    public boolean isSingularTickTask();
    public boolean isCompleted();
}
