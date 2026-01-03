package com.gtnewhorizons.angelica.mixins.interfaces;

import com.gtnewhorizons.angelica.client.font.BatchingTextRenderer;
import net.minecraft.resource.Identifier;

public interface TextRendererAccessor {

    int angelica$drawStringBatched(String text, int x, int y, int argb, boolean dropShadow);

    BatchingTextRenderer angelica$getBatcher();

    void angelica$bindTexture(Identifier location);
}