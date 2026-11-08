/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class XPMFile {
    private byte[] bytes;
    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;
    private static final int NUMBER_OF_COLORS = 2;
    private static final int CHARACTERS_PER_PIXEL = 3;
    private static int[] format = new int[4];

    private XPMFile() {
    }

    public static XPMFile load(String string) throws IOException {
        return XPMFile.load(new FileInputStream(new File(string)));
    }

    public static XPMFile load(InputStream inputStream2) {
        XPMFile xPMFile = new XPMFile();
        xPMFile.readImage(inputStream2);
        return xPMFile;
    }

    public int getHeight() {
        return format[1];
    }

    public int getWidth() {
        return format[0];
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    private void readImage(InputStream inputStream2) {
        try {
            int n;
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream2));
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            format = XPMFile.parseFormat(XPMFile.nextLineOfInterest(lineNumberReader));
            for (n = 0; n < format[2]; ++n) {
                Object[] objectArray = XPMFile.parseColor(XPMFile.nextLineOfInterest(lineNumberReader));
                hashMap.put((String)objectArray[0], (Integer)objectArray[1]);
            }
            this.bytes = new byte[format[0] * format[1] * 4];
            for (n = 0; n < format[1]; ++n) {
                this.parseImageLine(XPMFile.nextLineOfInterest(lineNumberReader), format, hashMap, n);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Unable to parse XPM File");
        }
    }

    private static String nextLineOfInterest(LineNumberReader lineNumberReader) throws IOException {
        String string;
        while (!(string = lineNumberReader.readLine()).startsWith("\"")) {
        }
        return string.substring(1, string.lastIndexOf(34));
    }

    private static int[] parseFormat(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        return new int[]{Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())};
    }

    private static Object[] parseColor(String string) {
        String string2 = string.substring(0, format[3]);
        String string3 = string.substring(format[3] + 4);
        return new Object[]{string2, Integer.parseInt(string3, 16)};
    }

    private void parseImageLine(String string, int[] nArray, HashMap<String, Integer> hashMap, int n) {
        int n2 = n * 4 * nArray[0];
        for (int i = 0; i < nArray[0]; ++i) {
            String string2 = string.substring(i * nArray[3], i * nArray[3] + nArray[3]);
            int n3 = hashMap.get(string2);
            this.bytes[n2 + i * 4] = (byte)((n3 & 0xFF0000) >> 16);
            this.bytes[n2 + (i * 4 + 1)] = (byte)((n3 & 0xFF00) >> 8);
            this.bytes[n2 + (i * 4 + 2)] = (byte)((n3 & 0xFF) >> 0);
            this.bytes[n2 + (i * 4 + 3)] = -1;
        }
    }

    public static void main(String[] stringArray) {
        if (stringArray.length != 1) {
            System.out.println("usage:\nXPMFile <file>");
        }
        try {
            String string = stringArray[0].substring(0, stringArray[0].indexOf(".")) + ".raw";
            XPMFile xPMFile = XPMFile.load(stringArray[0]);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(string)));
            bufferedOutputStream.write(xPMFile.getBytes());
            bufferedOutputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

