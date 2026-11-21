package dev.ultreon.quentangle.qv.platform;

import dev.ultreon.quentangle.api.item.IItemListener;
import dev.ultreon.quentangle.api.item.IItemSettings;
import dev.ultreon.quentangle.api.item.IItemStack;
import dev.ultreon.quentangle.item.IItemInstance;
import net.quantumvoxel.item.Item;

public class QuentItem <T extends IItemListener> extends Item implements IItemInstance<T> {
    private final T listener;

    public QuentItem(T listener, IItemSettings settings) {
        super((Settings)settings);
        this.listener = listener;
    }

    @Override
    public T quent$listener() {
        return listener;
    }

    @Override
    public IItemStack quent$defaultItemStack() {
        return null;
    }
}
