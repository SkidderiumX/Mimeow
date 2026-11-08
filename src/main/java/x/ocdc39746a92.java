/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.oc556c764ca6;

public class ocdc39746a92 {
    public final int \u02b6;
    public final int \u0167;
    public final List<oc556c764ca6> \u046a = new ArrayList<oc556c764ca6>();

    public ocdc39746a92(int n, int n2) {
        this.\u02b6 = n;
        this.\u0167 = n2;
        this.\u046a.add(new oc556c764ca6(0, 0, n));
    }

    public int[] \u0262(int n, int n2) {
        int n3;
        int n4;
        oc556c764ca6 oc556c764ca62;
        int n5;
        int n6 = this.\u046a.size();
        int n7 = -1;
        int n8 = -1;
        int n9 = -1;
        int n10 = this.\u0167;
        int n11 = this.\u02b6;
        for (n5 = 0; n5 < n6; ++n5) {
            int n12;
            oc556c764ca6 oc556c764ca63;
            oc556c764ca62 = this.\u046a.get(n5);
            short s = oc556c764ca62.\u051a;
            if (n + s > this.\u02b6) continue;
            n4 = oc556c764ca62.\u039e;
            int n13 = n5;
            boolean bl = true;
            for (n3 = n; n3 > 0; n3 -= oc556c764ca63.\u04c7) {
                if (n13 >= n6) {
                    bl = false;
                    break;
                }
                oc556c764ca63 = this.\u046a.get(n13++);
                if ((n4 = Math.max(n4, oc556c764ca63.\u039e)) + n2 <= this.\u0167) continue;
                bl = false;
                break;
            }
            if (!bl || n4 == -1 || (n12 = n4 + n2) >= n10 && (n12 != n10 || oc556c764ca62.\u04c7 >= n11)) continue;
            n7 = n5;
            n8 = s;
            n9 = n4;
            n10 = n12;
            n11 = oc556c764ca62.\u04c7;
        }
        if (n7 == -1) {
            return null;
        }
        this.\u046a.add(n7, new oc556c764ca6(n8, n9 + n2, n));
        n5 = n7 + 1;
        while (n5 < this.\u046a.size()) {
            oc556c764ca62 = this.\u046a.get(n5 - 1);
            oc556c764ca6 oc556c764ca64 = this.\u046a.get(n5);
            n4 = oc556c764ca62.\u051a + oc556c764ca62.\u04c7;
            n3 = oc556c764ca64.\u051a;
            if (n4 <= n3) break;
            oc556c764ca64.\u051a = (short)n4;
            oc556c764ca64.\u04c7 = (short)(n3 - n4 + oc556c764ca64.\u04c7);
            if (oc556c764ca64.\u04c7 > 0) break;
            this.\u046a.remove(n5);
        }
        int n14 = 0;
        while (n14 < this.\u046a.size() - 1) {
            oc556c764ca6 oc556c764ca65 = this.\u046a.get(n14);
            oc556c764ca6 oc556c764ca66 = this.\u046a.get(n14 + 1);
            if (oc556c764ca65.\u039e != oc556c764ca66.\u039e) {
                ++n14;
                continue;
            }
            oc556c764ca65.\u04c7 = (short)(oc556c764ca65.\u04c7 + oc556c764ca66.\u04c7);
            this.\u046a.remove(n14 + 1);
        }
        int[] nArray = new int[0x7814D41E ^ 0x7814D41C];
        nArray[0] = n8;
        nArray[1] = n9;
        return nArray;
    }
}

