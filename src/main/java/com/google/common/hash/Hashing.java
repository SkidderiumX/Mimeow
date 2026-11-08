/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.ChecksumHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.hash.Murmur3_128HashFunction;
import com.google.common.hash.Murmur3_32HashFunction;
import com.google.common.hash.SipHashFunction;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.Nullable;

@Beta
public class Hashing {
    private static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();

    public static HashFunction goodFastHash(int n) {
        int n2 = Hashing.checkPositiveAndMakeMultipleOf32(n);
        if (n2 == 32) {
            return Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32;
        }
        if (n2 <= 128) {
            return Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        }
        int n3 = (n2 + 127) / 128;
        HashFunction[] hashFunctionArray = new HashFunction[n3];
        hashFunctionArray[0] = Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        int n4 = GOOD_FAST_HASH_SEED;
        for (int i = 1; i < n3; ++i) {
            hashFunctionArray[i] = Hashing.murmur3_128(n4 += 1500450271);
        }
        return new ConcatenatedHashFunction(hashFunctionArray);
    }

    public static HashFunction murmur3_32(int n) {
        return new Murmur3_32HashFunction(n);
    }

    public static HashFunction murmur3_32() {
        return Murmur3_32Holder.MURMUR3_32;
    }

    public static HashFunction murmur3_128(int n) {
        return new Murmur3_128HashFunction(n);
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128Holder.MURMUR3_128;
    }

    public static HashFunction sipHash24() {
        return SipHash24Holder.SIP_HASH_24;
    }

    public static HashFunction sipHash24(long l, long l2) {
        return new SipHashFunction(2, 4, l, l2);
    }

    public static HashFunction md5() {
        return Md5Holder.MD5;
    }

    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }

    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }

    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }

    public static HashFunction crc32() {
        return Crc32Holder.CRC_32;
    }

    public static HashFunction adler32() {
        return Adler32Holder.ADLER_32;
    }

    private static HashFunction checksumHashFunction(ChecksumType checksumType, String string) {
        return new ChecksumHashFunction(checksumType, checksumType.bits, string);
    }

    public static int consistentHash(HashCode hashCode, int n) {
        return Hashing.consistentHash(hashCode.padToLong(), n);
    }

    public static int consistentHash(long l, int n) {
        int n2;
        Preconditions.checkArgument(n > 0, "buckets must be positive: %s", n);
        LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(l);
        int n3 = 0;
        while ((n2 = (int)((double)(n3 + 1) / linearCongruentialGenerator.nextDouble())) >= 0 && n2 < n) {
            n3 = n2;
        }
        return n3;
    }

    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        Iterator<HashCode> iterator2 = iterable.iterator();
        Preconditions.checkArgument(iterator2.hasNext(), "Must be at least 1 hash code to combine.");
        int n = iterator2.next().bits();
        byte[] byArray = new byte[n / 8];
        for (HashCode hashCode : iterable) {
            byte[] byArray2 = hashCode.asBytes();
            Preconditions.checkArgument(byArray2.length == byArray.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < byArray2.length; ++i) {
                byArray[i] = (byte)(byArray[i] * 37 ^ byArray2[i]);
            }
        }
        return HashCode.fromBytesNoCopy(byArray);
    }

    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        Iterator<HashCode> iterator2 = iterable.iterator();
        Preconditions.checkArgument(iterator2.hasNext(), "Must be at least 1 hash code to combine.");
        byte[] byArray = new byte[iterator2.next().bits() / 8];
        for (HashCode hashCode : iterable) {
            byte[] byArray2 = hashCode.asBytes();
            Preconditions.checkArgument(byArray2.length == byArray.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < byArray2.length; ++i) {
                int n = i;
                byArray[n] = (byte)(byArray[n] + byArray2[i]);
            }
        }
        return HashCode.fromBytesNoCopy(byArray);
    }

    static int checkPositiveAndMakeMultipleOf32(int n) {
        Preconditions.checkArgument(n > 0, "Number of bits must be positive");
        return n + 31 & 0xFFFFFFE0;
    }

    private Hashing() {
    }

    static /* synthetic */ int access$000() {
        return GOOD_FAST_HASH_SEED;
    }

    static /* synthetic */ HashFunction access$100(ChecksumType checksumType, String string) {
        return Hashing.checksumHashFunction(checksumType, string);
    }

    private static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long l) {
            this.state = l;
        }

        public double nextDouble() {
            this.state = 2862933555777941757L * this.state + 1L;
            return (double)((int)(this.state >>> 33) + 1) / 2.147483648E9;
        }
    }

    @VisibleForTesting
    public static final class ConcatenatedHashFunction
    extends AbstractCompositeHashFunction {
        private final int bits;

        ConcatenatedHashFunction(HashFunction ... hashFunctionArray) {
            super(hashFunctionArray);
            int n = 0;
            for (HashFunction hashFunction : hashFunctionArray) {
                n += hashFunction.bits();
            }
            this.bits = n;
        }

        @Override
        HashCode makeHash(Hasher[] hasherArray) {
            byte[] byArray = new byte[this.bits / 8];
            int n = 0;
            for (Hasher hasher : hasherArray) {
                HashCode hashCode = hasher.hash();
                n += hashCode.writeBytesTo(byArray, n, hashCode.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(byArray);
        }

        @Override
        public int bits() {
            return this.bits;
        }

        public boolean equals(@Nullable Object object) {
            if (object instanceof ConcatenatedHashFunction) {
                ConcatenatedHashFunction concatenatedHashFunction = (ConcatenatedHashFunction)object;
                if (this.bits != concatenatedHashFunction.bits || this.functions.length != concatenatedHashFunction.functions.length) {
                    return false;
                }
                for (int i = 0; i < this.functions.length; ++i) {
                    if (this.functions[i].equals(concatenatedHashFunction.functions[i])) continue;
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            int n = this.bits;
            for (HashFunction hashFunction : this.functions) {
                n ^= hashFunction.hashCode();
            }
            return n;
        }
    }

    public static enum ChecksumType implements Supplier<Checksum>
    {
        CRC_32(32){

            @Override
            public Checksum get() {
                return new CRC32();
            }
        }
        ,
        ADLER_32(32){

            @Override
            public Checksum get() {
                return new Adler32();
            }
        };

        private final int bits;

        private ChecksumType(int n2) {
            this.bits = n2;
        }

        @Override
        public abstract Checksum get();
    }

    private static class Adler32Holder {
        static final HashFunction ADLER_32 = Hashing.access$100(ChecksumType.ADLER_32, "Hashing.adler32()");

        private Adler32Holder() {
        }
    }

    private static class Crc32Holder {
        static final HashFunction CRC_32 = Hashing.access$100(ChecksumType.CRC_32, "Hashing.crc32()");

        private Crc32Holder() {
        }
    }

    private static class Sha512Holder {
        static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");

        private Sha512Holder() {
        }
    }

    private static class Sha256Holder {
        static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");

        private Sha256Holder() {
        }
    }

    private static class Sha1Holder {
        static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");

        private Sha1Holder() {
        }
    }

    private static class Md5Holder {
        static final HashFunction MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");

        private Md5Holder() {
        }
    }

    private static class SipHash24Holder {
        static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);

        private SipHash24Holder() {
        }
    }

    private static class Murmur3_128Holder {
        static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
        static final HashFunction GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(Hashing.access$000());

        private Murmur3_128Holder() {
        }
    }

    private static class Murmur3_32Holder {
        static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
        static final HashFunction GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(Hashing.access$000());

        private Murmur3_32Holder() {
        }
    }
}

