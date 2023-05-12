package tk.jandev.macromaker;

import tk.jandev.macromaker.tasks.Task;

import java.util.ArrayList;

public class MacroBuilder {
    private ArrayList<Task> tasks = new ArrayList<>();
    public MacroBuilder() {

    }
    public MacroBuilder add(Task e) {
        tasks.add(e);
        return this;
    }

    public MacroBuilder repeat(Task e, int amount) {
        for (int i = 0; i < amount; i++) {
            tasks.add(e);
        }
        return this;
    }

    public Macro build() {
        return new Macro(tasks);
    }

    public static MacroBuilder newBuilder() {
        return new MacroBuilder();
    }
}
