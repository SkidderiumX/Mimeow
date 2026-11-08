/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.expr;

import net.optifine.expr.ExpressionType;
import net.optifine.expr.FunctionType;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionFloatArray;

public class FunctionFloatArray
implements IExpressionFloatArray {
    private FunctionType type;
    private IExpression[] arguments;

    public FunctionFloatArray(FunctionType functionType, IExpression[] iExpressionArray) {
        this.type = functionType;
        this.arguments = iExpressionArray;
    }

    @Override
    public float[] eval() {
        return this.type.evalFloatArray(this.arguments);
    }

    @Override
    public ExpressionType getExpressionType() {
        return ExpressionType.FLOAT_ARRAY;
    }

    public String toString() {
        return String.valueOf((Object)this.type) + "()";
    }
}

