package dev.ultreon.quentangle.mc.platform;

import dev.ultreon.quentangle.mc.components.ComponentManager;
import dev.ultreon.quentangle.api.network.NetworkRegistry;
import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.mc.platform.services.IClientPlatform;
import dev.ultreon.quentangle.platform.IMod;
import dev.ultreon.quentangle.util.Env;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Alias for McPlatform for backwards compatibility.
 */
public class XinexPlatform {
    private XinexPlatform() {
    }

    public static boolean isModLoaded(String modId) {
        return McPlatform.isModLoaded(modId);
    }

    public static Optional<IMod> getMod(String modId) {
        return McPlatform.getMod(modId);
    }

    public static boolean isDevelopmentEnvironment() {
        return McPlatform.isDevelopmentEnvironment();
    }

    public static String getEnvironmentName() {
        return McPlatform.getEnvironmentName();
    }

    public static ComponentManager getComponentManager(String modId) {
        return McPlatform.getComponentManager(modId);
    }

    public static Env getEnv() {
        return McPlatform.getEnv();
    }

    public static Networker createNetworker(String modId, Consumer<NetworkRegistry> registrant) {
        return McPlatform.createNetworker(modId, registrant);
    }

    public static void registerCommand(ICommandRegistrant registrant) {
        McPlatform.registerCommand(registrant);
    }

    public static IClientPlatform client() {
        return McPlatform.client();
    }

    public static Path getConfigDir() {
        return McPlatform.getConfigDir();
    }
}
