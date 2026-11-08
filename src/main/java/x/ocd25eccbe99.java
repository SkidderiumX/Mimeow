/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc5ea809bee2;
import x.ocab1e1d632b;

public class ocd25eccbe99
implements Runnable {
    final ocab1e1d632b val$page;
    final oc5ea809bee2 this$1;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    ocd25eccbe99(oc5ea809bee2 oc5ea809bee22, ocab1e1d632b ocab1e1d632b2) {
        this.this$1 = oc5ea809bee22;
        this.val$page = ocab1e1d632b2;
    }

    @Override
    public void run() {
        this.this$1.this$0.\u03cc(this.this$1.val$generation, this.this$1.val$append, this.val$page);
    }
}

