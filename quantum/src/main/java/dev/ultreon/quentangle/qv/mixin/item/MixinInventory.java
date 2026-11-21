package dev.ultreon.quentangle.qv.mixin.item;

import net.quantumvoxel.item.ItemStack;
import net.quantumvoxel.menu.ContainerMenu;
import net.quantumvoxel.menu.Inventory;
import net.quantumvoxel.menu.MenuType;
import net.quantumvoxel.player.PlayerEntity;
import net.quantumvoxel.world.container.Container;
import dev.ultreon.quentangle.api.player.IInventory;
import dev.ultreon.quentangle.api.item.IItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Inventory.class)
public abstract class MixinInventory extends ContainerMenu implements IInventory {
    protected MixinInventory(@NotNull MenuType<?> type, @NotNull PlayerEntity player, int size, @Nullable Container container) {
        super(type, player, size, container);
    }

    @Shadow
    public abstract void clear();

    @Override
    public int quent$size() {
        return slots.length;
    }

    @Override
    public void quent$clear() {
        clear();
    }

    @Override
    public IItemStack quent$get(int slot) {
        return (IItemStack) getItem(slot);
    }

    @Override
    public void quent$set(int slot, IItemStack stack) {
        setItem(slot, (ItemStack) stack);
    }
}
