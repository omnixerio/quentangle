package dev.ultreon.quentangle.qv.mixin.item;

import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.quantumvoxel.item.Item;
import net.quantumvoxel.item.ItemStack;
import net.quantumvoxel.item.category.ItemCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemCategory.class)
public abstract class MixinItemGroup implements IItemGroup {
    @Shadow
    public abstract Item getIcon();

    @Override
    public IItemStack quent$getIcon() {
        return (IItemStack) new ItemStack(getIcon(), 1);
    }
}
