package dev.ultreon.quentangle.mc.mixin.client.gui;

import dev.ultreon.quentangle.api.client.gui.IGuiRenderer;
import dev.ultreon.quentangle.client.gui.IScreen;
import dev.ultreon.quentangle.client.gui.QuentScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Screen.class)
public abstract class MixinScreen implements IScreen {
    @Shadow
    public abstract void tick();

    @Shadow
    public abstract void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick);

    @Shadow
    public abstract void onClose();

    @Override
    public @Nullable QuentScreen quent$quentScreen() {
        return null;
    }

    @Override
    public void quent$tick() {
        tick();
    }

    @Override
    public void quent$render(IGuiRenderer renderer, int mouseX, int mouseY, float delta) {
        render((GuiGraphics) renderer, mouseX, mouseY, delta);
    }

    @Override
    public void quent$close() {
        onClose();
    }

    @Override
    public void quent$back() {
        onClose();
    }

    @Override
    public void quent$open() {
        Minecraft.getInstance().setScreen((Screen) (Object) this);
    }
}
