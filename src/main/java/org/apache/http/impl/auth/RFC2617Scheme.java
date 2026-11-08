/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.auth;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.impl.auth.AuthSchemeBase;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public abstract class RFC2617Scheme
extends AuthSchemeBase {
    private final Map<String, String> params = new HashMap<String, String>();
    private final Charset credentialsCharset;

    @Deprecated
    public RFC2617Scheme(ChallengeState challengeState) {
        super(challengeState);
        this.credentialsCharset = Consts.ASCII;
    }

    public RFC2617Scheme(Charset charset) {
        this.credentialsCharset = charset != null ? charset : Consts.ASCII;
    }

    public RFC2617Scheme() {
        this(Consts.ASCII);
    }

    public Charset getCredentialsCharset() {
        return this.credentialsCharset;
    }

    String getCredentialsCharset(HttpRequest httpRequest) {
        String string = (String)httpRequest.getParams().getParameter("http.auth.credential-charset");
        if (string == null) {
            string = this.getCredentialsCharset().name();
        }
        return string;
    }

    @Override
    protected void parseChallenge(CharArrayBuffer charArrayBuffer, int n, int n2) throws MalformedChallengeException {
        BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.INSTANCE;
        ParserCursor parserCursor = new ParserCursor(n, charArrayBuffer.length());
        HeaderElement[] headerElementArray = basicHeaderValueParser.parseElements(charArrayBuffer, parserCursor);
        if (headerElementArray.length == 0) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        this.params.clear();
        for (HeaderElement headerElement : headerElementArray) {
            this.params.put(headerElement.getName(), headerElement.getValue());
        }
    }

    protected Map<String, String> getParameters() {
        return this.params;
    }

    @Override
    public String getParameter(String string) {
        if (string == null) {
            return null;
        }
        return this.params.get(string.toLowerCase(Locale.ENGLISH));
    }

    @Override
    public String getRealm() {
        return this.getParameter("realm");
    }
}

