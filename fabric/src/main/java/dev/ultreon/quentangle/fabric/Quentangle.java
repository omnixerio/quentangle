package dev.ultreon.quentangle.fabric;

import dev.ultreon.quentangle.CommonConstants;
import dev.ultreon.quentangle.fabric.platform.FabricMcPlatform;
import dev.ultreon.quentangle.mc.QuentangleMinecraft;
import dev.ultreon.quentangle.mc.platform.McPlatform;
import dev.ultreon.quentangle.platform.Platform;
import net.fabricmc.api.ModInitializer;

public class Quentangle implements ModInitializer {

    @Override
    public void onInitialize() {

        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Platform.PLATFORM = McPlatform.PLATFORM = new FabricMcPlatform();
        CommonConstants.LOG.info("Hello Fabric world!");
        QuentangleMinecraft.init();
    }
}
