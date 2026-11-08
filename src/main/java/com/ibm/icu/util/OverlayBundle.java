/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class OverlayBundle
extends ResourceBundle {
    private String[] baseNames;
    private Locale locale;
    private ResourceBundle[] bundles;

    public OverlayBundle(String[] stringArray, Locale locale) {
        this.baseNames = stringArray;
        this.locale = locale;
        this.bundles = new ResourceBundle[stringArray.length];
    }

    @Override
    protected Object handleGetObject(String string) throws MissingResourceException {
        Object object = null;
        for (int i = 0; i < this.bundles.length; ++i) {
            block3: {
                this.load(i);
                try {
                    object = this.bundles[i].getObject(string);
                }
                catch (MissingResourceException missingResourceException) {
                    if (i != this.bundles.length - 1) break block3;
                    throw missingResourceException;
                }
            }
            if (object != null) break;
        }
        return object;
    }

    @Override
    public Enumeration<String> getKeys() {
        int n = this.bundles.length - 1;
        this.load(n);
        return this.bundles[n].getKeys();
    }

    private void load(int n) throws MissingResourceException {
        block9: {
            if (this.bundles[n] == null) {
                boolean bl = false;
                try {
                    this.bundles[n] = ResourceBundle.getBundle(this.baseNames[n], this.locale);
                    if (this.bundles[n].getLocale().equals(this.locale)) {
                        return;
                    }
                    if (this.locale.getCountry().length() != 0 && n != this.bundles.length - 1) {
                        bl = true;
                    }
                }
                catch (MissingResourceException missingResourceException) {
                    if (n == this.bundles.length - 1) {
                        throw missingResourceException;
                    }
                    bl = true;
                }
                if (bl) {
                    Locale locale = new Locale("xx", this.locale.getCountry(), this.locale.getVariant());
                    try {
                        this.bundles[n] = ResourceBundle.getBundle(this.baseNames[n], locale);
                    }
                    catch (MissingResourceException missingResourceException) {
                        if (this.bundles[n] != null) break block9;
                        throw missingResourceException;
                    }
                }
            }
        }
    }
}

