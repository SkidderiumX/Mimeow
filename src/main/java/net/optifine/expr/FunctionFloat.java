/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.expr;

import net.optifine.expr.ConstantFloat;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.FunctionType;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionFloat;
import net.optifine.shaders.uniform.Smoother;

public class FunctionFloat
implements IExpressionFloat {
    private FunctionType type;
    private IExpression[] arguments;
    private int smoothId = -1;

    public FunctionFloat(FunctionType functionType, IExpression[] iExpressionArray) {
        this.type = functionType;
        this.arguments = iExpressionArray;
    }

    @Override
    public float eval() {
        IExpression[] iExpressionArray = this.arguments;
        switch (this.type) {
            case SMOOTH: {
                float f;
                IExpression iExpression = iExpressionArray[0];
                if (iExpression instanceof ConstantFloat) break;
                float f2 = FunctionFloat.evalFloat(iExpressionArray, 0);
                float f3 = iExpressionArray.length > 1 ? FunctionFloat.evalFloat(iExpressionArray, 1) : 1.0f;
                float f4 = f = iExpressionArray.length > 2 ? FunctionFloat.evalFloat(iExpressionArray, 2) : f3;
                if (this.smoothId < 0) {
                    this.smoothId = Smoother.getNextId();
                }
                float f5 = Smoother.getSmoothValue(this.smoothId, f2, f3, f);
                return f5;
            }
        }
        return this.type.evalFloat(this.arguments);
    }

    private static float evalFloat(IExpression[] iExpressionArray, int n) {
        IExpressionFloat iExpressionFloat = (IExpressionFloat)iExpressionArray[n];
        float f = iExpressionFloat.eval();
        return f;
    }

    @Override
    public ExpressionType getExpressionType() {
        return ExpressionType.FLOAT;
    }

    public String toString() {
        return String.valueOf((Object)this.type) + "()";
    }
}

