package x;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.util.Vec3;

public class oc3dfdeebd5a {
   private final Minecraft ɥ = Minecraft.getMinecraft();
   private final Queue<oc1dc74d739e> Ҩ = new ConcurrentLinkedQueue<>();
   private long ʏ = System.currentTimeMillis();
   private double ԡ;
   public static int ң;

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ӟ(oce79181588d param1) {
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
      // 05: iload 2
      // 06: ifne 1b
      // 09: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 0c: invokestatic x/oc1b38068efb.Ѣ (Lnet/minecraft/network/Packet;)Z
      // 0f: ifne 2c
      // 12: goto 16
      // 15: athrow
      // 16: aload 1
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 1e: invokestatic x/oc1b38068efb.Բ (Lnet/minecraft/network/Packet;)Z
      // 21: iload 2
      // 22: ifne 45
      // 25: ifeq 39
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield x/oc3dfdeebd5a.Ҩ Ljava/util/Queue;
      // 30: invokeinterface java/util/Queue.clear ()V 1
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: iload 2
      // 3b: ifne 49
      // 3e: invokevirtual x/oc3dfdeebd5a.ҿ ()Z
      // 41: goto 45
      // 44: athrow
      // 45: ifeq 70
      // 48: aload 0
      // 49: iload 2
      // 4a: ifne 5f
      // 4d: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 50: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 53: ifnull 70
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: goto 5f
      // 5e: athrow
      // 5f: iload 2
      // 60: ifne 73
      // 63: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 66: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 69: ifnonnull 72
      // 6c: goto 70
      // 6f: athrow
      // 70: return
      // 71: athrow
      // 72: aload 0
      // 73: aload 1
      // 74: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 77: invokevirtual x/oc3dfdeebd5a.С (Lnet/minecraft/network/Packet;)V
      // 7a: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ҡ(ocf6b0e5bf86 param1) {
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
      // 06: ifne 18
      // 09: invokevirtual x/oc3dfdeebd5a.ҿ ()Z
      // 0c: ifeq 29
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2c
      // 1c: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 22: ifnonnull 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: aload 0
      // 2c: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 2f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 32: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 35: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3a: astore 3
      // 3b: aload 3
      // 3c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 41: ifeq 8f
      // 44: aload 3
      // 45: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4a: checkcast net/minecraft/entity/Entity
      // 4d: astore 4
      // 4f: aload 4
      // 51: iload 2
      // 52: ifne 68
      // 55: instanceof net/minecraft/entity/EntityLivingBase
      // 58: ifeq 8b
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 4
      // 61: invokestatic x/oc3dfdeebd5a.Š (Lnet/minecraft/entity/Entity;)Lx/oc5540c34271;
      // 64: goto 68
      // 67: athrow
      // 68: astore 5
      // 6a: aload 5
      // 6c: iload 2
      // 6d: ifne 82
      // 70: invokeinterface x/oc5540c34271.hasBacktrackTruePosition ()Z 1
      // 75: ifne 8b
      // 78: goto 7c
      // 7b: athrow
      // 7c: aload 5
      // 7e: goto 82
      // 81: athrow
      // 82: aload 4
      // 84: invokevirtual net/minecraft/entity/Entity.getPositionVector ()Lnet/minecraft/util/Vec3;
      // 87: bipush 0
      // 88: invokestatic x/oc3dfdeebd5a.ϔ (Lx/oc5540c34271;Lnet/minecraft/util/Vec3;Z)V
      // 8b: iload 2
      // 8c: ifeq 3b
      // 8f: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void ԟ(oc9374123646 param1) {
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
      // 07: lconst_0
      // 08: lload 3
      // 09: aload 0
      // 0a: getfield x/oc3dfdeebd5a.ʏ J
      // 0d: lsub
      // 0e: invokestatic java/lang/Math.max (JJ)J
      // 11: lstore 5
      // 13: istore 2
      // 14: aload 0
      // 15: iload 2
      // 16: ifne 52
      // 19: lload 3
      // 1a: putfield x/oc3dfdeebd5a.ʏ J
      // 1d: aload 0
      // 1e: invokevirtual x/oc3dfdeebd5a.ҿ ()Z
      // 21: ifne 42
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: iload 2
      // 2a: ifne 52
      // 2d: goto 31
      // 30: athrow
      // 31: getfield x/oc3dfdeebd5a.Ҩ Ljava/util/Queue;
      // 34: invokeinterface java/util/Queue.isEmpty ()Z 1
      // 39: ifeq 42
      // 3c: goto 40
      // 3f: athrow
      // 40: return
      // 41: athrow
      // 42: aload 0
      // 43: lload 5
      // 45: l2d
      // 46: ldc2_w 60.0
      // 49: ddiv
      // 4a: dconst_1
      // 4b: invokestatic java/lang/Math.min (DD)D
      // 4e: putfield x/oc3dfdeebd5a.ԡ D
      // 51: aload 0
      // 52: invokevirtual x/oc3dfdeebd5a.ϋ ()V
      // 55: return
   }

