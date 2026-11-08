/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001eH\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0018\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u000206H\u0016J(\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0019H\u0016J \u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0016J\u0010\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068\u00d6\u0002X\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2={"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "emit", "emitCompleteSegments", "flush", "isOpen", "outputStream", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "toString", "", "write", "", "source", "Ljava/nio/ByteBuffer;", "", "offset", "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"})
@SourceDebugExtension(value={"SMAP\nRealBufferedSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 2 RealBufferedSink.kt\nokio/internal/DRealBufferedSink\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n51#1:146\n51#1:152\n51#1:157\n51#1:162\n51#1:167\n51#1:172\n51#1:175\n51#1:176\n51#1:180\n51#1:185\n51#1:188\n51#1:192\n51#1:201\n51#1:210\n51#1:215\n51#1:220\n51#1:225\n51#1:230\n51#1:235\n51#1:240\n51#1:245\n51#1:250\n51#1:255\n51#1:261\n51#1:267\n51#1:279\n34#2:143\n35#2:145\n36#2,2:147\n40#2:149\n41#2:151\n42#2:153\n50#2:154\n51#2:156\n52#2:158\n56#2:159\n57#2:161\n58#2:163\n66#2:164\n67#2:166\n68#2:168\n72#2:169\n73#2:171\n74#2:173\n78#2:177\n79#2:179\n80#2:181\n88#2:182\n89#2:184\n90#2:186\n94#2,3:189\n97#2,5:193\n105#2,3:198\n108#2,5:202\n116#2:207\n117#2:209\n118#2:211\n122#2:212\n123#2:214\n124#2:216\n128#2:217\n129#2:219\n130#2:221\n134#2:222\n135#2:224\n136#2:226\n140#2:227\n141#2:229\n142#2:231\n146#2:232\n147#2:234\n148#2:236\n152#2:237\n153#2:239\n154#2:241\n158#2:242\n159#2:244\n160#2:246\n164#2:247\n165#2:249\n166#2:251\n170#2:252\n171#2:254\n172#2,2:256\n177#2:258\n178#2:260\n179#2,2:262\n184#2:264\n185#2:266\n186#2,4:268\n192#2,7:272\n199#2,16:280\n216#2:296\n218#2:297\n1#3:144\n1#3:150\n1#3:155\n1#3:160\n1#3:165\n1#3:170\n1#3:174\n1#3:178\n1#3:183\n1#3:187\n1#3:208\n1#3:213\n1#3:218\n1#3:223\n1#3:228\n1#3:233\n1#3:238\n1#3:243\n1#3:248\n1#3:253\n1#3:259\n1#3:265\n*S KotlinDebug\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink\n*L\n55#1:146\n56#1:152\n58#1:157\n59#1:162\n61#1:167\n63#1:172\n67#1:175\n78#1:176\n82#1:180\n84#1:185\n88#1:188\n93#1:192\n94#1:201\n95#1:210\n96#1:215\n97#1:220\n98#1:225\n99#1:230\n100#1:235\n101#1:240\n102#1:245\n103#1:250\n104#1:255\n105#1:261\n134#1:267\n138#1:279\n55#1:143\n55#1:145\n55#1:147,2\n56#1:149\n56#1:151\n56#1:153\n58#1:154\n58#1:156\n58#1:158\n59#1:159\n59#1:161\n59#1:163\n61#1:164\n61#1:166\n61#1:168\n63#1:169\n63#1:171\n63#1:173\n82#1:177\n82#1:179\n82#1:181\n84#1:182\n84#1:184\n84#1:186\n93#1:189,3\n93#1:193,5\n94#1:198,3\n94#1:202,5\n95#1:207\n95#1:209\n95#1:211\n96#1:212\n96#1:214\n96#1:216\n97#1:217\n97#1:219\n97#1:221\n98#1:222\n98#1:224\n98#1:226\n99#1:227\n99#1:229\n99#1:231\n100#1:232\n100#1:234\n100#1:236\n101#1:237\n101#1:239\n101#1:241\n102#1:242\n102#1:244\n102#1:246\n103#1:247\n103#1:249\n103#1:251\n104#1:252\n104#1:254\n104#1:256,2\n105#1:258\n105#1:260\n105#1:262,2\n134#1:264\n134#1:266\n134#1:268,4\n138#1:272,7\n138#1:280,16\n139#1:296\n140#1:297\n55#1:144\n56#1:150\n58#1:155\n59#1:160\n61#1:165\n63#1:170\n82#1:178\n84#1:183\n95#1:208\n96#1:213\n97#1:218\n98#1:223\n99#1:228\n100#1:233\n101#1:238\n102#1:243\n103#1:248\n104#1:253\n105#1:259\n134#1:265\n*E\n"})
public class RealBufferedSink
implements BufferedSink {
    @JvmField
    @NotNull
    public final Sink sink;
    @JvmField
    @NotNull
    public final Buffer bufferField;
    @JvmField
    public boolean closed;

    public RealBufferedSink(@NotNull Sink sink2) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        this.sink = sink2;
        this.bufferField = new Buffer();
    }

    @Override
    @NotNull
    public Buffer getBuffer() {
        boolean bl = false;
        return this.bufferField;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override
    public void write(@NotNull Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(buffer, l);
        realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byteString);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byteString, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string2 = "closed";
            throw new IllegalStateException(string2.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeUtf8(string);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string, int n, int n2) {
        Intrinsics.checkNotNullParameter(string, "string");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string2 = "closed";
            throw new IllegalStateException(string2.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeUtf8(string, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeUtf8CodePoint(int n) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeUtf8CodePoint(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeString(@NotNull String string, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(!this.closed)) {
            boolean bl = false;
            String string2 = "closed";
            throw new IllegalStateException(string2.toString());
        }
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        realBufferedSink.bufferField.writeString(string, charset);
        return this.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeString(@NotNull String string, int n, int n2, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(!this.closed)) {
            boolean bl = false;
            String string2 = "closed";
            throw new IllegalStateException(string2.toString());
        }
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        realBufferedSink.bufferField.writeString(string, n, n2, charset);
        return this.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink write(@NotNull byte[] byArray) {
        Intrinsics.checkNotNullParameter(byArray, "source");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byArray);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink write(@NotNull byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(byArray, "source");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byArray, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    public int write(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        if (!(!this.closed)) {
            boolean bl = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        int n = realBufferedSink.bufferField.write(byteBuffer);
        this.emitCompleteSegments();
        return n;
    }

    @Override
    public long writeAll(@NotNull Source source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        long l = 0L;
        while (true) {
            RealBufferedSink realBufferedSink2 = realBufferedSink;
            boolean bl2 = false;
            long l2 = source2.read(realBufferedSink2.bufferField, 8192L);
            if (l2 == -1L) break;
            l += l2;
            realBufferedSink.emitCompleteSegments();
        }
        return l;
    }

    @Override
    @NotNull
    public BufferedSink write(@NotNull Source source2, long l) {
        long l2;
        Intrinsics.checkNotNullParameter(source2, "source");
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        for (long i = l; i > 0L; i -= l2) {
            RealBufferedSink realBufferedSink2 = realBufferedSink;
            boolean bl2 = false;
            l2 = source2.read(realBufferedSink2.bufferField, i);
            if (l2 == -1L) {
                throw new EOFException();
            }
            realBufferedSink.emitCompleteSegments();
        }
        return realBufferedSink;
    }

    @Override
    @NotNull
    public BufferedSink writeByte(int n) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeByte(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeShort(int n) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeShort(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeShortLe(int n) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeShortLe(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeInt(int n) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeInt(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeIntLe(int n) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeIntLe(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeLong(long l) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeLongLe(long l) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeLongLe(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeDecimalLong(long l) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeDecimalLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long l) {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeHexadecimalUnsignedLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @Override
    @NotNull
    public BufferedSink emitCompleteSegments() {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        long l = realBufferedSink2.bufferField.completeSegmentByteCount();
        if (l > 0L) {
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink.sink.write(realBufferedSink2.bufferField, l);
        }
        return realBufferedSink;
    }

    @Override
    @NotNull
    public BufferedSink emit() {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        long l = realBufferedSink2.bufferField.size();
        if (l > 0L) {
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink.sink.write(realBufferedSink2.bufferField, l);
        }
        return realBufferedSink;
    }

    @Override
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream(this){
            final /* synthetic */ RealBufferedSink this$0;
            {
                this.this$0 = realBufferedSink;
            }

            public void write(int n) {
                if (this.this$0.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink realBufferedSink = this.this$0;
                boolean bl = false;
                realBufferedSink.bufferField.writeByte((byte)n);
                this.this$0.emitCompleteSegments();
            }

            public void write(@NotNull byte[] byArray, int n, int n2) {
                Intrinsics.checkNotNullParameter(byArray, "data");
                if (this.this$0.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink realBufferedSink = this.this$0;
                boolean bl = false;
                realBufferedSink.bufferField.write(byArray, n, n2);
                this.this$0.emitCompleteSegments();
            }

            public void flush() {
                if (!this.this$0.closed) {
                    this.this$0.flush();
                }
            }

            public void close() {
                this.this$0.close();
            }

            @NotNull
            public String toString() {
                return this.this$0 + ".outputStream()";
            }
        };
    }

    @Override
    public void flush() {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        if (realBufferedSink2.bufferField.size() > 0L) {
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink.sink.write(realBufferedSink2.bufferField, realBufferedSink2.bufferField.size());
        }
        realBufferedSink.sink.flush();
    }

    @Override
    public boolean isOpen() {
        return !this.closed;
    }

    @Override
    public void close() {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        if (!realBufferedSink.closed) {
            Throwable throwable;
            block7: {
                throwable = null;
                try {
                    RealBufferedSink realBufferedSink2 = realBufferedSink;
                    boolean bl2 = false;
                    if (realBufferedSink2.bufferField.size() > 0L) {
                        realBufferedSink2 = realBufferedSink;
                        bl2 = false;
                        realBufferedSink2 = realBufferedSink;
                        bl2 = false;
                        realBufferedSink.sink.write(realBufferedSink2.bufferField, realBufferedSink2.bufferField.size());
                    }
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                }
                try {
                    realBufferedSink.sink.close();
                }
                catch (Throwable throwable3) {
                    if (throwable != null) break block7;
                    throwable = throwable3;
                }
            }
            realBufferedSink.closed = true;
            Throwable throwable4 = throwable;
            if (throwable4 != null) {
                throw throwable4;
            }
        }
    }

    @Override
    @NotNull
    public Timeout timeout() {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        return realBufferedSink.sink.timeout();
    }

    @NotNull
    public String toString() {
        RealBufferedSink realBufferedSink = this;
        boolean bl = false;
        return "buffer(" + realBufferedSink.sink + ')';
    }
}

