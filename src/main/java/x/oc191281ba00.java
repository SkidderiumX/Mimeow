/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Font;
import java.util.function.Supplier;
import x.oc1378bc114d;
import x.oc9dc7529f0e;

public class oc191281ba00
implements Supplier<oc1378bc114d> {
    oc191281ba00() {
    }

    @Override
    public oc1378bc114d get() {
        Font font = new Font("Dialog", 0, 1).deriveFont(8.75f);
        return new oc9dc7529f0e(font, true, 4.0f);
    }
}

