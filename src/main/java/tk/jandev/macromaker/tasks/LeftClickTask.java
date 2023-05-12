package tk.jandev.macromaker.tasks;

import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;

public class LeftClickTask implements Task {
    @Override
    public void execute() {
        if (mc.crosshairTarget instanceof EntityHitResult entityHitResult) {
            mc.interactionManager.attackEntity(mc.player, entityHitResult.getEntity());
        } else {
            if (mc.crosshairTarget instanceof BlockHitResult blockHitResult) {
                mc.interactionManager.attackBlock(blockHitResult.getBlockPos(), Direction.UP);
            }
        }
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
