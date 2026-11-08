package kotlin.io.path;

import org.jetbrains.annotations.*;
import kotlin.collections.*;
import kotlin.*;
import kotlin.coroutines.*;
import java.util.*;
import java.nio.file.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.functions.*;
import kotlin.sequences.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0096\u0002JE\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0!\u0012\u0004\u0012\u00020\u00190 H\u0082H\u00f8\u0001\u0000¢\u0006\u0002\u0010\"R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#" }, d2 = { "Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "followLinks", "", "getFollowLinks", "()Z", "includeDirectories", "getIncludeDirectories", "isBFS", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "[Lkotlin/io/path/PathWalkOption;", "bfsIterator", "", "dfsIterator", "iterator", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-jdk7" })
@ExperimentalPathApi
public class PathTreeWalk implements Sequence<Path>
{
    @NotNull
    private final Path start;
    @NotNull
    private final PathWalkOption[] options;
    
    public PathTreeWalk(@NotNull final Path start, @NotNull final PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        this.start = start;
        this.options = options;
    }
    
    private final boolean getFollowLinks() {
        return ArraysKt___ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }
    
    private final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(this.getFollowLinks());
    }
    
    private final boolean getIncludeDirectories() {
        return ArraysKt___ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }
    
    private final boolean isBFS() {
        return ArraysKt___ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }
    
    @NotNull
    @Override
    public Iterator<Path> iterator() {
        return this.isBFS() ? this.bfsIterator() : this.dfsIterator();
    }
    
    private final Object yieldIfNeeded(final SequenceScope<? super Path> sequenceScope, final PathNode pathNode, final DirectoryEntriesReader directoryEntriesReader, final Function1<? super List<PathNode>, Unit> function1, final Continuation<? super Unit> continuation) {
        final Path path2;
        final Path path = path2 = pathNode.getPath();
        final LinkOption[] access$getLinkOptions = this.getLinkOptions();
        final LinkOption[] original = Arrays.copyOf(access$getLinkOptions, access$getLinkOptions.length);
        if (Files.isDirectory(path2, (LinkOption[])Arrays.copyOf(original, original.length))) {
            if (PathTreeWalkKt.access$createsCycle(pathNode)) {
                throw new FileSystemLoopException(path.toString());
            }
            if (this.getIncludeDirectories()) {
                final Path path3 = path;
                InlineMarker.mark(0);
                sequenceScope.m4eec8d92e8(path3, continuation);
                InlineMarker.mark(1);
            }
            final Path path4 = path;
            final LinkOption[] access$getLinkOptions2 = this.getLinkOptions();
            final LinkOption[] original2 = Arrays.copyOf(access$getLinkOptions2, access$getLinkOptions2.length);
            if (Files.isDirectory(path4, (LinkOption[])Arrays.copyOf(original2, original2.length))) {
                function1.invoke(directoryEntriesReader.readEntries(pathNode));
            }
        }
        else {
            final Path path5 = path;
            final LinkOption[] original3 = { LinkOption.NOFOLLOW_LINKS };
            if (Files.exists(path5, (LinkOption[])Arrays.copyOf(original3, original3.length))) {
                final Path path6 = path;
                InlineMarker.mark(0);
                sequenceScope.m4eec8d92e8(path6, continuation);
                InlineMarker.mark(1);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
    
    private final Iterator<Path> dfsIterator() {
        return SequencesKt__SequenceBuilderKt.iterator((Function2<? super SequenceScope<? super Path>, ? super Continuation<? super Unit>, ?>)new PathTreeWalk$dfsIterator.PathTreeWalk$dfsIterator$1(this, (Continuation)null));
    }
    
    private final Iterator<Path> bfsIterator() {
        return SequencesKt__SequenceBuilderKt.iterator((Function2<? super SequenceScope<? super Path>, ? super Continuation<? super Unit>, ?>)new PathTreeWalk$bfsIterator.PathTreeWalk$bfsIterator$1(this, (Continuation)null));
    }
}
