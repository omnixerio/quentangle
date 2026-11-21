package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IITemGroupFactory;
import dev.ultreon.quentangle.api.IItemGroupApi;
import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.api.item.IItemGroupContent;
import dev.ultreon.quentangle.api.item.IItemStack;
import dev.ultreon.quentangle.registry.IKey;
import net.quantumvoxel.item.Item;
import net.quantumvoxel.item.ItemStack;
import net.quantumvoxel.item.category.ItemCategory;

import java.util.function.Supplier;

public class ItemGroupApi implements IItemGroupApi {
    @Override
    public IItemGroup create(IKey key, Supplier<IItemStack> icon, IITemGroupFactory factory) {
        ItemCategory itemCategory = new ItemCategory(() -> (Item) icon.get());
        IItemGroup iItemGroup = (IItemGroup) itemCategory;
        factory.build(new IItemGroupContent() {
            @Override
            public void quent$add(IItemStack... stacks) {
                for (IItemStack stack : stacks) {
                    itemCategory.addContent((ItemStack) stack);
                }
            }

            @Override
            public void quent$add(IItem... items) {
                for (IItem item : items) {
                    itemCategory.addContent((Item) item);
                }
            }
        });
        return iItemGroup;
    }
}
