package dev.ultreon.quentangle.fabric.platform;

import dev.ultreon.quentangle.registry.IRegistry;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class FabricRegistrySupplier<T, C extends T> implements IRegistrySupplier<T, C> {
    private final ResourceLocation location;
    private final Registry<T> registry;
    private final Supplier<C> supplier;
    private final FabricRegistryRef<T> registryRef;

    public FabricRegistrySupplier(ResourceLocation key, Registry<T> registry, Supplier<C> supplier) {
        this.location = key;
        this.registry = registry;
        this.supplier = supplier;
        this.registryRef = null;
        Registry.register(registry, key, supplier.get());
    }

    public FabricRegistrySupplier(ResourceLocation key, Registry<T> registry, Supplier<C> supplier, FabricRegistryRef<T> registryRef) {
        this.location = key;
        this.registry = registry;
        this.supplier = supplier;
        this.registryRef = registryRef;
        Registry.register(registry, key, supplier.get());
    }

    @Override
    public C get() {
        //noinspection unchecked
        return (C) registry.get(location);
    }

    @Override
    public IRegistry<T> getRegistry() {
        return registryRef;
    }
}
