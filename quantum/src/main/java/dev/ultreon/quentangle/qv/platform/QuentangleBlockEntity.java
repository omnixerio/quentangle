package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityInstance;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityListener;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.api.world.IWorld;
import net.quantumvoxel.block.entity.BlockEntity;
import net.quantumvoxel.block.entity.BlockEntityType;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.world.World;
import org.jetbrains.annotations.Nullable;

public class QuentangleBlockEntity <T extends IBlockEntityListener> extends BlockEntity implements IBlockEntityInstance<T> {
    private final T listener;

    public QuentangleBlockEntity(BlockEntityType<QuentangleBlockEntity<T>> type, IBlockVec pos, IWorld world, T listener) {
        super(type, (BlockVec) pos, (World) world);
        this.listener = listener;
    }

    @Override
    public void tick() {
        listener.tick(this);
    }

    @Override
    public T getListener() {
        return listener;
    }

    @Override
    public IBlockState quent$blockState() {
        return (IBlockState) (Object) getBlockState();
    }

    @Override
    public IBlockVec quent$blockVec() {
        return (IBlockVec) getPos();
    }

    @Override
    public IWorld quent$world() {
        return (IWorld) getWorld();
    }

    @Override
    public @Nullable IServerWorld quent$serverWorld() {
        return (IServerWorld) (Object) getServerWorld();
    }
}
