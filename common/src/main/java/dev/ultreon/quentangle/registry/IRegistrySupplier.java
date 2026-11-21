package dev.ultreon.quentangle.registry;

import java.util.function.Supplier;

public interface IRegistrySupplier<T, C extends T> extends Supplier<C> {
    C get();

    IRegistry<T> getRegistry();
}
