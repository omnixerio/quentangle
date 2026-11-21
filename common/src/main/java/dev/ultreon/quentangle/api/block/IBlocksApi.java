package dev.ultreon.quentangle.api.block;

import dev.ultreon.quentangle.api.IBlockSettings;
import dev.ultreon.quentangle.block.IBlockListener;
import dev.ultreon.quentangle.dev.IBlockInstance;

public interface IBlocksApi {
    IBlock getAir();
    IBlock getStone();
    IBlock getDirt();
    IBlock getGrass();

    IBlockSettings blockSettings();

    <T extends IBlockListener> IBlockInstance<T> create(T factory, IBlockSettings properties);
}
