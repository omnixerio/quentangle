package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.client.gui.IScreen;
import org.jetbrains.annotations.Nullable;

public interface IScreenApi {
    @Nullable IScreen titleScreen();
    @Nullable IScreen pauseScreen();
    @Nullable IScreen settingsScreen();
    @Nullable IScreen modListScreen();
}
