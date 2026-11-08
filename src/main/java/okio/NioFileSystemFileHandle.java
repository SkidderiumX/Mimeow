/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileHandle;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokio/NioFileSystemFileHandle;", "Lokio/FileHandle;", "readWrite", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(ZLjava/nio/channels/FileChannel;)V", "protectedClose", "", "protectedFlush", "protectedRead", "", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "protectedResize", "size", "protectedSize", "protectedWrite", "okio"})
public class NioFileSystemFileHandle
extends FileHandle {
    @NotNull
    private final FileChannel fileChannel;

    public NioFileSystemFileHandle(boolean bl, @NotNull FileChannel fileChannel) {
        Intrinsics.checkNotNullParameter(fileChannel, "fileChannel");
        super(bl);
        this.fileChannel = fileChannel;
    }

    @Override
    protected synchronized void protectedResize(long l) {
        long l2 = this.size();
        long l3 = l - l2;
        if (l3 > 0L) {
            this.protectedWrite(l2, new byte[(int)l3], 0, (int)l3);
        } else {
            this.fileChannel.truncate(l);
        }
    }

    @Override
    protected synchronized long protectedSize() {
        return this.fileChannel.size();
    }

    @Override
    protected synchronized int protectedRead(long l, @NotNull byte[] byArray, int n, int n2) {
        int n3;
        int n4;
        Intrinsics.checkNotNullParameter(byArray, "array");
        this.fileChannel.position(l);
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray, n, n2);
        for (n3 = 0; n3 < n2; n3 += n4) {
            n4 = this.fileChannel.read(byteBuffer);
            if (n4 != -1) continue;
            if (n3 != 0) break;
            return -1;
        }
        return n3;
    }

    @Override
    protected synchronized void protectedWrite(long l, @NotNull byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(byArray, "array");
        this.fileChannel.position(l);
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray, n, n2);
        this.fileChannel.write(byteBuffer);
    }

    @Override
    protected synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    @Override
    protected synchronized void protectedClose() {
        this.fileChannel.close();
    }
}

