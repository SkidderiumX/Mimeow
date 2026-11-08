package com.mojang.realmsclient.client;

import org.apache.http.client.config.*;
import org.apache.http.impl.client.*;
import com.mojang.realmsclient.dto.*;
import com.mojang.realmsclient.gui.screens.*;
import org.apache.commons.lang3.*;
import net.minecraft.realms.*;
import org.apache.commons.compress.compressors.gzip.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import org.apache.commons.compress.archivers.tar.*;
import org.apache.logging.log4j.*;
import org.apache.commons.io.output.*;
import java.awt.event.*;
import com.google.common.hash.*;
import com.google.common.io.*;
import org.apache.commons.io.*;
import org.apache.http.client.methods.*;

public class FileDownload
{
    private static final Logger LOGGER;
    private volatile boolean cancelled;
    private volatile boolean finished;
    private volatile boolean error;
    private volatile boolean extracting;
    private volatile File tempFile;
    private volatile File resourcePackPath;
    private volatile HttpGet request;
    private Thread currentThread;
    private RequestConfig requestConfig;
    private static final String[] INVALID_FILE_NAMES;
    
    public FileDownload() {
        this.cancelled = false;
        this.finished = false;
        this.error = false;
        this.extracting = false;
        this.requestConfig = RequestConfig.custom().setSocketTimeout(120000).setConnectTimeout(120000).build();
    }
    
    public long contentLength(final String s) {
        CloseableHttpClient build = null;
        HttpUriRequest httpUriRequest = null;
        try {
            httpUriRequest = new HttpGet(s);
            build = HttpClientBuilder.create().setDefaultRequestConfig(this.requestConfig).build();
            return Long.parseLong(build.execute(httpUriRequest).getFirstHeader("Content-Length").getValue());
        }
        catch (final Throwable t) {
            FileDownload.LOGGER.error("Unable to get content length for download");
            return 0L;
        }
        finally {
            if (httpUriRequest != null) {
                ((HttpRequestBase)httpUriRequest).releaseConnection();
            }
            if (build != null) {
                try {
                    build.close();
                }
                catch (final IOException ex) {
                    FileDownload.LOGGER.error("Could not close http client", ex);
                }
            }
        }
    }
    
