/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00a2\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00a2\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007\u00a2\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007\u00a2\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007\u00a2\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007\u00a2\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007\u00a2\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007\u00a2\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010\u00a8\u0006K"}, d2={"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"})
public class HttpUrl {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String scheme;
    @NotNull
    private final String username;
    @NotNull
    private final String password;
    @NotNull
    private final String host;
    private final int port;
    @NotNull
    private final List<String> pathSegments;
    @Nullable
    private final List<String> queryNamesAndValues;
    @Nullable
    private final String fragment;
    @NotNull
    private final String url;
    private final boolean isHttps;
    @NotNull
    private static final char[] HEX_DIGITS;
    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    @NotNull
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    @NotNull
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";
    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";

    public HttpUrl(@NotNull String string, @NotNull String string2, @NotNull String string3, @NotNull String string4, int n, @NotNull List<String> list, @Nullable List<String> list2, @Nullable String string5, @NotNull String string6) {
        Intrinsics.checkNotNullParameter(string, "scheme");
        Intrinsics.checkNotNullParameter(string2, "username");
        Intrinsics.checkNotNullParameter(string3, "password");
        Intrinsics.checkNotNullParameter(string4, "host");
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(string6, "url");
        this.scheme = string;
        this.username = string2;
        this.password = string3;
        this.host = string4;
        this.port = n;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = string5;
        this.url = string6;
        this.isHttps = Intrinsics.areEqual(this.scheme, "https");
    }

    @JvmName(name="scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @JvmName(name="username")
    @NotNull
    public final String username() {
        return this.username;
    }

    @JvmName(name="password")
    @NotNull
    public final String password() {
        return this.password;
    }

    @JvmName(name="host")
    @NotNull
    public final String host() {
        return this.host;
    }

    @JvmName(name="port")
    public final int port() {
        return this.port;
    }

    @JvmName(name="pathSegments")
    @NotNull
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @JvmName(name="fragment")
    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @JvmName(name="url")
    @NotNull
    public final URL url() {
        try {
            return new URL(this.url);
        }
        catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }

    @JvmName(name="uri")
    @NotNull
    public final URI uri() {
        Object object;
        String string = this.newBuilder().reencodeForUri$okhttp().toString();
        try {
            object = new URI(string);
        }
        catch (URISyntaxException uRISyntaxException) {
            Object object2;
            try {
                CharSequence charSequence = string;
                Regex regex = new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                String string2 = FRAGMENT_ENCODE_SET;
                object2 = regex.replace(charSequence, string2);
                object2 = URI.create((String)object2);
            }
            catch (Exception exception) {
                throw new RuntimeException(uRISyntaxException);
            }
            Object object3 = object2;
            Intrinsics.checkNotNullExpressionValue(object3, "{\n      // Unlikely edge\u2026Unexpected!\n      }\n    }");
            object = object3;
        }
        return object;
    }

    @JvmName(name="encodedUsername")
    @NotNull
    public final String encodedUsername() {
        if (((CharSequence)this.username).length() == 0) {
            return FRAGMENT_ENCODE_SET;
        }
        int n = this.scheme.length() + 3;
        int n2 = Util.delimiterOffset(this.url, ":@", n, this.url.length());
        String string = this.url.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    @JvmName(name="encodedPassword")
    @NotNull
    public final String encodedPassword() {
        if (((CharSequence)this.password).length() == 0) {
            return FRAGMENT_ENCODE_SET;
        }
        int n = StringsKt.indexOf$default((CharSequence)this.url, ':', this.scheme.length() + 3, false, 4, null) + 1;
        int n2 = StringsKt.indexOf$default((CharSequence)this.url, '@', 0, false, 6, null);
        String string = this.url.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    @JvmName(name="pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @JvmName(name="encodedPath")
    @NotNull
    public final String encodedPath() {
        int n = StringsKt.indexOf$default((CharSequence)this.url, '/', this.scheme.length() + 3, false, 4, null);
        int n2 = Util.delimiterOffset(this.url, "?#", n, this.url.length());
        String string = this.url.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    @JvmName(name="encodedPathSegments")
    @NotNull
    public final List<String> encodedPathSegments() {
        int n = StringsKt.indexOf$default((CharSequence)this.url, '/', this.scheme.length() + 3, false, 4, null);
        int n2 = Util.delimiterOffset(this.url, "?#", n, this.url.length());
        List list = new ArrayList();
        int n3 = n;
        while (n3 < n2) {
            int n4 = Util.delimiterOffset(this.url, '/', ++n3, n2);
            String string = this.url.substring(n3, n4);
            Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            list.add(string);
            n3 = n4;
        }
        return list;
    }

    @JvmName(name="encodedQuery")
    @Nullable
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int n = StringsKt.indexOf$default((CharSequence)this.url, '?', 0, false, 6, null) + 1;
        int n2 = Util.delimiterOffset(this.url, '#', n, this.url.length());
        String string = this.url.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    @JvmName(name="query")
    @Nullable
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, stringBuilder);
        return stringBuilder.toString();
    }

    @JvmName(name="querySize")
    public final int querySize() {
        return this.queryNamesAndValues != null ? this.queryNamesAndValues.size() / 2 : 0;
    }

    @Nullable
    public final String queryParameter(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "name");
        if (this.queryNamesAndValues == null) {
            return null;
        }
        IntProgression intProgression = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        if (n3 > 0 && n <= n2 || n3 < 0 && n2 <= n) {
            while (true) {
                if (Intrinsics.areEqual(string, this.queryNamesAndValues.get(n))) {
                    return this.queryNamesAndValues.get(n + 1);
                }
                if (n == n2) break;
                n += n3;
            }
        }
        return null;
    }

    @JvmName(name="queryParameterNames")
    @NotNull
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt.emptySet();
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        IntProgression intProgression = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        if (n3 > 0 && n <= n2 || n3 < 0 && n2 <= n) {
            while (true) {
                String string = this.queryNamesAndValues.get(n);
                Intrinsics.checkNotNull(string);
                linkedHashSet.add(string);
                if (n == n2) break;
                n += n3;
            }
        }
        Set<String> set = Collections.unmodifiableSet((Set)linkedHashSet);
        Intrinsics.checkNotNullExpressionValue(set, "unmodifiableSet(result)");
        return set;
    }

    @NotNull
    public final List<String> queryParameterValues(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "name");
        if (this.queryNamesAndValues == null) {
            return CollectionsKt.emptyList();
        }
        List list = new ArrayList();
        IntProgression intProgression = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        if (n3 > 0 && n <= n2 || n3 < 0 && n2 <= n) {
            while (true) {
                if (Intrinsics.areEqual(string, this.queryNamesAndValues.get(n))) {
                    list.add(this.queryNamesAndValues.get(n + 1));
                }
                if (n == n2) break;
                n += n3;
            }
        }
        List<String> list2 = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue(list2, "unmodifiableList(result)");
        return list2;
    }

