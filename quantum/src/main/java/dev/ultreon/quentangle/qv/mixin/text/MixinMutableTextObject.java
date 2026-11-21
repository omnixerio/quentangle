package dev.ultreon.quentangle.qv.mixin.text;

import net.quantumvoxel.text.MutableText;
import net.quantumvoxel.text.Text;
import dev.ultreon.quentangle.text.IMutableTextObject;
import dev.ultreon.quentangle.text.ITextObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MutableText.class)
public interface MixinMutableTextObject extends Text, IMutableTextObject {
    @Shadow
    Text append(String text);

    @Shadow
    MutableText append(Text text);

    @Override
    default void quent$append(String text) {
        append(text);
    }

    @Override
    default void quent$append(ITextObject text) {
        append((Text) text);
    }
}
