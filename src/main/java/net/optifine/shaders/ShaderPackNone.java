/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import java.io.InputStream;
import net.optifine.shaders.IShaderPack;

public class ShaderPackNone
implements IShaderPack {
    @Override
    public void close() {
    }

    @Override
    public InputStream getResourceAsStream(String string) {
        return null;
    }

    @Override
    public boolean hasDirectory(String string) {
        return false;
    }

    @Override
    public String getName() {
        return "OFF";
    }
}

