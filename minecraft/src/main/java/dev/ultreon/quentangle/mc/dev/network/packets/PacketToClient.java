package dev.ultreon.quentangle.mc.dev.network.packets;

import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.api.network.packet.IPacketIO;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;

public record PacketToClient(
    String message
) implements dev.ultreon.quentangle.api.network.packet.PacketToClient<PacketToClient> {

    public static PacketToClient read(RegistryFriendlyByteBuf buf) {
        Thread.dumpStack();
        return new PacketToClient(buf.readUtf());
    }

    @Override
    public void write(IPacketIO buf) {
        buf.quent$writeString(message);
    }

    @Override
    public void handle(Networker networker) {
        Minecraft.getInstance().player.displayClientMessage(Component.literal(message), true);
        System.out.println(message);
    }
}
