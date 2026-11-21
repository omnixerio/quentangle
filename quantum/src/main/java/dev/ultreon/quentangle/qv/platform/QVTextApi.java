package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.ITextApi;
import dev.ultreon.quentangle.text.IMutableTextObject;
import dev.ultreon.quentangle.text.ITextObject;
import net.quantumvoxel.text.Text;

class QVTextApi implements ITextApi {
    @Override
    public IMutableTextObject literal(String text) {
        return (IMutableTextObject) Text.literal(text);
    }

    @Override
    public IMutableTextObject translate(String key, Object... args) {
        return (IMutableTextObject) Text.translation(key, args);
    }

    @Override
    public ITextObject empty() {
        return (ITextObject) Text.empty();
    }
}
