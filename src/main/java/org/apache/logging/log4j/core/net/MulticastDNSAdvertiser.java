/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.helpers.Integers;
import org.apache.logging.log4j.core.net.Advertiser;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="multicastdns", category="Core", elementType="advertiser", printObject=false)
public class MulticastDNSAdvertiser
implements Advertiser {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    private static Object jmDNS = MulticastDNSAdvertiser.initializeJMDNS();
    private static Class<?> jmDNSClass;
    private static Class<?> serviceInfoClass;

    @Override
    public Object advertise(Map<String, String> map) {
        Map.Entry<String, String> entry2;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (entry2.getKey().length() > 255 || entry2.getValue().length() > 255) continue;
            hashMap.put(entry2.getKey(), (String)entry2.getValue());
        }
        String string = (String)hashMap.get("protocol");
        entry2 = "._log4j._" + (String)(string != null ? string : "tcp") + ".local.";
        String string2 = (String)hashMap.get("port");
        int n = Integers.parseInt(string2, 4555);
        String string3 = (String)hashMap.get("name");
        if (jmDNS != null) {
            boolean bl = false;
            try {
                jmDNSClass.getMethod("create", null);
                bl = true;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            Object object = bl ? this.buildServiceInfoVersion3((String)((Object)entry2), n, string3, hashMap) : this.buildServiceInfoVersion1((String)((Object)entry2), n, string3, hashMap);
            try {
                Method method = jmDNSClass.getMethod("registerService", serviceInfoClass);
                method.invoke(jmDNS, object);
            }
            catch (IllegalAccessException illegalAccessException) {
                LOGGER.warn("Unable to invoke registerService method", (Throwable)illegalAccessException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                LOGGER.warn("No registerService method", (Throwable)noSuchMethodException);
            }
            catch (InvocationTargetException invocationTargetException) {
                LOGGER.warn("Unable to invoke registerService method", (Throwable)invocationTargetException);
            }
            return object;
        }
        LOGGER.warn("JMDNS not available - will not advertise ZeroConf support");
        return null;
    }

    @Override
    public void unadvertise(Object object) {
        if (jmDNS != null) {
            try {
                Method method = jmDNSClass.getMethod("unregisterService", serviceInfoClass);
                method.invoke(jmDNS, object);
            }
            catch (IllegalAccessException illegalAccessException) {
                LOGGER.warn("Unable to invoke unregisterService method", (Throwable)illegalAccessException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                LOGGER.warn("No unregisterService method", (Throwable)noSuchMethodException);
            }
            catch (InvocationTargetException invocationTargetException) {
                LOGGER.warn("Unable to invoke unregisterService method", (Throwable)invocationTargetException);
            }
        }
    }

    private static Object createJmDNSVersion1() {
        try {
            return jmDNSClass.newInstance();
        }
        catch (InstantiationException instantiationException) {
            LOGGER.warn("Unable to instantiate JMDNS", (Throwable)instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            LOGGER.warn("Unable to instantiate JMDNS", (Throwable)illegalAccessException);
        }
        return null;
    }

    private static Object createJmDNSVersion3() {
        try {
            Method method = jmDNSClass.getMethod("create", null);
            return method.invoke(null, null);
        }
        catch (IllegalAccessException illegalAccessException) {
            LOGGER.warn("Unable to instantiate jmdns class", (Throwable)illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            LOGGER.warn("Unable to access constructor", (Throwable)noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            LOGGER.warn("Unable to call constructor", (Throwable)invocationTargetException);
        }
        return null;
    }

    private Object buildServiceInfoVersion1(String string, int n, String string2, Map<String, String> map) {
        Hashtable<String, String> hashtable = new Hashtable<String, String>(map);
        try {
            Class[] classArray = new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Hashtable.class};
            Constructor<?> constructor = serviceInfoClass.getConstructor(classArray);
            Object[] objectArray = new Object[]{string, string2, n, 0, 0, hashtable};
            return constructor.newInstance(objectArray);
        }
        catch (IllegalAccessException illegalAccessException) {
            LOGGER.warn("Unable to construct ServiceInfo instance", (Throwable)illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            LOGGER.warn("Unable to get ServiceInfo constructor", (Throwable)noSuchMethodException);
        }
        catch (InstantiationException instantiationException) {
            LOGGER.warn("Unable to construct ServiceInfo instance", (Throwable)instantiationException);
        }
        catch (InvocationTargetException invocationTargetException) {
            LOGGER.warn("Unable to construct ServiceInfo instance", (Throwable)invocationTargetException);
        }
        return null;
    }

    private Object buildServiceInfoVersion3(String string, int n, String string2, Map<String, String> map) {
        try {
            Class[] classArray = new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Map.class};
            Method method = serviceInfoClass.getMethod("create", classArray);
            Object[] objectArray = new Object[]{string, string2, n, 0, 0, map};
            return method.invoke(null, objectArray);
        }
        catch (IllegalAccessException illegalAccessException) {
            LOGGER.warn("Unable to invoke create method", (Throwable)illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            LOGGER.warn("Unable to find create method", (Throwable)noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            LOGGER.warn("Unable to invoke create method", (Throwable)invocationTargetException);
        }
        return null;
    }

    private static Object initializeJMDNS() {
        try {
            jmDNSClass = Class.forName("javax.jmdns.JmDNS");
            serviceInfoClass = Class.forName("javax.jmdns.ServiceInfo");
            boolean bl = false;
            try {
                jmDNSClass.getMethod("create", null);
                bl = true;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            if (bl) {
                return MulticastDNSAdvertiser.createJmDNSVersion3();
            }
            return MulticastDNSAdvertiser.createJmDNSVersion1();
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOGGER.warn("JmDNS or serviceInfo class not found", (Throwable)classNotFoundException);
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            LOGGER.warn("JmDNS or serviceInfo class not found", (Throwable)exceptionInInitializerError);
        }
        return null;
    }
}

