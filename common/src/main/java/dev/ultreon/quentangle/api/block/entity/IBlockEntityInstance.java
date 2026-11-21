package dev.ultreon.quentangle.api.block.entity;

public interface IBlockEntityInstance<T> extends IBlockEntity {
    T getListener();
}
