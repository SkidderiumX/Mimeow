/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.uniform;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.expr.ConstantFloat;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionResolver;
import net.optifine.shaders.SMCLog;
import net.optifine.shaders.uniform.ShaderParameterBool;
import net.optifine.shaders.uniform.ShaderParameterFloat;
import net.optifine.shaders.uniform.ShaderParameterIndexed;

public class ShaderExpressionResolver
implements IExpressionResolver {
    private Map<String, IExpression> mapExpressions = new HashMap<String, IExpression>();

    public ShaderExpressionResolver(Map<String, IExpression> map) {
        this.registerExpressions();
        for (String string : map.keySet()) {
            IExpression iExpression = map.get(string);
            this.registerExpression(string, iExpression);
        }
    }

    private void registerExpressions() {
        ShaderParameterFloat[] shaderParameterFloatArray = ShaderParameterFloat.values();
        for (int i = 0; i < shaderParameterFloatArray.length; ++i) {
            ShaderParameterFloat shaderParameterFloat = shaderParameterFloatArray[i];
            this.addParameterFloat(this.mapExpressions, shaderParameterFloat);
        }
        ShaderParameterBool[] shaderParameterBoolArray = ShaderParameterBool.values();
        for (int i = 0; i < shaderParameterBoolArray.length; ++i) {
            ShaderParameterBool object = shaderParameterBoolArray[i];
            this.mapExpressions.put(object.getName(), object);
        }
        for (BiomeGenBase biomeGenBase : BiomeGenBase.BIOME_ID_MAP.values()) {
            Object object = biomeGenBase.biomeName.trim();
            object = "BIOME_" + ((String)object).toUpperCase().replace(' ', '_');
            int n = biomeGenBase.biomeID;
            ConstantFloat constantFloat = new ConstantFloat(n);
            this.registerExpression((String)object, constantFloat);
        }
    }

    private void addParameterFloat(Map<String, IExpression> map, ShaderParameterFloat shaderParameterFloat) {
        String[] stringArray = shaderParameterFloat.getIndexNames1();
        if (stringArray == null) {
            map.put(shaderParameterFloat.getName(), new ShaderParameterIndexed(shaderParameterFloat));
        } else {
            for (int i = 0; i < stringArray.length; ++i) {
                String string = stringArray[i];
                String[] stringArray2 = shaderParameterFloat.getIndexNames2();
                if (stringArray2 == null) {
                    map.put(shaderParameterFloat.getName() + "." + string, new ShaderParameterIndexed(shaderParameterFloat, i));
                    continue;
                }
                for (int j = 0; j < stringArray2.length; ++j) {
                    String string2 = stringArray2[j];
                    map.put(shaderParameterFloat.getName() + "." + string + "." + string2, new ShaderParameterIndexed(shaderParameterFloat, i, j));
                }
            }
        }
    }

    public boolean registerExpression(String string, IExpression iExpression) {
        if (this.mapExpressions.containsKey(string)) {
            SMCLog.warning("Expression already defined: " + string);
            return false;
        }
        this.mapExpressions.put(string, iExpression);
        return true;
    }

    @Override
    public IExpression getExpression(String string) {
        return this.mapExpressions.get(string);
    }

    public boolean hasExpression(String string) {
        return this.mapExpressions.containsKey(string);
    }
}

