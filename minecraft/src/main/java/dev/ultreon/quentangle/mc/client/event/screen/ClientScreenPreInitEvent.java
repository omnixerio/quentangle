package dev.ultreon.quentangle.mc.client.event.screen;

import dev.ultreon.quentangle.client.gui.IScreen;
import dev.ultreon.quentangle.mc.client.event.ClientScreenEvent;
import net.minecraft.client.gui.screens.Screen;


public class ClientScreenPreInitEvent implements ClientScreenEvent {
    private final IScreen screen;

    public ClientScreenPreInitEvent(IScreen screen) {
        this.screen = screen;
    }

    @Override
    public IScreen getScreen() {
        return screen;
    }
}
