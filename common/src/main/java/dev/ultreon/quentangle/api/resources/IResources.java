package dev.ultreon.quentangle.api.resources;

import dev.ultreon.quentangle.registry.IKey;

import java.io.IOException;
import java.io.InputStream;

public interface IResources {
    IResource quent$get(IKey id);

    InputStream quent$open(IKey id) throws IOException;
}
