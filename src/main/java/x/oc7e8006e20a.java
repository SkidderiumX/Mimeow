/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.IChatComponent;
import x.oc02e6d57a60;
import x.oc2f61de30bc;
import x.oc4d46a99983;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.ocadfd5cc157;
import x.oce4cea752dd;
import x.ocfa11b18c57;

public class oc7e8006e20a
extends oc69da1aa7f5 {
    private oca9cc61aada \u03b5;
    private String \u049b = "";
    private long \u0584 = 0L;
    public static boolean \u0501;

    public oc7e8006e20a() {
        super("AutoRequeue", oce4cea752dd.\u0502);
        this.\u0105("Automatically queues another game after a match ends.");
        this.\u028c(new oc4d46a99983("Automatically requeues games."));
        this.\u03b5 = new oca9cc61aada("Delay", " second", 0.5, 0.0, 5.0, 0.1);
        this.\u028c(this.\u03b5);
        this.\u026e = true;
    }

    @Override
    public void onDisable() {
        this.\u049b = "";
    }

    @oc66fa4f2195
    public void I(oc2f61de30bc oc2f61de30bc2) {
        block8: {
            int n;
            block7: {
                int n2 = ocfa11b18c57.\u0117;
                n = this.\u049b.isEmpty();
                if (n2 != 0) break block7;
                if (n != 0) break block8;
                double d = (double)(System.currentTimeMillis() - this.\u0584) - this.\u03b5.\u04c1() * 1000.0;
                n = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
            }
            if (n >= 0) {
                oc69da1aa7f5.\u0151.thePlayer.sendChatMessage(this.\u049b);
                this.\u049b = "";
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u04f9(oc02e6d57a60 oc02e6d57a602) {
        oc02e6d57a60 oc02e6d57a603;
        int n;
        block36: {
            String string;
            block35: {
                byte by;
                block34: {
                    n = ocfa11b18c57.\u0117;
                    by = oc02e6d57a602.\u03c1;
                    if (n != 0) break block34;
                    if (by == (0xF13877B4 ^ 0xF13877B6)) return;
                    by = (byte)(oc7ab2161b9f.\u00d0() ? 1 : 0);
                }
                if (by == 0) {
                    return;
                }
                String string2 = oc7ab2161b9f.\u045b(oc02e6d57a602.\u01eb.getUnformattedText());
                string = string2;
                if (n != 0) break block35;
                if (string.isEmpty()) return;
                string = string2;
            }
            if (!string.contains("play again")) {
                return;
            }
            oc02e6d57a603 = oc02e6d57a602;
            if (n != 0) break block36;
            if (oc02e6d57a603.\u01eb == null) return;
            oc02e6d57a603 = oc02e6d57a602;
        }
        for (IChatComponent iChatComponent : oc02e6d57a603.\u01eb.getSiblings()) {
            block38: {
                IChatComponent iChatComponent2;
                block41: {
                    block40: {
                        block39: {
                            block37: {
                                iChatComponent2 = iChatComponent;
                                if (n != 0) break block37;
                                if (iChatComponent2 == null) break block38;
                                iChatComponent2 = iChatComponent;
                            }
                            if (n != 0) break block39;
                            if (!iChatComponent2.getFormattedText().contains("Click here")) break block38;
                            iChatComponent2 = iChatComponent;
                        }
                        if (n != 0) break block40;
                        if (iChatComponent2.getChatStyle() == null) break block38;
                        iChatComponent2 = iChatComponent;
                    }
                    if (n != 0) break block41;
                    if (iChatComponent2.getChatStyle().getChatClickEvent() == null) break block38;
                    iChatComponent2 = iChatComponent;
                }
                if (iChatComponent2.getChatStyle().getChatClickEvent().getValue().startsWith("/")) {
                    this.\u049b = iChatComponent.getChatStyle().getChatClickEvent().getValue();
                    this.\u0584 = System.currentTimeMillis();
                }
            }
            if (n == 0) continue;
        }
    }

    @oc66fa4f2195
    public void \u0459(ocadfd5cc157 ocadfd5cc1572) {
        if (ocadfd5cc1572.\u0426 == oc69da1aa7f5.\u0151.thePlayer) {
            this.\u049b = "";
        }
    }
}

