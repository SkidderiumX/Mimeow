/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.ocd8ecc8a91a;

public class ocbfb02edab6 {
    private ocbfb02edab6() {
    }

    private static long \u0184(int n) {
        return ocd8ecc8a91a.\u0147(n);
    }

    private static double \u0544(int n) {
        return ocd8ecc8a91a.\u042d(n);
    }

    public static long \u050c(long l, long l2) {
        long l3 = l & (0x176462971E098F84L ^ 0x17646297E1F6707BL);
        long l4 = l2 & (0x176462971E098F84L ^ 0x17646297E1F6707BL);
        long l5 = l >>> (0x3C456AE8 ^ 0x3C456AC8);
        long l6 = l2 >>> (0x3C456AE8 ^ 0x3C456AC8);
        long l7 = l3 * l4;
        long l8 = l5 * l4;
        long l9 = l3 * l6;
        long l10 = (l7 >>> (0x3C456AE8 ^ 0x3C456AC8)) + (l8 & (0x176462971E098F84L ^ 0x17646297E1F6707BL)) + (l9 & (0x176462971E098F84L ^ 0x17646297E1F6707BL));
        return l5 * l6 + (l8 >>> (0x3C456AE8 ^ 0x3C456AC8)) + (l9 >>> (0x3C456AE8 ^ 0x3C456AC8)) + (l10 >>> (0x3C456AE8 ^ 0x3C456AC8));
    }

    public static double \u04fb(double d) {
        long l = Double.doubleToRawLongBits(d);
        return Double.longBitsToDouble(Long.compareUnsigned(l & (0x5EF26F7E52FB9B8FL ^ 0x210D9081AD046470L), 0x5EFD9081AD046470L ^ 0x210D9081AD046470L) > 0 ? l | 0x21059081AD046470L ^ 0x210D9081AD046470L : 0xDEF59081AD046470L ^ 0x210D9081AD046470L);
    }

    public static double \u01c7(double d) {
        long l = Double.doubleToRawLongBits(d);
        long l2 = l >>> (0xFCE07A06 ^ 0xFCE07A32);
        if (Long.compareUnsigned(l2 - (0xA80195B05B1D0B58L ^ 0xA80195B05B1D0CA7L), 0x57FE6A4FA4E2F4A5L ^ 0xA80195B05B1D0CA7L) < 0) {
            if (d == 0.0 || l == (0xD7F195B05B1D0CA7L ^ 0xA80195B05B1D0CA7L)) {
                return d;
            }
            if (Long.compareUnsigned(l, 0xD7F195B05B1D0CA7L ^ 0xA80195B05B1D0CA7L) > 0) {
                return ocbfb02edab6.\u04fb(d);
            }
            l = Double.doubleToRawLongBits(d *= ocbfb02edab6.\u0544(0xFCCBCD0A ^ 0xFCE07A32));
            l2 = (l >>> (0xFCE07A06 ^ 0xFCE07A32)) - (0xA80195B05B1D0C93L ^ 0xA80195B05B1D0CA7L);
        }
        long l3 = l << (0xFCE07A39 ^ 0xFCE07A32) | 0x280195B05B1D0CA7L ^ 0xA80195B05B1D0CA7L;
        if ((l2 & 1L) != 0L) {
            l3 = l << (0xFCE07A38 ^ 0xFCE07A32) & (0xD7FE6A4FA4E2F0A7L ^ 0xA80195B05B1D0CA7L);
        }
        long l4 = (long)ocd8ecc8a91a.\u0575((0xFCCBA572 ^ 0xFCE07A32) + (0xFCE07A30 ^ 0xFCE07A32) * (int)(l >>> (0xFCE07A1C ^ 0xFCE07A32) & (0xA80195B05B1D0CD8L ^ 0xA80195B05B1D0CA7L))) << (0xFCE07A22 ^ 0xFCE07A32);
        long l5 = (l3 >>> (0xFCE07A12 ^ 0xFCE07A32)) * l4 >>> (0xFCE07A12 ^ 0xFCE07A32);
        long l6 = l5 * l4 >>> (0xFCE07A12 ^ 0xFCE07A32);
        int n = (0x3CE07A32 ^ 0xFCE07A32) - (int)l6;
        l4 = l4 * ((long)n & (0xA80195B0A4E2F358L ^ 0xA80195B05B1D0CA7L)) >>> (0xFCE07A2D ^ 0xFCE07A32) & (0xA80195B0A4E2F359L ^ 0xA80195B05B1D0CA7L);
        l5 = l5 * ((long)n & (0xA80195B0A4E2F358L ^ 0xA80195B05B1D0CA7L)) >>> (0xFCE07A2D ^ 0xFCE07A32) & (0xA80195B0A4E2F359L ^ 0xA80195B05B1D0CA7L);
        n = (0x3CE07A32 ^ 0xFCE07A32) - (int)(l5 * l4 >>> (0xFCE07A12 ^ 0xFCE07A32));
        long l7 = (0xA80195B05B1D0CA5L ^ 0xA80195B05B1D0CA7L) * ((long)n & (0xA80195B0A4E2F358L ^ 0xA80195B05B1D0CA7L)) * l4 & (0x57FE6A4E5B1D0CA7L ^ 0xA80195B05B1D0CA7L);
        l5 = ocbfb02edab6.\u050c(l7, l3);
        l5 = ocbfb02edab6.\u050c(l5, (0x680195B05B1D0CA7L ^ 0xA80195B05B1D0CA7L) - ocbfb02edab6.\u050c(l5, l7));
        l5 = l5 - (0xA80195B05B1D0CA5L ^ 0xA80195B05B1D0CA7L) >>> (0xFCE07A3B ^ 0xFCE07A32);
        long l8 = l5 * l5 - (l3 <<= 0xFCE07A18 ^ 0xFCE07A32) + l5;
        long l9 = l5 + (l8 >>> (0xFCE07A0D ^ 0xFCE07A32));
        long l10 = l5 + l8;
        long l11 = (0xB7F995B05B1D0CA7L ^ 0xA80195B05B1D0CA7L) + (l2 << (0xFCE07A01 ^ 0xFCE07A32)) & (0x57F195B05B1D0CA7L ^ 0xA80195B05B1D0CA7L) | l9 & (0xA80E6A4FA4E2F358L ^ 0xA80195B05B1D0CA7L);
        double d2 = Double.longBitsToDouble(l11);
        if (++l10 != 0L) {
            long l12 = 0xA81195B05B1D0CA7L ^ 0xA80195B05B1D0CA7L | (l10 ^ l8) & (0x280195B05B1D0CA7L ^ 0xA80195B05B1D0CA7L);
            d2 += Double.longBitsToDouble(l12);
        }
        return d2;
    }

