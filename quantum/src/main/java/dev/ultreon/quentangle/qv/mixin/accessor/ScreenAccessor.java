package dev.ultreon.quentangle.qv.mixin.accessor;

import net.quantumvoxel.client.backend.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(net.quantumvoxel.client.gui.widget.Screen.class)
public interface ScreenAccessor {
    @Invoker("renderBackground")
    void quent$renderBackground(Gui renderer);
}
