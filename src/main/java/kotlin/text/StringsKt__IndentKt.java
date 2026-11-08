package kotlin.text;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.internal.*;
import kotlin.jvm.functions.*;
import java.util.*;
import kotlin.collections.*;
import kotlin.sequences.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 49, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015" }, d2 = { "getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({ "SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,123:1\n113#1,2:125\n115#1,4:140\n120#1,2:153\n113#1,2:162\n115#1,4:177\n120#1,2:184\n1#2:124\n1#2:150\n1#2:181\n1#2:205\n1569#3,11:127\n1864#3,2:138\n1866#3:151\n1580#3:152\n766#3:155\n857#3,2:156\n1549#3:158\n1620#3,3:159\n1569#3,11:164\n1864#3,2:175\n1866#3:182\n1580#3:183\n1569#3,11:192\n1864#3,2:203\n1866#3:206\n1580#3:207\n151#4,6:144\n151#4,6:186\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n38#1:125,2\n38#1:140,4\n38#1:153,2\n78#1:162,2\n78#1:177,4\n78#1:184,2\n38#1:150\n78#1:181\n114#1:205\n38#1:127,11\n38#1:138,2\n38#1:151\n38#1:152\n74#1:155\n74#1:156,2\n75#1:158\n75#1:159,3\n78#1:164,11\n78#1:175,2\n78#1:182\n78#1:183\n114#1:192,11\n114#1:203,2\n114#1:206\n114#1:207\n39#1:144,6\n101#1:186,6\n*E\n" })
public class StringsKt__IndentKt extends StringsKt__AppendableKt
{
    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimMargin(@NotNull final String s, @NotNull final String s2) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        Intrinsics.checkNotNullParameter(s2, "marginPrefix");
        return replaceIndentByMargin(s, "", s2);
    }
    
    @NotNull
    public static final String replaceIndentByMargin(@NotNull final String s, @NotNull final String s2, @NotNull final String s3) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        Intrinsics.checkNotNullParameter(s2, "newIndent");
        Intrinsics.checkNotNullParameter(s3, "marginPrefix");
        if (StringsKt__StringsJVMKt.isBlank(s3)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        final List<String> lines;
        final int capacity = s.length() + s2.length() * (lines = StringsKt__StringsKt.lines(s)).size();
        final Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(s2);
        final int lastIndex = CollectionsKt__CollectionsKt.getLastIndex((List<?>)lines);
        final Iterable iterable = lines;
        final Collection collection = new ArrayList();
        final Iterable iterable2 = iterable;
        int n = 0;
        for (final Object next : iterable2) {
            final int n2 = n++;
            if (n2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final int n3 = n2;
            final String s4 = (String)next;
            final int n4 = n3;
            final String s5 = s4;
            final int n5 = n4;
            String s10 = null;
            String s9 = null;
            Label_0405: {
                if ((n5 != 0 && n5 != lastIndex) || !StringsKt__StringsJVMKt.isBlank(s5)) {
                    final String s6 = s5;
                    final CharSequence charSequence = s6;
                    int i = 0;
                    while (true) {
                        while (i < charSequence.length()) {
                            if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                                final int n6 = i;
                                final int n7 = n6;
                                String s7;
                                String substring;
                                if (n7 == -1) {
                                    substring = (s7 = null);
                                }
                                else if (StringsKt__StringsJVMKt.startsWith$default(s6, s3, n7, false, 4, null)) {
                                    final String s8 = s6;
                                    final int beginIndex = n7 + s3.length();
                                    Intrinsics.checkNotNull(s8, "null cannot be cast to non-null type java.lang.String");
                                    Intrinsics.checkNotNullExpressionValue(s7 = (substring = s8.substring(beginIndex)), "this as java.lang.String).substring(startIndex)");
                                }
                                else {
                                    substring = (s7 = null);
                                }
                                if (s7 == null || (s9 = (s10 = indentFunction$StringsKt__IndentKt.invoke(substring))) == null) {
                                    s10 = (s9 = s5);
                                }
                                break Label_0405;
                            }
                            else {
                                ++i;
                            }
                        }
                        final int n6 = -1;
                        continue;
                    }
                }
                s10 = (s9 = null);
            }
            if (s9 != null) {
                collection.add(s10);
            }
        }
        final String string = ((StringBuilder)CollectionsKt___CollectionsKt.joinTo$default(collection, new StringBuilder(capacity), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string;
    }
    
    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimIndent(@NotNull final String s) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        return replaceIndent(s, "");
    }
    
    @NotNull
    public static final String replaceIndent(@NotNull final String s, @NotNull final String s2) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        Intrinsics.checkNotNullParameter(s2, "newIndent");
        final List<String> lines = StringsKt__StringsKt.lines(s);
        final Iterable iterable = lines;
        final Collection collection = new ArrayList();
        for (final Object next : iterable) {
            if (!StringsKt__StringsJVMKt.isBlank((CharSequence)next)) {
                collection.add(next);
            }
        }
        final Iterable iterable2;
        final Collection collection2 = new ArrayList<Integer>(CollectionsKt__IterablesKt.collectionSizeOrDefault((Iterable<?>)(iterable2 = collection), 10));
        final Iterator iterator2 = iterable2.iterator();
        while (iterator2.hasNext()) {
            collection2.add(indentWidth$StringsKt__IndentKt((String)iterator2.next()));
        }
        final Integer n = CollectionsKt___CollectionsKt.minOrNull((Iterable<? extends Integer>)(List<? extends T>)collection2);
        final int n2 = (n != null) ? n : 0;
        final List<String> list = lines;
        final int capacity = s.length() + s2.length() * lines.size();
        final Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(s2);
        final int lastIndex = CollectionsKt__CollectionsKt.getLastIndex((List<?>)list);
        final Iterable iterable3 = list;
        final Collection collection3 = new ArrayList();
        final Iterable iterable4 = iterable3;
        int n3 = 0;
        for (final Object next2 : iterable4) {
            final int n4 = n3++;
            if (n4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final int n5 = n4;
            final String s3 = (String)next2;
            final int n6 = n5;
            final String s4 = s3;
            final int n7 = n6;
            String s6;
            String s5;
            if ((n7 == 0 || n7 == lastIndex) && StringsKt__StringsJVMKt.isBlank(s4)) {
                s5 = (s6 = null);
            }
            else {
                final String drop = StringsKt___StringsKt.drop(s4, n2);
                if (drop == null || (s6 = (s5 = indentFunction$StringsKt__IndentKt.invoke(drop))) == null) {
                    s5 = (s6 = s4);
                }
            }
            if (s6 != null) {
                collection3.add(s5);
            }
        }
        final String string = ((StringBuilder)CollectionsKt___CollectionsKt.joinTo$default(collection3, new StringBuilder(capacity), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string;
    }
    
    @NotNull
    public static final String prependIndent(@NotNull final String s, @NotNull final String s2) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        Intrinsics.checkNotNullParameter(s2, "indent");
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.map((Sequence<?>)StringsKt__StringsKt.lineSequence(s), (Function1<? super Object, ?>)new StringsKt__IndentKt$prependIndent.StringsKt__IndentKt$prependIndent$1(s2)), "\n", null, null, 0, null, null, 62, null);
    }
    
    private static final int indentWidth$StringsKt__IndentKt(final String s) {
        final CharSequence charSequence = s;
        while (true) {
            for (int i = 0; i < charSequence.length(); ++i) {
                if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                    final int n = i;
                    final int n2 = n;
                    return (n2 == -1) ? s.length() : n2;
                }
            }
            final int n = -1;
            continue;
        }
    }
    
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String s) {
        return (Function1<String, String>)((s.length() == 0) ? StringsKt__IndentKt$getIndentFunction.StringsKt__IndentKt$getIndentFunction$1.INSTANCE : ((Function1)new StringsKt__IndentKt$getIndentFunction.StringsKt__IndentKt$getIndentFunction$2(s)));
    }
    
    private static final String reindent$StringsKt__IndentKt(final List<String> list, final int capacity, final Function1<? super String, String> function1, final Function1<? super String, String> function2) {
        final int lastIndex = CollectionsKt__CollectionsKt.getLastIndex((List<?>)list);
        final Iterable iterable = list;
        final Collection collection = new ArrayList();
        final Iterable iterable2 = iterable;
        int n = 0;
        for (final Object next : iterable2) {
            final int n2 = n++;
            if (n2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final int n3 = n2;
            final String s = (String)next;
            final int n4 = n3;
            final String s2 = s;
            final int n5 = n4;
            String s4;
            String s3;
            if ((n5 == 0 || n5 == lastIndex) && StringsKt__StringsJVMKt.isBlank(s2)) {
                s3 = (s4 = null);
            }
            else {
                final String s5 = function2.invoke(s2);
                if (s5 == null || (s4 = (s3 = function1.invoke(s5))) == null) {
                    s3 = (s4 = s2);
                }
            }
            if (s4 != null) {
                collection.add(s3);
            }
        }
        final String string = ((StringBuilder)CollectionsKt___CollectionsKt.joinTo$default(collection, new StringBuilder(capacity), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string;
    }
}
