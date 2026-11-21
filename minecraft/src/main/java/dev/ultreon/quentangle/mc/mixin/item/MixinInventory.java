package dev.ultreon.quentangle.mc.mixin.item;

import dev.ultreon.quentangle.api.player.IInventory;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Inventory.class)
public abstract class MixinInventory implements IInventory {
    @Shadow public abstract int getContainerSize();

    @Shadow public abstract void clearContent();

    @Shadow public abstract ItemStack getItem(int slot);

    @Shadow public abstract void setItem(int slot, ItemStack stack);

    @Override
    public int quent$size() {
        return getContainerSize();
    }

    @Override
    public void quent$clear() {
        clearContent();
    }

    @Override
    public IItemStack quent$get(int slot) {
        return (IItemStack) (Object) getItem(slot);
    }

    @Override
    public void quent$set(int slot, IItemStack stack) {
        setItem(slot, (ItemStack) (Object) stack);
    }
}
