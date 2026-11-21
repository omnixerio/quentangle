package dev.ultreon.quentangle.qv;

import dev.ultreon.quentangle.api.entity.IEntityInstanceType;
import dev.ultreon.quentangle.api.entity.IEntityTypeBuilder;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import net.quantumvoxel.entity.EntitySize;
import net.quantumvoxel.entity.EntityType;

public class QVEntityTypeBuilder<T extends IEntityListener> implements IEntityTypeBuilder<T> {
    private final T listener;

    private int width;
    private int height;

    public QVEntityTypeBuilder(T listener) {
        this.listener = listener;
    }

    @Override
    public IEntityTypeBuilder<T> sized(float width, float height) {
        this.width = (int) width;
        this.height = (int) height;
        return this;
    }

    @Override
    public IEntityInstanceType<T> build() {
        return new QVEntityInstanceTypeImpl<>(new EntityType<>((entityType, world) -> new QuentEntity<>(entityType, world, listener), new EntitySize(width, height)), listener);
    }
}
