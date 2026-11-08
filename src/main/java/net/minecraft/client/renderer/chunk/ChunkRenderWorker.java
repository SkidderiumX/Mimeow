/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.client.renderer.chunk.ChunkCompileTaskGenerator;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumWorldBlockLayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkRenderWorker
implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ChunkRenderDispatcher chunkRenderDispatcher;
    private final RegionRenderCacheBuilder regionRenderCacheBuilder;

    public ChunkRenderWorker(ChunkRenderDispatcher chunkRenderDispatcher) {
        this(chunkRenderDispatcher, null);
    }

    public ChunkRenderWorker(ChunkRenderDispatcher chunkRenderDispatcher, RegionRenderCacheBuilder regionRenderCacheBuilder) {
        this.chunkRenderDispatcher = chunkRenderDispatcher;
        this.regionRenderCacheBuilder = regionRenderCacheBuilder;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.processTask(this.chunkRenderDispatcher.getNextChunkUpdate());
            }
        }
        catch (InterruptedException interruptedException) {
            LOGGER.debug("Stopping due to interrupt");
            return;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Batching chunks");
            Minecraft.getMinecraft().crashed(Minecraft.getMinecraft().addGraphicsAndWorldToCrashReport(crashReport));
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void processTask(final ChunkCompileTaskGenerator chunkCompileTaskGenerator) throws InterruptedException {
        chunkCompileTaskGenerator.getLock().lock();
        try {
            if (chunkCompileTaskGenerator.getStatus() != ChunkCompileTaskGenerator.Status.PENDING) {
                if (!chunkCompileTaskGenerator.isFinished()) {
                    LOGGER.warn("Chunk render task was " + String.valueOf((Object)chunkCompileTaskGenerator.getStatus()) + " when I expected it to be pending; ignoring task");
                }
                return;
            }
            chunkCompileTaskGenerator.setStatus(ChunkCompileTaskGenerator.Status.COMPILING);
        }
        finally {
            chunkCompileTaskGenerator.getLock().unlock();
        }
        Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
        if (entity == null) {
            chunkCompileTaskGenerator.finish();
        } else {
            chunkCompileTaskGenerator.setRegionRenderCacheBuilder(this.getRegionRenderCacheBuilder());
            float f = (float)entity.posX;
            float f2 = (float)entity.posY + entity.getEyeHeight();
            float f3 = (float)entity.posZ;
            ChunkCompileTaskGenerator.Type type = chunkCompileTaskGenerator.getType();
            if (type == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                chunkCompileTaskGenerator.getRenderChunk().rebuildChunk(f, f2, f3, chunkCompileTaskGenerator);
            } else if (type == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                chunkCompileTaskGenerator.getRenderChunk().resortTransparency(f, f2, f3, chunkCompileTaskGenerator);
            }
            chunkCompileTaskGenerator.getLock().lock();
            try {
                if (chunkCompileTaskGenerator.getStatus() != ChunkCompileTaskGenerator.Status.COMPILING) {
                    if (!chunkCompileTaskGenerator.isFinished()) {
                        LOGGER.warn("Chunk render task was " + String.valueOf((Object)chunkCompileTaskGenerator.getStatus()) + " when I expected it to be compiling; aborting task");
                    }
                    this.freeRenderBuilder(chunkCompileTaskGenerator);
                    return;
                }
                chunkCompileTaskGenerator.setStatus(ChunkCompileTaskGenerator.Status.UPLOADING);
            }
            finally {
                chunkCompileTaskGenerator.getLock().unlock();
            }
            final CompiledChunk compiledChunk = chunkCompileTaskGenerator.getCompiledChunk();
            ArrayList<ListenableFuture<Object>> arrayList = Lists.newArrayList();
            if (type == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                for (EnumWorldBlockLayer enumWorldBlockLayer : EnumWorldBlockLayer.values()) {
                    if (!compiledChunk.isLayerStarted(enumWorldBlockLayer)) continue;
                    arrayList.add(this.chunkRenderDispatcher.uploadChunk(enumWorldBlockLayer, chunkCompileTaskGenerator.getRegionRenderCacheBuilder().getWorldRendererByLayer(enumWorldBlockLayer), chunkCompileTaskGenerator.getRenderChunk(), compiledChunk));
                }
            } else if (type == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                arrayList.add(this.chunkRenderDispatcher.uploadChunk(EnumWorldBlockLayer.TRANSLUCENT, chunkCompileTaskGenerator.getRegionRenderCacheBuilder().getWorldRendererByLayer(EnumWorldBlockLayer.TRANSLUCENT), chunkCompileTaskGenerator.getRenderChunk(), compiledChunk));
            }
            final ListenableFuture listenableFuture = Futures.allAsList(arrayList);
            chunkCompileTaskGenerator.addFinishRunnable(new Runnable(){

                @Override
                public void run() {
                    listenableFuture.cancel(false);
                }
            });
            Futures.addCallback(listenableFuture, new FutureCallback<List<Object>>(){

                @Override
                public void onSuccess(List<Object> list) {
                    block6: {
                        ChunkRenderWorker.this.freeRenderBuilder(chunkCompileTaskGenerator);
                        chunkCompileTaskGenerator.getLock().lock();
                        try {
                            if (chunkCompileTaskGenerator.getStatus() == ChunkCompileTaskGenerator.Status.UPLOADING) {
                                chunkCompileTaskGenerator.setStatus(ChunkCompileTaskGenerator.Status.DONE);
                                break block6;
                            }
                            if (!chunkCompileTaskGenerator.isFinished()) {
                                LOGGER.warn("Chunk render task was " + String.valueOf((Object)chunkCompileTaskGenerator.getStatus()) + " when I expected it to be uploading; aborting task");
                            }
                        }
                        finally {
                            chunkCompileTaskGenerator.getLock().unlock();
                        }
                        return;
                    }
                    chunkCompileTaskGenerator.getRenderChunk().setCompiledChunk(compiledChunk);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    ChunkRenderWorker.this.freeRenderBuilder(chunkCompileTaskGenerator);
                    if (!(throwable instanceof CancellationException) && !(throwable instanceof InterruptedException)) {
                        Minecraft.getMinecraft().crashed(CrashReport.makeCrashReport(throwable, "Rendering chunk"));
                    }
                }
            });
        }
    }

    private RegionRenderCacheBuilder getRegionRenderCacheBuilder() throws InterruptedException {
        return this.regionRenderCacheBuilder != null ? this.regionRenderCacheBuilder : this.chunkRenderDispatcher.allocateRenderBuilder();
    }

    private void freeRenderBuilder(ChunkCompileTaskGenerator chunkCompileTaskGenerator) {
        if (this.regionRenderCacheBuilder == null) {
            this.chunkRenderDispatcher.freeRenderBuilder(chunkCompileTaskGenerator.getRegionRenderCacheBuilder());
        }
    }
}

