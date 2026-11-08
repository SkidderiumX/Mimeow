/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.server.S14PacketEntity;
import x.oc053077e19a;

public class ocaf819336d8
extends oc053077e19a {
    public int \u0400;
    public byte \u04bb;
    public byte \u04a6;
    public byte \u0537;
    public byte \u0472;
    public byte \u024e;
    public boolean \u0138;
    public boolean \u00e1;
    public static boolean \u044e;

    public ocaf819336d8(S14PacketEntity s14PacketEntity) {
        super(s14PacketEntity);
    }

    public ocaf819336d8(int n, byte by, byte by2, byte by3, byte by4, byte by5, boolean bl) {
        super(null);
        this.\u0400 = n;
        this.\u04bb = by;
        this.\u04a6 = by2;
        this.\u0537 = by3;
        this.\u0472 = by4;
        this.\u024e = by5;
        this.\u0138 = bl;
        this.\u00e1 = true;
    }

    public ocaf819336d8(int n, byte by, byte by2, byte by3, boolean bl) {
        this(n, by, by2, by3, 0, 0, bl);
        this.\u00e1 = false;
    }

    public ocaf819336d8(int n, byte by, byte by2, boolean bl) {
        this(n, by, by2, 0, bl);
    }
}

