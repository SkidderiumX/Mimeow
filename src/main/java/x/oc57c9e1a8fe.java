/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C18PacketSpectate;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.ocd6ae010123;
import x.oce4cea752dd;
import x.ocebec3dfd67;

public class oc57c9e1a8fe
extends oc69da1aa7f5 {
    private final Minecraft i = Minecraft.getMinecraft();
    private final oca9cc61aada \u0390 = new oca9cc61aada("Packets / tick", 3.0, 1.0, 10.0, 1.0);
    private boolean A;
    private float \u02e1 = 120.0f;
    public static int \u024c;

    public oc57c9e1a8fe() {
        super("Troll", oce4cea752dd.\u04a6);
        this.\u028c(this.\u0390);
    }

    @oc66fa4f2195
    public void \u0277(ocebec3dfd67 ocebec3dfd672) {
        int n;
        boolean bl;
        block3: {
            block4: {
                bl = false;
                n = oc7ab2161b9f.\u00d0();
                if (bl) break block3;
                if (n != 0) break block4;
                return;
            }
            n = Math.max(1, (int)this.\u0390.\u04c1());
        }
        int n2 = n;
        for (int i = 0; i < n2; ++i) {
            this.\u04b8();
            this.\u01d6();
            if (!bl) continue;
        }
    }

    private void \u04b8() {
        boolean bl;
        block4: {
            block5: {
                int n = this.i.thePlayer.inventory.currentItem;
                this.\u01e1(new C09PacketHeldItemChange(n));
                this.\u01e1(new C09PacketHeldItemChange(n));
                boolean bl2 = false;
                C0BPacketEntityAction.Action action = this.A ? C0BPacketEntityAction.Action.START_SPRINTING : C0BPacketEntityAction.Action.STOP_SPRINTING;
                C0BPacketEntityAction.Action action2 = action;
                this.\u01e1(new C0BPacketEntityAction(this.i.thePlayer, action2));
                this.\u01e1(new C0BPacketEntityAction(this.i.thePlayer, action2));
                oc57c9e1a8fe oc57c9e1a8fe2 = this;
                bl = this.A;
                if (bl2) break block4;
                if (bl) break block5;
                bl = true;
                break block4;
            }
            bl = false;
        }
        oc57c9e1a8fe2.A = bl;
        this.\u01e1(new C0FPacketConfirmTransaction(0, (short)this.i.thePlayer.ticksExisted, false));
        C13PacketPlayerAbilities c13PacketPlayerAbilities = new C13PacketPlayerAbilities();
        c13PacketPlayerAbilities.setFlying(true);
        this.\u01e1(c13PacketPlayerAbilities);
        this.\u01e1(new C18PacketSpectate(this.i.thePlayer.getUniqueID()));
    }

    private void \u01d6() {
        this.\u02e1 = -this.\u02e1;
        this.\u01e1(new C03PacketPlayer.C05PacketPlayerLook(this.i.thePlayer.rotationYaw, this.\u02e1, this.i.thePlayer.onGround));
        int n = this.i.thePlayer.inventory.currentItem;
        this.\u01e1(new C09PacketHeldItemChange(n));
        this.\u01e1(new C09PacketHeldItemChange(n));
        this.\u01e1(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.UP));
    }

    private void \u01e1(Packet<?> packet) {
        ocd6ae010123.\u0115(packet);
    }
}

