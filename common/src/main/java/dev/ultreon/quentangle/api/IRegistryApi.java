package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityType;
import dev.ultreon.quentangle.api.entity.IEntityType;
import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.registry.IDeferredRegistry;
import dev.ultreon.quentangle.registry.IRegistryRef;

public interface IRegistryApi {
    IRegistryRef<IBlock> blocks();
    IRegistryRef<IItem> items();
    IRegistryRef<IItemGroup> itemGroups();
    IRegistryRef<IEntityType> entities();
    IRegistryRef<IBlockEntityType> blockEntities();

    <T> IDeferredRegistry<T> deferredRegistry(IRegistryRef<T> key);
}
