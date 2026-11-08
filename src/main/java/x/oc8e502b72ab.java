/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.minecraft.client.Minecraft;
import x.oc59f0ab164a;

public class oc8e502b72ab
implements oc59f0ab164a {
    private static final SecureRandom \u010d = new SecureRandom();
    private final byte[] \u03e9;
    public static boolean \u03ce;

    public oc8e502b72ab() {
        this(true);
    }

    oc8e502b72ab(boolean bl) {
        try {
            this.\u03e9 = bl ? oc8e502b72ab.\u01a4() : oc8e502b72ab.\u03d0();
        }
        catch (Exception exception) {
            throw new IllegalStateException("Could not initialize token protection", exception);
        }
    }

    @Override
    public String z$2d18fe1ddtiun(String string) throws Exception {
        return oc8e502b72ab.\u0554(string, this.\u03e9);
    }

    @Override
    public String z$3gaj86hkfeiuj(String string) throws Exception {
        try {
            return oc8e502b72ab.\u0107(string, this.\u03e9);
        }
        catch (Exception exception) {
            return this.\u01c6(string);
        }
    }

    String \u01c6(String string) throws Exception {
        return oc8e502b72ab.\u0107(string, oc8e502b72ab.\u03d0());
    }

    @Override
    public String z$3f9e4c95piano() {
        return "aes-gcm-random-install-key";
    }

    private static String \u0554(String string, byte[] byArray) throws Exception {
        byte[] byArray2 = new byte[0x3601A9B8 ^ 0x3601A9B4];
        \u010d.nextBytes(byArray2);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(0x3601A934 ^ 0x3601A9B4, byArray2));
        return Base64.getEncoder().encodeToString(byArray2) + "." + Base64.getEncoder().encodeToString(cipher.doFinal(string.getBytes(StandardCharsets.UTF_8)));
    }

    private static String \u0107(String string, byte[] byArray) throws Exception {
        String[] stringArray = null;
        Cipher cipher = null;
        boolean bl = false;
        int n = 0xBBB47C03 ^ 0x8F6D3963;
        while (true) {
            block8: {
                switch (n) {
                    default: {
                        throw null;
                    }
                    case 539941523: {
                        cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        cipher.init(0x8F6D3961 ^ 0x8F6D3963, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(0x8F6D39E3 ^ 0x8F6D3963, Base64.getDecoder().decode(stringArray[0])));
                        return new String(cipher.doFinal(Base64.getDecoder().decode(stringArray[1])), StandardCharsets.UTF_8);
                    }
                    case 1768177742: {
                        throw new IllegalArgumentException("Invalid protected payload");
                    }
                    case 886654304: 
                }
                stringArray = string.split("\\.", 0x8F6D3961 ^ 0x8F6D3963);
                if (bl) continue;
                if (stringArray.length == (0x8F6D3961 ^ 0x8F6D3963)) break block8;
                n = 0xE609792D ^ 0x8F6D3963;
                if (!bl) continue;
            }
            n = 0xAF43E3F0 ^ 0x8F6D3963;
        }
    }

    private static byte[] \u01a4() throws IOException {
        Path path = Minecraft.getMinecraft().mcDataDir.toPath();
        Files.createDirectories(path, new FileAttribute[0]);
        Path path2 = path.resolve(".miau-token-key");
        if (Files.isRegularFile(path2, new LinkOption[0])) {
            byte[] byArray = Files.readAllBytes(path2);
            byte[] byArray2 = Base64.getDecoder().decode(byArray);
            if (byArray2.length == (0xD1613A5B ^ 0xD1613A7B)) {
                return byArray2;
            }
            throw new IOException("Invalid Miau token key");
        }
        byte[] byArray = new byte[0xD1613A5B ^ 0xD1613A7B];
        \u010d.nextBytes(byArray);
        try {
            OpenOption[] openOptionArray = new OpenOption[0xD1613A79 ^ 0xD1613A7B];
            openOptionArray[0] = StandardOpenOption.CREATE_NEW;
            openOptionArray[1] = StandardOpenOption.WRITE;
            Files.write(path2, Base64.getEncoder().encode(byArray), openOptionArray);
        }
        catch (FileAlreadyExistsException fileAlreadyExistsException) {
            byte[] byArray3 = Base64.getDecoder().decode(Files.readAllBytes(path2));
            if (byArray3.length == (0xD1613A5B ^ 0xD1613A7B)) {
                return byArray3;
            }
            throw new IOException("Invalid Miau token key", fileAlreadyExistsException);
        }
        try {
            Files.setPosixFilePermissions(path2, Set.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE));
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            // empty catch block
        }
        return byArray;
    }

    private static byte[] \u03d0() throws Exception {
        String string = System.getProperty("user.name", "") + "|" + System.getProperty("os.name", "") + "|" + System.getenv("COMPUTERNAME");
        return MessageDigest.getInstance("SHA-256").digest(string.getBytes(StandardCharsets.UTF_8));
    }
}

