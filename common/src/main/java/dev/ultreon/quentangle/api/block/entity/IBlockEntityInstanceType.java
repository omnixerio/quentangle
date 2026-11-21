package dev.ultreon.quentangle.api.block.entity;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.world.IWorld;

public interface IBlockEntityInstanceType<T extends IBlockEntityListener> extends IBlockEntityType {
    IBlockEntityInstance<T> create(IBlockVec pos, IWorld world);
}
