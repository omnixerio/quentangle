package dev.ultreon.quentangle.qv.mixin.client;

import dev.ultreon.quentangle.api.resources.IResources;
import dev.ultreon.quentangle.client.gui.IScreen;
import net.fabricmc.loader.api.FabricLoader;
import net.quantumvoxel.client.QuantumClient;
import net.quantumvoxel.client.gui.widget.Screen;
import net.quantumvoxel.client.world.ClientWorld;
import dev.ultreon.quentangle.CommonConstants;
import dev.ultreon.quentangle.api.game.IClientGame;
import dev.ultreon.quentangle.api.world.IClientWorld;
import net.quantumvoxel.resource.ResourceManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(QuantumClient.class)
public abstract class MixinClientGame implements IClientGame {
    @Shadow
    private ClientWorld world;

    @Shadow
    @Final
    public ResourceManager resourceManager;

    @Shadow
    public abstract Screen getScreen();

    @Shadow
    public abstract void showScreen(Screen nextScreen);

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {
        CommonConstants.LOG.info("This line is printed by the Quentangle quantum voxel mixin!");
        CommonConstants.LOG.info("Quantum Voxel Version: {}", FabricLoader.getInstance().getRawGameVersion());
    }

    @Override
    public IClientWorld quent$clientWorld() {
        return (IClientWorld) world;
    }

    @Override
    public IResources quent$resources() {
        return (IResources) resourceManager;
    }

    @Override
    public IScreen quent$screen() {
        return (IScreen) getScreen();
    }

    @Override
    public void quent$showScreen(IScreen screen) {
        this.showScreen((Screen) screen);
    }
}
