/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import x.oc4e1b577a95;
import x.oc69da1aa7f5;

public class oc34bba7044e {
    private static String \u02a7 = "";
    private static int \u01a8 = 1;
    private static long \u0502 = 0L;
    private static int l = 1;
    public static boolean \u020b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void \u0227(IChatComponent iChatComponent, List<ChatLine> list, List<ChatLine> list2) {
        block36: {
            long l;
            block35: {
                String string;
                long l2;
                block33: {
                    String string2;
                    block34: {
                        int n;
                        boolean bl;
                        block32: {
                            block31: {
                                IChatComponent iChatComponent2;
                                block29: {
                                    block30: {
                                        block28: {
                                            bl = false;
                                            if (!oc4e1b577a95.\u03b4()) break block28;
                                            iChatComponent2 = iChatComponent;
                                            if (bl) break block29;
                                            if (iChatComponent2 != null) break block30;
                                        }
                                        oc34bba7044e.\u026b();
                                        return;
                                    }
                                    iChatComponent2 = iChatComponent;
                                }
                                string2 = iChatComponent2.getUnformattedText().trim();
                                if (bl) break block31;
                                if (!string2.isEmpty() && !oc34bba7044e.F(string2)) break block32;
                                oc34bba7044e.\u026b();
                            }
                            return;
                        }
                        l2 = System.currentTimeMillis();
                        string = string2;
                        if (bl) break block33;
                        if (!string.equals(\u02a7)) break block34;
                        l = l2 - \u0502;
                        if (bl) break block35;
                        if (l >= (0x63E86EC9D9DB386DL ^ 0x63E86EC9D9DB02F5L)) break block34;
                        int n2 = \u01a8 + 1;
                        if (!bl) {
                            \u01a8 = n2;
                            \u0502 = l2;
                            if (!list.isEmpty()) {
                                list.remove(0);
                            }
                            n2 = n = 0;
                        }
                        while (n < oc34bba7044e.l) {
                            Object object = list2;
                            if (!bl) {
                                if (object.isEmpty()) break;
                                object = list2.remove(0);
                            }
                            ++n;
                            if (!bl) continue;
                        }
                        iChatComponent.appendSibling(new ChatComponentText(" \u00a77(x" + \u01a8 + ")"));
                        if (!bl) break block36;
                    }
                    string = string2;
                }
                \u02a7 = string;
                \u01a8 = 1;
                l = l2;
            }
            \u0502 = l;
        }
    }

    public static void \u03f8(int n) {
        l = n;
    }

    public static void \u026b() {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    \u02a7 = "";
                    boolean bl2 = false;
                    \u01a8 = 1;
                    \u0502 = 0L;
                    l = 1;
                    if (!bl2) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    private static boolean F(String string) {
        char c;
        block23: {
            int n;
            boolean bl;
            block21: {
                int n2;
                block22: {
                    bl = false;
                    n2 = string.length();
                    if (bl) break block21;
                    if (n2 >= (0x846CD5C9 ^ 0x846CD5CC)) break block22;
                    return false;
                }
                n2 = n = 0;
            }
            while (n < string.length()) {
                block24: {
                    block25: {
                        char n3;
                        block28: {
                            block27: {
                                char n4;
                                block26: {
                                    c = string.charAt(n);
                                    if (bl) break block23;
                                    n4 = c;
                                    if (bl) break block24;
                                    if (n4 == (0x846CD5E1 ^ 0x846CD5CC)) break block25;
                                    n3 = n4;
                                    if (bl) break block26;
                                    if (n3 == (0x846CD5F1 ^ 0x846CD5CC)) break block25;
                                    n3 = n4;
                                }
                                if (bl) break block27;
                                if (n3 == (0x846CF060 ^ 0x846CD5CC)) break block25;
                                n3 = n4;
                            }
                            if (bl) break block28;
                            if (n3 == (0x846CD593 ^ 0x846CD5CC)) break block25;
                            n3 = '\u0000';
                        }
                        return n3 != '\u0000';
                    }
                    ++n;
                }
                if (!bl) continue;
            }
            c = '\u0001';
        }
        return c != '\u0000';
    }
}

