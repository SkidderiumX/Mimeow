/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

public class Utils {
    Utils() {
    }

    static int digit16(byte by) throws DecoderException {
        int n = Character.digit((char)by, 16);
        if (n == -1) {
            throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + by);
        }
        return n;
    }
}

