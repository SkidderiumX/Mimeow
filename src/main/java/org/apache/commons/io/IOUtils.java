/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;

public class IOUtils {
    private static final int EOF = -1;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final String LINE_SEPARATOR_UNIX = "\n";
    public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
    public static final String LINE_SEPARATOR;
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static char[] SKIP_CHAR_BUFFER;
    private static byte[] SKIP_BYTE_BUFFER;

    public static void close(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection)uRLConnection).disconnect();
        }
    }

    public static void closeQuietly(Reader reader) {
        IOUtils.closeQuietly((Closeable)reader);
    }

    public static void closeQuietly(Writer writer) {
        IOUtils.closeQuietly((Closeable)writer);
    }

    public static void closeQuietly(InputStream inputStream2) {
        IOUtils.closeQuietly((Closeable)inputStream2);
    }

    public static void closeQuietly(OutputStream outputStream2) {
        IOUtils.closeQuietly((Closeable)outputStream2);
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public static void closeQuietly(Selector selector) {
        if (selector != null) {
            try {
                selector.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public static InputStream toBufferedInputStream(InputStream inputStream2) throws IOException {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream2);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader);
    }

    public static byte[] toByteArray(InputStream inputStream2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream2, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(InputStream inputStream2, long l) throws IOException {
        if (l > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + l);
        }
        return IOUtils.toByteArray(inputStream2, (int)l);
    }

    public static byte[] toByteArray(InputStream inputStream2, int n) throws IOException {
        int n2;
        int n3;
        if (n < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + n);
        }
        if (n == 0) {
            return new byte[0];
        }
        byte[] byArray = new byte[n];
        for (n2 = 0; n2 < n && (n3 = inputStream2.read(byArray, n2, n - n2)) != -1; n2 += n3) {
        }
        if (n2 != n) {
            throw new IOException("Unexpected readed size. current: " + n2 + ", excepted: " + n);
        }
        return byArray;
    }

    public static byte[] toByteArray(Reader reader) throws IOException {
        return IOUtils.toByteArray(reader, Charset.defaultCharset());
    }

    public static byte[] toByteArray(Reader reader, Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(reader, (OutputStream)byteArrayOutputStream, charset);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(Reader reader, String string) throws IOException {
        return IOUtils.toByteArray(reader, Charsets.toCharset(string));
    }

    @Deprecated
    public static byte[] toByteArray(String string) throws IOException {
        return string.getBytes();
    }

    public static byte[] toByteArray(URI uRI) throws IOException {
        return IOUtils.toByteArray(uRI.toURL());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] toByteArray(URL uRL) throws IOException {
        URLConnection uRLConnection = uRL.openConnection();
        try {
            byte[] byArray = IOUtils.toByteArray(uRLConnection);
            return byArray;
        }
        finally {
            IOUtils.close(uRLConnection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] toByteArray(URLConnection uRLConnection) throws IOException {
        InputStream inputStream2 = uRLConnection.getInputStream();
        try {
            byte[] byArray = IOUtils.toByteArray(inputStream2);
            return byArray;
        }
        finally {
            inputStream2.close();
        }
    }

    public static char[] toCharArray(InputStream inputStream2) throws IOException {
        return IOUtils.toCharArray(inputStream2, Charset.defaultCharset());
    }

    public static char[] toCharArray(InputStream inputStream2, Charset charset) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        IOUtils.copy(inputStream2, (Writer)charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(InputStream inputStream2, String string) throws IOException {
        return IOUtils.toCharArray(inputStream2, Charsets.toCharset(string));
    }

    public static char[] toCharArray(Reader reader) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        IOUtils.copy(reader, (Writer)charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static String toString(InputStream inputStream2) throws IOException {
        return IOUtils.toString(inputStream2, Charset.defaultCharset());
    }

    public static String toString(InputStream inputStream2, Charset charset) throws IOException {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        IOUtils.copy(inputStream2, (Writer)stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static String toString(InputStream inputStream2, String string) throws IOException {
        return IOUtils.toString(inputStream2, Charsets.toCharset(string));
    }

    public static String toString(Reader reader) throws IOException {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        IOUtils.copy(reader, (Writer)stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static String toString(URI uRI) throws IOException {
        return IOUtils.toString(uRI, Charset.defaultCharset());
    }

    public static String toString(URI uRI, Charset charset) throws IOException {
        return IOUtils.toString(uRI.toURL(), Charsets.toCharset(charset));
    }

    public static String toString(URI uRI, String string) throws IOException {
        return IOUtils.toString(uRI, Charsets.toCharset(string));
    }

    public static String toString(URL uRL) throws IOException {
        return IOUtils.toString(uRL, Charset.defaultCharset());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String toString(URL uRL, Charset charset) throws IOException {
        InputStream inputStream2 = uRL.openStream();
        try {
            String string = IOUtils.toString(inputStream2, charset);
            return string;
        }
        finally {
            inputStream2.close();
        }
    }

    public static String toString(URL uRL, String string) throws IOException {
        return IOUtils.toString(uRL, Charsets.toCharset(string));
    }

    @Deprecated
    public static String toString(byte[] byArray) throws IOException {
        return new String(byArray);
    }

    public static String toString(byte[] byArray, String string) throws IOException {
        return new String(byArray, Charsets.toCharset(string));
    }

    public static List<String> readLines(InputStream inputStream2) throws IOException {
        return IOUtils.readLines(inputStream2, Charset.defaultCharset());
    }

    public static List<String> readLines(InputStream inputStream2, Charset charset) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, Charsets.toCharset(charset));
        return IOUtils.readLines(inputStreamReader);
    }

    public static List<String> readLines(InputStream inputStream2, String string) throws IOException {
        return IOUtils.readLines(inputStream2, Charsets.toCharset(string));
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = IOUtils.toBufferedReader(reader);
        ArrayList<String> arrayList = new ArrayList<String>();
        String string = bufferedReader.readLine();
        while (string != null) {
            arrayList.add(string);
            string = bufferedReader.readLine();
        }
        return arrayList;
    }

    public static LineIterator lineIterator(Reader reader) {
        return new LineIterator(reader);
    }

    public static LineIterator lineIterator(InputStream inputStream2, Charset charset) throws IOException {
        return new LineIterator(new InputStreamReader(inputStream2, Charsets.toCharset(charset)));
    }

    public static LineIterator lineIterator(InputStream inputStream2, String string) throws IOException {
        return IOUtils.lineIterator(inputStream2, Charsets.toCharset(string));
    }

    public static InputStream toInputStream(CharSequence charSequence) {
        return IOUtils.toInputStream(charSequence, Charset.defaultCharset());
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return IOUtils.toInputStream(((Object)charSequence).toString(), charset);
    }

    public static InputStream toInputStream(CharSequence charSequence, String string) throws IOException {
        return IOUtils.toInputStream(charSequence, Charsets.toCharset(string));
    }

    public static InputStream toInputStream(String string) {
        return IOUtils.toInputStream(string, Charset.defaultCharset());
    }

    public static InputStream toInputStream(String string, Charset charset) {
        return new ByteArrayInputStream(string.getBytes(Charsets.toCharset(charset)));
    }

    public static InputStream toInputStream(String string, String string2) throws IOException {
        byte[] byArray = string.getBytes(Charsets.toCharset(string2));
        return new ByteArrayInputStream(byArray);
    }

    public static void write(byte[] byArray, OutputStream outputStream2) throws IOException {
        if (byArray != null) {
            outputStream2.write(byArray);
        }
    }

    public static void write(byte[] byArray, Writer writer) throws IOException {
        IOUtils.write(byArray, writer, Charset.defaultCharset());
    }

    public static void write(byte[] byArray, Writer writer, Charset charset) throws IOException {
        if (byArray != null) {
            writer.write(new String(byArray, Charsets.toCharset(charset)));
        }
    }

    public static void write(byte[] byArray, Writer writer, String string) throws IOException {
        IOUtils.write(byArray, writer, Charsets.toCharset(string));
    }

    public static void write(char[] cArray, Writer writer) throws IOException {
        if (cArray != null) {
            writer.write(cArray);
        }
    }

    public static void write(char[] cArray, OutputStream outputStream2) throws IOException {
        IOUtils.write(cArray, outputStream2, Charset.defaultCharset());
    }

    public static void write(char[] cArray, OutputStream outputStream2, Charset charset) throws IOException {
        if (cArray != null) {
            outputStream2.write(new String(cArray).getBytes(Charsets.toCharset(charset)));
        }
    }

    public static void write(char[] cArray, OutputStream outputStream2, String string) throws IOException {
        IOUtils.write(cArray, outputStream2, Charsets.toCharset(string));
    }

    public static void write(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence != null) {
            IOUtils.write(((Object)charSequence).toString(), writer);
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream2) throws IOException {
        IOUtils.write(charSequence, outputStream2, Charset.defaultCharset());
    }

    public static void write(CharSequence charSequence, OutputStream outputStream2, Charset charset) throws IOException {
        if (charSequence != null) {
            IOUtils.write(((Object)charSequence).toString(), outputStream2, charset);
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream2, String string) throws IOException {
        IOUtils.write(charSequence, outputStream2, Charsets.toCharset(string));
    }

    public static void write(String string, Writer writer) throws IOException {
        if (string != null) {
            writer.write(string);
        }
    }

    public static void write(String string, OutputStream outputStream2) throws IOException {
        IOUtils.write(string, outputStream2, Charset.defaultCharset());
    }

    public static void write(String string, OutputStream outputStream2, Charset charset) throws IOException {
        if (string != null) {
            outputStream2.write(string.getBytes(Charsets.toCharset(charset)));
        }
    }

    public static void write(String string, OutputStream outputStream2, String string2) throws IOException {
        IOUtils.write(string, outputStream2, Charsets.toCharset(string2));
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, Writer writer) throws IOException {
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream2) throws IOException {
        IOUtils.write(stringBuffer, outputStream2, (String)null);
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream2, String string) throws IOException {
        if (stringBuffer != null) {
            outputStream2.write(stringBuffer.toString().getBytes(Charsets.toCharset(string)));
        }
    }

    public static void writeLines(Collection<?> collection, String string, OutputStream outputStream2) throws IOException {
        IOUtils.writeLines(collection, string, outputStream2, Charset.defaultCharset());
    }

    public static void writeLines(Collection<?> collection, String string, OutputStream outputStream2, Charset charset) throws IOException {
        if (collection == null) {
            return;
        }
        if (string == null) {
            string = LINE_SEPARATOR;
        }
        Charset charset2 = Charsets.toCharset(charset);
        for (Object obj : collection) {
            if (obj != null) {
                outputStream2.write(obj.toString().getBytes(charset2));
            }
            outputStream2.write(string.getBytes(charset2));
        }
    }

    public static void writeLines(Collection<?> collection, String string, OutputStream outputStream2, String string2) throws IOException {
        IOUtils.writeLines(collection, string, outputStream2, Charsets.toCharset(string2));
    }

    public static void writeLines(Collection<?> collection, String string, Writer writer) throws IOException {
        if (collection == null) {
            return;
        }
        if (string == null) {
            string = LINE_SEPARATOR;
        }
        for (Object obj : collection) {
            if (obj != null) {
                writer.write(obj.toString());
            }
            writer.write(string);
        }
    }

    public static int copy(InputStream inputStream2, OutputStream outputStream2) throws IOException {
        long l = IOUtils.copyLarge(inputStream2, outputStream2);
        if (l > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)l;
    }

    public static long copyLarge(InputStream inputStream2, OutputStream outputStream2) throws IOException {
        return IOUtils.copyLarge(inputStream2, outputStream2, new byte[4096]);
    }

    public static long copyLarge(InputStream inputStream2, OutputStream outputStream2, byte[] byArray) throws IOException {
        long l = 0L;
        int n = 0;
        while (-1 != (n = inputStream2.read(byArray))) {
            outputStream2.write(byArray, 0, n);
            l += (long)n;
        }
        return l;
    }

    public static long copyLarge(InputStream inputStream2, OutputStream outputStream2, long l, long l2) throws IOException {
        return IOUtils.copyLarge(inputStream2, outputStream2, l, l2, new byte[4096]);
    }

    public static long copyLarge(InputStream inputStream2, OutputStream outputStream2, long l, long l2, byte[] byArray) throws IOException {
        int n;
        int n2;
        if (l > 0L) {
            IOUtils.skipFully(inputStream2, l);
        }
        if (l2 == 0L) {
            return 0L;
        }
        int n3 = n2 = byArray.length;
        if (l2 > 0L && l2 < (long)n2) {
            n3 = (int)l2;
        }
        long l3 = 0L;
        while (n3 > 0 && -1 != (n = inputStream2.read(byArray, 0, n3))) {
            outputStream2.write(byArray, 0, n);
            l3 += (long)n;
            if (l2 <= 0L) continue;
            n3 = (int)Math.min(l2 - l3, (long)n2);
        }
        return l3;
    }

    public static void copy(InputStream inputStream2, Writer writer) throws IOException {
        IOUtils.copy(inputStream2, writer, Charset.defaultCharset());
    }

    public static void copy(InputStream inputStream2, Writer writer, Charset charset) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, Charsets.toCharset(charset));
        IOUtils.copy((Reader)inputStreamReader, writer);
    }

    public static void copy(InputStream inputStream2, Writer writer, String string) throws IOException {
        IOUtils.copy(inputStream2, writer, Charsets.toCharset(string));
    }

    public static int copy(Reader reader, Writer writer) throws IOException {
        long l = IOUtils.copyLarge(reader, writer);
        if (l > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)l;
    }

    public static long copyLarge(Reader reader, Writer writer) throws IOException {
        return IOUtils.copyLarge(reader, writer, new char[4096]);
    }

    public static long copyLarge(Reader reader, Writer writer, char[] cArray) throws IOException {
        long l = 0L;
        int n = 0;
        while (-1 != (n = reader.read(cArray))) {
            writer.write(cArray, 0, n);
            l += (long)n;
        }
        return l;
    }

    public static long copyLarge(Reader reader, Writer writer, long l, long l2) throws IOException {
        return IOUtils.copyLarge(reader, writer, l, l2, new char[4096]);
    }

    public static long copyLarge(Reader reader, Writer writer, long l, long l2, char[] cArray) throws IOException {
        int n;
        if (l > 0L) {
            IOUtils.skipFully(reader, l);
        }
        if (l2 == 0L) {
            return 0L;
        }
        int n2 = cArray.length;
        if (l2 > 0L && l2 < (long)cArray.length) {
            n2 = (int)l2;
        }
        long l3 = 0L;
        while (n2 > 0 && -1 != (n = reader.read(cArray, 0, n2))) {
            writer.write(cArray, 0, n);
            l3 += (long)n;
            if (l2 <= 0L) continue;
            n2 = (int)Math.min(l2 - l3, (long)cArray.length);
        }
        return l3;
    }

    public static void copy(Reader reader, OutputStream outputStream2) throws IOException {
        IOUtils.copy(reader, outputStream2, Charset.defaultCharset());
    }

    public static void copy(Reader reader, OutputStream outputStream2, Charset charset) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream2, Charsets.toCharset(charset));
        IOUtils.copy(reader, (Writer)outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void copy(Reader reader, OutputStream outputStream2, String string) throws IOException {
        IOUtils.copy(reader, outputStream2, Charsets.toCharset(string));
    }

    public static boolean contentEquals(InputStream inputStream2, InputStream inputStream3) throws IOException {
        int n;
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        if (!(inputStream3 instanceof BufferedInputStream)) {
            inputStream3 = new BufferedInputStream(inputStream3);
        }
        int n2 = inputStream2.read();
        while (-1 != n2) {
            n = inputStream3.read();
            if (n2 != n) {
                return false;
            }
            n2 = inputStream2.read();
        }
        n = inputStream3.read();
        return n == -1;
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        int n;
        reader = IOUtils.toBufferedReader(reader);
        reader2 = IOUtils.toBufferedReader(reader2);
        int n2 = reader.read();
        while (-1 != n2) {
            n = reader2.read();
            if (n2 != n) {
                return false;
            }
            n2 = reader.read();
        }
        n = reader2.read();
        return n == -1;
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) throws IOException {
        BufferedReader bufferedReader = IOUtils.toBufferedReader(reader);
        BufferedReader bufferedReader2 = IOUtils.toBufferedReader(reader2);
        String string = bufferedReader.readLine();
        String string2 = bufferedReader2.readLine();
        while (string != null && string2 != null && string.equals(string2)) {
            string = bufferedReader.readLine();
            string2 = bufferedReader2.readLine();
        }
        return string == null ? string2 == null : string.equals(string2);
    }

    public static long skip(InputStream inputStream2, long l) throws IOException {
        long l2;
        long l3;
        if (l < 0L) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + l);
        }
        if (SKIP_BYTE_BUFFER == null) {
            SKIP_BYTE_BUFFER = new byte[2048];
        }
        for (l2 = l; l2 > 0L && (l3 = (long)inputStream2.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l2, 2048L))) >= 0L; l2 -= l3) {
        }
        return l - l2;
    }

    public static long skip(Reader reader, long l) throws IOException {
        long l2;
        long l3;
        if (l < 0L) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + l);
        }
        if (SKIP_CHAR_BUFFER == null) {
            SKIP_CHAR_BUFFER = new char[2048];
        }
        for (l2 = l; l2 > 0L && (l3 = (long)reader.read(SKIP_CHAR_BUFFER, 0, (int)Math.min(l2, 2048L))) >= 0L; l2 -= l3) {
        }
        return l - l2;
    }

    public static void skipFully(InputStream inputStream2, long l) throws IOException {
        if (l < 0L) {
            throw new IllegalArgumentException("Bytes to skip must not be negative: " + l);
        }
        long l2 = IOUtils.skip(inputStream2, l);
        if (l2 != l) {
            throw new EOFException("Bytes to skip: " + l + " actual: " + l2);
        }
    }

    public static void skipFully(Reader reader, long l) throws IOException {
        long l2 = IOUtils.skip(reader, l);
        if (l2 != l) {
            throw new EOFException("Chars to skip: " + l + " actual: " + l2);
        }
    }

    public static int read(Reader reader, char[] cArray, int n, int n2) throws IOException {
        int n3;
        int n4;
        int n5;
        if (n2 < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + n2);
        }
        for (n4 = n2; n4 > 0 && -1 != (n5 = reader.read(cArray, n + (n3 = n2 - n4), n4)); n4 -= n5) {
        }
        return n2 - n4;
    }

    public static int read(Reader reader, char[] cArray) throws IOException {
        return IOUtils.read(reader, cArray, 0, cArray.length);
    }

    public static int read(InputStream inputStream2, byte[] byArray, int n, int n2) throws IOException {
        int n3;
        int n4;
        int n5;
        if (n2 < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + n2);
        }
        for (n4 = n2; n4 > 0 && -1 != (n5 = inputStream2.read(byArray, n + (n3 = n2 - n4), n4)); n4 -= n5) {
        }
        return n2 - n4;
    }

    public static int read(InputStream inputStream2, byte[] byArray) throws IOException {
        return IOUtils.read(inputStream2, byArray, 0, byArray.length);
    }

    public static void readFully(Reader reader, char[] cArray, int n, int n2) throws IOException {
        int n3 = IOUtils.read(reader, cArray, n, n2);
        if (n3 != n2) {
            throw new EOFException("Length to read: " + n2 + " actual: " + n3);
        }
    }

    public static void readFully(Reader reader, char[] cArray) throws IOException {
        IOUtils.readFully(reader, cArray, 0, cArray.length);
    }

    public static void readFully(InputStream inputStream2, byte[] byArray, int n, int n2) throws IOException {
        int n3 = IOUtils.read(inputStream2, byArray, n, n2);
        if (n3 != n2) {
            throw new EOFException("Length to read: " + n2 + " actual: " + n3);
        }
    }

    public static void readFully(InputStream inputStream2, byte[] byArray) throws IOException {
        IOUtils.readFully(inputStream2, byArray, 0, byArray.length);
    }

    static {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        LINE_SEPARATOR = stringBuilderWriter.toString();
        printWriter.close();
    }
}

