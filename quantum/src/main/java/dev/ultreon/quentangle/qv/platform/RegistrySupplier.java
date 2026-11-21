package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.platform.Services;
import dev.ultreon.quentangle.registry.IRegistry;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.quantumvoxel.registry.Registry;
import net.quantumvoxel.util.Key;

import java.util.function.Function;
import java.util.function.Supplier;

public class RegistrySupplier<R, T, C extends T> implements IRegistrySupplier<R> {
    private final Key key;
    private final Registry<T> registry;
    private final IRegistry<R> registryR;
    private final Class<R> type;

    @SafeVarargs
    public RegistrySupplier(Key key, Registry<T> registry, Supplier<R> supplier, Function<R, T> mapper, R... typeGetter) {
        this.key = key;
        this.registry = registry;

        //noinspection unchecked
        this.type = (Class<R>) typeGetter.getClass().getComponentType();

        registry.register(key, mapper.apply(supplier.get()));
    }

    @Override
    public R get() {
        return type.cast(registry.get(key));
    }

    @Override
    public IRegistry<R> getRegistry() {
        return registryR;
    }
}
