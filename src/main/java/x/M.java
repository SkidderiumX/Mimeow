/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.BlockPos;
import x.oc78dc1256b9;
import x.oc7b822110db;
import x.ocbce5ea28a3;

public class M {
    final oc7b822110db \u020e;
    final oc78dc1256b9 \u03b4;
    final List<BlockPos> \u01ba;
    final int \u018e;
    final int \u012e;
    final boolean \u03d3;

    private M(oc7b822110db oc7b822110db2, oc78dc1256b9 oc78dc1256b92, List<BlockPos> list, boolean bl) {
        this.\u020e = oc7b822110db2 == null ? null : oc7b822110db2.\u04d9();
        this.\u03b4 = oc78dc1256b92;
        this.\u01ba = list;
        this.\u018e = ocbce5ea28a3.\u01e1(list == null ? 0 : list.size());
        this.\u012e = ocbce5ea28a3.\u0474(list == null ? 0 : list.size());
        this.\u03d3 = bl;
    }

    static M \u0149(oc7b822110db oc7b822110db2, oc78dc1256b9 oc78dc1256b92, List<BlockPos> list) {
        return new M(oc7b822110db2, oc78dc1256b92, new ArrayList<BlockPos>(list), true);
    }

    static M \u03f2(oc7b822110db oc7b822110db2, oc78dc1256b9 oc78dc1256b92) {
        return new M(oc7b822110db2, oc78dc1256b92, new ArrayList<BlockPos>(), false);
    }
}