    public void download(final WorldDownload worldDownload, final String s, final RealmsDownloadLatestWorldScreen.DownloadStatus downloadStatus, final RealmsAnvilLevelStorageSource realmsAnvilLevelStorageSource) {
        if (this.currentThread != null) {
            return;
        }
        (this.currentThread = new Thread() {
            @Override
            public void run() {
                CloseableHttpClient build = null;
                try {
                    FileDownload.this.tempFile = File.createTempFile("backup", ".tar.gz");
                    FileDownload.this.request = new HttpGet(worldDownload.downloadLink);
                    build = HttpClientBuilder.create().setDefaultRequestConfig(FileDownload.this.requestConfig).build();
                    final CloseableHttpResponse execute = build.execute((HttpUriRequest)FileDownload.this.request);
                    downloadStatus.totalBytes = Long.parseLong(execute.getFirstHeader("Content-Length").getValue());
                    if (execute.getStatusLine().getStatusCode() != 200) {
                        FileDownload.this.error = true;
                        FileDownload.this.request.abort();
                        return;
                    }
                    final FileOutputStream fileOutputStream = new FileOutputStream(FileDownload.this.tempFile);
                    final ProgressListener listener = new ProgressListener(s.trim(), FileDownload.this.tempFile, realmsAnvilLevelStorageSource, downloadStatus, worldDownload);
                    final DownloadCountingOutputStream downloadCountingOutputStream = new DownloadCountingOutputStream(fileOutputStream);
                    downloadCountingOutputStream.setListener(listener);
                    IOUtils.copy(execute.getEntity().getContent(), downloadCountingOutputStream);
                }
                catch (final Exception ex) {
                    FileDownload.LOGGER.error("Caught exception while downloading: " + ex.getMessage());
                    FileDownload.this.error = true;
                    FileDownload.this.request.releaseConnection();
                    if (FileDownload.this.tempFile != null) {
                        FileDownload.this.tempFile.delete();
                    }
                    if (!FileDownload.this.error) {
                        if (!worldDownload.resourcePackUrl.isEmpty() && !worldDownload.resourcePackHash.isEmpty()) {
                            try {
                                FileDownload.this.tempFile = File.createTempFile("resources", ".tar.gz");
                                FileDownload.this.request = new HttpGet(worldDownload.resourcePackUrl);
                                final CloseableHttpResponse execute2 = build.execute((HttpUriRequest)FileDownload.this.request);
                                downloadStatus.totalBytes = Long.parseLong(execute2.getFirstHeader("Content-Length").getValue());
                                if (execute2.getStatusLine().getStatusCode() != 200) {
                                    FileDownload.this.error = true;
                                    FileDownload.this.request.abort();
                                    return;
                                }
                                final FileOutputStream fileOutputStream2 = new FileOutputStream(FileDownload.this.tempFile);
                                final ResourcePackProgressListener listener2 = new ResourcePackProgressListener(FileDownload.this.tempFile, downloadStatus, worldDownload);
                                final DownloadCountingOutputStream downloadCountingOutputStream2 = new DownloadCountingOutputStream(fileOutputStream2);
                                downloadCountingOutputStream2.setListener(listener2);
                                IOUtils.copy(execute2.getEntity().getContent(), downloadCountingOutputStream2);
                            }
                            catch (final Exception ex2) {
                                FileDownload.LOGGER.error("Caught exception while downloading: " + ex2.getMessage());
                                FileDownload.this.error = true;
                            }
                            finally {
                                FileDownload.this.request.releaseConnection();
                                if (FileDownload.this.tempFile != null) {
                                    FileDownload.this.tempFile.delete();
                                }
                            }
                        }
                        else {
                            FileDownload.this.finished = true;
                        }
                    }
                    if (build != null) {
                        try {
                            build.close();
                        }
                        catch (final IOException ex3) {
                            FileDownload.LOGGER.error("Failed to close Realms download client");
                        }
                    }
                }
                finally {
                    FileDownload.this.request.releaseConnection();
                    if (FileDownload.this.tempFile != null) {
                        FileDownload.this.tempFile.delete();
                    }
                    if (!FileDownload.this.error) {
                        if (!worldDownload.resourcePackUrl.isEmpty() && !worldDownload.resourcePackHash.isEmpty()) {
                            try {
                                FileDownload.this.tempFile = File.createTempFile("resources", ".tar.gz");
                                FileDownload.this.request = new HttpGet(worldDownload.resourcePackUrl);
                                final CloseableHttpResponse execute3 = build.execute((HttpUriRequest)FileDownload.this.request);
                                downloadStatus.totalBytes = Long.parseLong(execute3.getFirstHeader("Content-Length").getValue());
                                if (execute3.getStatusLine().getStatusCode() != 200) {
                                    FileDownload.this.error = true;
                                    FileDownload.this.request.abort();
                                    return;
                                }
                                final FileOutputStream fileOutputStream3 = new FileOutputStream(FileDownload.this.tempFile);
                                final ResourcePackProgressListener listener3 = new ResourcePackProgressListener(FileDownload.this.tempFile, downloadStatus, worldDownload);
                                final DownloadCountingOutputStream downloadCountingOutputStream3 = new DownloadCountingOutputStream(fileOutputStream3);
                                downloadCountingOutputStream3.setListener(listener3);
                                IOUtils.copy(execute3.getEntity().getContent(), downloadCountingOutputStream3);
                            }
                            catch (final Exception ex4) {
                                FileDownload.LOGGER.error("Caught exception while downloading: " + ex4.getMessage());
                                FileDownload.this.error = true;
                                FileDownload.this.request.releaseConnection();
                                if (FileDownload.this.tempFile != null) {
                                    FileDownload.this.tempFile.delete();
                                }
                            }
                            finally {
                                FileDownload.this.request.releaseConnection();
                                if (FileDownload.this.tempFile != null) {
                                    FileDownload.this.tempFile.delete();
                                }
                            }
                        }
                        else {
                            FileDownload.this.finished = true;
                        }
                    }
                    if (build != null) {
                        try {
                            build.close();
                        }
                        catch (final IOException ex5) {
                            FileDownload.LOGGER.error("Failed to close Realms download client");
                        }
                    }
                }
            }
        }).start();
    }
    
