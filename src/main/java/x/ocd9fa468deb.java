/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Date;
import java.util.Locale;
import x.oc099368a591;
import x.oc435d4cde9e;
import x.oc69da1aa7f5;

public class ocd9fa468deb {
    private final long \u040e;
    private final String \u046a;
    private final String \u01ff;
    private final String \u053d;

    private ocd9fa468deb(long l, String string, String string2, String string3) {
        this.\u040e = l;
        this.\u046a = string;
        this.\u01ff = string2;
        this.\u053d = string3;
    }

    public String toString() {
        String string;
        block4: {
            boolean bl;
            block6: {
                block5: {
                    boolean bl2 = oc435d4cde9e.\u04af;
                    Object[] objectArray = new Object[0x90AE5681 ^ 0x90AE5685];
                    objectArray[0] = oc099368a591.\u04b5.format(new Date(this.\u040e));
                    objectArray[1] = this.\u046a;
                    objectArray[0x90AE5687 ^ 0x90AE5685] = this.\u01ff;
                    objectArray[0x90AE5686 ^ 0x90AE5685] = this.\u053d;
                    string = String.format(Locale.ROOT, "[%s] [%s] [%s] %s", objectArray);
                    if (!bl2) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return string;
    }
}

