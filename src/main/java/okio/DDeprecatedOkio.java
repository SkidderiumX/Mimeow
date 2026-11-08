package okio;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.*;
import java.nio.file.*;
import java.util.*;
import java.net.*;
import java.io.*;

@Deprecated(message = "changed in Okio 2.x")
@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b" }, d2 = { "Lokio/DDeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio" })
public class DDeprecatedOkio
{
    @NotNull
    public static final DDeprecatedOkio INSTANCE;
    
    private DDeprecatedOkio() {
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.appendingSink()", imports = { "okio.appendingSink" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Sink appendingSink(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.appendingSink(file);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sink.buffer()", imports = { "okio.buffer" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final BufferedSink buffer(@NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return Okio.buffer(sink);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "source.buffer()", imports = { "okio.buffer" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final BufferedSource buffer(@NotNull final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return Okio.buffer(source);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.sink()", imports = { "okio.sink" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Sink sink(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.sink$default(file, false, 1, null);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "outputStream.sink()", imports = { "okio.sink" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Sink sink(@NotNull final OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.sink(*options)", imports = { "okio.sink" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Sink sink(@NotNull final Path path, @NotNull final OpenOption... original) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(original, "options");
        return Okio.sink(path, (OpenOption[])Arrays.copyOf(original, original.length));
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.sink()", imports = { "okio.sink" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Sink sink(@NotNull final Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return Okio.sink(socket);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.source()", imports = { "okio.source" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Source source(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.source(file);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputStream.source()", imports = { "okio.source" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Source source(@NotNull final InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return Okio.source(inputStream);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.source(*options)", imports = { "okio.source" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Source source(@NotNull final Path path, @NotNull final OpenOption... original) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(original, "options");
        return Okio.source(path, (OpenOption[])Arrays.copyOf(original, original.length));
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.source()", imports = { "okio.source" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Source source(@NotNull final Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return Okio.source(socket);
    }
    
    @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "blackholeSink()", imports = { "okio.blackholeSink" }), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Sink blackhole() {
        return Okio.blackhole();
    }
    
    static {
        INSTANCE = new DDeprecatedOkio();
    }
}
