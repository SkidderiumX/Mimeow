package okio;

import kotlin.*;
import kotlin.jvm.internal.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import kotlin.collections.*;
import java.nio.*;
import java.io.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E" }, d2 = { "Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", "offset", "", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio" })
@SourceDebugExtension({ "SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n+ 2 SegmentedByteString.kt\nokio/internal/DSegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n63#2,12:141\n63#2,12:153\n104#2,2:165\n106#2,26:168\n135#2,5:194\n142#2:199\n145#2,3:200\n63#2,8:203\n148#2,8:211\n71#2,4:219\n156#2:223\n63#2,12:224\n160#2:236\n85#2,10:237\n161#2,9:247\n95#2,4:256\n170#2,2:260\n179#2,4:262\n85#2,10:266\n183#2,3:276\n95#2,4:279\n186#2:283\n195#2,8:284\n85#2,10:292\n203#2,3:302\n95#2,4:305\n206#2:309\n215#2,5:310\n85#2,10:315\n220#2,3:325\n95#2,4:328\n223#2:332\n226#2,4:333\n234#2,6:337\n63#2,8:343\n240#2,7:351\n71#2,4:358\n247#2,2:362\n1#3:167\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n*L\n54#1:141,12\n66#1:153,12\n78#1:165,2\n78#1:168,26\n80#1:194,5\n82#1:199\n84#1:200,3\n84#1:203,8\n84#1:211,8\n84#1:219,4\n84#1:223\n90#1:224,12\n96#1:236\n96#1:237,10\n96#1:247,9\n96#1:256,4\n96#1:260,2\n103#1:262,4\n103#1:266,10\n103#1:276,3\n103#1:279,4\n103#1:283\n110#1:284,8\n110#1:292,10\n110#1:302,3\n110#1:305,4\n110#1:309\n117#1:310,5\n117#1:315,10\n117#1:325,3\n117#1:328,4\n117#1:332\n131#1:333,4\n133#1:337,6\n133#1:343,8\n133#1:351,7\n133#1:358,4\n133#1:362,2\n78#1:167\n*E\n" })
public class SegmentedByteString extends ByteString
{
    @NotNull
    private final transient byte[][] segments;
    @NotNull
    private final transient int[] directory;
    
