/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.ssl;

import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.ssl.PrivateKeyDetails;
import org.apache.http.conn.ssl.PrivateKeyStrategy;
import org.apache.http.conn.ssl.TrustStrategy;

@NotThreadSafe
public class SSLContextBuilder {
    static final String TLS = "TLS";
    static final String SSL = "SSL";
    private String protocol;
    private Set<KeyManager> keymanagers = new HashSet<KeyManager>();
    private Set<TrustManager> trustmanagers = new HashSet<TrustManager>();
    private SecureRandom secureRandom;

    public SSLContextBuilder useTLS() {
        this.protocol = TLS;
        return this;
    }

    public SSLContextBuilder useSSL() {
        this.protocol = SSL;
        return this;
    }

    public SSLContextBuilder useProtocol(String string) {
        this.protocol = string;
        return this;
    }

    public SSLContextBuilder setSecureRandom(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keyStore, TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagerArray = trustManagerFactory.getTrustManagers();
        if (trustManagerArray != null) {
            if (trustStrategy != null) {
                for (int i = 0; i < trustManagerArray.length; ++i) {
                    TrustManager trustManager = trustManagerArray[i];
                    if (!(trustManager instanceof X509TrustManager)) continue;
                    trustManagerArray[i] = new TrustManagerDelegate((X509TrustManager)trustManager, trustStrategy);
                }
            }
            for (TrustManager trustManager : trustManagerArray) {
                this.trustmanagers.add(trustManager);
            }
        }
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        return this.loadTrustMaterial(keyStore, null);
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore, char[] cArray) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        this.loadKeyMaterial(keyStore, cArray, null);
        return this;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore, char[] cArray, PrivateKeyStrategy privateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, cArray);
        KeyManager[] keyManagerArray = keyManagerFactory.getKeyManagers();
        if (keyManagerArray != null) {
            if (privateKeyStrategy != null) {
                for (int i = 0; i < keyManagerArray.length; ++i) {
                    KeyManager keyManager = keyManagerArray[i];
                    if (!(keyManager instanceof X509KeyManager)) continue;
                    keyManagerArray[i] = new KeyManagerDelegate((X509KeyManager)keyManager, privateKeyStrategy);
                }
            }
            for (KeyManager keyManager : keyManagerArray) {
                this.keymanagers.add(keyManager);
            }
        }
        return this;
    }

    public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance(this.protocol != null ? this.protocol : TLS);
        sSLContext.init(!this.keymanagers.isEmpty() ? this.keymanagers.toArray(new KeyManager[this.keymanagers.size()]) : null, !this.trustmanagers.isEmpty() ? this.trustmanagers.toArray(new TrustManager[this.trustmanagers.size()]) : null, this.secureRandom);
        return sSLContext;
    }

    public static class KeyManagerDelegate
    implements X509KeyManager {
        private final X509KeyManager keyManager;
        private final PrivateKeyStrategy aliasStrategy;

        KeyManagerDelegate(X509KeyManager x509KeyManager, PrivateKeyStrategy privateKeyStrategy) {
            this.keyManager = x509KeyManager;
            this.aliasStrategy = privateKeyStrategy;
        }

        public String[] getClientAliases(String string, Principal[] principalArray) {
            return this.keyManager.getClientAliases(string, principalArray);
        }

        public String chooseClientAlias(String[] stringArray, Principal[] principalArray, Socket socket) {
            HashMap<String, PrivateKeyDetails> hashMap = new HashMap<String, PrivateKeyDetails>();
            for (String string : stringArray) {
                String[] stringArray2 = this.keyManager.getClientAliases(string, principalArray);
                if (stringArray2 == null) continue;
                for (String string2 : stringArray2) {
                    hashMap.put(string2, new PrivateKeyDetails(string, this.keyManager.getCertificateChain(string2)));
                }
            }
            return this.aliasStrategy.chooseAlias(hashMap, socket);
        }

        public String[] getServerAliases(String string, Principal[] principalArray) {
            return this.keyManager.getServerAliases(string, principalArray);
        }

        public String chooseServerAlias(String string, Principal[] principalArray, Socket socket) {
            HashMap<String, PrivateKeyDetails> hashMap = new HashMap<String, PrivateKeyDetails>();
            String[] stringArray = this.keyManager.getServerAliases(string, principalArray);
            if (stringArray != null) {
                for (String string2 : stringArray) {
                    hashMap.put(string2, new PrivateKeyDetails(string, this.keyManager.getCertificateChain(string2)));
                }
            }
            return this.aliasStrategy.chooseAlias(hashMap, socket);
        }

        public X509Certificate[] getCertificateChain(String string) {
            return this.keyManager.getCertificateChain(string);
        }

        public PrivateKey getPrivateKey(String string) {
            return this.keyManager.getPrivateKey(string);
        }
    }

    public static class TrustManagerDelegate
    implements X509TrustManager {
        private final X509TrustManager trustManager;
        private final TrustStrategy trustStrategy;

        TrustManagerDelegate(X509TrustManager x509TrustManager, TrustStrategy trustStrategy) {
            this.trustManager = x509TrustManager;
            this.trustStrategy = trustStrategy;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
            this.trustManager.checkClientTrusted(x509CertificateArray, string);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
            if (!this.trustStrategy.isTrusted(x509CertificateArray, string)) {
                this.trustManager.checkServerTrusted(x509CertificateArray, string);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }
    }
}

