package dev.ultreon.quentangle.qv.mixin.client.gui;

import net.quantumvoxel.client.QuantumClient;
import net.quantumvoxel.client.backend.AbstractGui;
import net.quantumvoxel.client.backend.Gui;
import net.quantumvoxel.util.Key;
import dev.ultreon.quentangle.api.client.gui.IGuiRenderer;
import dev.ultreon.quentangle.qv.mixin.accessor.ScreenAccessor;
import dev.ultreon.quentangle.registry.IKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractGui.class)
public abstract class MixinGuiRenderer implements Gui, IGuiRenderer {
    @Shadow
    public abstract void pushMatrix();

    @Shadow
    public abstract void popMatrix();

    @Override
    public void quent$drawTex(IKey texture, int x, int y, int width, int height) {
        drawTexture((Key) (Object) texture, x, y, width, height, 0, 0, width, height, 256, 256);
    }

    @Override
    public void quent$drawTex(IKey texture, int x, int y, int width, int height, int u, int v) {
        drawTexture((Key) (Object) texture, x, y, width, height, u, v, width, height, 256, 256);
    }

    @Override
    public void quent$drawTex(IKey texture, int x, int y, int width, int height, int u, int v, int uWidth, int vHeight) {
        drawTexture((Key) (Object) texture, x, y, width, height, u, v, uWidth, vHeight, 256, 256);
    }

    @Override
    public void quent$drawTex(IKey texture, int x, int y, int width, int height, int u, int v, int uWidth, int vHeight, int textureWidth, int textureHeight) {
        drawTexture((Key) (Object) texture, x, y, width, height, u, v, uWidth, vHeight, textureWidth, textureHeight);
    }

    @Override
    public void quent$drawString(String text, int scale, int x, int y, int color, boolean shadow) {
        drawString(text, x, y, color, shadow);
    }

    @Override
    public void quent$drawBox(int x, int y, int width, int height, int color) {
        outlineRect(x, y, width, height, color);
    }

    @Override
    public void quent$fillBox(int x, int y, int width, int height, int color) {
        fillRect(x, y, width, height, color);
    }

    @Override
    public void quent$translate(float x, float y) {
        translate(x, y, 0);
    }

    @Override
    public void quent$scale(float x, float y) {
        scale(x, y, 1);
    }

    @Override
    public void quent$pushMatrix() {
        pushMatrix();
    }

    @Override
    public void quent$popMatrix() {
        popMatrix();
    }

    @Override
    public int quent$getTextHeight(String text, int scale) {
        return getFontHeight();
    }

    @Override
    public int quent$getTextWidth(String text, int scale) {
        return getStringWidth(text) * scale;
    }

    @Override
    public void quent$drawBackground(IGuiRenderer renderer, int mouseY, int y, float delta) {
        net.quantumvoxel.client.gui.widget.Screen screen = QuantumClient.get().getScreen();
        if (screen == null) throw new IllegalStateException("Cannot draw background without a screen!");

        ((ScreenAccessor)screen).quent$renderBackground((Gui) renderer);
    }
}
