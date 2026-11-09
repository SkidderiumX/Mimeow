/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.shader;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderDefault;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.client.shader.ShaderLoader;
import net.minecraft.client.shader.ShaderUniform;
import net.minecraft.client.util.JsonBlendingMode;
import net.minecraft.client.util.JsonException;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShaderManager {
    private static final Logger logger = LogManager.getLogger();
    private static final ShaderDefault defaultShaderUniform = new ShaderDefault();
    private static ShaderManager staticShaderManager = null;
    private static int currentProgram = -1;
    private static boolean field_148000_e = true;
    private final Map<String, Object> shaderSamplers = Maps.newHashMap();
    private final List<String> samplerNames = Lists.newArrayList();
    private final List<Integer> shaderSamplerLocations = Lists.newArrayList();
    private final List<ShaderUniform> shaderUniforms = Lists.newArrayList();
    private final List<Integer> shaderUniformLocations = Lists.newArrayList();
    private final Map<String, ShaderUniform> mappedShaderUniforms = Maps.newHashMap();
    private final int program;
    private final String programFilename;
    private final boolean useFaceCulling;
    private boolean isDirty;
    private final JsonBlendingMode field_148016_p;
    private final List<Integer> attribLocations;
    private final List<String> attributes;
    private final ShaderLoader vertexShaderLoader;
    private final ShaderLoader fragmentShaderLoader;

    public ShaderManager(IResourceManager iResourceManager, String string) throws JsonException, IOException {
        JsonParser jsonParser = new JsonParser();
        ResourceLocation resourceLocation = new ResourceLocation("shaders/program/" + string + ".json");
        this.programFilename = string;
        InputStream inputStream2 = null;
        try {
            JsonArray jsonArray;
            JsonArray jsonArray2;
            inputStream2 = iResourceManager.getResource(resourceLocation).getInputStream();
            JsonObject jsonObject = jsonParser.parse(IOUtils.toString(inputStream2, Charsets.UTF_8)).getAsJsonObject();
            String string2 = JsonUtils.getString(jsonObject, "vertex");
            String string3 = JsonUtils.getString(jsonObject, "fragment");
            JsonArray jsonArray3 = JsonUtils.getJsonArray(jsonObject, "samplers", null);
            if (jsonArray3 != null) {
                int n = 0;
                for (Object object : jsonArray3) {
                    try {
                        this.parseSampler((JsonElement)object);
                    }
                    catch (Exception exception) {
                        JsonException jsonException = JsonException.func_151379_a(exception);
                        jsonException.func_151380_a("samplers[" + n + "]");
                        throw jsonException;
                    }
                    ++n;
                }
            }
            if ((jsonArray2 = JsonUtils.getJsonArray(jsonObject, "attributes", null)) != null) {
                int n = 0;
                this.attribLocations = Lists.newArrayListWithCapacity(jsonArray2.size());
                this.attributes = Lists.newArrayListWithCapacity(jsonArray2.size());
                for (JsonElement object : jsonArray2) {
                    try {
                        this.attributes.add(JsonUtils.getString(object, "attribute"));
                    }
                    catch (Exception exception) {
                        JsonException jsonException = JsonException.func_151379_a(exception);
                        jsonException.func_151380_a("attributes[" + n + "]");
                        throw jsonException;
                    }
                    ++n;
                }
            } else {
                this.attribLocations = null;
                this.attributes = null;
            }
            if ((jsonArray = JsonUtils.getJsonArray(jsonObject, "uniforms", null)) != null) {
                int n = 0;
                for (JsonElement jsonElement : jsonArray) {
                    try {
                        this.parseUniform(jsonElement);
                    }
                    catch (Exception exception) {
                        JsonException jsonException = JsonException.func_151379_a(exception);
                        jsonException.func_151380_a("uniforms[" + n + "]");
                        throw jsonException;
                    }
                    ++n;
                }
            }
            this.field_148016_p = JsonBlendingMode.func_148110_a(JsonUtils.getJsonObject(jsonObject, "blend", null));
            this.useFaceCulling = JsonUtils.getBoolean(jsonObject, "cull", true);
            this.vertexShaderLoader = ShaderLoader.loadShader(iResourceManager, ShaderLoader.ShaderType.VERTEX, string2);
            this.fragmentShaderLoader = ShaderLoader.loadShader(iResourceManager, ShaderLoader.ShaderType.FRAGMENT, string3);
            this.program = ShaderLinkHelper.getStaticShaderLinkHelper().createProgram();
            ShaderLinkHelper.getStaticShaderLinkHelper().linkProgram(this);
            this.setupUniforms();
            if (this.attributes != null) {
                for (String string4 : this.attributes) {
                    int n = OpenGlHelper.glGetAttribLocation(this.program, string4);
                    this.attribLocations.add(n);
                }
            }
        }
        catch (Exception exception) {
            try {
                JsonException jsonException = JsonException.func_151379_a(exception);
                jsonException.func_151381_b(resourceLocation.getResourcePath());
                throw jsonException;
            }
            catch (Throwable throwable) {
                IOUtils.closeQuietly(inputStream2);
                throw throwable;
            }
        }
        IOUtils.closeQuietly(inputStream2);
        this.markDirty();
    }

    public void deleteShader() {
        ShaderLinkHelper.getStaticShaderLinkHelper().deleteShader(this);
    }

    public void endShader() {
        OpenGlHelper.glUseProgram(0);
        currentProgram = -1;
        staticShaderManager = null;
        field_148000_e = true;
        for (int i = 0; i < this.shaderSamplerLocations.size(); ++i) {
            if (this.shaderSamplers.get(this.samplerNames.get(i)) == null) continue;
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + i);
            GlStateManager.bindTexture(0);
        }
    }

    public void useShader() {
        this.isDirty = false;
        staticShaderManager = this;
        this.field_148016_p.func_148109_a();
        if (this.program != currentProgram) {
            OpenGlHelper.glUseProgram(this.program);
            currentProgram = this.program;
        }
        if (this.useFaceCulling) {
            GlStateManager.enableCull();
        } else {
            GlStateManager.disableCull();
        }
        for (int i = 0; i < this.shaderSamplerLocations.size(); ++i) {
            if (this.shaderSamplers.get(this.samplerNames.get(i)) == null) continue;
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + i);
            GlStateManager.enableTexture2D();
            Object object = this.shaderSamplers.get(this.samplerNames.get(i));
            int n = -1;
            if (object instanceof Framebuffer) {
                n = ((Framebuffer)object).framebufferTexture;
            } else if (object instanceof ITextureObject) {
                n = ((ITextureObject)object).getGlTextureId();
            } else if (object instanceof Integer) {
                n = (Integer)object;
            }
            if (n == -1) continue;
            GlStateManager.bindTexture(n);
            OpenGlHelper.glUniform1i(OpenGlHelper.glGetUniformLocation(this.program, this.samplerNames.get(i)), i);
        }
        for (ShaderUniform shaderUniform : this.shaderUniforms) {
            shaderUniform.upload();
        }
    }

    public void markDirty() {
        this.isDirty = true;
    }

    public ShaderUniform getShaderUniform(String string) {
        return this.mappedShaderUniforms.containsKey(string) ? this.mappedShaderUniforms.get(string) : null;
    }

    public ShaderUniform getShaderUniformOrDefault(String string) {
        return this.mappedShaderUniforms.containsKey(string) ? this.mappedShaderUniforms.get(string) : defaultShaderUniform;
    }

    private void setupUniforms() {
        int n = 0;
        int n2 = 0;
        while (n < this.samplerNames.size()) {
            String object = this.samplerNames.get(n);
            int n3 = OpenGlHelper.glGetUniformLocation(this.program, object);
            if (n3 == -1) {
                logger.warn("Shader " + this.programFilename + "could not find sampler named " + object + " in the specified shader program.");
                this.shaderSamplers.remove(object);
                this.samplerNames.remove(n2);
                --n2;
            } else {
                this.shaderSamplerLocations.add(n3);
            }
            ++n;
            ++n2;
        }
        for (ShaderUniform shaderUniform : this.shaderUniforms) {
            String string = shaderUniform.getShaderName();
            int n4 = OpenGlHelper.glGetUniformLocation(this.program, string);
            if (n4 == -1) {
                logger.warn("Could not find uniform named " + string + " in the specified shader program.");
                continue;
            }
            this.shaderUniformLocations.add(n4);
            shaderUniform.setUniformLocation(n4);
            this.mappedShaderUniforms.put(string, shaderUniform);
        }
    }

    private void parseSampler(JsonElement jsonElement) throws JsonException {
        JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "sampler");
        String string = JsonUtils.getString(jsonObject, "name");
        if (!JsonUtils.isString(jsonObject, "file")) {
            this.shaderSamplers.put(string, null);
            this.samplerNames.add(string);
        } else {
            this.samplerNames.add(string);
        }
    }

    public void addSamplerTexture(String string, Object object) {
        if (this.shaderSamplers.containsKey(string)) {
            this.shaderSamplers.remove(string);
        }
        this.shaderSamplers.put(string, object);
        this.markDirty();
    }

    private void parseUniform(JsonElement jsonElement) throws JsonException {
        Object object2;
        JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "uniform");
        String string = JsonUtils.getString(jsonObject, "name");
        int n = ShaderUniform.parseType(JsonUtils.getString(jsonObject, "type"));
        int n2 = JsonUtils.getInt(jsonObject, "count");
        float[] fArray = new float[Math.max(n2, 16)];
        JsonArray jsonArray = JsonUtils.getJsonArray(jsonObject, "values");
        if (jsonArray.size() != n2 && jsonArray.size() > 1) {
            throw new JsonException("Invalid amount of values specified (expected " + n2 + ", found " + jsonArray.size() + ")");
        }
        int n3 = 0;
        for (Object object2_r : jsonArray) {
            try {
                fArray[n3] = JsonUtils.getFloat((JsonElement)object2_r, "value");
            }
            catch (Exception exception) {
                JsonException jsonException = JsonException.func_151379_a(exception);
                jsonException.func_151380_a("values[" + n3 + "]");
                throw jsonException;
            }
            ++n3;
        }
        if (n2 > 1 && jsonArray.size() == 1) {
            while (n3 < n2) {
                fArray[n3] = fArray[0];
                ++n3;
            }
        }
        int n4 = n2 > 1 && n2 <= 4 && n < 8 ? n2 - 1 : 0;
        object2 = new ShaderUniform(string, n + n4, n2, this);
        if (n <= 3) {
            ((ShaderUniform)object2).set((int)fArray[0], (int)fArray[1], (int)fArray[2], (int)fArray[3]);
        } else if (n <= 7) {
            ((ShaderUniform)object2).func_148092_b(fArray[0], fArray[1], fArray[2], fArray[3]);
        } else {
            ((ShaderUniform)object2).set(fArray);
        }
        this.shaderUniforms.add((ShaderUniform)object2);
    }

    public ShaderLoader getVertexShaderLoader() {
        return this.vertexShaderLoader;
    }

    public ShaderLoader getFragmentShaderLoader() {
        return this.fragmentShaderLoader;
    }

    public int getProgram() {
        return this.program;
    }
}

