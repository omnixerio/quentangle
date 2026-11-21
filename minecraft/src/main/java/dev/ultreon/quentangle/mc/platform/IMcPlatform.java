package dev.ultreon.quentangle.mc.platform;

import com.mojang.brigadier.Command;
import dev.ultreon.quentangle.Game;
import dev.ultreon.quentangle.api.IBlockVec;import dev.ultreon.quentangle.api.ITextApi;
import dev.ultreon.quentangle.api.block.IBlocksApi;
import dev.ultreon.quentangle.api.block.entity.IBlockEntityApi;
import dev.ultreon.quentangle.item.IItemsApi;
import dev.ultreon.quentangle.mc.components.ComponentManager;
import dev.ultreon.quentangle.api.network.NetworkRegistry;
import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.mc.platform.services.IClientPlatform;
import dev.ultreon.quentangle.platform.services.IPlatform;
import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.text.IMutableTextObject;
import dev.ultreon.quentangle.text.ITextObject;
import dev.ultreon.quentangle.util.IVec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public interface IMcPlatform extends IPlatform {
    @Override
    default String getDefaultNamespace() {
        return "minecraft";
    }

    @Override
    default int getDefaultMaxStackSize() {
        return 64;
    }

    @Override
    default int getChunkHeight() {
        return 384;
    }

    @Override
    default int getChunkBase() {
        return -64;
    }

    @Override
    default boolean is3DChunks() {
        return false;
    }

    @Override
    default int getChunkWidth() {
        return 16;
    }

    @Override
    default IBlocksApi getBlocksApi() {
        return McPlatformHolder.BLOCKS_API;
    }

    @Override
    default IItemsApi getItemsApi() {
        return McPlatformHolder.ITEMS_API;
    }

    @Override
    default IBlockEntityApi getBlockEntityApi() {
        return McPlatformHolder.BLOCK_ENTITY_API;
    }

    @Override
    default ITextApi getTextApi() {
        return McPlatformHolder.TEXT_API;
    }

    @Override
    default IKey key(String domain, String path) {
        return (IKey) (Object) ResourceLocation.fromNamespaceAndPath(domain, path);
    }

    @Override
    default Game getGame() {
        return Game.Minecraft;
    }@Override
    default IBlockVec createBlockVec(IVec pos) {
        return (IBlockVec) BlockPos.containing((Position) pos);
    }

    @Override
    default IMutableTextObject createLiteralText(String text) {
        return (IMutableTextObject) Component.literal(text);
    }

    @Override
    default IMutableTextObject createTranslatableText(String key, Object... args) {
        return (IMutableTextObject) Component.translatable(key, args);
    }

    @Override
    default IMutableTextObject createTranslatableText(String key, Iterable<Object> args) {
        return (IMutableTextObject) Component.translatable(key, args);
    }

    @Override
    default ITextObject createEmptyText() {
        return (ITextObject) Component.empty();
    }

    /// Gets the component manager for the given mod id
    ///
    /// @param modId The mod id
    /// @return The component manager
    ComponentManager getComponentManager(String modId);

    /// Creates a new networker. This generally only needs to be created once per mod. Or not at all.
    ///
    /// @param modId The mod id
    /// @param registrant The network registry
    /// @return A new networker instance.
    Networker createNetworker(String modId, Consumer<NetworkRegistry> registrant);

    /// Registers a new command.
    ///
    /// @param registrant The command
    /// @see Command
    void registerCommand(ICommandRegistrant registrant);

    /// Gets the current client-side platform
    IClientPlatform client();
}
