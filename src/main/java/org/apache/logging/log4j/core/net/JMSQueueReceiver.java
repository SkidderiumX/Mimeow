/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.logging.log4j.core.net.AbstractJMSReceiver;

public class JMSQueueReceiver
extends AbstractJMSReceiver {
    public JMSQueueReceiver(String string, String string2, String string3, String string4) {
        try {
            InitialContext initialContext = new InitialContext();
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory)this.lookup(initialContext, string);
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection(string3, string4);
            queueConnection.start();
            QueueSession queueSession = queueConnection.createQueueSession(false, 1);
            Queue queue = (Queue)initialContext.lookup(string2);
            QueueReceiver queueReceiver = queueSession.createReceiver(queue);
            queueReceiver.setMessageListener((MessageListener)this);
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
            JMSQueueReceiver.usage("Wrong number of arguments.");
        }
        String string2 = stringArray[0];
        String string3 = stringArray[1];
        String string4 = stringArray[2];
        String string5 = stringArray[3];
        new JMSQueueReceiver(string2, string3, string4, string5);
        Charset charset = Charset.defaultCharset();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, charset));
        System.out.println("Type \"exit\" to quit JMSQueueReceiver.");
        while ((string = bufferedReader.readLine()) != null && !string.equalsIgnoreCase("exit")) {
        }
        System.out.println("Exiting. Kill the application if it does not exit due to daemon threads.");
    }

    private static void usage(String string) {
        System.err.println(string);
        System.err.println("Usage: java " + JMSQueueReceiver.class.getName() + " QueueConnectionFactoryBindingName QueueBindingName username password");
        System.exit(1);
    }
}

