/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.File;
import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import x.oc75d51ec7eb;

public class oc8ccd9c3f55 {
    public static final String \u02c0 = "miau";
    private static final String t = "Roven";
    public static int \u0394;

    private oc8ccd9c3f55() {
    }

    public static File \u0212(File file) {
        return new File(file, "miau");
    }

    public static File \u03b6(File file) {
        return new File(file, "Roven");
    }

    public static File \u057a(File file) {
        File file2;
        block12: {
            File file3;
            block13: {
                file3 = oc8ccd9c3f55.\u0212(file);
                int n = oc75d51ec7eb.\u03e9;
                file2 = file3;
                if (n != 0) break block12;
                if (file2.isDirectory()) break block13;
                file2 = file3;
                if (n != 0) break block12;
                if (file2.mkdirs()) break block13;
                file2 = file3;
                if (n != 0) break block12;
                if (file2.isDirectory()) break block13;
                throw new IllegalStateException("Unable to create Miau data directory: " + String.valueOf(file3));
            }
            file2 = file3;
        }
        return file2;
    }

    public static int \u0496(File file2, File file3) throws IOException {
        int n;
        block15: {
            File file4;
            int n2;
            block12: {
                block13: {
                    n2 = oc75d51ec7eb.\u03e9;
                    file4 = file2;
                    if (n2 != 0) break block12;
                    if (file4.isDirectory()) break block13;
                    return 0;
                }
                oc8ccd9c3f55.w(file3);
                file4 = file2;
            }
            File[] fileArray = file4.listFiles((file, string) -> string.toLowerCase(Locale.ROOT).endsWith(".json"));
            if (fileArray == null) {
                return 0;
            }
            int n3 = 0;
            File[] fileArray2 = fileArray;
            int n4 = fileArray2.length;
            int n5 = 0;
            while (n5 < n4) {
                block14: {
                    block16: {
                        File file5 = fileArray2[n5];
                        File file6 = new File(file3, file5.getName());
                        if (n2 != 0) break block14;
                        n = oc8ccd9c3f55.\u03e1(file5, file6) ? 1 : 0;
                        if (n2 != 0) break block15;
                        if (n == 0) break block16;
                        ++n3;
                    }
                    ++n5;
                }
                if (n2 == 0) continue;
            }
            n = n3;
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean \u03e1(File file, File file2) throws IOException {
        File file4;
        int n = oc75d51ec7eb.\u03e9;
        boolean bl = file.isFile();
        if (n != 0) return bl;
        if (!bl) return false;
        File file3 = file2;
        if (n == 0) {
            if (file3.exists()) {
                return false;
            }
            file3 = file2.getParentFile();
        }
        File file5 = file4 = file3;
        if (n == 0) {
            if (file5 != null) {
                oc8ccd9c3f55.w(file4);
            }
            file5 = new File(file4, file2.getName() + ".migration.tmp");
        }
        File file6 = file5;
        CopyOption[] copyOptionArray = new CopyOption[0x72B4DF4B ^ 0x72B4DF49];
        copyOptionArray[0] = StandardCopyOption.REPLACE_EXISTING;
        copyOptionArray[1] = StandardCopyOption.COPY_ATTRIBUTES;
        Files.copy(file.toPath(), file6.toPath(), copyOptionArray);
        try {
            try {
                Files.move(file6.toPath(), file2.toPath(), StandardCopyOption.ATOMIC_MOVE);
                return true;
            }
            catch (AtomicMoveNotSupportedException atomicMoveNotSupportedException) {
                Files.move(file6.toPath(), file2.toPath(), new CopyOption[0]);
                return true;
            }
        }
        finally {
            Files.deleteIfExists(file6.toPath());
        }
    }

    private static void w(File file) throws IOException {
        block12: {
            File file2;
            block13: {
                int n;
                block11: {
                    n = oc75d51ec7eb.\u03e9;
                    file2 = file;
                    if (n != 0) break block11;
                    if (file2.isDirectory()) break block12;
                    file2 = file;
                }
                if (n != 0) break block13;
                if (file2.mkdirs()) break block12;
                file2 = file;
            }
            if (!file2.isDirectory()) {
                throw new IOException("Unable to create directory: " + String.valueOf(file));
            }
        }
    }
}

