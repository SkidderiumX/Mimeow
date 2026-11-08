/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.client.renderer.VertexBufferUploader;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.chunk.ChunkCompileTaskGenerator;
import net.minecraft.client.renderer.chunk.ChunkRenderWorker;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.ListedRenderChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public class ChunkRenderDispatcher {
    private static final Logger logger = LogManager.getLogger();
    private static final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Chunk Batcher %d").setDaemon(true).build();
    private final List<ChunkRenderWorker> listThreadedWorkers = Lists.newArrayList();
    private final BlockingQueue<ChunkCompileTaskGenerator> queueChunkUpdates = Queues.newArrayBlockingQueue(100);
    private final BlockingQueue<RegionRenderCacheBuilder> queueFreeRenderBuilders;
    private final WorldVertexBufferUploader worldVertexUploader = new WorldVertexBufferUploader();
    private final VertexBufferUploader vertexUploader = new VertexBufferUploader();
    private final Queue<ListenableFutureTask<?>> queueChunkUploads = Queues.newArrayDeque();
    private final ChunkRenderWorker renderWorker;
    private final int countRenderBuilders;
    private List<RegionRenderCacheBuilder> listPausedBuilders = new ArrayList<RegionRenderCacheBuilder>();

    public ChunkRenderDispatcher() {
        this(-1);
    }

    public ChunkRenderDispatcher(int n) {
        int n2;
        int n3 = Math.max(1, (int)((double)Runtime.getRuntime().maxMemory() * 0.3) / 0xA00000);
        int n4 = Math.max(1, MathHelper.clamp_int(Runtime.getRuntime().availableProcessors() - 2, 1, n3 / 5));
        this.countRenderBuilders = n < 0 ? MathHelper.clamp_int(n4 * 8, 1, n3) : n;
        for (n2 = 0; n2 < n4; ++n2) {
            ChunkRenderWorker chunkRenderWorker = new ChunkRenderWorker(this);
            Thread thread2 = threadFactory.newThread(chunkRenderWorker);
            thread2.start();
            this.listThreadedWorkers.add(chunkRenderWorker);
        }
        this.queueFreeRenderBuilders = Queues.newArrayBlockingQueue(this.countRenderBuilders);
        for (n2 = 0; n2 < this.countRenderBuilders; ++n2) {
            this.queueFreeRenderBuilders.add(new RegionRenderCacheBuilder());
        }
        this.renderWorker = new ChunkRenderWorker(this, new RegionRenderCacheBuilder());
    }

    public String getDebugInfo() {
        return String.format("pC: %03d, pU: %1d, aB: %1d", this.queueChunkUpdates.size(), this.queueChunkUploads.size(), this.queueFreeRenderBuilders.size());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean runChunkUploads(long l) {
        long l2;
        boolean bl;
        boolean bl2 = false;
        do {
            bl = false;
            ListenableFutureTask<?> listenableFutureTask = null;
            Queue<ListenableFutureTask<?>> queue = this.queueChunkUploads;
            synchronized (queue) {
                listenableFutureTask = this.queueChunkUploads.poll();
            }
            if (listenableFutureTask == null) continue;
            listenableFutureTask.run();
            bl = true;
            bl2 = true;
        } while (l != 0L && bl && (l2 = l - System.nanoTime()) >= 0L);
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean updateChunkLater(RenderChunk renderChunk) {
        boolean bl;
        renderChunk.getLockCompileTask().lock();
        try {
            final ChunkCompileTaskGenerator chunkCompileTaskGenerator = renderChunk.makeCompileTaskChunk();
            chunkCompileTaskGenerator.addFinishRunnable(new Runnable(){

                @Override
                public void run() {
                    ChunkRenderDispatcher.this.queueChunkUpdates.remove(chunkCompileTaskGenerator);
                }
            });
            boolean bl2 = this.queueChunkUpdates.offer(chunkCompileTaskGenerator);
            if (!bl2) {
                chunkCompileTaskGenerator.finish();
            }
            bl = bl2;
        }
        finally {
            renderChunk.getLockCompileTask().unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean updateChunkNow(RenderChunk renderChunk) {
        boolean bl;
        renderChunk.getLockCompileTask().lock();
        try {
            ChunkCompileTaskGenerator chunkCompileTaskGenerator = renderChunk.makeCompileTaskChunk();
            try {
                this.renderWorker.processTask(chunkCompileTaskGenerator);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            bl = true;
        }
        finally {
            renderChunk.getLockCompileTask().unlock();
        }
        return bl;
    }

    public void stopChunkUpdates() {
        this.clearChunkUpdates();
        while (this.runChunkUploads(0L)) {
        }
        ArrayList<RegionRenderCacheBuilder> arrayList = Lists.newArrayList();
        while (arrayList.size() != this.countRenderBuilders) {
            try {
                arrayList.add(this.allocateRenderBuilder());
            }
            catch (InterruptedException interruptedException) {}
        }
        this.queueFreeRenderBuilders.addAll(arrayList);
    }

    public void freeRenderBuilder(RegionRenderCacheBuilder regionRenderCacheBuilder) {
        this.queueFreeRenderBuilders.add(regionRenderCacheBuilder);
    }

    public RegionRenderCacheBuilder allocateRenderBuilder() throws InterruptedException {
        return this.queueFreeRenderBuilders.take();
    }

    public ChunkCompileTaskGenerator getNextChunkUpdate() throws InterruptedException {
        return this.queueChunkUpdates.take();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean updateTransparencyLater(RenderChunk renderChunk) {
        boolean bl;
        renderChunk.getLockCompileTask().lock();
        try {
            boolean bl2;
            final ChunkCompileTaskGenerator chunkCompileTaskGenerator = renderChunk.makeCompileTaskTransparency();
            if (chunkCompileTaskGenerator != null) {
                boolean bl3;
                chunkCompileTaskGenerator.addFinishRunnable(new Runnable(){

                    @Override
                    public void run() {
                        ChunkRenderDispatcher.this.queueChunkUpdates.remove(chunkCompileTaskGenerator);
                    }
                });
                boolean bl4 = bl3 = this.queueChunkUpdates.offer(chunkCompileTaskGenerator);
                return bl4;
            }
            bl = bl2 = true;
        }
        finally {
            renderChunk.getLockCompileTask().unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListenableFuture<Object> uploadChunk(final EnumWorldBlockLayer enumWorldBlockLayer, final WorldRenderer worldRenderer, final RenderChunk renderChunk, final CompiledChunk compiledChunk) {
        if (Minecraft.getMinecraft().isCallingFromMinecraftThread()) {
            if (renderChunk != null && worldRenderer != null) {
                int n;
                if (OpenGlHelper.useVbo()) {
                    VertexBuffer vertexBuffer = renderChunk.getVertexBufferByLayer(enumWorldBlockLayer.ordinal());
                    if (vertexBuffer != null) {
                        this.uploadVertexBuffer(worldRenderer, vertexBuffer);
                    }
                } else if (renderChunk instanceof ListedRenderChunk && (n = ((ListedRenderChunk)renderChunk).getDisplayList(enumWorldBlockLayer, compiledChunk)) >= 0) {
                    this.uploadDisplayList(worldRenderer, n, renderChunk);
                }
            }
            if (worldRenderer != null) {
                worldRenderer.setTranslation(0.0, 0.0, 0.0);
            }
            return Futures.immediateFuture(null);
        }
        ListenableFutureTask<Object> listenableFutureTask = ListenableFutureTask.create(new Runnable(){

            @Override
            public void run() {
                ChunkRenderDispatcher.this.uploadChunk(enumWorldBlockLayer, worldRenderer, renderChunk, compiledChunk);
            }
        }, null);
        Queue<ListenableFutureTask<?>> queue = this.queueChunkUploads;
        synchronized (queue) {
            this.queueChunkUploads.add(listenableFutureTask);
            return listenableFutureTask;
        }
    }

    private void uploadDisplayList(WorldRenderer worldRenderer, int n, RenderChunk renderChunk) {
        if (worldRenderer == null || n < 0 || renderChunk == null) {
            return;
        }
        GL11.glNewList(n, 4864);
        GlStateManager.pushMatrix();
        renderChunk.multModelviewMatrix();
        this.worldVertexUploader.draw(worldRenderer);
        GlStateManager.popMatrix();
        GL11.glEndList();
    }

    private void uploadVertexBuffer(WorldRenderer worldRenderer, VertexBuffer vertexBuffer) {
        if (worldRenderer == null || vertexBuffer == null) {
            return;
        }
        this.vertexUploader.setVertexBuffer(vertexBuffer);
        this.vertexUploader.draw(worldRenderer);
    }

    public void clearChunkUpdates() {
        while (!this.queueChunkUpdates.isEmpty()) {
            ChunkCompileTaskGenerator chunkCompileTaskGenerator = (ChunkCompileTaskGenerator)this.queueChunkUpdates.poll();
            if (chunkCompileTaskGenerator == null) continue;
            chunkCompileTaskGenerator.finish();
        }
    }

    public boolean hasChunkUpdates() {
        return this.queueChunkUpdates.isEmpty() && this.queueChunkUploads.isEmpty();
    }

    public void pauseChunkUpdates() {
        while (this.listPausedBuilders.size() != this.countRenderBuilders) {
            try {
                this.runChunkUploads(Long.MAX_VALUE);
                RegionRenderCacheBuilder regionRenderCacheBuilder = this.queueFreeRenderBuilders.poll(100L, TimeUnit.MILLISECONDS);
                if (regionRenderCacheBuilder == null) continue;
                this.listPausedBuilders.add(regionRenderCacheBuilder);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    public void resumeChunkUpdates() {
        this.queueFreeRenderBuilders.addAll(this.listPausedBuilders);
        this.listPausedBuilders.clear();
    }
}

