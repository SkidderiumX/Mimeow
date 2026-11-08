package kotlin.io.path;

import org.jetbrains.annotations.*;
import java.util.*;
import kotlin.jvm.internal.*;
import java.io.*;
import java.nio.file.*;
import kotlin.*;
import kotlin.io.*;
import kotlin.jvm.functions.*;
import java.nio.file.attribute.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 49, d1 = { "\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\r\u001a&\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005H\u0082\b¢\u0006\u0004\b\u0010\u0010\u0011\u001aw\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007\u001a´\u0001\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2C\b\u0002\u0010 \u001a=\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\"0\u0015¢\u0006\u0002\b#H\u0007\u001a\f\u0010$\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u001b\u0010%\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0&*\u00020\tH\u0002¢\u0006\u0002\b'\u001a'\u0010(\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b*\u001a'\u0010+\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b,\u001a5\u0010-\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010.\u001a\u00020\t2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020100\"\u000201H\u0002¢\u0006\u0004\b2\u00103\u001a\u0011\u00104\u001a\u000205*\u00020\"H\u0003¢\u0006\u0002\b6\u001a\u0011\u00104\u001a\u000205*\u00020\u001cH\u0003¢\u0006\u0002\b6¨\u00067" }, d2 = { "collectIfThrows", "", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "Ljava/nio/file/Path;", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "copyToRecursively", "target", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "deleteRecursively", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "Ljava/nio/file/SecureDirectoryStream;", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "handleEntry", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7" }, xs = "kotlin/io/path/PathsKt")
@SourceDebugExtension({ "SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,420:1\n336#1,2:424\n344#1:426\n344#1:427\n338#1,4:428\n336#1,2:432\n344#1:434\n338#1,4:435\n344#1:439\n336#1,6:440\n336#1,2:446\n344#1:448\n338#1,4:449\n1#2:421\n1855#3,2:422\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n352#1:424,2\n361#1:426\n364#1:427\n352#1:428,4\n372#1:432,2\n373#1:434\n372#1:435,4\n384#1:439\n392#1:440,6\n410#1:446,2\n411#1:448\n410#1:449,4\n274#1:422,2\n*E\n" })
public class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt
{
    @ExperimentalPathApi
    @SinceKotlin(version = "1.8")
    @NotNull
    public static final Path copyToRecursively(@NotNull final Path path, @NotNull final Path path2, @NotNull final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, final boolean b, final boolean b2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(function3, "onError");
        return b2 ? copyToRecursively(path, path2, function3, b, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>)new PathsKt__PathRecursiveFunctionsKt$copyToRecursively.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2(b)) : copyToRecursively$default(path, path2, function3, b, null, 8, null);
    }
    
    @ExperimentalPathApi
    @SinceKotlin(version = "1.8")
    @NotNull
    public static final Path copyToRecursively(@NotNull final Path path, @NotNull final Path path2, @NotNull final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, final boolean b, @NotNull final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function4) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(function3, "onError");
        Intrinsics.checkNotNullParameter(function4, "copyAction");
        final LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(b);
        final LinkOption[] original = Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.exists(path, (LinkOption[])Arrays.copyOf(original, original.length))) {
            throw new NoSuchFileException(path.toString(), path2.toString(), "The source file doesn't exist.");
        }
        final LinkOption[] original2 = new LinkOption[0];
        if (Files.exists(path, (LinkOption[])Arrays.copyOf(original2, original2.length)) && (b || !Files.isSymbolicLink(path))) {
            final LinkOption[] original3 = new LinkOption[0];
            final boolean b2 = Files.exists(path2, (LinkOption[])Arrays.copyOf(original3, original3.length)) && !Files.isSymbolicLink(path2);
            if (!b2 || !Files.isSameFile(path, path2)) {
                boolean startsWith;
                if (!Intrinsics.areEqual(path.getFileSystem(), path2.getFileSystem())) {
                    startsWith = false;
                }
                else if (b2) {
                    startsWith = path2.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]));
                }
                else {
                    final Path parent = path2.getParent();
                    if (parent != null) {
                        final Path path3 = parent;
                        final LinkOption[] original4 = new LinkOption[0];
                        startsWith = (Files.exists(path3, (LinkOption[])Arrays.copyOf(original4, original4.length)) && path3.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0])));
                    }
                    else {
                        startsWith = false;
                    }
                }
                if (startsWith) {
                    throw new FileSystemException(path.toString(), path2.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                }
            }
        }
        PathsKt__PathUtilsKt.visitFileTree$default(path, 0, b, (Function1)new PathsKt__PathRecursiveFunctionsKt$copyToRecursively.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5((Function3)function4, path, path2, (Function3)function3), 1, null);
        return path2;
    }
    
    public static /* synthetic */ Path copyToRecursively$default(final Path path, final Path path2, Function3 function3, final boolean b, Function3 function4, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            function3 = (Function3)PathsKt__PathRecursiveFunctionsKt$copyToRecursively.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3.INSTANCE;
        }
        if ((n & 0x8) != 0x0) {
            function4 = (Function3)new PathsKt__PathRecursiveFunctionsKt$copyToRecursively.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4(b);
        }
        return copyToRecursively(path, path2, function3, b, function4);
    }
    
    @ExperimentalPathApi
    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(final CopyActionResult copyActionResult) {
        return switch (WhenMappings.$EnumSwitchMapping$0[copyActionResult.ordinal()]) {
            case 1 -> FileVisitResult.CONTINUE;
            case 2 -> FileVisitResult.TERMINATE;
            case 3 -> FileVisitResult.SKIP_SUBTREE;
            default -> throw new NoWhenBranchMatchedException();
        };
    }
    
    @ExperimentalPathApi
    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(final OnErrorResult onErrorResult) {
        return switch (WhenMappings.$EnumSwitchMapping$1[onErrorResult.ordinal()]) {
            case 1 -> FileVisitResult.TERMINATE;
            case 2 -> FileVisitResult.SKIP_SUBTREE;
            default -> throw new NoWhenBranchMatchedException();
        };
    }
    
    @ExperimentalPathApi
    @SinceKotlin(version = "1.8")
    public static final void deleteRecursively(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(path);
        if (!deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt.isEmpty()) {
            final FileSystemException ex = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            final Iterator iterator = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt.iterator();
            while (iterator.hasNext()) {
                ExceptionsKt__ExceptionsKt.addSuppressed(ex, (Throwable)iterator.next());
            }
            throw ex;
        }
    }
    
    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(final Path path) {
        final ExceptionsCollector exceptionsCollector = new ExceptionsCollector(0, 1, null);
        boolean b = true;
        final Path parent = path.getParent();
        if (parent != null) {
            final Path path2 = parent;
            DirectoryStream<Path> directoryStream;
            try {
                directoryStream = Files.newDirectoryStream(path2);
            }
            catch (final Throwable t) {
                directoryStream = null;
            }
            final DirectoryStream<Path> directoryStream2 = directoryStream;
            if (directoryStream2 != null) {
                final Closeable closeable = directoryStream2;
                Throwable t2 = null;
                try {
                    final DirectoryStream directoryStream3 = (DirectoryStream)closeable;
                    if (directoryStream3 instanceof SecureDirectoryStream) {
                        b = false;
                        exceptionsCollector.setPath(path2);
                        final SecureDirectoryStream<Path> secureDirectoryStream = (SecureDirectoryStream<Path>)directoryStream3;
                        final Path fileName = path.getFileName();
                        Intrinsics.checkNotNullExpressionValue(fileName, "this.fileName");
                        handleEntry$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, fileName, exceptionsCollector);
                    }
                    final Unit instance = Unit.INSTANCE;
                }
                catch (final Throwable t3) {
                    t2 = t3;
                    throw t3;
                }
                finally {
                    CloseableKt.closeFinally(closeable, t2);
                }
            }
        }
        if (b) {
            insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(path, exceptionsCollector);
        }
        return exceptionsCollector.getCollectedExceptions();
    }
    
    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(final ExceptionsCollector exceptionsCollector, final Function0<Unit> function0) {
        try {
            function0.invoke();
        }
        catch (final Exception ex) {
            exceptionsCollector.collect(ex);
        }
    }
    
    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(final Function0<? extends R> function0) {
        R invoke;
        try {
            invoke = (R)function0.invoke();
        }
        catch (final NoSuchFileException ex) {
            invoke = null;
        }
        return invoke;
    }
    
    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(final SecureDirectoryStream<Path> secureDirectoryStream, final Path path, final ExceptionsCollector exceptionsCollector) {
        exceptionsCollector.enterEntry(path);
        try {
            if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                final int totalExceptions = exceptionsCollector.getTotalExceptions();
                enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, exceptionsCollector);
                if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                    try {
                        secureDirectoryStream.deleteDirectory(path);
                        final Unit instance = Unit.INSTANCE;
                    }
                    catch (final NoSuchFileException ex) {}
                }
            }
            else {
                try {
                    secureDirectoryStream.deleteFile(path);
                    final Unit instance2 = Unit.INSTANCE;
                }
                catch (final NoSuchFileException ex2) {}
            }
        }
        catch (final Exception ex3) {
            exceptionsCollector.collect(ex3);
        }
        exceptionsCollector.exitEntry(path);
    }
    
    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(final SecureDirectoryStream<Path> secureDirectoryStream, final Path path, final ExceptionsCollector exceptionsCollector) {
        try {
            SecureDirectoryStream<Path> directoryStream;
            try {
                directoryStream = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            }
            catch (final NoSuchFileException ex) {
                directoryStream = null;
            }
            final SecureDirectoryStream<Path> secureDirectoryStream2 = directoryStream;
            if (secureDirectoryStream2 != null) {
                final Closeable closeable = secureDirectoryStream2;
                Throwable t = null;
                try {
                    final SecureDirectoryStream secureDirectoryStream3 = (SecureDirectoryStream)closeable;
                    for (final Path path2 : secureDirectoryStream3) {
                        final SecureDirectoryStream secureDirectoryStream4 = secureDirectoryStream3;
                        final Path fileName = path2.getFileName();
                        Intrinsics.checkNotNullExpressionValue(fileName, "entry.fileName");
                        handleEntry$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream4, fileName, exceptionsCollector);
                    }
                    final Unit instance = Unit.INSTANCE;
                }
                catch (final Throwable t2) {
                    t = t2;
                    throw t2;
                }
                finally {
                    CloseableKt.closeFinally(closeable, t);
                }
            }
        }
        catch (final Exception ex2) {
            exceptionsCollector.collect(ex2);
        }
    }
    
    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(final SecureDirectoryStream<Path> secureDirectoryStream, final Path path, final LinkOption... original) {
        Boolean value;
        try {
            value = secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[])Arrays.copyOf(original, original.length)).readAttributes().isDirectory();
        }
        catch (final NoSuchFileException ex) {
            value = null;
        }
        final Boolean b = value;
        return b != null && b;
    }
    
    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(final Path path, final ExceptionsCollector exceptionsCollector) {
        try {
            final LinkOption[] original = { LinkOption.NOFOLLOW_LINKS };
            if (Files.isDirectory(path, (LinkOption[])Arrays.copyOf(original, original.length))) {
                final int totalExceptions = exceptionsCollector.getTotalExceptions();
                insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(path, exceptionsCollector);
                if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                    Files.deleteIfExists(path);
                }
            }
            else {
                Files.deleteIfExists(path);
            }
        }
        catch (final Exception ex) {
            exceptionsCollector.collect(ex);
        }
    }
    
    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(final Path dir, final ExceptionsCollector exceptionsCollector) {
        try {
            DirectoryStream<Path> directoryStream;
            try {
                directoryStream = Files.newDirectoryStream(dir);
            }
            catch (final NoSuchFileException ex) {
                directoryStream = null;
            }
            final DirectoryStream<Path> directoryStream2 = directoryStream;
            if (directoryStream2 != null) {
                final Closeable closeable = directoryStream2;
                Throwable t = null;
                try {
                    for (final Path path : (DirectoryStream)closeable) {
                        Intrinsics.checkNotNullExpressionValue(path, "entry");
                        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(path, exceptionsCollector);
                    }
                    final Unit instance = Unit.INSTANCE;
                }
                catch (final Throwable t2) {
                    t = t2;
                    throw t2;
                }
                finally {
                    CloseableKt.closeFinally(closeable, t);
                }
            }
        }
        catch (final Exception ex2) {
            exceptionsCollector.collect(ex2);
        }
    }
    
    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(final Path path, final Path path2, final Path path3) {
        final Path resolve = path2.resolve(PathsKt__PathUtilsKt.relativeTo(path3, path).toString());
        Intrinsics.checkNotNullExpressionValue(resolve, "target.resolve(relativePath.pathString)");
        return resolve;
    }
    
    private static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, final Path path, final Path path2, final Path path3, final Exception ex) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((OnErrorResult)function3.invoke(path3, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3), ex));
    }
    
    private static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, final Path path, final Path path2, final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function4, final Path path3, final BasicFileAttributes basicFileAttributes) {
        FileVisitResult fileVisitResult;
        try {
            fileVisitResult = toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((CopyActionResult)function3.invoke(DefaultCopyActionContext.INSTANCE, path3, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3)));
        }
        catch (final Exception ex) {
            fileVisitResult = copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function4, path, path2, path3, ex);
        }
        return fileVisitResult;
    }
}
