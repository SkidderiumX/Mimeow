/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net.ssl;

import org.apache.logging.log4j.core.net.ssl.StoreConfigurationException;
import org.apache.logging.log4j.status.StatusLogger;

public class StoreConfiguration {
    protected static final StatusLogger LOGGER = StatusLogger.getLogger();
    private String location;
    private String password;

    public StoreConfiguration(String string, String string2) {
        this.location = string;
        this.password = string2;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String string) {
        this.location = string;
    }

    public String getPassword() {
        return this.password;
    }

    public char[] getPasswordAsCharArray() {
        if (this.password == null) {
            return null;
        }
        return this.password.toCharArray();
    }

    public void setPassword(String string) {
        this.password = string;
    }

    public boolean equals(StoreConfiguration storeConfiguration) {
        if (storeConfiguration == null) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = false;
        if (this.location != null) {
            bl = this.location.equals(storeConfiguration.location);
        } else {
            boolean bl3 = bl = this.location == storeConfiguration.location;
        }
        bl2 = this.password != null ? this.password.equals(storeConfiguration.password) : this.password == storeConfiguration.password;
        return bl && bl2;
    }

    protected void load() throws StoreConfigurationException {
    }
}

