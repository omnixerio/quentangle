package dev.ultreon.quentangle.registry;

public interface IRegistrySupplier<R> {
    R get();

    IRegistry<R> getRegistry();
}
