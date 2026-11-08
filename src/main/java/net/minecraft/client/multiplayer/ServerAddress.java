/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import java.net.IDN;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

public class ServerAddress {
    private final String ipAddress;
    private final int serverPort;

    private ServerAddress(String string, int n) {
        this.ipAddress = string;
        this.serverPort = n;
    }

    public String getIP() {
        return IDN.toASCII(this.ipAddress);
    }

    public int getPort() {
        return this.serverPort;
    }

    public static ServerAddress fromString(String string) {
        int n;
        Object object;
        int n2;
        if (string == null) {
            return null;
        }
        String[] stringArray = string.split(":");
        if (string.startsWith("[") && (n2 = string.indexOf("]")) > 0) {
            String string2 = string.substring(1, n2);
            object = string.substring(n2 + 1).trim();
            if (object.startsWith(":")) {
                object = object.substring(1);
                stringArray = new String[]{string2, object};
            } else {
                stringArray = new String[]{string2};
            }
        }
        if (stringArray.length > 2) {
            stringArray = new String[]{string};
        }
        String string3 = stringArray[0];
        int n3 = n = stringArray.length > 1 ? ServerAddress.parseIntWithDefault(stringArray[1]) : 25565;
        if (n == 25565) {
            object = ServerAddress.getServerAddress(string3);
            string3 = object[0];
            n = ServerAddress.parseIntWithDefault(object[1]);
        }
        return new ServerAddress(string3, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String[] getServerAddress(String string) {
        String[] stringArray;
        Context context = null;
        try {
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            Hashtable<String, String> hashtable = new Hashtable<String, String>();
            hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            hashtable.put("java.naming.provider.url", "dns:");
            hashtable.put("com.sun.jndi.dns.timeout.retries", "1");
            context = new InitialDirContext(hashtable);
            Attributes attributes = context.getAttributes("_minecraft._tcp." + string, new String[]{"SRV"});
            String[] stringArray2 = attributes.get("srv").get().toString().split(" ", 4);
            stringArray = new String[]{stringArray2[3], stringArray2[2]};
            if (context == null) return stringArray;
        }
        catch (Throwable throwable) {
            try {
                String[] stringArray3 = new String[]{string, Integer.toString(25565)};
                return stringArray3;
            }
            catch (Throwable throwable2) {
                throw throwable2;
            }
            finally {
                if (context != null) {
                    try {
                        context.close();
                    }
                    catch (Exception exception) {}
                }
            }
        }
        try {
            context.close();
            return stringArray;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return stringArray;
    }

    private static int parseIntWithDefault(String string) {
        try {
            return Integer.parseInt(string.trim());
        }
        catch (Exception exception) {
            return 25565;
        }
    }
}

