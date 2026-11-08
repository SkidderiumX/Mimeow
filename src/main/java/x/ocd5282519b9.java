/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.ChatComponentText;
import x.oc7ab2161b9f;
import x.ocdf3e495c45;

public class ocd5282519b9
implements Runnable {
    final String val$message;
    final ocdf3e495c45 this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    ocd5282519b9(ocdf3e495c45 ocdf3e495c452, String string) {
        this.this$0 = ocdf3e495c452;
        this.val$message = string;
    }

    @Override
    public void run() {
        if (oc7ab2161b9f.\u00d0()) {
            this.this$0.\u022b.thePlayer.addChatMessage(new ChatComponentText(this.val$message));
        }
    }
}

