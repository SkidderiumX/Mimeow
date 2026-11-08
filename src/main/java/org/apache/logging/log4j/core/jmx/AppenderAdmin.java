/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.jmx;

import javax.management.ObjectName;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.helpers.Assert;
import org.apache.logging.log4j.core.jmx.AppenderAdminMBean;
import org.apache.logging.log4j.core.jmx.Server;

public class AppenderAdmin
implements AppenderAdminMBean {
    private final String contextName;
    private final Appender appender;
    private final ObjectName objectName;

    public AppenderAdmin(String string, Appender appender) {
        this.contextName = Assert.isNotNull(string, "contextName");
        this.appender = Assert.isNotNull(appender, "appender");
        try {
            String string2 = Server.escape(this.contextName);
            String string3 = Server.escape(appender.getName());
            String string4 = String.format("org.apache.logging.log4j2:type=LoggerContext,ctx=%s,sub=Appender,name=%s", string2, string3);
            this.objectName = new ObjectName(string4);
        }
        catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    public ObjectName getObjectName() {
        return this.objectName;
    }

    @Override
    public String getName() {
        return this.appender.getName();
    }

    @Override
    public String getLayout() {
        return String.valueOf(this.appender.getLayout());
    }

    @Override
    public boolean isExceptionSuppressed() {
        return this.appender.ignoreExceptions();
    }

    @Override
    public String getErrorHandler() {
        return String.valueOf(this.appender.getHandler());
    }
}

