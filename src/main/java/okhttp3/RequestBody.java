/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2={"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"})
public abstract class RequestBody {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    public abstract MediaType contentType();

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract void writeTo(@NotNull BufferedSink var1) throws IOException;

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    @JvmStatic
    @JvmName(name="create")
    @NotNull
    public static final RequestBody create(@NotNull String string, @Nullable MediaType mediaType) {
        return Companion.create(string, mediaType);
    }

    @JvmStatic
    @JvmName(name="create")
    @NotNull
    public static final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name="create")
    @NotNull
    public static final RequestBody create(@NotNull byte[] byArray, @Nullable MediaType mediaType, int n, int n2) {
        return Companion.create(byArray, mediaType, n, n2);
    }

    @JvmStatic
    @JvmName(name="create")
    @NotNull
    public static final RequestBody create(@NotNull File file, @Nullable MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    @JvmStatic
    @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull String string) {
        return Companion.create(mediaType, string);
    }

    @JvmStatic
    @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @JvmStatic
    @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
    @JvmOverloads
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] byArray, int n, int n2) {
        return Companion.create(mediaType, byArray, n, n2);
    }

    @JvmStatic
    @kotlin.Deprecated(message="Moved to extension function. Put the 'file' argument first to fix Java", replaceWith=@ReplaceWith(expression="file.asRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.asRequestBody"}), level=DeprecationLevel.WARNING)
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
        return Companion.create(mediaType, file);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name="create")
    @NotNull
    public static final RequestBody create(@NotNull byte[] byArray, @Nullable MediaType mediaType, int n) {
        return Companion.create(byArray, mediaType, n);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name="create")
    @NotNull
    public static final RequestBody create(@NotNull byte[] byArray, @Nullable MediaType mediaType) {
        return Companion.create(byArray, mediaType);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name="create")
    @NotNull
    public static final RequestBody create(@NotNull byte[] byArray) {
        return Companion.create(byArray);
    }

    @JvmStatic
    @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
    @JvmOverloads
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] byArray, int n) {
        return Companion.create(mediaType, byArray, n);
    }

    @JvmStatic
    @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
    @JvmOverloads
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] byArray) {
        return Companion.create(mediaType, byArray);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u001d\u0010\u0010\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J1\u0010\u0011\u001a\u00020\u0004*\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003\u00a8\u0006\u0012"}, d2={"Lokhttp3/RequestBody$Companion;", "", "()V", "create", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "file", "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @JvmName(name="create")
        @NotNull
        public final RequestBody create(@NotNull String string, @Nullable MediaType mediaType) {
            Object object;
            Intrinsics.checkNotNullParameter(string, "<this>");
            Object object2 = Charsets.UTF_8;
            MediaType mediaType2 = mediaType;
            if (mediaType != null) {
                object = MediaType.charset$default(mediaType, null, 1, null);
                if (object == null) {
                    object2 = Charsets.UTF_8;
                    mediaType2 = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    object2 = object;
                }
            }
            byte[] byArray = string.getBytes((Charset)object2);
            Intrinsics.checkNotNullExpressionValue(byArray, "this as java.lang.String).getBytes(charset)");
            object = byArray;
            return this.create((byte[])object, mediaType2, 0, ((Object)object).length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String string, MediaType mediaType, int n, Object object) {
            if ((n & 1) != 0) {
                mediaType = null;
            }
            return companion.create(string, mediaType);
        }

        @JvmStatic
        @JvmName(name="create")
        @NotNull
        public final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(byteString, "<this>");
            return new RequestBody(mediaType, byteString){
                final /* synthetic */ MediaType $contentType;
                final /* synthetic */ ByteString $this_toRequestBody;
                {
                    this.$contentType = mediaType;
                    this.$this_toRequestBody = byteString;
                }

                @Nullable
                public MediaType contentType() {
                    return this.$contentType;
                }

                public long contentLength() {
                    return this.$this_toRequestBody.size();
                }

                public void writeTo(@NotNull BufferedSink bufferedSink) {
                    Intrinsics.checkNotNullParameter(bufferedSink, "sink");
                    bufferedSink.write(this.$this_toRequestBody);
                }
            };
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int n, Object object) {
            if ((n & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name="create")
        @NotNull
        public final RequestBody create(@NotNull byte[] byArray, @Nullable MediaType mediaType, int n, int n2) {
            Intrinsics.checkNotNullParameter(byArray, "<this>");
            Util.checkOffsetAndCount(byArray.length, n, n2);
            return new RequestBody(mediaType, n2, byArray, n){
                final /* synthetic */ MediaType $contentType;
                final /* synthetic */ int $byteCount;
                final /* synthetic */ byte[] $this_toRequestBody;
                final /* synthetic */ int $offset;
                {
                    this.$contentType = mediaType;
                    this.$byteCount = n;
                    this.$this_toRequestBody = byArray;
                    this.$offset = n2;
                }

                @Nullable
                public MediaType contentType() {
                    return this.$contentType;
                }

                public long contentLength() {
                    return this.$byteCount;
                }

                public void writeTo(@NotNull BufferedSink bufferedSink) {
                    Intrinsics.checkNotNullParameter(bufferedSink, "sink");
                    bufferedSink.write(this.$this_toRequestBody, this.$offset, this.$byteCount);
                }
            };
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] byArray, MediaType mediaType, int n, int n2, int n3, Object object) {
            if ((n3 & 1) != 0) {
                mediaType = null;
            }
            if ((n3 & 2) != 0) {
                n = 0;
            }
            if ((n3 & 4) != 0) {
                n2 = byArray.length;
            }
            return companion.create(byArray, mediaType, n, n2);
        }

        @JvmStatic
        @JvmName(name="create")
        @NotNull
        public final RequestBody create(@NotNull File file, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return new RequestBody(mediaType, file){
                final /* synthetic */ MediaType $contentType;
                final /* synthetic */ File $this_asRequestBody;
                {
                    this.$contentType = mediaType;
                    this.$this_asRequestBody = file;
                }

                @Nullable
                public MediaType contentType() {
                    return this.$contentType;
                }

                public long contentLength() {
                    return this.$this_asRequestBody.length();
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void writeTo(@NotNull BufferedSink bufferedSink) {
                    Intrinsics.checkNotNullParameter(bufferedSink, "sink");
                    Closeable closeable = Okio.source(this.$this_asRequestBody);
                    Throwable throwable = null;
                    try {
                        Source source2 = (Source)closeable;
                        boolean bl = false;
                        long l = bufferedSink.writeAll(source2);
                    }
                    catch (Throwable throwable2) {
                        throwable = throwable2;
                        throw throwable2;
                    }
                    finally {
                        CloseableKt.closeFinally(closeable, throwable);
                    }
                }
            };
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int n, Object object) {
            if ((n & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @JvmStatic
        @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "content");
            return this.create(string, mediaType);
        }

        @JvmStatic
        @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "content");
            return this.create(byteString, mediaType);
        }

        @JvmStatic
        @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
        @JvmOverloads
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] byArray, int n, int n2) {
            Intrinsics.checkNotNullParameter(byArray, "content");
            return this.create(byArray, mediaType, n, n2);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] byArray, int n, int n2, int n3, Object object) {
            if ((n3 & 4) != 0) {
                n = 0;
            }
            if ((n3 & 8) != 0) {
                n2 = byArray.length;
            }
            return companion.create(mediaType, byArray, n, n2);
        }

        @JvmStatic
        @kotlin.Deprecated(message="Moved to extension function. Put the 'file' argument first to fix Java", replaceWith=@ReplaceWith(expression="file.asRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.asRequestBody"}), level=DeprecationLevel.WARNING)
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return this.create(file, mediaType);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name="create")
        @NotNull
        public final RequestBody create(@NotNull byte[] byArray, @Nullable MediaType mediaType, int n) {
            Intrinsics.checkNotNullParameter(byArray, "<this>");
            return okhttp3.RequestBody$Companion.create$default(this, byArray, mediaType, n, 0, 4, null);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name="create")
        @NotNull
        public final RequestBody create(@NotNull byte[] byArray, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(byArray, "<this>");
            return okhttp3.RequestBody$Companion.create$default(this, byArray, mediaType, 0, 0, 6, null);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name="create")
        @NotNull
        public final RequestBody create(@NotNull byte[] byArray) {
            Intrinsics.checkNotNullParameter(byArray, "<this>");
            return okhttp3.RequestBody$Companion.create$default(this, byArray, null, 0, 0, 7, null);
        }

        @JvmStatic
        @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
        @JvmOverloads
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] byArray, int n) {
            Intrinsics.checkNotNullParameter(byArray, "content");
            return okhttp3.RequestBody$Companion.create$default(this, mediaType, byArray, n, 0, 8, null);
        }

        @JvmStatic
        @kotlin.Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}), level=DeprecationLevel.WARNING)
        @JvmOverloads
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] byArray) {
            Intrinsics.checkNotNullParameter(byArray, "content");
            return okhttp3.RequestBody$Companion.create$default(this, mediaType, byArray, 0, 0, 12, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

