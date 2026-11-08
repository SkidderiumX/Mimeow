package x;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class oc9621e51cfd {
   private static final String[] ц;
   private static final String[] դ;
   private final occ39d36078d Ő;
   private final oca9cc61aada ɪ = new oca9cc61aada("Next backtrack delay", "ms", 0.0, 0.0, 2000.0, 10.0);
   private final oca9cc61aada Ɛ = new oca9cc61aada("Max delay", "ms", 80.0, 0.0, 2000.0, 10.0);
   private final oca9cc61aada ƒ = new oca9cc61aada("Min delay", "ms", 80.0, 0.0, 2000.0, 10.0);
   private final oca9cc61aada A = new oca9cc61aada("Distance min", 2.0, 0.0, 6.0, 0.1);
   private final oca9cc61aada Ȅ = new oca9cc61aada("Distance max", 3.0, 0.0, 6.0, 0.1);
   private final occ2f8dff8d8 ԧ = new occ2f8dff8d8("Smart", true);
   private final oca9cc61aada Қ;
   private final oca9cc61aada ԓ;
   private final oc24a0a5bddf º;
   private final ConcurrentLinkedQueue<oc88f4868161> Ћ;
   private final ConcurrentLinkedDeque<oc47ee786826> Ș;
   private final AtomicLong д;
   private EntityLivingBase Ü;
   private long Ъ;
   private int á;
   private boolean Ψ;
   private boolean т;
   private boolean Į;
   public static boolean ș;

   public oc9621e51cfd(occ39d36078d var1) {
      this.Қ = new oca9cc61aada("ESP mode", 1, ц);
      this.ԓ = new oca9cc61aada("Color mode", 1, դ);
      this.º = new oc24a0a5bddf("ESP color", 0, 1820723203 ^ 1820723452, 0);
      this.Ћ = new ConcurrentLinkedQueue<>();
      this.Ș = new ConcurrentLinkedDeque<>();
      this.д = new AtomicLong();
      this.т = true;
      this.Ő = var1;
      var1.ʌ(this.ɪ);
      var1.ʌ(this.Ɛ);
      var1.ʌ(this.ƒ);
      var1.ʌ(this.A);
      var1.ʌ(this.Ȅ);
      var1.ʌ(this.ԧ);
      var1.ʌ(this.Қ);
      var1.ʌ(this.ԓ);
      var1.ʌ(this.º);
      this.Ǭ();
   }

   public void Ǯ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc9621e51cfd.ɪ Lx/oca9cc61aada;
      // 07: iload 1
      // 08: aload 0
      // 09: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 0c: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0f: istore 2
      // 10: aload 0
      // 11: getfield x/oc9621e51cfd.Ɛ Lx/oca9cc61aada;
      // 14: iload 1
      // 15: iload 2
      // 16: ifne 74
      // 19: aload 0
      // 1a: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 1d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 20: aload 0
      // 21: getfield x/oc9621e51cfd.ƒ Lx/oca9cc61aada;
      // 24: iload 1
      // 25: aload 0
      // 26: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 29: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 2c: aload 0
      // 2d: getfield x/oc9621e51cfd.A Lx/oca9cc61aada;
      // 30: iload 1
      // 31: aload 0
      // 32: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 35: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 38: aload 0
      // 39: getfield x/oc9621e51cfd.Ȅ Lx/oca9cc61aada;
      // 3c: iload 1
      // 3d: aload 0
      // 3e: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 41: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 44: aload 0
      // 45: getfield x/oc9621e51cfd.ԧ Lx/occ2f8dff8d8;
      // 48: iload 1
      // 49: aload 0
      // 4a: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 4d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 50: aload 0
      // 51: getfield x/oc9621e51cfd.Қ Lx/oca9cc61aada;
      // 54: iload 1
      // 55: aload 0
      // 56: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 59: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 5c: aload 0
      // 5d: getfield x/oc9621e51cfd.ԓ Lx/oca9cc61aada;
      // 60: iload 1
      // 61: ifeq 88
      // 64: goto 68
      // 67: athrow
      // 68: aload 0
      // 69: getfield x/oc9621e51cfd.Қ Lx/oca9cc61aada;
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
      // 8a: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 8d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 90: aload 0
      // 91: getfield x/oc9621e51cfd.º Lx/oc24a0a5bddf;
      // 94: iload 1
      // 95: iload 2
      // 96: ifne b4
      // 99: ifeq d3
      // 9c: goto a0
      // 9f: athrow
      // a0: aload 0
      // a1: iload 2
      // a2: ifne bd
      // a5: goto a9
      // a8: athrow
      // a9: getfield x/oc9621e51cfd.Қ Lx/oca9cc61aada;
      // ac: invokevirtual x/oca9cc61aada.Ӂ ()D
      // af: d2i
      // b0: goto b4
      // b3: athrow
      // b4: bipush 1
      // b5: if_icmpne d3
      // b8: aload 0
      // b9: goto bd
      // bc: athrow
      // bd: getfield x/oc9621e51cfd.ԓ Lx/oca9cc61aada;
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
      // d5: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // d8: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // db: return
   }

   public void ő(oce79181588d param1) {
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
      // 021: invokevirtual x/oc9621e51cfd.ǟ ()Z
      // 024: goto 028
      // 027: athrow
      // 028: ifeq 02c
      // 02b: return
      // 02c: aload 0
      // 02d: iload 2
      // 02e: ifne 049
      // 031: invokevirtual x/oc9621e51cfd.Ĩ ()Z
      // 034: ifne 048
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: bipush 1
      // 03d: bipush 1
      // 03e: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 041: aload 0
      // 042: aconst_null
      // 043: putfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 046: return
      // 047: athrow
      // 048: aload 0
      // 049: getfield x/oc9621e51cfd.Ћ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 04c: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.isEmpty ()Z
      // 04f: iload 2
      // 050: ifne 085
      // 053: ifeq 081
      // 056: goto 05a
      // 059: athrow
      // 05a: aload 0
      // 05b: invokevirtual x/oc9621e51cfd.ʖ ()Z
      // 05e: iload 2
      // 05f: ifne 085
      // 062: goto 066
      // 065: athrow
      // 066: ifeq 081
      // 069: goto 06d
      // 06c: athrow
      // 06d: aload 0
      // 06e: invokevirtual x/oc9621e51cfd.ё ()Z
      // 071: iload 2
      // 072: ifne 085
      // 075: goto 079
      // 078: athrow
      // 079: ifne 081
      // 07c: goto 080
      // 07f: athrow
      // 080: return
      // 081: aload 3
      // 082: invokestatic x/occ39d36078d.Ժ (Lnet/minecraft/network/Packet;)Z
      // 085: iload 2
      // 086: ifne 0a1
      // 089: ifne 0a4
      // 08c: goto 090
      // 08f: athrow
      // 090: aload 0
      // 091: iload 2
      // 092: ifne 0a6
      // 095: goto 099
      // 098: athrow
      // 099: aload 3
      // 09a: invokevirtual x/oc9621e51cfd.Ζ (Lnet/minecraft/network/Packet;)Z
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: ifeq 0a5
      // 0a4: return
      // 0a5: aload 0
      // 0a6: iload 2
      // 0a7: ifne 158
      // 0aa: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0ad: ifnull 152
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: aload 3
      // 0b5: iload 2
      // 0b6: ifne 0eb
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: instanceof net/minecraft/network/play/server/S14PacketEntity
      // 0c0: ifeq 0e6
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: aload 3
      // 0c8: iload 2
      // 0c9: ifne 0eb
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: checkcast x/oc1553ad102e
      // 0d3: invokeinterface x/oc1553ad102e.getEntityId ()I 1
      // 0d8: aload 0
      // 0d9: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0dc: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 0df: if_icmpeq 116
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 3
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: instanceof net/minecraft/network/play/server/S18PacketEntityTeleport
      // 0ee: iload 2
      // 0ef: ifne 170
      // 0f2: ifeq 152
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: aload 3
      // 0fa: checkcast net/minecraft/network/play/server/S18PacketEntityTeleport
      // 0fd: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getEntityId ()I
      // 100: iload 2
      // 101: ifne 170
      // 104: goto 108
      // 107: athrow
      // 108: aload 0
      // 109: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 10c: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 10f: if_icmpne 152
      // 112: goto 116
      // 115: athrow
      // 116: aload 0
      // 117: iload 2
      // 118: ifne 158
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 0
      // 120: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 123: invokevirtual x/oc9621e51cfd.Ć (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 126: astore 4
      // 128: aload 4
      // 12a: ifnull 152
      // 12d: aload 0
      // 12e: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 131: new x/oc47ee786826
      // 134: dup
      // 135: aload 4
      // 137: getfield net/minecraft/util/Vec3.xCoord D
      // 13a: aload 4
      // 13c: getfield net/minecraft/util/Vec3.yCoord D
      // 13f: aload 4
      // 141: getfield net/minecraft/util/Vec3.zCoord D
      // 144: invokestatic java/lang/System.currentTimeMillis ()J
      // 147: invokespecial x/oc47ee786826.<init> (DDDJ)V
      // 14a: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.offerLast (Ljava/lang/Object;)Z
      // 14d: pop
      // 14e: goto 152
      // 151: athrow
      // 152: aload 1
      // 153: bipush 1
      // 154: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 157: aload 0
      // 158: getfield x/oc9621e51cfd.Ћ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 15b: new x/oc88f4868161
      // 15e: dup
      // 15f: aload 3
      // 160: invokestatic java/lang/System.currentTimeMillis ()J
      // 163: aload 0
      // 164: getfield x/oc9621e51cfd.д Ljava/util/concurrent/atomic/AtomicLong;
      // 167: invokevirtual java/util/concurrent/atomic/AtomicLong.incrementAndGet ()J
      // 16a: invokespecial x/oc88f4868161.<init> (Lnet/minecraft/network/Packet;JJ)V
      // 16d: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.offer (Ljava/lang/Object;)Z
      // 170: pop
      // 171: return
   }

   public void Ĕ(oc9374123646 var1) {
      this.ü();
      this.Į = false;
   }

   public void ʇ() {
      try {
         if (oc7ab2161b9f.Ð()) {
            this.ϔ();
         }
      } catch (NumberFormatException var1) {
         throw var1;
      }
   }

   public void ű(ocd47efa9be3 param1) {
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
      // 09: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 0c: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f: if_acmpne 29
      // 12: aload 0
      // 13: iload 2
      // 14: ifne 2c
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 1
      // 1c: getfield x/ocd47efa9be3.ϊ Lnet/minecraft/entity/Entity;
      // 1f: invokevirtual x/oc9621e51cfd.ɯ (Lnet/minecraft/entity/Entity;)Z
      // 22: ifne 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: aload 0
      // 2c: iload 2
      // 2d: ifne 4d
      // 30: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 33: aload 1
      // 34: getfield x/ocd47efa9be3.ϊ Lnet/minecraft/entity/Entity;
      // 37: if_acmpeq 4c
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: bipush 1
      // 40: bipush 1
      // 41: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 44: aload 0
      // 45: invokevirtual x/oc9621e51cfd.Ѽ ()V
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: aload 1
      // 4e: getfield x/ocd47efa9be3.ϊ Lnet/minecraft/entity/Entity;
      // 51: checkcast net/minecraft/entity/EntityLivingBase
      // 54: putfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 57: return
   }

   public void җ(float param1) {
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
      // 009: invokevirtual x/oc9621e51cfd.ё ()Z
      // 00c: ifeq 068
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: goto 018
      // 017: athrow
      // 018: iload 2
      // 019: ifne 02b
      // 01c: getfield x/oc9621e51cfd.т Z
      // 01f: ifeq 068
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: goto 02b
      // 02a: athrow
      // 02b: iload 2
      // 02c: ifne 03e
      // 02f: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 032: ifnull 068
      // 035: goto 039
      // 038: athrow
      // 039: aload 0
      // 03a: goto 03e
      // 03d: athrow
      // 03e: iload 2
      // 03f: ifne 055
      // 042: aload 0
      // 043: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 046: invokevirtual x/oc9621e51cfd.Л (Lnet/minecraft/entity/Entity;)Z
      // 049: ifeq 068
      // 04c: goto 050
      // 04f: athrow
      // 050: aload 0
      // 051: goto 055
      // 054: athrow
      // 055: iload 2
      // 056: ifne 06b
      // 059: getfield x/oc9621e51cfd.Қ Lx/oca9cc61aada;
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
      // 06c: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 06f: invokevirtual x/oc9621e51cfd.ȶ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 072: astore 3
      // 073: aload 3
      // 074: getfield net/minecraft/util/Vec3.xCoord D
      // 077: aload 0
      // 078: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 07b: invokevirtual x/occ39d36078d.Ҝ ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 07e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 081: dsub
      // 082: dstore 4
      // 084: aload 3
      // 085: getfield net/minecraft/util/Vec3.yCoord D
      // 088: aload 0
      // 089: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 08c: invokevirtual x/occ39d36078d.Ҝ ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 08f: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 092: dsub
      // 093: dstore 6
      // 095: aload 3
      // 096: getfield net/minecraft/util/Vec3.zCoord D
      // 099: aload 0
      // 09a: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 09d: invokevirtual x/occ39d36078d.Ҝ ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0a0: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 0a3: dsub
      // 0a4: dstore 8
      // 0a6: aload 0
      // 0a7: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0aa: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0ad: dload 4
      // 0af: aload 0
      // 0b0: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0b3: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 0b6: dsub
      // 0b7: dload 6
      // 0b9: aload 0
      // 0ba: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0bd: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 0c0: dsub
      // 0c1: dload 8
      // 0c3: aload 0
      // 0c4: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0c7: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 0ca: dsub
      // 0cb: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0ce: astore 10
      // 0d0: aload 0
      // 0d1: getfield x/oc9621e51cfd.ԓ Lx/oca9cc61aada;
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
      // 0f0: getfield x/oc9621e51cfd.º Lx/oc24a0a5bddf;
      // 0f3: invokevirtual x/oc24a0a5bddf.ǐ ()I
      // 0f6: invokespecial java/awt/Color.<init> (I)V
      // 0f9: astore 11
      // 0fb: aload 10
      // 0fd: aload 11
      // 0ff: invokestatic x/ocbd4917c4b1.H (Lnet/minecraft/util/AxisAlignedBB;Ljava/awt/Color;)V
      // 102: return
   }

   public void Ц(boolean var1) {
      this.ƶ(var1, true);
      this.Ü = null;
      this.Ъ = 0L;
      this.Ψ = false;
      this.Į = false;
   }

   public int ԝ() {
      return this.á;
   }

   public EntityLivingBase Ń() {
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
      // 09: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0c: ifnull 47
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2e
      // 1c: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 1f: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 22: ifne 47
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 1
      // 2f: ifne 41
      // 32: invokevirtual x/oc9621e51cfd.ԝ ()I
      // 35: ifle 47
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 0
      // 3d: goto 41
      // 40: athrow
      // 41: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 44: goto 48
      // 47: aconst_null
      // 48: areturn
   }

   public Vec3 Ԕ() {
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
      // 09: invokevirtual x/oc9621e51cfd.Ń ()Lnet/minecraft/entity/EntityLivingBase;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: aconst_null
      // 14: goto 20
      // 17: athrow
      // 18: aload 0
      // 19: aload 0
      // 1a: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 1d: invokevirtual x/oc9621e51cfd.Ć (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 20: areturn
   }

   private void ü() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 042
      // 009: invokevirtual x/oc9621e51cfd.ё ()Z
      // 00c: ifeq 03d
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 1
      // 015: ifne 042
      // 018: goto 01c
      // 01b: athrow
      // 01c: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 01f: ifnull 03d
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: iload 1
      // 028: ifne 049
      // 02b: goto 02f
      // 02e: athrow
      // 02f: aload 0
      // 030: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 033: invokevirtual x/oc9621e51cfd.Л (Lnet/minecraft/entity/Entity;)Z
      // 036: ifne 048
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: goto 042
      // 041: athrow
      // 042: bipush 1
      // 043: bipush 1
      // 044: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 047: return
      // 048: aload 0
      // 049: aload 0
      // 04a: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 04d: invokevirtual x/oc9621e51cfd.Ć (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 050: astore 2
      // 051: iload 1
      // 052: aload 0
      // 053: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 056: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 059: aload 2
      // 05a: getfield net/minecraft/util/Vec3.xCoord D
      // 05d: aload 2
      // 05e: getfield net/minecraft/util/Vec3.yCoord D
      // 061: aload 2
      // 062: getfield net/minecraft/util/Vec3.zCoord D
      // 065: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistance (DDD)D
      // 068: dstore 3
      // 069: aload 0
      // 06a: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 06d: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 070: aload 0
      // 071: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 074: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 077: aload 0
      // 078: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 07b: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 07e: aload 0
      // 07f: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 082: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 085: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistance (DDD)D
      // 088: dstore 5
      // 08a: ifne 0d2
      // 08d: aload 0
      // 08e: invokevirtual x/oc9621e51cfd.ǟ ()Z
      // 091: ifne 0c8
      // 094: goto 098
      // 097: athrow
      // 098: dload 3
      // 099: ldc2_w 6.0
      // 09c: dcmpl
      // 09d: iload 1
      // 09e: ifne 0c5
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: ifgt 0c8
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: aload 0
      // 0ad: iload 1
      // 0ae: ifne 0e5
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: getfield x/oc9621e51cfd.ԧ Lx/occ2f8dff8d8;
      // 0b8: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0bb: dload 3
      // 0bc: dload 5
      // 0be: invokestatic x/oc4e962be445.Խ (ZDD)Z
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: ifne 0d3
      // 0c8: aload 0
      // 0c9: bipush 1
      // 0ca: bipush 1
      // 0cb: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: return
      // 0d3: aload 0
      // 0d4: iload 1
      // 0d5: ifne 107
      // 0d8: bipush 1
      // 0d9: putfield x/oc9621e51cfd.т Z
      // 0dc: bipush 1
      // 0dd: putstatic x/occ39d36078d.ž Z
      // 0e0: aload 0
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 0
      // 0e6: aload 0
      // 0e7: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0ea: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0ed: invokevirtual x/oc9621e51cfd.ĉ (Lnet/minecraft/util/AxisAlignedBB;)D
      // 0f0: invokevirtual x/oc9621e51cfd.ȉ (D)Z
      // 0f3: ifeq 102
      // 0f6: aload 0
      // 0f7: invokevirtual x/oc9621e51cfd.ɧ ()V
      // 0fa: iload 1
      // 0fb: ifeq 10a
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 0
      // 103: goto 107
      // 106: athrow
      // 107: invokevirtual x/oc9621e51cfd.Ѹ ()V
      // 10a: return
   }

   private void ɧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: invokestatic java/lang/System.currentTimeMillis ()J
      // 03: aload 0
      // 04: invokevirtual x/oc9621e51cfd.α ()I
      // 07: i2l
      // 08: lsub
      // 09: lstore 2
      // 0a: getstatic x/oc75d51ec7eb.ϩ I
      // 0d: aload 0
      // 0e: lload 2
      // 0f: invokevirtual x/oc9621e51cfd.Η (J)V
      // 12: istore 1
      // 13: aload 0
      // 14: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 17: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.isEmpty ()Z
      // 1a: ifne 47
      // 1d: aload 0
      // 1e: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 21: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.peekFirst ()Ljava/lang/Object;
      // 24: iload 1
      // 25: ifne 42
      // 28: checkcast x/oc47ee786826
      // 2b: invokevirtual x/oc47ee786826.r ()J
      // 2e: lload 2
      // 2f: lcmp
      // 30: ifge 47
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 3b: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.pollFirst ()Ljava/lang/Object;
      // 3e: goto 42
      // 41: athrow
      // 42: pop
      // 43: iload 1
      // 44: ifeq 13
      // 47: return
   }

   private void Ѹ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 09: aload 0
      // 0a: invokedynamic z$3ugj32ua7s1dc (Lx/oc9621e51cfd;)Lx/oc9ce2d650f1; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Lx/oc47ee786826;)D, x/oc9621e51cfd.qdlt81ae5vf6m (Lx/oc47ee786826;)D, (Lx/oc47ee786826;)D ]
      // 0f: aload 0
      // 10: invokevirtual x/oc9621e51cfd.ȵ ()D
      // 13: aload 0
      // 14: invokevirtual x/oc9621e51cfd.Đ ()D
      // 17: invokestatic x/oc4e962be445.Θ (Ljava/lang/Iterable;Lx/oc9ce2d650f1;DD)J
      // 1a: lstore 2
      // 1b: ifne 32
      // 1e: lload 2
      // 1f: lconst_0
      // 20: lcmp
      // 21: ifge 33
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: bipush 1
      // 2a: bipush 1
      // 2b: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 2e: goto 32
      // 31: athrow
      // 32: return
      // 33: aload 0
      // 34: lload 2
      // 35: invokevirtual x/oc9621e51cfd.Η (J)V
      // 38: aload 0
      // 39: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 3c: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.isEmpty ()Z
      // 3f: ifne 6c
      // 42: aload 0
      // 43: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 46: iload 1
      // 47: ifne 67
      // 4a: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.peekFirst ()Ljava/lang/Object;
      // 4d: checkcast x/oc47ee786826
      // 50: invokevirtual x/oc47ee786826.r ()J
      // 53: lload 2
      // 54: lcmp
      // 55: ifge 6c
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 0
      // 5d: getfield x/oc9621e51cfd.Ș Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 60: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.pollFirst ()Ljava/lang/Object;
      // 63: goto 67
      // 66: athrow
      // 67: pop
      // 68: iload 1
      // 69: ifeq 38
      // 6c: return
   }

   private void ϔ() {
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
      // 09: getfield x/oc9621e51cfd.Ћ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 0c: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.isEmpty ()Z
      // 0f: ifeq 2d
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/oc9621e51cfd.ʖ ()Z
      // 1e: iload 1
      // 1f: ifne 2a
      // 22: ifeq 2d
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: istore 2
      // 2f: iload 2
      // 30: iload 1
      // 31: ifne 45
      // 34: ifne 44
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: bipush 0
      // 3d: putfield x/oc9621e51cfd.Ψ Z
      // 40: goto 44
      // 43: athrow
      // 44: iload 2
      // 45: iload 1
      // 46: ifne 60
      // 49: ifeq ac
      // 4c: goto 50
      // 4f: athrow
      // 50: aload 0
      // 51: iload 1
      // 52: ifne 64
      // 55: goto 59
      // 58: athrow
      // 59: getfield x/oc9621e51cfd.Ψ Z
      // 5c: goto 60
      // 5f: athrow
      // 60: ifne ac
      // 63: aload 0
      // 64: invokevirtual x/oc9621e51cfd.ё ()Z
      // 67: ifne ac
      // 6a: lconst_0
      // 6b: aload 0
      // 6c: getfield x/oc9621e51cfd.ɪ Lx/oca9cc61aada;
      // 6f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 72: d2l
      // 73: invokestatic java/lang/Math.max (JJ)J
      // 76: lstore 3
      // 77: aload 0
      // 78: invokestatic java/lang/System.currentTimeMillis ()J
      // 7b: ldc2_w 758589188738601556
      // 7e: ldc2_w 8464782848116174251
      // 81: lxor
      // 82: iload 1
      // 83: ifne 9f
      // 86: lload 3
      // 87: lsub
      // 88: lcmp
      // 89: ifle 9b
      // 8c: goto 90
      // 8f: athrow
      // 90: ldc2_w 758589188738601556
      // 93: ldc2_w 8464782848116174251
      // 96: lxor
      // 97: goto a0
      // 9a: athrow
      // 9b: invokestatic java/lang/System.currentTimeMillis ()J
      // 9e: lload 3
      // 9f: ladd
      // a0: putfield x/oc9621e51cfd.Ъ J
      // a3: aload 0
      // a4: invokevirtual x/oc9621e51cfd.Ǭ ()V
      // a7: aload 0
      // a8: bipush 1
      // a9: putfield x/oc9621e51cfd.Ψ Z
      // ac: return
   }

   private void Η(long param1) {
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
      // 05: getfield x/oc9621e51cfd.Ћ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 08: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.peek ()Ljava/lang/Object;
      // 0b: checkcast x/oc88f4868161
      // 0e: dup
      // 0f: astore 4
      // 11: ifnull 3f
      // 14: aload 4
      // 16: iload 3
      // 17: ifne 31
      // 1a: invokevirtual x/oc88f4868161.ȷ ()J
      // 1d: lload 1
      // 1e: lcmp
      // 1f: ifgt 3f
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oc9621e51cfd.Ћ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 2a: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.poll ()Ljava/lang/Object;
      // 2d: goto 31
      // 30: athrow
      // 31: pop
      // 32: iload 3
      // 33: aload 0
      // 34: aload 4
      // 36: invokevirtual x/oc88f4868161.ϱ ()Lnet/minecraft/network/Packet;
      // 39: invokevirtual x/oc9621e51cfd.ð (Lnet/minecraft/network/Packet;)V
      // 3c: ifeq 04
      // 3f: return
   }

   private boolean Ζ(Packet<?> param1) {
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
      // 006: ifne 035
      // 009: instanceof net/minecraft/network/play/server/S06PacketUpdateHealth
      // 00c: ifeq 034
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: checkcast net/minecraft/network/play/server/S06PacketUpdateHealth
      // 017: iload 2
      // 018: ifne 035
      // 01b: goto 01f
      // 01e: athrow
      // 01f: invokevirtual net/minecraft/network/play/server/S06PacketUpdateHealth.getHealth ()F
      // 022: fconst_0
      // 023: fcmpg
      // 024: ifgt 034
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 0
      // 02c: bipush 1
      // 02d: bipush 1
      // 02e: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 031: bipush 1
      // 032: ireturn
      // 033: athrow
      // 034: aload 1
      // 035: iload 2
      // 036: ifne 09b
      // 039: instanceof net/minecraft/network/play/server/S13PacketDestroyEntities
      // 03c: ifeq 09a
      // 03f: goto 043
      // 042: athrow
      // 043: aload 0
      // 044: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 047: ifnull 09a
      // 04a: goto 04e
      // 04d: athrow
      // 04e: aload 1
      // 04f: checkcast net/minecraft/network/play/server/S13PacketDestroyEntities
      // 052: invokevirtual net/minecraft/network/play/server/S13PacketDestroyEntities.getEntityIDs ()[I
      // 055: astore 3
      // 056: aload 3
      // 057: arraylength
      // 058: istore 4
      // 05a: bipush 0
      // 05b: istore 5
      // 05d: iload 5
      // 05f: iload 4
      // 061: if_icmpge 09a
      // 064: aload 3
      // 065: iload 5
      // 067: iaload
      // 068: istore 6
      // 06a: iload 2
      // 06b: ifne 096
      // 06e: iload 6
      // 070: aload 0
      // 071: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 074: iload 2
      // 075: ifne 0cb
      // 078: goto 07c
      // 07b: athrow
      // 07c: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 07f: if_icmpne 093
      // 082: goto 086
      // 085: athrow
      // 086: aload 0
      // 087: bipush 1
      // 088: bipush 1
      // 089: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 08c: aload 0
      // 08d: invokevirtual x/oc9621e51cfd.Ѽ ()V
      // 090: bipush 1
      // 091: ireturn
      // 092: athrow
      // 093: iinc 5 1
      // 096: iload 2
      // 097: ifeq 05d
      // 09a: aload 1
      // 09b: iload 2
      // 09c: ifne 173
      // 09f: instanceof net/minecraft/network/play/server/S1CPacketEntityMetadata
      // 0a2: ifeq 172
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 0
      // 0aa: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0ad: ifnull 172
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: aload 1
      // 0b5: checkcast net/minecraft/network/play/server/S1CPacketEntityMetadata
      // 0b8: iload 2
      // 0b9: ifne 173
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: invokevirtual net/minecraft/network/play/server/S1CPacketEntityMetadata.getEntityId ()I
      // 0c3: aload 0
      // 0c4: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 0ce: if_icmpne 172
      // 0d1: aload 1
      // 0d2: checkcast net/minecraft/network/play/server/S1CPacketEntityMetadata
      // 0d5: invokevirtual net/minecraft/network/play/server/S1CPacketEntityMetadata.func_149376_c ()Ljava/util/List;
      // 0d8: astore 3
      // 0d9: aload 3
      // 0da: iload 2
      // 0db: ifne 0e9
      // 0de: ifnonnull 0e8
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: bipush 1
      // 0e6: ireturn
      // 0e7: athrow
      // 0e8: aload 3
      // 0e9: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0ee: astore 4
      // 0f0: aload 4
      // 0f2: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0f7: ifeq 170
      // 0fa: aload 4
      // 0fc: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 101: checkcast net/minecraft/entity/DataWatcher$WatchableObject
      // 104: astore 5
      // 106: aload 5
      // 108: iload 2
      // 109: ifne 12a
      // 10c: invokevirtual net/minecraft/entity/DataWatcher$WatchableObject.getDataValueId ()I
      // 10f: iload 2
      // 110: ifne 171
      // 113: goto 117
      // 116: athrow
      // 117: ldc_w 488060956
      // 11a: ldc_w 488060954
      // 11d: ixor
      // 11e: if_icmpne 16c
      // 121: goto 125
      // 124: athrow
      // 125: aload 5
      // 127: invokevirtual net/minecraft/entity/DataWatcher$WatchableObject.getObject ()Ljava/lang/Object;
      // 12a: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 12d: invokestatic java/lang/Double.parseDouble (Ljava/lang/String;)D
      // 130: dstore 6
      // 132: dload 6
      // 134: iload 2
      // 135: ifne 148
      // 138: invokestatic java/lang/Double.isNaN (D)Z
      // 13b: ifne 165
      // 13e: goto 142
      // 141: athrow
      // 142: dload 6
      // 144: goto 148
      // 147: athrow
      // 148: dconst_0
      // 149: dcmpg
      // 14a: iload 2
      // 14b: ifne 164
      // 14e: ifgt 165
      // 151: goto 155
      // 154: athrow
      // 155: aload 0
      // 156: bipush 1
      // 157: bipush 1
      // 158: invokevirtual x/oc9621e51cfd.ƶ (ZZ)V
      // 15b: aload 0
      // 15c: invokevirtual x/oc9621e51cfd.Ѽ ()V
      // 15f: bipush 1
      // 160: goto 164
      // 163: athrow
      // 164: ireturn
      // 165: goto 16c
      // 168: astore 6
      // 16a: bipush 1
      // 16b: ireturn
      // 16c: iload 2
      // 16d: ifeq 0f0
      // 170: bipush 1
      // 171: ireturn
      // 172: aload 1
      // 173: instanceof net/minecraft/network/play/server/S19PacketEntityStatus
      // 176: ifeq 1aa
      // 179: aload 0
      // 17a: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 17d: iload 2
      // 17e: ifne 19e
      // 181: goto 185
      // 184: athrow
      // 185: ifnull 1aa
      // 188: goto 18c
      // 18b: athrow
      // 18c: aload 1
      // 18d: checkcast net/minecraft/network/play/server/S19PacketEntityStatus
      // 190: aload 0
      // 191: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 194: invokevirtual x/occ39d36078d.ӣ ()Lnet/minecraft/world/World;
      // 197: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getEntity (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 19a: goto 19e
      // 19d: athrow
      // 19e: aload 0
      // 19f: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 1a2: if_acmpne 1aa
      // 1a5: bipush 1
      // 1a6: goto 1ab
      // 1a9: athrow
      // 1aa: bipush 0
      // 1ab: ireturn
   }

   private void ƶ(boolean var1, boolean var2) {
      int var3 = oc75d51ec7eb.ϩ;

      label43: {
         while (true) {
            oc88f4868161 var4;
            if ((var4 = this.Ћ.poll()) != null) {
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

               this.ð(var4.ϱ());
               if (var3 == 0) {
                  continue;
               }
            }

            try {
               this.Ș.clear();
               if (var3 != 0) {
                  break label43;
               }

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

            this.т = false;
         } catch (NumberFormatException var5) {
            throw var5;
         }
      }

      this.Į = true;
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void ð(Packet<?> var1) {
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

   private void Ѽ() {
      this.Ü = null;
      occ39d36078d.ž = false;
   }

   private boolean ё() {
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
      // 09: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 0c: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0f: ifeq fb
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: iload 1
      // 18: ifne 2a
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokevirtual x/oc9621e51cfd.Ĩ ()Z
      // 22: ifeq fb
      // 25: aload 0
      // 26: goto 2a
      // 29: athrow
      // 2a: iload 1
      // 2b: ifne 3d
      // 2e: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 31: ifnull fb
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: goto 3d
      // 3c: athrow
      // 3d: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
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
      // 5c: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
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
      // 74: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 77: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 7a: invokestatic java/lang/Float.isNaN (F)Z
      // 7d: ifeq fb
      // 80: goto 84
      // 83: athrow
      // 84: aload 0
      // 85: goto 89
      // 88: athrow
      // 89: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 8c: invokevirtual x/occ39d36078d.ԍ ()Z
      // 8f: iload 1
      // 90: ifne a6
      // 93: ifne fb
      // 96: goto 9a
      // 99: athrow
      // 9a: invokestatic java/lang/System.currentTimeMillis ()J
      // 9d: aload 0
      // 9e: getfield x/oc9621e51cfd.Ъ J
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
      // bb: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // be: invokevirtual x/oc9621e51cfd.ɯ (Lnet/minecraft/entity/Entity;)Z
      // c1: goto c5
      // c4: athrow
      // c5: ifeq fb
      // c8: aload 0
      // c9: iload 1
      // ca: ifne e9
      // cd: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // d0: invokevirtual x/occ39d36078d.ү ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // d3: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // d6: ldc_w -2032002625
      // d9: ldc_w -2032002645
      // dc: ixor
      // dd: if_icmple fb
      // e0: goto e4
      // e3: athrow
      // e4: aload 0
      // e5: goto e9
      // e8: athrow
      // e9: getfield x/oc9621e51cfd.Į Z
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

   private boolean Ĩ() {
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
      // 13: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
      // 16: iload 1
      // 17: ifne 30
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokevirtual x/occ39d36078d.Ø ()Z
      // 21: goto 25
      // 24: athrow
      // 25: ifne 42
      // 28: aload 0
      // 29: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
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

   private boolean ǟ() {
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

   private boolean ɯ(Entity param1) {
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
      // 1d: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
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
      // ab: getfield x/oc9621e51cfd.Ő Lx/occ39d36078d;
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
      // c5: invokestatic x/oc9621e51cfd.a (Lnet/minecraft/entity/Entity;)Z
      // c8: ireturn
   }

   private static boolean a(Entity param0) {
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

   private void Ǭ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc9621e51cfd.ƒ Lx/oca9cc61aada;
      // 07: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a: aload 0
      // 0b: getfield x/oc9621e51cfd.Ɛ Lx/oca9cc61aada;
      // 0e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 11: invokestatic java/lang/Math.min (DD)D
      // 14: d2i
      // 15: istore 2
      // 16: istore 1
      // 17: aload 0
      // 18: getfield x/oc9621e51cfd.ƒ Lx/oca9cc61aada;
      // 1b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e: aload 0
      // 1f: getfield x/oc9621e51cfd.Ɛ Lx/oca9cc61aada;
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
      // 4a: putfield x/oc9621e51cfd.á I
      // 4d: return
   }

   private int α() {
      return this.á;
   }

   private double ȵ() {
      return Math.min(this.A.Ӂ(), this.Ȅ.Ӂ());
   }

   private double Đ() {
      return Math.max(this.A.Ӂ(), this.Ȅ.Ӂ());
   }

   private boolean ȉ(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: dload 1
      // 05: aload 0
      // 06: iload 3
      // 07: ifne 1b
      // 0a: invokevirtual x/oc9621e51cfd.ȵ ()D
      // 0d: dcmpl
      // 0e: iflt 2e
      // 11: goto 15
      // 14: athrow
      // 15: dload 1
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/oc9621e51cfd.Đ ()D
      // 1e: dcmpg
      // 1f: iload 3
      // 20: ifne 2b
      // 23: ifgt 2e
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: goto 2f
      // 2e: bipush 0
      // 2f: ireturn
   }

   private double ȓ(Vec3 param1) {
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
      // 06: ifne 1b
      // 09: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 0c: ifnonnull 1a
      // 0f: goto 13
      // 12: athrow
      // 13: ldc2_w 1.7976931348623157E308
      // 16: goto 23
      // 19: athrow
      // 1a: aload 0
      // 1b: aload 0
      // 1c: getfield x/oc9621e51cfd.Ü Lnet/minecraft/entity/EntityLivingBase;
      // 1f: aload 1
      // 20: invokevirtual x/oc9621e51cfd.ѣ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)D
      // 23: dreturn
   }

   private double ѣ(Entity var1, Vec3 var2) {
      return this.ĉ(var1.getEntityBoundingBox().offset(var2.xCoord - var1.posX, var2.yCoord - var1.posY, var2.zCoord - var1.posZ));
   }

   private double ĉ(AxisAlignedBB var1) {
      Vec3 var2 = this.Ő.ү().getPositionEyes(1.0F);
      double var3 = Math.max(var1.minX, Math.min(var2.xCoord, var1.maxX));
      double var5 = Math.max(var1.minY, Math.min(var2.yCoord, var1.maxY));
      double var7 = Math.max(var1.minZ, Math.min(var2.zCoord, var1.maxZ));
      return var2.distanceTo(new Vec3(var3, var5, var7));
   }

   private boolean ʖ() {
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

   private boolean Л(Entity var1) {
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

   private Vec3 Ć(Entity param1) {
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

   private Vec3 ȶ(Entity var1) {
      return oc2cf3d80e17.Ŗ.Ѕ(var1);
   }

   static {
      String[] var10000 = new String[-1283862384 ^ -1283862382];
      var10000[0] = "None";
      var10000[1] = "Box";
      ц = var10000;
      var10000 = new String[-1283862384 ^ -1283862382];
      var10000[0] = "Custom";
      var10000[1] = "HUD";
      դ = var10000;
   }
}
