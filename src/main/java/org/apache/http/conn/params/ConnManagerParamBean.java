/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.params;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
@NotThreadSafe
public class ConnManagerParamBean
extends HttpAbstractParamBean {
    public ConnManagerParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setTimeout(long l) {
        this.params.setLongParameter("http.conn-manager.timeout", l);
    }

    public void setMaxTotalConnections(int n) {
        this.params.setIntParameter("http.conn-manager.max-total", n);
    }

    public void setConnectionsPerRoute(ConnPerRouteBean connPerRouteBean) {
        this.params.setParameter("http.conn-manager.max-per-route", connPerRouteBean);
    }
}

