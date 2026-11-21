package dev.ultreon.quentangle.api.network.endpoint;

import dev.ultreon.quentangle.api.network.Networker;
import dev.ultreon.quentangle.api.player.IServerPlayer;

public interface ServerEndpoint {
    void handle(Networker connection, IServerPlayer player);
}
