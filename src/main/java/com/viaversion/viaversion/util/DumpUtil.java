package com.viaversion.viaversion.util;

import com.google.common.io.CharStreams;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.ViaPlatform;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.dump.DumpTemplate;
import com.viaversion.viaversion.dump.VersionInfo;
import com.viaversion.viaversion.libs.gson.GsonBuilder;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DumpUtil {
   public static CompletableFuture<String> postDump(@Nullable UUID var0) {
      ProtocolVersion var1 = Via.getAPI().getServerVersion().lowestSupportedProtocolVersion();
      ViaPlatform var2 = Via.getPlatform();
      VersionInfo var3 = new VersionInfo(
         System.getProperty("java.version"),
         System.getProperty("os.name"),
         var1.getVersion(),
         var1.getName(),
         Via.getManager()
            .getProtocolManager()
            .getSupportedVersions()
            .stream()
            .map(ProtocolVersion::toString)
            .collect(Collectors.toCollection(LinkedHashSet::new)),
         var2.getPlatformName(),
         var2.getPlatformVersion(),
         var2.getPluginVersion(),
         com.viaversion.viaversion.util.VersionInfo.getImplementationVersion(),
         Via.getManager().getSubPlatforms()
      );
      Map var4 = ((Config)Via.getConfig()).getValues();
      DumpTemplate var5 = new DumpTemplate(var3, var4, var2.getDump(), Via.getManager().getInjector().getDump(), getPlayerSample(var0));
      CompletableFuture var6 = new CompletableFuture();
      var2.runAsync(() -> {
         HttpURLConnection var4x;
         try {
            var4x = (HttpURLConnection)new URL("https://dump.viaversion.com/documents").openConnection();
         } catch (IOException var11) {
            var2.getLogger().log(Level.SEVERE, "Error when opening connection to ViaVersion dump service", (Throwable)var11);
            var6.completeExceptionally(new DumpUtil.DumpException(DumpUtil.DumpErrorType.CONNECTION, var11));
            return;
         }

         try {
            var4x.setRequestProperty("Content-Type", "application/json");
            var4x.addRequestProperty("User-Agent", "ViaVersion-" + var2.getPlatformName() + "/" + var3.pluginVersion());
            var4x.setRequestMethod("POST");
            var4x.setDoOutput(true);

            try (OutputStream var5x = var4x.getOutputStream()) {
               var5x.write(new GsonBuilder().setPrettyPrinting().create().toJson(var5).getBytes(StandardCharsets.UTF_8));
            }

            if (var4x.getResponseCode() == 429) {
               var6.completeExceptionally(new DumpUtil.DumpException(DumpUtil.DumpErrorType.RATE_LIMITED));
               return;
            }

            String var15;
            try (InputStream var6x = var4x.getInputStream()) {
               var15 = CharStreams.toString(new InputStreamReader(var6x));
            }

            JsonObject var16 = (JsonObject)GsonUtil.getGson().fromJson(var15, JsonObject.class);
            if (!var16.has("key")) {
               throw new InvalidObjectException("Key is not given in Hastebin output");
            }

            var6.complete(urlForId(var16.get("key").getAsString()));
         } catch (Exception var14) {
            var2.getLogger().log(Level.SEVERE, "Error when posting ViaVersion dump", (Throwable)var14);
            var6.completeExceptionally(new DumpUtil.DumpException(DumpUtil.DumpErrorType.POST, var14));
            printFailureInfo(var4x);
         }
      });
      return var6;
   }

   private static void printFailureInfo(HttpURLConnection var0) {
      try {
         if (var0.getResponseCode() < 200 || var0.getResponseCode() > 400) {
            try (InputStream var1 = var0.getErrorStream()) {
               String var2 = CharStreams.toString(new InputStreamReader(var1));
               Via.getPlatform().getLogger().log(Level.SEVERE, "Page returned: " + var2);
            }
         }
      } catch (IOException var6) {
         Via.getPlatform().getLogger().log(Level.SEVERE, "Failed to capture further info", (Throwable)var6);
      }
   }

   public static String urlForId(String var0) {
      return String.format("https://dump.viaversion.com/%s", var0);
   }

   private static JsonObject getPlayerSample(@Nullable UUID var0) {
      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      var1.add("versions", var2);
      TreeMap var3 = new TreeMap(ProtocolVersion::compareTo);

      for (UserConnection var5 : Via.getManager().getConnectionManager().getConnections()) {
         ProtocolVersion var6 = var5.getProtocolInfo().protocolVersion();
         var3.compute(var6, (var0x, var1x) -> var1x != null ? var1x + 1 : 1);
      }

      for (Entry var13 : var3.entrySet()) {
         var2.addProperty(((ProtocolVersion)var13.getKey()).getName(), (Number)var13.getValue());
      }

      HashSet var12 = new HashSet();
      if (var0 != null) {
         UserConnection var14 = Via.getAPI().getConnection(var0);
         if (var14 != null && var14.getChannel() != null) {
            var12.add(var14.getChannel().pipeline().names());
         }
      }

      for (UserConnection var17 : Via.getManager().getConnectionManager().getConnections()) {
         if (var17.getChannel() != null) {
            List var7 = var17.getChannel().pipeline().names();
            if (var12.add(var7) && var12.size() == 3) {
               break;
            }
         }
      }

      int var16 = 0;

      for (List var19 : var12) {
         JsonArray var8 = new JsonArray(var19.size());

         for (String var10 : var19) {
            var8.add(var10);
         }

         var1.add("pipeline-" + var16++, var8);
      }

      return var1;
   }

   public static enum DumpErrorType {
      CONNECTION("Failed to dump, please check the console for more information"),
      RATE_LIMITED("Please wait before creating another dump"),
      POST("Failed to dump, please check the console for more information");

      private final String message;

      private DumpErrorType(String var3) {
         this.message = var3;
      }

      public String message() {
         return this.message;
      }
   }

   public static final class DumpException extends RuntimeException {
      private final DumpUtil.DumpErrorType errorType;

      private DumpException(DumpUtil.DumpErrorType var1, Throwable var2) {
         super(var1.message(), var2);
         this.errorType = var1;
      }

      private DumpException(DumpUtil.DumpErrorType var1) {
         super(var1.message());
         this.errorType = var1;
      }

      public DumpUtil.DumpErrorType errorType() {
         return this.errorType;
      }
   }
}
