/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.occfd144e27a;

public class oca222284e44 {
    private static final char \u04af = '\u00a7';
    public static boolean X;

    private oca222284e44() {
    }

    public static String \u01f0(String string, Iterable<String> iterable, String string2) {
        String string3;
        block5: {
            int n = oc75d51ec7eb.\u03e9;
            if (iterable == null) {
                return string;
            }
            String string4 = string;
            for (String string5 : iterable) {
                string3 = string4;
                if (n == 0) {
                    string4 = oca222284e44.\u020a(string3, string5, string2);
                    if (n == 0) continue;
                }
                break block5;
            }
            string3 = string4;
        }
        return string3;
    }

    public static String \u020a(String string, String string2, String string3) {
        String string4;
        block32: {
            int n;
            block31: {
                String string5;
                block29: {
                    block30: {
                        n = oc75d51ec7eb.\u03e9;
                        string5 = string;
                        if (n != 0) break block29;
                        if (string5 == null) break block30;
                        string5 = string;
                        if (n != 0) break block29;
                        if (string5.isEmpty()) break block30;
                        string5 = string2;
                        if (n != 0) break block29;
                        if (string5 == null) break block30;
                        string5 = string2;
                        if (n != 0) break block29;
                        if (string5.isEmpty()) break block30;
                        string5 = string3;
                        if (n != 0) break block29;
                        if (string5 != null) break block31;
                    }
                    string5 = string;
                }
                return string5;
            }
            StringBuilder stringBuilder = new StringBuilder(string.length() + string3.length());
            occfd144e27a occfd144e27a2 = new occfd144e27a();
            int n2 = 0;
            while (n2 < string.length()) {
                char c;
                block36: {
                    int n3;
                    block37: {
                        String string6;
                        block35: {
                            block33: {
                                block34: {
                                    string4 = string;
                                    if (n != 0) break block32;
                                    c = string4.charAt(n2);
                                    string6 = string;
                                    if (n != 0) break block33;
                                    if (!oca222284e44.\u00c5(string6, n2)) break block34;
                                    char c2 = string.charAt(n2 + 1);
                                    occfd144e27a2.\u0523(c2);
                                    stringBuilder.append(c).append(c2);
                                    n2 += 2;
                                    if (n == 0) continue;
                                }
                                string6 = string;
                            }
                            if (n != 0) break block35;
                            if (!oca222284e44.\u0391(string6, string2, n2)) break block36;
                            string6 = string;
                        }
                        n3 = oca222284e44.\u0209(string6, n2, string2.length());
                        if (n != 0) break block37;
                        if (n3 == 0) break block36;
                        stringBuilder.append(string3);
                        stringBuilder.append(occfd144e27a2.\u00d0());
                        n3 = n2 + string2.length();
                    }
                    n2 = n3;
                    if (n == 0) continue;
                }
                stringBuilder.append(c);
                ++n2;
                if (n == 0) continue;
            }
            string4 = stringBuilder.toString();
        }
        return string4;
    }

