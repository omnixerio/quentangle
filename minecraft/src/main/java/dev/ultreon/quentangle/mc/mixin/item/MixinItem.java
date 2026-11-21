package dev.ultreon.quentangle.mc.mixin.item;

import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Item.class)
public abstract class MixinItem implements IItem {
    @Override
    public IItemStack quent$defaultItemStack() {
        return (IItemStack) (Object) new ItemStack((Item) (Object) this, 1);
    }
}
