package dev.ultreon.quentangle.api.item;

import dev.ultreon.quentangle.registry.IKey;

import java.util.function.Supplier;

public interface IItemGroupBuilder {
    IItemGroupBuilder icon(Supplier<IItemStack> icon);

    IItemGroupBuilder background(IKey background);

    IItemGroupBuilder noScrollBar();

    IItemGroupBuilder displayItems(IGeneratorFunc generator);

    IItemGroup build();

    interface IGeneratorFunc {
        void genItems(IItemGroupContent content);
    }
}
