/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import x.F;
import x.oc0af730cc9f;
import x.oc10354c7bb8;
import x.oc2ec6a95e5c;
import x.oc2ef79a3df1;
import x.oc43fdb4c5d3;
import x.oc63848f8f74;
import x.oc920065c394;
import x.oc9be9d1e2c8;

public class oc9c5bf76ff7 {
    private static List<oc63848f8f74> \u024e;
    private static List<oc63848f8f74> \u01da;

    private oc9c5bf76ff7() {
    }

    static List<oc63848f8f74> \u03b1(oc10354c7bb8 oc10354c7bb82) {
        if (oc10354c7bb82 instanceof oc0af730cc9f) {
            return oc9be9d1e2c8.\u01d2("", new oc0af730cc9f("Potions")).stream().map(occ36fe312d92 -> new oc63848f8f74(occ36fe312d92.\u01b6, occ36fe312d92.\u03e2)).toList();
        }
        if (oc10354c7bb82 instanceof oc2ec6a95e5c) {
            if (\u024e == null) {
                LinkedHashMap<String, oc63848f8f74> linkedHashMap = new LinkedHashMap<String, oc63848f8f74>();
                for (oc2ef79a3df1 oc2ef79a3df12 : oc920065c394.\u04a4()) {
                    linkedHashMap.put(oc2ef79a3df12.\u0468, new oc63848f8f74(oc2ef79a3df12.\u0466, oc2ef79a3df12.\u0468));
                    String string = oc920065c394.\u03d1(oc2ef79a3df12.\u0468);
                    if (string == null || oc920065c394.\u04db(string).size() <= 1) continue;
                    String string2 = oc920065c394.\u00f8(string);
                    linkedHashMap.putIfAbsent(string2, new oc63848f8f74(oc920065c394.\u049f(string2), string2));
                }
                \u024e = oc9c5bf76ff7.\u0192(linkedHashMap);
            }
            return \u024e;
        }
        if (\u01da == null) {
            LinkedHashMap<String, oc63848f8f74> linkedHashMap = new LinkedHashMap<String, oc63848f8f74>();
            for (oc43fdb4c5d3 oc43fdb4c5d32 : F.\u00e5()) {
                linkedHashMap.put(oc43fdb4c5d32.\u020e, new oc63848f8f74(oc43fdb4c5d32.\u00ed, oc43fdb4c5d32.\u020e));
                String string = F.\u0519(oc43fdb4c5d32.\u020e);
                if (string == null || F.\u038e(string).size() <= 1) continue;
                String string3 = string + ":*";
                linkedHashMap.putIfAbsent(string3, new oc63848f8f74(F.\u0370(string3), string3));
            }
            \u01da = oc9c5bf76ff7.\u0192(linkedHashMap);
        }
        return \u01da;
    }

    private static List<oc63848f8f74> \u0192(Map<String, oc63848f8f74> map) {
        return map.values().stream().sorted(Comparator.comparing(oc63848f8f74::\u046a, String.CASE_INSENSITIVE_ORDER).thenComparing(oc63848f8f74::\u03d9)).toList();
    }
}

