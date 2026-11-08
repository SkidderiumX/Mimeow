/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import x.oc25e9d31d7d;
import x.oc32b50dcd85;
import x.ocd1cb14b5c3;

public class oc03814b0e1a
implements oc25e9d31d7d {
    private final Minecraft \u012f;
    private final boolean \u03a1;
    private final boolean \u020e;
    private final IResourceManager \u0260;
    private final BufferedImage \u01aa;
    private final byte[] \u00fc = new byte[0x711314B8 ^ 0x711214B8];
    private final Map<Integer, BufferedImage> G = new HashMap<Integer, BufferedImage>();
    private final Map<Integer, List<ocd1cb14b5c3>> \u0180 = new HashMap<Integer, List<ocd1cb14b5c3>>();
    private final oc32b50dcd85 \u038a = new oc32b50dcd85(() -> {
        throw new IllegalStateException("Game glyph scratch budget exceeded");
    });

    public oc03814b0e1a(Minecraft minecraft) throws IOException {
        this(minecraft, false);
    }

    public oc03814b0e1a(Minecraft minecraft, boolean bl) throws IOException {
        this.\u012f = minecraft;
        this.\u03a1 = bl;
        this.\u020e = minecraft.fontRendererObj.getUnicodeFlag();
        this.\u0260 = minecraft.getResourceManager();
        this.\u01aa = this.\u0495("textures/font/ascii.png");
        try (InputStream inputStream2 = this.\u0260.getResource(new ResourceLocation("font/glyph_sizes.bin")).getInputStream();){
            int n;
            for (int i = 0; i < this.\u00fc.length; i += n) {
                n = inputStream2.read(this.\u00fc, i, this.\u00fc.length - i);
                if (n >= 0) continue;
                throw new IOException("Incomplete game glyph-size resource");
            }
        }
    }

    private BufferedImage \u0495(String string) throws IOException {
        BufferedImage bufferedImage;
        try (InputStream inputStream2 = this.\u0260.getResource(new ResourceLocation(string)).getInputStream();){
            BufferedImage bufferedImage2 = ImageIO.read(inputStream2);
            if (bufferedImage2 == null) {
                throw new IOException("Unreadable game font bitmap " + string);
            }
            bufferedImage = bufferedImage2;
        }
        return bufferedImage;
    }

    @Override
    public int z$2droptwdkxnj3() {
        return 0x626BC92A ^ 0x626BC938;
    }

    boolean \u01c7() {
        return this.\u020e == this.\u012f.fontRendererObj.getUnicodeFlag();
    }

    @Override
    public int z$9uuod3iw435o(int n) {
        return n >= 0 && n <= (0x7F91960B ^ 0x7F9169F4) ? n : 0;
    }

    @Override
    public int z$2pfocnh38gpk7(int n) {
        return (Math.max(0, this.\u012f.fontRendererObj.getCharWidth((char)n)) + (this.\u03a1 && n != (0x102D1255 ^ 0x102D12F2) ? 1 : 0)) * (0x102D12F0 ^ 0x102D12F2);
    }

    @Override
    public int z$hqqzkx9lgbnj(int n, int n2) {
        return 0;
    }

    @Override
    public oc32b50dcd85 z$c0rlehjoef0y() {
        return this.\u038a;
    }

    @Override
    public int[] z$3lnt5igups949(int n) {
        List<ocd1cb14b5c3> list = this.z$3k6ox4binq6s8(n);
        if (list.isEmpty()) {
            return null;
        }
        int n2 = 0x16FEFEA ^ 0x7E901015;
        int n3 = 0x16FEFEA ^ 0x7E901015;
        int n4 = 0xFE901015 ^ 0x7E901015;
        int n5 = 0xFE901015 ^ 0x7E901015;
        for (ocd1cb14b5c3 ocd1cb14b5c32 : list) {
            n2 = Math.min(n2, ocd1cb14b5c32.\u04c1);
            n3 = Math.min(n3, ocd1cb14b5c32.\u0122);
            n4 = Math.max(n4, ocd1cb14b5c32.\u04c1);
            n5 = Math.max(n5, ocd1cb14b5c32.\u0122);
        }
        int[] nArray = new int[0x7E901011 ^ 0x7E901015];
        nArray[0] = n2;
        nArray[1] = n3;
        nArray[0x7E901017 ^ 0x7E901015] = n4;
        nArray[0x7E901016 ^ 0x7E901015] = n5;
        return nArray;
    }

    @Override
    public List<ocd1cb14b5c3> z$3k6ox4binq6s8(int n) {
        List<ocd1cb14b5c3> list = this.\u0180.get(n);
        if (list != null) {
            return list;
        }
        ArrayList<ocd1cb14b5c3> arrayList = new ArrayList<ocd1cb14b5c3>();
        if (n != (0x54EB3074 ^ 0x54EB3054) && n != (0x54EB30F3 ^ 0x54EB3054)) {
            int n2;
            BufferedImage bufferedImage;
            boolean bl = n >= (0x54EB3075 ^ 0x54EB3054) && n <= (0x54EB302A ^ 0x54EB3054) && !this.\u020e;
            try {
                if (bl) {
                    bufferedImage = this.\u01aa;
                } else {
                    n2 = n >>> (0x54EB305C ^ 0x54EB3054);
                    bufferedImage = this.G.get(n2);
                    if (bufferedImage == null && this.\u00fc[n] != 0) {
                        bufferedImage = this.\u0495(String.format(Locale.ROOT, "textures/font/unicode_page_%02x.png", n2));
                        this.G.put(n2, bufferedImage);
                    }
                    if (bufferedImage == null) {
                        this.\u0180.put(n, arrayList);
                        return arrayList;
                    }
                }
            }
            catch (IOException iOException) {
                throw new IllegalStateException("Game font resource failed", iOException);
            }
            n2 = n & (0x54EB30AB ^ 0x54EB3054);
            int n3 = bufferedImage.getWidth() / (0x54EB3044 ^ 0x54EB3054);
            int n4 = bufferedImage.getHeight() / (0x54EB3044 ^ 0x54EB3054);
            int n5 = (n2 & (0x54EB305B ^ 0x54EB3054)) * n3;
            int n6 = (n2 >>> (0x54EB3050 ^ 0x54EB3054)) * n4;
            int n7 = bl ? 0 : (this.\u00fc[n] & (0x54EB30AB ^ 0x54EB3054)) >>> (0x54EB3050 ^ 0x54EB3054);
            int n8 = bl ? 0x54EB3056 ^ 0x54EB3054 : 1;
            int n9 = bl ? n3 : Math.min(n3, (this.\u00fc[n] & (0x54EB305B ^ 0x54EB3054)) + 1);
            for (int i = 0; i < n4; ++i) {
                for (int j = n7; j < n9; ++j) {
                    if (bufferedImage.getRGB(n5 + j, n6 + i) >>> (0x54EB304C ^ 0x54EB3054) == 0) continue;
                    int n10 = (j - n7) * n8;
                    int n11 = n10 + n8 + (this.\u03a1 ? 0x54EB3056 ^ 0x54EB3054 : 0);
                    int n12 = (0x54EB3044 ^ 0x54EB3054) - i * n8;
                    int n13 = n12 - n8;
                    arrayList.add(new ocd1cb14b5c3(1, n10, n13, 0, 0, 0, 0));
                    arrayList.add(new ocd1cb14b5c3(0x54EB3056 ^ 0x54EB3054, n11, n13, 0, 0, 0, 0));
                    arrayList.add(new ocd1cb14b5c3(0x54EB3056 ^ 0x54EB3054, n11, n12, 0, 0, 0, 0));
                    arrayList.add(new ocd1cb14b5c3(0x54EB3056 ^ 0x54EB3054, n10, n12, 0, 0, 0, 0));
                    arrayList.add(new ocd1cb14b5c3(0x54EB3056 ^ 0x54EB3054, n10, n13, 0, 0, 0, 0));
                }
            }
            this.\u0180.put(n, arrayList);
            return arrayList;
        }
        this.\u0180.put(n, arrayList);
        return arrayList;
    }
}

