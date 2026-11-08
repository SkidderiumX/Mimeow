/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.auth;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthOption;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Asserts;

public class HttpAuthenticator {
    private final Log log;

    public HttpAuthenticator(Log log) {
        this.log = log != null ? log : LogFactory.getLog(this.getClass());
    }

    public HttpAuthenticator() {
        this(null);
    }

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        if (authenticationStrategy.isAuthenticationRequested(httpHost, httpResponse, httpContext)) {
            this.log.debug("Authentication required");
            if (authState.getState() == AuthProtocolState.SUCCESS) {
                authenticationStrategy.authFailed(httpHost, authState.getAuthScheme(), httpContext);
            }
            return true;
        }
        switch (authState.getState()) {
            case CHALLENGED: 
            case HANDSHAKE: {
                this.log.debug("Authentication succeeded");
                authState.setState(AuthProtocolState.SUCCESS);
                authenticationStrategy.authSucceeded(httpHost, authState.getAuthScheme(), httpContext);
                break;
            }
            case SUCCESS: {
                break;
            }
            default: {
                authState.setState(AuthProtocolState.UNCHALLENGED);
            }
        }
        return false;
    }

    public boolean handleAuthChallenge(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        try {
            Object object;
            Map<String, Header> map;
            if (this.log.isDebugEnabled()) {
                this.log.debug(httpHost.toHostString() + " requested authentication");
            }
            if ((map = authenticationStrategy.getChallenges(httpHost, httpResponse, httpContext)).isEmpty()) {
                this.log.debug("Response contains no authentication challenges");
                return false;
            }
            AuthScheme authScheme = authState.getAuthScheme();
            switch (authState.getState()) {
                case FAILURE: {
                    return false;
                }
                case SUCCESS: {
                    authState.reset();
                    break;
                }
                case CHALLENGED: 
                case HANDSHAKE: {
                    if (authScheme == null) {
                        this.log.debug("Auth scheme is null");
                        authenticationStrategy.authFailed(httpHost, null, httpContext);
                        authState.reset();
                        authState.setState(AuthProtocolState.FAILURE);
                        return false;
                    }
                }
                case UNCHALLENGED: {
                    if (authScheme == null) break;
                    object = authScheme.getSchemeName();
                    Header header = map.get(((String)object).toLowerCase(Locale.US));
                    if (header != null) {
                        this.log.debug("Authorization challenge processed");
                        authScheme.processChallenge(header);
                        if (authScheme.isComplete()) {
                            this.log.debug("Authentication failed");
                            authenticationStrategy.authFailed(httpHost, authState.getAuthScheme(), httpContext);
                            authState.reset();
                            authState.setState(AuthProtocolState.FAILURE);
                            return false;
                        }
                        authState.setState(AuthProtocolState.HANDSHAKE);
                        return true;
                    }
                    authState.reset();
                }
            }
            object = authenticationStrategy.select(map, httpHost, httpResponse, httpContext);
            if (object != null && !object.isEmpty()) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Selected authentication options: " + object);
                }
                authState.setState(AuthProtocolState.CHALLENGED);
                authState.update((Queue<AuthOption>)object);
                return true;
            }
            return false;
        }
        catch (MalformedChallengeException malformedChallengeException) {
            if (this.log.isWarnEnabled()) {
                this.log.warn("Malformed challenge: " + malformedChallengeException.getMessage());
            }
            authState.reset();
            return false;
        }
    }

    public void generateAuthResponse(HttpRequest httpRequest, AuthState authState, HttpContext httpContext) throws HttpException, IOException {
        block13: {
            Object object;
            AuthScheme authScheme = authState.getAuthScheme();
            Credentials credentials = authState.getCredentials();
            switch (authState.getState()) {
                case FAILURE: {
                    return;
                }
                case SUCCESS: {
                    this.ensureAuthScheme(authScheme);
                    if (!authScheme.isConnectionBased()) break;
                    return;
                }
                case CHALLENGED: {
                    object = authState.getAuthOptions();
                    if (object != null) {
                        while (!object.isEmpty()) {
                            AuthOption authOption = object.remove();
                            authScheme = authOption.getAuthScheme();
                            credentials = authOption.getCredentials();
                            authState.update(authScheme, credentials);
                            if (this.log.isDebugEnabled()) {
                                this.log.debug("Generating response to an authentication challenge using " + authScheme.getSchemeName() + " scheme");
                            }
                            try {
                                Header header = this.doAuth(authScheme, credentials, httpRequest, httpContext);
                                httpRequest.addHeader(header);
                                break;
                            }
                            catch (AuthenticationException authenticationException) {
                                if (!this.log.isWarnEnabled()) continue;
                                this.log.warn(authScheme + " authentication error: " + authenticationException.getMessage());
                            }
                        }
                        return;
                    }
                    this.ensureAuthScheme(authScheme);
                }
            }
            if (authScheme != null) {
                try {
                    object = this.doAuth(authScheme, credentials, httpRequest, httpContext);
                    httpRequest.addHeader((Header)object);
                }
                catch (AuthenticationException authenticationException) {
                    if (!this.log.isErrorEnabled()) break block13;
                    this.log.error(authScheme + " authentication error: " + authenticationException.getMessage());
                }
            }
        }
    }

    private void ensureAuthScheme(AuthScheme authScheme) {
        Asserts.notNull(authScheme, "Auth scheme");
    }

    private Header doAuth(AuthScheme authScheme, Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        int n = 306269187;
        block5: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case 306269187: {
                    if (authScheme instanceof ContextAwareAuthScheme) {
                        n = 1104809364;
                        continue block5;
                    }
                    n = 1225093929;
                    continue block5;
                }
                case 1225093929: {
                    return authScheme.authenticate(credentials, httpRequest);
                }
                case 1104809364: 
            }
            break;
        }
        return ((ContextAwareAuthScheme)authScheme).authenticate(credentials, httpRequest, httpContext);
    }
}

