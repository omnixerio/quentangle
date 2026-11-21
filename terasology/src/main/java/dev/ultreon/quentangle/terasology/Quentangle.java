package dev.ultreon.quentangle.terasology;

import dev.ultreon.quentangle.QuentangleCommon;
import dev.ultreon.quentangle.CommonConstants;
import dev.ultreon.quentangle.platform.Platform;
import net.fabricmc.api.ModInitializer;

public class Quentangle implements ModInitializer {

    @Override
    public void onInitialize() {
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Platform.PLATFORM = new TerasologyPlatform();
        CommonConstants.LOG.info("Hello Terasology world!");
        QuentangleCommon.init();
    }
}
