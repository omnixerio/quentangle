package dev.ultreon.quentangle.mc.api;

import dev.ultreon.quentangle.api.item.IItemListener;
import dev.ultreon.quentangle.api.item.IItemSettings;
import dev.ultreon.quentangle.api.item.IItemStack;
import dev.ultreon.quentangle.item.IItemInstance;
import net.minecraft.world.item.Item;

public class MCItemInstance <T extends IItemListener> extends Item implements IItemInstance<T> {
    private final T listener;

    public MCItemInstance(T listener, IItemSettings settings) {
        super((Properties) settings);
        this.listener = listener;
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
