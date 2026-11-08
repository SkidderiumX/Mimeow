/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.tokens;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.tokens.TagTuple;
import com.viaversion.viaversion.libs.snakeyaml.tokens.Token;

public class TagToken
extends Token {
    private final TagTuple value;

    public TagToken(TagTuple tagTuple, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.value = tagTuple;
    }

    public TagTuple getValue() {
        return this.value;
    }

    @Override
    public Token.ID getTokenId() {
        return Token.ID.Tag;
    }
}

