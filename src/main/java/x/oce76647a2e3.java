/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;
import x.oc54714bd439;
import x.oc804fdd8d75;
import x.ocb8a733cf81;
import x.ocd4bd33822b;
import x.ocd6bc26d10b;
import x.ocf130f74f2a;
import x.ocfc2b827e17;

public class oce76647a2e3
extends GuiScreen {
    private static final Pattern \u01e3 = Pattern.compile("M\\.C[A-Za-z0-9._!*$\\-]{47,}");
    private final GuiScreen \u04d3;
    private GuiTextField \u03e1;
    private GuiButton \u042b;
    private GuiButton \u0174;
    private ExecutorService \u0186;
    private CompletableFuture<Void> \u0545;
    private String \u01f5 = "&7Paste one or more Microsoft refresh tokens.&r";
    public static boolean \u03d4;

    public oce76647a2e3(GuiScreen guiScreen) {
        this.\u04d3 = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        int n = Math.min(0x19224494 ^ 0x192245FC, this.width - (0x192245D4 ^ 0x192245FC));
        this.\u03e1 = new GuiTextField(0, this.fontRendererObj, this.width / (0x192245FE ^ 0x192245FC) - n / (0x192245FE ^ 0x192245FC), this.height / (0x192245FE ^ 0x192245FC) - (0x192245F0 ^ 0x192245FC), n, 0x192245E8 ^ 0x192245FC);
        this.\u03e1.setMaxStringLength(0x1922BA03 ^ 0x192245FC);
        this.\u03e1.setFocused(true);
        this.\u042b = new GuiButton(0, this.width / (0x192245FE ^ 0x192245FC) - (0x1922459A ^ 0x192245FC), this.height / (0x192245FE ^ 0x192245FC) + (0x192245EE ^ 0x192245FC), 0x19224598 ^ 0x192245FC, 0x192245E8 ^ 0x192245FC, "Import");
        this.buttonList.add(this.\u042b);
        this.\u0174 = new GuiButton(1, this.width / (0x192245FE ^ 0x192245FC) + (0x192245FE ^ 0x192245FC), this.height / (0x192245FE ^ 0x192245FC) + (0x192245EE ^ 0x192245FC), 0x19224598 ^ 0x192245FC, 0x192245E8 ^ 0x192245FC, "Cancel");
        this.buttonList.add(this.\u0174);
    }

    @Override
    public void onGuiClosed() {
        block15: {
            oce76647a2e3 oce76647a2e32;
            block14: {
                boolean bl;
                block12: {
                    block13: {
                        Keyboard.enableRepeatEvents(false);
                        bl = ocf130f74f2a.\u02a1;
                        oce76647a2e32 = this;
                        if (bl) break block12;
                        if (oce76647a2e32.\u0545 == null) break block13;
                        oce76647a2e32 = this;
                        if (bl) break block12;
                        if (oce76647a2e32.\u0545.isDone()) break block13;
                        this.\u0545.cancel(true);
                    }
                    oce76647a2e32 = this;
                }
                if (bl) break block14;
                if (oce76647a2e32.\u0186 == null) break block15;
                oce76647a2e32 = this;
            }
            oce76647a2e32.\u0186.shutdownNow();
        }
    }

    @Override
    public void updateScreen() {
        this.\u03e1.updateCursorCounter();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Refresh Token Import", this.width / (0xCD3FFF7D ^ 0xCD3FFF7F), this.height / (0xCD3FFF7D ^ 0xCD3FFF7F) - (0xCD3FFF4B ^ 0xCD3FFF7F), -1);
        this.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4(this.\u01f5), this.width / (0xCD3FFF7D ^ 0xCD3FFF7F), this.height / (0xCD3FFF7D ^ 0xCD3FFF7F) - (0xCD3FFF5B ^ 0xCD3FFF7F), -1);
        this.drawCenteredString(this.fontRendererObj, "Separate tokens with spaces, commas, or new lines", this.width / (0xCD3FFF7D ^ 0xCD3FFF7F), this.height / (0xCD3FFF7D ^ 0xCD3FFF7F) - (0xCD3FFF67 ^ 0xCD3FFF7F), 0x329555D5 ^ 0xCD3FFF7F);
        this.\u03e1.drawTextBox();
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        super.mouseClicked(n, n2, n3);
        this.\u03e1.mouseClicked(n, n2, n3);
    }

    @Override
    protected void keyTyped(char c, int n) {
        block15: {
            int n2;
            block16: {
                int n3;
                boolean bl;
                block13: {
                    block14: {
                        bl = ocf130f74f2a.\u02a1;
                        n3 = n;
                        if (bl) break block13;
                        if (n3 != 1) break block14;
                        this.actionPerformed(this.\u0174);
                        return;
                    }
                    n2 = n;
                    if (bl) break block15;
                    n3 = GuiScreen.isKeyComboCtrlV(n2) ? 1 : 0;
                }
                if (n3 == 0) break block16;
                this.\u03e1.writeText(GuiScreen.getClipboardString().replaceAll("\\s+", " "));
                if (!bl) break block15;
            }
            n2 = this.\u03e1.textboxKeyTyped(c, n) ? 1 : 0;
        }
        if (n == (0x1C84FCA1 ^ 0x1C84FCBD)) {
            this.actionPerformed(this.\u042b);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiButton guiButton2;
        block15: {
            block16: {
                boolean bl;
                block13: {
                    block14: {
                        block12: {
                            bl = ocf130f74f2a.\u02a1;
                            guiButton2 = guiButton;
                            if (bl) break block12;
                            if (guiButton2 == null) return;
                            guiButton2 = guiButton;
                        }
                        if (bl) break block13;
                        if (guiButton2.enabled) break block14;
                        return;
                    }
                    guiButton2 = guiButton;
                }
                if (bl) break block15;
                if (guiButton2.id != 1) break block16;
                this.mc.displayGuiScreen(this.\u04d3);
                return;
            }
            guiButton2 = guiButton;
        }
        if (guiButton2.id != 0) return;
        this.\u0276(this.\u03e1.getText());
        return;
    }

    private void \u0276(String string) {
        block29: {
            Object object;
            List<String> list;
            boolean bl;
            block27: {
                oce76647a2e3 oce76647a2e32;
                block28: {
                    block26: {
                        block25: {
                            block24: {
                                block23: {
                                    block22: {
                                        oce76647a2e3 oce76647a2e33;
                                        block21: {
                                            bl = ocf130f74f2a.\u02a1;
                                            oce76647a2e33 = this;
                                            if (bl) break block21;
                                            if (oce76647a2e33.\u0545 == null) break block22;
                                            oce76647a2e33 = this;
                                        }
                                        if (!oce76647a2e33.\u0545.isDone()) {
                                            return;
                                        }
                                    }
                                    list = oce76647a2e3.\u0587(string);
                                    if (bl) break block23;
                                    if (!list.isEmpty()) break block24;
                                    this.\u01f5 = "&cNo valid refresh tokens found.&r";
                                }
                                return;
                            }
                            oce76647a2e32 = this;
                            if (bl) break block25;
                            if (oce76647a2e32.\u0186 == null) break block26;
                            oce76647a2e32 = this;
                        }
                        if (bl) break block27;
                        if (!oce76647a2e32.\u0186.isShutdown()) break block28;
                    }
                    object = new AtomicInteger();
                    this.\u0186 = Executors.newFixedThreadPool(Math.min(0x4F3D0CCB ^ 0x4F3D0CC8, list.size()), arg_0 -> oce76647a2e3.q37u9czyf3t0v3((AtomicInteger)object, arg_0));
                }
                this.\u042b.enabled = false;
                this.\u03e1.setEnabled(false);
                oce76647a2e32 = this;
            }
            oce76647a2e32.\u01f5 = "&eImporting " + list.size() + " account(s)...&r";
            object = Collections.synchronizedList(new ArrayList());
            AtomicInteger atomicInteger = new AtomicInteger();
            CompletableFuture[] completableFutureArray = new CompletableFuture[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                completableFutureArray[i] = ((CompletableFuture)ocd4bd33822b.\u047f(list.get(i), this.\u0186).thenAccept(((List)object)::add)).exceptionally(throwable -> {
                    atomicInteger.incrementAndGet();
                    return null;
                });
                if (!bl) {
                    if (!bl) continue;
                    break;
                }
                break block29;
            }
            this.\u0545 = ((CompletableFuture)CompletableFuture.allOf(completableFutureArray).thenRunAsync(() -> oce76647a2e3.qs5vl1qyjktja((List)object), this.\u0186)).whenComplete((arg_0, arg_1) -> this.q1xzbuqbkp9hfc((List)object, atomicInteger, arg_0, arg_1));
        }
    }

    private void \u0569(int n, int n2, Throwable throwable) {
        block27: {
            block28: {
                String string;
                boolean bl;
                block26: {
                    int n3;
                    block24: {
                        block25: {
                            block20: {
                                block21: {
                                    Object object;
                                    block23: {
                                        block22: {
                                            block19: {
                                                bl = ocf130f74f2a.\u02a1;
                                                if (this.mc.currentScreen != this) {
                                                    return;
                                                }
                                                if (throwable != null) break block19;
                                                n3 = n;
                                                if (bl) break block20;
                                                if (n3 != 0) break block21;
                                            }
                                            oce76647a2e3 oce76647a2e32 = this;
                                            if (throwable != null) break block22;
                                            object = "&cFailed to import " + n2 + " account(s).&r";
                                            break block23;
                                        }
                                        object = "&cRefresh-token import failed.&r";
                                    }
                                    oce76647a2e32.\u01f5 = object;
                                    this.\u042b.enabled = true;
                                    this.\u03e1.setEnabled(true);
                                    return;
                                }
                                n3 = n2;
                            }
                            if (bl) break block24;
                            if (n3 != 0) break block25;
                            string = "&aImported " + n + " account(s).&r";
                            break block26;
                        }
                        n3 = n;
                    }
                    string = "&aImported " + n3 + " account(s), &cfailed " + n2 + ".&r";
                }
                String string2 = string;
                if (bl) break block27;
                if (!(this.\u04d3 instanceof ocfc2b827e17)) break block28;
                ((ocfc2b827e17)this.\u04d3).\u04bd(new ocb8a733cf81(oc54714bd439.\u01e4(string2), 0x13BA13CFFF34E700L ^ 0x13BA13CFFF34F488L));
            }
            this.mc.displayGuiScreen(this.\u04d3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static List<String> \u0587(String string) {
        String string2;
        boolean bl;
        block8: {
            bl = ocf130f74f2a.\u02a1;
            string2 = string;
            if (bl) break block8;
            if (string2 == null) return Collections.emptyList();
            string2 = string.trim();
        }
        if (string2.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        Matcher matcher = \u01e3.matcher(string);
        while (matcher.find()) {
            linkedHashSet.add(matcher.group());
            if (!bl) continue;
        }
        return new ArrayList<String>(linkedHashSet);
    }

    private /* synthetic */ void q1xzbuqbkp9hfc(List list, AtomicInteger atomicInteger, Void void_, Throwable throwable) {
        this.mc.addScheduledTask(() -> this.\u0569(list.size(), atomicInteger.get(), throwable));
    }

    private static /* synthetic */ void qs5vl1qyjktja(List list) {
        ocd6bc26d10b.\u04f5(new ArrayList<oc804fdd8d75>(list));
    }

    private static /* synthetic */ Thread q37u9czyf3t0v3(AtomicInteger atomicInteger, Runnable runnable2) {
        Thread thread2 = new Thread(runnable2, "Mimeow-Refresh-Import-" + atomicInteger.incrementAndGet());
        thread2.setDaemon(true);
        return thread2;
    }
}

