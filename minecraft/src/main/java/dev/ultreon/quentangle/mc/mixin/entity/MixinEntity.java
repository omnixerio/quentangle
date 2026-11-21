package dev.ultreon.quentangle.mc.mixin.entity;

import dev.ultreon.quentangle.api.entity.IEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class MixinEntity implements IEntity {
    @Shadow public abstract double getX();

    @Shadow public abstract double getY();

    @Shadow public abstract double getZ();

    @Shadow public abstract void setPos(double p_20210_, double p_20211_, double p_20212_);

    @Override
    public double quent$x() {
        return getX();
    }

    @Override
    public double quent$y() {
        return getY();
    }

    @Override
    public double quent$z() {
        return getZ();
    }

    @Override
    public void quent$x(double x) {
        setPos(x, getY(), getZ());
    }

    @Override
    public void quent$y(double y) {
        setPos(getX(), y, getZ());
    }

    @Override
    public void quent$z(double z) {
        setPos(getX(), getY(), z);
    }

    @Override
    public void quent$pos(double x, double y, double z) {
        setPos(x, y, z);
    }
}
