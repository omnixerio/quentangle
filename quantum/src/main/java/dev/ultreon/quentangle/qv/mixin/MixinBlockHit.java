package dev.ultreon.quentangle.qv.mixin;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.util.*;
import net.quantumvoxel.world.HitResult;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HitResult.class)
public abstract class MixinBlockHit implements IBlockHit {
    @Shadow
    public abstract Vector3d hitPos();

    @Shadow
    public abstract net.quantumvoxel.util.BlockVec hitBlock();

    @Shadow
    public abstract net.quantumvoxel.util.Direction face();

    @Override
    public IVec quent$hitVec(IVec pos) {
        return pos.set(hitPos().x, hitPos().y, hitPos().z);
    }

    @Override
    public IBlockVec quent$blockVec() {
        return (IBlockVec) hitBlock();
    }

    @Override
    public Direction quent$direction() {
        return switch (face()) {
            case DOWN -> Direction.DOWN;
            case UP -> Direction.UP;
            case NORTH -> Direction.NORTH;
            case SOUTH -> Direction.SOUTH;
            case WEST -> Direction.WEST;
            case EAST -> Direction.EAST;
        };
    }
}
