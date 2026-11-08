/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.expr;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionBool;
import net.optifine.expr.IExpressionFloat;
import net.optifine.expr.IParameters;
import net.optifine.expr.Parameters;
import net.optifine.expr.ParametersVariable;
import net.optifine.shaders.uniform.Smoother;
import net.optifine.util.MathUtils;

public enum FunctionType {
    PLUS(10, ExpressionType.FLOAT, "+", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    MINUS(10, ExpressionType.FLOAT, "-", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    MUL(11, ExpressionType.FLOAT, "*", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    DIV(11, ExpressionType.FLOAT, "/", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    MOD(11, ExpressionType.FLOAT, "%", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    NEG(12, ExpressionType.FLOAT, "neg", new ExpressionType[]{ExpressionType.FLOAT}),
    PI(ExpressionType.FLOAT, "pi", new ExpressionType[0]),
    SIN(ExpressionType.FLOAT, "sin", new ExpressionType[]{ExpressionType.FLOAT}),
    COS(ExpressionType.FLOAT, "cos", new ExpressionType[]{ExpressionType.FLOAT}),
    ASIN(ExpressionType.FLOAT, "asin", new ExpressionType[]{ExpressionType.FLOAT}),
    ACOS(ExpressionType.FLOAT, "acos", new ExpressionType[]{ExpressionType.FLOAT}),
    TAN(ExpressionType.FLOAT, "tan", new ExpressionType[]{ExpressionType.FLOAT}),
    ATAN(ExpressionType.FLOAT, "atan", new ExpressionType[]{ExpressionType.FLOAT}),
    ATAN2(ExpressionType.FLOAT, "atan2", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    TORAD(ExpressionType.FLOAT, "torad", new ExpressionType[]{ExpressionType.FLOAT}),
    TODEG(ExpressionType.FLOAT, "todeg", new ExpressionType[]{ExpressionType.FLOAT}),
    MIN(ExpressionType.FLOAT, "min", new ParametersVariable().first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT)),
    MAX(ExpressionType.FLOAT, "max", new ParametersVariable().first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT)),
    CLAMP(ExpressionType.FLOAT, "clamp", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
    ABS(ExpressionType.FLOAT, "abs", new ExpressionType[]{ExpressionType.FLOAT}),
    FLOOR(ExpressionType.FLOAT, "floor", new ExpressionType[]{ExpressionType.FLOAT}),
    CEIL(ExpressionType.FLOAT, "ceil", new ExpressionType[]{ExpressionType.FLOAT}),
    EXP(ExpressionType.FLOAT, "exp", new ExpressionType[]{ExpressionType.FLOAT}),
    FRAC(ExpressionType.FLOAT, "frac", new ExpressionType[]{ExpressionType.FLOAT}),
    LOG(ExpressionType.FLOAT, "log", new ExpressionType[]{ExpressionType.FLOAT}),
    POW(ExpressionType.FLOAT, "pow", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    RANDOM(ExpressionType.FLOAT, "random", new ExpressionType[0]),
    ROUND(ExpressionType.FLOAT, "round", new ExpressionType[]{ExpressionType.FLOAT}),
    SIGNUM(ExpressionType.FLOAT, "signum", new ExpressionType[]{ExpressionType.FLOAT}),
    SQRT(ExpressionType.FLOAT, "sqrt", new ExpressionType[]{ExpressionType.FLOAT}),
    FMOD(ExpressionType.FLOAT, "fmod", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    TIME(ExpressionType.FLOAT, "time", new ExpressionType[0]),
    IF(ExpressionType.FLOAT, "if", new ParametersVariable().first(ExpressionType.BOOL, ExpressionType.FLOAT).repeat(ExpressionType.BOOL, ExpressionType.FLOAT).last(ExpressionType.FLOAT)),
    NOT(12, ExpressionType.BOOL, "!", new ExpressionType[]{ExpressionType.BOOL}),
    AND(3, ExpressionType.BOOL, "&&", new ExpressionType[]{ExpressionType.BOOL, ExpressionType.BOOL}),
    OR(2, ExpressionType.BOOL, "||", new ExpressionType[]{ExpressionType.BOOL, ExpressionType.BOOL}),
    GREATER(8, ExpressionType.BOOL, ">", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    GREATER_OR_EQUAL(8, ExpressionType.BOOL, ">=", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    SMALLER(8, ExpressionType.BOOL, "<", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    SMALLER_OR_EQUAL(8, ExpressionType.BOOL, "<=", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    EQUAL(7, ExpressionType.BOOL, "==", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    NOT_EQUAL(7, ExpressionType.BOOL, "!=", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    BETWEEN(7, ExpressionType.BOOL, "between", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
    EQUALS(7, ExpressionType.BOOL, "equals", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
    IN(ExpressionType.BOOL, "in", new ParametersVariable().first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT).last(ExpressionType.FLOAT)),
    SMOOTH(ExpressionType.FLOAT, "smooth", new ParametersVariable().first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT).maxCount(4)),
    TRUE(ExpressionType.BOOL, "true", new ExpressionType[0]),
    FALSE(ExpressionType.BOOL, "false", new ExpressionType[0]),
    VEC2(ExpressionType.FLOAT_ARRAY, "vec2", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
    VEC3(ExpressionType.FLOAT_ARRAY, "vec3", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
    VEC4(ExpressionType.FLOAT_ARRAY, "vec4", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT});

    private int precedence;
    private ExpressionType expressionType;
    private String name;
    private IParameters parameters;
    public static FunctionType[] VALUES;
    private static final Map<Integer, Float> mapSmooth;

    private FunctionType(ExpressionType expressionType, String string2, ExpressionType[] expressionTypeArray) {
        this(0, expressionType, string2, expressionTypeArray);
    }

    private FunctionType(int n2, ExpressionType expressionType, String string2, ExpressionType[] expressionTypeArray) {
        this(n2, expressionType, string2, new Parameters(expressionTypeArray));
    }

    private FunctionType(ExpressionType expressionType, String string2, IParameters iParameters) {
        this(0, expressionType, string2, iParameters);
    }

    private FunctionType(int n2, ExpressionType expressionType, String string2, IParameters iParameters) {
        this.precedence = n2;
        this.expressionType = expressionType;
        this.name = string2;
        this.parameters = iParameters;
    }

    public String getName() {
        return this.name;
    }

    public int getPrecedence() {
        return this.precedence;
    }

    public ExpressionType getExpressionType() {
        return this.expressionType;
    }

    public IParameters getParameters() {
        return this.parameters;
    }

    public int getParameterCount(IExpression[] iExpressionArray) {
        return this.parameters.getParameterTypes(iExpressionArray).length;
    }

    public ExpressionType[] getParameterTypes(IExpression[] iExpressionArray) {
        return this.parameters.getParameterTypes(iExpressionArray);
    }

    public float evalFloat(IExpression[] iExpressionArray) {
        switch (this) {
            case PLUS: {
                return FunctionType.evalFloat(iExpressionArray, 0) + FunctionType.evalFloat(iExpressionArray, 1);
            }
            case MINUS: {
                return FunctionType.evalFloat(iExpressionArray, 0) - FunctionType.evalFloat(iExpressionArray, 1);
            }
            case MUL: {
                return FunctionType.evalFloat(iExpressionArray, 0) * FunctionType.evalFloat(iExpressionArray, 1);
            }
            case DIV: {
                return FunctionType.evalFloat(iExpressionArray, 0) / FunctionType.evalFloat(iExpressionArray, 1);
            }
            case MOD: {
                float f = FunctionType.evalFloat(iExpressionArray, 0);
                float f2 = FunctionType.evalFloat(iExpressionArray, 1);
                return f - f2 * (float)((int)(f / f2));
            }
            case NEG: {
                return -FunctionType.evalFloat(iExpressionArray, 0);
            }
            case PI: {
                return MathHelper.PI;
            }
            case SIN: {
                return MathHelper.sin(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case COS: {
                return MathHelper.cos(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case ASIN: {
                return MathUtils.asin(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case ACOS: {
                return MathUtils.acos(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case TAN: {
                return (float)Math.tan(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case ATAN: {
                return (float)Math.atan(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case ATAN2: {
                return (float)MathHelper.atan2(FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1));
            }
            case TORAD: {
                return MathUtils.toRad(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case TODEG: {
                return MathUtils.toDeg(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case MIN: {
                return this.getMin(iExpressionArray);
            }
            case MAX: {
                return this.getMax(iExpressionArray);
            }
            case CLAMP: {
                return MathHelper.clamp_float(FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1), FunctionType.evalFloat(iExpressionArray, 2));
            }
            case ABS: {
                return MathHelper.abs(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case EXP: {
                return (float)Math.exp(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case FLOOR: {
                return MathHelper.floor_float(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case CEIL: {
                return MathHelper.ceiling_float_int(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case FRAC: {
                return (float)MathHelper.func_181162_h(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case LOG: {
                return (float)Math.log(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case POW: {
                return (float)Math.pow(FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1));
            }
            case RANDOM: {
                return (float)Math.random();
            }
            case ROUND: {
                return Math.round(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case SIGNUM: {
                return Math.signum(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case SQRT: {
                return MathHelper.sqrt_float(FunctionType.evalFloat(iExpressionArray, 0));
            }
            case FMOD: {
                float f = FunctionType.evalFloat(iExpressionArray, 0);
                float f3 = FunctionType.evalFloat(iExpressionArray, 1);
                return f - f3 * (float)MathHelper.floor_float(f / f3);
            }
            case TIME: {
                Minecraft minecraft = Minecraft.getMinecraft();
                WorldClient worldClient = minecraft.theWorld;
                if (worldClient == null) {
                    return 0.0f;
                }
                return (float)(worldClient.getTotalWorldTime() % 24000L) + Config.renderPartialTicks;
            }
            case IF: {
                int n = (iExpressionArray.length - 1) / 2;
                for (int i = 0; i < n; ++i) {
                    int n2 = i * 2;
                    if (!FunctionType.evalBool(iExpressionArray, n2)) continue;
                    return FunctionType.evalFloat(iExpressionArray, n2 + 1);
                }
                return FunctionType.evalFloat(iExpressionArray, n * 2);
            }
            case SMOOTH: {
                int n = (int)FunctionType.evalFloat(iExpressionArray, 0);
                float f = FunctionType.evalFloat(iExpressionArray, 1);
                float f4 = iExpressionArray.length > 2 ? FunctionType.evalFloat(iExpressionArray, 2) : 1.0f;
                float f5 = iExpressionArray.length > 3 ? FunctionType.evalFloat(iExpressionArray, 3) : f4;
                float f6 = Smoother.getSmoothValue(n, f, f4, f5);
                return f6;
            }
        }
        Config.warn("Unknown function type: " + String.valueOf((Object)this));
        return 0.0f;
    }

    private float getMin(IExpression[] iExpressionArray) {
        if (iExpressionArray.length == 2) {
            return Math.min(FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1));
        }
        float f = FunctionType.evalFloat(iExpressionArray, 0);
        for (int i = 1; i < iExpressionArray.length; ++i) {
            float f2 = FunctionType.evalFloat(iExpressionArray, i);
            if (!(f2 < f)) continue;
            f = f2;
        }
        return f;
    }

    private float getMax(IExpression[] iExpressionArray) {
        if (iExpressionArray.length == 2) {
            return Math.max(FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1));
        }
        float f = FunctionType.evalFloat(iExpressionArray, 0);
        for (int i = 1; i < iExpressionArray.length; ++i) {
            float f2 = FunctionType.evalFloat(iExpressionArray, i);
            if (!(f2 > f)) continue;
            f = f2;
        }
        return f;
    }

    private static float evalFloat(IExpression[] iExpressionArray, int n) {
        IExpressionFloat iExpressionFloat = (IExpressionFloat)iExpressionArray[n];
        float f = iExpressionFloat.eval();
        return f;
    }

    public boolean evalBool(IExpression[] iExpressionArray) {
        switch (this) {
            case TRUE: {
                return true;
            }
            case FALSE: {
                return false;
            }
            case NOT: {
                return !FunctionType.evalBool(iExpressionArray, 0);
            }
            case AND: {
                return FunctionType.evalBool(iExpressionArray, 0) && FunctionType.evalBool(iExpressionArray, 1);
            }
            case OR: {
                return FunctionType.evalBool(iExpressionArray, 0) || FunctionType.evalBool(iExpressionArray, 1);
            }
            case GREATER: {
                return FunctionType.evalFloat(iExpressionArray, 0) > FunctionType.evalFloat(iExpressionArray, 1);
            }
            case GREATER_OR_EQUAL: {
                return FunctionType.evalFloat(iExpressionArray, 0) >= FunctionType.evalFloat(iExpressionArray, 1);
            }
            case SMALLER: {
                return FunctionType.evalFloat(iExpressionArray, 0) < FunctionType.evalFloat(iExpressionArray, 1);
            }
            case SMALLER_OR_EQUAL: {
                return FunctionType.evalFloat(iExpressionArray, 0) <= FunctionType.evalFloat(iExpressionArray, 1);
            }
            case EQUAL: {
                return FunctionType.evalFloat(iExpressionArray, 0) == FunctionType.evalFloat(iExpressionArray, 1);
            }
            case NOT_EQUAL: {
                return FunctionType.evalFloat(iExpressionArray, 0) != FunctionType.evalFloat(iExpressionArray, 1);
            }
            case BETWEEN: {
                float f = FunctionType.evalFloat(iExpressionArray, 0);
                return f >= FunctionType.evalFloat(iExpressionArray, 1) && f <= FunctionType.evalFloat(iExpressionArray, 2);
            }
            case EQUALS: {
                float f = FunctionType.evalFloat(iExpressionArray, 0) - FunctionType.evalFloat(iExpressionArray, 1);
                float f2 = FunctionType.evalFloat(iExpressionArray, 2);
                return Math.abs(f) <= f2;
            }
            case IN: {
                float f = FunctionType.evalFloat(iExpressionArray, 0);
                for (int i = 1; i < iExpressionArray.length; ++i) {
                    float f3 = FunctionType.evalFloat(iExpressionArray, i);
                    if (f != f3) continue;
                    return true;
                }
                return false;
            }
        }
        Config.warn("Unknown function type: " + String.valueOf((Object)this));
        return false;
    }

    private static boolean evalBool(IExpression[] iExpressionArray, int n) {
        IExpressionBool iExpressionBool = (IExpressionBool)iExpressionArray[n];
        boolean bl = iExpressionBool.eval();
        return bl;
    }

    public float[] evalFloatArray(IExpression[] iExpressionArray) {
        switch (this) {
            case VEC2: {
                return new float[]{FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1)};
            }
            case VEC3: {
                return new float[]{FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1), FunctionType.evalFloat(iExpressionArray, 2)};
            }
            case VEC4: {
                return new float[]{FunctionType.evalFloat(iExpressionArray, 0), FunctionType.evalFloat(iExpressionArray, 1), FunctionType.evalFloat(iExpressionArray, 2), FunctionType.evalFloat(iExpressionArray, 3)};
            }
        }
        Config.warn("Unknown function type: " + String.valueOf((Object)this));
        return null;
    }

    public static FunctionType parse(String string) {
        for (int i = 0; i < VALUES.length; ++i) {
            FunctionType functionType = VALUES[i];
            if (!functionType.getName().equals(string)) continue;
            return functionType;
        }
        return null;
    }

    static {
        VALUES = FunctionType.values();
        mapSmooth = new HashMap<Integer, Float>();
    }
}

