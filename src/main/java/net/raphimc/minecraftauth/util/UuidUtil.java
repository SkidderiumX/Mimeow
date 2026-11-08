/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util;

import java.util.UUID;

public class UuidUtil {
    private static final String UNDASHED_UUID_REGEX = "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)";
    private static final String DASHED_UUID_REGEX = "(\\p{XDigit}{8})-(\\p{XDigit}{4})-(\\p{XDigit}{4})-(\\p{XDigit}{4})-(\\p{XDigit}+)";

    public static UUID fromUndashedString(String string) {
        if (string != null) {
            return UUID.fromString(string.replaceFirst(UNDASHED_UUID_REGEX, "$1-$2-$3-$4-$5"));
        }
        return null;
    }

    public static String toUndashedString(UUID uUID) {
        if (uUID != null) {
            return uUID.toString().replace("-", "");
        }
        return null;
    }

    public static boolean isUndashedUuid(String string) {
        return string.matches(UNDASHED_UUID_REGEX);
    }

    public static boolean isDashedUuid(String string) {
        return string.matches(DASHED_UUID_REGEX);
    }
}

