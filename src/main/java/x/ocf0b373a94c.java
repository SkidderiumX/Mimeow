/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.Session;
import org.lwjgl.input.Keyboard;
import x.oc54714bd439;
import x.oc804fdd8d75;
import x.ocb616b6fa2e;
import x.ocb8a733cf81;
import x.occ791aa07d0;
import x.ocd6bc26d10b;
import x.ocf130f74f2a;
import x.ocfc2b827e17;

public class ocf0b373a94c
extends GuiScreen {
    private static final String \u0253 = "42a60a84-599d-44b2-a7c6-b00cdef1d6a2";
    private static final String \u0195 = "XboxLive.signin XboxLive.offline_access";
    private final GuiScreen \u0445;
    private GuiButton \u00f9 = null;
    private String \u026b = null;
    private String \u041c = null;
    private String \u039e = null;
    private volatile boolean \u0578 = false;
    private ExecutorService \u03ae = null;
    private volatile CompletableFuture<Void> \u0132 = null;
    private volatile boolean \u0470 = false;
    public static int \u0579;

    public ocf0b373a94c(GuiScreen guiScreen) {
        this.\u0445 = guiScreen;
    }

    @Override
    public void initGui() {
        block4: {
            block5: {
                this.buttonList.clear();
                boolean bl = ocf130f74f2a.\u02a1;
                Keyboard.enableRepeatEvents(true);
                if (bl) break block4;
                if (this.\u03ae != null) break block5;
                this.\u03ae = Executors.newSingleThreadExecutor(runnable2 -> {
                    Thread thread2 = new Thread(runnable2, "Mimeow-Cookie-Auth");
                    thread2.setDaemon(true);
                    return thread2;
                });
            }
            this.\u00f9 = new GuiButton(0x1EC9D4C2 ^ 0x1EC9D724, this.width / (0x1EC9D726 ^ 0x1EC9D724) - (0x1EC9D740 ^ 0x1EC9D724), this.height / (0x1EC9D726 ^ 0x1EC9D724), 0x1EC9D7EC ^ 0x1EC9D724, 0x1EC9D730 ^ 0x1EC9D724, "Choose Cookie File...");
            this.buttonList.add(this.\u00f9);
        }
    }

    @Override
    public void onGuiClosed() {
        block15: {
            ocf0b373a94c ocf0b373a94c2;
            block14: {
                boolean bl;
                block12: {
                    block13: {
                        Keyboard.enableRepeatEvents(false);
                        bl = ocf130f74f2a.\u02a1;
                        ocf0b373a94c2 = this;
                        if (bl) break block12;
                        if (ocf0b373a94c2.\u0132 == null) break block13;
                        ocf0b373a94c2 = this;
                        if (bl) break block12;
                        if (ocf0b373a94c2.\u0132.isDone()) break block13;
                        this.\u0132.cancel(true);
                    }
                    ocf0b373a94c2 = this;
                }
                if (bl) break block14;
                if (ocf0b373a94c2.\u03ae == null) break block15;
                ocf0b373a94c2 = this;
            }
            ocf0b373a94c2.\u03ae.shutdownNow();
        }
    }

    @Override
    public void updateScreen() {
        block26: {
            ocf0b373a94c ocf0b373a94c2;
            block25: {
                boolean bl;
                block18: {
                    block19: {
                        boolean bl2;
                        block24: {
                            block21: {
                                block23: {
                                    ocf0b373a94c ocf0b373a94c3;
                                    block22: {
                                        block20: {
                                            bl = ocf130f74f2a.\u02a1;
                                            ocf0b373a94c2 = this;
                                            if (bl) break block18;
                                            if (ocf0b373a94c2.\u00f9 == null) break block19;
                                            GuiButton guiButton = this.\u00f9;
                                            ocf0b373a94c3 = this;
                                            if (bl) break block20;
                                            if (ocf0b373a94c3.\u0578) break block21;
                                            ocf0b373a94c3 = this;
                                        }
                                        if (bl) break block22;
                                        if (ocf0b373a94c3.\u0132 == null) break block23;
                                        ocf0b373a94c3 = this;
                                    }
                                    bl2 = ocf0b373a94c3.\u0132.isDone();
                                    if (bl) break block24;
                                    if (!bl2) break block21;
                                }
                                bl2 = true;
                                break block24;
                            }
                            bl2 = false;
                        }
                        guiButton.enabled = bl2;
                    }
                    ocf0b373a94c2 = this;
                }
                if (bl) break block25;
                if (!ocf0b373a94c2.\u0470) break block26;
                this.\u0470 = false;
                ocf0b373a94c2 = this;
            }
            ocf0b373a94c2.mc.displayGuiScreen(new ocfc2b827e17(this.\u0445, new ocb8a733cf81(oc54714bd439.\u01e4(String.format("&aSuccessful login! (%s)&r", occ791aa07d0.\u00fe().getUsername())), 0x9800E040E7A948B8L ^ 0x9800E040E7A95B30L)));
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        block17: {
            ocf0b373a94c ocf0b373a94c2;
            block16: {
                boolean bl;
                block14: {
                    block15: {
                        String string;
                        block18: {
                            block13: {
                                ocf0b373a94c ocf0b373a94c3;
                                block12: {
                                    this.drawDefaultBackground();
                                    bl = ocf130f74f2a.\u02a1;
                                    ocf0b373a94c3 = this;
                                    if (bl) break block12;
                                    super.drawScreen(n, n2, f);
                                    this.drawCenteredString(this.fontRendererObj, "Cookie Login", this.width / (0xD64BEADD ^ 0xD64BEADF), this.height / (0xD64BEADD ^ 0xD64BEADF) - this.fontRendererObj.FONT_HEIGHT / (0xD64BEADD ^ 0xD64BEADF) - this.fontRendererObj.FONT_HEIGHT * (0xD64BEADC ^ 0xD64BEADF) - (0xD64BEAD9 ^ 0xD64BEADF), 0xD6E14075 ^ 0xD64BEADF);
                                    if (this.\u026b == null) break block13;
                                    ocf0b373a94c3 = this;
                                }
                                string = ocf0b373a94c3.\u026b;
                                break block18;
                            }
                            string = "&7Choose an exported cookies file (Netscape .txt or JSON).&r";
                        }
                        String string2 = string;
                        ocf0b373a94c2 = this;
                        if (bl) break block14;
                        ocf0b373a94c2.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4(string2), this.width / (0xD64BEADD ^ 0xD64BEADF), this.height / (0xD64BEADD ^ 0xD64BEADF) - this.fontRendererObj.FONT_HEIGHT / (0xD64BEADD ^ 0xD64BEADF) - this.fontRendererObj.FONT_HEIGHT - (0xD64BEAD7 ^ 0xD64BEADF), -1);
                        if (this.\u039e == null) break block15;
                        this.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4(String.format("&8File: &7%s&r", this.\u039e)), this.width / (0xD64BEADD ^ 0xD64BEADF), this.height / (0xD64BEADD ^ 0xD64BEADF) + (0xD64BEAC5 ^ 0xD64BEADF), -1);
                    }
                    ocf0b373a94c2 = this;
                }
                if (bl) break block16;
                if (ocf0b373a94c2.\u041c == null) break block17;
                ocf0b373a94c2 = this;
            }
            String string = oc54714bd439.\u01e4(ocf0b373a94c2.\u041c);
            Gui.drawRect(0, this.height - (0xD64BEADD ^ 0xD64BEADF) - this.fontRendererObj.FONT_HEIGHT - (0xD64BEADC ^ 0xD64BEADF), (0xD64BEADC ^ 0xD64BEADF) + this.mc.fontRendererObj.getStringWidth(string) + (0xD64BEADC ^ 0xD64BEADF), this.height, 0xB24BEADF ^ 0xD64BEADF);
            this.drawString(this.fontRendererObj, string, 0xD64BEADC ^ 0xD64BEADF, this.height - (0xD64BEADD ^ 0xD64BEADF) - this.fontRendererObj.FONT_HEIGHT, -1);
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        block16: {
            ocf0b373a94c ocf0b373a94c2;
            block18: {
                block19: {
                    boolean bl;
                    block17: {
                        int n2;
                        block15: {
                            bl = ocf130f74f2a.\u02a1;
                            n2 = n;
                            if (bl) break block15;
                            if (n2 != 1) break block16;
                            ocf0b373a94c2 = this;
                            if (bl) break block17;
                            n2 = ocf0b373a94c2.\u0578 ? 1 : 0;
                        }
                        if (n2 != 0) break block16;
                        ocf0b373a94c2 = this;
                    }
                    if (bl) break block18;
                    if (ocf0b373a94c2.\u0132 == null) break block19;
                    ocf0b373a94c2 = this;
                    if (bl) break block18;
                    if (!ocf0b373a94c2.\u0132.isDone()) break block16;
                }
                ocf0b373a94c2 = this;
            }
            ocf0b373a94c2.mc.displayGuiScreen(this.\u0445);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiButton guiButton2;
        block9: {
            block10: {
                boolean bl;
                block8: {
                    bl = ocf130f74f2a.\u02a1;
                    guiButton2 = guiButton;
                    if (bl) break block8;
                    if (guiButton2 == null) return;
                    guiButton2 = guiButton;
                }
                if (bl) break block9;
                if (guiButton2.enabled) break block10;
                return;
            }
            guiButton2 = guiButton;
        }
        if (guiButton2.id != (0x57D9FD97 ^ 0x57D9FE71)) return;
        this.\u04af();
        return;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void \u04af() {
        block13: {
            ocf0b373a94c ocf0b373a94c2;
            block14: {
                boolean bl;
                block12: {
                    bl = ocf130f74f2a.\u02a1;
                    ocf0b373a94c2 = this;
                    if (bl) break block12;
                    if (ocf0b373a94c2.\u0578) return;
                    ocf0b373a94c2 = this;
                }
                if (bl) break block13;
                if (ocf0b373a94c2.\u0132 == null) break block14;
                ocf0b373a94c2 = this;
                if (bl) break block13;
                if (ocf0b373a94c2.\u0132.isDone()) break block14;
                return;
            }
            this.\u0578 = true;
            this.\u041c = null;
            ocf0b373a94c2 = this;
        }
        ocf0b373a94c2.\u026b = "&7Opening file chooser...&r";
        Thread thread2 = new Thread(() -> {
            block22: {
                block24: {
                    ocf0b373a94c ocf0b373a94c2;
                    boolean bl;
                    block23: {
                        block21: {
                            File file = null;
                            bl = ocf130f74f2a.\u02a1;
                            try {
                                try {
                                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                }
                                catch (Exception exception) {
                                    // empty catch block
                                }
                                JFileChooser jFileChooser = new JFileChooser();
                                jFileChooser.setDialogTitle("Select your exported cookies file");
                                jFileChooser.setFileSelectionMode(0);
                                String[] stringArray = new String[0x1093A578 ^ 0x1093A57A];
                                stringArray[0] = "txt";
                                stringArray[1] = "json";
                                jFileChooser.setFileFilter(new FileNameExtensionFilter("Cookie files (*.txt, *.json)", stringArray));
                                jFileChooser.setAcceptAllFileFilterUsed(true);
                                JFrame jFrame = new JFrame();
                                jFrame.setAlwaysOnTop(true);
                                jFrame.setLocationRelativeTo(null);
                                int n = jFileChooser.showOpenDialog(jFrame);
                                jFrame.dispose();
                                if (n == 0) {
                                    file = jFileChooser.getSelectedFile();
                                }
                            }
                            catch (Throwable throwable) {
                                this.\u026b = String.format("&cFile chooser failed: %s&r", throwable.getMessage());
                            }
                            finally {
                                this.\u0578 = false;
                            }
                            if (file == null) break block21;
                            this.\u04ae(file);
                            if (!bl) break block22;
                        }
                        ocf0b373a94c2 = this;
                        if (bl) break block23;
                        if (ocf0b373a94c2.\u026b == null) break block22;
                        ocf0b373a94c2 = this;
                    }
                    if (bl) break block24;
                    if (!ocf0b373a94c2.\u026b.contains("Opening")) break block22;
                    ocf0b373a94c2 = this;
                }
                ocf0b373a94c2.\u026b = "&7No file selected.&r";
            }
        }, "Cookie File Chooser");
        thread2.setDaemon(true);
        thread2.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u04ae(File file) {
        String[] stringArray;
        Object object;
        block12: {
            ocf0b373a94c ocf0b373a94c2;
            block11: {
                boolean bl = ocf130f74f2a.\u02a1;
                ocf0b373a94c2 = this;
                if (bl) break block11;
                if (ocf0b373a94c2.\u0132 == null) break block12;
                ocf0b373a94c2 = this;
            }
            if (!ocf0b373a94c2.\u0132.isDone()) {
                return;
            }
        }
        try {
            object = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            stringArray = ((String)object).split("\\r?\\n");
        }
        catch (Exception exception) {
            this.\u026b = String.format("&cCould not read file: %s&r", exception.getMessage());
            return;
        }
        if (stringArray.length == 0) {
            this.\u026b = "&cNo cookies were found in that file.&r";
            return;
        }
        this.\u039e = file.getName();
        this.\u041c = null;
        ocb616b6fa2e.\u0240 = "42a60a84-599d-44b2-a7c6-b00cdef1d6a2";
        ocb616b6fa2e.\u00f5 = "XboxLive.signin XboxLive.offline_access";
        object = new AtomicReference<String>("");
        AtomicReference<String> atomicReference = new AtomicReference<String>("");
        this.\u026b = "&fAuthenticating with cookies (Sisu)&r";
        this.\u0132 = ((CompletableFuture)((CompletableFuture)((CompletableFuture)CompletableFuture.supplyAsync(() -> {
            boolean bl = ocf130f74f2a.\u02a1;
            try {
                Object object2;
                String string2;
                Object object3;
                StringBuilder stringBuilder;
                block41: {
                    block40: {
                        block39: {
                            StringBuilder stringBuilder2;
                            int n;
                            block34: {
                                stringBuilder = new StringBuilder();
                                ArrayList<String> arrayList = new ArrayList<String>();
                                object3 = stringArray;
                                int n2 = ((String[])object3).length;
                                int n3 = 0;
                                while (n3 < n2) {
                                    block35: {
                                        block36: {
                                            int n4;
                                            String[] stringArray2;
                                            ArrayList<String> arrayList2;
                                            block38: {
                                                boolean bl2;
                                                block37: {
                                                    string2 = object3[n3];
                                                    object2 = string2.split("\t");
                                                    if (bl) break block35;
                                                    n = ((String[])object2).length;
                                                    if (bl) break block34;
                                                    if (n < (0x3241DF61 ^ 0x3241DF66)) break block36;
                                                    bl2 = object2[0].endsWith("login.live.com");
                                                    if (bl) break block37;
                                                    if (!bl2) break block36;
                                                    arrayList2 = arrayList;
                                                    stringArray2 = object2;
                                                    n4 = 0x3241DF63 ^ 0x3241DF66;
                                                    if (bl) break block38;
                                                    bl2 = arrayList2.contains(stringArray2[n4]);
                                                }
                                                if (bl2) break block36;
                                                stringBuilder.append(object2[0x3241DF63 ^ 0x3241DF66]).append("=").append(object2[0x3241DF60 ^ 0x3241DF66]).append("; ");
                                                arrayList2 = arrayList;
                                                stringArray2 = object2;
                                                n4 = 0x3241DF63 ^ 0x3241DF66;
                                            }
                                            arrayList2.add(stringArray2[n4]);
                                        }
                                        ++n3;
                                    }
                                    if (!bl) continue;
                                }
                                stringBuilder2 = stringBuilder;
                                if (bl) break block39;
                                n = stringBuilder2.length();
                            }
                            if (n <= (0x3241DF64 ^ 0x3241DF66)) break block40;
                            stringBuilder2 = stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - (0x3241DF64 ^ 0x3241DF66)));
                        }
                        if (!bl) break block41;
                    }
                    throw new Exception("No login.live.com cookies found!");
                }
                this.\u026b = "&fAcquiring Xbox token (Sisu)&r";
                object3 = (HttpsURLConnection)new URL("https://sisu.xboxlive.com/connect/XboxLive/?state=login&cobrandId=8058f65d-ce06-4c30-9559-473c9275a65d&tid=896928775&ru=https%3A%2F%2Fwww.minecraft.net%2Fen-us%2Flogin&aid=1142970254").openConnection();
                ((HttpURLConnection)object3).setRequestMethod("GET");
                ((URLConnection)object3).setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                ((URLConnection)object3).setRequestProperty("User-Agent", "Mozilla/5.0");
                ((HttpURLConnection)object3).setInstanceFollowRedirects(false);
                ((URLConnection)object3).connect();
                String string4 = ((URLConnection)object3).getHeaderField("Location");
                if (!bl) {
                    if (string4 == null) {
                        throw new Exception("No Location header in first redirect");
                    }
                    string4 = string4.replaceAll(" ", "%20");
                    object3 = (HttpsURLConnection)new URL(string4).openConnection();
                    ((HttpURLConnection)object3).setRequestMethod("GET");
                    ((URLConnection)object3).setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                    ((URLConnection)object3).setRequestProperty("Cookie", stringBuilder.toString());
                    ((URLConnection)object3).setRequestProperty("User-Agent", "Mozilla/5.0");
                    ((HttpURLConnection)object3).setInstanceFollowRedirects(false);
                    ((URLConnection)object3).connect();
                }
                String string3 = ((URLConnection)object3).getHeaderField("Location");
                if (!bl) {
                    if (string3 == null) {
                        throw new Exception("No Location header in second redirect");
                    }
                    object3 = (HttpsURLConnection)new URL(string3).openConnection();
                    ((HttpURLConnection)object3).setRequestMethod("GET");
                    ((URLConnection)object3).setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                    ((URLConnection)object3).setRequestProperty("Cookie", stringBuilder.toString());
                    ((URLConnection)object3).setRequestProperty("User-Agent", "Mozilla/5.0");
                    ((HttpURLConnection)object3).setInstanceFollowRedirects(false);
                    ((URLConnection)object3).connect();
                }
                String string = string2 = ((URLConnection)object3).getHeaderField("Location");
                if (!bl) {
                    if (string == null) {
                        throw new Exception("No Location header in third redirect (Cookie invalid or expired)");
                    }
                    string = string2.split("accessToken=")[1];
                }
                Object object = object2 = string;
                if (!bl) {
                    if (((String)object).contains("&")) {
                        object2 = ((String)object2).split("&")[0];
                    }
                    object = new String(Base64.getDecoder().decode((String)object2), StandardCharsets.UTF_8).split("\"rp://api.minecraftservices.com/\",")[1];
                }
                Object object4 = object;
                String string5 = ((String)object4).split("\"Token\":\"")[1].split("\"")[0];
                String string52 = ((String)object4).split(Pattern.quote("{\"DisplayClaims\":{\"xui\":[{\"uhs\":\""))[1].split("\"")[0];
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("Token", string5);
                hashMap.put("uhs", string52);
                return hashMap;
            }
            catch (Exception exception) {
                throw new CompletionException("Failed Sisu Xbox authentication! " + exception.getMessage(), exception);
            }
        }, this.\u03ae).thenComposeAsync(map -> {
            this.\u026b = "&fAcquiring Minecraft access token&r";
            return ocb616b6fa2e.\u053b((String)map.get("Token"), (String)map.get("uhs"), this.\u03ae);
        })).thenComposeAsync(string -> {
            this.\u026b = "&fFetching your Minecraft profile&r";
            atomicReference.set((String)string);
            return ocb616b6fa2e.\u0146(string, this.\u03ae);
        })).thenAccept(arg_0 -> this.q2osly7vfsf7g9((AtomicReference)object, atomicReference, arg_0))).exceptionally(throwable -> {
            block4: {
                ocf0b373a94c ocf0b373a94c2;
                block5: {
                    boolean bl = ocf130f74f2a.\u02a1;
                    ocf0b373a94c2 = this;
                    if (bl) break block4;
                    ocf0b373a94c2.\u026b = String.format("&c%s&r", throwable.getMessage());
                    if (throwable.getCause() == null) break block5;
                    this.\u041c = String.format("&c%s&r", throwable.getCause().getMessage());
                }
                ocf0b373a94c2 = this;
            }
            ocf0b373a94c2.\u0132 = null;
            return null;
        });
    }

    private /* synthetic */ void q2osly7vfsf7g9(AtomicReference atomicReference, AtomicReference atomicReference2, Session session) {
        this.\u026b = null;
        oc804fdd8d75 oc804fdd8d752 = new oc804fdd8d75((String)atomicReference.get(), (String)atomicReference2.get(), session.getUsername(), 0L, "42a60a84-599d-44b2-a7c6-b00cdef1d6a2", "XboxLive.signin XboxLive.offline_access", "cookie");
        ocd6bc26d10b.\u01fa(oc804fdd8d752);
        occ791aa07d0.\u0431(session);
        this.\u0470 = true;
    }
}

