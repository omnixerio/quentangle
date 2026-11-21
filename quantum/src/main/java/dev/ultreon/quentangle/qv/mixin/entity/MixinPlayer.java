package dev.ultreon.quentangle.qv.mixin.entity;

import net.quantumvoxel.menu.Inventory;
import dev.ultreon.quentangle.api.player.IInventory;
import dev.ultreon.quentangle.api.player.IPlayer;
import net.quantumvoxel.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayer implements IPlayer {
    @Shadow
    @Final
    public Inventory inventory;

    @Override
    public IInventory quent$getInventory() {
        return (IInventory) inventory;
    }
}
