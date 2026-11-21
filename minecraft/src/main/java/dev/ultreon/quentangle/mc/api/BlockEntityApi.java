package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityApi;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityInstanceType;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityListener;
import dev.ultreon.quentangle.api.world.IWorld;
import dev.ultreon.quentangle.registry.IKey;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BlockEntityApi implements IBlockEntityApi {
    @Override
    @SuppressWarnings("unchecked")
    public <T extends IBlockEntityListener> IBlockEntityInstanceType<T> createBlockEntity(IKey key, T listener) {
        throw new UnsupportedOperationException("Block entity creation is not yet implemented for Minecraft");
    }

    @Override
    @SuppressWarnings("unchecked")
    public IBlockEntityInstanceType<?> getBlockEntityType(IKey key) {
        net.minecraft.world.level.block.entity.BlockEntityType<?> type =
                (net.minecraft.world.level.block.entity.BlockEntityType<?>)
                        BuiltInRegistries.BLOCK_ENTITY_TYPE.get((ResourceLocation) (Object) key);
        return (IBlockEntityInstanceType<?>) (Object) type;
    }
}
