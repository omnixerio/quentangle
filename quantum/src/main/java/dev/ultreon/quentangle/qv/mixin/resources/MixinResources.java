package dev.ultreon.quentangle.qv.mixin.resources;

import dev.ultreon.quentangle.api.resources.IResource;
import dev.ultreon.quentangle.api.resources.IResources;
import dev.ultreon.quentangle.registry.IKey;
import net.quantumvoxel.resource.Resource;
import net.quantumvoxel.resource.ResourceManager;
import net.quantumvoxel.util.Key;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.IOException;
import java.io.InputStream;

@Mixin(ResourceManager.class)
public abstract class MixinResources implements IResources {
    @Shadow
    public abstract Resource getResource(Key entry);

    @Override
    public IResource quent$get(IKey id) {
        return (IResource) getResource((Key) (Object) id);
    }

    @Override
    public InputStream quent$open(IKey id) throws IOException {
        return getResource((Key) (Object) id).openStream();
    }
}
