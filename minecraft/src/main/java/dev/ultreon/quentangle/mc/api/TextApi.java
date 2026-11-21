package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.ITextApi;
import dev.ultreon.quentangle.text.IMutableTextObject;
import dev.ultreon.quentangle.text.ITextObject;
import net.minecraft.network.chat.Component;

public class TextApi implements ITextApi {
    @Override
    public IMutableTextObject literal(String text) {
        return (IMutableTextObject) (Object) Component.literal(text);
    }

    @Override
    public IMutableTextObject translate(String key, Object... args) {
        return (IMutableTextObject) (Object) Component.translatable(key, args);
    }

    @Override
    public ITextObject empty() {
        return (ITextObject) (Object) Component.empty();
    }
}
