package dev.ultreon.quentangle.mc.mixin.item;

import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CreativeModeTab.class)
public abstract class MixinItemGroup implements IItemGroup {
    @Shadow
    public abstract ItemStack getIconItem();

    @Override
    public IItemStack quent$getIcon() {
        return (IItemStack) (Object) getIconItem();
    }
}
