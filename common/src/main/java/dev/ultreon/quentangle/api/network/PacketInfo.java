package dev.ultreon.quentangle.api.network;

import dev.ultreon.quentangle.api.player.IServerPlayer;
import org.jetbrains.annotations.Nullable;

public record PacketInfo(
        @Nullable IServerPlayer sender
) {
    public PacketInfo() {
        this(null);
    }
}
