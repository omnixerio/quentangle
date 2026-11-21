package dev.ultreon.quentangle.forge.platform;

import dev.ultreon.quentangle.api.network.NetworkRegistry;
import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.api.network.endpoint.ClientEndpoint;
import dev.ultreon.quentangle.api.network.endpoint.ServerEndpoint;
import dev.ultreon.quentangle.api.network.packet.Packet;
import dev.ultreon.quentangle.api.player.IServerPlayer;

import java.util.function.Consumer;

public class ForgeNetworker implements Networker {
    public ForgeNetworker(String modId, Consumer<NetworkRegistry> registrant) {
    }

    @Override
    public <T extends Packet<T> & ServerEndpoint> void sendToServer(T payload) {

    }

    @Override
    public <T extends Packet<T> & ClientEndpoint> void sendToClient(T payload, IServerPlayer player) {

    }
}
