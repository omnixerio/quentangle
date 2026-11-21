package dev.ultreon.quentangle.server;

import dev.ultreon.quentangle.api.game.IGame;
import dev.ultreon.quentangle.api.player.IPlayer;
import dev.ultreon.quentangle.api.player.IServerPlayer;
import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.api.world.IServerWorld;

public interface IServerGame extends IGame {
    IServerWorld quent$serverWorld(IKey name);

    Iterable<IServerWorld> quent$serverWorlds();

    Iterable<IServerPlayer> quent$players();
}
