package dev.ultreon.quentangle.neoforge.platform;

import dev.ultreon.quentangle.registry.IRegistry;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class NeoForgeRegistrySupplier<T, C extends T> implements IRegistrySupplier<T, C> {
    private final Registry<T> registry;
    private final Supplier<C> supplier;
    private final NeoForgeRegistryRef<T> registryRef;
    private final DeferredHolder<T, C> value;

    public NeoForgeRegistrySupplier(String name, Registry<T> registry, Supplier<C> supplier, NeoForgeRegistryRef<T> registryRef) {
        this.registry = registry;
        this.supplier = supplier;
        this.registryRef = registryRef;
        value = registryRef.deferredRegister().register(name, supplier);
    }

    @Override
    public C get() {
        return value.get();
    }

    @Override
    public IRegistry<T> getRegistry() {
        return registryRef;
    }
}
