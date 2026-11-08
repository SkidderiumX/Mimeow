/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import x.oc69da1aa7f5;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc84f20a0bc5;
import x.oca9cc61aada;
import x.ocb23d192a35;
import x.occ2f8dff8d8;
import x.oce4cea752dd;

public class oca8439039be
extends oc69da1aa7f5 {
    private final ocb23d192a35 \u027e;
    private final occ2f8dff8d8 \u0215;
    private final oca9cc61aada \u01b0;
    private final oca9cc61aada \u0242;
    private boolean \u01df = false;
    private long \u0184 = 0L;
    private int \u00e0 = -1;
    private int \u0423 = -1;
    private long \u0575 = 0L;
    public static boolean \u0407;

    public oca8439039be() {
        super("PearlMacro", oce4cea752dd.\u0437);
        this.\u0105("Switches to an ender pearl and throws it.");
        this.\u027e = new ocb23d192a35("Keybind", 0);
        this.\u028c(this.\u027e);
        this.\u0215 = new occ2f8dff8d8("Switch back", true);
        this.\u028c(this.\u0215);
        this.\u01b0 = new oca9cc61aada("Switch delay", "ms", 0.0, 0.0, 300.0, 10.0);
        this.\u028c(this.\u01b0);
        this.\u0242 = new oca9cc61aada("Cooldown", "ms", 250.0, 50.0, 1000.0, 25.0);
        this.\u028c(this.\u0242);
        this.\u026e = true;
    }

    public ocb23d192a35 q() {
        return this.\u027e;
    }

    public occ2f8dff8d8 \u04ab() {
        return this.\u0215;
    }

    public oca9cc61aada \u00c9() {
        return this.\u01b0;
    }

    public oca9cc61aada \u015d() {
        return this.\u0242;
    }

    @Override
    public void onDisable() {
        this.\u01df = false;
        this.\u00e0 = -1;
        this.\u0423 = -1;
        this.\u0575 = 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$1m9j3ewef9s() {
        block32: {
            long l;
            int n;
            block33: {
                oca8439039be oca8439039be2;
                boolean bl;
                block31: {
                    boolean bl2;
                    block26: {
                        block28: {
                            oca8439039be oca8439039be3;
                            block29: {
                                int n2;
                                block30: {
                                    int n3;
                                    block27: {
                                        block25: {
                                            n = oc84f20a0bc5.\u0117;
                                            if (!oc7ab2161b9f.\u00d0()) {
                                                this.\u01df = false;
                                                return;
                                            }
                                            l = System.currentTimeMillis();
                                            n3 = this.\u00e0;
                                            if (n != 0) break block25;
                                            if (n3 == -1) break block26;
                                            long l2 = l - this.\u0575;
                                            n3 = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                                        }
                                        if (n != 0) break block27;
                                        if (n3 < 0) break block26;
                                        oca8439039be3 = this;
                                        if (n != 0) break block28;
                                        n3 = oca8439039be3.\u0423;
                                    }
                                    if (n3 == -1) break block29;
                                    n2 = oc69da1aa7f5.\u0151.thePlayer.inventory.currentItem;
                                    if (n != 0) break block30;
                                    if (n2 != this.\u0423) break block29;
                                    n2 = this.\u00e0;
                                }
                                oc7ab2161b9f.\u0101(n2, true);
                            }
                            this.\u00e0 = -1;
                            oca8439039be3 = this;
                        }
                        oca8439039be3.\u0423 = -1;
                    }
                    if (oc69da1aa7f5.\u0151.currentScreen != null) {
                        this.\u01df = false;
                        return;
                    }
                    bl = bl2 = this.\u027e.\u0190();
                    if (n != 0) break block31;
                    if (!bl) break block32;
                    oca8439039be2 = this;
                    if (n != 0) break block33;
                    bl = oca8439039be2.\u01df;
                }
                if (bl) return;
                oca8439039be2 = this;
            }
            oca8439039be2.\u01df = true;
            if (n == 0) {
                if (l - this.\u0184 < (long)this.\u0242.\u04c1()) return;
                this.\u057e(l);
            }
            if (n == 0) return;
        }
        this.\u01df = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean \u057e(long l) {
        int n;
        int n2;
        int n3;
        block45: {
            block46: {
                Minecraft minecraft;
                block47: {
                    block44: {
                        float f;
                        block43: {
                            block39: {
                                block40: {
                                    block42: {
                                        Minecraft minecraft2;
                                        block41: {
                                            block38: {
                                                float f2;
                                                float f3;
                                                float f4;
                                                block37: {
                                                    n3 = oc84f20a0bc5.\u0117;
                                                    int n4 = oc7ab2161b9f.\u00d0();
                                                    if (n3 == 0) {
                                                        if (n4 == 0) {
                                                            return false;
                                                        }
                                                        n4 = this.\u0553();
                                                    }
                                                    int n5 = n2 = n4;
                                                    if (n3 == 0) {
                                                        if (n5 == -1) {
                                                            return false;
                                                        }
                                                        n5 = oc69da1aa7f5.\u0151.thePlayer.inventory.currentItem;
                                                    }
                                                    n = n5;
                                                    f4 = oc75d51ec7eb.d[0];
                                                    f3 = oc69da1aa7f5.\u0151.thePlayer.rotationYaw;
                                                    if (n3 != 0) break block37;
                                                    if (f4 != f3) break block38;
                                                    f4 = oc75d51ec7eb.d[1];
                                                    f3 = oc69da1aa7f5.\u0151.thePlayer.rotationPitch;
                                                }
                                                f = (f2 = f4 - f3) == 0.0f ? 0 : (f2 > 0.0f ? 1 : -1);
                                                if (n3 != 0) break block39;
                                                if (f == false) break block40;
                                            }
                                            minecraft2 = oc69da1aa7f5.\u0151;
                                            if (n3 != 0) break block41;
                                            if (minecraft2.getNetHandler() == null) break block42;
                                            minecraft2 = oc69da1aa7f5.\u0151;
                                        }
                                        minecraft2.getNetHandler().addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(oc69da1aa7f5.\u0151.thePlayer.rotationYaw, oc69da1aa7f5.\u0151.thePlayer.rotationPitch, oc69da1aa7f5.\u0151.thePlayer.onGround));
                                    }
                                    oc75d51ec7eb.d[0] = oc69da1aa7f5.\u0151.thePlayer.rotationYaw;
                                    oc75d51ec7eb.d[1] = oc69da1aa7f5.\u0151.thePlayer.rotationPitch;
                                }
                                f = n;
                            }
                            if (n3 != 0) break block43;
                            if (f == n2) break block44;
                            f = n2;
                        }
                        oc7ab2161b9f.\u0101((int)f, true);
                    }
                    ItemStack itemStack = oc69da1aa7f5.\u0151.thePlayer.inventory.getStackInSlot(n2);
                    if (n3 != 0) break block45;
                    if (itemStack == null) break block46;
                    minecraft = oc69da1aa7f5.\u0151;
                    if (n3 != 0) break block47;
                    if (minecraft.playerController == null) break block46;
                    oc69da1aa7f5.\u0151.playerController.sendUseItem(oc69da1aa7f5.\u0151.thePlayer, oc69da1aa7f5.\u0151.theWorld, itemStack);
                    minecraft = oc69da1aa7f5.\u0151;
                }
                minecraft.thePlayer.swingItem();
            }
            this.\u0184 = l;
        }
        int n6 = this.\u0215.\u01ed();
        if (n3 != 0) return n6 != 0;
        if (n6 == 0) return 1 != 0;
        n6 = n;
        if (n3 != 0) return n6 != 0;
        if (n6 == n2) return 1 != 0;
        long l2 = (long)this.\u01b0.\u04c1();
        if (n3 == 0) {
            if (l2 <= 0L) {
                oc7ab2161b9f.\u0101(n, true);
                if (n3 == 0) return 1 != 0;
            }
            this.\u00e0 = n;
            this.\u0423 = n2;
        }
        this.\u0575 = l + l2;
        return 1 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int \u0553() {
        Minecraft minecraft;
        int n;
        block14: {
            n = oc84f20a0bc5.\u0117;
            minecraft = oc69da1aa7f5.\u0151;
            if (n != 0) break block14;
            if (minecraft.thePlayer == null) return -1;
            minecraft = oc69da1aa7f5.\u0151;
        }
        if (minecraft.thePlayer.inventory == null) {
            return -1;
        }
        int n2 = 0;
        while (n2 < (0xCFE61935 ^ 0xCFE6193C)) {
            block15: {
                block16: {
                    ItemStack itemStack = oc69da1aa7f5.\u0151.thePlayer.inventory.getStackInSlot(n2);
                    if (n != 0) break block15;
                    if (itemStack == null) break block16;
                    if (itemStack.getItem() != Items.ender_pearl) break block16;
                    return n2;
                }
                ++n2;
            }
            if (n == 0) continue;
        }
        return -1;
    }
}

