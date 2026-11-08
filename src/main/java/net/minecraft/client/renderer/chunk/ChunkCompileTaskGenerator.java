/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;

public class ChunkCompileTaskGenerator {
    private final RenderChunk renderChunk;
    private final ReentrantLock lock = new ReentrantLock();
    private final List<Runnable> listFinishRunnables = Lists.newArrayList();
    private final Type type;
    private RegionRenderCacheBuilder regionRenderCacheBuilder;
    private CompiledChunk compiledChunk;
    private Status status = Status.PENDING;
    private boolean finished;

    public ChunkCompileTaskGenerator(RenderChunk renderChunk, Type type) {
        this.renderChunk = renderChunk;
        this.type = type;
    }

    public Status getStatus() {
        return this.status;
    }

    public RenderChunk getRenderChunk() {
        return this.renderChunk;
    }

    public CompiledChunk getCompiledChunk() {
        return this.compiledChunk;
    }

    public void setCompiledChunk(CompiledChunk compiledChunk) {
        this.compiledChunk = compiledChunk;
    }

    public RegionRenderCacheBuilder getRegionRenderCacheBuilder() {
        return this.regionRenderCacheBuilder;
    }

    public void setRegionRenderCacheBuilder(RegionRenderCacheBuilder regionRenderCacheBuilder) {
        this.regionRenderCacheBuilder = regionRenderCacheBuilder;
    }

    public void setStatus(Status status) {
        this.lock.lock();
        try {
            this.status = status;
        }
        finally {
            this.lock.unlock();
        }
    }

    public void finish() {
        this.lock.lock();
        try {
            if (this.type == Type.REBUILD_CHUNK && this.status != Status.DONE) {
                this.renderChunk.setNeedsUpdate(true);
            }
            this.finished = true;
            this.status = Status.DONE;
            for (Runnable runnable2 : this.listFinishRunnables) {
                runnable2.run();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    public void addFinishRunnable(Runnable runnable2) {
        this.lock.lock();
        try {
            this.listFinishRunnables.add(runnable2);
            if (this.finished) {
                runnable2.run();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    public ReentrantLock getLock() {
        return this.lock;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public static enum Status {
        PENDING,
        COMPILING,
        UPLOADING,
        DONE;

    }

    public static enum Type {
        REBUILD_CHUNK,
        RESORT_TRANSPARENCY;

    }
}

