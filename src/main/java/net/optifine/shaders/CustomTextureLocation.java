/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.optifine.shaders.ICustomTexture;
import net.optifine.shaders.MultiTexID;

public class CustomTextureLocation
implements ICustomTexture {
    private int textureUnit = -1;
    private ResourceLocation location;
    private int variant = 0;
    private ITextureObject texture;
    public static final int VARIANT_BASE = 0;
    public static final int VARIANT_NORMAL = 1;
    public static final int VARIANT_SPECULAR = 2;

    public CustomTextureLocation(int n, ResourceLocation resourceLocation, int n2) {
        this.textureUnit = n;
        this.location = resourceLocation;
        this.variant = n2;
    }

    public ITextureObject getTexture() {
        if (this.texture == null) {
            TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
            this.texture = textureManager.getTexture(this.location);
            if (this.texture == null) {
                this.texture = new SimpleTexture(this.location);
                textureManager.loadTexture(this.location, this.texture);
                this.texture = textureManager.getTexture(this.location);
            }
        }
        return this.texture;
    }

    @Override
    public int getTextureId() {
        ITextureObject iTextureObject = this.getTexture();
        if (this.variant != 0 && iTextureObject instanceof AbstractTexture) {
            AbstractTexture abstractTexture = (AbstractTexture)iTextureObject;
            MultiTexID multiTexID = abstractTexture.multiTex;
            if (multiTexID != null) {
                if (this.variant == 1) {
                    return multiTexID.norm;
                }
                if (this.variant == 2) {
                    return multiTexID.spec;
                }
            }
        }
        return iTextureObject.getGlTextureId();
    }

    @Override
    public int getTextureUnit() {
        return this.textureUnit;
    }

    @Override
    public void deleteTexture() {
    }

    @Override
    public int getTarget() {
        return 3553;
    }

    public String toString() {
        return "textureUnit: " + this.textureUnit + ", location: " + String.valueOf(this.location) + ", glTextureId: " + String.valueOf(this.texture != null ? Integer.valueOf(this.texture.getGlTextureId()) : "");
    }
}

