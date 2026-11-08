/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import x.N;
import x.oc24a0a5bddf;
import x.oc3c7a892f2f;
import x.oc4d46a99983;
import x.oc5fe36d3bb5;
import x.oc69da1aa7f5;
import x.oc8edd24b1ed;
import x.oc9755810e45;
import x.oca9cc61aada;
import x.ocaa9a64f047;
import x.ocb23d192a35;
import x.ocbf5a535fb8;
import x.occ0b63c0426;
import x.occ2f8dff8d8;
import x.occ39d36078d;
import x.occc831eff22;
import x.ocdd342096f8;

public class ocbbac1d8814 {
    private oc69da1aa7f5 \u042e;
    private occc831eff22 \u02b3;
    private final List<N> \u0171 = new ArrayList<N>();
    private final Map<String, occ2f8dff8d8> \u0509 = new LinkedHashMap<String, occ2f8dff8d8>();
    private final Map<String, oca9cc61aada> \u01af = new LinkedHashMap<String, oca9cc61aada>();
    private final Map<String, oc24a0a5bddf> \u0128 = new LinkedHashMap<String, oc24a0a5bddf>();
    private final Map<String, ocb23d192a35> \u01e5 = new LinkedHashMap<String, ocb23d192a35>();
    private final Map<String, occc831eff22> \u0584 = new LinkedHashMap<String, occc831eff22>();
    public static int \u04cf;

    public ocbbac1d8814() {
        this(null);
    }

    public ocbbac1d8814(oc69da1aa7f5 oc69da1aa7f52) {
        this.\u042e = oc69da1aa7f52;
        this.\u02b3 = null;
    }

    public ocbbac1d8814(oc69da1aa7f5 oc69da1aa7f52, String string) {
        this.\u042e = oc69da1aa7f52;
        this.\u02b3 = new occc831eff22(string);
        this.\u0584.put(string, this.\u02b3);
        this.\u0171.add(this.\u02b3);
        oc69da1aa7f52.\u028c(this.\u02b3);
    }

