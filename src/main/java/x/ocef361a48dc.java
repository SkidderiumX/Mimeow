/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.concurrent.ConcurrentLinkedDeque;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import org.lwjgl.input.Mouse;
import x.oc2ec6a95e5c;
import x.oc49fb68d420;
import x.oc5e08d6b90f;
import x.oc72ee500c19;
import x.oc7ab2161b9f;
import x.oc9341368218;
import x.oca9cc61aada;
import x.ocbab3c9954b;
import x.occ2f8dff8d8;
import x.ocd6ae010123;
import x.oce79181588d;

public class ocef361a48dc
extends oc49fb68d420 {
    public final oca9cc61aada \u049d;
    public final occ2f8dff8d8 \u0256;
    public final oca9cc61aada \u0432;
    public final occ2f8dff8d8 \u0451;
    public final oca9cc61aada \u04eb;
    public final oca9cc61aada \u03e7;
    public final oca9cc61aada \u03c2;
    public final oca9cc61aada h;
    public final occ2f8dff8d8 \u02b6;
    public final occ2f8dff8d8 \u0507;
    public final occ2f8dff8d8 \u0162;
    public final occ2f8dff8d8 \u0443;
    public final oc2ec6a95e5c \u03c5;
    private final ConcurrentLinkedDeque<Packet<?>> \u00e4 = new ConcurrentLinkedDeque();
    private int \u00fb;
    private int \u04c3;
    private long \u015e = 0x389CB5F01CA05EFCL ^ 0xC7634A0FE35FA103L;
    private long \u0143;
    public static boolean q;

    public ocef361a48dc(oc72ee500c19 oc72ee500c192) {
        super("OldGrim", oc72ee500c192);
        this.\u049d = new oca9cc61aada("Chance", "%", 100.0, 0.0, 100.0, 1.0);
        this.\u023e(this.\u049d);
        this.\u0256 = new occ2f8dff8d8("Auto VL", false);
        this.\u023e(this.\u0256);
        this.\u0432 = new oca9cc61aada("Re-enable delay", "ms", 2000.0, 500.0, 10000.0, 100.0);
        this.\u023e(this.\u0432);
        this.\u0451 = new occ2f8dff8d8("Delay", false);
        this.\u023e(this.\u0451);
        this.\u04eb = new oca9cc61aada("Minimum delay", "ms", 100.0, 0.0, 1000.0, 10.0);
        this.\u023e(this.\u04eb);
        this.\u03e7 = new oca9cc61aada("Maximum delay", "ms", 200.0, 50.0, 1000.0, 10.0);
        this.\u023e(this.\u03e7);
        this.\u03c2 = new oca9cc61aada("Delay distance to target", 6.0, 3.0, 12.0, 0.1);
        this.\u023e(this.\u03c2);
        this.h = new oca9cc61aada("Delay chance", "%", 100.0, 0.0, 100.0, 1.0);
        this.\u023e(this.h);
        this.\u02b6 = new occ2f8dff8d8("Delay in air", true);
        this.\u023e(this.\u02b6);
        this.\u0507 = new occ2f8dff8d8("Delay looking at player", false);
        this.\u023e(this.\u0507);
        this.\u0162 = new occ2f8dff8d8("Delay require left mouse", false);
        this.\u023e(this.\u0162);
        this.\u0443 = new occ2f8dff8d8("Delay restrict held item", false);
        this.\u023e(this.\u0443);
        this.\u03c5 = new oc2ec6a95e5c("Delay whitelisted items", "oldgrim-delay-whitelisted-items");
        this.\u023e(this.\u03c5);
    }

    @Override
    public boolean z$23aflqwrtv1kr() {
        return this.\u0256.\u01ed();
    }

    @Override
    public long z$hyas9yszrl5h() {
        return (long)this.\u0432.\u04c1();
    }

    @Override
    public void z$fe4mfecqaowg() {
        block31: {
            boolean bl;
            block33: {
                block32: {
                    boolean bl2;
                    oc2ec6a95e5c oc2ec6a95e5c2;
                    boolean bl3;
                    block30: {
                        block29: {
                            block28: {
                                boolean bl4;
                                block27: {
                                    block26: {
                                        occ2f8dff8d8 occ2f8dff8d82;
                                        block25: {
                                            boolean bl5;
                                            oca9cc61aada oca9cc61aada2;
                                            boolean bl6;
                                            block24: {
                                                block23: {
                                                    block22: {
                                                        bl6 = this.\u03cc.\u04c2("OldGrim");
                                                        bl3 = false;
                                                        oca9cc61aada2 = this.\u049d;
                                                        bl5 = bl6;
                                                        if (bl3) break block22;
                                                        oca9cc61aada2.\u0209(bl5, this.\u03cc);
                                                        this.\u0256.\u0209(bl6, this.\u03cc);
                                                        oca9cc61aada2 = this.\u0432;
                                                        if (!bl6) break block23;
                                                        bl5 = this.\u0256.\u01ed();
                                                    }
                                                    if (bl3) break block24;
                                                    if (!bl5) break block23;
                                                    bl5 = true;
                                                    break block24;
                                                }
                                                bl5 = false;
                                            }
                                            oca9cc61aada2.\u0209(bl5, this.\u03cc);
                                            occ2f8dff8d82 = this.\u0451;
                                            if (bl3) break block25;
                                            occ2f8dff8d82.\u0209(bl6, this.\u03cc);
                                            if (!bl6) break block26;
                                            occ2f8dff8d82 = this.\u0451;
                                        }
                                        bl4 = occ2f8dff8d82.\u01ed();
                                        if (bl3) break block27;
                                        if (!bl4) break block26;
                                        bl4 = true;
                                        break block27;
                                    }
                                    bl4 = false;
                                }
                                boolean bl7 = bl4;
                                this.\u04eb.\u0209(bl7, this.\u03cc);
                                this.\u03e7.\u0209(bl7, this.\u03cc);
                                this.\u03c2.\u0209(bl7, this.\u03cc);
                                this.h.\u0209(bl7, this.\u03cc);
                                this.\u02b6.\u0209(bl7, this.\u03cc);
                                this.\u0507.\u0209(bl7, this.\u03cc);
                                this.\u0162.\u0209(bl7, this.\u03cc);
                                this.\u0443.\u0209(bl7, this.\u03cc);
                                oc2ec6a95e5c2 = this.\u03c5;
                                bl2 = bl7;
                                if (bl3) break block28;
                                if (!bl2) break block29;
                                bl2 = this.\u0443.\u01ed();
                            }
                            if (bl3) break block30;
                            if (!bl2) break block29;
                            bl2 = true;
                            break block30;
                        }
                        bl2 = false;
                    }
                    oc2ec6a95e5c2.\u0209(bl2, this.\u03cc);
                    if (!false) break block31;
                    if (!bl3) break block32;
                    bl = false;
                    break block33;
                }
                bl = true;
            }
            oc49fb68d420.\u012b = bl;
        }
    }

    @Override
    public void z$24alrqiqeci48() {
        this.\u00fb = 0;
        this.\u04c3 = 0;
        this.\u00e4.clear();
        this.\u015e = 0x3C3E178920D47B40L ^ 0xC3C1E876DF2B84BFL;
    }

    @Override
    public void z$1bjr376lv3ef3() {
        this.\u00fb = 0;
        this.\u04c3 = 0;
        this.\u0435();
    }

    @Override
    public void z$1k6rqjev9onbs(occ2f8dff8d8 occ2f8dff8d82) {
        block9: {
            ocef361a48dc ocef361a48dc2;
            block10: {
                boolean bl;
                block8: {
                    bl = false;
                    ocef361a48dc2 = this;
                    if (bl) break block8;
                    super.z$1k6rqjev9onbs(occ2f8dff8d82);
                    if (occ2f8dff8d82 != this.\u0451) break block9;
                    ocef361a48dc2 = this;
                }
                if (bl) break block10;
                if (ocef361a48dc2.\u0451.\u01ed()) break block9;
                ocef361a48dc2 = this;
            }
            ocef361a48dc2.\u0435();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$2az31g34zryyb(oce79181588d oce79181588d2) {
        long l;
        long l2;
        block48: {
            double d;
            boolean bl;
            block47: {
                ocef361a48dc ocef361a48dc2;
                block45: {
                    block46: {
                        block44: {
                            int n;
                            block43: {
                                ocef361a48dc ocef361a48dc3;
                                block42: {
                                    boolean bl2;
                                    block40: {
                                        block41: {
                                            block38: {
                                                block39: {
                                                    block36: {
                                                        block37: {
                                                            bl = false;
                                                            bl2 = this.\u0451.\u01ed();
                                                            if (bl) break block36;
                                                            if (bl2) break block37;
                                                            return;
                                                        }
                                                        bl2 = oce79181588d2.\u04a0() instanceof S08PacketPlayerPosLook;
                                                    }
                                                    if (bl) break block38;
                                                    if (!bl2) break block39;
                                                    this.\u0435();
                                                    return;
                                                }
                                                long l3 = this.\u015e - (0x360D513C9FC7A008L ^ 0xC9F2AEC360385FF7L);
                                                bl2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                                            }
                                            if (bl) break block40;
                                            if (!bl2) break block41;
                                            oce79181588d2.setCanceled(true);
                                            this.\u00e4.addLast(oce79181588d2.\u04a0());
                                            return;
                                        }
                                        bl2 = oce79181588d2.\u04a0() instanceof S12PacketEntityVelocity;
                                    }
                                    if (!bl2) return;
                                    ocef361a48dc3 = this;
                                    if (bl) break block42;
                                    if (ocef361a48dc3.\u01f1.thePlayer == null) return;
                                    ocef361a48dc3 = this;
                                }
                                if (ocef361a48dc3.\u01f1.theWorld == null) {
                                    return;
                                }
                                S12PacketEntityVelocity s12PacketEntityVelocity = (S12PacketEntityVelocity)oce79181588d2.\u04a0();
                                n = s12PacketEntityVelocity.getEntityID();
                                if (bl) break block43;
                                if (n != this.\u01f1.thePlayer.getEntityId()) return;
                                ocef361a48dc2 = this;
                                if (bl) break block44;
                                n = ocef361a48dc2.\u0136() ? 1 : 0;
                            }
                            if (n != 0) {
                                return;
                            }
                            ocef361a48dc2 = this;
                        }
                        if (bl) break block45;
                        if (!(ocef361a48dc2.h.\u04c1() < 100.0)) break block46;
                        d = Math.random();
                        if (bl) break block47;
                        if (!(d * 100.0 >= this.h.\u04c1())) break block46;
                        return;
                    }
                    oce79181588d2.setCanceled(true);
                    this.\u00e4.addLast(oce79181588d2.\u04a0());
                    this.\u015e = System.currentTimeMillis();
                    ocef361a48dc2 = this;
                }
                d = ocef361a48dc2.\u04eb.\u04c1();
            }
            l2 = (long)d;
            l = (long)this.\u03e7.\u04c1();
            if (bl) return;
            if (l2 <= l) break block48;
            l2 = l;
        }
        this.\u0143 = l2 + (long)(Math.random() * (double)(l - l2 + 1L));
    }

    @Override
    public void z$3fnumkcg4fzh7(oce79181588d oce79181588d2) {
        block45: {
            ocef361a48dc ocef361a48dc2;
            block46: {
                int n;
                block44: {
                    oce79181588d oce79181588d3;
                    boolean bl;
                    block42: {
                        block43: {
                            double d;
                            block40: {
                                block41: {
                                    block39: {
                                        double d2;
                                        double d3;
                                        block38: {
                                            ocef361a48dc ocef361a48dc3;
                                            block37: {
                                                block47: {
                                                    block36: {
                                                        boolean bl2;
                                                        block35: {
                                                            bl = false;
                                                            bl2 = oc7ab2161b9f.\u00d0();
                                                            if (bl) break block35;
                                                            if (!bl2) break block36;
                                                            ocef361a48dc3 = this;
                                                            if (bl) break block37;
                                                            bl2 = ocef361a48dc3.\u0226();
                                                        }
                                                        if (!bl2) break block47;
                                                    }
                                                    return;
                                                }
                                                ocef361a48dc3 = this;
                                            }
                                            d3 = ocef361a48dc3.\u049d.\u04c1();
                                            d2 = d3;
                                            if (bl) break block38;
                                            if (d2 <= 0.0) break block39;
                                            d2 = d3;
                                        }
                                        double d4 = d2 - 100.0;
                                        d = d4 == 0.0 ? 0 : (d4 < 0.0 ? -1 : 1);
                                        if (bl) break block40;
                                        if (d >= 0) break block41;
                                        double d5 = Math.random() - d3 / 100.0;
                                        d = d5 == 0.0 ? 0 : (d5 > 0.0 ? 1 : -1);
                                        if (bl) break block40;
                                        if (d < 0) break block41;
                                    }
                                    return;
                                }
                                oce79181588d3 = oce79181588d2;
                                if (bl) break block42;
                                d = (double)(oce79181588d3.\u04a0() instanceof S12PacketEntityVelocity);
                            }
                            if (d == false) break block43;
                            oce79181588d3 = oce79181588d2;
                            if (bl) break block42;
                            S12PacketEntityVelocity s12PacketEntityVelocity = (S12PacketEntityVelocity)oce79181588d3.\u04a0();
                            if (s12PacketEntityVelocity.getEntityID() == this.\u01f1.thePlayer.getEntityId()) {
                                oce79181588d2.setCanceled(true);
                                this.\u00fb = 0x640519B5 ^ 0x640519B3;
                            }
                        }
                        oce79181588d3 = oce79181588d2;
                    }
                    n = oce79181588d3.\u04a0() instanceof S32PacketConfirmTransaction;
                    if (bl) break block44;
                    if (n == 0) break block45;
                    ocef361a48dc2 = this;
                    if (bl) break block46;
                    n = ocef361a48dc2.\u00fb;
                }
                if (n <= 0) break block45;
                oce79181588d2.setCanceled(true);
                ocef361a48dc2 = this;
            }
            --ocef361a48dc2.\u00fb;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$1hfnjryfrqybj(oc9341368218 oc93413682182) {
        int n;
        block49: {
            ocef361a48dc ocef361a48dc2;
            boolean bl;
            block48: {
                block47: {
                    long l;
                    block46: {
                        block42: {
                            block43: {
                                ocef361a48dc ocef361a48dc3;
                                block44: {
                                    block45: {
                                        ocef361a48dc ocef361a48dc4;
                                        block40: {
                                            block41: {
                                                ocef361a48dc ocef361a48dc5;
                                                block38: {
                                                    block39: {
                                                        bl = false;
                                                        ocef361a48dc5 = this;
                                                        if (bl) break block38;
                                                        if (ocef361a48dc5.\u01f1.thePlayer == null) break block39;
                                                        ocef361a48dc5 = this;
                                                        if (bl) break block38;
                                                        if (ocef361a48dc5.\u01f1.theWorld == null) break block39;
                                                        ocef361a48dc4 = this;
                                                        if (bl) break block40;
                                                        if (!ocef361a48dc4.\u01f1.thePlayer.isDead) break block41;
                                                    }
                                                    ocef361a48dc5 = this;
                                                }
                                                ocef361a48dc5.\u0435();
                                                return;
                                            }
                                            ocef361a48dc4 = this;
                                        }
                                        long l2 = ocef361a48dc4.\u015e - (0x74034205FC6A051EL ^ 0x8BFCBDFA0395FAE1L);
                                        l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                                        if (bl) break block42;
                                        if (l == false) break block43;
                                        ocef361a48dc3 = this;
                                        if (bl) break block44;
                                        if (ocef361a48dc3.\u0136()) break block45;
                                        long l3 = System.currentTimeMillis() - this.\u015e - this.\u0143;
                                        l = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                                        if (bl) break block42;
                                        if (l < 0) break block43;
                                    }
                                    ocef361a48dc3 = this;
                                }
                                ocef361a48dc3.\u0435();
                            }
                            l = (long)oc7ab2161b9f.\u00d0();
                        }
                        if (bl) break block46;
                        if (l == false) return;
                        l = (long)this.\u0226();
                    }
                    if (l == false && oc93413682182.\u04e0 == this.\u01f1.thePlayer) break block47;
                    return;
                }
                ocef361a48dc ocef361a48dc6 = this;
                ocef361a48dc2 = ocef361a48dc6;
                n = ocef361a48dc6.\u04c3;
                if (bl) break block48;
                ocef361a48dc2.\u04c3 = n + 1;
                if (this.\u04c3 < (0x7826DB8F ^ 0x7826DB85)) return;
                ocef361a48dc2 = this;
                n = 0;
            }
            if (bl) break block49;
            ocef361a48dc2.\u04c3 = n;
            if (this.\u00fb <= 0) return;
            ocef361a48dc ocef361a48dc7 = this;
            ocef361a48dc2 = ocef361a48dc7;
            n = ocef361a48dc7.\u00fb - 1;
        }
        ocef361a48dc2.\u00fb = n;
    }

    @Override
    public void z$2cvyenog50sql(ocbab3c9954b ocbab3c9954b2) {
        this.\u0435();
    }

    private boolean \u0136() {
        int n;
        block39: {
            block40: {
                boolean bl;
                block42: {
                    block43: {
                        block41: {
                            boolean bl2;
                            block38: {
                                occ2f8dff8d8 occ2f8dff8d82;
                                block36: {
                                    block37: {
                                        block34: {
                                            block35: {
                                                double d;
                                                block31: {
                                                    ocef361a48dc ocef361a48dc2;
                                                    block33: {
                                                        block32: {
                                                            d = this.\u03c2.\u04c1() * this.\u03c2.\u04c1();
                                                            bl2 = false;
                                                            if (oc5e08d6b90f.\u00df(d, true) == null) {
                                                                return true;
                                                            }
                                                            occ2f8dff8d82 = this.\u02b6;
                                                            if (bl2) break block31;
                                                            if (!occ2f8dff8d82.\u01ed()) break block32;
                                                            ocef361a48dc2 = this;
                                                            if (bl2) break block33;
                                                            if (!ocef361a48dc2.\u01f1.thePlayer.onGround) break block32;
                                                            return true;
                                                        }
                                                        ocef361a48dc2 = this;
                                                    }
                                                    occ2f8dff8d82 = ocef361a48dc2.\u0507;
                                                }
                                                if (bl2) break block34;
                                                if (!occ2f8dff8d82.\u01ed()) break block35;
                                                if (oc5e08d6b90f.\u0568(d, true) != null) break block35;
                                                return true;
                                            }
                                            occ2f8dff8d82 = this.\u0162;
                                        }
                                        if (bl2) break block36;
                                        if (!occ2f8dff8d82.\u01ed()) break block37;
                                        n = 0;
                                        if (bl2) break block38;
                                        if (Mouse.isButtonDown(n)) break block37;
                                        return true;
                                    }
                                    occ2f8dff8d82 = this.\u0443;
                                }
                                n = occ2f8dff8d82.\u01ed();
                            }
                            if (bl2) break block39;
                            if (n == 0) break block40;
                            ItemStack itemStack = this.\u01f1.thePlayer.getHeldItem();
                            if (itemStack == null) break block41;
                            bl = this.\u03c5.b(itemStack);
                            if (bl2) break block42;
                            if (bl) break block43;
                        }
                        bl = true;
                        break block42;
                    }
                    bl = false;
                }
                return bl;
            }
            n = 0;
        }
        return n != 0;
    }

    private void \u0435() {
        block12: {
            ocef361a48dc ocef361a48dc2;
            block10: {
                block11: {
                    Packet<?> packet;
                    boolean bl = false;
                    ocef361a48dc2 = this;
                    if (bl) break block10;
                    ocef361a48dc2.\u015e = 0xC28FDDCDDAE2F9A1L ^ 0x3D702232251D065EL;
                    if (this.\u01f1.thePlayer == null) break block11;
                    ocef361a48dc2 = this;
                    if (bl) break block10;
                    if (ocef361a48dc2.\u01f1.getNetHandler() == null) break block11;
                    while ((packet = this.\u00e4.pollFirst()) != null) {
                        if (!bl) {
                            ocd6ae010123.\u00c5(packet);
                            if (!bl) continue;
                            break;
                        }
                        break block12;
                    }
                }
                ocef361a48dc2 = this;
            }
            ocef361a48dc2.\u00e4.clear();
        }
    }
}

