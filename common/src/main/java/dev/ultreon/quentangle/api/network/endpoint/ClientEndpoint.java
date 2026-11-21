package dev.ultreon.quentangle.api.network.endpoint;

import dev.ultreon.quentangle.api.network.Networker;

public interface ClientEndpoint {
    void handle(Networker connection);
}
