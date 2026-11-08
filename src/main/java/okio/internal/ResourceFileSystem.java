package okio.internal;

import kotlin.jvm.internal.*;
import kotlin.collections.*;
import org.jetbrains.annotations.*;
import okio.*;
import java.util.*;
import java.io.*;
import kotlin.*;
import kotlin.text.*;
import java.net.*;
import kotlin.jvm.functions.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J \u0010&\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u001e\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n0\t*\u00020\u0003H\u0002J\u001a\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n*\u00020+H\u0002J\u001a\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n*\u00020+H\u0002J\f\u0010-\u001a\u00020.*\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060" }, d2 = { "Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", "", "systemFileSystem", "(Ljava/lang/ClassLoader;ZLokio/FileSystem;)V", "roots", "", "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "appendingSink", "Lokio/Sink;", "file", "mustExist", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toClasspathRoots", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "toRelativePath", "", "Companion", "okio" })
@SourceDebugExtension({ "SMAP\nResourceFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n766#2:211\n857#2,2:212\n1549#2:214\n1620#2,3:215\n766#2:218\n857#2,2:219\n1549#2:221\n1620#2,3:222\n1603#2,9:225\n1855#2:234\n1856#2:236\n1612#2:237\n1603#2,9:238\n1855#2:247\n1856#2:249\n1612#2:250\n1#3:235\n1#3:248\n*S KotlinDebug\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n*L\n74#1:211\n74#1:212,2\n75#1:214\n75#1:215,3\n90#1:218\n90#1:219,2\n91#1:221\n91#1:222,3\n173#1:225,9\n173#1:234\n173#1:236\n173#1:237\n174#1:238,9\n174#1:247\n174#1:249\n174#1:250\n173#1:235\n174#1:248\n*E\n" })
public class ResourceFileSystem extends FileSystem
{
    @NotNull
    private static final Companion Companion;
    @NotNull
    private final ClassLoader classLoader;
    @NotNull
    private final FileSystem systemFileSystem;
    @NotNull
    private final Lazy roots$delegate;
    @NotNull
    private static final Path ROOT;
    
