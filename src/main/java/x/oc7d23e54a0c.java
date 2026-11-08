/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import x.oc24a0a5bddf;
import x.occ2f8dff8d8;
import x.oce6044968f8;

public class oc7d23e54a0c {
    final Class<? extends EntityLivingBase> \u03e4;
    final Predicate<EntityLivingBase> \u02a4;
    final occ2f8dff8d8 \u04a1;
    final oc24a0a5bddf \u0555;

    oc7d23e54a0c(Class<? extends EntityLivingBase> clazz, Predicate<EntityLivingBase> predicate, occ2f8dff8d8 occ2f8dff8d82, oc24a0a5bddf oc24a0a5bddf2) {
        this.\u03e4 = clazz;
        this.\u02a4 = predicate;
        this.\u04a1 = occ2f8dff8d82;
        this.\u0555 = oc24a0a5bddf2;
    }

    boolean \u0490(EntityLivingBase entityLivingBase) {
        boolean bl;
        block14: {
            block15: {
                block13: {
                    oc7d23e54a0c oc7d23e54a0c2;
                    boolean bl2;
                    block12: {
                        block10: {
                            block11: {
                                bl2 = oce6044968f8.\u0452;
                                oc7d23e54a0c2 = this;
                                if (bl2) break block10;
                                if (oc7d23e54a0c2.\u03e4.isInstance(entityLivingBase)) break block11;
                                return false;
                            }
                            oc7d23e54a0c2 = this;
                        }
                        if (bl2) break block12;
                        if (oc7d23e54a0c2.\u02a4 == null) break block13;
                        oc7d23e54a0c2 = this;
                    }
                    bl = oc7d23e54a0c2.\u02a4.test(entityLivingBase);
                    if (bl2) break block14;
                    if (!bl) break block15;
                }
                bl = true;
                break block14;
            }
            bl = false;
        }
        return bl;
    }
}

