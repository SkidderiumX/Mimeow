/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

public class RealmsWorldResetDto {
    private String seed;
    private long worldTemplateId;
    private int levelType;
    private boolean generateStructures;

    public RealmsWorldResetDto(String string, long l, int n, boolean bl) {
        this.seed = string;
        this.worldTemplateId = l;
        this.levelType = n;
        this.generateStructures = bl;
    }
}