    public SegmentedByteString(@NotNull final byte[][] segments, @NotNull final int[] directory) {
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.segments = segments;
        this.directory = directory;
    }
    
    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }
    
    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }
    
    @NotNull
    @Override
    public String string(@NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.toByteString().string(charset);
    }
    
    @NotNull
    @Override
    public String base64() {
        return this.toByteString().base64();
    }
    
    @NotNull
    @Override
    public String hex() {
        return this.toByteString().hex();
    }
    
    @NotNull
    @Override
    public ByteString toAsciiLowercase() {
        return this.toByteString().toAsciiLowercase();
    }
    
    @NotNull
    @Override
    public ByteString toAsciiUppercase() {
        return this.toByteString().toAsciiUppercase();
    }
    
    @NotNull
    @Override
    public ByteString digest$okio(@NotNull final String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        final MessageDigest instance = MessageDigest.getInstance(algorithm);
        final int length = this.getSegments$okio().length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final int offset = this.getDirectory$okio()[length + i];
            final int n2 = this.getDirectory$okio()[i];
            instance.update(this.getSegments$okio()[i], offset, n2 - n);
            n = n2;
            ++i;
        }
        final byte[] digest = instance.digest();
        Intrinsics.checkNotNull(digest);
        return new ByteString(digest);
    }
    
    @NotNull
    @Override
    public ByteString hmac$okio(@NotNull final String s, @NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(s, "algorithm");
        Intrinsics.checkNotNullParameter(byteString, "key");
        try {
            final Mac instance = Mac.getInstance(s);
            instance.init(new SecretKeySpec(byteString.toByteArray(), s));
            final int length = this.getSegments$okio().length;
            int i = 0;
            int n = 0;
            while (i < length) {
                final int offset = this.getDirectory$okio()[length + i];
                final int n2 = this.getDirectory$okio()[i];
                instance.update(this.getSegments$okio()[i], offset, n2 - n);
                n = n2;
                ++i;
            }
            final byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        }
        catch (final InvalidKeyException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    
    @NotNull
    @Override
    public String base64Url() {
        return this.toByteString().base64Url();
    }
    
    @NotNull
    @Override
    public ByteString substring(final int n, final int n2) {
        final int resolveDefaultParameter = DSegmentedByteString.resolveDefaultParameter(this, n2);
        if (n < 0) {
            throw new IllegalArgumentException(("beginIndex=" + n + " < 0").toString());
        }
        if (resolveDefaultParameter > this.size()) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + this.size() + ')').toString());
        }
        final int b = resolveDefaultParameter - n;
        if (b < 0) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + n).toString());
        }
        ByteString empty;
        if (n == 0 && resolveDefaultParameter == this.size()) {
            empty = this;
        }
        else if (n == resolveDefaultParameter) {
            empty = ByteString.EMPTY;
        }
        else {
            final int segment = okio.internal.DSegmentedByteString.segment(this, n);
            final int segment2 = okio.internal.DSegmentedByteString.segment(this, resolveDefaultParameter - 1);
            final byte[][] array = ArraysKt___ArraysJvmKt.copyOfRange(this.getSegments$okio(), segment, segment2 + 1);
            final int[] array2 = new int[array.length * 2];
            int n3 = 0;
            int n4 = segment;
            if (n4 <= segment2) {
                while (true) {
                    array2[n3] = Math.min(this.getDirectory$okio()[n4] - n, b);
                    array2[n3++ + ((Object[])array).length] = this.getDirectory$okio()[n4 + this.getSegments$okio().length];
                    if (n4 == segment2) {
                        break;
                    }
                    ++n4;
                }
            }
            final int n5 = (segment == 0) ? 0 : this.getDirectory$okio()[segment - 1];
            final int length = array.length;
            array2[length] += n - n5;
            empty = new SegmentedByteString(array, array2);
        }
        return empty;
    }
    
    @Override
    public byte internalGet$okio(final int n) {
        DSegmentedByteString.checkOffsetAndCount(this.getDirectory$okio()[this.getSegments$okio().length - 1], n, 1L);
        final int segment = okio.internal.DSegmentedByteString.segment(this, n);
        return this.getSegments$okio()[segment][n - ((segment == 0) ? 0 : this.getDirectory$okio()[segment - 1]) + this.getDirectory$okio()[segment + this.getSegments$okio().length]];
    }
    
    @Override
    public int getSize$okio() {
        return this.getDirectory$okio()[this.getSegments$okio().length - 1];
    }
    
    @NotNull
    @Override
    public byte[] toByteArray() {
        final byte[] array = new byte[this.size()];
        int n = 0;
        final int length = this.getSegments$okio().length;
        int i = 0;
        int n2 = 0;
        while (i < length) {
            final int n3 = this.getDirectory$okio()[length + i];
            final int n4 = this.getDirectory$okio()[i];
            final byte[] array2 = this.getSegments$okio()[i];
            final int n5 = n3;
            final int n6 = n4 - n2;
            final int n7 = n5;
            ArraysKt___ArraysJvmKt.copyInto(array2, array, n, n7, n7 + n6);
            n += n6;
            n2 = n4;
            ++i;
        }
        return array;
    }
    
    @NotNull
    @Override
    public ByteBuffer asByteBuffer() {
        final ByteBuffer readOnlyBuffer = ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(readOnlyBuffer, "asReadOnlyBuffer(...)");
        return readOnlyBuffer;
    }
    
    @Override
    public void write(@NotNull final OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        final int length = this.getSegments$okio().length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final int off = this.getDirectory$okio()[length + i];
            final int n2 = this.getDirectory$okio()[i];
            outputStream.write(this.getSegments$okio()[i], off, n2 - n);
            n = n2;
            ++i;
        }
    }
    
    @Override
    public void write$okio(@NotNull final Buffer buffer, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int n6;
        for (int a = n + n2, segment = okio.internal.DSegmentedByteString.segment(this, n), i = n; i < a; i += n6, ++segment) {
            final int n3 = (segment == 0) ? 0 : this.getDirectory$okio()[segment - 1];
            final int n4 = this.getDirectory$okio()[segment] - n3;
            final int n5 = this.getDirectory$okio()[this.getSegments$okio().length + segment];
            n6 = Math.min(a, n3 + n4) - i;
            final int n7 = n5 + (i - n3);
            final byte[] array = this.getSegments$okio()[segment];
            final int n8 = n7;
            final int n9 = n6;
            final int n10 = n8;
            final Segment prev = new Segment(array, n10, n10 + n9, true, false);
            if (buffer.head == null) {
                prev.prev = prev;
                prev.next = prev.prev;
                buffer.head = prev.next;
            }
            else {
                final Segment head = buffer.head;
                Intrinsics.checkNotNull(head);
                final Segment prev2 = head.prev;
                Intrinsics.checkNotNull(prev2);
                prev2.push(prev);
            }
        }
        buffer.setSize$okio(buffer.size() + n2);
    }
    
    @Override
    public boolean rangeEquals(final int n, @NotNull final ByteString byteString, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        boolean b;
        if (n < 0 || n > this.size() - n3) {
            b = false;
        }
        else {
            int n4 = n2;
            int n8;
            for (int a = n + n3, segment = okio.internal.DSegmentedByteString.segment(this, n), i = n; i < a; i += n8, ++segment) {
                final int n5 = (segment == 0) ? 0 : this.getDirectory$okio()[segment - 1];
                final int n6 = this.getDirectory$okio()[segment] - n5;
                final int n7 = this.getDirectory$okio()[this.getSegments$okio().length + segment];
                n8 = Math.min(a, n5 + n6) - i;
                final int n9 = n7 + (i - n5);
                final byte[] array = this.getSegments$okio()[segment];
                final int n10 = n9;
                final int n11 = n8;
                if (!byteString.rangeEquals(n4, array, n10, n11)) {
                    b = false;
                    return b;
                }
                n4 += n11;
            }
            b = true;
        }
        return b;
    }
    
    @Override
    public boolean rangeEquals(final int n, @NotNull final byte[] array, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(array, "other");
        boolean b;
        if (n < 0 || n > this.size() - n3 || n2 < 0 || n2 > array.length - n3) {
            b = false;
        }
        else {
            int n4 = n2;
            int n8;
            for (int a = n + n3, segment = okio.internal.DSegmentedByteString.segment(this, n), i = n; i < a; i += n8, ++segment) {
                final int n5 = (segment == 0) ? 0 : this.getDirectory$okio()[segment - 1];
                final int n6 = this.getDirectory$okio()[segment] - n5;
                final int n7 = this.getDirectory$okio()[this.getSegments$okio().length + segment];
                n8 = Math.min(a, n5 + n6) - i;
                final int n9 = n7 + (i - n5);
                final byte[] array2 = this.getSegments$okio()[segment];
                final int n10 = n9;
                final int n11 = n8;
                if (!DSegmentedByteString.arrayRangeEquals(array2, n10, array, n4, n11)) {
                    b = false;
                    return b;
                }
                n4 += n11;
            }
            b = true;
        }
        return b;
    }
    
    @Override
    public void copyInto(final int n, @NotNull final byte[] array, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(array, "target");
        DSegmentedByteString.checkOffsetAndCount(this.size(), n, n3);
        DSegmentedByteString.checkOffsetAndCount(array.length, n2, n3);
        int n4 = n2;
        int n8;
        for (int a = n + n3, segment = okio.internal.DSegmentedByteString.segment(this, n), i = n; i < a; i += n8, ++segment) {
            final int n5 = (segment == 0) ? 0 : this.getDirectory$okio()[segment - 1];
            final int n6 = this.getDirectory$okio()[segment] - n5;
            final int n7 = this.getDirectory$okio()[this.getSegments$okio().length + segment];
            n8 = Math.min(a, n5 + n6) - i;
            final int n9 = n7 + (i - n5);
            final byte[] array2 = this.getSegments$okio()[segment];
            final int n10 = n9;
            final int n11 = n8;
            final int n12 = n10;
            ArraysKt___ArraysJvmKt.copyInto(array2, array, n4, n12, n12 + n11);
            n4 += n11;
        }
    }
    
    @Override
    public int indexOf(@NotNull final byte[] array, final int n) {
        Intrinsics.checkNotNullParameter(array, "other");
        return this.toByteString().indexOf(array, n);
    }
    
    @Override
    public int lastIndexOf(@NotNull final byte[] array, final int n) {
        Intrinsics.checkNotNullParameter(array, "other");
        return this.toByteString().lastIndexOf(array, n);
    }
    
    private final ByteString toByteString() {
        return new ByteString(this.toByteArray());
    }
    
    @NotNull
    @Override
    public byte[] internalArray$okio() {
        return this.toByteArray();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o == this || (o instanceof ByteString && (((ByteString)o).size() == this.size() && this.rangeEquals(0, (ByteString)o, 0, this.size())));
    }
    
    @Override
    public int hashCode() {
        final int hashCode$okio = this.getHashCode$okio();
        int n;
        if (hashCode$okio != 0) {
            n = hashCode$okio;
        }
        else {
            int hashCode$okio2 = 1;
            final int length = this.getSegments$okio().length;
            int i = 0;
            int n2 = 0;
            while (i < length) {
                final int n3 = this.getDirectory$okio()[length + i];
                final int n4 = this.getDirectory$okio()[i];
                final byte[] array = this.getSegments$okio()[i];
                final int n5 = n3;
                final int n6 = n4 - n2;
                final int n7 = n5;
                final byte[] array2 = array;
                for (int j = n7; j < n7 + n6; ++j) {
                    hashCode$okio2 = 31 * hashCode$okio2 + array2[j];
                }
                n2 = n4;
                ++i;
            }
            this.setHashCode$okio(hashCode$okio2);
            n = hashCode$okio2;
        }
        return n;
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.toByteString().toString();
    }
    
    private final Object writeReplace() {
        final ByteString byteString = this.toByteString();
        Intrinsics.checkNotNull(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }
}
