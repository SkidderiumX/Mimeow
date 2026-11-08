/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import x.oc66fa4f2195;
import x.oc68d6b191af;
import x.oc69da1aa7f5;
import x.oc6e7b992074;
import x.ocae0001283f;
import x.oce4b177fd47;

public class oc04596227b7 {
    private static final Logger \u0420 = LogManager.getLogger(oc04596227b7.class);
    private final Map<Object, List<oc6e7b992074>> \u00eb = Collections.synchronizedMap(new IdentityHashMap());
    private final List<Object> \u0429 = new ArrayList<Object>();
    private volatile oce4b177fd47 O = new oce4b177fd47(Collections.emptyList());
    private long \u00ce;
    public static boolean \u0580;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void register(Object object) {
        boolean bl = oc68d6b191af.\u0215;
        if (object == null) {
            return;
        }
        Map<Object, List<oc6e7b992074>> map = this.\u00eb;
        synchronized (map) {
            block15: {
                Class<?> clazz;
                if (this.\u00eb.containsKey(object)) {
                    return;
                }
                ArrayList<oc6e7b992074> arrayList = new ArrayList<oc6e7b992074>();
                Class<?> clazz2 = object.getClass();
                while (clazz2 != null) {
                    block16: {
                        clazz = clazz2;
                        if (bl) break block15;
                        Method[] methodArray = clazz.getDeclaredMethods();
                        int n = methodArray.length;
                        int n2 = 0;
                        while (n2 < n) {
                            block17: {
                                block18: {
                                    boolean bl2;
                                    oc66fa4f2195 oc66fa4f21952;
                                    Method method;
                                    block23: {
                                        Method method2;
                                        block21: {
                                            block22: {
                                                int n3;
                                                block20: {
                                                    block19: {
                                                        method = methodArray[n2];
                                                        oc66fa4f21952 = method.getAnnotation(oc66fa4f2195.class);
                                                        if (bl) break block17;
                                                        if (bl) break block16;
                                                        if (oc66fa4f21952 == null) break block18;
                                                        n3 = method.getParameterTypes().length;
                                                        if (bl) break block19;
                                                        if (n3 != 1) break block18;
                                                        n3 = oc68d6b191af.class.isAssignableFrom(method.getParameterTypes()[0]) ? 1 : 0;
                                                    }
                                                    if (bl) break block20;
                                                    if (n3 == 0 && !bl) break block18;
                                                    method2 = method;
                                                    if (bl) break block21;
                                                    n3 = Modifier.isPublic(method2.getModifiers()) ? 1 : 0;
                                                }
                                                if (n3 == 0) break block22;
                                                bl2 = method.isAccessible();
                                                if (bl) break block18;
                                                if (bl2) break block23;
                                            }
                                            method2 = method;
                                        }
                                        method2.setAccessible(true);
                                    }
                                    try {
                                        bl2 = arrayList.add(new oc6e7b992074(object, method, method.getParameterTypes()[0], oc66fa4f21952, this.\u00ce++));
                                    }
                                    catch (IllegalAccessException illegalAccessException) {
                                        Object[] objectArray = new Object[0x5483E835 ^ 0x5483E837];
                                        objectArray[0] = method;
                                        objectArray[1] = illegalAccessException;
                                        \u0420.error("Cannot register event listener {}", objectArray);
                                    }
                                }
                                ++n2;
                            }
                            if (!bl) continue;
                        }
                        clazz2 = clazz2.getSuperclass();
                    }
                    if (!bl) continue;
                }
                clazz = this.\u00eb.put(object, arrayList);
            }
            this.\u0429.add(object);
            this.rebuildSnapshot();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void unregister(Object object) {
        boolean bl;
        block7: {
            block6: {
                bl = oc68d6b191af.\u0215;
                Map<Object, List<oc6e7b992074>> map = this.\u00eb;
                // MONITORENTER : map
                if (bl) break block6;
                if (this.\u00eb.remove(object) == null) break block7;
                this.removeOwnerFromOrder(object);
            }
            this.rebuildSnapshot();
        }
        // MONITOREXIT : map
        if (!bl) return;
        boolean bl2 = true;
        oc69da1aa7f5.\u04ac = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean post(oc68d6b191af oc68d6b191af2) {
        if (oc68d6b191af2 == null) {
            return false;
        }
        oce4b177fd47 oce4b177fd472 = this.O;
        Iterator<oc6e7b992074> iterator2 = oce4b177fd472.\u0564(oc68d6b191af2.getClass()).iterator();
        while (iterator2.hasNext()) {
            oc6e7b992074 oc6e7b9920742 = iterator2.next();
            if (oc68d6b191af2.isCanceled() && !oc6e7b9920742.\u047b) continue;
            try {
                oc6e7b9920742.\u01a5.invokeExact(oc68d6b191af2);
            }
            catch (Throwable throwable) {
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                Object[] objectArray = new Object[0x86A81491 ^ 0x86A81492];
                objectArray[0] = oc6e7b9920742.Y;
                objectArray[1] = oc68d6b191af2.getClass().getName();
                objectArray[0x86A81490 ^ 0x86A81492] = throwable;
                \u0420.error("Event listener {} failed for {}", objectArray);
                continue;
            }
            break;
        }
        return oc68d6b191af2.isCanceled();
    }

    private void rebuildSnapshot() {
        block5: {
            ArrayList<oc6e7b992074> arrayList = new ArrayList<oc6e7b992074>();
            boolean bl = oc68d6b191af.\u0215;
            for (Object object : this.\u0429) {
                block6: {
                    List<oc6e7b992074> list = this.\u00eb.get(object);
                    if (bl) break block5;
                    if (list == null) break block6;
                    arrayList.addAll(list);
                }
                if (!bl) continue;
            }
            Collections.sort(arrayList, new ocae0001283f(this));
            this.O = new oce4b177fd47(Collections.unmodifiableList(arrayList));
        }
    }

    private void removeOwnerFromOrder(Object object) {
        boolean bl = oc68d6b191af.\u0215;
        for (int i = 0; i < this.\u0429.size(); ++i) {
            block5: {
                Object object2 = this.\u0429;
                if (bl) break block5;
                if (object2.get(i) != object) continue;
                object2 = this.\u0429.remove(i);
            }
            return;
        }
    }
}

