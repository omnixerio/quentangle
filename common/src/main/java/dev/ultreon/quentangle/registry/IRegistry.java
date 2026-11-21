package dev.ultreon.quentangle.registry;

import org.jetbrains.annotations.Nullable;

public interface IRegistry<T> {
    @Nullable T quent$get(IKey name);

    @Nullable Iterable<T> quent$getByTag(IKey tag);

    Iterable<T> quent$getAll();
}
