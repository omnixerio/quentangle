package dev.ultreon.quentangle.api.block.entity;

public interface IBlockEntityListener {
    void tick(IBlockEntity blockEntity);

    void onRemove(IBlockEntity blockEntity);
}
