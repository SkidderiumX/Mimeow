/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RealmsVersion {
    private static String version;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String getVersion() {
        if (version != null) {
            return version;
        }
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream2 = RealmsVersion.class.getResourceAsStream("/version");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
            version = bufferedReader.readLine();
            bufferedReader.close();
            String string = version;
            return string;
        }
        catch (Exception exception) {
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {}
            }
        }
        return null;
    }
}

