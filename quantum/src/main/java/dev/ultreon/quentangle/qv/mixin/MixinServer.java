package dev.ultreon.quentangle.qv.mixin;

import dev.ultreon.quentangle.api.player.IServerPlayer;
import dev.ultreon.quentangle.api.resources.IResources;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.registry.IKey;
import dev.ultreon.quentangle.server.IServerGame;
import net.quantumvoxel.resource.ResourceManager;
import net.quantumvoxel.server.*;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Iterator;

@Mixin(QuantumServer.class)
public abstract class MixinServer implements IServerGame {
    @Shadow
    @Final
    private ResourceManager resourceManager;

    @Shadow
    @Final
    private PlayerManager playerManager;

    @Shadow
    @Final
    private DimensionManager dimManager;

    @Override
    public IServerWorld quent$serverWorld(IKey name) {
        return null;
    }

    @Override
    public Iterable<IServerWorld> quent$serverWorlds() {
        return () -> new Iterator<>() {
            private final Iterator<ServerWorld> iter = dimManager.getWorlds().values().iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public IServerWorld next() {
                return (IServerWorld) (Object) iter.next();
            }
        };
    }

    @Override
    public Iterable<IServerPlayer> quent$players() {
        return () -> new Iterator<>() {
            private final @NotNull Iterator<ServerPlayerEntity> iter = playerManager.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public IServerPlayer next() {
                return (IServerPlayer) iter.next();
            }
        };
    }

    @Override
    public IResources quent$resources() {
        return (IResources) resourceManager;
    }
}
