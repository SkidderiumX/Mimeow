/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.logging.log4j.message.Message;

public class ObjectMessage
implements Message {
    private static final long serialVersionUID = -5903272448334166185L;
    private transient Object obj;

    public ObjectMessage(Object object) {
        if (object == null) {
            object = "null";
        }
        this.obj = object;
    }

    @Override
    public String getFormattedMessage() {
        return this.obj.toString();
    }

    @Override
    public String getFormat() {
        return this.obj.toString();
    }

    @Override
    public Object[] getParameters() {
        return new Object[]{this.obj};
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ObjectMessage objectMessage = (ObjectMessage)object;
        return !(this.obj == null ? objectMessage.obj != null : !this.obj.equals(objectMessage.obj));
    }

    public int hashCode() {
        return this.obj != null ? this.obj.hashCode() : 0;
    }

    public String toString() {
        return "ObjectMessage[obj=" + this.obj.toString() + "]";
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.obj instanceof Serializable) {
            objectOutputStream.writeObject(this.obj);
        } else {
            objectOutputStream.writeObject(this.obj.toString());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.obj = objectInputStream.readObject();
    }

    @Override
    public Throwable getThrowable() {
        return this.obj instanceof Throwable ? (Throwable)this.obj : null;
    }
}

