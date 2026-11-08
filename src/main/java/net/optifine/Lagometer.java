/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.profiler.Profiler;
import net.minecraft.src.Config;
import net.optifine.util.MemoryMonitor;
import org.lwjgl.opengl.GL11;

public class Lagometer {
    private static Minecraft mc;
    private static GameSettings gameSettings;
    private static Profiler profiler;
    public static boolean active;
    public static TimerNano timerTick;
    public static TimerNano timerScheduledExecutables;
    public static TimerNano timerChunkUpload;
    public static TimerNano timerChunkUpdate;
    public static TimerNano timerVisibility;
    public static TimerNano timerTerrain;
    public static TimerNano timerServer;
    private static long[] timesFrame;
    private static long[] timesTick;
    private static long[] timesScheduledExecutables;
    private static long[] timesChunkUpload;
    private static long[] timesChunkUpdate;
    private static long[] timesVisibility;
    private static long[] timesTerrain;
    private static long[] timesServer;
    private static boolean[] gcs;
    private static int numRecordedFrameTimes;
    private static long prevFrameTimeNano;
    private static long renderTimeNano;

    public static void updateLagometer() {
        if (mc == null) {
            mc = Minecraft.getMinecraft();
            gameSettings = Lagometer.mc.gameSettings;
            profiler = Lagometer.mc.mcProfiler;
        }
        if (Lagometer.gameSettings.showDebugInfo && (Lagometer.gameSettings.ofLagometer || Lagometer.gameSettings.showLagometer)) {
            active = true;
            long l = System.nanoTime();
            if (prevFrameTimeNano == -1L) {
                prevFrameTimeNano = l;
            } else {
                int n = numRecordedFrameTimes & timesFrame.length - 1;
                ++numRecordedFrameTimes;
                boolean bl = MemoryMonitor.isGcEvent();
                Lagometer.timesFrame[n] = l - prevFrameTimeNano - renderTimeNano;
                Lagometer.timesTick[n] = Lagometer.timerTick.timeNano;
                Lagometer.timesScheduledExecutables[n] = Lagometer.timerScheduledExecutables.timeNano;
                Lagometer.timesChunkUpload[n] = Lagometer.timerChunkUpload.timeNano;
                Lagometer.timesChunkUpdate[n] = Lagometer.timerChunkUpdate.timeNano;
                Lagometer.timesVisibility[n] = Lagometer.timerVisibility.timeNano;
                Lagometer.timesTerrain[n] = Lagometer.timerTerrain.timeNano;
                Lagometer.timesServer[n] = Lagometer.timerServer.timeNano;
                Lagometer.gcs[n] = bl;
                timerTick.reset();
                timerScheduledExecutables.reset();
                timerVisibility.reset();
                timerChunkUpdate.reset();
                timerChunkUpload.reset();
                timerTerrain.reset();
                timerServer.reset();
                prevFrameTimeNano = System.nanoTime();
            }
        } else {
            active = false;
            prevFrameTimeNano = -1L;
        }
    }

