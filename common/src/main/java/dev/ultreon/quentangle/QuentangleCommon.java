package dev.ultreon.quentangle;

import dev.ultreon.quentangle.dev.QuentangleDev;
import dev.ultreon.quentangle.platform.Platform;
import dev.ultreon.quentangle.registry.IKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuentangleCommon {
    public static final Logger LOGGER = LoggerFactory.getLogger("Quentangle");

    public static void init() {
        CommonConstants.LOG.info("Hello from Common init on {} from {}! we are currently in a {} environment!", Platform.PLATFORM.getModLoader(), Platform.PLATFORM.getGame(), Platform.PLATFORM.getEnvironmentName());

        if (Platform.PLATFORM.isDevelopmentEnvironment()) {
            QuentangleDev.init();
        }
    }

    public static IKey id(String path) {
        return IKey.quent$of(CommonConstants.MOD_ID, path);
    }
}
