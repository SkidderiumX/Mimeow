/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.request;

import com.google.gson.JsonObject;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.util.CryptUtil;
import net.raphimc.minecraftauth.util.TimeUtil;

public abstract class SignedXblPostRequest
extends PostRequest {
    public SignedXblPostRequest(String string) throws MalformedURLException {
        super(string);
    }

    public SignedXblPostRequest(URL uRL) {
        super(uRL);
    }

    protected void appendSignatureHeader(ECPrivateKey eCPrivateKey) {
        long l = (Instant.now().plus(TimeUtil.getClientTimeOffset()).getEpochSecond() + 11644473600L) * 10000000L;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HttpContent httpContent;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeLong(l);
            dataOutputStream.writeByte(0);
            dataOutputStream.write(this.getMethod().getBytes(StandardCharsets.UTF_8));
            dataOutputStream.writeByte(0);
            dataOutputStream.write((this.getURL().getPath() + (this.getURL().getQuery() != null ? this.getURL().getQuery() : "")).getBytes(StandardCharsets.UTF_8));
            dataOutputStream.writeByte(0);
            Optional<String> optional = this.getFirstHeader("Authorization");
            if (optional.isPresent()) {
                dataOutputStream.write(optional.get().getBytes(StandardCharsets.UTF_8));
            }
            dataOutputStream.writeByte(0);
            if (this instanceof HttpContentRequest && (httpContent = this.getContent()) != null) {
                dataOutputStream.write(httpContent.getAsBytes());
            }
            dataOutputStream.writeByte(0);
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeLong(l);
            dataOutputStream.write(CryptUtil.signSha256InP1363Format(eCPrivateKey, byteArrayOutputStream2.toByteArray()));
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to sign request", throwable);
        }
        this.appendHeader("Signature", Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()));
    }

    protected JsonObject getProofKey(ECPublicKey eCPublicKey) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "EC");
        jsonObject.addProperty("alg", "ES256");
        jsonObject.addProperty("crv", "P-256");
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty("x", this.encodeEcCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()));
        jsonObject.addProperty("y", this.encodeEcCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()));
        return jsonObject;
    }

    private String encodeEcCoordinate(int n, BigInteger bigInteger) {
        int n2;
        byte[] byArray = this.bigIntegerToByteArray(bigInteger);
        if (byArray.length >= (n2 = (n + 7) / 8)) {
            return Base64.getUrlEncoder().withoutPadding().encodeToString(byArray);
        }
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 0, byArray2, n2 - byArray.length, byArray.length);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(byArray2);
    }

    private byte[] bigIntegerToByteArray(BigInteger bigInteger) {
        int n = bigInteger.bitLength();
        n = n + 7 >> 3 << 3;
        byte[] byArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && bigInteger.bitLength() / 8 + 1 == n / 8) {
            return byArray;
        }
        int n2 = 0;
        int n3 = byArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            n2 = 1;
            --n3;
        }
        int n4 = n / 8 - n3;
        byte[] byArray2 = new byte[n / 8];
        System.arraycopy(byArray, n2, byArray2, n4, n3);
        return byArray2;
    }
}

