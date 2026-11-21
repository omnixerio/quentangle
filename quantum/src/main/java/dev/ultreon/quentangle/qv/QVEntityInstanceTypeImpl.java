package dev.ultreon.quentangle.qv;

import dev.ultreon.quentangle.api.entity.IEntityInstanceType;
import dev.ultreon.quentangle.api.entity.IEntity;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import dev.ultreon.quentangle.api.world.IWorld;
import net.quantumvoxel.entity.EntityType;
import net.quantumvoxel.world.World;

public class QVEntityInstanceTypeImpl<T extends IEntityListener> implements IEntityInstanceType<T> {
    private final EntityType<QuentEntity<T>> entity;
    private final T listener;

    public QVEntityInstanceTypeImpl(EntityType<QuentEntity<T>> entity, T listener) {
        this.entity = entity;
        this.listener = listener;
    }

    @Override
    public T listener() {
        return listener;
    }

    @Override
    public IEntity create(IWorld world) {
        return new QuentEntity<>(entity, (World) world, listener);
    }
}
