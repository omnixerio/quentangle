package dev.ultreon.quentangle.qv.mixin.item;

import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.quantumvoxel.item.Item;
import net.quantumvoxel.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Item.class)
public abstract class MixinItem implements IItem {
    @Override
    public IItemStack quent$defaultItemStack() {
        return (IItemStack) new ItemStack((Item) (Object)this, 1);
    }
}
