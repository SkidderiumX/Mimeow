/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.concurrent.ConcurrentLinkedDeque;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import org.lwjgl.input.Mouse;
import x.oc2ec6a95e5c;
import x.oc49fb68d420;
import x.oc5e08d6b90f;
import x.oc72ee500c19;
import x.oc9341368218;
import x.oca9cc61aada;
import x.ocb67361fd4e;
import x.ocbab3c9954b;
import x.occ2f8dff8d8;
import x.ocd6ae010123;
import x.oce79181588d;

public abstract class ocbab7b621a5
extends oc49fb68d420 {
    public final occ2f8dff8d8 \u019f;
    public final oca9cc61aada \u0466;
    public final oca9cc61aada \u0171;
    public final oca9cc61aada \u039f;
    public final oca9cc61aada \u0444;
    public final occ2f8dff8d8 \u00d5;
    public final occ2f8dff8d8 \u04f4;
    public final occ2f8dff8d8 \u01f8;
    public final occ2f8dff8d8 \u00c0;
    public final oc2ec6a95e5c \u0217;
    private final ConcurrentLinkedDeque<Packet<?>> \u0507 = new ConcurrentLinkedDeque();
    private long \u03b0 = 0x318E3BC6F4D0F3C3L ^ 0xCE71C4390B2F0C3CL;
    private long \u04b3;
    public static boolean \u0276;

    protected ocbab7b621a5(String string, String string2, oc72ee500c19 oc72ee500c192) {
        super(string, oc72ee500c192);
        this.\u019f = new occ2f8dff8d8("Delay", false);
        this.\u023e(this.\u019f);
        this.\u0466 = new oca9cc61aada("Minimum delay", "ms", 100.0, 0.0, 1000.0, 10.0);
        this.\u023e(this.\u0466);
        this.\u0171 = new oca9cc61aada("Maximum delay", "ms", 200.0, 50.0, 1000.0, 10.0);
        this.\u023e(this.\u0171);
        this.\u039f = new oca9cc61aada("Delay distance to target", 6.0, 3.0, 12.0, 0.1);
        this.\u023e(this.\u039f);
        this.\u0444 = new oca9cc61aada("Delay chance", "%", 100.0, 0.0, 100.0, 1.0);
        this.\u023e(this.\u0444);
        this.\u00d5 = new occ2f8dff8d8("Delay in air", true);
        this.\u023e(this.\u00d5);
        this.\u04f4 = new occ2f8dff8d8("Delay looking at player", false);
        this.\u023e(this.\u04f4);
        this.\u01f8 = new occ2f8dff8d8("Delay require left mouse", false);
        this.\u023e(this.\u01f8);
        this.\u00c0 = new occ2f8dff8d8("Delay restrict held item", false);
        this.\u023e(this.\u00c0);
        this.\u0217 = new oc2ec6a95e5c("Delay whitelisted items", string2 + "-delay-whitelisted-items");
        this.\u023e(this.\u0217);
    }

    protected final void \u03a4(boolean bl) {
        boolean bl2;
        oc2ec6a95e5c oc2ec6a95e5c2;
        block17: {
            block16: {
                boolean bl3;
                block15: {
                    boolean bl4;
                    block14: {
                        block13: {
                            occ2f8dff8d8 occ2f8dff8d82;
                            block12: {
                                bl3 = false;
                                occ2f8dff8d82 = this.\u019f;
                                if (bl3) break block12;
                                occ2f8dff8d82.\u0209(bl, this.\u03cc);
                                if (!bl) break block13;
                                occ2f8dff8d82 = this.\u019f;
                            }
                            bl4 = occ2f8dff8d82.\u01ed();
                            if (bl3) break block14;
                            if (!bl4) break block13;
                            bl4 = true;
                            break block14;
                        }
                        bl4 = false;
                    }
                    boolean bl5 = bl4;
                    this.\u0466.\u0209(bl5, this.\u03cc);
                    this.\u0171.\u0209(bl5, this.\u03cc);
                    this.\u039f.\u0209(bl5, this.\u03cc);
                    this.\u0444.\u0209(bl5, this.\u03cc);
                    this.\u00d5.\u0209(bl5, this.\u03cc);
                    this.\u04f4.\u0209(bl5, this.\u03cc);
                    this.\u01f8.\u0209(bl5, this.\u03cc);
                    this.\u00c0.\u0209(bl5, this.\u03cc);
                    oc2ec6a95e5c2 = this.\u0217;
                    bl2 = bl5;
                    if (bl3) break block15;
                    if (!bl2) break block16;
                    bl2 = this.\u00c0.\u01ed();
                }
                if (bl3) break block17;
                if (!bl2) break block16;
                bl2 = true;
                break block17;
            }
            bl2 = false;
        }
        oc2ec6a95e5c2.\u0209(bl2, this.\u03cc);
    }

    @Override
    public final void z$24alrqiqeci48() {
        this.\u0507.clear();
        this.\u03b0 = 0x26AB087958D5D469L ^ 0xD954F786A72A2B96L;
        this.\u04a9();
    }

    @Override
    public final void z$1bjr376lv3ef3() {
        this.\u0254();
        this.\u0298();
    }

    @Override
    public void z$1k6rqjev9onbs(occ2f8dff8d8 occ2f8dff8d82) {
        block9: {
            ocbab7b621a5 ocbab7b621a52;
            block10: {
                boolean bl;
                block8: {
                    bl = false;
                    ocbab7b621a52 = this;
                    if (bl) break block8;
                    super.z$1k6rqjev9onbs(occ2f8dff8d82);
                    if (occ2f8dff8d82 != this.\u019f) break block9;
                    ocbab7b621a52 = this;
                }
                if (bl) break block10;
                if (ocbab7b621a52.\u019f.\u01ed()) break block9;
                ocbab7b621a52 = this;
            }
            ocbab7b621a52.\u0298();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final void z$2az31g34zryyb(oce79181588d oce79181588d2) {
        long l;
        long l2;
        block49: {
            double d;
            boolean bl;
            block48: {
                oca9cc61aada oca9cc61aada2;
                block46: {
                    block47: {
                        ocbab7b621a5 ocbab7b621a52;
                        block44: {
                            block45: {
                                block43: {
                                    block42: {
                                        boolean bl2;
                                        block40: {
                                            block41: {
                                                Packet<?> packet;
                                                block39: {
                                                    boolean bl3;
                                                    block37: {
                                                        block38: {
                                                            ocbab7b621a5 ocbab7b621a53;
                                                            block36: {
                                                                bl = false;
                                                                ocbab7b621a53 = this;
                                                                if (bl) break block36;
                                                                if (ocbab7b621a53.\u0226()) return;
                                                                ocbab7b621a53 = this;
                                                            }
                                                            bl3 = ocbab7b621a53.\u019f.\u01ed();
                                                            if (bl) break block37;
                                                            if (bl3) break block38;
                                                            return;
                                                        }
                                                        packet = oce79181588d2.\u04a0();
                                                        if (bl) break block39;
                                                        bl3 = packet instanceof S08PacketPlayerPosLook;
                                                    }
                                                    if (bl3) {
                                                        this.\u0298();
                                                        return;
                                                    }
                                                    packet = oce79181588d2.\u04a0();
                                                }
                                                bl2 = ocb67361fd4e.\u0223(packet);
                                                if (bl) break block40;
                                                if (!bl2) break block41;
                                                return;
                                            }
                                            ocbab7b621a52 = this;
                                            if (bl) break block42;
                                            long l3 = ocbab7b621a52.\u03b0 - (0xBB6E3DBA26C3FF8EL ^ 0x4491C245D93C0071L);
                                            bl2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                                        }
                                        if (bl2) {
                                            oce79181588d2.setCanceled(true);
                                            this.\u0507.addLast(oce79181588d2.\u04a0());
                                            return;
                                        }
                                        ocbab7b621a52 = this;
                                    }
                                    if (bl) break block43;
                                    if (!ocbab7b621a52.\u0184(oce79181588d2.\u04a0())) return;
                                    ocbab7b621a52 = this;
                                }
                                if (bl) break block44;
                                if (!ocbab7b621a52.\u0213()) break block45;
                                return;
                            }
                            ocbab7b621a52 = this;
                        }
                        oca9cc61aada2 = ocbab7b621a52.\u0444;
                        if (bl) break block46;
                        if (!(oca9cc61aada2.\u04c1() < 100.0)) break block47;
                        d = Math.random();
                        if (bl) break block48;
                        if (!(d * 100.0 >= this.\u0444.\u04c1())) break block47;
                        return;
                    }
                    oce79181588d2.setCanceled(true);
                    this.\u0507.addLast(oce79181588d2.\u04a0());
                    this.\u03b0 = System.currentTimeMillis();
                    oca9cc61aada2 = this.\u0466;
                }
                d = oca9cc61aada2.\u04c1();
            }
            l2 = (long)d;
            l = (long)this.\u0171.\u04c1();
            if (bl) return;
            if (l2 <= l) break block49;
            l2 = l;
        }
        this.\u04b3 = l2 + (long)(Math.random() * (double)(l - l2 + 1L));
    }

    @Override
    public final void z$3fnumkcg4fzh7(oce79181588d oce79181588d2) {
        if (!oce79181588d2.isCanceled()) {
            this.z$2uapwiwypvawu(oce79181588d2);
        }
    }

    @Override
    public final void z$1hfnjryfrqybj(oc9341368218 oc93413682182) {
        ocbab7b621a5 ocbab7b621a52;
        block26: {
            block27: {
                ocbab7b621a5 ocbab7b621a53;
                block28: {
                    block29: {
                        boolean bl;
                        block24: {
                            block25: {
                                ocbab7b621a5 ocbab7b621a54;
                                block22: {
                                    block23: {
                                        bl = false;
                                        ocbab7b621a54 = this;
                                        if (bl) break block22;
                                        if (ocbab7b621a54.\u01f1.thePlayer == null) break block23;
                                        ocbab7b621a54 = this;
                                        if (bl) break block22;
                                        if (ocbab7b621a54.\u01f1.theWorld == null) break block23;
                                        ocbab7b621a52 = this;
                                        if (bl) break block24;
                                        if (!ocbab7b621a52.\u01f1.thePlayer.isDead) break block25;
                                    }
                                    ocbab7b621a54 = this;
                                }
                                ocbab7b621a54.\u0298();
                                return;
                            }
                            ocbab7b621a52 = this;
                        }
                        if (bl) break block26;
                        if (ocbab7b621a52.\u03b0 == (0xA150092D2296BB1EL ^ 0x5EAFF6D2DD6944E1L)) break block27;
                        ocbab7b621a53 = this;
                        if (bl) break block28;
                        if (ocbab7b621a53.\u0213()) break block29;
                        if (System.currentTimeMillis() - this.\u03b0 < this.\u04b3) break block27;
                    }
                    ocbab7b621a53 = this;
                }
                ocbab7b621a53.\u0298();
            }
            ocbab7b621a52 = this;
        }
        ocbab7b621a52.z$ijyrn2gv32lm(oc93413682182);
    }

    @Override
    public final void z$2cvyenog50sql(ocbab3c9954b ocbab3c9954b2) {
        this.\u04a0(ocbab3c9954b2);
        this.\u0298();
    }

    protected void \u04a9() {
    }

    protected void \u0254() {
    }

    protected void \u04a0(ocbab3c9954b ocbab3c9954b2) {
    }

    protected void \u0164(Packet<?> packet) {
    }

    protected abstract void z$2uapwiwypvawu(oce79181588d var1);

    protected abstract void z$ijyrn2gv32lm(oc9341368218 var1);

    protected final boolean \u04f4(Packet<?> packet) {
        Packet<?> packet2;
        block11: {
            block12: {
                int n;
                block13: {
                    block14: {
                        boolean bl = false;
                        if (this.\u01f1.thePlayer == null) {
                            return false;
                        }
                        packet2 = packet;
                        if (bl) break block11;
                        if (!(packet2 instanceof S12PacketEntityVelocity)) break block12;
                        n = ((S12PacketEntityVelocity)packet).getEntityID();
                        if (bl) break block13;
                        if (n != this.\u01f1.thePlayer.getEntityId()) break block14;
                        n = 1;
                        break block13;
                    }
                    n = 0;
                }
                return n != 0;
            }
            packet2 = packet;
        }
        return packet2 instanceof S27PacketExplosion;
    }

    protected final boolean \u0184(Packet<?> packet) {
        boolean bl;
        block36: {
            block37: {
                boolean bl2;
                block40: {
                    block39: {
                        block41: {
                            EntityPlayerSP entityPlayerSP;
                            S27PacketExplosion s27PacketExplosion;
                            boolean bl3;
                            block38: {
                                Packet<?> packet2;
                                block29: {
                                    block30: {
                                        int n;
                                        block34: {
                                            block32: {
                                                block35: {
                                                    S12PacketEntityVelocity s12PacketEntityVelocity;
                                                    S12PacketEntityVelocity s12PacketEntityVelocity2;
                                                    block33: {
                                                        block31: {
                                                            bl3 = false;
                                                            if (this.\u01f1.thePlayer == null) {
                                                                return false;
                                                            }
                                                            packet2 = packet;
                                                            if (bl3) break block29;
                                                            if (!(packet2 instanceof S12PacketEntityVelocity)) break block30;
                                                            s12PacketEntityVelocity2 = (S12PacketEntityVelocity)packet;
                                                            s12PacketEntityVelocity = s12PacketEntityVelocity2;
                                                            if (bl3) break block31;
                                                            if (s12PacketEntityVelocity.getEntityID() != this.\u01f1.thePlayer.getEntityId()) break block32;
                                                            s12PacketEntityVelocity = s12PacketEntityVelocity2;
                                                            if (bl3) break block33;
                                                        }
                                                        if (s12PacketEntityVelocity.getMotionY() <= 0) break block32;
                                                        s12PacketEntityVelocity = s12PacketEntityVelocity2;
                                                    }
                                                    n = s12PacketEntityVelocity.getMotionX();
                                                    if (bl3) break block34;
                                                    if (n != 0) break block35;
                                                    n = s12PacketEntityVelocity2.getMotionZ();
                                                    if (bl3) break block34;
                                                    if (n == 0) break block32;
                                                }
                                                n = 1;
                                                break block34;
                                            }
                                            n = 0;
                                        }
                                        return n != 0;
                                    }
                                    packet2 = packet;
                                }
                                bl = packet2 instanceof S27PacketExplosion;
                                if (bl3) break block36;
                                if (!bl) break block37;
                                s27PacketExplosion = (S27PacketExplosion)packet;
                                entityPlayerSP = this.\u01f1.thePlayer;
                                if (bl3) break block38;
                                if (!(entityPlayerSP.motionY + (double)s27PacketExplosion.func_149144_d() > 0.0)) break block39;
                                entityPlayerSP = this.\u01f1.thePlayer;
                            }
                            double d = entityPlayerSP.motionX + (double)s27PacketExplosion.func_149149_c() - 0.0;
                            bl2 = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
                            if (bl3) break block40;
                            if (bl2) break block41;
                            double d2 = this.\u01f1.thePlayer.motionZ + (double)s27PacketExplosion.func_149147_e() - 0.0;
                            bl2 = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                            if (bl3) break block40;
                            if (!bl2) break block39;
                        }
                        bl2 = true;
                        break block40;
                    }
                    bl2 = false;
                }
                return bl2;
            }
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u0213() {
        int n;
        boolean bl;
        block48: {
            occ2f8dff8d8 occ2f8dff8d82;
            block46: {
                block47: {
                    ocbab7b621a5 ocbab7b621a52;
                    block44: {
                        block45: {
                            double d;
                            block42: {
                                block43: {
                                    ocbab7b621a5 ocbab7b621a53;
                                    block40: {
                                        block41: {
                                            block39: {
                                                bl = false;
                                                ocbab7b621a53 = this;
                                                if (bl) break block39;
                                                if (ocbab7b621a53.\u01f1.thePlayer == null) return true;
                                                ocbab7b621a53 = this;
                                            }
                                            if (bl) break block40;
                                            if (ocbab7b621a53.\u01f1.theWorld != null) break block41;
                                            return true;
                                        }
                                        ocbab7b621a53 = this;
                                    }
                                    d = ocbab7b621a53.\u039f.\u04c1() * this.\u039f.\u04c1();
                                    if (oc5e08d6b90f.\u00df(d, true) == null) {
                                        return true;
                                    }
                                    ocbab7b621a52 = this;
                                    if (bl) break block42;
                                    if (!ocbab7b621a52.\u00d5.\u01ed()) break block43;
                                    ocbab7b621a52 = this;
                                    if (bl) break block42;
                                    if (!ocbab7b621a52.\u01f1.thePlayer.onGround) break block43;
                                    return true;
                                }
                                ocbab7b621a52 = this;
                            }
                            if (bl) break block44;
                            if (!ocbab7b621a52.\u04f4.\u01ed()) break block45;
                            if (oc5e08d6b90f.\u0568(d, true) != null) break block45;
                            return true;
                        }
                        ocbab7b621a52 = this;
                    }
                    occ2f8dff8d82 = ocbab7b621a52.\u01f8;
                    if (bl) break block46;
                    if (!occ2f8dff8d82.\u01ed()) break block47;
                    n = 0;
                    if (bl) break block48;
                    if (Mouse.isButtonDown(n)) break block47;
                    return true;
                }
                occ2f8dff8d82 = this.\u00c0;
            }
            n = occ2f8dff8d82.\u01ed();
        }
        if (bl) return n != 0;
        if (n == 0) return 0 != 0;
        ItemStack itemStack = this.\u01f1.thePlayer.getHeldItem();
        if (itemStack == null) return true;
        boolean bl2 = this.\u0217.b(itemStack);
        if (bl) return bl2;
        if (bl2) return false;
        return true;
    }

    private void \u0298() {
        block12: {
            ocbab7b621a5 ocbab7b621a52;
            block10: {
                block11: {
                    Packet<?> packet;
                    boolean bl = false;
                    ocbab7b621a52 = this;
                    if (bl) break block10;
                    ocbab7b621a52.\u03b0 = 0xE3CC02AE9E83603CL ^ 0x1C33FD51617C9FC3L;
                    if (this.\u01f1.thePlayer == null) break block11;
                    ocbab7b621a52 = this;
                    if (bl) break block10;
                    if (ocbab7b621a52.\u01f1.getNetHandler() == null) break block11;
                    while ((packet = this.\u0507.pollFirst()) != null) {
                        if (!bl) {
                            this.\u0164(packet);
                            ocd6ae010123.\u00c5(packet);
                            if (!bl) continue;
                            break;
                        }
                        break block12;
                    }
                }
                ocbab7b621a52 = this;
            }
            ocbab7b621a52.\u0507.clear();
        }
    }
}

