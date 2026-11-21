package dev.ultreon.quentangle.qv.mixin;

import dev.ultreon.quentangle.util.IVec;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Vector3d.class)
public abstract class MixinVector3d implements IVec {
    @Shadow
    public abstract double x();

    @Shadow
    public abstract double y();

    @Shadow
    public abstract double z();

    @Override
    public double quent$x() {
        return x();
    }

    @Override
    public double quent$y() {
        return y();
    }

    @Override
    public double quent$z() {
        return z();
    }

    @Override
    public int quent$blockX() {
        return Math.floorMod((int) (Math.floor(x())), 16);
    }

    @Override
    public int quent$blockY() {
        return Math.floorMod((int) (Math.floor(y())), 16);
    }

    @Override
    public int quent$blockZ() {
        return Math.floorMod((int) (Math.floor(z())), 16);
    }

    @Override
    public IVec quent$copy() {
        return (IVec) new Vector3d(x(), y(), z());
    }

    @Override
    public int quent$getChunkX() {
        return Math.floorMod((int) (Math.floor(x())), 16);
    }

    @Override
    public int quent$getChunkZ() {
        return Math.floorMod((int) (Math.floor(z())), 16);
    }
}
