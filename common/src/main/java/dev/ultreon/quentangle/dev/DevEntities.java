package dev.ultreon.quentangle.dev;

import dev.ultreon.quentangle.api.entity.IEntityApi;
import dev.ultreon.quentangle.api.entity.IEntityInstanceType;
import dev.ultreon.quentangle.api.entity.IEntityType;
import dev.ultreon.quentangle.dev.entity.TestEntity;
import dev.ultreon.quentangle.platform.Platform;
import dev.ultreon.quentangle.registry.IRegistryRef;
import dev.ultreon.quentangle.registry.IRegistrySupplier;

public class DevEntities {
    private static final IRegistryRef<IEntityType> REGISTRAR = Platform.PLATFORM.registryApi("quentangle_dev").entities();

    public static final IRegistrySupplier<IEntityType, IEntityInstanceType<TestEntity>> TEST = REGISTRAR.register("test", () -> {
        IEntityApi entityApi = Platform.PLATFORM.getEntityApi();
        return entityApi.entityBuilder(new TestEntity())
                .sized(0.5f, 0.5f)
                .build();
    });

    public static void load() {
        REGISTRAR.load();
    }
}
