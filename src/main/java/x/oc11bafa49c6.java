package x;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.net.Proxy;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;

public class oc11bafa49c6 {
   private static final long ʶ = 1800000L;
   private static final long ñ = 300000L;
   private static final int ʳ = 512;
   private static final Map<String, ResourceLocation> Ɨ = new ConcurrentHashMap<>();
   private static final Map<String, UUID> ð = new ConcurrentHashMap<>();
   private static final Map<String, ocbff50020a5> Ǵ = new ConcurrentHashMap<>();
   private static final Set<String> Л = Collections.newSetFromMap(new ConcurrentHashMap<>());
   private static final Set<String> Ҁ = Collections.newSetFromMap(new ConcurrentHashMap<>());
   private static final Map<String, Long> ʓ = new ConcurrentHashMap<>();
   private static final GameProfileRepository ş = new YggdrasilAuthenticationService(Proxy.NO_PROXY, UUID.randomUUID().toString()).createProfileRepository();
   private static final AtomicInteger ğ = new AtomicInteger();
   private static final ExecutorService Խ = Executors.newFixedThreadPool(-1096373527 ^ -1096373525, var0 -> {
      Thread var1 = new Thread(var0, "Roven-SkinLookup-" + ğ.incrementAndGet());
      var1.setDaemon(true);
      return var1;
   });
   public static boolean қ;

   private oc11bafa49c6() {
   }

