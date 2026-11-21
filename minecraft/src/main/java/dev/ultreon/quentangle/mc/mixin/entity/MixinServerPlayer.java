package dev.ultreon.quentangle.mc.mixin.entity;

import dev.ultreon.quentangle.api.player.IServerPlayer;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayer.class)
public abstract class MixinServerPlayer implements IServerPlayer {
}
