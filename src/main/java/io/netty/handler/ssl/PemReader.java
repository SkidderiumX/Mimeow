/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PemReader {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PemReader.class);
    private static final Pattern CERT_PATTERN = Pattern.compile("-+BEGIN\\s+.*CERTIFICATE[^-]*-+(?:\\s|\\r|\\n)+([a-z0-9+/=\\r\\n]+)-+END\\s+.*CERTIFICATE[^-]*-+", 2);
    private static final Pattern KEY_PATTERN = Pattern.compile("-+BEGIN\\s+.*PRIVATE\\s+KEY[^-]*-+(?:\\s|\\r|\\n)+([a-z0-9+/=\\r\\n]+)-+END\\s+.*PRIVATE\\s+KEY[^-]*-+", 2);

    static ByteBuf[] readCertificates(File file) throws CertificateException {
        String string;
        try {
            string = PemReader.readContent(file);
        }
        catch (IOException iOException) {
            throw new CertificateException("failed to read a file: " + file, iOException);
        }
        ArrayList<ByteBuf> arrayList = new ArrayList<ByteBuf>();
        Matcher matcher = CERT_PATTERN.matcher(string);
        int n = 0;
        while (matcher.find(n)) {
            ByteBuf byteBuf = Unpooled.copiedBuffer(matcher.group(1), CharsetUtil.US_ASCII);
            ByteBuf byteBuf2 = Base64.decode(byteBuf);
            byteBuf.release();
            arrayList.add(byteBuf2);
            n = matcher.end();
        }
        if (arrayList.isEmpty()) {
            throw new CertificateException("found no certificates: " + file);
        }
        return arrayList.toArray(new ByteBuf[arrayList.size()]);
    }

    static ByteBuf readPrivateKey(File file) throws KeyException {
        String string;
        try {
            string = PemReader.readContent(file);
        }
        catch (IOException iOException) {
            throw new KeyException("failed to read a file: " + file, iOException);
        }
        Matcher matcher = KEY_PATTERN.matcher(string);
        if (!matcher.find()) {
            throw new KeyException("found no private key: " + file);
        }
        ByteBuf byteBuf = Unpooled.copiedBuffer(matcher.group(1), CharsetUtil.US_ASCII);
        ByteBuf byteBuf2 = Base64.decode(byteBuf);
        byteBuf.release();
        return byteBuf2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String readContent(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int n;
            byte[] byArray = new byte[8192];
            while ((n = ((InputStream)fileInputStream).read(byArray)) >= 0) {
                byteArrayOutputStream.write(byArray, 0, n);
            }
            String string = byteArrayOutputStream.toString(CharsetUtil.US_ASCII.name());
            return string;
        }
        finally {
            PemReader.safeClose(fileInputStream);
            PemReader.safeClose(byteArrayOutputStream);
        }
    }

    private static void safeClose(InputStream inputStream2) {
        try {
            inputStream2.close();
        }
        catch (IOException iOException) {
            logger.warn("Failed to close a stream.", iOException);
        }
    }

    private static void safeClose(OutputStream outputStream2) {
        try {
            outputStream2.close();
        }
        catch (IOException iOException) {
            logger.warn("Failed to close a stream.", iOException);
        }
    }

    private PemReader() {
    }
}

