/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import x.oc0c67416e8a;
import x.oc5d7fc2795f;
import x.oc804fdd8d75;

public class ocb7a9bf3f2f {
    private static final String l;
    private final oc5d7fc2795f \u045b;
    private final String \u0376;
    private final String \u01cd;
    private final String \u015c;
    private HttpServer \u0518;
    private ThreadPoolExecutor \u0547;
    public static boolean E;
    private static final String a;

    public ocb7a9bf3f2f(oc5d7fc2795f oc5d7fc2795f2, String string, String string2, String string3) throws IOException {
        long l = 0x9FC61E3D2B647DF3L ^ 0x9FC60EA209EA1EB2L;
        long l2 = l ^ (0x9FC6722F37343BB7L ^ 0x9FC60EA209EA1EB2L);
        int n = (int)(l2 >>> (0xE54FBB37 ^ 0xE54FBB17));
        int n2 = (int)(l2 << (0xE54FBB37 ^ 0xE54FBB17) >>> (0xE54FBB27 ^ 0xE54FBB17));
        int n3 = (int)(l2 << (0xE54FBB27 ^ 0xE54FBB17) >>> (0xE54FBB27 ^ 0xE54FBB17));
        this.\u045b = oc5d7fc2795f2;
        this.\u0376 = string;
        this.\u01cd = string2;
        this.\u015c = string3;
        this.\u0518 = HttpServer.create(new InetSocketAddress("localhost", 0xE54FEE88 ^ 0xE54FBB17), 0);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.\u0547 = (ThreadPoolExecutor)Executors.newFixedThreadPool(0xE54FBB15 ^ 0xE54FBB17, arg_0 -> ocb7a9bf3f2f.q1942tq9aq6uh4(n, (char)n2, atomicInteger, n3, arg_0));
    }

    public void \u0189() {
        this.\u0518.createContext("/login", new oc0c67416e8a(this));
        this.\u0518.setExecutor(this.\u0547);
        this.\u0518.start();
        String string = "https://login.live.com/oauth20_authorize.srf?client_id=<client_id>&redirect_uri=<redirect_uri>&response_type=code&display=touch&scope=<scope>&prompt=select_account".replace("<client_id>", this.\u0376).replace("<redirect_uri>", this.\u01cd).replace("<scope>", this.\u015c);
        this.\u045b.z$1op0p3awms9xf(string);
    }

    public synchronized void \u01bc(boolean bl) {
        block14: {
            block13: {
                ocb7a9bf3f2f ocb7a9bf3f2f2;
                int n;
                block11: {
                    block12: {
                        n = oc804fdd8d75.\u0186;
                        ocb7a9bf3f2f2 = this;
                        if (n != 0) break block11;
                        if (ocb7a9bf3f2f2.\u0518 == null) break block12;
                        this.\u0518.stop(0);
                        this.\u0518 = null;
                    }
                    ocb7a9bf3f2f2 = this;
                }
                if (n != 0) break block13;
                if (ocb7a9bf3f2f2.\u0547 == null) break block14;
                this.\u0547.shutdownNow();
                ocb7a9bf3f2f2 = this;
            }
            ocb7a9bf3f2f2.\u0547 = null;
        }
        if (bl) {
            this.\u045b.z$1fihlpu2c23e3("Has been interrupted");
        }
    }

    static Map<String, String> \u040a(String string) {
        HashMap<String, String> hashMap;
        block8: {
            String string2;
            int n;
            block7: {
                hashMap = new HashMap<String, String>();
                n = oc804fdd8d75.\u0186;
                string2 = string;
                if (n != 0) break block7;
                if (string2 == null) break block8;
                string2 = string;
            }
            String[] stringArray = string2.split("&");
            int n2 = stringArray.length;
            int n3 = 0;
            while (n3 < n2) {
                block9: {
                    block10: {
                        String string3 = stringArray[n3];
                        String[] stringArray2 = string3.split("=", 0x2FDDD944 ^ 0x2FDDD946);
                        if (n != 0) break block9;
                        if (stringArray2.length != (0x2FDDD944 ^ 0x2FDDD946)) break block10;
                        hashMap.put(URLDecoder.decode(stringArray2[0], StandardCharsets.UTF_8), URLDecoder.decode(stringArray2[1], StandardCharsets.UTF_8));
                    }
                    ++n3;
                }
                if (n == 0) continue;
            }
        }
        return hashMap;
    }

    private static /* synthetic */ Thread q1942tq9aq6uh4(int n, char c, AtomicInteger atomicInteger, int n2, Runnable runnable2) {
        long l = (long)n << (0x5A7FD8E9 ^ 0x5A7FD8C9) | (long)c << (0x5A7FD8F9 ^ 0x5A7FD8C9) >>> (0x5A7FD8E9 ^ 0x5A7FD8C9) | (long)n2 << (0x5A7FD8F9 ^ 0x5A7FD8C9) >>> (0x5A7FD8F9 ^ 0x5A7FD8C9);
        Thread thread2 = new Thread(runnable2, a + atomicInteger.incrementAndGet());
        thread2.setDaemon(true);
        return thread2;
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    static {
        char[] cArray;
        block12: {
            int n;
            int n2;
            char[] cArray2;
            int n3;
            block11: {
                l = "https://login.live.com/oauth20_authorize.srf?client_id=<client_id>&redirect_uri=<redirect_uri>&response_type=code&display=touch&scope=<scope>&prompt=select_account";
                char[] cArray3 = "\u0012U\u001d\u001dWm\u001b\u0010}\u0005\fP7".toCharArray();
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
                    cArray4[n5] = (char)(c ^ (switch (n3 % (0xE23F501F ^ 0xE23F5018)) {
                        case 0 -> 0xE23F5047 ^ 0xE23F5018;
                        case 1 -> 0xE23F5024 ^ 0xE23F5018;
                        case 2 -> 0xE23F5068 ^ 0xE23F5018;
                        case 3 -> 0xE23F5060 ^ 0xE23F5018;
                        case 4 -> 0xE23F5020 ^ 0xE23F5018;
                        case 5 -> 0xE23F5002 ^ 0xE23F5018;
                        default -> 0xE23F502E ^ 0xE23F5018;
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
    }
}

