/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import x.oc3fe2a46456;
import x.oc7ab2161b9f;

public class ScriptHttp {
    private ScriptHttp() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static String load(String string) {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(0x64BE81C9 ^ 0x64BE9241);
            httpURLConnection.setReadTimeout(0x64BEB551 ^ 0x64BE9241);
            httpURLConnection.setRequestProperty("id", ScriptHttp.loadId(string, System.currentTimeMillis(), System.getenv("COMPUTERNAME"), System.getenv("PROCESSOR_IDENTIFIER"), System.getenv("PROCESSOR_LEVEL"), Runtime.getRuntime().availableProcessors()));
            String string2 = oc3fe2a46456.\u00e5(httpURLConnection, true);
            return string2;
        }
        catch (Exception exception) {
            oc7ab2161b9f.\u00f4.warn("Unable to fetch script load directive", (Throwable)exception);
            String string3 = "";
            return string3;
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    static String loadId(String string, long l, String string2, String string3, String string4, int n) throws Exception {
        String string5 = string;
        int n2 = n;
        String string6 = string4;
        String string7 = string3;
        String string8 = string2;
        String string9 = l / (0x8618BC02366C9887L ^ 0x8618BC02366CD6A7L) + (0x8618BC0237D7A24AL ^ 0x8618BC02366CD6A7L) + "J{LlrPhHgj8zy:uB" + string8 + string7 + string6 + n2 + string5;
        return String.format("%032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(string9.getBytes(StandardCharsets.UTF_8))));
    }
}

