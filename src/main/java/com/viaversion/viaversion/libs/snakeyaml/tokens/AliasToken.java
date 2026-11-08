/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.tokens;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.tokens.Token;

public class AliasToken
extends Token {
    private final String value;

    public AliasToken(String string, Mark mark, Mark mark2) {
        super(mark, mark2);
        if (string == null) {
            throw new NullPointerException("alias is expected");
        }
        this.value = string;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public Token.ID getTokenId() {
        return Token.ID.Alias;
    }
}

