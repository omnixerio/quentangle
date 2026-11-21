package dev.ultreon.quentangle.fabric.network;

import dev.ultreon.quentangle.api.network.NetworkRegistry;
import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.api.player.IServerPlayer;
import dev.ultreon.quentangle.mc.network.PayloadWrapper;
import dev.ultreon.quentangle.api.network.endpoint.ClientEndpoint;
import dev.ultreon.quentangle.api.network.endpoint.ServerEndpoint;
import dev.ultreon.quentangle.api.network.packet.Packet;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Consumer;

public class FabricNetworker implements Networker {
    private final Consumer<NetworkRegistry> registrant;
    private final FabricNetworkRegistry registry;

    public FabricNetworker(String modId, Consumer<NetworkRegistry> registrant) {
        this.registrant = registrant;
        this.registry = new FabricNetworkRegistry(this, modId);
        registrant.accept(registry);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Packet<T> & ServerEndpoint> void sendToServer(T payload) {
        ClientPlayNetworking.send(new PayloadWrapper<>(registry.getType((Class<T>) payload.getClass()), payload));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Packet<T> & ClientEndpoint> void sendToClient(T payload, IServerPlayer player) {
        ServerPlayNetworking.send((ServerPlayer) player, new PayloadWrapper<>(registry.getType((Class<T>) payload.getClass()), payload));
    }
}
