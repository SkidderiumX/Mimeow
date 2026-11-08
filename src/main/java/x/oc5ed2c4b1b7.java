/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Font;
import java.util.function.Supplier;
import x.oc1378bc114d;
import x.oc32cfaf85ae;
import x.oc3ebac73392;

public class oc5ed2c4b1b7
implements Supplier<oc1378bc114d> {
    final oc32cfaf85ae val$bundledFont;
    final float val$safeTargetHeight;
    final float val$minimumRasterScale;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc5ed2c4b1b7(oc32cfaf85ae oc32cfaf85ae2, float f, float f2) {
        this.val$bundledFont = oc32cfaf85ae2;
        this.val$safeTargetHeight = f;
        this.val$minimumRasterScale = f2;
    }

    @Override
    public oc1378bc114d get() {
        Font font = oc3ebac73392.\u0577.computeIfAbsent(this.val$bundledFont.\u046a, oc3ebac73392::\u024d);
        if (font == null) {
            return oc3ebac73392.\u053b(this.val$safeTargetHeight);
        }
        return oc3ebac73392.\u027c(font, this.val$safeTargetHeight, this.val$minimumRasterScale);
    }
}

