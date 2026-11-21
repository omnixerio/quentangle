package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.item.IItemsApi;
import net.quantumvoxel.item.Items;

class ItemsApi implements IItemsApi {
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
}
