/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.auth;

import java.io.Serializable;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.auth.AuthSchemeBase;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

@NotThreadSafe
public abstract class GGSSchemeBase
extends AuthSchemeBase {
    private final Log log = LogFactory.getLog(this.getClass());
    private final Base64 base64codec = new Base64(0);
    private final boolean stripPort;
    private State state;
    private byte[] token;

    GGSSchemeBase(boolean bl) {
        this.stripPort = bl;
        this.state = State.UNINITIATED;
    }

    GGSSchemeBase() {
        this(false);
    }

    protected GSSManager getManager() {
        return GSSManager.getInstance();
    }

    protected byte[] generateGSSToken(byte[] byArray, Oid oid, String string) throws GSSException {
        byte[] byArray2 = byArray;
        if (byArray2 == null) {
            byArray2 = new byte[]{};
        }
        GSSManager gSSManager = this.getManager();
        GSSName gSSName = gSSManager.createName("HTTP@" + string, GSSName.NT_HOSTBASED_SERVICE);
        GSSContext gSSContext = gSSManager.createContext(gSSName.canonicalize(oid), oid, null, 0);
        gSSContext.requestMutualAuth(true);
        gSSContext.requestCredDeleg(true);
        return gSSContext.initSecContext(byArray2, 0, byArray2.length);
    }

    protected abstract byte[] generateToken(byte[] var1, String var2) throws GSSException;

    public boolean isComplete() {
        return this.state == State.TOKEN_GENERATED || this.state == State.FAILED;
    }

    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return this.authenticate(credentials, httpRequest, null);
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(httpRequest, "HTTP request");
        switch (this.state) {
            case UNINITIATED: {
                throw new AuthenticationException(this.getSchemeName() + " authentication has not been initiated");
            }
            case FAILED: {
                throw new AuthenticationException(this.getSchemeName() + " authentication has failed");
            }
            case CHALLENGE_RECEIVED: {
                Serializable serializable;
                Object object;
                try {
                    object = (HttpRoute)httpContext.getAttribute("http.route");
                    if (object == null) {
                        throw new AuthenticationException("Connection route is not available");
                    }
                    if (this.isProxy()) {
                        serializable = ((HttpRoute)object).getProxyHost();
                        if (serializable == null) {
                            serializable = ((HttpRoute)object).getTargetHost();
                        }
                    } else {
                        serializable = ((HttpRoute)object).getTargetHost();
                    }
                    String string = !this.stripPort && ((HttpHost)serializable).getPort() > 0 ? ((HttpHost)serializable).toHostString() : ((HttpHost)serializable).getHostName();
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("init " + string);
                    }
                    this.token = this.generateToken(this.token, string);
                    this.state = State.TOKEN_GENERATED;
                }
                catch (GSSException gSSException) {
                    this.state = State.FAILED;
                    if (gSSException.getMajor() == 9 || gSSException.getMajor() == 8) {
                        throw new InvalidCredentialsException(gSSException.getMessage(), gSSException);
                    }
                    if (gSSException.getMajor() == 13) {
                        throw new InvalidCredentialsException(gSSException.getMessage(), gSSException);
                    }
                    if (gSSException.getMajor() == 10 || gSSException.getMajor() == 19 || gSSException.getMajor() == 20) {
                        throw new AuthenticationException(gSSException.getMessage(), gSSException);
                    }
                    throw new AuthenticationException(gSSException.getMessage());
                }
            }
            case TOKEN_GENERATED: {
                Object object = new String(this.base64codec.encode(this.token));
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Sending response '" + (String)object + "' back to the auth server");
                }
                Serializable serializable = new CharArrayBuffer(32);
                if (this.isProxy()) {
                    ((CharArrayBuffer)serializable).append("Proxy-Authorization");
                } else {
                    ((CharArrayBuffer)serializable).append("Authorization");
                }
                ((CharArrayBuffer)serializable).append(": Negotiate ");
                ((CharArrayBuffer)serializable).append((String)object);
                return new BufferedHeader((CharArrayBuffer)serializable);
            }
        }
        throw new IllegalStateException("Illegal state: " + (Object)((Object)this.state));
    }

    protected void parseChallenge(CharArrayBuffer charArrayBuffer, int n, int n2) throws MalformedChallengeException {
        String string = charArrayBuffer.substringTrimmed(n, n2);
        if (this.log.isDebugEnabled()) {
            this.log.debug("Received challenge '" + string + "' from the auth server");
        }
        if (this.state == State.UNINITIATED) {
            this.token = Base64.decodeBase64(string.getBytes());
            this.state = State.CHALLENGE_RECEIVED;
        } else {
            this.log.debug("Authentication already attempted");
            this.state = State.FAILED;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        TOKEN_GENERATED,
        FAILED;

    }
}

