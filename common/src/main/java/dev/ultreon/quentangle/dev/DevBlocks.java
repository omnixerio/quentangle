package dev.ultreon.quentangle.dev;

import dev.ultreon.quentangle.api.IRegistryApi;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.block.IBlockListener;
import dev.ultreon.quentangle.dev.blocks.TestBlock;
import dev.ultreon.quentangle.platform.Platform;
import dev.ultreon.quentangle.registry.IRegistryRef;
import dev.ultreon.quentangle.registry.IRegistrySupplier;

import java.util.function.Supplier;

public class DevBlocks {
    private static final IRegistryApi REGISTRY_API = Platform.PLATFORM.registryApi("quentangle_dev");
    private static final IRegistryRef<IBlock> BLOCKS = REGISTRY_API.blocks();

    public static final IRegistrySupplier<IBlock, IBlockInstance<IBlockListener>> TEST = register("test", () -> {
        IBlocksApi blocksApi = Platform.PLATFORM.getBlocksApi();
        return blocksApi.create(new TestBlock(), blocksApi.blockSettings().quent$hardness(6));
    });

    private static <T extends IBlockListener> IRegistrySupplier<IBlock, IBlockInstance<T>> register(String name, Supplier<IBlockInstance<T>> supplier) {
        return BLOCKS.register(name, supplier);
    }

    public static void init() {

    }

}
