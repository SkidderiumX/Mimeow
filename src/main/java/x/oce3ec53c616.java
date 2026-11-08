/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import x.oc06c9105cec;
import x.oc6111f05032;
import x.oc69da1aa7f5;
import x.ocb112cc87f6;
import x.ocb683e2d821;
import x.occ9f45b91c4;
import x.ocd5cc9ffddf;
import x.ocdbe3e2d11a;

public class oce3ec53c616
implements ocdbe3e2d11a {
    private final oc6111f05032 \u013e;
    private final oc69da1aa7f5 \u0548;
    public static boolean \u03b0;

    public oce3ec53c616(oc6111f05032 oc6111f050322, oc69da1aa7f5 oc69da1aa7f52) {
        this.\u013e = oc6111f050322;
        this.\u0548 = oc69da1aa7f52;
    }

    @Override
    public boolean z$p6i3bcb8t5uh() {
        return this.\u013e.\u044f();
    }

    @Override
    public boolean z$vgmmp492cg5() {
        return this.\u013e.\u016d().onGround;
    }

    @Override
    public int z$dwcyixy03s00() {
        return this.\u013e.\u016d().hurtTime;
    }

    @Override
    public boolean z$i52wr1yfoyjf() {
        boolean bl = this.\u013e.\u016d().ridingEntity != null;
        return bl;
    }

    @Override
    public boolean z$2ojalhja9cq3r() {
        return occ9f45b91c4.\u0283(this.\u013e.\u0128().gameSettings.keyBindJump);
    }

    @Override
    public Vec3 z$1c8ca6y94mgtt() {
        return new Vec3(this.\u013e.\u016d().posX, this.\u013e.\u016d().posY, this.\u013e.\u016d().posZ);
    }

    @Override
    public Vec3 z$4exa799az0bq() {
        return this.\u013e.\u016d().getPositionEyes((float)ocb112cc87f6.\u03a4(0xBB68F87C ^ 0xBB7C0F0C));
    }

    @Override
    public AxisAlignedBB z$2pl724gm43s41() {
        return this.\u013e.\u016d().getEntityBoundingBox();
    }

    @Override
    public double[] z$1zrbvb85bh35f() {
        double[] dArray = new double[0x9D316734 ^ 0x9D316737];
        dArray[0] = this.\u013e.\u016d().motionX;
        dArray[1] = this.\u013e.\u016d().motionY;
        dArray[0x9D316735 ^ 0x9D316737] = this.\u013e.\u016d().motionZ;
        return dArray;
    }

    @Override
    public float z$1xf6ovtfcxtu7() {
        return this.\u013e.\u016d().rotationYaw;
    }

    @Override
    public float z$uz8x2y9gw6hn() {
        return this.\u013e.\u016d().rotationPitch;
    }

    @Override
    public int z$12f8gxmukeked(int n, int n2, int n3) {
        return Block.getIdFromBlock(this.\u013e.X().getBlockState(new BlockPos(n, n2, n3)).getBlock());
    }

    @Override
    public MovingObjectPosition z$1cc23fdw0ggkd(Vec3 vec3, Vec3 vec32) {
        return this.\u013e.X().rayTraceBlocks(vec3, vec32, false, true, false);
    }

    @Override
    public MovingObjectPosition z$30u6gvw84jfh3() {
        return this.\u013e.\u0128().objectMouseOver;
    }

    @Override
    public boolean z$ibmxubn64qgk() {
        return oc06c9105cec.\u04b2(this.\u013e.\u016d().getHeldItem());
    }

    @Override
    public void z$24bo1slqpbye5(boolean bl, boolean bl2) {
        ocd5cc9ffddf.\u046e(this.\u013e, this.\u0548, bl, bl2);
    }

    @Override
    public void z$1bxnu6aftks87() {
        oc06c9105cec.\u0266(this.\u013e.\u0128().gameSettings.keyBindUseItem);
    }

    @Override
    public void z$45u35xo28vnv() {
        this.\u0548.z$1ca1cmv0s357();
    }

    @Override
    public boolean z$1012j59x2itph(int n) {
        return ocb683e2d821.\u04dc(n);
    }

    @Override
    public boolean z$3164dzk4mkiij() {
        return ocb683e2d821.\u029d();
    }

    @Override
    public float z$25hrtc0z1u5o0() {
        return ocb683e2d821.\u0548();
    }

    @Override
    public float z$1r9jdp0dbez9w() {
        return ocb683e2d821.O();
    }

    @Override
    public float z$3o07r7zdh4hdo() {
        return ocb683e2d821.\u00dc();
    }

    @Override
    public float z$2sabofd6ckohl() {
        return ocb683e2d821.\u026f();
    }

    @Override
    public void z$20kus4uf00ac8(float f, float f2) {
        ocb683e2d821.\u0264(f, f2);
    }

    @Override
    public void z$bi5shdjot3xq(int n) {
        boolean bl;
        KeyBinding keyBinding;
        GameSettings gameSettings;
        block4: {
            block5: {
                gameSettings = this.\u013e.\u0128().gameSettings;
                boolean bl2 = ocd5cc9ffddf.\u0406;
                keyBinding = gameSettings.keyBindBack;
                bl = n;
                if (bl2) break block4;
                if (!bl) break block5;
                bl = true;
                break block4;
            }
            bl = false;
        }
        occ9f45b91c4.L(keyBinding, bl);
        occ9f45b91c4.L(gameSettings.keyBindForward, false);
        occ9f45b91c4.L(gameSettings.keyBindLeft, false);
        occ9f45b91c4.L(gameSettings.keyBindRight, false);
    }

    @Override
    public void z$268zqf4y56y3d() {
        GameSettings gameSettings = this.\u013e.\u0128().gameSettings;
        occ9f45b91c4.\u010e(gameSettings.keyBindBack);
        occ9f45b91c4.\u010e(gameSettings.keyBindForward);
        occ9f45b91c4.\u010e(gameSettings.keyBindLeft);
        occ9f45b91c4.\u010e(gameSettings.keyBindRight);
    }
}

