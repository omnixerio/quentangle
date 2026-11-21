package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.item.*;
import dev.ultreon.quentangle.registry.IKey;
import net.quantumvoxel.item.Item;
import net.quantumvoxel.item.ItemStack;
import net.quantumvoxel.item.category.ItemCategory;
import net.quantumvoxel.registry.Registries;
import net.quantumvoxel.util.Key;

import java.util.function.Supplier;

public class QVItemGroupBuilder implements IItemGroupBuilder {
    private final IKey key;
    private Supplier<IItemStack> icon = () -> (IItemStack) new ItemStack();
    private IGeneratorFunc generator = _ -> {};

    public QVItemGroupBuilder(IKey key) {
        this.key = key;
    }

    @Override
    public IItemGroupBuilder icon(Supplier<IItemStack> icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public IItemGroupBuilder background(IKey background) {
        return this;
    }

    @Override
    public IItemGroupBuilder noScrollBar() {
        return this;
    }

    @Override
    public IItemGroupBuilder displayItems(IGeneratorFunc generator) {
        this.generator = generator;
        return this;
    }

    @Override
    public IItemGroup build() {
        ItemCategory itemCategory = new ItemCategory(() -> ((ItemStack) icon.get()).getItem());
        generator.genItems(new IItemGroupContent() {
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
        return (IItemGroup) itemCategory;
    }
}
