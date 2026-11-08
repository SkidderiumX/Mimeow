/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.logging.log4j.core.helpers.Charsets;

public class MimeMessageBuilder {
    private final MimeMessage message;

    public MimeMessageBuilder(Session session) {
        this.message = new MimeMessage(session);
    }

    public MimeMessageBuilder setFrom(String string) throws MessagingException {
        InternetAddress internetAddress = MimeMessageBuilder.parseAddress(string);
        if (null != internetAddress) {
            this.message.setFrom((Address)internetAddress);
        } else {
            try {
                this.message.setFrom();
            }
            catch (Exception exception) {
                this.message.setFrom((Address)((InternetAddress)null));
            }
        }
        return this;
    }

    public MimeMessageBuilder setReplyTo(String string) throws MessagingException {
        InternetAddress[] internetAddressArray = MimeMessageBuilder.parseAddresses(string);
        if (null != internetAddressArray) {
            this.message.setReplyTo((Address[])internetAddressArray);
        }
        return this;
    }

    public MimeMessageBuilder setRecipients(Message.RecipientType recipientType, String string) throws MessagingException {
        InternetAddress[] internetAddressArray = MimeMessageBuilder.parseAddresses(string);
        if (null != internetAddressArray) {
            this.message.setRecipients(recipientType, (Address[])internetAddressArray);
        }
        return this;
    }

    public MimeMessageBuilder setSubject(String string) throws MessagingException {
        if (string != null) {
            this.message.setSubject(string, Charsets.UTF_8.name());
        }
        return this;
    }

    public MimeMessage getMimeMessage() {
        return this.message;
    }

    private static InternetAddress parseAddress(String string) throws AddressException {
        return string == null ? null : new InternetAddress(string);
    }

    private static InternetAddress[] parseAddresses(String string) throws AddressException {
        return string == null ? null : InternetAddress.parse((String)string, (boolean)true);
    }
}

