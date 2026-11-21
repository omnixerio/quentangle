package dev.ultreon.quentangle.api.entity;

import dev.ultreon.quentangle.api.world.IWorld;

public interface IEntityType {
    IEntity create(IWorld world);
}
