/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import net.minecraft.src.Config;

public class VillagerProfession {
    private int profession;
    private int[] careers;

    public VillagerProfession(int n) {
        this(n, null);
    }

    public VillagerProfession(int n, int n2) {
        this(n, new int[]{n2});
    }

    public VillagerProfession(int n, int[] nArray) {
        this.profession = n;
        this.careers = nArray;
    }

    public boolean matches(int n, int n2) {
        return this.profession != n ? false : this.careers == null || Config.equalsOne(n2, this.careers);
    }

    private boolean hasCareer(int n) {
        int n2 = 1643081142;
        block5: while (true) {
            switch (n2) {
                default: {
                    throw null;
                }
                case 545773427: {
                    return false;
                }
                case 1643081142: {
                    if (this.careers == null) {
                        n2 = 545773427;
                        continue block5;
                    }
                    n2 = 1803793496;
                    continue block5;
                }
                case 1803793496: 
            }
            break;
        }
        return Config.equalsOne(n, this.careers);
    }

    public boolean addCareer(int n) {
        if (this.careers == null) {
            this.careers = new int[]{n};
            return true;
        }
        if (this.hasCareer(n)) {
            return false;
        }
        this.careers = Config.addIntToArray(this.careers, n);
        return true;
    }

    public int getProfession() {
        return this.profession;
    }

    public int[] getCareers() {
        return this.careers;
    }

    public String toString() {
        return this.careers == null ? "" + this.profession : this.profession + ":" + Config.arrayToString(this.careers);
    }
}