    public ResourceFileSystem(@NotNull final ClassLoader classLoader, final boolean b, @NotNull final FileSystem systemFileSystem) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(systemFileSystem, "systemFileSystem");
        this.classLoader = classLoader;
        this.systemFileSystem = systemFileSystem;
        this.roots$delegate = LazyKt__LazyJVMKt.lazy((Function0<?>)new ResourceFileSystem$roots.ResourceFileSystem$roots$2(this));
        if (b) {
            this.getRoots().size();
        }
    }
    
    private final List<Pair<FileSystem, Path>> getRoots() {
        return this.roots$delegate.getValue();
    }
    
    @NotNull
    @Override
    public Path canonicalize(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.canonicalizeInternal(path);
    }
    
    private final Path canonicalizeInternal(final Path path) {
        return ResourceFileSystem.ROOT.resolve(path, true);
    }
    
    @NotNull
    @Override
    public List<Path> list(@NotNull final Path obj) {
        Intrinsics.checkNotNullParameter(obj, "dir");
        final String relativePath = this.toRelativePath(obj);
        final Set set = new LinkedHashSet();
        boolean b = false;
        for (final Pair pair : this.getRoots()) {
            final FileSystem fileSystem = (FileSystem)pair.component1();
            final Path path = (Path)pair.component2();
            try {
                final Collection collection = set;
                final Iterable iterable = fileSystem.list(path.resolve(relativePath));
                final Collection collection2 = new ArrayList();
                for (final Object next : iterable) {
                    if (ResourceFileSystem.Companion.keepPath((Path)next)) {
                        collection2.add(next);
                    }
                }
                final Iterable iterable2;
                final Collection collection3 = new ArrayList<Path>(CollectionsKt__IterablesKt.collectionSizeOrDefault((Iterable<?>)(iterable2 = collection2), 10));
                final Iterator iterator3 = iterable2.iterator();
                while (iterator3.hasNext()) {
                    collection3.add(ResourceFileSystem.Companion.removeBase((Path)iterator3.next(), path));
                }
                CollectionsKt__MutableCollectionsKt.addAll((Collection<? super Object>)collection, (Iterable<?>)(List<? extends T>)collection3);
                b = true;
            }
            catch (final IOException ex) {}
        }
        if (!b) {
            throw new FileNotFoundException("file not found: " + obj);
        }
        return (List<Path>)CollectionsKt___CollectionsKt.toList((Iterable<?>)set);
    }
    
    @Nullable
    @Override
    public List<Path> listOrNull(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        final String relativePath = this.toRelativePath(path);
        final Set set = new LinkedHashSet();
        boolean b = false;
        for (final Pair pair : this.getRoots()) {
            final FileSystem fileSystem = (FileSystem)pair.component1();
            final Path path2 = (Path)pair.component2();
            final List<Path> listOrNull = fileSystem.listOrNull(path2.resolve(relativePath));
            List list;
            if (listOrNull != null) {
                final Iterable iterable = listOrNull;
                final Collection collection = new ArrayList();
                for (final Object next : iterable) {
                    if (ResourceFileSystem.Companion.keepPath((Path)next)) {
                        collection.add(next);
                    }
                }
                final Iterable iterable2;
                final Collection collection2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault((Iterable<?>)(iterable2 = collection), 10));
                final Iterator iterator3 = iterable2.iterator();
                while (iterator3.hasNext()) {
                    collection2.add(ResourceFileSystem.Companion.removeBase((Path)iterator3.next(), path2));
                }
                list = (List)collection2;
            }
            else {
                list = null;
            }
            final List list2 = list;
            if (list2 != null) {
                CollectionsKt__MutableCollectionsKt.addAll((Collection<? super Object>)set, (Iterable<?>)list2);
                b = true;
            }
        }
        return (List<Path>)(b ? CollectionsKt___CollectionsKt.toList((Iterable<?>)set) : null);
    }
    
    @NotNull
    @Override
    public FileHandle openReadOnly(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (!ResourceFileSystem.Companion.keepPath(path)) {
            throw new FileNotFoundException("file not found: " + path);
        }
        final String relativePath = this.toRelativePath(path);
        for (final Pair pair : this.getRoots()) {
            final FileSystem fileSystem = (FileSystem)pair.component1();
            final Path path2 = (Path)pair.component2();
            try {
                return fileSystem.openReadOnly(path2.resolve(relativePath));
            }
            catch (final FileNotFoundException ex) {
                continue;
            }
            break;
        }
        throw new FileNotFoundException("file not found: " + path);
    }
    
    @NotNull
    @Override
    public FileHandle openReadWrite(@NotNull final Path path, final boolean b, final boolean b2) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("resources are not writable");
    }
    
    @Nullable
    @Override
    public FileMetadata metadataOrNull(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!ResourceFileSystem.Companion.keepPath(path)) {
            return null;
        }
        final String relativePath = this.toRelativePath(path);
        for (final Pair pair : this.getRoots()) {
            final FileMetadata metadataOrNull = ((FileSystem)pair.component1()).metadataOrNull(((Path)pair.component2()).resolve(relativePath));
            if (metadataOrNull == null) {
                continue;
            }
            return metadataOrNull;
        }
        return null;
    }
    
    @NotNull
    @Override
    public Source source(@NotNull final Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (!ResourceFileSystem.Companion.keepPath(path)) {
            throw new FileNotFoundException("file not found: " + path);
        }
        final InputStream resourceAsStream = this.classLoader.getResourceAsStream(Path.resolve$default(ResourceFileSystem.ROOT, path, false, 2, null).relativeTo(ResourceFileSystem.ROOT).toString());
        if (resourceAsStream != null) {
            final Source source = Okio.source(resourceAsStream);
            if (source != null) {
                return source;
            }
        }
        throw new FileNotFoundException("file not found: " + path);
    }
    
    @NotNull
    @Override
    public Sink sink(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException(this + " is read-only");
    }
    
    @NotNull
    @Override
    public Sink appendingSink(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException(this + " is read-only");
    }
    
    @Override
    public void createDirectory(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "dir");
        throw new IOException(this + " is read-only");
    }
    
    @Override
    public void atomicMove(@NotNull final Path path, @NotNull final Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException(this + " is read-only");
    }
    
    @Override
    public void delete(@NotNull final Path path, final boolean b) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }
    
    @Override
    public void createSymlink(@NotNull final Path path, @NotNull final Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException(this + " is read-only");
    }
    
    private final String toRelativePath(final Path path) {
        return this.canonicalizeInternal(path).relativeTo(ResourceFileSystem.ROOT).toString();
    }
    
    private final List<Pair<FileSystem, Path>> toClasspathRoots(final ClassLoader classLoader) {
        final Enumeration<URL> resources = classLoader.getResources("");
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        final ArrayList<Object> list = Collections.list((Enumeration<Object>)resources);
        Intrinsics.checkNotNullExpressionValue(list, "list(this)");
        final Iterable iterable = list;
        final Collection collection = new ArrayList();
        for (final URL url : iterable) {
            Intrinsics.checkNotNull(url);
            final Pair<FileSystem, Path> fileRoot = this.toFileRoot(url);
            if (fileRoot != null) {
                collection.add(fileRoot);
            }
        }
        final Collection collection2 = collection;
        final Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        final ArrayList<Object> list2 = Collections.list((Enumeration<Object>)resources2);
        Intrinsics.checkNotNullExpressionValue(list2, "list(this)");
        final Iterable iterable2 = list2;
        final Collection collection3 = collection2;
        final Iterable iterable3 = iterable2;
        final Collection collection4 = new ArrayList<Pair<FileSystem, Path>>();
        for (final URL url2 : iterable3) {
            Intrinsics.checkNotNull(url2);
            final Pair<FileSystem, Path> jarRoot = this.toJarRoot(url2);
            if (jarRoot != null) {
                collection4.add(jarRoot);
            }
        }
        return (List<Pair<FileSystem, Path>>)CollectionsKt___CollectionsKt.plus((Collection<?>)collection3, (Iterable<?>)(List<? extends T>)collection4);
    }
    
    private final Pair<FileSystem, Path> toFileRoot(final URL url) {
        if (!Intrinsics.areEqual(url.getProtocol(), "file")) {
            return null;
        }
        return TuplesKt.mcc4e6a6012(this.systemFileSystem, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, null));
    }
    
    private final Pair<FileSystem, Path> toJarRoot(final URL url) {
        final String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        final String s = string;
        if (!StringsKt__StringsJVMKt.startsWith$default(s, "jar:file:", false, 2, null)) {
            return null;
        }
        final int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(s, "!", 0, false, 6, null);
        if (lastIndexOf$default == -1) {
            return null;
        }
        final Path.Companion companion = Path.Companion;
        final String substring = s.substring(4, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return (Pair<FileSystem, Path>)TuplesKt.mcc4e6a6012(ZipFilesKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, null), this.systemFileSystem, (Function1<? super ZipEntry, Boolean>)ResourceFileSystem$toJarRoot$zip.ResourceFileSystem$toJarRoot$zip$1.INSTANCE), ResourceFileSystem.ROOT);
    }
    
    public static final /* synthetic */ Path access$getROOT$cp() {
        return ResourceFileSystem.ROOT;
    }
    
    static {
        Companion = new Companion(null);
        ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, null);
    }
    
    @Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f" }, d2 = { "Lokio/internal/ResourceFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "keepPath", "", "path", "removeBase", "base", "okio" })
    private static final class Companion
    {
        @NotNull
        public final Path getROOT() {
            return ResourceFileSystem.access$getROOT$cp();
        }
        
        @NotNull
        public final Path removeBase(@NotNull final Path path, @NotNull final Path path2) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            Intrinsics.checkNotNullParameter(path2, "base");
            return this.getROOT().resolve(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsKt.removePrefix(path.toString(), path2.toString()), '\\', '/', false, 4, null));
        }
        
        private final boolean keepPath(final Path path) {
            return !StringsKt__StringsJVMKt.endsWith(path.name(), ".class", true);
        }
    }
}
