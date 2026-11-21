package dev.ultreon.quentangle.qv.mixin;

import dev.ultreon.quentangle.api.IBlockVec;
import net.quantumvoxel.util.BlockVec;
import org.joml.Vector3i;
import org.joml.Vector4i;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockVec.class)
public abstract class MixinBlockVec extends Vector3i implements IBlockVec {
    @Override
    public int quent$x() {
        return x;
    }

    @Override
    public int quent$y() {
        return y;
    }

    @Override
    public int quent$z() {
        return z;
    }
}