    public static void showLagometer(ScaledResolution scaledResolution) {
        if (gameSettings != null && (Lagometer.gameSettings.ofLagometer || Lagometer.gameSettings.showLagometer)) {
            float f;
            int n;
            int n2;
            long l = System.nanoTime();
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.pushMatrix();
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, Lagometer.mc.displayWidth, Lagometer.mc.displayHeight, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GlStateManager.disableTexture2D();
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            worldRenderer.begin(1, DefaultVertexFormats.POSITION_COLOR);
            for (n2 = 0; n2 < timesFrame.length; ++n2) {
                n = (n2 - numRecordedFrameTimes & timesFrame.length - 1) * 100 / timesFrame.length;
                n += 155;
                f = Lagometer.mc.displayHeight;
                long l2 = 0L;
                if (gcs[n2]) {
                    Lagometer.renderTime(n2, timesFrame[n2], n, n / 2, 0, f, worldRenderer);
                    continue;
                }
                Lagometer.renderTime(n2, timesFrame[n2], n, n, n, f, worldRenderer);
                f -= (float)Lagometer.renderTime(n2, timesServer[n2], n / 2, n / 2, n / 2, f, worldRenderer);
                f -= (float)Lagometer.renderTime(n2, timesTerrain[n2], 0, n, 0, f, worldRenderer);
                f -= (float)Lagometer.renderTime(n2, timesVisibility[n2], n, n, 0, f, worldRenderer);
                f -= (float)Lagometer.renderTime(n2, timesChunkUpdate[n2], n, 0, 0, f, worldRenderer);
                f -= (float)Lagometer.renderTime(n2, timesChunkUpload[n2], n, 0, n, f, worldRenderer);
                f -= (float)Lagometer.renderTime(n2, timesScheduledExecutables[n2], 0, 0, n, f, worldRenderer);
                float f2 = f - (float)Lagometer.renderTime(n2, timesTick[n2], 0, n, n, f, worldRenderer);
            }
            Lagometer.renderTimeDivider(0, timesFrame.length, 33333333L, 196, 196, 196, Lagometer.mc.displayHeight, worldRenderer);
            Lagometer.renderTimeDivider(0, timesFrame.length, 16666666L, 196, 196, 196, Lagometer.mc.displayHeight, worldRenderer);
            tessellator.draw();
            GlStateManager.enableTexture2D();
            n2 = Lagometer.mc.displayHeight - 80;
            n = Lagometer.mc.displayHeight - 160;
            Lagometer.mc.fontRendererObj.drawString("30", 2, n + 1, -8947849);
            Lagometer.mc.fontRendererObj.drawString("30", 1, n, -3881788);
            Lagometer.mc.fontRendererObj.drawString("60", 2, n2 + 1, -8947849);
            Lagometer.mc.fontRendererObj.drawString("60", 1, n2, -3881788);
            GlStateManager.matrixMode(5889);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.enableTexture2D();
            f = 1.0f - (float)((double)(System.currentTimeMillis() - MemoryMonitor.getStartTimeMs()) / 1000.0);
            f = Config.limit(f, 0.0f, 1.0f);
            int n3 = (int)(170.0f + f * 85.0f);
            int n4 = (int)(100.0f + f * 55.0f);
            int n5 = (int)(10.0f + f * 10.0f);
            int n6 = n3 << 16 | n4 << 8 | n5;
            int n7 = 512 / scaledResolution.getScaleFactor() + 2;
            int n8 = Lagometer.mc.displayHeight / scaledResolution.getScaleFactor() - 8;
            GuiIngame guiIngame = Lagometer.mc.ingameGUI;
            GuiIngame.drawRect(n7 - 1, n8 - 1, n7 + 50, n8 + 10, -1605349296);
            Lagometer.mc.fontRendererObj.drawString(" " + MemoryMonitor.getAllocationRateMb() + " MB/s", n7, n8, n6);
            renderTimeNano = System.nanoTime() - l;
        }
    }

    private static long renderTime(int n, long l, int n2, int n3, int n4, float f, WorldRenderer worldRenderer) {
        long l2 = l / 200000L;
        if (l2 < 3L) {
            return 0L;
        }
        worldRenderer.pos((float)n + 0.5f, f - (float)l2 + 0.5f, 0.0).color(n2, n3, n4, 255).endVertex();
        worldRenderer.pos((float)n + 0.5f, f + 0.5f, 0.0).color(n2, n3, n4, 255).endVertex();
        return l2;
    }

    private static long renderTimeDivider(int n, int n2, long l, int n3, int n4, int n5, float f, WorldRenderer worldRenderer) {
        long l2 = l / 200000L;
        if (l2 < 3L) {
            return 0L;
        }
        worldRenderer.pos((float)n + 0.5f, f - (float)l2 + 0.5f, 0.0).color(n3, n4, n5, 255).endVertex();
        worldRenderer.pos((float)n2 + 0.5f, f - (float)l2 + 0.5f, 0.0).color(n3, n4, n5, 255).endVertex();
        return l2;
    }

    public static boolean isActive() {
        return active;
    }

    static {
        active = false;
        timerTick = new TimerNano();
        timerScheduledExecutables = new TimerNano();
        timerChunkUpload = new TimerNano();
        timerChunkUpdate = new TimerNano();
        timerVisibility = new TimerNano();
        timerTerrain = new TimerNano();
        timerServer = new TimerNano();
        timesFrame = new long[512];
        timesTick = new long[512];
        timesScheduledExecutables = new long[512];
        timesChunkUpload = new long[512];
        timesChunkUpdate = new long[512];
        timesVisibility = new long[512];
        timesTerrain = new long[512];
        timesServer = new long[512];
        gcs = new boolean[512];
        numRecordedFrameTimes = 0;
        prevFrameTimeNano = -1L;
        renderTimeNano = 0L;
    }

    public static class TimerNano {
        public long timeStartNano = 0L;
        public long timeNano = 0L;

        public void start() {
            if (active && this.timeStartNano == 0L) {
                this.timeStartNano = System.nanoTime();
            }
        }

        public void end() {
            if (active && this.timeStartNano != 0L) {
                this.timeNano += System.nanoTime() - this.timeStartNano;
                this.timeStartNano = 0L;
            }
        }

        private void reset() {
            this.timeNano = 0L;
            this.timeStartNano = 0L;
        }
    }
}

