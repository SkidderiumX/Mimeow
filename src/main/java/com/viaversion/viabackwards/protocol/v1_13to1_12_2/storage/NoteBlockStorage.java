/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.util.Pair;

public class NoteBlockStorage
implements StorableObject {
    private static final int MAX_NOTE_ID = 24;
    private final Object2IntMap<BlockPosition> noteBlockUpdates = new Object2IntOpenHashMap<BlockPosition>();

    public void storeNoteBlockUpdate(BlockPosition blockPosition, int n) {
        this.noteBlockUpdates.put(blockPosition, n);
    }

    public Pair<Integer, Integer> getNoteBlockUpdate(BlockPosition blockPosition) {
        if (!this.noteBlockUpdates.containsKey(blockPosition)) {
            return null;
        }
        int n = this.noteBlockUpdates.removeInt(blockPosition) - 249;
        return new Pair<Integer, Integer>((n /= 2) / 24 + 1, n % 24 + 1);
    }

    public void clear() {
        this.noteBlockUpdates.clear();
    }
}

