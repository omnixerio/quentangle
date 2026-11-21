package dev.ultreon.quentangle.api.entity;

public interface IEntityInstanceType<T extends IEntityListener> extends IEntityType {
    T listener();
}
