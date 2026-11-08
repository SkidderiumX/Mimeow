/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net.ssl;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.net.ssl.KeyStoreConfiguration;
import org.apache.logging.log4j.core.net.ssl.KeyStoreConfigurationException;
import org.apache.logging.log4j.core.net.ssl.StoreConfigurationException;
import org.apache.logging.log4j.core.net.ssl.TrustStoreConfiguration;
import org.apache.logging.log4j.core.net.ssl.TrustStoreConfigurationException;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="ssl", category="Core", printObject=true)
public class SSLConfiguration {
    private static final StatusLogger LOGGER = StatusLogger.getLogger();
    private KeyStoreConfiguration keyStoreConfig;
    private TrustStoreConfiguration trustStoreConfig;
    private SSLContext sslContext;

    private SSLConfiguration(KeyStoreConfiguration keyStoreConfiguration, TrustStoreConfiguration trustStoreConfiguration) {
        this.keyStoreConfig = keyStoreConfiguration;
        this.trustStoreConfig = trustStoreConfiguration;
        this.sslContext = null;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        if (this.sslContext == null) {
            this.sslContext = this.createSSLContext();
        }
        return this.sslContext.getSocketFactory();
    }

    public SSLServerSocketFactory getSSLServerSocketFactory() {
        if (this.sslContext == null) {
            this.sslContext = this.createSSLContext();
        }
        return this.sslContext.getServerSocketFactory();
    }

    private SSLContext createSSLContext() {
        SSLContext sSLContext = null;
        try {
            sSLContext = this.createSSLContextBasedOnConfiguration();
            LOGGER.debug("Creating SSLContext with the given parameters");
        }
        catch (TrustStoreConfigurationException trustStoreConfigurationException) {
            sSLContext = this.createSSLContextWithTrustStoreFailure();
        }
        catch (KeyStoreConfigurationException keyStoreConfigurationException) {
            sSLContext = this.createSSLContextWithKeyStoreFailure();
        }
        return sSLContext;
    }

    private SSLContext createSSLContextWithTrustStoreFailure() {
        SSLContext sSLContext;
        try {
            sSLContext = this.createSSLContextWithDefaultTrustManagerFactory();
            LOGGER.debug("Creating SSLContext with default truststore");
        }
        catch (KeyStoreConfigurationException keyStoreConfigurationException) {
            sSLContext = this.createDefaultSSLContext();
            LOGGER.debug("Creating SSLContext with default configuration");
        }
        return sSLContext;
    }

    private SSLContext createSSLContextWithKeyStoreFailure() {
        SSLContext sSLContext;
        try {
            sSLContext = this.createSSLContextWithDefaultKeyManagerFactory();
            LOGGER.debug("Creating SSLContext with default keystore");
        }
        catch (TrustStoreConfigurationException trustStoreConfigurationException) {
            sSLContext = this.createDefaultSSLContext();
            LOGGER.debug("Creating SSLContext with default configuration");
        }
        return sSLContext;
    }

    private SSLContext createSSLContextBasedOnConfiguration() throws KeyStoreConfigurationException, TrustStoreConfigurationException {
        return this.createSSLContext(false, false);
    }

    private SSLContext createSSLContextWithDefaultKeyManagerFactory() throws TrustStoreConfigurationException {
        try {
            return this.createSSLContext(true, false);
        }
        catch (KeyStoreConfigurationException keyStoreConfigurationException) {
            LOGGER.debug("Exception occured while using default keystore. This should be a BUG");
            return null;
        }
    }

    private SSLContext createSSLContextWithDefaultTrustManagerFactory() throws KeyStoreConfigurationException {
        try {
            return this.createSSLContext(false, true);
        }
        catch (TrustStoreConfigurationException trustStoreConfigurationException) {
            LOGGER.debug("Exception occured while using default truststore. This should be a BUG");
            return null;
        }
    }

    private SSLContext createDefaultSSLContext() {
        try {
            return SSLContext.getDefault();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            LOGGER.error("Failed to create an SSLContext with default configuration");
            return null;
        }
    }

