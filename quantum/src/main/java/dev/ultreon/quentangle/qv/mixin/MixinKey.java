package dev.ultreon.quentangle.qv.mixin;

import net.quantumvoxel.util.Key;
import dev.ultreon.quentangle.registry.IKey;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Key.class)
public class MixinKey implements IKey {

    @Shadow @Final private @NotNull String domain;

    @Shadow @Final private @NotNull String path;

    @Override
    public String quent$domain() {
        return domain;
    }

    @Override
    public String quent$path() {
        return path;
    }
}
