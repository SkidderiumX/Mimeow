/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.OutputStreamManager;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.helpers.Loader;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.util.PropertiesUtil;

@Plugin(name="Console", category="Core", elementType="appender", printObject=true)
public class ConsoleAppender
extends AbstractOutputStreamAppender {
    private static final String JANSI_CLASS = "org.fusesource.jansi.WindowsAnsiOutputStream";
    private static ConsoleManagerFactory factory = new ConsoleManagerFactory();

    private ConsoleAppender(String string, Layout<? extends Serializable> layout, Filter filter, OutputStreamManager outputStreamManager, boolean bl) {
        super(string, layout, filter, bl, true, outputStreamManager);
    }

    @PluginFactory
    public static ConsoleAppender createAppender(@PluginElement(value="Layout") Layout<? extends Serializable> patternLayout, @PluginElement(value="Filters") Filter filter, @PluginAttribute(value="target") String string, @PluginAttribute(value="name") String string2, @PluginAttribute(value="follow") String string3, @PluginAttribute(value="ignoreExceptions") String string4) {
        if (string2 == null) {
            LOGGER.error("No name provided for ConsoleAppender");
            return null;
        }
        if (patternLayout == null) {
            patternLayout = PatternLayout.createLayout(null, null, null, null, null);
        }
        boolean bl = Boolean.parseBoolean(string3);
        boolean bl2 = Booleans.parseBoolean(string4, true);
        Target target = string == null ? Target.SYSTEM_OUT : Target.valueOf(string);
        return new ConsoleAppender(string2, patternLayout, filter, ConsoleAppender.getManager(bl, target, patternLayout), bl2);
    }

    private static OutputStreamManager getManager(boolean bl, Target target, Layout<? extends Serializable> layout) {
        String string = target.name();
        OutputStream outputStream2 = ConsoleAppender.getOutputStream(bl, target);
        return OutputStreamManager.getManager(target.name() + "." + bl, new FactoryData(outputStream2, string, layout), factory);
    }

    private static OutputStream getOutputStream(boolean bl, Target target) {
        String string = Charset.defaultCharset().name();
        PrintStream printStream = null;
        try {
            printStream = target == Target.SYSTEM_OUT ? (bl ? new PrintStream((OutputStream)new SystemOutStream(), true, string) : System.out) : (bl ? new PrintStream((OutputStream)new SystemErrStream(), true, string) : System.err);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new IllegalStateException("Unsupported default encoding " + string, unsupportedEncodingException);
        }
        PropertiesUtil propertiesUtil = PropertiesUtil.getProperties();
        if (!propertiesUtil.getStringProperty("os.name").startsWith("Windows") || propertiesUtil.getBooleanProperty("log4j.skipJansi")) {
            return printStream;
        }
        try {
            ClassLoader classLoader = Loader.getClassLoader();
            Class<?> clazz = classLoader.loadClass(JANSI_CLASS);
            Constructor<?> constructor = clazz.getConstructor(OutputStream.class);
            return (OutputStream)constructor.newInstance(printStream);
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOGGER.debug("Jansi is not installed, cannot find {}", JANSI_CLASS);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            LOGGER.warn("{} is missing the proper constructor", JANSI_CLASS);
        }
        catch (Exception exception) {
            LOGGER.warn("Unable to instantiate {}", JANSI_CLASS);
        }
        return printStream;
    }

    private static class ConsoleManagerFactory
    implements ManagerFactory<OutputStreamManager, FactoryData> {
        private ConsoleManagerFactory() {
        }

        @Override
        public OutputStreamManager createManager(String string, FactoryData factoryData) {
            return new OutputStreamManager(factoryData.os, factoryData.type, factoryData.layout);
        }
    }

    private static class FactoryData {
        private final OutputStream os;
        private final String type;
        private final Layout<? extends Serializable> layout;

        public FactoryData(OutputStream outputStream2, String string, Layout<? extends Serializable> layout) {
            this.os = outputStream2;
            this.type = string;
            this.layout = layout;
        }
    }

    private static class SystemOutStream
    extends OutputStream {
        @Override
        public void close() {
        }

        @Override
        public void flush() {
            System.out.flush();
        }

        @Override
        public void write(byte[] byArray) throws IOException {
            System.out.write(byArray);
        }

        @Override
        public void write(byte[] byArray, int n, int n2) throws IOException {
            System.out.write(byArray, n, n2);
        }

        @Override
        public void write(int n) throws IOException {
            System.out.write(n);
        }
    }

    private static class SystemErrStream
    extends OutputStream {
        @Override
        public void close() {
        }

        @Override
        public void flush() {
            System.err.flush();
        }

        @Override
        public void write(byte[] byArray) throws IOException {
            System.err.write(byArray);
        }

        @Override
        public void write(byte[] byArray, int n, int n2) throws IOException {
            System.err.write(byArray, n, n2);
        }

        @Override
        public void write(int n) {
            System.err.write(n);
        }
    }

    public static enum Target {
        SYSTEM_OUT,
        SYSTEM_ERR;

    }
}

