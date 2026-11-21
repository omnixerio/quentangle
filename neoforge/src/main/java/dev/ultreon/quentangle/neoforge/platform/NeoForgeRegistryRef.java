package dev.ultreon.quentangle.neoforge.platform;

import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.registry.IRegistryRef;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class NeoForgeRegistryRef<T> implements IRegistryRef<T> {
    private final Registry<T> registry;
    private final String modId;
    private DeferredRegister<T> register;

    public NeoForgeRegistryRef(String modId, Registry<T> registry) {
        this.modId = modId;
        this.registry = registry;
    }

    @Override
    public @Nullable T quent$get(IKey name) {
        return registry.get(ResourceLocation.fromNamespaceAndPath(name.quent$domain(), name.quent$path()));
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
        return new NeoForgeRegistrySupplier<>(name, registry, supplier, this);
    }

    @Override
    public T get(String name) {
        return registry.get(ResourceLocation.fromNamespaceAndPath(modId, name));
    }

    public DeferredRegister<T> deferredRegister() {
        return register != null ? register : (register = DeferredRegister.create(registry.key(), modId));
    }
}
