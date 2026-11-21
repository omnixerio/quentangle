package dev.ultreon.quentangle.registry;

import java.util.function.Supplier;

public interface IDeferredRegistry<T> {
    <C extends T> IRegistrySupplier<T, C> register(String name, Supplier<C> supplier);

    T get(String name);

}
