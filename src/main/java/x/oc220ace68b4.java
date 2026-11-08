/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import x.occ4282ca4a7;

public class oc220ace68b4 {
    private static final String[] \u0107 = oc220ace68b4.\u020f();

    private oc220ace68b4() {
    }

    private static String[] \u020f() {
        String[] stringArray;
        InputStream inputStream2 = occ4282ca4a7.\u026b("/assets/slinkysemantic/KeyNames.json");
        if (inputStream2 == null) {
            return new String[]{"NONE"};
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, "UTF-8");
        try {
            JsonArray jsonArray = new JsonParser().parse(inputStreamReader).getAsJsonArray();
            String[] stringArray2 = new String[jsonArray.size()];
            for (int i = 0; i < stringArray2.length; ++i) {
                stringArray2[i] = jsonArray.get(i).getAsString();
            }
            stringArray = stringArray2;
        }
        catch (Throwable throwable) {
            try {
                try {
                    ((Reader)inputStreamReader).close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                return new String[]{"NONE"};
            }
        }
        ((Reader)inputStreamReader).close();
        return stringArray;
    }

    public static String b(int n) {
        if (n <= 0 || n >= \u0107.length) {
            return \u0107[0];
        }
        return \u0107[n];
    }
}

