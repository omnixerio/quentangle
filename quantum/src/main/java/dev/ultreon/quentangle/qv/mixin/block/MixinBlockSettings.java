package dev.ultreon.quentangle.qv.mixin.block;

import dev.ultreon.quentangle.api.IBlockSettings;
import net.quantumvoxel.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.Settings.class)
public abstract class MixinBlockSettings implements IBlockSettings {

    @Shadow
    public abstract Block.Settings hardness(float hardness);

    @Shadow
    public abstract Block.Settings resistance(float resistance);

    @Shadow
    public abstract Block.Settings replaceable(boolean replaceable);

    @Override
    public IBlockSettings quent$hardness(float hardness) {
        hardness(hardness);
        return this;
    }

    @Override
    public IBlockSettings quent$resistance(float resistance) {
        resistance(resistance);
        return this;
    }

    @Override
    public IBlockSettings quent$strength(float strength) {
        hardness(strength);
        resistance(strength);
        return this;
    }

    @Override
    public IBlockSettings quent$strength(float hardness, float resistance) {
        hardness(hardness);
        resistance(resistance);
        return this;
    }

    @Override
    public IBlockSettings quent$replaceable() {
        replaceable(true);
        return this;
    }
}
