/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;
import x.oce6044968f8;

public class oca26bed83cb {
    private final int \u0142;
    final int V;
    final double \u0454;
    final double \u0402;
    final double \u03b0;

    oca26bed83cb(int n, double d, double d2, double d3) {
        this.V = n;
        this.\u0454 = d;
        this.\u0402 = d2;
        this.\u03b0 = d3;
        Object[] objectArray = new Object[0xFDD8F533 ^ 0xFDD8F537];
        objectArray[0] = n;
        objectArray[1] = (int)d;
        objectArray[0xFDD8F535 ^ 0xFDD8F537] = (int)d2;
        objectArray[0xFDD8F534 ^ 0xFDD8F537] = (int)d3;
        this.\u0142 = Objects.hash(objectArray);
    }

    public boolean equals(Object object) {
        int n;
        block32: {
            block29: {
                double d;
                block31: {
                    double d2;
                    oca26bed83cb oca26bed83cb2;
                    boolean bl;
                    block30: {
                        oca26bed83cb oca26bed83cb3;
                        int n2;
                        block28: {
                            Object object2;
                            block26: {
                                block27: {
                                    block24: {
                                        block25: {
                                            bl = oce6044968f8.\u0452;
                                            object2 = this;
                                            if (bl) break block24;
                                            if (object2 != object) break block25;
                                            return true;
                                        }
                                        object2 = object;
                                    }
                                    if (bl) break block26;
                                    if (object2 instanceof oca26bed83cb) break block27;
                                    return false;
                                }
                                object2 = object;
                            }
                            oca26bed83cb2 = (oca26bed83cb)object2;
                            n2 = this.V;
                            oca26bed83cb3 = oca26bed83cb2;
                            if (bl) break block28;
                            if (n2 != oca26bed83cb3.V) break block29;
                            d2 = this.\u0454;
                            if (bl) break block30;
                            n2 = (int)d2;
                            oca26bed83cb3 = oca26bed83cb2;
                        }
                        if (n2 != (int)oca26bed83cb3.\u0454) break block29;
                        d2 = this.\u0402;
                    }
                    n = (int)d2;
                    d = oca26bed83cb2.\u0402;
                    if (bl) break block31;
                    if (n != (int)d) break block29;
                    n = (int)this.\u03b0;
                    if (bl) break block32;
                    d = oca26bed83cb2.\u03b0;
                }
                if (n != (int)d) break block29;
                n = 1;
                break block32;
            }
            n = false;
        }
        return n != 0;
    }

    public int hashCode() {
        return this.\u0142;
    }
}

