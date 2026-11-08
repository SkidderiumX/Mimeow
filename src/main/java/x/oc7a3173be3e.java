/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x.oc094a54ecb8;
import x.oc151419fdfe;
import x.oc2cf3d80e17;
import x.occ93a9667d6;

public class oc7a3173be3e
implements occ93a9667d6 {
    @Override
    public List<oc094a54ecb8> z$1cf840poz11vw() throws IOException {
        if (oc2cf3d80e17.\u00c1 == null || oc2cf3d80e17.\u00c1.\u01f9 == null) {
            return Collections.emptyList();
        }
        ArrayList<oc094a54ecb8> arrayList = new ArrayList<oc094a54ecb8>();
        for (oc151419fdfe oc151419fdfe2 : oc2cf3d80e17.\u00c1.\u01f9) {
            File file;
            if (oc151419fdfe2 == null) continue;
            String string = oc151419fdfe2.\u0120();
            long l = 0L;
            if (oc2cf3d80e17.\u00c1.\u044e != null && (file = new File(oc2cf3d80e17.\u00c1.\u044e, string + ".json")).exists()) {
                l = Math.max(0L, (System.currentTimeMillis() - file.lastModified()) / (0x1CF5D51D71B3319CL ^ 0x1CF5D51D71B33274L));
            }
            arrayList.add(new oc094a54ecb8(string, l));
        }
        return arrayList;
    }

    @Override
    public void z$290lade6yz6q7(String string) throws IOException {
        if (oc2cf3d80e17.\u00c1 != null) {
            oc2cf3d80e17.\u00c1.\u0431(string);
        }
    }

    @Override
    public void z$8vfnfg7a8xhb(String string, boolean bl) throws IOException {
        if (oc2cf3d80e17.\u00c1 != null) {
            oc151419fdfe oc151419fdfe2 = oc2cf3d80e17.\u00c1.\u04c7(string);
            if (oc151419fdfe2 != null) {
                oc2cf3d80e17.\u00c1.\u03e6(oc151419fdfe2);
            } else {
                oc2cf3d80e17.\u00c1.\u03c7(string, 0);
            }
        }
    }

    @Override
    public void z$3og0ar4vwp2z4(String string) throws IOException {
        if (oc2cf3d80e17.\u00c1 != null) {
            oc2cf3d80e17.\u00c1.\u014f(string);
        }
    }

    @Override
    public void z$1detxdtpegs8e() throws IOException {
        if (Desktop.isDesktopSupported() && oc2cf3d80e17.\u00c1 != null && oc2cf3d80e17.\u00c1.\u044e != null) {
            Desktop.getDesktop().open(oc2cf3d80e17.\u00c1.\u044e);
        }
    }

    @Override
    public void z$37cgydr40g6cp() throws IOException {
        if (oc2cf3d80e17.\u00c1 != null && oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u00c1.\u03e6(oc2cf3d80e17.\u0115);
        }
    }

    @Override
    public void z$1y8rno1hz6kp0(String string, String string2) throws IOException {
        if (oc2cf3d80e17.\u00c1 == null) {
            throw new IOException("Configuration manager is unavailable.");
        }
        oc151419fdfe oc151419fdfe2 = oc2cf3d80e17.\u00c1.\u04c7(string);
        if (oc151419fdfe2 == null || !oc2cf3d80e17.\u00c1.\u01fd(oc151419fdfe2, string2)) {
            throw new IOException("Could not rename profile: " + string);
        }
    }

    @Override
    public String z$3msju6dffd110() {
        return oc2cf3d80e17.\u0115 != null ? oc2cf3d80e17.\u0115.\u0120() : "default";
    }

    @Override
    public boolean z$3oyopcgywot0z() {
        return false;
    }
}

