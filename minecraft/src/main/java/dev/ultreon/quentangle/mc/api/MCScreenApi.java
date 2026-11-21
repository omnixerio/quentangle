package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.IScreenApi;
import dev.ultreon.quentangle.client.gui.IScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import org.jetbrains.annotations.Nullable;

public abstract class MCScreenApi implements IScreenApi {
    @Override
    public @Nullable IScreen titleScreen() {
        return (IScreen) new TitleScreen();
    }

    @Override
    public @Nullable IScreen pauseScreen() {
        return (IScreen) new PauseScreen(true);
    }

    @Override
    public @Nullable IScreen settingsScreen() {
        Minecraft mc = Minecraft.getInstance();
        return (IScreen) new OptionsScreen(mc.screen, mc.options);
    }

    @Override
    public abstract @Nullable IScreen modListScreen();
}
