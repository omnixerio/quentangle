package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityApi;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityListener;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityInstanceType;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.registry.IKey;
import net.quantumvoxel.block.entity.BlockEntityType;

public class BlockEntityApi implements IBlockEntityApi {
    @Override
    public <T extends IBlockEntityListener> IBlockEntityInstanceType<T> createBlockEntity(IKey key, T listener) {
        BlockEntityType.Factory<QuentangleBlockEntity<T>> quentangleBlockEntityFactory = (type, pos, world) -> new QuentangleBlockEntity<T>(type, (IBlockVec) pos, (IWorld) world, listener);
        return new BlockEntityInstanceTypeImpl<>(new BlockEntityType<>(quentangleBlockEntityFactory), listener);
    }

    @Override
    public IBlockEntityInstanceType<?> getBlockEntityType(IKey key) {
        return null;
    }
}
