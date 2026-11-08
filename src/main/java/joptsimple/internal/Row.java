/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.internal;

public class Row {
    final String option;
    final String description;

    Row(String string, String string2) {
        this.option = string;
        this.description = string2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || !this.getClass().equals(object.getClass())) {
            return false;
        }
        Row row = (Row)object;
        return this.option.equals(row.option) && this.description.equals(row.description);
    }

    public int hashCode() {
        return this.option.hashCode() ^ this.description.hashCode();
    }
}

