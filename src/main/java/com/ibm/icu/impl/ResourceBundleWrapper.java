/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ResourceBundleWrapper
extends UResourceBundle {
    private ResourceBundle bundle = null;
    private String localeID = null;
    private String baseName = null;
    private List<String> keys = null;
    private static final boolean DEBUG = ICUDebug.enabled("resourceBundleWrapper");

    private ResourceBundleWrapper(ResourceBundle resourceBundle) {
        this.bundle = resourceBundle;
    }

    @Override
    protected void setLoadingStatus(int n) {
    }

    @Override
    protected Object handleGetObject(String string) {
        Object object = null;
        for (ResourceBundleWrapper resourceBundleWrapper = this; resourceBundleWrapper != null; resourceBundleWrapper = (ResourceBundleWrapper)resourceBundleWrapper.getParent()) {
            try {
                object = resourceBundleWrapper.bundle.getObject(string);
                break;
            }
            catch (MissingResourceException missingResourceException) {
                continue;
            }
        }
        if (object == null) {
            throw new MissingResourceException("Can't find resource for bundle " + this.baseName + ", key " + string, this.getClass().getName(), string);
        }
        return object;
    }

    @Override
    public Enumeration<String> getKeys() {
        return Collections.enumeration(this.keys);
    }

    private void initKeysVector() {
        this.keys = new ArrayList<String>();
        for (ResourceBundleWrapper resourceBundleWrapper = this; resourceBundleWrapper != null; resourceBundleWrapper = (ResourceBundleWrapper)resourceBundleWrapper.getParent()) {
            Enumeration<String> enumeration = resourceBundleWrapper.bundle.getKeys();
            while (enumeration.hasMoreElements()) {
                String string = enumeration.nextElement();
                if (this.keys.contains(string)) continue;
                this.keys.add(string);
            }
        }
    }

    @Override
    protected String getLocaleID() {
        return this.localeID;
    }

    @Override
    protected String getBaseName() {
        return this.bundle.getClass().getName().replace('.', '/');
    }

    @Override
    public ULocale getULocale() {
        return new ULocale(this.localeID);
    }

    @Override
    public UResourceBundle getParent() {
        return (UResourceBundle)this.parent;
    }

    public static UResourceBundle getBundleInstance(String string, String string2, ClassLoader classLoader, boolean bl) {
        UResourceBundle uResourceBundle = ResourceBundleWrapper.instantiateBundle(string, string2, classLoader, bl);
        if (uResourceBundle == null) {
            String string3 = "_";
            if (string.indexOf(47) >= 0) {
                string3 = "/";
            }
            throw new MissingResourceException("Could not find the bundle " + string + string3 + string2, "", "");
        }
        return uResourceBundle;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static synchronized UResourceBundle instantiateBundle(String string, String string2, ClassLoader classLoader, boolean bl) {
        ResourceBundleWrapper resourceBundleWrapper;
        if (classLoader == null) {
            classLoader = Utility.getFallbackClassLoader();
        }
        final ClassLoader classLoader2 = classLoader;
        String string3 = string;
        ULocale uLocale = ULocale.getDefault();
        if (string2.length() != 0) {
            string3 = string3 + "_" + string2;
        }
        if ((resourceBundleWrapper = (ResourceBundleWrapper)ResourceBundleWrapper.loadFromCache(classLoader2, string3, uLocale)) == null) {
            block38: {
                Object object;
                Object object2;
                boolean bl2;
                ResourceBundleWrapper resourceBundleWrapper2;
                block36: {
                    resourceBundleWrapper2 = null;
                    int n = string2.lastIndexOf(95);
                    bl2 = false;
                    if (n != -1) {
                        object2 = string2.substring(0, n);
                        resourceBundleWrapper2 = (ResourceBundleWrapper)ResourceBundleWrapper.loadFromCache(classLoader2, string + "_" + (String)object2, uLocale);
                        if (resourceBundleWrapper2 == null) {
                            resourceBundleWrapper2 = (ResourceBundleWrapper)ResourceBundleWrapper.instantiateBundle(string, (String)object2, classLoader2, bl);
                        }
                    } else if (string2.length() > 0 && (resourceBundleWrapper2 = (ResourceBundleWrapper)ResourceBundleWrapper.loadFromCache(classLoader2, string, uLocale)) == null) {
                        resourceBundleWrapper2 = (ResourceBundleWrapper)ResourceBundleWrapper.instantiateBundle(string, "", classLoader2, bl);
                    }
                    try {
                        object2 = classLoader2.loadClass(string3).asSubclass(ResourceBundle.class);
                        object = (ResourceBundle)((Class)object2).newInstance();
                        resourceBundleWrapper = new ResourceBundleWrapper((ResourceBundle)object);
                        if (resourceBundleWrapper2 != null) {
                            resourceBundleWrapper.setParent(resourceBundleWrapper2);
                        }
                        resourceBundleWrapper.baseName = string;
                        resourceBundleWrapper.localeID = string2;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        bl2 = true;
                    }
                    catch (NoClassDefFoundError noClassDefFoundError) {
                        bl2 = true;
                    }
                    catch (Exception exception) {
                        if (DEBUG) {
                            System.out.println("failure");
                        }
                        if (!DEBUG) break block36;
                        System.out.println(exception);
                    }
                }
                if (bl2) {
                    try {
                        object2 = string3.replace('.', '/') + ".properties";
                        object = AccessController.doPrivileged(new PrivilegedAction<InputStream>((String)object2){
                            final /* synthetic */ String val$resName;
                            {
                                this.val$resName = string;
                            }

                            @Override
                            public InputStream run() {
                                if (classLoader2 != null) {
                                    return classLoader2.getResourceAsStream(this.val$resName);
                                }
                                return ClassLoader.getSystemResourceAsStream(this.val$resName);
                            }
                        });
                        if (object != null) {
                            object = new BufferedInputStream((InputStream)object);
                            try {
                                resourceBundleWrapper = new ResourceBundleWrapper(new PropertyResourceBundle((InputStream)object));
                                if (resourceBundleWrapper2 != null) {
                                    resourceBundleWrapper.setParent(resourceBundleWrapper2);
                                }
                                resourceBundleWrapper.baseName = string;
                                resourceBundleWrapper.localeID = string2;
                            }
                            catch (Exception exception) {
                            }
                            finally {
                                try {
                                    ((InputStream)object).close();
                                }
                                catch (Exception exception) {}
                            }
                        }
                        if (resourceBundleWrapper == null) {
                            String string4 = uLocale.toString();
                            if (string2.length() > 0 && string2.indexOf(95) < 0 && string4.indexOf(string2) == -1 && (resourceBundleWrapper = (ResourceBundleWrapper)ResourceBundleWrapper.loadFromCache(classLoader2, string + "_" + string4, uLocale)) == null) {
                                resourceBundleWrapper = (ResourceBundleWrapper)ResourceBundleWrapper.instantiateBundle(string, string4, classLoader2, bl);
                            }
                        }
                        if (resourceBundleWrapper == null) {
                            resourceBundleWrapper = resourceBundleWrapper2;
                        }
                    }
                    catch (Exception exception) {
                        if (DEBUG) {
                            System.out.println("failure");
                        }
                        if (!DEBUG) break block38;
                        System.out.println(exception);
                    }
                }
            }
            resourceBundleWrapper = (ResourceBundleWrapper)ResourceBundleWrapper.addToCache(classLoader2, string3, uLocale, resourceBundleWrapper);
        }
        if (resourceBundleWrapper != null) {
            resourceBundleWrapper.initKeysVector();
        } else if (DEBUG) {
            System.out.println("Returning null for " + string + "_" + string2);
        }
        return resourceBundleWrapper;
    }
}

