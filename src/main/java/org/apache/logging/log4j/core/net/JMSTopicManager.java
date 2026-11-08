/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.Serializable;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.NamingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.net.AbstractJMSManager;

public class JMSTopicManager
extends AbstractJMSManager {
    private static final JMSTopicManagerFactory FACTORY = new JMSTopicManagerFactory();
    private TopicInfo info;
    private final String factoryBindingName;
    private final String topicBindingName;
    private final String userName;
    private final String password;
    private final Context context;

    protected JMSTopicManager(String string, Context context, String string2, String string3, String string4, String string5, TopicInfo topicInfo) {
        super(string);
        this.context = context;
        this.factoryBindingName = string2;
        this.topicBindingName = string3;
        this.userName = string4;
        this.password = string5;
        this.info = topicInfo;
    }

    public static JMSTopicManager getJMSTopicManager(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        if (string6 == null) {
            LOGGER.error("No factory name provided for JMSTopicManager");
            return null;
        }
        if (string7 == null) {
            LOGGER.error("No topic name provided for JMSTopicManager");
            return null;
        }
        String string10 = "JMSTopic:" + string6 + '.' + string7;
        return JMSTopicManager.getManager(string10, FACTORY, new FactoryData(string, string2, string3, string4, string5, string6, string7, string8, string9));
    }

    @Override
    public void send(Serializable serializable) throws Exception {
        if (this.info == null) {
            this.info = JMSTopicManager.connect(this.context, this.factoryBindingName, this.topicBindingName, this.userName, this.password, false);
        }
        try {
            super.send(serializable, (Session)this.info.session, (MessageProducer)this.info.publisher);
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

    private static TopicInfo connect(Context context, String string, String string2, String string3, String string4, boolean bl) throws Exception {
        block4: {
            try {
                TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory)JMSTopicManager.lookup(context, string);
                TopicConnection topicConnection = string3 != null ? topicConnectionFactory.createTopicConnection(string3, string4) : topicConnectionFactory.createTopicConnection();
                TopicSession topicSession = topicConnection.createTopicSession(false, 1);
                Topic topic = (Topic)JMSTopicManager.lookup(context, string2);
                TopicPublisher topicPublisher = topicSession.createPublisher(topic);
                topicConnection.start();
                return new TopicInfo(topicConnection, topicSession, topicPublisher);
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

    private static class JMSTopicManagerFactory
    implements ManagerFactory<JMSTopicManager, FactoryData> {
        private JMSTopicManagerFactory() {
        }

        @Override
        public JMSTopicManager createManager(String string, FactoryData factoryData) {
            try {
                Context context = AbstractJMSManager.createContext(factoryData.factoryName, factoryData.providerURL, factoryData.urlPkgPrefixes, factoryData.securityPrincipalName, factoryData.securityCredentials);
                TopicInfo topicInfo = JMSTopicManager.connect(context, factoryData.factoryBindingName, factoryData.topicBindingName, factoryData.userName, factoryData.password, true);
                return new JMSTopicManager(string, context, factoryData.factoryBindingName, factoryData.topicBindingName, factoryData.userName, factoryData.password, topicInfo);
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

    private static class TopicInfo {
        private final TopicConnection conn;
        private final TopicSession session;
        private final TopicPublisher publisher;

        public TopicInfo(TopicConnection topicConnection, TopicSession topicSession, TopicPublisher topicPublisher) {
            this.conn = topicConnection;
            this.session = topicSession;
            this.publisher = topicPublisher;
        }
    }

    private static class FactoryData {
        private final String factoryName;
        private final String providerURL;
        private final String urlPkgPrefixes;
        private final String securityPrincipalName;
        private final String securityCredentials;
        private final String factoryBindingName;
        private final String topicBindingName;
        private final String userName;
        private final String password;

        public FactoryData(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
            this.factoryName = string;
            this.providerURL = string2;
            this.urlPkgPrefixes = string3;
            this.securityPrincipalName = string4;
            this.securityCredentials = string5;
            this.factoryBindingName = string6;
            this.topicBindingName = string7;
            this.userName = string8;
            this.password = string9;
        }
    }
}

