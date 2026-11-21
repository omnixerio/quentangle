package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.IScreenApi;
import dev.ultreon.quentangle.client.gui.IScreen;
import net.quantumvoxel.client.QuantumClient;
import net.quantumvoxel.client.gui.screen.ModListScreen;
import net.quantumvoxel.client.gui.screen.PauseScreen;
import net.quantumvoxel.client.gui.screen.SettingsScreen;
import net.quantumvoxel.client.gui.screen.TitleScreen;
import org.jetbrains.annotations.Nullable;

public class ScreenApi implements IScreenApi {
    @Override
    public @Nullable IScreen titleScreen() {
        return (IScreen) new TitleScreen();
    }

    @Override
    public @Nullable IScreen pauseScreen() {
        return (IScreen) new PauseScreen();
    }

    @Override
    public @Nullable IScreen settingsScreen() {
        return (IScreen) new SettingsScreen(QuantumClient.get().config);
    }

    @Override
    public @Nullable IScreen modListScreen() {
        return (IScreen) new ModListScreen();
    }
}
