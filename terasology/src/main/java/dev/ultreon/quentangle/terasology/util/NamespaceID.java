package dev.ultreon.quentangle.terasology.util;

import net.quantumvoxel.util.NamespaceID;
import dev.ultreon.quentangle.registry.IKey;

public class NamespaceID implements IKey {
    private final String domain;
    private final String path;

    private NamespaceID(String domain, String path) {
        this.domain = domain;
        this.path = path;
    }

    public static NamespaceID of(String domain, String path) {
        return new NamespaceID(domain, path);
    }

    @Override
    public String quent$domain() {
        return domain;
    }

    @Override
    public String quent$path() {
        return path;
    }
}
