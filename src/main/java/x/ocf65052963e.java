/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import keystrokesmod.script.Manager;
import keystrokesmod.script.Script;
import keystrokesmod.script.ScriptSourceTransformer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.oc2cf3d80e17;
import x.oc8ccd9c3f55;
import x.oc9755810e45;
import x.ocbd4917c4b1;
import x.ocd2958dac48;
import x.ocfc26979767;

public class ocf65052963e
extends GuiScreen {
    private static final int \u043a = 20;
    private static final int \u048d = 14;
    private static final int c = 28;
    private static final int \u054d = 18;
    private static final int \u0146 = 28;
    private static final int \u01e6 = 7;
    private static final int \u04a1 = 3;
    private static final int \u0171 = -267119594;
    private static final int \u04d5 = -300871405;
    private static final int \u00c6 = -15132388;
    private static final int \u017d = -15527147;
    private static final int \u02e4 = -7829368;
    private static final int \u0469 = -1118482;
    private static final int \u04e4 = 1429763543;
    private static final int \u015b = 0x10FFFFFF;
    private static final int \u026d = -11100970;
    private static final int \u0285 = -3239560;
    private static final int \u0470 = -9791147;
    private static final int \u04f5 = -2302806;
    private static final int \u056a = -4862296;
    private static final int \u0225 = -2829100;
    private static final Set<String> \u01d2;
    private final GuiScreen \u0457;
    private final String \u00c8;
    private File \u027f;
    private final List<File> v = new ArrayList<File>();
    private File \u0129;
    private final List<String> E = new ArrayList<String>();
    private int \u03ee = 0;
    private int \u0463 = 0;
    private int \u015f = -1;
    private int \u00de = -1;
    private float \u00ec = 0.0f;
    private float \u03ad = 0.0f;
    private boolean \u0274 = false;
    private float \u0505 = 0.0f;
    private boolean \u03f9 = false;
    private boolean \u04ad = false;
    private String \u0416 = "Ready";
    private boolean \u0270 = false;
    private long \u022e = 0L;
    private boolean p = false;
    private String \u0158 = "";
    private final LinkedList<List<String>> \u0286 = new LinkedList();
    private final LinkedList<List<String>> \u0409 = new LinkedList();
    private static final int \u0446 = 40;
    private boolean \u0297 = false;

    public ocf65052963e(GuiScreen guiScreen) {
        this(guiScreen, null);
    }

    public ocf65052963e(String string) {
        this(null, string);
    }

    public ocf65052963e(GuiScreen guiScreen, String string) {
        this.\u0457 = guiScreen;
        this.\u00c8 = string;
    }

    @Override
    public void initGui() {
        try {
            Keyboard.enableRepeatEvents(true);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.\u047c();
        this.\u00f5();
        if (this.\u0129 == null) {
            if (this.\u00c8 != null && !this.\u00c8.trim().isEmpty()) {
                Object object = this.\u00c8.trim();
                if (!((String)object).endsWith(".java")) {
                    object = (String)object + ".java";
                }
                for (File object2 : this.v) {
                    if (!object2.getName().equalsIgnoreCase((String)object)) continue;
                    this.\u03fb(object2);
                    break;
                }
                if (this.\u0129 == null && this.\u027f != null) {
                    File file = new File(this.\u027f, (String)object);
                    if (!file.exists()) {
                        String string = ((String)object).substring(0, ((String)object).length() - (0xB3583B68 ^ 0xB3583B6D));
                        try {
                            String iOException = this.\u01d9(string);
                            Files.write(file.toPath(), Collections.singletonList(iOException), StandardCharsets.UTF_8, new OpenOption[0]);
                            this.\u00f5();
                        }
                        catch (IOException iOException) {
                            // empty catch block
                        }
                    }
                    if (file.exists()) {
                        this.\u03fb(file);
                    }
                }
            }
            if (this.\u0129 == null && !this.v.isEmpty()) {
                this.\u03fb(this.v.get(0));
            } else if (this.\u0129 == null) {
                this.E.clear();
                this.E.add("// No scripts found in miau/scripts");
                this.E.add("// Click 'New Script' above to create one!");
                this.\u02b7();
            }
        }
    }

    @Override
    public void onGuiClosed() {
        try {
            Keyboard.enableRepeatEvents(false);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void \u047c() {
        if (oc2cf3d80e17.\u013e != null && oc2cf3d80e17.\u013e.directory != null) {
            this.\u027f = oc2cf3d80e17.\u013e.directory;
        } else {
            File file = oc8ccd9c3f55.\u0212(Minecraft.getMinecraft() != null ? Minecraft.getMinecraft().mcDataDir : null);
            this.\u027f = new File(file, "scripts");
        }
        if (this.\u027f != null && !this.\u027f.exists()) {
            this.\u027f.mkdirs();
        }
    }

    private void \u00f5() {
        File[] fileArray;
        this.v.clear();
        if (this.\u027f != null && this.\u027f.isDirectory() && (fileArray = this.\u027f.listFiles((file, string) -> string.toLowerCase(Locale.ROOT).endsWith(".java"))) != null) {
            Arrays.sort(fileArray, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
            Collections.addAll(this.v, fileArray);
        }
    }

    private void \u03fb(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            this.\u0129 = file;
            this.E.clear();
            List<String> list = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            String string = String.join((CharSequence)"\n", list);
            if (string.contains("extends ScriptModule") || string.contains("net.minecraftforge.")) {
                String string2 = file.getName().replace(".java", "");
                String string3 = ScriptSourceTransformer.unwrapLegacyTemplate(string, string2).trim();
                if (string3.isEmpty() || string3.equals("// Unwrapped class end")) {
                    this.E.addAll(Arrays.asList(this.\u01d9(string2).split("\n")));
                } else {
                    this.E.addAll(Arrays.asList(string3.split("\r?\n", -1)));
                }
                this.\u04ad = true;
                this.\u0138("Migrated " + file.getName() + " to Miau script format (Ctrl+S to save)", false);
            } else {
                if (list.isEmpty()) {
                    this.E.add("");
                } else {
                    this.E.addAll(list);
                }
                this.\u0138("Loaded " + file.getName(), false);
            }
            this.\u04ad = false;
            this.\u0286.clear();
            this.\u0409.clear();
            this.\u016f();
            this.\u02b7();
        }
        catch (IOException iOException) {
            this.\u0138("Failed to read " + file.getName(), true);
            iOException.printStackTrace();
        }
    }

    private void \u04c5() {
        if (this.\u0129 == null) {
            this.\u0138("No file open to save", true);
            return;
        }
        try {
            Manager manager;
            Files.write(this.\u0129.toPath(), this.E, StandardCharsets.UTF_8, new OpenOption[0]);
            this.\u04ad = false;
            Manager manager2 = oc2cf3d80e17.\u013c != null ? oc9755810e45.\u0159 : (manager = null);
            if (oc2cf3d80e17.\u013e != null) {
                oc2cf3d80e17.\u013e.loadScripts();
                if (manager != null) {
                    manager.loadScriptsNow();
                }
            } else if (manager != null) {
                manager.loadScriptsNow();
            }
            if (oc2cf3d80e17.\u013e != null && oc2cf3d80e17.\u013e.compiler == null) {
                this.\u0138("Saved to disk. (Note: Launch client with JDK 17+ to compile scripts)", true);
                this.\u00f5();
                return;
            }
            String string = this.\u0129.getName().replace(".java", "");
            Script script = null;
            if (oc2cf3d80e17.\u013e != null && (script = oc2cf3d80e17.\u013e.getScriptByFile(this.\u0129)) == null) {
                script = oc2cf3d80e17.\u013e.getScript(string);
            }
            if (script != null && script.error) {
                String string2 = script.lastError != null ? script.lastError : "Compile error! Check chat/console";
                this.\u0138("Error: " + string2, true);
            } else if (script != null) {
                this.\u0138("Saved & compiled " + this.\u0129.getName() + " successfully!", false);
            } else {
                this.\u0138("Saved " + this.\u0129.getName(), false);
            }
            this.\u00f5();
        }
        catch (Exception exception) {
            this.\u0138("Failed to save: " + exception.getMessage(), true);
            exception.printStackTrace();
        }
    }

    private void \u00e1(String string) {
        if (string == null || string.trim().isEmpty()) {
            this.\u0138("Script name cannot be empty", true);
            return;
        }
        String string2 = string.trim();
        if (string2.endsWith(".java")) {
            string2 = string2.substring(0, string2.length() - (0xF74D4AFD ^ 0xF74D4AF8));
        }
        if ((string2 = string2.replaceAll("[^a-zA-Z0-9_]", "")).isEmpty()) {
            this.\u0138("Invalid script name", true);
            return;
        }
        File file = new File(this.\u027f, string2 + ".java");
        if (file.exists()) {
            this.\u0138("File already exists: " + file.getName(), true);
            return;
        }
        try {
            String string3 = this.\u01d9(string2);
            Files.write(file.toPath(), Collections.singletonList(string3), StandardCharsets.UTF_8, new OpenOption[0]);
            this.\u00f5();
            this.\u03fb(file);
            this.\u04c5();
            this.p = false;
            this.\u0158 = "";
            this.\u0138("Created " + file.getName(), false);
        }
        catch (IOException iOException) {
            this.\u0138("Failed to create script: " + iOException.getMessage(), true);
            iOException.printStackTrace();
        }
    }

    private String \u01d9(String string) {
        String string2 = string;
        String string3 = string;
        String string4 = string;
        String string5 = string;
        return "// Miau Script: " + string5 + "\n\nvoid onLoad() {\n    modules.registerDescription(\"Custom script: " + string4 + "\");\n    // modules.registerButton(\"Toggle Feature\", true);\n    // modules.registerSlider(\"Settings\", \"Value\", \"\", 5.0, 1.0, 10.0, 0.5);\n}\n\nvoid onEnable() {\n    client.print(\"&a" + string3 + " enabled!\");\n}\n\nvoid onDisable() {\n    client.print(\"&c" + string2 + " disabled!\");\n}\n\nvoid onPreUpdate() {\n    // Runs each client tick\n}\n";
    }

    private void \u02b7() {
        this.\u03ee = 0;
        this.\u0463 = 0;
        this.\u015f = -1;
        this.\u00de = -1;
        this.\u00ec = 0.0f;
        this.\u03ad = 0.0f;
    }

    private void \u0138(String string, boolean bl) {
        this.\u0416 = string;
        this.\u0270 = bl;
        this.\u022e = System.currentTimeMillis();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private int \u025a() {
        return this.width < (0xE773A7AB ^ 0xE773A60F) ? 0 : 0xE773A61B ^ 0xE773A60F;
    }

    private int n() {
        return this.height < (0x4567EED ^ 0x4567FAD) ? 0 : 0x4567FA3 ^ 0x4567FAD;
    }

    private int \u046f() {
        return this.width < (0x55C017E3 ^ 0x55C01647) ? this.width : Math.max(0x55C01743 ^ 0x55C01647, this.width - (0x55C0166F ^ 0x55C01647));
    }

    private int \u03ba() {
        return this.height < (0x745A8414 ^ 0x745A8554) ? this.height : Math.max(0x745A85F4 ^ 0x745A8554, this.height - (0x745A8548 ^ 0x745A8554));
    }

    private static int \u045b(int n, int n2) {
        return Math.max(0, Math.min(0xA39404FA ^ 0xA3940405, n2)) << (0xA394041D ^ 0xA3940405) | n & (0xA36BFBFA ^ 0xA3940405);
    }

    private static boolean \u02ac(float f, float f2, float f3, float f4, int n, int n2) {
        return (float)n >= f && (float)n <= f + f3 && (float)n2 >= f2 && (float)n2 <= f2 + f4;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.fontRendererObj == null) {
            FontRenderer fontRenderer = this.fontRendererObj = Minecraft.getMinecraft() != null ? Minecraft.getMinecraft().fontRendererObj : null;
        }
        if (this.fontRendererObj == null) {
            return;
        }
        this.drawDefaultBackground();
        int n3 = this.\u025a();
        int n4 = this.n();
        int n5 = this.\u046f();
        int n6 = this.\u03ba();
        int n7 = ocd2958dac48.\u02b0(n3 + (0x7D2770DF ^ 0x7D2770CB), n4 + (0x7D2770C1 ^ 0x7D2770CB));
        ocbd4917c4b1.\u04da(n3 - 1, n4 - 1, n3 + n5 + 1, n4 + n6 + 1, 6.0f, ocf65052963e.\u045b(n7, 0x7D27705D ^ 0x7D2770CB));
        ocbd4917c4b1.\u04da(n3, n4, n3 + n5, n4 + n6, 6.0f, 0x8D3364DD ^ 0x7D2770CB);
        this.\u0402(n, n2);
        this.\u0582(n, n2);
        this.\u0453();
        if (this.\u03f9) {
            this.\u0503(n, n2);
        }
        if (this.p) {
            this.\u03af(n, n2);
        }
        if (this.\u0274) {
            if (!Mouse.isButtonDown(0)) {
                this.\u0274 = false;
            } else {
                this.\u0216(n2);
            }
        }
        super.drawScreen(n, n2, f);
    }

    private void \u0402(int n, int n2) {
        int n3 = this.\u025a();
        int n4 = this.n();
        int n5 = this.\u046f();
        int n6 = ocd2958dac48.\u02b0(n3 + (0x78324021 ^ 0x78324035), n4 + (0x7832403F ^ 0x78324035));
        ocbd4917c4b1.\u04da(n3, n4, n3 + n5, n4 + (0x78324029 ^ 0x78324035), 5.0f, 0x872B5929 ^ 0x78324035);
        this.fontRendererObj.drawStringWithShadow("MIAU SCRIPT", n3 + (0x78324039 ^ 0x78324035), n4 + (0x7832403C ^ 0x78324035), n6);
        int n7 = n3 + (0x78324063 ^ 0x78324035);
        int n8 = n4 + (0x78324031 ^ 0x78324035);
        String string = (this.\u0129 != null ? this.\u0129.getName() : "No Script") + (this.\u04ad ? " *" : "");
        int n9 = this.fontRendererObj.getStringWidth(string);
        int n10 = Math.max(0x7832404D ^ 0x78324035, n9 + (0x7832402D ^ 0x78324035));
        int n11 = 0x78324021 ^ 0x78324035;
        boolean bl = ocf65052963e.\u02ac(n7, n8, n10, n11, n, n2);
        ocbd4917c4b1.\u04da(n7, n8, n7 + n10, n8 + n11, 4.0f, this.\u03f9 ? 0x870A780B ^ 0x78324035 : (bl ? 0x87027000 ^ 0x78324035 : 0x87106213 ^ 0x78324035));
        int n12 = this.\u04ad ? 0x87CDEA35 ^ 0x78324035 : 0x87DCAEDB ^ 0x78324035;
        this.fontRendererObj.drawStringWithShadow(string, n7 + (0x78324032 ^ 0x78324035), n8 + (0x78324033 ^ 0x78324035), n12);
        this.fontRendererObj.drawStringWithShadow("\u25be", n7 + n10 - (0x78324039 ^ 0x78324035), n8 + (0x78324033 ^ 0x78324035), 0x87BAC8BD ^ 0x78324035);
        int n13 = n7 + n10 + (0x78324033 ^ 0x78324035);
        int n14 = 0x7832401B ^ 0x78324035;
        boolean bl2 = ocf65052963e.\u02ac(n13, n8, n14, n11, n, n2);
        ocbd4917c4b1.\u04da(n13, n8, n13 + n14, n8 + n11, 4.0f, bl2 ? 0x8707750E ^ 0x78324035 : 0x87106213 ^ 0x78324035);
        this.fontRendererObj.drawStringWithShadow("+ New", n13 + (n14 - this.fontRendererObj.getStringWidth("+ New")) / (0x78324037 ^ 0x78324035), n8 + (0x78324033 ^ 0x78324035), bl2 ? -1 : 0x87BAC8BD ^ 0x78324035);
        int n15 = n3 + n5 - (0x7832403D ^ 0x78324035);
        this.\u028d("\u2715", n15 -= 24, n8, 0x78324023 ^ 0x78324035, n11, n, n2, false, 0, 0x87CD1560 ^ 0x78324035);
        this.\u028d("Folder", n15 -= 52, n8, 0x78324005 ^ 0x78324035, n11, n, n2, false, 0, 0x87DCAEDB ^ 0x78324035);
        if (this.\u04ad) {
            this.\u028d("Revert", n15 -= 54, n8, 0x78324007 ^ 0x78324035, n11, n, n2, false, 0, 0x87CDEA35 ^ 0x78324035);
        }
        int n16 = this.\u04ad ? 0x871C3D07 ^ 0x78324035 : ocf65052963e.\u045b(n6, 0x783240E7 ^ 0x78324035);
        this.\u028d("Save (Ctrl+S)", n15 -= 102, n8, 0x78324057 ^ 0x78324035, n11, n, n2, true, n16, -1);
    }

    private void \u028d(String string, int n, int n2, int n3, int n4, int n5, int n6, boolean bl, int n7, int n8) {
        boolean bl2;
        boolean bl3 = bl2 = n5 >= n && n5 <= n + n3 && n6 >= n2 && n6 <= n2 + n4;
        int n9 = bl ? (bl2 ? 0x9B75202B ^ 0x644DAE17 : n7) : (bl2 ? 0x9B789B2C ^ 0x644DAE17 : 0x9B6F8C31 ^ 0x644DAE17);
        ocbd4917c4b1.\u04da(n, n2, n + n3, n2 + n4, 4.0f, n9);
        int n10 = n + (n3 - this.fontRendererObj.getStringWidth(string)) / (0x644DAE15 ^ 0x644DAE17);
        int n11 = n2 + (n4 - this.fontRendererObj.FONT_HEIGHT) / (0x644DAE15 ^ 0x644DAE17);
        this.fontRendererObj.drawStringWithShadow(string, n10, n11, bl2 ? -1 : n8);
    }

    private void \u0503(int n, int n2) {
        int n3 = this.\u025a();
        int n4 = this.n();
        int n5 = n3 + (0x2D3ED808 ^ 0x2D3ED85E);
        int n6 = n4 + (0x2D3ED85A ^ 0x2D3ED85E);
        String string = (this.\u0129 != null ? this.\u0129.getName() : "No Script") + (this.\u04ad ? " *" : "");
        int n7 = this.fontRendererObj.getStringWidth(string);
        int n8 = Math.max(0x2D3ED826 ^ 0x2D3ED85E, n7 + (0x2D3ED846 ^ 0x2D3ED85E));
        int n9 = n5;
        int n10 = n6 + (0x2D3ED84A ^ 0x2D3ED85E) + (0x2D3ED85C ^ 0x2D3ED85E);
        int n11 = Math.max(0x2D3ED8FE ^ 0x2D3ED85E, n8);
        int n12 = 0x2D3ED84C ^ 0x2D3ED85E;
        int n13 = Math.min(0x2D3ED856 ^ 0x2D3ED85E, Math.max(1, this.v.size()));
        int n14 = n13 * n12 + (0x2D3ED858 ^ 0x2D3ED85E);
        int n15 = ocd2958dac48.\u02b0(n9, n10);
        ocbd4917c4b1.\u04da(n9 - 1, n10 - 1, n9 + n11 + 1, n10 + n14 + 1, 4.0f, ocf65052963e.\u045b(n15, 0x2D3ED8EA ^ 0x2D3ED85E));
        ocbd4917c4b1.\u04da(n9, n10, n9 + n11, n10 + n14, 4.0f, 0xD724C240 ^ 0x2D3ED85E);
        if (this.v.isEmpty()) {
            this.fontRendererObj.drawStringWithShadow("No scripts in miau/scripts", n9 + (0x2D3ED856 ^ 0x2D3ED85E), n10 + (0x2D3ED859 ^ 0x2D3ED85E), 0xD2B650D6 ^ 0x2D3ED85E);
            return;
        }
        int n16 = n10 + (0x2D3ED85D ^ 0x2D3ED85E);
        for (int i = 0; i < n13; ++i) {
            boolean bl;
            File file = this.v.get(i);
            boolean bl2 = this.\u0129 != null && this.\u0129.equals(file);
            boolean bl3 = bl = n >= n9 && n <= n9 + n11 && n2 >= n16 && n2 < n16 + n12;
            if (bl2) {
                Gui.drawRect(n9 + 1, n16, n9 + (0x2D3ED85D ^ 0x2D3ED85E), n16 + n12, n15);
            }
            if (bl) {
                Gui.drawRect(n9 + 1, n16, n9 + n11 - 1, n16 + n12, 0xFC127A1 ^ 0x2D3ED85E);
            }
            String string2 = file.getName();
            int n17 = bl2 ? n15 : (bl ? -1 : 0xD2F21492 ^ 0x2D3ED85E);
            this.fontRendererObj.drawStringWithShadow(string2, n9 + (0x2D3ED856 ^ 0x2D3ED85E), n16 + (0x2D3ED85B ^ 0x2D3ED85E), n17);
            n16 += n12;
        }
    }

    private void \u0582(int n, int n2) {
        int n3 = this.\u025a();
        int n4 = this.n();
        int n5 = this.\u046f();
        int n6 = this.\u03ba();
        int n7 = n3 + (0xFB6DEEA0 ^ 0xFB6DEEA6);
        int n8 = n4 + (0xFB6DEEBA ^ 0xFB6DEEA6) + (0xFB6DEEA4 ^ 0xFB6DEEA6);
        int n9 = n5 - (0xFB6DEEAA ^ 0xFB6DEEA6);
        int n10 = n6 - (0xFB6DEEBA ^ 0xFB6DEEA6) - (0xFB6DEEB4 ^ 0xFB6DEEA6) - (0xFB6DEEA2 ^ 0xFB6DEEA6);
        ocbd4917c4b1.\u04da(n7, n8, n7 + n9, n8 + n10, 4.0f, 0x157CFFB5 ^ 0xFB6DEEA6);
        int n11 = this.fontRendererObj.FONT_HEIGHT + (0xFB6DEEA5 ^ 0xFB6DEEA6);
        int n12 = n7 + (0xFB6DEEBA ^ 0xFB6DEEA6) + (0xFB6DEEA0 ^ 0xFB6DEEA6);
        int n13 = Math.max(0, (int)(this.\u00ec / (float)n11));
        int n14 = n10 / n11 + (0xFB6DEEA4 ^ 0xFB6DEEA6);
        int n15 = Math.min(this.E.size() - 1, n13 + n14);
        ocbd4917c4b1.\u010e(n7, n8, n9 - (0xFB6DEEA1 ^ 0xFB6DEEA6) - (0xFB6DEEA2 ^ 0xFB6DEEA6), n10);
        for (int i = n13; i <= n15; ++i) {
            int n16 = n8 + (int)((float)(i * n11) - this.\u00ec);
            String string = String.valueOf(i + 1);
            int n17 = this.fontRendererObj.getStringWidth(string);
            int n18 = i == this.\u03ee ? 0x4830048 ^ 0xFB6DEEA6 : 0x43DBEF3 ^ 0xFB6DEEA6;
            this.fontRendererObj.drawString(string, n7 + (0xFB6DEEBA ^ 0xFB6DEEA6) - n17 - (0xFB6DEEA2 ^ 0xFB6DEEA6), n16 + 1, n18, false);
            if (i == this.\u03ee) {
                Gui.drawRect(n7 + (0xFB6DEEBA ^ 0xFB6DEEA6), n16, n7 + n9 - (0xFB6DEEA1 ^ 0xFB6DEEA6) - (0xFB6DEEA2 ^ 0xFB6DEEA6), n16 + n11, 0xEB921159 ^ 0xFB6DEEA6);
            }
            String string2 = i < this.E.size() ? this.E.get(i) : "";
            this.\u03b6(i, string2, n12 - (int)this.\u03ad, n16, n11);
            this.\u03c8(string2, n12 - (int)this.\u03ad, n16 + 1);
            if (i != this.\u03ee || System.currentTimeMillis() / (0x9C43584FDF70D3E9L ^ 0x9C43584FDF70D21DL) % (0x9C43584FDF70D21FL ^ 0x9C43584FDF70D21DL) != 0L) continue;
            int n19 = Math.min(this.\u0463, string2.length());
            String string3 = string2.substring(0, n19);
            int n20 = n12 - (int)this.\u03ad + this.fontRendererObj.getStringWidth(string3);
            Gui.drawRect(n20, n16, n20 + 1, n16 + n11 - 1, -1);
        }
        ocbd4917c4b1.\u01df();
        this.\u03dc(n, n2, n7, n8, n9, n10);
    }

    private void \u03dc(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = n3 + n5 - (0xB73C96E3 ^ 0xB73C96E4) - (0xB73C96E6 ^ 0xB73C96E4);
        int n8 = n4 + (0xB73C96E7 ^ 0xB73C96E4);
        int n9 = 0xB73C96E3 ^ 0xB73C96E4;
        int n10 = n6 - (0xB73C96E2 ^ 0xB73C96E4);
        int n11 = this.fontRendererObj.FONT_HEIGHT + (0xB73C96E7 ^ 0xB73C96E4);
        float f = Math.max(1, this.E.size()) * n11;
        float f2 = Math.max(0.0f, f - (float)n6 + (float)n11);
        ocbd4917c4b1.\u04da(n7, n8, n7 + n9, n8 + n10, 3.0f, 0xAFC3691B ^ 0xB73C96E4);
        if (f2 > 0.0f) {
            float f3 = Math.max(22.0f, (float)n6 / f * (float)n10);
            float f4 = (float)n8 + this.\u00ec / f2 * ((float)n10 - f3);
            boolean bl = n >= n7 - (0xB73C96E7 ^ 0xB73C96E4) && n <= n7 + n9 + (0xB73C96E7 ^ 0xB73C96E4) && (float)n2 >= f4 && (float)n2 <= f4 + f3;
            int n12 = ocd2958dac48.\u02b0(n7, f4);
            int n13 = this.\u0274 ? ocf65052963e.\u045b(n12, 0xB73C9614 ^ 0xB73C96E4) : (bl ? 0x27C3691B ^ 0xB73C96E4 : 0xFFC3691B ^ 0xB73C96E4);
            ocbd4917c4b1.\u04da(n7, f4, n7 + n9, f4 + f3, 3.0f, n13);
        }
    }

    private void \u0216(int n) {
        int n2 = this.\u03ba();
        int n3 = n2 - (0x1886FBE0 ^ 0x1886FBFC) - (0x1886FBEE ^ 0x1886FBFC) - (0x1886FBF8 ^ 0x1886FBFC);
        int n4 = this.n() + (0x1886FBE0 ^ 0x1886FBFC) + (0x1886FBFE ^ 0x1886FBFC) + (0x1886FBFF ^ 0x1886FBFC);
        int n5 = n3 - (0x1886FBFA ^ 0x1886FBFC);
        int n6 = this.fontRendererObj.FONT_HEIGHT + (0x1886FBFF ^ 0x1886FBFC);
        float f = Math.max(1, this.E.size()) * n6;
        float f2 = Math.max(0.0f, f - (float)n3 + (float)n6);
        if (f2 <= 0.0f) {
            this.\u00ec = 0.0f;
            return;
        }
        float f3 = Math.max(22.0f, (float)n3 / f * (float)n5);
        float f4 = (float)n5 - f3;
        if (f4 <= 0.0f) {
            this.\u00ec = 0.0f;
            return;
        }
        float f5 = (float)(n - n4) - this.\u0505;
        float f6 = f5 / f4;
        this.\u00ec = Math.max(0.0f, Math.min(f2, f6 * f2));
    }

    private void \u03b6(int n, String string, int n2, int n3, int n4) {
        int n5;
        int n6;
        if (!this.\u03cc()) {
            return;
        }
        int n7 = Math.min(this.\u015f, this.\u03ee);
        int n8 = Math.max(this.\u015f, this.\u03ee);
        if (n < n7 || n > n8) {
            return;
        }
        if (n7 == n8) {
            n6 = Math.min(this.\u00de, this.\u0463);
            n5 = Math.max(this.\u00de, this.\u0463);
        } else if (n == n7) {
            n6 = this.\u015f == n7 ? this.\u00de : this.\u0463;
            n5 = string.length();
        } else if (n == n8) {
            n6 = 0;
            n5 = this.\u015f == n8 ? this.\u00de : this.\u0463;
        } else {
            n6 = 0;
            n5 = string.length();
        }
        n6 = Math.max(0, Math.min(n6, string.length()));
        n5 = Math.max(0, Math.min(n5, string.length()));
        int n9 = n2 + this.fontRendererObj.getStringWidth(string.substring(0, n6));
        int n10 = n2 + this.fontRendererObj.getStringWidth(string.substring(0, n5));
        if (n9 == n10 && n6 == string.length()) {
            n10 += 4;
        }
        Gui.drawRect(n9, n3, n10, n3 + n4, 0x1D3FF44C ^ 0x4807819B);
    }

    private void \u03c8(String string, int n, int n2) {
        if (string.isEmpty()) {
            return;
        }
        int n3 = n;
        int n4 = string.indexOf("//");
        String string2 = n4 >= 0 ? string.substring(0, n4) : string;
        String string3 = n4 >= 0 ? string.substring(n4) : null;
        int n5 = string2.length();
        int n6 = 0;
        while (n6 < n5) {
            char c = string2.charAt(n6);
            if (c == (0xF086E027 ^ 0xF086E005) || c == (0xF086E022 ^ 0xF086E005)) {
                char c2 = c;
                int n7 = n6++;
                while (n6 < n5 && string2.charAt(n6) != c2) {
                    if (string2.charAt(n6) == (0xF086E059 ^ 0xF086E005) && n6 + 1 < n5) {
                        n6 += 2;
                        continue;
                    }
                    ++n6;
                }
                if (n6 < n5) {
                    ++n6;
                }
                String string4 = string2.substring(n7, n6);
                this.fontRendererObj.drawString(string4, n3, n2, 0xF48717D ^ 0xF086E005, false);
                n3 += this.fontRendererObj.getStringWidth(string4);
                continue;
            }
            if (c == (0xF086E045 ^ 0xF086E005)) {
                int n8 = n6++;
                while (n6 < n5 && Character.isJavaIdentifierPart(string2.charAt(n6))) {
                    ++n6;
                }
                String string5 = string2.substring(n8, n6);
                this.fontRendererObj.drawString(string5, n3, n2, 0xF5A3CAF ^ 0xF086E005, false);
                n3 += this.fontRendererObj.getStringWidth(string5);
                continue;
            }
            if (Character.isJavaIdentifierStart(c)) {
                int n9 = n6;
                while (n6 < n5 && Character.isJavaIdentifierPart(string2.charAt(n6))) {
                    ++n6;
                }
                String string6 = string2.substring(n9, n6);
                int n10 = \u01d2.contains(string6) ? 0xFD07CD3 ^ 0xF086E005 : 0xF5234D1 ^ 0xF086E005;
                this.fontRendererObj.drawString(string6, n3, n2, n10, false);
                n3 += this.fontRendererObj.getStringWidth(string6);
                continue;
            }
            if (Character.isDigit(c)) {
                int n11 = n6;
                while (n6 < n5 && (Character.isDigit(string2.charAt(n6)) || string2.charAt(n6) == (0xF086E02B ^ 0xF086E005) || string2.charAt(n6) == (0xF086E063 ^ 0xF086E005) || string2.charAt(n6) == (0xF086E043 ^ 0xF086E005) || string2.charAt(n6) == (0xF086E061 ^ 0xF086E005) || string2.charAt(n6) == (0xF086E041 ^ 0xF086E005) || string2.charAt(n6) == (0xF086E049 ^ 0xF086E005) || string2.charAt(n6) == (0xF086E069 ^ 0xF086E005))) {
                    ++n6;
                }
                String string7 = string2.substring(n11, n6);
                this.fontRendererObj.drawString(string7, n3, n2, 0xF332EAD ^ 0xF086E005, false);
                n3 += this.fontRendererObj.getStringWidth(string7);
                continue;
            }
            String string8 = String.valueOf(c);
            this.fontRendererObj.drawString(string8, n3, n2, 0xF5234D1 ^ 0xF086E005, false);
            n3 += this.fontRendererObj.getStringWidth(string8);
            ++n6;
        }
        if (string3 != null) {
            this.fontRendererObj.drawString(string3, n3, n2, 0xFEC7950 ^ 0xF086E005, false);
        }
    }

    private void \u0453() {
        int n = this.\u025a();
        int n2 = this.n();
        int n3 = this.\u046f();
        int n4 = this.\u03ba();
        int n5 = n2 + n4 - (0x8D14B749 ^ 0x8D14B75B);
        ocbd4917c4b1.\u04da(n, n5, n + n3, n2 + n4, 4.0f, 0x7207A44E ^ 0x8D14B75B);
        int n6 = this.\u0270 ? 0x72EBE20E ^ 0x8D14B75B : 0x7241480E ^ 0x8D14B75B;
        this.fontRendererObj.drawStringWithShadow(this.\u0416, n + (0x8D14B751 ^ 0x8D14B75B), n5 + (0x8D14B75E ^ 0x8D14B75B), n6);
        int n7 = this.E.size();
        int n8 = this.\u0463 + 1;
        int n9 = this.\u03ee + 1;
        String string = "Ln " + n9 + ", Col " + n8 + "  |  " + n7 + " lines  |  UTF-8";
        int n10 = this.fontRendererObj.getStringWidth(string);
        this.fontRendererObj.drawStringWithShadow(string, n + n3 - n10 - (0x8D14B751 ^ 0x8D14B75B), n5 + (0x8D14B75E ^ 0x8D14B75B), 0x729C3FD3 ^ 0x8D14B75B);
    }

    private void \u03af(int n, int n2) {
        Gui.drawRect(0, 0, this.width, this.height, 0xC80F5F68 ^ 0x580F5F68);
        int n3 = 0x580F5E6C ^ 0x580F5F68;
        int n4 = 0x580F5F01 ^ 0x580F5F68;
        int n5 = (this.width - n3) / (0x580F5F6A ^ 0x580F5F68);
        int n6 = (this.height - n4) / (0x580F5F6A ^ 0x580F5F68);
        int n7 = ocd2958dac48.\u02b0(n5, n6);
        ocbd4917c4b1.\u04da(n5 - 1, n6 - 1, n5 + n3 + 1, n6 + n4 + 1, 5.0f, ocf65052963e.\u045b(n7, 0x580F5FDC ^ 0x580F5F68));
        ocbd4917c4b1.\u04da(n5, n6, n5 + n3, n6 + n4, 5.0f, 0xAD11414A ^ 0x580F5F68);
        this.fontRendererObj.drawStringWithShadow("Create New Script", n5 + (0x580F5F78 ^ 0x580F5F68), n6 + (0x580F5F64 ^ 0x580F5F68), 0xA7E1B186 ^ 0x580F5F68);
        this.fontRendererObj.drawStringWithShadow("Enter script name (.java):", n5 + (0x580F5F78 ^ 0x580F5F68), n6 + (0x580F5F74 ^ 0x580F5F68), 0xA787D7E0 ^ 0x580F5F68);
        int n8 = n6 + (0x580F5F44 ^ 0x580F5F68);
        ocbd4917c4b1.\u04da(n5 + (0x580F5F78 ^ 0x580F5F68), n8, n5 + n3 - (0x580F5F78 ^ 0x580F5F68), n8 + (0x580F5F7C ^ 0x580F5F68), 3.0f, 0xA71B4B7E ^ 0x580F5F68);
        String string = this.\u0158 + (System.currentTimeMillis() / (0x1581A870477FE116L ^ 0x1581A870477FE086L) % (0x1581A870477FE084L ^ 0x1581A870477FE086L) == 0L ? "_" : "");
        this.fontRendererObj.drawStringWithShadow(string, n5 + (0x580F5F7E ^ 0x580F5F68), n8 + (0x580F5F6E ^ 0x580F5F68), -1);
        this.\u028d("Create", n5 + n3 - (0x580F5FE4 ^ 0x580F5F68), n6 + (0x580F5F20 ^ 0x580F5F68), 0x580F5F54 ^ 0x580F5F68, 0x580F5F7C ^ 0x580F5F68, n, n2, true, ocf65052963e.\u045b(n7, 0x580F5FB4 ^ 0x580F5F68), -1);
        this.\u028d("Cancel", n5 + n3 - (0x580F5F20 ^ 0x580F5F68), n6 + (0x580F5F20 ^ 0x580F5F68), 0x580F5F50 ^ 0x580F5F68, 0x580F5F7C ^ 0x580F5F68, n, n2, false, 0, 0xA787D7E0 ^ 0x580F5F68);
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        if (n3 != 0) {
            return;
        }
        if (this.p) {
            int n10 = 0x5D64D931 ^ 0x5D64D835;
            int n11 = 0x5D64D85C ^ 0x5D64D835;
            int n12 = (this.width - n10) / (0x5D64D837 ^ 0x5D64D835);
            int n13 = (this.height - n11) / (0x5D64D837 ^ 0x5D64D835);
            if (n >= n12 + n10 - (0x5D64D8B9 ^ 0x5D64D835) && n <= n12 + n10 - (0x5D64D865 ^ 0x5D64D835) && n2 >= n13 + (0x5D64D87D ^ 0x5D64D835) && n2 <= n13 + (0x5D64D869 ^ 0x5D64D835)) {
                this.\u00e1(this.\u0158);
                return;
            }
            if (n >= n12 + n10 - (0x5D64D87D ^ 0x5D64D835) && n <= n12 + n10 - (0x5D64D825 ^ 0x5D64D835) && n2 >= n13 + (0x5D64D87D ^ 0x5D64D835) && n2 <= n13 + (0x5D64D869 ^ 0x5D64D835)) {
                this.p = false;
                this.\u0158 = "";
                return;
            }
            return;
        }
        int n14 = this.\u025a();
        int n15 = this.n();
        int n16 = this.\u046f();
        int n17 = this.\u03ba();
        int n18 = n14 + (0x5D64D863 ^ 0x5D64D835);
        int n19 = n15 + (0x5D64D831 ^ 0x5D64D835);
        String string = (this.\u0129 != null ? this.\u0129.getName() : "No Script") + (this.\u04ad ? " *" : "");
        int n20 = this.fontRendererObj.getStringWidth(string);
        int n21 = Math.max(0x5D64D84D ^ 0x5D64D835, n20 + (0x5D64D82D ^ 0x5D64D835));
        int n22 = 0x5D64D821 ^ 0x5D64D835;
        if (this.\u03f9) {
            n9 = n18;
            n8 = n19 + n22 + (0x5D64D837 ^ 0x5D64D835);
            n7 = Math.max(0x5D64D895 ^ 0x5D64D835, n21);
            n6 = 0x5D64D827 ^ 0x5D64D835;
            n5 = Math.min(0x5D64D83D ^ 0x5D64D835, Math.max(1, this.v.size()));
            n4 = n5 * n6 + (0x5D64D833 ^ 0x5D64D835);
            if (n >= n9 && n <= n9 + n7 && n2 >= n8 && n2 <= n8 + n4) {
                int n23 = (n2 - n8 - (0x5D64D836 ^ 0x5D64D835)) / n6;
                if (n23 >= 0 && n23 < this.v.size()) {
                    this.\u03fb(this.v.get(n23));
                }
                this.\u03f9 = false;
                return;
            }
            this.\u03f9 = false;
            if (n >= n18 && n <= n18 + n21 && n2 >= n19 && n2 <= n19 + n22) {
                return;
            }
        }
        if (n2 >= n15 && n2 <= n15 + (0x5D64D829 ^ 0x5D64D835)) {
            if (n >= n18 && n <= n18 + n21 && n2 >= n19 && n2 <= n19 + n22) {
                this.\u03f9 = !this.\u03f9;
                return;
            }
            n9 = n18 + n21 + (0x5D64D833 ^ 0x5D64D835);
            n8 = 0x5D64D81B ^ 0x5D64D835;
            if (n >= n9 && n <= n9 + n8 && n2 >= n19 && n2 <= n19 + n22) {
                this.p = true;
                this.\u0158 = "";
                return;
            }
            n7 = n14 + n16 - (0x5D64D83D ^ 0x5D64D835);
            if (n >= (n7 -= 24) && n <= n7 + (0x5D64D823 ^ 0x5D64D835) && n2 >= n19 && n2 <= n19 + n22) {
                this.mc.displayGuiScreen(this.\u0457);
                return;
            }
            if (n >= (n7 -= 52) && n <= n7 + (0x5D64D805 ^ 0x5D64D835) && n2 >= n19 && n2 <= n19 + n22) {
                this.\u0456();
                return;
            }
            if (this.\u04ad && n >= (n7 -= 54) && n <= n7 + (0x5D64D807 ^ 0x5D64D835) && n2 >= n19 && n2 <= n19 + n22) {
                if (this.\u0129 != null) {
                    this.\u03fb(this.\u0129);
                }
                return;
            }
            if (n >= (n7 -= 102) && n <= n7 + (0x5D64D857 ^ 0x5D64D835) && n2 >= n19 && n2 <= n19 + n22) {
                this.\u04c5();
                return;
            }
            return;
        }
        n9 = n14 + (0x5D64D833 ^ 0x5D64D835);
        n8 = n15 + (0x5D64D829 ^ 0x5D64D835) + (0x5D64D837 ^ 0x5D64D835);
        n7 = n16 - (0x5D64D839 ^ 0x5D64D835);
        n6 = n17 - (0x5D64D829 ^ 0x5D64D835) - (0x5D64D827 ^ 0x5D64D835) - (0x5D64D831 ^ 0x5D64D835);
        n5 = n9 + n7 - (0x5D64D832 ^ 0x5D64D835) - (0x5D64D837 ^ 0x5D64D835);
        n4 = n8 + (0x5D64D837 ^ 0x5D64D835);
        int n24 = 0x5D64D832 ^ 0x5D64D835;
        int n25 = n6 - (0x5D64D831 ^ 0x5D64D835);
        int n26 = this.fontRendererObj.FONT_HEIGHT + (0x5D64D836 ^ 0x5D64D835);
        float f = Math.max(1, this.E.size()) * n26;
        float f2 = Math.max(0.0f, f - (float)n6 + (float)n26);
        if (f2 > 0.0f && n >= n5 - (0x5D64D831 ^ 0x5D64D835) && n <= n5 + n24 + (0x5D64D831 ^ 0x5D64D835) && n2 >= n4 && n2 <= n4 + n25) {
            float f3 = Math.max(22.0f, (float)n6 / f * (float)n25);
            float f4 = (float)n4 + this.\u00ec / f2 * ((float)n25 - f3);
            this.\u0274 = true;
            if ((float)n2 >= f4 && (float)n2 <= f4 + f3) {
                this.\u0505 = (float)n2 - f4;
            } else {
                this.\u0505 = f3 * 0.5f;
                float f5 = (float)(n2 - n4) - this.\u0505;
                float f6 = (float)n25 > f3 ? f5 / ((float)n25 - f3) : 0.0f;
                this.\u00ec = Math.max(0.0f, Math.min(f2, f6 * f2));
            }
            return;
        }
        if (n >= n9 && n < n5 - (0x5D64D836 ^ 0x5D64D835) && n2 >= n8 && n2 < n8 + n6) {
            int n27 = (int)(((float)(n2 - n8) + this.\u00ec) / (float)n26);
            n27 = Math.max(0, Math.min(n27, this.E.size() - 1));
            int n28 = n9 + (0x5D64D829 ^ 0x5D64D835) + (0x5D64D833 ^ 0x5D64D835) - (int)this.\u03ad;
            int n29 = this.\u0127(n27, n - n28);
            this.\u03ee = n27;
            this.\u0463 = n29;
            if (GuiScreen.isShiftKeyDown()) {
                if (this.\u015f == -1) {
                    this.\u015f = n27;
                    this.\u00de = n29;
                }
            } else {
                this.\u015f = this.\u03ee;
                this.\u00de = this.\u0463;
            }
            this.\u0297 = true;
            this.\u0221();
        }
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        if (n3 != 0) {
            return;
        }
        if (this.\u0274) {
            this.\u0216(n2);
            return;
        }
        if (this.\u0297) {
            int n4 = this.\u025a();
            int n5 = this.n();
            int n6 = n4 + (0x4DF2BAF2 ^ 0x4DF2BAF4);
            int n7 = n5 + (0x4DF2BAE8 ^ 0x4DF2BAF4) + (0x4DF2BAF6 ^ 0x4DF2BAF4);
            int n8 = this.fontRendererObj.FONT_HEIGHT + (0x4DF2BAF7 ^ 0x4DF2BAF4);
            int n9 = (int)(((float)(n2 - n7) + this.\u00ec) / (float)n8);
            n9 = Math.max(0, Math.min(n9, this.E.size() - 1));
            int n10 = n6 + (0x4DF2BAE8 ^ 0x4DF2BAF4) + (0x4DF2BAF2 ^ 0x4DF2BAF4) - (int)this.\u03ad;
            int n11 = this.\u0127(n9, n - n10);
            this.\u03ee = n9;
            this.\u0463 = n11;
            this.\u0221();
            this.\u0517();
        }
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        if (n3 == 0) {
            this.\u0297 = false;
            this.\u0274 = false;
        }
        super.mouseReleased(n, n2, n3);
    }

    private int \u0127(int n, int n2) {
        if (n < 0 || n >= this.E.size()) {
            return 0;
        }
        String string = this.E.get(n);
        if (n2 <= 0) {
            return 0;
        }
        int n3 = 0;
        for (int i = 0; i < string.length(); ++i) {
            int n4 = this.fontRendererObj.getCharWidth(string.charAt(i));
            if (n2 < n3 + n4 / (0x715C3948 ^ 0x715C394A)) {
                return i;
            }
            n3 += n4;
        }
        return string.length();
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            if (GuiScreen.isShiftKeyDown()) {
                this.\u03ad = Math.max(0.0f, this.\u03ad + (float)(n > 0 ? 0x8D57BEFA ^ 0x72A84126 : 0x72A84102 ^ 0x72A84126));
            } else {
                int n2 = this.fontRendererObj != null ? this.fontRendererObj.FONT_HEIGHT + (0x72A84125 ^ 0x72A84126) : 0x72A8412A ^ 0x72A84126;
                int n3 = 0x72A84122 ^ 0x72A84126;
                float f = n > 0 ? (float)(-(n2 * n3)) : (float)(n2 * n3);
                int n4 = this.\u03ba();
                int n5 = n4 - (0x72A8413A ^ 0x72A84126) - (0x72A84134 ^ 0x72A84126) - (0x72A84122 ^ 0x72A84126);
                float f2 = Math.max(0.0f, (float)(this.E.size() * n2 - n5 + n2));
                this.\u00ec = Math.max(0.0f, Math.min(this.\u00ec + f, f2));
            }
        }
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (this.p) {
            if (n == 1) {
                this.p = false;
                this.\u0158 = "";
                return;
            }
            if (n == (0x3C8B9BC2 ^ 0x3C8B9BDE)) {
                this.\u00e1(this.\u0158);
                return;
            }
            if (n == (0x3C8B9BD0 ^ 0x3C8B9BDE)) {
                if (!this.\u0158.isEmpty()) {
                    this.\u0158 = this.\u0158.substring(0, this.\u0158.length() - 1);
                }
                return;
            }
            if (ocfc26979767.\u0287(c) || c == (0x3C8B9B81 ^ 0x3C8B9BDE) || c == (0x3C8B9BF3 ^ 0x3C8B9BDE)) {
                this.\u0158 = this.\u0158 + c;
            }
            return;
        }
        if (this.\u03f9 && n == 1) {
            this.\u03f9 = false;
            return;
        }
        if (n == 1) {
            this.mc.displayGuiScreen(this.\u0457);
            return;
        }
        boolean bl = GuiScreen.isCtrlKeyDown();
        boolean bl2 = GuiScreen.isShiftKeyDown();
        if (bl && n == (0x3C8B9BC1 ^ 0x3C8B9BDE)) {
            this.\u04c5();
            return;
        }
        if (bl && n == (0x3C8B9BC0 ^ 0x3C8B9BDE)) {
            this.\u015f = 0;
            this.\u00de = 0;
            this.\u03ee = Math.max(0, this.E.size() - 1);
            this.\u0463 = this.E.isEmpty() ? 0 : this.E.get(this.\u03ee).length();
            return;
        }
        if (bl && n == (0x3C8B9BF0 ^ 0x3C8B9BDE)) {
            this.\u039b();
            return;
        }
        if (bl && n == (0x3C8B9BF3 ^ 0x3C8B9BDE)) {
            this.\u039b();
            this.\u03c6();
            this.\u016f();
            this.\u0517();
            return;
        }
        if (bl && n == (0x3C8B9BF1 ^ 0x3C8B9BDE)) {
            this.\u038c();
            this.\u016f();
            this.\u0517();
            return;
        }
        if (bl && n == (0x3C8B9BF2 ^ 0x3C8B9BDE)) {
            this.\u0204();
            return;
        }
        if (bl && n == (0x3C8B9BCB ^ 0x3C8B9BDE)) {
            this.\u017d();
            return;
        }
        if (n == (0x3C8B9B15 ^ 0x3C8B9BDE)) {
            this.\u01af(bl2, bl);
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B13 ^ 0x3C8B9BDE)) {
            this.\u0388(bl2, bl);
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B16 ^ 0x3C8B9BDE)) {
            this.\u043d(bl2);
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B0E ^ 0x3C8B9BDE)) {
            this.\u028d(bl2);
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B19 ^ 0x3C8B9BDE)) {
            this.\u0531(bl2);
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B11 ^ 0x3C8B9BDE)) {
            this.\u03e9(bl2);
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B17 ^ 0x3C8B9BDE)) {
            this.\u03ee = Math.max(0, this.\u03ee - (0x3C8B9BCA ^ 0x3C8B9BDE));
            if (!bl2) {
                this.\u0186();
            }
            this.\u0221();
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B0F ^ 0x3C8B9BDE)) {
            this.\u03ee = Math.min(this.E.size() - 1, this.\u03ee + (0x3C8B9BCA ^ 0x3C8B9BDE));
            if (!bl2) {
                this.\u0186();
            }
            this.\u0221();
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9BD0 ^ 0x3C8B9BDE)) {
            this.\u03fb();
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9B0D ^ 0x3C8B9BDE)) {
            this.\u04d7();
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9BC2 ^ 0x3C8B9BDE)) {
            this.\u00b5();
            this.\u0517();
            return;
        }
        if (n == (0x3C8B9BD1 ^ 0x3C8B9BDE)) {
            this.\u01ff(bl2);
            this.\u0517();
            return;
        }
        if (c >= (0x3C8B9BFE ^ 0x3C8B9BDE) && c != (0x3C8B9BA1 ^ 0x3C8B9BDE)) {
            this.Y(c);
            this.\u0517();
        }
    }

    private void \u01af(boolean bl, boolean bl2) {
        if (!bl && this.\u03cc()) {
            int n = Math.min(this.\u015f, this.\u03ee);
            int n2 = this.\u015f == this.\u03ee ? Math.min(this.\u00de, this.\u0463) : (this.\u015f < this.\u03ee ? this.\u00de : this.\u0463);
            this.\u03ee = n;
            this.\u0463 = n2;
            this.\u0186();
            return;
        }
        if (bl && this.\u015f == -1) {
            this.\u015f = this.\u03ee;
            this.\u00de = this.\u0463;
        }
        if (this.\u0463 > 0) {
            --this.\u0463;
        } else if (this.\u03ee > 0) {
            --this.\u03ee;
            this.\u0463 = this.E.get(this.\u03ee).length();
        }
        if (!bl) {
            this.\u0186();
        }
    }

    private void \u0388(boolean bl, boolean bl2) {
        String string;
        if (!bl && this.\u03cc()) {
            int n = Math.max(this.\u015f, this.\u03ee);
            int n2 = this.\u015f == this.\u03ee ? Math.max(this.\u00de, this.\u0463) : (this.\u015f > this.\u03ee ? this.\u00de : this.\u0463);
            this.\u03ee = n;
            this.\u0463 = n2;
            this.\u0186();
            return;
        }
        if (bl && this.\u015f == -1) {
            this.\u015f = this.\u03ee;
            this.\u00de = this.\u0463;
        }
        if (this.\u0463 < (string = this.E.get(this.\u03ee)).length()) {
            ++this.\u0463;
        } else if (this.\u03ee < this.E.size() - 1) {
            ++this.\u03ee;
            this.\u0463 = 0;
        }
        if (!bl) {
            this.\u0186();
        }
    }

    private void \u043d(boolean bl) {
        if (bl && this.\u015f == -1) {
            this.\u015f = this.\u03ee;
            this.\u00de = this.\u0463;
        }
        if (this.\u03ee > 0) {
            --this.\u03ee;
            this.\u0221();
        }
        if (!bl) {
            this.\u0186();
        }
    }

    private void \u028d(boolean bl) {
        if (bl && this.\u015f == -1) {
            this.\u015f = this.\u03ee;
            this.\u00de = this.\u0463;
        }
        if (this.\u03ee < this.E.size() - 1) {
            ++this.\u03ee;
            this.\u0221();
        }
        if (!bl) {
            this.\u0186();
        }
    }

    private void \u0531(boolean bl) {
        int n;
        if (bl && this.\u015f == -1) {
            this.\u015f = this.\u03ee;
            this.\u00de = this.\u0463;
        }
        String string = this.E.get(this.\u03ee);
        for (n = 0; n < string.length() && Character.isWhitespace(string.charAt(n)); ++n) {
        }
        int n2 = this.\u0463 = this.\u0463 == n ? 0 : n;
        if (!bl) {
            this.\u0186();
        }
    }

    private void \u03e9(boolean bl) {
        if (bl && this.\u015f == -1) {
            this.\u015f = this.\u03ee;
            this.\u00de = this.\u0463;
        }
        this.\u0463 = this.E.get(this.\u03ee).length();
        if (!bl) {
            this.\u0186();
        }
    }

    private void \u03fb() {
        if (this.\u03cc()) {
            this.\u03c6();
            this.\u016f();
            return;
        }
        if (this.\u0463 > 0) {
            String string = this.E.get(this.\u03ee);
            if (this.\u0463 >= (0x7663E331 ^ 0x7663E335) && string.substring(this.\u0463 - (0x7663E331 ^ 0x7663E335), this.\u0463).equals("    ")) {
                this.E.set(this.\u03ee, string.substring(0, this.\u0463 - (0x7663E331 ^ 0x7663E335)) + string.substring(this.\u0463));
                this.\u0463 -= 0x7663E331 ^ 0x7663E335;
            } else {
                this.E.set(this.\u03ee, string.substring(0, this.\u0463 - 1) + string.substring(this.\u0463));
                --this.\u0463;
            }
            this.\u04ad = true;
            this.\u016f();
        } else if (this.\u03ee > 0) {
            String string = this.E.get(this.\u03ee - 1);
            String string2 = this.E.get(this.\u03ee);
            --this.\u03ee;
            this.\u0463 = string.length();
            this.E.set(this.\u03ee, string + string2);
            this.E.remove(this.\u03ee + 1);
            this.\u04ad = true;
            this.\u016f();
        }
    }

    private void \u04d7() {
        if (this.\u03cc()) {
            this.\u03c6();
            this.\u016f();
            return;
        }
        String string = this.E.get(this.\u03ee);
        if (this.\u0463 < string.length()) {
            this.E.set(this.\u03ee, string.substring(0, this.\u0463) + string.substring(this.\u0463 + 1));
            this.\u04ad = true;
            this.\u016f();
        } else if (this.\u03ee < this.E.size() - 1) {
            this.E.set(this.\u03ee, string + this.E.get(this.\u03ee + 1));
            this.E.remove(this.\u03ee + 1);
            this.\u04ad = true;
            this.\u016f();
        }
    }

    private void \u00b5() {
        char c;
        if (this.\u03cc()) {
            this.\u03c6();
        }
        String string = this.E.get(this.\u03ee);
        String string2 = string.substring(0, this.\u0463);
        String string3 = string.substring(this.\u0463);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length() && ((c = string.charAt(i)) == (0xE91A6CA3 ^ 0xE91A6C83) || c == (0xE91A6C8A ^ 0xE91A6C83)); ++i) {
            stringBuilder.append(c);
        }
        if (string2.trim().endsWith("{")) {
            stringBuilder.append("    ");
        }
        this.E.set(this.\u03ee, string2);
        ++this.\u03ee;
        this.\u0463 = stringBuilder.length();
        this.E.add(this.\u03ee, String.valueOf(stringBuilder) + string3);
        this.\u04ad = true;
        this.\u016f();
    }

    private void \u01ff(boolean bl) {
        if (this.\u03cc()) {
            int n = Math.min(this.\u015f, this.\u03ee);
            int n2 = Math.max(this.\u015f, this.\u03ee);
            for (int i = n; i <= n2; ++i) {
                String string = this.E.get(i);
                if (!bl) {
                    this.E.set(i, "    " + string);
                    continue;
                }
                if (string.startsWith("    ")) {
                    this.E.set(i, string.substring(0x8030E5C1 ^ 0x8030E5C5));
                    continue;
                }
                if (!string.startsWith(" ")) continue;
                this.E.set(i, string.replaceFirst("^ +", ""));
            }
            this.\u0463 = this.E.get(this.\u03ee).length();
            this.\u04ad = true;
            this.\u016f();
            return;
        }
        if (!bl) {
            this.\u0281("    ");
        }
    }

    private void Y(char c) {
        if (this.\u03cc()) {
            this.\u03c6();
        }
        String string = this.E.get(this.\u03ee);
        String string2 = string.substring(0, this.\u0463) + c + string.substring(this.\u0463);
        this.E.set(this.\u03ee, string2);
        ++this.\u0463;
        this.\u04ad = true;
        this.\u016f();
    }

    private void \u0281(String string) {
        if (string == null || string.isEmpty()) {
            return;
        }
        if (this.\u03cc()) {
            this.\u03c6();
        }
        String[] stringArray = string.replace("\r\n", "\n").replace((char)(0xFACD080E ^ 0xFACD0803), (char)(0xFACD0809 ^ 0xFACD0803)).split("\n", -1);
        String string2 = this.E.get(this.\u03ee);
        String string3 = string2.substring(0, this.\u0463);
        String string4 = string2.substring(this.\u0463);
        if (stringArray.length == 1) {
            this.E.set(this.\u03ee, string3 + stringArray[0] + string4);
            this.\u0463 += stringArray[0].length();
        } else {
            this.E.set(this.\u03ee, string3 + stringArray[0]);
            for (int i = 1; i < stringArray.length - 1; ++i) {
                ++this.\u03ee;
                this.E.add(this.\u03ee, stringArray[i]);
            }
            ++this.\u03ee;
            this.E.add(this.\u03ee, stringArray[stringArray.length - 1] + string4);
            this.\u0463 = stringArray[stringArray.length - 1].length();
        }
        this.\u04ad = true;
        this.\u016f();
    }

    private boolean \u03cc() {
        return this.\u015f != -1 && (this.\u015f != this.\u03ee || this.\u00de != this.\u0463);
    }

    private void \u0186() {
        this.\u015f = -1;
        this.\u00de = -1;
    }

    private void \u03c6() {
        if (!this.\u03cc()) {
            return;
        }
        int n = this.\u015f;
        int n2 = this.\u00de;
        int n3 = this.\u03ee;
        int n4 = this.\u0463;
        if (n > n3 || n == n3 && n2 > n4) {
            int n5 = n;
            n = n3;
            n3 = n5;
            int n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        String string = this.E.get(n);
        String string2 = this.E.get(n3);
        String string3 = string.substring(0, Math.min(n2, string.length())) + string2.substring(Math.min(n4, string2.length()));
        this.E.set(n, string3);
        for (int i = n3; i > n; --i) {
            this.E.remove(i);
        }
        this.\u03ee = n;
        this.\u0463 = Math.min(n2, string3.length());
        this.\u0186();
        this.\u04ad = true;
    }

    private void \u039b() {
        Object object;
        if (!this.\u03cc()) {
            return;
        }
        int n = this.\u015f;
        int n2 = this.\u00de;
        int n3 = this.\u03ee;
        int n4 = this.\u0463;
        if (n > n3 || n == n3 && n2 > n4) {
            int n5 = n;
            n = n3;
            n3 = n5;
            int n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (n == n3) {
            object = this.E.get(n);
            stringBuilder.append((CharSequence)object, Math.min(n2, ((String)object).length()), Math.min(n4, ((String)object).length()));
        } else {
            object = this.E.get(n);
            stringBuilder.append(((String)object).substring(Math.min(n2, ((String)object).length()))).append("\n");
            for (int i = n + 1; i < n3; ++i) {
                stringBuilder.append(this.E.get(i)).append("\n");
            }
            String string = this.E.get(n3);
            stringBuilder.append(string, 0, Math.min(n4, string.length()));
        }
        object = new StringSelection(stringBuilder.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents((Transferable)object, null);
    }

    private void \u038c() {
        try {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String string = (String)transferable.getTransferData(DataFlavor.stringFlavor);
                this.\u0281(string);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void \u016f() {
        this.\u0286.addLast(new ArrayList<String>(this.E));
        if (this.\u0286.size() > (0xEF1B8280 ^ 0xEF1B82A8)) {
            this.\u0286.removeFirst();
        }
        this.\u0409.clear();
    }

    private void \u0204() {
        if (this.\u0286.size() > 1) {
            this.\u0409.addLast(this.\u0286.removeLast());
            List<String> list = this.\u0286.getLast();
            this.E.clear();
            this.E.addAll(list);
            this.\u0221();
            this.\u04ad = true;
        }
    }

    private void \u017d() {
        if (!this.\u0409.isEmpty()) {
            List<String> list = this.\u0409.removeLast();
            this.\u0286.addLast(list);
            this.E.clear();
            this.E.addAll(list);
            this.\u0221();
            this.\u04ad = true;
        }
    }

    private void \u0221() {
        this.\u03ee = Math.max(0, Math.min(this.\u03ee, this.E.size() - 1));
        this.\u0463 = !this.E.isEmpty() ? Math.max(0, Math.min(this.\u0463, this.E.get(this.\u03ee).length())) : 0;
    }

    private void \u0517() {
        this.\u0221();
        int n = this.\u03ba();
        int n2 = this.\u046f();
        int n3 = n - (0xD7E79B55 ^ 0xD7E79B49) - (0xD7E79B5B ^ 0xD7E79B49) - (0xD7E79B4D ^ 0xD7E79B49);
        int n4 = this.fontRendererObj.FONT_HEIGHT + (0xD7E79B4A ^ 0xD7E79B49);
        int n5 = this.\u03ee * n4;
        if ((float)n5 < this.\u00ec) {
            this.\u00ec = n5;
        } else if ((float)(n5 + n4) > this.\u00ec + (float)n3) {
            this.\u00ec = n5 + n4 - n3;
        }
        if (this.\u03ee < this.E.size()) {
            String string = this.E.get(this.\u03ee);
            int n6 = this.fontRendererObj.getStringWidth(string.substring(0, this.\u0463));
            int n7 = n2 - (0xD7E79B55 ^ 0xD7E79B49) - (0xD7E79B4E ^ 0xD7E79B49) - (0xD7E79B51 ^ 0xD7E79B49);
            if ((float)n6 < this.\u03ad) {
                this.\u03ad = n6;
            } else if ((float)n6 > this.\u03ad + (float)n7) {
                this.\u03ad = n6 - n7;
            }
        }
    }

    private void \u0456() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(this.\u027f);
            }
        }
        catch (Exception exception) {
            this.\u0138("Unable to open folder", true);
        }
    }

    static {
        String[] stringArray = new String[0x2F0D3428 ^ 0x2F0D341D];
        stringArray[0] = "abstract";
        stringArray[1] = "assert";
        stringArray[0x2F0D341F ^ 0x2F0D341D] = "boolean";
        stringArray[0x2F0D341E ^ 0x2F0D341D] = "break";
        stringArray[0x2F0D3419 ^ 0x2F0D341D] = "byte";
        stringArray[0x2F0D3418 ^ 0x2F0D341D] = "case";
        stringArray[0x2F0D341B ^ 0x2F0D341D] = "catch";
        stringArray[0x2F0D341A ^ 0x2F0D341D] = "char";
        stringArray[0x2F0D3415 ^ 0x2F0D341D] = "class";
        stringArray[0x2F0D3414 ^ 0x2F0D341D] = "const";
        stringArray[0x2F0D3417 ^ 0x2F0D341D] = "continue";
        stringArray[0x2F0D3416 ^ 0x2F0D341D] = "default";
        stringArray[0x2F0D3411 ^ 0x2F0D341D] = "do";
        stringArray[0x2F0D3410 ^ 0x2F0D341D] = "double";
        stringArray[0x2F0D3413 ^ 0x2F0D341D] = "else";
        stringArray[0x2F0D3412 ^ 0x2F0D341D] = "enum";
        stringArray[0x2F0D340D ^ 0x2F0D341D] = "extends";
        stringArray[0x2F0D340C ^ 0x2F0D341D] = "final";
        stringArray[0x2F0D340F ^ 0x2F0D341D] = "finally";
        stringArray[0x2F0D340E ^ 0x2F0D341D] = "float";
        stringArray[0x2F0D3409 ^ 0x2F0D341D] = "for";
        stringArray[0x2F0D3408 ^ 0x2F0D341D] = "goto";
        stringArray[0x2F0D340B ^ 0x2F0D341D] = "if";
        stringArray[0x2F0D340A ^ 0x2F0D341D] = "implements";
        stringArray[0x2F0D3405 ^ 0x2F0D341D] = "import";
        stringArray[0x2F0D3404 ^ 0x2F0D341D] = "instanceof";
        stringArray[0x2F0D3407 ^ 0x2F0D341D] = "int";
        stringArray[0x2F0D3406 ^ 0x2F0D341D] = "interface";
        stringArray[0x2F0D3401 ^ 0x2F0D341D] = "long";
        stringArray[0x2F0D3400 ^ 0x2F0D341D] = "native";
        stringArray[0x2F0D3403 ^ 0x2F0D341D] = "new";
        stringArray[0x2F0D3402 ^ 0x2F0D341D] = "package";
        stringArray[0x2F0D343D ^ 0x2F0D341D] = "private";
        stringArray[0x2F0D343C ^ 0x2F0D341D] = "protected";
        stringArray[0x2F0D343F ^ 0x2F0D341D] = "public";
        stringArray[0x2F0D343E ^ 0x2F0D341D] = "return";
        stringArray[0x2F0D3439 ^ 0x2F0D341D] = "short";
        stringArray[0x2F0D3438 ^ 0x2F0D341D] = "static";
        stringArray[0x2F0D343B ^ 0x2F0D341D] = "strictfp";
        stringArray[0x2F0D343A ^ 0x2F0D341D] = "super";
        stringArray[0x2F0D3435 ^ 0x2F0D341D] = "switch";
        stringArray[0x2F0D3434 ^ 0x2F0D341D] = "synchronized";
        stringArray[0x2F0D3437 ^ 0x2F0D341D] = "this";
        stringArray[0x2F0D3436 ^ 0x2F0D341D] = "throw";
        stringArray[0x2F0D3431 ^ 0x2F0D341D] = "throws";
        stringArray[0x2F0D3430 ^ 0x2F0D341D] = "transient";
        stringArray[0x2F0D3433 ^ 0x2F0D341D] = "try";
        stringArray[0x2F0D3432 ^ 0x2F0D341D] = "void";
        stringArray[0x2F0D342D ^ 0x2F0D341D] = "volatile";
        stringArray[0x2F0D342C ^ 0x2F0D341D] = "while";
        stringArray[0x2F0D342F ^ 0x2F0D341D] = "true";
        stringArray[0x2F0D342E ^ 0x2F0D341D] = "false";
        stringArray[0x2F0D3429 ^ 0x2F0D341D] = "null";
        \u01d2 = new HashSet<String>(Arrays.asList(stringArray));
    }
}

