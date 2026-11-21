package dev.ultreon.quentangle.forge.platform;

import dev.ultreon.quentangle.registry.IRegistry;
import dev.ultreon.quentangle.registry.IRegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ForgeRegistrySupplier<T, C extends T> implements IRegistrySupplier<T, C> {
    private final Registry<T> registry;
    private final Supplier<C> supplier;
    private final ForgeRegistryRef<T> registryRef;
    private final RegistryObject<C> value;

    public ForgeRegistrySupplier(String name, Registry<T> registry, Supplier<C> supplier, ForgeRegistryRef<T> registryRef) {
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
