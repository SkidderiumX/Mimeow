/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.EntityLivingBase;
import x.oc384197ee54;
import x.oc68d6b191af;

@oc384197ee54
public class oc4c5a4d3446
extends oc68d6b191af {
    public EntityLivingBase \u0217;
    private float \u01e5;
    private float \u0537;
    private boolean \u023e;
    public static int \u024d;

    public oc4c5a4d3446(EntityLivingBase entityLivingBase, float f, float f2, boolean bl) {
        this.\u0217 = entityLivingBase;
        this.\u01e5 = f;
        this.\u0537 = f2;
        this.\u023e = bl;
    }

    public float \u041f() {
        return this.\u01e5;
    }

    public void \u0246(float f) {
        this.\u01e5 = f;
    }

    public float \u0446() {
        return this.\u0537;
    }

    public void \u0156(float f) {
        this.\u0537 = f;
    }

    public boolean \u0159() {
        return this.\u023e;
    }

    public void \u0167(boolean bl) {
        this.\u023e = bl;
    }
}