    private SSLContext createSSLContext(boolean bl, boolean bl2) throws KeyStoreConfigurationException, TrustStoreConfigurationException {
        try {
            Object object;
            KeyManager[] keyManagerArray = null;
            TrustManager[] trustManagerArray = null;
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            if (!bl) {
                object = this.loadKeyManagerFactory();
                keyManagerArray = ((KeyManagerFactory)object).getKeyManagers();
            }
            if (!bl2) {
                object = this.loadTrustManagerFactory();
                trustManagerArray = ((TrustManagerFactory)object).getTrustManagers();
            }
            sSLContext.init(keyManagerArray, trustManagerArray, null);
            return sSLContext;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            LOGGER.error("No Provider supports a TrustManagerFactorySpi implementation for the specified protocol");
            throw new TrustStoreConfigurationException(noSuchAlgorithmException);
        }
        catch (KeyManagementException keyManagementException) {
            LOGGER.error("Failed to initialize the SSLContext");
            throw new KeyStoreConfigurationException(keyManagementException);
        }
    }

    private TrustManagerFactory loadTrustManagerFactory() throws TrustStoreConfigurationException {
        KeyStore keyStore = null;
        TrustManagerFactory trustManagerFactory = null;
        if (this.trustStoreConfig == null) {
            throw new TrustStoreConfigurationException(new Exception("The trustStoreConfiguration is null"));
        }
        try {
            keyStore = this.trustStoreConfig.getTrustStore();
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            LOGGER.error("The specified algorithm is not available from the specified provider");
            throw new TrustStoreConfigurationException(noSuchAlgorithmException);
        }
        catch (KeyStoreException keyStoreException) {
            LOGGER.error("Failed to initialize the TrustManagerFactory");
            throw new TrustStoreConfigurationException(keyStoreException);
        }
        catch (StoreConfigurationException storeConfigurationException) {
            throw new TrustStoreConfigurationException(storeConfigurationException);
        }
        return trustManagerFactory;
    }

    private KeyManagerFactory loadKeyManagerFactory() throws KeyStoreConfigurationException {
        KeyStore keyStore = null;
        KeyManagerFactory keyManagerFactory = null;
        if (this.keyStoreConfig == null) {
            throw new KeyStoreConfigurationException(new Exception("The keyStoreConfiguration is null"));
        }
        try {
            keyStore = this.keyStoreConfig.getKeyStore();
            keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, this.keyStoreConfig.getPasswordAsCharArray());
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            LOGGER.error("The specified algorithm is not available from the specified provider");
            throw new KeyStoreConfigurationException(noSuchAlgorithmException);
        }
        catch (KeyStoreException keyStoreException) {
            LOGGER.error("Failed to initialize the TrustManagerFactory");
            throw new KeyStoreConfigurationException(keyStoreException);
        }
        catch (StoreConfigurationException storeConfigurationException) {
            throw new KeyStoreConfigurationException(storeConfigurationException);
        }
        catch (UnrecoverableKeyException unrecoverableKeyException) {
            LOGGER.error("The key cannot be recovered (e.g. the given password is wrong)");
            throw new KeyStoreConfigurationException(unrecoverableKeyException);
        }
        return keyManagerFactory;
    }

    public boolean equals(SSLConfiguration sSLConfiguration) {
        if (sSLConfiguration == null) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = false;
        if (this.keyStoreConfig != null) {
            bl = this.keyStoreConfig.equals(sSLConfiguration.keyStoreConfig);
        } else {
            boolean bl3 = bl = this.keyStoreConfig == sSLConfiguration.keyStoreConfig;
        }
        bl2 = this.trustStoreConfig != null ? this.trustStoreConfig.equals(sSLConfiguration.trustStoreConfig) : this.trustStoreConfig == sSLConfiguration.trustStoreConfig;
        return bl && bl2;
    }

    @PluginFactory
    public static SSLConfiguration createSSLConfiguration(@PluginElement(value="keyStore") KeyStoreConfiguration keyStoreConfiguration, @PluginElement(value="trustStore") TrustStoreConfiguration trustStoreConfiguration) {
        return new SSLConfiguration(keyStoreConfiguration, trustStoreConfiguration);
    }
}

