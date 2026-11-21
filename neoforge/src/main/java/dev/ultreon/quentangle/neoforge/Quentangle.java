package dev.ultreon.quentangle.neoforge;


import dev.ultreon.quentangle.CommonConstants;
import dev.ultreon.quentangle.mc.platform.McPlatform;
import dev.ultreon.quentangle.neoforge.platform.NeoForgeMcPlatform;
import dev.ultreon.quentangle.platform.Platform;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CommonConstants.MOD_ID)
public class Quentangle {

    public Quentangle(IEventBus eventBus) {
        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Platform.PLATFORM = McPlatform.PLATFORM = new NeoForgeMcPlatform();
        CommonConstants.LOG.info("Hello NeoForge world!");
    }
}
