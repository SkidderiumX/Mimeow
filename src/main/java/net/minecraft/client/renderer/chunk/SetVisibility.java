/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.chunk;

import java.util.Set;
import net.minecraft.util.EnumFacing;

public class SetVisibility {
    private static final int COUNT_FACES = EnumFacing.values().length;
    private long bits;

    public void setManyVisible(Set<EnumFacing> set) {
        for (EnumFacing enumFacing : set) {
            for (EnumFacing enumFacing2 : set) {
                this.setVisible(enumFacing, enumFacing2, true);
            }
        }
    }

    public void setVisible(EnumFacing enumFacing, EnumFacing enumFacing2, boolean bl) {
        this.setBit(enumFacing.ordinal() + enumFacing2.ordinal() * COUNT_FACES, bl);
        this.setBit(enumFacing2.ordinal() + enumFacing.ordinal() * COUNT_FACES, bl);
    }

    public void setAllVisible(boolean bl) {
        this.bits = bl ? -1L : 0L;
    }

    public boolean isVisible(EnumFacing enumFacing, EnumFacing enumFacing2) {
        return this.getBit(enumFacing.ordinal() + enumFacing2.ordinal() * COUNT_FACES);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(' ');
        for (EnumFacing enumFacing : EnumFacing.values()) {
            stringBuilder.append(' ').append(enumFacing.toString().toUpperCase().charAt(0));
        }
        stringBuilder.append('\n');
        for (EnumFacing enumFacing : EnumFacing.values()) {
            stringBuilder.append(enumFacing.toString().toUpperCase().charAt(0));
            for (EnumFacing enumFacing2 : EnumFacing.values()) {
                if (enumFacing == enumFacing2) {
                    stringBuilder.append("  ");
                    continue;
                }
                boolean bl = this.isVisible(enumFacing, enumFacing2);
                stringBuilder.append(' ').append(bl ? (char)'Y' : 'n');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private boolean getBit(int n) {
        return (this.bits & (long)(1 << n)) != 0L;
    }

    private void setBit(int n, boolean bl) {
        if (bl) {
            this.setBit(n);
        } else {
            this.clearBit(n);
        }
    }

    private void setBit(int n) {
        this.bits |= (long)(1 << n);
    }

    private void clearBit(int n) {
        this.bits &= (long)(~(1 << n));
    }
}

