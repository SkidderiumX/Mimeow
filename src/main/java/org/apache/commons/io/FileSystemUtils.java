/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOExceptionWithCause;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.ThreadMonitor;

public class FileSystemUtils {
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int INIT_PROBLEM = -1;
    private static final int OTHER = 0;
    private static final int WINDOWS = 1;
    private static final int UNIX = 2;
    private static final int POSIX_UNIX = 3;
    private static final int OS;
    private static final String DF;

    @Deprecated
    public static long freeSpace(String string) throws IOException {
        return INSTANCE.freeSpaceOS(string, OS, false, -1L);
    }

    public static long freeSpaceKb(String string) throws IOException {
        return FileSystemUtils.freeSpaceKb(string, -1L);
    }

    public static long freeSpaceKb(String string, long l) throws IOException {
        return INSTANCE.freeSpaceOS(string, OS, true, l);
    }

    public static long freeSpaceKb() throws IOException {
        return FileSystemUtils.freeSpaceKb(-1L);
    }

    public static long freeSpaceKb(long l) throws IOException {
        return FileSystemUtils.freeSpaceKb(new File(".").getAbsolutePath(), l);
    }

    long freeSpaceOS(String string, int n, boolean bl, long l) throws IOException {
        if (string == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        switch (n) {
            case 1: {
                return bl ? this.freeSpaceWindows(string, l) / 1024L : this.freeSpaceWindows(string, l);
            }
            case 2: {
                return this.freeSpaceUnix(string, bl, false, l);
            }
            case 3: {
                return this.freeSpaceUnix(string, bl, true, l);
            }
            case 0: {
                throw new IllegalStateException("Unsupported operating system");
            }
        }
        throw new IllegalStateException("Exception caught when determining operating system");
    }

    long freeSpaceWindows(String string, long l) throws IOException {
        if ((string = FilenameUtils.normalize(string, false)).length() > 0 && string.charAt(0) != '\"') {
            string = "\"" + string + "\"";
        }
        String[] stringArray = new String[]{"cmd.exe", "/C", "dir /a /-c " + string};
        List<String> list = this.performCommand(stringArray, Integer.MAX_VALUE, l);
        for (int i = list.size() - 1; i >= 0; --i) {
            String string2 = list.get(i);
            if (string2.length() <= 0) continue;
            return this.parseDir(string2, string);
        }
        throw new IOException("Command line 'dir /-c' did not return any info for path '" + string + "'");
    }

    long parseDir(String string, String string2) throws IOException {
        char c;
        int n;
        int n2 = 0;
        int n3 = 0;
        for (n = string.length() - 1; n >= 0; --n) {
            c = string.charAt(n);
            if (!Character.isDigit(c)) continue;
            n3 = n + 1;
            break;
        }
        while (n >= 0) {
            c = string.charAt(n);
            if (!Character.isDigit(c) && c != ',' && c != '.') {
                n2 = n + 1;
                break;
            }
            --n;
        }
        if (n < 0) {
            throw new IOException("Command line 'dir /-c' did not return valid info for path '" + string2 + "'");
        }
        StringBuilder stringBuilder = new StringBuilder(string.substring(n2, n3));
        for (int i = 0; i < stringBuilder.length(); ++i) {
            if (stringBuilder.charAt(i) != ',' && stringBuilder.charAt(i) != '.') continue;
            stringBuilder.deleteCharAt(i--);
        }
        return this.parseBytes(stringBuilder.toString(), string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    long freeSpaceUnix(String string, boolean bl, boolean bl2, long l) throws IOException {
        String string2;
        String[] stringArray;
        if (string.length() == 0) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String string3 = "-";
        if (bl) {
            string3 = string3 + "k";
        }
        if (bl2) {
            string3 = string3 + "P";
        }
        if (string3.length() > 1) {
            String[] stringArray2 = new String[3];
            stringArray2[0] = DF;
            stringArray2[1] = string3;
            stringArray = stringArray2;
            stringArray2[2] = string;
        } else {
            String[] stringArray3 = new String[2];
            stringArray3[0] = DF;
            stringArray = stringArray3;
            stringArray3[1] = string;
        }
        String[] stringArray4 = stringArray;
        List<String> list = this.performCommand(stringArray4, 3, l);
        if (list.size() < 2) {
            throw new IOException("Command line '" + DF + "' did not return info as expected " + "for path '" + string + "'- response was " + list);
        }
        String string4 = list.get(1);
        StringTokenizer stringTokenizer = new StringTokenizer(string4, " ");
        if (stringTokenizer.countTokens() < 4) {
            if (stringTokenizer.countTokens() != 1 || list.size() < 3) throw new IOException("Command line '" + DF + "' did not return data as expected " + "for path '" + string + "'- check path is valid");
            string2 = list.get(2);
            stringTokenizer = new StringTokenizer(string2, " ");
        } else {
            stringTokenizer.nextToken();
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        string2 = stringTokenizer.nextToken();
        return this.parseBytes(string2, string);
    }

    long parseBytes(String string, String string2) throws IOException {
        try {
            long l = Long.parseLong(string);
            if (l < 0L) {
                throw new IOException("Command line '" + DF + "' did not find free space in response " + "for path '" + string2 + "'- check path is valid");
            }
            return l;
        }
        catch (NumberFormatException numberFormatException) {
            throw new IOExceptionWithCause("Command line '" + DF + "' did not return numeric data as expected " + "for path '" + string2 + "'- check path is valid", numberFormatException);
        }
    }

    List<String> performCommand(String[] stringArray, int n, long l) throws IOException {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2 = new ArrayList<String>(20);
        Process process = null;
        InputStream inputStream2 = null;
        OutputStream outputStream2 = null;
        InputStream inputStream3 = null;
        BufferedReader bufferedReader = null;
        try {
            Thread thread2 = ThreadMonitor.start(l);
            process = this.openProcess(stringArray);
            inputStream2 = process.getInputStream();
            outputStream2 = process.getOutputStream();
            inputStream3 = process.getErrorStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
            String string = bufferedReader.readLine();
            while (string != null && arrayList2.size() < n) {
                string = string.toLowerCase(Locale.ENGLISH).trim();
                arrayList2.add(string);
                string = bufferedReader.readLine();
            }
            process.waitFor();
            ThreadMonitor.stop(thread2);
            if (process.exitValue() != 0) {
                throw new IOException("Command line returned OS error code '" + process.exitValue() + "' for command " + Arrays.asList(stringArray));
            }
            if (arrayList2.isEmpty()) {
                throw new IOException("Command line did not return any info for command " + Arrays.asList(stringArray));
            }
            arrayList = arrayList2;
        }
        catch (InterruptedException interruptedException) {
            try {
                throw new IOExceptionWithCause("Command line threw an InterruptedException for command " + Arrays.asList(stringArray) + " timeout=" + l, interruptedException);
            }
            catch (Throwable throwable) {
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly(outputStream2);
                IOUtils.closeQuietly(inputStream3);
                IOUtils.closeQuietly(bufferedReader);
                if (process != null) {
                    process.destroy();
                }
                throw throwable;
            }
        }
        IOUtils.closeQuietly(inputStream2);
        IOUtils.closeQuietly(outputStream2);
        IOUtils.closeQuietly(inputStream3);
        IOUtils.closeQuietly(bufferedReader);
        if (process != null) {
            process.destroy();
        }
        return arrayList;
    }

    Process openProcess(String[] stringArray) throws IOException {
        return Runtime.getRuntime().exec(stringArray);
    }

    static {
        int n = 0;
        String string = "df";
        try {
            String string2 = System.getProperty("os.name");
            if (string2 == null) {
                throw new IOException("os.name not found");
            }
            if ((string2 = string2.toLowerCase(Locale.ENGLISH)).indexOf("windows") != -1) {
                n = 1;
            } else if (string2.indexOf("linux") != -1 || string2.indexOf("mpe/ix") != -1 || string2.indexOf("freebsd") != -1 || string2.indexOf("irix") != -1 || string2.indexOf("digital unix") != -1 || string2.indexOf("unix") != -1 || string2.indexOf("mac os x") != -1) {
                n = 2;
            } else if (string2.indexOf("sun os") != -1 || string2.indexOf("sunos") != -1 || string2.indexOf("solaris") != -1) {
                n = 3;
                string = "/usr/xpg4/bin/df";
            } else {
                n = string2.indexOf("hp-ux") != -1 || string2.indexOf("aix") != -1 ? 3 : 0;
            }
        }
        catch (Exception exception) {
            n = -1;
        }
        OS = n;
        DF = string;
    }
}

