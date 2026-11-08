/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.logging.log4j.core.net.AbstractJMSReceiver;

public class JMSTopicReceiver
extends AbstractJMSReceiver {
    public JMSTopicReceiver(String string, String string2, String string3, String string4) {
        try {
            InitialContext initialContext = new InitialContext();
            TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory)this.lookup(initialContext, string);
            TopicConnection topicConnection = topicConnectionFactory.createTopicConnection(string3, string4);
            topicConnection.start();
            TopicSession topicSession = topicConnection.createTopicSession(false, 1);
            Topic topic = (Topic)initialContext.lookup(string2);
            TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
            topicSubscriber.setMessageListener((MessageListener)this);
        }
        catch (JMSException jMSException) {
            this.logger.error("Could not read JMS message.", (Throwable)jMSException);
        }
        catch (NamingException namingException) {
            this.logger.error("Could not read JMS message.", (Throwable)namingException);
        }
        catch (RuntimeException runtimeException) {
            this.logger.error("Could not read JMS message.", (Throwable)runtimeException);
        }
    }

    public static void main(String[] stringArray) throws Exception {
        String string;
        if (stringArray.length != 4) {
            JMSTopicReceiver.usage("Wrong number of arguments.");
        }
        String string2 = stringArray[0];
        String string3 = stringArray[1];
        String string4 = stringArray[2];
        String string5 = stringArray[3];
        new JMSTopicReceiver(string2, string3, string4, string5);
        Charset charset = Charset.defaultCharset();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, charset));
        System.out.println("Type \"exit\" to quit JMSTopicReceiver.");
        while ((string = bufferedReader.readLine()) != null && !string.equalsIgnoreCase("exit")) {
        }
        System.out.println("Exiting. Kill the application if it does not exit due to daemon threads.");
    }

    private static void usage(String string) {
        System.err.println(string);
        System.err.println("Usage: java " + JMSTopicReceiver.class.getName() + " TopicConnectionFactoryBindingName TopicBindingName username password");
        System.exit(1);
    }
}

