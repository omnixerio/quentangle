package dev.ultreon.quentangle.qv.mixin.entity;

import dev.ultreon.quentangle.api.player.IServerPlayer;
import net.quantumvoxel.server.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
public abstract class MixinServerPlayer implements IServerPlayer {

}
