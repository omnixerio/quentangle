package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.api.item.IItemGroupContent;
import dev.ultreon.quentangle.api.item.IItemStack;
import dev.ultreon.quentangle.registry.IKey;

import java.util.function.Supplier;

public interface IItemGroupApi {
    IItemGroup create(IKey key, Supplier<IItemStack> icon, IITemGroupFactory factory);
}
