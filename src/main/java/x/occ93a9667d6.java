/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import x.oc094a54ecb8;

public interface occ93a9667d6 {
    public List<oc094a54ecb8> z$1cf840poz11vw() throws IOException;

    default public List<oc094a54ecb8> z$ezjgq66s9xkf() {
        try {
            return this.z$1cf840poz11vw();
        }
        catch (IOException iOException) {
            return Collections.emptyList();
        }
    }

    public void z$290lade6yz6q7(String var1) throws IOException;

    public void z$8vfnfg7a8xhb(String var1, boolean var2) throws IOException;

    public void z$3og0ar4vwp2z4(String var1) throws IOException;

    public void z$1y8rno1hz6kp0(String var1, String var2) throws IOException;

    public void z$1detxdtpegs8e() throws IOException;

    public void z$37cgydr40g6cp() throws IOException;

    public String z$3msju6dffd110();

    public boolean z$3oyopcgywot0z();
}

