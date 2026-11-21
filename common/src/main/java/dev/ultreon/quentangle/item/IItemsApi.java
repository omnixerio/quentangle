package dev.ultreon.quentangle.item;

import dev.ultreon.quentangle.api.IBlockSettings;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.item.*;

import java.util.function.Supplier;

public interface IItemsApi {
    IItem getAir();
    IItem getStone();
    IItem getDirt();

    IItemSettings itemSettings();

    <T extends IItemListener> IItemInstance<T> item(T listener, IItemSettings settings);

    <T extends IBlockItemListener> IBlockItemInstance<T> blockItem(T listener, Supplier<IBlock> blockSupplier, IItemSettings settings);

    default IItemStack stack(IItem item) {
        return stack(item, 1);
    }

    IItemStack stack(IItem item, int count);
}
