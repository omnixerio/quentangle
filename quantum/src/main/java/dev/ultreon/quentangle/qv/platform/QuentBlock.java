package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.CommonConstants;
import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.player.IPlayer;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.block.IBlockListener;
import dev.ultreon.quentangle.dev.IBlockInstance;
import dev.ultreon.quentangle.util.IBlockHit;
import dev.ultreon.quentangle.util.IHit;
import dev.ultreon.quentangle.util.IVec;
import dev.ultreon.quentangle.util.InteractResult;
import net.quantumvoxel.block.Block;
import net.quantumvoxel.block.state.BlockState;
import net.quantumvoxel.item.UseResult;
import net.quantumvoxel.player.PlayerEntity;
import net.quantumvoxel.server.ServerWorld;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.world.HitResult;
import net.quantumvoxel.world.World;

public class QuentBlock<T extends IBlockListener> extends Block implements IBlockInstance<T> {
    private final T listener;

    public QuentBlock(Block.Settings properties, T listener) {
        super(properties);
        this.listener = listener;
    }

    @Override
    public T listener() {
        return listener;
    }

    @Override
    public UseResult use(World world, PlayerEntity player, BlockState state, HitResult hitResult) {
        InteractResult use = listener.use((IBlockState) (Object) state, (IWorld) world, (IBlockVec) hitResult.hitBlock(), (IPlayer) player, (IBlockHit) (Object) hitResult);
        if (use == null) return super.use(world, player, state, hitResult);
        return switch (use) {
            case FAIL -> UseResult.FAIL;
            case PASS -> UseResult.SEND;
            case SUCCESS, CONSUME -> UseResult.SUCCESS;
            default -> {
                CommonConstants.LOG.warn("Unknown interact result: {}", use);
                yield UseResult.FAIL;
            }
        };
    }

    @Override
    public void onDestroy(ServerWorld world, BlockVec breaking, BlockState blockState) {
        IBlockState state = (IBlockState) (Object) world.get(breaking);
        listener.onBreak(state, (IWorld) (Object) world, (IBlockVec) breaking, null);
    }

    @Override
    public void onPlace(ServerWorld serverWorld, BlockVec blockVec, BlockState blockState) {
        listener.onPlace((IBlockState) (Object) blockState, (IWorld) (Object) serverWorld, (IBlockVec) blockVec, null);
    }

    @Override
    public InteractResult quent$use(IBlockState state, IWorld world, IVec pos, IPlayer player, IBlockHit hit) {
        World world1 = (World) world;
        BlockState blockState = world1.get((BlockVec) pos);
        UseResult use = use(world1, (PlayerEntity) player, blockState, (HitResult) (Object) hit);
        return switch (use) {
            case SUCCESS -> InteractResult.SUCCESS;
            case FAIL -> InteractResult.FAIL;
            case SEND -> InteractResult.SEND;
            case PASS -> InteractResult.PASS;
        };
    }

    @Override
    public boolean quent$onBreak(IBlockState state, IServerWorld world, IBlockVec pos, IPlayer player) {
        onDestroy((ServerWorld) (Object) world, new BlockVec(pos.quent$x(), pos.quent$y(), pos.quent$z()), (BlockState) (Object) state);
        return true;
    }

    @Override
    public IBlockState quent$onPlace(IBlockState state, IBlockState newState, IWorld world, IBlockVec pos, IPlayer player, IHit hit) {
        if (!(world instanceof IServerWorld serverWorld)) return newState;
        onPlace((ServerWorld) (Object) serverWorld, (BlockVec) pos, (BlockState) (Object) state);
        return world.quent$getBlock(pos);
    }

    @Override
    public IBlockState quent$defaultState() {
        return null;
    }
}
