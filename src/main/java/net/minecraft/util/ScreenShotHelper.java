/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.event.ClickEvent;
import net.minecraft.src.Config;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenShotHelper {
    private static final Logger logger = LogManager.getLogger();
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static IntBuffer pixelBuffer;
    private static int[] pixelValues;
    private static final ThreadPoolExecutor screenshotWriter;

    public static IChatComponent saveScreenshot(File file, int n, int n2, Framebuffer framebuffer) {
        return ScreenShotHelper.saveScreenshot(file, null, n, n2, framebuffer);
    }

    public static IChatComponent saveScreenshot(File file, String string, int n, int n2, Framebuffer framebuffer) {
        try {
            File file2;
            boolean bl;
            File file3 = new File(file, "screenshots");
            file3.mkdir();
            Minecraft minecraft = Minecraft.getMinecraft();
            int n3 = n;
            int n4 = n2;
            int n5 = Config.getGameSettings().guiScale;
            ScaledResolution scaledResolution = new ScaledResolution(minecraft);
            int n6 = scaledResolution.getScaleFactor();
            int n7 = Config.getScreenshotSize();
            boolean bl2 = bl = OpenGlHelper.isFramebufferEnabled() && n7 > 1;
            if (bl) {
                Config.getGameSettings().guiScale = n6 * n7;
                ScreenShotHelper.resize(n * n7, n2 * n7);
                GlStateManager.pushMatrix();
                GlStateManager.clear(16640);
                minecraft.getFramebuffer().bindFramebuffer(true);
                minecraft.entityRenderer.updateCameraAndRender(Config.renderPartialTicks, System.nanoTime());
            }
            if (OpenGlHelper.isFramebufferEnabled()) {
                n = framebuffer.framebufferTextureWidth;
                n2 = framebuffer.framebufferTextureHeight;
            }
            int n8 = n * n2;
            if (pixelBuffer == null || pixelBuffer.capacity() < n8) {
                pixelBuffer = BufferUtils.createIntBuffer(n8);
                pixelValues = new int[n8];
            }
            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3317, 1);
            pixelBuffer.clear();
            if (OpenGlHelper.isFramebufferEnabled()) {
                GlStateManager.bindTexture(framebuffer.framebufferTexture);
                GL11.glGetTexImage(3553, 0, 32993, 33639, pixelBuffer);
            } else {
                GL11.glReadPixels(0, 0, n, n2, 32993, 33639, pixelBuffer);
            }
            pixelBuffer.get(pixelValues);
            final int[] nArray = new int[n8];
            System.arraycopy(pixelValues, 0, nArray, 0, n8);
            final int n9 = n;
            final int n10 = n2;
            final boolean bl3 = OpenGlHelper.isFramebufferEnabled();
            final int n11 = framebuffer.framebufferWidth;
            final int n12 = framebuffer.framebufferHeight;
            final int n13 = framebuffer.framebufferTextureWidth;
            final int n14 = framebuffer.framebufferTextureHeight;
            if (bl) {
                minecraft.getFramebuffer().unbindFramebuffer();
                GlStateManager.popMatrix();
                Config.getGameSettings().guiScale = n5;
                ScreenShotHelper.resize(n3, n4);
            }
            boolean bl4 = false;
            if (string == null) {
                file2 = ScreenShotHelper.reserveTimestampedPNGFile(file3);
                bl4 = true;
            } else {
                file2 = new File(file3, string);
            }
            final File file4 = file2 = file2.getCanonicalFile();
            final boolean bl5 = bl4;
            try {
                screenshotWriter.execute(new Runnable(){

                    @Override
                    public void run() {
                        try {
                            TextureUtil.processPixelValues(nArray, n9, n10);
                            BufferedImage bufferedImage = ScreenShotHelper.createImage(nArray, n9, n10, bl3, n11, n12, n13, n14);
                            if (!ImageIO.write((RenderedImage)bufferedImage, "png", file4)) {
                                throw new IOException("No PNG image writer is available");
                            }
                        }
                        catch (Exception exception) {
                            if (bl5) {
                                file4.delete();
                            }
                            logger.warn("Couldn't save screenshot", (Throwable)exception);
                            ScreenShotHelper.reportAsyncFailure(exception);
                        }
                    }
                });
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                if (bl4) {
                    file2.delete();
                }
                return new ChatComponentTranslation("screenshot.failure", "screenshot queue is full");
            }
            ChatComponentText chatComponentText = new ChatComponentText(file2.getName());
            chatComponentText.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, file2.getAbsolutePath()));
            chatComponentText.getChatStyle().setUnderlined(true);
            return new ChatComponentTranslation("screenshot.success", chatComponentText);
        }
        catch (Exception exception) {
            logger.warn("Couldn't save screenshot", (Throwable)exception);
            return new ChatComponentTranslation("screenshot.failure", exception.getMessage());
        }
    }

    private static BufferedImage createImage(int[] nArray, int n, int n2, boolean bl, int n3, int n4, int n5, int n6) {
        if (bl) {
            BufferedImage bufferedImage = new BufferedImage(n3, n4, 1);
            int n7 = n6 - n4;
            bufferedImage.setRGB(0, 0, n3, n4, nArray, n7 * n5, n5);
            return bufferedImage;
        }
        BufferedImage bufferedImage = new BufferedImage(n, n2, 1);
        bufferedImage.setRGB(0, 0, n, n2, nArray, 0, n);
        return bufferedImage;
    }

    private static void reportAsyncFailure(final Exception exception) {
        final Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.addScheduledTask(new Runnable(){

            @Override
            public void run() {
                if (minecraft.ingameGUI != null) {
                    minecraft.ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("screenshot.failure", exception.getMessage()));
                }
            }
        });
    }

    private static synchronized File reserveTimestampedPNGFile(File file) throws IOException {
        String string = dateFormat.format(new Date()).toString();
        int n = 1;
        File file2;
        while (!(file2 = new File(file, string + (String)(n == 1 ? "" : "_" + n) + ".png")).createNewFile()) {
            ++n;
        }
        return file2;
    }

    private static void resize(int n, int n2) {
        Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.displayWidth = Math.max(1, n);
        minecraft.displayHeight = Math.max(1, n2);
        if (minecraft.currentScreen != null) {
            ScaledResolution scaledResolution = new ScaledResolution(minecraft);
            minecraft.currentScreen.onResize(minecraft, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
        }
        ScreenShotHelper.updateFramebufferSize();
    }

    private static void updateFramebufferSize() {
        Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.getFramebuffer().createBindFramebuffer(minecraft.displayWidth, minecraft.displayHeight);
        if (minecraft.entityRenderer != null) {
            minecraft.entityRenderer.updateShaderGroupSize(minecraft.displayWidth, minecraft.displayHeight);
        }
    }

    static {
        screenshotWriter = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2), new ThreadFactory(){

            @Override
            public Thread newThread(Runnable runnable2) {
                Thread thread2 = new Thread(runnable2, "Screenshot Writer");
                thread2.setDaemon(true);
                return thread2;
            }
        }, new ThreadPoolExecutor.AbortPolicy());
    }
}

