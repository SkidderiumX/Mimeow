/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.params;

import org.apache.http.annotation.ThreadSafe;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

@Deprecated
@ThreadSafe
public class SyncBasicHttpParams
extends BasicHttpParams {
    private static final long serialVersionUID = 5387834869062660642L;

    public synchronized boolean removeParameter(String string) {
        return super.removeParameter(string);
    }

    public synchronized HttpParams setParameter(String string, Object object) {
        return super.setParameter(string, object);
    }

    public synchronized Object getParameter(String string) {
        return super.getParameter(string);
    }

    public synchronized boolean isParameterSet(String string) {
        return super.isParameterSet(string);
    }

    public synchronized boolean isParameterSetLocally(String string) {
        return super.isParameterSetLocally(string);
    }

    public synchronized void setParameters(String[] stringArray, Object object) {
        super.setParameters(stringArray, object);
    }

    public synchronized void clear() {
        super.clear();
    }

    public synchronized Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

