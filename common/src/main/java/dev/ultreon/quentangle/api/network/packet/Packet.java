package dev.ultreon.quentangle.api.network.packet;

import dev.ultreon.quentangle.api.network.NetworkRegistry;

/// Represents a packet that can be sent between the client and the server
///
/// @see PacketToClient
/// @see PacketToEither
/// @see PacketToServer
/// @see NetworkRegistry
/// @param <T> The type of the packet
public interface Packet<T extends Packet<T>> {
    void write(IPacketIO buffer);
}
