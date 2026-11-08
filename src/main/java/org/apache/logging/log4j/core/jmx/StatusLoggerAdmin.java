/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.jmx;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.jmx.StatusLoggerAdminMBean;
import org.apache.logging.log4j.status.StatusData;
import org.apache.logging.log4j.status.StatusListener;
import org.apache.logging.log4j.status.StatusLogger;

public class StatusLoggerAdmin
extends NotificationBroadcasterSupport
implements StatusListener,
StatusLoggerAdminMBean {
    private final AtomicLong sequenceNo = new AtomicLong();
    private final ObjectName objectName;
    private Level level = Level.WARN;

    public StatusLoggerAdmin(Executor executor) {
        super(executor, StatusLoggerAdmin.createNotificationInfo());
        try {
            this.objectName = new ObjectName("org.apache.logging.log4j2:type=StatusLogger");
        }
        catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
        StatusLogger.getLogger().registerListener(this);
    }

    private static MBeanNotificationInfo createNotificationInfo() {
        String[] stringArray = new String[]{"com.apache.logging.log4j.core.jmx.statuslogger.data", "com.apache.logging.log4j.core.jmx.statuslogger.message"};
        String string = Notification.class.getName();
        String string2 = "StatusLogger has logged an event";
        return new MBeanNotificationInfo(stringArray, string, "StatusLogger has logged an event");
    }

    @Override
    public String[] getStatusDataHistory() {
        List<StatusData> list = this.getStatusData();
        String[] stringArray = new String[list.size()];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = list.get(i).getFormattedStatus();
        }
        return stringArray;
    }

    @Override
    public List<StatusData> getStatusData() {
        return StatusLogger.getLogger().getStatusData();
    }

    @Override
    public String getLevel() {
        return this.level.name();
    }

    @Override
    public Level getStatusLevel() {
        return this.level;
    }

    @Override
    public void setLevel(String string) {
        this.level = Level.toLevel(string, Level.ERROR);
    }

    @Override
    public void log(StatusData statusData) {
        Notification notification = new Notification("com.apache.logging.log4j.core.jmx.statuslogger.message", this.getObjectName(), this.nextSeqNo(), this.now(), statusData.getFormattedStatus());
        this.sendNotification(notification);
        Notification notification2 = new Notification("com.apache.logging.log4j.core.jmx.statuslogger.data", (Object)this.getObjectName(), this.nextSeqNo(), this.now());
        notification2.setUserData(statusData);
        this.sendNotification(notification2);
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