   @oc66fa4f2195
   public void Ż(ocbab3c9954b var1) {
      this.Ҩ.clear();
   }

   public void ʗ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 07: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 0a: astore 3
      // 0b: aload 0
      // 0c: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 0f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 12: astore 4
      // 14: istore 2
      // 15: aload 1
      // 16: ifnull 78
      // 19: aload 3
      // 1a: ifnull 78
      // 1d: goto 21
      // 20: athrow
      // 21: aload 4
      // 23: ifnull 78
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 3
      // 2b: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.isDoneLoadingTerrain ()Z
      // 2e: iload 2
      // 2f: ifne 4d
      // 32: goto 36
      // 35: athrow
      // 36: ifeq 78
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 1
      // 3e: iload 2
      // 3f: ifne 51
      // 42: goto 46
      // 45: athrow
      // 46: invokestatic x/oc1b38068efb.Ѣ (Lnet/minecraft/network/Packet;)Z
      // 49: goto 4d
      // 4c: athrow
      // 4d: ifne 78
      // 50: aload 1
      // 51: invokestatic x/oc1b38068efb.Բ (Lnet/minecraft/network/Packet;)Z
      // 54: iload 2
      // 55: ifne 77
      // 58: ifne 78
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: getfield x/oc3dfdeebd5a.Ҩ Ljava/util/Queue;
      // 63: new x/oc1dc74d739e
      // 66: dup
      // 67: aload 1
      // 68: aload 3
      // 69: aload 4
      // 6b: invokespecial x/oc1dc74d739e.<init> (Lnet/minecraft/network/Packet;Lnet/minecraft/client/network/NetHandlerPlayClient;Lnet/minecraft/client/multiplayer/WorldClient;)V
      // 6e: invokeinterface java/util/Queue.offer (Ljava/lang/Object;)Z 2
      // 73: goto 77
      // 76: athrow
      // 77: pop
      // 78: return
   }

   public boolean ձ() {
      return this.Ҩ.isEmpty();
   }

   public void о() {
      this.Ҩ.clear();
   }

   private boolean ҿ() {
      int var1 = oc75d51ec7eb.ϩ;

      occ39d36078d var10000;
      label33: {
         try {
            var10000 = oc9755810e45.G;
            if (var1 != 0) {
               break label33;
            }

            if (oc9755810e45.G == null) {
               return false;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var10000 = oc9755810e45.G;
      }

      try {
         boolean var4 = var10000.z$3rzb3dil7uydr();
         if (var1 != 0) {
            return var4;
         }

         if (var4) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public Vec3 Ѐ(Entity var1) {
      oc5540c34271 var2 = Š(var1);

      try {
         if (var2.hasBacktrackTruePosition()) {
            return new Vec3(var2.getBacktrackTrueX(), var2.getBacktrackTrueY(), var2.getBacktrackTrueZ());
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return var1.getPositionVector();
   }

   public Vec3 Ѕ(Entity var1) {
      oc5540c34271 var2 = Š(var1);

      try {
         if (var2.hasBacktrackTruePosition()) {
            return new Vec3(var2.getBacktrackLerpX(), var2.getBacktrackLerpY(), var2.getBacktrackLerpZ());
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return var1.getPositionVector();
   }

   public boolean Κ(Entity param1) {
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
      // 05: iload 2
      // 06: ifne 18
      // 09: ifnull 2c
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: invokestatic x/oc3dfdeebd5a.Š (Lnet/minecraft/entity/Entity;)Lx/oc5540c34271;
      // 14: goto 18
      // 17: athrow
      // 18: invokeinterface x/oc5540c34271.hasBacktrackTruePosition ()Z 1
      // 1d: iload 2
      // 1e: ifne 29
      // 21: ifeq 2c
      // 24: goto 28
      // 27: athrow
      // 28: bipush 1
      // 29: goto 2d
      // 2c: bipush 0
      // 2d: ireturn
   }

   private void С(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 3
      // 002: getstatic x/oc75d51ec7eb.ϩ I
      // 005: aconst_null
      // 006: astore 4
      // 008: istore 2
      // 009: bipush 0
      // 00a: istore 5
      // 00c: aload 1
      // 00d: iload 2
      // 00e: ifne 05c
      // 011: instanceof net/minecraft/network/play/server/S0CPacketSpawnPlayer
      // 014: ifeq 05b
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 1
      // 01c: checkcast net/minecraft/network/play/server/S0CPacketSpawnPlayer
      // 01f: astore 6
      // 021: aload 0
      // 022: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 025: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 028: aload 6
      // 02a: invokevirtual net/minecraft/network/play/server/S0CPacketSpawnPlayer.getEntityID ()I
      // 02d: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntityByID (I)Lnet/minecraft/entity/Entity;
      // 030: astore 3
      // 031: new net/minecraft/util/Vec3
      // 034: dup
      // 035: aload 6
      // 037: invokevirtual net/minecraft/network/play/server/S0CPacketSpawnPlayer.getX ()I
      // 03a: i2d
      // 03b: ldc2_w 32.0
      // 03e: ddiv
      // 03f: aload 6
      // 041: invokevirtual net/minecraft/network/play/server/S0CPacketSpawnPlayer.getY ()I
      // 044: i2d
      // 045: ldc2_w 32.0
      // 048: ddiv
      // 049: aload 6
      // 04b: invokevirtual net/minecraft/network/play/server/S0CPacketSpawnPlayer.getZ ()I
      // 04e: i2d
      // 04f: ldc2_w 32.0
      // 052: ddiv
      // 053: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 056: astore 4
      // 058: goto 1a5
      // 05b: aload 1
      // 05c: iload 2
      // 05d: ifne 0ab
      // 060: instanceof net/minecraft/network/play/server/S0FPacketSpawnMob
      // 063: ifeq 0aa
      // 066: goto 06a
      // 069: athrow
      // 06a: aload 1
      // 06b: checkcast net/minecraft/network/play/server/S0FPacketSpawnMob
      // 06e: astore 6
      // 070: aload 0
      // 071: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 074: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 077: aload 6
      // 079: invokevirtual net/minecraft/network/play/server/S0FPacketSpawnMob.getEntityID ()I
      // 07c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntityByID (I)Lnet/minecraft/entity/Entity;
      // 07f: astore 3
      // 080: new net/minecraft/util/Vec3
      // 083: dup
      // 084: aload 6
      // 086: invokevirtual net/minecraft/network/play/server/S0FPacketSpawnMob.getX ()I
      // 089: i2d
      // 08a: ldc2_w 32.0
      // 08d: ddiv
      // 08e: aload 6
      // 090: invokevirtual net/minecraft/network/play/server/S0FPacketSpawnMob.getY ()I
      // 093: i2d
      // 094: ldc2_w 32.0
      // 097: ddiv
      // 098: aload 6
      // 09a: invokevirtual net/minecraft/network/play/server/S0FPacketSpawnMob.getZ ()I
      // 09d: i2d
      // 09e: ldc2_w 32.0
      // 0a1: ddiv
      // 0a2: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0a5: astore 4
      // 0a7: goto 1a5
      // 0aa: aload 1
      // 0ab: iload 2
      // 0ac: ifne 153
      // 0af: instanceof net/minecraft/network/play/server/S14PacketEntity
      // 0b2: ifeq 152
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 0
      // 0ba: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 0bd: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0c0: aload 1
      // 0c1: checkcast x/oc1553ad102e
      // 0c4: invokeinterface x/oc1553ad102e.getEntityId ()I 1
      // 0c9: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntityByID (I)Lnet/minecraft/entity/Entity;
      // 0cc: astore 3
      // 0cd: aload 3
      // 0ce: iload 2
      // 0cf: ifne 0e1
      // 0d2: ifnull 1a5
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: aload 3
      // 0da: invokestatic x/oc3dfdeebd5a.Š (Lnet/minecraft/entity/Entity;)Lx/oc5540c34271;
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: astore 6
      // 0e3: aload 6
      // 0e5: iload 2
      // 0e6: ifne 0fb
      // 0e9: invokeinterface x/oc5540c34271.hasBacktrackTruePosition ()Z 1
      // 0ee: ifne 103
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: aload 6
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: aload 3
      // 0fc: invokevirtual net/minecraft/entity/Entity.getPositionVector ()Lnet/minecraft/util/Vec3;
      // 0ff: bipush 0
      // 100: invokestatic x/oc3dfdeebd5a.ϔ (Lx/oc5540c34271;Lnet/minecraft/util/Vec3;Z)V
      // 103: aload 1
      // 104: checkcast net/minecraft/network/play/server/S14PacketEntity
      // 107: astore 7
      // 109: new net/minecraft/util/Vec3
      // 10c: dup
      // 10d: aload 6
      // 10f: invokeinterface x/oc5540c34271.getBacktrackTrueX ()D 1
      // 114: aload 7
      // 116: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149062_c ()B
      // 119: i2d
      // 11a: ldc2_w 32.0
      // 11d: ddiv
      // 11e: dadd
      // 11f: aload 6
      // 121: invokeinterface x/oc5540c34271.getBacktrackTrueY ()D 1
      // 126: aload 7
      // 128: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149061_d ()B
      // 12b: i2d
      // 12c: ldc2_w 32.0
      // 12f: ddiv
      // 130: dadd
      // 131: aload 6
      // 133: invokeinterface x/oc5540c34271.getBacktrackTrueZ ()D 1
      // 138: aload 7
      // 13a: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149064_e ()B
      // 13d: i2d
      // 13e: ldc2_w 32.0
      // 141: ddiv
      // 142: dadd
      // 143: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 146: astore 4
      // 148: aload 6
      // 14a: aload 4
      // 14c: invokestatic x/oc3dfdeebd5a.ӕ (Lx/oc5540c34271;Lnet/minecraft/util/Vec3;)V
      // 14f: goto 1a5
      // 152: aload 1
      // 153: iload 2
      // 154: ifne 166
      // 157: instanceof net/minecraft/network/play/server/S18PacketEntityTeleport
      // 15a: ifeq 1a5
      // 15d: goto 161
      // 160: athrow
      // 161: aload 1
      // 162: goto 166
      // 165: athrow
      // 166: checkcast net/minecraft/network/play/server/S18PacketEntityTeleport
      // 169: astore 6
      // 16b: aload 0
      // 16c: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 16f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 172: aload 6
      // 174: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getEntityId ()I
      // 177: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntityByID (I)Lnet/minecraft/entity/Entity;
      // 17a: astore 3
      // 17b: new net/minecraft/util/Vec3
      // 17e: dup
      // 17f: aload 6
      // 181: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getX ()I
      // 184: i2d
      // 185: ldc2_w 32.0
      // 188: ddiv
      // 189: aload 6
      // 18b: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getY ()I
      // 18e: i2d
      // 18f: ldc2_w 32.0
      // 192: ddiv
      // 193: aload 6
      // 195: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getZ ()I
      // 198: i2d
      // 199: ldc2_w 32.0
      // 19c: ddiv
      // 19d: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1a0: astore 4
      // 1a2: bipush 1
      // 1a3: istore 5
      // 1a5: aload 3
      // 1a6: instanceof net/minecraft/entity/EntityLivingBase
      // 1a9: ifeq 1cf
      // 1ac: aload 4
      // 1ae: ifnull 1cf
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: aload 1
      // 1b6: instanceof net/minecraft/network/play/server/S14PacketEntity
      // 1b9: ifne 1cf
      // 1bc: goto 1c0
      // 1bf: athrow
      // 1c0: aload 3
      // 1c1: invokestatic x/oc3dfdeebd5a.Š (Lnet/minecraft/entity/Entity;)Lx/oc5540c34271;
      // 1c4: aload 4
      // 1c6: iload 5
      // 1c8: invokestatic x/oc3dfdeebd5a.ϔ (Lx/oc5540c34271;Lnet/minecraft/util/Vec3;Z)V
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: return
   }

   public void ɖ(Entity param1) {
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
      // 05: iload 2
      // 06: ifne 19
      // 09: instanceof net/minecraft/entity/EntityLivingBase
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 1
      // 16: invokestatic x/oc3dfdeebd5a.Š (Lnet/minecraft/entity/Entity;)Lx/oc5540c34271;
      // 19: astore 3
      // 1a: iload 2
      // 1b: ifne 8a
      // 1e: aload 3
      // 1f: invokeinterface x/oc5540c34271.hasBacktrackTruePosition ()Z 1
      // 24: ifne 2d
      // 27: goto 2b
      // 2a: athrow
      // 2b: return
      // 2c: athrow
      // 2d: aload 3
      // 2e: aload 3
      // 2f: invokeinterface x/oc5540c34271.getBacktrackLerpX ()D 1
      // 34: aload 3
      // 35: invokeinterface x/oc5540c34271.getBacktrackTrueX ()D 1
      // 3a: aload 3
      // 3b: invokeinterface x/oc5540c34271.getBacktrackLerpX ()D 1
      // 40: dsub
      // 41: aload 0
      // 42: getfield x/oc3dfdeebd5a.ԡ D
      // 45: dmul
      // 46: dadd
      // 47: invokeinterface x/oc5540c34271.setBacktrackLerpX (D)V 3
      // 4c: aload 3
      // 4d: aload 3
      // 4e: invokeinterface x/oc5540c34271.getBacktrackLerpY ()D 1
      // 53: aload 3
      // 54: invokeinterface x/oc5540c34271.getBacktrackTrueY ()D 1
      // 59: aload 3
      // 5a: invokeinterface x/oc5540c34271.getBacktrackLerpY ()D 1
      // 5f: dsub
      // 60: aload 0
      // 61: getfield x/oc3dfdeebd5a.ԡ D
      // 64: dmul
      // 65: dadd
      // 66: invokeinterface x/oc5540c34271.setBacktrackLerpY (D)V 3
      // 6b: aload 3
      // 6c: aload 3
      // 6d: invokeinterface x/oc5540c34271.getBacktrackLerpZ ()D 1
      // 72: aload 3
      // 73: invokeinterface x/oc5540c34271.getBacktrackTrueZ ()D 1
      // 78: aload 3
      // 79: invokeinterface x/oc5540c34271.getBacktrackLerpZ ()D 1
      // 7e: dsub
      // 7f: aload 0
      // 80: getfield x/oc3dfdeebd5a.ԡ D
      // 83: dmul
      // 84: dadd
      // 85: invokeinterface x/oc5540c34271.setBacktrackLerpZ (D)V 3
      // 8a: return
   }

   private void ϋ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 07: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 0a: astore 2
      // 0b: istore 1
      // 0c: aload 0
      // 0d: getfield x/oc3dfdeebd5a.ɥ Lnet/minecraft/client/Minecraft;
      // 10: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 13: astore 3
      // 14: iload 1
      // 15: ifne 48
      // 18: aload 2
      // 19: ifnull 3b
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 3
      // 21: ifnull 3b
      // 24: goto 28
      // 27: athrow
      // 28: aload 2
      // 29: iload 1
      // 2a: ifne 52
      // 2d: goto 31
      // 30: athrow
      // 31: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.isDoneLoadingTerrain ()Z
      // 34: ifne 49
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: getfield x/oc3dfdeebd5a.Ҩ Ljava/util/Queue;
      // 3f: invokeinterface java/util/Queue.clear ()V 1
      // 44: goto 48
      // 47: athrow
      // 48: return
      // 49: aload 0
      // 4a: getfield x/oc3dfdeebd5a.Ҩ Ljava/util/Queue;
      // 4d: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 52: checkcast x/oc1dc74d739e
      // 55: dup
      // 56: astore 4
      // 58: ifnull bb
      // 5b: aload 4
      // 5d: iload 1
      // 5e: ifne 72
      // 61: goto 65
      // 64: athrow
      // 65: getfield x/oc1dc74d739e.ʠ Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 68: aload 2
      // 69: if_acmpne 49
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 4
      // 72: iload 1
      // 73: ifne 83
      // 76: getfield x/oc1dc74d739e.Ӷ Lnet/minecraft/client/multiplayer/WorldClient;
      // 79: aload 3
      // 7a: if_acmpne 49
      // 7d: goto 81
      // 80: athrow
      // 81: aload 4
      // 83: iload 1
      // 84: ifne 96
      // 87: getfield x/oc1dc74d739e.Ë Lnet/minecraft/network/Packet;
      // 8a: invokestatic x/oc1b38068efb.Ѣ (Lnet/minecraft/network/Packet;)Z
      // 8d: ifne 49
      // 90: goto 94
      // 93: athrow
      // 94: aload 4
      // 96: iload 1
      // 97: ifne b1
      // 9a: getfield x/oc1dc74d739e.Ë Lnet/minecraft/network/Packet;
      // 9d: invokestatic x/oc1b38068efb.Բ (Lnet/minecraft/network/Packet;)Z
      // a0: ifeq af
      // a3: goto a7
      // a6: athrow
      // a7: iload 1
      // a8: ifeq 49
      // ab: goto af
      // ae: athrow
      // af: aload 4
      // b1: getfield x/oc1dc74d739e.Ë Lnet/minecraft/network/Packet;
      // b4: invokestatic x/ocd6ae010123.Å (Lnet/minecraft/network/Packet;)V
      // b7: iload 1
      // b8: ifeq 49
      // bb: return
   }

   private static oc5540c34271 Š(Entity var0) {
      return var0;
   }

   private static void ϔ(oc5540c34271 param0, Vec3 param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 38
      // 09: aload 1
      // 0a: invokestatic x/oc3dfdeebd5a.ӕ (Lx/oc5540c34271;Lnet/minecraft/util/Vec3;)V
      // 0d: iload 2
      // 0e: ifne 37
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: aload 1
      // 17: getfield net/minecraft/util/Vec3.xCoord D
      // 1a: invokeinterface x/oc5540c34271.setBacktrackLerpX (D)V 3
      // 1f: aload 0
      // 20: aload 1
      // 21: getfield net/minecraft/util/Vec3.yCoord D
      // 24: invokeinterface x/oc5540c34271.setBacktrackLerpY (D)V 3
      // 29: aload 0
      // 2a: aload 1
      // 2b: getfield net/minecraft/util/Vec3.zCoord D
      // 2e: invokeinterface x/oc5540c34271.setBacktrackLerpZ (D)V 3
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: bipush 1
      // 39: invokeinterface x/oc5540c34271.setBacktrackTruePosition (Z)V 2
      // 3e: return
   }

   private static void ӕ(oc5540c34271 var0, Vec3 var1) {
      var0.setBacktrackTrueX(var1.xCoord);
      var0.setBacktrackTrueY(var1.yCoord);
      var0.setBacktrackTrueZ(var1.zCoord);
      var0.setBacktrackTruePosition(true);
   }
}
