package dev.ultreon.quentangle.mc.mixin.item;

import dev.ultreon.quentangle.api.item.IItemSettings;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.Properties.class)
public abstract class MixinItemSettings implements IItemSettings {

    @Shadow
    public abstract Item.Properties stacksTo(int maxStackSize);

    @Override
    public IItemSettings quent$maxStackSize(int maxStackSize) {
        stacksTo(maxStackSize);
        return this;
    }
}
