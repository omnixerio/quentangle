package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.entity.IEntityType;
import dev.ultreon.quentangle.api.IRegistryApi;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityType;
import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.registry.IDeferredRegistry;
import dev.ultreon.quentangle.registry.IRegistryRef;
import net.quantumvoxel.block.Block;
import net.quantumvoxel.block.entity.BlockEntityType;
import net.quantumvoxel.entity.EntityType;
import net.quantumvoxel.item.Item;
import net.quantumvoxel.item.category.ItemCategory;
import net.quantumvoxel.registry.Registries;
import net.quantumvoxel.registry.Registry;

public class QVRegistryApi implements IRegistryApi {
    private final String modId;

    public QVRegistryApi(String modId) {
        this.modId = modId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IRegistryRef<IBlock> blocks() {
        Registry<Block> blockRegistry = Registries.BLOCK;
        return new QVRegistryRef<>(modId, (Registry<IBlock>) (Object) blockRegistry);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IRegistryRef<IItem> items() {
        Registry<Item> itemRegistry = Registries.ITEM;
        return new QVRegistryRef<>(modId, (Registry<IItem>) (Object) itemRegistry);
    }

    @Override
    public IRegistryRef<IItemGroup> itemGroups() {
        Registry<ItemCategory> itemGroupRegistry = Registries.ITEM_CATEGORY;
        return new QVRegistryRef<>(modId, (Registry<IItemGroup>) (Object) itemGroupRegistry);
    }

    @Override
    public IRegistryRef<IEntityType> entities() {
        Registry<EntityType<?>> entityRegistry = Registries.ENTITY;
        return new QVRegistryRef<>(modId, (Registry<IEntityType>) (Object) entityRegistry);
    }

    @Override
    public IRegistryRef<IBlockEntityType> blockEntities() {
        Registry<BlockEntityType<?>> blockEntityRegistry = Registries.BLOCK_ENTITY;
        return new QVRegistryRef<>(modId, (Registry<IBlockEntityType>) (Object) blockEntityRegistry);
    }

    @Override
    public <T> IDeferredRegistry<T> deferredRegistry(IRegistryRef<T> key) {
        return key;
    }
}
