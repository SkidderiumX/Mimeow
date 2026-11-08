/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import x.oc6d9efd226f;
import x.occ995d8031c;
import x.ocd7b0575e93;

public class oc4cd250c7b8 {
    private static final Pattern \u023c = Pattern.compile("\\[([^\\]]+)]\\([^)]*\\)");
    private static final Pattern \u00d2 = Pattern.compile("^#{1,6}\\s*(.+)$");
    private static final Pattern \u01a5 = Pattern.compile("^\\*\\*([^*]+)\\*\\*$");
    private static final Pattern \u01b3 = Pattern.compile("^(?:[-*+]|\\d+[.)])\\s*");
    public static int \u022c;

    private oc4cd250c7b8() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List<occ995d8031c> \u050b(String string) {
        int n;
        block34: {
            block33: {
                String string2;
                block32: {
                    n = oc6d9efd226f.\u03a5;
                    string2 = string;
                    if (n != 0) break block32;
                    if (string2 == null) break block33;
                    string2 = string.trim();
                }
                if (!string2.isEmpty()) break block34;
            }
            return Collections.emptyList();
        }
        ArrayList<occ995d8031c> arrayList = new ArrayList<occ995d8031c>();
        ocd7b0575e93 ocd7b0575e932 = ocd7b0575e93.\u019f;
        boolean bl = false;
        String[] stringArray = string.replace("\r", "").split("\n");
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            block38: {
                block35: {
                    String string3;
                    boolean bl2;
                    String string4;
                    block40: {
                        block41: {
                            block46: {
                                ocd7b0575e93 ocd7b0575e933;
                                boolean bl3;
                                ocd7b0575e93 ocd7b0575e934;
                                block44: {
                                    block45: {
                                        String string5;
                                        block42: {
                                            block43: {
                                                Object object;
                                                Matcher matcher;
                                                block36: {
                                                    block37: {
                                                        Object object2;
                                                        block39: {
                                                            Matcher matcher2;
                                                            String string6 = stringArray[n3];
                                                            string4 = string6.trim();
                                                            if (string4.isEmpty() && n == 0) break block35;
                                                            matcher = matcher2 = \u00d2.matcher(string4);
                                                            if (n != 0) break block36;
                                                            if (!matcher.matches()) break block37;
                                                            object = oc4cd250c7b8.\u013b(matcher2.group(1));
                                                            if (n != 0) break block38;
                                                            bl = oc4cd250c7b8.\u01d2((String)object);
                                                            if (bl) break block35;
                                                            object2 = object;
                                                            if (n != 0) break block39;
                                                            if (oc4cd250c7b8.\u047f((String)object2)) break block35;
                                                            object2 = object;
                                                        }
                                                        ocd7b0575e932 = oc4cd250c7b8.\u00da((String)object2, ocd7b0575e93.\u019f);
                                                        if (n == 0) break block35;
                                                    }
                                                    matcher = \u01a5.matcher(string4);
                                                }
                                                object = matcher;
                                                bl2 = ((Matcher)object).matches();
                                                if (n != 0) break block40;
                                                if (!bl2) break block41;
                                                string3 = oc4cd250c7b8.\u013b(((Matcher)object).group(1));
                                                ocd7b0575e934 = oc4cd250c7b8.\u00da(string3, ocd7b0575e93.\u019f);
                                                string5 = string3;
                                                if (n != 0) break block42;
                                                if (!oc4cd250c7b8.\u01d2(string5)) break block43;
                                                bl = true;
                                                if (n == 0) break block35;
                                            }
                                            string5 = string3;
                                        }
                                        bl3 = oc4cd250c7b8.\u047f(string5);
                                        if (n != 0) break block44;
                                        if (bl3) break block45;
                                        ocd7b0575e933 = ocd7b0575e934;
                                        if (n != 0) break block46;
                                        if (ocd7b0575e933 == ocd7b0575e93.\u019f) break block41;
                                    }
                                    bl3 = false;
                                }
                                bl = bl3;
                                ocd7b0575e933 = ocd7b0575e932 = ocd7b0575e934;
                            }
                            if (n == 0) break block35;
                        }
                        bl2 = bl;
                    }
                    if (bl2 && n == 0) break block35;
                    string3 = oc4cd250c7b8.\u013b(\u01b3.matcher(string4).replaceFirst(""));
                    if (n != 0) break block38;
                    if (!string3.isEmpty()) {
                        boolean bl4 = string3.toLowerCase(Locale.ROOT).startsWith("full changelog");
                        if (!(n != 0 || bl4 && n == 0)) {
                            bl4 = arrayList.add(new occ995d8031c(string3, oc4cd250c7b8.\u00da(string3, ocd7b0575e932)));
                        }
                    }
                }
                ++n3;
            }
            if (n == 0) continue;
        }
        return Collections.unmodifiableList(arrayList);
    }

    static ocd7b0575e93 \u00da(String string, ocd7b0575e93 ocd7b0575e932) {
        String string2;
        String[] stringArray;
        String string3;
        block26: {
            int n;
            String[] stringArray2;
            String[] stringArray3;
            String string4;
            block24: {
                int n2;
                block25: {
                    int n3;
                    block23: {
                        String[] stringArray4;
                        block21: {
                            block22: {
                                string4 = string.toLowerCase(Locale.ROOT);
                                n2 = oc6d9efd226f.\u03a5;
                                string3 = string4;
                                String[] stringArray5 = new String[0x808CE881 ^ 0x808CE887];
                                stringArray5[0] = "remove";
                                stringArray5[1] = "deleted";
                                stringArray5[0x808CE885 ^ 0x808CE887] = "delete ";
                                stringArray4 = stringArray5;
                                stringArray5[0x808CE884 ^ 0x808CE887] = "x\u00f3a";
                                if (n2 != 0) break block21;
                                stringArray4[0x808CE883 ^ 0x808CE887] = "xo\u00e1";
                                stringArray4[0x808CE882 ^ 0x808CE887] = "lo\u1ea1i b\u1ecf";
                                if (!oc4cd250c7b8.\u0370(string3, stringArray4)) break block22;
                                return ocd7b0575e93.\u018e;
                            }
                            string3 = string4;
                            n3 = 0x808CE880 ^ 0x808CE887;
                            if (n2 != 0) break block23;
                            String[] stringArray6 = new String[n3];
                            stringArray6[0] = "fix";
                            stringArray6[1] = "bug";
                            stringArray6[0x808CE885 ^ 0x808CE887] = "crash";
                            stringArray6[0x808CE884 ^ 0x808CE887] = "resolved";
                            stringArray6[0x808CE883 ^ 0x808CE887] = "hotfix";
                            stringArray6[0x808CE882 ^ 0x808CE887] = "s\u1eeda";
                            stringArray4 = stringArray6;
                            stringArray6[0x808CE881 ^ 0x808CE887] = "l\u1ed7i";
                        }
                        if (oc4cd250c7b8.\u0370(string3, stringArray4)) {
                            return ocd7b0575e93.\u046b;
                        }
                        string3 = string4;
                        n3 = 0x808CE880 ^ 0x808CE887;
                    }
                    String[] stringArray7 = new String[n3];
                    stringArray7[0] = "refactor";
                    stringArray7[1] = "rewrite";
                    stringArray7[0x808CE885 ^ 0x808CE887] = "migrat";
                    stringArray7[0x808CE884 ^ 0x808CE887] = "renam";
                    stringArray7[0x808CE883 ^ 0x808CE887] = "restructur";
                    stringArray7[0x808CE882 ^ 0x808CE887] = "vi\u1ebft l\u1ea1i";
                    stringArray3 = stringArray7;
                    stringArray7[0x808CE881 ^ 0x808CE887] = "t\u00e1i c\u1ea5u tr\u00fac";
                    if (n2 != 0) break block24;
                    if (!oc4cd250c7b8.\u0370(string3, stringArray3)) break block25;
                    return ocd7b0575e93.\u0144;
                }
                string3 = string4;
                String[] stringArray8 = new String[0x808CE880 ^ 0x808CE887];
                stringArray2 = stringArray8;
                stringArray = stringArray8;
                n = 0;
                string2 = "add";
                if (n2 != 0) break block26;
                stringArray2[n] = string2;
                stringArray[1] = "new ";
                stringArray[0x808CE885 ^ 0x808CE887] = "introduc";
                stringArray[0x808CE884 ^ 0x808CE887] = "support";
                stringArray[0x808CE883 ^ 0x808CE887] = "th\u00eam";
                stringArray[0x808CE882 ^ 0x808CE887] = "m\u1edbi";
                stringArray3 = stringArray;
                stringArray[0x808CE881 ^ 0x808CE887] = "h\u1ed7 tr\u1ee3";
            }
            if (oc4cd250c7b8.\u0370(string3, stringArray3)) {
                return ocd7b0575e93.\u03cc;
            }
            string3 = string4;
            String[] stringArray9 = new String[0x808CE88D ^ 0x808CE887];
            stringArray9[0] = "improv";
            stringArray9[1] = "enhanc";
            stringArray9[0x808CE885 ^ 0x808CE887] = "updat";
            stringArray9[0x808CE884 ^ 0x808CE887] = "optimi";
            stringArray9[0x808CE883 ^ 0x808CE887] = "rework";
            stringArray9[0x808CE882 ^ 0x808CE887] = "chang";
            stringArray9[0x808CE881 ^ 0x808CE887] = "c\u1ea3i thi\u1ec7n";
            stringArray9[0x808CE880 ^ 0x808CE887] = "n\u00e2ng c\u1ea5p";
            stringArray9[0x808CE88F ^ 0x808CE887] = "thay \u0111\u1ed5i";
            stringArray2 = stringArray9;
            stringArray = stringArray9;
            n = 0x808CE88E ^ 0x808CE887;
            string2 = "t\u1ed1i \u01b0u";
        }
        stringArray2[n] = string2;
        if (oc4cd250c7b8.\u0370(string3, stringArray)) {
            return ocd7b0575e93.J;
        }
        return ocd7b0575e932;
    }

    private static boolean \u0370(String string, String ... stringArray) {
        boolean bl;
        block8: {
            String[] stringArray2 = stringArray;
            int n = oc6d9efd226f.\u03a5;
            int n2 = stringArray2.length;
            int n3 = 0;
            while (n3 < n2) {
                block7: {
                    block9: {
                        String string2 = stringArray2[n3];
                        if (n != 0) break block7;
                        bl = string.contains(string2);
                        if (n != 0) break block8;
                        if (!bl) break block9;
                        return true;
                    }
                    ++n3;
                }
                if (n == 0) continue;
            }
            bl = false;
        }
        return bl;
    }

    private static boolean \u047f(String string) {
        boolean bl;
        block18: {
            block20: {
                block19: {
                    String string2 = string.toLowerCase(Locale.ROOT).replace("'", "").trim();
                    int n = oc6d9efd226f.\u03a5;
                    bl = string2.equals("whats changed");
                    if (n != 0) break block18;
                    if (bl) break block19;
                    bl = string2.equals("changes");
                    if (n != 0) break block18;
                    if (bl) break block19;
                    bl = string2.equals("change");
                    if (n != 0) break block18;
                    if (bl) break block19;
                    bl = string2.equals("changelog");
                    if (n != 0) break block18;
                    if (bl) break block19;
                    bl = string2.equals("release notes");
                    if (n != 0) break block18;
                    if (!bl) break block20;
                }
                bl = true;
                break block18;
            }
            bl = false;
        }
        return bl;
    }

    private static boolean \u01d2(String string) {
        boolean bl;
        block14: {
            block16: {
                block15: {
                    String string2 = string.toLowerCase(Locale.ROOT).trim();
                    int n = oc6d9efd226f.\u03a5;
                    bl = string2.equals("contributors");
                    if (n != 0) break block14;
                    if (bl) break block15;
                    bl = string2.equals("new contributors");
                    if (n != 0) break block14;
                    if (bl) break block15;
                    bl = string2.equals("contributor");
                    if (n != 0) break block14;
                    if (bl) break block15;
                    bl = string2.equals("new contributor");
                    if (n != 0) break block14;
                    if (!bl) break block16;
                }
                bl = true;
                break block14;
            }
            bl = false;
        }
        return bl;
    }

    private static String \u013b(String string) {
        StringBuffer stringBuffer;
        Matcher matcher;
        StringBuffer stringBuffer2;
        block4: {
            String string2 = string;
            int n = oc6d9efd226f.\u03a5;
            Matcher matcher2 = \u023c.matcher(string2);
            stringBuffer2 = new StringBuffer();
            while (matcher2.find()) {
                matcher = matcher2;
                stringBuffer = stringBuffer2;
                if (n == 0) {
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(matcher2.group(1)));
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            matcher = matcher2;
            stringBuffer = stringBuffer2;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer2.toString().replace("**", "").replace("__", "").replace("`", "").replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replaceAll("\\s+", " ").trim();
    }
}

