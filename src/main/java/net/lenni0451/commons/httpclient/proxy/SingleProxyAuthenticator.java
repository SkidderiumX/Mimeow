/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.proxy;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class SingleProxyAuthenticator
extends Authenticator {
    private final PasswordAuthentication passwordAuthentication;

    public SingleProxyAuthenticator(String string, String string2) {
        this.passwordAuthentication = new PasswordAuthentication(string, string2.toCharArray());
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return this.passwordAuthentication;
    }
}

