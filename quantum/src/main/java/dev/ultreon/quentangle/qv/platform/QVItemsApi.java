package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.item.*;
import dev.ultreon.quentangle.item.IItemInstance;
import dev.ultreon.quentangle.item.IItemsApi;
import net.quantumvoxel.item.Item;
import net.quantumvoxel.item.ItemStack;
import net.quantumvoxel.item.Items;

import java.util.function.Supplier;

class QVItemsApi implements IItemsApi {
    @Override
    public IItem getAir() {
        return (IItem) Items.AIR;
    }

    @Override
    public IItem getStone() {
        return (IItem) Items.STONE;
    }

    @Override
    public IItem getDirt() {
        return (IItem) Items.DIRT;
    }

    @Override
    public IItemSettings itemSettings() {
        return (IItemSettings) new Item.Settings();
    }

    @Override
    public <T extends IItemListener> IItemInstance<T> item(T listener, IItemSettings settings) {
        return new QuentItem<>(listener, settings);
    }

    @Override
    public <T extends IBlockItemListener> IBlockItemInstance<T> blockItem(T listener, Supplier<IBlock> blockSupplier, IItemSettings settings) {
        return new QuentBlockItem<>(listener, blockSupplier, settings);
    }

    @Override
    public IItemStack stack(IItem item, int count) {
        return (IItemStack) new ItemStack((Item) item, count);
    }
}
