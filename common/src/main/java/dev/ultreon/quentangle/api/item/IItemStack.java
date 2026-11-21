package dev.ultreon.quentangle.api.item;

import dev.ultreon.quentangle.platform.Platform;

public interface IItemStack {
    static IItemStack create(IItem item) {
        return Platform.PLATFORM.getItemsApi().stack(item);
    }

    int quent$getAmount();

    void quent$setAmount(int amount);

    IItem quent$getItem();
}
