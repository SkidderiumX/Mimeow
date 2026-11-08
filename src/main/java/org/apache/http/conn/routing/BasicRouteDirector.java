/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.routing;

import org.apache.http.annotation.Immutable;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.util.Args;

@Immutable
public class BasicRouteDirector
implements HttpRouteDirector {
    public int nextStep(RouteInfo routeInfo, RouteInfo routeInfo2) {
        Args.notNull(routeInfo, "Planned route");
        int n = -1;
        n = routeInfo2 == null || routeInfo2.getHopCount() < 1 ? this.firstStep(routeInfo) : (routeInfo.getHopCount() > 1 ? this.proxiedStep(routeInfo, routeInfo2) : this.directStep(routeInfo, routeInfo2));
        return n;
    }

    protected int firstStep(RouteInfo routeInfo) {
        return routeInfo.getHopCount() > 1 ? 2 : 1;
    }

    protected int directStep(RouteInfo routeInfo, RouteInfo routeInfo2) {
        if (routeInfo2.getHopCount() > 1) {
            return -1;
        }
        if (!routeInfo.getTargetHost().equals(routeInfo2.getTargetHost())) {
            return -1;
        }
        if (routeInfo.isSecure() != routeInfo2.isSecure()) {
            return -1;
        }
        if (routeInfo.getLocalAddress() != null && !routeInfo.getLocalAddress().equals(routeInfo2.getLocalAddress())) {
            return -1;
        }
        return 0;
    }

    protected int proxiedStep(RouteInfo routeInfo, RouteInfo routeInfo2) {
        int n;
        if (routeInfo2.getHopCount() <= 1) {
            return -1;
        }
        if (!routeInfo.getTargetHost().equals(routeInfo2.getTargetHost())) {
            return -1;
        }
        int n2 = routeInfo.getHopCount();
        if (n2 < (n = routeInfo2.getHopCount())) {
            return -1;
        }
        for (int i = 0; i < n - 1; ++i) {
            if (routeInfo.getHopTarget(i).equals(routeInfo2.getHopTarget(i))) continue;
            return -1;
        }
        if (n2 > n) {
            return 4;
        }
        if (routeInfo2.isTunnelled() && !routeInfo.isTunnelled() || routeInfo2.isLayered() && !routeInfo.isLayered()) {
            return -1;
        }
        if (routeInfo.isTunnelled() && !routeInfo2.isTunnelled()) {
            return 3;
        }
        if (routeInfo.isLayered() && !routeInfo2.isLayered()) {
            return 5;
        }
        if (routeInfo.isSecure() != routeInfo2.isSecure()) {
            return -1;
        }
        return 0;
    }
}

