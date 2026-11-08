/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.common.base.Predicate;
import net.minecraft.scoreboard.Score;
import x.oc446ce7e211;
import x.oce6044968f8;

public class ocd455364f5a
implements Predicate<Score> {
    final oc446ce7e211 this$0;

    ocd455364f5a(oc446ce7e211 oc446ce7e2112) {
        this.this$0 = oc446ce7e2112;
    }

    public boolean \u01b1(Score score) {
        boolean bl;
        block11: {
            block9: {
                Score score2;
                boolean bl2;
                block10: {
                    block8: {
                        bl2 = oce6044968f8.\u0452;
                        score2 = score;
                        if (bl2) break block8;
                        if (score2 == null) break block9;
                        score2 = score;
                    }
                    if (bl2) break block10;
                    if (score2.getPlayerName() == null) break block9;
                    score2 = score;
                }
                bl = score2.getPlayerName().startsWith("#");
                if (bl2) break block11;
                if (bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }
}

