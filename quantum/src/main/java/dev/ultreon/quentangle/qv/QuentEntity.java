package dev.ultreon.quentangle.qv;

import dev.ultreon.quentangle.api.entity.IEntityInstance;
import dev.ultreon.quentangle.api.entity.IEntityInstanceType;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import dev.ultreon.quentangle.api.world.IWorld;
import net.quantumvoxel.entity.Entity;
import net.quantumvoxel.entity.EntityType;
import net.quantumvoxel.world.World;

public class QuentEntity<T extends IEntityListener>  extends Entity implements IEntityInstance<T> {
    private final T listener;

    public QuentEntity(EntityType<?> type, World world, T listener) {
        super(type, world);
        this.listener = listener;
    }

    @Override
    public T listener() {
        return this.listener;
    }

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
