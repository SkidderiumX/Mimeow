package okio.internal;

import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import java.io.*;
import okio.*;
import kotlin.jvm.functions.*;
import kotlin.coroutines.*;
import kotlin.sequences.*;
import kotlin.coroutines.intrinsics.*;
import kotlin.*;
import kotlin.collections.*;
import org.jetbrains.annotations.*;
import java.util.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@\u00f8\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c" }, d2 = { "collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio" })
@JvmName(name = "DFileSystem")
@SourceDebugExtension({ "SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/DFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n52#2,5:156\n52#2,21:161\n60#2,10:182\n57#2,2:192\n71#2,2:194\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/DFileSystem\n*L\n65#1:156,5\n66#1:161,21\n65#1:182,10\n65#1:192,2\n65#1:194,2\n*E\n" })
public class DFileSystem
{
    @NotNull
    public static final FileMetadata commonMetadata(@NotNull final FileSystem fileSystem, @NotNull final Path obj) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(obj, "path");
        final FileMetadata metadataOrNull = fileSystem.metadataOrNull(obj);
        if (metadataOrNull == null) {
            throw new FileNotFoundException("no such file: " + obj);
        }
        return metadataOrNull;
    }
    
    public static final boolean commonExists(@NotNull final FileSystem fileSystem, @NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }
    
    public static final void commonCreateDirectories(@NotNull final FileSystem fileSystem, @NotNull final Path obj, final boolean b) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(obj, "dir");
        final ArrayDeque arrayDeque = new ArrayDeque();
        for (Path parent = obj; parent != null && !fileSystem.exists(parent); parent = parent.parent()) {
            arrayDeque.addFirst(parent);
        }
        if (b && arrayDeque.isEmpty()) {
            throw new IOException(obj + " already exists.");
        }
        final Iterator iterator = arrayDeque.iterator();
        while (iterator.hasNext()) {
            fileSystem.createDirectory((Path)iterator.next());
        }
    }
    
    public static final void commonCopy(@NotNull final FileSystem fileSystem, @NotNull final Path path, @NotNull final Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        final Closeable closeable = fileSystem.source(path);
        Object value = null;
        Throwable t = null;
        try {
            final Source source = (Source)closeable;
            final Closeable closeable2 = Okio.buffer(fileSystem.sink(path2));
            Number value2 = null;
            Throwable t2 = null;
            try {
                value2 = ((BufferedSink)closeable2).writeAll(source);
            }
            catch (final Throwable t3) {
                t2 = t3;
                try (final BufferedSink bufferedSink = (BufferedSink)closeable2) {}
                catch (final Throwable t4) {
                    if (t2 == null) {
                        t2 = t4;
                    }
                    else {
                        ExceptionsKt__ExceptionsKt.addSuppressed(t2, t4);
                    }
                }
            }
            final Throwable t5 = t2;
            if (t5 != null) {
                throw t5;
            }
            final Number n = value2;
            Intrinsics.checkNotNull(n);
            value = n.longValue();
        }
        catch (final Throwable t6) {
            t = t6;
            try (final Source source2 = (Source)closeable) {}
            catch (final Throwable t7) {
                if (t == null) {
                    t = t7;
                }
                else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(t, t7);
                }
            }
        }
        finally {
            try (final Source source3 = (Source)closeable) {}
            catch (final Throwable t8) {
                t = t8;
            }
        }
        final Throwable t9 = t;
        if (t9 != null) {
            throw t9;
        }
        Intrinsics.checkNotNull(value);
    }
    
    public static final void commonDeleteRecursively(@NotNull final FileSystem fileSystem, @NotNull final Path path, final boolean b) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        final Iterator<Object> iterator = (Iterator<Object>)SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super Path>, ? super Continuation<? super Unit>, ?>)new DFileSystem$commonDeleteRecursively$sequence.DFileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, (Continuation)null)).iterator();
        while (iterator.hasNext()) {
            fileSystem.delete((Path)iterator.next(), b && !iterator.hasNext());
        }
    }
    
    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull final FileSystem fileSystem, @NotNull final Path path, final boolean b) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super Path>, ? super Continuation<? super Unit>, ?>)new DFileSystem$commonListRecursively.DFileSystem$commonListRecursively$1(path, fileSystem, b, (Continuation)null));
    }
    
    @Nullable
    public static final Object collectRecursively(@NotNull SequenceScope<? super Path> sequenceScope, @NotNull FileSystem fileSystem, @NotNull ArrayDeque<Path> arrayDeque, @NotNull Path obj, boolean b, boolean b2, @NotNull final Continuation<? super Unit> continuation) {
        DFileSystem$collectRecursively.DFileSystem$collectRecursively$1 DFileSystem$collectRecursively$1 = null;
        Label_0052: {
            if (continuation instanceof DFileSystem$collectRecursively.DFileSystem$collectRecursively$1) {
                DFileSystem$collectRecursively$1 = (DFileSystem$collectRecursively.DFileSystem$collectRecursively$1)continuation;
                if ((DFileSystem$collectRecursively$1.label & Integer.MIN_VALUE) != 0x0) {
                    final DFileSystem$collectRecursively.DFileSystem$collectRecursively$1 DFileSystem$collectRecursively$2 = DFileSystem$collectRecursively$1;
                    DFileSystem$collectRecursively$2.label -= Integer.MIN_VALUE;
                    break Label_0052;
                }
            }
            DFileSystem$collectRecursively$1 = new DFileSystem$collectRecursively.DFileSystem$collectRecursively$1((Continuation)continuation);
        }
        final Object result = DFileSystem$collectRecursively$1.result;
        final Object coroutine_SUSPENDED = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
    Label_0345:
        while (true) {
            switch (DFileSystem$collectRecursively$1.label) {
                case 0: {
                    ResultKt.throwOnFailure(result);
                    if (b2) {
                        break;
                    }
                    final SequenceScope sequenceScope2 = sequenceScope;
                    final Path path = obj;
                    final DFileSystem$collectRecursively.DFileSystem$collectRecursively$1 DFileSystem$collectRecursively$3 = DFileSystem$collectRecursively$1;
                    DFileSystem$collectRecursively$1.L$0 = sequenceScope;
                    DFileSystem$collectRecursively$1.L$1 = fileSystem;
                    DFileSystem$collectRecursively$1.L$2 = arrayDeque;
                    DFileSystem$collectRecursively$1.L$3 = obj;
                    DFileSystem$collectRecursively$1.Z$0 = b;
                    DFileSystem$collectRecursively$1.Z$1 = b2;
                    DFileSystem$collectRecursively$1.label = 1;
                    if (sequenceScope2.m4eec8d92e8(path, (Continuation<? super Unit>)DFileSystem$collectRecursively$3) == coroutine_SUSPENDED) {
                        return coroutine_SUSPENDED;
                    }
                    break;
                }
                case 1: {
                    b2 = DFileSystem$collectRecursively$1.Z$1;
                    b = DFileSystem$collectRecursively$1.Z$0;
                    obj = (Path)DFileSystem$collectRecursively$1.L$3;
                    arrayDeque = (ArrayDeque)DFileSystem$collectRecursively$1.L$2;
                    fileSystem = (FileSystem)DFileSystem$collectRecursively$1.L$1;
                    sequenceScope = (SequenceScope)DFileSystem$collectRecursively$1.L$0;
                    ResultKt.throwOnFailure(result);
                    break;
                }
                case 2: {
                    Label_0473: {
                        break Label_0473;
                        final Path path2;
                        arrayDeque.addLast(path2);
                        try {
                            final Object o;
                            Iterator iterator = ((List)o).iterator();
                            while (true) {
                                while (iterator.hasNext()) {
                                    final Path path3 = (Path)iterator.next();
                                    final SequenceScope sequenceScope3 = sequenceScope;
                                    final FileSystem fileSystem2 = fileSystem;
                                    final ArrayDeque arrayDeque2 = arrayDeque;
                                    final Path path4 = path3;
                                    final boolean b3 = b;
                                    final boolean b4 = b2;
                                    final DFileSystem$collectRecursively.DFileSystem$collectRecursively$1 DFileSystem$collectRecursively$4 = DFileSystem$collectRecursively$1;
                                    DFileSystem$collectRecursively$1.L$0 = sequenceScope;
                                    DFileSystem$collectRecursively$1.L$1 = fileSystem;
                                    DFileSystem$collectRecursively$1.L$2 = arrayDeque;
                                    DFileSystem$collectRecursively$1.L$3 = obj;
                                    DFileSystem$collectRecursively$1.L$4 = iterator;
                                    DFileSystem$collectRecursively$1.Z$0 = b;
                                    DFileSystem$collectRecursively$1.Z$1 = b2;
                                    DFileSystem$collectRecursively$1.label = 2;
                                    if (collectRecursively(sequenceScope3, fileSystem2, arrayDeque2, path4, b3, b4, (Continuation<? super Unit>)DFileSystem$collectRecursively$4) == coroutine_SUSPENDED) {
                                        return coroutine_SUSPENDED;
                                    }
                                }
                                break Label_0345;
                                b2 = DFileSystem$collectRecursively$1.Z$1;
                                b = DFileSystem$collectRecursively$1.Z$0;
                                iterator = (Iterator)DFileSystem$collectRecursively$1.L$4;
                                obj = (Path)DFileSystem$collectRecursively$1.L$3;
                                arrayDeque = (ArrayDeque)DFileSystem$collectRecursively$1.L$2;
                                fileSystem = (FileSystem)DFileSystem$collectRecursively$1.L$1;
                                sequenceScope = (SequenceScope)DFileSystem$collectRecursively$1.L$0;
                                ResultKt.throwOnFailure(result);
                                continue;
                            }
                        }
                        finally {
                            arrayDeque.removeLast();
                        }
                    }
                    break Label_0345;
                }
                case 3: {
                    ResultKt.throwOnFailure(result);
                    return Unit.INSTANCE;
                }
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            Object o2;
            if ((o2 = fileSystem.listOrNull(obj)) == null) {
                o2 = CollectionsKt__CollectionsKt.emptyList();
            }
            final Object o = o2;
            if (!((Collection)o).isEmpty()) {
                Path path2 = obj;
                int n = 0;
                while (!b || !arrayDeque.contains(path2)) {
                    final Path symlinkTarget = symlinkTarget(fileSystem, path2);
                    if (symlinkTarget == null) {
                        if (b || n == 0) {
                            continue Label_0345;
                        }
                        break Label_0345;
                    }
                    else {
                        path2 = symlinkTarget;
                        ++n;
                    }
                }
                throw new IOException("symlink cycle at " + obj);
            }
            break;
        }
        if (!b2) {
            return Unit.INSTANCE;
        }
        final SequenceScope sequenceScope4 = sequenceScope;
        final Path path5 = obj;
        final DFileSystem$collectRecursively.DFileSystem$collectRecursively$1 DFileSystem$collectRecursively$5 = DFileSystem$collectRecursively$1;
        DFileSystem$collectRecursively$1.L$0 = null;
        DFileSystem$collectRecursively$1.L$1 = null;
        DFileSystem$collectRecursively$1.L$2 = null;
        DFileSystem$collectRecursively$1.L$3 = null;
        DFileSystem$collectRecursively$1.L$4 = null;
        DFileSystem$collectRecursively$1.label = 3;
        if (sequenceScope4.m4eec8d92e8(path5, (Continuation<? super Unit>)DFileSystem$collectRecursively$5) == coroutine_SUSPENDED) {
            return coroutine_SUSPENDED;
        }
        return Unit.INSTANCE;
    }
    
    @Nullable
    public static final Path symlinkTarget(@NotNull final FileSystem fileSystem, @NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        final Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        final Path path2 = symlinkTarget;
        final Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(path2);
    }
}
