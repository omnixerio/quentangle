package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IITemGroupFactory;
import dev.ultreon.quentangle.api.IItemGroupApi;
import dev.ultreon.quentangle.api.item.*;
import dev.ultreon.quentangle.registry.IKey;
import net.quantumvoxel.item.Item;
import net.quantumvoxel.item.ItemStack;
import net.quantumvoxel.item.category.ItemCategory;

import java.util.function.Supplier;

public class QVItemGroupApi implements IItemGroupApi {
    @Override
    public IItemGroupBuilder builder(IKey key) {
        return new QVItemGroupBuilder(key);
    }
}
