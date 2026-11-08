/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc0a84d4d076;
import x.oc84f20a0bc5;
import x.oc9511a0d7a7;
import x.oca6eae151db;

public class oc583347ab0c
implements oc9511a0d7a7 {
    private final double \u04cb;
    private final oca6eae151db \u054b;
    final oc0a84d4d076 this$0;

    private oc583347ab0c(oc0a84d4d076 oc0a84d4d0762) {
        this.this$0 = oc0a84d4d0762;
        this.\u04cb = oca6eae151db.\u03ea();
        this.\u054b = oca6eae151db.\u0151;
    }

    @Override
    public boolean z$84hiyxqkwzed() {
        return this.\u054b.\u03ec(0.5f);
    }

    @Override
    public boolean z$xyji8ho88y4j() {
        return this.this$0.\u016f.\u00c8(0.05f, 0.1f, 20.0, this.\u04cb, this.\u054b);
    }

    @Override
    public boolean z$3eojo8bgeog0e() {
        return this.this$0.\u0222.\u00c8(0.05f, 0.1f, 10.0, this.\u04cb, this.\u054b);
    }

    @Override
    public float z$nktgmt65xe69() {
        return this.\u054b.\u015d(0.0f, 27.0f);
    }

    @Override
    public float z$20ncyjv7sxlb5() {
        return this.\u054b.\u015d(0.0f, (float)Math.PI);
    }

    @Override
    public double z$26ss96k6y6akr(float f) {
        return oc0a84d4d076.\u0420(f, this.this$0.l.\u0536(0.0f, 2.0f, 30.0, this.\u04cb, this.\u054b));
    }

    @Override
    public double z$38ty68r8mu29k(float f) {
        return oc0a84d4d076.\u0420(f, this.this$0.\u047a.\u0536(0.0f, 2.0f, 30.0, this.\u04cb, this.\u054b));
    }

    @Override
    public float z$180a2142whfyd(float f, float f2, boolean bl) {
        float f3;
        int n = oc84f20a0bc5.\u0117;
        if (!bl) {
            return this.\u054b.\u015d(Math.min(f, f2), Math.max(f, f2));
        }
        float f4 = f3 = this.this$0.\u0193.\u0536(0.8f, 1.2f, 30.0, this.\u04cb, this.\u054b) * 2.0f;
        float f5 = 1.0f + this.this$0.\u01e0.\u0506(this.\u054b) * 0.3f;
        if (n == 0) {
            f3 = f4 * f5;
            if (this.this$0.\u00ff.\u00c8(0.04f, 0.08f, 30.0, this.\u04cb, this.\u054b)) {
                f3 /= this.\u054b.\u015d(1.4f, 1.8f);
            }
            f4 = 0.1f;
            f5 = Math.min(10.0f, f3);
        }
        return Math.max(f4, f5);
    }
}

