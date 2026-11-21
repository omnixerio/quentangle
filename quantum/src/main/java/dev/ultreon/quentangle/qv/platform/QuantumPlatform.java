package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.*;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityApi;
import dev.ultreon.quentangle.api.entity.IEntityApi;
import dev.ultreon.quentangle.util.IVec;
import net.quantumvoxel.text.Text;
import net.quantumvoxel.util.BlockVec;
import net.quantumvoxel.util.Key;
import net.quantumvoxel.world.World;
import dev.ultreon.quentangle.Game;
import dev.ultreon.quentangle.ModLoader;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.item.IItemsApi;
import dev.ultreon.quentangle.platform.IMod;
import dev.ultreon.quentangle.platform.services.IPlatform;
import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.text.IMutableTextObject;
import dev.ultreon.quentangle.text.ITextObject;
import dev.ultreon.quentangle.util.Env;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class QuantumPlatform implements IPlatform {

    private final ITextApi textApi = new QVTextApi();
    private final IBlocksApi blocksApi = new QVBlocksApi();
    private final IItemsApi itemsApi = new QVItemsApi();
    private final IItemGroupApi itemGroupApi = new QVItemGroupApi();
    private final IBlockEntityApi blockEntityApi = new QVBlockEntityApi();
    private final IScreenApi screenApi = new QVScreenApi();

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public String getDefaultNamespace() {
        return "quantum";
    }

    @Override
    public int getDefaultMaxStackSize() {
        return 64;
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
        return (IKey) (Object) new Key(domain, path);
    }

    @Override
    public IMutableTextObject createLiteralText(String text) {
        return (IMutableTextObject) Text.literal(text);
    }

    @Override
    public IMutableTextObject createTranslatableText(String key, Object... args) {
        return (IMutableTextObject) Text.translation(key, args);
    }

    @Override
    public IMutableTextObject createTranslatableText(String key, Iterable<Object> args) {
        if (args instanceof Collection<Object> collection) {
            return (IMutableTextObject) Text.translation(key, collection.toArray());
        }
        return (IMutableTextObject) Text.translation(key, List.of(args).toArray());
    }

    @Override
    public ITextObject createEmptyText() {
        return (ITextObject) Text.empty();
    }

    @Override
    public Optional<IMod> getMod(String modId) {
        return Optional.empty();
    }

    @Override
    public ModLoader getModLoader() {
        return ModLoader.Fabric;
    }

    @Override
    public Game getGame() {
        return Game.QuantumVoxel;
    }

    @Override
    public Path getConfigDir() {
        return FabricLoader.getInstance().getConfigDir();
    }

    @Override
    public Env getEnv() {
        return switch (FabricLoader.getInstance().getEnvironmentType()) {
            case CLIENT -> Env.CLIENT;
            case SERVER -> Env.SERVER;
        };
    }

    @Override
    public int getChunkHeight() {
        return World.CHUNK_HEIGHT;
    }

    @Override
    public int getChunkWidth() {
        return World.CHUNK_SIZE;
    }

    @Override
    public ITextApi getTextApi() {
        return textApi;
    }

    @Override
    public IBlocksApi getBlocksApi() {
        return blocksApi;
    }

    @Override
    public IItemsApi getItemsApi() {
        return itemsApi;
    }

    @Override
    public IItemGroupApi getItemGroupApi() {
        return itemGroupApi;
    }

    @Override
    public IBlockEntityApi getBlockEntityApi() {
        return blockEntityApi;
    }

    @Override
    public IScreenApi getScreenApi() {
        return screenApi;
    }

    @Override
    public IRegistryApi registryApi(String modId) {
        return new QVRegistryApi(modId);
    }

    @Override
    public IEntityApi getEntityApi() {
        return new QVEntityApi();
    }

    @Override
    public IBlockVec createBlockVec(IVec pos) {
        return (IBlockVec) new BlockVec(pos.quent$blockX(), pos.quent$blockY(), pos.quent$blockZ());
    }
}
