package dev.ultreon.quentangle.registry;

public interface IRegistryRef<T> extends IRegistry<T>, IDeferredRegistry<T> {
    void load();
}
