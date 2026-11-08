/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public interface oc65f19d876a {
    public void callSetupCameraTransform(float var1, int var2);

    public void callLoadShader(ResourceLocation var1);

    public ResourceLocation[] getShaderResourceLocations();

    public boolean getUseShader();

    public void setUseShader(boolean var1);

    public int getShaderIndex();

    public void setShaderIndex(int var1);

    public void setThirdPersonDistance(float var1);

    public Entity getPointedEntity();

    public void setPointedEntity(Entity var1);
}

