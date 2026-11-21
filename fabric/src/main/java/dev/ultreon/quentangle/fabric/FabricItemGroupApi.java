package dev.ultreon.quentangle.fabric;

import dev.ultreon.quentangle.api.item.IItemGroupBuilder;
import dev.ultreon.quentangle.fabric.tabs.FabricItemGroupBuilder;
import dev.ultreon.quentangle.mc.api.MCItemGroupApi;
import dev.ultreon.quentangle.registry.IKey;

public class FabricItemGroupApi extends MCItemGroupApi {
    @Override
    public IItemGroupBuilder builder(IKey key) {
        return new FabricItemGroupBuilder(key);
    }
}
