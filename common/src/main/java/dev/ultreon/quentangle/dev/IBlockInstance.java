package dev.ultreon.quentangle.dev;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.block.IBlockListener;

public interface IBlockInstance<T extends IBlockListener> extends IBlock {
    T listener();
}
