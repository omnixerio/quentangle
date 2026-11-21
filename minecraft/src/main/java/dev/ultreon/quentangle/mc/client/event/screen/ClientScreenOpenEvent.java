package dev.ultreon.quentangle.mc.client.event.screen;

import dev.ultreon.quentangle.client.gui.IScreen;
import dev.ultreon.quentangle.mc.client.event.ClientScreenEvent;
import dev.ultreon.quentangle.mc.event.CancelableValue;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;

public class ClientScreenOpenEvent implements ClientScreenEvent, CancelableValue<Screen> {
    private final IScreen screen;
    private boolean canceled;
    private @Nullable Screen nextScreen;

    public ClientScreenOpenEvent(IScreen screen) {
        this.screen = screen;
    }

    @Override
    public IScreen getScreen() {
        return screen;
    }

    @Override
    public boolean isCanceled() {
        return canceled;
    }

    @Override
    public void cancel(@Nullable Screen value) {
        canceled = true;
        nextScreen = value;
    }

    @Override
    public @Nullable Screen get() {
        return nextScreen;
    }
}
