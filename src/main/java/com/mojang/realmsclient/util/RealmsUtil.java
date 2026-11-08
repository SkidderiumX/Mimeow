/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import net.minecraft.realms.Realms;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsUtil {
    public static LoadingCache<String, String> nameCache = CacheBuilder.newBuilder().expireAfterWrite(60L, TimeUnit.MINUTES).build(new CacheLoader<String, String>(){

        @Override
        public String load(String string) throws Exception {
            String string2 = Realms.uuidToName(string);
            if (string2 == null) {
                throw new Exception("Couldn't get username");
            }
            return string2;
        }
    });
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MINUTES = 60;
    private static final int HOURS = 3600;
    private static final int DAYS = 86400;

    public static void browseTo(String string) {
        try {
            URI uRI = new URI(string);
            Class<?> clazz = Class.forName("java.awt.Desktop");
            Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod("browse", URI.class).invoke(object, uRI);
        }
        catch (Throwable throwable) {
            LOGGER.error("Couldn't open link");
        }
    }

    public static String convertToAgePresentation(Long l) {
        if (l < 0L) {
            return "right now";
        }
        long l2 = l / 1000L;
        if (l2 < 60L) {
            return (l2 == 1L ? "1 second" : l2 + " seconds") + " ago";
        }
        if (l2 < 3600L) {
            long l3 = l2 / 60L;
            return (l3 == 1L ? "1 minute" : l3 + " minutes") + " ago";
        }
        if (l2 < 86400L) {
            long l4 = l2 / 3600L;
            return (l4 == 1L ? "1 hour" : l4 + " hours") + " ago";
        }
        long l5 = l2 / 86400L;
        return (l5 == 1L ? "1 day" : l5 + " days") + " ago";
    }
}

