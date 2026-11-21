package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.IBlockSettings;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.block.IBlockListener;
import dev.ultreon.quentangle.dev.IBlockInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlocksApi implements IBlocksApi {
    @Override
    public IBlock getAir() {
        return (IBlock) (Object) Blocks.AIR;
    }

    @Override
    public IBlock getStone() {
        return (IBlock) (Object) Blocks.STONE;
    }

    @Override
    public IBlock getDirt() {
        return (IBlock) (Object) Blocks.DIRT;
    }

    @Override
    public IBlock getGrass() {
        return (IBlock) (Object) Blocks.GRASS_BLOCK;
    }

    @Override
    public IBlockSettings blockSettings() {
        return (IBlockSettings) (Object) Block.Properties.of();
    }

    @Override
    public <T extends IBlockListener> IBlockInstance<T> create(T listener, IBlockSettings properties) {
        return new BlockInstance<>(listener, properties);
    }
}
