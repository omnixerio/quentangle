package dev.ultreon.quentangle.qv.mixin.client;

import net.fabricmc.loader.api.FabricLoader;
import dev.ultreon.quentangle.CommonConstants;
import net.quantumvoxel.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {
    @Inject(at = @At("HEAD"), method = "init")
    private void init(CallbackInfo info) {
        CommonConstants.LOG.info("This line is printed by the Quentangle mixin from Fabric!");
        CommonConstants.LOG.info("Quantum Voxel Version: {}", FabricLoader.getInstance().getRawGameVersion());
    }
}
