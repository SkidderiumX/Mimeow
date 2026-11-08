/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.SpoofChecker;
import com.ibm.icu.text.UnicodeSet;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class IdentifierInfo {
    private static final UnicodeSet ASCII = new UnicodeSet(0, 127).freeze();
    private String identifier;
    private final BitSet requiredScripts = new BitSet();
    private final Set<BitSet> scriptSetSet = new HashSet<BitSet>();
    private final BitSet commonAmongAlternates = new BitSet();
    private final UnicodeSet numerics = new UnicodeSet();
    private final UnicodeSet identifierProfile = new UnicodeSet(0, 0x10FFFF);
    private static final BitSet JAPANESE = IdentifierInfo.set(new BitSet(), 25, 17, 20, 22);
    private static final BitSet CHINESE = IdentifierInfo.set(new BitSet(), 25, 17, 5);
    private static final BitSet KOREAN = IdentifierInfo.set(new BitSet(), 25, 17, 18);
    private static final BitSet CONFUSABLE_WITH_LATIN = IdentifierInfo.set(new BitSet(), 8, 14, 6);
    public static final Comparator<BitSet> BITSET_COMPARATOR = new Comparator<BitSet>(){

        @Override
        public int compare(BitSet bitSet, BitSet bitSet2) {
            int n = bitSet.cardinality() - bitSet2.cardinality();
            if (n != 0) {
                return n;
            }
            int n2 = bitSet.nextSetBit(0);
            int n3 = bitSet2.nextSetBit(0);
            while ((n = n2 - n3) == 0 && n2 > 0) {
                n2 = bitSet.nextSetBit(n2 + 1);
                n3 = bitSet2.nextSetBit(n3 + 1);
            }
            return n;
        }
    };

    private IdentifierInfo clear() {
        this.requiredScripts.clear();
        this.scriptSetSet.clear();
        this.numerics.clear();
        this.commonAmongAlternates.clear();
        return this;
    }

    public IdentifierInfo setIdentifierProfile(UnicodeSet unicodeSet) {
        this.identifierProfile.set(unicodeSet);
        return this;
    }

    public UnicodeSet getIdentifierProfile() {
        return new UnicodeSet(this.identifierProfile);
    }

    public IdentifierInfo setIdentifier(String string) {
        this.identifier = string;
        this.clear();
        BitSet bitSet = new BitSet();
        block4: for (int i = 0; i < string.length(); i += Character.charCount(i)) {
            int n = Character.codePointAt(string, i);
            if (UCharacter.getType(n) == 9) {
                this.numerics.add(n - UCharacter.getNumericValue(n));
            }
            UScript.getScriptExtensions(n, bitSet);
            bitSet.clear(0);
            bitSet.clear(1);
            switch (bitSet.cardinality()) {
                case 0: {
                    continue block4;
                }
                case 1: {
                    this.requiredScripts.or(bitSet);
                    continue block4;
                }
                default: {
                    if (this.requiredScripts.intersects(bitSet) || !this.scriptSetSet.add(bitSet)) continue block4;
                    bitSet = new BitSet();
                }
            }
        }
        if (this.scriptSetSet.size() > 0) {
            this.commonAmongAlternates.set(0, 159);
            Iterator<BitSet> iterator2 = this.scriptSetSet.iterator();
            block5: while (iterator2.hasNext()) {
                BitSet bitSet2 = iterator2.next();
                if (this.requiredScripts.intersects(bitSet2)) {
                    iterator2.remove();
                    continue;
                }
                this.commonAmongAlternates.and(bitSet2);
                for (BitSet bitSet3 : this.scriptSetSet) {
                    if (bitSet2 == bitSet3 || !IdentifierInfo.contains(bitSet2, bitSet3)) continue;
                    iterator2.remove();
                    continue block5;
                }
            }
        }
        if (this.scriptSetSet.size() == 0) {
            this.commonAmongAlternates.clear();
        }
        return this;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public BitSet getScripts() {
        return (BitSet)this.requiredScripts.clone();
    }

    public Set<BitSet> getAlternates() {
        HashSet<BitSet> hashSet = new HashSet<BitSet>();
        for (BitSet bitSet : this.scriptSetSet) {
            hashSet.add((BitSet)bitSet.clone());
        }
        return hashSet;
    }

    public UnicodeSet getNumerics() {
        return new UnicodeSet(this.numerics);
    }

    public BitSet getCommonAmongAlternates() {
        return (BitSet)this.commonAmongAlternates.clone();
    }

    public SpoofChecker.RestrictionLevel getRestrictionLevel() {
        if (!this.identifierProfile.containsAll(this.identifier) || this.getNumerics().size() > 1) {
            return SpoofChecker.RestrictionLevel.UNRESTRICTIVE;
        }
        if (ASCII.containsAll(this.identifier)) {
            return SpoofChecker.RestrictionLevel.ASCII;
        }
        int n = this.requiredScripts.cardinality() + (this.commonAmongAlternates.cardinality() == 0 ? this.scriptSetSet.size() : 1);
        if (n < 2) {
            return SpoofChecker.RestrictionLevel.HIGHLY_RESTRICTIVE;
        }
        if (this.containsWithAlternates(JAPANESE, this.requiredScripts) || this.containsWithAlternates(CHINESE, this.requiredScripts) || this.containsWithAlternates(KOREAN, this.requiredScripts)) {
            return SpoofChecker.RestrictionLevel.HIGHLY_RESTRICTIVE;
        }
        if (n == 2 && this.requiredScripts.get(25) && !this.requiredScripts.intersects(CONFUSABLE_WITH_LATIN)) {
            return SpoofChecker.RestrictionLevel.MODERATELY_RESTRICTIVE;
        }
        return SpoofChecker.RestrictionLevel.MINIMALLY_RESTRICTIVE;
    }

    public int getScriptCount() {
        int n = this.requiredScripts.cardinality() + (this.commonAmongAlternates.cardinality() == 0 ? this.scriptSetSet.size() : 1);
        return n;
    }

    public String toString() {
        return this.identifier + ", " + this.identifierProfile.toPattern(false) + ", " + (Object)((Object)this.getRestrictionLevel()) + ", " + IdentifierInfo.displayScripts(this.requiredScripts) + ", " + IdentifierInfo.displayAlternates(this.scriptSetSet) + ", " + this.numerics.toPattern(false);
    }

    private boolean containsWithAlternates(BitSet bitSet, BitSet bitSet2) {
        if (!IdentifierInfo.contains(bitSet, bitSet2)) {
            return false;
        }
        for (BitSet bitSet3 : this.scriptSetSet) {
            if (bitSet.intersects(bitSet3)) continue;
            return false;
        }
        return true;
    }

    public static String displayAlternates(Set<BitSet> set) {
        if (set.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        TreeSet<BitSet> treeSet = new TreeSet<BitSet>(BITSET_COMPARATOR);
        treeSet.addAll(set);
        for (BitSet bitSet : treeSet) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append("; ");
            }
            stringBuilder.append(IdentifierInfo.displayScripts(bitSet));
        }
        return stringBuilder.toString();
    }

    public static String displayScripts(BitSet bitSet) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = bitSet.nextSetBit(0);
        while (n >= 0) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(UScript.getShortName(n));
            n = bitSet.nextSetBit(n + 1);
        }
        return stringBuilder.toString();
    }

    public static BitSet parseScripts(String string) {
        BitSet bitSet = new BitSet();
        for (String string2 : string.trim().split(",?\\s+")) {
            if (string2.length() == 0) continue;
            bitSet.set(UScript.getCodeFromName(string2));
        }
        return bitSet;
    }

    public static Set<BitSet> parseAlternates(String string) {
        HashSet<BitSet> hashSet = new HashSet<BitSet>();
        for (String string2 : string.trim().split("\\s*;\\s*")) {
            if (string2.length() == 0) continue;
            hashSet.add(IdentifierInfo.parseScripts(string2));
        }
        return hashSet;
    }

    public static final boolean contains(BitSet bitSet, BitSet bitSet2) {
        int n = bitSet2.nextSetBit(0);
        while (n >= 0) {
            if (!bitSet.get(n)) {
                return false;
            }
            n = bitSet2.nextSetBit(n + 1);
        }
        return true;
    }

    public static final BitSet set(BitSet bitSet, int ... nArray) {
        for (int n : nArray) {
            bitSet.set(n);
        }
        return bitSet;
    }
}

