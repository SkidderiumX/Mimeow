package okio;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.*;
import java.io.*;
import java.util.*;
import kotlin.collections.*;
import okio.internal.*;
import java.util.zip.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006(" }, d2 = { "Lokio/ZipFileSystem;", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "entries", "", "Lokio/internal/ZipEntry;", "comment", "", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "appendingSink", "Lokio/Sink;", "file", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "Companion", "okio" })
@SourceDebugExtension({ "SMAP\nZipFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,175:1\n52#2,5:176\n52#2,21:181\n60#2,10:202\n57#2,2:212\n71#2,2:214\n52#2,21:216\n*S KotlinDebug\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n*L\n102#1:176,5\n103#1:181,21\n102#1:202,10\n102#1:212,2\n102#1:214,2\n132#1:216,21\n*E\n" })
public class ZipFileSystem extends FileSystem
{
    @NotNull
    private static final Companion Companion;
    @NotNull
    private final Path zipPath;
    @NotNull
    private final FileSystem fileSystem;
    @NotNull
    private final Map<Path, ZipEntry> entries;
    @Nullable
    private final String comment;
    @NotNull
    private static final Path ROOT;
    
    public ZipFileSystem(@NotNull final Path zipPath, @NotNull final FileSystem fileSystem, @NotNull final Map<Path, ZipEntry> entries, @Nullable final String comment) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = comment;
    }
    
    @NotNull
    @Override
    public Path canonicalize(@NotNull final Path obj) {
        Intrinsics.checkNotNullParameter(obj, "path");
        final Path canonicalizeInternal = this.canonicalizeInternal(obj);
        if (!this.entries.containsKey(canonicalizeInternal)) {
            throw new FileNotFoundException(String.valueOf(obj));
        }
        return canonicalizeInternal;
    }
    
    private final Path canonicalizeInternal(final Path path) {
        return ZipFileSystem.ROOT.resolve(path, true);
    }
    
    @Nullable
    @Override
    public FileMetadata metadataOrNull(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        final ZipEntry zipEntry = this.entries.get(this.canonicalizeInternal(path));
        if (zipEntry == null) {
            return null;
        }
        final ZipEntry zipEntry2 = zipEntry;
        final FileMetadata fileMetadata = new FileMetadata(!zipEntry2.isDirectory(), zipEntry2.isDirectory(), null, zipEntry2.isDirectory() ? null : Long.valueOf(zipEntry2.getSize()), null, zipEntry2.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry2.getOffset() == -1L) {
            return fileMetadata;
        }
        final Closeable closeable = this.fileSystem.openReadOnly(this.zipPath);
        Object o = null;
        Throwable t = null;
        try {
            final Closeable closeable2 = Okio.buffer(((FileHandle)closeable).source(zipEntry2.getOffset()));
            FileMetadata localHeader = null;
            Throwable t2 = null;
            try {
                localHeader = ZipFilesKt.readLocalHeader((BufferedSource)closeable2, fileMetadata);
            }
            catch (final Throwable t3) {
                t2 = t3;
                try (final BufferedSource bufferedSource = (BufferedSource)closeable2) {}
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
            final FileMetadata fileMetadata2 = localHeader;
            Intrinsics.checkNotNull(fileMetadata2);
            o = fileMetadata2;
        }
        catch (final Throwable t6) {
            t = t6;
            try (final FileHandle fileHandle = (FileHandle)closeable) {}
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
            try (final FileHandle fileHandle2 = (FileHandle)closeable) {}
            catch (final Throwable t8) {
                t = t8;
            }
        }
        final Throwable t9 = t;
        if (t9 != null) {
            throw t9;
        }
        final Object o2 = o;
        Intrinsics.checkNotNull(o2);
        return (FileMetadata)o2;
    }
    
    @NotNull
    @Override
    public FileHandle openReadOnly(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }
    
    @NotNull
    @Override
    public FileHandle openReadWrite(@NotNull final Path path, final boolean b, final boolean b2) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip entries are not writable");
    }
    
    @NotNull
    @Override
    public List<Path> list(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        final List<Path> list = this.list(path, true);
        Intrinsics.checkNotNull(list);
        return list;
    }
    
    @Nullable
    @Override
    public List<Path> listOrNull(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return this.list(path, false);
    }
    
    private final List<Path> list(final Path obj, final boolean b) {
        final ZipEntry zipEntry = this.entries.get(this.canonicalizeInternal(obj));
        if (zipEntry != null) {
            return (List<Path>)CollectionsKt___CollectionsKt.toList((Iterable<?>)zipEntry.getChildren());
        }
        if (b) {
            throw new IOException("not a directory: " + obj);
        }
        return null;
    }
    
    @NotNull
    @Override
    public Source source(@NotNull final Path obj) throws IOException {
        Intrinsics.checkNotNullParameter(obj, "file");
        final ZipEntry zipEntry = this.entries.get(this.canonicalizeInternal(obj));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + obj);
        }
        final ZipEntry zipEntry2 = zipEntry;
        final Closeable closeable = this.fileSystem.openReadOnly(this.zipPath);
        BufferedSource buffer = null;
        Throwable t = null;
        try {
            buffer = Okio.buffer(((FileHandle)closeable).source(zipEntry2.getOffset()));
        }
        catch (final Throwable t2) {
            t = t2;
            try (final FileHandle fileHandle = (FileHandle)closeable) {}
            catch (final Throwable t3) {
                if (t == null) {
                    t = t3;
                }
                else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(t, t3);
                }
            }
        }
        finally {
            try (final FileHandle fileHandle2 = (FileHandle)closeable) {}
            catch (final Throwable t4) {
                t = t4;
            }
        }
        final Throwable t5 = t;
        if (t5 != null) {
            throw t5;
        }
        final BufferedSource bufferedSource = buffer;
        Intrinsics.checkNotNull(bufferedSource);
        final BufferedSource bufferedSource2 = bufferedSource;
        ZipFilesKt.skipLocalHeader(bufferedSource2);
        return (zipEntry2.getCompressionMethod() == 0) ? new FixedLengthSource(bufferedSource2, zipEntry2.getSize(), true) : ((Source)new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSource2, zipEntry2.getCompressedSize(), true), new Inflater(true)), zipEntry2.getSize(), false));
    }
    
    @NotNull
    @Override
    public Sink sink(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip file systems are read-only");
    }
    
    @NotNull
    @Override
    public Sink appendingSink(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip file systems are read-only");
    }
    
    @Override
    public void createDirectory(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "dir");
        throw new IOException("zip file systems are read-only");
    }
    
    @Override
    public void atomicMove(@NotNull final Path path, @NotNull final Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException("zip file systems are read-only");
    }
    
    @Override
    public void delete(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }
    
    @Override
    public void createSymlink(@NotNull final Path path, @NotNull final Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException("zip file systems are read-only");
    }
    
    public static final /* synthetic */ Path access$getROOT$cp() {
        return ZipFileSystem.ROOT;
    }
    
    static {
        Companion = new Companion(null);
        ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, null);
    }
    
    @Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lokio/ZipFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio" })
    private static final class Companion
    {
        @NotNull
        public final Path getROOT() {
            return ZipFileSystem.access$getROOT$cp();
        }
    }
}
