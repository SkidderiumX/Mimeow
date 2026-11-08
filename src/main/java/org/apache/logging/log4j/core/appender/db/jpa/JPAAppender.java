/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jpa;

import java.lang.reflect.Constructor;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseAppender;
import org.apache.logging.log4j.core.appender.db.jpa.AbstractLogEventWrapperEntity;
import org.apache.logging.log4j.core.appender.db.jpa.JPADatabaseManager;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.helpers.Strings;

@Plugin(name="JPA", category="Core", elementType="appender", printObject=true)
public class JPAAppender
extends AbstractDatabaseAppender<JPADatabaseManager> {
    private final String description = this.getName() + "{ manager=" + this.getManager() + " }";

    private JPAAppender(String string, Filter filter, boolean bl, JPADatabaseManager jPADatabaseManager) {
        super(string, filter, bl, jPADatabaseManager);
    }

    @Override
    public String toString() {
        return this.description;
    }

    @PluginFactory
    public static JPAAppender createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="ignoreExceptions") String string2, @PluginElement(value="Filter") Filter filter, @PluginAttribute(value="bufferSize") String string3, @PluginAttribute(value="entityClassName") String string4, @PluginAttribute(value="persistenceUnitName") String string5) {
        if (Strings.isEmpty(string4) || Strings.isEmpty(string5)) {
            LOGGER.error("Attributes entityClassName and persistenceUnitName are required for JPA Appender.");
            return null;
        }
        int n = AbstractAppender.parseInt(string3, 0);
        boolean bl = Booleans.parseBoolean(string2, true);
        try {
            Class<?> clazz = Class.forName(string4);
            if (!AbstractLogEventWrapperEntity.class.isAssignableFrom(clazz)) {
                LOGGER.error("Entity class [{}] does not extend AbstractLogEventWrapperEntity.", string4);
                return null;
            }
            try {
                clazz.getConstructor(new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                LOGGER.error("Entity class [{}] does not have a no-arg constructor. The JPA provider will reject it.", string4);
                return null;
            }
            Constructor<?> constructor = clazz.getConstructor(LogEvent.class);
            String string6 = "jpaManager{ description=" + string + ", bufferSize=" + n + ", persistenceUnitName=" + string5 + ", entityClass=" + clazz.getName() + "}";
            JPADatabaseManager jPADatabaseManager = JPADatabaseManager.getJPADatabaseManager(string6, n, clazz, constructor, string5);
            if (jPADatabaseManager == null) {
                return null;
            }
            return new JPAAppender(string, filter, bl, jPADatabaseManager);
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOGGER.error("Could not load entity class [{}].", string4, classNotFoundException);
            return null;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            LOGGER.error("Entity class [{}] does not have a constructor with a single argument of type LogEvent.", string4);
            return null;
        }
    }
}

