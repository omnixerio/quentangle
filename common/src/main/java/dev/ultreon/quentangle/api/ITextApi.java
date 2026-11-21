package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.text.IMutableTextObject;
import dev.ultreon.quentangle.text.ITextObject;

public interface ITextApi {
    IMutableTextObject literal(String text);
    IMutableTextObject translate(String key, Object... args);
    ITextObject empty();
}
