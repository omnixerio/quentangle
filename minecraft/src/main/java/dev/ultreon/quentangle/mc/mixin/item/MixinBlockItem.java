package dev.ultreon.quentangle.mc.mixin.item;

import dev.ultreon.quentangle.api.item.IBlockItem;
import net.minecraft.world.item.BlockItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockItem.class)
public abstract class MixinBlockItem implements IBlockItem {
}
