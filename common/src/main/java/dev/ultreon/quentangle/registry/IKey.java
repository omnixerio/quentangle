package dev.ultreon.quentangle.registry;

import dev.ultreon.quentangle.platform.Services;

import java.util.function.Function;

public interface IKey {
    static IKey quent$of(String domain, String path) {
        return Services.PLATFORM.key(domain, path);
    }

    static IKey quent$parse(String id) {
        String[] split = id.split(":");
        if (split.length == 1) {
            String path = split[0];
            if (!path.matches("[a-z0-9/._]+")) throw new IllegalArgumentException("Invalid path: " + id);
            return Services.PLATFORM.key(Services.PLATFORM.getDefaultNamespace(), path);
        }
        if (split.length != 2) throw new IllegalArgumentException("Invalid id: " + id);
        if (!split[0].matches("[a-z0-9_]+")) throw new IllegalArgumentException("Invalid domain: " + id);
        if (!split[1].matches("[a-z0-9/._]+")) throw new IllegalArgumentException("Invalid path: " + id);
        return Services.PLATFORM.key(split[0], split[1]);
    }

    default IKey quent$withPath(String path) {
        return IKey.quent$of(quent$domain(), path);
    }

    default IKey quent$withDomain(String domain) {
        return IKey.quent$of(domain, quent$path());
    }

    default IKey quent$map(Function<String, String> mapper) {
        return IKey.quent$of(quent$domain(), mapper.apply(quent$path()));
    }

    default IKey quent$withDefaultDomain() {
        return IKey.quent$of(Services.PLATFORM.getDefaultNamespace(), quent$path());
    }

    String quent$domain();

    String quent$path();
}
