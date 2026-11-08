/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import x.oc2f61de30bc;
import x.oc3c7a892f2f;
import x.oc51fb428ba0;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc748fdbd6c0;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc89eb238246;
import x.oc8ce2882092;
import x.oc9755810e45;
import x.oc9d4393f3ce;
import x.oca4f99d2d44;
import x.occ2f8dff8d8;
import x.occ39d36078d;
import x.ocd3dd601cf7;
import x.ocd47efa9be3;
import x.ocdd342096f8;
import x.oce4cea752dd;
import x.oce79181588d;

public class V
extends oc69da1aa7f5 {
    private static final DecimalFormat \u0201 = new DecimalFormat("+0.0;-0.0", DecimalFormatSymbols.getInstance(Locale.US));
    private final occ2f8dff8d8 \u017b;
    private final occ2f8dff8d8 \u0498;
    private final occ2f8dff8d8 \u0239;
    private final occ2f8dff8d8 \u045d;
    private final occ2f8dff8d8 \u04b1;
    private final occ2f8dff8d8 \u0386;
    private final occ2f8dff8d8 \u0103;
    private final occ2f8dff8d8 \u0159;
    private final occ2f8dff8d8 \u0373;
    private final occ2f8dff8d8 \u0538;
    private final Map<Integer, ocd3dd601cf7> \u02ad = new ConcurrentHashMap<Integer, ocd3dd601cf7>();
    private int \u0390 = 0xEBD222D8 ^ 0x6BD222D8;
    private int \u02ae = 0xEBD222D8 ^ 0x6BD222D8;
    public static int \u01d5;

    public V() {
        super("Debug", oce4cea752dd.\u04a6);
        this.\u0105("Displays diagnostic data for combat and network modules.");
        this.\u017b = new occ2f8dff8d8("AttackRange", true);
        this.\u028c(this.\u017b);
        this.\u0498 = new occ2f8dff8d8("IgnoreBackTrack", false);
        this.\u028c(this.\u0498);
        this.\u0239 = new occ2f8dff8d8("TimerRangeDebug", true);
        this.\u028c(this.\u0239);
        this.\u045d = new occ2f8dff8d8("LagRangeDebug", true);
        this.\u028c(this.\u045d);
        this.\u04b1 = new occ2f8dff8d8("BacktrackDebug", true);
        this.\u028c(this.\u04b1);
        this.\u0386 = new occ2f8dff8d8("HealthDebug", true);
        this.\u028c(this.\u0386);
        this.\u0103 = new occ2f8dff8d8("ServersideChat", false);
        this.\u028c(this.\u0103);
        this.\u0159 = new occ2f8dff8d8("Blink", false);
        this.\u028c(this.\u0159);
        this.\u0373 = new occ2f8dff8d8("Transaction", false);
        this.\u028c(this.\u0373);
        this.\u0538 = new occ2f8dff8d8("Motion Debug", false);
        this.\u028c(this.\u0538);
    }

    @Override
    public void onEnable() {
        this.\u0390 = 0xCA8FA3DD ^ 0x4A8FA3DD;
        this.\u02ae = 0xCA8FA3DD ^ 0x4A8FA3DD;
        this.\u02ad.clear();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u01ed(ocd47efa9be3 ocd47efa9be32) {
        boolean bl;
        boolean bl2;
        double d;
        boolean bl3;
        double d2;
        EntityPlayer entityPlayer;
        block95: {
            block93: {
                oc3c7a892f2f oc3c7a892f2f2;
                int n;
                block94: {
                    block92: {
                        boolean bl4;
                        block90: {
                            block88: {
                                block91: {
                                    oc51fb428ba0 oc51fb428ba02;
                                    block89: {
                                        block87: {
                                            block86: {
                                                boolean bl5;
                                                block85: {
                                                    boolean bl6;
                                                    block84: {
                                                        block82: {
                                                            occ39d36078d occ39d36078d2;
                                                            block83: {
                                                                block81: {
                                                                    double d3;
                                                                    block96: {
                                                                        block79: {
                                                                            ocdd342096f8 ocdd342096f82;
                                                                            block80: {
                                                                                ocdd342096f8 ocdd342096f83;
                                                                                block78: {
                                                                                    EntityPlayer entityPlayer2;
                                                                                    block76: {
                                                                                        block77: {
                                                                                            block75: {
                                                                                                ocd47efa9be3 ocd47efa9be33;
                                                                                                block73: {
                                                                                                    block74: {
                                                                                                        block72: {
                                                                                                            block70: {
                                                                                                                block71: {
                                                                                                                    block69: {
                                                                                                                        boolean bl7;
                                                                                                                        block68: {
                                                                                                                            n = oc89eb238246.\u0127;
                                                                                                                            bl7 = this.\u017b.\u01ed();
                                                                                                                            if (n != 0) break block68;
                                                                                                                            if (!bl7) return;
                                                                                                                            bl7 = oc7ab2161b9f.\u00d0();
                                                                                                                        }
                                                                                                                        if (!bl7) return;
                                                                                                                        ocd47efa9be33 = ocd47efa9be32;
                                                                                                                        if (n != 0) break block69;
                                                                                                                        if (ocd47efa9be33.\u03b2 != oc69da1aa7f5.\u0151.thePlayer) return;
                                                                                                                        ocd47efa9be33 = ocd47efa9be32;
                                                                                                                    }
                                                                                                                    if (n != 0) break block70;
                                                                                                                    if (ocd47efa9be33.\u03ca != null) break block71;
                                                                                                                    return;
                                                                                                                }
                                                                                                                ocd47efa9be33 = ocd47efa9be32;
                                                                                                            }
                                                                                                            if (n != 0) break block72;
                                                                                                            if (ocd47efa9be33.isCanceled()) return;
                                                                                                            ocd47efa9be33 = ocd47efa9be32;
                                                                                                        }
                                                                                                        if (n != 0) break block73;
                                                                                                        if (ocd47efa9be33.\u03ca instanceof EntityPlayer) break block74;
                                                                                                        return;
                                                                                                    }
                                                                                                    ocd47efa9be33 = ocd47efa9be32;
                                                                                                }
                                                                                                entityPlayer = (EntityPlayer)ocd47efa9be33.\u03ca;
                                                                                                entityPlayer2 = entityPlayer;
                                                                                                if (n != 0) break block75;
                                                                                                if (oca4f99d2d44.\u039b(entityPlayer2)) return;
                                                                                                entityPlayer2 = entityPlayer;
                                                                                            }
                                                                                            if (n != 0) break block76;
                                                                                            if (!entityPlayer2.isDead) break block77;
                                                                                            return;
                                                                                        }
                                                                                        entityPlayer2 = entityPlayer;
                                                                                    }
                                                                                    if (entityPlayer2.hurtResistantTime > (0x9ACFA273 ^ 0x9ACFA279)) {
                                                                                        return;
                                                                                    }
                                                                                    ocdd342096f83 = oc9755810e45.\u00ff;
                                                                                    ocdd342096f82 = ocdd342096f83;
                                                                                    if (n != 0) break block78;
                                                                                    if (ocdd342096f82 == null) break block79;
                                                                                    ocdd342096f82 = ocdd342096f83;
                                                                                }
                                                                                if (n != 0) break block80;
                                                                                if (!ocdd342096f82.z$3rzb3dil7uydr()) break block79;
                                                                                ocdd342096f82 = ocdd342096f83;
                                                                            }
                                                                            d3 = ocdd342096f82.Q().\u04c1();
                                                                            break block96;
                                                                        }
                                                                        d3 = 3.0;
                                                                    }
                                                                    d2 = d3;
                                                                    occ39d36078d2 = oc9755810e45.G;
                                                                    if (n != 0) break block81;
                                                                    if (occ39d36078d2 == null) break block82;
                                                                    occ39d36078d2 = oc9755810e45.G;
                                                                    if (n != 0) break block83;
                                                                }
                                                                if (!occ39d36078d2.z$3rzb3dil7uydr()) break block82;
                                                                occ39d36078d2 = oc9755810e45.G;
                                                            }
                                                            bl6 = occ39d36078d2.\u0518();
                                                            if (n != 0) break block84;
                                                            if (!bl6) break block82;
                                                            bl6 = true;
                                                            break block84;
                                                        }
                                                        bl6 = false;
                                                    }
                                                    bl3 = bl6;
                                                    bl5 = this.\u0498.\u01ed();
                                                    if (n != 0) break block85;
                                                    if (!bl5) break block86;
                                                    bl5 = bl3;
                                                }
                                                if (bl5) {
                                                    return;
                                                }
                                            }
                                            d = oc75d51ec7eb.\u016c(entityPlayer);
                                            oc51fb428ba02 = oc9755810e45.\u03ce;
                                            if (n != 0) break block87;
                                            if (oc51fb428ba02 == null) break block88;
                                            oc51fb428ba02 = oc9755810e45.\u03ce;
                                            if (n != 0) break block89;
                                        }
                                        if (!oc51fb428ba02.z$3rzb3dil7uydr()) break block88;
                                        oc51fb428ba02 = oc9755810e45.\u03ce;
                                    }
                                    bl4 = oc51fb428ba02.\u01fe();
                                    if (n != 0) break block90;
                                    if (bl4) break block91;
                                    bl4 = oc9755810e45.\u03ce.\u0561(0x788F9538082B0AD0L ^ 0x788F9538082B09F0L);
                                    if (n != 0) break block90;
                                    if (!bl4) break block88;
                                }
                                bl4 = true;
                                break block90;
                            }
                            bl4 = false;
                        }
                        bl2 = bl4;
                        oc3c7a892f2f2 = oc9755810e45.\u053a;
                        if (n != 0) break block92;
                        if (oc3c7a892f2f2 == null) break block93;
                        oc3c7a892f2f2 = oc9755810e45.\u053a;
                        if (n != 0) break block94;
                    }
                    if (!oc3c7a892f2f2.z$3rzb3dil7uydr()) break block93;
                    oc3c7a892f2f2 = oc9755810e45.\u053a;
                }
                bl = oc3c7a892f2f2.\u023c();
                if (n != 0) break block95;
                if (!bl) break block93;
                bl = true;
                break block95;
            }
            bl = false;
        }
        boolean bl8 = bl;
        this.\u02ad.put(entityPlayer.getEntityId(), new ocd3dd601cf7(entityPlayer.getEntityId(), d, d2, bl2, bl8, bl3, System.currentTimeMillis()));
    }

    @oc66fa4f2195
    public void \u0228(oc2f61de30bc oc2f61de30bc2) {
        boolean bl;
        block5: {
            block6: {
                int n = oc89eb238246.\u0127;
                bl = oc7ab2161b9f.\u00d0();
                if (n != 0) break block5;
                if (bl) break block6;
                this.\u02ad.clear();
                return;
            }
            bl = this.\u02ad.isEmpty();
        }
        if (!bl) {
            long l = System.currentTimeMillis();
            this.\u02ad.entrySet().removeIf(entry -> {
                int n;
                block20: {
                    block19: {
                        Minecraft minecraft;
                        int n2;
                        ocd3dd601cf7 ocd3dd601cf72;
                        block18: {
                            block17: {
                                long l2;
                                block16: {
                                    ocd3dd601cf72 = (ocd3dd601cf7)entry.getValue();
                                    n2 = oc89eb238246.\u0127;
                                    long l3 = l - ocd3dd601cf72.\u00dc - (0x80164EA9D099F592L ^ 0x80164EA9D099F67AL);
                                    l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                                    if (n2 != 0) break block16;
                                    if (l2 <= 0) break block17;
                                    l2 = 1;
                                }
                                return (boolean)l2;
                            }
                            minecraft = oc69da1aa7f5.\u0151;
                            if (n2 != 0) break block18;
                            if (minecraft.theWorld == null) break block19;
                            minecraft = oc69da1aa7f5.\u0151;
                        }
                        Entity entity = minecraft.theWorld.getEntityByID(ocd3dd601cf72.\u021a);
                        n = entity instanceof EntityLivingBase;
                        if (n2 != 0) break block20;
                        if (n == 0) break block19;
                        EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
                        n = entityLivingBase.hurtTime;
                        if (n2 != 0) break block20;
                        if (n <= 0) break block19;
                        n = entityLivingBase.hurtResistantTime;
                        if (n2 != 0) break block20;
                        if (n < entityLivingBase.maxHurtResistantTime - 1) break block19;
                        this.\u01a4(ocd3dd601cf72);
                        return true;
                    }
                    n = 0;
                }
                return n != 0;
            });
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST, receiveCanceled=true)
    public void \u04c2(oc9d4393f3ce oc9d4393f3ce2) {
        block39: {
            int n;
            Packet<INetHandlerPlayServer> packet;
            Packet<?> packet2;
            block41: {
                int n2;
                block40: {
                    block38: {
                        block36: {
                            occ2f8dff8d8 occ2f8dff8d82;
                            block34: {
                                block35: {
                                    oc748fdbd6c0 oc748fdbd6c02;
                                    block37: {
                                        boolean bl;
                                        block33: {
                                            V v;
                                            block31: {
                                                block32: {
                                                    packet2 = oc9d4393f3ce2.\u025f();
                                                    n2 = oc89eb238246.\u0127;
                                                    v = this;
                                                    if (n2 != 0) break block31;
                                                    if (!v.\u0373.\u01ed()) break block32;
                                                    bl = packet2 instanceof C0FPacketConfirmTransaction;
                                                    if (n2 != 0) break block33;
                                                    if (!bl) break block32;
                                                    packet = (C0FPacketConfirmTransaction)packet2;
                                                    boolean bl2 = oc9d4393f3ce2.isCanceled();
                                                    short s = ((C0FPacketConfirmTransaction)packet).getUid();
                                                    int n3 = ((C0FPacketConfirmTransaction)packet).getWindowId();
                                                    this.\u03dd("Transaction C0F window=" + n3 + " uid=" + s + " canceled=" + bl2);
                                                }
                                                v = this;
                                            }
                                            occ2f8dff8d82 = v.\u0159;
                                            if (n2 != 0) break block34;
                                            bl = occ2f8dff8d82.\u01ed();
                                        }
                                        if (!bl) break block35;
                                        n = oc9d4393f3ce2.isCanceled();
                                        if (n2 != 0) break block36;
                                        if (n == 0) break block35;
                                        oc748fdbd6c02 = oc9755810e45.\u054f;
                                        if (n2 != 0) break block37;
                                        if (oc748fdbd6c02 == null) break block35;
                                        oc748fdbd6c02 = oc9755810e45.\u054f;
                                    }
                                    n = oc748fdbd6c02.z$3rzb3dil7uydr() ? 1 : 0;
                                    if (n2 != 0) break block36;
                                    if (n == 0) break block35;
                                    this.\u03dd("Blink buffered " + packet2.getClass().getSimpleName());
                                }
                                occ2f8dff8d82 = this.\u0538;
                            }
                            n = occ2f8dff8d82.\u01ed();
                        }
                        if (n2 != 0) break block38;
                        if (n == 0) break block39;
                        n = packet2 instanceof C03PacketPlayer;
                    }
                    if (n2 != 0) break block40;
                    if (n == 0) break block39;
                    n = oc7ab2161b9f.\u00d0();
                }
                if (n2 != 0) break block41;
                if (n == 0) break block39;
                n = this.\u02ae;
            }
            if (n != oc69da1aa7f5.\u0151.thePlayer.ticksExisted) {
                packet = (C03PacketPlayer)packet2;
                this.\u02ae = oc69da1aa7f5.\u0151.thePlayer.ticksExisted;
                boolean bl = ((C03PacketPlayer)packet).isMoving();
                boolean bl3 = ((C03PacketPlayer)packet).isOnGround();
                String string = this.\u01b3(oc69da1aa7f5.\u0151.thePlayer.motionZ);
                String string2 = this.\u01b3(oc69da1aa7f5.\u0151.thePlayer.motionY);
                String string3 = this.\u01b3(oc69da1aa7f5.\u0151.thePlayer.motionX);
                this.\u03dd("Motion x=" + string3 + " y=" + string2 + " z=" + string + " ground=" + bl3 + " moving=" + bl);
            }
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST, receiveCanceled=true)
    public void \u0393(oce79181588d oce79181588d2) {
        Object object;
        Object object2;
        int n;
        block87: {
            Object object3;
            block88: {
                Packet<INetHandlerPlayClient> packet;
                block85: {
                    Packet<INetHandlerPlayClient> packet2;
                    block86: {
                        Packet<?> packet3;
                        block83: {
                            Packet<?> packet4;
                            block84: {
                                block82: {
                                    byte by;
                                    block80: {
                                        block81: {
                                            block78: {
                                                block79: {
                                                    block77: {
                                                        block73: {
                                                            V v;
                                                            block75: {
                                                                block74: {
                                                                    Object object4;
                                                                    block76: {
                                                                        block70: {
                                                                            Packet<?> packet5;
                                                                            block72: {
                                                                                block71: {
                                                                                    block69: {
                                                                                        occ2f8dff8d8 occ2f8dff8d82;
                                                                                        block67: {
                                                                                            block68: {
                                                                                                packet4 = oce79181588d2.\u04a0();
                                                                                                n = oc89eb238246.\u0127;
                                                                                                occ2f8dff8d82 = this.\u0103;
                                                                                                if (n != 0) break block67;
                                                                                                if (!occ2f8dff8d82.\u01ed()) break block68;
                                                                                                by = packet4 instanceof S02PacketChat;
                                                                                                if (n != 0) break block69;
                                                                                                if (by == 0) break block68;
                                                                                                this.\u03dd("Server chat: " + ((S02PacketChat)packet4).getChatComponent().getUnformattedText());
                                                                                            }
                                                                                            occ2f8dff8d82 = this.\u0373;
                                                                                        }
                                                                                        by = occ2f8dff8d82.\u01ed();
                                                                                    }
                                                                                    if (n != 0) break block70;
                                                                                    if (by == 0) break block71;
                                                                                    packet5 = packet4;
                                                                                    if (n != 0) break block72;
                                                                                    if (!(packet5 instanceof S32PacketConfirmTransaction)) break block71;
                                                                                    packet2 = (S32PacketConfirmTransaction)packet4;
                                                                                    boolean bl = oce79181588d2.isCanceled();
                                                                                    boolean bl2 = ((S32PacketConfirmTransaction)packet2).func_148888_e();
                                                                                    short s = ((S32PacketConfirmTransaction)packet2).getActionNumber();
                                                                                    int n2 = ((S32PacketConfirmTransaction)packet2).getWindowId();
                                                                                    this.\u03dd("Transaction S32 window=" + n2 + " action=" + s + " accepted=" + bl2 + " canceled=" + bl);
                                                                                }
                                                                                packet5 = packet4;
                                                                            }
                                                                            by = packet5 instanceof S19PacketEntityStatus;
                                                                        }
                                                                        if (n != 0) break block73;
                                                                        if (by == 0) break block74;
                                                                        v = this;
                                                                        if (n != 0) break block75;
                                                                        if (v.\u02ad.isEmpty()) break block74;
                                                                        if (oc69da1aa7f5.\u0151.theWorld == null) break block74;
                                                                        packet2 = (S19PacketEntityStatus)packet4;
                                                                        by = ((S19PacketEntityStatus)packet2).getOpCode();
                                                                        if (n != 0) break block73;
                                                                        if (by != (0x719B8FA5 ^ 0x719B8FA7)) break block74;
                                                                        object3 = ((S19PacketEntityStatus)packet2).getEntity(oc69da1aa7f5.\u0151.theWorld);
                                                                        object4 = object3;
                                                                        if (n != 0) break block76;
                                                                        if (object4 == null) break block74;
                                                                        v = this;
                                                                        if (n != 0) break block75;
                                                                        object4 = v.\u02ad.remove(((Entity)object3).getEntityId());
                                                                    }
                                                                    object2 = (ocd3dd601cf7)object4;
                                                                    if (object2 == null) break block74;
                                                                    long l = System.currentTimeMillis() - ((ocd3dd601cf7)object2).\u00dc - (0xEC83361E47D05A9BL ^ 0xEC83361E47D05973L);
                                                                    by = (byte)(l == 0L ? 0 : (l < 0L ? -1 : 1));
                                                                    if (n != 0) break block73;
                                                                    if (by > 0) break block74;
                                                                    this.\u01a4((ocd3dd601cf7)object2);
                                                                }
                                                                v = this;
                                                            }
                                                            by = v.\u0386.\u01ed();
                                                        }
                                                        if (n != 0) break block77;
                                                        if (by == 0) break block78;
                                                        by = oce79181588d2.isCanceled();
                                                    }
                                                    if (n != 0) break block79;
                                                    if (by != 0) break block78;
                                                    by = oc7ab2161b9f.\u00d0();
                                                }
                                                if (n != 0) break block80;
                                                if (by != 0) break block81;
                                            }
                                            return;
                                        }
                                        packet3 = packet4;
                                        if (n != 0) break block82;
                                        by = packet3 instanceof S06PacketUpdateHealth;
                                    }
                                    if (by != 0) {
                                        this.\u04c6(((S06PacketUpdateHealth)packet4).getHealth() - oc69da1aa7f5.\u0151.thePlayer.getHealth());
                                        return;
                                    }
                                    packet3 = packet4;
                                }
                                if (n != 0) break block83;
                                if (packet3 instanceof S1CPacketEntityMetadata) break block84;
                                return;
                            }
                            packet3 = packet4;
                        }
                        packet2 = (S1CPacketEntityMetadata)packet3;
                        packet = packet2;
                        if (n != 0) break block85;
                        if (((S1CPacketEntityMetadata)packet).getEntityId() == oc69da1aa7f5.\u0151.thePlayer.getEntityId()) break block86;
                        return;
                    }
                    packet = packet2;
                }
                object3 = ((S1CPacketEntityMetadata)packet).func_149376_c();
                object = object3;
                if (n != 0) break block87;
                if (object != null) break block88;
                return;
            }
            object = object3;
        }
        object2 = object.iterator();
        while (object2.hasNext()) {
            block90: {
                Object object5;
                DataWatcher.WatchableObject watchableObject;
                block89: {
                    watchableObject = object2.next();
                    object5 = watchableObject;
                    if (n != 0) break block89;
                    if (((DataWatcher.WatchableObject)object5).getDataValueId() != (0x719B8FA1 ^ 0x719B8FA7)) break block90;
                    object5 = watchableObject.getObject();
                }
                if (object5 instanceof Number) {
                    this.\u04c6(((Number)watchableObject.getObject()).floatValue() - oc69da1aa7f5.\u0151.thePlayer.getHealth());
                    return;
                }
            }
            if (n == 0) continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void \u04c6(float f) {
        V v;
        block12: {
            float f2;
            block11: {
                int n = oc89eb238246.\u0127;
                float f3 = f - 0.0f;
                f2 = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                if (n != 0) break block11;
                if (f2 == false) return;
                v = this;
                if (n != 0) break block12;
                f2 = v.\u0390;
            }
            if (f2 == oc69da1aa7f5.\u0151.thePlayer.ticksExisted) {
                return;
            }
            this.\u0390 = oc69da1aa7f5.\u0151.thePlayer.ticksExisted;
            v = this;
        }
        String string = f > 0.0f ? "&a&l" : "&c&l";
        int n = oc69da1aa7f5.\u0151.thePlayer.ticksExisted;
        String string2 = \u0201.format(f);
        String string3 = string;
        v.\u03dd("Health: " + string3 + string2 + "&r &f(&otick: " + n + "&r&f)");
    }

    private String \u01b3(double d) {
        return String.format(Locale.ROOT, "%.4f", d);
    }

    private void \u03dd(String string) {
        oc7ab2161b9f.\u00fd("&7[&dDebug&7] &f" + string);
    }

    private void \u01a4(ocd3dd601cf7 ocd3dd601cf72) {
        V v;
        StringBuilder stringBuilder;
        block17: {
            occ2f8dff8d8 occ2f8dff8d82;
            block15: {
                int n;
                block16: {
                    V v2;
                    block13: {
                        block14: {
                            stringBuilder = new StringBuilder("AttackRange ").append(this.\u01b3(ocd3dd601cf72.\u0577)).append(" / ").append(this.\u01b3(ocd3dd601cf72.\u011d));
                            n = oc89eb238246.\u0127;
                            v2 = this;
                            if (n != 0) break block13;
                            if (!v2.\u0239.\u01ed()) break block14;
                            stringBuilder.append(" | TimerRange=").append(ocd3dd601cf72.\u0194);
                        }
                        v2 = this;
                    }
                    occ2f8dff8d82 = v2.\u045d;
                    if (n != 0) break block15;
                    if (!occ2f8dff8d82.\u01ed()) break block16;
                    stringBuilder.append(" | LagRange=").append(ocd3dd601cf72.\u0527);
                }
                v = this;
                if (n != 0) break block17;
                occ2f8dff8d82 = v.\u04b1;
            }
            if (occ2f8dff8d82.\u01ed()) {
                stringBuilder.append(" | Backtrack=").append(ocd3dd601cf72.\u056d);
            }
            v = this;
        }
        v.\u03dd(stringBuilder.toString());
    }
}

