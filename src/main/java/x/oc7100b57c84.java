package x;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class oc7100b57c84 {
   private static final String[] Ǯ;
   private static final String[] ů;
   private final occ39d36078d Ü;
   private final oca9cc61aada Ɉ = new oca9cc61aada("Next backtrack delay", "ms", 0.0, 0.0, 2000.0, 10.0);
   private final oca9cc61aada ӓ = new oca9cc61aada("Max delay", "ms", 80.0, 0.0, 2000.0, 10.0);
   private final oca9cc61aada ŋ = new oca9cc61aada("Min delay", "ms", 80.0, 0.0, 2000.0, 10.0);
   private final oca9cc61aada ԏ = new oca9cc61aada("Distance min", 2.0, 0.0, 6.0, 0.1);
   private final oca9cc61aada К = new oca9cc61aada("Distance max", 3.0, 0.0, 6.0, 0.1);
   private final occ2f8dff8d8 Ś = new occ2f8dff8d8("Smart", true);
   private final oca9cc61aada շ;
   private final oca9cc61aada ª;
   private final oc24a0a5bddf Ҽ;
   private final ConcurrentLinkedQueue<oc88f4868161> Ї;
   private final ConcurrentLinkedDeque<oc47ee786826> ө;
   private final AtomicLong з;
   private final ocab3a64a31e Φ;
   private EntityLivingBase ϼ;
   private long Ȅ;
   private int ň;
   private boolean щ;
   private boolean ɗ;
   private boolean Â;
   public static int Ԉ;

   public oc7100b57c84(occ39d36078d var1) {
      this.շ = new oca9cc61aada("ESP mode", 1, Ǯ);
      this.ª = new oca9cc61aada("Color mode", 1, ů);
      this.Ҽ = new oc24a0a5bddf("ESP color", 0, 1565939181 ^ 1565938962, 0);
      this.Ї = new ConcurrentLinkedQueue<>();
      this.ө = new ConcurrentLinkedDeque<>();
      this.з = new AtomicLong();
      this.Φ = new ocab3a64a31e();
      this.щ = true;
      this.Ü = var1;
      var1.z$1k81rl22ylo65(this.Ɉ, "setting.028");
      var1.z$1k81rl22ylo65(this.ӓ, "setting.029");
      var1.z$1k81rl22ylo65(this.ŋ, "setting.030");
      var1.z$1k81rl22ylo65(this.ԏ, "setting.031");
      var1.z$1k81rl22ylo65(this.К, "setting.032");
      var1.z$1k81rl22ylo65(this.Ś, "setting.033");
      var1.z$1k81rl22ylo65(this.շ, "setting.034");
      var1.z$1k81rl22ylo65(this.ª, "setting.035");
      var1.z$1k81rl22ylo65(this.Ҽ, "setting.036");
      this.minQ();
   }

   public void д(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc7100b57c84.Ɉ Lx/oca9cc61aada;
      // 07: iload 1
      // 08: aload 0
      // 09: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 0c: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0f: istore 2
      // 10: aload 0
      // 11: getfield x/oc7100b57c84.ӓ Lx/oca9cc61aada;
      // 14: iload 1
      // 15: aload 0
      // 16: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 19: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1c: aload 0
      // 1d: getfield x/oc7100b57c84.ŋ Lx/oca9cc61aada;
      // 20: iload 1
      // 21: iload 2
      // 22: ifne 74
      // 25: aload 0
      // 26: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 29: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 2c: aload 0
      // 2d: getfield x/oc7100b57c84.ԏ Lx/oca9cc61aada;
      // 30: iload 1
      // 31: aload 0
      // 32: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 35: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 38: aload 0
      // 39: getfield x/oc7100b57c84.К Lx/oca9cc61aada;
      // 3c: iload 1
      // 3d: aload 0
      // 3e: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 41: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 44: aload 0
      // 45: getfield x/oc7100b57c84.Ś Lx/occ2f8dff8d8;
      // 48: iload 1
      // 49: aload 0
      // 4a: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 4d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 50: aload 0
      // 51: getfield x/oc7100b57c84.շ Lx/oca9cc61aada;
      // 54: iload 1
      // 55: aload 0
      // 56: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 59: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 5c: aload 0
      // 5d: getfield x/oc7100b57c84.ª Lx/oca9cc61aada;
      // 60: iload 1
      // 61: ifeq 88
      // 64: goto 68
      // 67: athrow
      // 68: aload 0
      // 69: getfield x/oc7100b57c84.շ Lx/oca9cc61aada;
      // 6c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 6f: d2i
      // 70: goto 74
      // 73: athrow
      // 74: iload 2
      // 75: ifne 85
      // 78: bipush 1
      // 79: if_icmpne 88
      // 7c: goto 80
      // 7f: athrow
      // 80: bipush 1
      // 81: goto 85
      // 84: athrow
      // 85: goto 89
      // 88: bipush 0
      // 89: aload 0
      // 8a: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 8d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 90: aload 0
      // 91: getfield x/oc7100b57c84.Ҽ Lx/oc24a0a5bddf;
      // 94: iload 1
      // 95: iload 2
      // 96: ifne b4
      // 99: ifeq d3
      // 9c: goto a0
      // 9f: athrow
      // a0: aload 0
      // a1: getfield x/oc7100b57c84.շ Lx/oca9cc61aada;
      // a4: iload 2
      // a5: ifne c0
      // a8: goto ac
      // ab: athrow
      // ac: invokevirtual x/oca9cc61aada.Ӂ ()D
      // af: d2i
      // b0: goto b4
      // b3: athrow
      // b4: bipush 1
      // b5: if_icmpne d3
      // b8: aload 0
      // b9: getfield x/oc7100b57c84.ª Lx/oca9cc61aada;
      // bc: goto c0
      // bf: athrow
      // c0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // c3: d2i
      // c4: iload 2
      // c5: ifne d0
      // c8: ifne d3
      // cb: goto cf
      // ce: athrow
      // cf: bipush 1
      // d0: goto d4
      // d3: bipush 0
      // d4: aload 0
      // d5: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // d8: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // db: return
   }

   public void ԡ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: aload 1
      // 004: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 1
      // 00a: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 00d: iload 2
      // 00e: ifne 028
      // 011: ifne 02b
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: iload 2
      // 01a: ifne 02d
      // 01d: goto 021
      // 020: athrow
      // 021: invokevirtual x/oc7100b57c84.Ï ()Z
      // 024: goto 028
      // 027: athrow
      // 028: ifeq 02c
      // 02b: return
      // 02c: aload 0
      // 02d: iload 2
      // 02e: ifne 04d
      // 031: invokevirtual x/oc7100b57c84.Ѩ ()Z
      // 034: ifne 04c
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: bipush 1
      // 03d: bipush 1
      // 03e: invokevirtual x/oc7100b57c84.Ǔ (ZZ)V
      // 041: aload 0
      // 042: invokevirtual x/oc7100b57c84.I ()V
      // 045: aload 0
      // 046: aconst_null
      // 047: putfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 04a: return
      // 04b: athrow
      // 04c: aload 0
      // 04d: iload 2
      // 04e: ifne 05f
      // 051: aload 3
      // 052: invokevirtual x/oc7100b57c84.Ɇ (Lnet/minecraft/network/Packet;)Z
      // 055: ifeq 05e
      // 058: goto 05c
      // 05b: athrow
      // 05c: return
      // 05d: athrow
      // 05e: aload 0
      // 05f: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 062: invokevirtual x/ocab3a64a31e.һ ()Z
      // 065: iload 2
      // 066: ifne 09e
      // 069: ifne 09a
      // 06c: goto 070
      // 06f: athrow
      // 070: aload 0
      // 071: getfield x/oc7100b57c84.Ї Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 074: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.isEmpty ()Z
      // 077: iload 2
      // 078: ifne 09e
      // 07b: goto 07f
      // 07e: athrow
      // 07f: ifeq 09a
      // 082: goto 086
      // 085: athrow
      // 086: aload 0
      // 087: invokevirtual x/oc7100b57c84.U ()Z
      // 08a: iload 2
      // 08b: ifne 09e
      // 08e: goto 092
      // 091: athrow
      // 092: ifeq 09a
      // 095: goto 099
      // 098: athrow
      // 099: return
      // 09a: aload 3
      // 09b: invokestatic x/occ39d36078d.Ժ (Lnet/minecraft/network/Packet;)Z
      // 09e: iload 2
      // 09f: ifne 0ba
      // 0a2: ifne 0bd
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 0
      // 0aa: iload 2
      // 0ab: ifne 0bf
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: aload 3
      // 0b3: invokevirtual x/oc7100b57c84.ɐ (Lnet/minecraft/network/Packet;)Z
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: ifeq 0be
      // 0bd: return
      // 0be: aload 0
      // 0bf: iload 2
      // 0c0: ifne 171
      // 0c3: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0c6: ifnull 16b
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: aload 3
      // 0ce: iload 2
      // 0cf: ifne 104
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: instanceof net/minecraft/network/play/server/S14PacketEntity
      // 0d9: ifeq 0ff
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: aload 3
      // 0e1: iload 2
      // 0e2: ifne 104
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: checkcast x/oc1553ad102e
      // 0ec: invokeinterface x/oc1553ad102e.getEntityId ()I 1
      // 0f1: aload 0
      // 0f2: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0f5: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 0f8: if_icmpeq 12f
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: aload 3
      // 100: goto 104
      // 103: athrow
      // 104: instanceof net/minecraft/network/play/server/S18PacketEntityTeleport
      // 107: iload 2
      // 108: ifne 189
      // 10b: ifeq 16b
      // 10e: goto 112
      // 111: athrow
      // 112: aload 3
      // 113: checkcast net/minecraft/network/play/server/S18PacketEntityTeleport
      // 116: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getEntityId ()I
      // 119: iload 2
      // 11a: ifne 189
      // 11d: goto 121
      // 120: athrow
      // 121: aload 0
      // 122: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 125: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 128: if_icmpne 16b
      // 12b: goto 12f
      // 12e: athrow
      // 12f: aload 0
      // 130: iload 2
      // 131: ifne 171
      // 134: goto 138
      // 137: athrow
      // 138: aload 0
      // 139: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 13c: invokevirtual x/oc7100b57c84.Ę (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 13f: astore 4
      // 141: aload 4
      // 143: ifnull 16b
      // 146: aload 0
      // 147: getfield x/oc7100b57c84.ө Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 14a: new x/oc47ee786826
      // 14d: dup
      // 14e: aload 4
      // 150: getfield net/minecraft/util/Vec3.xCoord D
      // 153: aload 4
      // 155: getfield net/minecraft/util/Vec3.yCoord D
      // 158: aload 4
      // 15a: getfield net/minecraft/util/Vec3.zCoord D
      // 15d: invokestatic java/lang/System.currentTimeMillis ()J
      // 160: invokespecial x/oc47ee786826.<init> (DDDJ)V
      // 163: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.offerLast (Ljava/lang/Object;)Z
      // 166: pop
      // 167: goto 16b
      // 16a: athrow
      // 16b: aload 1
      // 16c: bipush 1
      // 16d: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 170: aload 0
      // 171: getfield x/oc7100b57c84.Ї Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 174: new x/oc88f4868161
      // 177: dup
      // 178: aload 3
      // 179: invokestatic java/lang/System.currentTimeMillis ()J
      // 17c: aload 0
      // 17d: getfield x/oc7100b57c84.з Ljava/util/concurrent/atomic/AtomicLong;
      // 180: invokevirtual java/util/concurrent/atomic/AtomicLong.incrementAndGet ()J
      // 183: invokespecial x/oc88f4868161.<init> (Lnet/minecraft/network/Packet;JJ)V
      // 186: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.offer (Ljava/lang/Object;)Z
      // 189: pop
      // 18a: return
   }

   public void ʀ(oc9374123646 var1) {
      this.ǔ();
      this.ɗ = false;
   }

   public void ǥ(ocd47efa9be3 param1) {
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
      // 05: getfield x/ocd47efa9be3.β Lnet/minecraft/entity/player/EntityPlayer;
      // 08: aload 0
      // 09: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 0c: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f: if_acmpne 29
      // 12: aload 0
      // 13: iload 2
      // 14: ifne 2c
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 1
      // 1c: getfield x/ocd47efa9be3.ϊ Lnet/minecraft/entity/Entity;
      // 1f: invokevirtual x/oc7100b57c84.Ǌ (Lnet/minecraft/entity/Entity;)Z
      // 22: ifne 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: aload 0
      // 2c: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 2f: iload 2
      // 30: ifne 50
      // 33: aload 1
      // 34: getfield x/ocd47efa9be3.ϊ Lnet/minecraft/entity/Entity;
      // 37: if_acmpeq 4c
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: bipush 1
      // 40: bipush 1
      // 41: invokevirtual x/oc7100b57c84.Ǔ (ZZ)V
      // 44: aload 0
      // 45: invokevirtual x/oc7100b57c84.Ւ ()V
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 1
      // 4d: getfield x/ocd47efa9be3.ϊ Lnet/minecraft/entity/Entity;
      // 50: instanceof net/minecraft/entity/EntityLivingBase
      // 53: ifeq 69
      // 56: aload 0
      // 57: aload 1
      // 58: getfield x/ocd47efa9be3.ϊ Lnet/minecraft/entity/Entity;
      // 5b: checkcast net/minecraft/entity/EntityLivingBase
      // 5e: putfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 61: aload 0
      // 62: invokevirtual x/oc7100b57c84.Ў ()V
      // 65: goto 69
      // 68: athrow
      // 69: return
   }

   public void Ñ(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 018
      // 009: invokevirtual x/oc7100b57c84.i ()Z
      // 00c: ifeq 068
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: goto 018
      // 017: athrow
      // 018: iload 2
      // 019: ifne 02b
      // 01c: getfield x/oc7100b57c84.щ Z
      // 01f: ifeq 068
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: goto 02b
      // 02a: athrow
      // 02b: iload 2
      // 02c: ifne 03e
      // 02f: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 032: ifnull 068
      // 035: goto 039
      // 038: athrow
      // 039: aload 0
      // 03a: goto 03e
      // 03d: athrow
      // 03e: iload 2
      // 03f: ifne 055
      // 042: aload 0
      // 043: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 046: invokevirtual x/oc7100b57c84.Ɠ (Lnet/minecraft/entity/Entity;)Z
      // 049: ifeq 068
      // 04c: goto 050
      // 04f: athrow
      // 050: aload 0
      // 051: goto 055
      // 054: athrow
      // 055: iload 2
      // 056: ifne 06b
      // 059: getfield x/oc7100b57c84.շ Lx/oca9cc61aada;
      // 05c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 05f: d2i
      // 060: bipush 1
      // 061: if_icmpeq 06a
      // 064: goto 068
      // 067: athrow
      // 068: return
      // 069: athrow
      // 06a: aload 0
      // 06b: aload 0
      // 06c: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 06f: invokevirtual x/oc7100b57c84.ƞ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 072: astore 3
      // 073: aload 3
      // 074: getfield net/minecraft/util/Vec3.xCoord D
      // 077: aload 0
      // 078: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 07b: invokevirtual x/occ39d36078d.Ҝ ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 07e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 081: dsub
      // 082: dstore 4
      // 084: aload 3
      // 085: getfield net/minecraft/util/Vec3.yCoord D
      // 088: aload 0
      // 089: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 08c: invokevirtual x/occ39d36078d.Ҝ ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 08f: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 092: dsub
      // 093: dstore 6
      // 095: aload 3
      // 096: getfield net/minecraft/util/Vec3.zCoord D
      // 099: aload 0
      // 09a: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 09d: invokevirtual x/occ39d36078d.Ҝ ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0a0: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 0a3: dsub
      // 0a4: dstore 8
      // 0a6: aload 0
      // 0a7: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0aa: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0ad: dload 4
      // 0af: aload 0
      // 0b0: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0b3: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 0b6: dsub
      // 0b7: dload 6
      // 0b9: aload 0
      // 0ba: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0bd: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 0c0: dsub
      // 0c1: dload 8
      // 0c3: aload 0
      // 0c4: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0c7: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 0ca: dsub
      // 0cb: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0ce: astore 10
      // 0d0: aload 0
      // 0d1: getfield x/oc7100b57c84.ª Lx/oca9cc61aada;
      // 0d4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d7: d2i
      // 0d8: bipush 1
      // 0d9: if_icmpne 0eb
      // 0dc: new java/awt/Color
      // 0df: dup
      // 0e0: dconst_0
      // 0e1: invokestatic x/ocd2958dac48.ů (D)I
      // 0e4: invokespecial java/awt/Color.<init> (I)V
      // 0e7: goto 0f9
      // 0ea: athrow
      // 0eb: new java/awt/Color
      // 0ee: dup
      // 0ef: aload 0
      // 0f0: getfield x/oc7100b57c84.Ҽ Lx/oc24a0a5bddf;
      // 0f3: invokevirtual x/oc24a0a5bddf.ǐ ()I
      // 0f6: invokespecial java/awt/Color.<init> (I)V
      // 0f9: astore 11
      // 0fb: aload 10
      // 0fd: aload 11
      // 0ff: invokestatic x/ocbd4917c4b1.H (Lnet/minecraft/util/AxisAlignedBB;Ljava/awt/Color;)V
      // 102: return
   }

   public void ɱ(boolean var1) {
      this.Ǔ(var1, true);
      this.ϼ = null;
      this.ɗ = false;
      this.I();
   }

   public int Ɣ() {
      return this.ň;
   }

   public EntityLivingBase М() {
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
      // 06: ifne 18
      // 09: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0c: ifnull 47
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2e
      // 1c: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 1f: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 22: ifne 47
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 1
      // 2f: ifne 41
      // 32: invokevirtual x/oc7100b57c84.Ɣ ()I
      // 35: ifle 47
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 0
      // 3d: goto 41
      // 40: athrow
      // 41: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 44: goto 48
      // 47: aconst_null
      // 48: areturn
   }

   public Vec3 ê() {
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
      // 06: ifne 19
      // 09: invokevirtual x/oc7100b57c84.М ()Lnet/minecraft/entity/EntityLivingBase;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: aconst_null
      // 14: goto 20
      // 17: athrow
      // 18: aload 0
      // 19: aload 0
      // 1a: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 1d: invokevirtual x/oc7100b57c84.Ę (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 20: areturn
   }

   private void ǔ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic java/lang/System.currentTimeMillis ()J
      // 06: lstore 2
      // 07: istore 1
      // 08: aload 0
      // 09: lload 2
      // 0a: invokevirtual x/oc7100b57c84.ҽ (J)V
      // 0d: aload 0
      // 0e: iload 1
      // 0f: ifne 45
      // 12: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 15: invokevirtual x/ocab3a64a31e.һ ()Z
      // 18: ifne 44
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: getfield x/oc7100b57c84.Ї Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 23: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.isEmpty ()Z
      // 26: iload 1
      // 27: ifne 40
      // 2a: goto 2e
      // 2d: athrow
      // 2e: ifne 3f
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: bipush 1
      // 37: bipush 0
      // 38: invokevirtual x/oc7100b57c84.Ǔ (ZZ)V
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush 0
      // 40: putstatic x/occ39d36078d.ž Z
      // 43: return
      // 44: aload 0
      // 45: iload 1
      // 46: ifne 5c
      // 49: invokevirtual x/oc7100b57c84.Ӟ ()Z
      // 4c: ifne 5b
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: lload 2
      // 55: bipush 1
      // 56: invokevirtual x/oc7100b57c84.Ķ (JZ)V
      // 59: return
      // 5a: athrow
      // 5b: aload 0
      // 5c: bipush 1
      // 5d: putfield x/oc7100b57c84.щ Z
      // 60: bipush 1
      // 61: putstatic x/occ39d36078d.ž Z
      // 64: return
   }

   private boolean Ӟ() {
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
      // 05: invokevirtual x/oc7100b57c84.i ()Z
      // 08: iload 1
      // 09: ifne 55
      // 0c: ifeq 50
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 2b
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 1f: ifnull 50
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 2f: invokevirtual x/oc7100b57c84.Ɠ (Lnet/minecraft/entity/Entity;)Z
      // 32: iload 1
      // 33: ifne 55
      // 36: ifeq 50
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: iload 1
      // 3f: ifne 57
      // 42: goto 46
      // 45: athrow
      // 46: invokevirtual x/oc7100b57c84.Ï ()Z
      // 49: ifeq 56
      // 4c: goto 50
      // 4f: athrow
      // 50: bipush 0
      // 51: goto 55
      // 54: athrow
      // 55: ireturn
      // 56: aload 0
      // 57: aload 0
      // 58: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 5b: invokevirtual x/oc7100b57c84.Ę (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 5e: astore 2
      // 5f: aload 0
      // 60: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 63: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 66: aload 2
      // 67: getfield net/minecraft/util/Vec3.xCoord D
      // 6a: aload 2
      // 6b: getfield net/minecraft/util/Vec3.yCoord D
      // 6e: aload 2
      // 6f: getfield net/minecraft/util/Vec3.zCoord D
      // 72: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistance (DDD)D
      // 75: dstore 3
      // 76: aload 0
      // 77: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 7a: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7d: aload 0
      // 7e: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 81: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 84: aload 0
      // 85: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 88: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 8b: aload 0
      // 8c: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 8f: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 92: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistance (DDD)D
      // 95: dstore 5
      // 97: aload 0
      // 98: getfield x/oc7100b57c84.Ś Lx/occ2f8dff8d8;
      // 9b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 9e: dload 3
      // 9f: dload 5
      // a1: aload 0
      // a2: aload 0
      // a3: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // a6: aload 2
      // a7: invokevirtual x/oc7100b57c84.ӷ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)D
      // aa: aload 0
      // ab: invokevirtual x/oc7100b57c84.Ȇ ()D
      // ae: invokestatic x/oc4e962be445.ȟ (ZDDDD)Z
      // b1: ireturn
   }

   private void Ў() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic java/lang/System.currentTimeMillis ()J
      // 06: lstore 2
      // 07: istore 1
      // 08: aload 0
      // 09: lload 2
      // 0a: invokevirtual x/oc7100b57c84.ҽ (J)V
      // 0d: aload 0
      // 0e: iload 1
      // 0f: ifne 21
      // 12: invokevirtual x/oc7100b57c84.Ѩ ()Z
      // 15: ifeq 8d
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: goto 21
      // 20: athrow
      // 21: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 24: iload 1
      // 25: ifne 47
      // 28: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHealth ()F
      // 2e: fconst_0
      // 2f: fcmpg
      // 30: ifle 8d
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: iload 1
      // 39: ifne 52
      // 3c: goto 40
      // 3f: athrow
      // 40: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 43: goto 47
      // 46: athrow
      // 47: invokevirtual x/occ39d36078d.ԍ ()Z
      // 4a: ifne 8d
      // 4d: aload 0
      // 4e: goto 52
      // 51: athrow
      // 52: iload 1
      // 53: ifne 72
      // 56: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 59: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5c: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 5f: ldc_w 360668375
      // 62: ldc_w 360668355
      // 65: ixor
      // 66: if_icmple 8d
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 0
      // 6e: goto 72
      // 71: athrow
      // 72: invokevirtual x/oc7100b57c84.Ï ()Z
      // 75: iload 1
      // 76: ifne 8a
      // 79: ifne 8d
      // 7c: goto 80
      // 7f: athrow
      // 80: lload 2
      // 81: aload 0
      // 82: getfield x/oc7100b57c84.Ȅ J
      // 85: lcmp
      // 86: goto 8a
      // 89: athrow
      // 8a: ifge 8e
      // 8d: return
      // 8e: aload 0
      // 8f: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 92: lload 2
      // 93: aload 0
      // 94: invokevirtual x/oc7100b57c84.Ң ()I
      // 97: i2l
      // 98: invokevirtual x/ocab3a64a31e.Ǫ (JJ)V
      // 9b: return
   }

   private boolean Ɇ(Packet<?> param1) {
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
      // 05: instanceof net/minecraft/network/play/server/S19PacketEntityStatus
      // 08: iload 2
      // 09: ifne 23
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 17: ifnonnull 24
      // 1a: goto 1e
      // 1d: athrow
      // 1e: bipush 0
      // 1f: goto 23
      // 22: athrow
      // 23: ireturn
      // 24: aload 1
      // 25: checkcast net/minecraft/network/play/server/S19PacketEntityStatus
      // 28: astore 3
      // 29: aload 3
      // 2a: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getOpCode ()B
      // 2d: iload 2
      // 2e: ifne 5a
      // 31: ldc_w -1820289415
      // 34: ldc_w -1820289413
      // 37: ixor
      // 38: if_icmpne 55
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 3
      // 40: aload 0
      // 41: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 44: invokevirtual x/occ39d36078d.ӣ ()Lnet/minecraft/world/World;
      // 47: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getEntity (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 4a: aload 0
      // 4b: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 4e: if_acmpeq 5b
      // 51: goto 55
      // 54: athrow
      // 55: bipush 0
      // 56: goto 5a
      // 59: athrow
      // 5a: ireturn
      // 5b: invokestatic java/lang/System.currentTimeMillis ()J
      // 5e: lstore 4
      // 60: aload 0
      // 61: lload 4
      // 63: invokevirtual x/oc7100b57c84.ҽ (J)V
      // 66: aload 0
      // 67: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 6a: iload 2
      // 6b: ifne 9b
      // 6e: lload 4
      // 70: aload 0
      // 71: invokevirtual x/oc7100b57c84.ɾ ()I
      // 74: i2l
      // 75: invokevirtual x/ocab3a64a31e.Ӭ (JJ)Z
      // 78: ifne 82
      // 7b: goto 7f
      // 7e: athrow
      // 7f: bipush 1
      // 80: ireturn
      // 81: athrow
      // 82: aload 0
      // 83: bipush 0
      // 84: putfield x/oc7100b57c84.Â Z
      // 87: aload 0
      // 88: bipush 0
      // 89: putfield x/oc7100b57c84.ɗ Z
      // 8c: aload 0
      // 8d: aload 0
      // 8e: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 91: invokevirtual x/ocab3a64a31e.һ ()Z
      // 94: putfield x/oc7100b57c84.щ Z
      // 97: aload 0
      // 98: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 9b: invokevirtual x/ocab3a64a31e.һ ()Z
      // 9e: putstatic x/occ39d36078d.ž Z
      // a1: bipush 1
      // a2: ireturn
   }

   private void ҽ(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 07: lload 1
      // 08: invokevirtual x/ocab3a64a31e.Ѣ (J)Z
      // 0b: pop
      // 0c: istore 3
      // 0d: aload 0
      // 0e: iload 3
      // 0f: ifne 37
      // 12: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 15: lload 1
      // 16: invokevirtual x/ocab3a64a31e.ɵ (J)Z
      // 19: ifeq 36
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: bipush 1
      // 22: bipush 0
      // 23: invokevirtual x/oc7100b57c84.Ǔ (ZZ)V
      // 26: aload 0
      // 27: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 2a: invokevirtual x/ocab3a64a31e.Ȍ ()V
      // 2d: aload 0
      // 2e: bipush 1
      // 2f: putfield x/oc7100b57c84.Â Z
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: iload 3
      // 38: ifne 4a
      // 3b: getfield x/oc7100b57c84.Â Z
      // 3e: ifeq 7f
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: goto 4a
      // 49: athrow
      // 4a: iload 3
      // 4b: ifne 60
      // 4e: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 51: invokevirtual x/ocab3a64a31e.Æ ()Z
      // 54: ifne 7f
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 0
      // 5c: goto 60
      // 5f: athrow
      // 60: iload 3
      // 61: ifne 7b
      // 64: getfield x/oc7100b57c84.Φ Lx/ocab3a64a31e;
      // 67: invokevirtual x/ocab3a64a31e.һ ()Z
      // 6a: ifne 7f
      // 6d: goto 71
      // 70: athrow
      // 71: aload 0
      // 72: lload 1
      // 73: invokevirtual x/oc7100b57c84.ճ (J)V
      // 76: aload 0
      // 77: goto 7b
      // 7a: athrow
      // 7b: bipush 0
      // 7c: putfield x/oc7100b57c84.Â Z
      // 7f: return
   }

   private void Ķ(long var1, boolean var3) {
      int var10000 = oc75d51ec7eb.ϩ;
      boolean var5 = this.Φ.һ();
      this.Ǔ(true, false);
      int var4 = var10000;

      label26: {
         try {
            this.Φ.Ŀ();
            this.Â = false;
            var8 = var3;
            if (var4 != 0) {
               break label26;
            }

            if (!var3) {
               return;
            }
         } catch (NumberFormatException var7) {
            throw var7;
         }

         var8 = var5;
      }

      try {
         if (var8) {
            this.ճ(var1);
         }
      } catch (NumberFormatException var6) {
         throw var6;
      }
   }

   private void ճ(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: lconst_0
      // 04: aload 0
      // 05: getfield x/oc7100b57c84.Ɉ Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2l
      // 0c: invokestatic java/lang/Math.max (JJ)J
      // 0f: lstore 4
      // 11: istore 3
      // 12: aload 0
      // 13: lload 1
      // 14: ldc2_w 2808132401074834069
      // 17: ldc2_w 6415239635779941738
      // 1a: lxor
      // 1b: iload 3
      // 1c: ifne 38
      // 1f: lload 4
      // 21: lsub
      // 22: lcmp
      // 23: ifle 35
      // 26: goto 2a
      // 29: athrow
      // 2a: ldc2_w 2808132401074834069
      // 2d: ldc2_w 6415239635779941738
      // 30: lxor
      // 31: goto 39
      // 34: athrow
      // 35: lload 1
      // 36: lload 4
      // 38: ladd
      // 39: putfield x/oc7100b57c84.Ȅ J
      // 3c: aload 0
      // 3d: invokevirtual x/oc7100b57c84.minQ ()V
      // 40: return
   }

   private int Ң() {
      return Math.max(591556910 ^ 591557048, Math.min(591556684 ^ 591557048, this.ɾ() + (591556910 ^ 591557048)));
   }

   private boolean ɐ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 039
      // 009: instanceof net/minecraft/network/play/server/S06PacketUpdateHealth
      // 00c: ifeq 038
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: checkcast net/minecraft/network/play/server/S06PacketUpdateHealth
      // 017: iload 2
      // 018: ifne 039
      // 01b: goto 01f
      // 01e: athrow
      // 01f: invokevirtual net/minecraft/network/play/server/S06PacketUpdateHealth.getHealth ()F
      // 022: fconst_0
      // 023: fcmpg
      // 024: ifgt 038
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 0
      // 02c: bipush 1
      // 02d: bipush 1
      // 02e: invokevirtual x/oc7100b57c84.Ǔ (ZZ)V
      // 031: aload 0
      // 032: invokevirtual x/oc7100b57c84.I ()V
      // 035: bipush 1
      // 036: ireturn
      // 037: athrow
      // 038: aload 1
      // 039: iload 2
      // 03a: ifne 09f
      // 03d: instanceof net/minecraft/network/play/server/S13PacketDestroyEntities
      // 040: ifeq 09e
      // 043: goto 047
      // 046: athrow
      // 047: aload 0
      // 048: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 04b: ifnull 09e
      // 04e: goto 052
      // 051: athrow
      // 052: aload 1
      // 053: checkcast net/minecraft/network/play/server/S13PacketDestroyEntities
      // 056: invokevirtual net/minecraft/network/play/server/S13PacketDestroyEntities.getEntityIDs ()[I
      // 059: astore 3
      // 05a: aload 3
      // 05b: arraylength
      // 05c: istore 4
      // 05e: bipush 0
      // 05f: istore 5
      // 061: iload 5
      // 063: iload 4
      // 065: if_icmpge 09e
      // 068: aload 3
      // 069: iload 5
      // 06b: iaload
      // 06c: istore 6
      // 06e: iload 2
      // 06f: ifne 176
      // 072: iload 2
      // 073: ifne 09a
      // 076: goto 07a
      // 079: athrow
      // 07a: iload 6
      // 07c: aload 0
      // 07d: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 080: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 083: if_icmpne 097
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 0
      // 08b: bipush 1
      // 08c: bipush 1
      // 08d: invokevirtual x/oc7100b57c84.Ǔ (ZZ)V
      // 090: aload 0
      // 091: invokevirtual x/oc7100b57c84.Ւ ()V
      // 094: bipush 1
      // 095: ireturn
      // 096: athrow
      // 097: iinc 5 1
      // 09a: iload 2
      // 09b: ifeq 061
      // 09e: aload 1
      // 09f: iload 2
      // 0a0: ifne 177
      // 0a3: instanceof net/minecraft/network/play/server/S1CPacketEntityMetadata
      // 0a6: ifeq 176
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: aload 0
      // 0ae: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0b1: ifnull 176
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: aload 1
      // 0b9: checkcast net/minecraft/network/play/server/S1CPacketEntityMetadata
      // 0bc: iload 2
      // 0bd: ifne 177
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: invokevirtual net/minecraft/network/play/server/S1CPacketEntityMetadata.getEntityId ()I
      // 0c7: aload 0
      // 0c8: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 0cb: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 0ce: if_icmpne 176
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 1
      // 0d6: checkcast net/minecraft/network/play/server/S1CPacketEntityMetadata
      // 0d9: invokevirtual net/minecraft/network/play/server/S1CPacketEntityMetadata.func_149376_c ()Ljava/util/List;
      // 0dc: astore 3
      // 0dd: aload 3
      // 0de: iload 2
      // 0df: ifne 0ed
      // 0e2: ifnonnull 0ec
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: bipush 1
      // 0ea: ireturn
      // 0eb: athrow
      // 0ec: aload 3
      // 0ed: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0f2: astore 4
      // 0f4: aload 4
      // 0f6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0fb: ifeq 174
      // 0fe: aload 4
      // 100: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 105: checkcast net/minecraft/entity/DataWatcher$WatchableObject
      // 108: astore 5
      // 10a: aload 5
      // 10c: iload 2
      // 10d: ifne 12e
      // 110: invokevirtual net/minecraft/entity/DataWatcher$WatchableObject.getDataValueId ()I
      // 113: iload 2
      // 114: ifne 175
      // 117: goto 11b
      // 11a: athrow
      // 11b: ldc_w -39234915
      // 11e: ldc_w -39234917
      // 121: ixor
      // 122: if_icmpne 170
      // 125: goto 129
      // 128: athrow
      // 129: aload 5
      // 12b: invokevirtual net/minecraft/entity/DataWatcher$WatchableObject.getObject ()Ljava/lang/Object;
      // 12e: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 131: invokestatic java/lang/Double.parseDouble (Ljava/lang/String;)D
      // 134: dstore 6
      // 136: dload 6
      // 138: iload 2
      // 139: ifne 14c
      // 13c: invokestatic java/lang/Double.isNaN (D)Z
      // 13f: ifne 169
      // 142: goto 146
      // 145: athrow
      // 146: dload 6
      // 148: goto 14c
      // 14b: athrow
      // 14c: dconst_0
      // 14d: dcmpg
      // 14e: iload 2
      // 14f: ifne 168
      // 152: ifgt 169
      // 155: goto 159
      // 158: athrow
      // 159: aload 0
      // 15a: bipush 1
      // 15b: bipush 1
      // 15c: invokevirtual x/oc7100b57c84.Ǔ (ZZ)V
      // 15f: aload 0
      // 160: invokevirtual x/oc7100b57c84.Ւ ()V
      // 163: bipush 1
      // 164: goto 168
      // 167: athrow
      // 168: ireturn
      // 169: goto 170
      // 16c: astore 6
      // 16e: bipush 1
      // 16f: ireturn
      // 170: iload 2
      // 171: ifeq 0f4
      // 174: bipush 1
      // 175: ireturn
      // 176: aload 1
      // 177: instanceof net/minecraft/network/play/server/S19PacketEntityStatus
      // 17a: ifeq 1ae
      // 17d: aload 0
      // 17e: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 181: iload 2
      // 182: ifne 1a2
      // 185: goto 189
      // 188: athrow
      // 189: ifnull 1ae
      // 18c: goto 190
      // 18f: athrow
      // 190: aload 1
      // 191: checkcast net/minecraft/network/play/server/S19PacketEntityStatus
      // 194: aload 0
      // 195: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 198: invokevirtual x/occ39d36078d.ӣ ()Lnet/minecraft/world/World;
      // 19b: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getEntity (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: aload 0
      // 1a3: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 1a6: if_acmpne 1ae
      // 1a9: bipush 1
      // 1aa: goto 1af
      // 1ad: athrow
      // 1ae: bipush 0
      // 1af: ireturn
   }

   private void Ǔ(boolean var1, boolean var2) {
      int var3 = oc75d51ec7eb.ϩ;

      oc7100b57c84 var10000;
      label43: {
         while (true) {
            oc88f4868161 var4;
            if ((var4 = this.Ї.poll()) != null) {
               try {
                  if (var3 != 0) {
                     break;
                  }

                  if (!var1) {
                     continue;
                  }
               } catch (NumberFormatException var7) {
                  throw var7;
               }

               this.æ(var4.ϱ());
               if (var3 == 0) {
                  continue;
               }
            }

            try {
               var10000 = this;
               if (var3 != 0) {
                  break label43;
               }

               this.ө.clear();
               occ39d36078d.ž = false;
               break;
            } catch (NumberFormatException var6) {
               throw var6;
            }
         }

         try {
            if (!var2) {
               return;
            }

            this.щ = false;
            var10000 = this;
         } catch (NumberFormatException var5) {
            throw var5;
         }
      }

      var10000.ɗ = true;
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void æ(Packet<?> var1) {
      int var2 = oc75d51ec7eb.ϩ;

      label33: {
         label32: {
            oc3dfdeebd5a var10000;
            label31: {
               try {
                  var10000 = oc2cf3d80e17.Ŗ;
                  if (var2 != 0) {
                     break label31;
                  }

                  if (oc2cf3d80e17.Ŗ == null) {
                     break label32;
                  }
               } catch (NumberFormatException var6) {
                  throw var6;
               }

               var10000 = oc2cf3d80e17.Ŗ;
            }

            try {
               var10000.ʗ(var1);
               if (var2 == 0) {
                  break label33;
               }
            } catch (NumberFormatException var5) {
               throw var5;
            }
         }

         try {
            ocd6ae010123.Å(var1);
         } catch (NumberFormatException var4) {
            throw var4;
         }
      }

      try {
         ;
      } catch (NumberFormatException var3) {
         throw var3;
      }
   }

   private void I() {
      this.Φ.Ŀ();
      this.Â = false;
   }

   private void Ւ() {
      this.ϼ = null;
      occ39d36078d.ž = false;
   }

   private boolean i() {
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
      // 06: ifne 1f
      // 09: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 0c: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0f: ifeq fb
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: iload 1
      // 18: ifne 2a
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokevirtual x/oc7100b57c84.Ѩ ()Z
      // 22: ifeq fb
      // 25: aload 0
      // 26: goto 2a
      // 29: athrow
      // 2a: iload 1
      // 2b: ifne 3d
      // 2e: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 31: ifnull fb
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: goto 3d
      // 3c: athrow
      // 3d: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 40: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 43: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHealth ()F
      // 46: fconst_0
      // 47: iload 1
      // 48: ifne 67
      // 4b: fcmpl
      // 4c: ifle fb
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: iload 1
      // 55: ifne 89
      // 58: goto 5c
      // 5b: athrow
      // 5c: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 5f: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 62: fconst_0
      // 63: goto 67
      // 66: athrow
      // 67: fcmpl
      // 68: ifgt 84
      // 6b: aload 0
      // 6c: iload 1
      // 6d: ifne 89
      // 70: goto 74
      // 73: athrow
      // 74: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // 77: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 7a: invokestatic java/lang/Float.isNaN (F)Z
      // 7d: ifeq fb
      // 80: goto 84
      // 83: athrow
      // 84: aload 0
      // 85: goto 89
      // 88: athrow
      // 89: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 8c: invokevirtual x/occ39d36078d.ԍ ()Z
      // 8f: iload 1
      // 90: ifne a6
      // 93: ifne fb
      // 96: goto 9a
      // 99: athrow
      // 9a: invokestatic java/lang/System.currentTimeMillis ()J
      // 9d: aload 0
      // 9e: getfield x/oc7100b57c84.Ȅ J
      // a1: lcmp
      // a2: goto a6
      // a5: athrow
      // a6: iload 1
      // a7: ifne c5
      // aa: iflt fb
      // ad: goto b1
      // b0: athrow
      // b1: aload 0
      // b2: iload 1
      // b3: ifne c9
      // b6: goto ba
      // b9: athrow
      // ba: aload 0
      // bb: getfield x/oc7100b57c84.ϼ Lnet/minecraft/entity/EntityLivingBase;
      // be: invokevirtual x/oc7100b57c84.Ǌ (Lnet/minecraft/entity/Entity;)Z
      // c1: goto c5
      // c4: athrow
      // c5: ifeq fb
      // c8: aload 0
      // c9: iload 1
      // ca: ifne e9
      // cd: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // d0: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // d3: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // d6: ldc_w 1443798114
      // d9: ldc_w 1443798134
      // dc: ixor
      // dd: if_icmple fb
      // e0: goto e4
      // e3: athrow
      // e4: aload 0
      // e5: goto e9
      // e8: athrow
      // e9: getfield x/oc7100b57c84.ɗ Z
      // ec: iload 1
      // ed: ifne f8
      // f0: ifne fb
      // f3: goto f7
      // f6: athrow
      // f7: bipush 1
      // f8: goto fc
      // fb: bipush 0
      // fc: ireturn
   }

   private boolean Ѩ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 1
      // 08: ifne 25
      // 0b: ifeq 42
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 16: iload 1
      // 17: ifne 30
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokevirtual x/occ39d36078d.Ø ()Z
      // 21: goto 25
      // 24: athrow
      // 25: ifne 42
      // 28: aload 0
      // 29: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 2c: goto 30
      // 2f: athrow
      // 30: invokevirtual x/occ39d36078d.Κ ()Z
      // 33: iload 1
      // 34: ifne 3f
      // 37: ifeq 42
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: bipush 0
      // 43: ireturn
   }

   private boolean Ï() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/oc9755810e45.Տ Lx/oc748fdbd6c0;
      // 07: iload 1
      // 08: ifne 1d
      // 0b: ifnull 3c
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.Տ Lx/oc748fdbd6c0;
      // 15: iload 1
      // 16: ifne 2a
      // 19: goto 1d
      // 1c: athrow
      // 1d: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 20: ifeq 3c
      // 23: getstatic x/oc9755810e45.Տ Lx/oc748fdbd6c0;
      // 26: goto 2a
      // 29: athrow
      // 2a: invokevirtual x/oc748fdbd6c0.Ў ()Z
      // 2d: iload 1
      // 2e: ifne 39
      // 31: ifeq 3c
      // 34: goto 38
      // 37: athrow
      // 38: bipush 1
      // 39: goto 3d
      // 3c: bipush 0
      // 3d: ireturn
   }

   private boolean Ǌ(Entity param1) {
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
      // 05: instanceof net/minecraft/entity/EntityLivingBase
      // 08: iload 2
      // 09: ifne 2f
      // 0c: ifeq 2a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: iload 2
      // 15: ifne 31
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // 20: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 23: if_acmpne 30
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 0
      // 2b: goto 2f
      // 2e: athrow
      // 2f: ireturn
      // 30: aload 1
      // 31: checkcast net/minecraft/entity/EntityLivingBase
      // 34: astore 3
      // 35: aload 3
      // 36: invokevirtual net/minecraft/entity/EntityLivingBase.isEntityAlive ()Z
      // 39: iload 2
      // 3a: ifne 5c
      // 3d: ifeq 57
      // 40: goto 44
      // 43: athrow
      // 44: aload 3
      // 45: iload 2
      // 46: ifne 5e
      // 49: goto 4d
      // 4c: athrow
      // 4d: invokevirtual net/minecraft/entity/EntityLivingBase.isInvisible ()Z
      // 50: ifeq 5d
      // 53: goto 57
      // 56: athrow
      // 57: bipush 0
      // 58: goto 5c
      // 5b: athrow
      // 5c: ireturn
      // 5d: aload 1
      // 5e: iload 2
      // 5f: ifne 70
      // 62: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 65: ifeq 6f
      // 68: goto 6c
      // 6b: athrow
      // 6c: bipush 0
      // 6d: ireturn
      // 6e: athrow
      // 6f: aload 1
      // 70: iload 2
      // 71: ifne c5
      // 74: instanceof net/minecraft/entity/player/EntityPlayer
      // 77: ifeq c4
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 1
      // 7f: checkcast net/minecraft/entity/player/EntityPlayer
      // 82: astore 4
      // 84: aload 4
      // 86: iload 2
      // 87: ifne 99
      // 8a: invokevirtual net/minecraft/entity/player/EntityPlayer.isSpectator ()Z
      // 8d: ifeq 97
      // 90: goto 94
      // 93: athrow
      // 94: bipush 0
      // 95: ireturn
      // 96: athrow
      // 97: aload 4
      // 99: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 9c: iload 2
      // 9d: ifne b3
      // a0: ifeq aa
      // a3: goto a7
      // a6: athrow
      // a7: bipush 0
      // a8: ireturn
      // a9: athrow
      // aa: aload 0
      // ab: getfield x/oc7100b57c84.Ü Lx/occ39d36078d;
      // ae: aload 4
      // b0: invokevirtual x/occ39d36078d.ĩ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // b3: iload 2
      // b4: ifne bf
      // b7: ifne c2
      // ba: goto be
      // bd: athrow
      // be: bipush 1
      // bf: goto c3
      // c2: bipush 0
      // c3: ireturn
      // c4: aload 1
      // c5: invokestatic x/oc7100b57c84.Ђ (Lnet/minecraft/entity/Entity;)Z
      // c8: ireturn
   }

   private static boolean Ђ(Entity param0) {
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
      // 05: instanceof net/minecraft/entity/monster/EntityMob
      // 08: iload 1
      // 09: ifne 60
      // 0c: ifne 5f
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: instanceof net/minecraft/entity/passive/EntityVillager
      // 17: iload 1
      // 18: ifne 60
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 5f
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: instanceof net/minecraft/entity/monster/EntitySlime
      // 2a: iload 1
      // 2b: ifne 60
      // 2e: goto 32
      // 31: athrow
      // 32: ifne 5f
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: instanceof net/minecraft/entity/monster/EntityGhast
      // 3d: iload 1
      // 3e: ifne 60
      // 41: goto 45
      // 44: athrow
      // 45: ifne 5f
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: instanceof net/minecraft/entity/boss/EntityDragon
      // 50: iload 1
      // 51: ifne 60
      // 54: goto 58
      // 57: athrow
      // 58: ifeq 63
      // 5b: goto 5f
      // 5e: athrow
      // 5f: bipush 1
      // 60: goto 64
      // 63: bipush 0
      // 64: ireturn
   }

   private void minQ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc7100b57c84.ŋ Lx/oca9cc61aada;
      // 07: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a: aload 0
      // 0b: getfield x/oc7100b57c84.ӓ Lx/oca9cc61aada;
      // 0e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 11: invokestatic java/lang/Math.min (DD)D
      // 14: d2i
      // 15: istore 2
      // 16: istore 1
      // 17: aload 0
      // 18: getfield x/oc7100b57c84.ŋ Lx/oca9cc61aada;
      // 1b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e: aload 0
      // 1f: getfield x/oc7100b57c84.ӓ Lx/oca9cc61aada;
      // 22: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 25: invokestatic java/lang/Math.max (DD)D
      // 28: d2i
      // 29: istore 3
      // 2a: aload 0
      // 2b: iload 2
      // 2c: iload 1
      // 2d: ifne 3e
      // 30: iload 3
      // 31: if_icmpne 3d
      // 34: goto 38
      // 37: athrow
      // 38: iload 2
      // 39: goto 4a
      // 3c: athrow
      // 3d: iload 2
      // 3e: invokestatic java/lang/Math.random ()D
      // 41: iload 3
      // 42: iload 2
      // 43: isub
      // 44: bipush 1
      // 45: iadd
      // 46: i2d
      // 47: dmul
      // 48: d2i
      // 49: iadd
      // 4a: putfield x/oc7100b57c84.ň I
      // 4d: return
   }

   private int ɾ() {
      return this.ň;
   }

   private double minQd() {
      return Math.min(this.ԏ.Ӂ(), this.К.Ӂ());
   }

   private double Ȇ() {
      return Math.max(this.ԏ.Ӂ(), this.К.Ӂ());
   }

   private double ӷ(Entity var1, Vec3 var2) {
      return this.ï(var1.getEntityBoundingBox().offset(var2.xCoord - var1.posX, var2.yCoord - var1.posY, var2.zCoord - var1.posZ));
   }

   private double ï(AxisAlignedBB var1) {
      Vec3 var2 = this.Ü.ү().getPositionEyes(1.0F);
      double var3 = Math.max(var1.minX, Math.min(var2.xCoord, var1.maxX));
      double var5 = Math.max(var1.minY, Math.min(var2.yCoord, var1.maxY));
      double var7 = Math.max(var1.minZ, Math.min(var2.zCoord, var1.maxZ));
      return var2.distanceTo(new Vec3(var3, var5, var7));
   }

   private boolean U() {
      int var1 = oc75d51ec7eb.ϩ;

      oc3dfdeebd5a var10000;
      label33: {
         try {
            var10000 = oc2cf3d80e17.Ŗ;
            if (var1 != 0) {
               break label33;
            }

            if (oc2cf3d80e17.Ŗ == null) {
               return true;
            }
         } catch (NumberFormatException var3) {
            throw var3;
         }

         var10000 = oc2cf3d80e17.Ŗ;
      }

      try {
         boolean var4 = var10000.ձ();
         if (var1 != 0) {
            return var4;
         }

         if (var4) {
            return true;
         }
      } catch (NumberFormatException var2) {
         throw var2;
      }

      return false;
   }

   private boolean Ɠ(Entity var1) {
      int var2 = oc75d51ec7eb.ϩ;

      oc3dfdeebd5a var10000;
      label33: {
         try {
            var10000 = oc2cf3d80e17.Ŗ;
            if (var2 != 0) {
               break label33;
            }

            if (oc2cf3d80e17.Ŗ == null) {
               return false;
            }
         } catch (NumberFormatException var4) {
            throw var4;
         }

         var10000 = oc2cf3d80e17.Ŗ;
      }

      try {
         boolean var5 = var10000.Κ(var1);
         if (var2 != 0) {
            return var5;
         }

         if (var5) {
            return true;
         }
      } catch (NumberFormatException var3) {
         throw var3;
      }

      return false;
   }

   private Vec3 Ę(Entity param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: getstatic x/oc2cf3d80e17.Ŗ Lx/oc3dfdeebd5a;
      // 07: iload 2
      // 08: ifne 1a
      // 0b: ifnonnull 17
      // 0e: goto 12
      // 11: athrow
      // 12: aconst_null
      // 13: goto 1e
      // 16: athrow
      // 17: getstatic x/oc2cf3d80e17.Ŗ Lx/oc3dfdeebd5a;
      // 1a: aload 1
      // 1b: invokevirtual x/oc3dfdeebd5a.Ѐ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 1e: areturn
   }

   private Vec3 ƞ(Entity var1) {
      return oc2cf3d80e17.Ŗ.Ѕ(var1);
   }

   static {
      String[] var10000 = new String[-866059672 ^ -866059670];
      var10000[0] = "None";
      var10000[1] = "Box";
      Ǯ = var10000;
      var10000 = new String[-866059672 ^ -866059670];
      var10000[0] = "Custom";
      var10000[1] = "HUD";
      ů = var10000;
   }
}
