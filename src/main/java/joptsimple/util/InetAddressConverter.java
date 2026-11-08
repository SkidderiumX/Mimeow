/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import joptsimple.ValueConversionException;
import joptsimple.ValueConverter;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class InetAddressConverter
implements ValueConverter<InetAddress> {
    @Override
    public InetAddress convert(String string) {
        try {
            return InetAddress.getByName(string);
        }
        catch (UnknownHostException unknownHostException) {
            throw new ValueConversionException("Cannot convert value [" + string + " into an InetAddress", unknownHostException);
        }
    }

    @Override
    public Class<InetAddress> valueType() {
        return InetAddress.class;
    }

    @Override
    public String valuePattern() {
        return null;
    }
}

