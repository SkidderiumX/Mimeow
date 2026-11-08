/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Callback;
import com.sun.jna.CallbackReference;
import com.sun.jna.CallbackThreadInitializer;
import com.sun.jna.FromNativeContext;
import com.sun.jna.FromNativeConverter;
import com.sun.jna.Function;
import com.sun.jna.FunctionMapper;
import com.sun.jna.IntegerType;
import com.sun.jna.Library;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.ToNativeContext;
import com.sun.jna.ToNativeConverter;
import com.sun.jna.TypeMapper;
import com.sun.jna.WString;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
public class Native {
    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }
    static /* synthetic */ Class class$com$sun$jna$Library;
    static /* synthetic */ Class class$com$sun$jna$Pointer;
    static /* synthetic */ Class class$java$lang$String;

    private static final String VERSION = "3.4.0";
    private static final String VERSION_NATIVE = "3.4.0";
    private static String nativeLibraryPath;
    private static Map typeMappers;
    private static Map alignments;
    private static Map options;
    private static Map libraries;
    private static final Callback.UncaughtExceptionHandler DEFAULT_HANDLER;
    private static Callback.UncaughtExceptionHandler callbackExceptionHandler;
    public static final int POINTER_SIZE;
    public static final int LONG_SIZE;
    public static final int WCHAR_SIZE;
    public static final int SIZE_T_SIZE;
    private static final int TYPE_VOIDP = 0;
    private static final int TYPE_LONG = 1;
    private static final int TYPE_WCHAR_T = 2;
    private static final int TYPE_SIZE_T = 3;
    private static final int THREAD_NOCHANGE = 0;
    private static final int THREAD_DETACH = -1;
    private static final int THREAD_LEAVE_ATTACHED = -2;
    private static final Object finalizer;
    private static final ThreadLocal lastError;
    private static Map registeredClasses;
    private static Map registeredLibraries;
    private static Object unloader;
    static final int CB_HAS_INITIALIZER = 1;
    private static final int CVT_UNSUPPORTED = -1;
    private static final int CVT_DEFAULT = 0;
    private static final int CVT_POINTER = 1;
    private static final int CVT_STRING = 2;
    private static final int CVT_STRUCTURE = 3;
    private static final int CVT_STRUCTURE_BYVAL = 4;
    private static final int CVT_BUFFER = 5;
    private static final int CVT_ARRAY_BYTE = 6;
    private static final int CVT_ARRAY_SHORT = 7;
    private static final int CVT_ARRAY_CHAR = 8;
    private static final int CVT_ARRAY_INT = 9;
    private static final int CVT_ARRAY_LONG = 10;
    private static final int CVT_ARRAY_FLOAT = 11;
    private static final int CVT_ARRAY_DOUBLE = 12;
    private static final int CVT_ARRAY_BOOLEAN = 13;
    private static final int CVT_BOOLEAN = 14;
    private static final int CVT_CALLBACK = 15;
    private static final int CVT_FLOAT = 16;
    private static final int CVT_NATIVE_MAPPED = 17;
    private static final int CVT_WSTRING = 18;
    private static final int CVT_INTEGER_TYPE = 19;
    private static final int CVT_POINTER_TYPE = 20;
    private static final int CVT_TYPE_MAPPER = 21;
    static /* synthetic */ Class class$java$lang$ClassLoader;
    static /* synthetic */ Class class$com$sun$jna$LastErrorException;
    static /* synthetic */ Class class$java$nio$Buffer;

    private static void dispose() {
        NativeLibrary.disposeAll();
        nativeLibraryPath = null;
    }

    private static boolean deleteNativeLibrary(String string) {
        File file = new File(string);
        if (file.delete()) {
            return true;
        }
        Native.markTemporaryFile(file);
        return false;
    }

    private Native() {
    }

    private static native void initIDs();

    public static synchronized native void setProtected(boolean var0);

    public static synchronized native boolean isProtected();

    public static synchronized native void setPreserveLastError(boolean var0);

    public static synchronized native boolean getPreserveLastError();

    public static long getWindowID(Window window) throws HeadlessException {
        return AWT.getWindowID(window);
    }

    public static long getComponentID(Component component) throws HeadlessException {
        return AWT.getComponentID(component);
    }

    public static Pointer getWindowPointer(Window window) throws HeadlessException {
        return new Pointer(AWT.getWindowID(window));
    }

    public static Pointer getComponentPointer(Component component) throws HeadlessException {
        return new Pointer(AWT.getComponentID(component));
    }

    static native long getWindowHandle0(Component var0);

    public static Pointer getDirectBufferPointer(Buffer buffer) {
        long l = Native._getDirectBufferPointer(buffer);
        return l == 0L ? null : new Pointer(l);
    }

    private static native long _getDirectBufferPointer(Buffer var0);

    public static String toString(byte[] byArray) {
        return Native.toString(byArray, System.getProperty("jna.encoding"));
    }

    public static String toString(byte[] byArray, String string) {
        int n;
        String string2 = null;
        if (string != null) {
            try {
                string2 = new String(byArray, string);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
        }
        if (string2 == null) {
            string2 = new String(byArray);
        }
        if ((n = string2.indexOf(0)) != -1) {
            string2 = string2.substring(0, n);
        }
        return string2;
    }

    public static String toString(char[] cArray) {
        String string = new String(cArray);
        int n = string.indexOf(0);
        if (n != -1) {
            string = string.substring(0, n);
        }
        return string;
    }

    public static Object loadLibrary(Class clazz) {
        return Native.loadLibrary(null, clazz);
    }

    public static Object loadLibrary(Class clazz, Map map) {
        return Native.loadLibrary(null, clazz, map);
    }

    public static Object loadLibrary(String string, Class clazz) {
        return Native.loadLibrary(string, clazz, Collections.EMPTY_MAP);
    }

    public static Object loadLibrary(String string, Class clazz, Map map) {
        Library.Handler handler = new Library.Handler(string, clazz, map);
        ClassLoader classLoader = clazz.getClassLoader();
        Library library = (Library)Proxy.newProxyInstance(classLoader, new Class[]{clazz}, (InvocationHandler)handler);
        Native.cacheOptions(clazz, map, library);
        return library;
    }

    private static void loadLibraryInstance(Class clazz) {
        if (clazz != null && !libraries.containsKey(clazz)) {
            try {
                Field[] fieldArray = clazz.getFields();
                for (int i = 0; i < fieldArray.length; ++i) {
                    Field field = fieldArray[i];
                    if (field.getType() != clazz || !Modifier.isStatic(field.getModifiers())) continue;
                    libraries.put(clazz, new WeakReference<Object>(field.get(null)));
                    break;
                }
            }
            catch (Exception exception) {
                throw new IllegalArgumentException("Could not access instance of " + clazz + " (" + exception + ")");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static Class findEnclosingLibraryClass(Class clazz) {
        Class clazz2;
        if (clazz == null) {
            return null;
        }
        Object object = libraries;
        synchronized (object) {
            if (options.containsKey(clazz)) {
                return clazz;
            }
        }
        if (Library.class.isAssignableFrom(clazz)) {
            return clazz;
        }
        if (Callback.class.isAssignableFrom(clazz)) {
            clazz = CallbackReference.findCallbackClass(clazz);
        }
        if ((clazz2 = Native.findEnclosingLibraryClass((Class)(object = clazz.getDeclaringClass()))) != null) {
            return clazz2;
        }
        return Native.findEnclosingLibraryClass(clazz.getSuperclass());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Map getLibraryOptions(Class clazz) {
        Map map = libraries;
        synchronized (map) {
            Class clazz2 = Native.findEnclosingLibraryClass(clazz);
            if (clazz2 != null) {
                Native.loadLibraryInstance(clazz2);
            } else {
                clazz2 = clazz;
            }
            if (!options.containsKey(clazz2)) {
                try {
                    Field field = clazz2.getField("OPTIONS");
                    field.setAccessible(true);
                    options.put(clazz2, field.get(null));
                }
                catch (NoSuchFieldException noSuchFieldException) {
                }
                catch (Exception exception) {
                    throw new IllegalArgumentException("OPTIONS must be a public field of type java.util.Map (" + exception + "): " + clazz2);
                }
            }
            return (Map)options.get(clazz2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static TypeMapper getTypeMapper(Class clazz) {
        Map map = libraries;
        synchronized (map) {
            Class clazz2 = Native.findEnclosingLibraryClass(clazz);
            if (clazz2 != null) {
                Native.loadLibraryInstance(clazz2);
            } else {
                clazz2 = clazz;
            }
            if (!typeMappers.containsKey(clazz2)) {
                try {
                    Field field = clazz2.getField("TYPE_MAPPER");
                    field.setAccessible(true);
                    typeMappers.put(clazz2, field.get(null));
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Map map2 = Native.getLibraryOptions(clazz);
                    if (map2 != null && map2.containsKey("type-mapper")) {
                        typeMappers.put(clazz2, map2.get("type-mapper"));
                    }
                }
                catch (Exception exception) {
                    throw new IllegalArgumentException("TYPE_MAPPER must be a public field of type " + TypeMapper.class.getName() + " (" + exception + "): " + clazz2);
                }
            }
            return (TypeMapper)typeMappers.get(clazz2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int getStructureAlignment(Class clazz) {
        Map map = libraries;
        synchronized (map) {
            Object object;
            Class clazz2 = Native.findEnclosingLibraryClass(clazz);
            if (clazz2 != null) {
                Native.loadLibraryInstance(clazz2);
            } else {
                clazz2 = clazz;
            }
            if (!alignments.containsKey(clazz2)) {
                try {
                    object = clazz2.getField("STRUCTURE_ALIGNMENT");
                    ((Field)object).setAccessible(true);
                    alignments.put(clazz2, ((Field)object).get(null));
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Map map2 = Native.getLibraryOptions(clazz2);
                    if (map2 != null && map2.containsKey("structure-alignment")) {
                        alignments.put(clazz2, map2.get("structure-alignment"));
                    }
                }
                catch (Exception exception) {
                    throw new IllegalArgumentException("STRUCTURE_ALIGNMENT must be a public field of type int (" + exception + "): " + clazz2);
                }
            }
            int n = (object = (Integer)alignments.get(clazz2)) != null ? (Integer)object : 0;
            return n;
        }
    }

    static byte[] getBytes(String string) {
        try {
            return Native.getBytes(string, System.getProperty("jna.encoding"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string.getBytes();
        }
    }

    static byte[] getBytes(String string, String string2) throws UnsupportedEncodingException {
        if (string2 != null) {
            return string.getBytes(string2);
        }
        return string.getBytes();
    }

    public static byte[] toByteArray(String string) {
        byte[] byArray = Native.getBytes(string);
        byte[] byArray2 = new byte[byArray.length + 1];
        System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
        return byArray2;
    }

    public static byte[] toByteArray(String string, String string2) throws UnsupportedEncodingException {
        byte[] byArray = Native.getBytes(string, string2);
        byte[] byArray2 = new byte[byArray.length + 1];
        System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
        return byArray2;
    }

    public static char[] toCharArray(String string) {
        char[] cArray = string.toCharArray();
        char[] cArray2 = new char[cArray.length + 1];
        System.arraycopy(cArray, 0, cArray2, 0, cArray.length);
        return cArray2;
    }

    static String getNativeLibraryResourcePath(int n, String string, String string2) {
        String string3;
        if ("powerpc".equals(string = string.toLowerCase())) {
            string = "ppc";
        } else if ("powerpc64".equals(string)) {
            string = "ppc64";
        }
        switch (n) {
            case 2: {
                if ("i386".equals(string)) {
                    string = "x86";
                }
                string3 = "win32-" + string;
                break;
            }
            case 6: {
                string3 = "w32ce-" + string;
                break;
            }
            case 0: {
                string3 = "darwin";
                break;
            }
            case 1: {
                if ("x86".equals(string)) {
                    string = "i386";
                } else if ("x86_64".equals(string)) {
                    string = "amd64";
                }
                string3 = "linux-" + string;
                break;
            }
            case 3: {
                string3 = "sunos-" + string;
                break;
            }
            default: {
                int n2;
                string3 = string2.toLowerCase();
                if ("x86".equals(string)) {
                    string = "i386";
                }
                if ("x86_64".equals(string)) {
                    string = "amd64";
                }
                if ((n2 = string3.indexOf(" ")) != -1) {
                    string3 = string3.substring(0, n2);
                }
                string3 = string3 + "-" + string;
            }
        }
        return "/com/sun/jna/" + string3;
    }

    private static void loadNativeLibrary() {
        block13: {
            Native.removeTemporaryFiles();
            String string = System.getProperty("jna.boot.library.name", "jnidispatch");
            String string2 = System.getProperty("jna.boot.library.path");
            if (string2 != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(string2, File.pathSeparator);
                while (stringTokenizer.hasMoreTokens()) {
                    String string3;
                    String string4;
                    String string5 = stringTokenizer.nextToken();
                    File file = new File(new File(string5), System.mapLibraryName(string));
                    String string6 = file.getAbsolutePath();
                    if (file.exists()) {
                        try {
                            System.load(string6);
                            nativeLibraryPath = string6;
                            return;
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                            // empty catch block
                        }
                    }
                    if (!Platform.isMac()) continue;
                    if (string6.endsWith("dylib")) {
                        string4 = "dylib";
                        string3 = "jnilib";
                    } else {
                        string4 = "jnilib";
                        string3 = "dylib";
                    }
                    if (!new File(string6 = string6.substring(0, string6.lastIndexOf(string4)) + string3).exists()) continue;
                    try {
                        System.load(string6);
                        nativeLibraryPath = string6;
                        return;
                    }
                    catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                        System.err.println("File found at " + string6 + " but not loadable: " + unsatisfiedLinkError.getMessage());
                    }
                }
            }
            try {
                if (!Boolean.getBoolean("jna.nosys")) {
                    System.loadLibrary(string);
                    return;
                }
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                if (!Boolean.getBoolean("jna.nounpack")) break block13;
                throw unsatisfiedLinkError;
            }
        }
        if (!Boolean.getBoolean("jna.nounpack")) {
            Native.loadNativeLibraryFromJar();
            return;
        }
        throw new UnsatisfiedLinkError("Native jnidispatch library not found");
    }

    private static void loadNativeLibraryFromJar() {
        String string = System.mapLibraryName("jnidispatch");
        String string2 = System.getProperty("os.arch");
        String string3 = System.getProperty("os.name");
        String string4 = Native.getNativeLibraryResourcePath(Platform.getOSType(), string2, string3) + "/" + string;
        URL uRL = Native.class.getResource(string4);
        boolean bl = false;
        if (uRL == null && Platform.isMac() && string4.endsWith(".dylib")) {
            string4 = string4.substring(0, string4.lastIndexOf(".dylib")) + ".jnilib";
            uRL = Native.class.getResource(string4);
        }
        if (uRL == null) {
            throw new UnsatisfiedLinkError("jnidispatch (" + string4 + ") not found in resource path");
        }
        File file = null;
        if (uRL.getProtocol().toLowerCase().equals("file")) {
            try {
                file = new File(new URI(uRL.toString()));
            }
            catch (URISyntaxException uRISyntaxException) {
                file = new File(uRL.getPath());
            }
            if (!file.exists()) {
                throw new Error("File URL " + uRL + " could not be properly decoded");
            }
        } else {
            InputStream inputStream2 = Native.class.getResourceAsStream(string4);
            if (inputStream2 == null) {
                throw new Error("Can't obtain jnidispatch InputStream");
            }
            FileOutputStream fileOutputStream = null;
            try {
                int n;
                File file2 = Native.getTempDir();
                file = File.createTempFile("jna", Platform.isWindows() ? ".dll" : null, file2);
                file.deleteOnExit();
                fileOutputStream = new FileOutputStream(file);
                byte[] byArray = new byte[1024];
                while ((n = inputStream2.read(byArray, 0, byArray.length)) > 0) {
                    fileOutputStream.write(byArray, 0, n);
                }
                bl = true;
            }
            catch (IOException iOException) {
                throw new Error("Failed to create temporary file for jnidispatch library: " + iOException);
            }
            finally {
                try {
                    inputStream2.close();
                }
                catch (IOException iOException) {}
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    }
                    catch (IOException iOException) {}
                }
            }
        }
        System.load(file.getAbsolutePath());
        nativeLibraryPath = file.getAbsolutePath();
        if (bl) {
            Native.deleteNativeLibrary(file.getAbsolutePath());
        }
    }

    private static native int sizeof(int var0);

    private static native String getNativeVersion();

    private static native String getAPIChecksum();

    public static int getLastError() {
        return (Integer)lastError.get();
    }

    public static native void setLastError(int var0);

    static void updateLastError(int n) {
        lastError.set(new Integer(n));
    }

    public static Library synchronizedLibrary(final Library library) {
        Class<?> clazz = library.getClass();
        if (!Proxy.isProxyClass(clazz)) {
            throw new IllegalArgumentException("Library must be a proxy class");
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(library);
        if (!(invocationHandler instanceof Library.Handler)) {
            throw new IllegalArgumentException("Unrecognized proxy handler: " + invocationHandler);
        }
        final Library.Handler handler = (Library.Handler)invocationHandler;
        InvocationHandler invocationHandler2 = new InvocationHandler(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
                NativeLibrary nativeLibrary = handler.getNativeLibrary();
                synchronized (nativeLibrary) {
                    return handler.invoke(library, method, objectArray);
                }
            }
        };
        return (Library)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), invocationHandler2);
    }

    public static String getWebStartLibraryPath(String string) {
        if (System.getProperty("javawebstart.version") == null) {
            return null;
        }
        try {
            ClassLoader classLoader = Native.class.getClassLoader();
            Method method = (Method)AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    try {
                        Method method = (class$java$lang$ClassLoader == null ? (class$java$lang$ClassLoader = Native.class$("java.lang.ClassLoader")) : class$java$lang$ClassLoader).getDeclaredMethod("findLibrary", class$java$lang$String == null ? (class$java$lang$String = Native.class$("java.lang.String")) : class$java$lang$String);
                        method.setAccessible(true);
                        return method;
                    }
                    catch (Exception exception) {
                        return null;
                    }
                }
            });
            String string2 = (String)method.invoke(classLoader, string);
            if (string2 != null) {
                return new File(string2).getParent();
            }
            return null;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static void markTemporaryFile(File file) {
        try {
            File file2 = new File(file.getParentFile(), file.getName() + ".x");
            file2.createNewFile();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    static File getTempDir() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        File file2 = new File(file, "jna");
        file2.mkdirs();
        return file2.exists() ? file2 : file;
    }

    static void removeTemporaryFiles() {
        File file = Native.getTempDir();
        FilenameFilter filenameFilter = new FilenameFilter(){

            public boolean accept(File file, String string) {
                return string.endsWith(".x") && string.indexOf("jna") != -1;
            }
        };
        File[] fileArray = file.listFiles(filenameFilter);
        for (int i = 0; fileArray != null && i < fileArray.length; ++i) {
            File file2 = fileArray[i];
            String string = file2.getName();
            string = string.substring(0, string.length() - 2);
            File file3 = new File(file2.getParentFile(), string);
            if (file3.exists() && !file3.delete()) continue;
            file2.delete();
        }
    }

    public static int getNativeSize(Class clazz, Object object) {
        if (clazz.isArray()) {
            int n = Array.getLength(object);
            if (n > 0) {
                Object object2 = Array.get(object, 0);
                return n * Native.getNativeSize(clazz.getComponentType(), object2);
            }
            throw new IllegalArgumentException("Arrays of length zero not allowed: " + clazz);
        }
        if (Structure.class.isAssignableFrom(clazz) && !Structure.ByReference.class.isAssignableFrom(clazz)) {
            if (object == null) {
                object = Structure.newInstance(clazz);
            }
            return ((Structure)object).size();
        }
        try {
            return Native.getNativeSize(clazz);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("The type \"" + clazz.getName() + "\" is not supported: " + illegalArgumentException.getMessage());
        }
    }

    public static int getNativeSize(Class clazz) {
        if (NativeMapped.class.isAssignableFrom(clazz)) {
            clazz = NativeMappedConverter.getInstance(clazz).nativeType();
        }
        if (clazz == Boolean.TYPE || clazz == Boolean.class) {
            return 4;
        }
        if (clazz == Byte.TYPE || clazz == Byte.class) {
            return 1;
        }
        if (clazz == Short.TYPE || clazz == Short.class) {
            return 2;
        }
        if (clazz == Character.TYPE || clazz == Character.class) {
            return WCHAR_SIZE;
        }
        if (clazz == Integer.TYPE || clazz == Integer.class) {
            return 4;
        }
        if (clazz == Long.TYPE || clazz == Long.class) {
            return 8;
        }
        if (clazz == Float.TYPE || clazz == Float.class) {
            return 4;
        }
        if (clazz == Double.TYPE || clazz == Double.class) {
            return 8;
        }
        if (Structure.class.isAssignableFrom(clazz)) {
            if (Structure.ByValue.class.isAssignableFrom(clazz)) {
                return Structure.newInstance(clazz).size();
            }
            return POINTER_SIZE;
        }
        if (Pointer.class.isAssignableFrom(clazz) || Platform.HAS_BUFFERS && Buffers.isBuffer(clazz) || Callback.class.isAssignableFrom(clazz) || String.class == clazz || WString.class == clazz) {
            return POINTER_SIZE;
        }
        throw new IllegalArgumentException("Native size for type \"" + clazz.getName() + "\" is unknown");
    }

    public static boolean isSupportedNativeType(Class clazz) {
        if (Structure.class.isAssignableFrom(clazz)) {
            return true;
        }
        try {
            return Native.getNativeSize(clazz) != 0;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler uncaughtExceptionHandler) {
        callbackExceptionHandler = uncaughtExceptionHandler == null ? DEFAULT_HANDLER : uncaughtExceptionHandler;
    }

    public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler() {
        return callbackExceptionHandler;
    }

    public static void register(String string) {
        Native.register(Native.getNativeClass(Native.getCallingClass()), NativeLibrary.getInstance(string));
    }

    public static void register(NativeLibrary nativeLibrary) {
        Native.register(Native.getNativeClass(Native.getCallingClass()), nativeLibrary);
    }

    static Class getNativeClass(Class clazz) {
        int n;
        Method[] methodArray = clazz.getDeclaredMethods();
        for (n = 0; n < methodArray.length; ++n) {
            if ((methodArray[n].getModifiers() & 0x100) == 0) continue;
            return clazz;
        }
        n = clazz.getName().lastIndexOf("$");
        if (n != -1) {
            String string = clazz.getName().substring(0, n);
            try {
                return Native.getNativeClass(Class.forName(string, true, clazz.getClassLoader()));
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        throw new IllegalArgumentException("Can't determine class with native methods from the current context (" + clazz + ")");
    }

    static Class getCallingClass() {
        Class[] classArray = new SecurityManager(){

            public Class[] getClassContext() {
                return super.getClassContext();
            }
        }.getClassContext();
        if (classArray.length < 4) {
            throw new IllegalStateException("This method must be called from the static initializer of a class");
        }
        return classArray[3];
    }

    public static void setCallbackThreadInitializer(Callback callback, CallbackThreadInitializer callbackThreadInitializer) {
        CallbackReference.setCallbackThreadInitializer(callback, callbackThreadInitializer);
    }

    public static void unregister() {
        Native.unregister(Native.getNativeClass(Native.getCallingClass()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void unregister(Class clazz) {
        Map map = registeredClasses;
        synchronized (map) {
            if (registeredClasses.containsKey(clazz)) {
                Native.unregister(clazz, (long[])registeredClasses.get(clazz));
                registeredClasses.remove(clazz);
                registeredLibraries.remove(clazz);
            }
        }
    }

    private static native void unregister(Class var0, long[] var1);

    private static String getSignature(Class clazz) {
        if (clazz.isArray()) {
            return "[" + Native.getSignature(clazz.getComponentType());
        }
        if (clazz.isPrimitive()) {
            if (clazz == Void.TYPE) {
                return "V";
            }
            if (clazz == Boolean.TYPE) {
                return "Z";
            }
            if (clazz == Byte.TYPE) {
                return "B";
            }
            if (clazz == Short.TYPE) {
                return "S";
            }
            if (clazz == Character.TYPE) {
                return "C";
            }
            if (clazz == Integer.TYPE) {
                return "I";
            }
            if (clazz == Long.TYPE) {
                return "J";
            }
            if (clazz == Float.TYPE) {
                return "F";
            }
            if (clazz == Double.TYPE) {
                return "D";
            }
        }
        return "L" + Native.replace(".", "/", clazz.getName()) + ";";
    }

    static String replace(String string, String string2, String string3) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int n;
            if ((n = string3.indexOf(string)) == -1) break;
            stringBuffer.append(string3.substring(0, n));
            stringBuffer.append(string2);
            string3 = string3.substring(n + string.length());
        }
        stringBuffer.append(string3);
        return stringBuffer.toString();
    }

    private static int getConversion(Class clazz, TypeMapper typeMapper) {
        if (clazz == Boolean.class) {
            clazz = Boolean.TYPE;
        } else if (clazz == Byte.class) {
            clazz = Byte.TYPE;
        } else if (clazz == Short.class) {
            clazz = Short.TYPE;
        } else if (clazz == Character.class) {
            clazz = Character.TYPE;
        } else if (clazz == Integer.class) {
            clazz = Integer.TYPE;
        } else if (clazz == Long.class) {
            clazz = Long.TYPE;
        } else if (clazz == Float.class) {
            clazz = Float.TYPE;
        } else if (clazz == Double.class) {
            clazz = Double.TYPE;
        } else if (clazz == Void.class) {
            clazz = Void.TYPE;
        }
        if (typeMapper != null && (typeMapper.getFromNativeConverter(clazz) != null || typeMapper.getToNativeConverter(clazz) != null)) {
            return 21;
        }
        if (Pointer.class.isAssignableFrom(clazz)) {
            return 1;
        }
        if (String.class == clazz) {
            return 2;
        }
        if (WString.class.isAssignableFrom(clazz)) {
            return 18;
        }
        if (Platform.HAS_BUFFERS && Buffers.isBuffer(clazz)) {
            return 5;
        }
        if (Structure.class.isAssignableFrom(clazz)) {
            if (Structure.ByValue.class.isAssignableFrom(clazz)) {
                return 4;
            }
            return 3;
        }
        if (clazz.isArray()) {
            switch (clazz.getName().charAt(1)) {
                case 'Z': {
                    return 13;
                }
                case 'B': {
                    return 6;
                }
                case 'S': {
                    return 7;
                }
                case 'C': {
                    return 8;
                }
                case 'I': {
                    return 9;
                }
                case 'J': {
                    return 10;
                }
                case 'F': {
                    return 11;
                }
                case 'D': {
                    return 12;
                }
            }
        }
        if (clazz.isPrimitive()) {
            return clazz == Boolean.TYPE ? 14 : 0;
        }
        if (Callback.class.isAssignableFrom(clazz)) {
            return 15;
        }
        if (IntegerType.class.isAssignableFrom(clazz)) {
            return 19;
        }
        if (PointerType.class.isAssignableFrom(clazz)) {
            return 20;
        }
        if (NativeMapped.class.isAssignableFrom(clazz)) {
            return 17;
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void register(Class clazz, NativeLibrary nativeLibrary) {
        Method[] methodArray = clazz.getDeclaredMethods();
        ArrayList<Method> arrayList = new ArrayList<Method>();
        TypeMapper typeMapper = (TypeMapper)nativeLibrary.getOptions().get("type-mapper");
        for (int i = 0; i < methodArray.length; ++i) {
            if ((methodArray[i].getModifiers() & 0x100) == 0) continue;
            arrayList.add(methodArray[i]);
        }
        long[] lArray = new long[arrayList.size()];
        for (int i = 0; i < lArray.length; ++i) {
            Object object;
            long l;
            long l2;
            Method method = (Method)arrayList.get(i);
            String string = "(";
            Class<?> clazz2 = method.getReturnType();
            Class<?>[] classArray = method.getParameterTypes();
            long[] lArray2 = new long[classArray.length];
            long[] lArray3 = new long[classArray.length];
            int[] nArray = new int[classArray.length];
            ToNativeConverter[] toNativeConverterArray = new ToNativeConverter[classArray.length];
            FromNativeConverter fromNativeConverter = null;
            int n = Native.getConversion(clazz2, typeMapper);
            boolean bl = false;
            switch (n) {
                case -1: {
                    throw new IllegalArgumentException(clazz2 + " is not a supported return type (in method " + method.getName() + " in " + clazz + ")");
                }
                case 21: {
                    fromNativeConverter = typeMapper.getFromNativeConverter(clazz2);
                    l2 = Structure.FFIType.get(clazz2).peer;
                    l = Structure.FFIType.get((Object)fromNativeConverter.nativeType()).peer;
                    break;
                }
                case 17: 
                case 19: 
                case 20: {
                    l2 = Structure.FFIType.get((Object)(Native.class$com$sun$jna$Pointer == null ? Native.class$((String)"com.sun.jna.Pointer") : Native.class$com$sun$jna$Pointer)).peer;
                    l = Structure.FFIType.get((Object)NativeMappedConverter.getInstance(clazz2).nativeType()).peer;
                    break;
                }
                case 3: {
                    l2 = l = Structure.FFIType.get((Object)(Native.class$com$sun$jna$Pointer == null ? Native.class$((String)"com.sun.jna.Pointer") : Native.class$com$sun$jna$Pointer)).peer;
                    break;
                }
                case 4: {
                    l2 = Structure.FFIType.get((Object)(Native.class$com$sun$jna$Pointer == null ? Native.class$((String)"com.sun.jna.Pointer") : Native.class$com$sun$jna$Pointer)).peer;
                    l = Structure.FFIType.get(clazz2).peer;
                    break;
                }
                default: {
                    l2 = l = Structure.FFIType.get(clazz2).peer;
                }
            }
            block19: for (int j = 0; j < classArray.length; ++j) {
                object = classArray[j];
                string = string + Native.getSignature(object);
                nArray[j] = Native.getConversion(object, typeMapper);
                if (nArray[j] == -1) {
                    throw new IllegalArgumentException(object + " is not a supported argument type (in method " + method.getName() + " in " + clazz + ")");
                }
                if (nArray[j] == 17 || nArray[j] == 19) {
                    object = NativeMappedConverter.getInstance(object).nativeType();
                } else if (nArray[j] == 21) {
                    toNativeConverterArray[j] = typeMapper.getToNativeConverter((Class)object);
                }
                switch (nArray[j]) {
                    case 4: 
                    case 17: 
                    case 19: 
                    case 20: {
                        lArray2[j] = Structure.FFIType.get((Object)object).peer;
                        lArray3[j] = Structure.FFIType.get((Object)(Native.class$com$sun$jna$Pointer == null ? Native.class$((String)"com.sun.jna.Pointer") : Native.class$com$sun$jna$Pointer)).peer;
                        continue block19;
                    }
                    case 21: {
                        lArray3[j] = ((Class)object).isPrimitive() ? Structure.FFIType.get((Object)object).peer : Structure.FFIType.get((Object)(Native.class$com$sun$jna$Pointer == null ? Native.class$((String)"com.sun.jna.Pointer") : Native.class$com$sun$jna$Pointer)).peer;
                        lArray2[j] = Structure.FFIType.get((Object)toNativeConverterArray[j].nativeType()).peer;
                        continue block19;
                    }
                    case 0: {
                        lArray3[j] = lArray2[j] = Structure.FFIType.get((Object)object).peer;
                        continue block19;
                    }
                    default: {
                        lArray3[j] = lArray2[j] = Structure.FFIType.get((Object)(Native.class$com$sun$jna$Pointer == null ? Native.class$((String)"com.sun.jna.Pointer") : Native.class$com$sun$jna$Pointer)).peer;
                    }
                }
            }
            string = string + ")";
            string = string + Native.getSignature(clazz2);
            Class<?>[] classArray2 = method.getExceptionTypes();
            for (int j = 0; j < classArray2.length; ++j) {
                if (!(class$com$sun$jna$LastErrorException == null ? Native.class$("com.sun.jna.LastErrorException") : class$com$sun$jna$LastErrorException).isAssignableFrom(classArray2[j])) continue;
                bl = true;
                break;
            }
            object = method.getName();
            FunctionMapper functionMapper = (FunctionMapper)nativeLibrary.getOptions().get("function-mapper");
            if (functionMapper != null) {
                object = functionMapper.getFunctionName(nativeLibrary, method);
            }
            Function function = nativeLibrary.getFunction((String)object, method);
            try {
                lArray[i] = Native.registerMethod(clazz, method.getName(), string, nArray, lArray3, lArray2, n, l2, l, clazz2, function.peer, function.getCallingConvention(), bl, toNativeConverterArray, fromNativeConverter);
                continue;
            }
            catch (NoSuchMethodError noSuchMethodError) {
                throw new UnsatisfiedLinkError("No method " + method.getName() + " with signature " + string + " in " + clazz);
            }
        }
        Map map = registeredClasses;
        synchronized (map) {
            registeredClasses.put(clazz, lArray);
            registeredLibraries.put(clazz, nativeLibrary);
        }
        Native.cacheOptions(clazz, nativeLibrary.getOptions(), null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void cacheOptions(Class clazz, Map map, Object object) {
        Map map2 = libraries;
        synchronized (map2) {
            if (!map.isEmpty()) {
                options.put(clazz, map);
            }
            if (map.containsKey("type-mapper")) {
                typeMappers.put(clazz, map.get("type-mapper"));
            }
            if (map.containsKey("structure-alignment")) {
                alignments.put(clazz, map.get("structure-alignment"));
            }
            if (object != null) {
                libraries.put(clazz, new WeakReference<Object>(object));
            }
            if (!clazz.isInterface() && Library.class.isAssignableFrom(clazz)) {
                Class<?>[] classArray = clazz.getInterfaces();
                for (int i = 0; i < classArray.length; ++i) {
                    if (!(class$com$sun$jna$Library == null ? Native.class$("com.sun.jna.Library") : class$com$sun$jna$Library).isAssignableFrom(classArray[i])) continue;
                    Native.cacheOptions(classArray[i], map, object);
                    break;
                }
            }
        }
    }

    private static native long registerMethod(Class var0, String var1, String var2, int[] var3, long[] var4, long[] var5, int var6, long var7, long var9, Class var11, long var12, int var14, boolean var15, ToNativeConverter[] var16, FromNativeConverter var17);

    private static NativeMapped fromNative(Class clazz, Object object) {
        return (NativeMapped)NativeMappedConverter.getInstance(clazz).fromNative(object, new FromNativeContext(clazz));
    }

    private static Class nativeType(Class clazz) {
        return NativeMappedConverter.getInstance(clazz).nativeType();
    }

    private static Object toNative(ToNativeConverter toNativeConverter, Object object) {
        return toNativeConverter.toNative(object, new ToNativeContext());
    }

    private static Object fromNative(FromNativeConverter fromNativeConverter, Object object, Class clazz) {
        return fromNativeConverter.fromNative(object, new FromNativeContext(clazz));
    }

    public static native long ffi_prep_cif(int var0, int var1, long var2, long var4);

    public static native void ffi_call(long var0, long var2, long var4, long var6);

    public static native long ffi_prep_closure(long var0, ffi_callback var2);

    public static native void ffi_free_closure(long var0);

    static native int initialize_ffi_type(long var0);

    public static void main(String[] stringArray) {
        String string;
        String string2;
        String string3 = "Java Native Access (JNA)";
        String string4 = "3.4.0";
        String string5 = "3.4.0 (package information missing)";
        Package package_ = Native.class.getPackage();
        String string6 = string2 = package_ != null ? package_.getSpecificationTitle() : "Java Native Access (JNA)";
        if (string2 == null) {
            string2 = "Java Native Access (JNA)";
        }
        String string7 = string = package_ != null ? package_.getSpecificationVersion() : "3.4.0";
        if (string == null) {
            string = "3.4.0";
        }
        string2 = string2 + " API Version " + string;
        System.out.println(string2);
        String string8 = string = package_ != null ? package_.getImplementationVersion() : "3.4.0 (package information missing)";
        if (string == null) {
            string = "3.4.0 (package information missing)";
        }
        System.out.println("Version: " + string);
        System.out.println(" Native: " + Native.getNativeVersion() + " (" + Native.getAPIChecksum() + ")");
        System.exit(0);
    }

    static synchronized native void freeNativeCallback(long var0);

    static synchronized native long createNativeCallback(Callback var0, Method var1, Class[] var2, Class var3, int var4, boolean var5);

    static native int invokeInt(long var0, int var2, Object[] var3);

    static native long invokeLong(long var0, int var2, Object[] var3);

    static native void invokeVoid(long var0, int var2, Object[] var3);

    static native float invokeFloat(long var0, int var2, Object[] var3);

    static native double invokeDouble(long var0, int var2, Object[] var3);

    static native long invokePointer(long var0, int var2, Object[] var3);

    private static native void invokeStructure(long var0, int var2, Object[] var3, long var4, long var6);

    static Structure invokeStructure(long l, int n, Object[] objectArray, Structure structure) {
        Native.invokeStructure(l, n, objectArray, structure.getPointer().peer, structure.getTypeInfo().peer);
        return structure;
    }

    static native Object invokeObject(long var0, int var2, Object[] var3);

    static native long open(String var0);

    static native void close(long var0);

    static native long findSymbol(long var0, String var2);

    static native long indexOf(long var0, byte var2);

    static native void read(long var0, byte[] var2, int var3, int var4);

    static native void read(long var0, short[] var2, int var3, int var4);

    static native void read(long var0, char[] var2, int var3, int var4);

    static native void read(long var0, int[] var2, int var3, int var4);

    static native void read(long var0, long[] var2, int var3, int var4);

    static native void read(long var0, float[] var2, int var3, int var4);

    static native void read(long var0, double[] var2, int var3, int var4);

    static native void write(long var0, byte[] var2, int var3, int var4);

    static native void write(long var0, short[] var2, int var3, int var4);

    static native void write(long var0, char[] var2, int var3, int var4);

    static native void write(long var0, int[] var2, int var3, int var4);

    static native void write(long var0, long[] var2, int var3, int var4);

    static native void write(long var0, float[] var2, int var3, int var4);

    static native void write(long var0, double[] var2, int var3, int var4);

    static native byte getByte(long var0);

    static native char getChar(long var0);

    static native short getShort(long var0);

    static native int getInt(long var0);

    static native long getLong(long var0);

    static native float getFloat(long var0);

    static native double getDouble(long var0);

    static Pointer getPointer(long l) {
        long l2 = Native._getPointer(l);
        return l2 == 0L ? null : new Pointer(l2);
    }

    private static native long _getPointer(long var0);

    static native String getString(long var0, boolean var2);

    static native void setMemory(long var0, long var2, byte var4);

    static native void setByte(long var0, byte var2);

    static native void setShort(long var0, short var2);

    static native void setChar(long var0, char var2);

    static native void setInt(long var0, int var2);

    static native void setLong(long var0, long var2);

    static native void setFloat(long var0, float var2);

    static native void setDouble(long var0, double var2);

    static native void setPointer(long var0, long var2);

    static native void setString(long var0, String var2, boolean var3);

    public static native long malloc(long var0);

    public static native void free(long var0);

    public static native ByteBuffer getDirectByteBuffer(long var0, long var2);

    public static void detach(boolean bl) {
        Native.setLastError(bl ? -1 : -2);
    }

    static {
        String string;
        nativeLibraryPath = null;
        typeMappers = new WeakHashMap();
        alignments = new WeakHashMap();
        options = new WeakHashMap();
        libraries = new WeakHashMap();
        callbackExceptionHandler = DEFAULT_HANDLER = new Callback.UncaughtExceptionHandler(){

            public void uncaughtException(Callback callback, Throwable throwable) {
                System.err.println("JNA: Callback " + callback + " threw the following exception:");
                throwable.printStackTrace();
            }
        };
        Native.loadNativeLibrary();
        POINTER_SIZE = Native.sizeof(0);
        LONG_SIZE = Native.sizeof(1);
        WCHAR_SIZE = Native.sizeof(2);
        SIZE_T_SIZE = Native.sizeof(3);
        Native.initIDs();
        if (Boolean.getBoolean("jna.protected")) {
            Native.setProtected(true);
        }
        if (!"3.4.0".equals(string = Native.getNativeVersion())) {
            String string2 = System.getProperty("line.separator");
            throw new Error(string2 + string2 + "There is an incompatible JNA native library installed on this system." + string2 + "To resolve this issue you may do one of the following:" + string2 + " - remove or uninstall the offending library" + string2 + " - set the system property jna.nosys=true" + string2 + " - set jna.boot.library.path to include the path to the version of the " + string2 + "   jnidispatch library included with the JNA jar file you are using" + string2);
        }
        Native.setPreserveLastError("true".equalsIgnoreCase(System.getProperty("jna.preserve_last_error", "true")));
        finalizer = new Object(){

            protected void finalize() {
                Native.dispose();
            }
        };
        lastError = new ThreadLocal(){

            protected synchronized Object initialValue() {
                return new Integer(0);
            }
        };
        registeredClasses = new HashMap();
        registeredLibraries = new HashMap();
        unloader = new Object(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            protected void finalize() {
                Map map = registeredClasses;
                synchronized (map) {
                    Iterator iterator2 = registeredClasses.entrySet().iterator();
                    while (iterator2.hasNext()) {
                        Map.Entry entry = iterator2.next();
                        Native.unregister((Class)entry.getKey(), (long[])entry.getValue());
                        iterator2.remove();
                    }
                }
            }
        };
    }

    private static class AWT {
        private AWT() {
        }

        static long getWindowID(Window window) throws HeadlessException {
            return AWT.getComponentID(window);
        }

        static long getComponentID(Object object) throws HeadlessException {
            if (GraphicsEnvironment.isHeadless()) {
                throw new HeadlessException("No native windows when headless");
            }
            Component component = (Component)object;
            if (component.isLightweight()) {
                throw new IllegalArgumentException("Component must be heavyweight");
            }
            if (!component.isDisplayable()) {
                throw new IllegalStateException("Component must be displayable");
            }
            if (Platform.isX11() && System.getProperty("java.version").startsWith("1.4") && !component.isVisible()) {
                throw new IllegalStateException("Component must be visible");
            }
            return Native.getWindowHandle0(component);
        }
    }

    private static class Buffers {
        private Buffers() {
        }

        static boolean isBuffer(Class clazz) {
            return (class$java$nio$Buffer == null ? (class$java$nio$Buffer = Native.class$("java.nio.Buffer")) : class$java$nio$Buffer).isAssignableFrom(clazz);
        }
    }

    public static interface ffi_callback {
        public void invoke(long var1, long var3, long var5);
    }
}

