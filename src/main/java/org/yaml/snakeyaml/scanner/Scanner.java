/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.tokens.Token;

public interface Scanner {
    public boolean checkToken(Token.ID ... var1);

    default public boolean checkToken(Token.ID iD) {
        return this.checkToken(new Token.ID[]{iD});
    }

    public Token peekToken();

    public Token getToken();

    public void resetDocumentIndex();
}

