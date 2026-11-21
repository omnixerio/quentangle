package dev.ultreon.quentangle.dev;

import dev.ultreon.quentangle.api.IRegistryApi;
import dev.ultreon.quentangle.api.item.IBlockItemInstance;
import dev.ultreon.quentangle.api.item.IBlockItemListener;
import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.dev.items.TestBlockItem;
import dev.ultreon.quentangle.item.IItemsApi;
import dev.ultreon.quentangle.platform.Platform;
import dev.ultreon.quentangle.registry.IRegistryRef;
import dev.ultreon.quentangle.registry.IRegistrySupplier;

import java.util.function.Supplier;

public class DevItems {
    private static final IRegistryApi REGISTRY_API = Platform.PLATFORM.registryApi("quentangle_dev");
    private static final IRegistryRef<IItem> ITEMS = REGISTRY_API.items();

    public static final IRegistrySupplier<IItem, IBlockItemInstance<TestBlockItem>> TEST = register("test", () -> {
        IItemsApi itemsApi = Platform.PLATFORM.getItemsApi();
        return itemsApi.blockItem(new TestBlockItem(), DevBlocks.TEST::get, itemsApi.itemSettings().quent$maxStackSize(32));
    });

    private static <T extends IBlockItemListener> IRegistrySupplier<IItem, IBlockItemInstance<T>> register(String name, Supplier<IBlockItemInstance<T>> supplier) {
        return ITEMS.register(name, supplier);
    }

    public static void init() {

    }

}
