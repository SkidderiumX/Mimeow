/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import net.minecraft.client.gui.Gui;
import x.oc08592ac73b;
import x.oc1378bc114d;
import x.oc13d681dc50;
import x.oc151419fdfe;
import x.oc255ab955c3;
import x.oc26930a666f;
import x.oc2cf3d80e17;
import x.oc41720aed4a;
import x.oc7ab2161b9f;
import x.oc9e5a7eeec6;
import x.ocbd4917c4b1;
import x.ocd26b62219b;
import x.ocf973b98311;

public class oce2a4f2842f {
    private static final int \u015b = 360;
    private static final int \u0513 = 250;
    private static final int \u01e7 = 22;
    private static final int \u017a = 18;
    private static final int \u0373 = 32;
    private static final int \u0508 = 18;
    private static final int \u011b = 5;
    private static final SimpleDateFormat \u013f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private final oc26930a666f \u037a = new oc26930a666f();
    private final List<oc13d681dc50> \u00f6 = new ArrayList<oc13d681dc50>();
    private final List<oc41720aed4a> \u026d = new ArrayList<oc41720aed4a>();
    private final List<oc41720aed4a> \u03f4 = new ArrayList<oc41720aed4a>();
    private ocd26b62219b \u0495 = ocd26b62219b.\u0423;
    private String \u019a = "";
    private String \u014d = "";
    private String \u0434 = "Click a config to load";
    private int \u0459;
    private int \u02b6;
    private int \u040b;
    private int \u0422;
    private int \u0461;
    private int \u0172;
    private int \u0551;
    private int \u00f8;
    private int \u0493;
    private boolean U;
    private boolean \u03e4;
    private boolean \u0503;
    private boolean b;
    private boolean \u01d2;
    private boolean \u047b;

    oce2a4f2842f() {
    }

    void \u00e8(int n, int n2) {
        this.\u03a5(n, n2);
        boolean bl = !this.\u047b;
        this.\u047b = true;
        this.\u0140();
        this.\u04f1(oc9e5a7eeec6.\u044d);
        if (bl) {
            this.\u04f1(oc9e5a7eeec6.\u00fd);
        }
    }

    void \u01b7() {
        this.\u047b = false;
    }

    void \u0145(int n, int n2, int n3, int n4) {
        this.\u03a5(n3, n4);
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.B();
        int n5 = oc255ab955c3.\u01ea((double)this.\u0459 + (double)this.\u040b * 0.5, (double)this.\u02b6 + (double)this.\u0422 * 0.5);
        ocbd4917c4b1.\u04da(this.\u0459 - 1, this.\u02b6 - 1, this.\u0459 + this.\u040b + 1, this.\u02b6 + this.\u0422 + 1, 6.0f, oc255ab955c3.\u0515(n5, 0xE196F8B0 ^ 0xE196F86C));
        ocbd4917c4b1.\u04da(this.\u0459, this.\u02b6, this.\u0459 + this.\u040b, this.\u02b6 + this.\u0422, 6.0f, oc255ab955c3.\u0515(0x1E8FE175 ^ 0xE196F86C, 0xE196F899 ^ 0xE196F86C));
        String string = "Config Manager";
        oc1378bc114d2.z$ao2ykh4tuw6w(string, this.\u0459 + (this.\u040b - oc1378bc114d2.z$toz8pt08w0nc(string)) / (0xE196F86E ^ 0xE196F86C), this.\u02b6 + Math.max(0xE196F86F ^ 0xE196F86C, ((0xE196F87A ^ 0xE196F86C) - oc1378bc114d2.z$1tqmx4tpnr6lq()) / (0xE196F86E ^ 0xE196F86C)), -1, true);
        this.\u02ae(n, n2, oc1378bc114d2);
        this.\u017b(n, n2, oc1378bc114d2);
        String string2 = oc255ab955c3.\u0516(this.\u0434, oc1378bc114d2, this.\u040b - (0xE196F866 ^ 0xE196F86C));
        oc1378bc114d2.z$ao2ykh4tuw6w(string2, this.\u0459 + (0xE196F869 ^ 0xE196F86C), this.\u02b6 + this.\u0422 - (0xE196F87E ^ 0xE196F86C) + (0xE196F868 ^ 0xE196F86C), this.\u01d2 ? n5 : 0x1E0866F2 ^ 0xE196F86C, true);
    }