   public static ResourceLocation Փ(String param0, NetworkPlayerInfo param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: aload 0
      // 004: invokestatic x/oc11bafa49c6.Ԙ (Ljava/lang/String;)Ljava/lang/String;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 3
      // 00a: iload 2
      // 00b: ifne 01e
      // 00e: invokevirtual java/lang/String.isEmpty ()Z
      // 011: ifeq 025
      // 014: goto 018
      // 017: athrow
      // 018: ldc "Steve"
      // 01a: goto 01e
      // 01d: athrow
      // 01e: invokestatic net/minecraft/entity/player/EntityPlayer.getOfflineUUID (Ljava/lang/String;)Ljava/util/UUID;
      // 021: invokestatic net/minecraft/client/resources/DefaultPlayerSkin.getDefaultSkin (Ljava/util/UUID;)Lnet/minecraft/util/ResourceLocation;
      // 024: areturn
      // 025: aload 1
      // 026: iload 2
      // 027: ifne 0c9
      // 02a: ifnull 0c0
      // 02d: goto 031
      // 030: athrow
      // 031: aload 1
      // 032: iload 2
      // 033: ifne 0c9
      // 036: goto 03a
      // 039: athrow
      // 03a: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 03d: ifnull 0c0
      // 040: goto 044
      // 043: athrow
      // 044: aload 1
      // 045: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 048: astore 4
      // 04a: aload 4
      // 04c: invokevirtual com/mojang/authlib/GameProfile.getId ()Ljava/util/UUID;
      // 04f: astore 5
      // 051: aload 5
      // 053: iload 2
      // 054: ifne 06d
      // 057: ifnull 06e
      // 05a: goto 05e
      // 05d: athrow
      // 05e: getstatic x/oc11bafa49c6.ð Ljava/util/Map;
      // 061: aload 3
      // 062: aload 5
      // 064: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 069: goto 06d
      // 06c: athrow
      // 06d: pop
      // 06e: aload 4
      // 070: invokevirtual com/mojang/authlib/GameProfile.getName ()Ljava/lang/String;
      // 073: ifnull 093
      // 076: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 079: iload 2
      // 07a: ifne 08b
      // 07d: goto 081
      // 080: athrow
      // 081: ifnull 093
      // 084: goto 088
      // 087: athrow
      // 088: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 08b: aload 4
      // 08d: invokevirtual com/mojang/authlib/GameProfile.getName ()Ljava/lang/String;
      // 090: invokevirtual x/occ9ed06a81d.Ȩ (Ljava/lang/String;)V
      // 093: aload 1
      // 094: iload 2
      // 095: ifne 0c9
      // 098: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getLocationSkin ()Lnet/minecraft/util/ResourceLocation;
      // 09b: astore 6
      // 09d: aload 6
      // 09f: ifnull 0c0
      // 0a2: getstatic x/oc11bafa49c6.Ɨ Ljava/util/Map;
      // 0a5: aload 3
      // 0a6: aload 6
      // 0a8: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0ad: pop
      // 0ae: getstatic x/oc11bafa49c6.ʓ Ljava/util/Map;
      // 0b1: aload 3
      // 0b2: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0b7: pop
      // 0b8: aload 3
      // 0b9: invokestatic x/oc11bafa49c6.џ (Ljava/lang/String;)V
      // 0bc: aload 6
      // 0be: areturn
      // 0bf: athrow
      // 0c0: getstatic x/oc11bafa49c6.Ɨ Ljava/util/Map;
      // 0c3: aload 3
      // 0c4: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c9: checkcast net/minecraft/util/ResourceLocation
      // 0cc: astore 4
      // 0ce: aload 4
      // 0d0: iload 2
      // 0d1: ifne 0dd
      // 0d4: ifnull 0de
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 4
      // 0dd: areturn
      // 0de: invokestatic java/lang/System.currentTimeMillis ()J
      // 0e1: lstore 5
      // 0e3: getstatic x/oc11bafa49c6.ʓ Ljava/util/Map;
      // 0e6: aload 3
      // 0e7: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0ec: checkcast java/lang/Long
      // 0ef: astore 7
      // 0f1: aload 7
      // 0f3: iload 2
      // 0f4: ifne 113
      // 0f7: ifnull 10d
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: lload 5
      // 100: aload 7
      // 102: invokevirtual java/lang/Long.longValue ()J
      // 105: lcmp
      // 106: iflt 12b
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 7
      // 10f: goto 113
      // 112: athrow
      // 113: ifnull 126
      // 116: getstatic x/oc11bafa49c6.ʓ Ljava/util/Map;
      // 119: aload 3
      // 11a: aload 7
      // 11c: invokeinterface java/util/Map.remove (Ljava/lang/Object;Ljava/lang/Object;)Z 3
      // 121: pop
      // 122: goto 126
      // 125: athrow
      // 126: aload 3
      // 127: aload 0
      // 128: invokestatic x/oc11bafa49c6.σ (Ljava/lang/String;Ljava/lang/String;)V
      // 12b: getstatic x/oc11bafa49c6.ð Ljava/util/Map;
      // 12e: aload 3
      // 12f: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 134: checkcast java/util/UUID
      // 137: astore 8
      // 139: aload 8
      // 13b: iload 2
      // 13c: ifne 15e
      // 13f: ifnonnull 15c
      // 142: goto 146
      // 145: athrow
      // 146: aload 0
      // 147: invokestatic net/minecraft/entity/player/EntityPlayer.getOfflineUUID (Ljava/lang/String;)Ljava/util/UUID;
      // 14a: astore 8
      // 14c: getstatic x/oc11bafa49c6.ð Ljava/util/Map;
      // 14f: aload 3
      // 150: aload 8
      // 152: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 157: pop
      // 158: aload 3
      // 159: invokestatic x/oc11bafa49c6.џ (Ljava/lang/String;)V
      // 15c: aload 8
      // 15e: invokestatic net/minecraft/client/resources/DefaultPlayerSkin.getDefaultSkin (Ljava/util/UUID;)Lnet/minecraft/util/ResourceLocation;
      // 161: areturn
   }

