package dev.ultreon.quentangle.api.block.entity;

import dev.ultreon.quentangle.registry.IKey;

public interface IBlockEntityApi {
    <T extends IBlockEntityListener> IBlockEntityInstanceType<T> createBlockEntity(IKey key, T listener);

    IBlockEntityInstanceType<?> getBlockEntityType(IKey key);
}
