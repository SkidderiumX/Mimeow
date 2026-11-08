/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.security.KeyPair;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.lenni0451.commons.gson.elements.GsonArray;
import net.lenni0451.commons.gson.elements.GsonElement;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.util.CryptUtil;

public class JsonUtil {
    public static JsonArray encodeSet(Set<String> set) {
        JsonArray jsonArray = new JsonArray();
        for (String string : set) {
            jsonArray.add(string);
        }
        return jsonArray;
    }

    public static Set<String> decodeSet(GsonArray gsonArray) {
        HashSet<String> hashSet = new HashSet<String>(gsonArray.size());
        for (GsonElement gsonElement : gsonArray) {
            hashSet.add(gsonElement.asString());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static JsonObject encodeMap(Map<String, String> map) {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jsonObject.addProperty(entry.getKey(), entry.getValue());
        }
        return jsonObject;
    }

    public static Map<String, String> decodeMap(GsonObject gsonObject) {
        HashMap<String, String> hashMap = new HashMap<String, String>(gsonObject.size());
        for (Map.Entry<String, GsonElement> entry : gsonObject.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().asString());
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static JsonObject encodeKeyPair(KeyPair keyPair) {
        if (keyPair.getPublic() == null || keyPair.getPrivate() == null) {
            throw new IllegalArgumentException("KeyPair must contain both public and private key");
        }
        if (!keyPair.getPublic().getAlgorithm().equals(keyPair.getPrivate().getAlgorithm())) {
            throw new IllegalArgumentException("Public and private key must use the same algorithm");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("algorithm", keyPair.getPublic().getAlgorithm());
        jsonObject.addProperty("publicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        jsonObject.addProperty("privateKey", Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
        return jsonObject;
    }

    public static KeyPair decodeKeyPair(GsonObject gsonObject) {
        String string;
        switch (string = gsonObject.reqString("algorithm")) {
            case "RSA": {
                return new KeyPair(CryptUtil.rsaPublicKeyFromBase64(gsonObject.reqString("publicKey")), CryptUtil.rsaPrivateKeyFromBase64(gsonObject.reqString("privateKey")));
            }
            case "EC": {
                return new KeyPair(CryptUtil.ecPublicKeyFromBase64(gsonObject.reqString("publicKey")), CryptUtil.ecPrivateKeyFromBase64(gsonObject.reqString("privateKey")));
            }
        }
        throw new IllegalArgumentException("Unsupported key algorithm: " + string);
    }
}

