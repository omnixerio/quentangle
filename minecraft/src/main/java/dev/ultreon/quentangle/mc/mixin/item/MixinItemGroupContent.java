package dev.ultreon.quentangle.mc.mixin.item;

import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemGroupContent;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CreativeModeTab.Output.class)
public interface MixinItemGroupContent extends IItemGroupContent {
    @Shadow
    void accept(ItemLike item);

    @Override
    default void quent$add(IItemStack... stack) {
        for (IItemStack iItemStack : stack) {
            accept(((ItemStack) (Object) iItemStack).getItem());
        }
    }

    @Override
    default void quent$add(IItem... item) {
        for (IItem iItem : item) {
            accept((Item ) iItem);
        }
    }
}
