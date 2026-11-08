/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileHandle;
import okio.FileMetadata;
import okio.NioFileSystemFileHandle;
import okio.NioSystemFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J \u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\f\u0010#\u001a\u00020$*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Lokio/NioFileSystemWrappingFileSystem;", "Lokio/NioSystemFileSystem;", "nioFileSystem", "Ljava/nio/file/FileSystem;", "(Ljava/nio/file/FileSystem;)V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "", "resolve", "Ljava/nio/file/Path;", "okio"})
@SourceDebugExtension(value={"SMAP\nNioFileSystemWrappingFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,192:1\n1620#2,3:193\n1#3:196\n37#4,2:197\n37#4,2:199\n37#4,2:201\n*S KotlinDebug\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n*L\n77#1:193,3\n104#1:197,2\n125#1:199,2\n138#1:201,2\n*E\n"})
public class NioFileSystemWrappingFileSystem
extends NioSystemFileSystem {
    @NotNull
    private final FileSystem nioFileSystem;

    public NioFileSystemWrappingFileSystem(@NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(fileSystem, "nioFileSystem");
        this.nioFileSystem = fileSystem;
    }

    private final java.nio.file.Path resolve(Path path) {
        java.nio.file.Path path2 = this.nioFileSystem.getPath(path.toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return path2;
    }

    @Override
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            java.nio.file.Path path2 = this.resolve(path).toRealPath(new LinkOption[0]);
            Intrinsics.checkNotNullExpressionValue(path2, "toRealPath(...)");
            return Path.Companion.get$default(Path.Companion, path2, false, 1, null);
        }
        catch (NoSuchFileException noSuchFileException) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.metadataOrNull(this.resolve(path));
    }

    @Override
    @NotNull
    public List<Path> list(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        List<Path> list = this.list(path, true);
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override
    @Nullable
    public List<Path> listOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return this.list(path, false);
    }

    private final List<Path> list(Path path, boolean bl) {
        List list;
        java.nio.file.Path path2 = this.resolve(path);
        try {
            list = PathsKt.listDirectoryEntries$default(path2, null, 1, null);
        }
        catch (Exception exception) {
            if (bl) {
                LinkOption[] linkOptionArray = new LinkOption[]{};
                if (!Files.exists(path2, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
                    throw new FileNotFoundException("no such file: " + path);
                }
                throw new IOException("failed to list " + path);
            }
            return null;
        }
        List list2 = list;
        Iterable iterable = list2;
        Collection collection = new ArrayList();
        boolean bl2 = false;
        for (Object t : iterable) {
            java.nio.file.Path path3 = (java.nio.file.Path)t;
            Collection collection2 = collection;
            boolean bl3 = false;
            collection2.add(Path.Companion.get$default(Path.Companion, path3, false, 1, null));
        }
        list = (List)collection;
        CollectionsKt.sort(list);
        return list;
    }

    @Override
    @NotNull
    public FileHandle openReadOnly(@NotNull Path path) {
        Object object;
        Intrinsics.checkNotNullParameter(path, "file");
        try {
            object = new OpenOption[]{StandardOpenOption.READ};
            object = FileChannel.open(this.resolve(path), object);
        }
        catch (NoSuchFileException noSuchFileException) {
            throw new FileNotFoundException("no such file: " + path);
        }
        Object object2 = object;
        Intrinsics.checkNotNull(object2);
        return new NioFileSystemFileHandle(false, (FileChannel)object2);
    }

    @Override
    @NotNull
    public FileHandle openReadWrite(@NotNull Path path, boolean bl, boolean bl2) {
        StandardOpenOption[] standardOpenOptionArray;
        Intrinsics.checkNotNullParameter(path, "file");
        if (!(!bl || !bl2)) {
            boolean bl3 = false;
            String string = "Cannot require mustCreate and mustExist at the same time.";
            throw new IllegalArgumentException(string.toString());
        }
        Object object = standardOpenOptionArray = CollectionsKt.createListBuilder();
        boolean bl4 = false;
        object.add(StandardOpenOption.READ);
        object.add(StandardOpenOption.WRITE);
        if (bl) {
            object.add(StandardOpenOption.CREATE_NEW);
        } else if (!bl2) {
            object.add(StandardOpenOption.CREATE);
        }
        List list = CollectionsKt.build(standardOpenOptionArray);
        try {
            Collection collection = list;
            boolean bl5 = false;
            Collection collection2 = collection;
            object = collection2.toArray(new StandardOpenOption[0]);
            object = FileChannel.open(this.resolve(path), Arrays.copyOf(object, ((StandardOpenOption[])object).length));
        }
        catch (NoSuchFileException noSuchFileException) {
            throw new FileNotFoundException("no such file: " + path);
        }
        standardOpenOptionArray = object;
        Intrinsics.checkNotNull(standardOpenOptionArray);
        return new NioFileSystemFileHandle(true, (FileChannel)standardOpenOptionArray);
    }

    @Override
    @NotNull
    public Source source(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        try {
            OpenOption[] openOptionArray = new OpenOption[]{};
            InputStream inputStream2 = Files.newInputStream(this.resolve(path), Arrays.copyOf(openOptionArray, openOptionArray.length));
            Intrinsics.checkNotNullExpressionValue(inputStream2, "newInputStream(this, *options)");
            return Okio.source(inputStream2);
        }
        catch (NoSuchFileException noSuchFileException) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override
    @NotNull
    public Sink sink(@NotNull Path path, boolean bl) {
        Intrinsics.checkNotNullParameter(path, "file");
        Object object = CollectionsKt.createListBuilder();
        OpenOption[] openOptionArray = object;
        boolean bl2 = false;
        if (bl) {
            openOptionArray.add(StandardOpenOption.CREATE_NEW);
        }
        List list = CollectionsKt.build(object);
        try {
            object = this.resolve(path);
            Collection collection = list;
            boolean bl3 = false;
            Collection collection2 = collection;
            openOptionArray = collection2.toArray(new StandardOpenOption[0]);
            openOptionArray = Arrays.copyOf(openOptionArray, openOptionArray.length);
            OutputStream outputStream2 = Files.newOutputStream((java.nio.file.Path)object, Arrays.copyOf(openOptionArray, openOptionArray.length));
            Intrinsics.checkNotNullExpressionValue(outputStream2, "newOutputStream(this, *options)");
            return Okio.sink(outputStream2);
        }
        catch (NoSuchFileException noSuchFileException) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override
    @NotNull
    public Sink appendingSink(@NotNull Path path, boolean bl) {
        Intrinsics.checkNotNullParameter(path, "file");
        Object object = CollectionsKt.createListBuilder();
        OpenOption[] openOptionArray = object;
        boolean bl2 = false;
        openOptionArray.add(StandardOpenOption.APPEND);
        if (!bl) {
            openOptionArray.add(StandardOpenOption.CREATE);
        }
        List list = CollectionsKt.build(object);
        object = this.resolve(path);
        Collection collection = list;
        boolean bl3 = false;
        Collection collection2 = collection;
        openOptionArray = collection2.toArray(new StandardOpenOption[0]);
        openOptionArray = Arrays.copyOf(openOptionArray, openOptionArray.length);
        OutputStream outputStream2 = Files.newOutputStream((java.nio.file.Path)object, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue(outputStream2, "newOutputStream(this, *options)");
        return Okio.sink(outputStream2);
    }

    @Override
    public void createDirectory(@NotNull Path path, boolean bl) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(path, "dir");
        FileMetadata fileMetadata = this.metadataOrNull(path);
        boolean bl3 = fileMetadata != null ? fileMetadata.isDirectory() : (bl2 = false);
        if (bl2 && bl) {
            throw new IOException(path + " already exists.");
        }
        try {
            FileAttribute[] fileAttributeArray = new FileAttribute[]{};
            Intrinsics.checkNotNullExpressionValue(Files.createDirectory(this.resolve(path), Arrays.copyOf(fileAttributeArray, fileAttributeArray.length)), "createDirectory(this, *attributes)");
        }
        catch (IOException iOException) {
            if (bl2) {
                return;
            }
            throw new IOException("failed to create directory: " + path, iOException);
        }
    }

    @Override
    public void atomicMove(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        try {
            java.nio.file.Path path3 = this.resolve(path);
            java.nio.file.Path path4 = this.resolve(path2);
            CopyOption[] copyOptionArray = new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING};
            Intrinsics.checkNotNullExpressionValue(Files.move(path3, path4, Arrays.copyOf(copyOptionArray, copyOptionArray.length)), "move(this, target, *options)");
        }
        catch (NoSuchFileException noSuchFileException) {
            throw new FileNotFoundException(noSuchFileException.getMessage());
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            throw new IOException("atomic move not supported");
        }
    }

    @Override
    public void delete(@NotNull Path path, boolean bl) {
        block5: {
            Intrinsics.checkNotNullParameter(path, "path");
            if (Thread.interrupted()) {
                throw new InterruptedIOException("interrupted");
            }
            java.nio.file.Path path2 = this.resolve(path);
            try {
                Files.delete(path2);
            }
            catch (NoSuchFileException noSuchFileException) {
                if (bl) {
                    throw new FileNotFoundException("no such file: " + path);
                }
            }
            catch (IOException iOException) {
                LinkOption[] linkOptionArray = new LinkOption[]{};
                if (!Files.exists(path2, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) break block5;
                throw new IOException("failed to delete " + path);
            }
        }
    }

    @Override
    public void createSymlink(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        FileAttribute[] fileAttributeArray = new FileAttribute[]{};
        Intrinsics.checkNotNullExpressionValue(Files.createSymbolicLink(this.resolve(path), this.resolve(path2), Arrays.copyOf(fileAttributeArray, fileAttributeArray.length)), "createSymbolicLink(this, target, *attributes)");
    }

    @Override
    @NotNull
    public String toString() {
        String string = Reflection.getOrCreateKotlinClass(this.nioFileSystem.getClass()).getSimpleName();
        Intrinsics.checkNotNull(string);
        return string;
    }
}

