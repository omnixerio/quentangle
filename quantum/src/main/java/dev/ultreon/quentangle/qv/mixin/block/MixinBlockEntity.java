package dev.ultreon.quentangle.qv.mixin.block;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.block.entity.IBlockEntity;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.api.world.IWorld;
import net.quantumvoxel.block.entity.BlockEntity;
import net.quantumvoxel.block.state.BlockState;
import net.quantumvoxel.server.ServerWorld;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockEntity.class)
public abstract class MixinBlockEntity implements IBlockEntity {

    @Shadow
    public abstract BlockState getBlockState();

    @Shadow
    public abstract BlockVec getPos();

    @Shadow
    public abstract World getWorld();

    @Shadow
    public abstract ServerWorld getServerWorld();

    @Override
    public IBlockState quent$blockState() {
        return (IBlockState) (Object) getBlockState();
    }

    @Override
    public IBlockVec quent$blockVec() {
        return (IBlockVec) getPos();
    }

    @Override
    public IWorld quent$world() {
        return (IWorld) getWorld();
    }

    @Override
    public IServerWorld quent$serverWorld() {
        return (IServerWorld) (Object) getServerWorld();
    }
}
