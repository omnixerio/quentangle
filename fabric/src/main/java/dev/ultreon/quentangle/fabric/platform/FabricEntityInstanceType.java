package dev.ultreon.quentangle.fabric.platform;

import dev.ultreon.quentangle.api.entity.IEntity;
import dev.ultreon.quentangle.api.entity.IEntityInstanceType;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import dev.ultreon.quentangle.api.world.IWorld;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class FabricEntityInstanceType<T extends IEntityListener> implements IEntityInstanceType<T> {
    private final EntityType<FabricQuentEntity<T>> entity;
    private final T listener;

    public FabricEntityInstanceType(EntityType<FabricQuentEntity<T>> entity, T listener) {
        this.entity = entity;
        this.listener = listener;
    }

    @Override
    public T listener() {
        return listener;
    }

    @Override
    public IEntity create(IWorld world) {
        return new FabricQuentEntity<>(entity, (Level) world, listener);
    }
}
