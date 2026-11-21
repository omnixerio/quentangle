package dev.ultreon.quentangle.fabric.platform;

import dev.ultreon.quentangle.api.entity.IEntityType;
import dev.ultreon.quentangle.api.IRegistryApi;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityType;
import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.registry.IDeferredRegistry;
import dev.ultreon.quentangle.registry.IRegistryRef;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FabricRegistryApi implements IRegistryApi {
    private final String modId;

    public FabricRegistryApi(String modId) {
        this.modId = modId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IRegistryRef<IBlock> blocks() {
        Registry<Block> blockRegistry = BuiltInRegistries.BLOCK;
        return new FabricRegistryRef<>(modId, (Registry<IBlock>) (Object) blockRegistry);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IRegistryRef<IItem> items() {
        Registry<Item> itemRegistry = BuiltInRegistries.ITEM;
        return new FabricRegistryRef<>(modId, (Registry<IItem>) (Object) itemRegistry);
    }

    @Override
    public IRegistryRef<IItemGroup> itemGroups() {
        Registry<CreativeModeTab> itemGroupRegistry = BuiltInRegistries.CREATIVE_MODE_TAB;
        return new FabricRegistryRef<>(modId, (Registry<IItemGroup>) (Object) itemGroupRegistry);
    }

    @Override
    public IRegistryRef<IEntityType> entities() {
        Registry<EntityType<?>> entityRegistry = BuiltInRegistries.ENTITY_TYPE;
        return new FabricRegistryRef<>(modId, (Registry<IEntityType>) (Object) entityRegistry);
    }

    @Override
    public IRegistryRef<IBlockEntityType> blockEntities() {
        Registry<BlockEntityType<?>> blockEntityRegistry = BuiltInRegistries.BLOCK_ENTITY_TYPE;
        return new FabricRegistryRef<>(modId, (Registry<IBlockEntityType>) (Object) blockEntityRegistry);
    }

    @Override
    public <T> IDeferredRegistry<T> deferredRegistry(IRegistryRef<T> key) {
        return key;
    }
}
