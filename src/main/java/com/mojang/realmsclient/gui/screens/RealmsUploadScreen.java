/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.FileUpload;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.client.UploadStatus;
import com.mojang.realmsclient.dto.UploadInfo;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.exception.RetryCallException;
import com.mojang.realmsclient.gui.screens.RealmsResetWorldScreen;
import com.mojang.realmsclient.util.UploadTokenCache;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.GZIPOutputStream;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsDefaultVertexFormat;
import net.minecraft.realms.RealmsLevelSummary;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsSharedConstants;
import net.minecraft.realms.Tezzelator;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class RealmsUploadScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int CANCEL_BUTTON = 0;
    private static final int BACK_BUTTON = 1;
    private final RealmsResetWorldScreen lastScreen;
    private final RealmsLevelSummary selectedLevel;
    private final long worldId;
    private final int slotId;
    private final UploadStatus uploadStatus;
    private volatile String errorMessage = null;
    private volatile String status = null;
    private volatile String progress = null;
    private volatile boolean cancelled = false;
    private volatile boolean uploadFinished = false;
    private volatile boolean showDots = true;
    private volatile boolean uploadStarted = false;
    private RealmsButton backButton;
    private RealmsButton cancelButton;
    private int animTick = 0;
    private static final String[] DOTS = new String[]{"", ".", ". .", ". . ."};
    private int dotIndex = 0;
    private Long previousWrittenBytes = null;
    private Long previousTimeSnapshot = null;
    private long bytesPersSecond = 0L;
    private static final ReentrantLock uploadLock = new ReentrantLock();
    private static final int baseUnit = 1024;

    public RealmsUploadScreen(long l, int n, RealmsResetWorldScreen realmsResetWorldScreen, RealmsLevelSummary realmsLevelSummary) {
        this.worldId = l;
        this.slotId = n;
        this.lastScreen = realmsResetWorldScreen;
        this.selectedLevel = realmsLevelSummary;
        this.uploadStatus = new UploadStatus();
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.backButton = RealmsUploadScreen.newButton(1, this.width() / 2 - 100, this.height() - 42, 200, 20, RealmsUploadScreen.getLocalizedString("gui.back"));
        this.cancelButton = RealmsUploadScreen.newButton(0, this.width() / 2 - 100, this.height() - 42, 200, 20, RealmsUploadScreen.getLocalizedString("gui.cancel"));
        this.buttonsAdd(this.cancelButton);
        if (!this.uploadStarted) {
            if (this.lastScreen.slot != -1) {
                this.lastScreen.switchSlot(this);
            } else {
                this.upload();
            }
        }
    }

    @Override
    public void confirmResult(boolean bl, int n) {
        if (bl && !this.uploadStarted) {
            this.uploadStarted = true;
            Realms.setScreen(this);
            this.upload();
        }
    }

    @Override
    public void removed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (!realmsButton.active()) {
            return;
        }
        if (realmsButton.id() == 1) {
            this.lastScreen.confirmResult(true, 0);
        } else if (realmsButton.id() == 0) {
            this.cancelled = true;
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            if (!this.showDots) {
                this.buttonClicked(this.backButton);
            } else {
                this.buttonClicked(this.cancelButton);
            }
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        if (!this.uploadFinished && this.uploadStatus.bytesWritten != 0L && this.uploadStatus.bytesWritten.longValue() == this.uploadStatus.totalBytes.longValue()) {
            this.status = RealmsUploadScreen.getLocalizedString("mco.upload.verifying");
            this.cancelButton.active(false);
        }
        this.drawCenteredString(this.status, this.width() / 2, 50, 0xFFFFFF);
        if (this.showDots) {
            this.drawDots();
        }
        if (this.uploadStatus.bytesWritten != 0L && !this.cancelled) {
            this.drawProgressBar();
            this.drawUploadSpeed();
        }
        if (this.errorMessage != null) {
            String[] stringArray = this.errorMessage.split("\\\\n");
            for (int i = 0; i < stringArray.length; ++i) {
                this.drawCenteredString(stringArray[i], this.width() / 2, 110 + 12 * i, 0xFF0000);
            }
        }
        super.render(n, n2, f);
    }

    private void drawDots() {
        int n = this.fontWidth(this.status);
        if (this.animTick % 10 == 0) {
            ++this.dotIndex;
        }
        this.drawString(DOTS[this.dotIndex % DOTS.length], this.width() / 2 + n / 2 + 5, 50, 0xFFFFFF);
    }

    private void drawProgressBar() {
        double d = this.uploadStatus.bytesWritten.doubleValue() / this.uploadStatus.totalBytes.doubleValue() * 100.0;
        if (d > 100.0) {
            d = 100.0;
        }
        this.progress = String.format("%.1f", d);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3553);
        double d2 = this.width() / 2 - 100;
        double d3 = 0.5;
        Tezzelator tezzelator = Tezzelator.instance;
        tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_COLOR);
        tezzelator.vertex(d2 - 0.5, 95.5, 0.0).color(217, 210, 210, 255).endVertex();
        tezzelator.vertex(d2 + 200.0 * d / 100.0 + 0.5, 95.5, 0.0).color(217, 210, 210, 255).endVertex();
        tezzelator.vertex(d2 + 200.0 * d / 100.0 + 0.5, 79.5, 0.0).color(217, 210, 210, 255).endVertex();
        tezzelator.vertex(d2 - 0.5, 79.5, 0.0).color(217, 210, 210, 255).endVertex();
        tezzelator.vertex(d2, 95.0, 0.0).color(128, 128, 128, 255).endVertex();
        tezzelator.vertex(d2 + 200.0 * d / 100.0, 95.0, 0.0).color(128, 128, 128, 255).endVertex();
        tezzelator.vertex(d2 + 200.0 * d / 100.0, 80.0, 0.0).color(128, 128, 128, 255).endVertex();
        tezzelator.vertex(d2, 80.0, 0.0).color(128, 128, 128, 255).endVertex();
        tezzelator.end();
        GL11.glEnable(3553);
        this.drawCenteredString(this.progress + " %", this.width() / 2, 84, 0xFFFFFF);
    }

    private void drawUploadSpeed() {
        if (this.animTick % RealmsSharedConstants.TICKS_PER_SECOND == 0) {
            if (this.previousWrittenBytes != null) {
                long l = System.currentTimeMillis() - this.previousTimeSnapshot;
                if (l == 0L) {
                    l = 1L;
                }
                this.bytesPersSecond = 1000L * (this.uploadStatus.bytesWritten - this.previousWrittenBytes) / l;
                this.drawUploadSpeed0(this.bytesPersSecond);
            }
            this.previousWrittenBytes = this.uploadStatus.bytesWritten;
            this.previousTimeSnapshot = System.currentTimeMillis();
        } else {
            this.drawUploadSpeed0(this.bytesPersSecond);
        }
    }

    private void drawUploadSpeed0(long l) {
        if (l > 0L) {
            int n = this.fontWidth(this.progress);
            String string = "(" + RealmsUploadScreen.humanReadableByteCount(l) + ")";
            this.drawString(string, this.width() / 2 + n / 2 + 15, 84, 0xFFFFFF);
        }
    }

    public static String humanReadableByteCount(long l) {
        int n = 1024;
        if (l < (long)n) {
            return l + " B";
        }
        int n2 = (int)(Math.log(l) / Math.log(n));
        String string = "KMGTPE".charAt(n2 - 1) + "";
        return String.format("%.1f %sB/s", (double)l / Math.pow(n, n2), string);
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
    }

    @Override
    public void tick() {
        super.tick();
        ++this.animTick;
    }

    public static Unit getLargestUnit(long l) {
        if (l < 1024L) {
            return Unit.B;
        }
        int n = (int)(Math.log(l) / Math.log(1024.0));
        String string = "KMGTPE".charAt(n - 1) + "";
        try {
            return Unit.valueOf(string + "B");
        }
        catch (Exception exception) {
            return Unit.GB;
        }
    }

    public static double convertToUnit(long l, Unit unit) {
        if (unit.equals((Object)Unit.B)) {
            return l;
        }
        return (double)l / Math.pow(1024.0, unit.ordinal());
    }

    public static String humanReadableSize(long l, Unit unit) {
        return String.format("%." + (unit.equals((Object)Unit.GB) ? "1" : "0") + "f %s", RealmsUploadScreen.convertToUnit(l, unit), unit.name());
    }

    private void upload() {
        this.uploadStarted = true;
        new Thread(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                File file = null;
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                long l = RealmsUploadScreen.this.worldId;
                try {
                    if (!uploadLock.tryLock(1L, TimeUnit.SECONDS)) {
                        return;
                    }
                    RealmsUploadScreen.this.status = RealmsScreen.getLocalizedString("mco.upload.preparing");
                    UploadInfo uploadInfo = null;
                    for (int i = 0; i < 20; ++i) {
                        block39: {
                            try {
                                if (!RealmsUploadScreen.this.cancelled) break block39;
                                RealmsUploadScreen.this.uploadCancelled(l);
                                return;
                            }
                            catch (RetryCallException retryCallException) {
                                Thread.sleep(retryCallException.delaySeconds * 1000);
                                continue;
                            }
                        }
                        uploadInfo = realmsClient.upload(l, UploadTokenCache.get(l));
                        break;
                    }
                    if (uploadInfo == null) {
                        RealmsUploadScreen.this.status = RealmsScreen.getLocalizedString("mco.upload.close.failure");
                        return;
                    }
                    UploadTokenCache.put(l, uploadInfo.getToken());
                    if (!uploadInfo.isWorldClosed()) {
                        RealmsUploadScreen.this.status = RealmsScreen.getLocalizedString("mco.upload.close.failure");
                        return;
                    }
                    if (RealmsUploadScreen.this.cancelled) {
                        RealmsUploadScreen.this.uploadCancelled(l);
                        return;
                    }
                    File file2 = new File(Realms.getGameDirectoryPath(), "saves");
                    file = RealmsUploadScreen.this.tarGzipArchive(new File(file2, RealmsUploadScreen.this.selectedLevel.getLevelId()));
                    if (RealmsUploadScreen.this.cancelled) {
                        RealmsUploadScreen.this.uploadCancelled(l);
                        return;
                    }
                    if (!RealmsUploadScreen.this.verify(file)) {
                        long l2 = file.length();
                        Unit unit = RealmsUploadScreen.getLargestUnit(l2);
                        Unit unit2 = RealmsUploadScreen.getLargestUnit(0x40000000L);
                        if (RealmsUploadScreen.humanReadableSize(l2, unit).equals(RealmsUploadScreen.humanReadableSize(0x40000000L, unit2)) && unit != Unit.B) {
                            Unit unit3 = Unit.values()[unit.ordinal() - 1];
                            RealmsUploadScreen.this.errorMessage = RealmsScreen.getLocalizedString("mco.upload.size.failure", RealmsUploadScreen.this.selectedLevel.getLevelName(), RealmsUploadScreen.humanReadableSize(l2, unit3), RealmsUploadScreen.humanReadableSize(0x40000000L, unit3));
                            return;
                        }
                        RealmsUploadScreen.this.errorMessage = RealmsScreen.getLocalizedString("mco.upload.size.failure", RealmsUploadScreen.this.selectedLevel.getLevelName(), RealmsUploadScreen.humanReadableSize(l2, unit), RealmsUploadScreen.humanReadableSize(0x40000000L, unit2));
                        return;
                    }
                    RealmsUploadScreen.this.status = RealmsScreen.getLocalizedString("mco.upload.uploading", RealmsUploadScreen.this.selectedLevel.getLevelName());
                    FileUpload fileUpload = new FileUpload();
                    fileUpload.upload(file, RealmsUploadScreen.this.worldId, RealmsUploadScreen.this.slotId, uploadInfo, Realms.getSessionId(), Realms.getName(), RealmsSharedConstants.VERSION_STRING, RealmsUploadScreen.this.uploadStatus);
                    while (!fileUpload.isFinished()) {
                        if (RealmsUploadScreen.this.cancelled) {
                            fileUpload.cancel();
                            RealmsUploadScreen.this.uploadCancelled(l);
                            return;
                        }
                        try {
                            Thread.sleep(500L);
                        }
                        catch (InterruptedException interruptedException) {
                            LOGGER.error("Failed to check Realms file upload status");
                        }
                    }
                    if (fileUpload.getStatusCode() >= 200 && fileUpload.getStatusCode() < 300) {
                        RealmsUploadScreen.this.uploadFinished = true;
                        RealmsUploadScreen.this.status = RealmsScreen.getLocalizedString("mco.upload.done");
                        RealmsUploadScreen.this.backButton.msg(RealmsScreen.getLocalizedString("gui.done"));
                        UploadTokenCache.invalidate(l);
                    } else if (fileUpload.getStatusCode() == 400 && fileUpload.getErrorMessage() != null) {
                        RealmsUploadScreen.this.errorMessage = RealmsScreen.getLocalizedString("mco.upload.failed", fileUpload.getErrorMessage());
                    } else {
                        RealmsUploadScreen.this.errorMessage = RealmsScreen.getLocalizedString("mco.upload.failed", fileUpload.getStatusCode());
                    }
                }
                catch (IOException iOException) {
                    RealmsUploadScreen.this.errorMessage = RealmsScreen.getLocalizedString("mco.upload.failed", iOException.getMessage());
                }
                catch (RealmsServiceException realmsServiceException) {
                    RealmsUploadScreen.this.errorMessage = RealmsScreen.getLocalizedString("mco.upload.failed", realmsServiceException.toString());
                }
                catch (InterruptedException interruptedException) {
                    LOGGER.error("Could not acquire upload lock");
                }
                finally {
                    RealmsUploadScreen.this.uploadFinished = true;
                    if (!uploadLock.isHeldByCurrentThread()) {
                        return;
                    }
                    uploadLock.unlock();
                    RealmsUploadScreen.this.showDots = false;
                    RealmsUploadScreen.this.buttonsClear();
                    RealmsUploadScreen.this.buttonsAdd(RealmsUploadScreen.this.backButton);
                    if (file != null) {
                        LOGGER.debug("Deleting file " + file.getAbsolutePath());
                        file.delete();
                    }
                }
            }
        }.start();
    }

    private void uploadCancelled(long l) {
        this.status = RealmsUploadScreen.getLocalizedString("mco.upload.cancelled");
        LOGGER.debug("Upload was cancelled");
    }

    private boolean verify(File file) {
        return file.length() < 0x40000000L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private File tarGzipArchive(File file) throws IOException {
        TarArchiveOutputStream tarArchiveOutputStream = null;
        try {
            File file2 = File.createTempFile("realms-upload-file", ".tar.gz");
            tarArchiveOutputStream = new TarArchiveOutputStream(new GZIPOutputStream(new FileOutputStream(file2)));
            this.addFileToTarGz(tarArchiveOutputStream, file.getAbsolutePath(), "world", true);
            tarArchiveOutputStream.finish();
            File file3 = file2;
            return file3;
        }
        finally {
            if (tarArchiveOutputStream != null) {
                tarArchiveOutputStream.close();
            }
        }
    }

    private void addFileToTarGz(TarArchiveOutputStream tarArchiveOutputStream, String string, String string2, boolean bl) throws IOException {
        if (this.cancelled) {
            return;
        }
        File file = new File(string);
        String string3 = bl ? string2 : string2 + file.getName();
        TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(file, string3);
        tarArchiveOutputStream.putArchiveEntry(tarArchiveEntry);
        if (file.isFile()) {
            IOUtils.copy(new FileInputStream(file), tarArchiveOutputStream);
            tarArchiveOutputStream.closeArchiveEntry();
        } else {
            tarArchiveOutputStream.closeArchiveEntry();
            File[] fileArray = file.listFiles();
            if (fileArray != null) {
                for (File file2 : fileArray) {
                    this.addFileToTarGz(tarArchiveOutputStream, file2.getAbsolutePath(), string3 + "/", false);
                }
            }
        }
    }

    public static enum Unit {
        B,
        KB,
        MB,
        GB;

    }
}

