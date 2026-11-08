/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Comparator;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBow;
import x.N;
import x.oc46d828aa5f;
import x.oc5e549848f3;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc86de9e2892;
import x.oc8ce2882092;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.ocd84af7ddf8;
import x.oce4cea752dd;

public class oc9d7dd3866d
extends oc69da1aa7f5 {
    private final oca9cc61aada \u0586;
    private final oca9cc61aada \u01b0;
    private final oc46d828aa5f \u0219;
    private final occ2f8dff8d8 \u012c;
    private EntityLivingBase \u0106;
    public static boolean \u024d;
    public static boolean \u0579;

    public oc9d7dd3866d() {
        super("BowAimbot", oce4cea752dd.\u0201);
        this.\u0105("Auto aim bow.");
        this.\u0586 = new oca9cc61aada("Fov", 90.0, 10.0, 180.0, 1.0);
        this.\u028c(this.\u0586);
        this.\u01b0 = new oca9cc61aada("Predict size", 2.0, 0.1, 5.0, 0.1);
        this.\u028c(this.\u01b0);
        this.\u0219 = new oc46d828aa5f(this);
        this.\u012c = new occ2f8dff8d8("Auto release", false);
        this.\u028c(this.\u012c);
    }

    @Override
    public void z$1m9j3ewef9s() {
        block8: {
            boolean bl;
            block9: {
                int n;
                block7: {
                    n = oc5e549848f3.\u0130;
                    bl = this.\u012c.\u01ed();
                    if (n != 0) break block7;
                    if (!bl) break block8;
                    bl = \u024d;
                }
                if (n != 0) break block9;
                if (!bl) break block8;
                bl = oc7ab2161b9f.\u00d0();
            }
            if (bl) {
                oc69da1aa7f5.\u0151.playerController.onStoppedUsingItem(oc69da1aa7f5.\u0151.thePlayer);
            }
        }
    }

    @Override
    public void onDisable() {
        \u024d = false;
        this.\u0106 = null;
        this.\u0219.\u024c();
    }

    @Override
    public void z$2u87utkr1isxg() {
        this.\u0219.\u057c();
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        this.\u0219.\u057c();
    }

    @Override
    public void guiButtonToggled(occ2f8dff8d8 occ2f8dff8d82) {
        this.\u0219.\u057c();
        super.guiButtonToggled(occ2f8dff8d82);
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        this.\u0219.\u057c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195(priority=oc8ce2882092.LOW)
    public void \u0512(oc86de9e2892 oc86de9e28922) {
        float f;
        int n;
        block36: {
            float f2;
            block35: {
                int n2;
                block33: {
                    EntityLivingBase entityLivingBase;
                    block34: {
                        block29: {
                            block30: {
                                EntityPlayerSP entityPlayerSP;
                                block32: {
                                    block31: {
                                        block28: {
                                            oc9d7dd3866d oc9d7dd3866d2;
                                            block27: {
                                                \u024d = false;
                                                n = oc5e549848f3.\u0130;
                                                oc9d7dd3866d2 = this;
                                                if (n != 0) break block27;
                                                oc9d7dd3866d2.\u0106 = null;
                                                if (oc7ab2161b9f.\u00d0()) break block28;
                                                oc9d7dd3866d2 = this;
                                            }
                                            oc9d7dd3866d2.\u0219.\u024c();
                                            return;
                                        }
                                        List<EntityLivingBase> list = ocd84af7ddf8.\u04be(500.0);
                                        Object object = list;
                                        if (n == 0) {
                                            object.sort(Comparator.comparingDouble(oc75d51ec7eb::\u0157));
                                            if (list.isEmpty()) {
                                                this.\u0219.\u024c();
                                                return;
                                            }
                                            object = list.get(0);
                                        }
                                        entityLivingBase = (EntityLivingBase)object;
                                        if (n != 0) break block29;
                                        if ((double)oc75d51ec7eb.\u0157(entityLivingBase) >= this.\u0586.\u04c1()) break block30;
                                        entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                                        if (n != 0) break block31;
                                        if (entityPlayerSP.getHeldItem() == null) break block30;
                                        entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                                        if (n != 0) break block32;
                                    }
                                    if (!(entityPlayerSP.getHeldItem().getItem() instanceof ItemBow)) break block30;
                                    entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                                }
                                n2 = entityPlayerSP.isUsingItem();
                                if (n != 0) break block33;
                                if (n2 != 0) break block34;
                            }
                            this.\u0219.\u024c();
                        }
                        return;
                    }
                    this.\u0106 = entityLivingBase;
                    n2 = (0xF92F7356 ^ 0xF92E6A16) - oc69da1aa7f5.\u0151.thePlayer.getItemInUseCount();
                }
                int n3 = n2;
                f = (float)n3 / 20.0f;
                f2 = f * f + f * 2.0f;
                if (n != 0) break block35;
                f = f2 / 3.0f;
                if (!(f > 1.0f)) break block36;
                f2 = 1.0f;
            }
            f = f2;
        }
        float[] fArray = oc75d51ec7eb.G((Entity)this.\u0106, (float)this.\u01b0.\u04c1(), 0.05f, f);
        float[] fArray2 = this.\u0219.D(oc86de9e28922);
        if (n == 0) {
            if (oc75d51ec7eb.\u0459(fArray2, fArray) < 0.05f) {
                \u024d = true;
            }
            this.\u0219.\u049e(oc86de9e28922, fArray);
        }
    }
}

