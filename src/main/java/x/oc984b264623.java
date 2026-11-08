/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import keystrokesmod.script.Manager;
import net.minecraft.client.Minecraft;
import x.oc08592ac73b;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc2cf3d80e17;
import x.oc67f8865952;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.oca98caeda20;
import x.ocbd4917c4b1;
import x.oce4cea752dd;
import x.ocf65052963e;

public class oc984b264623 {
    private static final int \u0296 = 300;
    private static final int \u0463 = 32;
    private static final int \u04ee = 16;
    private static final int \u03ed = 52;
    private static final int \u04cd = 14;
    private static final int \u04c9 = 72;
    private static final int \u03db = 56;
    private static final int \u04b0 = 20;
    private static final String \u0120 = "Click to toggle | Right click for settings";
    private final List<oc67f8865952> \u045f = new ArrayList<oc67f8865952>();
    private final oca98caeda20 \u014c = new oca98caeda20("Type a script name...", 0x567FF81F ^ 0x567FF83F);
    private String \u01e5;
    private int \u0169;
    private int \u04a9;
    private int \u0389 = 0x567FF877 ^ 0x567FF83F;
    private int \u0437 = 0x567FF877 ^ 0x567FF83F;
    private int \u012d;
    private float \u0237;

    oc984b264623() {
    }

    void \u0295(int n, int n2) {
        this.\u02ae(n, n2);
        this.\u029f();
    }

    void \u04e2() {
    }

