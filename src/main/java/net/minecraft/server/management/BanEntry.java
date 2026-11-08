/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.server.management.UserListEntry;

public abstract class BanEntry<T>
extends UserListEntry<T> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    protected final Date banStartDate;
    protected final String bannedBy;
    protected final Date banEndDate;
    protected final String reason;

    public BanEntry(T t, Date date, String string, Date date2, String string2) {
        super(t);
        this.banStartDate = date == null ? new Date() : date;
        this.bannedBy = string == null ? "(Unknown)" : string;
        this.banEndDate = date2;
        this.reason = string2 == null ? "Banned by an operator." : string2;
    }

    protected BanEntry(T t, JsonObject jsonObject) {
        super(t, jsonObject);
        Date date;
        Date date2;
        try {
            date2 = jsonObject.has("created") ? dateFormat.parse(jsonObject.get("created").getAsString()) : new Date();
        }
        catch (ParseException parseException) {
            date2 = new Date();
        }
        this.banStartDate = date2;
        this.bannedBy = jsonObject.has("source") ? jsonObject.get("source").getAsString() : "(Unknown)";
        try {
            date = jsonObject.has("expires") ? dateFormat.parse(jsonObject.get("expires").getAsString()) : null;
        }
        catch (ParseException parseException) {
            date = null;
        }
        this.banEndDate = date;
        this.reason = jsonObject.has("reason") ? jsonObject.get("reason").getAsString() : "Banned by an operator.";
    }

    public Date getBanEndDate() {
        return this.banEndDate;
    }

    public String getBanReason() {
        return this.reason;
    }

    @Override
    boolean hasBanExpired() {
        return this.banEndDate == null ? false : this.banEndDate.before(new Date());
    }

    @Override
    protected void onSerialization(JsonObject jsonObject) {
        jsonObject.addProperty("created", dateFormat.format(this.banStartDate));
        jsonObject.addProperty("source", this.bannedBy);
        jsonObject.addProperty("expires", this.banEndDate == null ? "forever" : dateFormat.format(this.banEndDate));
        jsonObject.addProperty("reason", this.reason);
    }
}

