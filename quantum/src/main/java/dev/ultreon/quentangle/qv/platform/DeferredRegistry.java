package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.registry.IDeferredRegistry;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.quantumvoxel.registry.Registries;
import net.quantumvoxel.registry.Registry;
import net.quantumvoxel.registry.RegistryKey;
import net.quantumvoxel.util.Key;

import java.util.function.Supplier;

public class DeferredRegistry<T, R> implements IDeferredRegistry<T> {
    private final String modId;
    private final Registry<T> registry;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public DeferredRegistry(String modId, RegistryKey<Registry<R>> key) {
        this.modId = modId;
        this.registry = Registries.REGISTRY.get((RegistryKey) key);
    }

    @Override
    public IRegistrySupplier<R, R> register(String name, Supplier<R> supplier) {
        return new RegistrySupplier<>(new Key(modId, name), registry, supplier);
    }

    @Override
    public IRegistrySupplier<T, T> get(String name) {
        return null;
    }

    @Override
    public void registerAll() {

    }
}
