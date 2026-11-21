package dev.ultreon.quentangle.client.gui;

import dev.ultreon.quentangle.api.client.gui.IGuiRenderer;
import org.jetbrains.annotations.Nullable;

public interface IScreen {
    /**
     * @return the QuentScreen instance associated with this screen, or null if the screen isn't made by Quentangle
     */
    @Nullable QuentScreen quent$quentScreen();

    void quent$tick();

    void quent$render(IGuiRenderer renderer, int mouseX, int mouseY, float delta);

    void quent$close();

    void quent$back();

    void quent$open();
}
