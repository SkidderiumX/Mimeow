/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014\u00a8\u0006\""}, d2={"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"})
public class CacheControl {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean noCache;
    private final boolean noStore;
    private final int maxAgeSeconds;
    private final int sMaxAgeSeconds;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final boolean mustRevalidate;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean onlyIfCached;
    private final boolean noTransform;
    private final boolean immutable;
    @Nullable
    private String headerValue;
    @JvmField
    @NotNull
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    @JvmField
    @NotNull
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    private CacheControl(boolean bl, boolean bl2, int n, int n2, boolean bl3, boolean bl4, boolean bl5, int n3, int n4, boolean bl6, boolean bl7, boolean bl8, String string) {
        this.noCache = bl;
        this.noStore = bl2;
        this.maxAgeSeconds = n;
        this.sMaxAgeSeconds = n2;
        this.isPrivate = bl3;
        this.isPublic = bl4;
        this.mustRevalidate = bl5;
        this.maxStaleSeconds = n3;
        this.minFreshSeconds = n4;
        this.onlyIfCached = bl6;
        this.noTransform = bl7;
        this.immutable = bl8;
        this.headerValue = string;
    }

    @JvmName(name="noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName(name="noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName(name="maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName(name="sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @JvmName(name="mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName(name="maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName(name="minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName(name="onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName(name="noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName(name="immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="noCache", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_noCache")
    public final boolean m89926e506d() {
        return this.noCache;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="noStore", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_noStore")
    public final boolean m4348ee3f32() {
        return this.noStore;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="maxAgeSeconds", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_maxAgeSeconds")
    public final int mf3c3e6abd1() {
        return this.maxAgeSeconds;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="sMaxAgeSeconds", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_sMaxAgeSeconds")
    public final int m866f69dffc() {
        return this.sMaxAgeSeconds;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="mustRevalidate", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_mustRevalidate")
    public final boolean me1345b6623() {
        return this.mustRevalidate;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="maxStaleSeconds", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_maxStaleSeconds")
    public final int m0b631d673e() {
        return this.maxStaleSeconds;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="minFreshSeconds", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_minFreshSeconds")
    public final int m15dc2feeca() {
        return this.minFreshSeconds;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="onlyIfCached", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_onlyIfCached")
    public final boolean m1b1147a773() {
        return this.onlyIfCached;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="noTransform", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_noTransform")
    public final boolean m41d89bdd48() {
        return this.noTransform;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="immutable", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_immutable")
    public final boolean m342b86c893() {
        return this.immutable;
    }

    @NotNull
    public String toString() {
        String string = this.headerValue;
        if (string == null) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
            boolean bl = false;
            if (this.noCache) {
                stringBuilder2.append("no-cache, ");
            }
            if (this.noStore) {
                stringBuilder2.append("no-store, ");
            }
            if (this.maxAgeSeconds != -1) {
                stringBuilder2.append("max-age=").append(this.maxAgeSeconds).append(", ");
            }
            if (this.sMaxAgeSeconds != -1) {
                stringBuilder2.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
            }
            if (this.isPrivate) {
                stringBuilder2.append("private, ");
            }
            if (this.isPublic) {
                stringBuilder2.append("public, ");
            }
            if (this.mustRevalidate) {
                stringBuilder2.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                stringBuilder2.append("max-stale=").append(this.maxStaleSeconds).append(", ");
            }
            if (this.minFreshSeconds != -1) {
                stringBuilder2.append("min-fresh=").append(this.minFreshSeconds).append(", ");
            }
            if (this.onlyIfCached) {
                stringBuilder2.append("only-if-cached, ");
            }
            if (this.noTransform) {
                stringBuilder2.append("no-transform, ");
            }
            if (this.immutable) {
                stringBuilder2.append("immutable, ");
            }
            if (((CharSequence)stringBuilder2).length() == 0) {
                return "";
            }
            stringBuilder2.delete(stringBuilder2.length() - 2, stringBuilder2.length());
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = string = string2;
        }
        return string;
    }

    @JvmStatic
    @NotNull
    public static final CacheControl parse(@NotNull Headers headers) {
        return Companion.parse(headers);
    }

    public /* synthetic */ CacheControl(boolean bl, boolean bl2, int n, int n2, boolean bl3, boolean bl4, boolean bl5, int n3, int n4, boolean bl6, boolean bl7, boolean bl8, String string, DefaultConstructorMarker defaultConstructorMarker) {
        this(bl, bl2, n, n2, bl3, bl4, bl5, n3, n4, bl6, bl7, bl8, string);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nCacheControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheControl.kt\nokhttp3/CacheControl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,416:1\n1#2:417\n*E\n"})
    public static final class Builder {
        private boolean noCache;
        private boolean noStore;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean onlyIfCached;
        private boolean noTransform;
        private boolean immutable;

        @NotNull
        public final Builder noCache() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.noCache = true;
            return builder;
        }

        @NotNull
        public final Builder noStore() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.noStore = true;
            return builder;
        }

        @NotNull
        public final Builder maxAge(int n, @NotNull TimeUnit timeUnit) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)timeUnit, "timeUnit");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!(n >= 0)) {
                boolean bl2 = false;
                String string = "maxAge < 0: " + n;
                throw new IllegalArgumentException(string.toString());
            }
            long l = timeUnit.toSeconds(n);
            builder2.maxAgeSeconds = builder2.clampToInt(l);
            return builder;
        }

        @NotNull
        public final Builder maxStale(int n, @NotNull TimeUnit timeUnit) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)timeUnit, "timeUnit");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!(n >= 0)) {
                boolean bl2 = false;
                String string = "maxStale < 0: " + n;
                throw new IllegalArgumentException(string.toString());
            }
            long l = timeUnit.toSeconds(n);
            builder2.maxStaleSeconds = builder2.clampToInt(l);
            return builder;
        }

        @NotNull
        public final Builder minFresh(int n, @NotNull TimeUnit timeUnit) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)timeUnit, "timeUnit");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!(n >= 0)) {
                boolean bl2 = false;
                String string = "minFresh < 0: " + n;
                throw new IllegalArgumentException(string.toString());
            }
            long l = timeUnit.toSeconds(n);
            builder2.minFreshSeconds = builder2.clampToInt(l);
            return builder;
        }

        @NotNull
        public final Builder onlyIfCached() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.onlyIfCached = true;
            return builder;
        }

