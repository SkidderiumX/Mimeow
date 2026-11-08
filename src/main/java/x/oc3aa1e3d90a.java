/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.image.BufferedImage;
import x.occ0b63c0426;

public class oc3aa1e3d90a {
    public String \u02a2;
    public BufferedImage \u02b8;
    public int \u053b;
    public int \u0105;
    public int \u03b6;
    public boolean \u0211;
    public static boolean \u01e5;

    public oc3aa1e3d90a(String string, boolean bl) {
        this.\u02a2 = string;
    }

    public float[] A() {
        float[] fArray = new float[0x61161037 ^ 0x61161035];
        fArray[0] = this.\u0105;
        fArray[1] = this.\u053b;
        return fArray;
    }

    public boolean \u01db() {
        boolean bl = this.\u02b8 != null;
        return bl;
    }

    public static void \u0583() {
    }

    public String toString() {
        String string;
        block6: {
            oc3aa1e3d90a oc3aa1e3d90a2;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc3aa1e3d90a2 = this;
                    if (n != 0) break block4;
                    if (oc3aa1e3d90a2.\u02a2 != null) break block5;
                    string = "";
                    break block6;
                }
                oc3aa1e3d90a2 = this;
            }
            string = oc3aa1e3d90a2.\u02a2;
        }
        return string;
    }
}

