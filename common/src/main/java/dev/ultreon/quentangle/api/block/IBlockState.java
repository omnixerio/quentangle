package dev.ultreon.quentangle.api.block;

import dev.ultreon.quentangle.api.player.IPlayer;
import dev.ultreon.quentangle.util.IBlockHit;
import dev.ultreon.quentangle.util.IVec;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.util.InteractResult;

public interface IBlockState {
    InteractResult quent$use(IWorld world, IVec pos, IPlayer player, IBlockHit hit);

    IBlock quent$getBlock();
}
