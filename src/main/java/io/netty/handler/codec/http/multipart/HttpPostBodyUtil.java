/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;

public class HttpPostBodyUtil {
    public static final int chunkSize = 8096;
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String NAME = "name";
    public static final String FILENAME = "filename";
    public static final String FORM_DATA = "form-data";
    public static final String ATTACHMENT = "attachment";
    public static final String FILE = "file";
    public static final String MULTIPART_MIXED = "multipart/mixed";
    public static final Charset ISO_8859_1 = CharsetUtil.ISO_8859_1;
    public static final Charset US_ASCII = CharsetUtil.US_ASCII;
    public static final String DEFAULT_BINARY_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain";

    private HttpPostBodyUtil() {
    }

    static int findNonWhitespace(String string, int n) {
        int n2;
        for (n2 = n; n2 < string.length() && Character.isWhitespace(string.charAt(n2)); ++n2) {
        }
        return n2;
    }

    static int findWhitespace(String string, int n) {
        int n2;
        for (n2 = n; n2 < string.length() && !Character.isWhitespace(string.charAt(n2)); ++n2) {
        }
        return n2;
    }

    static int findEndOfString(String string) {
        int n;
        for (n = string.length(); n > 0 && Character.isWhitespace(string.charAt(n - 1)); --n) {
        }
        return n;
    }

    public static class SeekAheadOptimize {
        byte[] bytes;
        int readerIndex;
        int pos;
        int origPos;
        int limit;
        ByteBuf buffer;

        SeekAheadOptimize(ByteBuf byteBuf) throws SeekAheadNoBackArrayException {
            if (!byteBuf.hasArray()) {
                throw new SeekAheadNoBackArrayException();
            }
            this.buffer = byteBuf;
            this.bytes = byteBuf.array();
            this.readerIndex = byteBuf.readerIndex();
            this.origPos = this.pos = byteBuf.arrayOffset() + this.readerIndex;
            this.limit = byteBuf.arrayOffset() + byteBuf.writerIndex();
        }

        void setReadPosition(int n) {
            this.pos -= n;
            this.readerIndex = this.getReadPosition(this.pos);
            this.buffer.readerIndex(this.readerIndex);
        }

        int getReadPosition(int n) {
            return n - this.origPos + this.readerIndex;
        }

        void clear() {
            this.buffer = null;
            this.bytes = null;
            this.limit = 0;
            this.pos = 0;
            this.readerIndex = 0;
        }
    }

    public static class SeekAheadNoBackArrayException
    extends Exception {
        private static final long serialVersionUID = -630418804938699495L;

        SeekAheadNoBackArrayException() {
        }
    }

    public static enum TransferEncodingMechanism {
        BIT7("7bit"),
        BIT8("8bit"),
        BINARY("binary");

        private final String value;

        private TransferEncodingMechanism(String string2) {
            this.value = string2;
        }

        private TransferEncodingMechanism() {
            this.value = this.name();
        }

        public String value() {
            return this.value;
        }

        public String toString() {
            return this.value;
        }
    }
}

