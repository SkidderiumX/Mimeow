/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import okio.internal.DPath;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\rH\u0087\u0002\u00a2\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0087\u0002\u00a2\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0087\u0002\u00a2\u0006\u0002\b\"J\u0013\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0006\u0010&\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00008G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c\u00a8\u0006/"}, d2={"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", "parent", "()Lokio/Path;", "root", "getRoot", "segments", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", "other", "div", "child", "resolve", "equals", "", "hashCode", "normalized", "relativeTo", "normalize", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "toString", "Companion", "okio"})
@SourceDebugExtension(value={"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/Path\n+ 2 Path.kt\nokio/internal/DPath\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n45#2,3:133\n53#2,28:136\n59#2,22:168\n112#2:190\n117#2:191\n122#2,6:192\n139#2,5:198\n149#2:203\n154#2,25:204\n194#2:229\n199#2,11:230\n204#2,6:241\n199#2,11:247\n204#2,6:258\n228#2,36:264\n268#2:300\n282#2:301\n287#2:302\n292#2:303\n297#2:304\n1549#3:164\n1620#3,3:165\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/Path\n*L\n44#1:133,3\n47#1:136,28\n50#1:168,22\n53#1:190\n56#1:191\n60#1:192,6\n64#1:198,5\n68#1:203\n72#1:204,25\n75#1:229\n78#1:230,11\n81#1:241,6\n87#1:247,11\n90#1:258,6\n95#1:264,36\n97#1:300\n104#1:301\n106#1:302\n108#1:303\n110#1:304\n47#1:164\n47#1:165,3\n*E\n"})
public class Path
implements Comparable<Path> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ByteString bytes;
    @JvmField
    @NotNull
    public static final String DIRECTORY_SEPARATOR;

    public Path(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        this.bytes = byteString;
    }

    @NotNull
    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    @Nullable
    public final Path getRoot() {
        Path path = this;
        boolean bl = false;
        int n = DPath.access$rootLength(path);
        return n == -1 ? null : new Path(path.getBytes$okio().substring(0, n));
    }

    @NotNull
    public final List<String> getSegments() {
        int n;
        Path path = this;
        boolean bl = false;
        Object object = path;
        boolean bl2 = false;
        Object object2 = new ArrayList();
        int n2 = DPath.access$rootLength((Path)object);
        if (n2 == -1) {
            n2 = 0;
        } else if (n2 < ((Path)object).getBytes$okio().size() && ((Path)object).getBytes$okio().getByte(n2) == 92) {
            ++n2;
        }
        int n3 = ((Path)object).getBytes$okio().size();
        for (n = n2; n < n3; ++n) {
            if (((Path)object).getBytes$okio().getByte(n) != 47 && ((Path)object).getBytes$okio().getByte(n) != 92) continue;
            ((Collection)object2).add(((Path)object).getBytes$okio().substring(n2, n));
            n2 = n + 1;
        }
        if (n2 < ((Path)object).getBytes$okio().size()) {
            ((Collection)object2).add(((Path)object).getBytes$okio().substring(n2, ((Path)object).getBytes$okio().size()));
        }
        object = (Iterable)object2;
        bl2 = false;
        object2 = object;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(object, 10));
        n = 0;
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            Object t = iterator2.next();
            ByteString byteString = (ByteString)t;
            Collection collection2 = collection;
            boolean bl3 = false;
            collection2.add(byteString.utf8());
        }
        return (List)collection;
    }

    @NotNull
    public final List<ByteString> getSegmentsBytes() {
        Path path = this;
        boolean bl = false;
        List list = new ArrayList();
        int n = DPath.access$rootLength(path);
        if (n == -1) {
            n = 0;
        } else if (n < path.getBytes$okio().size() && path.getBytes$okio().getByte(n) == 92) {
            ++n;
        }
        int n2 = path.getBytes$okio().size();
        for (int i = n; i < n2; ++i) {
            if (path.getBytes$okio().getByte(i) != 47 && path.getBytes$okio().getByte(i) != 92) continue;
            ((Collection)list).add(path.getBytes$okio().substring(n, i));
            n = i + 1;
        }
        if (n < path.getBytes$okio().size()) {
            ((Collection)list).add(path.getBytes$okio().substring(n, path.getBytes$okio().size()));
        }
        return list;
    }

    public final boolean isAbsolute() {
        Path path = this;
        boolean bl = false;
        return DPath.access$rootLength(path) != -1;
    }

    public final boolean isRelative() {
        Path path = this;
        boolean bl = false;
        return DPath.access$rootLength(path) == -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmName(name="volumeLetter")
    @Nullable
    public final Character volumeLetter() {
        Path path = this;
        boolean bl = false;
        if (ByteString.indexOf$default(path.getBytes$okio(), DPath.access$getSLASH$p(), 0, 2, null) != -1) {
            return null;
        }
        if (path.getBytes$okio().size() < 2) {
            return null;
        }
        if (path.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c = (char)path.getBytes$okio().getByte(0);
        if (!('a' <= c ? c < '{' : false)) {
            if ('A' > c) return null;
            if (c >= '[') return null;
            boolean bl2 = true;
            if (!bl2) {
                return null;
            }
        }
        Character c2 = Character.valueOf(c);
        return c2;
    }

    @JvmName(name="nameBytes")
    @NotNull
    public final ByteString nameBytes() {
        Path path = this;
        boolean bl = false;
        int n = DPath.access$getIndexOfLastSlash(path);
        return n != -1 ? ByteString.substring$default(path.getBytes$okio(), n + 1, 0, 2, null) : (path.volumeLetter() != null && path.getBytes$okio().size() == 2 ? ByteString.EMPTY : path.getBytes$okio());
    }

    @JvmName(name="name")
    @NotNull
    public final String name() {
        Path path = this;
        boolean bl = false;
        return path.nameBytes().utf8();
    }

    @JvmName(name="parent")
    @Nullable
    public final Path parent() {
        Object object;
        Path path = this;
        boolean bl = false;
        if (Intrinsics.areEqual(path.getBytes$okio(), DPath.access$getDOT$p()) || Intrinsics.areEqual(path.getBytes$okio(), DPath.access$getSLASH$p()) || Intrinsics.areEqual(path.getBytes$okio(), DPath.access$getBACKSLASH$p()) || DPath.access$lastSegmentIsDotDot(path)) {
            object = null;
        } else {
            int n = DPath.access$getIndexOfLastSlash(path);
            object = n == 2 && path.volumeLetter() != null ? (path.getBytes$okio().size() == 3 ? null : new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, null))) : (n == 1 && path.getBytes$okio().startsWith(DPath.access$getBACKSLASH$p()) ? null : (n == -1 && path.volumeLetter() != null ? (path.getBytes$okio().size() == 2 ? null : new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, null))) : (n == -1 ? new Path(DPath.access$getDOT$p()) : (n == 0 ? new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, null)) : new Path(ByteString.substring$default(path.getBytes$okio(), 0, n, 1, null))))));
        }
        return object;
    }

    public final boolean isRoot() {
        Path path = this;
        boolean bl = false;
        return DPath.access$rootLength(path) == path.getBytes$okio().size();
    }

    @JvmName(name="resolve")
    @NotNull
    public final Path resolve(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "child");
        Path path = this;
        boolean bl = false;
        boolean bl2 = false;
        Path path2 = path;
        Buffer buffer = new Buffer().writeUtf8(string);
        boolean bl3 = false;
        return DPath.commonResolve(path2, DPath.toPath(buffer, false), bl);
    }

    @JvmName(name="resolve")
    @NotNull
    public final Path resolve(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "child");
        Path path = this;
        boolean bl = false;
        boolean bl2 = false;
        Path path2 = path;
        Buffer buffer = new Buffer().write(byteString);
        boolean bl3 = false;
        return DPath.commonResolve(path2, DPath.toPath(buffer, false), bl);
    }

    @JvmName(name="resolve")
    @NotNull
    public final Path resolve(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "child");
        return DPath.commonResolve(this, path, false);
    }

    @NotNull
    public final Path resolve(@NotNull String string, boolean bl) {
        Intrinsics.checkNotNullParameter(string, "child");
        Path path = this;
        boolean bl2 = false;
        Path path2 = path;
        Buffer buffer = new Buffer().writeUtf8(string);
        boolean bl3 = false;
        return DPath.commonResolve(path2, DPath.toPath(buffer, false), bl);
    }

    public static /* synthetic */ Path resolve$default(Path path, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return path.resolve(string, bl);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString byteString, boolean bl) {
        Intrinsics.checkNotNullParameter(byteString, "child");
        Path path = this;
        boolean bl2 = false;
        Path path2 = path;
        Buffer buffer = new Buffer().write(byteString);
        boolean bl3 = false;
        return DPath.commonResolve(path2, DPath.toPath(buffer, false), bl);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return path.resolve(byteString, bl);
    }

    @NotNull
    public final Path resolve(@NotNull Path path, boolean bl) {
        Intrinsics.checkNotNullParameter(path, "child");
        return DPath.commonResolve(this, path, bl);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return path.resolve(path2, bl);
    }

    @NotNull
    public final Path relativeTo(@NotNull Path path) {
        Path path2;
        int n;
        Intrinsics.checkNotNullParameter(path, "other");
        Path path3 = this;
        boolean bl = false;
        if (!Intrinsics.areEqual(path3.getRoot(), path.getRoot())) {
            boolean bl2 = false;
            String string = "Paths of different roots cannot be relative to each other: " + path3 + " and " + path;
            throw new IllegalArgumentException(string.toString());
        }
        List<ByteString> list = path3.getSegmentsBytes();
        List<ByteString> list2 = path.getSegmentsBytes();
        int n2 = Math.min(list.size(), list2.size());
        for (n = 0; n < n2 && Intrinsics.areEqual(list.get(n), list2.get(n)); ++n) {
        }
        if (n == n2 && path3.getBytes$okio().size() == path.getBytes$okio().size()) {
            path2 = okio.Path$Companion.get$default(Companion, ".", false, 1, null);
        } else {
            int n3;
            if (!(list2.subList(n, list2.size()).indexOf(DPath.access$getDOT_DOT$p()) == -1)) {
                boolean bl3 = false;
                String string = "Impossible relative path to resolve: " + path3 + " and " + path;
                throw new IllegalArgumentException(string.toString());
            }
            Buffer buffer = new Buffer();
            ByteString byteString = DPath.access$getSlash(path);
            if (byteString == null && (byteString = DPath.access$getSlash(path3)) == null) {
                byteString = DPath.access$toSlash(DIRECTORY_SEPARATOR);
            }
            ByteString byteString2 = byteString;
            int n4 = list2.size();
            for (n3 = n; n3 < n4; ++n3) {
                buffer.write(DPath.access$getDOT_DOT$p());
                buffer.write(byteString2);
            }
            n4 = list.size();
            for (n3 = n; n3 < n4; ++n3) {
                buffer.write(list.get(n3));
                buffer.write(byteString2);
            }
            path2 = DPath.toPath(buffer, false);
        }
        return path2;
    }

    @NotNull
    public final Path normalized() {
        Path path = this;
        boolean bl = false;
        return Companion.get(path.toString(), true);
    }

    @NotNull
    public final File toFile() {
        return new File(this.toString());
    }

    @NotNull
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(this.toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    @Override
    public int compareTo(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "other");
        Path path2 = this;
        boolean bl = false;
        return path2.getBytes$okio().compareTo(path.getBytes$okio());
    }

    public boolean equals(@Nullable Object object) {
        Path path = this;
        boolean bl = false;
        return object instanceof Path && Intrinsics.areEqual(((Path)object).getBytes$okio(), path.getBytes$okio());
    }

    public int hashCode() {
        Path path = this;
        boolean bl = false;
        return path.getBytes$okio().hashCode();
    }

    @NotNull
    public String toString() {
        Path path = this;
        boolean bl = false;
        return path.getBytes$okio().utf8();
    }

    @JvmStatic
    @JvmName(name="get")
    @JvmOverloads
    @NotNull
    public static final Path get(@NotNull String string, boolean bl) {
        return Companion.get(string, bl);
    }

    @JvmStatic
    @JvmName(name="get")
    @JvmOverloads
    @NotNull
    public static final Path get(@NotNull File file, boolean bl) {
        return Companion.get(file, bl);
    }

    @JvmStatic
    @JvmName(name="get")
    @JvmOverloads
    @NotNull
    public static final Path get(@NotNull java.nio.file.Path path, boolean bl) {
        return Companion.get(path, bl);
    }

    @JvmStatic
    @JvmName(name="get")
    @JvmOverloads
    @NotNull
    public static final Path get(@NotNull String string) {
        return Companion.get(string);
    }

    @JvmStatic
    @JvmName(name="get")
    @JvmOverloads
    @NotNull
    public static final Path get(@NotNull File file) {
        return Companion.get(file);
    }

    @JvmStatic
    @JvmName(name="get")
    @JvmOverloads
    @NotNull
    public static final Path get(@NotNull java.nio.file.Path path) {
        return Companion.get(path);
    }

    static {
        String string = File.separator;
        Intrinsics.checkNotNullExpressionValue(string, "separator");
        DIRECTORY_SEPARATOR = string;
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", "", "get", "Ljava/nio/file/Path;", "toPath", "okio"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @JvmName(name="get")
        @JvmOverloads
        @NotNull
        public final Path get(@NotNull String string, boolean bl) {
            Intrinsics.checkNotNullParameter(string, "<this>");
            return DPath.commonToPath(string, bl);
        }

        public static /* synthetic */ Path get$default(Companion companion, String string, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = false;
            }
            return companion.get(string, bl);
        }

        @JvmStatic
        @JvmName(name="get")
        @JvmOverloads
        @NotNull
        public final Path get(@NotNull File file, boolean bl) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String string = file.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return this.get(string, bl);
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = false;
            }
            return companion.get(file, bl);
        }

        @JvmStatic
        @JvmName(name="get")
        @JvmOverloads
        @NotNull
        public final Path get(@NotNull java.nio.file.Path path, boolean bl) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return this.get(((Object)path).toString(), bl);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = false;
            }
            return companion.get(path, bl);
        }

        @JvmStatic
        @JvmName(name="get")
        @JvmOverloads
        @NotNull
        public final Path get(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<this>");
            return okio.Path$Companion.get$default(this, string, false, 1, null);
        }

        @JvmStatic
        @JvmName(name="get")
        @JvmOverloads
        @NotNull
        public final Path get(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return okio.Path$Companion.get$default(this, file, false, 1, null);
        }

        @JvmStatic
        @JvmName(name="get")
        @JvmOverloads
        @NotNull
        public final Path get(@NotNull java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return okio.Path$Companion.get$default(this, path, false, 1, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

