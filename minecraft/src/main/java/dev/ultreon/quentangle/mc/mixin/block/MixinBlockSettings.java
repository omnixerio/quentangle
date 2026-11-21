package dev.ultreon.quentangle.mc.mixin.block;

import dev.ultreon.quentangle.api.IBlockSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.Properties.class)
public abstract class MixinBlockSettings implements IBlockSettings {

    @Shadow
    public abstract Block.Properties strength(float destroyTime, float explosionResistance);

    @Shadow
    public abstract BlockBehaviour.Properties replaceable();

    @Override
    public IBlockSettings quent$hardness(float hardness) {
        strength(hardness, hardness);
        return this;
    }

    @Override
    public IBlockSettings quent$resistance(float resistance) {
        strength(resistance, resistance);
        return this;
    }

    @Override
    public IBlockSettings quent$strength(float strength) {
        strength(strength, strength);
        return this;
    }

    @Override
    public IBlockSettings quent$strength(float hardness, float resistance) {
        strength(hardness, resistance);
        return this;
    }

    @Override
    public IBlockSettings quent$replaceable() {
        replaceable();
        return this;
    }
}
