package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.registry.IRegistry;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.quantumvoxel.registry.Registry;
import net.quantumvoxel.util.Key;

import java.util.function.Supplier;

public class QVRegistrySupplier<T, C extends T> implements IRegistrySupplier<T, C> {
    private final Key key;
    private final Registry<T> registry;
    private final Supplier<C> supplier;
    private final QVRegistryRef<T> registryRef;

    public QVRegistrySupplier(Key key, Registry<T> registry, Supplier<C> supplier) {
        this.key = key;
        this.registry = registry;
        this.supplier = supplier;
        this.registryRef = null;
        registry.register(key, supplier.get());
    }

    public QVRegistrySupplier(Key key, Registry<T> registry, Supplier<C> supplier, QVRegistryRef<T> registryRef) {
        this.key = key;
        this.registry = registry;
        this.supplier = supplier;
        this.registryRef = registryRef;
        registry.register(key, supplier.get());
    }

    @Override
    public C get() {
        //noinspection unchecked
        return (C) registry.get(key);
    }

    @Override
    public IRegistry<T> getRegistry() {
        return registryRef;
    }
}
