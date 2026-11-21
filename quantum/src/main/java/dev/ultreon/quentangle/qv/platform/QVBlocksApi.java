package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IBlockSettings;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.block.IBlockListener;
import dev.ultreon.quentangle.dev.IBlockInstance;
import net.quantumvoxel.Blocks;
import net.quantumvoxel.block.Block;

class QVBlocksApi implements IBlocksApi {
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
    public <T extends IBlockListener> IBlockInstance<T> create(T listener, IBlockSettings properties) {
        return new QuentBlock<>((Block.Settings) properties, listener);
    }
}
