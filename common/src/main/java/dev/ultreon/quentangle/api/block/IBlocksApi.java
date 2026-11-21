package dev.ultreon.quentangle.api.block;

import dev.ultreon.quentangle.api.IBlockSettings;
import dev.ultreon.quentangle.block.IBlockFactory;

public interface IBlocksApi {
    IBlock getAir();
    IBlock getStone();
    IBlock getDirt();
    IBlock getGrass();

    IBlockSettings blockSettings();

    IBlock create(IBlockFactory factory, IBlockSettings properties);
}
