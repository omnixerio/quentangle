package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.item.IBlockItemInstance;
import dev.ultreon.quentangle.api.item.IBlockItemListener;
import dev.ultreon.quentangle.api.item.IItemSettings;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class MCBlockItemInstance<T extends IBlockItemListener> extends BlockItem implements IBlockItemInstance<T> {
    private final T listener;

    public MCBlockItemInstance(T listener, Supplier<IBlock> blockSupplier, IItemSettings settings) {
        super((Block) blockSupplier.get(), (Properties) settings);
        this.listener = listener;
    }

    @Override
    public IBlock quent$block() {
        return (IBlock) getBlock();
    }

    @Override
    public T quent$listener() {
        return listener;
    }

    @Override
    public IItemStack quent$defaultItemStack() {
        return (IItemStack) (Object) getDefaultInstance();
    }
}