    public static double \u025d(double d, int n) {
        int n2;
        int n3;
        long l = Double.doubleToRawLongBits(d);
        int n4 = (int)(l >>> (0x97546DAA ^ 0x97546D9E) & (0xB6504AEE737B5F14L ^ 0xB6504AEE737B58EBL));
        if (n4 == (0x97546A61 ^ 0x97546D9E)) {
            return d;
        }
        long l2 = l & (0x36504AEE737B58EBL ^ 0xB6504AEE737B58EBL);
        long l3 = l * (0xB6504AEE737B58E9L ^ 0xB6504AEE737B58EBL);
        int n5 = n3 = l3 != 0L ? (0x97546DA1 ^ 0x97546D9E) - Long.numberOfLeadingZeros(l3) : 0x97546DE1 ^ 0x97546D9E;
        int n6 = n4 != 0 ? n4 : (n2 = l3 != 0L ? n3 - (0x97546DAA ^ 0x97546D9E) : 0x68AB9255 ^ 0x97546D9E);
        if (n >= 0) {
            if (n > (0x97546A60 ^ 0x97546D9E) - n2) {
                return Double.longBitsToDouble(l & ocbfb02edab6.\u0184(0x977FDD1E ^ 0x97546D9E) | ocbfb02edab6.\u0184(0x977FDD0E ^ 0x97546D9E));
            }
            int n7 = n2 + n;
            if (n7 <= 0) {
                return Double.longBitsToDouble(l << n | l2);
            }
            if (n2 > 0) {
                return Double.longBitsToDouble(l + ((long)n << (0x97546DAA ^ 0x97546D9E)));
            }
            long l4 = l << 1 - n2 & (0xB65FB5118C84A714L ^ 0xB6504AEE737B58EBL);
            return Double.longBitsToDouble(l4 | (long)n7 << (0x97546DAA ^ 0x97546D9E) | l2);
        }
        int n8 = -n;
        if (n > -n2) {
            return Double.longBitsToDouble(l - (((long)n8 & (0xB6504AEE8C84A714L ^ 0xB6504AEE737B58EBL)) << (0x97546DAA ^ 0x97546D9E)));
        }
        if (n < (0x68AB9252 ^ 0x97546D9E) - n2) {
            return Double.longBitsToDouble(l2);
        }
        int n9 = n + n2;
        int n10 = (Integer.compareUnsigned(n8, 1 - n9) < 0 ? n8 : 1 - n9) - 1 & (0x97546DA1 ^ 0x97546D9E);
        boolean bl = Long.numberOfTrailingZeros(l) == n10;
        long l5 = l & (0xB65FB5118C84A714L ^ 0xB6504AEE737B58EBL) | (n2 > 0 ? 0xB6404AEE737B58EBL ^ 0xB6504AEE737B58EBL : 0L);
        long l6 = (l5 >>> n10) + 1L >>> 1;
        return Double.longBitsToDouble(l & ocbfb02edab6.\u0184(0x977FDD1E ^ 0x97546D9E) | (l6 &= (bl ? 1L : 0L) ^ (0x49AFB5118C84A714L ^ 0xB6504AEE737B58EBL)) & ocbfb02edab6.\u0184(0x977FDDEE ^ 0x97546D9E));
    }

