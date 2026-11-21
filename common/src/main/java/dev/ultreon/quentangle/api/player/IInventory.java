package dev.ultreon.quentangle.api.player;

import dev.ultreon.quentangle.api.item.IItemStack;

public interface IInventory {
    int quent$size();

    void quent$clear();

    IItemStack quent$get(int slot);

    void quent$set(int slot, IItemStack stack);
}
