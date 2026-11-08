/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

@Deprecated
public class CopyUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    public static void copy(byte[] byArray, OutputStream outputStream2) throws IOException {
        outputStream2.write(byArray);
    }

    public static void copy(byte[] byArray, Writer writer) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        CopyUtils.copy((InputStream)byteArrayInputStream, writer);
    }

    public static void copy(byte[] byArray, Writer writer, String string) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        CopyUtils.copy(byteArrayInputStream, writer, string);
    }

    public static int copy(InputStream inputStream2, OutputStream outputStream2) throws IOException {
        byte[] byArray = new byte[4096];
        int n = 0;
        int n2 = 0;
        while (-1 != (n2 = inputStream2.read(byArray))) {
            outputStream2.write(byArray, 0, n2);
            n += n2;
        }
        return n;
    }

    public static int copy(Reader reader, Writer writer) throws IOException {
        char[] cArray = new char[4096];
        int n = 0;
        int n2 = 0;
        while (-1 != (n2 = reader.read(cArray))) {
            writer.write(cArray, 0, n2);
            n += n2;
        }
        return n;
    }

    public static void copy(InputStream inputStream2, Writer writer) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2);
        CopyUtils.copy((Reader)inputStreamReader, writer);
    }

    public static void copy(InputStream inputStream2, Writer writer, String string) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, string);
        CopyUtils.copy((Reader)inputStreamReader, writer);
    }

    public static void copy(Reader reader, OutputStream outputStream2) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream2);
        CopyUtils.copy(reader, (Writer)outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void copy(String string, OutputStream outputStream2) throws IOException {
        StringReader stringReader = new StringReader(string);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream2);
        CopyUtils.copy((Reader)stringReader, (Writer)outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void copy(String string, Writer writer) throws IOException {
        writer.write(string);
    }
}