   private static void σ(String param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic java/lang/System.currentTimeMillis ()J
      // 06: lstore 3
      // 07: istore 2
      // 08: getstatic x/oc11bafa49c6.Ǵ Ljava/util/Map;
      // 0b: aload 0
      // 0c: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 11: checkcast x/ocbff50020a5
      // 14: astore 5
      // 16: aload 5
      // 18: iload 2
      // 19: ifne 56
      // 1c: ifnull 54
      // 1f: goto 23
      // 22: athrow
      // 23: aload 5
      // 25: iload 2
      // 26: ifne 56
      // 29: goto 2d
      // 2c: athrow
      // 2d: lload 3
      // 2e: invokevirtual x/ocbff50020a5.у (J)Z
      // 31: ifne 54
      // 34: goto 38
      // 37: athrow
      // 38: aload 5
      // 3a: getfield x/ocbff50020a5.Š Lcom/mojang/authlib/GameProfile;
      // 3d: ifnonnull 4a
      // 40: goto 44
      // 43: athrow
      // 44: aload 0
      // 45: invokestatic x/oc11bafa49c6.Ѷ (Ljava/lang/String;)V
      // 48: return
      // 49: athrow
      // 4a: aload 0
      // 4b: aload 5
      // 4d: getfield x/ocbff50020a5.Š Lcom/mojang/authlib/GameProfile;
      // 50: invokestatic x/oc11bafa49c6.Ћ (Ljava/lang/String;Lcom/mojang/authlib/GameProfile;)V
      // 53: return
      // 54: aload 5
      // 56: ifnull 69
      // 59: getstatic x/oc11bafa49c6.Ǵ Ljava/util/Map;
      // 5c: aload 0
      // 5d: aload 5
      // 5f: invokeinterface java/util/Map.remove (Ljava/lang/Object;Ljava/lang/Object;)Z 3
      // 64: pop
      // 65: goto 69
      // 68: athrow
      // 69: getstatic x/oc11bafa49c6.Л Ljava/util/Set;
      // 6c: aload 0
      // 6d: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 72: ifne 77
      // 75: return
      // 76: athrow
      // 77: getstatic x/oc11bafa49c6.Խ Ljava/util/concurrent/ExecutorService;
      // 7a: new x/oce6a3f39735
      // 7d: dup
      // 7e: aload 1
      // 7f: aload 0
      // 80: invokespecial x/oce6a3f39735.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 83: invokeinterface java/util/concurrent/ExecutorService.execute (Ljava/lang/Runnable;)V 2
      // 88: return
   }

   private static void Ћ(String param0, GameProfile param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 1
      // 05: ifnonnull 0e
      // 08: aload 0
      // 09: invokestatic x/oc11bafa49c6.Ѷ (Ljava/lang/String;)V
      // 0c: return
      // 0d: athrow
      // 0e: getstatic x/oc11bafa49c6.Ҁ Ljava/util/Set;
      // 11: aload 0
      // 12: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 17: ifne 1c
      // 1a: return
      // 1b: athrow
      // 1c: aload 1
      // 1d: iload 2
      // 1e: ifne 3c
      // 21: invokevirtual com/mojang/authlib/GameProfile.getId ()Ljava/util/UUID;
      // 24: ifnull 3d
      // 27: goto 2b
      // 2a: athrow
      // 2b: getstatic x/oc11bafa49c6.ð Ljava/util/Map;
      // 2e: aload 0
      // 2f: aload 1
      // 30: invokevirtual com/mojang/authlib/GameProfile.getId ()Ljava/util/UUID;
      // 33: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 38: goto 3c
      // 3b: athrow
      // 3c: pop
      // 3d: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 40: astore 3
      // 41: aload 3
      // 42: invokevirtual net/minecraft/client/Minecraft.getSkinManager ()Lnet/minecraft/client/resources/SkinManager;
      // 45: aload 1
      // 46: invokevirtual net/minecraft/client/resources/SkinManager.loadSkinFromCache (Lcom/mojang/authlib/GameProfile;)Ljava/util/Map;
      // 49: astore 4
      // 4b: aload 4
      // 4d: iload 2
      // 4e: ifne 67
      // 51: ifnonnull 5d
      // 54: goto 58
      // 57: athrow
      // 58: aconst_null
      // 59: goto 6a
      // 5c: athrow
      // 5d: aload 4
      // 5f: getstatic com/mojang/authlib/minecraft/MinecraftProfileTexture$Type.SKIN Lcom/mojang/authlib/minecraft/MinecraftProfileTexture$Type;
      // 62: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 67: checkcast com/mojang/authlib/minecraft/MinecraftProfileTexture
      // 6a: astore 5
      // 6c: iload 2
      // 6d: ifne 98
      // 70: aload 5
      // 72: ifnonnull 88
      // 75: goto 79
      // 78: athrow
      // 79: aload 0
      // 7a: invokestatic x/oc11bafa49c6.Ѷ (Ljava/lang/String;)V
      // 7d: getstatic x/oc11bafa49c6.Ҁ Ljava/util/Set;
      // 80: aload 0
      // 81: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 86: pop
      // 87: return
      // 88: aload 3
      // 89: new x/oc1dfcc931f9
      // 8c: dup
      // 8d: aload 1
      // 8e: aload 5
      // 90: aload 0
      // 91: invokespecial x/oc1dfcc931f9.<init> (Lcom/mojang/authlib/GameProfile;Lcom/mojang/authlib/minecraft/MinecraftProfileTexture;Ljava/lang/String;)V
      // 94: invokevirtual net/minecraft/client/Minecraft.addScheduledTask (Ljava/lang/Runnable;)Lcom/google/common/util/concurrent/ListenableFuture;
      // 97: pop
      // 98: goto aa
      // 9b: astore 3
      // 9c: getstatic x/oc11bafa49c6.Ҁ Ljava/util/Set;
      // 9f: aload 0
      // a0: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // a5: pop
      // a6: aload 0
      // a7: invokestatic x/oc11bafa49c6.Ѷ (Ljava/lang/String;)V
      // aa: return
   }

