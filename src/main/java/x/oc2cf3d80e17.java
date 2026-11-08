/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import keystrokesmod.oc502dfc7784;
import keystrokesmod.script.ScriptManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.play.client.C01PacketChatMessage;
import x.G;
import x.Q;
import x.ReflectionUtils;
import x.oc00038824c1;
import x.oc020457c099;
import x.oc110d7f376c;
import x.oc151419fdfe;
import x.oc1cb76bf763;
import x.oc2c25634a7e;
import x.oc2f61179d2b;
import x.oc3dfdeebd5a;
import x.oc46245c2b20;
import x.oc56ed92c768;
import x.oc5dd058ac50;
import x.oc5e549848f3;
import x.oc61f27421d1;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc6a954e7c9f;
import x.oc718fd4d503;
import x.oc7ab2161b9f;
import x.oc7b3527f5bb;
import x.oc7d9b6bd5c4;
import x.oc83f133123b;
import x.oc8ce2882092;
import x.oc8da5ba227c;
import x.oc8eb3e96b6e;
import x.oc93ebf33b8e;
import x.oc9755810e45;
import x.oc980a49f10a;
import x.oc9adb807c19;
import x.oc9d4393f3ce;
import x.oca9cc61aada;
import x.ocadfd5cc157;
import x.ocb5d5ed49ea;
import x.ocbb165642ef;
import x.occ2557d4248;
import x.occ87a73ee8b;
import x.occ9ed06a81d;
import x.occecd0ef754;
import x.ocd6ae010123;
import x.ocd6bc26d10b;
import x.ocdd342096f8;
import x.ocdf3e495c45;
import x.ocea775c9d5c;
import x.ocf4d23d5084;

public class oc2cf3d80e17 {
    public static boolean \u0125 = false;
    public static Minecraft \u0425 = Minecraft.getMinecraft();
    private static final ScheduledExecutorService \u01b3 = Executors.newScheduledThreadPool(0x3F1AB175 ^ 0x3F1AB177, oc2cf3d80e17.\u02e3("Miau-Scheduled"));
    private static final ExecutorService \u02a1 = Executors.newCachedThreadPool(oc2cf3d80e17.\u02e3("Miau-Worker"));
    public static oc9755810e45 \u013c;
    public static oc2c25634a7e V;
    public static oc6a954e7c9f \u04ce;
    public static oc1cb76bf763 \u0565;
    public static oc7d9b6bd5c4 \u00c1;
    public static oc7b3527f5bb \u0449;
    public static occ9ed06a81d \u022c;
    public static oc151419fdfe \u0115;
    public static ocf4d23d5084 \u023b;
    public static oc3dfdeebd5a \u0156;
    public static oc020457c099 \u02ad;
    public static oc61f27421d1 \u04be;
    public static oc8da5ba227c \u0230;
    public static oc46245c2b20 \u02e1;
    public static ScriptManager \u013e;
    private static boolean \u0228;
    public static boolean \u017b;

    private static ThreadFactory \u02e3(String string) {
        AtomicInteger atomicInteger = new AtomicInteger();
        return runnable2 -> {
            Thread thread2 = new Thread(runnable2, string + "-" + atomicInteger.incrementAndGet());
            thread2.setDaemon(true);
            return thread2;
        };
    }

    public oc2cf3d80e17() {
        \u013c = new oc9755810e45();
    }

