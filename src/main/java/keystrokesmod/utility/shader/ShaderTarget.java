/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.utility.shader;

public enum ShaderTarget {
    CLICK_GUI, TARGET_HUD, TARGET_RENDER, NOTIFICATIONS, HUD, POTION_HUD, SCOREBOARD, CHAT, PLAYER_ESP, MOB_ESP, SCRIPT_UI, OTHER_UI;
    private static final ShaderTarget[] $VALUES_REF;











    



    private static /* synthetic */ ShaderTarget[] $VALUES_REF() {
        ShaderTarget[] shaderTargetArray = new ShaderTarget[0x31907E ^ 0x319072];
        shaderTargetArray[0] = CLICK_GUI;
        shaderTargetArray[1] = TARGET_HUD;
        shaderTargetArray[0x319070 ^ 0x319072] = TARGET_RENDER;
        shaderTargetArray[0x319071 ^ 0x319072] = NOTIFICATIONS;
        shaderTargetArray[0x319076 ^ 0x319072] = HUD;
        shaderTargetArray[0x319077 ^ 0x319072] = POTION_HUD;
        shaderTargetArray[0x319074 ^ 0x319072] = SCOREBOARD;
        shaderTargetArray[0x319075 ^ 0x319072] = CHAT;
        shaderTargetArray[0x31907A ^ 0x319072] = PLAYER_ESP;
        shaderTargetArray[0x31907B ^ 0x319072] = MOB_ESP;
        shaderTargetArray[0x319078 ^ 0x319072] = SCRIPT_UI;
        shaderTargetArray[0x319079 ^ 0x319072] = OTHER_UI;
        return shaderTargetArray;
    }

    static {
        $VALUES_REF = ShaderTarget.$VALUES_REF();
    }
}

