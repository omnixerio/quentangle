package dev.ultreon.quentangle.api.resources;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;

public interface IResource {
    InputStream quent$inputStream() throws IOException;

    byte[] quent$bytes();

    @Nullable String quent$string();
}
