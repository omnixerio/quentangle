package dev.ultreon.quentangle.api.entity;

public interface IEntityInstance<T extends IEntityListener> extends IEntity {
    T listener();
}
