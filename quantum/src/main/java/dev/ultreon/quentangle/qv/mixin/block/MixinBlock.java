package dev.ultreon.quentangle.qv.mixin.block;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.world.IServerWorld;
import net.quantumvoxel.block.Block;
import net.quantumvoxel.block.state.BlockState;
import net.quantumvoxel.item.UseResult;
import net.quantumvoxel.player.PlayerEntity;
import net.quantumvoxel.server.ServerWorld;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.world.HitResult;
import net.quantumvoxel.world.World;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.player.IPlayer;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.util.IBlockHit;
import dev.ultreon.quentangle.util.IHit;
import dev.ultreon.quentangle.util.IVec;
import dev.ultreon.quentangle.util.InteractResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.class)
public abstract class MixinBlock implements IBlock {

    @Shadow
    public abstract UseResult use(World world, PlayerEntity player, BlockState state, HitResult hitResult);

    @Shadow
    public abstract void onDestroy(ServerWorld world, BlockVec breaking, BlockState blockState);

    @Shadow
    public abstract void onPlace(ServerWorld serverWorld, BlockVec blockVec, BlockState blockState);

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
