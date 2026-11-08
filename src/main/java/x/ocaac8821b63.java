/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.renderer.OpenGlHelper;
import x.oc69da1aa7f5;
import x.oce4cea752dd;

public class ocaac8821b63
extends oc69da1aa7f5 {
    public static boolean \u02b3;

    public ocaac8821b63() {
        super("Low Graphics", oce4cea752dd.\u04a6);
        this.\u0105("Reduces visual effects to improve performance.");
    }

    @Override
    public void onEnable() {
        OpenGlHelper.setReducedRenderMode(true);
    }

    @Override
    public void onDisable() {
        OpenGlHelper.setReducedRenderMode(false);
    }
}

