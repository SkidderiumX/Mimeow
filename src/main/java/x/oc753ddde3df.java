/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;
import x.oc189360bfdf;
import x.oc2f60cd9d1e;
import x.oc69da1aa7f5;
import x.ocacfd09d720;

public class oc753ddde3df
extends oc189360bfdf {
    @NotNull
    private final Packet<?> \u0449;
    @NotNull
    private final oc2f60cd9d1e \u046b;
    private final long \u00c7;
    public static boolean \u01e3;

    public oc753ddde3df(@NotNull Packet<?> packet, @NotNull oc2f60cd9d1e oc2f60cd9d1e2) {
        this.\u0449 = packet;
        this.\u046b = oc2f60cd9d1e2;
        this.\u00c7 = System.currentTimeMillis();
    }

    public long \u04d7() {
        return this.\u00c7;
    }

    public void \u023a(@NotNull ocacfd09d720 ocacfd09d7202) {
        block10: {
            boolean bl;
            block12: {
                block11: {
                    oc753ddde3df oc753ddde3df2;
                    boolean bl2;
                    block8: {
                        block9: {
                            bl2 = false;
                            oc753ddde3df2 = this;
                            if (bl2) break block8;
                            if (oc753ddde3df2.\u046b != oc2f60cd9d1e.\u00fb) break block9;
                            ocacfd09d7202.z$3oshsjajatpc8(this.\u0449);
                        }
                        oc753ddde3df2 = this;
                    }
                    oc753ddde3df2.\u046b.\u0265(this.\u0449);
                    if (!bl2) break block10;
                    if (!false) break block11;
                    bl = false;
                    break block12;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }
}

