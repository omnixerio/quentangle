package dev.ultreon.quentangle.dev;

import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.platform.Services;
import dev.ultreon.quentangle.platform.services.IPlatform;

public class DevQuentangle {
    public static void init() {
        IPlatform platform = Services.PLATFORM;
        platform.registryApi();
        IBlocksApi blocksApi = platform.getBlocksApi();
        blocksApi.registerBlock();
    }
}
