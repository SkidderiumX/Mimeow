/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.simple;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

public class SimpleLogger
extends AbstractLogger {
    private static final char SPACE = ' ';
    private DateFormat dateFormatter;
    private Level level;
    private final boolean showDateTime;
    private final boolean showContextMap;
    private PrintStream stream;
    private final String logName;

    public SimpleLogger(String string, Level level, boolean bl, boolean bl2, boolean bl3, boolean bl4, String string2, MessageFactory messageFactory, PropertiesUtil propertiesUtil, PrintStream printStream) {
        super(string, messageFactory);
        int n;
        String string3 = propertiesUtil.getStringProperty("org.apache.logging.log4j.simplelog." + string + ".level");
        this.level = Level.toLevel(string3, level);
        this.logName = bl2 ? ((n = string.lastIndexOf(".")) > 0 && n < string.length() ? string.substring(n + 1) : string) : (bl ? string : null);
        this.showDateTime = bl3;
        this.showContextMap = bl4;
        this.stream = printStream;
        if (bl3) {
            try {
                this.dateFormatter = new SimpleDateFormat(string2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS zzz");
            }
        }
    }

    public void setStream(PrintStream printStream) {
        this.stream = printStream;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        if (level != null) {
            this.level = level;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void log(Marker marker, String string, Level level, Message message, Throwable throwable) {
        Object object;
        Object object2;
        Object[] objectArray;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.showDateTime) {
            objectArray = new Date();
            object2 = this.dateFormatter;
            synchronized (object2) {
                object = this.dateFormatter.format((Date)objectArray);
            }
            stringBuilder.append((String)object);
            stringBuilder.append(' ');
        }
        stringBuilder.append(level.toString());
        stringBuilder.append(' ');
        if (this.logName != null && this.logName.length() > 0) {
            stringBuilder.append(this.logName);
            stringBuilder.append(' ');
        }
        stringBuilder.append(message.getFormattedMessage());
        if (this.showContextMap && (objectArray = ThreadContext.getContext()).size() > 0) {
            stringBuilder.append(' ');
            stringBuilder.append(objectArray.toString());
            stringBuilder.append(' ');
        }
        objectArray = message.getParameters();
        object = throwable == null && objectArray != null && objectArray[objectArray.length - 1] instanceof Throwable ? (Throwable)objectArray[objectArray.length - 1] : throwable;
        if (object != null) {
            stringBuilder.append(' ');
            object2 = new ByteArrayOutputStream();
            ((Throwable)object).printStackTrace(new PrintStream((OutputStream)object2));
            stringBuilder.append(((ByteArrayOutputStream)object2).toString());
        }
        this.stream.println(stringBuilder.toString());
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, String string) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, String string, Throwable throwable) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, String string, Object ... objectArray) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, Object object, Throwable throwable) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, Message message, Throwable throwable) {
        return this.level.intLevel() >= level.intLevel();
    }
}

