/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc384197ee54;

public class oc68d6b191af {
    private boolean \u02a4;
    public static boolean \u0215;

    public boolean isCancelable() {
        return this.getClass().isAnnotationPresent(oc384197ee54.class);
    }

    public boolean isCanceled() {
        return this.\u02a4;
    }

    public void setCanceled(boolean bl) {
        block11: {
            oc68d6b191af oc68d6b191af2;
            block10: {
                boolean bl2;
                block9: {
                    boolean bl3 = \u0215;
                    bl2 = bl;
                    if (bl3) break block9;
                    if (!bl2) break block10;
                    oc68d6b191af2 = this;
                    if (bl3) break block11;
                    bl2 = oc68d6b191af2.isCancelable();
                }
                if (!bl2) {
                    throw new IllegalArgumentException("Attempted to cancel a non-cancelable event: " + this.getClass().getName());
                }
            }
            oc68d6b191af2 = this;
        }
        oc68d6b191af2.\u02a4 = bl;
    }
}

