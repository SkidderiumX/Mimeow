/*
 * Decompiled with CFR 0.152.
 */
package okio.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\u0080\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\u0080\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\u0080\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\u0080\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\u0080\b\u001a\u0014\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\u0080\b\u00a2\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00066"}, d2={"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"})
@JvmName(name="DPath")
@SourceDebugExtension(value={"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/internal/DPath\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,406:1\n59#1,22:407\n209#1:433\n209#1:434\n1549#2:429\n1620#2,3:430\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/internal/DPath\n*L\n53#1:407,22\n199#1:433\n204#1:434\n53#1:429\n53#1:430,3\n*E\n"})
public class DPath {
    @NotNull
    private static final ByteString SLASH = ByteString.Companion.encodeUtf8("/");
    @NotNull
    private static final ByteString BACKSLASH = ByteString.Companion.encodeUtf8("\\");
    @NotNull
    private static final ByteString ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
    @NotNull
    private static final ByteString DOT = ByteString.Companion.encodeUtf8(".");
    @NotNull
    private static final ByteString DOT_DOT = ByteString.Companion.encodeUtf8("..");

    private static /* synthetic */ void getSLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    @Nullable
    public static final Path commonRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        int n = DPath.rootLength(path);
        return n == -1 ? null : new Path(path.getBytes$okio().substring(0, n));
    }

    @NotNull
    public static final List<String> commonSegments(@NotNull Path path) {
        int n;
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        Object object = path;
        boolean bl2 = false;
        Object object2 = new ArrayList();
        int n2 = DPath.rootLength((Path)object);
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
    public static final List<ByteString> commonSegmentsBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        List list = new ArrayList();
        int n = DPath.rootLength(path);
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

    private static final int rootLength(Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        if (path.getBytes$okio().getByte(0) == 47) {
            return 1;
        }
        if (path.getBytes$okio().getByte(0) == 92) {
            if (path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(1) == 92) {
                int n = path.getBytes$okio().indexOf(BACKSLASH, 2);
                if (n == -1) {
                    n = path.getBytes$okio().size();
                }
                return n;
            }
            return 1;
        }
        if (path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(1) == 58 && path.getBytes$okio().getByte(2) == 92) {
            char c = (char)path.getBytes$okio().getByte(0);
            if (!('a' <= c ? c < '{' : false)) {
                if (!('A' <= c ? c < '[' : false)) {
                    return -1;
                }
            }
            return 3;
        }
        return -1;
    }

    public static final boolean commonIsAbsolute(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return DPath.rootLength(path) != -1;
    }

    public static final boolean commonIsRelative(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return DPath.rootLength(path) == -1;
    }

    @Nullable
    public static final Character commonVolumeLetter(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        if (ByteString.indexOf$default(path.getBytes$okio(), DPath.SLASH, 0, 2, null) != -1) {
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
            if (!('A' <= c ? c < '[' : false)) {
                return null;
            }
        }
        return Character.valueOf(c);
    }

    private static final int getIndexOfLastSlash(Path path) {
        int n = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, null);
        if (n != -1) {
            return n;
        }
        return ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, null);
    }

    @NotNull
    public static final ByteString commonNameBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        int n = DPath.getIndexOfLastSlash(path);
        return n != -1 ? ByteString.substring$default(path.getBytes$okio(), n + 1, 0, 2, null) : (path.volumeLetter() != null && path.getBytes$okio().size() == 2 ? ByteString.EMPTY : path.getBytes$okio());
    }

    @NotNull
    public static final String commonName(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return path.nameBytes().utf8();
    }

    @Nullable
    public static final Path commonParent(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        if (Intrinsics.areEqual(path.getBytes$okio(), DPath.DOT) || Intrinsics.areEqual(path.getBytes$okio(), DPath.SLASH) || Intrinsics.areEqual(path.getBytes$okio(), DPath.BACKSLASH) || DPath.lastSegmentIsDotDot(path)) {
            return null;
        }
        int n = DPath.getIndexOfLastSlash(path);
        if (n == 2 && path.volumeLetter() != null) {
            if (path.getBytes$okio().size() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, null));
        }
        if (n == 1 && path.getBytes$okio().startsWith(DPath.BACKSLASH)) {
            return null;
        }
        if (n == -1 && path.volumeLetter() != null) {
            if (path.getBytes$okio().size() == 2) {
                return null;
            }
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, null));
        }
        if (n == -1) {
            return new Path(DPath.DOT);
        }
        if (n == 0) {
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, null));
        }
        return new Path(ByteString.substring$default(path.getBytes$okio(), 0, n, 1, null));
    }

    private static final boolean lastSegmentIsDotDot(Path path) {
        if (path.getBytes$okio().endsWith(DOT_DOT)) {
            if (path.getBytes$okio().size() == 2) {
                return true;
            }
            if (path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1)) {
                return true;
            }
            if (path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean commonIsRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return DPath.rootLength(path) == path.getBytes$okio().size();
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull String string, boolean bl) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(string, "child");
        boolean bl2 = false;
        Path path2 = path;
        Buffer buffer = new Buffer().writeUtf8(string);
        boolean bl3 = false;
        return DPath.commonResolve(path2, DPath.toPath(buffer, false), bl);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull ByteString byteString, boolean bl) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "child");
        boolean bl2 = false;
        Path path2 = path;
        Buffer buffer = new Buffer().write(byteString);
        boolean bl3 = false;
        return DPath.commonResolve(path2, DPath.toPath(buffer, false), bl);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Buffer buffer, boolean bl) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "child");
        boolean bl2 = false;
        return DPath.commonResolve(path, DPath.toPath(buffer, false), bl);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Path path2, boolean bl) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "child");
        if (path2.isAbsolute() || path2.volumeLetter() != null) {
            return path2;
        }
        ByteString byteString = DPath.getSlash(path);
        if (byteString == null && (byteString = DPath.getSlash(path2)) == null) {
            byteString = DPath.toSlash(Path.DIRECTORY_SEPARATOR);
        }
        ByteString byteString2 = byteString;
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0L) {
            buffer.write(byteString2);
        }
        buffer.write(path2.getBytes$okio());
        return DPath.toPath(buffer, bl);
    }

    @NotNull
    public static final Path commonRelativeTo(@NotNull Path path, @NotNull Path path2) {
        int n;
        int n2;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        boolean bl = false;
        if (!Intrinsics.areEqual(path.getRoot(), path2.getRoot())) {
            boolean bl2 = false;
            String string = "Paths of different roots cannot be relative to each other: " + path + " and " + path2;
            throw new IllegalArgumentException(string.toString());
        }
        List<ByteString> list = path.getSegmentsBytes();
        List<ByteString> list2 = path2.getSegmentsBytes();
        int n3 = Math.min(list.size(), list2.size());
        for (n2 = 0; n2 < n3 && Intrinsics.areEqual(list.get(n2), list2.get(n2)); ++n2) {
        }
        if (n2 == n3 && path.getBytes$okio().size() == path2.getBytes$okio().size()) {
            return Path.Companion.get$default(Path.Companion, ".", false, 1, null);
        }
        if (!(list2.subList(n2, list2.size()).indexOf(DPath.DOT_DOT) == -1)) {
            boolean bl3 = false;
            String string = "Impossible relative path to resolve: " + path + " and " + path2;
            throw new IllegalArgumentException(string.toString());
        }
        Buffer buffer = new Buffer();
        ByteString byteString = DPath.getSlash(path2);
        if (byteString == null && (byteString = DPath.getSlash(path)) == null) {
            byteString = DPath.toSlash(Path.DIRECTORY_SEPARATOR);
        }
        ByteString byteString2 = byteString;
        int n4 = list2.size();
        for (n = n2; n < n4; ++n) {
            buffer.write(DPath.DOT_DOT);
            buffer.write(byteString2);
        }
        n4 = list.size();
        for (n = n2; n < n4; ++n) {
            buffer.write(list.get(n));
            buffer.write(byteString2);
        }
        return DPath.toPath(buffer, false);
    }

    @NotNull
    public static final Path commonNormalized(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return Path.Companion.get(path.toString(), true);
    }

    private static final ByteString getSlash(Path path) {
        return ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, null) != -1 ? SLASH : (ByteString.indexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, null) != -1 ? BACKSLASH : null);
    }

    public static final int commonCompareTo(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        boolean bl = false;
        return path.getBytes$okio().compareTo(path2.getBytes$okio());
    }

    public static final boolean commonEquals(@NotNull Path path, @Nullable Object object) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return object instanceof Path && Intrinsics.areEqual(((Path)object).getBytes$okio(), path.getBytes$okio());
    }

    public static final int commonHashCode(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return path.getBytes$okio().hashCode();
    }

    @NotNull
    public static final String commonToString(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean bl = false;
        return path.getBytes$okio().utf8();
    }

    @NotNull
    public static final Path commonToPath(@NotNull String string, boolean bl) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        return DPath.toPath(new Buffer().writeUtf8(string), bl);
    }

    @NotNull
    public static final Path toPath(@NotNull Buffer buffer, boolean bl) {
        byte by;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteString byteString = null;
        Buffer buffer2 = new Buffer();
        int n = 0;
        while (buffer.rangeEquals(0L, SLASH) || buffer.rangeEquals(0L, BACKSLASH)) {
            by = buffer.readByte();
            ByteString byteString2 = byteString;
            if (byteString2 == null) {
                byteString2 = DPath.toSlash(by);
            }
            byteString = byteString2;
            ++n;
        }
        byte by2 = by = n >= 2 && Intrinsics.areEqual(byteString, BACKSLASH) ? (byte)1 : 0;
        if (by != 0) {
            ByteString byteString3 = byteString;
            Intrinsics.checkNotNull(byteString3);
            buffer2.write(byteString3);
            buffer2.write(byteString);
        } else if (n > 0) {
            ByteString byteString4 = byteString;
            Intrinsics.checkNotNull(byteString4);
            buffer2.write(byteString4);
        } else {
            long l = buffer.indexOfElement(ANY_SLASH);
            ByteString byteString5 = byteString;
            if (byteString5 == null) {
                byteString5 = l == -1L ? DPath.toSlash(Path.DIRECTORY_SEPARATOR) : DPath.toSlash(buffer.getByte(l));
            }
            if (DPath.startsWithVolumeLetterAndColon(buffer, byteString = byteString5)) {
                if (l == 2L) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
        }
        boolean bl2 = buffer2.size() > 0L;
        List list = new ArrayList();
        while (!buffer.exhausted()) {
            long l = buffer.indexOfElement(ANY_SLASH);
            ByteString byteString6 = null;
            if (l == -1L) {
                byteString6 = buffer.readByteString();
            } else {
                byteString6 = buffer.readByteString(l);
                buffer.readByte();
            }
            if (Intrinsics.areEqual(byteString6, DOT_DOT)) {
                if (bl2 && list.isEmpty()) continue;
                if (!bl || !bl2 && (list.isEmpty() || Intrinsics.areEqual(CollectionsKt.last(list), DOT_DOT))) {
                    list.add(byteString6);
                    continue;
                }
                if (by != 0 && list.size() == 1) continue;
                CollectionsKt.removeLastOrNull(list);
                continue;
            }
            if (Intrinsics.areEqual(byteString6, DOT) || Intrinsics.areEqual(byteString6, ByteString.EMPTY)) continue;
            list.add(byteString6);
        }
        int n2 = list.size();
        for (int i = 0; i < n2; ++i) {
            if (i > 0) {
                buffer2.write(byteString);
            }
            buffer2.write((ByteString)list.get(i));
        }
        if (buffer2.size() == 0L) {
            buffer2.write(DOT);
        }
        return new Path(buffer2.readByteString());
    }

    private static final ByteString toSlash(String string) {
        ByteString byteString;
        String string2 = string;
        if (Intrinsics.areEqual(string2, "/")) {
            byteString = SLASH;
        } else if (Intrinsics.areEqual(string2, "\\")) {
            byteString = BACKSLASH;
        } else {
            throw new IllegalArgumentException("not a directory separator: " + string);
        }
        return byteString;
    }

    private static final ByteString toSlash(byte by) {
        ByteString byteString;
        switch (by) {
            case 47: {
                byteString = SLASH;
                break;
            }
            case 92: {
                byteString = BACKSLASH;
                break;
            }
            default: {
                throw new IllegalArgumentException("not a directory separator: " + by);
            }
        }
        return byteString;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        boolean bl;
        if (!Intrinsics.areEqual(byteString, BACKSLASH)) {
            return false;
        }
        if (buffer.size() < 2L) {
            return false;
        }
        if (buffer.getByte(1L) != 58) {
            return false;
        }
        char c = (char)buffer.getByte(0L);
        if ('a' <= c) {
            if (c < '{') {
                return true;
            }
            bl = false;
        } else {
            bl = false;
        }
        if (bl) return true;
        if ('A' > c) return false;
        if (c >= '[') return false;
        return true;
    }
}

