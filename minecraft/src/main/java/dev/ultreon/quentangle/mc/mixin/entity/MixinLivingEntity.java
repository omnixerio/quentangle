package dev.ultreon.quentangle.mc.mixin.entity;

import dev.ultreon.quentangle.api.entity.ILivingEntity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity implements ILivingEntity {
    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract float getHealth();

    @Override
    public void quent$health(float health) {
        setHealth(health);
    }

    @Override
    public float quent$health() {
        return getHealth();
    }
}
