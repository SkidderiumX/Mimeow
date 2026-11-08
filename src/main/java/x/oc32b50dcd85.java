/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;

public class oc32b50dcd85 {
    public int \u0416;
    public boolean \u0514 = true;
    public final Runnable \u0523;

    public oc32b50dcd85(Runnable runnable2) {
        this.\u0523 = Objects.requireNonNull(runnable2);
    }

    public boolean \u02e4(int n) {
        int n2 = this.\u0416 + (n + (0x5C4206D ^ 0x5C42062) & (0xFA3BDF92 ^ 0x5C42062));
        if (n2 >= (0x5C55763 ^ 0x5C42062)) {
            this.\u0523.run();
            return false;
        }
        this.\u0416 = n2;
        return this.\u0514;
    }
}

