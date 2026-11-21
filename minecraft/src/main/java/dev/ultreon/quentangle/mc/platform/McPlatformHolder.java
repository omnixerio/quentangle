package dev.ultreon.quentangle.mc.platform;

import dev.ultreon.quentangle.api.ITextApi;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityApi;
import dev.ultreon.quentangle.item.IItemsApi;
import dev.ultreon.quentangle.mc.api.*;

public final class McPlatformHolder {
    public static final ITextApi TEXT_API = new TextApi();
    public static final IBlocksApi BLOCKS_API = new BlocksApi();
    public static final IItemsApi ITEMS_API = new ItemsApi();
    public static final IBlockEntityApi BLOCK_ENTITY_API = new BlockEntityApi();

    private McPlatformHolder() {
    }
}
