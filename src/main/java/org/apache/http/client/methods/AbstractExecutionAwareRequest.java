/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.methods;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;

public abstract class AbstractExecutionAwareRequest
extends AbstractHttpMessage
implements HttpExecutionAware,
AbortableHttpRequest,
Cloneable,
HttpRequest {
    private Lock abortLock = new ReentrantLock();
    private volatile boolean aborted;
    private volatile Cancellable cancellable;

    protected AbstractExecutionAwareRequest() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Deprecated
    public void setConnectionRequest(final ClientConnectionRequest clientConnectionRequest) {
        if (this.aborted) {
            return;
        }
        this.abortLock.lock();
        try {
            this.cancellable = new Cancellable(){

                public boolean cancel() {
                    clientConnectionRequest.abortRequest();
                    return true;
                }
            };
        }
        finally {
            this.abortLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Deprecated
    public void setReleaseTrigger(final ConnectionReleaseTrigger connectionReleaseTrigger) {
        if (this.aborted) {
            return;
        }
        this.abortLock.lock();
        try {
            this.cancellable = new Cancellable(){

                public boolean cancel() {
                    try {
                        connectionReleaseTrigger.abortConnection();
                        return true;
                    }
                    catch (IOException iOException) {
                        return false;
                    }
                }
            };
        }
        finally {
            this.abortLock.unlock();
        }
    }

    private void cancelExecution() {
        if (this.cancellable != null) {
            this.cancellable.cancel();
            this.cancellable = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abort() {
        if (this.aborted) {
            return;
        }
        this.abortLock.lock();
        try {
            this.aborted = true;
            this.cancelExecution();
        }
        finally {
            this.abortLock.unlock();
        }
    }

    public boolean isAborted() {
        return this.aborted;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setCancellable(Cancellable cancellable) {
        if (this.aborted) {
            return;
        }
        this.abortLock.lock();
        try {
            this.cancellable = cancellable;
        }
        finally {
            this.abortLock.unlock();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractExecutionAwareRequest abstractExecutionAwareRequest = (AbstractExecutionAwareRequest)super.clone();
        abstractExecutionAwareRequest.headergroup = CloneUtils.cloneObject(this.headergroup);
        abstractExecutionAwareRequest.params = CloneUtils.cloneObject(this.params);
        abstractExecutionAwareRequest.abortLock = new ReentrantLock();
        abstractExecutionAwareRequest.cancellable = null;
        abstractExecutionAwareRequest.aborted = false;
        return abstractExecutionAwareRequest;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void completed() {
        this.abortLock.lock();
        try {
            this.cancellable = null;
        }
        finally {
            this.abortLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.abortLock.lock();
        try {
            this.cancelExecution();
            this.aborted = false;
        }
        finally {
            this.abortLock.unlock();
        }
    }
}

