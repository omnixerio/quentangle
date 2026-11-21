package dev.ultreon.quentangle.fabric.platform;

import dev.ultreon.quentangle.api.entity.IEntityInstance;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class FabricQuentEntity<T extends IEntityListener> extends Entity implements IEntityInstance<T> {
    private final T listener;

    public FabricQuentEntity(EntityType<?> type, Level world, T listener) {
        super(type, world);
        this.listener = listener;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    public T listener() {
        return listener;
    }

    @Override
    public double quent$x() {
        return position().x;
    }

    @Override
    public double quent$y() {
        return position().y;
    }

    @Override
    public double quent$z() {
        return position().z;
    }

    @Override
    public void quent$x(double x) {
        teleportTo(position().x, position().y, position().z);
    }

    @Override
    public void quent$y(double y) {
        teleportTo(position().x, position().y, position().z);
    }

    @Override
    public void quent$z(double z) {
        teleportTo(position().x, position().y, position().z);
    }

    @Override
    public void quent$pos(double x, double y, double z) {
        teleportTo(position().x, position().y, position().z);
    }
}
