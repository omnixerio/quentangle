package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityInstance;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityListener;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityInstanceType;
import dev.ultreon.quentangle.api.world.IWorld;
import net.quantumvoxel.block.entity.BlockEntityType;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.world.World;

public class BlockEntityInstanceTypeImpl<T extends IBlockEntityListener> implements IBlockEntityInstanceType<T> {
    private final BlockEntityType<QuentangleBlockEntity<T>> blockEntityBlockEntityType;
    private final T listener;

    public BlockEntityInstanceTypeImpl(BlockEntityType<QuentangleBlockEntity<T>> blockEntityBlockEntityType, T listener) {
        this.blockEntityBlockEntityType = blockEntityBlockEntityType;
        this.listener = listener;
    }

    @Override
    public IBlockEntityInstance<T> create(IBlockVec pos, IWorld world) {
        return blockEntityBlockEntityType.create((BlockVec) pos, (World)world);
    }

    public T getListener() {
        return listener;
    }
}
