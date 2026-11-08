/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.Utility;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public abstract class URLHandler {
    public static final String PROPNAME = "urlhandler.props";
    private static final Map<String, Method> handlers;
    private static final boolean DEBUG;

    public static URLHandler get(URL uRL) {
        block9: {
            Method method;
            if (uRL == null) {
                return null;
            }
            String string = uRL.getProtocol();
            if (handlers != null && (method = handlers.get(string)) != null) {
                try {
                    URLHandler uRLHandler = (URLHandler)method.invoke(null, uRL);
                    if (uRLHandler != null) {
                        return uRLHandler;
                    }
                }
                catch (IllegalAccessException illegalAccessException) {
                    if (DEBUG) {
                        System.err.println(illegalAccessException);
                    }
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    if (DEBUG) {
                        System.err.println(illegalArgumentException);
                    }
                }
                catch (InvocationTargetException invocationTargetException) {
                    if (!DEBUG) break block9;
                    System.err.println(invocationTargetException);
                }
            }
        }
        return URLHandler.getDefault(uRL);
    }

    protected static URLHandler getDefault(URL uRL) {
        URLHandler uRLHandler = null;
        String string = uRL.getProtocol();
        try {
            if (string.equals("file")) {
                uRLHandler = new FileURLHandler(uRL);
            } else if (string.equals("jar") || string.equals("wsjar")) {
                uRLHandler = new JarURLHandler(uRL);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return uRLHandler;
    }

    public void guide(URLVisitor uRLVisitor, boolean bl) {
        this.guide(uRLVisitor, bl, true);
    }

    public abstract void guide(URLVisitor var1, boolean var2, boolean var3);

    static {
        HashMap<String, Method> hashMap;
        block13: {
            DEBUG = ICUDebug.enabled("URLHandler");
            hashMap = null;
            try {
                Class[] classArray;
                InputStream inputStream2 = URLHandler.class.getResourceAsStream(PROPNAME);
                if (inputStream2 == null) {
                    classArray = Utility.getFallbackClassLoader();
                    inputStream2 = classArray.getResourceAsStream(PROPNAME);
                }
                if (inputStream2 == null) break block13;
                classArray = new Class[]{URL.class};
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                String string = bufferedReader.readLine();
                while (string != null) {
                    block14: {
                        if ((string = string.trim()).length() != 0 && string.charAt(0) != '#') {
                            int n = string.indexOf(61);
                            if (n == -1) {
                                if (!DEBUG) break;
                                System.err.println("bad urlhandler line: '" + string + "'");
                                break;
                            }
                            String string2 = string.substring(0, n).trim();
                            String string3 = string.substring(n + 1).trim();
                            try {
                                Class<?> clazz = Class.forName(string3);
                                Method method = clazz.getDeclaredMethod("get", classArray);
                                if (hashMap == null) {
                                    hashMap = new HashMap<String, Method>();
                                }
                                hashMap.put(string2, method);
                            }
                            catch (ClassNotFoundException classNotFoundException) {
                                if (DEBUG) {
                                    System.err.println(classNotFoundException);
                                }
                            }
                            catch (NoSuchMethodException noSuchMethodException) {
                                if (DEBUG) {
                                    System.err.println(noSuchMethodException);
                                }
                            }
                            catch (SecurityException securityException) {
                                if (!DEBUG) break block14;
                                System.err.println(securityException);
                            }
                        }
                    }
                    string = bufferedReader.readLine();
                }
                bufferedReader.close();
            }
            catch (Throwable throwable) {
                if (!DEBUG) break block13;
                System.err.println(throwable);
            }
        }
        handlers = hashMap;
    }

    public static interface URLVisitor {
        public void visit(String var1);
    }

    private static class JarURLHandler
    extends URLHandler {
        JarFile jarFile;
        String prefix;

        JarURLHandler(URL uRL) {
            try {
                Object object;
                int n;
                String string;
                this.prefix = uRL.getPath();
                int n2 = this.prefix.lastIndexOf("!/");
                if (n2 >= 0) {
                    this.prefix = this.prefix.substring(n2 + 2);
                }
                if (!(string = uRL.getProtocol()).equals("jar") && (n = ((String)(object = uRL.toString())).indexOf(":")) != -1) {
                    uRL = new URL("jar" + ((String)object).substring(n));
                }
                object = (JarURLConnection)uRL.openConnection();
                this.jarFile = ((JarURLConnection)object).getJarFile();
            }
            catch (Exception exception) {
                if (DEBUG) {
                    System.err.println("icurb jar error: " + exception);
                }
                throw new IllegalArgumentException("jar error: " + exception.getMessage());
            }
        }

        public void guide(URLVisitor uRLVisitor, boolean bl, boolean bl2) {
            block5: {
                try {
                    Enumeration<JarEntry> enumeration = this.jarFile.entries();
                    while (enumeration.hasMoreElements()) {
                        String string;
                        JarEntry jarEntry = enumeration.nextElement();
                        if (jarEntry.isDirectory() || !(string = jarEntry.getName()).startsWith(this.prefix)) continue;
                        int n = (string = string.substring(this.prefix.length())).lastIndexOf(47);
                        if (n != -1) {
                            if (!bl) continue;
                            if (bl2) {
                                string = string.substring(n + 1);
                            }
                        }
                        uRLVisitor.visit(string);
                    }
                }
                catch (Exception exception) {
                    if (!DEBUG) break block5;
                    System.err.println("icurb jar error: " + exception);
                }
            }
        }
    }

    private static class FileURLHandler
    extends URLHandler {
        File file;

        FileURLHandler(URL uRL) {
            try {
                this.file = new File(uRL.toURI());
            }
            catch (URISyntaxException uRISyntaxException) {
                // empty catch block
            }
            if (this.file == null || !this.file.exists()) {
                if (DEBUG) {
                    System.err.println("file does not exist - " + uRL.toString());
                }
                throw new IllegalArgumentException();
            }
        }

        public void guide(URLVisitor uRLVisitor, boolean bl, boolean bl2) {
            if (this.file.isDirectory()) {
                this.process(uRLVisitor, bl, bl2, "/", this.file.listFiles());
            } else {
                uRLVisitor.visit(this.file.getName());
            }
        }

        private void process(URLVisitor uRLVisitor, boolean bl, boolean bl2, String string, File[] fileArray) {
            for (int i = 0; i < fileArray.length; ++i) {
                File file = fileArray[i];
                if (file.isDirectory()) {
                    if (!bl) continue;
                    this.process(uRLVisitor, bl, bl2, string + file.getName() + '/', file.listFiles());
                    continue;
                }
                uRLVisitor.visit(bl2 ? file.getName() : string + file.getName());
            }
        }
    }
}

