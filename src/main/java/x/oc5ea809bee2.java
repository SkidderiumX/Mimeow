/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc19a6b77031;
import x.ocab1e1d632b;
import x.occa0b4185a7;
import x.ocd25eccbe99;

public class oc5ea809bee2
implements Runnable {
    final String val$cursor;
    final int val$generation;
    final boolean val$append;
    final oc19a6b77031 this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc5ea809bee2(oc19a6b77031 oc19a6b770312, String string, int n, boolean bl) {
        this.this$0 = oc19a6b770312;
        this.val$cursor = string;
        this.val$generation = n;
        this.val$append = bl;
    }

    @Override
    public void run() {
        try {
            ocab1e1d632b ocab1e1d632b2 = this.this$0.\u0255.\u0494(this.val$cursor);
            this.this$0.\u017f(new ocd25eccbe99(this, ocab1e1d632b2));
        }
        catch (Exception exception) {
            this.this$0.\u017f(new occa0b4185a7(this, exception));
        }
    }
}

