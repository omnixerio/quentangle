package dev.ultreon.quentangle.api.entity;

public interface IEntityApi {
    <T extends IEntityListener> IEntityTypeBuilder<T> entityBuilder(T listener);
}
