/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter.entitydata;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.AbstractEntityDataTypes;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntArraySet;
import com.viaversion.viaversion.libs.fastutil.ints.IntComparators;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import com.viaversion.viaversion.libs.fastutil.ints.IntListIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandler;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public record EntityDataFilter(@Nullable EntityType type, boolean filterFamily, @Nullable EntityDataType dataType, int index, EntityDataHandler handler) {
    public EntityDataFilter(@Nullable EntityType entityType, boolean bl, @Nullable EntityDataType entityDataType, int n, EntityDataHandler entityDataHandler) {
        Preconditions.checkNotNull(entityDataHandler, "EntityDataHandler cannot be null");
    }

    public EntityDataFilter(EntityDataHandler entityDataHandler) {
        this(null, true, null, -1, entityDataHandler);
    }

    public boolean isFiltered(@Nullable EntityType entityType, EntityData entityData) {
        return !(this.index != -1 && entityData.id() != this.index || this.type != null && !this.matchesType(entityType) || this.dataType != null && entityData.dataType() != this.dataType);
    }

    private boolean matchesType(EntityType entityType) {
        if (entityType == null) {
            return false;
        }
        return this.filterFamily ? entityType.isOrHasParent(this.type) : this.type == entityType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        EntityDataFilter entityDataFilter = (EntityDataFilter)object;
        if (this.index != entityDataFilter.index) {
            return false;
        }
        if (this.filterFamily != entityDataFilter.filterFamily) {
            return false;
        }
        if (!this.handler.equals(entityDataFilter.handler)) {
            return false;
        }
        if (!Objects.equals(this.dataType, entityDataFilter.dataType)) {
            return false;
        }
        return Objects.equals(this.type, entityDataFilter.type);
    }

    @Override
    public int hashCode() {
        int n = this.handler.hashCode();
        n = 31 * n + (this.type != null ? this.type.hashCode() : 0);
        n = 31 * n + (this.dataType != null ? this.dataType.hashCode() : 0);
        n = 31 * n + this.index;
        n = 31 * n + (this.filterFamily ? 1 : 0);
        return n;
    }

    @Override
    public String toString() {
        return "EntityDataFilter{type=" + String.valueOf(this.type) + ", filterFamily=" + this.filterFamily + ", dataType=" + String.valueOf(this.dataType) + ", index=" + this.index + ", handler=" + String.valueOf(this.handler) + "}";
    }

    public static final class DataTypeMapper {
        private final IntList addedTypeIds = new IntArrayList();
        private final IntList removedTypeIds = new IntArrayList();
        private final IntSet skippedTypeIds = new IntArraySet();
        private final EntityRewriter<?, ?> rewriter;
        private final AbstractEntityDataTypes mappedDataTypes;

        public DataTypeMapper(EntityRewriter<?, ?> entityRewriter) {
            this.rewriter = entityRewriter;
            this.mappedDataTypes = entityRewriter.protocol().mappedTypes().entityDataTypes();
        }

        public DataTypeMapper added(EntityDataType entityDataType) {
            Preconditions.checkArgument(entityDataType.getClass() == this.mappedDataTypes.getDataTypeClass());
            this.addedTypeIds.add(entityDataType.typeId());
            return this;
        }

        public DataTypeMapper removed(EntityDataType entityDataType) {
            Preconditions.checkArgument(entityDataType.getClass() == this.rewriter.protocol().types().entityDataTypes().getDataTypeClass());
            this.removedTypeIds.add(entityDataType.typeId());
            return this;
        }

        public DataTypeMapper skip(EntityDataType entityDataType) {
            Preconditions.checkArgument(entityDataType.getClass() == this.rewriter.protocol().types().entityDataTypes().getDataTypeClass());
            this.skippedTypeIds.add(entityDataType.typeId());
            return this;
        }

        public void register() {
            if (this.addedTypeIds.isEmpty() && this.removedTypeIds.isEmpty() && this.skippedTypeIds.isEmpty()) {
                this.rewriter.filter().handler((entityDataHandlerEvent, entityData) -> {
                    EntityDataType entityDataType = this.mappedDataTypes.byId(entityData.dataType().typeId());
                    entityData.setDataType(entityDataType);
                });
                return;
            }
            this.addedTypeIds.sort(IntComparators.NATURAL_COMPARATOR);
            this.removedTypeIds.sort(IntComparators.OPPOSITE_COMPARATOR);
            this.rewriter.registerFilter(new EntityDataFilter((entityDataHandlerEvent, entityData) -> {
                EntityDataType entityDataType = this.mappedType(entityData.dataType());
                if (entityDataType != null) {
                    entityData.setDataType(entityDataType);
                } else if (entityDataHandlerEvent.entityType() == null) {
                    entityDataHandlerEvent.cancel();
                }
            }));
        }

        private @Nullable EntityDataType mappedType(EntityDataType entityDataType) {
            if (this.skippedTypeIds.contains(entityDataType.typeId()) || this.shouldCancel(entityDataType)) {
                return null;
            }
            int n = this.mappedTypeId(entityDataType.typeId());
            return this.mappedDataTypes.byId(n);
        }

        private boolean shouldCancel(EntityDataType entityDataType) {
            return !this.removedTypeIds.isEmpty() && this.removedTypeIds.contains(entityDataType.typeId());
        }

        private int mappedTypeId(int n) {
            int n2;
            IntListIterator intListIterator = this.removedTypeIds.iterator();
            while (intListIterator.hasNext()) {
                n2 = (Integer)intListIterator.next();
                if (n <= n2) continue;
                --n;
            }
            intListIterator = this.addedTypeIds.iterator();
            while (intListIterator.hasNext()) {
                n2 = (Integer)intListIterator.next();
                if (n < n2) continue;
                ++n;
            }
            return n;
        }
    }

    public static final class Builder {
        private final EntityRewriter<?, ?> rewriter;
        private EntityType type;
        private EntityDataType dataType;
        private int index = -1;
        private boolean filterFamily;
        private EntityDataHandler handler;

        public Builder(EntityRewriter<?, ?> entityRewriter) {
            this.rewriter = entityRewriter;
        }

        public Builder dataType(EntityDataType entityDataType) {
            Preconditions.checkArgument(this.dataType == null);
            this.dataType = entityDataType;
            return this;
        }

        public Builder type(EntityType entityType) {
            Preconditions.checkArgument(this.type == null);
            this.type = entityType;
            this.filterFamily = true;
            return this;
        }

        public Builder exactType(EntityType entityType) {
            Preconditions.checkArgument(this.type == null);
            this.type = entityType;
            this.filterFamily = false;
            return this;
        }

        public Builder index(int n) {
            Preconditions.checkArgument(this.index == -1);
            this.index = n;
            return this;
        }

        public Builder handlerNoRegister(EntityDataHandler entityDataHandler) {
            Preconditions.checkArgument(this.handler == null);
            this.handler = entityDataHandler;
            return this;
        }

        public void handler(EntityDataHandler entityDataHandler) {
            Preconditions.checkArgument(this.handler == null);
            this.handler = entityDataHandler;
            this.register();
        }

        public void mapDataType(Int2ObjectFunction<EntityDataType> int2ObjectFunction) {
            this.handler((entityDataHandlerEvent, entityData) -> {
                EntityDataType entityDataType = (EntityDataType)int2ObjectFunction.apply(entityData.dataType().typeId());
                if (entityDataType != null) {
                    entityData.setDataType(entityDataType);
                } else {
                    entityDataHandlerEvent.cancel();
                }
            });
        }

        public void cancel(int n) {
            this.index = n;
            this.handler((entityDataHandlerEvent, entityData) -> entityDataHandlerEvent.cancel());
        }

        public void toIndex(int n) {
            Preconditions.checkArgument(this.index != -1);
            this.handler((entityDataHandlerEvent, entityData) -> entityDataHandlerEvent.setIndex(n));
        }

        public void addIndex(int n) {
            Preconditions.checkArgument(this.index == -1);
            this.handler((entityDataHandlerEvent, entityData) -> {
                if (entityDataHandlerEvent.index() >= n) {
                    entityDataHandlerEvent.setIndex(entityDataHandlerEvent.index() + 1);
                }
            });
        }

        public void removeIndex(int n) {
            Preconditions.checkArgument(this.index == -1);
            this.handler((entityDataHandlerEvent, entityData) -> {
                int n2 = entityDataHandlerEvent.index();
                if (n2 == n) {
                    entityDataHandlerEvent.cancel();
                } else if (n2 > n) {
                    entityDataHandlerEvent.setIndex(n2 - 1);
                }
            });
        }

        public void register() {
            this.rewriter.registerFilter(this.build());
        }

        public EntityDataFilter build() {
            Preconditions.checkNotNull(this.handler, "EntityDataHandler cannot be null");
            return new EntityDataFilter(this.type, this.filterFamily, this.dataType, this.index, this.handler);
        }
    }
}

