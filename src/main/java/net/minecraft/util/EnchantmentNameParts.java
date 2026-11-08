/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.Random;

public class EnchantmentNameParts {
    private static final EnchantmentNameParts instance = new EnchantmentNameParts();
    private Random rand = new Random();
    private String[] namePartsArray = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale ".split(" ");

    public static EnchantmentNameParts getInstance() {
        return instance;
    }

    public String generateNewRandomName() {
        int n = this.rand.nextInt(2) + 3;
        Object object = "";
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                object = (String)object + " ";
            }
            object = (String)object + this.namePartsArray[this.rand.nextInt(this.namePartsArray.length)];
        }
        return object;
    }

    public void reseedRandomGenerator(long l) {
        this.rand.setSeed(l);
    }
}

