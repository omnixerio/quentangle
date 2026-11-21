package dev.ultreon.quentangle.api.world;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlockState;
import org.jetbrains.annotations.Nullable;

public interface IWorld {
    @Nullable IServerWorld quent$asServerWorld();

    @Nullable IClientWorld quent$asClientWorld();

    IBlockState quent$getBlock(int x, int y, int z);

    default IBlockState quent$getBlock(IBlockVec pos) {
        return quent$getBlock(pos.quent$x(), pos.quent$y(), pos.quent$z());
    }

    void quent$setBlock(int x, int y, int z, IBlockState block);

    default void quent$setBlock(IBlockVec pos, IBlockState block) {
        quent$setBlock(pos.quent$x(), pos.quent$y(), pos.quent$z(), block);
    }

    void quent$removeBlock(int x, int y, int z);

    default void quent$removeBlock(IBlockVec pos) {
        quent$removeBlock(pos.quent$x(), pos.quent$y(), pos.quent$z());
    }
}
