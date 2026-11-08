/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public class NTUserPrincipal
implements Principal,
Serializable {
    private static final long serialVersionUID = -6870169797924406894L;
    private final String username;
    private final String domain;
    private final String ntname;

    public NTUserPrincipal(String string, String string2) {
        Args.notNull(string2, "User name");
        this.username = string2;
        this.domain = string != null ? string.toUpperCase(Locale.ENGLISH) : null;
        if (this.domain != null && this.domain.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.domain);
            stringBuilder.append('\\');
            stringBuilder.append(this.username);
            this.ntname = stringBuilder.toString();
        } else {
            this.ntname = this.username;
        }
    }

    public String getName() {
        return this.ntname;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int n = 17;
        n = LangUtils.hashCode(n, this.username);
        n = LangUtils.hashCode(n, this.domain);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof NTUserPrincipal) {
            NTUserPrincipal nTUserPrincipal = (NTUserPrincipal)object;
            if (LangUtils.equals(this.username, nTUserPrincipal.username) && LangUtils.equals(this.domain, nTUserPrincipal.domain)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.ntname;
    }
}

