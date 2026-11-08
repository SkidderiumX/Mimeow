/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.exception;

import com.mojang.realmsclient.client.RealmsError;
import net.minecraft.realms.RealmsScreen;

public class RealmsServiceException
extends Exception {
    public final int httpResultCode;
    public final String httpResponseContent;
    public final int errorCode;
    public final String errorMsg;

    public RealmsServiceException(int n, String string, RealmsError realmsError) {
        super(string);
        this.httpResultCode = n;
        this.httpResponseContent = string;
        this.errorCode = realmsError.getErrorCode();
        this.errorMsg = realmsError.getErrorMessage();
    }

    public RealmsServiceException(int n, String string, int n2, String string2) {
        super(string);
        this.httpResultCode = n;
        this.httpResponseContent = string;
        this.errorCode = n2;
        this.errorMsg = string2;
    }

    @Override
    public String toString() {
        if (this.errorCode != -1) {
            String string = "mco.errorMessage." + this.errorCode;
            String string2 = RealmsScreen.getLocalizedString(string);
            return (string2.equals(string) ? this.errorMsg : string2) + " - " + this.errorCode;
        }
        return "Realms (" + this.httpResultCode + ") " + this.httpResponseContent;
    }
}

