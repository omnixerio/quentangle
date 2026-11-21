package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.api.item.IItemGroupBuilder;
import dev.ultreon.quentangle.registry.IKey;

public interface IItemGroupApi {
    /// Creates a new creative mode tab builder
    ///
    /// @see net.minecraft.world.item.CreativeModeTab
    /// @return The creative mode tab builder
    IItemGroupBuilder builder(IKey key);
}
