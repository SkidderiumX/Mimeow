/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.exception;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class InformativeException
extends RuntimeException {
    private final List<DataEntry> dataEntries = new ArrayList<DataEntry>();
    private boolean shouldBePrinted = true;
    private int sources;

    public InformativeException(Throwable throwable) {
        super(throwable);
    }

    public InformativeException set(String string, @Nullable Object object) {
        this.dataEntries.add(new DataEntry(string, object));
        return this;
    }

    public InformativeException addSource(Class<?> clazz) {
        return this.set("Source " + this.sources++, this.getSource(clazz));
    }

    private String getSource(Class<?> clazz) {
        return clazz.isAnonymousClass() ? clazz.getName() + " (Anonymous)" : clazz.getName();
    }

    public boolean shouldBePrinted() {
        return this.shouldBePrinted;
    }

    public void setShouldBePrinted(boolean bl) {
        this.shouldBePrinted = bl;
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder("Please report the full error (!) from the console on the Via support Discord or open an issue on the relevant GitHub repository.\n");
        boolean bl = true;
        for (DataEntry dataEntry : this.dataEntries) {
            if (!bl) {
                stringBuilder.append(", ");
            } else {
                bl = false;
            }
            stringBuilder.append(dataEntry.name()).append(": ");
            Object object = String.valueOf(dataEntry.value());
            if (!Via.getManager().isDebug() && ((String)object).length() > 10 && stringBuilder.length() + ((String)object).length() > Via.getConfig().maxErrorLength()) {
                int n = Math.max(0, Via.getConfig().maxErrorLength() - stringBuilder.length());
                object = ((String)object).substring(0, Math.min(n, ((String)object).length())) + "...";
            }
            stringBuilder.append(StringUtil.forLogging((String)object));
        }
        return stringBuilder.toString();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    private record DataEntry(String name, @Nullable Object value) {
    }
}

