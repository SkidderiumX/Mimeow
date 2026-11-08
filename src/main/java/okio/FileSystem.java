package okio;

import org.jetbrains.annotations.*;
import java.util.*;
import kotlin.sequences.*;
import kotlin.jvm.functions.*;
import java.io.*;
import kotlin.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import okio.internal.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J:\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u0006H&JD\u0010/\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065" }, d2 = { "Lokio/FileSystem;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "copy", "createDirectories", "dir", "mustCreate", "createDirectory", "createSymlink", "delete", "deleteRecursively", "fileOrDirectory", "exists", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "read", "T", "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Source;", "write", "writerAction", "Lokio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "okio" })
@SourceDebugExtension({ "SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,165:1\n52#2,21:166\n52#2,21:187\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n*L\n67#1:166,21\n81#1:187,21\n*E\n" })
public abstract class FileSystem
{
    @NotNull
    public static final Companion Companion;
    @JvmField
    @NotNull
    public static final FileSystem SYSTEM;
    @JvmField
    @NotNull
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;
    @JvmField
    @NotNull
    public static final FileSystem RESOURCES;
    
    @NotNull
    public abstract Path canonicalize(@NotNull final Path p0) throws IOException;
    
    @NotNull
    public final FileMetadata metadata(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return DFileSystem.commonMetadata(this, path);
    }
    
    @Nullable
    public abstract FileMetadata metadataOrNull(@NotNull final Path p0) throws IOException;
    
    public final boolean exists(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return DFileSystem.commonExists(this, path);
    }
    
    @NotNull
    public abstract List<Path> list(@NotNull final Path p0) throws IOException;
    
    @Nullable
    public abstract List<Path> listOrNull(@NotNull final Path p0);
    
    @NotNull
    public Sequence<Path> listRecursively(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return DFileSystem.commonListRecursively(this, path, b);
    }
    
    @NotNull
    public final Sequence<Path> listRecursively(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return this.listRecursively(path, false);
    }
    
    @NotNull
    public abstract FileHandle openReadOnly(@NotNull final Path p0) throws IOException;
    
    @NotNull
    public abstract FileHandle openReadWrite(@NotNull final Path p0, final boolean p1, final boolean p2) throws IOException;
    
    @NotNull
    public final FileHandle openReadWrite(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.openReadWrite(path, false, false);
    }
    
    @NotNull
    public abstract Source source(@NotNull final Path p0) throws IOException;
    
    @JvmName(name = "-read")
    public final <T> T m6e3b6450a7(@NotNull final Path path, @NotNull final Function1<? super BufferedSource, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(function1, "readerAction");
        final Closeable closeable = Okio.buffer(this.source(path));
        T invoke = null;
        Throwable t = null;
        try {
            invoke = (T)function1.invoke((BufferedSource)closeable);
        }
        catch (final Throwable t2) {
            t = t2;
            InlineMarker.finallyStart(1);
            try (final BufferedSource bufferedSource = (BufferedSource)closeable) {}
            catch (final Throwable t3) {
                if (t == null) {
                    t = t3;
                }
                else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(t, t3);
                }
            }
            InlineMarker.finallyEnd(1);
        }
        finally {
            InlineMarker.finallyStart(1);
            try (final BufferedSource bufferedSource2 = (BufferedSource)closeable) {}
            catch (final Throwable t4) {
                t = t4;
            }
            InlineMarker.finallyEnd(1);
        }
        final Throwable t5 = t;
        if (t5 != null) {
            throw t5;
        }
        final T t6 = invoke;
        Intrinsics.checkNotNull(t6);
        return t6;
    }
    
    @NotNull
    public abstract Sink sink(@NotNull final Path p0, final boolean p1) throws IOException;
    
    @NotNull
    public final Sink sink(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.sink(path, false);
    }
    
    @JvmName(name = "-write")
    public final <T> T m39ab1df4fe(@NotNull final Path path, final boolean b, @NotNull final Function1<? super BufferedSink, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(function1, "writerAction");
        final Closeable closeable = Okio.buffer(this.sink(path, b));
        T invoke = null;
        Throwable t = null;
        try {
            invoke = (T)function1.invoke((BufferedSink)closeable);
        }
        catch (final Throwable t2) {
            t = t2;
            InlineMarker.finallyStart(1);
            try (final BufferedSink bufferedSink = (BufferedSink)closeable) {}
            catch (final Throwable t3) {
                if (t == null) {
                    t = t3;
                }
                else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(t, t3);
                }
            }
            InlineMarker.finallyEnd(1);
        }
        finally {
            InlineMarker.finallyStart(1);
            try (final BufferedSink bufferedSink2 = (BufferedSink)closeable) {}
            catch (final Throwable t4) {
                t = t4;
            }
            InlineMarker.finallyEnd(1);
        }
        final Throwable t5 = t;
        if (t5 != null) {
            throw t5;
        }
        final T t6 = invoke;
        Intrinsics.checkNotNull(t6);
        return t6;
    }
    
    @NotNull
    public abstract Sink appendingSink(@NotNull final Path p0, final boolean p1) throws IOException;
    
    @NotNull
    public final Sink appendingSink(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.appendingSink(path, false);
    }
    
    public abstract void createDirectory(@NotNull final Path p0, final boolean p1) throws IOException;
    
    public final void createDirectory(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        this.createDirectory(path, false);
    }
    
    public final void createDirectories(@NotNull final Path path, final boolean b) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        DFileSystem.commonCreateDirectories(this, path, b);
    }
    
    public final void createDirectories(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        this.createDirectories(path, false);
    }
    
    public abstract void atomicMove(@NotNull final Path p0, @NotNull final Path p1) throws IOException;
    
    public void copy(@NotNull final Path path, @NotNull final Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        DFileSystem.commonCopy(this, path, path2);
    }
    
    public abstract void delete(@NotNull final Path p0, final boolean p1) throws IOException;
    
    public final void delete(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        this.delete(path, false);
    }
    
    public void deleteRecursively(@NotNull final Path path, final boolean b) throws IOException {
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        DFileSystem.commonDeleteRecursively(this, path, b);
    }
    
    public final void deleteRecursively(@NotNull final Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        this.deleteRecursively(path, false);
    }
    
    public abstract void createSymlink(@NotNull final Path p0, @NotNull final Path p1) throws IOException;
    
    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    public static final FileSystem get(@NotNull final java.nio.file.FileSystem fileSystem) {
        return FileSystem.Companion.get(fileSystem);
    }
    
    static {
        Companion = new Companion(null);
        final Companion companion = FileSystem.Companion;
        JvmSystemFileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        }
        catch (final ClassNotFoundException ex) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        final Path.Companion companion2 = Path.Companion;
        final String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion2, property, false, 1, null);
        final ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader, false, null, 4, null);
    }
    
    @Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lokio/FileSystem$Companion;", "", "()V", "RESOURCES", "Lokio/FileSystem;", "SYSTEM", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "asOkioFileSystem", "Ljava/nio/file/FileSystem;", "get", "okio" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        public final FileSystem get(@NotNull final java.nio.file.FileSystem fileSystem) {
            Intrinsics.checkNotNullParameter(fileSystem, "<this>");
            return new NioFileSystemWrappingFileSystem(fileSystem);
        }
    }
}
