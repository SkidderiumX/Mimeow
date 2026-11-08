/*
 * Decompiled with CFR 0.152.
 */
package x;

public class ClientNativeBridge {
    private ClientNativeBridge() {
    }

    public static int \u04bd(int n, int n2, long l) {
        long l2 = (long)n << (0x8D7A7943 ^ 0x8D7A7963) ^ (long)n2 & (0x3FEA37147EB2C495L ^ 0x3FEA3714814D3B6AL) ^ l;
        l2 ^= l2 << (0x8D7A796E ^ 0x8D7A7963);
        l2 ^= l2 >>> (0x8D7A7964 ^ 0x8D7A7963);
        l2 ^= l2 << (0x8D7A7972 ^ 0x8D7A7963);
        return (int)(l2 ^ l2 >>> (0x8D7A7943 ^ 0x8D7A7963));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static long \u03a5(Class<?> clazz, String string, int n, int n2) {
        String string2 = clazz.getName();
        long l = 0xCE9EA5A5856F7371L ^ 0xEAA1CF2D00CC7BA2L;
        l ^= 0x215353C984EE5887L ^ 0xEAA1CF2D00CC7BA2L;
        for (int i = 0; i < string2.length(); l *= 0xEAA1CE2D00CC7A11L ^ 0xEAA1CF2D00CC7BA2L, ++i) {
            l ^= (long)string2.charAt(i);
        }
        long l2 = 0xF9B8450303BC08E6L ^ 0xEAA1CF2D00CC7BA2L;
        l2 ^= 0x6E83EC08CB3EE746L ^ 0xEAA1CF2D00CC7BA2L;
        int n3 = 0;
        while (true) {
            if (n3 >= string.length()) {
                long l3 = l ^ Long.rotateLeft(l2, 0x65A98A42 ^ 0x65A98A55) ^ (long)n << (0x65A98A75 ^ 0x65A98A55) ^ (long)n & (0xEAA1CF2DFF33845DL ^ 0xEAA1CF2D00CC7BA2L) ^ (0x7496B6947F8607B7L ^ 0xEAA1CF2D00CC7BA2L) * ((long)n2 + 1L);
                l3 ^= l3 >>> (0x65A98A4B ^ 0x65A98A55);
                l3 *= 0x55F988401C289E1BL ^ 0xEAA1CF2D00CC7BA2L;
                l3 ^= l3 >>> (0x65A98A4E ^ 0x65A98A55);
                return (l3 *= 0x7E71869613FD6A49L ^ 0xEAA1CF2D00CC7BA2L) ^ l3 >>> (0x65A98A4A ^ 0x65A98A55);
            }
            l2 ^= (long)string.charAt(n3);
            l2 *= 0xEAA1CE2D00CC7A11L ^ 0xEAA1CF2D00CC7BA2L;
            ++n3;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static long \u0266(Class<?> clazz, byte[] byArray, int n, int n2) {
        long l;
        long l2;
        String string = clazz.getName();
        long l3 = l2 = 0x4E379638BA15429FL ^ 0x5D2E1C16B96531DBL;
        l2 ^= 0x96DC80F23D4712FEL ^ 0x5D2E1C16B96531DBL;
        for (int i = 0; i < string.length(); l2 *= 0x5D2E1D16B9653068L ^ 0x5D2E1C16B96531DBL, ++i) {
            l2 ^= (long)string.charAt(i);
        }
        long l4 = 0x7911769E3CC63908L ^ 0x5D2E1C16B96531DBL;
        l4 ^= l2;
        byte[] byArray2 = byArray;
        int n3 = byArray2.length;
        for (int i = 0; i < n3; l4 *= 0x5D2E1D16B9653068L ^ 0x5D2E1C16B96531DBL, ++i) {
            byte by = byArray2[i];
            l4 ^= (long)by & (0x5D2E1C16B9653124L ^ 0x5D2E1C16B96531DBL);
        }
        l4 ^= Long.rotateLeft(l3, n & (0xD7A2E8EC ^ 0xD7A2E8D3)) ^ (0x8C9B562468F7DCD8L ^ 0x5D2E1C16B96531DBL) * ((long)n + 1L) ^ (0xC9FE55ADAA542030L ^ 0x5D2E1C16B96531DBL) * ((long)n2 + 1L);
        l4 ^= l4 >>> (0xD7A2E8CD ^ 0xD7A2E8D3);
        l4 *= 0xE2765B7BA581D462L ^ 0x5D2E1C16B96531DBL;
        l4 ^= l4 >>> (0xD7A2E8C8 ^ 0xD7A2E8D3);
        l4 *= 0xC9FE55ADAA542030L ^ 0x5D2E1C16B96531DBL;
        if ((l4 ^= l4 >>> (0xD7A2E8CC ^ 0xD7A2E8D3)) != 0L) {
            l = l4;
            return l;
        }
        l = 0xC31965AFC62F4DCEL ^ 0x5D2E1C16B96531DBL;
        return l;
    }

    public static int \u0451(int n, int n2) {
        long l = 0xB87B93972B19001L ^ 0x2FB8D3B1F71298D2L ^ ((long)n & (0x2FB8D3B108ED672DL ^ 0x2FB8D3B1F71298D2L)) * (0xB18FAA088858E4C7L ^ 0x2FB8D3B1F71298D2L) ^ Long.rotateLeft(0x3CA1599FF462EB96L ^ 0x2FB8D3B1F71298D2L, n2 & (0x5BDFBABE ^ 0x5BDFBA81)) ^ ((long)n2 & (0x2FB8D3B108ED672DL ^ 0x2FB8D3B1F71298D2L)) * (0xFE0D9983268075D1L ^ 0x2FB8D3B1F71298D2L);
        l ^= l >>> (0x5BDFBA9F ^ 0x5BDFBA81);
        l *= 0x90E094DCEBF67D6BL ^ 0x2FB8D3B1F71298D2L;
        l ^= l >>> (0x5BDFBA9A ^ 0x5BDFBA81);
        l *= 0xBB689A0AE4238939L ^ 0x2FB8D3B1F71298D2L;
        l ^= l >>> (0x5BDFBA9E ^ 0x5BDFBA81);
        return (int)(l ^ l >>> (0x5BDFBAA1 ^ 0x5BDFBA81));
    }
}