   private static void Չ(String var0, GameProfile var1) {
      long var10000;
      label16: {
         try {
            if (var1 == null) {
               var10000 = -6936042505299889959L ^ -6936042505300188359L;
               break label16;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         var10000 = -6936042505300798343L ^ -6936042505300188359L;
      }

      long var2 = var10000;
      Ǵ.put(var0, new ocbff50020a5(var1, System.currentTimeMillis() + var2));
      џ(var0);
   }

   private static void Ѷ(String var0) {
      ʓ.put(var0, System.currentTimeMillis() + (7995846699785950924L ^ 7995846699786175788L));
      џ(var0);
   }

   private static void џ(String var0) {
      Δ(Ɨ, var0);
      Δ(ð, var0);
      Δ(Ǵ, var0);
      Δ(ʓ, var0);
   }

   private static <T> void Δ(Map<String, T> param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1f
      // 09: invokeinterface java/util/Map.size ()I 1
      // 0e: ldc_w 785596409
      // 11: ldc_w 785595897
      // 14: ixor
      // 15: if_icmpgt 1e
      // 18: goto 1c
      // 1b: athrow
      // 1c: return
      // 1d: athrow
      // 1e: aload 0
      // 1f: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 24: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 29: astore 3
      // 2a: aload 3
      // 2b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 30: ifeq 72
      // 33: aload 3
      // 34: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 39: checkcast java/lang/String
      // 3c: astore 4
      // 3e: iload 2
      // 3f: ifne 5c
      // 42: aload 4
      // 44: aload 1
      // 45: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 48: ifne 6e
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 0
      // 50: aload 4
      // 52: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 57: pop
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 0
      // 5d: invokeinterface java/util/Map.size ()I 1
      // 62: ldc_w 785596409
      // 65: ldc_w 785595897
      // 68: ixor
      // 69: if_icmpgt 6e
      // 6c: return
      // 6d: athrow
      // 6e: iload 2
      // 6f: ifeq 2a
      // 72: return
   }

   private static String Ԙ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1b
      // 09: ifnonnull 17
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc_w ""
      // 13: goto 21
      // 16: athrow
      // 17: aload 0
      // 18: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1b: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 1e: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 21: areturn
   }
}
