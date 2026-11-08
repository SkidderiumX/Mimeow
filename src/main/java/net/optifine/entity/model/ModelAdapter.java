/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import java.util.ArrayList;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.optifine.entity.model.IEntityRenderer;

public abstract class ModelAdapter {
    private Class entityClass;
    private String name;
    private float shadowSize;
    private String[] aliases;

    public ModelAdapter(Class clazz, String string, float f) {
        this.entityClass = clazz;
        this.name = string;
        this.shadowSize = f;
    }

    public ModelAdapter(Class clazz, String string, float f, String[] stringArray) {
        this.entityClass = clazz;
        this.name = string;
        this.shadowSize = f;
        this.aliases = stringArray;
    }

    public Class getEntityClass() {
        return this.entityClass;
    }

    public String getName() {
        return this.name;
    }

    public String[] getAliases() {
        return this.aliases;
    }

    public float getShadowSize() {
        return this.shadowSize;
    }

    public abstract ModelBase makeModel();

    public abstract ModelRenderer getModelRenderer(ModelBase var1, String var2);

    public abstract String[] getModelRendererNames();

    public abstract IEntityRenderer makeEntityRender(ModelBase var1, float var2);

    public ModelRenderer[] getModelRenderers(ModelBase modelBase) {
        String[] stringArray = this.getModelRendererNames();
        ArrayList<ModelRenderer> arrayList = new ArrayList<ModelRenderer>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            ModelRenderer modelRenderer = this.getModelRenderer(modelBase, string);
            if (modelRenderer == null) continue;
            arrayList.add(modelRenderer);
        }
        ModelRenderer[] modelRendererArray = arrayList.toArray(new ModelRenderer[arrayList.size()]);
        return modelRendererArray;
    }
}

