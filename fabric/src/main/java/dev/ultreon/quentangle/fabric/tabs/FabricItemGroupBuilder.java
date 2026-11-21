package dev.ultreon.quentangle.fabric.tabs;

import dev.ultreon.quentangle.api.item.IItemGroup;
import dev.ultreon.quentangle.api.item.IItemGroupContent;
import dev.ultreon.quentangle.api.item.IItemStack;
import dev.ultreon.quentangle.api.item.IItemGroupBuilder;
import dev.ultreon.quentangle.registry.IKey;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class FabricItemGroupBuilder implements IItemGroupBuilder {
    private final CreativeModeTab.Builder builder;

    public FabricItemGroupBuilder(IKey key) {
        this.builder = FabricItemGroup.builder().title(
                Component.translatable("itemGroup." + key.quent$domain() + "." + key.quent$path().replace('/', '.'))
        );
    }

    @Override
    public IItemGroupBuilder icon(Supplier<IItemStack> icon) {
        builder.icon(() -> (ItemStack) (Object) icon.get());
        return this;
    }

    @Override
    public IItemGroupBuilder background(IKey background) {
        builder.backgroundTexture((ResourceLocation) (Object) background);
        return this;
    }

    @Override
    public IItemGroupBuilder noScrollBar() {
        builder.noScrollBar();
        return this;
    }

    @Override
    public IItemGroupBuilder displayItems(IGeneratorFunc generator) {
        builder.displayItems((itemDisplayParameters, output) -> generator.genItems((IItemGroupContent) output));
        return this;
    }

    @Override
    public IItemGroup build() {
        return (IItemGroup) builder.build();
    }
}
