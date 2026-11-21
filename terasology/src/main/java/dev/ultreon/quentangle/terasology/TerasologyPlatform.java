package dev.ultreon.quentangle.terasology;

import dev.ultreon.quentangle.Game;
import dev.ultreon.quentangle.ModLoader;
import dev.ultreon.quentangle.api.*;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityApi;
import dev.ultreon.quentangle.api.entity.IEntityApi;
import dev.ultreon.quentangle.item.IItemsApi;
import dev.ultreon.quentangle.platform.IMod;
import dev.ultreon.quentangle.platform.services.IPlatform;
import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.text.IMutableTextObject;
import dev.ultreon.quentangle.text.ITextObject;
import dev.ultreon.quentangle.util.Env;
import dev.ultreon.quentangle.util.IVec;

import java.nio.file.Path;
import java.util.Optional;

public class TerasologyPlatform implements IPlatform {
    @Override
    public boolean isModLoaded(String modId) {
        return false;
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return false;
    }

    @Override
    public String getDefaultNamespace() {
        return "";
    }

    @Override
    public int getDefaultMaxStackSize() {
        return 0;
    }

    @Override
    public IBlockEntityApi getBlockEntityApi() {
        return null;
    }

    @Override
    public ITextApi getTextApi() {
        return null;
    }

    @Override
    public IBlocksApi getBlocksApi() {
        return null;
    }

    @Override
    public IItemsApi getItemsApi() {
        return null;
    }

    @Override
    public int getChunkWidth() {
        return 0;
    }

    @Override
    public int getChunkHeight() {
        return 0;
    }

    @Override
    public int getChunkBase() {
        return 0;
    }

    @Override
    public boolean is3DChunks() {
        return false;
    }

    @Override
    public IKey key(String domain, String path) {
        return null;
    }

    @Override
    public IMutableTextObject createLiteralText(String text) {
        return null;
    }

    @Override
    public IMutableTextObject createTranslatableText(String key, Object... args) {
        return null;
    }

    @Override
    public IMutableTextObject createTranslatableText(String key, Iterable<Object> args) {
        return null;
    }

    @Override
    public ITextObject createEmptyText() {
        return null;
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
    public Game getGame() {
        return null;
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
    public IBlockVec createBlockVec(IVec pos) {
        return null;
    }
}
