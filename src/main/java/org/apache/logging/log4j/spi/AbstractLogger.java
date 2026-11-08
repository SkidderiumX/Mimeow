/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.spi;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.ParameterizedMessageFactory;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.logging.log4j.status.StatusLogger;

public abstract class AbstractLogger
implements Logger {
    public static final Marker FLOW_MARKER = MarkerManager.getMarker("FLOW");
    public static final Marker ENTRY_MARKER = MarkerManager.getMarker("ENTRY", FLOW_MARKER);
    public static final Marker EXIT_MARKER = MarkerManager.getMarker("EXIT", FLOW_MARKER);
    public static final Marker EXCEPTION_MARKER = MarkerManager.getMarker("EXCEPTION");
    public static final Marker THROWING_MARKER = MarkerManager.getMarker("THROWING", EXCEPTION_MARKER);
    public static final Marker CATCHING_MARKER = MarkerManager.getMarker("CATCHING", EXCEPTION_MARKER);
    public static final Class<? extends MessageFactory> DEFAULT_MESSAGE_FACTORY_CLASS = ParameterizedMessageFactory.class;
    private static final String FQCN = AbstractLogger.class.getName();
    private static final String THROWING = "throwing";
    private static final String CATCHING = "catching";
    private final String name;
    private final MessageFactory messageFactory;

    public AbstractLogger() {
        this.name = this.getClass().getName();
        this.messageFactory = this.createDefaultMessageFactory();
    }

    public AbstractLogger(String string) {
        this.name = string;
        this.messageFactory = this.createDefaultMessageFactory();
    }

    public AbstractLogger(String string, MessageFactory messageFactory) {
        this.name = string;
        this.messageFactory = messageFactory == null ? this.createDefaultMessageFactory() : messageFactory;
    }

    public static void checkMessageFactory(Logger logger, MessageFactory messageFactory) {
        String string = logger.getName();
        MessageFactory messageFactory2 = logger.getMessageFactory();
        if (messageFactory != null && !messageFactory2.equals(messageFactory)) {
            StatusLogger.getLogger().warn("The Logger {} was created with the message factory {} and is now requested with the message factory {}, which may create log events with unexpected formatting.", string, messageFactory2, messageFactory);
        } else if (messageFactory == null && !messageFactory2.getClass().equals(DEFAULT_MESSAGE_FACTORY_CLASS)) {
            StatusLogger.getLogger().warn("The Logger {} was created with the message factory {} and is now requested with a null message factory (defaults to {}), which may create log events with unexpected formatting.", string, messageFactory2, DEFAULT_MESSAGE_FACTORY_CLASS.getName());
        }
    }

    @Override
    public void catching(Level level, Throwable throwable) {
        this.catching(FQCN, level, throwable);
    }

    @Override
    public void catching(Throwable throwable) {
        this.catching(FQCN, Level.ERROR, throwable);
    }

    protected void catching(String string, Level level, Throwable throwable) {
        if (this.isEnabled(level, CATCHING_MARKER, (Object)null, null)) {
            this.log(CATCHING_MARKER, string, level, this.messageFactory.newMessage(CATCHING), throwable);
        }
    }

    private MessageFactory createDefaultMessageFactory() {
        try {
            return DEFAULT_MESSAGE_FACTORY_CLASS.newInstance();
        }
        catch (InstantiationException instantiationException) {
            throw new IllegalStateException(instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
    }

    @Override
    public void debug(Marker marker, Message message) {
        if (this.isEnabled(Level.DEBUG, marker, message, null)) {
            this.log(marker, FQCN, Level.DEBUG, message, null);
        }
    }

    @Override
    public void debug(Marker marker, Message message, Throwable throwable) {
        if (this.isEnabled(Level.DEBUG, marker, message, throwable)) {
            this.log(marker, FQCN, Level.DEBUG, message, throwable);
        }
    }

    @Override
    public void debug(Marker marker, Object object) {
        if (this.isEnabled(Level.DEBUG, marker, object, null)) {
            this.log(marker, FQCN, Level.DEBUG, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void debug(Marker marker, Object object, Throwable throwable) {
        if (this.isEnabled(Level.DEBUG, marker, object, throwable)) {
            this.log(marker, FQCN, Level.DEBUG, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void debug(Marker marker, String string) {
        if (this.isEnabled(Level.DEBUG, marker, string)) {
            this.log(marker, FQCN, Level.DEBUG, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void debug(Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(Level.DEBUG, marker, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(marker, FQCN, Level.DEBUG, message, message.getThrowable());
        }
    }

    @Override
    public void debug(Marker marker, String string, Throwable throwable) {
        if (this.isEnabled(Level.DEBUG, marker, string, throwable)) {
            this.log(marker, FQCN, Level.DEBUG, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void debug(Message message) {
        if (this.isEnabled(Level.DEBUG, null, message, null)) {
            this.log(null, FQCN, Level.DEBUG, message, null);
        }
    }

    @Override
    public void debug(Message message, Throwable throwable) {
        if (this.isEnabled(Level.DEBUG, null, message, throwable)) {
            this.log(null, FQCN, Level.DEBUG, message, throwable);
        }
    }

    @Override
    public void debug(Object object) {
        if (this.isEnabled(Level.DEBUG, null, object, null)) {
            this.log(null, FQCN, Level.DEBUG, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void debug(Object object, Throwable throwable) {
        if (this.isEnabled(Level.DEBUG, null, object, throwable)) {
            this.log(null, FQCN, Level.DEBUG, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void debug(String string) {
        if (this.isEnabled(Level.DEBUG, null, string)) {
            this.log(null, FQCN, Level.DEBUG, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void debug(String string, Object ... objectArray) {
        if (this.isEnabled(Level.DEBUG, null, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(null, FQCN, Level.DEBUG, message, message.getThrowable());
        }
    }

    @Override
    public void debug(String string, Throwable throwable) {
        if (this.isEnabled(Level.DEBUG, (Marker)null, string, throwable)) {
            this.log(null, FQCN, Level.DEBUG, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void entry() {
        this.entry(FQCN, new Object[0]);
    }

    @Override
    public void entry(Object ... objectArray) {
        this.entry(FQCN, objectArray);
    }

    protected void entry(String string, Object ... objectArray) {
        if (this.isEnabled(Level.TRACE, ENTRY_MARKER, (Object)null, null)) {
            this.log(ENTRY_MARKER, string, Level.TRACE, this.entryMsg(objectArray.length, objectArray), null);
        }
    }

    private Message entryMsg(int n, Object ... objectArray) {
        if (n == 0) {
            return this.messageFactory.newMessage("entry");
        }
        StringBuilder stringBuilder = new StringBuilder("entry params(");
        int n2 = 0;
        for (Object object : objectArray) {
            if (object != null) {
                stringBuilder.append(object.toString());
            } else {
                stringBuilder.append("null");
            }
            if (++n2 >= objectArray.length) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(")");
        return this.messageFactory.newMessage(stringBuilder.toString());
    }

    @Override
    public void error(Marker marker, Message message) {
        if (this.isEnabled(Level.ERROR, marker, message, null)) {
            this.log(marker, FQCN, Level.ERROR, message, null);
        }
    }

    @Override
    public void error(Marker marker, Message message, Throwable throwable) {
        if (this.isEnabled(Level.ERROR, marker, message, throwable)) {
            this.log(marker, FQCN, Level.ERROR, message, throwable);
        }
    }

    @Override
    public void error(Marker marker, Object object) {
        if (this.isEnabled(Level.ERROR, marker, object, null)) {
            this.log(marker, FQCN, Level.ERROR, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void error(Marker marker, Object object, Throwable throwable) {
        if (this.isEnabled(Level.ERROR, marker, object, throwable)) {
            this.log(marker, FQCN, Level.ERROR, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void error(Marker marker, String string) {
        if (this.isEnabled(Level.ERROR, marker, string)) {
            this.log(marker, FQCN, Level.ERROR, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void error(Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(Level.ERROR, marker, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(marker, FQCN, Level.ERROR, message, message.getThrowable());
        }
    }

    @Override
    public void error(Marker marker, String string, Throwable throwable) {
        if (this.isEnabled(Level.ERROR, marker, string, throwable)) {
            this.log(marker, FQCN, Level.ERROR, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void error(Message message) {
        if (this.isEnabled(Level.ERROR, null, message, null)) {
            this.log(null, FQCN, Level.ERROR, message, null);
        }
    }

    @Override
    public void error(Message message, Throwable throwable) {
        if (this.isEnabled(Level.ERROR, null, message, throwable)) {
            this.log(null, FQCN, Level.ERROR, message, throwable);
        }
    }

    @Override
    public void error(Object object) {
        if (this.isEnabled(Level.ERROR, null, object, null)) {
            this.log(null, FQCN, Level.ERROR, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void error(Object object, Throwable throwable) {
        if (this.isEnabled(Level.ERROR, null, object, throwable)) {
            this.log(null, FQCN, Level.ERROR, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void error(String string) {
        if (this.isEnabled(Level.ERROR, null, string)) {
            this.log(null, FQCN, Level.ERROR, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void error(String string, Object ... objectArray) {
        if (this.isEnabled(Level.ERROR, null, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(null, FQCN, Level.ERROR, message, message.getThrowable());
        }
    }

    @Override
    public void error(String string, Throwable throwable) {
        if (this.isEnabled(Level.ERROR, (Marker)null, string, throwable)) {
            this.log(null, FQCN, Level.ERROR, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void exit() {
        this.exit(FQCN, null);
    }

    @Override
    public <R> R exit(R r) {
        return this.exit(FQCN, r);
    }

    protected <R> R exit(String string, R r) {
        if (this.isEnabled(Level.TRACE, EXIT_MARKER, (Object)null, null)) {
            this.log(EXIT_MARKER, string, Level.TRACE, this.toExitMsg(r), null);
        }
        return r;
    }

    @Override
    public void fatal(Marker marker, Message message) {
        if (this.isEnabled(Level.FATAL, marker, message, null)) {
            this.log(marker, FQCN, Level.FATAL, message, null);
        }
    }

    @Override
    public void fatal(Marker marker, Message message, Throwable throwable) {
        if (this.isEnabled(Level.FATAL, marker, message, throwable)) {
            this.log(marker, FQCN, Level.FATAL, message, throwable);
        }
    }

    @Override
    public void fatal(Marker marker, Object object) {
        if (this.isEnabled(Level.FATAL, marker, object, null)) {
            this.log(marker, FQCN, Level.FATAL, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void fatal(Marker marker, Object object, Throwable throwable) {
        if (this.isEnabled(Level.FATAL, marker, object, throwable)) {
            this.log(marker, FQCN, Level.FATAL, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void fatal(Marker marker, String string) {
        if (this.isEnabled(Level.FATAL, marker, string)) {
            this.log(marker, FQCN, Level.FATAL, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void fatal(Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(Level.FATAL, marker, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(marker, FQCN, Level.FATAL, message, message.getThrowable());
        }
    }

    @Override
    public void fatal(Marker marker, String string, Throwable throwable) {
        if (this.isEnabled(Level.FATAL, marker, string, throwable)) {
            this.log(marker, FQCN, Level.FATAL, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void fatal(Message message) {
        if (this.isEnabled(Level.FATAL, null, message, null)) {
            this.log(null, FQCN, Level.FATAL, message, null);
        }
    }

    @Override
    public void fatal(Message message, Throwable throwable) {
        if (this.isEnabled(Level.FATAL, null, message, throwable)) {
            this.log(null, FQCN, Level.FATAL, message, throwable);
        }
    }

    @Override
    public void fatal(Object object) {
        if (this.isEnabled(Level.FATAL, null, object, null)) {
            this.log(null, FQCN, Level.FATAL, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void fatal(Object object, Throwable throwable) {
        if (this.isEnabled(Level.FATAL, null, object, throwable)) {
            this.log(null, FQCN, Level.FATAL, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void fatal(String string) {
        if (this.isEnabled(Level.FATAL, null, string)) {
            this.log(null, FQCN, Level.FATAL, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void fatal(String string, Object ... objectArray) {
        if (this.isEnabled(Level.FATAL, null, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(null, FQCN, Level.FATAL, message, message.getThrowable());
        }
    }

    @Override
    public void fatal(String string, Throwable throwable) {
        if (this.isEnabled(Level.FATAL, (Marker)null, string, throwable)) {
            this.log(null, FQCN, Level.FATAL, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public MessageFactory getMessageFactory() {
        return this.messageFactory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void info(Marker marker, Message message) {
        if (this.isEnabled(Level.INFO, marker, message, null)) {
            this.log(marker, FQCN, Level.INFO, message, null);
        }
    }

    @Override
    public void info(Marker marker, Message message, Throwable throwable) {
        if (this.isEnabled(Level.INFO, marker, message, throwable)) {
            this.log(marker, FQCN, Level.INFO, message, throwable);
        }
    }

    @Override
    public void info(Marker marker, Object object) {
        if (this.isEnabled(Level.INFO, marker, object, null)) {
            this.log(marker, FQCN, Level.INFO, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void info(Marker marker, Object object, Throwable throwable) {
        if (this.isEnabled(Level.INFO, marker, object, throwable)) {
            this.log(marker, FQCN, Level.INFO, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void info(Marker marker, String string) {
        if (this.isEnabled(Level.INFO, marker, string)) {
            this.log(marker, FQCN, Level.INFO, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void info(Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(Level.INFO, marker, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(marker, FQCN, Level.INFO, message, message.getThrowable());
        }
    }

    @Override
    public void info(Marker marker, String string, Throwable throwable) {
        if (this.isEnabled(Level.INFO, marker, string, throwable)) {
            this.log(marker, FQCN, Level.INFO, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void info(Message message) {
        if (this.isEnabled(Level.INFO, null, message, null)) {
            this.log(null, FQCN, Level.INFO, message, null);
        }
    }

    @Override
    public void info(Message message, Throwable throwable) {
        if (this.isEnabled(Level.INFO, null, message, throwable)) {
            this.log(null, FQCN, Level.INFO, message, throwable);
        }
    }

    @Override
    public void info(Object object) {
        if (this.isEnabled(Level.INFO, null, object, null)) {
            this.log(null, FQCN, Level.INFO, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void info(Object object, Throwable throwable) {
        if (this.isEnabled(Level.INFO, null, object, throwable)) {
            this.log(null, FQCN, Level.INFO, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void info(String string) {
        if (this.isEnabled(Level.INFO, null, string)) {
            this.log(null, FQCN, Level.INFO, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void info(String string, Object ... objectArray) {
        if (this.isEnabled(Level.INFO, null, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(null, FQCN, Level.INFO, message, message.getThrowable());
        }
    }

    @Override
    public void info(String string, Throwable throwable) {
        if (this.isEnabled(Level.INFO, (Marker)null, string, throwable)) {
            this.log(null, FQCN, Level.INFO, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.isEnabled(Level.DEBUG, null, null);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return this.isEnabled(Level.DEBUG, marker, (Object)null, null);
    }

    @Override
    public boolean isEnabled(Level level) {
        return this.isEnabled(level, null, (Object)null, null);
    }

    protected abstract boolean isEnabled(Level var1, Marker var2, Message var3, Throwable var4);

    protected abstract boolean isEnabled(Level var1, Marker var2, Object var3, Throwable var4);

    protected abstract boolean isEnabled(Level var1, Marker var2, String var3);

    protected abstract boolean isEnabled(Level var1, Marker var2, String var3, Object ... var4);

    protected abstract boolean isEnabled(Level var1, Marker var2, String var3, Throwable var4);

    @Override
    public boolean isErrorEnabled() {
        return this.isEnabled(Level.ERROR, null, (Object)null, null);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return this.isEnabled(Level.ERROR, marker, (Object)null, null);
    }

    @Override
    public boolean isFatalEnabled() {
        return this.isEnabled(Level.FATAL, null, (Object)null, null);
    }

    @Override
    public boolean isFatalEnabled(Marker marker) {
        return this.isEnabled(Level.FATAL, marker, (Object)null, null);
    }

    @Override
    public boolean isInfoEnabled() {
        return this.isEnabled(Level.INFO, null, (Object)null, null);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return this.isEnabled(Level.INFO, marker, (Object)null, null);
    }

    @Override
    public boolean isTraceEnabled() {
        return this.isEnabled(Level.TRACE, null, (Object)null, null);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return this.isEnabled(Level.TRACE, marker, (Object)null, null);
    }

    @Override
    public boolean isWarnEnabled() {
        return this.isEnabled(Level.WARN, null, (Object)null, null);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return this.isEnabled(Level.WARN, marker, (Object)null, null);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker) {
        return this.isEnabled(level, marker, (Object)null, null);
    }

    @Override
    public void log(Level level, Marker marker, Message message) {
        if (this.isEnabled(level, marker, message, null)) {
            this.log(marker, FQCN, level, message, null);
        }
    }

    @Override
    public void log(Level level, Marker marker, Message message, Throwable throwable) {
        if (this.isEnabled(level, marker, message, throwable)) {
            this.log(marker, FQCN, level, message, throwable);
        }
    }

    @Override
    public void log(Level level, Marker marker, Object object) {
        if (this.isEnabled(level, marker, object, null)) {
            this.log(marker, FQCN, level, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void log(Level level, Marker marker, Object object, Throwable throwable) {
        if (this.isEnabled(level, marker, object, throwable)) {
            this.log(marker, FQCN, level, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void log(Level level, Marker marker, String string) {
        if (this.isEnabled(level, marker, string)) {
            this.log(marker, FQCN, level, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void log(Level level, Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(level, marker, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(marker, FQCN, level, message, message.getThrowable());
        }
    }

    @Override
    public void log(Level level, Marker marker, String string, Throwable throwable) {
        if (this.isEnabled(level, marker, string, throwable)) {
            this.log(marker, FQCN, level, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void log(Level level, Message message) {
        if (this.isEnabled(level, null, message, null)) {
            this.log(null, FQCN, level, message, null);
        }
    }

    @Override
    public void log(Level level, Message message, Throwable throwable) {
        if (this.isEnabled(level, null, message, throwable)) {
            this.log(null, FQCN, level, message, throwable);
        }
    }

    @Override
    public void log(Level level, Object object) {
        if (this.isEnabled(level, null, object, null)) {
            this.log(null, FQCN, level, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void log(Level level, Object object, Throwable throwable) {
        if (this.isEnabled(level, null, object, throwable)) {
            this.log(null, FQCN, level, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void log(Level level, String string) {
        if (this.isEnabled(level, null, string)) {
            this.log(null, FQCN, level, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void log(Level level, String string, Object ... objectArray) {
        if (this.isEnabled(level, null, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(null, FQCN, level, message, message.getThrowable());
        }
    }

    @Override
    public void log(Level level, String string, Throwable throwable) {
        if (this.isEnabled(level, (Marker)null, string, throwable)) {
            this.log(null, FQCN, level, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void printf(Level level, String string, Object ... objectArray) {
        if (this.isEnabled(level, null, string, objectArray)) {
            StringFormattedMessage stringFormattedMessage = new StringFormattedMessage(string, objectArray);
            this.log(null, FQCN, level, stringFormattedMessage, stringFormattedMessage.getThrowable());
        }
    }

    @Override
    public void printf(Level level, Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(level, marker, string, objectArray)) {
            StringFormattedMessage stringFormattedMessage = new StringFormattedMessage(string, objectArray);
            this.log(marker, FQCN, level, stringFormattedMessage, stringFormattedMessage.getThrowable());
        }
    }

    public abstract void log(Marker var1, String var2, Level var3, Message var4, Throwable var5);

    @Override
    public <T extends Throwable> T throwing(Level level, T t) {
        return this.throwing(FQCN, level, t);
    }

    @Override
    public <T extends Throwable> T throwing(T t) {
        return this.throwing(FQCN, Level.ERROR, t);
    }

    protected <T extends Throwable> T throwing(String string, Level level, T t) {
        if (this.isEnabled(level, THROWING_MARKER, (Object)null, null)) {
            this.log(THROWING_MARKER, string, level, this.messageFactory.newMessage(THROWING), t);
        }
        return t;
    }

    private Message toExitMsg(Object object) {
        if (object == null) {
            return this.messageFactory.newMessage("exit");
        }
        return this.messageFactory.newMessage("exit with(" + object + ")");
    }

    public String toString() {
        return this.name;
    }

    @Override
    public void trace(Marker marker, Message message) {
        if (this.isEnabled(Level.TRACE, marker, message, null)) {
            this.log(marker, FQCN, Level.TRACE, message, null);
        }
    }

    @Override
    public void trace(Marker marker, Message message, Throwable throwable) {
        if (this.isEnabled(Level.TRACE, marker, message, throwable)) {
            this.log(marker, FQCN, Level.TRACE, message, throwable);
        }
    }

    @Override
    public void trace(Marker marker, Object object) {
        if (this.isEnabled(Level.TRACE, marker, object, null)) {
            this.log(marker, FQCN, Level.TRACE, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void trace(Marker marker, Object object, Throwable throwable) {
        if (this.isEnabled(Level.TRACE, marker, object, throwable)) {
            this.log(marker, FQCN, Level.TRACE, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void trace(Marker marker, String string) {
        if (this.isEnabled(Level.TRACE, marker, string)) {
            this.log(marker, FQCN, Level.TRACE, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void trace(Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(Level.TRACE, marker, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(marker, FQCN, Level.TRACE, message, message.getThrowable());
        }
    }

    @Override
    public void trace(Marker marker, String string, Throwable throwable) {
        if (this.isEnabled(Level.TRACE, marker, string, throwable)) {
            this.log(marker, FQCN, Level.TRACE, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void trace(Message message) {
        if (this.isEnabled(Level.TRACE, null, message, null)) {
            this.log(null, FQCN, Level.TRACE, message, null);
        }
    }

    @Override
    public void trace(Message message, Throwable throwable) {
        if (this.isEnabled(Level.TRACE, null, message, throwable)) {
            this.log(null, FQCN, Level.TRACE, message, throwable);
        }
    }

    @Override
    public void trace(Object object) {
        if (this.isEnabled(Level.TRACE, null, object, null)) {
            this.log(null, FQCN, Level.TRACE, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void trace(Object object, Throwable throwable) {
        if (this.isEnabled(Level.TRACE, null, object, throwable)) {
            this.log(null, FQCN, Level.TRACE, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void trace(String string) {
        if (this.isEnabled(Level.TRACE, null, string)) {
            this.log(null, FQCN, Level.TRACE, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void trace(String string, Object ... objectArray) {
        if (this.isEnabled(Level.TRACE, null, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(null, FQCN, Level.TRACE, message, message.getThrowable());
        }
    }

    @Override
    public void trace(String string, Throwable throwable) {
        if (this.isEnabled(Level.TRACE, (Marker)null, string, throwable)) {
            this.log(null, FQCN, Level.TRACE, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void warn(Marker marker, Message message) {
        if (this.isEnabled(Level.WARN, marker, message, null)) {
            this.log(marker, FQCN, Level.WARN, message, null);
        }
    }

    @Override
    public void warn(Marker marker, Message message, Throwable throwable) {
        if (this.isEnabled(Level.WARN, marker, message, throwable)) {
            this.log(marker, FQCN, Level.WARN, message, throwable);
        }
    }

    @Override
    public void warn(Marker marker, Object object) {
        if (this.isEnabled(Level.WARN, marker, object, null)) {
            this.log(marker, FQCN, Level.WARN, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void warn(Marker marker, Object object, Throwable throwable) {
        if (this.isEnabled(Level.WARN, marker, object, throwable)) {
            this.log(marker, FQCN, Level.WARN, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void warn(Marker marker, String string) {
        if (this.isEnabled(Level.WARN, marker, string)) {
            this.log(marker, FQCN, Level.WARN, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void warn(Marker marker, String string, Object ... objectArray) {
        if (this.isEnabled(Level.WARN, marker, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(marker, FQCN, Level.WARN, message, message.getThrowable());
        }
    }

    @Override
    public void warn(Marker marker, String string, Throwable throwable) {
        if (this.isEnabled(Level.WARN, marker, string, throwable)) {
            this.log(marker, FQCN, Level.WARN, this.messageFactory.newMessage(string), throwable);
        }
    }

    @Override
    public void warn(Message message) {
        if (this.isEnabled(Level.WARN, null, message, null)) {
            this.log(null, FQCN, Level.WARN, message, null);
        }
    }

    @Override
    public void warn(Message message, Throwable throwable) {
        if (this.isEnabled(Level.WARN, null, message, throwable)) {
            this.log(null, FQCN, Level.WARN, message, throwable);
        }
    }

    @Override
    public void warn(Object object) {
        if (this.isEnabled(Level.WARN, null, object, null)) {
            this.log(null, FQCN, Level.WARN, this.messageFactory.newMessage(object), null);
        }
    }

    @Override
    public void warn(Object object, Throwable throwable) {
        if (this.isEnabled(Level.WARN, null, object, throwable)) {
            this.log(null, FQCN, Level.WARN, this.messageFactory.newMessage(object), throwable);
        }
    }

    @Override
    public void warn(String string) {
        if (this.isEnabled(Level.WARN, null, string)) {
            this.log(null, FQCN, Level.WARN, this.messageFactory.newMessage(string), null);
        }
    }

    @Override
    public void warn(String string, Object ... objectArray) {
        if (this.isEnabled(Level.WARN, null, string, objectArray)) {
            Message message = this.messageFactory.newMessage(string, objectArray);
            this.log(null, FQCN, Level.WARN, message, message.getThrowable());
        }
    }

    @Override
    public void warn(String string, Throwable throwable) {
        if (this.isEnabled(Level.WARN, (Marker)null, string, throwable)) {
            this.log(null, FQCN, Level.WARN, this.messageFactory.newMessage(string), throwable);
        }
    }
}

