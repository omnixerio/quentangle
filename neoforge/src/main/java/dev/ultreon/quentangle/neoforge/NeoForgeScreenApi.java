package dev.ultreon.quentangle.neoforge;

import dev.ultreon.quentangle.client.gui.IScreen;
import dev.ultreon.quentangle.mc.api.MCScreenApi;
import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.client.gui.ModListScreen;
import org.jetbrains.annotations.Nullable;

public class NeoForgeScreenApi extends MCScreenApi {
    @Override
    public @Nullable IScreen modListScreen() {
        return (IScreen) new ModListScreen(Minecraft.getInstance().screen);
    }
}
