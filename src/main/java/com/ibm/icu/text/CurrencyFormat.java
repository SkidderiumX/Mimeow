/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.MeasureFormat;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import java.text.FieldPosition;
import java.text.ParsePosition;

public class CurrencyFormat
extends MeasureFormat {
    static final long serialVersionUID = -931679363692504634L;
    private NumberFormat fmt;

    public CurrencyFormat(ULocale uLocale) {
        this.fmt = NumberFormat.getCurrencyInstance(uLocale.toLocale());
    }

    public StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        try {
            CurrencyAmount currencyAmount = (CurrencyAmount)object;
            this.fmt.setCurrency(currencyAmount.getCurrency());
            return this.fmt.format(currencyAmount.getNumber(), stringBuffer, fieldPosition);
        }
        catch (ClassCastException classCastException) {
            throw new IllegalArgumentException("Invalid type: " + object.getClass().getName());
        }
    }

    public Object parseObject(String string, ParsePosition parsePosition) {
        return this.fmt.parseCurrency(string, parsePosition);
    }
}

