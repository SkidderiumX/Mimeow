/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jpa;

import java.lang.reflect.Constructor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseManager;
import org.apache.logging.log4j.core.appender.db.jpa.AbstractLogEventWrapperEntity;

public class JPADatabaseManager
extends AbstractDatabaseManager {
    private static final JPADatabaseManagerFactory FACTORY = new JPADatabaseManagerFactory();
    private final String entityClassName;
    private final Constructor<? extends AbstractLogEventWrapperEntity> entityConstructor;
    private final String persistenceUnitName;
    private EntityManagerFactory entityManagerFactory;

    private JPADatabaseManager(String string, int n, Class<? extends AbstractLogEventWrapperEntity> clazz, Constructor<? extends AbstractLogEventWrapperEntity> constructor, String string2) {
        super(string, n);
        this.entityClassName = clazz.getName();
        this.entityConstructor = constructor;
        this.persistenceUnitName = string2;
    }

    @Override
    protected void connectInternal() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory((String)this.persistenceUnitName);
    }

    @Override
    protected void disconnectInternal() {
        if (this.entityManagerFactory != null && this.entityManagerFactory.isOpen()) {
            this.entityManagerFactory.close();
        }
    }

    @Override
    protected void writeInternal(LogEvent logEvent) {
        AbstractLogEventWrapperEntity abstractLogEventWrapperEntity;
        if (!this.isConnected() || this.entityManagerFactory == null) {
            throw new AppenderLoggingException("Cannot write logging event; JPA manager not connected to the database.");
        }
        try {
            abstractLogEventWrapperEntity = this.entityConstructor.newInstance(logEvent);
        }
        catch (Exception exception) {
            throw new AppenderLoggingException("Failed to instantiate entity class [" + this.entityClassName + "].", exception);
        }
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = this.entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist((Object)abstractLogEventWrapperEntity);
            entityTransaction.commit();
        }
        catch (Exception exception) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new AppenderLoggingException("Failed to insert record for log event in JDBC manager: " + exception.getMessage(), exception);
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static JPADatabaseManager getJPADatabaseManager(String string, int n, Class<? extends AbstractLogEventWrapperEntity> clazz, Constructor<? extends AbstractLogEventWrapperEntity> constructor, String string2) {
        return AbstractDatabaseManager.getManager(string, new FactoryData(n, clazz, constructor, string2), FACTORY);
    }

    private static final class JPADatabaseManagerFactory
    implements ManagerFactory<JPADatabaseManager, FactoryData> {
        private JPADatabaseManagerFactory() {
        }

        @Override
        public JPADatabaseManager createManager(String string, FactoryData factoryData) {
            return new JPADatabaseManager(string, factoryData.getBufferSize(), factoryData.entityClass, factoryData.entityConstructor, factoryData.persistenceUnitName);
        }
    }

    private static final class FactoryData
    extends AbstractDatabaseManager.AbstractFactoryData {
        private final Class<? extends AbstractLogEventWrapperEntity> entityClass;
        private final Constructor<? extends AbstractLogEventWrapperEntity> entityConstructor;
        private final String persistenceUnitName;

        protected FactoryData(int n, Class<? extends AbstractLogEventWrapperEntity> clazz, Constructor<? extends AbstractLogEventWrapperEntity> constructor, String string) {
            super(n);
            this.entityClass = clazz;
            this.entityConstructor = constructor;
            this.persistenceUnitName = string;
        }
    }
}

