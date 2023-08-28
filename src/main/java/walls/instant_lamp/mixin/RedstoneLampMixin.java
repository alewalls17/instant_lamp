package walls.instant_lamp.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(RedstoneLampBlock.class)
public abstract class RedstoneLampMixin extends Block {
    public RedstoneLampMixin(Settings settings) {
        super(settings);
    }
    @ModifyArg(method = "neighborUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;scheduleBlockTick(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;I)V"), index = 2)
    public int removeDelay(BlockPos pos, Block block, int delay) {
        return 0;
    }
}
