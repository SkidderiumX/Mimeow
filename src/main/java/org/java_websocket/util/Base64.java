/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.util;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

public class Base64 {
    public static final int NO_OPTIONS = 0;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int DO_BREAK_LINES = 8;
    public static final int URL_SAFE = 16;
    public static final int ORDERED = 32;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte EQUALS_SIGN = 61;
    private static final byte NEW_LINE = 10;
    private static final String PREFERRED_ENCODING = "US-ASCII";
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte[] _STANDARD_ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] _STANDARD_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] _URL_SAFE_ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] _URL_SAFE_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] _ORDERED_ALPHABET = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] _ORDERED_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private static final byte[] getAlphabet(int n) {
        if ((n & 0x10) == 16) {
            return _URL_SAFE_ALPHABET;
        }
        if ((n & 0x20) == 32) {
            return _ORDERED_ALPHABET;
        }
        return _STANDARD_ALPHABET;
    }

    private static final byte[] getDecodabet(int n) {
        if ((n & 0x10) == 16) {
            return _URL_SAFE_DECODABET;
        }
        if ((n & 0x20) == 32) {
            return _ORDERED_DECODABET;
        }
        return _STANDARD_DECODABET;
    }

    private Base64() {
    }

    private static byte[] encode3to4(byte[] byArray, byte[] byArray2, int n, int n2) {
        Base64.encode3to4(byArray2, 0, n, byArray, 0, n2);
        return byArray;
    }

    private static byte[] encode3to4(byte[] byArray, int n, int n2, byte[] byArray2, int n3, int n4) {
        byte[] byArray3 = Base64.getAlphabet(n4);
        int n5 = (n2 > 0 ? byArray[n] << 24 >>> 8 : 0) | (n2 > 1 ? byArray[n + 1] << 24 >>> 16 : 0) | (n2 > 2 ? byArray[n + 2] << 24 >>> 24 : 0);
        switch (n2) {
            case 3: {
                byArray2[n3] = byArray3[n5 >>> 18];
                byArray2[n3 + 1] = byArray3[n5 >>> 12 & 0x3F];
                byArray2[n3 + 2] = byArray3[n5 >>> 6 & 0x3F];
                byArray2[n3 + 3] = byArray3[n5 & 0x3F];
                return byArray2;
            }
            case 2: {
                byArray2[n3] = byArray3[n5 >>> 18];
                byArray2[n3 + 1] = byArray3[n5 >>> 12 & 0x3F];
                byArray2[n3 + 2] = byArray3[n5 >>> 6 & 0x3F];
                byArray2[n3 + 3] = 61;
                return byArray2;
            }
            case 1: {
                byArray2[n3] = byArray3[n5 >>> 18];
                byArray2[n3 + 1] = byArray3[n5 >>> 12 & 0x3F];
                byArray2[n3 + 2] = 61;
                byArray2[n3 + 3] = 61;
                return byArray2;
            }
        }
        return byArray2;
    }

    public static String encodeBytes(byte[] byArray) {
        String string;
        block3: {
            string = null;
            try {
                string = Base64.encodeBytes(byArray, 0, byArray.length, 0);
            }
            catch (IOException iOException) {
                if ($assertionsDisabled) break block3;
                throw new AssertionError((Object)iOException.getMessage());
            }
        }
        assert (string != null);
        return string;
    }

    public static String encodeBytes(byte[] byArray, int n, int n2, int n3) throws IOException {
        byte[] byArray2 = Base64.encodeBytesToBytes(byArray, n, n2, n3);
        try {
            return new String(byArray2, PREFERRED_ENCODING);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(byArray2);
        }
    }

    public static byte[] encodeBytesToBytes(byte[] byArray, int n, int n2, int n3) throws IOException {
        if (byArray == null) {
            throw new IllegalArgumentException("Cannot serialize a null array.");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + n);
        }
        if (n2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + n2);
        }
        if (n + n2 > byArray.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", n, n2, byArray.length));
        }
        if ((n3 & 2) != 0) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            DeflaterOutputStream deflaterOutputStream = null;
            OutputStream outputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                outputStream2 = new OutputStream(byteArrayOutputStream, 1 | n3);
                deflaterOutputStream = new GZIPOutputStream(outputStream2);
                ((GZIPOutputStream)deflaterOutputStream).write(byArray, n, n2);
                deflaterOutputStream.close();
            }
            catch (IOException iOException) {
                throw iOException;
            }
            finally {
                try {
                    if (deflaterOutputStream != null) {
                        deflaterOutputStream.close();
                    }
                }
                catch (Exception exception) {}
                try {
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                }
                catch (Exception exception) {}
                try {
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                }
                catch (Exception exception) {}
            }
            return byteArrayOutputStream.toByteArray();
        }
        boolean bl = (n3 & 8) != 0;
        int n4 = n2 / 3 * 4 + (n2 % 3 > 0 ? 4 : 0);
        if (bl) {
            n4 += n4 / 76;
        }
        byte[] byArray2 = new byte[n4];
        int n5 = 0;
        int n6 = 0;
        int n7 = n2 - 2;
        int n8 = 0;
        while (n5 < n7) {
            Base64.encode3to4(byArray, n5 + n, 3, byArray2, n6, n3);
            if (bl && (n8 += 4) >= 76) {
                byArray2[n6 + 4] = 10;
                ++n6;
                n8 = 0;
            }
            n5 += 3;
            n6 += 4;
        }
        if (n5 < n2) {
            Base64.encode3to4(byArray, n5 + n, n2 - n5, byArray2, n6, n3);
            n6 += 4;
        }
        if (n6 <= byArray2.length - 1) {
            byte[] byArray3 = new byte[n6];
            System.arraycopy(byArray2, 0, byArray3, 0, n6);
            return byArray3;
        }
        return byArray2;
    }

    private static int decode4to3(byte[] byArray, int n, byte[] byArray2, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("Source array was null.");
        }
        if (byArray2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        }
        if (n < 0 || n + 3 >= byArray.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", byArray.length, n));
        }
        if (n2 < 0 || n2 + 2 >= byArray2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", byArray2.length, n2));
        }
        byte[] byArray3 = Base64.getDecodabet(n3);
        if (byArray[n + 2] == 61) {
            int n4 = (byArray3[byArray[n]] & 0xFF) << 18 | (byArray3[byArray[n + 1]] & 0xFF) << 12;
            byArray2[n2] = (byte)(n4 >>> 16);
            return 1;
        }
        if (byArray[n + 3] == 61) {
            int n5 = (byArray3[byArray[n]] & 0xFF) << 18 | (byArray3[byArray[n + 1]] & 0xFF) << 12 | (byArray3[byArray[n + 2]] & 0xFF) << 6;
            byArray2[n2] = (byte)(n5 >>> 16);
            byArray2[n2 + 1] = (byte)(n5 >>> 8);
            return 2;
        }
        int n6 = (byArray3[byArray[n]] & 0xFF) << 18 | (byArray3[byArray[n + 1]] & 0xFF) << 12 | (byArray3[byArray[n + 2]] & 0xFF) << 6 | byArray3[byArray[n + 3]] & 0xFF;
        byArray2[n2] = (byte)(n6 >> 16);
        byArray2[n2 + 1] = (byte)(n6 >> 8);
        byArray2[n2 + 2] = (byte)n6;
        return 3;
    }

    public static class OutputStream
    extends FilterOutputStream {
        private boolean encode;
        private int position;
        private byte[] buffer;
        private int bufferLength;
        private int lineLength;
        private boolean breakLines;
        private byte[] b4;
        private boolean suspendEncoding;
        private int options;
        private byte[] decodabet;

        public OutputStream(java.io.OutputStream outputStream2) {
            this(outputStream2, 1);
        }

        public OutputStream(java.io.OutputStream outputStream2, int n) {
            super(outputStream2);
            this.breakLines = (n & 8) != 0;
            this.encode = (n & 1) != 0;
            this.bufferLength = this.encode ? 3 : 4;
            this.buffer = new byte[this.bufferLength];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
            this.options = n;
            this.decodabet = Base64.getDecodabet(n);
        }

        @Override
        public void write(int n) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(n);
                return;
            }
            if (this.encode) {
                this.buffer[this.position++] = (byte)n;
                if (this.position >= this.bufferLength) {
                    this.out.write(Base64.encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
                    this.lineLength += 4;
                    if (this.breakLines && this.lineLength >= 76) {
                        this.out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            } else if (this.decodabet[n & 0x7F] > -5) {
                this.buffer[this.position++] = (byte)n;
                if (this.position >= this.bufferLength) {
                    int n2 = Base64.decode4to3(this.buffer, 0, this.b4, 0, this.options);
                    this.out.write(this.b4, 0, n2);
                    this.position = 0;
                }
            } else if (this.decodabet[n & 0x7F] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override
        public void write(byte[] byArray, int n, int n2) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(byArray, n, n2);
                return;
            }
            for (int i = 0; i < n2; ++i) {
                this.write(byArray[n + i]);
            }
        }

        public void flushBase64() throws IOException {
            if (this.position > 0) {
                if (this.encode) {
                    this.out.write(Base64.encode3to4(this.b4, this.buffer, this.position, this.options));
                    this.position = 0;
                } else {
                    throw new IOException("Base64 input not properly padded.");
                }
            }
        }

        @Override
        public void close() throws IOException {
            this.flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }
    }
}

