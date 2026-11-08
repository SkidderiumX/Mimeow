/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.expr;

import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpression;
import net.optifine.expr.IParameters;

public class Parameters
implements IParameters {
    private ExpressionType[] parameterTypes;

    public Parameters(ExpressionType[] expressionTypeArray) {
        this.parameterTypes = expressionTypeArray;
    }

    @Override
    public ExpressionType[] getParameterTypes(IExpression[] iExpressionArray) {
        return this.parameterTypes;
    }
}

