package dev.ultreon.quentangle.api.player;

import dev.ultreon.quentangle.text.ITextObject;

public interface IServerPlayer extends IPlayer {
    default void quent$sendSystemMessage(ITextObject component) {
        // Unimplemented
    }
}
