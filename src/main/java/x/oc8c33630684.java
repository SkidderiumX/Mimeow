/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import x.oce6044968f8;

public class oc8c33630684 {
    private final ItemStack \u019b;
    private final TextureAtlasSprite \u00e3;
    private final int \u04dc;
    private final String \u0271;

    private oc8c33630684(ItemStack itemStack, TextureAtlasSprite textureAtlasSprite, int n, String string) {
        this.\u019b = itemStack;
        this.\u00e3 = textureAtlasSprite;
        this.\u04dc = n;
        this.\u0271 = string;
    }

    private boolean \u020b() {
        boolean bl;
        block8: {
            block7: {
                oc8c33630684 oc8c336306842;
                block6: {
                    boolean bl2 = oce6044968f8.\u0452;
                    oc8c336306842 = this;
                    if (bl2) break block6;
                    if (oc8c336306842.\u019b == null) break block7;
                    oc8c336306842 = this;
                }
                if (oc8c336306842.\u019b.getItem() == null) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    private boolean \u03bd() {
        boolean bl = this.\u00e3 != null;
        return bl;
    }

    private int \u0186() {
        return this.\u04dc;
    }
}