    @NotNull
    public final String queryParameterName(int n) {
        if (this.queryNamesAndValues == null) {
            throw new IndexOutOfBoundsException();
        }
        String string = this.queryNamesAndValues.get(n * 2);
        Intrinsics.checkNotNull(string);
        return string;
    }

    @Nullable
    public final String queryParameterValue(int n) {
        if (this.queryNamesAndValues == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.queryNamesAndValues.get(n * 2 + 1);
    }

    @JvmName(name="encodedFragment")
    @Nullable
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int n = StringsKt.indexOf$default((CharSequence)this.url, '#', 0, false, 6, null) + 1;
        String string = this.url.substring(n);
        Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String).substring(startIndex)");
        return string;
    }

    @NotNull
    public final String redact() {
        Builder builder = this.newBuilder("/...");
        Intrinsics.checkNotNull(builder);
        return builder.username(FRAGMENT_ENCODE_SET).password(FRAGMENT_ENCODE_SET).build().toString();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "link");
        Builder builder = this.newBuilder(string);
        return builder != null ? builder.build() : null;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(this.encodedUsername());
        builder.setEncodedPassword$okhttp(this.encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll((Collection<String>)this.encodedPathSegments());
        builder.encodedQuery(this.encodedQuery());
        builder.setEncodedFragment$okhttp(this.encodedFragment());
        return builder;
    }

    @Nullable
    public final Builder newBuilder(@NotNull String string) {
        Builder builder;
        Intrinsics.checkNotNullParameter(string, "link");
        try {
            builder = new Builder().parse$okhttp(this, string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            builder = null;
        }
        return builder;
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof HttpUrl && Intrinsics.areEqual(((HttpUrl)object).url, this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return this.url;
    }

    @Nullable
    public final String topPrivateDomain() {
        return Util.canParseAsIpAddress(this.host) ? null : PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @Deprecated(message="moved to toUrl()", replaceWith=@ReplaceWith(expression="toUrl()", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_url")
    @NotNull
    public final URL m289dde399c() {
        return this.url();
    }

    @Deprecated(message="moved to toUri()", replaceWith=@ReplaceWith(expression="toUri()", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_uri")
    @NotNull
    public final URI m8ea086cd29() {
        return this.uri();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="scheme", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_scheme")
    @NotNull
    public final String mb5d37539d2() {
        return this.scheme;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="encodedUsername", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_encodedUsername")
    @NotNull
    public final String mf132c7413b() {
        return this.encodedUsername();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="username", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_username")
    @NotNull
    public final String m86f5d7645c() {
        return this.username;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="encodedPassword", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_encodedPassword")
    @NotNull
    public final String m8af58c2775() {
        return this.encodedPassword();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="password", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_password")
    @NotNull
    public final String m1692d58e9f() {
        return this.password;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="host", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_host")
    @NotNull
    public final String md9edae78d9() {
        return this.host;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="port", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_port")
    public final int m01723dede8() {
        return this.port;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="pathSize", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_pathSize")
    public final int m491a7016de() {
        return this.pathSize();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="encodedPath", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_encodedPath")
    @NotNull
    public final String m0c6188453f() {
        return this.encodedPath();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="encodedPathSegments", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_encodedPathSegments")
    @NotNull
    public final List<String> mb0fd571131() {
        return this.encodedPathSegments();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="pathSegments", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_pathSegments")
    @NotNull
    public final List<String> m4effc45145() {
        return this.pathSegments;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="encodedQuery", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_encodedQuery")
    @Nullable
    public final String m9c25b62bae() {
        return this.encodedQuery();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="query", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_query")
    @Nullable
    public final String m936ab62e6c() {
        return this.query();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="querySize", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_querySize")
    public final int m0fb490d7e5() {
        return this.querySize();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="queryParameterNames", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_queryParameterNames")
    @NotNull
    public final Set<String> m88977f4e33() {
        return this.queryParameterNames();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="encodedFragment", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_encodedFragment")
    @Nullable
    public final String m1628a3883e() {
        return this.encodedFragment();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="fragment", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_fragment")
    @Nullable
    public final String m011d153d4e() {
        return this.fragment;
    }

    @JvmStatic
    public static final int defaultPort(@NotNull String string) {
        return Companion.defaultPort(string);
    }

    @JvmStatic
    @JvmName(name="get")
    @NotNull
    public static final HttpUrl get(@NotNull String string) {
        return Companion.get(string);
    }

    @JvmStatic
    @JvmName(name="parse")
    @Nullable
    public static final HttpUrl parse(@NotNull String string) {
        return Companion.parse(string);
    }

    @JvmStatic
    @JvmName(name="get")
    @Nullable
    public static final HttpUrl get(@NotNull URL uRL) {
        return Companion.get(uRL);
    }

    @JvmStatic
    @JvmName(name="get")
    @Nullable
    public static final HttpUrl get(@NotNull URI uRI) {
        return Companion.get(uRI);
    }

    static {
        char[] cArray = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        HEX_DIGITS = cArray;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020\u0000H\u0000\u00a2\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b\u00a8\u0006W"}, d2={"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", "build", "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", "base", "parse$okhttp", "password", "pop", "", "push", "pos", "limit", "addTrailingSlash", "query", "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttpUrl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1869:1\n1#2:1870\n1549#3:1871\n1620#3,3:1872\n1549#3:1875\n1620#3,3:1876\n*S KotlinDebug\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n*L\n1180#1:1871\n1180#1:1872,3\n1181#1:1875\n1181#1:1876,3\n*E\n"})
    public static final class Builder {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        private String scheme;
        @NotNull
        private String encodedUsername = "";
        @NotNull
        private String encodedPassword = "";
        @Nullable
        private String host;
        private int port = -1;
        @NotNull
        private final List<String> encodedPathSegments = new ArrayList();
        @Nullable
        private List<String> encodedQueryNamesAndValues;
        @Nullable
        private String encodedFragment;
        @NotNull
        public static final String INVALID_HOST = "Invalid URL host";

        public Builder() {
            this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
        }

        @Nullable
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final void setScheme$okhttp(@Nullable String string) {
            this.scheme = string;
        }

        @NotNull
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final void setEncodedUsername$okhttp(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<set-?>");
            this.encodedUsername = string;
        }

        @NotNull
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final void setEncodedPassword$okhttp(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<set-?>");
            this.encodedPassword = string;
        }

        @Nullable
        public final String getHost$okhttp() {
            return this.host;
        }

        public final void setHost$okhttp(@Nullable String string) {
            this.host = string;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final void setPort$okhttp(int n) {
            this.port = n;
        }

        @NotNull
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @Nullable
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @Nullable
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final void setEncodedFragment$okhttp(@Nullable String string) {
            this.encodedFragment = string;
        }

        @NotNull
        public final Builder scheme(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "scheme");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (StringsKt.equals(string, "http", true)) {
                builder2.scheme = "http";
            } else if (StringsKt.equals(string, "https", true)) {
                builder2.scheme = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + string);
            }
            return builder;
        }

        @NotNull
        public final Builder username(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "username");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.encodedUsername = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return builder;
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedUsername");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.encodedUsername = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return builder;
        }

        @NotNull
        public final Builder password(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "password");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.encodedPassword = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return builder;
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedPassword");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.encodedPassword = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return builder;
        }

        @NotNull
        public final Builder host(@NotNull String string) {
            String string2;
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "host");
            Builder builder2 = builder = this;
            boolean bl = false;
            String string3 = HostnamesKt.toCanonicalHost(okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, string, 0, 0, false, 7, null));
            if (string3 == null) {
                throw new IllegalArgumentException("unexpected host: " + string);
            }
            builder2.host = string2 = string3;
            return builder;
        }

        @NotNull
        public final Builder port(int n) {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!(1 <= n ? n < 65536 : false)) {
                boolean bl2 = false;
                String string = "unexpected port: " + n;
                throw new IllegalArgumentException(string.toString());
            }
            builder2.port = n;
            return builder;
        }

        private final int effectivePort() {
            int n;
            if (this.port != -1) {
                n = this.port;
            } else {
                String string = this.scheme;
                Intrinsics.checkNotNull(string);
                n = Companion.defaultPort(string);
            }
            return n;
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "pathSegment");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.push(string, 0, string.length(), false, false);
            return builder;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "pathSegments");
            return this.addPathSegments(string, false);
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedPathSegment");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.push(string, 0, string.length(), false, true);
            return builder;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "encodedPathSegments");
            return this.addPathSegments(string, true);
        }

        private final Builder addPathSegments(String string, boolean bl) {
            int n;
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl2 = false;
            int n2 = 0;
            do {
                boolean bl3 = (n = Util.delimiterOffset(string, "/\\", n2, string.length())) < string.length();
                builder2.push(string, n2, n, bl3, bl);
            } while ((n2 = n + 1) <= string.length());
            return builder;
        }

        @NotNull
        public final Builder setPathSegment(int n, @NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "pathSegment");
            Builder builder2 = builder = this;
            boolean bl = false;
            String string2 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!(!builder2.isDot(string2) && !builder2.isDotDot(string2))) {
                boolean bl2 = false;
                String string3 = "unexpected path segment: " + string;
                throw new IllegalArgumentException(string3.toString());
            }
            builder2.encodedPathSegments.set(n, string2);
            return builder;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int n, @NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedPathSegment");
            Builder builder2 = builder = this;
            boolean bl = false;
            String string2 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            builder2.encodedPathSegments.set(n, string2);
            if (!(!builder2.isDot(string2) && !builder2.isDotDot(string2))) {
                boolean bl2 = false;
                String string3 = "unexpected path segment: " + string;
                throw new IllegalArgumentException(string3.toString());
            }
            return builder;
        }

        @NotNull
        public final Builder removePathSegment(int n) {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.encodedPathSegments.remove(n);
            if (builder2.encodedPathSegments.isEmpty()) {
                builder2.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            return builder;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedPath");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!StringsKt.startsWith$default(string, "/", false, 2, null)) {
                boolean bl2 = false;
                String string2 = "unexpected encodedPath: " + string;
                throw new IllegalArgumentException(string2.toString());
            }
            builder2.resolvePath(string, 0, string.length());
            return builder;
        }

        @NotNull
        public final Builder query(@Nullable String string) {
            String string2;
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.encodedQueryNamesAndValues = string != null && (string2 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null)) != null ? Companion.toQueryNamesAndValues$okhttp(string2) : null;
            return builder;
        }

        @NotNull
        public final Builder encodedQuery(@Nullable String string) {
            String string2;
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.encodedQueryNamesAndValues = string != null && (string2 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null)) != null ? Companion.toQueryNamesAndValues$okhttp(string2) : null;
            return builder;
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String string, @Nullable String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (builder2.encodedQueryNamesAndValues == null) {
                builder2.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = builder2.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            list.add(okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = builder2.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            String string3 = string2;
            list2.add(string3 != null ? okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string3, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return builder;
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String string, @Nullable String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedName");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (builder2.encodedQueryNamesAndValues == null) {
                builder2.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = builder2.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            list.add(okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = builder2.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            String string3 = string2;
            list2.add(string3 != null ? okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string3, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null) : null);
            return builder;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String string, @Nullable String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.removeAllQueryParameters(string);
            builder2.addQueryParameter(string, string2);
            return builder;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String string, @Nullable String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedName");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.removeAllEncodedQueryParameters(string);
            builder2.addEncodedQueryParameter(string, string2);
            return builder;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (builder2.encodedQueryNamesAndValues == null) {
                return builder2;
            }
            String string2 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null);
            builder2.removeAllCanonicalQueryParameters(string2);
            return builder;
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "encodedName");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (builder2.encodedQueryNamesAndValues == null) {
                return builder2;
            }
            builder2.removeAllCanonicalQueryParameters(okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return builder;
        }

        private final void removeAllCanonicalQueryParameters(String string) {
            int n;
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            int n2 = n = list.size() - 2;
            int n3 = ProgressionUtilKt.getProgressionLastElement(n, 0, -2);
            if (n3 <= n2) {
                while (true) {
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list2);
                    if (Intrinsics.areEqual(string, list2.get(n2))) {
                        List<String> list3 = this.encodedQueryNamesAndValues;
                        Intrinsics.checkNotNull(list3);
                        list3.remove(n2 + 1);
                        List<String> list4 = this.encodedQueryNamesAndValues;
                        Intrinsics.checkNotNull(list4);
                        list4.remove(n2);
                        List<String> list5 = this.encodedQueryNamesAndValues;
                        Intrinsics.checkNotNull(list5);
                        if (list5.isEmpty()) {
                            this.encodedQueryNamesAndValues = null;
                            return;
                        }
                    }
                    if (n2 == n3) break;
                    n2 -= 2;
                }
            }
        }

        @NotNull
        public final Builder fragment(@Nullable String string) {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            String string2 = string;
            builder2.encodedFragment = string2 != null ? okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string2, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET, false, false, false, true, null, 187, null) : null;
            return builder;
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String string) {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            String string2 = string;
            builder2.encodedFragment = string2 != null ? okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string2, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET, true, false, false, true, null, 179, null) : null;
            return builder;
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            String string;
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            String string2 = builder2.host;
            if (string2 != null) {
                CharSequence charSequence = string2;
                Regex regex = new Regex("[\"<>^`{|}]");
                String string3 = HttpUrl.FRAGMENT_ENCODE_SET;
                string = regex.replace(charSequence, string3);
            } else {
                string = null;
            }
            builder2.host = string;
            int n = builder2.encodedPathSegments.size();
            for (int i = 0; i < n; ++i) {
                builder2.encodedPathSegments.set(i, okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, builder2.encodedPathSegments.get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list = builder2.encodedQueryNamesAndValues;
            if (list != null) {
                int n2 = list.size();
                for (n = 0; n < n2; ++n) {
                    String string4 = list.get(n);
                    list.set(n, string4 != null ? okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string4, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String string5 = builder2.encodedFragment;
            builder2.encodedFragment = string5 != null ? okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string5, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null) : null;
            return builder;
        }

        @NotNull
        public final HttpUrl build() {
            Collection<String> collection;
            Collection<String> collection2;
            String string;
            String string2 = this.scheme;
            if (string2 == null) {
                throw new IllegalStateException("scheme == null");
            }
            String string3 = this.host;
            if (string3 == null) {
                throw new IllegalStateException("host == null");
            }
            Iterable iterable = this.encodedPathSegments;
            int n = this.effectivePort();
            String string4 = string3;
            String string5 = okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, this.encodedPassword, 0, 0, false, 7, null);
            String string6 = okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, this.encodedUsername, 0, 0, false, 7, null);
            String string7 = string2;
            boolean bl = false;
            Iterable iterable2 = iterable;
            Iterable iterable3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            boolean bl2 = false;
            for (Object object : iterable2) {
                string = (String)object;
                collection2 = iterable3;
                boolean bl3 = false;
                collection2.add(okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, string, 0, 0, false, 7, null));
            }
            collection2 = (List)iterable3;
            String string8 = string7;
            String string9 = string6;
            String string10 = string5;
            String string11 = string4;
            int n2 = n;
            Collection<String> collection3 = collection2;
            List<String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                Collection<String> collection4;
                Object object;
                Iterable iterable4 = list;
                collection2 = collection3;
                n = n2;
                string4 = string11;
                string5 = string10;
                string6 = string9;
                string7 = string8;
                boolean bl4 = false;
                iterable3 = iterable4;
                Collection collection5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable4, 10));
                boolean bl5 = false;
                object = iterable3.iterator();
                while (object.hasNext()) {
                    String string12 = string = object.next();
                    collection4 = collection5;
                    boolean bl6 = false;
                    String string13 = string12;
                    collection4.add(string13 != null ? okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, string13, 0, 0, true, 3, null) : null);
                }
                collection4 = (List)collection5;
                string8 = string7;
                string9 = string6;
                string10 = string5;
                string11 = string4;
                n2 = n;
                collection3 = collection2;
                collection = collection4;
            } else {
                collection = null;
            }
            String string14 = this.encodedFragment;
            String string15 = this.toString();
            String string16 = string14 != null ? okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, string14, 0, 0, false, 7, null) : null;
            Collection<String> collection6 = collection;
            Collection<String> collection7 = collection3;
            int n3 = n2;
            String string17 = string11;
            String string18 = string10;
            String string19 = string9;
            String string20 = string8;
            return new HttpUrl(string20, string19, string18, string17, n3, (List<String>)collection7, (List<String>)collection6, string16, string15);
        }

        @NotNull
        public String toString() {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            block12: {
                int n;
                block13: {
                    stringBuilder = stringBuilder2 = new StringBuilder();
                    boolean bl = false;
                    if (this.scheme != null) {
                        stringBuilder.append(this.scheme);
                        stringBuilder.append("://");
                    } else {
                        stringBuilder.append("//");
                    }
                    if (((CharSequence)this.encodedUsername).length() > 0 || ((CharSequence)this.encodedPassword).length() > 0) {
                        stringBuilder.append(this.encodedUsername);
                        if (((CharSequence)this.encodedPassword).length() > 0) {
                            stringBuilder.append(':');
                            stringBuilder.append(this.encodedPassword);
                        }
                        stringBuilder.append('@');
                    }
                    if (this.host != null) {
                        String string = this.host;
                        Intrinsics.checkNotNull(string);
                        if (StringsKt.contains$default((CharSequence)string, ':', false, 2, null)) {
                            stringBuilder.append('[');
                            stringBuilder.append(this.host);
                            stringBuilder.append(']');
                        } else {
                            stringBuilder.append(this.host);
                        }
                    }
                    if (this.port == -1 && this.scheme == null) break block12;
                    n = this.effectivePort();
                    if (this.scheme == null) break block13;
                    String string = this.scheme;
                    Intrinsics.checkNotNull(string);
                    if (n == Companion.defaultPort(string)) break block12;
                }
                stringBuilder.append(':');
                stringBuilder.append(n);
            }
            Companion.toPathString$okhttp(this.encodedPathSegments, stringBuilder);
            if (this.encodedQueryNamesAndValues != null) {
                stringBuilder.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                Companion.toQueryString$okhttp(list, stringBuilder);
            }
            if (this.encodedFragment != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.encodedFragment);
            }
            String string = stringBuilder2.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        /*
         * Enabled aggressive block sorting
         */
        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl httpUrl, @NotNull String string) {
            int n;
            int n2;
            Intrinsics.checkNotNullParameter(string, "input");
            int n3 = 0;
            n3 = Util.indexOfFirstNonAsciiWhitespace$default(string, 0, 0, 3, null);
            int n4 = Util.indexOfLastNonAsciiWhitespace$default(string, n3, 0, 2, null);
            int n5 = Builder.Companion.schemeDelimiterOffset(string, n3, n4);
            if (n5 != -1) {
                if (StringsKt.startsWith(string, "https:", n3, true)) {
                    this.scheme = "https";
                    n3 += 6;
                } else {
                    if (!StringsKt.startsWith(string, "http:", n3, true)) {
                        StringBuilder stringBuilder = new StringBuilder().append("Expected URL scheme 'http' or 'https' but was '");
                        String string2 = string.substring(0, n5);
                        Intrinsics.checkNotNullExpressionValue(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        throw new IllegalArgumentException(stringBuilder.append(string2).append('\'').toString());
                    }
                    this.scheme = "http";
                    n3 += 5;
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                String string3 = string.length() > 6 ? StringsKt.take(string, 6) + "..." : string;
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + string3);
            }
            boolean bl = false;
            boolean bl2 = false;
            int n6 = Builder.Companion.slashCount(string, n3, n4);
            if (n6 < 2 && httpUrl != null && Intrinsics.areEqual(httpUrl.scheme(), this.scheme)) {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll((Collection<String>)httpUrl.encodedPathSegments());
                if (n3 == n4 || string.charAt(n3) == '#') {
                    this.encodedQuery(httpUrl.encodedQuery());
                }
            } else {
                n3 += n6;
                block4: while (true) {
                    n = (n2 = Util.delimiterOffset(string, "@/\\?#", n3, n4)) != n4 ? (int)string.charAt(n2) : -1;
                    switch (n) {
                        case 64: {
                            int n7;
                            if (!bl2) {
                                n7 = Util.delimiterOffset(string, ':', n3, n2);
                                String string4 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, n3, n7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                String string5 = this.encodedUsername = bl ? this.encodedUsername + "%40" + string4 : string4;
                                if (n7 != n2) {
                                    bl2 = true;
                                    this.encodedPassword = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, n7 + 1, n2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                }
                                bl = true;
                            } else {
                                this.encodedPassword = this.encodedPassword + "%40" + okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, n3, n2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            }
                            n3 = n2 + 1;
                            continue block4;
                        }
                        case -1: 
                        case 35: 
                        case 47: 
                        case 63: 
                        case 92: {
                            int n7 = Builder.Companion.portColonOffset(string, n3, n2);
                            if (n7 + 1 < n2) {
                                this.host = HostnamesKt.toCanonicalHost(okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, string, n3, n7, false, 4, null));
                                this.port = Builder.Companion.parsePort(string, n7 + 1, n2);
                                if (!(this.port != -1)) {
                                    boolean bl3 = false;
                                    StringBuilder stringBuilder = new StringBuilder().append("Invalid URL port: \"");
                                    String string6 = string.substring(n7 + 1, n2);
                                    Intrinsics.checkNotNullExpressionValue(string6, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                    String string7 = stringBuilder.append(string6).append('\"').toString();
                                    throw new IllegalArgumentException(string7.toString());
                                }
                            } else {
                                this.host = HostnamesKt.toCanonicalHost(okhttp3.HttpUrl$Companion.percentDecode$okhttp$default(Companion, string, n3, n7, false, 4, null));
                                String string8 = this.scheme;
                                Intrinsics.checkNotNull(string8);
                                this.port = Companion.defaultPort(string8);
                            }
                            if (!(this.host != null)) {
                                boolean bl4 = false;
                                StringBuilder stringBuilder = new StringBuilder().append("Invalid URL host: \"");
                                String string9 = string.substring(n3, n7);
                                Intrinsics.checkNotNullExpressionValue(string9, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                String string10 = stringBuilder.append(string9).append('\"').toString();
                                throw new IllegalArgumentException(string10.toString());
                            }
                            n3 = n2;
                            break block4;
                        }
                        default: {
                            continue block4;
                        }
                    }
                    break;
                }
            }
            n2 = Util.delimiterOffset(string, "?#", n3, n4);
            this.resolvePath(string, n3, n2);
            n3 = n2;
            if (n3 < n4 && string.charAt(n3) == '?') {
                n = Util.delimiterOffset(string, '#', n3, n4);
                this.encodedQueryNamesAndValues = Companion.toQueryNamesAndValues$okhttp(okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, n3 + 1, n, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                n3 = n;
            }
            if (n3 < n4 && string.charAt(n3) == '#') {
                this.encodedFragment = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, n3 + 1, n4, HttpUrl.FRAGMENT_ENCODE_SET, true, false, false, true, null, 176, null);
            }
            return this;
        }

        private final void resolvePath(String string, int n, int n2) {
            int n3 = n;
            if (n3 == n2) {
                return;
            }
            char c = string.charAt(n3);
            if (c == '/' || c == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
                ++n3;
            } else {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, HttpUrl.FRAGMENT_ENCODE_SET);
            }
            int n4 = n3;
            while (n4 < n2) {
                int n5 = Util.delimiterOffset(string, "/\\", n4, n2);
                boolean bl = n5 < n2;
                this.push(string, n4, n5, bl, true);
                n4 = n5;
                if (!bl) continue;
                ++n4;
            }
        }

        private final void push(String string, int n, int n2, boolean bl, boolean bl2) {
            String string2 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(Companion, string, n, n2, HttpUrl.PATH_SEGMENT_ENCODE_SET, bl2, false, false, false, null, 240, null);
            if (this.isDot(string2)) {
                return;
            }
            if (this.isDotDot(string2)) {
                this.pop();
                return;
            }
            if (((CharSequence)this.encodedPathSegments.get(this.encodedPathSegments.size() - 1)).length() == 0) {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, string2);
            } else {
                this.encodedPathSegments.add(string2);
            }
            if (bl) {
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }

        private final boolean isDot(String string) {
            return Intrinsics.areEqual(string, ".") || StringsKt.equals(string, "%2e", true);
        }

        private final boolean isDotDot(String string) {
            return Intrinsics.areEqual(string, "..") || StringsKt.equals(string, "%2e.", true) || StringsKt.equals(string, ".%2e", true) || StringsKt.equals(string, "%2e%2e", true);
        }

        private final void pop() {
            String string = this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1);
            if (((CharSequence)string).length() == 0 && !((Collection)this.encodedPathSegments).isEmpty()) {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, HttpUrl.FRAGMENT_ENCODE_SET);
            } else {
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"})
        public static final class Companion {
            private Companion() {
            }

            private final int schemeDelimiterOffset(String string, int n, int n2) {
                if (n2 - n < 2) {
                    return -1;
                }
                char c = string.charAt(n);
                if (!(Intrinsics.compare(c, 97) >= 0 && Intrinsics.compare(c, 122) <= 0 || Intrinsics.compare(c, 65) >= 0 && Intrinsics.compare(c, 90) <= 0)) {
                    return -1;
                }
                for (int i = n + 1; i < n2; ++i) {
                    char c2 = string.charAt(i);
                    if (((((('a' <= c2 ? c2 < '{' : false) ? true : ('A' <= c2 ? c2 < '[' : false)) ? true : ('0' <= c2 ? c2 < ':' : false)) ? true : c2 == '+') ? true : c2 == '-') ? true : c2 == '.') continue;
                    return c2 == ':' ? i : -1;
                }
                return -1;
            }

            private final int slashCount(String string, int n, int n2) {
                char c;
                int n3 = 0;
                for (int i = n; i < n2 && ((c = string.charAt(i)) == '\\' || c == '/'); ++i) {
                    ++n3;
                }
                return n3;
            }

            private final int portColonOffset(String string, int n, int n2) {
                for (int i = n; i < n2; ++i) {
                    char c = string.charAt(i);
                    if (c == '[') {
                        while (++i < n2 && string.charAt(i) != ']') {
                        }
                        continue;
                    }
                    if (c != ':') continue;
                    return i;
                }
                return n2;
            }

            private final int parsePort(String string, int n, int n2) {
                int n3;
                try {
                    String string2 = okhttp3.HttpUrl$Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, n, n2, HttpUrl.FRAGMENT_ENCODE_SET, false, false, false, false, null, 248, null);
                    int n4 = Integer.parseInt(string2);
                    n3 = (1 <= n4 ? n4 < 65536 : false) ? n4 : -1;
                }
                catch (NumberFormatException numberFormatException) {
                    n3 = -1;
                }
                return n3;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a2\u0006\u0002\b\u0018J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u00a2\u0006\u0002\b\u0018J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u001cJa\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000\u00a2\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\"*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J/\u0010*\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\"H\u0000\u00a2\u0006\u0002\b+J\u0011\u0010,\u001a\u00020\u0015*\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u001aH\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u001bJ#\u0010.\u001a\u00020/*\b\u0012\u0004\u0012\u00020\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000\u00a2\u0006\u0002\b4J\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000406*\u00020\u0004H\u0000\u00a2\u0006\u0002\b7J%\u00108\u001a\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000\u00a2\u0006\u0002\b9JV\u0010:\u001a\u00020/*\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J,\u0010=\u001a\u00020/*\u00020;2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2={"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", "scheme", "get", "Lokhttp3/HttpUrl;", "uri", "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", "pos", "limit", "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final int defaultPort(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "scheme");
            String string2 = string;
            return Intrinsics.areEqual(string2, "http") ? 80 : (Intrinsics.areEqual(string2, "https") ? 443 : -1);
        }

        public final void toPathString$okhttp(@NotNull List<String> list, @NotNull StringBuilder stringBuilder) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(stringBuilder, "out");
            int n = list.size();
            for (int i = 0; i < n; ++i) {
                stringBuilder.append('/');
                stringBuilder.append(list.get(i));
            }
        }

        public final void toQueryString$okhttp(@NotNull List<String> list, @NotNull StringBuilder stringBuilder) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(stringBuilder, "out");
            IntProgression intProgression = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int n = intProgression.getFirst();
            int n2 = intProgression.getLast();
            int n3 = intProgression.getStep();
            if (n3 > 0 && n <= n2 || n3 < 0 && n2 <= n) {
                while (true) {
                    String string = list.get(n);
                    String string2 = list.get(n + 1);
                    if (n > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append(string);
                    if (string2 != null) {
                        stringBuilder.append('=');
                        stringBuilder.append(string2);
                    }
                    if (n == n2) break;
                    n += n3;
                }
            }
        }

        @NotNull
        public final List<String> toQueryNamesAndValues$okhttp(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<this>");
            List list = new ArrayList();
            int n = 0;
            while (n <= string.length()) {
                int n2;
                int n3 = StringsKt.indexOf$default((CharSequence)string, '&', n, false, 4, null);
                if (n3 == -1) {
                    n3 = string.length();
                }
                if ((n2 = StringsKt.indexOf$default((CharSequence)string, '=', n, false, 4, null)) == -1 || n2 > n3) {
                    String string2 = string.substring(n, n3);
                    Intrinsics.checkNotNullExpressionValue(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    list.add(string2);
                    list.add(null);
                } else {
                    String string3 = string.substring(n, n2);
                    Intrinsics.checkNotNullExpressionValue(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    list.add(string3);
                    String string4 = string.substring(n2 + 1, n3);
                    Intrinsics.checkNotNullExpressionValue(string4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    list.add(string4);
                }
                n = n3 + 1;
            }
            return list;
        }

        @JvmStatic
        @JvmName(name="get")
        @NotNull
        public final HttpUrl get(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<this>");
            return new Builder().parse$okhttp(null, string).build();
        }

        @JvmStatic
        @JvmName(name="parse")
        @Nullable
        public final HttpUrl parse(@NotNull String string) {
            HttpUrl httpUrl;
            Intrinsics.checkNotNullParameter(string, "<this>");
            try {
                httpUrl = this.get(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                httpUrl = null;
            }
            return httpUrl;
        }

        @JvmStatic
        @JvmName(name="get")
        @Nullable
        public final HttpUrl get(@NotNull URL uRL) {
            Intrinsics.checkNotNullParameter(uRL, "<this>");
            String string = uRL.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString()");
            return this.parse(string);
        }

        @JvmStatic
        @JvmName(name="get")
        @Nullable
        public final HttpUrl get(@NotNull URI uRI) {
            Intrinsics.checkNotNullParameter(uRI, "<this>");
            String string = uRI.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString()");
            return this.parse(string);
        }

        @Deprecated(message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrl()", imports={"okhttp3.HttpUrl.Companion.toHttpUrl"}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_get")
        @NotNull
        public final HttpUrl mb208bec41b(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "url");
            return this.get(string);
        }

        @Deprecated(message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_parse")
        @Nullable
        public final HttpUrl m9c32784aca(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "url");
            return this.parse(string);
        }

        @Deprecated(message="moved to extension function", replaceWith=@ReplaceWith(expression="url.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_get")
        @Nullable
        public final HttpUrl m921a3595ee(@NotNull URL uRL) {
            Intrinsics.checkNotNullParameter(uRL, "url");
            return this.get(uRL);
        }

        @Deprecated(message="moved to extension function", replaceWith=@ReplaceWith(expression="uri.toHttpUrlOrNull()", imports={"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_get")
        @Nullable
        public final HttpUrl m180bb46639(@NotNull URI uRI) {
            Intrinsics.checkNotNullParameter(uRI, "uri");
            return this.get(uRI);
        }

        @NotNull
        public final String percentDecode$okhttp(@NotNull String string, int n, int n2, boolean bl) {
            Intrinsics.checkNotNullParameter(string, "<this>");
            for (int i = n; i < n2; ++i) {
                char c = string.charAt(i);
                if (c != '%' && (c != '+' || !bl)) continue;
                Buffer buffer = new Buffer();
                buffer.writeUtf8(string, n, i);
                this.writePercentDecoded(buffer, string, i, n2, bl);
                return buffer.readUtf8();
            }
            String string2 = string.substring(n, n2);
            Intrinsics.checkNotNullExpressionValue(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return string2;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String string, int n, int n2, boolean bl, int n3, Object object) {
            if ((n3 & 1) != 0) {
                n = 0;
            }
            if ((n3 & 2) != 0) {
                n2 = string.length();
            }
            if ((n3 & 4) != 0) {
                bl = false;
            }
            return companion.percentDecode$okhttp(string, n, n2, bl);
        }

        private final void writePercentDecoded(Buffer buffer, String string, int n, int n2, boolean bl) {
            int n3 = 0;
            int n4 = n;
            while (n4 < n2) {
                n3 = string.codePointAt(n4);
                if (n3 == 37 && n4 + 2 < n2) {
                    int n5 = Util.parseHexDigit(string.charAt(n4 + 1));
                    int n6 = Util.parseHexDigit(string.charAt(n4 + 2));
                    if (n5 != -1 && n6 != -1) {
                        buffer.writeByte((n5 << 4) + n6);
                        n4 += 2;
                        n4 += Character.charCount(n3);
                        continue;
                    }
                } else if (n3 == 43 && bl) {
                    buffer.writeByte(32);
                    ++n4;
                    continue;
                }
                buffer.writeUtf8CodePoint(n3);
                n4 += Character.charCount(n3);
            }
        }

        private final boolean isPercentEncoded(String string, int n, int n2) {
            return n + 2 < n2 && string.charAt(n) == '%' && Util.parseHexDigit(string.charAt(n + 1)) != -1 && Util.parseHexDigit(string.charAt(n + 2)) != -1;
        }

        @NotNull
        public final String canonicalize$okhttp(@NotNull String string, int n, int n2, @NotNull String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, @Nullable Charset charset) {
            Intrinsics.checkNotNullParameter(string, "<this>");
            Intrinsics.checkNotNullParameter(string2, "encodeSet");
            int n3 = 0;
            for (int i = n; i < n2; i += Character.charCount(n3)) {
                n3 = string.codePointAt(i);
                if (!(n3 < 32 || n3 == 127 || n3 >= 128 && !bl4 || StringsKt.contains$default((CharSequence)string2, (char)n3, false, 2, null) || n3 == 37 && (!bl || bl2 && !this.isPercentEncoded(string, i, n2))) && (n3 != 43 || !bl3)) continue;
                Buffer buffer = new Buffer();
                buffer.writeUtf8(string, n, i);
                this.writeCanonicalized(buffer, string, i, n2, string2, bl, bl2, bl3, bl4, charset);
                return buffer.readUtf8();
            }
            String string3 = string.substring(n, n2);
            Intrinsics.checkNotNullExpressionValue(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return string3;
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String string, int n, int n2, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset, int n3, Object object) {
            if ((n3 & 1) != 0) {
                n = 0;
            }
            if ((n3 & 2) != 0) {
                n2 = string.length();
            }
            if ((n3 & 8) != 0) {
                bl = false;
            }
            if ((n3 & 0x10) != 0) {
                bl2 = false;
            }
            if ((n3 & 0x20) != 0) {
                bl3 = false;
            }
            if ((n3 & 0x40) != 0) {
                bl4 = false;
            }
            if ((n3 & 0x80) != 0) {
                charset = null;
            }
            return companion.canonicalize$okhttp(string, n, n2, string2, bl, bl2, bl3, bl4, charset);
        }

        private final void writeCanonicalized(Buffer buffer, String string, int n, int n2, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset) {
            Buffer buffer2 = null;
            int n3 = 0;
            for (int i = n; i < n2; i += Character.charCount(n3)) {
                n3 = string.codePointAt(i);
                if (bl && (n3 == 9 || n3 == 10 || n3 == 12 || n3 == 13)) continue;
                if (n3 == 43 && bl3) {
                    buffer.writeUtf8(bl ? "+" : "%2B");
                    continue;
                }
                if (n3 < 32 || n3 == 127 || n3 >= 128 && !bl4 || StringsKt.contains$default((CharSequence)string2, (char)n3, false, 2, null) || n3 == 37 && (!bl || bl2 && !this.isPercentEncoded(string, i, n2))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || Intrinsics.areEqual(charset, StandardCharsets.UTF_8)) {
                        buffer2.writeUtf8CodePoint(n3);
                    } else {
                        buffer2.writeString(string, i, i + Character.charCount(n3), charset);
                    }
                    while (!buffer2.exhausted()) {
                        int n4 = buffer2.readByte() & 0xFF;
                        buffer.writeByte(37);
                        buffer.writeByte(HEX_DIGITS[n4 >> 4 & 0xF]);
                        buffer.writeByte(HEX_DIGITS[n4 & 0xF]);
                    }
                    continue;
                }
                buffer.writeUtf8CodePoint(n3);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

