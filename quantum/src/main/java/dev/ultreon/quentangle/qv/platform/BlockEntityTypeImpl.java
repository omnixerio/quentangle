package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.entity.IBlockEntity;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityInstance;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityType;
import dev.ultreon.quentangle.api.world.IWorld;
import net.quantumvoxel.block.entity.BlockEntityType;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.world.World;

public class BlockEntityTypeImpl implements IBlockEntityType {
    private final BlockEntityType<?> blockEntityBlockEntityType;

    public BlockEntityTypeImpl(BlockEntityType<?> blockEntityBlockEntityType) {
        this.blockEntityBlockEntityType = blockEntityBlockEntityType;
    }

    @Override
    public IBlockEntity create(IBlockVec pos, IWorld world) {
        return (IBlockEntity) blockEntityBlockEntityType.create((BlockVec) pos, (World)world);
    }
}
