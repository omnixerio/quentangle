package dev.ultreon.quentangle.fabric.platform;

import dev.ultreon.quentangle.api.entity.IEntityApi;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import dev.ultreon.quentangle.api.entity.IEntityTypeBuilder;

public class FabricEntityApi implements IEntityApi {
    @Override
    public <T extends IEntityListener> IEntityTypeBuilder<T> entityBuilder(T listener) {
        return new FabricEntityTypeBuilder<>(listener);
    }
}
