/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.compat.model;

import com.google.common.base.Optional;
import net.optifine.compat.model.IModelPart;
import net.optifine.compat.model.TRSRTransformation;

public interface IModelState {
    public Optional<TRSRTransformation> apply(Optional<? extends IModelPart> var1);
}

