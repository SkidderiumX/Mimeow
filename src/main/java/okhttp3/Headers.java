/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0096\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\n\u00a8\u0006("}, d2={"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "size", "", "()I", "byteCount", "", "equals", "", "other", "", "get", "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", "value", "values", "Builder", "Companion", "okhttp"})
public class Headers
implements Iterable<Pair<? extends String, ? extends String>>,
KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String[] namesAndValues;

    private Headers(String[] stringArray) {
        this.namesAndValues = stringArray;
    }

    @Nullable
    public final String get(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "name");
        return Headers.Companion.get(this.namesAndValues, string);
    }

    @Nullable
    public final Date getDate(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "name");
        String string2 = this.get(string);
        return string2 != null ? DatesKt.toHttpDateOrNull(string2) : null;
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String string) {
        Date date;
        Intrinsics.checkNotNullParameter(string, "name");
        Date date2 = date = this.getDate(string);
        return date2 != null ? date2.toInstant() : null;
    }

    @JvmName(name="size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_size")
    public final int m3bc94960dd() {
        return this.size();
    }

    @NotNull
    public final String name(int n) {
        return this.namesAndValues[n * 2];
    }

    @NotNull
    public final String value(int n) {
        return this.namesAndValues[n * 2 + 1];
    }

    @NotNull
    public final Set<String> names() {
        TreeSet<String> treeSet = new TreeSet<String>(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            treeSet.add(this.name(i));
        }
        Set<String> set = Collections.unmodifiableSet((Set)treeSet);
        Intrinsics.checkNotNullExpressionValue(set, "unmodifiableSet(result)");
        return set;
    }

    @NotNull
    public final List<String> values(@NotNull String string) {
        List<String> list;
        Intrinsics.checkNotNullParameter(string, "name");
        List list2 = null;
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            if (!StringsKt.equals(string, this.name(i), true)) continue;
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            list2.add(this.value(i));
        }
        if (list2 != null) {
            List list3 = Collections.unmodifiableList(list2);
            list = list3;
            Intrinsics.checkNotNullExpressionValue(list3, "{\n      Collections.unmodifiableList(result)\n    }");
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public final long byteCount() {
        long l = this.namesAndValues.length * 2;
        int n = this.namesAndValues.length;
        for (int i = 0; i < n; ++i) {
            l += (long)this.namesAndValues[i].length();
        }
        return l;
    }

    @Override
    @NotNull
    public Iterator<Pair<String, String>> iterator() {
        int n = 0;
        int n2 = this.size();
        Pair[] pairArray = new Pair[n2];
        while (n < n2) {
            int n3 = n++;
            pairArray[n3] = TuplesKt.mcc4e6a6012(this.name(n3), this.value(n3));
        }
        return ArrayIteratorKt.iterator(pairArray);
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        CollectionsKt.addAll((Collection)builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof Headers && Arrays.equals(this.namesAndValues, ((Headers)object).namesAndValues);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
        boolean bl = false;
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            String string = this.name(i);
            String string2 = this.value(i);
            stringBuilder2.append(string);
            stringBuilder2.append(": ");
            stringBuilder2.append(Util.isSensitiveHeader(string) ? "\u2588\u2588" : string2);
            stringBuilder2.append("\n");
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            String string;
            Object object = this.name(i);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            Intrinsics.checkNotNullExpressionValue(((String)object).toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
            object = (List)treeMap.get(string);
            if (object == null) {
                object = new ArrayList(2);
                ((Map)treeMap).put(string, object);
            }
            object.add(this.value(i));
        }
        return treeMap;
    }

    @JvmStatic
    @JvmName(name="of")
    @NotNull
    public static final Headers of(String ... stringArray) {
        return Companion.of(stringArray);
    }

    @JvmStatic
    @JvmName(name="of")
    @NotNull
    public static final Headers of(@NotNull Map<String, String> map) {
        return Companion.of(map);
    }

    public /* synthetic */ Headers(String[] stringArray, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringArray);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2={"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", "get", "removeAll", "set", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,458:1\n1#2:459\n37#3,2:460\n*S KotlinDebug\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n*L\n359#1:460,2\n*E\n"})
    public static final class Builder {
        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "line");
            Builder builder2 = builder = this;
            boolean bl = false;
            int n = StringsKt.indexOf$default((CharSequence)string, ':', 1, false, 4, null);
            if (n != -1) {
                String string2 = string.substring(0, n);
                Intrinsics.checkNotNullExpressionValue(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String string3 = string.substring(n + 1);
                Intrinsics.checkNotNullExpressionValue(string3, "this as java.lang.String).substring(startIndex)");
                builder2.addLenient$okhttp(string2, string3);
            } else if (string.charAt(0) == ':') {
                String string4 = string.substring(1);
                Intrinsics.checkNotNullExpressionValue(string4, "this as java.lang.String).substring(startIndex)");
                builder2.addLenient$okhttp("", string4);
            } else {
                builder2.addLenient$okhttp("", string);
            }
            return builder;
        }

        @NotNull
        public final Builder add(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "line");
            Builder builder2 = builder = this;
            boolean bl = false;
            int n = StringsKt.indexOf$default((CharSequence)string, ':', 0, false, 6, null);
            if (!(n != -1)) {
                boolean bl2 = false;
                String string2 = "Unexpected header: " + string;
                throw new IllegalArgumentException(string2.toString());
            }
            String string3 = string.substring(0, n);
            Intrinsics.checkNotNullExpressionValue(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String string4 = ((Object)StringsKt.trim((CharSequence)string3)).toString();
            String string5 = string.substring(n + 1);
            Intrinsics.checkNotNullExpressionValue(string5, "this as java.lang.String).substring(startIndex)");
            builder2.add(string4, string5);
            return builder;
        }

        @NotNull
        public final Builder add(@NotNull String string, @NotNull String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(string2, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            Companion.checkName(string);
            Companion.checkValue(string2, string);
            builder2.addLenient$okhttp(string, string2);
            return builder;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String string, @NotNull String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(string2, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            Companion.checkName(string);
            builder2.addLenient$okhttp(string, string2);
            return builder;
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            Builder builder;
            Intrinsics.checkNotNullParameter(headers, "headers");
            Builder builder2 = builder = this;
            boolean bl = false;
            int n = headers.size();
            for (int i = 0; i < n; ++i) {
                builder2.addLenient$okhttp(headers.name(i), headers.value(i));
            }
            return builder;
        }

        @NotNull
        public final Builder add(@NotNull String string, @NotNull Date date) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(date, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.add(string, DatesKt.toHttpDateString(date));
            return builder;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String string, @NotNull Instant instant) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(instant, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.add(string, new Date(instant.toEpochMilli()));
            return builder;
        }

        @NotNull
        public final Builder set(@NotNull String string, @NotNull Date date) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(date, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.set(string, DatesKt.toHttpDateString(date));
            return builder;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String string, @NotNull Instant instant) {
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(instant, "value");
            Builder builder = this;
            boolean bl = false;
            return builder.set(string, new Date(instant.toEpochMilli()));
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String string, @NotNull String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(string2, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.namesAndValues.add(string);
            builder2.namesAndValues.add(((Object)StringsKt.trim((CharSequence)string2)).toString());
            return builder;
        }

        @NotNull
        public final Builder removeAll(@NotNull String string) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Builder builder2 = builder = this;
            boolean bl = false;
            for (int i = 0; i < builder2.namesAndValues.size(); i += 2) {
                if (!StringsKt.equals(string, builder2.namesAndValues.get(i), true)) continue;
                builder2.namesAndValues.remove(i);
                builder2.namesAndValues.remove(i);
                i -= 2;
            }
            return builder;
        }

        @NotNull
        public final Builder set(@NotNull String string, @NotNull String string2) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "name");
            Intrinsics.checkNotNullParameter(string2, "value");
            Builder builder2 = builder = this;
            boolean bl = false;
            Companion.checkName(string);
            Companion.checkValue(string2, string);
            builder2.removeAll(string);
            builder2.addLenient$okhttp(string, string2);
            return builder;
        }

        @Nullable
        public final String get(@NotNull String string) {
            int n;
            Intrinsics.checkNotNullParameter(string, "name");
            int n2 = n = this.namesAndValues.size() - 2;
            int n3 = ProgressionUtilKt.getProgressionLastElement(n, 0, -2);
            if (n3 <= n2) {
                while (true) {
                    if (StringsKt.equals(string, this.namesAndValues.get(n2), true)) {
                        return this.namesAndValues.get(n2 + 1);
                    }
                    if (n2 == n3) break;
                    n2 -= 2;
                }
            }
            return null;
        }

        @NotNull
        public final Headers build() {
            Collection collection = this.namesAndValues;
            boolean bl = false;
            Collection collection2 = collection;
            return new Headers(collection2.toArray(new String[0]), null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007\u00a2\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007\u00a2\u0006\u0002\b\u000f\u00a8\u0006\u0015"}, d2={"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", "get", "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        private final String get(String[] stringArray, String string) {
            int n;
            int n2 = n = stringArray.length - 2;
            int n3 = ProgressionUtilKt.getProgressionLastElement(n, 0, -2);
            if (n3 <= n2) {
                while (true) {
                    if (StringsKt.equals(string, stringArray[n2], true)) {
                        return stringArray[n2 + 1];
                    }
                    if (n2 == n3) break;
                    n2 -= 2;
                }
            }
            return null;
        }

        @JvmStatic
        @JvmName(name="of")
        @NotNull
        public final Headers of(String ... stringArray) {
            int n;
            Intrinsics.checkNotNullParameter(stringArray, "namesAndValues");
            if (!(stringArray.length % 2 == 0)) {
                boolean bl = false;
                String string = "Expected alternating header names and values";
                throw new IllegalArgumentException(string.toString());
            }
            String[] stringArray2 = (String[])stringArray.clone();
            int n2 = stringArray2.length;
            for (n = 0; n < n2; ++n) {
                if (!(stringArray2[n] != null)) {
                    boolean bl = false;
                    String string = "Headers cannot be null";
                    throw new IllegalArgumentException(string.toString());
                }
                stringArray2[n] = ((Object)StringsKt.trim((CharSequence)stringArray2[n])).toString();
            }
            n2 = 0;
            n = stringArray2.length + -1;
            int n3 = ProgressionUtilKt.getProgressionLastElement(0, n, 2);
            if (n2 <= n3) {
                while (true) {
                    String string = stringArray2[n2];
                    String string2 = stringArray2[n2 + 1];
                    this.checkName(string);
                    this.checkValue(string2, string);
                    if (n2 == n3) break;
                    n2 += 2;
                }
            }
            return new Headers(stringArray2, null);
        }

        @kotlin.Deprecated(message="function name changed", replaceWith=@ReplaceWith(expression="headersOf(*namesAndValues)", imports={}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_of")
        @NotNull
        public final Headers m0760342908(String ... stringArray) {
            Intrinsics.checkNotNullParameter(stringArray, "namesAndValues");
            return this.of(Arrays.copyOf(stringArray, stringArray.length));
        }

        @JvmStatic
        @JvmName(name="of")
        @NotNull
        public final Headers of(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            String[] stringArray = new String[map.size() * 2];
            int n = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String string = entry.getKey();
                String string2 = entry.getValue();
                String string3 = ((Object)StringsKt.trim((CharSequence)string)).toString();
                String string4 = ((Object)StringsKt.trim((CharSequence)string2)).toString();
                this.checkName(string3);
                this.checkValue(string4, string3);
                stringArray[n] = string3;
                stringArray[n + 1] = string4;
                n += 2;
            }
            return new Headers(stringArray, null);
        }

        @kotlin.Deprecated(message="function moved to extension", replaceWith=@ReplaceWith(expression="headers.toHeaders()", imports={}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_of")
        @NotNull
        public final Headers m8d2cf2e3fc(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "headers");
            return this.of(map);
        }

        private final void checkName(String string) {
            if (!(((CharSequence)string).length() > 0)) {
                boolean bl = false;
                String string2 = "name is empty";
                throw new IllegalArgumentException(string2.toString());
            }
            int n = string.length();
            for (int i = 0; i < n; ++i) {
                char c = string.charAt(i);
                if ('!' <= c ? c < '\u007f' : false) continue;
                boolean bl = false;
                Object[] objectArray = new Object[]{(int)c, i, string};
                String string3 = Util.format("Unexpected char %#04x at %d in header name: %s", objectArray);
                throw new IllegalArgumentException(string3.toString());
            }
        }

        /*
         * Unable to fully structure code
         */
        private final void checkValue(String value, String name) {
            for (int i = 0; i < value.length(); ++i) {
                char c = value.charAt(i);
                if (c == '\t' || (' ' <= c && c < '\u007f')) {
                    continue;
                }
                String message = Util.format("Unexpected char %#04x at %d in %s value", (int) c, i, name)
                    + (Util.isSensitiveHeader(name) ? "" : ": " + value);
                throw new IllegalArgumentException(message);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

