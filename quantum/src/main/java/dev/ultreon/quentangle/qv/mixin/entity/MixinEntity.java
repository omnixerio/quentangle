package dev.ultreon.quentangle.qv.mixin.entity;

import net.quantumvoxel.entity.Entity;
import dev.ultreon.quentangle.api.entity.IEntity;
import net.quantumvoxel.resource.GameObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class MixinEntity extends GameObject implements IEntity {
    @Override
    public double quent$x() {
        return position.x;
    }

    @Override
    public double quent$y() {
        return position.y;
    }

    @Override
    public double quent$z() {
        return position.z;
    }

    @Override
    public void quent$x(double x) {
        position.x = x;
    }

    @Override
    public void quent$y(double y) {
        position.y = y;
    }

    @Override
    public void quent$z(double z) {
        position.z = z;
    }

    @Override
    public void quent$pos(double x, double y, double z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }
}
