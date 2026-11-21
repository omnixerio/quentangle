package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.IBlockSettings;
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
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class BlockInstance<T extends IBlockListener> extends Block implements IBlockInstance<T> {
    private final T listener;

    public BlockInstance(T listener, IBlockSettings settings) {
        super((Properties) settings);
        this.listener = listener;
    }

    @Override
    public T listener() {
        return listener;
    }

    @Override
    public InteractResult quent$use(IBlockState state, IWorld world, IVec pos, IPlayer player, IBlockHit hit) {
        Player mcPlayer = (Player) player;
        InteractionResult interactionResult = useWithoutItem((BlockState) state, (Level) world, new BlockPos(pos.quent$blockX(), pos.quent$blockY(), pos.quent$blockZ()), mcPlayer, new BlockHitResult((Vec3) hit.quent$hitVec(), switch (hit.quent$direction()) {
            case UP -> Direction.UP;
            case DOWN -> Direction.DOWN;
            case NORTH -> Direction.NORTH;
            case SOUTH -> Direction.SOUTH;
            case WEST -> Direction.WEST;
            case EAST -> Direction.EAST;
        }, (BlockPos) hit.quent$blockVec(), false));
        return switch (interactionResult) {
            case SUCCESS, SUCCESS_NO_ITEM_USED -> InteractResult.SUCCESS;
            case CONSUME, CONSUME_PARTIAL -> InteractResult.CONSUME;
            case FAIL -> InteractResult.FAIL;
            default -> InteractResult.PASS;
        };
    }

    @Override
    public boolean quent$onBreak(IBlockState state, IServerWorld world, IBlockVec pos, IPlayer player) {
        playerDestroy((Level) world,(Player) player, (BlockPos) pos, (BlockState) state, ((Level) world).getBlockEntity((BlockPos) pos), ((Player) player).getMainHandItem());
        return true;
    }

    @Override
    public @Nullable IBlockState quent$onPlace(IBlockState state, IBlockState newState, IWorld world, IBlockVec pos, IPlayer player, IHit hit) {
        onPlace((BlockState) newState, (Level) world, (BlockPos) pos, (BlockState) state, false);
        return null;
    }

    @Override
    public IBlockState quent$defaultState() {
        return (IBlockState) defaultBlockState();
    }
}
