/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import x.oc69da1aa7f5;
import x.occc82079da8;

public class oc06c9105cec {
    private static final Field \u0372 = occc82079da8.\u00d0(KeyBinding.class, "pressTime");
    public static boolean \u04ec;

    private oc06c9105cec() {
    }

    public static void \u0266(KeyBinding keyBinding) {
        int n = oc69da1aa7f5.\u04f5;
        try {
            \u0372.setInt(keyBinding, \u0372.getInt(keyBinding) + 1);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
        if (false) {
            oc69da1aa7f5.\u04f5 = ++n;
        }
    }

    public static boolean \u04b2(ItemStack itemStack) {
        int n;
        block18: {
            block17: {
                Block block;
                int n2;
                block16: {
                    Item item;
                    block14: {
                        Item item2;
                        block15: {
                            ItemStack itemStack2;
                            block12: {
                                block13: {
                                    n2 = oc69da1aa7f5.\u04f5;
                                    itemStack2 = itemStack;
                                    if (n2 != 0) break block12;
                                    if (itemStack2 != null) break block13;
                                    return false;
                                }
                                itemStack2 = itemStack;
                            }
                            item2 = itemStack2.getItem();
                            item = item2;
                            if (n2 != 0) break block14;
                            if (item != null) break block15;
                            return false;
                        }
                        item = item2;
                    }
                    Block block2 = Block.getBlockFromItem(item);
                    block = block2;
                    if (n2 != 0) break block16;
                    if (block == null) break block17;
                    block = block2;
                }
                n = Block.getIdFromBlock(block);
                if (n2 != 0) break block18;
                if (n == 0) break block17;
                n = 1;
                break block18;
            }
            n = 0;
        }
        return n != 0;
    }

    public static Vec3 \u023c(MovingObjectPosition movingObjectPosition) {
        Vec3 vec3;
        block4: {
            boolean bl;
            block6: {
                block5: {
                    BlockPos blockPos = movingObjectPosition.getBlockPos();
                    EnumFacing enumFacing = movingObjectPosition.sideHit;
                    int n = oc69da1aa7f5.\u04f5;
                    vec3 = new Vec3((double)blockPos.getX() + (double)enumFacing.getFrontOffsetX(), (double)blockPos.getY() + (double)enumFacing.getFrontOffsetY(), (double)enumFacing.getFrontOffsetZ() + (double)blockPos.getZ());
                    if (n == 0) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return vec3;
    }
}

