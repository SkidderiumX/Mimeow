/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.multipart.AbstractDiskHttpData;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.FileUpload;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class DiskFileUpload
extends AbstractDiskHttpData
implements FileUpload {
    public static String baseDirectory;
    public static boolean deleteOnExitTemporaryFile;
    public static final String prefix = "FUp_";
    public static final String postfix = ".tmp";
    private String filename;
    private String contentType;
    private String contentTransferEncoding;

    public DiskFileUpload(String string, String string2, String string3, String string4, Charset charset, long l) {
        super(string, charset, l);
        this.setFilename(string2);
        this.setContentType(string3);
        this.setContentTransferEncoding(string4);
    }

    @Override
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.FileUpload;
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public void setFilename(String string) {
        if (string == null) {
            throw new NullPointerException("filename");
        }
        this.filename = string;
    }

    public int hashCode() {
        return this.getName().hashCode();
    }

    public boolean equals(Object object) {
        if (!(object instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute)object;
        return this.getName().equalsIgnoreCase(attribute.getName());
    }

    @Override
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (!(interfaceHttpData instanceof FileUpload)) {
            throw new ClassCastException("Cannot compare " + (Object)((Object)this.getHttpDataType()) + " with " + (Object)((Object)interfaceHttpData.getHttpDataType()));
        }
        return this.compareTo((FileUpload)interfaceHttpData);
    }

    @Override
    public int compareTo(FileUpload fileUpload) {
        int n = this.getName().compareToIgnoreCase(fileUpload.getName());
        if (n != 0) {
            return n;
        }
        return n;
    }

    @Override
    public void setContentType(String string) {
        if (string == null) {
            throw new NullPointerException("contentType");
        }
        this.contentType = string;
    }

    @Override
    public String getContentType() {
        return this.contentType;
    }

    @Override
    public String getContentTransferEncoding() {
        return this.contentTransferEncoding;
    }

    @Override
    public void setContentTransferEncoding(String string) {
        this.contentTransferEncoding = string;
    }

    public String toString() {
        return "Content-Disposition: form-data; name=\"" + this.getName() + "\"; " + "filename" + "=\"" + this.filename + "\"\r\n" + "Content-Type" + ": " + this.contentType + (this.charset != null ? "; charset=" + this.charset + "\r\n" : "\r\n") + "Content-Length" + ": " + this.length() + "\r\n" + "Completed: " + this.isCompleted() + "\r\nIsInMemory: " + this.isInMemory() + "\r\nRealFile: " + (this.file != null ? this.file.getAbsolutePath() : "null") + " DefaultDeleteAfter: " + deleteOnExitTemporaryFile;
    }

    @Override
    protected boolean deleteOnExit() {
        return deleteOnExitTemporaryFile;
    }

    @Override
    protected String getBaseDirectory() {
        return baseDirectory;
    }

    @Override
    protected String getDiskFilename() {
        File file = new File(this.filename);
        return file.getName();
    }

    @Override
    protected String getPostfix() {
        return postfix;
    }

    @Override
    protected String getPrefix() {
        return prefix;
    }

    @Override
    public FileUpload copy() {
        DiskFileUpload diskFileUpload = new DiskFileUpload(this.getName(), this.getFilename(), this.getContentType(), this.getContentTransferEncoding(), this.getCharset(), this.size);
        ByteBuf byteBuf = this.content();
        if (byteBuf != null) {
            try {
                diskFileUpload.setContent(byteBuf.copy());
            }
            catch (IOException iOException) {
                throw new ChannelException(iOException);
            }
        }
        return diskFileUpload;
    }

    @Override
    public FileUpload duplicate() {
        DiskFileUpload diskFileUpload = new DiskFileUpload(this.getName(), this.getFilename(), this.getContentType(), this.getContentTransferEncoding(), this.getCharset(), this.size);
        ByteBuf byteBuf = this.content();
        if (byteBuf != null) {
            try {
                diskFileUpload.setContent(byteBuf.duplicate());
            }
            catch (IOException iOException) {
                throw new ChannelException(iOException);
            }
        }
        return diskFileUpload;
    }

    @Override
    public FileUpload retain(int n) {
        super.retain(n);
        return this;
    }

    @Override
    public FileUpload retain() {
        super.retain();
        return this;
    }

    static {
        deleteOnExitTemporaryFile = true;
    }
}

