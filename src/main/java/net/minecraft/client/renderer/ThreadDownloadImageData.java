/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.http.HttpPipeline;
import net.optifine.http.HttpRequest;
import net.optifine.http.HttpResponse;
import net.optifine.player.CapeImageBuffer;
import net.optifine.shaders.ShadersTex;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDownloadImageData
extends SimpleTexture {
    private static final Logger logger = LogManager.getLogger();
    private static final AtomicInteger threadDownloadCounter = new AtomicInteger(0);
    private static final Executor downloadExecutor = Executors.newFixedThreadPool(4, runnable2 -> {
        Thread thread2 = new Thread(runnable2, "Texture Downloader #" + threadDownloadCounter.incrementAndGet());
        thread2.setDaemon(true);
        thread2.setPriority(1);
        return thread2;
    });
    private final File cacheFile;
    private final String imageUrl;
    private final IImageBuffer imageBuffer;
    private volatile BufferedImage bufferedImage;
    private Runnable imageTask;
    private volatile boolean textureUploaded;
    public Boolean imageFound = null;
    public boolean pipeline = false;

    public ThreadDownloadImageData(File file, String string, ResourceLocation resourceLocation, IImageBuffer iImageBuffer) {
        super(resourceLocation);
        this.cacheFile = file;
        this.imageUrl = string;
        this.imageBuffer = iImageBuffer;
    }

    private void checkTextureUploaded() {
        if (!this.textureUploaded && this.bufferedImage != null) {
            this.textureUploaded = true;
            if (this.textureLocation != null) {
                this.deleteGlTexture();
            }
            if (Config.isShaders()) {
                ShadersTex.loadSimpleTexture(super.getGlTextureId(), this.bufferedImage, false, false, Config.getResourceManager(), this.textureLocation, this.getMultiTexID());
            } else {
                TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
            }
            this.bufferedImage = null;
            this.imageTask = null;
        }
    }

    @Override
    public int getGlTextureId() {
        this.checkTextureUploaded();
        return super.getGlTextureId();
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        if (this.imageBuffer != null) {
            this.imageBuffer.skinAvailable();
        }
        this.imageFound = this.bufferedImage != null;
    }

    @Override
    public void loadTexture(IResourceManager iResourceManager) throws IOException {
        if (this.textureUploaded) {
            return;
        }
        if (this.bufferedImage == null && this.textureLocation != null) {
            super.loadTexture(iResourceManager);
        }
        if (this.imageTask == null) {
            if (this.cacheFile != null && this.cacheFile.isFile()) {
                logger.debug("Loading http texture from local cache ({})", this.cacheFile);
                try {
                    this.bufferedImage = ImageIO.read(this.cacheFile);
                    if (this.imageBuffer != null) {
                        this.setBufferedImage(this.imageBuffer.parseUserSkin(this.bufferedImage));
                    }
                    this.loadingFinished();
                }
                catch (IOException iOException) {
                    logger.error("Couldn't load skin " + String.valueOf(this.cacheFile), (Throwable)iOException);
                    this.loadTextureFromServer();
                }
            } else {
                this.loadTextureFromServer();
            }
        }
    }

    protected void loadTextureFromServer() {
        this.imageTask = new Runnable(){

            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                logger.debug("Downloading http texture from {} to {}", ThreadDownloadImageData.this.imageUrl, ThreadDownloadImageData.this.cacheFile);
                if (ThreadDownloadImageData.this.shouldPipeline()) {
                    ThreadDownloadImageData.this.loadPipelined();
                } else {
                    try {
                        BufferedImage bufferedImage;
                        httpURLConnection = (HttpURLConnection)new URL(ThreadDownloadImageData.this.imageUrl).openConnection(Minecraft.getMinecraft().getProxy());
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(false);
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() / 100 != 2) {
                            if (httpURLConnection.getErrorStream() != null) {
                                Config.readAll(httpURLConnection.getErrorStream());
                            }
                            return;
                        }
                        if (ThreadDownloadImageData.this.cacheFile != null) {
                            FileUtils.copyInputStreamToFile(httpURLConnection.getInputStream(), ThreadDownloadImageData.this.cacheFile);
                            bufferedImage = ImageIO.read(ThreadDownloadImageData.this.cacheFile);
                        } else {
                            bufferedImage = TextureUtil.readBufferedImage(httpURLConnection.getInputStream());
                        }
                        if (ThreadDownloadImageData.this.imageBuffer != null) {
                            bufferedImage = ThreadDownloadImageData.this.imageBuffer.parseUserSkin(bufferedImage);
                        }
                        ThreadDownloadImageData.this.setBufferedImage(bufferedImage);
                    }
                    catch (Exception exception) {
                        logger.error("Couldn't download http texture: " + exception.getClass().getName() + ": " + exception.getMessage());
                        return;
                    }
                    finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        ThreadDownloadImageData.this.loadingFinished();
                    }
                }
            }
        };
        downloadExecutor.execute(this.imageTask);
    }

    private boolean shouldPipeline() {
        if (!this.pipeline) {
            return false;
        }
        Proxy proxy = Minecraft.getMinecraft().getProxy();
        return proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS ? false : this.imageUrl.startsWith("http://");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadPipelined() {
        try {
            BufferedImage bufferedImage;
            HttpRequest httpRequest = HttpPipeline.makeRequest(this.imageUrl, Minecraft.getMinecraft().getProxy());
            HttpResponse httpResponse = HttpPipeline.executeRequest(httpRequest);
            if (httpResponse.getStatus() / 100 != 2) {
                return;
            }
            byte[] byArray = httpResponse.getBody();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            if (this.cacheFile != null) {
                FileUtils.copyInputStreamToFile(byteArrayInputStream, this.cacheFile);
                bufferedImage = ImageIO.read(this.cacheFile);
            } else {
                bufferedImage = TextureUtil.readBufferedImage(byteArrayInputStream);
            }
            if (this.imageBuffer != null) {
                bufferedImage = this.imageBuffer.parseUserSkin(bufferedImage);
            }
            this.setBufferedImage(bufferedImage);
        }
        catch (Exception exception) {
            logger.error("Couldn't download http texture: " + exception.getClass().getName() + ": " + exception.getMessage());
            return;
        }
        finally {
            this.loadingFinished();
        }
    }

    private void loadingFinished() {
        this.imageFound = this.textureUploaded || this.bufferedImage != null;
        if (this.imageBuffer instanceof CapeImageBuffer) {
            CapeImageBuffer capeImageBuffer = (CapeImageBuffer)this.imageBuffer;
            capeImageBuffer.cleanup();
        }
    }

    public IImageBuffer getImageBuffer() {
        return this.imageBuffer;
    }
}

