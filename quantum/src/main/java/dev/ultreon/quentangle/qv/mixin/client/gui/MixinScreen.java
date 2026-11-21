package dev.ultreon.quentangle.qv.mixin.client.gui;

import dev.ultreon.quentangle.api.client.gui.IGuiRenderer;
import dev.ultreon.quentangle.client.gui.IScreen;
import dev.ultreon.quentangle.client.gui.QuentScreen;
import net.quantumvoxel.client.backend.Gui;
import net.quantumvoxel.client.gui.widget.ContainerWidget;
import net.quantumvoxel.client.gui.widget.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Screen.class)
public abstract class MixinScreen extends ContainerWidget implements IScreen {

    @Shadow
    public abstract void render(Gui gui, int mouseX, int mouseY, float partialTicks);

    @Shadow
    public abstract void back();

    @Override
    public QuentScreen quent$quentScreen() {
        return null;
    }

    @Override
    public void quent$tick() {
        tick();
    }

    @Override
    public void quent$render(IGuiRenderer renderer, int mouseX, int mouseY, float delta) {
        render((Gui) renderer, mouseX, mouseY, delta);
    }

    @Override
    public void quent$close() {
        back();
    }

    @Override
    public void quent$back() {
        back();
    }

    @Override
    public void quent$open() {
        client.showScreen((Screen) (Object) this);
    }
}
