/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import x.oc4e871be632;
import x.oc95a52a4046;

public class oc6ee405a8e2
implements oc4e871be632 {
    private oc6ee405a8e2() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String z$qwjgoq304pul() throws Exception {
        Transferable transferable;
        block13: {
            Object object;
            int n;
            block11: {
                Transferable transferable2;
                block12: {
                    block10: {
                        transferable2 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
                        n = oc95a52a4046.\u03bd;
                        object = transferable2;
                        if (n != 0) break block10;
                        if (object == null) return "";
                        object = transferable2;
                    }
                    if (n != 0) break block11;
                    if (object.isDataFlavorSupported(DataFlavor.stringFlavor)) break block12;
                    return "";
                }
                object = transferable2.getTransferData(DataFlavor.stringFlavor);
            }
            Transferable transferable3 = object;
            transferable = transferable3;
            if (n != 0) break block13;
            if (!(transferable instanceof String)) return "";
            transferable = transferable3;
        }
        String string = (String)((Object)transferable);
        return string;
    }

    @Override
    public boolean z$1w9fm5zod4yek(String string) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(string), null);
        int n = oc95a52a4046.\u03bd;
        boolean bl = true;
        if (false) {
            oc95a52a4046.\u03bd = ++n;
        }
        return bl;
    }
}

