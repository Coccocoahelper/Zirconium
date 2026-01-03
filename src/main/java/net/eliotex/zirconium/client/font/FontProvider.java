package com.gtnewhorizons.angelica.client.font;

import net.minecraft.resource.Identifier;

public interface FontProvider {

    /**
     * For use with §k. Should fetch a character of the same width as provided.
     */
    char getRandomReplacement(char chr);
    boolean isGlyphAvailable(char chr);
    float getUStart(char chr);
    float getVStart(char chr);
    float getXAdvance(char chr);
    float getGlyphW(char chr);
    float getUSize(char chr);
    float getVSize(char chr);
    float getShadowOffset();
    Identifier getTexture(char chr);
    float getYScaleMultiplier();
}