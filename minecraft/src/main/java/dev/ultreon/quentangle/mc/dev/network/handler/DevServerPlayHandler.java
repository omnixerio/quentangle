package dev.ultreon.quentangle.mc.dev.network.handler;

import dev.ultreon.quentangle.mc.dev.network.packets.PacketToServer;
import dev.ultreon.quentangle.api.network.PacketInfo;
import dev.ultreon.quentangle.text.ITextObject;
import net.minecraft.network.chat.Component;

import java.util.UUID;

public class DevServerPlayHandler {
    public void handle(PacketToServer packet, PacketInfo packetInfo) {
        UUID uuid = packet.uuid();
        packetInfo.sender().quent$sendSystemMessage(ITextObject.nullToEmpty("Hello, the UUID is: " + uuid));
    }
}
