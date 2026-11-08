/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.tokens;

import com.viaversion.viaversion.libs.snakeyaml.comments.CommentType;
import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.tokens.Token;
import java.util.Objects;

public class CommentToken
extends Token {
    private final CommentType type;
    private final String value;

    public CommentToken(CommentType commentType, String string, Mark mark, Mark mark2) {
        super(mark, mark2);
        Objects.requireNonNull(commentType);
        this.type = commentType;
        Objects.requireNonNull(string);
        this.value = string;
    }

    public CommentType getCommentType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public Token.ID getTokenId() {
        return Token.ID.Comment;
    }
}