    boolean \u0127(int n, int n2, int n3) {
        int n4;
        int n5;
        if (n3 != 0 || !oc255ab955c3.\u050e(this.\u0459, this.\u02b6, this.\u040b, this.\u0422, n, n2)) {
            return false;
        }
        int n6 = this.\u02b6 + (0xC60E3678 ^ 0xC60E366E);
        int n7 = (this.\u040b - (0xC60E3664 ^ 0xC60E366E)) / ocd26b62219b.values().length;
        for (n5 = 0; n5 < ocd26b62219b.values().length; ++n5) {
            n4 = this.\u0459 + (0xC60E366B ^ 0xC60E366E) + n5 * n7;
            if (!oc255ab955c3.\u050e(n4, n6, n7, 18.0f, n, n2)) continue;
            this.\u03d7(ocd26b62219b.values()[n5]);
            return true;
        }
        n5 = this.\u04b6();
        n4 = this.\u01ad();
        if (n2 < n5 || n2 > n4) {
            return true;
        }
        int n8 = (n2 - n5 + this.\u054a()) / (0xC60E364E ^ 0xC60E366E);
        if (this.\u0495 == ocd26b62219b.\u02a5) {
            if (n8 >= 0 && n8 < this.\u00f6.size()) {
                this.g(this.\u00f6.get(n8));
            }
            return true;
        }
        List<oc41720aed4a> list = this.\u02ab(this.\u0495.\u03c4);
        if (n8 >= 0 && n8 < list.size()) {
            this.\u01c6(list.get(n8), this.\u0495.\u03c4);
        }
        return true;
    }

    boolean \u03e7(int n, int n2, int n3) {
        if (n3 == 0 || !oc255ab955c3.\u050e(this.\u0459, this.\u04b6(), this.\u040b, this.\u01ad() - this.\u04b6(), n, n2)) {
            return false;
        }
        int n4 = this.\u054a() - Math.round(oc08592ac73b.\u02b5(n3, 32.0));
        this.\u0511(Math.max(0, Math.min(n4, this.\u0454())));
        return true;
    }

    private void \u02ae(int n, int n2, oc1378bc114d oc1378bc114d2) {
        int n3 = this.\u02b6 + (0xF4525805 ^ 0xF4525813);
        int n4 = (this.\u040b - (0xF4525819 ^ 0xF4525813)) / ocd26b62219b.values().length;
        for (int i = 0; i < ocd26b62219b.values().length; ++i) {
            int n5;
            ocd26b62219b ocd26b62219b2 = ocd26b62219b.values()[i];
            int n6 = this.\u0459 + (0xF4525816 ^ 0xF4525813) + i * n4;
            boolean bl = ocd26b62219b2 == this.\u0495;
            boolean bl2 = oc255ab955c3.\u050e(n6, n3, n4, 18.0f, n, n2);
            if (bl) {
                n5 = oc255ab955c3.\u01ea((double)n6 + (double)n4 * 0.5, (double)n3 + 9.0);
                ocbd4917c4b1.\u04da(n6, n3, n6 + n4, n3 + (0xF4525801 ^ 0xF4525813), 3.0f, oc255ab955c3.\u0515(n5, 0xF45258DE ^ 0xF4525813));
            } else if (bl2) {
                Gui.drawRect(n6, n3, n6 + n4, n3 + (0xF4525801 ^ 0xF4525813), 0x624B410A ^ 0xF4525813);
            }
            n5 = bl ? -1 : 0xBCCC68D ^ 0xF4525813;
            oc1378bc114d2.z$ao2ykh4tuw6w(ocd26b62219b2.\u00df, n6 + (n4 - oc1378bc114d2.z$toz8pt08w0nc(ocd26b62219b2.\u00df)) / (0xF4525811 ^ 0xF4525813), n3 + Math.max(0xF4525811 ^ 0xF4525813, ((0xF4525801 ^ 0xF4525813) - oc1378bc114d2.z$1tqmx4tpnr6lq()) / (0xF4525811 ^ 0xF4525813)), n5, true);
        }
    }

