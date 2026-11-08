/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.raphimc.minecraftauth.msa.model.MsaDeviceCode;
import x.oc086240ae91;
import x.oc4d1e5c5d41;
import x.oc54714bd439;
import x.oc6bcef73ceb;
import x.ocb8a733cf81;
import x.occ791aa07d0;
import x.ocd6bc26d10b;
import x.ocf130f74f2a;
import x.ocfc2b827e17;

public class oc3aee363e08
extends GuiScreen {
    private final GuiScreen \u0491;
    private GuiButton \u04fb;
    private GuiButton \u0565;
    private ExecutorService \u013f;
    private CompletableFuture<Void> \u0475;
    private volatile String \u01e8;
    private volatile String \u04f6;
    private volatile boolean \u029c;
    private volatile boolean \u0535;
    public static int \u01ce;

    public oc3aee363e08(GuiScreen guiScreen) {
        this.\u0491 = guiScreen;
    }

    @Override
    public void initGui() {
        block7: {
            oc3aee363e08 oc3aee363e082;
            block6: {
                this.buttonList.clear();
                boolean bl = ocf130f74f2a.\u02a1;
                GuiButton guiButton = this.\u04fb = new GuiButton(1, this.width / (0xDEE15496 ^ 0xDEE15494) - (0xDEE154DF ^ 0xDEE15494), this.height / (0xDEE15496 ^ 0xDEE15494) + (0xDEE154B7 ^ 0xDEE15494), 0xDEE15402 ^ 0xDEE15494, 0xDEE15480 ^ 0xDEE15494, "Open Browser");
                boolean bl2 = this.\u04f6 != null;
                guiButton.enabled = bl2;
                this.buttonList.add(this.\u04fb);
                oc3aee363e082 = this;
                if (bl) break block6;
                this.\u0565 = new GuiButton(0, this.width / (0xDEE15496 ^ 0xDEE15494) - (0xDEE154A6 ^ 0xDEE15494), this.height / (0xDEE15496 ^ 0xDEE15494) + (0xDEE154A8 ^ 0xDEE15494), 0xDEE154F0 ^ 0xDEE15494, 0xDEE15480 ^ 0xDEE15494, "Cancel");
                oc3aee363e082.buttonList.add(this.\u0565);
                if (this.\u0475 != null) break block7;
                this.\u01e8 = "&fRequesting Microsoft login code...&r";
                this.\u013f = Executors.newSingleThreadExecutor(runnable2 -> {
                    Thread thread2 = new Thread(runnable2, "Miau Microsoft Login");
                    thread2.setDaemon(true);
                    return thread2;
                });
                oc3aee363e082 = this;
            }
            oc3aee363e082.\u00f2();
        }
    }

    private void \u00f2() {
        this.\u0475 = ((CompletableFuture)CompletableFuture.supplyAsync(() -> {
            try {
                return oc086240ae91.\u04af(this::\u042c);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                throw new CompletionException(interruptedException);
            }
            catch (Exception exception) {
                throw new CompletionException(exception);
            }
        }, this.\u013f).thenAccept(oc6bcef73ceb2 -> this.\u0428(() -> this.\u048b((oc6bcef73ceb)oc6bcef73ceb2)))).exceptionally(throwable -> {
            this.\u0428(() -> this.\u01bf((Throwable)throwable));
            return null;
        });
    }

    private void \u042c(MsaDeviceCode msaDeviceCode) {
        this.\u04f6 = msaDeviceCode.getDirectVerificationUri();
        oc4d1e5c5d41.\u0109(this.\u04f6);
        oc4d1e5c5d41.\u04d3(URI.create(this.\u04f6));
        this.\u0428(() -> {
            block4: {
                oc3aee363e08 oc3aee363e082;
                block5: {
                    boolean bl = ocf130f74f2a.\u02a1;
                    oc3aee363e082 = this;
                    if (bl) break block4;
                    if (!oc3aee363e082.\u0535) break block5;
                    return;
                }
                this.\u04fb.enabled = true;
                oc3aee363e082 = this;
            }
            oc3aee363e082.\u01e8 = "&fEnter code &b" + msaDeviceCode.getUserCode() + "&f in Microsoft. The link was copied.&r";
        });
    }

    private void \u048b(oc6bcef73ceb oc6bcef73ceb2) {
        block4: {
            oc3aee363e08 oc3aee363e082;
            block5: {
                boolean bl = ocf130f74f2a.\u02a1;
                oc3aee363e082 = this;
                if (bl) break block4;
                if (!oc3aee363e082.\u0535) break block5;
                return;
            }
            ocd6bc26d10b.\u01fa(oc6bcef73ceb2.\u00fb());
            occ791aa07d0.\u0431(oc6bcef73ceb2.\u045a());
            oc3aee363e082 = this;
        }
        oc3aee363e082.\u029c = true;
    }

    private void \u01bf(Throwable throwable) {
        block4: {
            oc3aee363e08 oc3aee363e082;
            block5: {
                boolean bl = ocf130f74f2a.\u02a1;
                oc3aee363e082 = this;
                if (bl) break block4;
                if (!oc3aee363e082.\u0535) break block5;
                return;
            }
            oc3aee363e082 = this;
        }
        oc3aee363e082.\u01e8 = "&c" + oc086240ae91.W(throwable) + "&r";
    }

    private void \u0428(Runnable runnable2) {
        this.mc.addScheduledTask(runnable2);
    }

    @Override
    public void onGuiClosed() {
        block15: {
            oc3aee363e08 oc3aee363e082;
            block14: {
                boolean bl;
                block12: {
                    block13: {
                        bl = ocf130f74f2a.\u02a1;
                        oc3aee363e082 = this;
                        if (bl) break block12;
                        oc3aee363e082.\u0535 = true;
                        if (this.\u0475 == null) break block13;
                        oc3aee363e082 = this;
                        if (bl) break block12;
                        if (oc3aee363e082.\u0475.isDone()) break block13;
                        this.\u0475.cancel(true);
                    }
                    oc3aee363e082 = this;
                }
                if (bl) break block14;
                if (oc3aee363e082.\u013f == null) break block15;
                oc3aee363e082 = this;
            }
            oc3aee363e082.\u013f.shutdownNow();
        }
    }

    @Override
    public void updateScreen() {
        if (!this.\u029c) {
            return;
        }
        String string = occ791aa07d0.\u00fe().getUsername();
        this.\u029c = false;
        this.mc.displayGuiScreen(new ocfc2b827e17(this.\u0491, new ocb8a733cf81(oc54714bd439.\u01e4(String.format("&aSuccessful login! (%s)&r", string)), 0x1219C6F052FC4FAL ^ 0x1219C6F052FD772L)));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        super.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRendererObj, "Microsoft Authentication", this.width / (0xA74B1416 ^ 0xA74B1414), this.height / (0xA74B1416 ^ 0xA74B1414) - (0xA74B1423 ^ 0xA74B1414), 0x58E1BEBE ^ 0xA74B1414);
        this.\u018d();
    }

    private void \u018d() {
        oc3aee363e08 oc3aee363e082;
        boolean bl;
        block5: {
            block6: {
                bl = ocf130f74f2a.\u02a1;
                oc3aee363e082 = this;
                if (bl) break block5;
                if (oc3aee363e082.\u01e8 != null) break block6;
                return;
            }
            oc3aee363e082 = this;
        }
        List<String> list = oc3aee363e082.fontRendererObj.listFormattedStringToWidth(oc54714bd439.\u01e4(this.\u01e8), Math.max(0x41DF9843 ^ 0x41DF9827, this.width - (0x41DF980F ^ 0x41DF9827)));
        int n = this.height / (0x41DF9825 ^ 0x41DF9827) - (0x41DF9828 ^ 0x41DF9827) - list.size() * this.fontRendererObj.FONT_HEIGHT / (0x41DF9825 ^ 0x41DF9827);
        for (String string : list) {
            this.drawCenteredString(this.fontRendererObj, string, this.width / (0x41DF9825 ^ 0x41DF9827), n, -1);
            n += this.fontRendererObj.FONT_HEIGHT + (0x41DF9825 ^ 0x41DF9827);
            if (!bl) continue;
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (n == 1) {
            this.actionPerformed(this.\u0565);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiButton guiButton2;
        block15: {
            block16: {
                oc3aee363e08 oc3aee363e082;
                boolean bl;
                block17: {
                    bl = ocf130f74f2a.\u02a1;
                    guiButton2 = guiButton;
                    if (!bl) {
                        if (guiButton2 == null) return;
                        guiButton2 = guiButton;
                    }
                    if (!bl) {
                        if (!guiButton2.enabled) {
                            return;
                        }
                        guiButton2 = guiButton;
                    }
                    if (bl) break block15;
                    if (guiButton2.id != 1) break block16;
                    oc3aee363e082 = this;
                    if (bl) break block17;
                    if (oc3aee363e082.\u04f6 == null) break block16;
                    oc4d1e5c5d41.\u0109(this.\u04f6);
                    oc3aee363e082 = this;
                }
                oc4d1e5c5d41.\u04d3(URI.create(oc3aee363e082.\u04f6));
                if (!bl) return;
            }
            guiButton2 = guiButton;
        }
        if (guiButton2.id != 0) return;
        this.mc.displayGuiScreen(new ocfc2b827e17(this.\u0491));
    }
}

