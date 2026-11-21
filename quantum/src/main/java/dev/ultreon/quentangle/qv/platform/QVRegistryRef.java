package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.registry.IRegistryRef;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.quantumvoxel.registry.Registry;
import net.quantumvoxel.util.Key;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class QVRegistryRef<T> implements IRegistryRef<T> {
    private final Registry<T> registry;
    private final String modId;

    public QVRegistryRef(String modId, Registry<T> registry) {
        this.modId = modId;
        this.registry = registry;
    }

    @Override
    public @Nullable T quent$get(IKey name) {
        return registry.get(new Key(name.quent$domain(), name.quent$path()));
    }

    @Override
    public @Nullable Iterable<T> quent$getByTag(IKey tag) {
        return null;
    }

    @Override
    public Iterable<T> quent$getAll() {
        return registry;
    }

    @Override
    public <C extends T> IRegistrySupplier<T, C> register(String name, Supplier<C> supplier) {
        return new QVRegistrySupplier<>(new Key(modId, name), registry, supplier, this);
    }

    @Override
    public T get(String name) {
        return registry.get(new Key(modId, name));
    }

    @Override
    public void load() {
        // Nothing to do
    }
}
