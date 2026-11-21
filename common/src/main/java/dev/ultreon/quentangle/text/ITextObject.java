package dev.ultreon.quentangle.text;

import dev.ultreon.quentangle.platform.Platform;

public interface ITextObject {
    static ITextObject nullToEmpty(String s) {
        return s == null ? empty() : literal(s);
    }

    String quent$getText();

    static IMutableTextObject literal(String text) {
        return Platform.PLATFORM.createLiteralText(text);
    }

    static IMutableTextObject translatable(String key, Object... args) {
        return Platform.PLATFORM.createTranslatableText(key, args);
    }

    static IMutableTextObject translatable(String key, Iterable<Object> args) {
        return Platform.PLATFORM.createTranslatableText(key, args);
    }

    static ITextObject empty() {
        return Platform.PLATFORM.createEmptyText();
    }
}
