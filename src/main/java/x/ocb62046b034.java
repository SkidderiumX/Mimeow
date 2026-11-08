/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.Session;
import org.lwjgl.input.Keyboard;
import x.oc54714bd439;
import x.oc804fdd8d75;
import x.ocb616b6fa2e;
import x.ocb8a733cf81;
import x.occ791aa07d0;
import x.ocd4bd33822b;
import x.ocd6bc26d10b;
import x.ocf130f74f2a;
import x.ocfc2b827e17;

public class ocb62046b034
extends GuiScreen {
    private final GuiScreen \u0470;
    private String \u0214 = null;
    private ExecutorService \u04c8 = null;
    private CompletableFuture<Void> \u050c = null;
    private boolean \u03fe = false;
    private GuiTextField \u04bb;
    public static boolean \u0495;

    public ocb62046b034(GuiScreen guiScreen) {
        this.\u0470 = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        this.\u04bb = new GuiTextField(1, this.mc.fontRendererObj, scaledResolution.getScaledWidth() / (0x156BB19C ^ 0x156BB19E) - (0x156BB1FA ^ 0x156BB19E), scaledResolution.getScaledHeight() / (0x156BB19C ^ 0x156BB19E), 0x156BB156 ^ 0x156BB19E, 0x156BB18A ^ 0x156BB19E);
        this.\u04bb.setMaxStringLength(0x156BCE61 ^ 0x156BB19E);
        this.\u04bb.setFocused(true);
        this.buttonList.add(new GuiButton(0x156BB278 ^ 0x156BB19E, scaledResolution.getScaledWidth() / (0x156BB19C ^ 0x156BB19E) - (0x156BB1FA ^ 0x156BB19E), scaledResolution.getScaledHeight() / (0x156BB19C ^ 0x156BB19E) + (0x156BB180 ^ 0x156BB19E), 0x156BB156 ^ 0x156BB19E, 0x156BB18A ^ 0x156BB19E, "Add"));
    }

    @Override
    public void onGuiClosed() {
        block15: {
            ocb62046b034 ocb62046b0342;
            block14: {
                boolean bl;
                block12: {
                    block13: {
                        Keyboard.enableRepeatEvents(false);
                        bl = ocf130f74f2a.\u02a1;
                        ocb62046b0342 = this;
                        if (bl) break block12;
                        if (ocb62046b0342.\u050c == null) break block13;
                        ocb62046b0342 = this;
                        if (bl) break block12;
                        if (ocb62046b0342.\u050c.isDone()) break block13;
                        this.\u050c.cancel(true);
                    }
                    ocb62046b0342 = this;
                }
                if (bl) break block14;
                if (ocb62046b0342.\u04c8 == null) break block15;
                ocb62046b0342 = this;
            }
            ocb62046b0342.\u04c8.shutdownNow();
        }
    }

    @Override
    public void updateScreen() {
        block5: {
            block4: {
                boolean bl = ocf130f74f2a.\u02a1;
                ocb62046b034 ocb62046b0342 = this;
                if (bl) break block4;
                if (!ocb62046b0342.\u03fe) break block5;
                this.mc.displayGuiScreen(new ocfc2b827e17(this.\u0470, new ocb8a733cf81(oc54714bd439.\u01e4(String.format("&aSuccessful login! (%s)&r", occ791aa07d0.\u00fe().getUsername())), 0x37757BBEE5669C71L ^ 0x37757BBEE5668FF9L)));
                ocb62046b0342 = this;
            }
            ocb62046b0342.\u03fe = false;
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        block5: {
            String string;
            FontRenderer fontRenderer;
            ocb62046b034 ocb62046b0342;
            block4: {
                this.drawDefaultBackground();
                boolean bl = ocf130f74f2a.\u02a1;
                super.drawScreen(n, n2, f);
                ocb62046b0342 = this;
                fontRenderer = this.fontRendererObj;
                string = "Token / Refresh / Session";
                if (bl) break block4;
                ocb62046b0342.drawCenteredString(fontRenderer, string, this.width / (0xD03BEED6 ^ 0xD03BEED4), this.height / (0xD03BEED6 ^ 0xD03BEED4) - this.fontRendererObj.FONT_HEIGHT / (0xD03BEED6 ^ 0xD03BEED4) - this.fontRendererObj.FONT_HEIGHT * (0xD03BEED6 ^ 0xD03BEED4) - (0xD03BEEDA ^ 0xD03BEED4), 0xD091447E ^ 0xD03BEED4);
                this.\u04bb.drawTextBox();
                if (this.\u0214 == null) break block5;
                ocb62046b0342 = this;
                fontRenderer = this.fontRendererObj;
                string = oc54714bd439.\u01e4(this.\u0214);
            }
            ocb62046b0342.drawCenteredString(fontRenderer, string, this.width / (0xD03BEED6 ^ 0xD03BEED4), this.height / (0xD03BEED6 ^ 0xD03BEED4) - this.fontRendererObj.FONT_HEIGHT / (0xD03BEED6 ^ 0xD03BEED4) - (0xD03BEEDA ^ 0xD03BEED4), -1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void keyTyped(char c, int n) {
        block20: {
            ocb62046b034 ocb62046b0342;
            block22: {
                int n2;
                block21: {
                    boolean bl;
                    block16: {
                        block17: {
                            ocb62046b034 ocb62046b0343;
                            block18: {
                                block19: {
                                    this.\u04bb.textboxKeyTyped(c, n);
                                    bl = ocf130f74f2a.\u02a1;
                                    n2 = n;
                                    if (bl) break block16;
                                    if (n2 != 1) break block17;
                                    ocb62046b0343 = this;
                                    if (bl) break block18;
                                    if (ocb62046b0343.\u050c == null) break block19;
                                    ocb62046b0343 = this;
                                    if (bl) break block18;
                                    if (ocb62046b0343.\u050c.isDone()) break block19;
                                    ocb62046b0343 = this;
                                    if (bl) break block18;
                                    if (ocb62046b0343.\u050c.isCancelled()) break block19;
                                    ocb62046b0343 = this;
                                    if (bl) break block18;
                                    if (!ocb62046b0343.\u050c.isCompletedExceptionally()) break block20;
                                }
                                ocb62046b0343 = this;
                            }
                            ocb62046b0343.mc.displayGuiScreen(this.\u0470);
                            if (!bl) break block20;
                        }
                        n2 = n;
                    }
                    if (bl) break block21;
                    if (n2 != (0xE8E6F0AD ^ 0xE8E6F0B1)) break block20;
                    ocb62046b0342 = this;
                    if (bl) break block22;
                    n2 = ocb62046b0342.buttonList.isEmpty() ? 1 : 0;
                }
                if (n2 != 0) break block20;
                ocb62046b0342 = this;
            }
            ocb62046b0342.actionPerformed(this.buttonList.get(0));
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        block36: {
            String string;
            block43: {
                int n;
                String[] stringArray;
                String[] stringArray2;
                block45: {
                    boolean bl;
                    block44: {
                        block42: {
                            String string2;
                            block40: {
                                block41: {
                                    ocb62046b034 ocb62046b0342;
                                    block38: {
                                        block39: {
                                            block37: {
                                                GuiButton guiButton2;
                                                block35: {
                                                    block33: {
                                                        block34: {
                                                            bl = ocf130f74f2a.\u02a1;
                                                            guiButton2 = guiButton;
                                                            if (bl) break block33;
                                                            if (guiButton2 != null) break block34;
                                                            return;
                                                        }
                                                        guiButton2 = guiButton;
                                                    }
                                                    if (bl) break block35;
                                                    if (!guiButton2.enabled) break block36;
                                                    guiButton2 = guiButton;
                                                }
                                                if (guiButton2.id != (0xAF1E5E1 ^ 0xAF1E607)) break block36;
                                                ocb62046b0342 = this;
                                                if (bl) break block37;
                                                if (ocb62046b0342.\u050c != null) break block36;
                                                ocb62046b0342 = this;
                                            }
                                            if (bl) break block38;
                                            if (ocb62046b0342.\u04c8 != null) break block39;
                                            this.\u04c8 = Executors.newSingleThreadExecutor(runnable2 -> {
                                                Thread thread2 = new Thread(runnable2, "Mimeow-Token-Auth");
                                                thread2.setDaemon(true);
                                                return thread2;
                                            });
                                        }
                                        ocb62046b0342 = this;
                                    }
                                    string = ocb62046b0342.\u04bb.getText().trim();
                                    string2 = string;
                                    if (bl) break block40;
                                    if (!string2.isEmpty()) break block41;
                                    this.\u0214 = "&cPlease enter a token or session.&r";
                                    return;
                                }
                                string2 = string;
                            }
                            stringArray2 = string2.split(":", 0xAF1E604 ^ 0xAF1E607);
                            stringArray = stringArray2;
                            if (bl) break block42;
                            if (stringArray.length != (0xAF1E604 ^ 0xAF1E607)) break block43;
                            stringArray = stringArray2;
                        }
                        n = 0;
                        if (bl) break block44;
                        if (stringArray[n].isEmpty()) break block43;
                        stringArray = stringArray2;
                        n = 1;
                    }
                    if (bl) break block45;
                    if (stringArray[n].isEmpty()) break block43;
                    stringArray = stringArray2;
                    n = 0xAF1E605 ^ 0xAF1E607;
                }
                if (!stringArray[n].isEmpty()) {
                    Session session2 = new Session(stringArray2[0], stringArray2[1], stringArray2[0xAF1E605 ^ 0xAF1E607], "mojang");
                    oc804fdd8d75 oc804fdd8d752 = new oc804fdd8d75("", stringArray2[0xAF1E605 ^ 0xAF1E607], stringArray2[0], 0L, "", "", "session", stringArray2[1], 0L, 0L);
                    ocd6bc26d10b.\u01fa(oc804fdd8d752);
                    occ791aa07d0.\u0431(session2);
                    this.\u03fe = true;
                    return;
                }
            }
            this.\u050c = ((CompletableFuture)((CompletableFuture)ocb616b6fa2e.\u0146(string, this.\u04c8).handle((session, throwable) -> {
                if (session != null) {
                    oc804fdd8d75 oc804fdd8d753 = new oc804fdd8d75("", string, session.getUsername(), 0L, "", "", "token", session.getPlayerID(), 0L, 0L);
                    this.t(oc804fdd8d753, (Session)session);
                    return CompletableFuture.completedFuture(null);
                }
                this.\u0214 = "&7Refreshing Microsoft access token...&r";
                return ocd4bd33822b.\u047f(string, this.\u04c8).thenAccept(oc804fdd8d752 -> this.t((oc804fdd8d75)oc804fdd8d752, new Session(oc804fdd8d752.\u014c(), oc804fdd8d752.\u04fc(), oc804fdd8d752.\u0106(), "mojang")));
            })).thenCompose(completableFuture -> completableFuture)).exceptionally(throwable -> {
                Throwable throwable2;
                block6: {
                    Throwable throwable3;
                    block4: {
                        block5: {
                            boolean bl = ocf130f74f2a.\u02a1;
                            throwable3 = throwable;
                            if (bl) break block4;
                            if (throwable3.getCause() != null) break block5;
                            throwable2 = throwable;
                            break block6;
                        }
                        throwable3 = throwable;
                    }
                    throwable2 = throwable3.getCause();
                }
                Throwable throwable4 = throwable2;
                this.\u0214 = String.format("&c%s&r", this.\u0166(throwable4));
                this.\u050c = null;
                return null;
            });
        }
    }

    private void t(oc804fdd8d75 oc804fdd8d752, Session session) {
        ocd6bc26d10b.\u01fa(oc804fdd8d752);
        this.mc.addScheduledTask(() -> {
            this.\u0214 = null;
            occ791aa07d0.\u0431(session);
            this.\u03fe = true;
        });
    }

    private String \u0166(Throwable throwable) {
        String string;
        block15: {
            String string2;
            block17: {
                block16: {
                    String string3;
                    boolean bl;
                    block14: {
                        Throwable throwable2;
                        block12: {
                            block13: {
                                bl = ocf130f74f2a.\u02a1;
                                throwable2 = throwable;
                                if (bl) break block12;
                                if (throwable2 != null) break block13;
                                string3 = null;
                                break block14;
                            }
                            throwable2 = throwable;
                        }
                        string3 = throwable2.getMessage();
                    }
                    string2 = string3;
                    string = string2;
                    if (bl) break block15;
                    if (string == null) break block16;
                    string = string2;
                    if (bl) break block15;
                    if (!string.trim().isEmpty()) break block17;
                }
                string = "Authentication failed";
                break block15;
            }
            string = string2;
        }
        return string;
    }
}

