/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;

public class StructuredItemTemplate
extends StructuredItem {
    public StructuredItemTemplate(int n, int n2) {
        super(n, n2, new StructuredDataContainer());
    }

    public StructuredItemTemplate(int n, int n2, StructuredDataContainer structuredDataContainer) {
        super(n, n2, structuredDataContainer);
    }

    @Override
    public void setIdentifier(int n) {
        Preconditions.checkArgument(n > 0, "Template item cannot be empty");
        super.setIdentifier(n);
    }

    @Override
    public void setAmount(int n) {
        Preconditions.checkArgument(n > 0, "Template item cannot be empty");
        super.setAmount(n);
    }

    @Override
    public boolean isTemplate() {
        return true;
    }

    @Override
    public StructuredItemTemplate copy() {
        return new StructuredItemTemplate(this.identifier(), this.amount(), this.dataContainer().copy());
    }
}

