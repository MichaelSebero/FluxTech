package gregfluxology.mixins.gregtech;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.pipelike.cable.tile.TileEntityCable;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GregtechCapabilities.class, remap = false)
public class GregtechCapabilitiesMixin {

    @Inject(method = "attachTileCapability", at = @At("HEAD"), cancellable = true)
    private static void attachTileCapability(AttachCapabilitiesEvent<TileEntity> event, CallbackInfo ci) {
        TileEntity tileEntity = event.getObject();
        if (tileEntity instanceof IGregTechTileEntity || tileEntity instanceof TileEntityCable) {
            ci.cancel();
        }
    }
}
