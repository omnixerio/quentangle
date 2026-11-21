package dev.ultreon.quentangle.mc.mixin.block.entity;

import dev.ultreon.quentangle.api.IBlockVec;
import dev.ultreon.quentangle.api.block.IBlockState;
import dev.ultreon.quentangle.api.block.entity.IBlockEntity;
import dev.ultreon.quentangle.api.world.IServerWorld;
import dev.ultreon.quentangle.api.world.IWorld;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockEntity.class)
public abstract class MixinBlockEntity implements IBlockEntity {
    @Shadow
    @Final
    public BlockPos worldPosition;

    @Shadow
    @Final
    public Level level;

    @Shadow
    public abstract BlockState getBlockState();

    @Override
    public IBlockState quent$blockState() {
        return (IBlockState) (Object) getBlockState();
    }

    @Override
    public IBlockVec quent$blockVec() {
        return (IBlockVec) (Object) worldPosition;
    }

    @Override
    public IWorld quent$world() {
        return (IWorld) (Object) level;
    }

    @Override
    public IServerWorld quent$serverWorld() {
        if (level instanceof net.minecraft.server.level.ServerLevel) {
            return (IServerWorld) (Object) level;
        }
        return null;
    }
}
