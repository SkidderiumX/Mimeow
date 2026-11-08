/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;
import x.oc68d6b191af;
import x.oce79181588d;

public class oc86de9e2892
extends oc68d6b191af {
    public Float \u04dc;
    public Float \u0177;
    public boolean \u0291;
    private float \u00c1 = Float.POSITIVE_INFINITY;
    private final Float \u0569;
    private final Float \u046e;
    private Float \u024b;
    private Float \u04e9;
    private boolean \u012e;
    private Object \u01b4;
    private int \u03c0 = 0x21FF4C24 ^ 0xA1FF4C24;
    private boolean \u026a;
    private boolean \u01e7;
    private Boolean \u047a;
    public static boolean \u04f3;

    public oc86de9e2892(Float f, Float f2) {
        this.\u04dc = f;
        this.\u0177 = f2;
        this.\u0569 = f;
        this.\u046e = f2;
        this.\u024b = f;
        this.\u04e9 = f2;
    }

    public void t(Float f) {
        this.\u04dc = f;
        this.\u04c7();
    }

    public void U(Float f) {
        this.\u0177 = f;
        this.\u04c7();
    }

    public void \u0567(Float f, Float f2) {
        this.\u04dc = f;
        this.\u0177 = f2;
        this.\u04c7();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean \u01f0(Object object, int n) {
        Object object2;
        int n2;
        int n3;
        block14: {
            Objects.requireNonNull(object, "owner");
            this.\u01ce();
            n3 = oce79181588d.\u022d;
            n2 = this.\u012e;
            if (n3 != 0) return n2 != 0;
            if (n2 == 0) return 1 != 0;
            object2 = this;
            if (n3 != 0) break block14;
            if (((oc86de9e2892)object2).\u01b4 == null) return 1 != 0;
            object2 = this.\u01b4;
        }
        if (object2 == object) return 1 != 0;
        n2 = n;
        if (n3 != 0) return n2 != 0;
        if (n2 <= this.\u03c0) return 0 != 0;
        return 1 != 0;
    }

    public boolean \u043b(Object object, int n, Float f, Float f2) {
        return this.\u01cd(object, n, f, f2, false);
    }

    public boolean \u01cd(Object object, int n, Float f, Float f2, boolean bl) {
        int n2;
        block12: {
            block13: {
                Object object2;
                int n3;
                block10: {
                    block11: {
                        n3 = oce79181588d.\u022d;
                        object2 = this;
                        if (n3 != 0) break block10;
                        if (((oc86de9e2892)object2).\u01f0(object, n)) break block11;
                        return false;
                    }
                    object2 = this.\u01b4;
                }
                boolean bl2 = object2 == object;
                boolean bl3 = bl2;
                this.\u04dc = f;
                this.\u0177 = f2;
                this.\u024b = f;
                this.\u04e9 = f2;
                oc86de9e2892 oc86de9e28922 = this;
                n2 = 1;
                if (n3 != 0) break block12;
                oc86de9e28922.\u012e = n2;
                this.\u01b4 = object;
                oc86de9e28922 = this;
                if (!bl3) break block13;
                n2 = Math.max(this.\u03c0, n);
                break block12;
            }
            n2 = n;
        }
        oc86de9e28922.\u03c0 = n2;
        this.\u026a = bl;
        this.\u01e7 = false;
        this.\u047a = null;
        this.\u00c1 = Float.POSITIVE_INFINITY;
        return true;
    }

    public void \u0290(boolean bl) {
        boolean bl2;
        block13: {
            block11: {
                Object object;
                block12: {
                    boolean bl3;
                    block10: {
                        this.\u01ce();
                        int n = oce79181588d.\u022d;
                        oc86de9e2892 oc86de9e28922 = this;
                        bl3 = bl;
                        if (n != 0) break block10;
                        if (!bl3) break block11;
                        object = this;
                        if (n != 0) break block12;
                        bl3 = ((oc86de9e2892)object).\u012e;
                    }
                    if (!bl3) break block11;
                    object = this.\u01b4;
                }
                if (object == null) break block11;
                bl2 = true;
                break block13;
            }
            bl2 = false;
        }
        oc86de9e28922.\u01e7 = bl2;
    }

    public boolean \u025a() {
        this.\u01ce();
        return this.\u01e7;
    }

    public void \u0271(float f) {
        float f2;
        block6: {
            float f3;
            block4: {
                block5: {
                    int n = oce79181588d.\u022d;
                    oc86de9e2892 oc86de9e28922 = this;
                    f3 = f;
                    if (n != 0) break block4;
                    if (!Float.isNaN(f3)) break block5;
                    f2 = Float.POSITIVE_INFINITY;
                    break block6;
                }
                f3 = 0.0f;
            }
            f2 = Math.max(f3, f);
        }
        oc86de9e28922.\u00c1 = f2;
    }

    public float o() {
        return this.\u00c1;
    }

    public Float \u0149() {
        return this.\u0569;
    }

    public Float \u0583() {
        return this.\u046e;
    }

    public Object \u038e() {
        this.\u01ce();
        return this.\u01b4;
    }

    public boolean \u0470(Object object) {
        boolean bl = this.\u038e() == object;
        return bl;
    }

    public boolean \u0404() {
        this.\u01ce();
        return this.\u026a;
    }

    public void \u0224(boolean bl) {
        block9: {
            block10: {
                oc86de9e2892 oc86de9e28922;
                Object object;
                block8: {
                    int n = oce79181588d.\u022d;
                    object = this;
                    if (n != 0) break block8;
                    ((oc86de9e2892)object).\u01ce();
                    if (!this.\u012e) break block9;
                    oc86de9e28922 = this;
                    if (n != 0) break block10;
                    object = oc86de9e28922.\u01b4;
                }
                if (object == null) break block9;
                oc86de9e28922 = this;
            }
            oc86de9e28922.\u047a = bl;
        }
    }

    public Boolean \u00fe() {
        this.\u01ce();
        return this.\u047a;
    }

    public boolean \u0148() {
        this.\u01ce();
        return this.\u012e;
    }

    private void \u01ce() {
        block10: {
            oc86de9e2892 oc86de9e28922;
            block8: {
                block9: {
                    int n = oce79181588d.\u022d;
                    oc86de9e28922 = this;
                    if (n != 0) break block8;
                    if (!Objects.equals(oc86de9e28922.\u024b, this.\u04dc)) break block9;
                    oc86de9e28922 = this;
                    if (n != 0) break block8;
                    if (Objects.equals(oc86de9e28922.\u04e9, this.\u0177)) break block10;
                }
                oc86de9e28922 = this;
            }
            oc86de9e28922.\u04c7();
        }
    }

    private void \u04c7() {
        this.\u024b = this.\u04dc;
        this.\u04e9 = this.\u0177;
        this.\u012e = true;
        this.\u01b4 = null;
        this.\u03c0 = 0xC99D3209 ^ 0xB662CDF6;
        this.\u026a = false;
        this.\u01e7 = false;
        this.\u047a = null;
    }
}

