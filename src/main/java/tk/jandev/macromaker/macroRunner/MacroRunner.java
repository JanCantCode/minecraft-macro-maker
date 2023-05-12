package tk.jandev.macromaker.macroRunner;

import tk.jandev.macromaker.Macro;

public class MacroRunner {
    private static Macro currentMacro;
    private static Macro macro1;
    public static void setCurrent(Macro macro) {
        currentMacro = macro;
        macro1 = macro;
    }

    public static void tick() {
        if (currentMacro == null) return;
        if (currentMacro.done()) {
            currentMacro = macro1;
            return;
        }
        currentMacro.tick();
    }
}
