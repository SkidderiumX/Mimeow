/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractManager;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.helpers.CyclicBuffer;
import org.apache.logging.log4j.core.helpers.NameUtil;
import org.apache.logging.log4j.core.helpers.NetUtils;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.core.net.MimeMessageBuilder;
import org.apache.logging.log4j.util.PropertiesUtil;

public class SMTPManager
extends AbstractManager {
    private static final SMTPManagerFactory FACTORY = new SMTPManagerFactory();
    private final Session session;
    private final CyclicBuffer<LogEvent> buffer;
    private volatile MimeMessage message;
    private final FactoryData data;

    protected SMTPManager(String string, Session session, MimeMessage mimeMessage, FactoryData factoryData) {
        super(string);
        this.session = session;
        this.message = mimeMessage;
        this.data = factoryData;
        this.buffer = new CyclicBuffer<LogEvent>(LogEvent.class, factoryData.numElements);
    }

    public void add(LogEvent logEvent) {
        this.buffer.add(logEvent);
    }

    public static SMTPManager getSMTPManager(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n, String string9, String string10, boolean bl, String string11, int n2) {
        if (Strings.isEmpty(string7)) {
            string7 = "smtp";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (string != null) {
            stringBuilder.append(string);
        }
        stringBuilder.append(":");
        if (string2 != null) {
            stringBuilder.append(string2);
        }
        stringBuilder.append(":");
        if (string3 != null) {
            stringBuilder.append(string3);
        }
        stringBuilder.append(":");
        if (string4 != null) {
            stringBuilder.append(string4);
        }
        stringBuilder.append(":");
        if (string5 != null) {
            stringBuilder.append(string5);
        }
        stringBuilder.append(":");
        if (string6 != null) {
            stringBuilder.append(string6);
        }
        stringBuilder.append(":");
        stringBuilder.append(string7).append(":").append(string8).append(":").append("port").append(":");
        if (string9 != null) {
            stringBuilder.append(string9);
        }
        stringBuilder.append(":");
        if (string10 != null) {
            stringBuilder.append(string10);
        }
        stringBuilder.append(bl ? ":debug:" : "::");
        stringBuilder.append(string11);
        String string12 = "SMTP:" + NameUtil.md5(stringBuilder.toString());
        return SMTPManager.getManager(string12, FACTORY, new FactoryData(string, string2, string3, string4, string5, string6, string7, string8, n, string9, string10, bl, n2));
    }

    public void sendEvents(Layout<?> layout, LogEvent logEvent) {
        if (this.message == null) {
            this.connect();
        }
        try {
            LogEvent[] logEventArray = this.buffer.removeAll();
            byte[] byArray = this.formatContentToBytes(logEventArray, logEvent, layout);
            String string = layout.getContentType();
            String string2 = this.getEncoding(byArray, string);
            byte[] byArray2 = this.encodeContentToBytes(byArray, string2);
            InternetHeaders internetHeaders = this.getHeaders(string, string2);
            MimeMultipart mimeMultipart = this.getMimeMultipart(byArray2, internetHeaders);
            this.sendMultipartMessage(this.message, mimeMultipart);
        }
        catch (MessagingException messagingException) {
            LOGGER.error("Error occurred while sending e-mail notification.", (Throwable)messagingException);
            throw new LoggingException("Error occurred while sending email", messagingException);
        }
        catch (IOException iOException) {
            LOGGER.error("Error occurred while sending e-mail notification.", (Throwable)iOException);
            throw new LoggingException("Error occurred while sending email", iOException);
        }
        catch (RuntimeException runtimeException) {
            LOGGER.error("Error occurred while sending e-mail notification.", (Throwable)runtimeException);
            throw new LoggingException("Error occurred while sending email", runtimeException);
        }
    }

    protected byte[] formatContentToBytes(LogEvent[] logEventArray, LogEvent logEvent, Layout<?> layout) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.writeContent(logEventArray, logEvent, layout, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private void writeContent(LogEvent[] logEventArray, LogEvent logEvent, Layout<?> layout, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        this.writeHeader(layout, byteArrayOutputStream);
        this.writeBuffer(logEventArray, logEvent, layout, byteArrayOutputStream);
        this.writeFooter(layout, byteArrayOutputStream);
    }

    protected void writeHeader(Layout<?> layout, OutputStream outputStream2) throws IOException {
        byte[] byArray = layout.getHeader();
        if (byArray != null) {
            outputStream2.write(byArray);
        }
    }

    protected void writeBuffer(LogEvent[] logEventArray, LogEvent logEvent, Layout<?> layout, OutputStream outputStream2) throws IOException {
        for (LogEvent logEvent2 : logEventArray) {
            byte[] byArray = layout.toByteArray(logEvent2);
            outputStream2.write(byArray);
        }
        byte[] byArray = layout.toByteArray(logEvent);
        outputStream2.write(byArray);
    }

    protected void writeFooter(Layout<?> layout, OutputStream outputStream2) throws IOException {
        byte[] byArray = layout.getFooter();
        if (byArray != null) {
            outputStream2.write(byArray);
        }
    }

    protected String getEncoding(byte[] byArray, String string) {
        ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(byArray, string);
        return MimeUtility.getEncoding((DataSource)byteArrayDataSource);
    }

    protected byte[] encodeContentToBytes(byte[] byArray, String string) throws MessagingException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.encodeContent(byArray, string, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected void encodeContent(byte[] byArray, String string, ByteArrayOutputStream byteArrayOutputStream) throws MessagingException, IOException {
        OutputStream outputStream2 = MimeUtility.encode((OutputStream)byteArrayOutputStream, (String)string);
        outputStream2.write(byArray);
        outputStream2.close();
    }

    protected InternetHeaders getHeaders(String string, String string2) {
        InternetHeaders internetHeaders = new InternetHeaders();
        internetHeaders.setHeader("Content-Type", string + "; charset=UTF-8");
        internetHeaders.setHeader("Content-Transfer-Encoding", string2);
        return internetHeaders;
    }

    protected MimeMultipart getMimeMultipart(byte[] byArray, InternetHeaders internetHeaders) throws MessagingException {
        MimeMultipart mimeMultipart = new MimeMultipart();
        MimeBodyPart mimeBodyPart = new MimeBodyPart(internetHeaders, byArray);
        mimeMultipart.addBodyPart((BodyPart)mimeBodyPart);
        return mimeMultipart;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void sendMultipartMessage(MimeMessage mimeMessage, MimeMultipart mimeMultipart) throws MessagingException {
        MimeMessage mimeMessage2 = mimeMessage;
        synchronized (mimeMessage2) {
            mimeMessage.setContent((Multipart)mimeMultipart);
            mimeMessage.setSentDate(new Date());
            Transport.send((Message)mimeMessage);
        }
    }

    private synchronized void connect() {
        if (this.message != null) {
            return;
        }
        try {
            this.message = new MimeMessageBuilder(this.session).setFrom(this.data.from).setReplyTo(this.data.replyto).setRecipients(Message.RecipientType.TO, this.data.f23f30cd6fb).setRecipients(Message.RecipientType.CC, this.data.cc).setRecipients(Message.RecipientType.BCC, this.data.bcc).setSubject(this.data.subject).getMimeMessage();
        }
        catch (MessagingException messagingException) {
            LOGGER.error("Could not set SMTPAppender message options.", (Throwable)messagingException);
            this.message = null;
        }
    }

    private static class SMTPManagerFactory
    implements ManagerFactory<SMTPManager, FactoryData> {
        private SMTPManagerFactory() {
        }

        @Override
        public SMTPManager createManager(String string, FactoryData factoryData) {
            MimeMessage mimeMessage;
            Authenticator authenticator;
            String string2 = "mail." + factoryData.protocol;
            Properties properties = PropertiesUtil.getSystemProperties();
            properties.put("mail.transport.protocol", factoryData.protocol);
            if (properties.getProperty("mail.host") == null) {
                properties.put("mail.host", NetUtils.getLocalHostname());
            }
            if (null != factoryData.host) {
                properties.put(string2 + ".host", factoryData.host);
            }
            if (factoryData.port > 0) {
                properties.put(string2 + ".port", String.valueOf(factoryData.port));
            }
            if (null != (authenticator = this.buildAuthenticator(factoryData.username, factoryData.password))) {
                properties.put(string2 + ".auth", "true");
            }
            Session session = Session.getInstance((Properties)properties, (Authenticator)authenticator);
            session.setProtocolForAddress("rfc822", factoryData.protocol);
            session.setDebug(factoryData.isDebug);
            try {
                mimeMessage = new MimeMessageBuilder(session).setFrom(factoryData.from).setReplyTo(factoryData.replyto).setRecipients(Message.RecipientType.TO, factoryData.f23f30cd6fb).setRecipients(Message.RecipientType.CC, factoryData.cc).setRecipients(Message.RecipientType.BCC, factoryData.bcc).setSubject(factoryData.subject).getMimeMessage();
            }
            catch (MessagingException messagingException) {
                LOGGER.error("Could not set SMTPAppender message options.", (Throwable)messagingException);
                mimeMessage = null;
            }
            return new SMTPManager(string, session, mimeMessage, factoryData);
        }

        private Authenticator buildAuthenticator(final String string, final String string2) {
            if (null != string2 && null != string) {
                return new Authenticator(){
                    private final PasswordAuthentication passwordAuthentication;
                    {
                        this.passwordAuthentication = new PasswordAuthentication(string, string2);
                    }

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return this.passwordAuthentication;
                    }
                };
            }
            return null;
        }
    }

    private static class FactoryData {
        private final String f23f30cd6fb;
        private final String cc;
        private final String bcc;
        private final String from;
        private final String replyto;
        private final String subject;
        private final String protocol;
        private final String host;
        private final int port;
        private final String username;
        private final String password;
        private final boolean isDebug;
        private final int numElements;

        public FactoryData(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n, String string9, String string10, boolean bl, int n2) {
            this.f23f30cd6fb = string;
            this.cc = string2;
            this.bcc = string3;
            this.from = string4;
            this.replyto = string5;
            this.subject = string6;
            this.protocol = string7;
            this.host = string8;
            this.port = n;
            this.username = string9;
            this.password = string10;
            this.isDebug = bl;
            this.numElements = n2;
        }
    }
}

