package dev.ultreon.quentangle.dev;

import dev.ultreon.quentangle.api.IItemGroupApi;
import dev.ultreon.quentangle.api.IRegistryApi;
import dev.ultreon.quentangle.api.item.*;
import dev.ultreon.quentangle.platform.Platform;
import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.registry.IRegistryRef;
import dev.ultreon.quentangle.registry.IRegistrySupplier;

import java.util.function.Supplier;

public class DevItemGroups {
    private static final IRegistryApi REGISTRY_API = Platform.PLATFORM.registryApi("quentangle_dev");
    private static final IRegistryRef<IItemGroup> ITEMS = REGISTRY_API.itemGroups();

    public static final IRegistrySupplier<IItemGroup, IItemGroup> TEST = register("test", DevItems.TEST::get, content -> {
        content.quent$add(DevItems.TEST.get());
    });

    private static IRegistrySupplier<IItemGroup, IItemGroup> register(String name, Supplier<IItem> icon, IItemGroupBuilder.IGeneratorFunc supplier) {
        return ITEMS.register(name, () -> {
            IItemGroupApi itemGroupApi = Platform.PLATFORM.getItemGroupApi();
            return itemGroupApi.builder(IKey.quent$of("quentangle_dev", name)).icon(() -> icon.get().quent$defaultItemStack()).displayItems(supplier).build();
        });
    }

    public static void init() {

    }

}
