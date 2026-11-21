package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.item.*;
import dev.ultreon.quentangle.item.IItemInstance;
import dev.ultreon.quentangle.item.IItemsApi;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public class ItemsApi implements IItemsApi {
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
        return (IItemSettings) new Item.Properties();
    }

    @Override
    public <T extends IItemListener> IItemInstance<T> item(T listener, IItemSettings settings) {
        return new MCItemInstance<>(listener, settings);
    }

    @Override
    public <T extends IBlockItemListener> IBlockItemInstance<T> blockItem(T listener, Supplier<IBlock> blockSupplier, IItemSettings settings) {
        return new MCBlockItemInstance<>(listener, blockSupplier, settings);
    }

    @Override
    public IItemStack stack(IItem item, int count) {
        return (IItemStack) (Object) new ItemStack((Item) item, count);
    }
}
