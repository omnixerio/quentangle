package dev.ultreon.quentangle.mc.mixin.block;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.player.IPlayer;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.util.IBlockHit;
import dev.ultreon.quentangle.util.IHit;
import dev.ultreon.quentangle.util.IVec;
import dev.ultreon.quentangle.util.InteractResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.class)
public abstract class MixinBlock extends BlockBehaviour implements IBlock {
    @Shadow public abstract void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool);

    @Shadow public abstract BlockState defaultBlockState();

    public MixinBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractResult quent$use(IBlockState state, IWorld world, IVec pos, IPlayer player, IBlockHit hit) {
        return switch (useWithoutItem((BlockState) state, (Level) world, (BlockPos) IBlockVec.fromVec(pos), (Player) player, (BlockHitResult) hit)) {
            case SUCCESS -> InteractResult.SUCCESS;
            case FAIL -> InteractResult.FAIL;
            case CONSUME -> InteractResult.CONSUME;
            case PASS -> InteractResult.PASS;
            default -> InteractResult.UNKNOWN;
        };
    }

    @Override
    public boolean quent$onBreak(IBlockState state, IServerWorld world, IBlockVec pos, IPlayer player) {
        BlockPos blockPos = new BlockPos(pos.quent$x(), pos.quent$y(), pos.quent$z());
        Level level = (Level) world;
        playerDestroy(level, (Player) player, blockPos, (BlockState) state, level.getBlockEntity(blockPos), ((Player) player).getUseItem());
        return true;
    }

    @Override
    public IBlockState quent$onPlace(IBlockState state, IBlockState newState, IWorld world, IBlockVec pos, IPlayer player, IHit hit) {
        BlockPos blockPos = new BlockPos(pos.quent$x(), pos.quent$y(), pos.quent$z());
        onPlace((BlockState) newState, (Level) world, blockPos, (BlockState) state, false);
        return (IBlockState) ((Level) world).getBlockState(blockPos);
    }

    @Override
    public IBlockState quent$defaultState() {
        return (IBlockState) defaultBlockState();
    }
}
