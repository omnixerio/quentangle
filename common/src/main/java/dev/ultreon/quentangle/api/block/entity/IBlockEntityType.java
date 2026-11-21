package dev.ultreon.quentangle.api.block.entity;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.world.IWorld;

public interface IBlockEntityType {
    IBlockEntity create(IBlockVec pos, IWorld world);
}
