package dev.ultreon.quentangle.mc.mixin.util;

import dev.ultreon.quentangle.util.IVec;
import net.minecraft.core.Position;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Position.class)
public interface MixinPosition extends IVec {
    @Shadow
    double x();

    @Shadow
    double y();

    @Shadow
    double z();

    @Override
    default double quent$x() {
        return x();
    }

    @Override
    default double quent$y() {
        return y();
    }

    @Override
    default double quent$z() {
        return z();
    }

    @Override
    default int quent$blockX() {
        return Math.floorMod((int) x(), 16);
    }

    @Override
    default int quent$blockY() {
        return Math.floorMod((int) y(), 16);
    }

    @Override
    default int quent$blockZ() {
        return Math.floorMod((int) z(), 16);
    }

    @Override
    default IVec quent$copy() {
        return (IVec) new Vec3(x(), y(), z());
    }

    @Override
    default int quent$getChunkX() {
        return Math.floorDiv((int) x(), 16);
    }

    @Override
    default int quent$getChunkZ() {
        return Math.floorDiv((int) z(), 16);
    }
}
