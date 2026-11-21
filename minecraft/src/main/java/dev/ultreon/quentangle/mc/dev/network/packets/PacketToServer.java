package dev.ultreon.quentangle.mc.dev.network.packets;

import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.api.network.packet.IPacketIO;
import dev.ultreon.quentangle.api.player.IServerPlayer;
import dev.ultreon.quentangle.text.ITextObject;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.UUID;

public record PacketToServer(
    UUID uuid
) implements dev.ultreon.quentangle.api.network.packet.PacketToServer<PacketToServer> {
    public static PacketToServer read(RegistryFriendlyByteBuf buf) {
        return new PacketToServer(buf.readUUID());
    }

    @Override
    public void write(IPacketIO buf) {
        buf.quent$writeUUID(uuid);
    }

    @Override
    public void handle(Networker connection, IServerPlayer player) {
        player.quent$sendSystemMessage(ITextObject.nullToEmpty("Hello, the UUID is: " + uuid));
    }
}
