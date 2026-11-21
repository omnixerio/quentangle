package dev.ultreon.quentangle.forge.platform;

import dev.ultreon.quentangle.mc.client.LayerDefinitionProvider;
import dev.ultreon.quentangle.mc.platform.services.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ForgeEntityRendererRegistry implements EntityRendererRegistry {
    @Override
    public <T extends BlockEntity> void register(Holder<BlockEntityType<T>> entity, BlockEntityRendererProvider<T> provider) {

    }

    @Override
    public <T extends Entity> void register(Supplier<EntityType<T>> entity, EntityRendererProvider<T> provider) {

    }

    @Override
    public <T extends Entity> void registerModel(ModelLayerLocation location, LayerDefinitionProvider provider) {

    }
}
