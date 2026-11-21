package dev.ultreon.quentangle.block;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.player.IPlayer;
import dev.ultreon.quentangle.util.IBlockHit;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.util.InteractResult;
import org.jetbrains.annotations.Nullable;

public interface IBlockListener {
    @Nullable
    default InteractResult use(IBlockState state, IWorld world, IBlockVec pos, IPlayer player, IBlockHit hit) {
        return null;
    }

    default boolean onBreak(IBlockState state, IWorld world, IBlockVec pos, @Nullable IPlayer player) {
        return false;
    }

    default boolean onPlace(IBlockState state, IWorld world, IBlockVec pos, @Nullable IPlayer player) {
        return false;
    }
}
