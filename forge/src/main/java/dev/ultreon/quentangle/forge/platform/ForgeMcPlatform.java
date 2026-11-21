package dev.ultreon.quentangle.forge.platform;

import dev.ultreon.quentangle.QuentangleCommon;
import dev.ultreon.quentangle.ModLoader;
import dev.ultreon.quentangle.api.IItemGroupApi;
import dev.ultreon.quentangle.api.IRegistryApi;
import dev.ultreon.quentangle.api.IScreenApi;
import dev.ultreon.quentangle.api.entity.IEntityApi;
import dev.ultreon.quentangle.api.network.NetworkRegistry;
import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.mc.components.ComponentManager;
import dev.ultreon.quentangle.mc.platform.ICommandRegistrant;
import dev.ultreon.quentangle.mc.platform.IMcPlatform;
import dev.ultreon.quentangle.mc.platform.services.IClientPlatform;
import dev.ultreon.quentangle.platform.IMod;
import dev.ultreon.quentangle.util.Env;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ForgeMcPlatform implements IMcPlatform {

    private final Map<String, IEventBus> eventBuses = new ConcurrentHashMap<>();
    private IClientPlatform client;

    public ForgeMcPlatform() {
        if (FMLLoader.getDist().isClient()) {
            this.client = new ForgeClientPlatform();
        }
    }

    @Override
    public String getPlatformName() {
        return "Forge";
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
    public IItemGroupApi getItemGroupApi() {
        return null;
    }

    @Override
    public IScreenApi getScreenApi() {
        return null;
    }

    @Override
    public IRegistryApi registryApi(String modId) {
        return null;
    }

    @Override
    public IEntityApi getEntityApi() {
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
        return ModLoader.Forge;
    }

    public IEventBus eventBusFor(String modId) {
        return eventBuses.get(modId);
    }

    @Override
    public ComponentManager getComponentManager(String modId) {
        return null;
    }

    @Override
    public Networker createNetworker(String modId, Consumer<NetworkRegistry> registrant) {
        return new ForgeNetworker(modId, registrant);
    }

    @Override
    public void registerCommand(ICommandRegistrant registrant) {
        QuentangleCommon.LOGGER.warn("Commands not implemented on Forge");
    }

    @Override
    public IClientPlatform client() {
        return client;
    }
}