    public void \u0535() {
        block14: {
            boolean bl;
            block16: {
                block15: {
                    boolean bl2;
                    block13: {
                        oc7d9b6bd5c4 oc7d9b6bd5c42;
                        String string;
                        block12: {
                            block10: {
                                block11: {
                                    Runtime.getRuntime().addShutdownHook(new Thread(\u01b3::shutdown));
                                    Runtime.getRuntime().addShutdownHook(new Thread(\u02a1::shutdown));
                                    Runtime.getRuntime().addShutdownHook(new Thread(ocdf3e495c45.\u03dd()::\u0534));
                                    bl2 = Q.\u02a7;
                                    Runtime.getRuntime().addShutdownHook(new Thread(occ2557d4248.\u0172()::\u0117, "Miau-Discord-RPC-Shutdown"));
                                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                                        block8: {
                                            boolean bl = Q.\u02a7;
                                            try {
                                                occ87a73ee8b occ87a73ee8b2;
                                                block7: {
                                                    occ87a73ee8b2 = oc9755810e45.\u0239;
                                                    if (bl) break block7;
                                                    if (occ87a73ee8b2 == null) break block8;
                                                    occ87a73ee8b2 = oc9755810e45.\u0239;
                                                }
                                                occ87a73ee8b2.\u0503();
                                            }
                                            catch (Exception exception) {
                                                if (\u0125) {
                                                    exception.printStackTrace();
                                                }
                                            }
                                        }
                                    }));
                                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                                        block3: {
                                            ScriptManager scriptManager;
                                            block2: {
                                                boolean bl = Q.\u02a7;
                                                scriptManager = \u013e;
                                                if (bl) break block2;
                                                if (scriptManager == null) break block3;
                                                scriptManager = \u013e;
                                            }
                                            scriptManager.shutdown();
                                        }
                                    }, "Miau-Scripting-Shutdown"));
                                    ocea775c9d5c.\u0173.register(this);
                                    ocea775c9d5c.\u0173.register(new occecd0ef754());
                                    ocea775c9d5c.\u0173.register(new oc8eb3e96b6e());
                                    ocea775c9d5c.\u0173.register(ocbb165642ef.\u02a8());
                                    ocea775c9d5c.\u0173.register(new oc83f133123b());
                                    \u023b = new ocf4d23d5084();
                                    ocea775c9d5c.\u0173.register(\u023b);
                                    ocea775c9d5c.\u0173.register(new oc56ed92c768());
                                    ocea775c9d5c.\u0173.register(new ocb5d5ed49ea());
                                    ocea775c9d5c.\u0173.register(new oc5e549848f3());
                                    ocea775c9d5c.\u0173.register(new oc5dd058ac50());
                                    ocea775c9d5c.\u0173.register(G.S);
                                    ocea775c9d5c.\u0173.register(oc718fd4d503.\u014c);
                                    \u0156 = new oc3dfdeebd5a();
                                    ocea775c9d5c.\u0173.register(\u0156);
                                    \u02ad = new oc020457c099();
                                    ocea775c9d5c.\u0173.register(\u02ad);
                                    \u04be = new oc61f27421d1();
                                    ocea775c9d5c.\u0173.register(\u04be);
                                    \u0230 = new oc8da5ba227c();
                                    ocea775c9d5c.\u0173.register(\u0230);
                                    \u02e1 = new oc46245c2b20();
                                    ocea775c9d5c.\u0173.register(\u02e1);
                                    ReflectionUtils.setupFields();
                                    \u022c = new occ9ed06a81d();
                                    \u022c.\u0434();
                                    \u013c.g();
                                    oc502dfc7784.\u04a3 = \u013e = new ScriptManager();
                                    \u013e.loadScripts();
                                    ocea775c9d5c.\u0173.register(new oc2f61179d2b());
                                    V = new oc2c25634a7e();
                                    \u04ce = new oc6a954e7c9f();
                                    \u0565 = new oc1cb76bf763();
                                    \u00c1 = new oc7d9b6bd5c4();
                                    \u00c1.\u0401();
                                    string = \u00c1.\u02e2();
                                    oc7d9b6bd5c42 = \u00c1;
                                    if (bl2) break block10;
                                    if (oc7d9b6bd5c42.\u04c7(string) != null) break block11;
                                    string = "default";
                                }
                                oc7d9b6bd5c42 = \u00c1;
                            }
                            if (bl2) break block12;
                            if (oc7d9b6bd5c42.\u04c7(string) == null) break block13;
                            oc7d9b6bd5c42 = \u00c1;
                        }
                        oc7d9b6bd5c42.\u0431(string);
                    }
                    ReflectionUtils.setKeyBindings();
                    oc9755810e45.\u00f6();
                    \u02e1.\u00c4();
                    \u0449 = new oc7b3527f5bb();
                    ocd6bc26d10b.\u0214();
                    if (!bl2) break block14;
                    if (!false) break block15;
                    bl = false;
                    break block16;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0534(oc9adb807c19 oc9adb807c192) {
        boolean bl;
        boolean bl2;
        block69: {
            block68: {
                block53: {
                    boolean bl3;
                    block66: {
                        block67: {
                            Minecraft minecraft;
                            block52: {
                                block55: {
                                    boolean bl4;
                                    block54: {
                                        bl2 = Q.\u02a7;
                                        if (oc9adb807c192.\u04b0 != oc110d7f376c.END) break block53;
                                        occ2557d4248.\u0172().\u027a(\u0425);
                                        bl4 = oc7ab2161b9f.\u00d0();
                                        if (!bl2) {
                                            if (!bl4) return;
                                            bl4 = ReflectionUtils.ERROR;
                                        }
                                        if (bl2) break block54;
                                        if (!bl4) break block55;
                                        oc7ab2161b9f.\u00fd("&cThere was an error, relaunch the game.");
                                        bl4 = false;
                                    }
                                    ReflectionUtils.ERROR = bl4;
                                }
                                oc8eb3e96b6e.\u040a();
                                for (oc69da1aa7f5 oc69da1aa7f52 : new ArrayList<oc69da1aa7f5>(oc2cf3d80e17.\u00f3().\u057f())) {
                                    block65: {
                                        oc69da1aa7f5 oc69da1aa7f53;
                                        block64: {
                                            block59: {
                                                block63: {
                                                    block61: {
                                                        GuiScreen guiScreen;
                                                        block62: {
                                                            block60: {
                                                                boolean bl5;
                                                                block58: {
                                                                    Minecraft minecraft2;
                                                                    block56: {
                                                                        block57: {
                                                                            minecraft = \u0425;
                                                                            if (bl2) break block52;
                                                                            if (bl2) break block56;
                                                                            if (minecraft.currentScreen != null) break block57;
                                                                            bl5 = oc69da1aa7f52.canBeEnabled();
                                                                            if (bl2) break block58;
                                                                            if (!bl5) break block57;
                                                                            oc69da1aa7f52.z$2zw1jy3uhp6iv();
                                                                            if (!bl2) break block59;
                                                                        }
                                                                        minecraft2 = \u0425;
                                                                    }
                                                                    guiScreen = minecraft2.currentScreen;
                                                                    if (bl2) break block60;
                                                                    bl5 = guiScreen instanceof oc2c25634a7e;
                                                                }
                                                                if (bl5) break block61;
                                                                guiScreen = oc2cf3d80e17.\u0425.currentScreen;
                                                            }
                                                            if (bl2) break block62;
                                                            if (guiScreen instanceof oc6a954e7c9f) break block61;
                                                            guiScreen = oc2cf3d80e17.\u0425.currentScreen;
                                                        }
                                                        if (!(guiScreen instanceof oc1cb76bf763)) break block63;
                                                    }
                                                    oc69da1aa7f52.z$2u87utkr1isxg();
                                                    oc69da1aa7f52.\u0408();
                                                    if (!bl2) break block59;
                                                }
                                                oc69da1aa7f52.\u0408();
                                            }
                                            oc69da1aa7f53 = oc69da1aa7f52;
                                            if (bl2) break block64;
                                            if (!oc69da1aa7f53.z$3rzb3dil7uydr()) break block65;
                                            oc69da1aa7f53 = oc69da1aa7f52;
                                        }
                                        oc69da1aa7f53.z$1m9j3ewef9s();
                                    }
                                    if (!bl2) continue;
                                }
                                minecraft = \u0425;
                            }
                            bl3 = minecraft.currentScreen instanceof oc2c25634a7e;
                            if (bl2) break block66;
                            if (bl3) break block67;
                            bl3 = oc2cf3d80e17.\u0425.currentScreen instanceof oc6a954e7c9f;
                            if (bl2) break block66;
                            if (bl3) break block67;
                            bl3 = oc2cf3d80e17.\u0425.currentScreen instanceof oc1cb76bf763;
                            if (bl2) break block66;
                            if (!bl3) return;
                        }
                        bl3 = this.\u03ce();
                    }
                    if (!bl3) return;
                    V.\u015c();
                    if (!bl2) return;
                }
                oc8eb3e96b6e.\u0458();
                if (oc2cf3d80e17.\u0425.currentScreen != null) break block68;
                bl = oc7ab2161b9f.\u00d0();
                if (bl2) break block69;
                if (bl) {
                    for (oc151419fdfe oc151419fdfe2 : oc2cf3d80e17.\u00c1.\u01f9) {
                        if (bl2) return;
                        oc151419fdfe2.\u01da().z$2zw1jy3uhp6iv();
                        if (!bl2) continue;
                    }
                    if (!bl2) return;
                }
            }
            bl = oc7ab2161b9f.\u00d0();
        }
        if (!bl) return;
        Iterator<Object> iterator2 = oc2cf3d80e17.\u00c1.\u01f9.iterator();
        do {
            if (!iterator2.hasNext()) return;
            oc151419fdfe oc151419fdfe3 = iterator2.next();
            oc151419fdfe3.\u01da().\u0408();
        } while (!bl2);
    }

    @oc66fa4f2195
    public void \u056d(oc00038824c1 oc00038824c12) {
        oc9755810e45.\u00f6();
        this.\u03ce();
        V.\u015c();
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u013f(oc9d4393f3ce oc9d4393f3ce2) {
        block19: {
            Minecraft minecraft;
            String string;
            block17: {
                block18: {
                    boolean bl;
                    block15: {
                        block16: {
                            block14: {
                                bl = Q.\u02a7;
                                if (oc9d4393f3ce2.\u025f() instanceof C01PacketChatMessage && \u0449 != null) break block14;
                                return;
                            }
                            string = ((C01PacketChatMessage)oc9d4393f3ce2.\u025f()).getMessage();
                            if (bl) break block15;
                            if (\u0449.\u01a4(string)) break block16;
                            return;
                        }
                        oc9d4393f3ce2.setCanceled(true);
                    }
                    minecraft = \u0425;
                    if (bl) break block17;
                    if (!minecraft.isCallingFromMinecraftThread()) break block18;
                    \u0449.\u014a(string);
                    if (!bl) break block19;
                }
                minecraft = \u0425;
            }
            minecraft.addScheduledTask(() -> \u0449.\u014a(string));
        }
    }

    @oc66fa4f2195
    public void \u03a8(oc980a49f10a oc980a49f10a2) {
        this.\u03ce();
        V.\u015c();
        oc2cf3d80e17.\u04eb();
    }

    @oc66fa4f2195
    public void \u0502(ocadfd5cc157 ocadfd5cc1572) {
        block6: {
            oc61f27421d1 oc61f27421d12;
            block9: {
                boolean bl;
                block8: {
                    oc020457c099 oc020457c0992;
                    block7: {
                        bl = Q.\u02a7;
                        if (ocadfd5cc1572.\u0426 != oc2cf3d80e17.\u0425.thePlayer) break block6;
                        \u0228 = true;
                        oc93ebf33b8e.\u0195().\u0504();
                        ocd6ae010123.\u02b3();
                        oc020457c0992 = \u02ad;
                        if (bl) break block7;
                        if (oc020457c0992 == null) break block8;
                        oc020457c0992 = \u02ad;
                    }
                    oc020457c0992.\u01c7();
                }
                oc61f27421d12 = \u04be;
                if (bl) break block9;
                if (oc61f27421d12 == null) break block6;
                oc61f27421d12 = \u04be;
            }
            oc61f27421d12.\u040b(false);
        }
    }

    public static oc9755810e45 \u00f3() {
        return \u013c;
    }

    public static void \u04eb() {
        block7: {
            block8: {
                oc151419fdfe oc151419fdfe2;
                boolean bl;
                block6: {
                    bl = Q.\u02a7;
                    oc151419fdfe2 = \u0115;
                    if (bl) break block6;
                    if (oc151419fdfe2 == null) break block7;
                    oc151419fdfe2 = \u0115;
                }
                if (bl) break block8;
                if (oc151419fdfe2.\u01da() == null) break block7;
                oc151419fdfe2 = \u0115;
            }
            oc151419fdfe2.\u01da().\u018b = false;
        }
    }

    public static ScheduledExecutorService \u02af() {
        return \u01b3;
    }

    public static ExecutorService P() {
        return \u02a1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void \u012d() {
        boolean bl;
        block31: {
            block29: {
                Minecraft minecraft;
                block30: {
                    GuiScreen guiScreen;
                    block28: {
                        Minecraft minecraft2;
                        block24: {
                            block25: {
                                bl = Q.\u02a7;
                                if (!oc7ab2161b9f.\u00d0()) {
                                    return;
                                }
                                oc8eb3e96b6e.\u040a();
                                minecraft2 = \u0425;
                                if (bl) break block24;
                                if (minecraft2.currentScreen != null) break block25;
                                for (oc69da1aa7f5 oc69da1aa7f52 : oc2cf3d80e17.\u00f3().\u057f()) {
                                    block27: {
                                        oc69da1aa7f5 oc69da1aa7f53;
                                        block26: {
                                            if (bl) return;
                                            oc69da1aa7f53 = oc69da1aa7f52;
                                            if (bl) break block26;
                                            if (!oc69da1aa7f53.canBeEnabled()) break block27;
                                            oc69da1aa7f53 = oc69da1aa7f52;
                                        }
                                        oc69da1aa7f53.z$2zw1jy3uhp6iv();
                                    }
                                    if (!bl) continue;
                                }
                                if (!bl) return;
                            }
                            minecraft2 = \u0425;
                        }
                        guiScreen = minecraft2.currentScreen;
                        if (bl) break block28;
                        if (guiScreen instanceof oc2c25634a7e) break block29;
                        minecraft = \u0425;
                        if (bl) break block30;
                        guiScreen = minecraft.currentScreen;
                    }
                    if (guiScreen instanceof oc6a954e7c9f) break block29;
                    minecraft = \u0425;
                }
                if (!(minecraft.currentScreen instanceof oc1cb76bf763)) break block31;
            }
            for (oc69da1aa7f5 oc69da1aa7f52 : oc2cf3d80e17.\u00f3().\u057f()) {
                oc69da1aa7f52.z$2u87utkr1isxg();
                if (bl) return;
                oc69da1aa7f52.\u0408();
                if (!bl) continue;
            }
            if (!bl) return;
        }
        for (oc69da1aa7f5 oc69da1aa7f52 : oc2cf3d80e17.\u00f3().\u057f()) {
            oc69da1aa7f52.\u0408();
            if (!bl) continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u03ce() {
        double d;
        boolean bl;
        block21: {
            double d2;
            double d3;
            oca9cc61aada oca9cc61aada2;
            boolean bl2;
            block19: {
                block20: {
                    oca9cc61aada oca9cc61aada3;
                    oca9cc61aada oca9cc61aada4;
                    oca9cc61aada oca9cc61aada5;
                    block18: {
                        block17: {
                            ocdd342096f8 ocdd342096f82;
                            block15: {
                                block16: {
                                    bl2 = Q.\u02a7;
                                    ocdd342096f82 = oc9755810e45.\u00ff;
                                    if (bl2) break block15;
                                    if (ocdd342096f82 != null) break block16;
                                    return false;
                                }
                                ocdd342096f82 = oc9755810e45.\u00ff;
                            }
                            oca9cc61aada5 = ocdd342096f82.Q();
                            oca9cc61aada4 = oc9755810e45.\u00ff.\u015f();
                            oca9cc61aada2 = oc9755810e45.\u00ff.E();
                            oca9cc61aada3 = oca9cc61aada5;
                            if (bl2) break block17;
                            if (oca9cc61aada3 == null) return false;
                            oca9cc61aada3 = oca9cc61aada4;
                        }
                        if (bl2) break block18;
                        if (oca9cc61aada3 == null) return false;
                        oca9cc61aada3 = oca9cc61aada2;
                    }
                    if (oca9cc61aada3 == null) {
                        return false;
                    }
                    bl = false;
                    double d4 = oca9cc61aada5.\u04c1();
                    d3 = oca9cc61aada4.\u04c1();
                    d2 = d3;
                    if (bl2) break block19;
                    if (!(d2 < d4)) break block20;
                    oca9cc61aada4.\u021e(d4);
                    d3 = oca9cc61aada4.\u04c1();
                    bl = true;
                }
                d2 = oca9cc61aada2.\u04c1();
            }
            double d5 = d2 - d3;
            d = d5 == 0.0 ? 0 : (d5 < 0.0 ? -1 : 1);
            if (bl2) return (boolean)d;
            if (d >= 0) break block21;
            oca9cc61aada2.\u021e(d3);
            return (boolean)1.0;
        }
        d = (double)bl;
        return (boolean)d;
    }

    static {
        \u0228 = false;
    }
}

