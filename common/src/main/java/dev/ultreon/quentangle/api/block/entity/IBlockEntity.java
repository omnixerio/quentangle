package dev.ultreon.quentangle.api.block.entity;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.api.world.IWorld;
import org.jetbrains.annotations.Nullable;

public interface IBlockEntity {
    IBlockState quent$blockState();

    IBlockVec quent$blockVec();

    IWorld quent$world();

    @Nullable
    IServerWorld quent$serverWorld();
}
