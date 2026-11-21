package dev.ultreon.quentangle.mc.mixin.util;

import dev.ultreon.quentangle.api.IBlockVec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockPos.class)
public abstract class MixinBlockPos extends Vec3i implements IBlockVec {
    public MixinBlockPos(int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public int quent$x() {
        return getX();
    }

    @Override
    public int quent$y() {
        return getY();
    }

    @Override
    public int quent$z() {
        return getZ();
    }
}
