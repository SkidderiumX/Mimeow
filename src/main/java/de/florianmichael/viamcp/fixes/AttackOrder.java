/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.viamcp.fixes;

import de.florianmichael.viamcp.ViaMCP;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;

public class AttackOrder {
    private AttackOrder() {
    }

    public static void sendConditionalSwing(Minecraft minecraft, MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition != null && movingObjectPosition.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY) {
            minecraft.thePlayer.swingItem();
        }
    }

    public static void sendFixedAttack(Minecraft minecraft, EntityPlayer entityPlayer, Entity entity) {
        if (!ViaMCP.isTargetVersionNewerThanNative()) {
            minecraft.thePlayer.swingItem();
            minecraft.playerController.attackEntity(entityPlayer, entity);
        } else {
            minecraft.playerController.attackEntity(entityPlayer, entity);
            minecraft.thePlayer.swingItem();
        }
    }
}