    private void \u017b(int n, int n2, oc1378bc114d oc1378bc114d2) {
        int n3 = this.\u04b6();
        int n4 = this.\u01ad();
        int n5 = this.\u040b - (0x2358729D ^ 0x23587297);
        ocbd4917c4b1.\u010e(this.\u0459 + (0x23587292 ^ 0x23587297), n3, n5, n4 - n3);
        int n6 = n3 - this.\u054a();
        if (this.\u0495 == ocd26b62219b.\u02a5) {
            for (oc13d681dc50 oc13d681dc502 : this.\u00f6) {
                this.\u051b(oc13d681dc502, this.\u0459 + (0x23587292 ^ 0x23587297), n6, n5, n, n2, oc1378bc114d2);
                n6 += 32;
            }
        } else {
            List<oc41720aed4a> list = this.\u02ab(this.\u0495.\u03c4);
            String string = this.\u0433(this.\u0495.\u03c4);
            if (!string.isEmpty()) {
                oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(string, oc1378bc114d2, n5 - (0x2358729F ^ 0x23587297)), this.\u0459 + (0x23587292 ^ 0x23587297) + (0x23587293 ^ 0x23587297), n3 + (0x23587291 ^ 0x23587297), 0xDCC6EC09 ^ 0x23587297, true);
            } else {
                for (oc41720aed4a oc41720aed4a2 : list) {
                    this.\u04e3(oc41720aed4a2, this.\u0459 + (0x23587292 ^ 0x23587297), n6, n5, n, n2, oc1378bc114d2);
                    n6 += 32;
                }
            }
        }
        ocbd4917c4b1.\u01df();
    }

    private void \u051b(oc13d681dc50 oc13d681dc502, int n, int n2, int n3, int n4, int n5, oc1378bc114d oc1378bc114d2) {
        int n6;
        boolean bl = this.\u01e5(n, n2, n3, n4, n5);
        int n7 = n6 = bl ? 0xBA7059C4 ^ 0x45446DF0 : 0xBA6D44D9 ^ 0x45446DF0;
        if (oc13d681dc502.\u01ae) {
            n6 = oc255ab955c3.\u0515(oc255ab955c3.\u01ea(n, n2), bl ? 0x45446D66 ^ 0x45446DF0 : 0x45446D99 ^ 0x45446DF0);
        }
        Gui.drawRect(n, n2, n + n3, n2 + (0x45446DD0 ^ 0x45446DF0) - (0x45446DF2 ^ 0x45446DF0), n6);
        int n8 = oc13d681dc502.\u01ae ? oc255ab955c3.\u01ea(n + n3, n2) : -1;
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(oc13d681dc502.\u00da, oc1378bc114d2, n3 - (0x45446DFA ^ 0x45446DF0)), n + (0x45446DF5 ^ 0x45446DF0), n2 + (0x45446DF4 ^ 0x45446DF0), n8, true);
        String string = oc13d681dc502.\u01ae ? "Current config" : "Last used: " + oc13d681dc502.\u03f5;
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(string, oc1378bc114d2, n3 - (0x45446DFA ^ 0x45446DF0)), n + (0x45446DF5 ^ 0x45446DF0), n2 + (0x45446DE1 ^ 0x45446DF0), oc13d681dc502.\u01ae ? -1 : 0xBADAF36E ^ 0x45446DF0, true);
    }

    private void \u04e3(oc41720aed4a oc41720aed4a2, int n, int n2, int n3, int n4, int n5, oc1378bc114d oc1378bc114d2) {
        boolean bl = this.\u01e5(n, n2, n3, n4, n5);
        Gui.drawRect(n, n2, n + n3, n2 + (0x9936FBB5 ^ 0x9936FB95) - (0x9936FB97 ^ 0x9936FB95), bl ? 0x6602CFA1 ^ 0x9936FB95 : 0x661FD2BC ^ 0x9936FB95);
        int n6 = oc255ab955c3.\u01ea(n + n3, n2);
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(oc41720aed4a2.\u00d6(), oc1378bc114d2, n3 - (0x9936FB9F ^ 0x9936FB95)), n + (0x9936FB90 ^ 0x9936FB95), n2 + (0x9936FB91 ^ 0x9936FB95), bl ? n6 : -1, true);
        String string = "by " + oc41720aed4a2.\u00db() + " | " + oc41720aed4a2.\u057b() + " loads";
        if (this.\u0495 == ocd26b62219b.\u0423 && !oc41720aed4a2.\u0437().isEmpty()) {
            string = string + " | " + oc41720aed4a2.\u0437();
        }
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(string, oc1378bc114d2, n3 - (0x9936FB9F ^ 0x9936FB95)), n + (0x9936FB90 ^ 0x9936FB95), n2 + (0x9936FB84 ^ 0x9936FB95), 0x66A8650B ^ 0x9936FB95, true);
    }

    private boolean \u01e5(int n, int n2, int n3, int n4, int n5) {
        return n2 >= this.\u04b6() - (0xF0193E78 ^ 0xF0193E58) && n2 < this.\u01ad() && oc255ab955c3.\u050e(n, n2, n3, 30.0f, n4, n5) && n5 >= this.\u04b6() && n5 <= this.\u01ad();
    }

    private void \u03d7(ocd26b62219b ocd26b62219b2) {
        this.\u0495 = ocd26b62219b2;
        if (ocd26b62219b2 == ocd26b62219b.\u02a5) {
            this.\u0140();
        } else {
            this.\u04f1(ocd26b62219b2.\u03c4);
        }
        this.\u0511(Math.min(this.\u054a(), this.\u0454()));
    }

    private void \u04f1(oc9e5a7eeec6 oc9e5a7eeec62) {
        if (oce2a4f2842f.\u03c0(oc9e5a7eeec62, this.\u01fb(oc9e5a7eeec62), this.\u0406(oc9e5a7eeec62))) {
            this.\u042e(oc9e5a7eeec62);
        }
    }

    static boolean \u03c0(oc9e5a7eeec6 oc9e5a7eeec62, boolean bl, boolean bl2) {
        return !bl2 && (oc9e5a7eeec62 == oc9e5a7eeec6.\u044d || !bl);
    }

    private void \u0140() {
        this.\u00f6.clear();
        if (oc2cf3d80e17.\u00c1 == null) {
            return;
        }
        String string = oc2cf3d80e17.\u0115 == null ? "" : oc2cf3d80e17.\u0115.\u0120();
        for (oc151419fdfe oc151419fdfe2 : oc2cf3d80e17.\u00c1.\u01f9) {
            File file = new File(oc2cf3d80e17.\u00c1.\u044e, oc151419fdfe2.\u0120() + ".json");
            String string2 = file.isFile() ? \u013f.format(new Date(file.lastModified())) : "unknown";
            this.\u00f6.add(new oc13d681dc50(oc151419fdfe2.\u0120(), string2, oc151419fdfe2.\u0120().equalsIgnoreCase(string)));
        }
        this.\u00f6.sort(Comparator.comparing(oc13d681dc502 -> oc13d681dc502.\u00da, String.CASE_INSENSITIVE_ORDER));
        this.\u0172 = Math.min(this.\u0172, this.\u029b(ocd26b62219b.\u02a5));
    }

    private void \u042e(oc9e5a7eeec6 oc9e5a7eeec62) {
        this.\u04c6(oc9e5a7eeec62, true);
        this.\u0480(oc9e5a7eeec62, false);
        this.\u0213(oc9e5a7eeec62, "Loading " + oc9e5a7eeec62.\u04f2() + " configs...");
        this.\u02ab(oc9e5a7eeec62).clear();
        int n = this.Z(oc9e5a7eeec62);
        this.\u037a.\u04e6(oc9e5a7eeec62, list -> {
            if (n != this.\u0259(oc9e5a7eeec62)) {
                return;
            }
            List<oc41720aed4a> list2 = this.\u02ab(oc9e5a7eeec62);
            list2.clear();
            list2.addAll((Collection<oc41720aed4a>)list);
            list2.sort(Comparator.comparing(oc41720aed4a::\u00d6, String.CASE_INSENSITIVE_ORDER));
            this.\u0213(oc9e5a7eeec62, list2.isEmpty() ? "No configs found" : "");
            this.\u04c6(oc9e5a7eeec62, false);
            this.\u0480(oc9e5a7eeec62, true);
            this.\u0511(Math.min(this.\u054a(), this.\u0454()));
        }, string -> {
            if (n != this.\u0259(oc9e5a7eeec62)) {
                return;
            }
            this.\u0213(oc9e5a7eeec62, "Failed: " + string);
            this.\u04c6(oc9e5a7eeec62, false);
        });
    }

    private void g(oc13d681dc50 oc13d681dc502) {
        if (this.\u01d2 || oc2cf3d80e17.\u00c1 == null) {
            return;
        }
        boolean bl = oc2cf3d80e17.\u00c1.\u0431(oc13d681dc502.\u00da);
        Object object = this.\u0434 = bl ? "Loaded local config: " + oc13d681dc502.\u00da : "Failed to load: " + oc13d681dc502.\u00da;
        if (bl) {
            oc7ab2161b9f.\u00fd("&7Loaded local config: &b" + oc13d681dc502.\u00da);
        }
        this.\u0140();
    }

    private void \u01c6(oc41720aed4a oc41720aed4a2, oc9e5a7eeec6 oc9e5a7eeec62) {
        if (this.\u01d2) {
            return;
        }
        this.\u01d2 = true;
        this.\u0434 = "Loading " + oc41720aed4a2.\u00d6() + "...";
        this.\u037a.\u0160(oc9e5a7eeec62, oc41720aed4a2, bl -> {
            this.\u0434 = bl != false ? "Loaded " + oc41720aed4a2.\u00d6() : "Failed to apply " + oc41720aed4a2.\u00d6();
            this.\u01d2 = false;
            if (bl.booleanValue()) {
                oc7ab2161b9f.\u00fd("&7Loaded " + oc9e5a7eeec62.\u04f2() + " config: &b" + oc41720aed4a2.\u00d6());
                this.\u0140();
            }
        }, string -> {
            this.\u0434 = "Failed: " + string;
            this.\u01d2 = false;
        });
    }

    private void \u03a5(int n, int n2) {
        this.\u040b = Math.min(0x50D2A55C ^ 0x50D2A434, Math.max(0x50D2A494 ^ 0x50D2A434, n - (0x50D2A420 ^ 0x50D2A434)));
        this.\u0422 = Math.min(0x50D2A4CE ^ 0x50D2A434, Math.max(0x50D2A44C ^ 0x50D2A434, n2 - (0x50D2A410 ^ 0x50D2A434)));
        this.\u0459 = (n - this.\u040b) / (0x50D2A436 ^ 0x50D2A434);
        this.\u02b6 = Math.max(0x50D2A428 ^ 0x50D2A434, (n2 - this.\u0422) / (0x50D2A436 ^ 0x50D2A434));
    }

    private int \u04b6() {
        return this.\u02b6 + (0x3B4C4EC7 ^ 0x3B4C4ED1) + (0x3B4C4EC3 ^ 0x3B4C4ED1) + (0x3B4C4ED5 ^ 0x3B4C4ED1);
    }

    private int \u01ad() {
        return this.\u02b6 + this.\u0422 - (0x82E0CF51 ^ 0x82E0CF43);
    }

    private int \u0454() {
        return this.\u029b(this.\u0495);
    }

    private int \u029b(ocd26b62219b ocd26b62219b2) {
        int n = ocd26b62219b2 == ocd26b62219b.\u02a5 ? this.\u00f6.size() : this.\u02ab(ocd26b62219b2.\u03c4).size();
        return Math.max(0, n * (0xCE4C39EA ^ 0xCE4C39CA) - (this.\u01ad() - this.\u04b6()));
    }

    private int \u054a() {
        switch (ocf973b98311.\u015a[this.\u0495.ordinal()]) {
            case 1: {
                return this.\u0172;
            }
            case 2: {
                return this.\u0551;
            }
        }
        return this.\u0461;
    }

    private void \u0511(int n) {
        int n2 = Math.max(0, n);
        switch (ocf973b98311.\u015a[this.\u0495.ordinal()]) {
            case 1: {
                this.\u0172 = n2;
                break;
            }
            case 2: {
                this.\u0551 = n2;
                break;
            }
            default: {
                this.\u0461 = n2;
            }
        }
    }

    private List<oc41720aed4a> \u02ab(oc9e5a7eeec6 oc9e5a7eeec62) {
        return oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd ? this.\u03f4 : this.\u026d;
    }

    private String \u0433(oc9e5a7eeec6 oc9e5a7eeec62) {
        return oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd ? this.\u014d : this.\u019a;
    }

    private void \u0213(oc9e5a7eeec6 oc9e5a7eeec62, String string) {
        if (oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd) {
            this.\u014d = string;
        } else {
            this.\u019a = string;
        }
    }

    private boolean \u01fb(oc9e5a7eeec6 oc9e5a7eeec62) {
        return oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd ? this.\u03e4 : this.U;
    }

    private void \u0480(oc9e5a7eeec6 oc9e5a7eeec62, boolean bl) {
        if (oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd) {
            this.\u03e4 = bl;
        } else {
            this.U = bl;
        }
    }

    private boolean \u0406(oc9e5a7eeec6 oc9e5a7eeec62) {
        return oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd ? this.b : this.\u0503;
    }

    private void \u04c6(oc9e5a7eeec6 oc9e5a7eeec62, boolean bl) {
        if (oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd) {
            this.b = bl;
        } else {
            this.\u0503 = bl;
        }
    }

    private int Z(oc9e5a7eeec6 oc9e5a7eeec62) {
        if (oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd) {
            return ++this.\u0493;
        }
        return ++this.\u00f8;
    }

    private int \u0259(oc9e5a7eeec6 oc9e5a7eeec62) {
        return oc9e5a7eeec62 == oc9e5a7eeec6.\u00fd ? this.\u0493 : this.\u00f8;
    }
}

