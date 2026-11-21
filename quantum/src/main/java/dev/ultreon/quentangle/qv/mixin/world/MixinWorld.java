package dev.ultreon.quentangle.qv.mixin.world;

import net.quantumvoxel.Blocks;
import net.quantumvoxel.ai.BlockNavigator;
import net.quantumvoxel.block.state.BlockState;
import net.quantumvoxel.resource.GameObject;
import net.quantumvoxel.util.BlockFlags;
import net.quantumvoxel.world.BlockAccess;
import net.quantumvoxel.world.World;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.world.IClientWorld;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.api.world.IWorld;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(World.class)
public abstract class MixinWorld extends GameObject implements BlockAccess, BlockNavigator.WorldAccess, IWorld {
    @Shadow public abstract @NotNull BlockState get(int x, int y, int z);

    @Shadow
    public abstract boolean set(int i, int i1, int i2, BlockState blockState, int i3);

    @Override
    public @Nullable IServerWorld quent$asServerWorld() {
        return this instanceof IServerWorld ? (IServerWorld) this : null;
    }

    @Override
    public @Nullable IClientWorld quent$asClientWorld() {
        return this instanceof IClientWorld ? (IClientWorld) this : null;
    }

    @Override
    public IBlockState quent$getBlock(int x, int y, int z) {
        return (IBlockState) (Object) get(x, y, z);
    }

    @Override
    public void quent$setBlock(int x, int y, int z, IBlockState block) {
        set(x, y, z, (BlockState) (Object) block, BlockFlags.BLOCK_UPDATE | BlockFlags.NEIGHBOR_UPDATE | BlockFlags.NOTIFY_CLIENTS);
    }

    @Override
    public void quent$removeBlock(int x, int y, int z) {
        set(x, y, z, Blocks.AIR.getDefaultState(), BlockFlags.BLOCK_UPDATE | BlockFlags.NEIGHBOR_UPDATE | BlockFlags.NOTIFY_CLIENTS);
    }
}
