/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import java.util.HashMap;
import java.util.Map;

public class InventoryTracker
implements StorableObject {
    private String inventory;
    private final Int2ObjectMap<Map<Short, Integer>> windowItemCache = new Int2ObjectOpenHashMap<Map<Short, Integer>>();
    private int itemIdInCursor;
    private boolean dragging;

    public String getInventory() {
        return this.inventory;
    }

    public void setInventory(String string) {
        this.inventory = string;
    }

    public void resetInventory(int n) {
        if (this.inventory == null) {
            this.itemIdInCursor = 0;
            this.dragging = false;
            if (n != 0) {
                this.windowItemCache.remove(n);
            }
        }
    }

    public int getItemId(int n, short s) {
        Map map = (Map)this.windowItemCache.get(n);
        if (map == null) {
            return 0;
        }
        return map.getOrDefault(s, 0);
    }

    public void setItemId(int n2, short s, int n3) {
        if (n2 == -1 && s == -1) {
            this.itemIdInCursor = n3;
        } else {
            this.windowItemCache.computeIfAbsent(n2, n -> new HashMap()).put(s, n3);
        }
    }

    public void handleWindowClick(UserConnection userConnection, int n, byte by, short s, byte by2) {
        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)userConnection.getEntityTracker(Protocol1_8To1_9.class);
        if (s == -1) {
            return;
        }
        if (s == 45) {
            entityTracker1_9.setSecondHand(null);
            return;
        }
        boolean bl = s >= 5 && s <= 8 || s == 0;
        switch (by) {
            case 0: {
                if (this.itemIdInCursor == 0) {
                    this.itemIdInCursor = this.getItemId(n, s);
                    this.setItemId(n, s, 0);
                    break;
                }
                if (s == -999) {
                    this.itemIdInCursor = 0;
                    break;
                }
                if (bl) break;
                int n2 = this.getItemId(n, s);
                this.setItemId(n, s, this.itemIdInCursor);
                this.itemIdInCursor = n2;
                break;
            }
            case 2: {
                if (bl) break;
                short s2 = (short)(by2 + 36);
                int n3 = this.getItemId(n, s);
                int n4 = this.getItemId(n, s2);
                this.setItemId(n, s2, n3);
                this.setItemId(n, s, n4);
                break;
            }
            case 4: {
                int n5 = this.getItemId(n, s);
                if (n5 == 0) break;
                this.setItemId(n, s, 0);
                break;
            }
            case 5: {
                switch (by2) {
                    case 0: 
                    case 4: {
                        this.dragging = true;
                        break;
                    }
                    case 1: 
                    case 5: {
                        if (!this.dragging || this.itemIdInCursor == 0 || bl) break;
                        int n6 = this.getItemId(n, s);
                        this.setItemId(n, s, this.itemIdInCursor);
                        this.itemIdInCursor = n6;
                        break;
                    }
                    case 2: 
                    case 6: {
                        this.dragging = false;
                    }
                }
                break;
            }
        }
        entityTracker1_9.syncShieldWithSword();
    }
}

