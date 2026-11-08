/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.Charsets;

public class ReversedLinesFileReader
implements Closeable {
    private final int blockSize;
    private final Charset encoding;
    private final RandomAccessFile randomAccessFile;
    private final long totalByteLength;
    private final long totalBlockCount;
    private final byte[][] newLineSequences;
    private final int avoidNewlineSplitBufferSize;
    private final int byteDecrement;
    private FilePart currentFilePart;
    private boolean trailingNewlineOfFileSkipped = false;

    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 4096, Charset.defaultCharset().toString());
    }

    public ReversedLinesFileReader(File file, int n, Charset charset) throws IOException {
        this.blockSize = n;
        this.encoding = charset;
        this.randomAccessFile = new RandomAccessFile(file, "r");
        this.totalByteLength = this.randomAccessFile.length();
        int n2 = (int)(this.totalByteLength % (long)n);
        if (n2 > 0) {
            this.totalBlockCount = this.totalByteLength / (long)n + 1L;
        } else {
            this.totalBlockCount = this.totalByteLength / (long)n;
            if (this.totalByteLength > 0L) {
                n2 = n;
            }
        }
        this.currentFilePart = new FilePart(this.totalBlockCount, n2, null);
        Charset charset2 = Charsets.toCharset(charset);
        CharsetEncoder charsetEncoder = charset2.newEncoder();
        float f = charsetEncoder.maxBytesPerChar();
        if (f == 1.0f) {
            this.byteDecrement = 1;
        } else if (charset2 == Charset.forName("UTF-8")) {
            this.byteDecrement = 1;
        } else if (charset2 == Charset.forName("Shift_JIS")) {
            this.byteDecrement = 1;
        } else if (charset2 == Charset.forName("UTF-16BE") || charset2 == Charset.forName("UTF-16LE")) {
            this.byteDecrement = 2;
        } else {
            if (charset2 == Charset.forName("UTF-16")) {
                throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
            }
            throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
        }
        this.newLineSequences = new byte[][]{"\r\n".getBytes(charset), "\n".getBytes(charset), "\r".getBytes(charset)};
        this.avoidNewlineSplitBufferSize = this.newLineSequences[0].length;
    }

    public ReversedLinesFileReader(File file, int n, String string) throws IOException {
        this(file, n, Charsets.toCharset(string));
    }

    public String readLine() throws IOException {
        String string = this.currentFilePart.readLine();
        while (string == null) {
            this.currentFilePart = this.currentFilePart.rollOver();
            if (this.currentFilePart == null) break;
            string = this.currentFilePart.readLine();
        }
        if ("".equals(string) && !this.trailingNewlineOfFileSkipped) {
            this.trailingNewlineOfFileSkipped = true;
            string = this.readLine();
        }
        return string;
    }

    @Override
    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    private class FilePart {
        private final long no;
        private final byte[] data;
        private byte[] leftOver;
        private int currentLastBytePos;

        private FilePart(long l, int n, byte[] byArray) throws IOException {
            this.no = l;
            int n2 = n + (byArray != null ? byArray.length : 0);
            this.data = new byte[n2];
            long l2 = (l - 1L) * (long)ReversedLinesFileReader.this.blockSize;
            if (l > 0L) {
                ReversedLinesFileReader.this.randomAccessFile.seek(l2);
                int n3 = ReversedLinesFileReader.this.randomAccessFile.read(this.data, 0, n);
                if (n3 != n) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (byArray != null) {
                System.arraycopy(byArray, 0, this.data, n, byArray.length);
            }
            this.currentLastBytePos = this.data.length - 1;
            this.leftOver = null;
        }

        private FilePart rollOver() throws IOException {
            if (this.currentLastBytePos > -1) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
            if (this.no > 1L) {
                return new FilePart(this.no - 1L, ReversedLinesFileReader.this.blockSize, this.leftOver);
            }
            if (this.leftOver != null) {
                throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
            }
            return null;
        }

        private String readLine() throws IOException {
            String string = null;
            boolean bl = this.no == 1L;
            int n = this.currentLastBytePos;
            while (n > -1) {
                if (!bl && n < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                    this.createLeftOver();
                    break;
                }
                int n2 = this.getNewLineMatchByteCount(this.data, n);
                if (n2 > 0) {
                    int n3 = n + 1;
                    int n4 = this.currentLastBytePos - n3 + 1;
                    if (n4 < 0) {
                        throw new IllegalStateException("Unexpected negative line length=" + n4);
                    }
                    byte[] byArray = new byte[n4];
                    System.arraycopy(this.data, n3, byArray, 0, n4);
                    string = new String(byArray, ReversedLinesFileReader.this.encoding);
                    this.currentLastBytePos = n - n2;
                    break;
                }
                if ((n -= ReversedLinesFileReader.this.byteDecrement) >= 0) continue;
                this.createLeftOver();
                break;
            }
            if (bl && this.leftOver != null) {
                string = new String(this.leftOver, ReversedLinesFileReader.this.encoding);
                this.leftOver = null;
            }
            return string;
        }

        private void createLeftOver() {
            int n = this.currentLastBytePos + 1;
            if (n > 0) {
                this.leftOver = new byte[n];
                System.arraycopy(this.data, 0, this.leftOver, 0, n);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] byArray, int n) {
            for (byte[] byArray2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean bl = true;
                for (int i = byArray2.length - 1; i >= 0; --i) {
                    int n2 = n + i - (byArray2.length - 1);
                    bl &= n2 >= 0 && byArray[n2] == byArray2[i];
                }
                if (!bl) continue;
                return byArray2.length;
            }
            return 0;
        }
    }
}

