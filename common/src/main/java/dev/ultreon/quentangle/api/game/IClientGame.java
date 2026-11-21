package dev.ultreon.quentangle.api.game;

import dev.ultreon.quentangle.api.world.IClientWorld;
import dev.ultreon.quentangle.client.gui.IScreen;

public interface IClientGame extends IGame {
    IClientWorld quent$clientWorld();

    IScreen quent$screen();

    void quent$showScreen(IScreen screen);
}
