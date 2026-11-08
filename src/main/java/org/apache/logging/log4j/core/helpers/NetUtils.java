/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

public class NetUtils {
    private static final Logger LOGGER = StatusLogger.getLogger();

    private NetUtils() {
    }

    public static String getLocalHostname() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostName();
        }
        catch (UnknownHostException unknownHostException) {
            try {
                Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
                while (enumeration.hasMoreElements()) {
                    NetworkInterface networkInterface = enumeration.nextElement();
                    Enumeration<InetAddress> enumeration2 = networkInterface.getInetAddresses();
                    while (enumeration2.hasMoreElements()) {
                        String string;
                        InetAddress inetAddress = enumeration2.nextElement();
                        if (inetAddress.isLoopbackAddress() || (string = inetAddress.getHostName()) == null) continue;
                        return string;
                    }
                }
            }
            catch (SocketException socketException) {
                LOGGER.error("Could not determine local host name", (Throwable)unknownHostException);
                return "UNKNOWN_LOCALHOST";
            }
            LOGGER.error("Could not determine local host name", (Throwable)unknownHostException);
            return "UNKNOWN_LOCALHOST";
        }
    }
}

