/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.Serializable;
import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.logging.log4j.core.appender.AbstractManager;

public abstract class AbstractJMSManager
extends AbstractManager {
    public AbstractJMSManager(String string) {
        super(string);
    }

    protected static Context createContext(String string, String string2, String string3, String string4, String string5) throws NamingException {
        Properties properties = AbstractJMSManager.getEnvironment(string, string2, string3, string4, string5);
        return new InitialContext(properties);
    }

    protected static Object lookup(Context context, String string) throws NamingException {
        try {
            return context.lookup(string);
        }
        catch (NameNotFoundException nameNotFoundException) {
            LOGGER.warn("Could not find name [" + string + "].");
            throw nameNotFoundException;
        }
    }

    protected static Properties getEnvironment(String string, String string2, String string3, String string4, String string5) {
        Properties properties = new Properties();
        if (string != null) {
            properties.put("java.naming.factory.initial", string);
            if (string2 != null) {
                properties.put("java.naming.provider.url", string2);
            } else {
                LOGGER.warn("The InitialContext factory name has been provided without a ProviderURL. This is likely to cause problems");
            }
            if (string3 != null) {
                properties.put("java.naming.factory.url.pkgs", string3);
            }
            if (string4 != null) {
                properties.put("java.naming.security.principal", string4);
                if (string5 != null) {
                    properties.put("java.naming.security.credentials", string5);
                } else {
                    LOGGER.warn("SecurityPrincipalName has been set without SecurityCredentials. This is likely to cause problems.");
                }
            }
            return properties;
        }
        return null;
    }

    public abstract void send(Serializable var1) throws Exception;

    public synchronized void send(Serializable serializable, Session session, MessageProducer messageProducer) throws Exception {
        try {
            TextMessage textMessage;
            if (serializable instanceof String) {
                textMessage = session.createTextMessage();
                textMessage.setText((String)((Object)serializable));
            } else {
                textMessage = session.createObjectMessage();
                ((ObjectMessage)textMessage).setObject(serializable);
            }
            messageProducer.send((Message)textMessage);
        }
        catch (JMSException jMSException) {
            LOGGER.error("Could not publish message via JMS " + this.getName());
            throw jMSException;
        }
    }
}

