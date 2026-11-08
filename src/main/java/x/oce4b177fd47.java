/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import x.oc68d6b191af;
import x.oc6e7b992074;

public class oce4b177fd47 {
    private final List<oc6e7b992074> \u01e1;
    private final ConcurrentMap<Class<?>, List<oc6e7b992074>> \u03da = new ConcurrentHashMap();

    private oce4b177fd47(List<oc6e7b992074> list) {
        this.\u01e1 = list;
    }

    private List<oc6e7b992074> \u0564(Class<?> clazz) {
        return this.\u03da.computeIfAbsent(clazz, this::\u0498);
    }

    private List<oc6e7b992074> \u0498(Class<?> clazz) {
        List<oc6e7b992074> list;
        block14: {
            ArrayList<oc6e7b992074> arrayList;
            block13: {
                ArrayList<oc6e7b992074> arrayList2;
                block11: {
                    arrayList2 = new ArrayList<oc6e7b992074>();
                    boolean bl = oc68d6b191af.\u0215;
                    for (oc6e7b992074 oc6e7b9920742 : this.\u01e1) {
                        block12: {
                            if (bl) break block11;
                            boolean bl2 = oc6e7b9920742.\u0568.isAssignableFrom(clazz);
                            if (bl) break block12;
                            if (!bl2) break block12;
                            bl2 = arrayList2.add(oc6e7b9920742);
                        }
                        if (!bl) continue;
                    }
                    arrayList = arrayList2;
                    if (bl) break block13;
                    if (!arrayList.isEmpty()) break block11;
                    list = Collections.emptyList();
                    break block14;
                }
                arrayList = arrayList2;
            }
            list = Collections.unmodifiableList(arrayList);
        }
        return list;
    }
}

