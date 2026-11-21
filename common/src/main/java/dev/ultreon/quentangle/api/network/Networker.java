package dev.ultreon.quentangle.api.network;

import dev.ultreon.quentangle.api.network.endpoint.ClientEndpoint;
import dev.ultreon.quentangle.api.network.endpoint.ServerEndpoint;
import dev.ultreon.quentangle.api.network.packet.Packet;
import dev.ultreon.quentangle.api.player.IServerPlayer;

import java.util.stream.Stream;

public interface Networker {
    <T extends Packet<T> & ServerEndpoint> void sendToServer(T payload);

    <T extends Packet<T> & ClientEndpoint> void sendToClient(T payload, IServerPlayer player);

    default <T extends Packet<T> & ClientEndpoint> void sendToClients(T payload, IServerPlayer... players) {
        for (IServerPlayer player : players) {
            sendToClient(payload, player);
        }
    }

    default <T extends Packet<T> & ClientEndpoint> void sendToClients(T payload, Iterable<IServerPlayer> players) {
        for (IServerPlayer player : players) {
            sendToClient(payload, player);
        }
    }

    default <T extends Packet<T> & ClientEndpoint> void sendToClients(T payload, Stream<IServerPlayer> players) {
        players.forEach(player -> sendToClient(payload, player));
    }
}
