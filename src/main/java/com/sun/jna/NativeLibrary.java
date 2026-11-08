/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Function;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
public class NativeLibrary {
    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }

    private long handle;
    private final String libraryName;
    private final String libraryPath;
    private final Map functions = new HashMap();
    final int callFlags;
    final Map options;
    private static final Map libraries = new HashMap();
    private static final Map searchPaths = Collections.synchronizedMap(new HashMap());
    private static final List librarySearchPath = new LinkedList();
    static /* synthetic */ Class class$com$sun$jna$LastErrorException;

    private static String functionKey(String string, int n) {
        return string + "|" + n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private NativeLibrary(String string, String string2, long l, Map map) {
        int n;
        this.libraryName = this.getLibraryName(string);
        this.libraryPath = string2;
        this.handle = l;
        Object v = map.get("calling-convention");
        this.callFlags = n = v instanceof Integer ? (Integer)v : 0;
        this.options = map;
        if (Platform.isWindows() && "kernel32".equals(this.libraryName.toLowerCase())) {
            Map map2 = this.functions;
            synchronized (map2) {
                Function function = new Function(this, "GetLastError", 1){

                    Object invoke(Object[] objectArray, Class clazz, boolean bl) {
                        return new Integer(Native.getLastError());
                    }
                };
                this.functions.put(NativeLibrary.functionKey("GetLastError", this.callFlags), function);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static NativeLibrary loadLibrary(String string, Map map) {
        long l;
        Object object;
        block23: {
            List list;
            LinkedList<String> linkedList = new LinkedList<String>();
            String string2 = Native.getWebStartLibraryPath(string);
            if (string2 != null) {
                linkedList.add(string2);
            }
            if ((list = (List)searchPaths.get(string)) != null) {
                object = list;
                synchronized (object) {
                    linkedList.addAll(0, list);
                }
            }
            linkedList.addAll(NativeLibrary.initPaths("jna.library.path"));
            object = NativeLibrary.findLibraryPath(string, linkedList);
            l = 0L;
            try {
                l = Native.open((String)object);
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                linkedList.addAll(librarySearchPath);
            }
            try {
                if (l == 0L && (l = Native.open((String)(object = NativeLibrary.findLibraryPath(string, linkedList)))) == 0L) {
                    throw new UnsatisfiedLinkError("Failed to load library '" + string + "'");
                }
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                UnsatisfiedLinkError unsatisfiedLinkError2;
                if (Platform.isLinux()) {
                    object = NativeLibrary.matchLibrary(string, linkedList);
                    if (object != null) {
                        try {
                            l = Native.open((String)object);
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError3) {
                            unsatisfiedLinkError2 = unsatisfiedLinkError3;
                        }
                    }
                } else if (Platform.isMac() && !string.endsWith(".dylib")) {
                    object = "/System/Library/Frameworks/" + string + ".framework/" + string;
                    if (new File((String)object).exists()) {
                        try {
                            l = Native.open((String)object);
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError4) {
                            unsatisfiedLinkError2 = unsatisfiedLinkError4;
                        }
                    }
                } else if (Platform.isWindows()) {
                    object = NativeLibrary.findLibraryPath("lib" + string, linkedList);
                    try {
                        l = Native.open((String)object);
                    }
                    catch (UnsatisfiedLinkError unsatisfiedLinkError5) {
                        unsatisfiedLinkError2 = unsatisfiedLinkError5;
                    }
                }
                if (l != 0L) break block23;
                throw new UnsatisfiedLinkError("Unable to load library '" + string + "': " + unsatisfiedLinkError2.getMessage());
            }
        }
        return new NativeLibrary(string, (String)object, l, map);
    }

    private String getLibraryName(String string) {
        String string2;
        int n;
        String string3 = string;
        String string4 = "---";
        String string5 = NativeLibrary.mapLibraryName("---");
        int n2 = string5.indexOf("---");
        if (n2 > 0 && string3.startsWith(string5.substring(0, n2))) {
            string3 = string3.substring(n2);
        }
        if ((n = string3.indexOf(string2 = string5.substring(n2 + "---".length()))) != -1) {
            string3 = string3.substring(0, n);
        }
        return string3;
    }

    public static final NativeLibrary getInstance(String string) {
        return NativeLibrary.getInstance(string, Collections.EMPTY_MAP);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final NativeLibrary getInstance(String string, Map hashMap) {
        if ((hashMap = new HashMap<String, Integer>(hashMap)).get("calling-convention") == null) {
            hashMap.put("calling-convention", new Integer(0));
        }
        if (Platform.isLinux() && "c".equals(string)) {
            string = null;
        }
        Map map = libraries;
        synchronized (map) {
            NativeLibrary nativeLibrary;
            WeakReference<NativeLibrary> weakReference = (WeakReference<NativeLibrary>)libraries.get(string + hashMap);
            NativeLibrary nativeLibrary2 = nativeLibrary = weakReference != null ? (NativeLibrary)weakReference.get() : null;
            if (nativeLibrary == null) {
                nativeLibrary = string == null ? new NativeLibrary("<process>", null, Native.open(null), hashMap) : NativeLibrary.loadLibrary(string, hashMap);
                weakReference = new WeakReference<NativeLibrary>(nativeLibrary);
                libraries.put(nativeLibrary.getName() + hashMap, weakReference);
                File file = nativeLibrary.getFile();
                if (file != null) {
                    libraries.put(file.getAbsolutePath() + hashMap, weakReference);
                    libraries.put(file.getName() + hashMap, weakReference);
                }
            }
            return nativeLibrary;
        }
    }

    public static final synchronized NativeLibrary getProcess() {
        return NativeLibrary.getInstance(null);
    }

    public static final synchronized NativeLibrary getProcess(Map map) {
        return NativeLibrary.getInstance(null, map);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void addSearchPath(String string, String string2) {
        Map map = searchPaths;
        synchronized (map) {
            List<String> list = (List<String>)searchPaths.get(string);
            if (list == null) {
                list = Collections.synchronizedList(new LinkedList());
                searchPaths.put(string, list);
            }
            list.add(string2);
        }
    }

    public Function getFunction(String string) {
        return this.getFunction(string, this.callFlags);
    }

    Function getFunction(String string, Method method) {
        int n = this.callFlags;
        Class<?>[] classArray = method.getExceptionTypes();
        for (int i = 0; i < classArray.length; ++i) {
            if (!(class$com$sun$jna$LastErrorException == null ? NativeLibrary.class$("com.sun.jna.LastErrorException") : class$com$sun$jna$LastErrorException).isAssignableFrom(classArray[i])) continue;
            n |= 4;
        }
        return this.getFunction(string, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Function getFunction(String string, int n) {
        if (string == null) {
            throw new NullPointerException("Function name may not be null");
        }
        Map map = this.functions;
        synchronized (map) {
            String string2 = NativeLibrary.functionKey(string, n);
            Function function = (Function)this.functions.get(string2);
            if (function == null) {
                function = new Function(this, string, n);
                this.functions.put(string2, function);
            }
            return function;
        }
    }

    public Map getOptions() {
        return this.options;
    }

    public Pointer getGlobalVariableAddress(String string) {
        try {
            return new Pointer(this.getSymbolAddress(string));
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            throw new UnsatisfiedLinkError("Error looking up '" + string + "': " + unsatisfiedLinkError.getMessage());
        }
    }

    long getSymbolAddress(String string) {
        if (this.handle == 0L) {
            throw new UnsatisfiedLinkError("Library has been unloaded");
        }
        return Native.findSymbol(this.handle, string);
    }

    public String toString() {
        return "Native Library <" + this.libraryPath + "@" + this.handle + ">";
    }

    public String getName() {
        return this.libraryName;
    }

    public File getFile() {
        if (this.libraryPath == null) {
            return null;
        }
        return new File(this.libraryPath);
    }

    protected void finalize() {
        this.dispose();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void disposeAll() {
        HashSet hashSet;
        Object object = libraries;
        synchronized (object) {
            hashSet = new HashSet(libraries.values());
        }
        object = hashSet.iterator();
        while (object.hasNext()) {
            WeakReference weakReference = (WeakReference)object.next();
            NativeLibrary nativeLibrary = (NativeLibrary)weakReference.get();
            if (nativeLibrary == null) continue;
            nativeLibrary.dispose();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dispose() {
        Object object = libraries;
        synchronized (object) {
            Iterator iterator2 = libraries.values().iterator();
            while (iterator2.hasNext()) {
                WeakReference weakReference = (WeakReference)iterator2.next();
                if (weakReference.get() != this) continue;
                iterator2.remove();
            }
        }
        object = this;
        synchronized (object) {
            if (this.handle != 0L) {
                Native.close(this.handle);
                this.handle = 0L;
            }
        }
    }

    private static List initPaths(String string) {
        String string2 = System.getProperty(string, "");
        if ("".equals(string2)) {
            return Collections.EMPTY_LIST;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string2, File.pathSeparator);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()) {
            String string3 = stringTokenizer.nextToken();
            if ("".equals(string3)) continue;
            arrayList.add(string3);
        }
        return arrayList;
    }

    private static String findLibraryPath(String string, List list) {
        if (new File(string).isAbsolute()) {
            return string;
        }
        String string2 = NativeLibrary.mapLibraryName(string);
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            String string3 = (String)iterator2.next();
            File file = new File(string3, string2);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            if (!Platform.isMac() || !string2.endsWith(".dylib") || !(file = new File(string3, string2.substring(0, string2.lastIndexOf(".dylib")) + ".jnilib")).exists()) continue;
            return file.getAbsolutePath();
        }
        return string2;
    }

    private static String mapLibraryName(String string) {
        if (Platform.isMac()) {
            if (string.startsWith("lib") && (string.endsWith(".dylib") || string.endsWith(".jnilib"))) {
                return string;
            }
            String string2 = System.mapLibraryName(string);
            if (string2.endsWith(".jnilib")) {
                return string2.substring(0, string2.lastIndexOf(".jnilib")) + ".dylib";
            }
            return string2;
        }
        if (Platform.isLinux() ? NativeLibrary.isVersionedName(string) || string.endsWith(".so") : Platform.isWindows() && (string.endsWith(".drv") || string.endsWith(".dll"))) {
            return string;
        }
        return System.mapLibraryName(string);
    }

    private static boolean isVersionedName(String string) {
        int n;
        if (string.startsWith("lib") && (n = string.lastIndexOf(".so.")) != -1 && n + 4 < string.length()) {
            for (int i = n + 4; i < string.length(); ++i) {
                char c = string.charAt(i);
                if (Character.isDigit(c) || c == '.') continue;
                return false;
            }
            return true;
        }
        return false;
    }

    static String matchLibrary(final String string, List list) {
        File file = new File(string);
        if (file.isAbsolute()) {
            list = Arrays.asList(file.getParent());
        }
        FilenameFilter filenameFilter = new FilenameFilter(){

            public boolean accept(File file, String string2) {
                return (string2.startsWith("lib" + string + ".so") || string2.startsWith(string + ".so") && string.startsWith("lib")) && NativeLibrary.isVersionedName(string2);
            }
        };
        LinkedList<File> linkedList = new LinkedList<File>();
        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            File[] fileArray = new File(iterator2.next()).listFiles(filenameFilter);
            if (fileArray == null || fileArray.length <= 0) continue;
            linkedList.addAll(Arrays.asList(fileArray));
        }
        double d = -1.0;
        String string2 = null;
        Iterator iterator3 = linkedList.iterator();
        while (iterator3.hasNext()) {
            String string3 = ((File)iterator3.next()).getAbsolutePath();
            String string4 = string3.substring(string3.lastIndexOf(".so.") + 4);
            double d2 = NativeLibrary.parseVersion(string4);
            if (!(d2 > d)) continue;
            d = d2;
            string2 = string3;
        }
        return string2;
    }

    static double parseVersion(String string) {
        double d = 0.0;
        double d2 = 1.0;
        int n = string.indexOf(".");
        while (string != null) {
            String string2;
            if (n != -1) {
                string2 = string.substring(0, n);
                string = string.substring(n + 1);
                n = string.indexOf(".");
            } else {
                string2 = string;
                string = null;
            }
            try {
                d += (double)Integer.parseInt(string2) / d2;
            }
            catch (NumberFormatException numberFormatException) {
                return 0.0;
            }
            d2 *= 100.0;
        }
        return d;
    }

    static {
        if (Native.POINTER_SIZE == 0) {
            throw new Error("Native library not initialized");
        }
        String string = Native.getWebStartLibraryPath("jnidispatch");
        if (string != null) {
            librarySearchPath.add(string);
        }
        if (System.getProperty("jna.platform.library.path") == null && !Platform.isWindows()) {
            Object object;
            String string2 = "";
            String string3 = "";
            String string4 = "";
            if (Platform.isLinux() || Platform.isSolaris() || Platform.isFreeBSD()) {
                string4 = (Platform.isSolaris() ? "/" : "") + Pointer.SIZE * 8;
            }
            String[] stringArray = new String[]{"/usr/lib" + string4, "/lib" + string4, "/usr/lib", "/lib"};
            if (Platform.isLinux()) {
                String string5 = "";
                object = "linux";
                String string6 = "gnu";
                if (Platform.isIntel()) {
                    string5 = Platform.is64Bit() ? "x86_64" : "i386";
                } else if (Platform.isPPC()) {
                    string5 = Platform.is64Bit() ? "powerpc64" : "powerpc";
                } else if (Platform.isARM()) {
                    string5 = "arm";
                    string6 = "gnueabi";
                }
                String string7 = string5 + "-" + (String)object + "-" + string6;
                stringArray = new String[]{"/usr/lib/" + string7, "/lib/" + string7, "/usr/lib" + string4, "/lib" + string4, "/usr/lib", "/lib"};
            }
            for (int i = 0; i < stringArray.length; ++i) {
                object = new File(stringArray[i]);
                if (!((File)object).exists() || !((File)object).isDirectory()) continue;
                string2 = string2 + string3 + stringArray[i];
                string3 = File.pathSeparator;
            }
            if (!"".equals(string2)) {
                System.setProperty("jna.platform.library.path", string2);
            }
        }
        librarySearchPath.addAll(NativeLibrary.initPaths("jna.platform.library.path"));
    }
}

