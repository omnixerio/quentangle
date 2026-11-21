package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IRegistryApi;
import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.registry.IDeferredRegistry;
import net.quantumvoxel.block.Block;
import net.quantumvoxel.registry.RegistryKeys;

public class IRegistryApiImpl implements IRegistryApi {
    private RegistryRef<IBlock, Block> blocks;

    @Override
    public IDeferredRegistry<IBlock> blocks() {
        blocks = new DeferredRegistry<>(RegistryKeys.BLOCK);
        return blocks;
    }

    @Override
    public IRegistryRef<IItem> items() {
        return null;
    }

    @Override
    public <T> IDeferredRegistry<T> deferredRegistry(IRegistryRef<T> key) {
        return new DeferredRegistry<>(key);
    }
}
