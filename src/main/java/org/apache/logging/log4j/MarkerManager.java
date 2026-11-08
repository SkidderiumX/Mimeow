/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.logging.log4j.Marker;

public class MarkerManager {
    private static ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap<String, Marker>();

    private MarkerManager() {
    }

    public static Marker getMarker(String string) {
        markerMap.putIfAbsent(string, new Log4jMarker(string));
        return (Marker)markerMap.get(string);
    }

    public static Marker getMarker(String string, String string2) {
        Marker marker = (Marker)markerMap.get(string2);
        if (marker == null) {
            throw new IllegalArgumentException("Parent Marker " + string2 + " has not been defined");
        }
        return MarkerManager.getMarker(string, marker);
    }

    public static Marker getMarker(String string, Marker marker) {
        markerMap.putIfAbsent(string, new Log4jMarker(string, marker));
        return (Marker)markerMap.get(string);
    }

    private static class Log4jMarker
    implements Marker {
        private static final long serialVersionUID = 100L;
        private final String name;
        private final Marker parent;

        public Log4jMarker(String string) {
            this.name = string;
            this.parent = null;
        }

        public Log4jMarker(String string, Marker marker) {
            this.name = string;
            this.parent = marker;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public Marker getParent() {
            return this.parent;
        }

        @Override
        public boolean isInstanceOf(Marker marker) {
            if (marker == null) {
                throw new IllegalArgumentException("A marker parameter is required");
            }
            Marker marker2 = this;
            do {
                if (marker2 != marker) continue;
                return true;
            } while ((marker2 = marker2.getParent()) != null);
            return false;
        }

        @Override
        public boolean isInstanceOf(String string) {
            if (string == null) {
                throw new IllegalArgumentException("A marker name is required");
            }
            Marker marker = this;
            do {
                if (!string.equals(marker.getName())) continue;
                return true;
            } while ((marker = marker.getParent()) != null);
            return false;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || !(object instanceof Marker)) {
                return false;
            }
            Marker marker = (Marker)object;
            return !(this.name != null ? !this.name.equals(marker.getName()) : marker.getName() != null);
        }

        public int hashCode() {
            return this.name != null ? this.name.hashCode() : 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.name);
            if (this.parent != null) {
                stringBuilder.append("[ ");
                boolean bl = true;
                for (Marker marker = this.parent; marker != null; marker = marker.getParent()) {
                    if (!bl) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(marker.getName());
                    bl = false;
                }
                stringBuilder.append(" ]");
            }
            return stringBuilder.toString();
        }
    }
}

