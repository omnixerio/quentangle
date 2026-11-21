package dev.ultreon.quentangle.qv.mixin.resources;

import dev.ultreon.quentangle.api.resources.IResource;
import net.quantumvoxel.resource.Resource;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.IOException;
import java.io.InputStream;

@Mixin(Resource.class)
public interface MixinResource extends IResource {
    @Shadow
    InputStream openStream() throws IOException;

    @Shadow
    byte @Nullable [] readBytes();

    @Shadow
    @Nullable String readString();

    @Override
    default InputStream quent$inputStream() throws IOException {
        return openStream();
    }

    @Override
    default byte @Nullable [] quent$bytes() {
        return readBytes();
    }

    @Override
    default @Nullable String quent$string() {
        return readString();
    }
}
