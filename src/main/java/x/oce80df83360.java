/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import x.oc89e52ca90f;
import x.oce490879787;

public class oce80df83360
implements WebSocket.Listener {
    private final long \u0491;
    private final StringBuilder \u0136;
    private String \u02ab;
    final oc89e52ca90f this$0;

    private oce80df83360(oc89e52ca90f oc89e52ca90f2, long l, String string) {
        this.this$0 = oc89e52ca90f2;
        this.\u0136 = new StringBuilder();
        this.\u0491 = l;
        this.\u02ab = string;
    }

    @Override
    public void onOpen(WebSocket webSocket) {
        oce80df83360 oce80df833602;
        block4: {
            block5: {
                boolean bl = oce490879787.\u0583;
                oce80df833602 = this;
                if (bl) break block4;
                if (oce80df833602.this$0.\u0576(this.\u0491, webSocket)) break block5;
                webSocket.abort();
                return;
            }
            oce80df833602 = this;
        }
        String string = oce80df833602.\u02ab;
        this.\u02ab = "";
        this.this$0.s(this.\u0491, webSocket, string);
        webSocket.request(1L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence charSequence, boolean bl) {
        this.\u0136.append(charSequence);
        boolean bl2 = oce490879787.\u0583;
        int n = this.\u0136.length();
        if (!bl2) {
            if (n > (0xD281716 ^ 0xD285716)) {
                this.this$0.\u044f.z$4rxrffi8xyrb("The IRC service returned an invalid packet.");
                this.this$0.\u0262(this.\u0491, webSocket);
                return null;
            }
            n = bl ? 1 : 0;
        }
        if (n != 0) {
            String string = this.\u0136.toString();
            this.\u0136.setLength(0);
            try {
                this.this$0.\u00cb(this.\u0491, webSocket, string);
            }
            catch (IOException iOException) {
                this.this$0.\u044f.z$4rxrffi8xyrb(iOException.getMessage());
                this.this$0.\u0262(this.\u0491, webSocket);
                return null;
            }
        }
        webSocket.request(1L);
        return null;
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int n, String string) {
        this.this$0.\u0262(this.\u0491, webSocket);
        return null;
    }

    @Override
    public void onError(WebSocket webSocket, Throwable throwable) {
        this.this$0.\u0262(this.\u0491, webSocket);
    }
}

