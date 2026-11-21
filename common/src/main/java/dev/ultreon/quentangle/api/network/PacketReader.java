package dev.ultreon.quentangle.api.network;

import dev.ultreon.quentangle.api.network.packet.IPacketIO;
import dev.ultreon.quentangle.api.network.packet.Packet;

@FunctionalInterface
public interface PacketReader<T extends Packet<?>> {
    T read(IPacketIO buffer);
}
