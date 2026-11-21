package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.registry.IDeferredRegistry;

public interface IRegistryApi {
    IRegistryRef<IBlock> blocks();
    IRegistryRef<IItem> items();

    <T> IDeferredRegistry<T> deferredRegistry(IRegistryRef<T> key);
}
