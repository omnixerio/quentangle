package dev.ultreon.quentangle.qv.mixin.text;

import net.quantumvoxel.text.Text;
import dev.ultreon.quentangle.text.ITextObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Text.class)
public interface MixinTextObject extends ITextObject {
    @Shadow
    String getText();

    @Override
    default String quent$getText() {
        return getText();
    }
}
