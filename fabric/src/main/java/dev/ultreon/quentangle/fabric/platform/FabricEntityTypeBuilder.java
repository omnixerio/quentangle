package dev.ultreon.quentangle.fabric.platform;

import dev.ultreon.quentangle.api.entity.IEntityInstanceType;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import dev.ultreon.quentangle.api.entity.IEntityTypeBuilder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class FabricEntityTypeBuilder<T extends IEntityListener> implements IEntityTypeBuilder<T> {
    private final EntityType.Builder<FabricQuentEntity<T>> builder;
    private final T listener;

    public FabricEntityTypeBuilder(T listener) {
        this.listener = listener;
        builder = EntityType.Builder.of((entityType, world) -> new FabricQuentEntity<T>(entityType, world, listener), MobCategory.MISC);
    }

    @Override
    public IEntityTypeBuilder<T> sized(float width, float height) {
        builder.sized(width, height);
        return this;
    }

    @Override
    public IEntityInstanceType<T> build() {
        EntityType<FabricQuentEntity<T>> build = builder.build();
        return new FabricEntityInstanceType<>(build, listener);
    }
}