    private static boolean \u0391(String string, String string2, int n) {
        int n2;
        block13: {
            block11: {
                int n3;
                block12: {
                    int n4;
                    block10: {
                        n3 = oc75d51ec7eb.\u03e9;
                        n4 = n;
                        if (n3 != 0) break block10;
                        if (n4 < 0) break block11;
                        n2 = n;
                        if (n3 != 0) break block12;
                        n4 = n2 + string2.length();
                    }
                    if (n4 > string.length()) break block11;
                    n2 = string.regionMatches(true, n, string2, 0, string2.length()) ? 1 : 0;
                }
                if (n3 != 0) break block13;
                if (n2 == 0) break block11;
                n2 = 1;
                break block13;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    public static String \u04c6(String string) {
        String string2;
        String string3;
        block12: {
            block13: {
                String string4;
                int n;
                block10: {
                    block11: {
                        n = oc75d51ec7eb.\u03e9;
                        string4 = string;
                        if (n != 0) break block10;
                        if (string4 != null) break block11;
                        return null;
                    }
                    string4 = oc7ab2161b9f.\u045b(string).trim();
                }
                string3 = string4;
                string2 = string3;
                if (n != 0) break block12;
                if (!string2.isEmpty()) break block13;
                return null;
            }
            string2 = string3;
        }
        int n = string2.lastIndexOf(0xEB642234 ^ 0xEB642214);
        String string5 = n >= 0 ? string3.substring(n + 1) : string3;
        return string5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean \u0209(String string, int n, int n2) {
        char c;
        block6: {
            char c2 = oca222284e44.\u0426(string, n - 1);
            int n3 = oc75d51ec7eb.\u03e9;
            int c3 = oca222284e44.\u0215(string, n + n2);
            c = c2;
            if (n3 != 0) break block6;
            if (!oca222284e44.\u0193(c)) return 0 != 0;
            int c4 = c3;
            if (n3 != 0) return c4 != 0;
            c = (char)(oca222284e44.\u0193(c4) ? 1 : 0);
        }
        if (c == '\u0000') return 0 != 0;
        return 1 != 0;
    }

    private static char \u0426(String string, int n) {
        int n2;
        block16: {
            int n3 = n;
            int n4 = oc75d51ec7eb.\u03e9;
            while (n3 >= 0) {
                String string2;
                block19: {
                    block17: {
                        block18: {
                            n2 = n3;
                            if (n4 != 0) break block16;
                            if (n4 != 0) break block17;
                            if (n2 <= 0) break block18;
                            n2 = string.charAt(n3 - 1);
                            if (n4 != 0) break block17;
                            if (n2 != (0xE910E8B7 ^ 0xE910E810)) break block18;
                            n3 -= 2;
                            if (n4 == 0) continue;
                        }
                        string2 = string;
                        if (n4 != 0) break block19;
                        n2 = string2.charAt(n3);
                    }
                    if (n2 == (0xE910E8B7 ^ 0xE910E810)) {
                        --n3;
                        if (n4 == 0) continue;
                    }
                    string2 = string;
                }
                return string2.charAt(n3);
            }
            n2 = 0;
        }
        return (char)n2;
    }

    private static char \u0215(String string, int n) {
        char c;
        block9: {
            int n2 = oc75d51ec7eb.\u03e9;
            for (int i = n; i < string.length(); i += 2) {
                int n3;
                String string2;
                block8: {
                    string2 = string;
                    n3 = i;
                    if (n2 != 0) break block8;
                    c = (char)(oca222284e44.\u00c5(string2, n3) ? 1 : 0);
                    if (n2 != 0) break block9;
                    if (c != '\u0000') {
                        continue;
                    }
                    string2 = string;
                    n3 = i;
                }
                return string2.charAt(n3);
            }
            c = '\u0000';
        }
        return c;
    }

    private static boolean \u0193(char c) {
        int c2;
        block8: {
            block10: {
                block9: {
                    int n = oc75d51ec7eb.\u03e9;
                    c2 = c;
                    if (n != 0) break block8;
                    if (c2 == 0) break block9;
                    c2 = c;
                    if (n != 0) break block8;
                    if (oca222284e44.\u0181(c2)) break block10;
                }
                c2 = 1;
                break block8;
            }
            c2 = 0;
        }
        return c2 != 0;
    }

    private static boolean \u0181(char c) {
        int c2;
        block8: {
            block10: {
                block9: {
                    int n = oc75d51ec7eb.\u03e9;
                    c2 = c;
                    if (n != 0) break block8;
                    if (Character.isLetterOrDigit(c2)) break block9;
                    c2 = c;
                    if (n != 0) break block8;
                    if (c2 != (0x32998178 ^ 0x32998127)) break block10;
                }
                c2 = 1;
                break block8;
            }
            c2 = 0;
        }
        return c2 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean \u00c5(String string, int n) {
        int n2;
        int n3;
        block6: {
            int n4 = oc75d51ec7eb.\u03e9;
            n3 = n;
            n2 = 1;
            if (n4 != 0) break block6;
            if (n3 + n2 >= string.length()) return 0 != 0;
            n3 = string.charAt(n);
            if (n4 != 0) return n3 != 0;
            n2 = 0x93C2B161 ^ 0x93C2B1C6;
        }
        if (n3 != n2) return 0 != 0;
        return 1 != 0;
    }
}

