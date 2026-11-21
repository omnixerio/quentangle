package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.CommonConstants;
import dev.ultreon.quentangle.api.IBlockSettings;
import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.api.player.IPlayer;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.block.IBlockFactory;
import dev.ultreon.quentangle.util.IBlockHit;
import dev.ultreon.quentangle.util.InteractResult;
import net.quantumvoxel.Blocks;
import net.quantumvoxel.block.Block;
import net.quantumvoxel.block.state.BlockState;
import net.quantumvoxel.item.UseResult;
import net.quantumvoxel.player.PlayerEntity;
import net.quantumvoxel.server.ServerWorld;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.world.HitResult;
import net.quantumvoxel.world.World;

class BlocksApi implements IBlocksApi {
    @Override
    public IBlock getAir() {
        return (IBlock) Blocks.AIR;
    }

    @Override
    public IBlock getStone() {
        return (IBlock) Blocks.STONE;
    }

    @Override
    public IBlock getDirt() {
        return (IBlock) Blocks.DIRT;
    }

    @Override
    public IBlock getGrass() {
        return (IBlock) Blocks.GRASS_BLOCK;
    }

    @Override
    public IBlockSettings blockSettings() {
        return (IBlockSettings) new Block.Settings();
    }

    @Override
    public IBlock create(IBlockFactory factory, IBlockSettings properties) {
        return (IBlock) (Object) new Block((Block.Settings) properties) {
            @Override
            public UseResult use(World world, PlayerEntity player, BlockState state, HitResult hitResult) {
                InteractResult use = factory.use((IBlockState) (Object) state, (IWorld) world, (IBlockVec) hitResult.hitBlock(), (IPlayer) player, (IBlockHit) (Object) hitResult);
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
                factory.onBreak(state, (IWorld) (Object) world, (IBlockVec) breaking, null);
            }

            @Override
            public void onPlace(ServerWorld serverWorld, BlockVec blockVec, BlockState blockState) {
                factory.onPlace((IBlockState) (Object) blockState, (IWorld) (Object) serverWorld, (IBlockVec) blockVec, null);
            }
        };
    }
}
