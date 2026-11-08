/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.jmx;

import java.util.List;
import javax.management.ObjectName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.helpers.Assert;
import org.apache.logging.log4j.core.jmx.LoggerConfigAdminMBean;
import org.apache.logging.log4j.core.jmx.Server;

public class LoggerConfigAdmin
implements LoggerConfigAdminMBean {
    private final String contextName;
    private final LoggerConfig loggerConfig;
    private final ObjectName objectName;

    public LoggerConfigAdmin(String string, LoggerConfig loggerConfig) {
        this.contextName = Assert.isNotNull(string, "contextName");
        this.loggerConfig = Assert.isNotNull(loggerConfig, "loggerConfig");
        try {
            String string2 = Server.escape(this.contextName);
            String string3 = Server.escape(loggerConfig.getName());
            String string4 = String.format("org.apache.logging.log4j2:type=LoggerContext,ctx=%s,sub=LoggerConfig,name=%s", string2, string3);
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
        return this.loggerConfig.getName();
    }

    @Override
    public String getLevel() {
        return this.loggerConfig.getLevel().name();
    }

    @Override
    public void setLevel(String string) {
        this.loggerConfig.setLevel(Level.valueOf(string));
    }

    @Override
    public boolean isAdditive() {
        return this.loggerConfig.isAdditive();
    }

    @Override
    public void setAdditive(boolean bl) {
        this.loggerConfig.setAdditive(bl);
    }

    @Override
    public boolean isIncludeLocation() {
        return this.loggerConfig.isIncludeLocation();
    }

    @Override
    public String getFilter() {
        return String.valueOf(this.loggerConfig.getFilter());
    }

    @Override
    public String[] getAppenderRefs() {
        List<AppenderRef> list = this.loggerConfig.getAppenderRefs();
        String[] stringArray = new String[list.size()];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = list.get(i).getRef();
        }
        return stringArray;
    }
}

