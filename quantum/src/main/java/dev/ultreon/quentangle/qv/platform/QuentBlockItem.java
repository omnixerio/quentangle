package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.block.IBlock;
import dev.ultreon.quentangle.api.item.IBlockItemInstance;
import dev.ultreon.quentangle.api.item.IBlockItemListener;
import dev.ultreon.quentangle.api.item.IItemSettings;
import dev.ultreon.quentangle.api.item.IItemStack;
import net.quantumvoxel.block.Block;
import net.quantumvoxel.item.BlockItem;
import net.quantumvoxel.item.ItemStack;

import java.util.function.Supplier;

public class QuentBlockItem<T extends IBlockItemListener> extends BlockItem implements IBlockItemInstance<T> {
    private final T listener;

    public QuentBlockItem(T listener, Supplier<IBlock> blockSupplier, IItemSettings settings) {
        super((Settings)settings, () -> (Block) blockSupplier.get());
        this.listener = listener;
    }

    @Override
    public IItemStack quent$defaultItemStack() {
        return (IItemStack) new ItemStack(this);
    }

    @Override
    public IBlock quent$block() {
        return (IBlock) this.getBlock();
    }

    @Override
    public T quent$listener() {
        return this.listener;
    }
}
