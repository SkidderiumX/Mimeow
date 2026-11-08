/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.entitydata;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;

public interface EntityDataType {
    public Type type();

    public int typeId();

    public static EntityDataType create(int n, Type<?> type) {
        return new EntityDataTypeImpl(n, type);
    }

    public static final class EntityDataTypeImpl
    implements EntityDataType {
        private final int typeId;
        private final Type<?> type;

        EntityDataTypeImpl(int n, Type<?> type) {
            Preconditions.checkNotNull(type);
            this.typeId = n;
            this.type = type;
        }

        @Override
        public int typeId() {
            return this.typeId;
        }

        @Override
        public Type<?> type() {
            return this.type;
        }

        public String toString() {
            return "EntityDataTypeImpl{typeId=" + this.typeId + ", type=" + String.valueOf(this.type) + "}";
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            EntityDataTypeImpl entityDataTypeImpl = (EntityDataTypeImpl)object;
            if (this.typeId != entityDataTypeImpl.typeId) {
                return false;
            }
            return this.type.equals(entityDataTypeImpl.type);
        }

        public int hashCode() {
            int n = this.typeId;
            n = 31 * n + this.type.hashCode();
            return n;
        }
    }
}

