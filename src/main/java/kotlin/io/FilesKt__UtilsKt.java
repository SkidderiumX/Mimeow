package kotlin.io;

import org.jetbrains.annotations.*;
import java.io.*;
import kotlin.text.*;
import kotlin.collections.*;
import kotlin.jvm.functions.*;
import kotlin.jvm.internal.*;
import kotlin.*;
import kotlin.sequences.*;
import java.util.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 49, d1 = { "\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+" }, d2 = { "extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib" }, xs = "kotlin/io/FilesKt")
@SourceDebugExtension({ "SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1284#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n" })
public class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt
{
    @kotlin.Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @NotNull
    @java.lang.Deprecated
    public static final File createTempDir(@NotNull final String prefix, @Nullable final String suffix, @Nullable final File directory) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        final File tempFile = File.createTempFile(prefix, suffix, directory);
        tempFile.delete();
        if (tempFile.mkdir()) {
            Intrinsics.checkNotNullExpressionValue(tempFile, "dir");
            return tempFile;
        }
        throw new IOException("Unable to create temporary directory " + tempFile + '.');
    }
    
    @kotlin.Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @NotNull
    @java.lang.Deprecated
    public static final File createTempFile(@NotNull final String prefix, @Nullable final String suffix, @Nullable final File directory) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        final File tempFile = File.createTempFile(prefix, suffix, directory);
        Intrinsics.checkNotNullExpressionValue(tempFile, "createTempFile(prefix, suffix, directory)");
        return tempFile;
    }
    
    @NotNull
    public static final String getExtension(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        final String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringAfterLast(name, '.', "");
    }
    
    @NotNull
    public static final String getInvariantSeparatorsPath(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String s;
        if (File.separatorChar != '/') {
            final String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "path");
            s = StringsKt__StringsJVMKt.replace$default(path, File.separatorChar, '/', false, 4, null);
        }
        else {
            Intrinsics.checkNotNullExpressionValue(s = file.getPath(), "path");
        }
        return s;
    }
    
    @NotNull
    public static final String getNameWithoutExtension(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        final String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringBeforeLast$default(name, ".", null, 2, null);
    }
    
    @NotNull
    public static final String toRelativeString(@NotNull final File obj, @NotNull final File obj2) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(obj2, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(obj, obj2);
        if (relativeStringOrNull$FilesKt__UtilsKt == null) {
            throw new IllegalArgumentException("this and base files have different roots: " + obj + " and " + obj2 + '.');
        }
        return relativeStringOrNull$FilesKt__UtilsKt;
    }
    
    @NotNull
    public static final File relativeTo(@NotNull final File file, @NotNull final File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "base");
        return new File(toRelativeString(file, file2));
    }
    
    @NotNull
    public static final File relativeToOrSelf(@NotNull final File file, @NotNull final File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        return (relativeStringOrNull$FilesKt__UtilsKt != null) ? new File(relativeStringOrNull$FilesKt__UtilsKt) : file;
    }
    
    @Nullable
    public static final File relativeToOrNull(@NotNull final File file, @NotNull final File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        return (relativeStringOrNull$FilesKt__UtilsKt != null) ? new File(relativeStringOrNull$FilesKt__UtilsKt) : null;
    }
    
    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(final File file, final File file2) {
        final FilePathComponents normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file));
        final FilePathComponents normalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file2));
        if (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getRoot(), normalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size;
        int size2;
        int n;
        for (size = normalize$FilesKt__UtilsKt2.getSize(), size2 = normalize$FilesKt__UtilsKt.getSize(), n = 0; n < Math.min(size2, size) && Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getSegments().get(n), normalize$FilesKt__UtilsKt2.getSegments().get(n)); ++n) {}
        final int n2 = n;
        final StringBuilder sb = new StringBuilder();
        int n3 = size - 1;
        Label_0198: {
            if (n2 <= n3) {
                while (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt2.getSegments().get(n3).getName(), "..")) {
                    sb.append("..");
                    if (n3 != n2) {
                        sb.append(File.separatorChar);
                    }
                    if (n3 == n2) {
                        break Label_0198;
                    }
                    --n3;
                }
                return null;
            }
        }
        if (n2 < size2) {
            if (n2 < size) {
                sb.append(File.separatorChar);
            }
            final Iterable iterable = CollectionsKt___CollectionsKt.drop((Iterable<?>)normalize$FilesKt__UtilsKt.getSegments(), n2);
            final Appendable appendable = sb;
            final String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            CollectionsKt___CollectionsKt.joinTo$default(iterable, appendable, separator, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }
    
    @NotNull
    public static final File copyTo(@NotNull final File p0, @NotNull final File p1, final boolean p2, final int p3) {
        // 
        Intrinsics.checkNotNullParameter(p0, "<this>");
        Intrinsics.checkNotNullParameter(p1, "target");
        if (!p0.exists()) {
            throw new NoSuchFileException(p0, null, "The source file doesn't exist.");
        }
        if (p1.exists()) {
            if (!p2) {
                throw new FileAlreadyExistsException(p0, p1, "The destination file already exists.");
            }
            if (!p1.delete()) {
                throw new FileAlreadyExistsException(p0, p1, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (p0.isDirectory()) {
            if (!p1.mkdirs()) {
                throw new FileSystemException(p0, p1, "Failed to create target directory.");
            }
        }
        else {
            final File parentFile = p1.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            final FileInputStream fileInputStream = new FileInputStream(p0);
            Throwable throwable = null;
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(p1);
                Throwable throwable2 = null;
                try {
                    kotlin.io.ByteStreamsKt.copyTo((InputStream)fileInputStream, (OutputStream)fileOutputStream, p3);
                }
                catch (Throwable t2) {
                    throwable2 = t2;
                    throw t2;
                }
                finally {
                    kotlin.io.CloseableKt.closeFinally((Closeable)fileOutputStream, throwable2);
                }
            }
            catch (Throwable t3) {
                throwable = t3;
                throw t3;
            }
            finally {
                kotlin.io.CloseableKt.closeFinally((Closeable)fileInputStream, throwable);
            }
        }
        return p1;
    }
    
    public static /* synthetic */ File copyTo$default(final File file, final File file2, boolean b, int n, final int n2, final Object o) {
        if ((n2 & 0x2) != 0x0) {
            b = false;
        }
        if ((n2 & 0x4) != 0x0) {
            n = 8192;
        }
        return copyTo(file, file2, b, n);
    }
    
    public static final boolean copyRecursively(@NotNull final File file, @NotNull final File parent, final boolean b, @NotNull final Function2<? super File, ? super IOException, ? extends OnErrorAction> function2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(parent, "target");
        Intrinsics.checkNotNullParameter(function2, "onError");
        if (!file.exists()) {
            return function2.invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            for (final File file2 : FilesKt__FileTreeWalkKt.walkTopDown(file).onFail((Function2<? super File, ? super IOException, Unit>)new FilesKt__UtilsKt$copyRecursively.FilesKt__UtilsKt$copyRecursively$2((Function2)function2))) {
                if (!file2.exists()) {
                    if (function2.invoke(file2, new NoSuchFileException(file2, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                    continue;
                }
                else {
                    final File file3 = new File(parent, toRelativeString(file2, file));
                    if (file3.exists() && (!file2.isDirectory() || !file3.isDirectory()) && (!b || !(file3.isDirectory() ? (!deleteRecursively(file3)) : (!file3.delete())))) {
                        if (function2.invoke(file3, new FileAlreadyExistsException(file2, file3, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                        continue;
                    }
                    else if (file2.isDirectory()) {
                        file3.mkdirs();
                    }
                    else {
                        if (copyTo$default(file2, file3, b, 0, 4, null).length() != file2.length() && function2.invoke(file2, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                        continue;
                    }
                }
            }
            return true;
        }
        catch (final TerminateException ex) {
            return false;
        }
    }
    
    public static final boolean deleteRecursively(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        final Sequence sequence = FilesKt__FileTreeWalkKt.walkBottomUp(file);
        int n = 1;
        for (final Object next : sequence) {
            final int n2 = n;
            final File file2 = (File)next;
            final int n3 = n2;
            n = (((file2.delete() || !file2.exists()) && n3 != 0) ? 1 : 0);
        }
        return n != 0;
    }
    
    public static final boolean startsWith(@NotNull final File file, @NotNull final File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "other");
        final FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        final FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(file2);
        return Intrinsics.areEqual(components.getRoot(), components2.getRoot()) && components.getSize() >= components2.getSize() && components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
    }
    
    public static final boolean startsWith(@NotNull final File file, @NotNull final String pathname) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(pathname, "other");
        return startsWith(file, new File(pathname));
    }
    
    public static final boolean endsWith(@NotNull final File file, @NotNull final File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "other");
        final FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        final FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(file2);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(file, file2);
        }
        final int n = components.getSize() - components2.getSize();
        return n >= 0 && components.getSegments().subList(n, components.getSize()).equals(components2.getSegments());
    }
    
    public static final boolean endsWith(@NotNull final File file, @NotNull final String pathname) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(pathname, "other");
        return endsWith(file, new File(pathname));
    }
    
    @NotNull
    public static final File normalize(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        final FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        final File root = components.getRoot();
        final Iterable iterable = normalize$FilesKt__UtilsKt(components.getSegments());
        final String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        return resolve(root, CollectionsKt___CollectionsKt.joinToString$default(iterable, separator, null, null, 0, null, null, 62, null));
    }
    
    private static final FilePathComponents normalize$FilesKt__UtilsKt(final FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }
    
    private static final List<File> normalize$FilesKt__UtilsKt(final List<? extends File> list) {
        final List list2 = new ArrayList(list.size());
        for (final File file : list) {
            final String name = file.getName();
            if (!Intrinsics.areEqual(name, ".")) {
                if (Intrinsics.areEqual(name, "..")) {
                    if (!list2.isEmpty() && !Intrinsics.areEqual(((File)CollectionsKt___CollectionsKt.last((List<?>)list2)).getName(), "..")) {
                        list2.remove(list2.size() - 1);
                    }
                    else {
                        list2.add(file);
                    }
                }
                else {
                    list2.add(file);
                }
            }
        }
        return list2;
    }
    
    @NotNull
    public static final File resolve(@NotNull final File file, @NotNull final File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(file2)) {
            return file2;
        }
        final String string = file.toString();
        Intrinsics.checkNotNullExpressionValue(string, "this.toString()");
        final String s = string;
        return (s.length() == 0 || StringsKt__StringsKt.endsWith$default(s, File.separatorChar, false, 2, null)) ? new File(s + file2) : new File(s + File.separatorChar + file2);
    }
    
    @NotNull
    public static final File resolve(@NotNull final File file, @NotNull final String pathname) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(pathname, "relative");
        return resolve(file, new File(pathname));
    }
    
    @NotNull
    public static final File resolveSibling(@NotNull final File file, @NotNull final File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "relative");
        final FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        return resolve(resolve(components.getRoot(), (components.getSize() == 0) ? new File("..") : components.subPath(0, components.getSize() - 1)), file2);
    }
    
    @NotNull
    public static final File resolveSibling(@NotNull final File file, @NotNull final String pathname) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(pathname, "relative");
        return resolveSibling(file, new File(pathname));
    }
}
