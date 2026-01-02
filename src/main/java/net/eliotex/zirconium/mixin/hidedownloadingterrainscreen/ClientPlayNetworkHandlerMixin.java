package net.eliotex.zirconium.mixin.hidedownloadingterrainscreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.handler.ClientPlayNetworkHandler;
import net.minecraft.client.network.handler.ClientPlayPacketHandler;
import net.eliotex.zirconium.config.ZirconiumConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Makes interdimensional teleportation nearly as fast as same-dimension
 * teleportation by removing the "Downloading terrain..." screen. This will cause
 * the player to see partially loaded terrain rather than waiting for the whole
 * render distance to load, but that's also the vanilla behaviour for same-dimension
 * teleportation.
 */
// Adapted from embeddedt's ArchaicFix mod, for 1.7.10
@Mixin(value = ClientPlayNetworkHandler.class, priority = 500)
public abstract class ClientPlayNetworkHandler implements ClientPlayPacketHandler {

    @Redirect(method = "handleJoinGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/screen/Screen;)V"))
    private void onGuiDisplayJoin(Minecraft mc, Screen guiScreenIn) {
        mc.displayGuiScreen(ZirconiumConfig.instance.hideDownloadingTerrainScreen.get() ? null : guiScreenIn);
    }

    @Redirect(method = "handleRespawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/screen/Screen;)V"))
    private void onGuiDisplayRespawn(Minecraft mc, Screen guiScreenIn) {
        mc.displayGuiScreen(ZirconiumConfig.instance.hideDownloadingTerrainScreen.get() ? null : guiScreenIn);
    }
}