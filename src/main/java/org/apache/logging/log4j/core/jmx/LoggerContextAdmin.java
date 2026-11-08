/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.jmx;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.helpers.Assert;
import org.apache.logging.log4j.core.helpers.Charsets;
import org.apache.logging.log4j.core.helpers.Closer;
import org.apache.logging.log4j.core.jmx.LoggerContextAdminMBean;
import org.apache.logging.log4j.core.jmx.Server;
import org.apache.logging.log4j.status.StatusLogger;

public class LoggerContextAdmin
extends NotificationBroadcasterSupport
implements LoggerContextAdminMBean,
PropertyChangeListener {
    private static final int PAGE = 4096;
    private static final int TEXT_BUFFER = 65536;
    private static final int BUFFER_SIZE = 2048;
    private static final StatusLogger LOGGER = StatusLogger.getLogger();
    private final AtomicLong sequenceNo = new AtomicLong();
    private final ObjectName objectName;
    private final LoggerContext loggerContext;
    private String customConfigText;

    public LoggerContextAdmin(LoggerContext loggerContext, Executor executor) {
        super(executor, LoggerContextAdmin.createNotificationInfo());
        this.loggerContext = Assert.isNotNull(loggerContext, "loggerContext");
        try {
            String string = Server.escape(loggerContext.getName());
            String string2 = String.format("org.apache.logging.log4j2:type=LoggerContext,ctx=%s", string);
            this.objectName = new ObjectName(string2);
        }
        catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
        loggerContext.addPropertyChangeListener(this);
    }

    private static MBeanNotificationInfo createNotificationInfo() {
        String[] stringArray = new String[]{"com.apache.logging.log4j.core.jmx.config.reconfigured"};
        String string = Notification.class.getName();
        String string2 = "Configuration reconfigured";
        return new MBeanNotificationInfo(stringArray, string, "Configuration reconfigured");
    }

    @Override
    public String getStatus() {
        return this.loggerContext.getStatus().toString();
    }

    @Override
    public String getName() {
        return this.loggerContext.getName();
    }

    private Configuration getConfig() {
        return this.loggerContext.getConfiguration();
    }

    @Override
    public String getConfigLocationURI() {
        if (this.loggerContext.getConfigLocation() != null) {
            return String.valueOf(this.loggerContext.getConfigLocation());
        }
        if (this.getConfigName() != null) {
            return String.valueOf(new File(this.getConfigName()).toURI());
        }
        return "";
    }

    @Override
    public void setConfigLocationURI(String string) throws URISyntaxException, IOException {
        LOGGER.debug("---------");
        LOGGER.debug("Remote request to reconfigure using location " + string);
        URI uRI = new URI(string);
        uRI.toURL().openStream().close();
        this.loggerContext.setConfigLocation(uRI);
        LOGGER.debug("Completed remote request to reconfigure.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!"config".equals(propertyChangeEvent.getPropertyName())) {
            return;
        }
        if (this.loggerContext.getConfiguration().getName() != null) {
            this.customConfigText = null;
        }
        Notification notification = new Notification("com.apache.logging.log4j.core.jmx.config.reconfigured", this.getObjectName(), this.nextSeqNo(), this.now(), null);
        this.sendNotification(notification);
    }

    @Override
    public String getConfigText() throws IOException {
        return this.getConfigText(Charsets.UTF_8.name());
    }

    @Override
    public String getConfigText(String string) throws IOException {
        if (this.customConfigText != null) {
            return this.customConfigText;
        }
        try {
            Charset charset = Charset.forName(string);
            return this.readContents(new URI(this.getConfigLocationURI()), charset);
        }
        catch (Exception exception) {
            StringWriter stringWriter = new StringWriter(2048);
            exception.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
    }

    @Override
    public void setConfigText(String string, String string2) {
        String string3 = this.customConfigText;
        this.customConfigText = Assert.isNotNull(string, "configText");
        LOGGER.debug("---------");
        LOGGER.debug("Remote request to reconfigure from config text.");
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes(string2));
            ConfigurationFactory.ConfigurationSource configurationSource = new ConfigurationFactory.ConfigurationSource(byteArrayInputStream);
            Configuration configuration = ConfigurationFactory.getInstance().getConfiguration(configurationSource);
            this.loggerContext.start(configuration);
            LOGGER.debug("Completed remote request to reconfigure from config text.");
        }
        catch (Exception exception) {
            this.customConfigText = string3;
            String string4 = "Could not reconfigure from config text";
            LOGGER.error("Could not reconfigure from config text", (Throwable)exception);
            throw new IllegalArgumentException("Could not reconfigure from config text", exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String readContents(URI uRI, Charset charset) throws IOException {
        String string;
        InputStream inputStream2 = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStream2 = uRI.toURL().openStream();
            inputStreamReader = new InputStreamReader(inputStream2, charset);
            StringBuilder stringBuilder = new StringBuilder(65536);
            char[] cArray = new char[4096];
            int n = -1;
            while ((n = inputStreamReader.read(cArray)) >= 0) {
                stringBuilder.append(cArray, 0, n);
            }
            string = stringBuilder.toString();
        }
        catch (Throwable throwable) {
            Closer.closeSilent(inputStream2);
            Closer.closeSilent(inputStreamReader);
            throw throwable;
        }
        Closer.closeSilent(inputStream2);
        Closer.closeSilent(inputStreamReader);
        return string;
    }

    @Override
    public String getConfigName() {
        return this.getConfig().getName();
    }

    @Override
    public String getConfigClassName() {
        return this.getConfig().getClass().getName();
    }

    @Override
    public String getConfigFilter() {
        return String.valueOf(this.getConfig().getFilter());
    }

    @Override
    public String getConfigMonitorClassName() {
        return this.getConfig().getConfigurationMonitor().getClass().getName();
    }

    @Override
    public Map<String, String> getConfigProperties() {
        return this.getConfig().getProperties();
    }

    public ObjectName getObjectName() {
        return this.objectName;
    }

    private long nextSeqNo() {
        return this.sequenceNo.getAndIncrement();
    }

    private long now() {
        return System.currentTimeMillis();
    }
}

