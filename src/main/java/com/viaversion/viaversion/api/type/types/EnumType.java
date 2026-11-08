/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.util.MathUtil;

public class EnumType
extends VarIntType {
    private final String[] names;
    private final Fallback fallback;

    public EnumType(String ... stringArray) {
        this(Fallback.ZERO, stringArray);
    }

    public EnumType(Fallback fallback, String ... stringArray) {
        this.names = stringArray;
        this.fallback = fallback;
    }

    @Override
    public void write(Ops ops, Integer n) {
        Types.STRING.write(ops, this.nameFromId(n));
    }

    public String[] names() {
        return this.names;
    }

    public String nameFromId(int n) {
        if (n < 0 || n >= this.names.length) {
            return switch (this.fallback) {
                default -> throw new IncompatibleClassChangeError();
                case Fallback.ZERO -> this.names[0];
                case Fallback.WRAP -> this.names[Math.floorMod(n, this.names.length)];
                case Fallback.CLAMP -> this.names[MathUtil.clamp(n, 0, this.names.length - 1)];
            };
        }
        return this.names[n];
    }

    public int idFromName(String string) {
        for (int i = 0; i < this.names.length; ++i) {
            if (!this.names[i].equals(string)) continue;
            return i;
        }
        return switch (this.fallback) {
            default -> throw new IncompatibleClassChangeError();
            case Fallback.ZERO -> 0;
            case Fallback.WRAP -> Math.floorMod(string.hashCode(), this.names.length);
            case Fallback.CLAMP -> this.names.length - 1;
        };
    }

    public static enum Fallback {
        ZERO,
        WRAP,
        CLAMP;

    }
}

