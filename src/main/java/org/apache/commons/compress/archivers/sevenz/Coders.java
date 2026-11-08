/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.archivers.sevenz;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.archivers.sevenz.AES256SHA256Decoder;
import org.apache.commons.compress.archivers.sevenz.Coder;
import org.apache.commons.compress.archivers.sevenz.CoderBase;
import org.apache.commons.compress.archivers.sevenz.DeltaDecoder;
import org.apache.commons.compress.archivers.sevenz.LZMA2Decoder;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.tukaani.xz.ARMOptions;
import org.tukaani.xz.ARMThumbOptions;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.IA64Options;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.PowerPCOptions;
import org.tukaani.xz.SPARCOptions;
import org.tukaani.xz.X86Options;

public class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = new HashMap<SevenZMethod, CoderBase>(){
        private static final long serialVersionUID = 1664829131806520867L;
        {
            this.put(SevenZMethod.COPY, new CopyDecoder());
            this.put(SevenZMethod.LZMA, new LZMADecoder());
            this.put(SevenZMethod.LZMA2, new LZMA2Decoder());
            this.put(SevenZMethod.DEFLATE, new DeflateDecoder());
            this.put(SevenZMethod.BZIP2, new BZIP2Decoder());
            this.put(SevenZMethod.AES256SHA256, new AES256SHA256Decoder());
            this.put(SevenZMethod.BCJ_X86_FILTER, new BCJDecoder((FilterOptions)new X86Options()));
            this.put(SevenZMethod.BCJ_PPC_FILTER, new BCJDecoder((FilterOptions)new PowerPCOptions()));
            this.put(SevenZMethod.BCJ_IA64_FILTER, new BCJDecoder((FilterOptions)new IA64Options()));
            this.put(SevenZMethod.BCJ_ARM_FILTER, new BCJDecoder((FilterOptions)new ARMOptions()));
            this.put(SevenZMethod.BCJ_ARM_THUMB_FILTER, new BCJDecoder((FilterOptions)new ARMThumbOptions()));
            this.put(SevenZMethod.BCJ_SPARC_FILTER, new BCJDecoder((FilterOptions)new SPARCOptions()));
            this.put(SevenZMethod.DELTA_FILTER, new DeltaDecoder());
        }
    };

    Coders() {
    }

    static CoderBase findByMethod(SevenZMethod sevenZMethod) {
        return CODER_MAP.get((Object)sevenZMethod);
    }

    static InputStream addDecoder(InputStream inputStream2, Coder coder, byte[] byArray) throws IOException {
        CoderBase coderBase = Coders.findByMethod(SevenZMethod.byId(coder.decompressionMethodId));
        if (coderBase == null) {
            throw new IOException("Unsupported compression method " + Arrays.toString(coder.decompressionMethodId));
        }
        return coderBase.decode(inputStream2, coder, byArray);
    }

    static OutputStream addEncoder(OutputStream outputStream2, SevenZMethod sevenZMethod, Object object) throws IOException {
        CoderBase coderBase = Coders.findByMethod(sevenZMethod);
        if (coderBase == null) {
            throw new IOException("Unsupported compression method " + (Object)((Object)sevenZMethod));
        }
        return coderBase.encode(outputStream2, object);
    }

    private static class DummyByteAddingInputStream
    extends FilterInputStream {
        private boolean addDummyByte = true;

        private DummyByteAddingInputStream(InputStream inputStream2) {
            super(inputStream2);
        }

        public int read() throws IOException {
            int n = super.read();
            if (n == -1 && this.addDummyByte) {
                this.addDummyByte = false;
                n = 0;
            }
            return n;
        }

        public int read(byte[] byArray, int n, int n2) throws IOException {
            int n3 = super.read(byArray, n, n2);
            if (n3 == -1 && this.addDummyByte) {
                this.addDummyByte = false;
                byArray[n] = 0;
                return 1;
            }
            return n3;
        }
    }

    public static class BZIP2Decoder
    extends CoderBase {
        BZIP2Decoder() {
            super(Number.class);
        }

        InputStream decode(InputStream inputStream2, Coder coder, byte[] byArray) throws IOException {
            return new BZip2CompressorInputStream(inputStream2);
        }

        OutputStream encode(OutputStream outputStream2, Object object) throws IOException {
            int n = BZIP2Decoder.numberOptionOrDefault(object, 9);
            return new BZip2CompressorOutputStream(outputStream2, n);
        }
    }

    public static class DeflateDecoder
    extends CoderBase {
        DeflateDecoder() {
            super(Number.class);
        }

        InputStream decode(InputStream inputStream2, Coder coder, byte[] byArray) throws IOException {
            return new InflaterInputStream(new DummyByteAddingInputStream(inputStream2), new Inflater(true));
        }

        OutputStream encode(OutputStream outputStream2, Object object) {
            int n = DeflateDecoder.numberOptionOrDefault(object, 9);
            return new DeflaterOutputStream(outputStream2, new Deflater(n, true));
        }
    }

    public static class BCJDecoder
    extends CoderBase {
        private final FilterOptions opts;

        BCJDecoder(FilterOptions filterOptions) {
            super(new Class[0]);
            this.opts = filterOptions;
        }

        InputStream decode(InputStream inputStream2, Coder coder, byte[] byArray) throws IOException {
            try {
                return this.opts.getInputStream(inputStream2);
            }
            catch (AssertionError assertionError) {
                IOException iOException = new IOException("BCJ filter needs XZ for Java > 1.4 - see http://commons.apache.org/proper/commons-compress/limitations.html#7Z");
                iOException.initCause((Throwable)((Object)assertionError));
                throw iOException;
            }
        }

        OutputStream encode(OutputStream outputStream2, Object object) {
            FinishableOutputStream finishableOutputStream = this.opts.getOutputStream((FinishableOutputStream)new FinishableWrapperOutputStream(outputStream2));
            return new FilterOutputStream((OutputStream)finishableOutputStream){

                public void flush() {
                }
            };
        }
    }

    public static class LZMADecoder
    extends CoderBase {
        LZMADecoder() {
            super(new Class[0]);
        }

        InputStream decode(InputStream inputStream2, Coder coder, byte[] byArray) throws IOException {
            byte by = coder.properties[0];
            long l = coder.properties[1];
            for (int i = 1; i < 4; ++i) {
                l |= ((long)coder.properties[i + 1] & 0xFFL) << 8 * i;
            }
            if (l > 0x7FFFFFF0L) {
                throw new IOException("Dictionary larger than 4GiB maximum size");
            }
            return new LZMAInputStream(inputStream2, -1L, by, (int)l);
        }
    }

    public static class CopyDecoder
    extends CoderBase {
        CopyDecoder() {
            super(new Class[0]);
        }

        InputStream decode(InputStream inputStream2, Coder coder, byte[] byArray) throws IOException {
            return inputStream2;
        }

        OutputStream encode(OutputStream outputStream2, Object object) {
            return outputStream2;
        }
    }
}

