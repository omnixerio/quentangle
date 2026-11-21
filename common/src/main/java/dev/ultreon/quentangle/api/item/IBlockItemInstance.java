package dev.ultreon.quentangle.api.item;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.item.IBlockItem;
import dev.ultreon.quentangle.item.IItemInstance;

public interface IBlockItemInstance<T extends IBlockItemListener> extends IBlockItem, IItemInstance<T> {
    IBlock quent$block();
    T quent$listener();
}
