/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import keystrokesmod.script.ScriptDefaults;
import keystrokesmod.script.model.Entity;
import keystrokesmod.script.model.Image;
import keystrokesmod.script.model.NetworkPlayer;
import org.lwjgl.Sys;
import x.oc2cf3d80e17;
import x.oc321b4679dd;
import x.oc4d46a99983;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc8ccd9c3f55;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.ocf65052963e;

public class Manager
extends oc69da1aa7f5 {
    public static occ2f8dff8d8 enableHttpRequests;
    public static occ2f8dff8d8 enableWebSockets;
    private final oc321b4679dd createScriptName;
    public final String DOCUMENTATION_URL;
    private final String CONFIG_DIR;
    private final String SEPARATOR;
    private final String SEPARATOR_FULL;
    private long lastLoad;

    public Manager() {
        super("Manager", oce4cea752dd.\u057c);
        this.DOCUMENTATION_URL = "https://blowsy.gitbook.io/raven";
        this.CONFIG_DIR = new File(oc8ccd9c3f55.\u0212(oc69da1aa7f5.\u0151 != null ? oc69da1aa7f5.\u0151.mcDataDir : null), "script_settings.txt").getPath();
        this.SEPARATOR = ":";
        this.SEPARATOR_FULL = ": ";
        this.lastLoad = 0L;
        this.\u0105("Creates, edits and loads custom client scripts.");
        this.createScriptName = new oc321b4679dd("Script name", "", "Type a script name...", 0xF303049D ^ 0xF30304BD, this::createScript);
        this.\u028c(this.createScriptName);
        this.\u028c(new occ2f8dff8d8("Create script", this::createScript));
        this.\u028c(new occ2f8dff8d8("Script Editor", this::openEditor));
        this.\u028c(new occ2f8dff8d8("Load scripts", this::loadScriptsNow));
        this.\u028c(new occ2f8dff8d8("Open folder", this::openFolder));
        this.\u028c(new occ2f8dff8d8("View documentation", this::viewDocumentation));
        this.\u028c(new oc4d46a99983("Privacy"));
        enableHttpRequests = new occ2f8dff8d8("Enable http requests", true);
        this.\u028c(enableHttpRequests);
        enableWebSockets = new occ2f8dff8d8("Enable websockets", true);
        this.\u028c(enableWebSockets);
        this.\u022d = false;
        this.\u04fa = true;
        this.retrieveSettings();
    }

    @Override
    public void guiButtonToggled(occ2f8dff8d8 occ2f8dff8d82) {
        this.updateSettingFile();
    }

    private boolean updateSettingFile() {
        return this.set("enable-http-requests", String.valueOf(enableHttpRequests.\u01ed())) & this.set("enable-websockets", String.valueOf(enableWebSockets.\u01ed()));
    }

    public void loadScripts(long l) {
        oc2cf3d80e17.\u013e.loadScripts();
        if (oc2cf3d80e17.\u013e.scripts.isEmpty()) {
            oc7ab2161b9f.\u00fd("&7No scripts found.");
        } else {
            double d = oc7ab2161b9f.\u025c((double)(System.currentTimeMillis() - l) / 1000.0, 1);
            String string = oc7ab2161b9f.\u0251(d);
            String string2 = oc2cf3d80e17.\u013e.scripts.size() == 1 ? "" : "s";
            int n = oc2cf3d80e17.\u013e.scripts.size();
            oc7ab2161b9f.\u00fd("&7Loaded &b" + n + " &7script" + string2 + " in &b" + string + "&7s.");
        }
        Entity.clearCache();
        NetworkPlayer.clearCache();
        Image.clearCache();
        ScriptDefaults.reloadModules();
        if (oc2cf3d80e17.\u0115 != null && oc2cf3d80e17.\u0115.\u01da() != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
    }

    private void ensureConfigFileExists() throws IOException {
        Path path = Paths.get(this.CONFIG_DIR, new String[0]);
        if (Files.notExists(path, new LinkOption[0])) {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            Files.createFile(path, new FileAttribute[0]);
        }
    }

    private boolean set(String string, String string2) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        string = string.replace(":", "");
        String string3 = string + ": " + string2;
        try {
            this.ensureConfigFileExists();
            Path path = new File(this.CONFIG_DIR).toPath();
            ArrayList<String> arrayList = new ArrayList<String>(Files.readAllLines(path));
            boolean bl = false;
            for (int i = 0; i < arrayList.size(); ++i) {
                String string4 = (String)arrayList.get(i);
                if (!string4.startsWith(string + ": ")) continue;
                arrayList.set(i, string3);
                bl = true;
                break;
            }
            if (!bl) {
                arrayList.add(string3);
            }
            Files.write(path, arrayList, new OpenOption[0]);
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    private void retrieveSettings() {
        String string = this.retrieveSetting("enable-http-requests");
        String string2 = this.retrieveSetting("enable-websockets");
        if (string != null) {
            enableHttpRequests.\u03d1(this.parseBoolean(string, true));
        }
        if (string2 != null) {
            enableWebSockets.\u03d1(this.parseBoolean(string2, true));
        }
    }

    private boolean parseBoolean(String string, boolean bl) {
        try {
            return Boolean.parseBoolean(string);
        }
        catch (Exception exception) {
            return bl;
        }
    }

    private String retrieveSetting(String string) {
        try {
            this.ensureConfigFileExists();
            Path path = new File(this.CONFIG_DIR).toPath();
            List<String> list = Files.readAllLines(path);
            for (String string2 : list) {
                if (!string2.startsWith(string + ": ")) continue;
                return string2.substring((string + ": ").length());
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return null;
    }

    private void createScript() {
        this.createScript(this.createScriptName.\u00ca());
        if (!this.createScriptName.\u00ca().isEmpty()) {
            this.createScriptName.z$1bnplyl2p7uqx("");
        }
    }

    public void createScript(String string) {
        if (oc2cf3d80e17.\u013e == null || string == null || string.trim().isEmpty()) {
            return;
        }
        String string2 = oc2cf3d80e17.\u013e.createScript(string.trim());
        if (string2 != null) {
            oc7ab2161b9f.\u00fd("&7Created script: &b" + string2);
        }
    }

    public void loadScriptsNow() {
        if (oc2cf3d80e17.\u013e.compiler == null) {
            oc7ab2161b9f.\u00fd("&cCompiler error, JDK not found");
            return;
        }
        long l = System.currentTimeMillis();
        if (oc7ab2161b9f.\u048a(this.lastLoad, l) > (0x62B4A79E0DCB5050L ^ 0x62B4A79E0DCB558CL)) {
            this.lastLoad = l;
            this.loadScripts(l);
        } else {
            oc7ab2161b9f.\u00fd("&cYou are on cooldown.");
        }
    }

    public void openFolder() {
        try {
            Files.createDirectories(oc2cf3d80e17.\u013e.directory.toPath(), new FileAttribute[0]);
            Desktop.getDesktop().open(oc2cf3d80e17.\u013e.directory);
        }
        catch (Exception exception) {
            oc7ab2161b9f.\u00fd("&7Scripts folder: &b" + oc2cf3d80e17.\u013e.directory.getAbsolutePath());
        }
    }

    public void viewDocumentation() {
        try {
            Desktop.getDesktop().browse(new URI("https://blowsy.gitbook.io/raven"));
        }
        catch (Throwable throwable) {
            Sys.openURL("https://blowsy.gitbook.io/raven");
        }
    }

    public void openEditor() {
        if (oc69da1aa7f5.\u0151.isCallingFromMinecraftThread()) {
            oc69da1aa7f5.\u0151.displayGuiScreen(new ocf65052963e(oc69da1aa7f5.\u0151.currentScreen, null));
        } else {
            oc69da1aa7f5.\u0151.addScheduledTask(() -> oc69da1aa7f5.\u0151.displayGuiScreen(new ocf65052963e(oc69da1aa7f5.\u0151.currentScreen, null)));
        }
    }
}

