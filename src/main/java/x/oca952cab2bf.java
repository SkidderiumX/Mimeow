/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import x.oc293826be15;
import x.oc32b50dcd85;
import x.ocae3bb6ecc0;
import x.occ4282ca4a7;
import x.ocdaf6bff4db;
import x.oceb7ed9a2d8;

public class oca952cab2bf {
    public static oc293826be15 \u028c(int n) {
        byte[] byArray;
        int n2;
        Object object;
        String string = n == 1 ? "InterSemiBold.ttf" : "Inter-Medium.ttf";
        try {
            object = occ4282ca4a7.\u026b("/assets/slinkysemantic/fonts/" + string);
            try {
                if (object == null) {
                    throw new IOException("Missing bundled GUI font " + string);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] byArray2 = new byte[0xB47D0FA ^ 0xB47F0FA];
                while ((n2 = ((InputStream)object).read(byArray2)) != -1) {
                    byteArrayOutputStream.write(byArray2, 0, n2);
                }
                byArray = byteArrayOutputStream.toByteArray();
            }
            finally {
                if (object != null) {
                    ((InputStream)object).close();
                }
            }
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Cannot load GUI font", iOException);
        }
        object = new oceb7ed9a2d8(byArray, new oc32b50dcd85(() -> {
            throw new IllegalStateException("GUI glyph scratch capacity exceeded");
        }));
        ((oceb7ed9a2d8)object).\u0109 = oca952cab2bf.\u010f(byArray, "head");
        ((oceb7ed9a2d8)object).\u01dd = oca952cab2bf.\u010f(byArray, "hhea");
        ((oceb7ed9a2d8)object).\u0164 = oca952cab2bf.\u010f(byArray, "hmtx");
        ((oceb7ed9a2d8)object).\u00f0 = oca952cab2bf.\u010f(byArray, "loca");
        ((oceb7ed9a2d8)object).\u03fe = oca952cab2bf.\u010f(byArray, "glyf");
        ((oceb7ed9a2d8)object).\u0531 = oca952cab2bf.\u010f(byArray, "kern");
        ((oceb7ed9a2d8)object).\u0514 = oca952cab2bf.\u010f(byArray, "GPOS");
        ((oceb7ed9a2d8)object).\u056d = ocdaf6bff4db.\u0244(byArray, oca952cab2bf.\u04ac(oca952cab2bf.\u010f(byArray, "maxp")) + (0xB47F0FE ^ 0xB47F0FA));
        ((oceb7ed9a2d8)object).\u027c = ocdaf6bff4db.\u0244(byArray, oca952cab2bf.\u04ac(((oceb7ed9a2d8)object).\u0109) + (0xB47F0C8 ^ 0xB47F0FA));
        int n3 = oca952cab2bf.\u04ac(oca952cab2bf.\u010f(byArray, "cmap"));
        for (int i = 0; i < ocdaf6bff4db.\u0244(byArray, n3 + (0xB47F0F8 ^ 0xB47F0FA)); ++i) {
            n2 = n3 + (0xB47F0FE ^ 0xB47F0FA) + i * (0xB47F0F2 ^ 0xB47F0FA);
            int n4 = n3 + ocdaf6bff4db.\u0425(byArray, n2 + (0xB47F0FE ^ 0xB47F0FA));
            int n5 = ocdaf6bff4db.\u0244(byArray, n4);
            int n6 = ocdaf6bff4db.\u0244(byArray, n2);
            int n7 = ocdaf6bff4db.\u0244(byArray, n2 + (0xB47F0F8 ^ 0xB47F0FA));
            if (n6 != 0 && (n6 != (0xB47F0F9 ^ 0xB47F0FA) || n7 != 1 && n7 != (0xB47F0F0 ^ 0xB47F0FA)) || n5 != (0xB47F0FE ^ 0xB47F0FA) && n5 != (0xB47F0F6 ^ 0xB47F0FA) || ((oceb7ed9a2d8)object).\u0429 != 0 && n5 != (0xB47F0F6 ^ 0xB47F0FA)) continue;
            ((oceb7ed9a2d8)object).\u0429 = n4;
        }
        oca952cab2bf.\u04ac(((oceb7ed9a2d8)object).\u0429);
        oca952cab2bf.\u04ac(((oceb7ed9a2d8)object).\u03fe);
        oca952cab2bf.\u04ac(((oceb7ed9a2d8)object).\u00f0);
        oca952cab2bf.\u04ac(((oceb7ed9a2d8)object).\u01dd);
        oca952cab2bf.\u04ac(((oceb7ed9a2d8)object).\u0164);
        float f = ocdaf6bff4db.\u0534(byArray, ((oceb7ed9a2d8)object).\u01dd + (0xB47F0FE ^ 0xB47F0FA)) - ocdaf6bff4db.\u0534(byArray, ((oceb7ed9a2d8)object).\u01dd + (0xB47F0FC ^ 0xB47F0FA));
        float f2 = (float)ocdaf6bff4db.\u0534(byArray, ((oceb7ed9a2d8)object).\u01dd + (0xB47F0FE ^ 0xB47F0FA)) / f;
        float f3 = (float)ocdaf6bff4db.\u0534(byArray, ((oceb7ed9a2d8)object).\u01dd + (0xB47F0FC ^ 0xB47F0FA)) / f;
        float f4 = (float)ocdaf6bff4db.\u0534(byArray, ((oceb7ed9a2d8)object).\u01dd + (0xB47F0F2 ^ 0xB47F0FA)) / f;
        int[] nArray = new int[0xB47F1FA ^ 0xB47F0FA];
        Arrays.fill(nArray, -1);
        return new oc293826be15(new ocae3bb6ecc0((oceb7ed9a2d8)object, nArray, f2, f3, f2 - f3 + f4), null, 0xB47F2FA ^ 0xB47F0FA, 0xB47F1FA ^ 0xB47F0FA);
    }

    private static int \u04ac(int n) {
        if (n == 0) {
            throw new IllegalStateException("Incomplete bundled TrueType face");
        }
        return n;
    }

    private static int \u010f(byte[] byArray, String string) {
        int n = ocdaf6bff4db.\u0244(byArray, 0x47CB814E ^ 0x47CB814A);
        for (int i = 0; i < n; ++i) {
            int n2 = (0x47CB8146 ^ 0x47CB814A) + i * (0x47CB815A ^ 0x47CB814A);
            boolean bl = true;
            for (int j = 0; j < (0x47CB814E ^ 0x47CB814A); ++j) {
                bl &= byArray[n2 + j] == string.charAt(j);
            }
            if (!bl) continue;
            return ocdaf6bff4db.\u0425(byArray, n2 + (0x47CB8142 ^ 0x47CB814A));
        }
        return 0;
    }

    private oca952cab2bf() {
    }
}

