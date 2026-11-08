/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public class BasicUserPrincipal
implements Principal,
Serializable {
    private static final long serialVersionUID = -2266305184969850467L;
    private final String username;

    public BasicUserPrincipal(String string) {
        Args.notNull(string, "User name");
        this.username = string;
    }

    public String getName() {
        return this.username;
    }

    public int hashCode() {
        int n = 17;
        n = LangUtils.hashCode(n, this.username);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof BasicUserPrincipal) {
            BasicUserPrincipal basicUserPrincipal = (BasicUserPrincipal)object;
            if (LangUtils.equals(this.username, basicUserPrincipal.username)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[principal: ");
        stringBuilder.append(this.username);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

