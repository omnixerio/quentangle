package dev.ultreon.quentangle.qv;

import dev.ultreon.quentangle.QuentangleCommon;
import dev.ultreon.quentangle.CommonConstants;
import dev.ultreon.quentangle.platform.Platform;
import dev.ultreon.quentangle.qv.platform.QuantumPlatform;
import net.fabricmc.api.ModInitializer;

public class Quentangle implements ModInitializer {

    @Override
    public void onInitialize() {
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Platform.PLATFORM = new QuantumPlatform();
        CommonConstants.LOG.info("Hello Quantum Voxel world!");
        QuentangleCommon.init();
    }
}
