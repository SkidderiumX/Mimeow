/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

public class FileUtils {
    private static final String PROTOCOL_FILE = "file";
    private static final String JBOSS_FILE = "vfsfile";
    private static final Logger LOGGER = StatusLogger.getLogger();

    private FileUtils() {
    }

    public static File fileFromURI(URI uRI) {
        if (uRI == null || uRI.getScheme() != null && !PROTOCOL_FILE.equals(uRI.getScheme()) && !JBOSS_FILE.equals(uRI.getScheme())) {
            return null;
        }
        if (uRI.getScheme() == null) {
            try {
                uRI = new File(uRI.getPath()).toURI();
            }
            catch (Exception exception) {
                LOGGER.warn("Invalid URI " + uRI);
                return null;
            }
        }
        try {
            return new File(URLDecoder.decode(uRI.toURL().getFile(), "UTF8"));
        }
        catch (MalformedURLException malformedURLException) {
            LOGGER.warn("Invalid URL " + uRI, (Throwable)malformedURLException);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            LOGGER.warn("Invalid encoding: UTF8", (Throwable)unsupportedEncodingException);
        }
        return null;
    }

    public static boolean isFile(URL uRL) {
        return uRL != null && (uRL.getProtocol().equals(PROTOCOL_FILE) || uRL.getProtocol().equals(JBOSS_FILE));
    }

    public static void mkdir(File file, boolean bl) throws IOException {
        if (!file.exists()) {
            if (!bl) {
                throw new IOException("The directory " + file.getAbsolutePath() + " does not exist.");
            }
            if (!file.mkdirs()) {
                throw new IOException("Could not create directory " + file.getAbsolutePath());
            }
        }
        if (!file.isDirectory()) {
            throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
        }
    }
}

