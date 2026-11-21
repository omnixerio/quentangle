package dev.ultreon.quentangle.qv.mixin.world;

import net.quantumvoxel.client.world.ClientWorld;
import net.quantumvoxel.world.World;
import dev.ultreon.quentangle.api.world.IClientWorld;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientWorld.class)
public abstract class MixinClientWorld extends World implements IClientWorld {
    // TODO
}
