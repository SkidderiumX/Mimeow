package x;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GLContext;

public class occc57954425 {
   private static final Minecraft ԍ = Minecraft.getMinecraft();
   private static final ConcurrentHashMap<UUID, ocdec3856236> ԛ = new ConcurrentHashMap<>();
   private static final boolean ţ;
   private static boolean Ĥ = true;
   public static boolean ҿ = false;
   private static int Ѿ = 0;
   public static boolean ȇ;

   public static boolean Ӝ() {
      return Ĥ;
   }

   public static void ó() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc4a43182f3e.ϡ Z
      // 03: getstatic x/occc57954425.ԛ Ljava/util/concurrent/ConcurrentHashMap;
      // 06: invokevirtual java/util/concurrent/ConcurrentHashMap.values ()Ljava/util/Collection;
      // 09: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0e: astore 1
      // 0f: istore 0
      // 10: aload 1
      // 11: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 16: ifeq 49
      // 19: aload 1
      // 1a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1f: checkcast x/ocdec3856236
      // 22: astore 2
      // 23: iload 0
      // 24: ifne 4f
      // 27: iload 0
      // 28: ifne 41
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 2
      // 30: getfield x/ocdec3856236.Ϡ I
      // 33: ifeq 45
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 2
      // 3b: getfield x/ocdec3856236.Ϡ I
      // 3e: invokestatic org/lwjgl/opengl/GL15.glDeleteQueries (I)V
      // 41: goto 45
      // 44: astore 3
      // 45: iload 0
      // 46: ifeq 10
      // 49: getstatic x/occc57954425.ԛ Ljava/util/concurrent/ConcurrentHashMap;
      // 4c: invokevirtual java/util/concurrent/ConcurrentHashMap.clear ()V
      // 4f: bipush 0
      // 50: ifeq 64
      // 53: iload 0
      // 54: ifeq 60
      // 57: goto 5b
      // 5a: athrow
      // 5b: bipush 0
      // 5c: goto 61
      // 5f: athrow
      // 60: bipush 1
      // 61: putstatic x/oc4a43182f3e.ϡ Z
      // 64: return
   }

   public static boolean ȅ(EntityLivingBase param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc4a43182f3e.ϡ Z
      // 003: istore 1
      // 004: getstatic x/occc57954425.Ĥ Z
      // 007: iload 1
      // 008: ifne 025
      // 00b: ifeq 024
      // 00e: goto 012
      // 011: athrow
      // 012: invokestatic x/oc4e1b577a95.Մ ()Z
      // 015: iload 1
      // 016: ifne 025
      // 019: goto 01d
      // 01c: athrow
      // 01d: ifne 026
      // 020: goto 024
      // 023: athrow
      // 024: bipush 0
      // 025: ireturn
      // 026: aload 0
      // 027: iload 1
      // 028: ifne 03d
      // 02b: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 02e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 031: if_acmpeq 054
      // 034: goto 038
      // 037: athrow
      // 038: aload 0
      // 039: goto 03d
      // 03c: athrow
      // 03d: iload 1
      // 03e: ifne 058
      // 041: getfield net/minecraft/entity/EntityLivingBase.worldObj Lnet/minecraft/world/World;
      // 044: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 047: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 04a: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 04d: if_acmpeq 057
      // 050: goto 054
      // 053: athrow
      // 054: bipush 0
      // 055: ireturn
      // 056: athrow
      // 057: aload 0
      // 058: instanceof net/minecraft/entity/item/EntityArmorStand
      // 05b: istore 2
      // 05c: iload 2
      // 05d: iload 1
      // 05e: ifne 093
      // 061: ifeq 081
      // 064: goto 068
      // 067: athrow
      // 068: aload 0
      // 069: iload 1
      // 06a: ifne 082
      // 06d: goto 071
      // 070: athrow
      // 071: checkcast net/minecraft/entity/item/EntityArmorStand
      // 074: invokevirtual net/minecraft/entity/item/EntityArmorStand.hasMarker ()Z
      // 077: ifeq 081
      // 07a: goto 07e
      // 07d: athrow
      // 07e: bipush 0
      // 07f: ireturn
      // 080: athrow
      // 081: aload 0
      // 082: iload 1
      // 083: ifne 0aa
      // 086: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 089: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08c: invokevirtual net/minecraft/entity/EntityLivingBase.isInvisibleToPlayer (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 08f: goto 093
      // 092: athrow
      // 093: ifeq 0a9
      // 096: iload 2
      // 097: iload 1
      // 098: ifne 0ad
      // 09b: goto 09f
      // 09e: athrow
      // 09f: ifne 0a9
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: bipush 0
      // 0a7: ireturn
      // 0a8: athrow
      // 0a9: aload 0
      // 0aa: instanceof net/minecraft/entity/boss/EntityWither
      // 0ad: iload 1
      // 0ae: ifne 0d0
      // 0b1: ifne 0cb
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: aload 0
      // 0b9: iload 1
      // 0ba: ifne 0dd
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: instanceof net/minecraft/entity/boss/EntityDragon
      // 0c4: ifeq 0d1
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: bipush 0
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: ireturn
      // 0d1: aload 0
      // 0d2: iload 1
      // 0d3: ifne 108
      // 0d6: getfield net/minecraft/entity/EntityLivingBase.ridingEntity Lnet/minecraft/entity/Entity;
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: ifnull 0fc
      // 0e0: aload 0
      // 0e1: iload 1
      // 0e2: ifne 108
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: getfield net/minecraft/entity/EntityLivingBase.ridingEntity Lnet/minecraft/entity/Entity;
      // 0ec: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 0ef: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f2: if_acmpne 0fc
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: bipush 0
      // 0fa: ireturn
      // 0fb: athrow
      // 0fc: aload 0
      // 0fd: iload 1
      // 0fe: ifne 128
      // 101: getfield net/minecraft/entity/EntityLivingBase.riddenByEntity Lnet/minecraft/entity/Entity;
      // 104: goto 108
      // 107: athrow
      // 108: ifnull 127
      // 10b: aload 0
      // 10c: iload 1
      // 10d: ifne 128
      // 110: goto 114
      // 113: athrow
      // 114: getfield net/minecraft/entity/EntityLivingBase.riddenByEntity Lnet/minecraft/entity/Entity;
      // 117: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 11a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11d: if_acmpne 127
      // 120: goto 124
      // 123: athrow
      // 124: bipush 0
      // 125: ireturn
      // 126: athrow
      // 127: aload 0
      // 128: invokestatic x/occc57954425.Ŭ (Lnet/minecraft/entity/Entity;)Z
      // 12b: ireturn
   }

   public static boolean z(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc4a43182f3e.ϡ Z
      // 03: istore 1
      // 04: getstatic x/occc57954425.Ĥ Z
      // 07: iload 1
      // 08: ifne 42
      // 0b: ifeq 41
      // 0e: goto 12
      // 11: athrow
      // 12: invokestatic x/oc4e1b577a95.Մ ()Z
      // 15: iload 1
      // 16: ifne 42
      // 19: goto 1d
      // 1c: athrow
      // 1d: ifeq 41
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: ifnull 41
      // 28: goto 2c
      // 2b: athrow
      // 2c: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 2f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 32: iload 1
      // 33: ifne 44
      // 36: goto 3a
      // 39: athrow
      // 3a: ifnonnull 43
      // 3d: goto 41
      // 40: athrow
      // 41: bipush 0
      // 42: ireturn
      // 43: aload 0
      // 44: iload 1
      // 45: ifne 5f
      // 48: getfield net/minecraft/entity/Entity.worldObj Lnet/minecraft/world/World;
      // 4b: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 4e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 51: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 54: if_acmpeq 5e
      // 57: goto 5b
      // 5a: athrow
      // 5b: bipush 0
      // 5c: ireturn
      // 5d: athrow
      // 5e: aload 0
      // 5f: invokestatic x/occc57954425.Ŭ (Lnet/minecraft/entity/Entity;)Z
      // 62: ireturn
   }

   private static int ɪ() {
      try {
         return GL15.glGenQueries();
      } catch (Throwable var1) {
         Ĥ = false;
         return 0;
      }
   }

   private static boolean Ŭ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc4a43182f3e.ϡ Z
      // 03: istore 1
      // 04: getstatic x/occc57954425.ҿ Z
      // 07: iload 1
      // 08: ifne 13
      // 0b: ifeq 14
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 0
      // 13: ireturn
      // 14: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 17: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 1a: astore 2
      // 1b: aload 2
      // 1c: iload 1
      // 1d: ifne 39
      // 20: ifnonnull 2a
      // 23: goto 27
      // 26: athrow
      // 27: bipush 0
      // 28: ireturn
      // 29: athrow
      // 2a: getstatic x/occc57954425.ԛ Ljava/util/concurrent/ConcurrentHashMap;
      // 2d: aload 0
      // 2e: invokevirtual net/minecraft/entity/Entity.getUniqueID ()Ljava/util/UUID;
      // 31: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocdec3856236.<init> (Ljava/util/UUID;)V, (Ljava/util/UUID;)Lx/ocdec3856236; ]
      // 36: invokevirtual java/util/concurrent/ConcurrentHashMap.computeIfAbsent (Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;
      // 39: checkcast x/ocdec3856236
      // 3c: astore 3
      // 3d: aload 3
      // 3e: iload 1
      // 3f: ifne bf
      // 42: getfield x/ocdec3856236.Ք Z
      // 45: ifeq be
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 3
      // 4d: invokestatic x/occc57954425.ɪ ()I
      // 50: putfield x/ocdec3856236.Ϡ I
      // 53: aload 3
      // 54: iload 1
      // 55: ifne 6a
      // 58: goto 5c
      // 5b: athrow
      // 5c: getfield x/ocdec3856236.Ϡ I
      // 5f: ifne 69
      // 62: goto 66
      // 65: athrow
      // 66: bipush 0
      // 67: ireturn
      // 68: athrow
      // 69: aload 3
      // 6a: bipush 0
      // 6b: putfield x/ocdec3856236.Ք Z
      // 6e: getstatic x/occc57954425.ţ Z
      // 71: iload 1
      // 72: ifne 81
      // 75: ifeq 84
      // 78: goto 7c
      // 7b: athrow
      // 7c: ldc 470235813
      // 7e: ldc 470267530
      // 80: ixor
      // 81: goto 89
      // 84: ldc 470237086
      // 86: ldc 470267530
      // 88: ixor
      // 89: istore 4
      // 8b: iload 4
      // 8d: aload 3
      // 8e: getfield x/ocdec3856236.Ϡ I
      // 91: invokestatic org/lwjgl/opengl/GL15.glBeginQuery (II)V
      // 94: aload 0
      // 95: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 98: ldc2_w 0.2
      // 9b: ldc2_w 0.2
      // 9e: ldc2_w 0.2
      // a1: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // a4: aload 2
      // a5: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // a8: dneg
      // a9: aload 2
      // aa: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // ad: dneg
      // ae: aload 2
      // af: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // b2: dneg
      // b3: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // b6: invokestatic x/occc57954425.J (Lnet/minecraft/util/AxisAlignedBB;)V
      // b9: iload 4
      // bb: invokestatic org/lwjgl/opengl/GL15.glEndQuery (I)V
      // be: aload 3
      // bf: getfield x/ocdec3856236.с Z
      // c2: ireturn
   }

   public static void J(AxisAlignedBB param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic net/minecraft/client/renderer/GlStateManager.disableAlpha ()V
      // 003: getstatic x/oc4a43182f3e.ϡ Z
      // 006: invokestatic net/minecraft/client/renderer/GlStateManager.disableCull ()V
      // 009: bipush 0
      // 00a: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 00d: bipush 0
      // 00e: bipush 0
      // 00f: bipush 0
      // 010: bipush 0
      // 011: invokestatic net/minecraft/client/renderer/GlStateManager.colorMask (ZZZZ)V
      // 014: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 017: astore 2
      // 018: aload 2
      // 019: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 01c: astore 3
      // 01d: aload 3
      // 01e: ldc -1029355408
      // 020: ldc -1029355400
      // 022: ixor
      // 023: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 026: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 029: aload 3
      // 02a: aload 0
      // 02b: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 02e: aload 0
      // 02f: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 032: aload 0
      // 033: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 036: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 039: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 03c: aload 3
      // 03d: aload 0
      // 03e: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 041: aload 0
      // 042: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 045: aload 0
      // 046: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 049: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 04c: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 04f: aload 3
      // 050: aload 0
      // 051: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 054: aload 0
      // 055: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 058: aload 0
      // 059: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 05c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 05f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 062: aload 3
      // 063: aload 0
      // 064: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 067: aload 0
      // 068: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 06b: aload 0
      // 06c: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 06f: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 072: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 075: istore 1
      // 076: aload 3
      // 077: aload 0
      // 078: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 07b: aload 0
      // 07c: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 07f: aload 0
      // 080: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 083: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 086: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 089: aload 3
      // 08a: aload 0
      // 08b: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 08e: aload 0
      // 08f: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 092: aload 0
      // 093: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 096: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 099: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 09c: aload 3
      // 09d: aload 0
      // 09e: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0a1: aload 0
      // 0a2: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0a5: aload 0
      // 0a6: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0a9: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0ac: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0af: aload 3
      // 0b0: aload 0
      // 0b1: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0b4: aload 0
      // 0b5: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0b8: aload 0
      // 0b9: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0bc: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0bf: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0c2: aload 3
      // 0c3: aload 0
      // 0c4: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0c7: aload 0
      // 0c8: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0cb: aload 0
      // 0cc: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0cf: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0d2: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0d5: aload 3
      // 0d6: aload 0
      // 0d7: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0da: aload 0
      // 0db: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0de: aload 0
      // 0df: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0e2: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0e5: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0e8: aload 3
      // 0e9: aload 0
      // 0ea: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0ed: aload 0
      // 0ee: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0f1: aload 0
      // 0f2: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0f5: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0f8: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0fb: aload 3
      // 0fc: aload 0
      // 0fd: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 100: aload 0
      // 101: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 104: aload 0
      // 105: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 108: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 10b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 10e: aload 3
      // 10f: aload 0
      // 110: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 113: aload 0
      // 114: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 117: aload 0
      // 118: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 11b: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 11e: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 121: aload 3
      // 122: aload 0
      // 123: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 126: aload 0
      // 127: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 12a: aload 0
      // 12b: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 12e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 131: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 134: aload 2
      // 135: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 138: aload 3
      // 139: ldc_w -1029355393
      // 13c: ldc -1029355400
      // 13e: ixor
      // 13f: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 142: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 145: aload 3
      // 146: aload 0
      // 147: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 14a: aload 0
      // 14b: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 14e: aload 0
      // 14f: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 152: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 155: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 158: aload 3
      // 159: aload 0
      // 15a: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 15d: aload 0
      // 15e: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 161: aload 0
      // 162: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 165: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 168: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 16b: aload 3
      // 16c: aload 0
      // 16d: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 170: aload 0
      // 171: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 174: aload 0
      // 175: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 178: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 17b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 17e: aload 3
      // 17f: aload 0
      // 180: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 183: aload 0
      // 184: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 187: aload 0
      // 188: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 18b: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 18e: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 191: aload 3
      // 192: aload 0
      // 193: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 196: aload 0
      // 197: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 19a: aload 0
      // 19b: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 19e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1a1: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1a4: aload 3
      // 1a5: aload 0
      // 1a6: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1a9: aload 0
      // 1aa: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1ad: aload 0
      // 1ae: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1b1: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1b4: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1b7: aload 3
      // 1b8: aload 0
      // 1b9: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1bc: aload 0
      // 1bd: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1c0: aload 0
      // 1c1: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1c4: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1c7: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1ca: aload 3
      // 1cb: aload 0
      // 1cc: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1cf: aload 0
      // 1d0: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1d3: aload 0
      // 1d4: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 1d7: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1da: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1dd: aload 2
      // 1de: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 1e1: bipush 1
      // 1e2: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 1e5: bipush 1
      // 1e6: bipush 1
      // 1e7: bipush 1
      // 1e8: bipush 1
      // 1e9: invokestatic net/minecraft/client/renderer/GlStateManager.colorMask (ZZZZ)V
      // 1ec: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 1ef: iload 1
      // 1f0: ifeq 204
      // 1f3: bipush 0
      // 1f4: ifeq 200
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: bipush 0
      // 1fc: goto 201
      // 1ff: athrow
      // 200: bipush 1
      // 201: putstatic x/oc69da1aa7f5.Ҭ Z
      // 204: return
   }

   public static boolean Ѡ(EntityLivingBase param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc4a43182f3e.ϡ Z
      // 003: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 009: astore 2
      // 00a: istore 1
      // 00b: aload 2
      // 00c: iload 1
      // 00d: ifne 01b
      // 010: ifnonnull 01a
      // 013: goto 017
      // 016: athrow
      // 017: bipush 0
      // 018: ireturn
      // 019: athrow
      // 01a: aload 0
      // 01b: instanceof net/minecraft/entity/player/EntityPlayer
      // 01e: iload 1
      // 01f: ifne 0d9
      // 022: ifeq 0d6
      // 025: goto 029
      // 028: athrow
      // 029: aload 0
      // 02a: iload 1
      // 02b: ifne 03f
      // 02e: goto 032
      // 031: athrow
      // 032: aload 2
      // 033: if_acmpeq 0d6
      // 036: goto 03a
      // 039: athrow
      // 03a: aload 0
      // 03b: goto 03f
      // 03e: athrow
      // 03f: invokevirtual net/minecraft/entity/EntityLivingBase.getTeam ()Lnet/minecraft/scoreboard/Team;
      // 042: astore 3
      // 043: aload 2
      // 044: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getTeam ()Lnet/minecraft/scoreboard/Team;
      // 047: astore 4
      // 049: aload 3
      // 04a: iload 1
      // 04b: ifne 056
      // 04e: ifnull 0d6
      // 051: goto 055
      // 054: athrow
      // 055: aload 3
      // 056: invokevirtual net/minecraft/scoreboard/Team.getNameTagVisibility ()Lnet/minecraft/scoreboard/Team$EnumVisible;
      // 059: astore 5
      // 05b: getstatic x/oc3caca5ff3f.ǚ [I
      // 05e: aload 5
      // 060: invokevirtual net/minecraft/scoreboard/Team$EnumVisible.ordinal ()I
      // 063: iaload
      // 064: iload 1
      // 065: ifne 0d5
      // 068: tableswitch 108 1 4 33 36 72 108
      // 088: athrow
      // 089: bipush 0
      // 08a: ireturn
      // 08b: athrow
      // 08c: aload 4
      // 08e: iload 1
      // 08f: ifne 09a
      // 092: ifnull 0aa
      // 095: goto 099
      // 098: athrow
      // 099: aload 3
      // 09a: aload 4
      // 09c: invokevirtual net/minecraft/scoreboard/Team.isSameTeam (Lnet/minecraft/scoreboard/Team;)Z
      // 09f: iload 1
      // 0a0: ifne 0ab
      // 0a3: ifeq 0ae
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: bipush 1
      // 0ab: goto 0af
      // 0ae: bipush 0
      // 0af: ireturn
      // 0b0: aload 4
      // 0b2: iload 1
      // 0b3: ifne 0be
      // 0b6: ifnull 0ce
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aload 3
      // 0be: aload 4
      // 0c0: invokevirtual net/minecraft/scoreboard/Team.isSameTeam (Lnet/minecraft/scoreboard/Team;)Z
      // 0c3: iload 1
      // 0c4: ifne 0cf
      // 0c7: ifne 0d2
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: bipush 1
      // 0cf: goto 0d3
      // 0d2: bipush 0
      // 0d3: ireturn
      // 0d4: bipush 1
      // 0d5: ireturn
      // 0d6: invokestatic net/minecraft/client/Minecraft.isGuiEnabled ()Z
      // 0d9: ifeq 12c
      // 0dc: aload 0
      // 0dd: iload 1
      // 0de: ifne 0fa
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 0e8: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0eb: getfield net/minecraft/client/renderer/entity/RenderManager.livingPlayer Lnet/minecraft/entity/Entity;
      // 0ee: if_acmpeq 12c
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: aload 0
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: iload 1
      // 0fb: ifne 124
      // 0fe: instanceof net/minecraft/entity/item/EntityArmorStand
      // 101: ifne 11c
      // 104: goto 108
      // 107: athrow
      // 108: aload 0
      // 109: iload 1
      // 10a: ifne 124
      // 10d: goto 111
      // 110: athrow
      // 111: aload 2
      // 112: invokevirtual net/minecraft/entity/EntityLivingBase.isInvisibleToPlayer (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 115: ifne 12c
      // 118: goto 11c
      // 11b: athrow
      // 11c: aload 0
      // 11d: getfield net/minecraft/entity/EntityLivingBase.riddenByEntity Lnet/minecraft/entity/Entity;
      // 120: goto 124
      // 123: athrow
      // 124: ifnonnull 12c
      // 127: bipush 1
      // 128: goto 12d
      // 12b: athrow
      // 12c: bipush 0
      // 12d: ireturn
   }

   public static void ј() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc4a43182f3e.ϡ Z
      // 03: istore 0
      // 04: getstatic x/occc57954425.Ĥ Z
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifeq 18
      // 0e: goto 12
      // 11: athrow
      // 12: invokestatic x/oc4e1b577a95.Մ ()Z
      // 15: ifne 19
      // 18: return
      // 19: invokestatic x/oc4e1b577a95.Ɏ ()J
      // 1c: lstore 1
      // 1d: getstatic java/util/concurrent/TimeUnit.NANOSECONDS Ljava/util/concurrent/TimeUnit;
      // 20: invokestatic java/lang/System.nanoTime ()J
      // 23: invokevirtual java/util/concurrent/TimeUnit.toMillis (J)J
      // 26: lstore 3
      // 27: getstatic x/occc57954425.ԛ Ljava/util/concurrent/ConcurrentHashMap;
      // 2a: invokevirtual java/util/concurrent/ConcurrentHashMap.values ()Ljava/util/Collection;
      // 2d: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 32: astore 5
      // 34: aload 5
      // 36: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3b: ifeq e6
      // 3e: aload 5
      // 40: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 45: checkcast x/ocdec3856236
      // 48: astore 6
      // 4a: aload 6
      // 4c: iload 0
      // 4d: ifne b4
      // 50: getfield x/ocdec3856236.Ϡ I
      // 53: ifeq b2
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 6
      // 5c: iload 0
      // 5d: ifne b4
      // 60: goto 64
      // 63: athrow
      // 64: getfield x/ocdec3856236.Ϡ I
      // 67: ldc_w 1155824965
      // 6a: ldc_w 1155855650
      // 6d: ixor
      // 6e: invokestatic org/lwjgl/opengl/GL15.glGetQueryObjecti (II)I
      // 71: istore 7
      // 73: iload 7
      // 75: ifeq b2
      // 78: aload 6
      // 7a: aload 6
      // 7c: getfield x/ocdec3856236.Ϡ I
      // 7f: iload 0
      // 80: ifne 9d
      // 83: goto 87
      // 86: athrow
      // 87: ldc_w 1155824964
      // 8a: ldc_w 1155855650
      // 8d: ixor
      // 8e: invokestatic org/lwjgl/opengl/GL15.glGetQueryObjecti (II)I
      // 91: ifne a0
      // 94: goto 98
      // 97: athrow
      // 98: bipush 1
      // 99: goto 9d
      // 9c: athrow
      // 9d: goto a1
      // a0: bipush 0
      // a1: putfield x/ocdec3856236.с Z
      // a4: aload 6
      // a6: getfield x/ocdec3856236.Ϡ I
      // a9: invokestatic org/lwjgl/opengl/GL15.glDeleteQueries (I)V
      // ac: aload 6
      // ae: bipush 0
      // af: putfield x/ocdec3856236.Ϡ I
      // b2: aload 6
      // b4: getfield x/ocdec3856236.Ϡ I
      // b7: iload 0
      // b8: ifne cf
      // bb: ifne e2
      // be: goto c2
      // c1: athrow
      // c2: lload 3
      // c3: aload 6
      // c5: getfield x/ocdec3856236.Č J
      // c8: lsub
      // c9: lload 1
      // ca: lcmp
      // cb: goto cf
      // ce: athrow
      // cf: ifle e2
      // d2: aload 6
      // d4: lload 3
      // d5: putfield x/ocdec3856236.Č J
      // d8: aload 6
      // da: bipush 1
      // db: putfield x/ocdec3856236.Ք Z
      // de: goto e2
      // e1: athrow
      // e2: iload 0
      // e3: ifeq 34
      // e6: return
   }

   public static void ķ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc4a43182f3e.ϡ Z
      // 003: istore 0
      // 004: getstatic x/occc57954425.Ĥ Z
      // 007: iload 0
      // 008: ifne 015
      // 00b: ifeq 020
      // 00e: goto 012
      // 011: athrow
      // 012: invokestatic x/oc4e1b577a95.Մ ()Z
      // 015: iload 0
      // 016: ifne 032
      // 019: ifne 021
      // 01c: goto 020
      // 01f: athrow
      // 020: return
      // 021: getstatic x/occc57954425.Ѿ I
      // 024: bipush 1
      // 025: iadd
      // 026: iload 0
      // 027: ifne 03f
      // 02a: dup
      // 02b: putstatic x/occc57954425.Ѿ I
      // 02e: goto 032
      // 031: athrow
      // 032: ldc_w -1150992779
      // 035: ldc_w -1150992879
      // 038: ixor
      // 039: if_icmpge 03e
      // 03c: return
      // 03d: athrow
      // 03e: bipush 0
      // 03f: putstatic x/occc57954425.Ѿ I
      // 042: iload 0
      // 043: getstatic x/occc57954425.ԍ Lnet/minecraft/client/Minecraft;
      // 046: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 049: astore 1
      // 04a: ifne 05c
      // 04d: aload 1
      // 04e: ifnonnull 05d
      // 051: goto 055
      // 054: athrow
      // 055: invokestatic x/occc57954425.ó ()V
      // 058: goto 05c
      // 05b: athrow
      // 05c: return
      // 05d: new java/util/HashSet
      // 060: dup
      // 061: invokespecial java/util/HashSet.<init> ()V
      // 064: astore 2
      // 065: aload 1
      // 066: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 069: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 06e: astore 3
      // 06f: aload 3
      // 070: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 075: ifeq 093
      // 078: aload 3
      // 079: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 07e: checkcast net/minecraft/entity/Entity
      // 081: astore 4
      // 083: iload 0
      // 084: aload 2
      // 085: aload 4
      // 087: invokevirtual net/minecraft/entity/Entity.getUniqueID ()Ljava/util/UUID;
      // 08a: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 08f: pop
      // 090: ifeq 06f
      // 093: new java/util/ArrayList
      // 096: dup
      // 097: invokespecial java/util/ArrayList.<init> ()V
      // 09a: astore 3
      // 09b: getstatic x/occc57954425.ԛ Ljava/util/concurrent/ConcurrentHashMap;
      // 09e: invokevirtual java/util/concurrent/ConcurrentHashMap.values ()Ljava/util/Collection;
      // 0a1: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0a6: astore 4
      // 0a8: aload 4
      // 0aa: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0af: ifeq 111
      // 0b2: aload 4
      // 0b4: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0b9: checkcast x/ocdec3856236
      // 0bc: astore 5
      // 0be: iload 0
      // 0bf: ifne 119
      // 0c2: iload 0
      // 0c3: ifne 0f8
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: aload 2
      // 0cb: aload 5
      // 0cd: getfield x/ocdec3856236.Ի Ljava/util/UUID;
      // 0d0: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 0d5: ifeq 0e4
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: iload 0
      // 0dd: ifeq 0a8
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: aload 3
      // 0e5: aload 5
      // 0e7: getfield x/ocdec3856236.Ի Ljava/util/UUID;
      // 0ea: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0ef: iload 0
      // 0f0: ifne 105
      // 0f3: pop
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: aload 5
      // 0fa: getfield x/ocdec3856236.Ϡ I
      // 0fd: ifeq 10d
      // 100: aload 5
      // 102: getfield x/ocdec3856236.Ϡ I
      // 105: invokestatic org/lwjgl/opengl/GL15.glDeleteQueries (I)V
      // 108: goto 10d
      // 10b: astore 6
      // 10d: iload 0
      // 10e: ifeq 0a8
      // 111: aload 3
      // 112: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 117: astore 4
      // 119: aload 4
      // 11b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 120: ifeq 13c
      // 123: aload 4
      // 125: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 12a: checkcast java/util/UUID
      // 12d: astore 5
      // 12f: iload 0
      // 130: getstatic x/occc57954425.ԛ Ljava/util/concurrent/ConcurrentHashMap;
      // 133: aload 5
      // 135: invokevirtual java/util/concurrent/ConcurrentHashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 138: pop
      // 139: ifeq 119
      // 13c: return
   }

   static {
      boolean var0 = false;

      try {
         var0 = GLContext.getCapabilities().OpenGL33;
      } catch (Throwable var2) {
      }

      ţ = var0;
   }
}
