/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import org.jspecify.annotations.Nullable;
import org.lwjgl.Version;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.SharedLibraryLoader;

public class Library {
    public static final String JNI_LIBRARY_NAME = Configuration.LIBRARY_NAME.get(Platform.mapLibraryNameBundled("lwjgl"));
    static final String JAVA_LIBRARY_PATH = "java.library.path";
    private static final Pattern PATH_SEPARATOR = Pattern.compile(File.pathSeparator);
    private static final Pattern NATIVES_JAR = Pattern.compile("/[\\w-]+?-natives-\\w+.jar!/");

    private Library() {
    }

    public static void initialize() {
    }

    public static void loadSystem(String string, String string2) throws UnsatisfiedLinkError {
        Library.loadSystem(System::load, System::loadLibrary, Library.class, string, string2);
    }

    public static void loadSystem(Consumer<String> consumer, Consumer<String> consumer2, Class<?> clazz, String string, String string2) throws UnsatisfiedLinkError {
        Object object;
        boolean bl;
        String string3;
        block30: {
            if (Checks.DEBUG) {
                APIUtil.DEBUG_STREAM.print("[LWJGL] Loading JNI library: " + string2 + "\n\tModule: " + string + "\n");
            }
            if (Paths.get(string2, new String[0]).isAbsolute()) {
                consumer.accept(string2);
                APIUtil.apiLogMore("Success");
                return;
            }
            string3 = Platform.get().mapLibraryName(string2);
            URL uRL = Library.findResource(clazz, string, string3, bl = string2.contains("lwjgl"));
            if (uRL == null) {
                if (Library.loadSystemFromLibraryPath(consumer, clazz, string, string3, bl)) {
                    return;
                }
            } else {
                boolean bl2 = Configuration.DEBUG_LOADER.get(false);
                try {
                    if (!Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(false).booleanValue() && (object = Library.getRegularFilePath(uRL)) != null) {
                        consumer.accept((String)object);
                        APIUtil.apiLogMore("Loaded from classpath: " + (String)object);
                        return;
                    }
                    if (bl2) {
                        APIUtil.apiLogMore("Using SharedLibraryLoader...");
                    }
                    object = SharedLibraryLoader.load(string2, string3, uRL, consumer);
                    Throwable throwable = null;
                    try {
                        if (Library.loadSystemFromLibraryPath(consumer, clazz, string, string3, bl)) {
                            return;
                        }
                    }
                    catch (Throwable throwable2) {
                        throwable = throwable2;
                        throw throwable2;
                    }
                    finally {
                        if (object != null) {
                            if (throwable != null) {
                                try {
                                    ((AbstractInterruptibleChannel)object).close();
                                }
                                catch (Throwable throwable3) {
                                    throwable.addSuppressed(throwable3);
                                }
                            } else {
                                ((AbstractInterruptibleChannel)object).close();
                            }
                        }
                    }
                }
                catch (Exception exception) {
                    if (!bl2) break block30;
                    exception.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        String string4 = System.getProperty(JAVA_LIBRARY_PATH);
        if (bl && string4 != null && Library.loadSystem(consumer, clazz, string, Library.getBundledPath(string, string3), false, JAVA_LIBRARY_PATH, string4)) {
            return;
        }
        try {
            consumer2.accept(string2);
            Object object2 = object = string4 == null ? null : Library.findFile(string4, string, string3, bl);
            if (object != null) {
                APIUtil.apiLogMore(String.format("Loaded from %s: %s", JAVA_LIBRARY_PATH, object));
                if (bl) {
                    Library.checkHash(clazz, (Path)object, string, string3);
                }
            } else {
                APIUtil.apiLogMore("Loaded from a ClassLoader provided path.");
            }
            return;
        }
        catch (Throwable throwable) {
            APIUtil.apiLogMore(string3 + " not found in " + JAVA_LIBRARY_PATH);
            Library.detectPlatformMismatch(clazz, string);
            Library.printError(true);
            throw new UnsatisfiedLinkError("Failed to locate library: " + string3);
        }
    }

    private static boolean loadSystemFromLibraryPath(Consumer<String> consumer, Class<?> clazz, String string, String string2, boolean bl) {
        String string3 = Configuration.LIBRARY_PATH.get();
        return string3 != null && Library.loadSystem(consumer, clazz, string, string2, bl, Configuration.LIBRARY_PATH.getProperty(), string3);
    }

    private static boolean loadSystem(Consumer<String> consumer, Class<?> clazz, String string, String string2, boolean bl, String string3, String string4) {
        Path path = Library.findFile(string4, string, string2, bl);
        if (path == null) {
            APIUtil.apiLogMore(string2 + " not found in " + string3 + "=" + string4);
            return false;
        }
        consumer.accept(path.toAbsolutePath().toString());
        APIUtil.apiLogMore("Loaded from " + string3 + ": " + path);
        if (bl) {
            Library.checkHash(clazz, path, string, string2);
        }
        return true;
    }

    public static SharedLibrary loadNative(String string, String string2) {
        return Library.loadNative(Library.class, string, string2);
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, String string2) {
        return Library.loadNative(clazz, string, string2, false);
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, String string2, boolean bl) {
        return Library.loadNative(clazz, string, string2, bl, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SharedLibrary loadNative(Class<?> clazz, String string, String string2, boolean bl, boolean bl2) {
        String string3;
        Object object;
        SharedLibrary sharedLibrary;
        String string4;
        block31: {
            if (Checks.DEBUG) {
                APIUtil.DEBUG_STREAM.print("[LWJGL] Loading library: " + string2 + "\n\tModule: " + string + "\n");
            }
            if (Paths.get(string2, new String[0]).isAbsolute()) {
                SharedLibrary sharedLibrary3 = APIUtil.apiCreateLibrary(string2);
                APIUtil.apiLogMore("Success");
                return sharedLibrary3;
            }
            string4 = Platform.get().mapLibraryName(string2);
            URL uRL = Library.findResource(clazz, string, string4, bl);
            if (uRL == null) {
                sharedLibrary = Library.loadNativeFromLibraryPath(clazz, string, string4, bl);
                if (sharedLibrary != null) {
                    return sharedLibrary;
                }
            } else {
                boolean bl3 = Configuration.DEBUG_LOADER.get(false);
                try {
                    if (!Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(false).booleanValue() && (object = Library.getRegularFilePath(uRL)) != null) {
                        SharedLibrary sharedLibrary4 = APIUtil.apiCreateLibrary((String)object);
                        APIUtil.apiLogMore("Loaded from classpath: " + (String)object);
                        return sharedLibrary4;
                    }
                    if (bl3) {
                        APIUtil.apiLogMore("Using SharedLibraryLoader...");
                    }
                    object = SharedLibraryLoader.load(string2, string4, uRL, null);
                    Throwable throwable = null;
                    try {
                        sharedLibrary = Library.loadNativeFromLibraryPath(clazz, string, string4, bl);
                        if (sharedLibrary != null) {
                            SharedLibrary sharedLibrary2 = sharedLibrary;
                            return sharedLibrary2;
                        }
                    }
                    catch (Throwable throwable4) {
                        throwable = throwable4;
                        throw throwable4;
                    }
                    finally {
                        if (object != null) {
                            if (throwable != null) {
                                try {
                                    ((AbstractInterruptibleChannel)object).close();
                                }
                                catch (Throwable throwable2) {
                                    throwable.addSuppressed(throwable2);
                                }
                            } else {
                                ((AbstractInterruptibleChannel)object).close();
                            }
                        }
                    }
                }
                catch (Exception exception) {
                    if (!bl3) break block31;
                    exception.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        if (!bl && (sharedLibrary = Library.loadNativeFromSystem(string4)) != null) {
            return sharedLibrary;
        }
        if (Configuration.EMULATE_SYSTEM_LOADLIBRARY.get(false).booleanValue()) {
            try {
                Method method = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                method.setAccessible(true);
                object = (String)method.invoke(clazz.getClassLoader(), string2);
                if (object != null) {
                    sharedLibrary = APIUtil.apiCreateLibrary((String)object);
                    APIUtil.apiLogMore("Loaded from ClassLoader provided path: " + (String)object);
                    return sharedLibrary;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if ((string3 = System.getProperty(JAVA_LIBRARY_PATH)) != null && (sharedLibrary = Library.loadNative(clazz, string, string4, bl, JAVA_LIBRARY_PATH, string3)) != null) {
            return sharedLibrary;
        }
        if (bl && (sharedLibrary = Library.loadNativeFromSystem(string4)) != null) {
            return sharedLibrary;
        }
        if (!bl2) throw new UnsatisfiedLinkError("Failed to locate library: " + string4);
        Library.detectPlatformMismatch(clazz, string);
        Library.printError(bl);
        throw new UnsatisfiedLinkError("Failed to locate library: " + string4);
    }

    private static @Nullable SharedLibrary loadNativeFromSystem(String string) {
        SharedLibrary sharedLibrary;
        try {
            sharedLibrary = APIUtil.apiCreateLibrary(string);
            String string2 = sharedLibrary.getPath();
            APIUtil.apiLogMore(string2 == null ? "Loaded from system paths" : "Loaded from system paths: " + string2);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            sharedLibrary = null;
            APIUtil.apiLogMore(string + " not found in system paths");
        }
        return sharedLibrary;
    }

    private static @Nullable SharedLibrary loadNativeFromLibraryPath(Class<?> clazz, String string, String string2, boolean bl) {
        String string3 = Configuration.LIBRARY_PATH.get();
        if (string3 == null) {
            return null;
        }
        return Library.loadNative(clazz, string, string2, bl, Configuration.LIBRARY_PATH.getProperty(), string3);
    }

    private static @Nullable SharedLibrary loadNative(Class<?> clazz, String string, String string2, boolean bl, String string3, String string4) {
        Path path = Library.findFile(string4, string, string2, bl);
        if (path == null) {
            APIUtil.apiLogMore(string2 + " not found in " + string3 + "=" + string4);
            return null;
        }
        SharedLibrary sharedLibrary = APIUtil.apiCreateLibrary(path.toAbsolutePath().toString());
        APIUtil.apiLogMore("Loaded from " + string3 + ": " + path);
        if (bl) {
            Library.checkHash(clazz, path, string, string2);
        }
        return sharedLibrary;
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, @Nullable Configuration<String> configuration, String ... stringArray) {
        return Library.loadNative(clazz, string, configuration, null, stringArray);
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, @Nullable Configuration<String> configuration, @Nullable Supplier<SharedLibrary> supplier, String ... stringArray) {
        String string2;
        if (stringArray.length == 0) {
            throw new IllegalArgumentException("No default names specified.");
        }
        if (configuration != null && (string2 = configuration.get()) != null) {
            return Library.loadNative(clazz, string, string2);
        }
        if (supplier == null && stringArray.length <= 1) {
            return Library.loadNative(clazz, string, stringArray[0]);
        }
        try {
            return Library.loadNative(clazz, string, stringArray[0], false, false);
        }
        catch (Throwable throwable) {
            for (int i = 1; i < stringArray.length; ++i) {
                try {
                    return Library.loadNative(clazz, string, stringArray[i], false, supplier == null && i == stringArray.length - 1);
                }
                catch (Throwable throwable2) {
                    continue;
                }
            }
            if (supplier != null) {
                return supplier.get();
            }
            throw throwable;
        }
    }

    private static String getBundledPath(String string, String string2) {
        return Platform.mapLibraryPathBundled(string.replace('.', '/') + "/" + string2);
    }

    static @Nullable URL findResource(Class<?> clazz, String string, String string2, boolean bl) {
        String string3;
        URL uRL = null;
        if (bl && !(string3 = Library.getBundledPath(string, string2)).equals(string2)) {
            uRL = clazz.getClassLoader().getResource(string3);
        }
        return uRL == null ? clazz.getClassLoader().getResource(string2) : uRL;
    }

    static @Nullable String getRegularFilePath(URL uRL) {
        if (uRL.getProtocol().equals("file")) {
            try {
                Path path = Paths.get(uRL.toURI());
                if (path.isAbsolute() && Files.isReadable(path)) {
                    return path.toString();
                }
            }
            catch (URISyntaxException uRISyntaxException) {
                // empty catch block
            }
        }
        return null;
    }

    static @Nullable Path findFile(String string, String string2, String string3, boolean bl) {
        Path path;
        String string4;
        if (bl && !(string4 = Library.getBundledPath(string2, string3)).equals(string3) && (path = Library.findFile(string, string4)) != null) {
            return path;
        }
        return Library.findFile(string, string3);
    }

    private static @Nullable Path findFile(String string, String string2) {
        for (String string3 : PATH_SEPARATOR.split(string)) {
            Path path = Paths.get(string3, string2);
            if (!Files.isReadable(path)) continue;
            return path;
        }
        return null;
    }

    private static void detectPlatformMismatch(Class<?> clazz, String string) {
        if (!string.startsWith("org.lwjgl")) {
            return;
        }
        String string2 = string.equals("org.lwjgl") ? "lwjgl" : "lwjgl-" + string.substring("org.lwjgl.".length());
        ArrayList<String> arrayList = new ArrayList<String>(8);
        try {
            Enumeration<URL> enumeration = clazz.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (enumeration.hasMoreElements()) {
                InputStream inputStream2 = enumeration.nextElement().openStream();
                Throwable throwable = null;
                try {
                    String string3;
                    Manifest manifest = new Manifest(inputStream2);
                    Attributes attributes = manifest.getMainAttributes();
                    if (!string2.equals(attributes.getValue("Implementation-Title")) || (string3 = attributes.getValue("LWJGL-Platform")) == null) continue;
                    arrayList.add(string3);
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally {
                    if (inputStream2 == null) continue;
                    if (throwable != null) {
                        try {
                            inputStream2.close();
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                        continue;
                    }
                    inputStream2.close();
                }
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (!arrayList.isEmpty()) {
            APIUtil.DEBUG_STREAM.print("[LWJGL] Platform/architecture mismatch detected for module: " + string + "\n\tJVM platform:\t\t" + Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\t\t" + System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n\tPlatform" + (arrayList.size() == 1 ? "" : "s") + " available on classpath:\n\t\t" + String.join((CharSequence)"\n\t\t", arrayList) + "\n");
        }
    }

    private static void printError(boolean bl) {
        Library.printError("[LWJGL] Failed to load a library. Possible solutions:\n" + (bl ? "\ta) Add the directory that contains the shared library to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the shared library to the classpath." : "\ta) Install the library or the driver that provides the library.\n\tb) Ensure that the library is accessible from the system library paths."));
    }

    static void printError(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append("\n");
        if (!Checks.DEBUG) {
            stringBuilder.append("[LWJGL] Enable debug mode with -Dorg.lwjgl.util.Debug=true for better diagnostics.\n");
            if (!Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                stringBuilder.append("[LWJGL] Enable the SharedLibraryLoader debug mode with -Dorg.lwjgl.util.DebugLoader=true for better diagnostics.\n");
            }
        }
        APIUtil.DEBUG_STREAM.print(stringBuilder);
    }

    private static void checkHash(Class<?> clazz, Path path, String string, String string2) {
        block7: {
            if (Configuration.DISABLE_HASH_CHECKS.get(!Checks.CHECKS).booleanValue()) {
                return;
            }
            try {
                byte[] byArray;
                Object object;
                Object object2 = null;
                Object object3 = null;
                Enumeration<URL> enumeration = clazz.getClassLoader().getResources("META-INF/" + Library.getBundledPath(string, string2) + ".sha1");
                while (enumeration.hasMoreElements()) {
                    object = enumeration.nextElement();
                    if (NATIVES_JAR.matcher(((URL)object).toExternalForm()).find()) {
                        object3 = object;
                        continue;
                    }
                    object2 = object;
                }
                if (object2 == null) {
                    return;
                }
                object = Library.getSHA1(object2);
                byte[] byArray2 = byArray = Checks.DEBUG || object3 == null ? Library.getSHA1(path) : Library.getSHA1(object3);
                if (!Arrays.equals((byte[])object, byArray)) {
                    APIUtil.DEBUG_STREAM.println("[LWJGL] [ERROR] Incompatible Java and native library versions detected.\nPossible reasons:\n\ta) -Djava.library.path is set to a folder containing shared libraries of an older LWJGL version.\n\tb) The classpath contains jar files of an older LWJGL version.\nPossible solutions:\n\ta) Make sure to not set -Djava.library.path (it is not needed for developing with LWJGL 3) or make\n\t   sure the folder it points to contains the shared libraries of the correct LWJGL version.\n\tb) Check the classpath and make sure to only have jar files of the same LWJGL version in it.");
                }
            }
            catch (Throwable throwable) {
                if (!Checks.DEBUG) break block7;
                APIUtil.apiLog("Failed to verify native library.");
                throwable.printStackTrace();
            }
        }
    }

    private static byte[] getSHA1(URL uRL) throws IOException {
        byte[] byArray = new byte[20];
        try (InputStream inputStream2 = uRL.openStream();){
            for (int i = 0; i < 20; ++i) {
                byArray[i] = (byte)(Character.digit(inputStream2.read(), 16) << 4 | Character.digit(inputStream2.read(), 16));
            }
        }
        return byArray;
    }

    private static byte[] getSHA1(Path path) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        try (InputStream inputStream2 = Files.newInputStream(path, new OpenOption[0]);){
            int n;
            byte[] byArray = new byte[8192];
            while ((n = inputStream2.read(byArray)) != -1) {
                messageDigest.update(byArray, 0, n);
            }
        }
        return messageDigest.digest();
    }

    static {
        if (Checks.DEBUG) {
            APIUtil.DEBUG_STREAM.print("[LWJGL] Version: " + Version.getVersion() + "\n\t OS: " + System.getProperty("os.name") + " v" + System.getProperty("os.version") + "\n\tJRE: " + Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\tJVM: " + System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n");
        }
        Library.loadSystem("org.lwjgl", JNI_LIBRARY_NAME);
    }
}

