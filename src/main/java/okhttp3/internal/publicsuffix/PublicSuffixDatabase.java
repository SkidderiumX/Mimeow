/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.publicsuffix;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"})
public class PublicSuffixDatabase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    @NotNull
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);
    private byte[] publicSuffixListBytes;
    private byte[] publicSuffixExceptionListBytes;
    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    @NotNull
    private static final byte[] WILDCARD_LABEL;
    @NotNull
    private static final List<String> PREVAILING_RULE;
    private static final char EXCEPTION_MARKER = '!';
    @NotNull
    private static final PublicSuffixDatabase instance;

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "domain");
        String string2 = IDN.toUnicode(string);
        Intrinsics.checkNotNullExpressionValue(string2, "unicodeDomain");
        List<String> list = this.splitDomain(string2);
        List<String> list2 = this.findMatchingRule(list);
        if (list.size() == list2.size() && list2.get(0).charAt(0) != '!') {
            return null;
        }
        int n = list2.get(0).charAt(0) == '!' ? list.size() - list2.size() : list.size() - (list2.size() + 1);
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence((Iterable)this.splitDomain(string)), n), ".", null, null, 0, null, null, 62, null);
    }

    private final List<String> splitDomain(String string) {
        char[] cArray = new char[]{'.'};
        List list = StringsKt.split$default((CharSequence)string, cArray, false, 0, 6, null);
        if (Intrinsics.areEqual(CollectionsKt.last(list), "")) {
            return CollectionsKt.dropLast(list, 1);
        }
        return list;
    }

    private final List<String> findMatchingRule(List<String> list) {
        char[] cArray;
        List list2;
        List list3;
        char[] cArray2;
        String string;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            this.readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        if (!(this.publicSuffixListBytes != null)) {
            boolean bl = false;
            String string2 = "Unable to load publicsuffixes.gz resource from the classpath.";
            throw new IllegalStateException(string2.toString());
        }
        int n = 0;
        int n2 = list.size();
        byte[][] byArrayArray = new byte[n2][];
        while (n < n2) {
            int n3 = n++;
            String string3 = list.get(n3);
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
            Intrinsics.checkNotNullExpressionValue(string3.getBytes(charset), "this as java.lang.String).getBytes(charset)");
        }
        byte[][] byArrayArray2 = byArrayArray;
        String string4 = null;
        int n4 = ((Object[])byArrayArray2).length;
        for (n2 = 0; n2 < n4; ++n2) {
            String string5;
            byte[] byArray = this.publicSuffixListBytes;
            if (this.publicSuffixListBytes == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                byArray = null;
            }
            if ((string5 = PublicSuffixDatabase.Companion.binarySearch(byArray, byArrayArray2, n2)) == null) continue;
            string4 = string5;
            break;
        }
        Object object = null;
        if (((Object[])byArrayArray2).length > 1) {
            byte[][] byArray = (byte[][])((Object[])byArrayArray2).clone();
            int n5 = ((Object[])byArray).length - 1;
            for (int i = 0; i < n5; ++i) {
                byArray[i] = WILDCARD_LABEL;
                byte[] byArray2 = this.publicSuffixListBytes;
                if (this.publicSuffixListBytes == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    byArray2 = null;
                }
                if ((string = PublicSuffixDatabase.Companion.binarySearch(byArray2, byArray, i)) == null) continue;
                object = string;
                break;
            }
        }
        String string6 = null;
        if (object != null) {
            int n6 = ((Object[])byArrayArray2).length - 1;
            for (int i = 0; i < n6; ++i) {
                byte[] byArray = this.publicSuffixExceptionListBytes;
                if (this.publicSuffixExceptionListBytes == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    byArray = null;
                }
                if ((string = PublicSuffixDatabase.Companion.binarySearch(byArray, byArrayArray2, i)) == null) continue;
                string6 = string;
                break;
            }
        }
        if (string6 != null) {
            string6 = '!' + string6;
            char[] cArray3 = new char[]{'.'};
            return StringsKt.split$default((CharSequence)string6, cArray3, false, 0, 6, null);
        }
        if (string4 == null && object == null) {
            return PREVAILING_RULE;
        }
        Object object2 = string4;
        if (object2 == null || (object2 = StringsKt.split$default((CharSequence)object2, cArray2 = new char[]{'.'}, false, 0, 6, null)) == null) {
            object2 = list3 = CollectionsKt.emptyList();
        }
        if ((list2 = object) == null || (list2 = StringsKt.split$default((CharSequence)((Object)list2), cArray = new char[]{'.'}, false, 0, 6, null)) == null) {
            list2 = CollectionsKt.emptyList();
        }
        List list4 = list2;
        return list3.size() > list4.size() ? list3 : list4;
    }

    /*
     * Exception decompiling
     */
    private final void readTheListUninterruptibly() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void readTheList() throws IOException {
        try {
            InputStream inputStream2;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            if (PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE) == null) {
                return;
            }
            InputStream inputStream3 = inputStream2;
            Object object = Okio.buffer(new GzipSource(Okio.source(inputStream3)));
            Throwable throwable = null;
            try {
                Object object2 = (BufferedSource)object;
                boolean bl = false;
                int n = object2.readInt();
                objectRef.element = object2.readByteArray(n);
                int n2 = object2.readInt();
                objectRef2.element = object2.readByteArray(n2);
                object2 = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)object, throwable);
            }
            object = this;
            synchronized (object) {
                boolean bl = false;
                Object t = objectRef.element;
                Intrinsics.checkNotNull(t);
                this.publicSuffixListBytes = (byte[])t;
                Object t2 = objectRef2.element;
                Intrinsics.checkNotNull(t2);
                this.publicSuffixExceptionListBytes = (byte[])t2;
                Unit unit = Unit.INSTANCE;
            }
        }
        finally {
            this.readCompleteLatch.countDown();
        }
    }

    public final void setListBytes(@NotNull byte[] byArray, @NotNull byte[] byArray2) {
        Intrinsics.checkNotNullParameter(byArray, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(byArray2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = byArray;
        this.publicSuffixExceptionListBytes = byArray2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }

    static {
        byte[] byArray = new byte[]{42};
        WILDCARD_LABEL = byArray;
        PREVAILING_RULE = CollectionsKt.listOf("*");
        instance = new PublicSuffixDatabase();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return instance;
        }

        private final String binarySearch(byte[] byArray, byte[][] byArray2, int n) {
            int n2 = 0;
            int n3 = byArray.length;
            String string = null;
            while (n2 < n3) {
                int n4;
                int n5;
                int n6;
                for (n6 = (n2 + n3) / 2; n6 > -1 && byArray[n6] != 10; --n6) {
                }
                ++n6;
                int n7 = 1;
                while (byArray[n6 + n7] != 10) {
                    ++n7;
                }
                int n8 = n6 + n7 - n6;
                int n9 = 0;
                int n10 = n;
                int n11 = 0;
                int n12 = 0;
                boolean bl = false;
                while (true) {
                    n5 = 0;
                    if (bl) {
                        n5 = 46;
                        bl = false;
                    } else {
                        n5 = Util.and(byArray2[n10][n11], 255);
                    }
                    n4 = Util.and(byArray[n6 + n12], 255);
                    n9 = n5 - n4;
                    if (n9 != 0) break;
                    ++n11;
                    if (++n12 == n8) break;
                    if (byArray2[n10].length != n11) continue;
                    if (n10 == ((Object[])byArray2).length - 1) break;
                    ++n10;
                    n11 = -1;
                    bl = true;
                }
                if (n9 < 0) {
                    n3 = n6 - 1;
                    continue;
                }
                if (n9 > 0) {
                    n2 = n6 + n7 + 1;
                    continue;
                }
                n5 = n8 - n12;
                n4 = byArray2[n10].length - n11;
                int n13 = ((Object[])byArray2).length;
                for (int i = n10 + 1; i < n13; ++i) {
                    n4 += byArray2[i].length;
                }
                if (n4 < n5) {
                    n3 = n6 - 1;
                    continue;
                }
                if (n4 > n5) {
                    n2 = n6 + n7 + 1;
                    continue;
                }
                Charset charset = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                Charset charset2 = charset;
                string = new String(byArray, n6, n8, charset2);
                break;
            }
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

