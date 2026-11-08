/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.Serializable;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.net.AbstractJMSManager;

public class JMSQueueManager
extends AbstractJMSManager {
    private static final JMSQueueManagerFactory FACTORY = new JMSQueueManagerFactory();
    private QueueInfo info;
    private final String factoryBindingName;
    private final String queueBindingName;
    private final String userName;
    private final String password;
    private final Context context;

    protected JMSQueueManager(String string, Context context, String string2, String string3, String string4, String string5, QueueInfo queueInfo) {
        super(string);
        this.context = context;
        this.factoryBindingName = string2;
        this.queueBindingName = string3;
        this.userName = string4;
        this.password = string5;
        this.info = queueInfo;
    }

    public static JMSQueueManager getJMSQueueManager(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        if (string6 == null) {
            LOGGER.error("No factory name provided for JMSQueueManager");
            return null;
        }
        if (string7 == null) {
            LOGGER.error("No topic name provided for JMSQueueManager");
            return null;
        }
        String string10 = "JMSQueue:" + string6 + '.' + string7;
        return JMSQueueManager.getManager(string10, FACTORY, new FactoryData(string, string2, string3, string4, string5, string6, string7, string8, string9));
    }

    @Override
    public synchronized void send(Serializable serializable) throws Exception {
        if (this.info == null) {
            this.info = JMSQueueManager.connect(this.context, this.factoryBindingName, this.queueBindingName, this.userName, this.password, false);
        }
        try {
            super.send(serializable, (Session)this.info.session, (MessageProducer)this.info.sender);
        }
        catch (Exception exception) {
            this.cleanup(true);
            throw exception;
        }
    }

    @Override
    public void releaseSub() {
        if (this.info != null) {
            this.cleanup(false);
        }
    }

    private void cleanup(boolean bl) {
        block5: {
            block4: {
                try {
                    this.info.session.close();
                }
                catch (Exception exception) {
                    if (bl) break block4;
                    LOGGER.error("Error closing session for " + this.getName(), (Throwable)exception);
                }
            }
            try {
                this.info.conn.close();
            }
            catch (Exception exception) {
                if (bl) break block5;
                LOGGER.error("Error closing connection for " + this.getName(), (Throwable)exception);
            }
        }
        this.info = null;
    }

    private static QueueInfo connect(Context context, String string, String string2, String string3, String string4, boolean bl) throws Exception {
        block4: {
            try {
                QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory)JMSQueueManager.lookup(context, string);
                QueueConnection queueConnection = string3 != null ? queueConnectionFactory.createQueueConnection(string3, string4) : queueConnectionFactory.createQueueConnection();
                QueueSession queueSession = queueConnection.createQueueSession(false, 1);
                Queue queue = (Queue)JMSQueueManager.lookup(context, string2);
                QueueSender queueSender = queueSession.createSender(queue);
                queueConnection.start();
                return new QueueInfo(queueConnection, queueSession, queueSender);
            }
            catch (NamingException namingException) {
                LOGGER.warn("Unable to locate connection factory " + string, (Throwable)namingException);
                if (!bl) {
                    throw namingException;
                }
            }
            catch (JMSException jMSException) {
                LOGGER.warn("Unable to create connection to queue " + string2, (Throwable)jMSException);
                if (bl) break block4;
                throw jMSException;
            }
        }
        return null;
    }

    private static class JMSQueueManagerFactory
    implements ManagerFactory<JMSQueueManager, FactoryData> {
        private JMSQueueManagerFactory() {
        }

        @Override
        public JMSQueueManager createManager(String string, FactoryData factoryData) {
            try {
                Context context = AbstractJMSManager.createContext(factoryData.factoryName, factoryData.providerURL, factoryData.urlPkgPrefixes, factoryData.securityPrincipalName, factoryData.securityCredentials);
                QueueInfo queueInfo = JMSQueueManager.connect(context, factoryData.factoryBindingName, factoryData.queueBindingName, factoryData.userName, factoryData.password, true);
                return new JMSQueueManager(string, context, factoryData.factoryBindingName, factoryData.queueBindingName, factoryData.userName, factoryData.password, queueInfo);
            }
            catch (NamingException namingException) {
                LOGGER.error("Unable to locate resource", (Throwable)namingException);
            }
            catch (Exception exception) {
                LOGGER.error("Unable to connect", (Throwable)exception);
            }
            return null;
        }
    }

    private static class QueueInfo {
        private final QueueConnection conn;
        private final QueueSession session;
        private final QueueSender sender;

        public QueueInfo(QueueConnection queueConnection, QueueSession queueSession, QueueSender queueSender) {
            this.conn = queueConnection;
            this.session = queueSession;
            this.sender = queueSender;
        }
    }

    private static class FactoryData {
        private final String factoryName;
        private final String providerURL;
        private final String urlPkgPrefixes;
        private final String securityPrincipalName;
        private final String securityCredentials;
        private final String factoryBindingName;
        private final String queueBindingName;
        private final String userName;
        private final String password;

        public FactoryData(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
            this.factoryName = string;
            this.providerURL = string2;
            this.urlPkgPrefixes = string3;
            this.securityPrincipalName = string4;
            this.securityCredentials = string5;
            this.factoryBindingName = string6;
            this.queueBindingName = string7;
            this.userName = string8;
            this.password = string9;
        }
    }
}

