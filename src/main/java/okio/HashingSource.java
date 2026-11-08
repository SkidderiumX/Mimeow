/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Segment;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fB\u001f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0007\u00a2\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0011\u0010\u0010\u001a\u00020\u000e8G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "source", "digest", "Ljava/security/MessageDigest;", "(Lokio/Source;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Source;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "messageDigest", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "okio"})
public class HashingSource
extends ForwardingSource
implements Source {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final MessageDigest messageDigest;
    @Nullable
    private final Mac mac;

    public HashingSource(@NotNull Source source2, @NotNull MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(messageDigest, "digest");
        super(source2);
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    public HashingSource(@NotNull Source source2, @NotNull String string) {
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(string, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(string);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
        this(source2, messageDigest);
    }

    public HashingSource(@NotNull Source source2, @NotNull Mac mac) {
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(mac, "mac");
        super(source2);
        this.mac = mac;
        this.messageDigest = null;
    }

    public HashingSource(@NotNull Source source2, @NotNull ByteString byteString, @NotNull String string) {
        Source source3;
        HashingSource hashingSource;
        Mac mac;
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(byteString, "key");
        Intrinsics.checkNotNullParameter(string, "algorithm");
        Source source4 = source2;
        HashingSource hashingSource2 = this;
        try {
            Mac mac2 = mac = Mac.getInstance(string);
            Source source5 = source4;
            HashingSource hashingSource3 = hashingSource2;
            boolean bl = false;
            mac2.init(new SecretKeySpec(byteString.toByteArray(), string));
            Unit unit = Unit.INSTANCE;
            hashingSource = hashingSource3;
            source3 = source5;
        }
        catch (InvalidKeyException invalidKeyException) {
            HashingSource hashingSource4 = hashingSource2;
            Source source6 = source4;
            throw new IllegalArgumentException(invalidKeyException);
        }
        Mac mac3 = mac;
        Intrinsics.checkNotNull(mac3);
        hashingSource(source3, mac3);
    }

    @Override
    public long read(@NotNull Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        long l2 = super.read(buffer, l);
        if (l2 != -1L) {
            long l3;
            long l4 = buffer.size() - l2;
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment;
            for (l3 = buffer.size(); l3 > l4; l3 -= (long)(segment2.limit - segment2.pos)) {
                Intrinsics.checkNotNull(segment2.prev);
            }
            while (l3 < buffer.size()) {
                int n = (int)((long)segment2.pos + l4 - l3);
                if (this.messageDigest != null) {
                    this.messageDigest.update(segment2.data, n, segment2.limit - n);
                } else {
                    Mac mac = this.mac;
                    Intrinsics.checkNotNull(mac);
                    mac.update(segment2.data, n, segment2.limit - n);
                }
                l4 = l3 += (long)(segment2.limit - segment2.pos);
                Intrinsics.checkNotNull(segment2.next);
            }
        }
        return l2;
    }

    @JvmName(name="hash")
    @NotNull
    public final ByteString hash() {
        byte[] byArray;
        if (this.messageDigest != null) {
            byArray = this.messageDigest.digest();
        } else {
            Mac mac = this.mac;
            Intrinsics.checkNotNull(mac);
            byArray = mac.doFinal();
        }
        byte[] byArray2 = byArray;
        Intrinsics.checkNotNull(byArray2);
        return new ByteString(byArray2);
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="hash", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_hash")
    @NotNull
    public final ByteString m96e41da013() {
        return this.hash();
    }

    @JvmStatic
    @NotNull
    public static final HashingSource md5(@NotNull Source source2) {
        return Companion.md5(source2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha1(@NotNull Source source2) {
        return Companion.sha1(source2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha256(@NotNull Source source2) {
        return Companion.sha256(source2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha512(@NotNull Source source2) {
        return Companion.sha512(source2);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha1(@NotNull Source source2, @NotNull ByteString byteString) {
        return Companion.hmacSha1(source2, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha256(@NotNull Source source2, @NotNull ByteString byteString) {
        return Companion.hmacSha256(source2, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha512(@NotNull Source source2, @NotNull ByteString byteString) {
        return Companion.hmacSha512(source2, byteString);
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000f"}, d2={"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", "source", "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSource md5(@NotNull Source source2) {
            Intrinsics.checkNotNullParameter(source2, "source");
            return new HashingSource(source2, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha1(@NotNull Source source2) {
            Intrinsics.checkNotNullParameter(source2, "source");
            return new HashingSource(source2, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha256(@NotNull Source source2) {
            Intrinsics.checkNotNullParameter(source2, "source");
            return new HashingSource(source2, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha512(@NotNull Source source2) {
            Intrinsics.checkNotNullParameter(source2, "source");
            return new HashingSource(source2, "SHA-512");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha1(@NotNull Source source2, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(source2, "source");
            Intrinsics.checkNotNullParameter(byteString, "key");
            return new HashingSource(source2, byteString, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha256(@NotNull Source source2, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(source2, "source");
            Intrinsics.checkNotNullParameter(byteString, "key");
            return new HashingSource(source2, byteString, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha512(@NotNull Source source2, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(source2, "source");
            Intrinsics.checkNotNullParameter(byteString, "key");
            return new HashingSource(source2, byteString, "HmacSHA512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

