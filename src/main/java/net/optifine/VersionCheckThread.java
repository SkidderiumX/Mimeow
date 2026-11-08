/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.src.Config;

public class VersionCheckThread
extends Thread {
    public VersionCheckThread() {
        super("VersionCheck");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            Config.dbg("Checking for new version");
            URL uRL = new URL("http://optifine.net/version/1.8.9/HD_U.txt");
            httpURLConnection = (HttpURLConnection)uRL.openConnection();
            if (Config.getGameSettings().snooperEnabled) {
                httpURLConnection.setRequestProperty("OF-MC-Version", "1.8.9");
                httpURLConnection.setRequestProperty("OF-MC-Brand", ClientBrandRetriever.getClientModName());
                httpURLConnection.setRequestProperty("OF-Edition", "HD_U");
                httpURLConnection.setRequestProperty("OF-Release", "M6_pre2");
                httpURLConnection.setRequestProperty("OF-Java-Version", System.getProperty("java.version"));
                httpURLConnection.setRequestProperty("OF-CpuCount", "" + Config.getAvailableProcessors());
                httpURLConnection.setRequestProperty("OF-OpenGL-Version", Config.openGlVersion);
                httpURLConnection.setRequestProperty("OF-OpenGL-Vendor", Config.openGlVendor);
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.connect();
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String string = Config.readInputStream(inputStream2);
                inputStream2.close();
                String[] stringArray = Config.tokenize(string, "\n\r");
                if (stringArray.length >= 1) {
                    String string2 = stringArray[0].trim();
                    Config.dbg("Version found: " + string2);
                    if (Config.compareRelease(string2, "M6_pre2") <= 0) {
                        return;
                    }
                    Config.setNewRelease(string2);
                    return;
                }
            }
            finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        catch (Exception exception) {
            Config.dbg(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
}

