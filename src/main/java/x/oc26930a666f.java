/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import x.oc2cf3d80e17;
import x.oc41720aed4a;
import x.oc7d9b6bd5c4;
import x.oc835693ee7c;
import x.oc9e5a7eeec6;

public class oc26930a666f {
    private static final ExecutorService \u0495;
    private final Minecraft \u041f = Minecraft.getMinecraft();
    private final oc835693ee7c \u0218;
    public static boolean \u0404;
    private static final String a;

    public oc26930a666f() {
        this(new oc835693ee7c());
    }

    oc26930a666f(oc835693ee7c oc835693ee7c2) {
        this.\u0218 = oc835693ee7c2;
    }

    public void \u04e6(oc9e5a7eeec6 oc9e5a7eeec62, Consumer<List<oc41720aed4a>> consumer, Consumer<String> consumer2) {
        \u0495.execute(() -> {
            try {
                List<oc41720aed4a> list = this.\u0218.\u02b4(oc9e5a7eeec62);
                this.\u041f.addScheduledTask(() -> consumer.accept(list));
            }
            catch (Exception exception) {
                String string = oc26930a666f.\u04c4(exception);
                this.\u041f.addScheduledTask(() -> consumer2.accept(string));
            }
        });
    }

    public void \u0160(oc9e5a7eeec6 oc9e5a7eeec62, oc41720aed4a oc41720aed4a2, Consumer<Boolean> consumer, Consumer<String> consumer2) {
        long l = 0xC949C6D612DD8CA9L ^ 0xC94989A7F7DC15E1L;
        long l2 = l ^ (0xC949ED6BEF740DB8L ^ 0xC94989A7F7DC15E1L);
        int n = (int)(l2 >>> (0x88DF0CC7 ^ 0x88DF0CE7));
        int n2 = (int)(l2 << (0x88DF0CC7 ^ 0x88DF0CE7) >>> (0x88DF0CD7 ^ 0x88DF0CE7));
        int n3 = (int)(l2 << (0x88DF0CD7 ^ 0x88DF0CE7) >>> (0x88DF0CD7 ^ 0x88DF0CE7));
        \u0495.execute(() -> this.qdzym2pju9m0y(oc9e5a7eeec62, oc41720aed4a2, n, consumer, (short)n2, n3, consumer2));
    }

    static String \u04c4(Exception exception) {
        Object object;
        block16: {
            String string;
            String string2;
            block14: {
                boolean bl;
                block15: {
                    String string3;
                    block12: {
                        block13: {
                            string2 = exception.getMessage();
                            bl = oc9e5a7eeec6.\u039d;
                            string3 = string2;
                            if (bl) break block12;
                            if (string3 == null) break block13;
                            string = string2;
                            if (bl) break block14;
                            if (!string.trim().isEmpty()) break block15;
                        }
                        string3 = "Unknown error";
                    }
                    return string3;
                }
                object = string2.replaceAll("\\s+", " ").trim();
                if (bl) break block16;
                string = string2 = object;
            }
            object = string.length() > (0xA4D68DAC ^ 0xA4D68DFC) ? string2.substring(0, 0xA4D68DAC ^ 0xA4D68DFC) + "..." : string2;
        }
        return object;
    }

    private /* synthetic */ void qdzym2pju9m0y(oc9e5a7eeec6 oc9e5a7eeec62, oc41720aed4a oc41720aed4a2, int n, Consumer consumer, short s, int n2, Consumer consumer2) {
        long l = (long)n << (0x8858BCC0 ^ 0x8858BCE0) | (long)s << (0x8858BCD0 ^ 0x8858BCE0) >>> (0x8858BCC0 ^ 0x8858BCE0) | (long)n2 << (0x8858BCD0 ^ 0x8858BCE0) >>> (0x8858BCD0 ^ 0x8858BCE0);
        long l2 = l ^ (0xCF5E68424EC3ACE3L ^ 0xCF5E38712B641214L);
        try {
            String string = this.\u0218.S(oc9e5a7eeec62, oc41720aed4a2.\u01d2());
            this.\u041f.addScheduledTask(() -> {
                boolean bl;
                Consumer consumer2_r;
                block6: {
                    block5: {
                        oc7d9b6bd5c4 oc7d9b6bd5c42;
                        boolean bl2;
                        block4: {
                            bl2 = oc9e5a7eeec6.\u039d;
                            consumer2_r = consumer;
                            oc7d9b6bd5c42 = oc2cf3d80e17.\u00c1;
                            if (l2 < 1L || bl2) break block4;
                            if (oc7d9b6bd5c42 == null) break block5;
                            oc7d9b6bd5c42 = oc2cf3d80e17.\u00c1;
                        }
                        bl = oc7d9b6bd5c42.\u0386(string);
                        if (bl2) break block6;
                        if (!bl) break block5;
                        bl = true;
                        break block6;
                    }
                    bl = false;
                }
                consumer2_r.accept(bl);
            });
        }
        catch (Exception exception) {
            String string = oc26930a666f.\u04c4(exception);
            this.\u041f.addScheduledTask(() -> consumer2.accept(string));
        }
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    static {
        char[] cArray;
        long l;
        block12: {
            int n;
            int n2;
            char[] cArray2;
            int n3;
            block11: {
                long l2 = 0x6007A1D66EAB519BL ^ 0x6007ADE98C7C9A4EL;
                l = l2 ^ (0x6007F4184D276288L ^ 0x6007ADE98C7C9A4EL);
                char[] cArray3 = "\u0013\u000f2e\u0007!j2\u000f=u\u0007-k0\u0000:wY".toCharArray();
                n3 = 0;
                int n4 = cArray3.length;
                cArray2 = cArray3;
                n2 = n4;
                if (n4 <= 1) break block11;
                cArray = cArray2;
                n = n2;
                if (n2 <= n3) break block12;
            }
            do {
                char[] cArray4 = cArray2;
                char[] cArray5 = cArray2;
                int n5 = n3;
                while (true) {
                    char c = cArray4[n5];
                    cArray4[n5] = (char)(c ^ (switch (n3 % (0xD2EA7F57 ^ 0xD2EA7F50)) {
                        case 0 -> 0xD2EA7F0E ^ 0xD2EA7F50;
                        case 1 -> 0xD2EA7F36 ^ 0xD2EA7F50;
                        case 2 -> 0xD2EA7F03 ^ 0xD2EA7F50;
                        case 3 -> 0xD2EA7F40 ^ 0xD2EA7F50;
                        case 4 -> 0xD2EA7F7A ^ 0xD2EA7F50;
                        case 5 -> 0xD2EA7F3E ^ 0xD2EA7F50;
                        default -> 0xD2EA7F54 ^ 0xD2EA7F50;
                    }));
                    ++n3;
                    cArray2 = cArray5;
                    n2 = n2;
                    if (n2 != 0) break;
                    cArray5 = cArray2;
                    n = n2;
                    n5 = n2;
                    cArray4 = cArray2;
                }
                cArray = cArray2;
                n = n2;
            } while (n2 > n3);
        }
        a = new String(cArray).intern();
        \u0495 = Executors.newSingleThreadExecutor(runnable2 -> {
            Thread thread2 = new Thread(runnable2, a);
            thread2.setDaemon(true);
            return thread2;
        });
    }
}

