package tk.jandev.macromaker;

import tk.jandev.macromaker.tasks.Task;

import java.util.ArrayList;
import java.util.Objects;

public class Macro {
    int currentIndex = 0;
    private ArrayList<Task> tasks = new ArrayList<>();
    public Macro(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void tick() {
        Task task = this.tasks.get(currentIndex);
        if (task.isSingularTickTask()) {
            task.execute();
            currentIndex++;
        } else {
            if (task.isCompleted()) {
                currentIndex++;
            } else {
                task.tick();
            }
        }
    }

    public boolean done() {
        if (currentIndex >= this.tasks.size()) {
            currentIndex = 0;
            return true;
        }
        return false;
    }


    public Object copy() {
        return this;
    }
}
