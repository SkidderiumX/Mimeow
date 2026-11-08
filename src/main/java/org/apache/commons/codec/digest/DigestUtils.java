/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.digest;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils {
    private static final int STREAM_BUFFER_LENGTH = 1024;

    private static byte[] digest(MessageDigest messageDigest, InputStream inputStream2) throws IOException {
        return DigestUtils.updateDigest(messageDigest, inputStream2).digest();
    }

    public static MessageDigest getDigest(String string) {
        try {
            return MessageDigest.getInstance(string);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new IllegalArgumentException(noSuchAlgorithmException);
        }
    }

    public static MessageDigest getMd2Digest() {
        return DigestUtils.getDigest("MD2");
    }

    public static MessageDigest getMd5Digest() {
        return DigestUtils.getDigest("MD5");
    }

    public static MessageDigest getSha1Digest() {
        return DigestUtils.getDigest("SHA-1");
    }

    public static MessageDigest getSha256Digest() {
        return DigestUtils.getDigest("SHA-256");
    }

    public static MessageDigest getSha384Digest() {
        return DigestUtils.getDigest("SHA-384");
    }

    public static MessageDigest getSha512Digest() {
        return DigestUtils.getDigest("SHA-512");
    }

    @Deprecated
    public static MessageDigest getShaDigest() {
        return DigestUtils.getSha1Digest();
    }

    public static byte[] md2(byte[] byArray) {
        return DigestUtils.getMd2Digest().digest(byArray);
    }

    public static byte[] md2(InputStream inputStream2) throws IOException {
        return DigestUtils.digest(DigestUtils.getMd2Digest(), inputStream2);
    }

    public static byte[] md2(String string) {
        return DigestUtils.md2(StringUtils.getBytesUtf8(string));
    }

    public static String md2Hex(byte[] byArray) {
        return Hex.encodeHexString(DigestUtils.md2(byArray));
    }

    public static String md2Hex(InputStream inputStream2) throws IOException {
        return Hex.encodeHexString(DigestUtils.md2(inputStream2));
    }

    public static String md2Hex(String string) {
        return Hex.encodeHexString(DigestUtils.md2(string));
    }

    public static byte[] md5(byte[] byArray) {
        return DigestUtils.getMd5Digest().digest(byArray);
    }

    public static byte[] md5(InputStream inputStream2) throws IOException {
        return DigestUtils.digest(DigestUtils.getMd5Digest(), inputStream2);
    }

    public static byte[] md5(String string) {
        return DigestUtils.md5(StringUtils.getBytesUtf8(string));
    }

    public static String md5Hex(byte[] byArray) {
        return Hex.encodeHexString(DigestUtils.md5(byArray));
    }

    public static String md5Hex(InputStream inputStream2) throws IOException {
        return Hex.encodeHexString(DigestUtils.md5(inputStream2));
    }

    public static String md5Hex(String string) {
        return Hex.encodeHexString(DigestUtils.md5(string));
    }

    @Deprecated
    public static byte[] sha(byte[] byArray) {
        return DigestUtils.sha1(byArray);
    }

    @Deprecated
    public static byte[] sha(InputStream inputStream2) throws IOException {
        return DigestUtils.sha1(inputStream2);
    }

    @Deprecated
    public static byte[] sha(String string) {
        return DigestUtils.sha1(string);
    }

    public static byte[] sha1(byte[] byArray) {
        return DigestUtils.getSha1Digest().digest(byArray);
    }

    public static byte[] sha1(InputStream inputStream2) throws IOException {
        return DigestUtils.digest(DigestUtils.getSha1Digest(), inputStream2);
    }

    public static byte[] sha1(String string) {
        return DigestUtils.sha1(StringUtils.getBytesUtf8(string));
    }

    public static String sha1Hex(byte[] byArray) {
        return Hex.encodeHexString(DigestUtils.sha1(byArray));
    }

    public static String sha1Hex(InputStream inputStream2) throws IOException {
        return Hex.encodeHexString(DigestUtils.sha1(inputStream2));
    }

    public static String sha1Hex(String string) {
        return Hex.encodeHexString(DigestUtils.sha1(string));
    }

    public static byte[] sha256(byte[] byArray) {
        return DigestUtils.getSha256Digest().digest(byArray);
    }

    public static byte[] sha256(InputStream inputStream2) throws IOException {
        return DigestUtils.digest(DigestUtils.getSha256Digest(), inputStream2);
    }

    public static byte[] sha256(String string) {
        return DigestUtils.sha256(StringUtils.getBytesUtf8(string));
    }

    public static String sha256Hex(byte[] byArray) {
        return Hex.encodeHexString(DigestUtils.sha256(byArray));
    }

    public static String sha256Hex(InputStream inputStream2) throws IOException {
        return Hex.encodeHexString(DigestUtils.sha256(inputStream2));
    }

    public static String sha256Hex(String string) {
        return Hex.encodeHexString(DigestUtils.sha256(string));
    }

    public static byte[] sha384(byte[] byArray) {
        return DigestUtils.getSha384Digest().digest(byArray);
    }

    public static byte[] sha384(InputStream inputStream2) throws IOException {
        return DigestUtils.digest(DigestUtils.getSha384Digest(), inputStream2);
    }

    public static byte[] sha384(String string) {
        return DigestUtils.sha384(StringUtils.getBytesUtf8(string));
    }

    public static String sha384Hex(byte[] byArray) {
        return Hex.encodeHexString(DigestUtils.sha384(byArray));
    }

    public static String sha384Hex(InputStream inputStream2) throws IOException {
        return Hex.encodeHexString(DigestUtils.sha384(inputStream2));
    }

    public static String sha384Hex(String string) {
        return Hex.encodeHexString(DigestUtils.sha384(string));
    }

    public static byte[] sha512(byte[] byArray) {
        return DigestUtils.getSha512Digest().digest(byArray);
    }

    public static byte[] sha512(InputStream inputStream2) throws IOException {
        return DigestUtils.digest(DigestUtils.getSha512Digest(), inputStream2);
    }

    public static byte[] sha512(String string) {
        return DigestUtils.sha512(StringUtils.getBytesUtf8(string));
    }

    public static String sha512Hex(byte[] byArray) {
        return Hex.encodeHexString(DigestUtils.sha512(byArray));
    }

    public static String sha512Hex(InputStream inputStream2) throws IOException {
        return Hex.encodeHexString(DigestUtils.sha512(inputStream2));
    }

    public static String sha512Hex(String string) {
        return Hex.encodeHexString(DigestUtils.sha512(string));
    }

    @Deprecated
    public static String shaHex(byte[] byArray) {
        return DigestUtils.sha1Hex(byArray);
    }

    @Deprecated
    public static String shaHex(InputStream inputStream2) throws IOException {
        return DigestUtils.sha1Hex(inputStream2);
    }

    @Deprecated
    public static String shaHex(String string) {
        return DigestUtils.sha1Hex(string);
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, byte[] byArray) {
        messageDigest.update(byArray);
        return messageDigest;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, InputStream inputStream2) throws IOException {
        byte[] byArray = new byte[1024];
        int n = inputStream2.read(byArray, 0, 1024);
        while (n > -1) {
            messageDigest.update(byArray, 0, n);
            n = inputStream2.read(byArray, 0, 1024);
        }
        return messageDigest;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, String string) {
        messageDigest.update(StringUtils.getBytesUtf8(string));
        return messageDigest;
    }
}

