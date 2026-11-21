package dev.ultreon.quentangle.qv.mixin.entity;

import dev.ultreon.quentangle.api.entity.ILivingEntity;
import net.quantumvoxel.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity implements ILivingEntity {
    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract float getHealth();

    public void quent$health(float health) {
        setHealth(health);
    }

    public float quent$health() {
        return getHealth();
    }
}
