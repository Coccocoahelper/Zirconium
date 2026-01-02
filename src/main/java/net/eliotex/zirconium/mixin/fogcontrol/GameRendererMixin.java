package net.eliotex.zirconium.mixin.fogcontrol;

import net.minecraft.client.render.GameRenderer;
import net.eliotex.zirconium.config.ZirconiumConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Credits to https://github.com/Sumire-Labs/Celeritas-Extra for the original, Forge 1.12.2 implementation of this!
 */
@Mixin(GameRenderer.class)
public class GameRendererMixin {

    /**
     * Control fog rendering (simplified version)
     * This cancels the fog setup, effectively disabling fog
     */
    @Inject(
        method = "renderFog",
        at = @At("HEAD"),
        cancellable = true
    )
    private void renderFog(int mode, float tickDelta, CallbackInfo ci) {
        if (!ZirconiumConfig.instance.showFog.get()) {
            ci.cancel();
        }
    }

}
