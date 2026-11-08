/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MovementInput;
import x.oc52918cda9d;
import x.oc70db705765;
import x.ocea775c9d5c;
import x.ocee33618a8d;

public class MovementInputFromOptions
extends MovementInput {
    private final GameSettings gameSettings;

    public MovementInputFromOptions(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public void updatePlayerMoveState() {
        this.moveStrafe = 0.0f;
        this.moveForward = 0.0f;
        if (this.gameSettings.keyBindForward.isKeyDown()) {
            this.moveForward += 1.0f;
        }
        if (this.gameSettings.keyBindBack.isKeyDown()) {
            this.moveForward -= 1.0f;
        }
        if (this.gameSettings.keyBindLeft.isKeyDown()) {
            this.moveStrafe += 1.0f;
        }
        if (this.gameSettings.keyBindRight.isKeyDown()) {
            this.moveStrafe -= 1.0f;
        }
        this.jump = this.gameSettings.keyBindJump.isKeyDown();
        this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
        oc70db705765 oc70db7057652 = new oc70db705765(this.moveForward, this.moveStrafe, this.jump, this.sneak, 0.3);
        ocea775c9d5c.\u0173.post(oc70db7057652);
        double d = oc70db7057652.\u016b();
        this.moveForward = oc70db7057652.\u0509();
        this.moveStrafe = oc70db7057652.\u01f6();
        this.jump = oc70db7057652.\u03e7();
        this.sneak = oc70db7057652.\u04a7();
        if (this.sneak) {
            this.moveStrafe = (float)((double)this.moveStrafe * d);
            this.moveForward = (float)((double)this.moveForward * d);
        }
        this.mimeow$onUpdatePlayerMoveState(new ocee33618a8d("updatePlayerMoveState", false));
    }

    private void mimeow$onUpdatePlayerMoveState(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc52918cda9d());
    }
}

