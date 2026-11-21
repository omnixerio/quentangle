package dev.ultreon.quentangle.qv.mixin.world;

import net.quantumvoxel.server.ServerWorld;
import dev.ultreon.quentangle.api.world.IServerWorld;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerWorld.class)
public abstract class MixinServerWorld implements IServerWorld {
    // TODO
}
