package keystrokesmod.utility;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

public class NetworkUtils {
   public static final String CHROME_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
   private static final Pattern OGP_IMAGE_REGEX = Pattern.compile("<meta property=\"(?:og:image|twitter:image)\" content=\"(?<url>.+?)\"[^>]*?>");
   private static final Pattern IMG_TAG_REGEX = Pattern.compile("<img[^>]*?src=\"(?<url>.+?)\"[^>]*?>");

   public static String getTextFromURL(String var0, boolean var1, boolean var2) {
      String var3 = "";
      HttpURLConnection var4 = null;

      try {
         URL var5 = new URL(var0);
         var4 = (HttpURLConnection)var5.openConnection();
         var4.setRequestProperty(
            "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
         );
         var3 = getTextFromConnection(var4, var1);
      } catch (IOException var9) {
      } finally {
         if (var4 != null) {
            var4.disconnect();
         }
      }

      return var3;
   }

   public static String getTextFromConnection(HttpURLConnection var0, boolean var1) {
      if (var0 != null) {
         try {
            BufferedReader var2 = new BufferedReader(new InputStreamReader(var0.getInputStream()));
            StringBuilder var3 = new StringBuilder();

            String var4;
            while ((var4 = var2.readLine()) != null) {
               var3.append(var4);
               if (var1) {
                  var3.append("\n");
               }
            }

            return var3.toString();
         } catch (Exception var5) {
         }
      }

      return "";
   }

   public static BufferedImage getImageFromURL(String var0) {
      try {
         URL var1 = new URL(var0);

         while (true) {
            HttpURLConnection var2 = (HttpURLConnection)var1.openConnection();
            var2.setRequestMethod("GET");
            var2.setUseCaches(true);
            var2.setInstanceFollowRedirects(true);
            var2.setRequestProperty(
               "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            );
            var2.setRequestProperty("Accept", "text/html, image/*");
            if (var1.getHost() != null && var1.getHost().contains("imgur")) {
               var2.setRequestProperty("Referer", "https://imgur.com/");
            }

            int var3 = var2.getResponseCode();
            if (var3 >= (-1768068348 ^ -1768068568) && var3 < (-1768068168 ^ -1768068568)) {
               String var15 = var2.getHeaderField("Location");
               if (var15 == null || var15.isEmpty()) {
                  return null;
               }

               var1 = new URL(var1, var15);
               var2.disconnect();
            } else {
               String var4 = var2.getContentType();
               if (var4 != null && var4.startsWith("image")) {
                  BufferedImage var18;
                  try (InputStream var16 = var2.getInputStream()) {
                     BufferedImage var17 = ImageIO.read(var16);
                     var2.disconnect();
                     var18 = var17;
                  }

                  return var18;
               }

               Object var9;
               try (InputStream var5 = var2.getInputStream()) {
                  String var6 = new String(var5.readAllBytes(), StandardCharsets.UTF_8);
                  String var7 = "";
                  Matcher var8 = OGP_IMAGE_REGEX.matcher(var6);
                  if (var8.find()) {
                     var7 = var8.group("url");
                  } else {
                     var8 = IMG_TAG_REGEX.matcher(var6);
                     if (var8.find()) {
                        var7 = var8.group("url");
                     }
                  }

                  if (!var7.isEmpty()) {
                     var1 = new URL(var1, var7);
                     var2.disconnect();
                     continue;
                  }

                  var9 = null;
               }

               return (BufferedImage)var9;
            }
         }
      } catch (Exception var14) {
         return null;
      }
   }
}
