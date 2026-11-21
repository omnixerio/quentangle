package dev.ultreon.quentangle.qv.mixin.item;

import dev.ultreon.quentangle.api.item.IItemSettings;
import net.quantumvoxel.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.Settings.class)
public abstract class MixinItemSettings implements IItemSettings {

    @Shadow
    public abstract Item.Settings maxStackSize(int size);

    @Override
    public IItemSettings quent$maxStackSize(int maxStackSize) {
        maxStackSize(maxStackSize);
        return this;
    }
}