    public void cancel() {
        if (this.request != null) {
            this.request.abort();
        }
        if (this.tempFile != null) {
            this.tempFile.delete();
        }
        this.cancelled = true;
    }
    
    public boolean isFinished() {
        return this.finished;
    }
    
    public boolean isError() {
        return this.error;
    }
    
    public boolean isExtracting() {
        return this.extracting;
    }
    
    public static String findAvailableFolderName(String str) {
        str = str.replaceAll("[\\./\"]", "_");
        final String[] invalid_FILE_NAMES = FileDownload.INVALID_FILE_NAMES;
        for (int length = invalid_FILE_NAMES.length, i = 0; i < length; ++i) {
            if (str.equalsIgnoreCase(invalid_FILE_NAMES[i])) {
                str = "_" + str + "_";
            }
        }
        return str;
    }
    
    private void untarGzipArchive(String s, final File file, final RealmsAnvilLevelStorageSource realmsAnvilLevelStorageSource) throws IOException {
        final Pattern compile = Pattern.compile(".*-([0-9]+)$");
        int intValue = 1;
        final char[] illegal_FILE_CHARACTERS = RealmsSharedConstants.ILLEGAL_FILE_CHARACTERS;
        for (int length = illegal_FILE_CHARACTERS.length, i = 0; i < length; ++i) {
            s = s.replace(illegal_FILE_CHARACTERS[i], '_');
        }
        if (StringUtils.isEmpty(s)) {
            s = "Realm";
        }
        s = findAvailableFolderName(s);
        try {
            for (final RealmsLevelSummary realmsLevelSummary : realmsAnvilLevelStorageSource.getLevelList()) {
                if (realmsLevelSummary.getLevelId().toLowerCase().startsWith(s.toLowerCase())) {
                    final Matcher matcher = compile.matcher(realmsLevelSummary.getLevelId());
                    if (matcher.matches()) {
                        if (Integer.valueOf(matcher.group(1)) <= intValue) {
                            continue;
                        }
                        intValue = Integer.valueOf(matcher.group(1));
                    }
                    else {
                        ++intValue;
                    }
                }
            }
        }
        catch (final Exception ex) {
            this.error = true;
            return;
        }
        String s2;
        if (!realmsAnvilLevelStorageSource.isNewLevelIdAcceptable(s) || intValue > 1) {
            s2 = s + ((intValue == 1) ? "" : ("-" + intValue));
            if (!realmsAnvilLevelStorageSource.isNewLevelIdAcceptable(s2)) {
                for (int j = 0; j == 0; j = 1) {
                    ++intValue;
                    s2 = s + ((intValue == 1) ? "" : ("-" + intValue));
                    if (realmsAnvilLevelStorageSource.isNewLevelIdAcceptable(s2)) {}
                }
            }
        }
        else {
            s2 = s;
        }
        TarArchiveInputStream tarArchiveInputStream = null;
        final File file2 = new File(Realms.getGameDirectoryPath(), "saves");
        try {
            file2.mkdir();
            tarArchiveInputStream = new TarArchiveInputStream(new GzipCompressorInputStream(new BufferedInputStream(new FileInputStream(file))));
            for (TarArchiveEntry tarArchiveEntry = tarArchiveInputStream.getNextTarEntry(); tarArchiveEntry != null; tarArchiveEntry = tarArchiveInputStream.getNextTarEntry()) {
                final File file3 = new File(file2, tarArchiveEntry.getName().replace("world", s2));
                if (tarArchiveEntry.isDirectory()) {
                    file3.mkdirs();
                }
                else {
                    file3.createNewFile();
                    final byte[] array = new byte[1024];
                    final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                    int read;
                    while ((read = tarArchiveInputStream.read(array)) != -1) {
                        bufferedOutputStream.write(array, 0, read);
                    }
                    bufferedOutputStream.close();
                }
            }
        }
        catch (final Exception ex2) {
            this.error = true;
        }
        finally {
            if (tarArchiveInputStream != null) {
                tarArchiveInputStream.close();
            }
            if (file != null) {
                file.delete();
            }
            realmsAnvilLevelStorageSource.renameLevel(s2, s2.trim());
            this.resourcePackPath = new File(file2, s2 + File.separator + "resources.zip");
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        INVALID_FILE_NAMES = new String[] { "CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9" };
    }
    
    private class DownloadCountingOutputStream extends CountingOutputStream
    {
        private ActionListener listener;
        
        public DownloadCountingOutputStream(final OutputStream outputStream) {
            super(outputStream);
            this.listener = null;
        }
        
        public void setListener(final ActionListener listener) {
            this.listener = listener;
        }
        
        @Override
        protected void afterWrite(final int n) throws IOException {
            super.afterWrite(n);
            if (this.listener != null) {
                this.listener.actionPerformed(new ActionEvent(this, 0, null));
            }
        }
    }
    
    private class ResourcePackProgressListener implements ActionListener
    {
        private volatile File tempFile;
        private volatile RealmsDownloadLatestWorldScreen.DownloadStatus downloadStatus;
        private volatile WorldDownload worldDownload;
        
        private ResourcePackProgressListener(final File tempFile, final RealmsDownloadLatestWorldScreen.DownloadStatus downloadStatus, final WorldDownload worldDownload) {
            this.tempFile = tempFile;
            this.downloadStatus = downloadStatus;
            this.worldDownload = worldDownload;
        }
        
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            this.downloadStatus.bytesWritten = ((DownloadCountingOutputStream)actionEvent.getSource()).getByteCount();
            if (this.downloadStatus.bytesWritten >= this.downloadStatus.totalBytes && !FileDownload.this.cancelled) {
                try {
                    final String string = Hashing.sha1().hashBytes(Files.toByteArray(this.tempFile)).toString();
                    if (string.equals(this.worldDownload.resourcePackHash)) {
                        FileUtils.copyFile(this.tempFile, FileDownload.this.resourcePackPath);
                        FileDownload.this.finished = true;
                    }
                    else {
                        FileDownload.LOGGER.error("Resourcepack had wrong hash (expected " + this.worldDownload.resourcePackHash + ", found " + string + "). Deleting it.");
                        FileUtils.deleteQuietly(this.tempFile);
                        FileDownload.this.error = true;
                    }
                }
                catch (final IOException ex) {
                    FileDownload.LOGGER.error("Error copying resourcepack file", ex.getMessage());
                    FileDownload.this.error = true;
                }
            }
        }
    }
    
