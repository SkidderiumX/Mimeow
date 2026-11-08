/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Font;
import java.util.function.Supplier;
import x.oc1378bc114d;
import x.oc32cfaf85ae;
import x.oc3ebac73392;
import x.oc9dc7529f0e;

public class ocbfcb9603cb
implements Supplier<oc1378bc114d> {
    final oc32cfaf85ae val$bundledFont;
    final float val$safeFontSize;
    final float val$minimumRasterScale;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    ocbfcb9603cb(oc32cfaf85ae oc32cfaf85ae2, float f, float f2) {
        this.val$bundledFont = oc32cfaf85ae2;
        this.val$safeFontSize = f;
        this.val$minimumRasterScale = f2;
    }

    @Override
    public oc1378bc114d get() {
        Font font = oc3ebac73392.\u0577.computeIfAbsent(this.val$bundledFont.\u046a, oc3ebac73392::\u024d);
        if (font == null) {
            return oc3ebac73392.\u053b(this.val$safeFontSize);
        }
        return new oc9dc7529f0e(font.deriveFont(this.val$safeFontSize), true, this.val$minimumRasterScale, oc3ebac73392.\u0289());
    }
}