    void \u01e5(int n, int n2, int n3, int n4) {
        this.\u02ae(n3, n4);
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        this.\u01db(n, n2, oc1378bc114d2);
        this.\u014c.\u01da(this.\u0169, 52.0f, this.\u04a9);
        this.\u012d = this.\u0550();
        this.\u0161();
        int n5 = this.\u0437 - this.\u0389;
        ocbd4917c4b1.\u010e(this.\u0169, this.\u0389, this.\u04a9, n5);
        int n6 = this.\u0389 - Math.round(this.\u0237);
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            oc67f88659522.\u0214(this.\u0169, n6, this.\u04a9);
            oc67f88659522.\u0376(n, n2);
            n6 += oc67f88659522.\u04b8();
        }
        ocbd4917c4b1.\u01df();
        String string = this.\u045f.isEmpty() ? "No scripts found" : (this.\u01e5 != null ? this.\u01e5 : "Click to toggle | Right click for settings");
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(string, oc1378bc114d2, this.\u04a9), this.\u0169 + (this.\u04a9 - oc1378bc114d2.z$toz8pt08w0nc(string)) / (0x1604852E ^ 0x1604852C), this.\u0437 + (0x16048524 ^ 0x1604852C), 0xE99A1BB2 ^ 0x1604852C, true);
    }

    private void \u01db(int n, int n2, oc1378bc114d oc1378bc114d2) {
        String[] stringArray = new String[0x44BF6C8B ^ 0x44BF6C8E];
        stringArray[0] = "Create";
        stringArray[1] = "Edit";
        stringArray[0x44BF6C8C ^ 0x44BF6C8E] = "Load";
        stringArray[0x44BF6C8D ^ 0x44BF6C8E] = "Folder";
        stringArray[0x44BF6C8A ^ 0x44BF6C8E] = "Docs";
        String[] stringArray2 = stringArray;
        int n3 = 0x44BF6C8A ^ 0x44BF6C8E;
        int n4 = (this.\u04a9 - n3 * (stringArray2.length - 1)) / stringArray2.length;
        int n5 = 0x44BF6CAE ^ 0x44BF6C8E;
        int n6 = 0x44BF6C9E ^ 0x44BF6C8E;
        for (int i = 0; i < stringArray2.length; ++i) {
            int n7 = this.\u0169 + i * (n4 + n3);
            boolean bl = oc255ab955c3.\u050e(n7, n5, n4, n6, n, n2);
            ocbd4917c4b1.\u04da(n7, n5, n7 + n4, n5 + n6, 3.0f, bl ? 0xD2A67597 ^ 0x44BF6C8E : oc255ab955c3.\u0515(0xBBA67597 ^ 0x44BF6C8E, 0x44BF6C65 ^ 0x44BF6C8E));
            int n8 = bl ? -1 : 0xBB21F210 ^ 0x44BF6C8E;
            oc1378bc114d2.z$ao2ykh4tuw6w(stringArray2[i], n7 + (n4 - oc1378bc114d2.z$toz8pt08w0nc(stringArray2[i])) / (0x44BF6C8C ^ 0x44BF6C8E), oc255ab955c3.\u0544(n5, n6, oc1378bc114d2), n8, true);
        }
    }

    private boolean \u0586(int n, int n2) {
        String[] stringArray = new String[0x19A8D805 ^ 0x19A8D800];
        stringArray[0] = "Create";
        stringArray[1] = "Edit";
        stringArray[0x19A8D802 ^ 0x19A8D800] = "Load";
        stringArray[0x19A8D803 ^ 0x19A8D800] = "Folder";
        stringArray[0x19A8D804 ^ 0x19A8D800] = "Docs";
        String[] stringArray2 = stringArray;
        int n3 = 0x19A8D804 ^ 0x19A8D800;
        int n4 = (this.\u04a9 - n3 * (stringArray2.length - 1)) / stringArray2.length;
        int n5 = 0x19A8D820 ^ 0x19A8D800;
        int n6 = 0x19A8D810 ^ 0x19A8D800;
        if (!oc255ab955c3.\u050e(this.\u0169, n5, this.\u04a9, n6, n, n2)) {
            return false;
        }
        for (int i = 0; i < stringArray2.length; ++i) {
            int n7 = this.\u0169 + i * (n4 + n3);
            if (!oc255ab955c3.\u050e(n7, n5, n4, n6, n, n2)) continue;
            this.\u0491(stringArray2[i]);
            return true;
        }
        return true;
    }

    private void \u0491(String string) {
        Manager manager;
        if ("Edit".equals(string)) {
            String string2 = this.\u014c.\u01af().trim();
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.displayGuiScreen(new ocf65052963e(minecraft.currentScreen, string2.isEmpty() ? null : string2));
            return;
        }
        Manager manager2 = oc2cf3d80e17.\u013c != null ? oc9755810e45.\u0159 : (manager = null);
        if (manager == null) {
            this.\u01e5 = "Script manager unavailable";
            return;
        }
        if ("Create".equals(string)) {
            String string3 = this.\u014c.\u01af().trim();
            if (string3.isEmpty()) {
                this.\u01e5 = "Type a script name first";
                return;
            }
            manager.createScript(string3);
            this.\u014c.\u039d("");
            this.\u029f();
            this.\u01e5 = "Created script: " + string3;
            return;
        }
        if ("Load".equals(string)) {
            manager.loadScriptsNow();
            this.\u029f();
            this.\u01e5 = "Scripts loaded";
            return;
        }
        if ("Folder".equals(string)) {
            manager.openFolder();
            return;
        }
        if ("Docs".equals(string)) {
            manager.viewDocumentation();
        }
    }

    boolean \u017a(int n, int n2, int n3) {
        if (!oc255ab955c3.\u050e(this.\u0169, 32.0f, this.\u04a9, this.\u0437 - (0xF0D5DEE3 ^ 0xF0D5DEC3), n, n2)) {
            return false;
        }
        if (n2 < this.\u0389) {
            if (n3 != 0) {
                return true;
            }
            if (oc255ab955c3.\u050e(this.\u0169, 52.0f, this.\u04a9, 14.0f, n, n2)) {
                this.\u014c.\u04cc();
            } else {
                this.\u014c.\u02e1();
            }
            this.\u0586(n, n2);
            return true;
        }
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            if (!oc67f88659522.\u0290(n, n2, n3)) continue;
            return true;
        }
        this.\u04bb();
        return true;
    }

    boolean \u03cb(int n, int n2, int n3) {
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            oc67f88659522.c(n, n2, n3);
        }
        return false;
    }

    boolean \u028e(char c, int n) {
        if (this.\u014c.\u0175() && n == (0xF540FCFE ^ 0xF540FCE2)) {
            if (!this.\u014c.\u01af().trim().isEmpty()) {
                this.\u0491("Create");
            }
            this.\u014c.\u02e1();
            return true;
        }
        if (this.\u014c.\u01dd(c, n)) {
            return true;
        }
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            if (!oc67f88659522.\u0586(c, n)) continue;
            return true;
        }
        return false;
    }

    boolean \u0295(int n, int n2, int n3) {
        if (n3 == 0 || !oc255ab955c3.\u050e(this.\u0169, this.\u0389, this.\u04a9, this.\u0437 - this.\u0389, n, n2)) {
            return false;
        }
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            if (!oc67f88659522.\u04df(n, n2, n3)) continue;
            return true;
        }
        this.\u0237 -= oc08592ac73b.\u02b5(n3, 15.0);
        this.\u0161();
        return true;
    }

    void \u04bb() {
        this.\u014c.\u02e1();
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            oc67f88659522.\u04df();
        }
    }

    void \u019e() {
        this.\u014c.\u02e1();
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            oc67f88659522.\u0564();
        }
    }

    void \u029f() {
        List<oc69da1aa7f5> list = this.\u01e1();
        list.sort(Comparator.comparing(oc69da1aa7f5::z$3i8m9vxwuvqj0, String.CASE_INSENSITIVE_ORDER));
        HashMap<Object, oc67f8865952> hashMap = new HashMap<Object, oc67f8865952>();
        for (oc67f8865952 object : this.\u045f) {
            hashMap.put(object.\u040d().\u0452() + "\u0000" + object.\u040d().z$3i8m9vxwuvqj0(), object);
            hashMap.put(object.\u040d().z$3i8m9vxwuvqj0(), object);
        }
        this.\u045f.clear();
        for (oc69da1aa7f5 oc69da1aa7f52 : list) {
            oc67f8865952 oc67f88659522 = (oc67f8865952)hashMap.get(oc69da1aa7f52.\u0452() + "\u0000" + oc69da1aa7f52.z$3i8m9vxwuvqj0());
            if (oc67f88659522 == null) {
                oc67f88659522 = (oc67f8865952)hashMap.get(oc69da1aa7f52.z$3i8m9vxwuvqj0());
            }
            oc67f8865952 oc67f88659523 = new oc67f8865952(oc69da1aa7f52);
            if (oc67f88659522 != null) {
                oc67f88659523.\u0405(oc67f88659522);
            }
            this.\u045f.add(oc67f88659523);
        }
        this.\u012d = this.\u0550();
        this.\u0161();
    }

    private List<oc69da1aa7f5> \u01e1() {
        ArrayList<oc69da1aa7f5> arrayList = new ArrayList<oc69da1aa7f5>();
        if (oc2cf3d80e17.\u013c == null) {
            return arrayList;
        }
        for (oc69da1aa7f5 oc69da1aa7f52 : oc2cf3d80e17.\u013c.\u0249(oce4cea752dd.\u057c)) {
            if (oc69da1aa7f52 instanceof Manager) continue;
            arrayList.add(oc69da1aa7f52);
        }
        return arrayList;
    }

    private int \u0550() {
        int n = 0;
        for (oc67f8865952 oc67f88659522 : this.\u045f) {
            n += oc67f88659522.\u04b8();
        }
        return n;
    }

    private void \u0161() {
        int n = Math.max(0, this.\u012d - (this.\u0437 - this.\u0389));
        this.\u0237 = Math.max(0.0f, Math.min(this.\u0237, (float)n));
    }

    private void \u02ae(int n, int n2) {
        this.\u04a9 = Math.min(0xF6CC19B0 ^ 0xF6CC189C, Math.max(0xF6CC183C ^ 0xF6CC189C, n - (0xF6CC18CC ^ 0xF6CC189C)));
        this.\u0169 = (n - this.\u04a9) / (0xF6CC189E ^ 0xF6CC189C);
        this.\u0389 = 0xF6CC18D4 ^ 0xF6CC189C;
        this.\u0437 = Math.max(this.\u0389 + (0xF6CC18B4 ^ 0xF6CC189C), n2 - (0xF6CC18A4 ^ 0xF6CC189C));
    }
}

