package dev.ultreon.quentangle.forge.platform;

import dev.ultreon.quentangle.mc.platform.services.EntityRendererRegistry;
import dev.ultreon.quentangle.mc.platform.services.IClientPlatform;

public class ForgeClientPlatform implements IClientPlatform {
    @Override
    public EntityRendererRegistry entityRenderers() {
        return new ForgeEntityRendererRegistry();
    }
}
