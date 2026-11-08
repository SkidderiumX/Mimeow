/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.AbstractServer;
import org.apache.logging.log4j.core.LogEvent;

public abstract class AbstractJMSReceiver
extends AbstractServer
implements MessageListener {
    protected Logger logger = LogManager.getLogger(this.getClass().getName());

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage)message;
                this.log((LogEvent)objectMessage.getObject());
            } else {
                this.logger.warn("Received message is of type " + message.getJMSType() + ", was expecting ObjectMessage.");
            }
        }
        catch (JMSException jMSException) {
            this.logger.error("Exception thrown while processing incoming message.", (Throwable)jMSException);
        }
    }

    protected Object lookup(Context context, String string) throws NamingException {
        try {
            return context.lookup(string);
        }
        catch (NameNotFoundException nameNotFoundException) {
            this.logger.error("Could not find name [" + string + "].");
            throw nameNotFoundException;
        }
    }
}

