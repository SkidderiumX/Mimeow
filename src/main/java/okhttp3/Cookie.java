/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000\u00a2\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f\u00a8\u0006'"}, d2={"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"})
public class Cookie {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @NotNull
    private final String value;
    private final long expiresAt;
    @NotNull
    private final String domain;
    @NotNull
    private final String path;
    private final boolean secure;
    private final boolean httpOnly;
    private final boolean persistent;
    private final boolean hostOnly;
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private Cookie(String string, String string2, long l, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.name = string;
        this.value = string2;
        this.expiresAt = l;
        this.domain = string3;
        this.path = string4;
        this.secure = bl;
        this.httpOnly = bl2;
        this.persistent = bl3;
        this.hostOnly = bl4;
    }

    @JvmName(name="name")
    @NotNull
    public final String name() {
        return this.name;
    }

    @JvmName(name="value")
    @NotNull
    public final String value() {
        return this.value;
    }

    @JvmName(name="expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @JvmName(name="domain")
    @NotNull
    public final String domain() {
        return this.domain;
    }

    @JvmName(name="path")
    @NotNull
    public final String path() {
        return this.path;
    }

    @JvmName(name="secure")
    public final boolean secure() {
        return this.secure;
    }

    @JvmName(name="httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    @JvmName(name="persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName(name="hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean matches(@NotNull HttpUrl httpUrl) {
        boolean bl;
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        boolean bl2 = bl = this.hostOnly ? Intrinsics.areEqual(httpUrl.host(), this.domain) : Cookie.Companion.domainMatch(httpUrl.host(), this.domain);
        if (!bl) {
            return false;
        }
        if (!Cookie.Companion.pathMatch(httpUrl, this.path)) {
            return false;
        }
        return !this.secure || httpUrl.isHttps();
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof Cookie && Intrinsics.areEqual(((Cookie)object).name, this.name) && Intrinsics.areEqual(((Cookie)object).value, this.value) && ((Cookie)object).expiresAt == this.expiresAt && Intrinsics.areEqual(((Cookie)object).domain, this.domain) && Intrinsics.areEqual(((Cookie)object).path, this.path) && ((Cookie)object).secure == this.secure && ((Cookie)object).httpOnly == this.httpOnly && ((Cookie)object).persistent == this.persistent && ((Cookie)object).hostOnly == this.hostOnly;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int n = 17;
        n = 31 * n + this.name.hashCode();
        n = 31 * n + this.value.hashCode();
        n = 31 * n + Long.hashCode(this.expiresAt);
        n = 31 * n + this.domain.hashCode();
        n = 31 * n + this.path.hashCode();
        n = 31 * n + Boolean.hashCode(this.secure);
        n = 31 * n + Boolean.hashCode(this.httpOnly);
        n = 31 * n + Boolean.hashCode(this.persistent);
        n = 31 * n + Boolean.hashCode(this.hostOnly);
        return n;
    }

    @NotNull
    public String toString() {
        return this.toString$okhttp(false);
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="name", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_name")
    @NotNull
    public final String m8c00cf3f52() {
        return this.name;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="value", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_value")
    @NotNull
    public final String m19666c51f2() {
        return this.value;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="persistent", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_persistent")
    public final boolean m1c8355e732() {
        return this.persistent;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="expiresAt", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_expiresAt")
    public final long m0e833ebb83() {
        return this.expiresAt;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="hostOnly", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_hostOnly")
    public final boolean m0740cbe6fe() {
        return this.hostOnly;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="domain", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_domain")
    @NotNull
    public final String m194294586f() {
        return this.domain;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="path", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_path")
    @NotNull
    public final String mab7685afd4() {
        return this.path;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="httpOnly", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_httpOnly")
    public final boolean m79bb62ab59() {
        return this.httpOnly;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="secure", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_secure")
    public final boolean m02c5f59f64() {
        return this.secure;
    }

    @NotNull
    public final String toString$okhttp(boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = false;
        stringBuilder.append(this.name);
        stringBuilder.append('=');
        stringBuilder.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            stringBuilder.append("; domain=");
            if (bl) {
                stringBuilder.append(".");
            }
            stringBuilder.append(this.domain);
        }
        stringBuilder.append("; path=").append(this.path);
        if (this.secure) {
            stringBuilder.append("; secure");
        }
        if (this.httpOnly) {
            stringBuilder.append("; httponly");
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return string;
    }

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl httpUrl, @NotNull String string) {
        return Companion.parse(httpUrl, string);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl httpUrl, @NotNull Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    public /* synthetic */ Cookie(String string, String string2, long l, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4, DefaultConstructorMarker defaultConstructorMarker) {
        this(string, string2, l, string3, string4, bl, bl2, bl3, bl4);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nCookie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cookie.kt\nokhttp3/Cookie$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,614:1\n1#2:615\n*E\n"})
    public static final class Builder {
        @Nullable
        private String name;
        @Nullable
        private String value;
        private long expiresAt = 253402300799999L;
        @Nullable
        private String domain;
        @NotNull
        private String path = "/";
        private boolean secure;
        private boolean httpOnly;
        private boolean persistent;
        private boolean hostOnly;

        @NotNull
        public final Builder name(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!Intrinsics.areEqual(((Object)StringsKt.trim((CharSequence)string)).toString(), string)) {
                boolean bl2 = false;
                String string2 = "name is not trimmed";
                throw new IllegalArgumentException(string2.toString());
            }
            builder2.name = string;
            return builder;
        }

        @NotNull
        public final Builder value(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!Intrinsics.areEqual(((Object)StringsKt.trim((CharSequence)string)).toString(), string)) {
                boolean bl2 = false;
                String string2 = "value is not trimmed";
                throw new IllegalArgumentException(string2.toString());
            }
            builder2.value = string;
            return builder;
        }

        @NotNull
        public final Builder expiresAt(long l) {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            long l2 = l;
            if (l2 <= 0L) {
                l2 = Long.MIN_VALUE;
            }
            if (l2 > 253402300799999L) {
                l2 = 253402300799999L;
            }
            builder2.expiresAt = l2;
            builder2.persistent = true;
            return builder;
        }

        @NotNull
        public final Builder domain(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "domain");
            return this.domain(string, false);
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "domain");
            return this.domain(string, true);
        }

        private final Builder domain(String string, boolean bl) {
            String string2;
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl2 = false;
            String string3 = HostnamesKt.toCanonicalHost(string);
            if (string3 == null) {
                throw new IllegalArgumentException("unexpected domain: " + string);
            }
            builder2.domain = string2 = string3;
            builder2.hostOnly = bl;
            return builder;
        }

        @NotNull
        public final Builder path(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "path");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!StringsKt.startsWith$default(string, "/", false, 2, null)) {
                boolean bl2 = false;
                String string2 = "path must start with '/'";
                throw new IllegalArgumentException(string2.toString());
            }
            builder2.path = string;
            return builder;
        }

        @NotNull
        public final Builder secure() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.secure = true;
            return builder;
        }

        @NotNull
        public final Builder httpOnly() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.httpOnly = true;
            return builder;
        }

        @NotNull
        public final Cookie build() {
            String string = this.name;
            if (string == null) {
                throw new NullPointerException("builder.name == null");
            }
            String string2 = this.value;
            if (string2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            String string3 = this.domain;
            if (string3 == null) {
                throw new NullPointerException("builder.domain == null");
            }
            return new Cookie(string, string2, this.expiresAt, string3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000\u00a2\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        private final boolean domainMatch(String string, String string2) {
            if (Intrinsics.areEqual(string, string2)) {
                return true;
            }
            return StringsKt.endsWith$default(string, string2, false, 2, null) && string.charAt(string.length() - string2.length() - 1) == '.' && !Util.canParseAsIpAddress(string);
        }

        private final boolean pathMatch(HttpUrl httpUrl, String string) {
            String string2 = httpUrl.encodedPath();
            if (Intrinsics.areEqual(string2, string)) {
                return true;
            }
            if (StringsKt.startsWith$default(string2, string, false, 2, null)) {
                if (StringsKt.endsWith$default(string, "/", false, 2, null)) {
                    return true;
                }
                if (string2.charAt(string.length()) == '/') {
                    return true;
                }
            }
            return false;
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl httpUrl, @NotNull String string) {
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            Intrinsics.checkNotNullParameter(string, "setCookie");
            return this.parse$okhttp(System.currentTimeMillis(), httpUrl, string);
        }

        @Nullable
        public final Cookie parse$okhttp(long l, @NotNull HttpUrl httpUrl, @NotNull String string) {
            long l2;
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            Intrinsics.checkNotNullParameter(string, "setCookie");
            int n = Util.delimiterOffset$default(string, ';', 0, 0, 6, null);
            int n2 = Util.delimiterOffset$default(string, '=', 0, n, 2, null);
            if (n2 == n) {
                return null;
            }
            String string2 = Util.trimSubstring$default(string, 0, n2, 1, null);
            if (((CharSequence)string2).length() == 0 || Util.indexOfControlOrNonAscii(string2) != -1) {
                return null;
            }
            String string3 = Util.trimSubstring(string, n2 + 1, n);
            if (Util.indexOfControlOrNonAscii(string3) != -1) {
                return null;
            }
            long l3 = 253402300799999L;
            long l4 = -1L;
            String string4 = null;
            String string5 = null;
            boolean bl = false;
            boolean bl2 = false;
            boolean bl3 = true;
            boolean bl4 = false;
            int n3 = n + 1;
            int n4 = string.length();
            while (n3 < n4) {
                int n5 = Util.delimiterOffset(string, ';', n3, n4);
                int n6 = Util.delimiterOffset(string, '=', n3, n5);
                String string6 = Util.trimSubstring(string, n3, n6);
                String string7 = n6 < n5 ? Util.trimSubstring(string, n6 + 1, n5) : "";
                if (StringsKt.equals(string6, "expires", true)) {
                    try {
                        l3 = this.parseExpires(string7, 0, string7.length());
                        bl4 = true;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {}
                } else if (StringsKt.equals(string6, "max-age", true)) {
                    try {
                        l4 = this.parseMaxAge(string7);
                        bl4 = true;
                    }
                    catch (NumberFormatException numberFormatException) {}
                } else if (StringsKt.equals(string6, "domain", true)) {
                    try {
                        string4 = this.parseDomain(string7);
                        bl3 = false;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {}
                } else if (StringsKt.equals(string6, "path", true)) {
                    string5 = string7;
                } else if (StringsKt.equals(string6, "secure", true)) {
                    bl = true;
                } else if (StringsKt.equals(string6, "httponly", true)) {
                    bl2 = true;
                }
                n3 = n5 + 1;
            }
            if (l4 == Long.MIN_VALUE) {
                l3 = Long.MIN_VALUE;
            } else if (l4 != -1L && ((l3 = l + (l2 = l4 <= 9223372036854775L ? l4 * (long)1000 : Long.MAX_VALUE)) < l || l3 > 253402300799999L)) {
                l3 = 253402300799999L;
            }
            String string8 = httpUrl.host();
            if (string4 == null) {
                string4 = string8;
            } else if (!this.domainMatch(string8, string4)) {
                return null;
            }
            if (string8.length() != string4.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(string4) == null) {
                return null;
            }
            if (string5 == null || !StringsKt.startsWith$default(string5, "/", false, 2, null)) {
                String string9;
                String string10 = httpUrl.encodedPath();
                int n7 = StringsKt.lastIndexOf$default((CharSequence)string10, '/', 0, false, 6, null);
                if (n7 != 0) {
                    String string11 = string10.substring(0, n7);
                    string9 = string11;
                    Intrinsics.checkNotNullExpressionValue(string11, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                } else {
                    string9 = "/";
                }
                string5 = string9;
            }
            return new Cookie(string2, string3, l3, string4, string5, bl, bl2, bl4, bl3, null);
        }

        private final long parseExpires(String string, int n, int n2) {
            Object object;
            int n3 = n;
            n3 = this.dateCharacterOffset(string, n3, n2, false);
            int n4 = 0;
            n4 = -1;
            int n5 = 0;
            n5 = -1;
            int n6 = 0;
            n6 = -1;
            int n7 = 0;
            n7 = -1;
            int n8 = 0;
            n8 = -1;
            int n9 = 0;
            n9 = -1;
            Matcher matcher = TIME_PATTERN.matcher(string);
            while (n3 < n2) {
                int n10 = this.dateCharacterOffset(string, n3 + 1, n2, true);
                matcher.region(n3, n10);
                if (n4 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                    String string2 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(string2, "matcher.group(1)");
                    n4 = Integer.parseInt(string2);
                    String string3 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(string3, "matcher.group(2)");
                    n5 = Integer.parseInt(string3);
                    String string4 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(string4, "matcher.group(3)");
                    n6 = Integer.parseInt(string4);
                } else if (n7 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                    String string5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(string5, "matcher.group(1)");
                    n7 = Integer.parseInt(string5);
                } else if (n8 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                    String string6;
                    Intrinsics.checkNotNullExpressionValue(matcher.group(1), "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "US");
                    Intrinsics.checkNotNullExpressionValue(string6.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
                    String string7 = MONTH_PATTERN.pattern();
                    Intrinsics.checkNotNullExpressionValue(string7, "MONTH_PATTERN.pattern()");
                    n8 = StringsKt.indexOf$default((CharSequence)string7, (String)object, 0, false, 6, null) / 4;
                } else if (n9 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    String string8 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(string8, "matcher.group(1)");
                    n9 = Integer.parseInt(string8);
                }
                n3 = this.dateCharacterOffset(string, n10 + 1, n2, false);
            }
            boolean bl = 70 <= n9 ? n9 < 100 : false;
            if (bl) {
                n9 += 1900;
            }
            boolean bl2 = 0 <= n9 ? n9 < 70 : false;
            if (bl2) {
                n9 += 2000;
            }
            if (!(n9 >= 1601)) {
                object = "Failed requirement.";
                throw new IllegalArgumentException(object.toString());
            }
            if (!(n8 != -1)) {
                object = "Failed requirement.";
                throw new IllegalArgumentException(object.toString());
            }
            if (!(1 <= n7 ? n7 < 32 : false)) {
                object = "Failed requirement.";
                throw new IllegalArgumentException(object.toString());
            }
            if (!(0 <= n4 ? n4 < 24 : false)) {
                object = "Failed requirement.";
                throw new IllegalArgumentException(object.toString());
            }
            if (!(0 <= n5 ? n5 < 60 : false)) {
                object = "Failed requirement.";
                throw new IllegalArgumentException(object.toString());
            }
            if (!(0 <= n6 ? n6 < 60 : false)) {
                object = "Failed requirement.";
                throw new IllegalArgumentException(object.toString());
            }
            object = new GregorianCalendar(Util.UTC);
            boolean bl3 = false;
            ((Calendar)object).setLenient(false);
            ((Calendar)object).set(1, n9);
            ((Calendar)object).set(2, n8 - 1);
            ((Calendar)object).set(5, n7);
            ((Calendar)object).set(11, n4);
            ((Calendar)object).set(12, n5);
            ((Calendar)object).set(13, n6);
            ((Calendar)object).set(14, 0);
            return ((Calendar)object).getTimeInMillis();
        }

        /*
         * Unable to fully structure code
         */
        private final int dateCharacterOffset(String string, int pos, int limit, boolean invert) {
            for (int i = pos; i < limit; ++i) {
                char c = string.charAt(i);
                boolean valid = (c < ' ' && c != '\t') || c >= '\u007f'
                    || ('0' <= c && c < ':')
                    || ('a' <= c && c < '{')
                    || (('A' <= c && c < '[') || c == ':');
                if (valid != invert) {
                    return i;
                }
            }
            return limit;
        }

        private final long parseMaxAge(String string) {
            try {
                long l = Long.parseLong(string);
                return l <= 0L ? Long.MIN_VALUE : l;
            }
            catch (NumberFormatException numberFormatException) {
                CharSequence charSequence = string;
                if (new Regex("-?\\d+").matches(charSequence)) {
                    return StringsKt.startsWith$default(string, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw numberFormatException;
            }
        }

        private final String parseDomain(String string) {
            if (!(!StringsKt.endsWith$default(string, ".", false, 2, null))) {
                String string2 = "Failed requirement.";
                throw new IllegalArgumentException(string2.toString());
            }
            String string3 = HostnamesKt.toCanonicalHost(StringsKt.removePrefix(string, (CharSequence)"."));
            if (string3 == null) {
                throw new IllegalArgumentException();
            }
            return string3;
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl httpUrl, @NotNull Headers headers) {
            List<Cookie> list;
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> list2 = headers.values("Set-Cookie");
            List list3 = null;
            int n = list2.size();
            for (int i = 0; i < n; ++i) {
                Cookie cookie;
                if (this.parse(httpUrl, list2.get(i)) == null) continue;
                if (list3 == null) {
                    list3 = new ArrayList();
                }
                list3.add(cookie);
            }
            if (list3 != null) {
                List list4 = Collections.unmodifiableList(list3);
                list = list4;
                Intrinsics.checkNotNullExpressionValue(list4, "{\n        Collections.un\u2026ableList(cookies)\n      }");
            } else {
                list = CollectionsKt.emptyList();
            }
            return list;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

