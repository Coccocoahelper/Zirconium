package net.eliotex.zirconium.mixin.details;

import net.eliotex.zirconium.config.ZirconiumConfig;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Credits to https://github.com/Sumire-Labs/Celeritas-Extra for the Forge 1.12.2 implementation of this!
 */
@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(
        method = "renderFog",
        at = @At("HEAD"),
        cancellable = true
    )
    private void renderFog(int mode, float tickDelta, CallbackInfo ci) {
        if (!ZirconiumConfig.instance.fog.get()) {
            ci.cancel();
        }
    }

    @Inject(
        method = "renderClouds",
        at = @At("HEAD"),
        cancellable = true
    )
    private void renderClouds(float tickDelta, int anaglyphRenderPass, CallbackInfo ci) {
        if (!ZirconiumConfig.instance.clouds.get()) {
            ci.cancel();
        }
    }
}

