/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.Grego;
import com.ibm.icu.util.TimeZone;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class JavaTimeZone
extends TimeZone {
    private static final long serialVersionUID = 6977448185543929364L;
    private static final TreeSet<String> AVAILABLESET = new TreeSet();
    private java.util.TimeZone javatz;
    private transient Calendar javacal;
    private static Method mObservesDaylightTime;
    private transient boolean isFrozen = false;

    public JavaTimeZone() {
        this(java.util.TimeZone.getDefault(), null);
    }

    public JavaTimeZone(java.util.TimeZone timeZone, String string) {
        if (string == null) {
            string = timeZone.getID();
        }
        this.javatz = timeZone;
        this.setID(string);
        this.javacal = new GregorianCalendar(this.javatz);
    }

    public static JavaTimeZone createTimeZone(String string) {
        java.util.TimeZone timeZone = null;
        if (AVAILABLESET.contains(string)) {
            timeZone = java.util.TimeZone.getTimeZone(string);
        }
        if (timeZone == null) {
            boolean[] blArray = new boolean[1];
            String string2 = TimeZone.getCanonicalID(string, blArray);
            if (blArray[0] && AVAILABLESET.contains(string2)) {
                timeZone = java.util.TimeZone.getTimeZone(string2);
            }
        }
        if (timeZone == null) {
            return null;
        }
        return new JavaTimeZone(timeZone, string);
    }

    public int getOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        return this.javatz.getOffset(n, n2, n3, n4, n5, n6);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getOffset(long l, boolean bl, int[] nArray) {
        Calendar calendar = this.javacal;
        synchronized (calendar) {
            if (bl) {
                int[] nArray2 = new int[6];
                Grego.timeToFields(l, nArray2);
                int n = nArray2[5];
                int n2 = n % 1000;
                int n3 = (n /= 1000) % 60;
                int n4 = (n /= 60) % 60;
                int n5 = n / 60;
                this.javacal.clear();
                this.javacal.set(nArray2[0], nArray2[1], nArray2[2], n5, n4, n3);
                this.javacal.set(14, n2);
                int n6 = this.javacal.get(6);
                int n7 = this.javacal.get(11);
                int n8 = this.javacal.get(12);
                int n9 = this.javacal.get(13);
                int n10 = this.javacal.get(14);
                if (nArray2[4] != n6 || n5 != n7 || n4 != n8 || n3 != n9 || n2 != n10) {
                    int n11 = Math.abs(n6 - nArray2[4]) > 1 ? 1 : n6 - nArray2[4];
                    int n12 = (((n11 * 24 + n7 - n5) * 60 + n8 - n4) * 60 + n9 - n3) * 1000 + n10 - n2;
                    this.javacal.setTimeInMillis(this.javacal.getTimeInMillis() - (long)n12 - 1L);
                }
            } else {
                this.javacal.setTimeInMillis(l);
            }
            nArray[0] = this.javacal.get(15);
            nArray[1] = this.javacal.get(16);
        }
    }

    public int getRawOffset() {
        return this.javatz.getRawOffset();
    }

    public boolean inDaylightTime(Date date) {
        return this.javatz.inDaylightTime(date);
    }

    public void setRawOffset(int n) {
        if (this.isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen JavaTimeZone instance.");
        }
        this.javatz.setRawOffset(n);
    }

    public boolean useDaylightTime() {
        return this.javatz.useDaylightTime();
    }

    public boolean observesDaylightTime() {
        if (mObservesDaylightTime != null) {
            try {
                return (Boolean)mObservesDaylightTime.invoke(this.javatz, null);
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (InvocationTargetException invocationTargetException) {
                // empty catch block
            }
        }
        return super.observesDaylightTime();
    }

    public int getDSTSavings() {
        return this.javatz.getDSTSavings();
    }

    public java.util.TimeZone unwrap() {
        return this.javatz;
    }

    public Object clone() {
        if (this.isFrozen()) {
            return this;
        }
        return this.cloneAsThawed();
    }

    public int hashCode() {
        return super.hashCode() + this.javatz.hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.javacal = new GregorianCalendar(this.javatz);
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }

    public TimeZone freeze() {
        this.isFrozen = true;
        return this;
    }

    public TimeZone cloneAsThawed() {
        JavaTimeZone javaTimeZone = (JavaTimeZone)super.cloneAsThawed();
        javaTimeZone.javatz = (java.util.TimeZone)this.javatz.clone();
        javaTimeZone.javacal = (GregorianCalendar)this.javacal.clone();
        javaTimeZone.isFrozen = false;
        return javaTimeZone;
    }

    static {
        String[] stringArray = java.util.TimeZone.getAvailableIDs();
        for (int i = 0; i < stringArray.length; ++i) {
            AVAILABLESET.add(stringArray[i]);
        }
        try {
            mObservesDaylightTime = java.util.TimeZone.class.getMethod("observesDaylightTime", null);
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
    }
}

