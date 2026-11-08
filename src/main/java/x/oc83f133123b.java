/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc02a3730b27;
import x.oc02e6d57a60;
import x.oc66fa4f2195;
import x.oc7ab2161b9f;
import x.ocda171fe5d8;

public class oc83f133123b {
    private static final long \u01de = 10000L;
    private static boolean \u0546;
    private static long \u048f;
    public static boolean \u0252;

    @oc66fa4f2195
    public void \u04ef(oc02e6d57a60 oc02e6d57a602) {
        block19: {
            oc02e6d57a60 oc02e6d57a603;
            block18: {
                int n;
                block16: {
                    int n2;
                    block17: {
                        block14: {
                            block15: {
                                block13: {
                                    block12: {
                                        n2 = oc02a3730b27.\u0166;
                                        n = \u0546;
                                        if (n2 != 0) break block12;
                                        if (n == 0) break block13;
                                        n = oc7ab2161b9f.\u00d0();
                                    }
                                    if (n2 != 0) break block14;
                                    if (n != 0) break block15;
                                }
                                return;
                            }
                            long l = System.currentTimeMillis() - \u048f - (0x9CBEAD2411540B0BL ^ 0x9CBEAD2411542C1BL);
                            n = l == 0L ? 0 : (l < 0L ? -1 : 1);
                        }
                        if (n2 != 0) break block16;
                        if (n <= 0) break block17;
                        oc83f133123b.\u01b8(true);
                        return;
                    }
                    oc02e6d57a603 = oc02e6d57a602;
                    if (n2 != 0) break block18;
                    n = oc7ab2161b9f.\u045b(oc02e6d57a603.\u01eb.getUnformattedText()).startsWith("Unknown") ? 1 : 0;
                }
                if (n == 0) break block19;
                oc02e6d57a603 = oc02e6d57a602;
            }
            oc02e6d57a603.setCanceled(true);
            int n = Math.max(0, (int)(System.currentTimeMillis() - \u048f) - (0x23D74A60 ^ 0x23D74A74));
            oc7ab2161b9f.\u00fd("&7Your ping: &b" + n + "&7ms.");
            oc83f133123b.\u01b8(true);
        }
    }

    public static void \u025d(boolean bl) {
        long l;
        block14: {
            boolean bl2;
            block12: {
                block13: {
                    int n;
                    block10: {
                        block11: {
                            n = oc02a3730b27.\u0166;
                            bl2 = oc7ab2161b9f.\u00d0();
                            if (n != 0) break block10;
                            if (bl2) break block11;
                            return;
                        }
                        bl2 = \u0546;
                    }
                    if (n != 0) break block12;
                    if (!bl2) break block13;
                    l = System.currentTimeMillis();
                    if (n != 0) break block14;
                    if (l - \u048f > (0xD0857A987BE7943BL ^ 0xD0857A987BE7B32BL)) break block13;
                    oc7ab2161b9f.\u00fd("&7Please wait before checking again.");
                    return;
                }
                oc83f133123b.\u01b8(true);
                oc7ab2161b9f.\u00fd("&7Checking ping...");
                bl2 = true;
            }
            \u0546 = bl2;
            l = System.currentTimeMillis();
        }
        \u048f = l;
        ocda171fe5d8.\u01d4.thePlayer.sendChatMessage("/...");
    }

    public static void \u01b8(boolean bl) {
        \u0546 = false;
        \u048f = 0L;
    }
}

