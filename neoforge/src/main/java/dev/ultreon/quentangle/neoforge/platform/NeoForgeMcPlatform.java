package dev.ultreon.quentangle.neoforge.platform;

import dev.ultreon.quentangle.ModLoader;
import dev.ultreon.quentangle.mc.components.ComponentManager;
import dev.ultreon.quentangle.api.network.NetworkRegistry;
import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.mc.platform.ICommandRegistrant;
import dev.ultreon.quentangle.mc.platform.IMcPlatform;
import dev.ultreon.quentangle.mc.platform.IMcPlatformHelper;
import dev.ultreon.quentangle.mc.platform.services.IClientPlatform;
import dev.ultreon.quentangle.mc.platform.services.IMcPlatform;
import dev.ultreon.quentangle.platform.IMod;
import dev.ultreon.quentangle.util.Env;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

public class NeoForgeMcPlatform implements IMcPlatform {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public Path getConfigDir() {
        return null;
    }

    @Override
    public Env getEnv() {
        return null;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public Optional<IMod> getMod(String modId) {
        return Optional.empty();
    }

    @Override
    public ModLoader getModLoader() {
        return null;
    }

    @Override
    public ComponentManager getComponentManager(String modId) {
        return null;
    }

    @Override
    public Networker createNetworker(String modId, Consumer<NetworkRegistry> registrant) {
        return null;
    }

    @Override
    public void registerCommand(ICommandRegistrant registrant) {

    }

    @Override
    public IClientPlatform client() {
        return null;
    }
}