    public void \u0468(oc69da1aa7f5 oc69da1aa7f52) {
        this.\u042e = oc69da1aa7f52;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void \u02a5(String string) {
        String string2;
        block7: {
            int n = occ0b63c0426.\u039f;
            string2 = string;
            if (n != 0) break block7;
            if (string2 == null) return;
            string2 = string.trim();
        }
        if (string2.isEmpty()) {
            return;
        }
        occc831eff22 occc831eff222 = new occc831eff22(string.trim());
        this.\u0584.put(string.trim(), occc831eff222);
        this.\u0171.add(occc831eff222);
        this.\u042e.\u028c(occc831eff222);
    }

    public void \u03fd(String string) {
        oc4d46a99983 oc4d46a999832 = new oc4d46a99983(string);
        this.\u0171.add(oc4d46a999832);
        this.\u042e.\u028c(oc4d46a999832);
    }

    public void \u0474(String string, boolean bl) {
        occ2f8dff8d8 occ2f8dff8d82 = new occ2f8dff8d8(this.\u02b3, string, bl);
        this.\u0509.put(string, occ2f8dff8d82);
        this.\u0171.add(occ2f8dff8d82);
        this.\u042e.\u028c(occ2f8dff8d82);
        ocbbac1d8814.\u021d(this.\u02b3, occ2f8dff8d82);
    }

    public void \u00dc(String string, String string2, boolean bl) {
        occc831eff22 occc831eff222 = this.\u04b5(string);
        occ2f8dff8d8 occ2f8dff8d82 = occc831eff222 == null ? new occ2f8dff8d8(string2, bl) : new occ2f8dff8d8(occc831eff222, string2, bl);
        occ2f8dff8d8 occ2f8dff8d83 = occ2f8dff8d82;
        this.\u0509.put(string2, occ2f8dff8d83);
        this.\u0171.add(occ2f8dff8d83);
        this.\u042e.\u028c(occ2f8dff8d83);
        ocbbac1d8814.\u021d(occc831eff222, occ2f8dff8d83);
    }

    public void \u029d(String string, int n) {
        this.\u011d(null, string, n);
    }

    public void \u011d(String string, String string2, int n) {
        occc831eff22 occc831eff222 = this.\u04b5(string);
        ocb23d192a35 ocb23d192a352 = occc831eff222 == null ? new ocb23d192a35(string2, n) : new ocb23d192a35(occc831eff222, string2, n);
        ocb23d192a35 ocb23d192a353 = ocb23d192a352;
        this.\u01e5.put(string2, ocb23d192a353);
        this.\u0171.add(ocb23d192a353);
        this.\u042e.\u028c(ocb23d192a353);
        ocbbac1d8814.\u021d(occc831eff222, ocb23d192a353);
    }

    public void \u02a9(String string, String string2, double d, double d2, double d3, double d4) {
        oca9cc61aada oca9cc61aada2 = new oca9cc61aada(this.\u02b3, string, string2, d, d2, d3, d4);
        this.\u01af.put(string, oca9cc61aada2);
        this.\u0171.add(oca9cc61aada2);
        this.\u042e.\u028c(oca9cc61aada2);
        ocbbac1d8814.\u021d(this.\u02b3, oca9cc61aada2);
    }

    public void \u03da(String string, double d, double d2, double d3, double d4) {
        this.\u02a9(string, "", d, d2, d3, d4);
    }

    public void \u0241(String string, String string2, String string3, double d, double d2, double d3, double d4) {
        occc831eff22 occc831eff222 = this.\u04b5(string);
        oca9cc61aada oca9cc61aada2 = occc831eff222 == null ? new oca9cc61aada(string2, string3, d, d2, d3, d4) : new oca9cc61aada(occc831eff222, string2, string3, d, d2, d3, d4);
        oca9cc61aada oca9cc61aada3 = oca9cc61aada2;
        this.\u01af.put(string2, oca9cc61aada3);
        this.\u0171.add(oca9cc61aada3);
        this.\u042e.\u028c(oca9cc61aada3);
        ocbbac1d8814.\u021d(occc831eff222, oca9cc61aada3);
    }

    public void \u04c5(String string, String string2, double d, String[] stringArray) {
        oca9cc61aada oca9cc61aada2 = new oca9cc61aada(this.\u02b3, string, string2, (int)d, stringArray);
        this.\u01af.put(string, oca9cc61aada2);
        this.\u0171.add(oca9cc61aada2);
        this.\u042e.\u028c(oca9cc61aada2);
        ocbbac1d8814.\u021d(this.\u02b3, oca9cc61aada2);
    }

    public void \u0433(String string, int n, String[] stringArray) {
        this.\u0228(string, "", n, stringArray);
    }

    public void \u0228(String string, String string2, int n, String[] stringArray) {
        oca9cc61aada oca9cc61aada2 = new oca9cc61aada(this.\u02b3, string, string2, n, stringArray);
        this.\u01af.put(string, oca9cc61aada2);
        this.\u0171.add(oca9cc61aada2);
        this.\u042e.\u028c(oca9cc61aada2);
        ocbbac1d8814.\u021d(this.\u02b3, oca9cc61aada2);
    }

    public void \u03ce(String string, String string2, String string3, int n, String[] stringArray) {
        occc831eff22 occc831eff222 = this.\u04b5(string);
        oca9cc61aada oca9cc61aada2 = new oca9cc61aada(occc831eff222, string2, string3, n, stringArray);
        this.\u01af.put(string2, oca9cc61aada2);
        this.\u0171.add(oca9cc61aada2);
        this.\u042e.\u028c(oca9cc61aada2);
        ocbbac1d8814.\u021d(occc831eff222, oca9cc61aada2);
    }

    public void \u0109(String string, int n, int n2, int n3) {
        this.\u03b6(this.\u02b3, string, n, n2, n3, 0x273E2289 ^ 0x273E2276, false);
    }

    public void \u03b8(String string, int n, int n2, int n3, int n4) {
        this.\u03b6(this.\u02b3, string, n, n2, n3, n4, true);
    }

    public void \u0452(String string, String string2, int n, int n2, int n3) {
        this.\u03b6(this.\u04b5(string), string2, n, n2, n3, 0xA0E1754C ^ 0xA0E175B3, false);
    }

    public void \u00c0(String string, String string2, int n, int n2, int n3, int n4) {
        this.\u03b6(this.\u04b5(string), string2, n, n2, n3, n4, true);
    }

    private void \u03b6(occc831eff22 occc831eff222, String string, int n, int n2, int n3, int n4, boolean bl) {
        oc24a0a5bddf oc24a0a5bddf2;
        block8: {
            block6: {
                block7: {
                    if (occc831eff222 != null) break block6;
                    if (!bl) break block7;
                    oc24a0a5bddf2 = new oc24a0a5bddf(string, n, n2, n3, n4);
                    break block8;
                }
                oc24a0a5bddf2 = new oc24a0a5bddf(string, n, n2, n3);
                break block8;
            }
            oc24a0a5bddf2 = bl ? new oc24a0a5bddf(occc831eff222, string, n, n2, n3, n4) : new oc24a0a5bddf(occc831eff222, string, n, n2, n3);
        }
        oc24a0a5bddf oc24a0a5bddf3 = oc24a0a5bddf2;
        this.\u0128.put(string, oc24a0a5bddf3);
        this.\u0171.add(oc24a0a5bddf3);
        this.\u042e.\u028c(oc24a0a5bddf3);
        ocbbac1d8814.\u021d(occc831eff222, oc24a0a5bddf3);
    }

    public void \u0274(boolean bl) {
        Iterator<N> iterator2 = this.\u0171.iterator();
        int n = occ0b63c0426.\u039f;
        while (iterator2.hasNext()) {
            N n2 = iterator2.next();
            n2.\u0209(bl, this.\u042e);
            if (n == 0) continue;
        }
    }

    public void \u0174(String string, boolean bl) {
        block3: {
            oca9cc61aada oca9cc61aada2;
            block2: {
                oca9cc61aada oca9cc61aada3 = this.\u01af.get(string);
                int n = occ0b63c0426.\u039f;
                oca9cc61aada2 = oca9cc61aada3;
                if (n != 0) break block2;
                if (oca9cc61aada2 == null) break block3;
                oca9cc61aada2 = oca9cc61aada3;
            }
            oca9cc61aada2.\u0209(bl, this.\u042e);
        }
    }

    public boolean \u04d5(String string, String string2) {
        boolean bl;
        block6: {
            block5: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block4: {
                    occ2f8dff8d8 occ2f8dff8d83 = this.\u0509.get(string2);
                    n = occ0b63c0426.\u039f;
                    occ2f8dff8d82 = occ2f8dff8d83;
                    if (n != 0) break block4;
                    if (occ2f8dff8d82 == null) break block5;
                    occ2f8dff8d82 = occ2f8dff8d83;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public double \u0187(String string, String string2) {
        double d;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                oca9cc61aada oca9cc61aada3;
                block5: {
                    oca9cc61aada3 = this.\u01af.get(string2);
                    int n = occ0b63c0426.\u039f;
                    oca9cc61aada2 = oca9cc61aada3;
                    if (n != 0) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oca9cc61aada2 = oca9cc61aada3;
            }
            d = oca9cc61aada2.\u04c1();
        }
        return d;
    }

    public int \u018c(String string, String string2) {
        int n;
        block6: {
            oc24a0a5bddf oc24a0a5bddf2;
            block4: {
                oc24a0a5bddf oc24a0a5bddf3;
                block5: {
                    oc24a0a5bddf3 = this.\u0128.get(string2);
                    int n2 = occ0b63c0426.\u039f;
                    oc24a0a5bddf2 = oc24a0a5bddf3;
                    if (n2 != 0) break block4;
                    if (oc24a0a5bddf2 != null) break block5;
                    n = 0;
                    break block6;
                }
                oc24a0a5bddf2 = oc24a0a5bddf3;
            }
            n = oc24a0a5bddf2.\u0373();
        }
        return n;
    }

    public void \u01bd(String string, String string2, int n, int n2, int n3) {
        block3: {
            oc24a0a5bddf oc24a0a5bddf2;
            block2: {
                oc24a0a5bddf oc24a0a5bddf3 = this.\u0128.get(string2);
                int n4 = occ0b63c0426.\u039f;
                oc24a0a5bddf2 = oc24a0a5bddf3;
                if (n4 != 0) break block2;
                if (oc24a0a5bddf2 == null) break block3;
                oc24a0a5bddf2 = oc24a0a5bddf3;
            }
            oc24a0a5bddf2.\u04c2(n, n2, n3);
        }
    }

    public void \u0412(String string, String string2, int n, int n2, int n3, int n4) {
        block3: {
            oc24a0a5bddf oc24a0a5bddf2;
            block2: {
                oc24a0a5bddf oc24a0a5bddf3 = this.\u0128.get(string2);
                int n5 = occ0b63c0426.\u039f;
                oc24a0a5bddf2 = oc24a0a5bddf3;
                if (n5 != 0) break block2;
                if (oc24a0a5bddf2 == null) break block3;
                oc24a0a5bddf2 = oc24a0a5bddf3;
            }
            oc24a0a5bddf2.\u01be(n, n2, n3, n4);
        }
    }

    public double \u04d4(String string, String string2) {
        double d;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                oca9cc61aada oca9cc61aada3;
                block5: {
                    oca9cc61aada3 = this.\u01af.get(string2);
                    int n = occ0b63c0426.\u039f;
                    oca9cc61aada2 = oca9cc61aada3;
                    if (n != 0) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oca9cc61aada2 = oca9cc61aada3;
            }
            d = oca9cc61aada2.\u0515();
        }
        return d;
    }

    public double \u044e(String string, String string2) {
        double d;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                oca9cc61aada oca9cc61aada3;
                block5: {
                    oca9cc61aada3 = this.\u01af.get(string2);
                    int n = occ0b63c0426.\u039f;
                    oca9cc61aada2 = oca9cc61aada3;
                    if (n != 0) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oca9cc61aada2 = oca9cc61aada3;
            }
            d = oca9cc61aada2.\u0236();
        }
        return d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u0538(String string, String string2) {
        oca9cc61aada oca9cc61aada2;
        oca9cc61aada oca9cc61aada3;
        block12: {
            block13: {
                int n;
                block11: {
                    block10: {
                        oca9cc61aada3 = this.\u01af.get(string2);
                        n = occ0b63c0426.\u039f;
                        oca9cc61aada2 = oca9cc61aada3;
                        if (n != 0) break block10;
                        if (oca9cc61aada2 == null) return "";
                        oca9cc61aada2 = oca9cc61aada3;
                    }
                    if (n != 0) break block11;
                    if (oca9cc61aada2.\u04be() == null) return "";
                    oca9cc61aada2 = oca9cc61aada3;
                }
                if (n != 0) break block12;
                if (oca9cc61aada2.\u04be().length != 0) break block13;
                return "";
            }
            oca9cc61aada2 = oca9cc61aada3;
        }
        String[] stringArray = oca9cc61aada2.\u04be();
        int n = (int)Math.round(oca9cc61aada3.\u04c1());
        n = Math.max(0, Math.min(n, stringArray.length - 1));
        return stringArray[n];
    }

    public void \u04b7(String string, String string2, boolean bl) {
        block3: {
            occ2f8dff8d8 occ2f8dff8d82;
            block2: {
                occ2f8dff8d8 occ2f8dff8d83 = this.\u0509.get(string2);
                int n = occ0b63c0426.\u039f;
                occ2f8dff8d82 = occ2f8dff8d83;
                if (n != 0) break block2;
                if (occ2f8dff8d82 == null) break block3;
                occ2f8dff8d82 = occ2f8dff8d83;
            }
            occ2f8dff8d82.\u03d1(bl);
        }
    }

    public void \u0402(String string, String string2, double d) {
        block3: {
            oca9cc61aada oca9cc61aada2;
            block2: {
                oca9cc61aada oca9cc61aada3 = this.\u01af.get(string2);
                int n = occ0b63c0426.\u039f;
                oca9cc61aada2 = oca9cc61aada3;
                if (n != 0) break block2;
                if (oca9cc61aada2 == null) break block3;
                oca9cc61aada2 = oca9cc61aada3;
            }
            oca9cc61aada2.f(d);
        }
    }

    public boolean \u0191(String string, String string2) {
        boolean bl;
        block6: {
            block5: {
                ocb23d192a35 ocb23d192a352;
                int n;
                block4: {
                    ocb23d192a35 ocb23d192a353 = this.\u01e5.get(string2);
                    n = occ0b63c0426.\u039f;
                    ocb23d192a352 = ocb23d192a353;
                    if (n != 0) break block4;
                    if (ocb23d192a352 == null) break block5;
                    ocb23d192a352 = ocb23d192a353;
                }
                bl = ocb23d192a352.\u0190();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public void \u041f(String string, String string2, int n) {
        block3: {
            ocb23d192a35 ocb23d192a352;
            block2: {
                ocb23d192a35 ocb23d192a353 = this.\u01e5.get(string2);
                int n2 = occ0b63c0426.\u039f;
                ocb23d192a352 = ocb23d192a353;
                if (n2 != 0) break block2;
                if (ocb23d192a352 == null) break block3;
                ocb23d192a352 = ocb23d192a353;
            }
            ocb23d192a352.\u00c8(n);
        }
    }

    public Map<String, Object> \u01ca(String string) {
        oc69da1aa7f5 oc69da1aa7f52;
        int n;
        LinkedHashMap<String, Object> linkedHashMap;
        block21: {
            oc69da1aa7f5 oc69da1aa7f53;
            block22: {
                linkedHashMap = new LinkedHashMap<String, Object>();
                oc69da1aa7f53 = this.\u0575(string);
                n = occ0b63c0426.\u039f;
                oc69da1aa7f52 = oc69da1aa7f53;
                if (n != 0) break block21;
                if (oc69da1aa7f52 != null) break block22;
                return linkedHashMap;
            }
            oc69da1aa7f52 = oc69da1aa7f53;
        }
        for (N n2 : oc69da1aa7f52.\u0260()) {
            block25: {
                Object object;
                block26: {
                    block27: {
                        block23: {
                            block24: {
                                object = n2;
                                if (n != 0) break block23;
                                if (!(object instanceof oca9cc61aada)) break block24;
                                linkedHashMap.put(n2.z$18nrktuqeiysv(), ((oca9cc61aada)n2).\u04c1());
                                if (n == 0) break block25;
                            }
                            object = n2;
                        }
                        if (n != 0) break block26;
                        if (!(object instanceof occ2f8dff8d8)) break block27;
                        linkedHashMap.put(n2.z$18nrktuqeiysv(), ((occ2f8dff8d8)n2).\u01ed());
                        if (n == 0) break block25;
                    }
                    object = n2;
                }
                if (n != 0 || !(object instanceof oc24a0a5bddf)) break block25;
                object = linkedHashMap.put(n2.z$18nrktuqeiysv(), ((oc24a0a5bddf)n2).\u0373());
            }
            if (n == 0) continue;
        }
        return linkedHashMap;
    }

    public Map<String, List<String>> \u039b() {
        LinkedHashMap<String, List<String>> linkedHashMap;
        block3: {
            LinkedHashMap<String, List<String>> linkedHashMap2 = new LinkedHashMap<String, List<String>>();
            Iterator<oc69da1aa7f5> iterator2 = oc9755810e45.\u0154.iterator();
            int n = occ0b63c0426.\u039f;
            while (iterator2.hasNext()) {
                block4: {
                    ArrayList<String> arrayList;
                    oc69da1aa7f5 oc69da1aa7f52;
                    block5: {
                        oc69da1aa7f52 = iterator2.next();
                        String string = oc69da1aa7f52.\u044a().name();
                        linkedHashMap = linkedHashMap2;
                        if (n != 0) break block3;
                        arrayList = (ArrayList<String>)linkedHashMap.get(string);
                        if (n != 0) break block4;
                        if (arrayList != null) break block5;
                        arrayList = new ArrayList<String>();
                        linkedHashMap2.put(string, arrayList);
                    }
                    arrayList.add(oc69da1aa7f52.z$3i8m9vxwuvqj0());
                }
                if (n == 0) continue;
            }
            linkedHashMap = linkedHashMap2;
        }
        return linkedHashMap;
    }

    public boolean \u027a(String string) {
        boolean bl;
        block6: {
            block5: {
                oc69da1aa7f5 oc69da1aa7f52;
                int n;
                block4: {
                    oc69da1aa7f5 oc69da1aa7f53 = oc9755810e45.\u0548(string);
                    n = occ0b63c0426.\u039f;
                    oc69da1aa7f52 = oc69da1aa7f53;
                    if (n != 0) break block4;
                    if (oc69da1aa7f52 == null) break block5;
                    oc69da1aa7f52 = oc69da1aa7f53;
                }
                bl = oc69da1aa7f52.z$3rzb3dil7uydr();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public void \u04f3(String string) {
        block7: {
            oc69da1aa7f5 oc69da1aa7f52;
            block8: {
                int n;
                oc69da1aa7f5 oc69da1aa7f53;
                block6: {
                    oc69da1aa7f53 = this.\u0575(string);
                    n = occ0b63c0426.\u039f;
                    oc69da1aa7f52 = oc69da1aa7f53;
                    if (n != 0) break block6;
                    if (oc69da1aa7f52 == null) break block7;
                    oc69da1aa7f52 = oc69da1aa7f53;
                }
                if (n != 0) break block8;
                if (oc69da1aa7f52.z$3rzb3dil7uydr()) break block7;
                oc69da1aa7f52 = oc69da1aa7f53;
            }
            oc69da1aa7f52.\u0425();
        }
    }

    public void \u0554(String string) {
        block7: {
            oc69da1aa7f5 oc69da1aa7f52;
            block8: {
                int n;
                oc69da1aa7f5 oc69da1aa7f53;
                block6: {
                    oc69da1aa7f53 = this.\u0575(string);
                    n = occ0b63c0426.\u039f;
                    oc69da1aa7f52 = oc69da1aa7f53;
                    if (n != 0) break block6;
                    if (oc69da1aa7f52 == null) break block7;
                    oc69da1aa7f52 = oc69da1aa7f53;
                }
                if (n != 0) break block8;
                if (!oc69da1aa7f52.z$3rzb3dil7uydr()) break block7;
                oc69da1aa7f52 = oc69da1aa7f53;
            }
            oc69da1aa7f52.z$1ca1cmv0s357();
        }
    }

    public oc5fe36d3bb5 v() {
        oc5fe36d3bb5 oc5fe36d3bb52;
        block6: {
            EntityLivingBase entityLivingBase;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    entityLivingBase = ocdd342096f8.f;
                    if (n != 0) break block4;
                    if (entityLivingBase != null) break block5;
                    oc5fe36d3bb52 = null;
                    break block6;
                }
                entityLivingBase = ocdd342096f8.f;
            }
            oc5fe36d3bb52 = oc5fe36d3bb5.\u0277(entityLivingBase);
        }
        return oc5fe36d3bb52;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public oc5fe36d3bb5 \u04cc() {
        ocaa9a64f047 ocaa9a64f0472;
        block7: {
            int n;
            block6: {
                n = occ0b63c0426.\u039f;
                ocaa9a64f0472 = oc9755810e45.\u0163;
                if (n != 0) break block6;
                if (ocaa9a64f0472 == null) return null;
                ocaa9a64f0472 = oc9755810e45.\u0163;
            }
            if (n != 0) return oc5fe36d3bb5.\u0277(ocaa9a64f0472.\u0283());
            if (ocaa9a64f0472.z$3rzb3dil7uydr()) break block7;
            return null;
        }
        ocaa9a64f0472 = oc9755810e45.\u0163;
        return oc5fe36d3bb5.\u0277(ocaa9a64f0472.\u0283());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public oc5fe36d3bb5 \u04a9() {
        oc3c7a892f2f oc3c7a892f2f2;
        block7: {
            int n;
            block6: {
                n = occ0b63c0426.\u039f;
                oc3c7a892f2f2 = oc9755810e45.\u053a;
                if (n != 0) break block6;
                if (oc3c7a892f2f2 == null) return null;
                oc3c7a892f2f2 = oc9755810e45.\u053a;
            }
            if (n != 0) return oc5fe36d3bb5.\u0277(oc3c7a892f2f2.B());
            if (oc3c7a892f2f2.z$3rzb3dil7uydr()) break block7;
            return null;
        }
        oc3c7a892f2f2 = oc9755810e45.\u053a;
        return oc5fe36d3bb5.\u0277(oc3c7a892f2f2.B());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public oc5fe36d3bb5 \u0491() {
        occ39d36078d occ39d36078d2;
        block7: {
            int n;
            block6: {
                n = occ0b63c0426.\u039f;
                occ39d36078d2 = oc9755810e45.G;
                if (n != 0) break block6;
                if (occ39d36078d2 == null) return null;
                occ39d36078d2 = oc9755810e45.G;
            }
            if (n != 0) return oc5fe36d3bb5.\u0277(occ39d36078d2.\u0172());
            if (occ39d36078d2.z$3rzb3dil7uydr()) break block7;
            return null;
        }
        occ39d36078d2 = oc9755810e45.G;
        return oc5fe36d3bb5.\u0277(occ39d36078d2.\u0172());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ocbf5a535fb8 \u04b4() {
        oc3c7a892f2f oc3c7a892f2f2;
        block10: {
            int n;
            block9: {
                n = occ0b63c0426.\u039f;
                oc3c7a892f2f2 = oc9755810e45.\u053a;
                if (n != 0) break block9;
                if (oc3c7a892f2f2 == null) return null;
                oc3c7a892f2f2 = oc9755810e45.\u053a;
            }
            if (n != 0) break block10;
            if (!oc3c7a892f2f2.z$3rzb3dil7uydr()) return null;
            oc3c7a892f2f2 = oc9755810e45.\u053a;
            if (n != 0) return ocbf5a535fb8.\u00c9(oc3c7a892f2f2.\u0407());
        }
        if (oc3c7a892f2f2.\u0407() == null) {
            return null;
        }
        oc3c7a892f2f2 = oc9755810e45.\u053a;
        return ocbf5a535fb8.\u00c9(oc3c7a892f2f2.\u0407());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ocbf5a535fb8 \u011c() {
        occ39d36078d occ39d36078d2;
        block10: {
            int n;
            block9: {
                n = occ0b63c0426.\u039f;
                occ39d36078d2 = oc9755810e45.G;
                if (n != 0) break block9;
                if (occ39d36078d2 == null) return null;
                occ39d36078d2 = oc9755810e45.G;
            }
            if (n != 0) break block10;
            if (!occ39d36078d2.z$3rzb3dil7uydr()) return null;
            occ39d36078d2 = oc9755810e45.G;
            if (n != 0) return ocbf5a535fb8.\u00c9(occ39d36078d2.\u022f());
        }
        if (occ39d36078d2.\u022f() == null) {
            return null;
        }
        occ39d36078d2 = oc9755810e45.G;
        return ocbf5a535fb8.\u00c9(occ39d36078d2.\u022f());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ocbf5a535fb8 \u0288() {
        oc8edd24b1ed oc8edd24b1ed2;
        block10: {
            int n;
            block9: {
                n = occ0b63c0426.\u039f;
                oc8edd24b1ed2 = oc9755810e45.\u03d4;
                if (n != 0) break block9;
                if (oc8edd24b1ed2 == null) return null;
                oc8edd24b1ed2 = oc9755810e45.\u03d4;
            }
            if (n != 0) break block10;
            if (!oc8edd24b1ed2.z$3rzb3dil7uydr()) return null;
            oc8edd24b1ed2 = oc9755810e45.\u03d4;
            if (n != 0) return ocbf5a535fb8.\u03e1(oc8edd24b1ed2.\u0513());
        }
        if (oc8edd24b1ed2.\u0513() == null) {
            return null;
        }
        oc8edd24b1ed2 = oc9755810e45.\u03d4;
        return ocbf5a535fb8.\u03e1(oc8edd24b1ed2.\u0513());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public float[] \u0118() {
        float[] fArray;
        int n;
        block7: {
            block8: {
                block6: {
                    oc8edd24b1ed oc8edd24b1ed2;
                    int n2;
                    block5: {
                        n2 = occ0b63c0426.\u039f;
                        oc8edd24b1ed2 = oc9755810e45.\u03d4;
                        if (n2 != 0) break block5;
                        if (oc8edd24b1ed2 == null) break block6;
                        oc8edd24b1ed2 = oc9755810e45.\u03d4;
                    }
                    n = oc8edd24b1ed2.z$3rzb3dil7uydr();
                    if (n2 != 0) break block7;
                    if (n != 0) break block8;
                }
                float[] fArray2 = new float[0x8E491432 ^ 0x8E491430];
                fArray2[0] = 0.0f;
                fArray = fArray2;
                fArray2[1] = 0.0f;
                return fArray;
            }
            n = 0x8E491432 ^ 0x8E491430;
        }
        float[] fArray3 = new float[n];
        fArray3[0] = oc9755810e45.\u03d4.\u0402();
        fArray = fArray3;
        fArray3[1] = 0.0f;
        return fArray;
    }

    public boolean \u021d() {
        boolean bl;
        block6: {
            block5: {
                oc69da1aa7f5 oc69da1aa7f52;
                int n;
                block4: {
                    oc69da1aa7f5 oc69da1aa7f53 = oc9755810e45.\u0548("Scaffold");
                    n = occ0b63c0426.\u039f;
                    oc69da1aa7f52 = oc69da1aa7f53;
                    if (n != 0) break block4;
                    if (oc69da1aa7f52 == null) break block5;
                    oc69da1aa7f52 = oc69da1aa7f53;
                }
                bl = oc69da1aa7f52.z$3rzb3dil7uydr();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0139() {
        return false;
    }

    public boolean \u00ea(String string) {
        boolean bl;
        block6: {
            block5: {
                oc69da1aa7f5 oc69da1aa7f52;
                int n;
                block4: {
                    oc69da1aa7f5 oc69da1aa7f53 = oc9755810e45.\u0548(string);
                    n = occ0b63c0426.\u039f;
                    oc69da1aa7f52 = oc69da1aa7f53;
                    if (n != 0) break block4;
                    if (oc69da1aa7f52 == null) break block5;
                    oc69da1aa7f52 = oc69da1aa7f53;
                }
                bl = oc69da1aa7f52.\u056c();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ocbf5a535fb8 \u024d() {
        BlockPos blockPos;
        Minecraft minecraft;
        int n;
        Minecraft minecraft2;
        block22: {
            block23: {
                block21: {
                    minecraft2 = Minecraft.getMinecraft();
                    n = occ0b63c0426.\u039f;
                    minecraft = minecraft2;
                    if (n != 0) break block21;
                    if (minecraft.thePlayer == null) return null;
                    minecraft = minecraft2;
                }
                if (n != 0) break block22;
                if (minecraft.theWorld != null) break block23;
                return null;
            }
            minecraft = minecraft2;
        }
        BlockPos blockPos2 = minecraft.thePlayer.getPosition();
        BlockPos blockPos3 = null;
        double d = Double.MAX_VALUE;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int n2 = Math.max(0, blockPos2.getY() - (0xB0688591 ^ 0xB0688588));
        int n3 = Math.min(0xB0688577 ^ 0xB0688588, blockPos2.getY() + (0xB0688591 ^ 0xB0688588));
        int n4 = blockPos2.getX() - (0xB0688591 ^ 0xB0688588);
        while (n4 <= blockPos2.getX() + (0xB0688591 ^ 0xB0688588)) {
            block24: {
                blockPos = blockPos2;
                if (n != 0) return ocbf5a535fb8.\u03e1(blockPos);
                block17: for (int i = (v3135978).getZ() - (0xB0688591 ^ 0xB0688588); i <= blockPos2.getZ() + (0xB0688591 ^ 0xB0688588); ++i) {
                    if (n != 0) break block24;
                    WorldClient worldClient = minecraft2.theWorld;
                    block18: while (true) {
                        int n5;
                        int n6 = worldClient.isBlockLoaded(mutableBlockPos.set(n4, blockPos2.getY(), i), false);
                        if (n == 0) {
                            if (n6 == 0) continue block17;
                            n6 = n5 = n2;
                        }
                        while (n5 <= n3) {
                            block28: {
                                block27: {
                                    BlockPos.MutableBlockPos mutableBlockPos2;
                                    block25: {
                                        block26: {
                                            mutableBlockPos2 = mutableBlockPos;
                                            if (n != 0) break block25;
                                            mutableBlockPos2.set(n4, n5, i);
                                            worldClient = minecraft2.theWorld;
                                            if (n != 0) continue block18;
                                            if (worldClient.getBlockState(mutableBlockPos).getBlock() instanceof BlockBed) break block26;
                                            break block27;
                                        }
                                        mutableBlockPos2 = mutableBlockPos;
                                    }
                                    double d2 = mutableBlockPos2.distanceSq(blockPos2);
                                    if (n != 0) break block28;
                                    if (!(d2 < d)) break block27;
                                    d = d2;
                                    blockPos3 = new BlockPos(n4, n5, i);
                                }
                                ++n5;
                            }
                            if (n == 0) continue;
                        }
                        break;
                    }
                    if (n == 0) continue;
                }
                ++n4;
            }
            if (n == 0) continue;
        }
        blockPos = blockPos3;
        return ocbf5a535fb8.\u03e1(blockPos);
    }

    private oc69da1aa7f5 \u0575(String string) {
        oc69da1aa7f5 oc69da1aa7f52;
        block6: {
            String string2;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    string2 = this.\u042e.z$3i8m9vxwuvqj0();
                    if (n != 0) break block4;
                    if (!string2.equalsIgnoreCase(string)) break block5;
                    oc69da1aa7f52 = this.\u042e;
                    break block6;
                }
                string2 = string;
            }
            oc69da1aa7f52 = oc9755810e45.\u0548(string2);
        }
        return oc69da1aa7f52;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private occc831eff22 \u04b5(String string) {
        Object object;
        String string2;
        block9: {
            int n = occ0b63c0426.\u039f;
            string2 = string;
            if (n != 0) break block9;
            if (string2 == null) return this.\u02b3;
            object = string;
            if (n != 0) return (occc831eff22)object;
            string2 = ((String)object).trim();
        }
        if (string2.isEmpty()) {
            return this.\u02b3;
        }
        object = this.\u0584.get(string.trim());
        return (occc831eff22)object;
    }

    private static void \u021d(occc831eff22 occc831eff222, N n) {
        block6: {
            N n2;
            block5: {
                int n3 = occ0b63c0426.\u039f;
                n2 = occc831eff222;
                if (n3 != 0) break block5;
                if (n2 == null) break block6;
                n2 = n;
            }
            if (n2 != null) {
                occc831eff222.\u03c1(n);
            }
        }
    }
}

