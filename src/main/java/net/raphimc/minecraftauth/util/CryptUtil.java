/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class CryptUtil {
    public static final KeyFactory RSA_KEYFACTORY;
    public static final KeyFactory EC_KEYFACTORY;

    public static ECPublicKey ecPublicKeyFromBase64(String string) {
        return CryptUtil.ecPublicKeyFromBytes(Base64.getDecoder().decode(string));
    }

    public static ECPrivateKey ecPrivateKeyFromBase64(String string) {
        return CryptUtil.ecPrivateKeyFromBytes(Base64.getDecoder().decode(string));
    }

    public static ECPublicKey ecPublicKeyFromBytes(byte[] byArray) {
        try {
            return (ECPublicKey)EC_KEYFACTORY.generatePublic(new X509EncodedKeySpec(byArray));
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new RuntimeException("Failed to decode public key", invalidKeySpecException);
        }
    }

    public static ECPrivateKey ecPrivateKeyFromBytes(byte[] byArray) {
        try {
            return (ECPrivateKey)EC_KEYFACTORY.generatePrivate(new PKCS8EncodedKeySpec(byArray));
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new RuntimeException("Failed to decode private key", invalidKeySpecException);
        }
    }

    public static RSAPublicKey rsaPublicKeyFromBase64(String string) {
        return CryptUtil.rsaPublicKeyFromBytes(Base64.getDecoder().decode(string));
    }

    public static RSAPrivateKey rsaPrivateKeyFromBase64(String string) {
        return CryptUtil.rsaPrivateKeyFromBytes(Base64.getDecoder().decode(string));
    }

    public static RSAPublicKey rsaPublicKeyFromBytes(byte[] byArray) {
        try {
            return (RSAPublicKey)RSA_KEYFACTORY.generatePublic(new X509EncodedKeySpec(byArray));
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new RuntimeException("Failed to decode public key", invalidKeySpecException);
        }
    }

    public static RSAPrivateKey rsaPrivateKeyFromBytes(byte[] byArray) {
        try {
            return (RSAPrivateKey)RSA_KEYFACTORY.generatePrivate(new PKCS8EncodedKeySpec(byArray));
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new RuntimeException("Failed to decode private key", invalidKeySpecException);
        }
    }

    public static KeyPair generateEcdsa256KeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
            return keyPairGenerator.generateKeyPair();
        }
        catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException generalSecurityException) {
            throw new RuntimeException("Failed to generate key pair", generalSecurityException);
        }
    }

    public static KeyPair generateEcdsa384KeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(new ECGenParameterSpec("secp384r1"));
            return keyPairGenerator.generateKeyPair();
        }
        catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException generalSecurityException) {
            throw new RuntimeException("Failed to generate key pair", generalSecurityException);
        }
    }

    public static byte[] signSha256InP1363Format(ECPrivateKey eCPrivateKey, byte[] byArray) throws SignatureException, InvalidKeyException, NoSuchAlgorithmException {
        try {
            Signature signature = Signature.getInstance("SHA256withECDSAinP1363Format");
            signature.initSign(eCPrivateKey);
            signature.update(byArray);
            return signature.sign();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(eCPrivateKey);
            signature.update(byArray);
            byte[] byArray2 = signature.sign();
            if (byArray2[0] != 48) {
                throw new IllegalArgumentException("Not a valid DER sequence");
            }
            int n = 2;
            if (byArray2[n] != 2) {
                throw new IllegalArgumentException("Expected integer for r");
            }
            byte by = byArray2[n + 1];
            byte[] byArray3 = Arrays.copyOfRange(byArray2, n + 2, n + 2 + by);
            if (byArray2[n += 2 + by] != 2) {
                throw new IllegalArgumentException("Expected integer for s");
            }
            byte by2 = byArray2[n + 1];
            byte[] byArray4 = Arrays.copyOfRange(byArray2, n + 2, n + 2 + by2);
            int n2 = eCPrivateKey.getParams().getOrder().bitLength() / 8;
            byte[] byArray5 = new byte[n2 * 2];
            System.arraycopy(CryptUtil.toFixedLengthP1363(byArray3, n2), 0, byArray5, 0, n2);
            System.arraycopy(CryptUtil.toFixedLengthP1363(byArray4, n2), 0, byArray5, n2, n2);
            return byArray5;
        }
    }

    private static byte[] toFixedLengthP1363(byte[] byArray, int n) {
        if (byArray.length == n) {
            return byArray;
        }
        if (byArray.length == n + 1 && byArray[0] == 0) {
            return Arrays.copyOfRange(byArray, 1, byArray.length);
        }
        if (byArray.length < n) {
            byte[] byArray2 = new byte[n];
            System.arraycopy(byArray, 0, byArray2, n - byArray.length, byArray.length);
            return byArray2;
        }
        throw new IllegalArgumentException("Invalid length for ECDSA integer");
    }

    static {
        try {
            RSA_KEYFACTORY = KeyFactory.getInstance("RSA");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("Failed to create RSA KeyFactory", noSuchAlgorithmException);
        }
        try {
            EC_KEYFACTORY = KeyFactory.getInstance("EC");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("Failed to create EllipticCurve KeyFactory", noSuchAlgorithmException);
        }
    }
}

