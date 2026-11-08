/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import x.oc380d0f830c;
import x.oc51f4f13c5a;
import x.oc5a0c1fbe1c;
import x.oc6bed6d7740;
import x.ocbb1bc27172;
import x.oce7be97fef5;

public class ocdaef1a63d8 {
    public static final String \u02a6 = oc380d0f830c.\u04c9("api/spotify/callback");
    private final String \u01dc;
    private final oce7be97fef5 \u047b;
    private final SecureRandom \u0507 = new SecureRandom();
    private String \u0109 = "";
    public static int \u00d1;

    public ocdaef1a63d8(String string, oce7be97fef5 oce7be97fef52) {
        this.\u01dc = string;
        this.\u047b = oce7be97fef52;
    }

    public String \u0215(String string) throws Exception {
        byte[] byArray = new byte[0x1FE22819 ^ 0x1FE22859];
        this.\u0507.nextBytes(byArray);
        this.\u0109 = Base64.getUrlEncoder().withoutPadding().encodeToString(byArray);
        String string2 = ocdaef1a63d8.\u0579(this.\u0109);
        String string3 = ocdaef1a63d8.\u0476(string2);
        String string4 = ocdaef1a63d8.\u0476(string);
        String string5 = ocdaef1a63d8.\u0476("user-read-currently-playing user-read-playback-state user-modify-playback-state");
        String string6 = ocdaef1a63d8.\u0476(\u02a6);
        String string7 = ocdaef1a63d8.\u0476(this.\u01dc);
        return "https://accounts.spotify.com/authorize?client_id=" + string7 + "&response_type=code&redirect_uri=" + string6 + "&scope=" + string5 + "&state=" + string4 + "&code_challenge_method=S256&code_challenge=" + string3;
    }

    public oc5a0c1fbe1c \u048d(String string) throws IOException {
        String string2 = ocdaef1a63d8.\u0476(this.\u0109);
        String string3 = ocdaef1a63d8.\u0476(\u02a6);
        String string4 = ocdaef1a63d8.\u0476(string);
        String string5 = ocdaef1a63d8.\u0476(this.\u01dc);
        return this.\u0204("grant_type=authorization_code&client_id=" + string5 + "&code=" + string4 + "&redirect_uri=" + string3 + "&code_verifier=" + string2, "");
    }

    public oc5a0c1fbe1c \u02a7(String string) throws IOException {
        return this.\u0204("grant_type=refresh_token&client_id=" + ocdaef1a63d8.\u0476(this.\u01dc) + "&refresh_token=" + ocdaef1a63d8.\u0476(string), string);
    }

    private oc5a0c1fbe1c \u0204(String string, String string2) throws IOException {
        long l;
        String string3;
        String string4;
        block13: {
            block12: {
                JsonElement jsonElement;
                block11: {
                    boolean bl;
                    JsonObject jsonObject;
                    block9: {
                        int n;
                        block10: {
                            oc51f4f13c5a oc51f4f13c5a2 = this.\u047b.z$1ahjbl7dqoxur(oc6bed6d7740.\u0289("POST", "https://accounts.spotify.com/api/token").\u01ce("Content-Type", "application/x-www-form-urlencoded").\u024f(string).\u0290());
                            n = ocbb1bc27172.\u050d;
                            if (oc51f4f13c5a2.\u0463() != (0xB4703A54 ^ 0xB4703A9C)) {
                                throw new IOException("Spotify token endpoint returned HTTP " + oc51f4f13c5a2.\u0463());
                            }
                            jsonObject = new JsonParser().parse(oc51f4f13c5a2.\u02a4()).getAsJsonObject();
                            string4 = ocdaef1a63d8.\u037a(jsonObject, "access_token");
                            string3 = ocdaef1a63d8.\u037a(jsonObject, "refresh_token");
                            bl = string3.isEmpty();
                            if (n != 0) break block9;
                            if (!bl) break block10;
                            string3 = string2;
                        }
                        jsonElement = jsonObject;
                        if (n != 0) break block11;
                        bl = ((JsonObject)jsonElement).has("expires_in");
                    }
                    if (!bl) break block12;
                    jsonElement = jsonObject.get("expires_in");
                }
                l = jsonElement.getAsLong();
                break block13;
            }
            l = 0x6A2575BAFC8DC0CAL ^ 0x6A2575BAFC8DCEDAL;
        }
        long l2 = l;
        return new oc5a0c1fbe1c(string4, string3, System.currentTimeMillis() + Math.max(0x6A2575BAFC8DCEE6L ^ 0x6A2575BAFC8DCEDAL, l2) * (0x6A2575BAFC8DCD32L ^ 0x6A2575BAFC8DCEDAL));
    }

    public static String \u0579(String string) throws Exception {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(MessageDigest.getInstance("SHA-256").digest(string.getBytes(StandardCharsets.US_ASCII)));
    }

    private static String \u0476(String string) throws IOException {
        String string2;
        block2: {
            block3: {
                int n = ocbb1bc27172.\u050d;
                string2 = string;
                if (n != 0) break block2;
                if (string2 != null) break block3;
                string2 = "";
                break block2;
            }
            string2 = string;
        }
        return URLEncoder.encode(string2, "UTF-8");
    }

    private static String \u037a(JsonObject jsonObject, String string) {
        String string2;
        block11: {
            block9: {
                JsonElement jsonElement;
                block10: {
                    JsonElement jsonElement2;
                    block8: {
                        int n = ocbb1bc27172.\u050d;
                        jsonElement2 = jsonObject;
                        if (n != 0) break block8;
                        if (!jsonElement2.has(string)) break block9;
                        jsonElement = jsonObject;
                        if (n != 0) break block10;
                        jsonElement2 = ((JsonObject)jsonElement).get(string);
                    }
                    if (jsonElement2.isJsonNull()) break block9;
                    jsonElement = jsonObject.get(string);
                }
                string2 = jsonElement.getAsString();
                break block11;
            }
            string2 = "";
        }
        return string2;
    }
}

