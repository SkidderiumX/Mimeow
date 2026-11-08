/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.auth;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.auth.NTLMEngine;
import org.apache.http.impl.auth.NTLMEngineException;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
public class NTLMEngineImpl
implements NTLMEngine {
    protected static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    protected static final int FLAG_REQUEST_TARGET = 4;
    protected static final int FLAG_REQUEST_SIGN = 16;
    protected static final int FLAG_REQUEST_SEAL = 32;
    protected static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    protected static final int FLAG_REQUEST_NTLMv1 = 512;
    protected static final int FLAG_DOMAIN_PRESENT = 4096;
    protected static final int FLAG_WORKSTATION_PRESENT = 8192;
    protected static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    protected static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
    protected static final int FLAG_REQUEST_VERSION = 0x2000000;
    protected static final int FLAG_TARGETINFO_PRESENT = 0x800000;
    protected static final int FLAG_REQUEST_128BIT_KEY_EXCH = 0x20000000;
    protected static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 0x40000000;
    protected static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
    private static final SecureRandom RND_GEN;
    static final String DEFAULT_CHARSET = "ASCII";
    private String credentialCharset = "ASCII";
    private static final byte[] SIGNATURE;

    NTLMEngineImpl() {
    }

    final String getResponseFor(String string, String string2, String string3, String string4, String string5) throws NTLMEngineException {
        String string6;
        if (string == null || string.trim().equals("")) {
            string6 = this.getType1Message(string4, string5);
        } else {
            Type2Message type2Message = new Type2Message(string);
            string6 = this.getType3Message(string2, string3, string4, string5, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
        }
        return string6;
    }

    String getType1Message(String string, String string2) throws NTLMEngineException {
        return new Type1Message(string2, string).getResponse();
    }

    String getType3Message(String string, String string2, String string3, String string4, byte[] byArray, int n, String string5, byte[] byArray2) throws NTLMEngineException {
        return new Type3Message(string4, string3, string, string2, byArray, n, string5, byArray2).getResponse();
    }

    String getCredentialCharset() {
        return this.credentialCharset;
    }

    void setCredentialCharset(String string) {
        this.credentialCharset = string;
    }

    private static String stripDotSuffix(String string) {
        int n = 0;
        int n2 = -2063868308;
        block7: while (true) {
            switch (n2) {
                default: {
                    throw null;
                }
                case -1826166506: {
                    return string.substring(0, n);
                }
                case -2030746251: {
                    return string;
                }
                case -1550026099: {
                    return null;
                }
                case -53538522: {
                    n = string.indexOf(".");
                    if (n != -1) {
                        n2 = -1826166506;
                        continue block7;
                    }
                    n2 = -2030746251;
                    continue block7;
                }
                case -2063868308: 
            }
            if (string == null) {
                n2 = -1550026099;
                continue;
            }
            n2 = -53538522;
        }
    }

    private static String convertHost(String string) {
        return NTLMEngineImpl.stripDotSuffix(string);
    }

    private static String convertDomain(String string) {
        return NTLMEngineImpl.stripDotSuffix(string);
    }

    private static int readULong(byte[] byArray, int n) throws NTLMEngineException {
        int n2 = -1464907786;
        block5: while (true) {
            switch (n2) {
                default: {
                    throw null;
                }
                case 231785814: {
                    return byArray[n] & 0xFF | (byArray[n + 1] & 0xFF) << 8 | (byArray[n + 2] & 0xFF) << 16 | (byArray[n + 3] & 0xFF) << 24;
                }
                case -1464907786: {
                    if (byArray.length < n + 4) {
                        n2 = -2045521285;
                        continue block5;
                    }
                    n2 = 231785814;
                    continue block5;
                }
                case -2045521285: 
            }
            break;
        }
        throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
    }

    private static int readUShort(byte[] byArray, int n) throws NTLMEngineException {
        int n2 = -1257112709;
        block5: while (true) {
            switch (n2) {
                default: {
                    throw null;
                }
                case -872978021: {
                    throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
                }
                case -1257112709: {
                    if (byArray.length < n + 2) {
                        n2 = -872978021;
                        continue block5;
                    }
                    n2 = -340239305;
                    continue block5;
                }
                case -340239305: 
            }
            break;
        }
        return byArray[n] & 0xFF | (byArray[n + 1] & 0xFF) << 8;
    }

    private static byte[] readSecurityBuffer(byte[] byArray, int n) throws NTLMEngineException {
        int n2 = 0;
        int n3 = 0;
        byte[] byArray2 = null;
        int n4 = 1620029538;
        block5: while (true) {
            switch (n4) {
                default: {
                    throw null;
                }
                case 716522986: {
                    throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
                }
                case 1620029538: {
                    n2 = NTLMEngineImpl.readUShort(byArray, n);
                    n3 = NTLMEngineImpl.readULong(byArray, n + 4);
                    if (byArray.length < n3 + n2) {
                        n4 = 716522986;
                        continue block5;
                    }
                    n4 = -758802405;
                    continue block5;
                }
                case -758802405: 
            }
            break;
        }
        byArray2 = new byte[n2];
        System.arraycopy(byArray, n3, byArray2, 0, n2);
        return byArray2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] makeRandomChallenge() throws NTLMEngineException {
        if (RND_GEN == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] byArray = new byte[8];
        SecureRandom secureRandom = RND_GEN;
        synchronized (secureRandom) {
            RND_GEN.nextBytes(byArray);
        }
        return byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] makeSecondaryKey() throws NTLMEngineException {
        if (RND_GEN == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] byArray = new byte[16];
        SecureRandom secureRandom = RND_GEN;
        synchronized (secureRandom) {
            RND_GEN.nextBytes(byArray);
        }
        return byArray;
    }

    static byte[] hmacMD5(byte[] byArray, byte[] byArray2) throws NTLMEngineException {
        HMACMD5 hMACMD5 = new HMACMD5(byArray2);
        hMACMD5.update(byArray);
        return hMACMD5.getOutput();
    }

    static byte[] RC4(byte[] byArray, byte[] byArray2) throws NTLMEngineException {
        try {
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(byArray2, "RC4"));
            return cipher.doFinal(byArray);
        }
        catch (Exception exception) {
            throw new NTLMEngineException(exception.getMessage(), exception);
        }
    }

    static byte[] ntlm2SessionResponse(byte[] byArray, byte[] byArray2, byte[] byArray3) throws NTLMEngineException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(byArray2);
            messageDigest.update(byArray3);
            byte[] byArray4 = messageDigest.digest();
            byte[] byArray5 = new byte[8];
            System.arraycopy(byArray4, 0, byArray5, 0, 8);
            return NTLMEngineImpl.lmResponse(byArray, byArray5);
        }
        catch (Exception exception) {
            if (exception instanceof NTLMEngineException) {
                throw (NTLMEngineException)exception;
            }
            throw new NTLMEngineException(exception.getMessage(), exception);
        }
    }

    private static byte[] lmHash(String string) throws NTLMEngineException {
        try {
            byte[] byArray = string.toUpperCase(Locale.US).getBytes("US-ASCII");
            int n = Math.min(byArray.length, 14);
            byte[] byArray2 = new byte[14];
            System.arraycopy(byArray, 0, byArray2, 0, n);
            Key key = NTLMEngineImpl.createDESKey(byArray2, 0);
            Key key2 = NTLMEngineImpl.createDESKey(byArray2, 7);
            byte[] byArray3 = "KGS!@#$%".getBytes("US-ASCII");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, key);
            byte[] byArray4 = cipher.doFinal(byArray3);
            cipher.init(1, key2);
            byte[] byArray5 = cipher.doFinal(byArray3);
            byte[] byArray6 = new byte[16];
            System.arraycopy(byArray4, 0, byArray6, 0, 8);
            System.arraycopy(byArray5, 0, byArray6, 8, 8);
            return byArray6;
        }
        catch (Exception exception) {
            throw new NTLMEngineException(exception.getMessage(), exception);
        }
    }

    private static byte[] ntlmHash(String string) throws NTLMEngineException {
        try {
            byte[] byArray = string.getBytes("UnicodeLittleUnmarked");
            MD4 mD4 = new MD4();
            mD4.update(byArray);
            return mD4.getOutput();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new NTLMEngineException("Unicode not supported: " + unsupportedEncodingException.getMessage(), unsupportedEncodingException);
        }
    }

    private static byte[] lmv2Hash(String string, String string2, byte[] byArray) throws NTLMEngineException {
        try {
            HMACMD5 hMACMD5 = new HMACMD5(byArray);
            hMACMD5.update(string2.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked"));
            if (string != null) {
                hMACMD5.update(string.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked"));
            }
            return hMACMD5.getOutput();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new NTLMEngineException("Unicode not supported! " + unsupportedEncodingException.getMessage(), unsupportedEncodingException);
        }
    }

    private static byte[] ntlmv2Hash(String string, String string2, byte[] byArray) throws NTLMEngineException {
        try {
            HMACMD5 hMACMD5 = new HMACMD5(byArray);
            hMACMD5.update(string2.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked"));
            if (string != null) {
                hMACMD5.update(string.getBytes("UnicodeLittleUnmarked"));
            }
            return hMACMD5.getOutput();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new NTLMEngineException("Unicode not supported! " + unsupportedEncodingException.getMessage(), unsupportedEncodingException);
        }
    }

    private static byte[] lmResponse(byte[] byArray, byte[] byArray2) throws NTLMEngineException {
        try {
            byte[] byArray3 = new byte[21];
            System.arraycopy(byArray, 0, byArray3, 0, 16);
            Key key = NTLMEngineImpl.createDESKey(byArray3, 0);
            Key key2 = NTLMEngineImpl.createDESKey(byArray3, 7);
            Key key3 = NTLMEngineImpl.createDESKey(byArray3, 14);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, key);
            byte[] byArray4 = cipher.doFinal(byArray2);
            cipher.init(1, key2);
            byte[] byArray5 = cipher.doFinal(byArray2);
            cipher.init(1, key3);
            byte[] byArray6 = cipher.doFinal(byArray2);
            byte[] byArray7 = new byte[24];
            System.arraycopy(byArray4, 0, byArray7, 0, 8);
            System.arraycopy(byArray5, 0, byArray7, 8, 8);
            System.arraycopy(byArray6, 0, byArray7, 16, 8);
            return byArray7;
        }
        catch (Exception exception) {
            throw new NTLMEngineException(exception.getMessage(), exception);
        }
    }

    private static byte[] lmv2Response(byte[] byArray, byte[] byArray2, byte[] byArray3) throws NTLMEngineException {
        HMACMD5 hMACMD5 = new HMACMD5(byArray);
        hMACMD5.update(byArray2);
        hMACMD5.update(byArray3);
        byte[] byArray4 = hMACMD5.getOutput();
        byte[] byArray5 = new byte[byArray4.length + byArray3.length];
        System.arraycopy(byArray4, 0, byArray5, 0, byArray4.length);
        System.arraycopy(byArray3, 0, byArray5, byArray4.length, byArray3.length);
        return byArray5;
    }

    private static byte[] createBlob(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        byte[] byArray4 = new byte[]{1, 1, 0, 0};
        byte[] byArray5 = new byte[]{0, 0, 0, 0};
        byte[] byArray6 = new byte[]{0, 0, 0, 0};
        byte[] byArray7 = new byte[]{0, 0, 0, 0};
        byte[] byArray8 = new byte[byArray4.length + byArray5.length + byArray3.length + 8 + byArray6.length + byArray2.length + byArray7.length];
        int n = 0;
        System.arraycopy(byArray4, 0, byArray8, n, byArray4.length);
        System.arraycopy(byArray5, 0, byArray8, n += byArray4.length, byArray5.length);
        System.arraycopy(byArray3, 0, byArray8, n += byArray5.length, byArray3.length);
        System.arraycopy(byArray, 0, byArray8, n += byArray3.length, 8);
        System.arraycopy(byArray6, 0, byArray8, n += 8, byArray6.length);
        System.arraycopy(byArray2, 0, byArray8, n += byArray6.length, byArray2.length);
        System.arraycopy(byArray7, 0, byArray8, n += byArray2.length, byArray7.length);
        n += byArray7.length;
        return byArray8;
    }

    private static Key createDESKey(byte[] byArray, int n) {
        byte[] byArray2 = new byte[7];
        System.arraycopy(byArray, n, byArray2, 0, 7);
        byte[] byArray3 = new byte[]{byArray2[0], (byte)(byArray2[0] << 7 | (byArray2[1] & 0xFF) >>> 1), (byte)(byArray2[1] << 6 | (byArray2[2] & 0xFF) >>> 2), (byte)(byArray2[2] << 5 | (byArray2[3] & 0xFF) >>> 3), (byte)(byArray2[3] << 4 | (byArray2[4] & 0xFF) >>> 4), (byte)(byArray2[4] << 3 | (byArray2[5] & 0xFF) >>> 5), (byte)(byArray2[5] << 2 | (byArray2[6] & 0xFF) >>> 6), (byte)(byArray2[6] << 1)};
        NTLMEngineImpl.oddParity(byArray3);
        return new SecretKeySpec(byArray3, "DES");
    }

    private static void oddParity(byte[] byArray) {
        for (int i = 0; i < byArray.length; ++i) {
            boolean bl;
            byte by = byArray[i];
            boolean bl2 = bl = ((by >>> 7 ^ by >>> 6 ^ by >>> 5 ^ by >>> 4 ^ by >>> 3 ^ by >>> 2 ^ by >>> 1) & 1) == 0;
            if (bl) {
                int n = i;
                byArray[n] = (byte)(byArray[n] | 1);
                continue;
            }
            int n = i;
            byArray[n] = (byte)(byArray[n] & 0xFFFFFFFE);
        }
    }

    static void writeULong(byte[] byArray, int n, int n2) {
        byArray[n2] = (byte)(n & 0xFF);
        byArray[n2 + 1] = (byte)(n >> 8 & 0xFF);
        byArray[n2 + 2] = (byte)(n >> 16 & 0xFF);
        byArray[n2 + 3] = (byte)(n >> 24 & 0xFF);
    }

    static int F(int n, int n2, int n3) {
        return n & n2 | ~n & n3;
    }

    static int G(int n, int n2, int n3) {
        return n & n2 | n & n3 | n2 & n3;
    }

    static int H(int n, int n2, int n3) {
        return n ^ n2 ^ n3;
    }

    static int rotintlft(int n, int n2) {
        return n << n2 | n >>> 32 - n2;
    }

    public String generateType1Msg(String string, String string2) throws NTLMEngineException {
        return this.getType1Message(string2, string);
    }

    public String generateType3Msg(String string, String string2, String string3, String string4, String string5) throws NTLMEngineException {
        Type2Message type2Message = new Type2Message(string5);
        return this.getType3Message(string, string2, string4, string3, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }

    static {
        Object object = null;
        try {
            object = SecureRandom.getInstance("SHA1PRNG");
        }
        catch (Exception exception) {
            // empty catch block
        }
        RND_GEN = object;
        object = EncodingUtils.getBytes("NTLMSSP", DEFAULT_CHARSET);
        SIGNATURE = new byte[((Object)object).length + 1];
        System.arraycopy(object, 0, SIGNATURE, 0, ((Object)object).length);
        NTLMEngineImpl.SIGNATURE[((Object)object).length] = 0;
    }

    public static class HMACMD5 {
        protected byte[] ipad;
        protected byte[] opad;
        protected MessageDigest md5;

        HMACMD5(byte[] byArray) throws NTLMEngineException {
            int n;
            byte[] byArray2 = byArray;
            try {
                this.md5 = MessageDigest.getInstance("MD5");
            }
            catch (Exception exception) {
                throw new NTLMEngineException("Error getting md5 message digest implementation: " + exception.getMessage(), exception);
            }
            this.ipad = new byte[64];
            this.opad = new byte[64];
            int n2 = byArray2.length;
            if (n2 > 64) {
                this.md5.update(byArray2);
                byArray2 = this.md5.digest();
                n2 = byArray2.length;
            }
            for (n = 0; n < n2; ++n) {
                this.ipad[n] = (byte)(byArray2[n] ^ 0x36);
                this.opad[n] = (byte)(byArray2[n] ^ 0x5C);
            }
            while (n < 64) {
                this.ipad[n] = 54;
                this.opad[n] = 92;
                ++n;
            }
            this.md5.reset();
            this.md5.update(this.ipad);
        }

        byte[] getOutput() {
            byte[] byArray = this.md5.digest();
            this.md5.update(this.opad);
            return this.md5.digest(byArray);
        }

        void update(byte[] byArray) {
            this.md5.update(byArray);
        }

        void update(byte[] byArray, int n, int n2) {
            this.md5.update(byArray, n, n2);
        }
    }

    public static class MD4 {
        protected int A = 1732584193;
        protected int B = -271733879;
        protected int C = -1732584194;
        protected int D = 271733878;
        protected long count = 0L;
        protected byte[] dataBuffer = new byte[64];

        MD4() {
        }

        void update(byte[] byArray) {
            int n;
            int n2 = (int)(this.count & 0x3FL);
            int n3 = 0;
            while (byArray.length - n3 + n2 >= this.dataBuffer.length) {
                n = this.dataBuffer.length - n2;
                System.arraycopy(byArray, n3, this.dataBuffer, n2, n);
                this.count += (long)n;
                n2 = 0;
                n3 += n;
                this.processBuffer();
            }
            if (n3 < byArray.length) {
                n = byArray.length - n3;
                System.arraycopy(byArray, n3, this.dataBuffer, n2, n);
                this.count += (long)n;
                n2 += n;
            }
        }

        byte[] getOutput() {
            int n = (int)(this.count & 0x3FL);
            int n2 = n < 56 ? 56 - n : 120 - n;
            byte[] byArray = new byte[n2 + 8];
            byArray[0] = -128;
            for (int i = 0; i < 8; ++i) {
                byArray[n2 + i] = (byte)(this.count * 8L >>> 8 * i);
            }
            this.update(byArray);
            byte[] byArray2 = new byte[16];
            NTLMEngineImpl.writeULong(byArray2, this.A, 0);
            NTLMEngineImpl.writeULong(byArray2, this.B, 4);
            NTLMEngineImpl.writeULong(byArray2, this.C, 8);
            NTLMEngineImpl.writeULong(byArray2, this.D, 12);
            return byArray2;
        }

        protected void processBuffer() {
            int n;
            int[] nArray = new int[16];
            for (n = 0; n < 16; ++n) {
                nArray[n] = (this.dataBuffer[n * 4] & 0xFF) + ((this.dataBuffer[n * 4 + 1] & 0xFF) << 8) + ((this.dataBuffer[n * 4 + 2] & 0xFF) << 16) + ((this.dataBuffer[n * 4 + 3] & 0xFF) << 24);
            }
            n = this.A;
            int n2 = this.B;
            int n3 = this.C;
            int n4 = this.D;
            this.round1(nArray);
            this.round2(nArray);
            this.round3(nArray);
            this.A += n;
            this.B += n2;
            this.C += n3;
            this.D += n4;
        }

        protected void round1(int[] nArray) {
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + nArray[0], 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + nArray[1], 7);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + nArray[2], 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + nArray[3], 19);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + nArray[4], 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + nArray[5], 7);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + nArray[6], 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + nArray[7], 19);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + nArray[8], 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + nArray[9], 7);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + nArray[10], 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + nArray[11], 19);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + nArray[12], 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + nArray[13], 7);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + nArray[14], 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + nArray[15], 19);
        }

        protected void round2(int[] nArray) {
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + nArray[0] + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + nArray[4] + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + nArray[8] + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + nArray[12] + 1518500249, 13);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + nArray[1] + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + nArray[5] + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + nArray[9] + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + nArray[13] + 1518500249, 13);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + nArray[2] + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + nArray[6] + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + nArray[10] + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + nArray[14] + 1518500249, 13);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + nArray[3] + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + nArray[7] + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + nArray[11] + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + nArray[15] + 1518500249, 13);
        }

        protected void round3(int[] nArray) {
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + nArray[0] + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + nArray[8] + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + nArray[4] + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + nArray[12] + 1859775393, 15);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + nArray[2] + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + nArray[10] + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + nArray[6] + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + nArray[14] + 1859775393, 15);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + nArray[1] + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + nArray[9] + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + nArray[5] + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + nArray[13] + 1859775393, 15);
            this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + nArray[3] + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + nArray[11] + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + nArray[7] + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + nArray[15] + 1859775393, 15);
        }
    }

    public static class Type3Message
    extends NTLMMessage {
        protected int type2Flags;
        protected byte[] domainBytes;
        protected byte[] hostBytes;
        protected byte[] userBytes;
        protected byte[] lmResp;
        protected byte[] ntResp;
        protected byte[] sessionKey;

        Type3Message(String string, String string2, String string3, String string4, byte[] byArray, int n, String string5, byte[] byArray2) throws NTLMEngineException {
            byte[] byArray3;
            this.type2Flags = n;
            String string6 = NTLMEngineImpl.convertHost(string2);
            String string7 = NTLMEngineImpl.convertDomain(string);
            CipherGen cipherGen = new CipherGen(string7, string3, string4, byArray, string5, byArray2);
            try {
                if ((n & 0x800000) != 0 && byArray2 != null && string5 != null) {
                    this.ntResp = cipherGen.getNTLMv2Response();
                    this.lmResp = cipherGen.getLMv2Response();
                    byArray3 = (n & 0x80) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getNTLMv2UserSessionKey();
                } else if ((n & 0x80000) != 0) {
                    this.ntResp = cipherGen.getNTLM2SessionResponse();
                    this.lmResp = cipherGen.getLM2SessionResponse();
                    byArray3 = (n & 0x80) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getNTLM2SessionResponseUserSessionKey();
                } else {
                    this.ntResp = cipherGen.getNTLMResponse();
                    this.lmResp = cipherGen.getLMResponse();
                    byArray3 = (n & 0x80) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getNTLMUserSessionKey();
                }
            }
            catch (NTLMEngineException nTLMEngineException) {
                this.ntResp = new byte[0];
                this.lmResp = cipherGen.getLMResponse();
                byArray3 = (n & 0x80) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getLMUserSessionKey();
            }
            this.sessionKey = (byte[])((n & 0x10) != 0 ? ((n & 0x40000000) != 0 ? NTLMEngineImpl.RC4(cipherGen.getSecondaryKey(), byArray3) : byArray3) : null);
            try {
                this.hostBytes = string6 != null ? string6.getBytes("UnicodeLittleUnmarked") : null;
                this.domainBytes = string7 != null ? string7.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked") : null;
                this.userBytes = string3.getBytes("UnicodeLittleUnmarked");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new NTLMEngineException("Unicode not supported: " + unsupportedEncodingException.getMessage(), unsupportedEncodingException);
            }
        }

        String getResponse() {
            int n = this.ntResp.length;
            int n2 = this.lmResp.length;
            int n3 = this.domainBytes != null ? this.domainBytes.length : 0;
            int n4 = this.hostBytes != null ? this.hostBytes.length : 0;
            int n5 = this.userBytes.length;
            int n6 = this.sessionKey != null ? this.sessionKey.length : 0;
            int n7 = 72;
            int n8 = 72 + n2;
            int n9 = n8 + n;
            int n10 = n9 + n3;
            int n11 = n10 + n5;
            int n12 = n11 + n4;
            int n13 = n12 + n6;
            this.prepareResponse(n13, 3);
            this.addUShort(n2);
            this.addUShort(n2);
            this.addULong(72);
            this.addUShort(n);
            this.addUShort(n);
            this.addULong(n8);
            this.addUShort(n3);
            this.addUShort(n3);
            this.addULong(n9);
            this.addUShort(n5);
            this.addUShort(n5);
            this.addULong(n10);
            this.addUShort(n4);
            this.addUShort(n4);
            this.addULong(n11);
            this.addUShort(n6);
            this.addUShort(n6);
            this.addULong(n12);
            this.addULong(this.type2Flags & 0x80 | this.type2Flags & 0x200 | this.type2Flags & 0x80000 | 0x2000000 | this.type2Flags & 0x8000 | this.type2Flags & 0x20 | this.type2Flags & 0x10 | this.type2Flags & 0x20000000 | this.type2Flags & Integer.MIN_VALUE | this.type2Flags & 0x40000000 | this.type2Flags & 0x800000 | this.type2Flags & 1 | this.type2Flags & 4);
            this.addUShort(261);
            this.addULong(2600);
            this.addUShort(3840);
            this.addBytes(this.lmResp);
            this.addBytes(this.ntResp);
            this.addBytes(this.domainBytes);
            this.addBytes(this.userBytes);
            this.addBytes(this.hostBytes);
            if (this.sessionKey != null) {
                this.addBytes(this.sessionKey);
            }
            return super.getResponse();
        }
    }

    public static class Type2Message
    extends NTLMMessage {
        protected byte[] challenge = new byte[8];
        protected String target;
        protected byte[] targetInfo;
        protected int flags;

        Type2Message(String string) throws NTLMEngineException {
            super(string, 2);
            byte[] byArray;
            this.readBytes(this.challenge, 24);
            this.flags = this.readULong(20);
            if ((this.flags & 1) == 0) {
                throw new NTLMEngineException("NTLM type 2 message has flags that make no sense: " + Integer.toString(this.flags));
            }
            this.target = null;
            if (this.getMessageLength() >= 20 && (byArray = this.readSecurityBuffer(12)).length != 0) {
                try {
                    this.target = new String(byArray, "UnicodeLittleUnmarked");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    throw new NTLMEngineException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
                }
            }
            this.targetInfo = null;
            if (this.getMessageLength() >= 48 && (byArray = this.readSecurityBuffer(40)).length != 0) {
                this.targetInfo = byArray;
            }
        }

        byte[] getChallenge() {
            return this.challenge;
        }

        String getTarget() {
            return this.target;
        }

        byte[] getTargetInfo() {
            return this.targetInfo;
        }

        int getFlags() {
            return this.flags;
        }
    }

    public static class Type1Message
    extends NTLMMessage {
        protected byte[] hostBytes;
        protected byte[] domainBytes;

        Type1Message(String string, String string2) throws NTLMEngineException {
            try {
                String string3 = NTLMEngineImpl.convertHost(string2);
                String string4 = NTLMEngineImpl.convertDomain(string);
                this.hostBytes = string3 != null ? string3.getBytes(NTLMEngineImpl.DEFAULT_CHARSET) : null;
                this.domainBytes = string4 != null ? string4.toUpperCase(Locale.US).getBytes(NTLMEngineImpl.DEFAULT_CHARSET) : null;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new NTLMEngineException("Unicode unsupported: " + unsupportedEncodingException.getMessage(), unsupportedEncodingException);
            }
        }

        String getResponse() {
            int n = 40;
            this.prepareResponse(40, 1);
            this.addULong(-1576500735);
            this.addUShort(0);
            this.addUShort(0);
            this.addULong(40);
            this.addUShort(0);
            this.addUShort(0);
            this.addULong(40);
            this.addUShort(261);
            this.addULong(2600);
            this.addUShort(3840);
            return super.getResponse();
        }
    }

    public static class NTLMMessage {
        private byte[] messageContents = null;
        private int currentOutputPosition = 0;

        NTLMMessage() {
        }

        NTLMMessage(String string, int n) throws NTLMEngineException {
            this.messageContents = Base64.decodeBase64(EncodingUtils.getBytes(string, NTLMEngineImpl.DEFAULT_CHARSET));
            if (this.messageContents.length < SIGNATURE.length) {
                throw new NTLMEngineException("NTLM message decoding error - packet too short");
            }
            for (int i = 0; i < SIGNATURE.length; ++i) {
                if (this.messageContents[i] == SIGNATURE[i]) continue;
                throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
            }
            int n2 = this.readULong(SIGNATURE.length);
            if (n2 != n) {
                throw new NTLMEngineException("NTLM type " + Integer.toString(n) + " message expected - instead got type " + Integer.toString(n2));
            }
            this.currentOutputPosition = this.messageContents.length;
        }

        protected int getPreambleLength() {
            return SIGNATURE.length + 4;
        }

        protected int getMessageLength() {
            return this.currentOutputPosition;
        }

        protected byte readByte(int n) throws NTLMEngineException {
            if (this.messageContents.length < n + 1) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            return this.messageContents[n];
        }

        protected void readBytes(byte[] byArray, int n) throws NTLMEngineException {
            if (this.messageContents.length < n + byArray.length) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            System.arraycopy(this.messageContents, n, byArray, 0, byArray.length);
        }

        protected int readUShort(int n) throws NTLMEngineException {
            return NTLMEngineImpl.readUShort(this.messageContents, n);
        }

        protected int readULong(int n) throws NTLMEngineException {
            return NTLMEngineImpl.readULong(this.messageContents, n);
        }

        protected byte[] readSecurityBuffer(int n) throws NTLMEngineException {
            return NTLMEngineImpl.readSecurityBuffer(this.messageContents, n);
        }

        protected void prepareResponse(int n, int n2) {
            this.messageContents = new byte[n];
            this.currentOutputPosition = 0;
            this.addBytes(SIGNATURE);
            this.addULong(n2);
        }

        protected void addByte(byte by) {
            this.messageContents[this.currentOutputPosition] = by;
            ++this.currentOutputPosition;
        }

        protected void addBytes(byte[] byArray) {
            if (byArray == null) {
                return;
            }
            byte[] byArray2 = byArray;
            int n = byArray2.length;
            for (int i = 0; i < n; ++i) {
                byte by;
                this.messageContents[this.currentOutputPosition] = by = byArray2[i];
                ++this.currentOutputPosition;
            }
        }

        protected void addUShort(int n) {
            this.addByte((byte)(n & 0xFF));
            this.addByte((byte)(n >> 8 & 0xFF));
        }

        protected void addULong(int n) {
            this.addByte((byte)(n & 0xFF));
            this.addByte((byte)(n >> 8 & 0xFF));
            this.addByte((byte)(n >> 16 & 0xFF));
            this.addByte((byte)(n >> 24 & 0xFF));
        }

        String getResponse() {
            byte[] byArray;
            if (this.messageContents.length > this.currentOutputPosition) {
                byte[] byArray2 = new byte[this.currentOutputPosition];
                System.arraycopy(this.messageContents, 0, byArray2, 0, this.currentOutputPosition);
                byArray = byArray2;
            } else {
                byArray = this.messageContents;
            }
            return EncodingUtils.getAsciiString(Base64.encodeBase64(byArray));
        }
    }

    protected static class CipherGen {
        protected final String domain;
        protected final String user;
        protected final String password;
        protected final byte[] challenge;
        protected final String target;
        protected final byte[] targetInformation;
        protected byte[] clientChallenge;
        protected byte[] clientChallenge2;
        protected byte[] secondaryKey;
        protected byte[] timestamp;
        protected byte[] lmHash = null;
        protected byte[] lmResponse = null;
        protected byte[] ntlmHash = null;
        protected byte[] ntlmResponse = null;
        protected byte[] ntlmv2Hash = null;
        protected byte[] lmv2Hash = null;
        protected byte[] lmv2Response = null;
        protected byte[] ntlmv2Blob = null;
        protected byte[] ntlmv2Response = null;
        protected byte[] ntlm2SessionResponse = null;
        protected byte[] lm2SessionResponse = null;
        protected byte[] lmUserSessionKey = null;
        protected byte[] ntlmUserSessionKey = null;
        protected byte[] ntlmv2UserSessionKey = null;
        protected byte[] ntlm2SessionResponseUserSessionKey = null;
        protected byte[] lanManagerSessionKey = null;

        public CipherGen(String string, String string2, String string3, byte[] byArray, String string4, byte[] byArray2, byte[] byArray3, byte[] byArray4, byte[] byArray5, byte[] byArray6) {
            this.domain = string;
            this.target = string4;
            this.user = string2;
            this.password = string3;
            this.challenge = byArray;
            this.targetInformation = byArray2;
            this.clientChallenge = byArray3;
            this.clientChallenge2 = byArray4;
            this.secondaryKey = byArray5;
            this.timestamp = byArray6;
        }

        public CipherGen(String string, String string2, String string3, byte[] byArray, String string4, byte[] byArray2) {
            this(string, string2, string3, byArray, string4, byArray2, null, null, null, null);
        }

        public byte[] getClientChallenge() throws NTLMEngineException {
            if (this.clientChallenge == null) {
                this.clientChallenge = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge;
        }

        public byte[] getClientChallenge2() throws NTLMEngineException {
            if (this.clientChallenge2 == null) {
                this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge2;
        }

        public byte[] getSecondaryKey() throws NTLMEngineException {
            if (this.secondaryKey == null) {
                this.secondaryKey = NTLMEngineImpl.makeSecondaryKey();
            }
            return this.secondaryKey;
        }

        public byte[] getLMHash() throws NTLMEngineException {
            if (this.lmHash == null) {
                this.lmHash = NTLMEngineImpl.lmHash(this.password);
            }
            return this.lmHash;
        }

        public byte[] getLMResponse() throws NTLMEngineException {
            if (this.lmResponse == null) {
                this.lmResponse = NTLMEngineImpl.lmResponse(this.getLMHash(), this.challenge);
            }
            return this.lmResponse;
        }

        public byte[] getNTLMHash() throws NTLMEngineException {
            if (this.ntlmHash == null) {
                this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
            }
            return this.ntlmHash;
        }

        public byte[] getNTLMResponse() throws NTLMEngineException {
            if (this.ntlmResponse == null) {
                this.ntlmResponse = NTLMEngineImpl.lmResponse(this.getNTLMHash(), this.challenge);
            }
            return this.ntlmResponse;
        }

        public byte[] getLMv2Hash() throws NTLMEngineException {
            if (this.lmv2Hash == null) {
                this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, this.getNTLMHash());
            }
            return this.lmv2Hash;
        }

        public byte[] getNTLMv2Hash() throws NTLMEngineException {
            if (this.ntlmv2Hash == null) {
                this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, this.getNTLMHash());
            }
            return this.ntlmv2Hash;
        }

        public byte[] getTimestamp() {
            if (this.timestamp == null) {
                long l = System.currentTimeMillis();
                l += 11644473600000L;
                l *= 10000L;
                this.timestamp = new byte[8];
                for (int i = 0; i < 8; ++i) {
                    this.timestamp[i] = (byte)l;
                    l >>>= 8;
                }
            }
            return this.timestamp;
        }

        public byte[] getNTLMv2Blob() throws NTLMEngineException {
            if (this.ntlmv2Blob == null) {
                this.ntlmv2Blob = NTLMEngineImpl.createBlob(this.getClientChallenge2(), this.targetInformation, this.getTimestamp());
            }
            return this.ntlmv2Blob;
        }

        public byte[] getNTLMv2Response() throws NTLMEngineException {
            if (this.ntlmv2Response == null) {
                this.ntlmv2Response = NTLMEngineImpl.lmv2Response(this.getNTLMv2Hash(), this.challenge, this.getNTLMv2Blob());
            }
            return this.ntlmv2Response;
        }

        public byte[] getLMv2Response() throws NTLMEngineException {
            if (this.lmv2Response == null) {
                this.lmv2Response = NTLMEngineImpl.lmv2Response(this.getLMv2Hash(), this.challenge, this.getClientChallenge());
            }
            return this.lmv2Response;
        }

        public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
            if (this.ntlm2SessionResponse == null) {
                this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(this.getNTLMHash(), this.challenge, this.getClientChallenge());
            }
            return this.ntlm2SessionResponse;
        }

        public byte[] getLM2SessionResponse() throws NTLMEngineException {
            if (this.lm2SessionResponse == null) {
                byte[] byArray = this.getClientChallenge();
                this.lm2SessionResponse = new byte[24];
                System.arraycopy(byArray, 0, this.lm2SessionResponse, 0, byArray.length);
                Arrays.fill(this.lm2SessionResponse, byArray.length, this.lm2SessionResponse.length, (byte)0);
            }
            return this.lm2SessionResponse;
        }

        public byte[] getLMUserSessionKey() throws NTLMEngineException {
            if (this.lmUserSessionKey == null) {
                byte[] byArray = this.getLMHash();
                this.lmUserSessionKey = new byte[16];
                System.arraycopy(byArray, 0, this.lmUserSessionKey, 0, 8);
                Arrays.fill(this.lmUserSessionKey, 8, 16, (byte)0);
            }
            return this.lmUserSessionKey;
        }

        public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
            if (this.ntlmUserSessionKey == null) {
                byte[] byArray = this.getNTLMHash();
                MD4 mD4 = new MD4();
                mD4.update(byArray);
                this.ntlmUserSessionKey = mD4.getOutput();
            }
            return this.ntlmUserSessionKey;
        }

        public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
            if (this.ntlmv2UserSessionKey == null) {
                byte[] byArray = this.getNTLMv2Hash();
                byte[] byArray2 = new byte[16];
                System.arraycopy(this.getNTLMv2Response(), 0, byArray2, 0, 16);
                this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(byArray2, byArray);
            }
            return this.ntlmv2UserSessionKey;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
            if (this.ntlm2SessionResponseUserSessionKey == null) {
                byte[] byArray = this.getNTLMUserSessionKey();
                byte[] byArray2 = this.getLM2SessionResponse();
                byte[] byArray3 = new byte[this.challenge.length + byArray2.length];
                System.arraycopy(this.challenge, 0, byArray3, 0, this.challenge.length);
                System.arraycopy(byArray2, 0, byArray3, this.challenge.length, byArray2.length);
                this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(byArray3, byArray);
            }
            return this.ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getLanManagerSessionKey() throws NTLMEngineException {
            if (this.lanManagerSessionKey == null) {
                byte[] byArray = this.getLMHash();
                byte[] byArray2 = this.getLMResponse();
                try {
                    byte[] byArray3 = new byte[14];
                    System.arraycopy(byArray, 0, byArray3, 0, 8);
                    Arrays.fill(byArray3, 8, byArray3.length, (byte)-67);
                    Key key = NTLMEngineImpl.createDESKey(byArray3, 0);
                    Key key2 = NTLMEngineImpl.createDESKey(byArray3, 7);
                    byte[] byArray4 = new byte[8];
                    System.arraycopy(byArray2, 0, byArray4, 0, byArray4.length);
                    Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher.init(1, key);
                    byte[] byArray5 = cipher.doFinal(byArray4);
                    cipher = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher.init(1, key2);
                    byte[] byArray6 = cipher.doFinal(byArray4);
                    this.lanManagerSessionKey = new byte[16];
                    System.arraycopy(byArray5, 0, this.lanManagerSessionKey, 0, byArray5.length);
                    System.arraycopy(byArray6, 0, this.lanManagerSessionKey, byArray5.length, byArray6.length);
                }
                catch (Exception exception) {
                    throw new NTLMEngineException(exception.getMessage(), exception);
                }
            }
            return this.lanManagerSessionKey;
        }
    }
}

