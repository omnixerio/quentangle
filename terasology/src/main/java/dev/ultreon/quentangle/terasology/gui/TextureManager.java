package dev.ultreon.quentangle.terasology.gui;

import dev.ultreon.quentangle.registry.IKey;
import org.terasology.splash.glfw.graphics.Texture;

import java.io.IOException;
import java.util.HashMap;

public class TextureManager {
    private static final HashMap<IKey, Texture> textures = new HashMap<>();

    public static Texture get(IKey id) {
        if (textures.containsKey(id)) {
            return textures.get(id);
        }

        return textures.put(id, load(id));
    }

    private static Texture load(IKey id) {
        try {
            return Texture.loadTexture(TextureManager.class.getClassLoader().getResource("assets/" + id.quent$domain() + "/textures/" + id.quent$path()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
