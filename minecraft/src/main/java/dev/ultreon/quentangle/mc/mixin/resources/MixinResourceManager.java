package dev.ultreon.quentangle.mc.mixin.resources;

import dev.ultreon.quentangle.api.resources.IResource;
import dev.ultreon.quentangle.api.resources.IResources;
import dev.ultreon.quentangle.registry.IKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Mixin(ResourceManager.class)
public interface MixinResourceManager extends IResources {
    @Shadow
    List<Resource> getResourceStack(ResourceLocation resourceLocation);

    @Override
    default IResource quent$get(IKey id) {
        return (IResource) getResourceStack((ResourceLocation) (Object) id).stream().findFirst().orElse(null);
    }

    @Override
    default InputStream quent$open(IKey id) throws IOException {
        return getResourceStack((ResourceLocation) (Object) id).stream().findFirst().orElseThrow().open();
    }
}
