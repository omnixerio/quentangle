package dev.ultreon.quentangle.mc.mixin.resources;

import dev.ultreon.quentangle.api.resources.IResource;
import net.minecraft.server.packs.resources.Resource;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.IOException;
import java.io.InputStream;

@Mixin(Resource.class)
public abstract class MixinResource implements IResource {
    @Shadow
    public abstract InputStream open() throws IOException;

    @Override
    public InputStream quent$inputStream() throws IOException {
        return open();
    }

    @Override
    public byte[] quent$bytes() {
        try (InputStream inputStream = open()) {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    @Nullable
    public String quent$string() {
        try (InputStream inputStream = open()) {
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            return null;
        }
    }
}
