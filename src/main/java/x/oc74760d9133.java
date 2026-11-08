/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.apache.commons.lang3.RandomStringUtils;
import x.oc4d1e5c5d41;
import x.oc54714bd439;
import x.oc804fdd8d75;
import x.ocb616b6fa2e;
import x.ocb8a733cf81;
import x.occ791aa07d0;
import x.ocd6bc26d10b;
import x.ocf130f74f2a;
import x.ocfc2b827e17;

public class oc74760d9133
extends GuiScreen {
    private final GuiScreen \u04f1;
    private final String \u0155;
    private GuiButton \u04d4 = null;
    private boolean \u02a7 = true;
    private GuiButton \u0509 = null;
    private String \u0540 = null;
    private String \u0479 = null;
    private ExecutorService \u0494 = null;
    private CompletableFuture<Void> \u0159 = null;
    private boolean \u0505 = false;
    public static int \u019e;

    public oc74760d9133(GuiScreen guiScreen) {
        this.\u04f1 = guiScreen;
        this.\u0155 = RandomStringUtils.randomAlphanumeric(0xC0925495 ^ 0xC092549D);
    }

    @Override
    public void initGui() {
        block11: {
            block15: {
                block14: {
                    String string2;
                    boolean bl;
                    block16: {
                        block13: {
                            URI uRI;
                            block12: {
                                block10: {
                                    this.buttonList.clear();
                                    bl = ocf130f74f2a.\u02a1;
                                    this.\u04d4 = new GuiButton(0, this.width / (0xCA2397 ^ 0xCA2395) - (0xCA23DE ^ 0xCA2395) - (0xCA2397 ^ 0xCA2395), this.height / (0xCA2397 ^ 0xCA2395) + this.fontRendererObj.FONT_HEIGHT / (0xCA2397 ^ 0xCA2395) + this.fontRendererObj.FONT_HEIGHT, 0xCA23DE ^ 0xCA2395, 0xCA2381 ^ 0xCA2395, "Open");
                                    this.buttonList.add(this.\u04d4);
                                    if (bl) break block10;
                                    this.\u0509 = new GuiButton(1, this.width / (0xCA2397 ^ 0xCA2395) + (0xCA2397 ^ 0xCA2395), this.height / (0xCA2397 ^ 0xCA2395) + this.fontRendererObj.FONT_HEIGHT / (0xCA2397 ^ 0xCA2395) + this.fontRendererObj.FONT_HEIGHT, 0xCA23DE ^ 0xCA2395, 0xCA2381 ^ 0xCA2395, "Cancel");
                                    this.buttonList.add(this.\u0509);
                                    if (this.\u0159 != null) break block11;
                                    ocb616b6fa2e.\u0240 = "42a60a84-599d-44b2-a7c6-b00cdef1d6a2";
                                    ocb616b6fa2e.\u00f5 = "XboxLive.signin XboxLive.offline_access";
                                }
                                URI uRI2 = ocb616b6fa2e.\u0152(this.\u0155);
                                uRI = uRI2;
                                if (bl) break block12;
                                if (uRI == null) break block13;
                                uRI = uRI2;
                            }
                            string2 = uRI.toString();
                            break block16;
                        }
                        string2 = "";
                    }
                    oc4d1e5c5d41.\u0109(string2);
                    oc74760d9133 oc74760d91332 = this;
                    if (bl) break block14;
                    oc74760d91332.\u0540 = "&fLogin link has been copied to the clipboard!&r";
                    if (this.\u0494 != null) break block15;
                    oc74760d91332 = this;
                }
                oc74760d91332.\u0494 = Executors.newSingleThreadExecutor(runnable2 -> {
                    Thread thread2 = new Thread(runnable2, "Mimeow-Microsoft-Auth");
                    thread2.setDaemon(true);
                    return thread2;
                });
            }
            AtomicReference<String> atomicReference = new AtomicReference<String>("");
            AtomicReference<String> atomicReference2 = new AtomicReference<String>("");
            this.\u0159 = ((CompletableFuture)((CompletableFuture)((CompletableFuture)((CompletableFuture)((CompletableFuture)((CompletableFuture)ocb616b6fa2e.\u0508(this.\u0155, this.\u0494).thenComposeAsync(string -> {
                this.\u02a7 = false;
                this.\u0540 = "&fAcquiring Microsoft access tokens&r";
                return ocb616b6fa2e.\u0372(string, this.\u0494);
            })).thenComposeAsync(map -> {
                this.\u0540 = "&fAcquiring Xbox access token&r";
                atomicReference.set((String)map.get("refresh_token"));
                return ocb616b6fa2e.\u04cb((String)map.get("access_token"), this.\u0494);
            })).thenComposeAsync(string -> {
                this.\u0540 = "&fAcquiring Xbox XSTS token&r";
                return ocb616b6fa2e.\u0106(string, this.\u0494);
            })).thenComposeAsync(map -> {
                this.\u0540 = "&fAcquiring Minecraft access token&r";
                return ocb616b6fa2e.\u053b((String)map.get("Token"), (String)map.get("uhs"), this.\u0494);
            })).thenComposeAsync(string -> {
                this.\u0540 = "&fFetching your Minecraft profile&r";
                atomicReference2.set((String)string);
                return ocb616b6fa2e.\u0146(string, this.\u0494);
            })).thenAccept(session -> this.mc.addScheduledTask(() -> {
                this.\u0540 = null;
                oc804fdd8d75 oc804fdd8d752 = new oc804fdd8d75((String)atomicReference.get(), (String)atomicReference2.get(), session.getUsername(), "42a60a84-599d-44b2-a7c6-b00cdef1d6a2", "XboxLive.signin XboxLive.offline_access");
                ocd6bc26d10b.\u01fa(oc804fdd8d752);
                occ791aa07d0.\u0431(session);
                this.\u0505 = true;
            }))).exceptionally(throwable -> {
                this.mc.addScheduledTask(() -> {
                    String string;
                    block8: {
                        Object[] objectArray;
                        String string2;
                        block6: {
                            Throwable throwable2;
                            block7: {
                                this.\u02a7 = false;
                                String string3 = throwable.getMessage();
                                boolean bl = ocf130f74f2a.\u02a1;
                                throwable2 = throwable.getCause();
                                oc74760d9133 oc74760d91332 = this;
                                string2 = "&c%s&r";
                                Object[] objectArray2 = new Object[1];
                                Object[] objectArray3 = objectArray2;
                                objectArray = objectArray2;
                                int n = 0;
                                Object object = string3 == null ? throwable : string3;
                                objectArray3[n] = object;
                                if (bl) break block6;
                                oc74760d91332.\u0540 = String.format(string2, objectArray);
                                oc74760d91332 = this;
                                if (throwable2 != null) break block7;
                                string = null;
                                break block8;
                            }
                            string2 = "&c%s&r";
                            Object[] objectArray4 = new Object[1];
                            objectArray = objectArray4;
                            objectArray4[0] = throwable2.getMessage();
                        }
                        string = String.format(string2, objectArray);
                    }
                    oc74760d91332.\u0479 = string;
                });
                return null;
            });
        }
    }

    @Override
    public void onGuiClosed() {
        block15: {
            oc74760d9133 oc74760d91332;
            block14: {
                boolean bl;
                block12: {
                    block13: {
                        bl = ocf130f74f2a.\u02a1;
                        oc74760d91332 = this;
                        if (bl) break block12;
                        if (oc74760d91332.\u0159 == null) break block13;
                        oc74760d91332 = this;
                        if (bl) break block12;
                        if (oc74760d91332.\u0159.isDone()) break block13;
                        this.\u0159.cancel(true);
                    }
                    oc74760d91332 = this;
                }
                if (bl) break block14;
                if (oc74760d91332.\u0494 == null) break block15;
                oc74760d91332 = this;
            }
            oc74760d91332.\u0494.shutdownNow();
        }
    }

    @Override
    public void updateScreen() {
        block5: {
            block4: {
                boolean bl = ocf130f74f2a.\u02a1;
                oc74760d9133 oc74760d91332 = this;
                if (bl) break block4;
                if (!oc74760d91332.\u0505) break block5;
                this.mc.displayGuiScreen(new ocfc2b827e17(this.\u04f1, new ocb8a733cf81(oc54714bd439.\u01e4(String.format("&aSuccessful login! (%s)&r", occ791aa07d0.\u00fe().getUsername())), 0x77C6B73FEAFEE02L ^ 0x77C6B73FEAFFD8AL)));
                oc74760d91332 = this;
            }
            oc74760d91332.\u0505 = false;
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        block17: {
            oc74760d9133 oc74760d91332;
            block16: {
                boolean bl;
                block14: {
                    block15: {
                        block12: {
                            block13: {
                                bl = ocf130f74f2a.\u02a1;
                                oc74760d91332 = this;
                                if (bl) break block12;
                                if (oc74760d91332.\u04d4 == null) break block13;
                                this.\u04d4.enabled = this.\u02a7;
                            }
                            this.drawDefaultBackground();
                            super.drawScreen(n, n2, f);
                            this.drawCenteredString(this.fontRendererObj, "Microsoft Authentication", this.width / (0xFADA8A1F ^ 0xFADA8A1D), this.height / (0xFADA8A1F ^ 0xFADA8A1D) - this.fontRendererObj.FONT_HEIGHT / (0xFADA8A1F ^ 0xFADA8A1D) - this.fontRendererObj.FONT_HEIGHT * (0xFADA8A1F ^ 0xFADA8A1D), 0xFA7020B7 ^ 0xFADA8A1D);
                            oc74760d91332 = this;
                        }
                        if (bl) break block14;
                        if (oc74760d91332.\u0540 == null) break block15;
                        this.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4(this.\u0540), this.width / (0xFADA8A1F ^ 0xFADA8A1D), this.height / (0xFADA8A1F ^ 0xFADA8A1D) - this.fontRendererObj.FONT_HEIGHT / (0xFADA8A1F ^ 0xFADA8A1D), -1);
                    }
                    oc74760d91332 = this;
                }
                if (bl) break block16;
                if (oc74760d91332.\u0479 == null) break block17;
                oc74760d91332 = this;
            }
            String string = oc54714bd439.\u01e4(oc74760d91332.\u0479);
            Gui.drawRect(0, this.height - (0xFADA8A1F ^ 0xFADA8A1D) - this.fontRendererObj.FONT_HEIGHT - (0xFADA8A1E ^ 0xFADA8A1D), (0xFADA8A1E ^ 0xFADA8A1D) + this.mc.fontRendererObj.getStringWidth(string) + (0xFADA8A1E ^ 0xFADA8A1D), this.height, 0x9EDA8A1D ^ 0xFADA8A1D);
            this.drawString(this.fontRendererObj, oc54714bd439.\u01e4(this.\u0479), 0xFADA8A1E ^ 0xFADA8A1D, this.height - (0xFADA8A1F ^ 0xFADA8A1D) - this.fontRendererObj.FONT_HEIGHT, -1);
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (n == 1) {
            this.actionPerformed(this.\u0509);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void actionPerformed(GuiButton guiButton) {
        boolean bl = ocf130f74f2a.\u02a1;
        GuiButton guiButton2 = guiButton;
        if (!bl) {
            if (guiButton2 == null) {
                return;
            }
            guiButton2 = guiButton;
        }
        if (!bl) {
            if (!guiButton2.enabled) return;
            guiButton2 = guiButton;
        }
        switch (guiButton2.id) {
            case 0: {
                oc4d1e5c5d41.\u04d3(ocb616b6fa2e.\u0152(this.\u0155));
                if (!bl) return;
            }
            case 1: {
                this.mc.displayGuiScreen(new ocfc2b827e17(this.\u04f1));
                return;
            }
        }
    }
}

