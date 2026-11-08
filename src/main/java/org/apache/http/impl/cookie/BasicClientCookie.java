/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicClientCookie
implements SetCookie,
ClientCookie,
Cloneable,
Serializable {
    private static final long serialVersionUID = -3869795591041535538L;
    private final String name;
    private Map<String, String> attribs;
    private String value;
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private boolean isSecure;
    private int cookieVersion;

    public BasicClientCookie(String string, String string2) {
        Args.notNull(string, "Name");
        this.name = string;
        this.attribs = new HashMap<String, String>();
        this.value = string2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    public String getComment() {
        return this.cookieComment;
    }

    public void setComment(String string) {
        this.cookieComment = string;
    }

    public String getCommentURL() {
        return null;
    }

    public Date getExpiryDate() {
        return this.cookieExpiryDate;
    }

    public void setExpiryDate(Date date) {
        this.cookieExpiryDate = date;
    }

    public boolean isPersistent() {
        return null != this.cookieExpiryDate;
    }

    public String getDomain() {
        return this.cookieDomain;
    }

    public void setDomain(String string) {
        this.cookieDomain = string != null ? string.toLowerCase(Locale.ENGLISH) : null;
    }

    public String getPath() {
        return this.cookiePath;
    }

    public void setPath(String string) {
        this.cookiePath = string;
    }

    public boolean isSecure() {
        return this.isSecure;
    }

    public void setSecure(boolean bl) {
        this.isSecure = bl;
    }

    public int[] getPorts() {
        return null;
    }

    public int getVersion() {
        return this.cookieVersion;
    }

    public void setVersion(int n) {
        this.cookieVersion = n;
    }

    public boolean isExpired(Date date) {
        Args.notNull(date, "Date");
        return this.cookieExpiryDate != null && this.cookieExpiryDate.getTime() <= date.getTime();
    }

    public void setAttribute(String string, String string2) {
        this.attribs.put(string, string2);
    }

    public String getAttribute(String string) {
        return this.attribs.get(string);
    }

    public boolean containsAttribute(String string) {
        return this.attribs.get(string) != null;
    }

    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie basicClientCookie = (BasicClientCookie)super.clone();
        basicClientCookie.attribs = new HashMap<String, String>(this.attribs);
        return basicClientCookie;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[version: ");
        stringBuilder.append(Integer.toString(this.cookieVersion));
        stringBuilder.append("]");
        stringBuilder.append("[name: ");
        stringBuilder.append(this.name);
        stringBuilder.append("]");
        stringBuilder.append("[value: ");
        stringBuilder.append(this.value);
        stringBuilder.append("]");
        stringBuilder.append("[domain: ");
        stringBuilder.append(this.cookieDomain);
        stringBuilder.append("]");
        stringBuilder.append("[path: ");
        stringBuilder.append(this.cookiePath);
        stringBuilder.append("]");
        stringBuilder.append("[expiry: ");
        stringBuilder.append(this.cookieExpiryDate);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

