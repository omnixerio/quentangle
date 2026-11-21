package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.entity.IEntityApi;
import dev.ultreon.quentangle.api.entity.IEntityListener;
import dev.ultreon.quentangle.api.entity.IEntityTypeBuilder;
import dev.ultreon.quentangle.qv.QVEntityTypeBuilder;

public class QVEntityApi implements IEntityApi {
    @Override
    public <T extends IEntityListener> IEntityTypeBuilder<T> entityBuilder(T listener) {
        return new QVEntityTypeBuilder<>(listener);
    }
}
