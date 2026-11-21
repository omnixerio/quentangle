package dev.ultreon.quentangle.api.entity;

public interface IEntityTypeBuilder<T extends IEntityListener> {
    IEntityTypeBuilder<T> sized(float width, float height);

    IEntityInstanceType<T> build();
}
