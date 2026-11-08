/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

public enum EnumDifficulty {
    PEACEFUL(0, "options.difficulty.peaceful"),
    EASY(1, "options.difficulty.easy"),
    NORMAL(2, "options.difficulty.normal"),
    HARD(3, "options.difficulty.hard");

    private static final EnumDifficulty[] difficultyEnums;
    private final int difficultyId;
    private final String difficultyResourceKey;

    private EnumDifficulty(int n2, String string2) {
        this.difficultyId = n2;
        this.difficultyResourceKey = string2;
    }

    public int getDifficultyId() {
        return this.difficultyId;
    }

    public static EnumDifficulty getDifficultyEnum(int n) {
        return difficultyEnums[n % difficultyEnums.length];
    }

    public String getDifficultyResourceKey() {
        return this.difficultyResourceKey;
    }

    static {
        difficultyEnums = new EnumDifficulty[EnumDifficulty.values().length];
        EnumDifficulty[] enumDifficultyArray = EnumDifficulty.values();
        int n = enumDifficultyArray.length;
        for (int i = 0; i < n; ++i) {
            EnumDifficulty enumDifficulty;
            EnumDifficulty.difficultyEnums[enumDifficulty.difficultyId] = enumDifficulty = enumDifficultyArray[i];
        }
    }
}

