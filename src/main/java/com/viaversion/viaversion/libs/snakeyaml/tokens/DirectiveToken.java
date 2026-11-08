/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.tokens;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.error.YAMLException;
import com.viaversion.viaversion.libs.snakeyaml.tokens.Token;
import java.util.List;

public class DirectiveToken<T>
extends Token {
    private final String name;
    private final List<T> value;

    public DirectiveToken(String string, List<T> list, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.name = string;
        if (list != null && list.size() != 2) {
            throw new YAMLException("Two strings must be provided instead of " + list.size());
        }
        this.value = list;
    }

    public String getName() {
        return this.name;
    }

    public List<T> getValue() {
        return this.value;
    }

    @Override
    public Token.ID getTokenId() {
        return Token.ID.Directive;
    }
}

