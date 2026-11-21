package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.api.item.IItemGroupContent;

@FunctionalInterface
public interface IITemGroupFactory {
    void build(IItemGroupContent content);
}
