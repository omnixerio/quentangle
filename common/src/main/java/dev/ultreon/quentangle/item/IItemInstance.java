package dev.ultreon.quentangle.item;

import dev.ultreon.quentangle.api.item.IItem;
import dev.ultreon.quentangle.api.item.IItemListener;

public interface IItemInstance<T extends IItemListener> extends IItem {
    T quent$listener();
}
