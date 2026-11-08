/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import x.oc33a56dc248;
import x.ocab66880042;
import x.oce490879787;

public class oc9e2e8d26de {
    private static final long \u01fd = 60000000000L;
    private static final oc33a56dc248 \u03f4;
    private static volatile oc33a56dc248 \u01a8;
    public static int \u00e6;

    private oc9e2e8d26de() {
    }

    public static void \u0233(List<ocab66880042> list) {
        block16: {
            HashSet<String> hashSet;
            HashSet<UUID> hashSet2;
            block17: {
                hashSet2 = new HashSet<UUID>();
                boolean bl = oce490879787.\u0583;
                hashSet = new HashSet<String>();
                if (bl) break block16;
                if (list == null) break block17;
                for (ocab66880042 ocab668800422 : list) {
                    block20: {
                        ocab66880042 ocab668800423;
                        block18: {
                            block19: {
                                if (bl) break block16;
                                ocab668800423 = ocab668800422;
                                if (bl) break block18;
                                if (ocab668800423 != null) break block19;
                                if (!bl) continue;
                            }
                            ocab668800423 = ocab668800422;
                        }
                        UUID uUID = oc9e2e8d26de.\u01b6(ocab668800423.\u0161());
                        if (uUID != null) {
                            hashSet2.add(uUID);
                        }
                        boolean bl2 = oc9e2e8d26de.\u04f3(ocab668800422);
                        if (bl || !bl2) break block20;
                        bl2 = hashSet.add(oc9e2e8d26de.\u00aa(ocab668800422.\u0165()));
                    }
                    if (!bl) continue;
                }
            }
            \u01a8 = new oc33a56dc248(Collections.unmodifiableSet(hashSet2), Collections.unmodifiableSet(hashSet), System.nanoTime());
        }
    }

    public static boolean \u03ae(UUID uUID) {
        return oc9e2e8d26de.\u04b0(uUID, null);
    }

    public static boolean \u04b0(UUID uUID, String string) {
        boolean bl;
        block15: {
            block17: {
                block16: {
                    boolean bl2;
                    oc33a56dc248 oc33a56dc2482;
                    block14: {
                        block13: {
                            long l;
                            block12: {
                                oc33a56dc2482 = \u01a8;
                                bl2 = oce490879787.\u0583;
                                long l2 = System.nanoTime() - oc33a56dc2482.\u0553 - (0xFE2AB8A61799C98CL ^ 0xFE2AB8ABEFDE918CL);
                                l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                                if (bl2) break block12;
                                if (l <= 0) break block13;
                                l = 0;
                            }
                            return (boolean)l;
                        }
                        if (uUID == null) break block14;
                        bl = oc33a56dc2482.\u0408.contains(uUID);
                        if (bl2) break block15;
                        if (bl) break block16;
                    }
                    if (string == null) break block17;
                    bl = oc33a56dc2482.\u0270.contains(oc9e2e8d26de.\u00aa(string));
                    if (bl2) break block15;
                    if (!bl) break block17;
                }
                bl = true;
                break block15;
            }
            bl = false;
        }
        return bl;
    }

    public static void \u0401() {
        \u01a8 = \u03f4;
    }

    private static boolean \u04f3(ocab66880042 ocab668800422) {
        try {
            return oce490879787.\u0167(ocab668800422.\u0165()).equals(ocab668800422.\u0161());
        }
        catch (IOException iOException) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static UUID \u01b6(String string) {
        boolean bl = oce490879787.\u0583;
        String string2 = string;
        if (!bl) {
            if (string2 == null) {
                return null;
            }
            string2 = string.replace("-", "").trim();
        }
        String string22 = string2;
        Object object = string22;
        if (bl) return UUID.fromString((String)object);
        if (((String)object).length() != (0x8461C524 ^ 0x8461C504)) {
            return null;
        }
        try {
            object = string22.substring(0, 0x8461C50C ^ 0x8461C504) + "-" + string22.substring(0x8461C50C ^ 0x8461C504, 0x8461C508 ^ 0x8461C504) + "-" + string22.substring(0x8461C508 ^ 0x8461C504, 0x8461C514 ^ 0x8461C504) + "-" + string22.substring(0x8461C514 ^ 0x8461C504, 0x8461C510 ^ 0x8461C504) + "-" + string22.substring(0x8461C510 ^ 0x8461C504);
            return UUID.fromString((String)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    private static String \u00aa(String string) {
        return string.trim().toLowerCase(Locale.ROOT);
    }

    static {
        \u01a8 = \u03f4 = new oc33a56dc248(Collections.emptySet(), Collections.emptySet(), 0L);
    }
}

