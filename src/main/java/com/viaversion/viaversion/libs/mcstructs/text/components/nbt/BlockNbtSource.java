/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components.nbt;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import lombok.Generated;

public class BlockNbtSource
implements NbtDataSource {
    private String pos;

    public BlockNbtSource(String string) {
        this.pos = string;
    }

    public String getPos() {
        return this.pos;
    }

    public BlockNbtSource setPos(String string) {
        this.pos = string;
        return this;
    }

    @Override
    public BlockNbtSource copy() {
        return new BlockNbtSource(this.pos);
    }

    public String toString() {
        return ToString.of(this).add("pos", this.pos).toString();
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BlockNbtSource)) {
            return false;
        }
        BlockNbtSource blockNbtSource = (BlockNbtSource)object;
        if (!blockNbtSource.canEqual(this)) {
            return false;
        }
        String string = this.getPos();
        String string2 = blockNbtSource.getPos();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof BlockNbtSource;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getPos();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}