    public static double O(double d) {
        long l = Double.doubleToRawLongBits(d);
        long l2 = l >>> (0xD0158081 ^ 0xD01580B5) & (0x2AB14759C8448C73L ^ 0x2AB14759C8448B8CL);
        if (l2 < (0x2AB14759C8448FBFL ^ 0x2AB14759C8448B8CL) && d != 0.0) {
            double d2;
            double d3 = ocbfb02edab6.\u0544(0xD03E462D ^ 0xD01580B5);
            double d4 = ocbfb02edab6.\u0544(0xD03E4615 ^ 0xD01580B5);
            double d5 = ocbfb02edab6.\u0544(0xD03E461D ^ 0xD01580B5);
            boolean bl = l < 0L;
            double d6 = d2 = bl ? d3 + (d4 + d) - d : d3 + d + d4 - d;
            if (l2 <= (0x2AB14759C8448872L ^ 0x2AB14759C8448B8CL)) {
                return bl ? d5 : 0.0;
            }
            double d7 = d + d2;
            return d2 > 0.0 ? d7 + d5 : d7;
        }
        return d;
    }

    public static double c(double d, double d2) {
        long l = Double.doubleToRawLongBits(d);
        long l2 = Double.doubleToRawLongBits(d2);
        long l3 = l & (0xE52B7CABA9F3E850L ^ 0x652B7CABA9F3E850L);
        long l4 = l & (0x1AD48354560C17AFL ^ 0x652B7CABA9F3E850L);
        long l5 = l2 & (0x1AD48354560C17AFL ^ 0x652B7CABA9F3E850L);
        int n = (int)(l4 >>> (0x446238C0 ^ 0x446238F4));
        int n2 = (int)(l5 >>> (0x446238C0 ^ 0x446238F4));
        if (l5 != 0L && l5 <= (0x1ADB7CABA9F3E850L ^ 0x652B7CABA9F3E850L) && n != (0x44623F0B ^ 0x446238F4)) {
            if (l4 <= l5) {
                return l4 == l5 ? Double.longBitsToDouble(l3) : d;
            }
            if (n != 0) {
                l4 = l4 & (0x65248354560C17AFL ^ 0x652B7CABA9F3E850L) | 0x653B7CABA9F3E850L ^ 0x652B7CABA9F3E850L;
            } else {
                n = 1;
                while (l4 < (0x653B7CABA9F3E850L ^ 0x652B7CABA9F3E850L)) {
                    l4 <<= 1;
                    --n;
                }
            }
            if (n2 != 0) {
                l5 = l5 & (0x65248354560C17AFL ^ 0x652B7CABA9F3E850L) | 0x653B7CABA9F3E850L ^ 0x652B7CABA9F3E850L;
            } else {
                n2 = 1;
                while (l5 < (0x653B7CABA9F3E850L ^ 0x652B7CABA9F3E850L)) {
                    l5 <<= 1;
                    --n2;
                }
            }
            while (n > n2) {
                if (l4 >= l5 && (l4 -= l5) == 0L) {
                    return Double.longBitsToDouble(l3);
                }
                l4 <<= 1;
                --n;
            }
            if (l4 >= l5 && (l4 -= l5) == 0L) {
                return Double.longBitsToDouble(l3);
            }
            while (l4 < (0x653B7CABA9F3E850L ^ 0x652B7CABA9F3E850L)) {
                l4 <<= 1;
                --n;
            }
            l4 = n > 0 ? l4 - (0x653B7CABA9F3E850L ^ 0x652B7CABA9F3E850L) | (long)n << (0x446238C0 ^ 0x446238F4) : (l4 >>>= 1 - n);
            return Double.longBitsToDouble(l4 | l3);
        }
        if (l4 > (0x1ADB7CABA9F3E850L ^ 0x652B7CABA9F3E850L)) {
            return ocbfb02edab6.\u04fb(d);
        }
        return l5 > (0x1ADB7CABA9F3E850L ^ 0x652B7CABA9F3E850L) ? ocbfb02edab6.\u04fb(d2) : Double.longBitsToDouble(0x9AD37CABA9F3E850L ^ 0x652B7CABA9F3E850L);
    }
}

