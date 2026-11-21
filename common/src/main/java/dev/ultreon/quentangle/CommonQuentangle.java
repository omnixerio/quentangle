package dev.ultreon.quentangle;

import dev.ultreon.quentangle.platform.Services;
import dev.ultreon.quentangle.registry.IKey;

public class CommonQuentangle {
    public static void init() {
        CommonConstants.LOG.info("Hello from Common init on {} from {}! we are currently in a {} environment!", Services.PLATFORM.getModLoader(), Services.PLATFORM.getGame(), Services.PLATFORM.getEnvironmentName());
    }

    public static IKey id(String path) {
        return IKey.quent$of(CommonConstants.MOD_ID, path);
    }
}