        @NotNull
        public final Builder noTransform() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.noTransform = true;
            return builder;
        }

        @NotNull
        public final Builder immutable() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.immutable = true;
            return builder;
        }

        private final int clampToInt(long l) {
            return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l;
        }

        @NotNull
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final CacheControl parse(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            boolean bl = false;
            boolean bl2 = false;
            int n = -1;
            int n2 = -1;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            int n3 = -1;
            int n4 = -1;
            boolean bl6 = false;
            boolean bl7 = false;
            boolean bl8 = false;
            boolean bl9 = true;
            String string = null;
            int n5 = headers.size();
            for (int i = 0; i < n5; ++i) {
                String string2 = headers.name(i);
                String string3 = headers.value(i);
                if (StringsKt.equals(string2, "Cache-Control", true)) {
                    if (string != null) {
                        bl9 = false;
                    } else {
                        string = string3;
                    }
                } else {
                    if (!StringsKt.equals(string2, "Pragma", true)) continue;
                    bl9 = false;
                }
                int n6 = 0;
                while (n6 < string3.length()) {
                    int n7 = n6;
                    n6 = this.indexOfElement(string3, "=,;", n6);
                    String string4 = string3.substring(n7, n6);
                    Intrinsics.checkNotNullExpressionValue(string4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    String string5 = ((Object)StringsKt.trim((CharSequence)string4)).toString();
                    String string6 = null;
                    if (n6 == string3.length() || string3.charAt(n6) == ',' || string3.charAt(n6) == ';') {
                        ++n6;
                        string6 = null;
                    } else {
                        int n8;
                        ++n6;
                        if ((n6 = Util.indexOfNonWhitespace(string3, n6)) < string3.length() && string3.charAt(n6) == '\"') {
                            n8 = ++n6;
                            n6 = StringsKt.indexOf$default((CharSequence)string3, '\"', n6, false, 4, null);
                            String string7 = string3.substring(n8, n6);
                            Intrinsics.checkNotNullExpressionValue(string7, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            string6 = string7;
                            ++n6;
                        } else {
                            n8 = n6;
                            n6 = this.indexOfElement(string3, ",;", n6);
                            String string8 = string3.substring(n8, n6);
                            Intrinsics.checkNotNullExpressionValue(string8, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            string6 = ((Object)StringsKt.trim((CharSequence)string8)).toString();
                        }
                    }
                    if (StringsKt.equals("no-cache", string5, true)) {
                        bl = true;
                        continue;
                    }
                    if (StringsKt.equals("no-store", string5, true)) {
                        bl2 = true;
                        continue;
                    }
                    if (StringsKt.equals("max-age", string5, true)) {
                        n = Util.toNonNegativeInt(string6, -1);
                        continue;
                    }
                    if (StringsKt.equals("s-maxage", string5, true)) {
                        n2 = Util.toNonNegativeInt(string6, -1);
                        continue;
                    }
                    if (StringsKt.equals("private", string5, true)) {
                        bl3 = true;
                        continue;
                    }
                    if (StringsKt.equals("public", string5, true)) {
                        bl4 = true;
                        continue;
                    }
                    if (StringsKt.equals("must-revalidate", string5, true)) {
                        bl5 = true;
                        continue;
                    }
                    if (StringsKt.equals("max-stale", string5, true)) {
                        n3 = Util.toNonNegativeInt(string6, Integer.MAX_VALUE);
                        continue;
                    }
                    if (StringsKt.equals("min-fresh", string5, true)) {
                        n4 = Util.toNonNegativeInt(string6, -1);
                        continue;
                    }
                    if (StringsKt.equals("only-if-cached", string5, true)) {
                        bl6 = true;
                        continue;
                    }
                    if (StringsKt.equals("no-transform", string5, true)) {
                        bl7 = true;
                        continue;
                    }
                    if (!StringsKt.equals("immutable", string5, true)) continue;
                    bl8 = true;
                }
            }
            if (!bl9) {
                string = null;
            }
            return new CacheControl(bl, bl2, n, n2, bl3, bl4, bl5, n3, n4, bl6, bl7, bl8, string, null);
        }

        private final int indexOfElement(String string, String string2, int n) {
            int n2 = string.length();
            for (int i = n; i < n2; ++i) {
                if (!StringsKt.contains$default((CharSequence)string2, string.charAt(i), false, 2, null)) continue;
                return i;
            }
            return string.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String string, String string2, int n, int n2, Object object) {
            if ((n2 & 2) != 0) {
                n = 0;
            }
            return companion.indexOfElement(string, string2, n);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

