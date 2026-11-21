package dev.ultreon.quentangle.fabric;

import com.terraformersmc.modmenu.gui.ModsScreen;
import dev.ultreon.quentangle.client.gui.IScreen;
import dev.ultreon.quentangle.mc.api.MCScreenApi;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.Nullable;

public class FabricScreenApi extends MCScreenApi {
    @Override
    public @Nullable IScreen modListScreen() {
        if (FabricLoader.getInstance().isModLoaded("modmenu"))
            return (IScreen) new ModsScreen(Minecraft.getInstance().screen);
        return null;
    }
}
