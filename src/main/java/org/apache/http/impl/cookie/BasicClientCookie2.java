/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.impl.cookie.BasicClientCookie;

@NotThreadSafe
public class BasicClientCookie2
extends BasicClientCookie
implements SetCookie2 {
    private static final long serialVersionUID = -7744598295706617057L;
    private String commentURL;
    private int[] ports;
    private boolean discard;

    public BasicClientCookie2(String string, String string2) {
        super(string, string2);
    }

    public int[] getPorts() {
        return this.ports;
    }

    public void setPorts(int[] nArray) {
        this.ports = nArray;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public void setCommentURL(String string) {
        this.commentURL = string;
    }

    public void setDiscard(boolean bl) {
        this.discard = bl;
    }

    public boolean isPersistent() {
        return !this.discard && super.isPersistent();
    }

    public boolean isExpired(Date date) {
        return this.discard || super.isExpired(date);
    }

    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie2 basicClientCookie2 = (BasicClientCookie2)super.clone();
        if (this.ports != null) {
            basicClientCookie2.ports = (int[])this.ports.clone();
        }
        return basicClientCookie2;
    }
}

