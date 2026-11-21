package dev.ultreon.quentangle.mc.mixin.client;

import com.mojang.blaze3d.platform.Window;
import dev.ultreon.quentangle.api.game.IClientGame;
import dev.ultreon.quentangle.api.resources.IResources;
import dev.ultreon.quentangle.api.world.IClientWorld;
import dev.ultreon.quentangle.client.gui.IScreen;
import dev.ultreon.quentangle.mc.client.event.ClientStartedEvent;
import dev.ultreon.quentangle.mc.client.event.ClientStoppedEvent;
import dev.ultreon.quentangle.mc.client.event.ClientStoppingEvent;
import dev.ultreon.quentangle.mc.client.event.ClientTickEvent;
import dev.ultreon.quentangle.mc.event.system.EventSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.packs.resources.ResourceManager;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/// @author XyperCode
/// @since 0.1.0 (December 10, 2024)
@Mixin(Minecraft.class)
public abstract class MixinMinecraft implements IClientGame {

    @Shadow @Final private Window window;

    @Shadow
    public ClientLevel level;

    @Shadow
    public Screen screen;

    @Shadow
    public abstract void setScreen(Screen guiScreen);

    @Shadow
    public abstract ResourceManager getResourceManager();

    @Override
    public IClientWorld quent$clientWorld() {
        return (IClientWorld) level;
    }

    @Override
    public IResources quent$resources() {
        return (IResources) getResourceManager();
    }

    @Override
    public IScreen quent$screen() {
        return (IScreen) screen;
    }

    @Override
    public void quent$showScreen(IScreen screen) {
        setScreen((Screen) screen);
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo ci) {
        EventSystem.MAIN.publish(new ClientStartedEvent((Minecraft) (Object) this));
    }

    @Inject(at = @At("HEAD"), method = "stop", cancellable = true)
    private void shutdown(CallbackInfo ci) {
        ClientStoppingEvent event = EventSystem.MAIN.publish(new ClientStoppingEvent((Minecraft) (Object) this));
        if (event.isCanceled()) {
            GLFW.glfwSetWindowShouldClose(window.getWindow(), false);
            ci.cancel();
        } else {
            EventSystem.MAIN.publish(new ClientStoppedEvent((Minecraft) (Object) this));
        }
    }

    @Inject(at = @At("HEAD"), method = "runTick")
    private void runTick$head(CallbackInfo ci) {
        EventSystem.MAIN.publish(new ClientTickEvent.Pre((Minecraft) (Object) this));
    }

    @Inject(at = @At("RETURN"), method = "runTick")
    private void runTick$return(CallbackInfo ci) {
        EventSystem.MAIN.publish(new ClientTickEvent.Post((Minecraft) (Object) this));
    }
}
