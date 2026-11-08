/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token;

public class BlockEntryToken
extends Token {
    public BlockEntryToken(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override
    public Token.ID getTokenId() {
        return Token.ID.BlockEntry;
    }
}

