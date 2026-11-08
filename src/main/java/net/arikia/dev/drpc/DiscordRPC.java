/*
 * Decompiled with CFR 0.152.
 */
package net.arikia.dev.drpc;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.OSUtil;

public class DiscordRPC {
    private static final String DLL_VERSION = "3.4.0";
    private static final String LIB_VERSION = "1.6.2";

    public static void discordInitialize(String string, DiscordEventHandlers discordEventHandlers, boolean bl) {
        DLL.INSTANCE.Discord_Initialize(string, discordEventHandlers, bl ? 1 : 0, null);
    }

    public static void discordRegister(String string, String string2) {
        DLL.INSTANCE.Discord_Register(string, string2);
    }

    public static void discordInitialize(String string, DiscordEventHandlers discordEventHandlers, boolean bl, String string2) {
        DLL.INSTANCE.Discord_Initialize(string, discordEventHandlers, bl ? 1 : 0, string2);
    }

    public static void discordRegisterSteam(String string, String string2) {
        DLL.INSTANCE.Discord_RegisterSteamGame(string, string2);
    }

    public static void discordUpdateEventHandlers(DiscordEventHandlers discordEventHandlers) {
        DLL.INSTANCE.Discord_UpdateHandlers(discordEventHandlers);
    }

    public static void discordShutdown() {
        DLL.INSTANCE.Discord_Shutdown();
    }

    public static void discordRunCallbacks() {
        DLL.INSTANCE.Discord_RunCallbacks();
    }

    public static void discordUpdatePresence(DiscordRichPresence discordRichPresence) {
        DLL.INSTANCE.Discord_UpdatePresence(discordRichPresence);
    }

    public static void discordClearPresence() {
        DLL.INSTANCE.Discord_ClearPresence();
    }

    public static void discordRespond(String string, DiscordReply discordReply) {
        DLL.INSTANCE.Discord_Respond(string, discordReply.reply);
    }

    private static void loadDLL() {
        String string;
        String string2;
        String string3 = System.mapLibraryName("discord-rpc");
        OSUtil oSUtil = new OSUtil();
        if (oSUtil.isMac()) {
            File file = new File(System.getProperty("user.home") + File.separator + "Library" + File.separator + "Application Support" + File.separator);
            string2 = "darwin";
            string = file + File.separator + "discord-rpc" + File.separator + string3;
        } else if (oSUtil.isWindows()) {
            File file = new File(System.getenv("TEMP"));
            boolean bl = System.getProperty("sun.arch.data.model").equals("64");
            string2 = bl ? "win-x64" : "win-x86";
            string = file + File.separator + "discord-rpc" + File.separator + string3;
        } else {
            File file = new File(System.getProperty("user.home"), ".discord-rpc");
            string2 = "linux";
            string = file + File.separator + string3;
        }
        String string4 = "/" + string2 + "/" + string3;
        File file = new File(string);
        try (InputStream inputStream2 = DiscordRPC.class.getResourceAsStream(string4);
             FileOutputStream fileOutputStream = DiscordRPC.openOutputStream(file);){
            DiscordRPC.copyFile(inputStream2, fileOutputStream);
            file.deleteOnExit();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        System.load(file.getAbsolutePath());
    }

    private static void copyFile(InputStream inputStream2, OutputStream outputStream2) throws IOException {
        int n;
        byte[] byArray = new byte[4096];
        while (-1 != (n = inputStream2.read(byArray))) {
            outputStream2.write(byArray, 0, n);
        }
    }

    private static FileOutputStream openOutputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File file2 = file.getParentFile();
            if (file2 != null && !file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Directory '" + file2 + "' could not be created");
            }
        }
        return new FileOutputStream(file);
    }

    static {
        DiscordRPC.loadDLL();
    }

    private static interface DLL
    extends Library {
        public static final DLL INSTANCE = (DLL)Native.loadLibrary("discord-rpc", DLL.class);

        public void Discord_Initialize(String var1, DiscordEventHandlers var2, int var3, String var4);

        public void Discord_Register(String var1, String var2);

        public void Discord_RegisterSteamGame(String var1, String var2);

        public void Discord_UpdateHandlers(DiscordEventHandlers var1);

        public void Discord_Shutdown();

        public void Discord_RunCallbacks();

        public void Discord_UpdatePresence(DiscordRichPresence var1);

        public void Discord_ClearPresence();

        public void Discord_Respond(String var1, int var2);
    }

    public static enum DiscordReply {
        NO(0),
        YES(1),
        IGNORE(2);

        public final int reply;

        private DiscordReply(int n2) {
            this.reply = n2;
        }
    }
}