    private class ProgressListener implements ActionListener
    {
        private volatile String worldName;
        private volatile File tempFile;
        private volatile RealmsAnvilLevelStorageSource levelStorageSource;
        private volatile RealmsDownloadLatestWorldScreen.DownloadStatus downloadStatus;
        private volatile WorldDownload worldDownload;
        
        private ProgressListener(final String worldName, final File tempFile, final RealmsAnvilLevelStorageSource levelStorageSource, final RealmsDownloadLatestWorldScreen.DownloadStatus downloadStatus, final WorldDownload worldDownload) {
            this.worldName = worldName;
            this.tempFile = tempFile;
            this.levelStorageSource = levelStorageSource;
            this.downloadStatus = downloadStatus;
            this.worldDownload = worldDownload;
        }
        
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            this.downloadStatus.bytesWritten = ((DownloadCountingOutputStream)actionEvent.getSource()).getByteCount();
            if (this.downloadStatus.bytesWritten >= this.downloadStatus.totalBytes && !FileDownload.this.cancelled && !FileDownload.this.error) {
                try {
                    FileDownload.this.extracting = true;
                    FileDownload.this.untarGzipArchive(this.worldName, this.tempFile, this.levelStorageSource);
                }
                catch (final IOException ex) {
                    FileDownload.this.error = true;
                }
            }
        }
    }
}
