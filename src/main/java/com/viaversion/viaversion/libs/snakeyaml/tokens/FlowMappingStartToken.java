/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.tokens;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.tokens.Token;

public class FlowMappingStartToken
extends Token {
    public FlowMappingStartToken(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override
    public Token.ID getTokenId() {
        return Token.ID.FlowMappingStart;
    }
}

