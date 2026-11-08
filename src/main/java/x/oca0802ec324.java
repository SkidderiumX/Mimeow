package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

public class oca0802ec324 extends oc6031c5c531 {
   private static final String[] Ҹ;
   private static final int ϗ = 60;
   private static final int Ԃ = 8;
   private static final int ǌ = 70;
   private static final int ԧ = 600;
   private static final int Ӻ = 256;
   private static final double դ = -0.03125;
   private static final double σ = 0.05;
   private static final long я = TimeUnit.SECONDS.toNanos(-4604339935524157417L ^ -4604339935524157431L);
   private static final long ʲ = Long.MIN_VALUE;
   public final oca9cc61aada м;
   private final Deque<C0FPacketConfirmTransaction> ĉ;
   private final Set<Long> Ո;
   private boolean Ӧ;
   private boolean Զ;
   private boolean č;
   private int ѭ;
   private int ǿ;
   private int ʡ;
   private long Т;
   private long Ţ;
   private long Ӵ;
   private double ȍ;
   private double Ȥ;
   private double ª;
   private double Û;
   public static int Ʒ;

   public oca0802ec324(ocdacba68ccd var1) {
      super("IntaveFireBall", var1);
      this.м = new oca9cc61aada("Motion mode", 0, Ҹ);
      this.ĉ = new ArrayDeque<>();
      this.Ո = new LinkedHashSet<>();
      this.Ţ = -7137573666221138094L ^ 2085798370633637714L;
      this.Ӵ = -7137573666221138094L ^ 2085798370633637714L;
   }

   @Override
   public void z$3g18l332rzhcd(boolean var1) {
      this.м.ȉ(var1, super.Ȓ);
   }

   @Override
   public boolean z$3hzq8op22ljmt() {
      int var1 = oc47731c13e2.ů;

      try {
         boolean var10000 = this.ƙ();
         if (var1 != 0) {
            return var10000;
         }

         if (!var10000) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   @Override
   public synchronized void z$30uo8shdqe5to() {
      this.ö();
      this.Ԉ();
   }

   @Override
   public synchronized void z$1q0da71f8mrae() {
      this.ρ(true);
      this.Ԉ();
   }

   @Override
   public synchronized void z$28gl8df6dqh8o(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc47731c13e2.ů I
      // 003: aload 1
      // 004: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 3
      // 00a: instanceof net/minecraft/network/play/server/S32PacketConfirmTransaction
      // 00d: iload 2
      // 00e: ifne 02e
      // 011: ifeq 022
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: aload 3
      // 01a: checkcast net/minecraft/network/play/server/S32PacketConfirmTransaction
      // 01d: invokevirtual x/oca0802ec324.Ǉ (Lnet/minecraft/network/play/server/S32PacketConfirmTransaction;)V
      // 020: return
      // 021: athrow
      // 022: aload 0
      // 023: iload 2
      // 024: ifne 032
      // 027: getfield x/oca0802ec324.č Z
      // 02a: goto 02e
      // 02d: athrow
      // 02e: ifeq 038
      // 031: aload 0
      // 032: getfield x/oca0802ec324.Ӵ J
      // 035: goto 03f
      // 038: ldc2_w 5838966366667888130
      // 03b: ldc2_w -3384405670186887678
      // 03e: lxor
      // 03f: lstore 4
      // 041: aload 0
      // 042: bipush 0
      // 043: putfield x/oca0802ec324.č Z
      // 046: aload 0
      // 047: ldc2_w 5838966366667888130
      // 04a: ldc2_w -3384405670186887678
      // 04d: lxor
      // 04e: putfield x/oca0802ec324.Ӵ J
      // 051: aload 3
      // 052: iload 2
      // 053: ifne 068
      // 056: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 059: ifeq 067
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 0
      // 061: bipush 1
      // 062: invokevirtual x/oca0802ec324.ρ (Z)V
      // 065: return
      // 066: athrow
      // 067: aload 3
      // 068: instanceof net/minecraft/network/play/server/S12PacketEntityVelocity
      // 06b: ifeq 08f
      // 06e: aload 0
      // 06f: iload 2
      // 070: ifne 086
      // 073: goto 077
      // 076: athrow
      // 077: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 07a: ifnull 08f
      // 07d: goto 081
      // 080: athrow
      // 081: aload 0
      // 082: goto 086
      // 085: athrow
      // 086: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 089: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08c: ifnonnull 091
      // 08f: return
      // 090: athrow
      // 091: aload 3
      // 092: checkcast net/minecraft/network/play/server/S12PacketEntityVelocity
      // 095: astore 6
      // 097: iload 2
      // 098: ifne 0b8
      // 09b: aload 6
      // 09d: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getEntityID ()I
      // 0a0: aload 0
      // 0a1: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0a4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a7: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityId ()I
      // 0aa: if_icmpeq 0b3
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: return
      // 0b2: athrow
      // 0b3: aload 0
      // 0b4: bipush 1
      // 0b5: invokevirtual x/oca0802ec324.ρ (Z)V
      // 0b8: lload 4
      // 0ba: ldc2_w 5838966366667888130
      // 0bd: ldc2_w -3384405670186887678
      // 0c0: lxor
      // 0c1: lcmp
      // 0c2: iload 2
      // 0c3: ifne 0d3
      // 0c6: ifne 0ce
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: return
      // 0ce: aload 6
      // 0d0: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionY ()I
      // 0d3: i2d
      // 0d4: ldc2_w 8000.0
      // 0d7: ddiv
      // 0d8: dstore 7
      // 0da: dload 7
      // 0dc: iload 2
      // 0dd: ifne 113
      // 0e0: ldc2_w 0.05
      // 0e3: dcmpg
      // 0e4: ifgt 0ed
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: return
      // 0ec: athrow
      // 0ed: aload 0
      // 0ee: aload 6
      // 0f0: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionX ()I
      // 0f3: i2d
      // 0f4: ldc2_w 8000.0
      // 0f7: ddiv
      // 0f8: putfield x/oca0802ec324.ȍ D
      // 0fb: aload 0
      // 0fc: dload 7
      // 0fe: putfield x/oca0802ec324.Ȥ D
      // 101: aload 0
      // 102: aload 6
      // 104: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionZ ()I
      // 107: i2d
      // 108: ldc2_w 8000.0
      // 10b: ddiv
      // 10c: putfield x/oca0802ec324.ª D
      // 10f: aload 0
      // 110: getfield x/oca0802ec324.Ȥ D
      // 113: invokestatic x/oca0802ec324.ʰ (D)I
      // 116: istore 9
      // 118: aload 0
      // 119: iload 2
      // 11a: ifne 180
      // 11d: bipush 1
      // 11e: ldc -279919882
      // 120: ldc -279919926
      // 122: ixor
      // 123: ldc -279919988
      // 125: ldc -279919926
      // 127: ixor
      // 128: iload 9
      // 12a: isub
      // 12b: invokestatic java/lang/Math.min (II)I
      // 12e: invokestatic java/lang/Math.max (II)I
      // 131: putfield x/oca0802ec324.ʡ I
      // 134: aload 0
      // 135: bipush 0
      // 136: putfield x/oca0802ec324.ѭ I
      // 139: aload 0
      // 13a: bipush 0
      // 13b: putfield x/oca0802ec324.ǿ I
      // 13e: aload 0
      // 13f: aload 0
      // 140: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 143: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 146: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 149: putfield x/oca0802ec324.Û D
      // 14c: aload 0
      // 14d: invokestatic java/lang/System.nanoTime ()J
      // 150: putfield x/oca0802ec324.Т J
      // 153: aload 0
      // 154: getfield x/oca0802ec324.Ո Ljava/util/Set;
      // 157: lload 4
      // 159: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 15c: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 161: ifeq 17b
      // 164: goto 168
      // 167: athrow
      // 168: aload 0
      // 169: bipush 1
      // 16a: putfield x/oca0802ec324.Ӧ Z
      // 16d: iload 2
      // 16e: aload 0
      // 16f: lload 4
      // 171: putfield x/oca0802ec324.Ţ J
      // 174: ifeq 184
      // 177: goto 17b
      // 17a: athrow
      // 17b: aload 0
      // 17c: goto 180
      // 17f: athrow
      // 180: bipush 1
      // 181: putfield x/oca0802ec324.Զ Z
      // 184: aload 1
      // 185: bipush 1
      // 186: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 189: return
   }

   @Override
   public synchronized void z$eqd7gcilc76w(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 08: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 0b: iload 2
      // 0c: ifne 23
      // 0f: ifne 17
      // 12: goto 16
      // 15: athrow
      // 16: return
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 28
      // 1c: getfield x/oca0802ec324.Զ Z
      // 1f: goto 23
      // 22: athrow
      // 23: ifne 27
      // 26: return
      // 27: aload 0
      // 28: iload 2
      // 29: ifne 3e
      // 2c: invokevirtual x/oca0802ec324.đ ()Z
      // 2f: ifeq 3d
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: bipush 1
      // 38: invokevirtual x/oca0802ec324.ρ (Z)V
      // 3b: return
      // 3c: athrow
      // 3d: aload 0
      // 3e: getfield x/oca0802ec324.ĉ Ljava/util/Deque;
      // 41: aload 1
      // 42: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 45: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 48: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 4d: aload 1
      // 4e: bipush 1
      // 4f: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 52: return
   }

   @Override
   public synchronized void z$1ygb8gyji3zuv(oc6c7463093f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 19
      // 09: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 0c: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 0f: ifne 18
      // 12: goto 16
      // 15: athrow
      // 16: return
      // 17: athrow
      // 18: aload 1
      // 19: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 1c: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 1f: invokestatic x/oca0802ec324.գ (Lnet/minecraft/network/play/client/C0FPacketConfirmTransaction;)J
      // 22: lstore 3
      // 23: aload 0
      // 24: getfield x/oca0802ec324.Ո Ljava/util/Set;
      // 27: lload 3
      // 28: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 2b: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 30: iload 2
      // 31: ifne 4a
      // 34: pop
      // 35: aload 0
      // 36: getfield x/oca0802ec324.Ӧ Z
      // 39: ifeq 55
      // 3c: goto 40
      // 3f: athrow
      // 40: lload 3
      // 41: aload 0
      // 42: getfield x/oca0802ec324.Ţ J
      // 45: lcmp
      // 46: goto 4a
      // 49: athrow
      // 4a: iload 2
      // 4b: ifne 62
      // 4e: ifeq 56
      // 51: goto 55
      // 54: athrow
      // 55: return
      // 56: aload 0
      // 57: iload 2
      // 58: ifne 6d
      // 5b: invokevirtual x/oca0802ec324.đ ()Z
      // 5e: goto 62
      // 61: athrow
      // 62: ifeq 6c
      // 65: aload 0
      // 66: bipush 1
      // 67: invokevirtual x/oca0802ec324.ρ (Z)V
      // 6a: return
      // 6b: athrow
      // 6c: aload 0
      // 6d: iload 2
      // 6e: ifne 96
      // 71: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 74: ifnull 91
      // 77: goto 7b
      // 7a: athrow
      // 7b: aload 0
      // 7c: iload 2
      // 7d: ifne be
      // 80: goto 84
      // 83: athrow
      // 84: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 87: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8a: ifnonnull 9b
      // 8d: goto 91
      // 90: athrow
      // 91: aload 0
      // 92: goto 96
      // 95: athrow
      // 96: bipush 1
      // 97: invokevirtual x/oca0802ec324.ρ (Z)V
      // 9a: return
      // 9b: aload 0
      // 9c: bipush 0
      // 9d: putfield x/oca0802ec324.Ӧ Z
      // a0: aload 0
      // a1: bipush 1
      // a2: putfield x/oca0802ec324.Զ Z
      // a5: aload 0
      // a6: bipush 0
      // a7: putfield x/oca0802ec324.ѭ I
      // aa: aload 0
      // ab: bipush 0
      // ac: putfield x/oca0802ec324.ǿ I
      // af: aload 0
      // b0: aload 0
      // b1: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // b4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // b7: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // ba: putfield x/oca0802ec324.Û D
      // bd: aload 0
      // be: ldc2_w 8147529164953989718
      // c1: ldc2_w -1075842871900786090
      // c4: lxor
      // c5: putfield x/oca0802ec324.Ţ J
      // c8: return
   }

   @Override
   public synchronized void z$2chcnix6dewx9(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 19
      // 09: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: aconst_null
      // 14: goto 1f
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 1c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f: astore 3
      // 20: aload 0
      // 21: getfield x/oca0802ec324.Զ Z
      // 24: ifeq 2f
      // 27: aload 3
      // 28: ifnonnull 31
      // 2b: goto 2f
      // 2e: athrow
      // 2f: return
      // 30: athrow
      // 31: aload 0
      // 32: iload 2
      // 33: ifne 5f
      // 36: invokevirtual x/oca0802ec324.đ ()Z
      // 39: ifne 5a
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: iload 2
      // 42: ifne 65
      // 45: goto 49
      // 48: athrow
      // 49: getfield x/oca0802ec324.ѭ I
      // 4c: ldc_w 649187178
      // 4f: ldc_w 649186610
      // 52: ixor
      // 53: if_icmplt 64
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: goto 5f
      // 5e: athrow
      // 5f: bipush 1
      // 60: invokevirtual x/oca0802ec324.ρ (Z)V
      // 63: return
      // 64: aload 0
      // 65: iload 2
      // 66: ifne 7b
      // 69: invokevirtual x/oca0802ec324.ƙ ()Z
      // 6c: ifeq 7a
      // 6f: goto 73
      // 72: athrow
      // 73: aload 0
      // 74: aload 3
      // 75: invokevirtual x/oca0802ec324.ӿ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 78: return
      // 79: athrow
      // 7a: aload 0
      // 7b: aload 3
      // 7c: invokevirtual x/oca0802ec324.Ǒ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 7f: return
   }

   private void Ǒ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 3f
      // 09: dup
      // 0a: getfield x/oca0802ec324.ѭ I
      // 0d: bipush 1
      // 0e: iadd
      // 0f: putfield x/oca0802ec324.ѭ I
      // 12: aload 0
      // 13: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 16: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 19: ifnull 3e
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: iload 2
      // 22: ifne 3f
      // 25: goto 29
      // 28: athrow
      // 29: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 2c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 2f: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 32: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 35: ifeq 3e
      // 38: goto 3c
      // 3b: athrow
      // 3c: return
      // 3d: athrow
      // 3e: aload 0
      // 3f: getfield x/oca0802ec324.ǿ I
      // 42: iload 2
      // 43: ifne 67
      // 46: aload 0
      // 47: getfield x/oc6031c5c531.Ȓ Lx/ocdacba68ccd;
      // 4a: invokevirtual x/ocdacba68ccd.M ()I
      // 4d: if_icmplt 5b
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: bipush 1
      // 56: invokevirtual x/oca0802ec324.ρ (Z)V
      // 59: return
      // 5a: athrow
      // 5b: aload 1
      // 5c: iload 2
      // 5d: ifne 6b
      // 60: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 63: goto 67
      // 66: athrow
      // 67: ifeq 7d
      // 6a: aload 1
      // 6b: getfield net/minecraft/client/entity/EntityPlayerSP.isCollidedVertically Z
      // 6e: iload 2
      // 6f: ifne 7a
      // 72: ifeq 7d
      // 75: goto 79
      // 78: athrow
      // 79: bipush 1
      // 7a: goto 7e
      // 7d: bipush 0
      // 7e: istore 3
      // 7f: aload 1
      // 80: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 83: ldc2_w -0.03125
      // 86: iload 2
      // 87: ifne a2
      // 8a: dcmpg
      // 8b: ifgt b2
      // 8e: goto 92
      // 91: athrow
      // 92: aload 1
      // 93: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 96: aload 0
      // 97: getfield x/oca0802ec324.Û D
      // 9a: ldc2_w 0.05
      // 9d: dadd
      // 9e: goto a2
      // a1: athrow
      // a2: dcmpg
      // a3: iload 2
      // a4: ifne af
      // a7: ifgt b2
      // aa: goto ae
      // ad: athrow
      // ae: bipush 1
      // af: goto b3
      // b2: bipush 0
      // b3: istore 4
      // b5: iload 2
      // b6: ifne f6
      // b9: aload 0
      // ba: getfield x/oca0802ec324.ǿ I
      // bd: ifle da
      // c0: goto c4
      // c3: athrow
      // c4: iload 3
      // c5: iload 2
      // c6: ifne d6
      // c9: goto cd
      // cc: athrow
      // cd: ifne da
      // d0: goto d4
      // d3: athrow
      // d4: iload 4
      // d6: ifne da
      // d9: return
      // da: aload 0
      // db: aload 1
      // dc: invokevirtual x/oca0802ec324.Ŵ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // df: aload 1
      // e0: fconst_0
      // e1: putfield net/minecraft/client/entity/EntityPlayerSP.fallDistance F
      // e4: aload 0
      // e5: aload 1
      // e6: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // e9: putfield x/oca0802ec324.Û D
      // ec: aload 0
      // ed: dup
      // ee: getfield x/oca0802ec324.ǿ I
      // f1: bipush 1
      // f2: iadd
      // f3: putfield x/oca0802ec324.ǿ I
      // f6: return
   }

   private void ӿ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 1
      // 05: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 08: iload 2
      // 09: ifne 28
      // 0c: ifeq 1c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: bipush 0
      // 15: putfield x/oca0802ec324.ѭ I
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: iload 2
      // 1e: ifne 34
      // 21: getfield x/oca0802ec324.ѭ I
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: getfield x/oca0802ec324.ʡ I
      // 2c: if_icmpge 61
      // 2f: aload 0
      // 30: goto 34
      // 33: athrow
      // 34: iload 2
      // 35: ifne 6e
      // 38: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 3b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 3e: ifnull 63
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: iload 2
      // 47: ifne 6e
      // 4a: goto 4e
      // 4d: athrow
      // 4e: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 51: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 54: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 57: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 5a: ifeq 63
      // 5d: goto 61
      // 60: athrow
      // 61: return
      // 62: athrow
      // 63: aload 0
      // 64: dup
      // 65: getfield x/oca0802ec324.ѭ I
      // 68: bipush 1
      // 69: iadd
      // 6a: putfield x/oca0802ec324.ѭ I
      // 6d: aload 0
      // 6e: aload 1
      // 6f: invokevirtual x/oca0802ec324.Ŵ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 72: aload 1
      // 73: fconst_0
      // 74: putfield net/minecraft/client/entity/EntityPlayerSP.fallDistance F
      // 77: return
   }

   @Override
   public synchronized void z$rvfg1nz4abtc(ocbab3c9954b var1) {
      this.ö();
      this.Ԉ();
   }

   private void ρ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: bipush 0
      // 02: putfield x/oca0802ec324.Զ Z
      // 05: getstatic x/oc47731c13e2.ů I
      // 08: aload 0
      // 09: bipush 0
      // 0a: putfield x/oca0802ec324.Ӧ Z
      // 0d: aload 0
      // 0e: bipush 0
      // 0f: putfield x/oca0802ec324.ѭ I
      // 12: istore 2
      // 13: aload 0
      // 14: bipush 0
      // 15: putfield x/oca0802ec324.ǿ I
      // 18: aload 0
      // 19: iload 2
      // 1a: ifne 5e
      // 1d: bipush 0
      // 1e: putfield x/oca0802ec324.ʡ I
      // 21: aload 0
      // 22: lconst_0
      // 23: putfield x/oca0802ec324.Т J
      // 26: aload 0
      // 27: ldc2_w -3097248854224745345
      // 2a: ldc2_w 6126123182630030463
      // 2d: lxor
      // 2e: putfield x/oca0802ec324.Ţ J
      // 31: aload 0
      // 32: dconst_0
      // 33: putfield x/oca0802ec324.ȍ D
      // 36: aload 0
      // 37: dconst_0
      // 38: putfield x/oca0802ec324.Ȥ D
      // 3b: aload 0
      // 3c: dconst_0
      // 3d: putfield x/oca0802ec324.ª D
      // 40: aload 0
      // 41: dconst_0
      // 42: putfield x/oca0802ec324.Û D
      // 45: iload 1
      // 46: ifeq 59
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 0
      // 4e: invokevirtual x/oca0802ec324.Ђ ()V
      // 51: iload 2
      // 52: ifeq 66
      // 55: goto 59
      // 58: athrow
      // 59: aload 0
      // 5a: goto 5e
      // 5d: athrow
      // 5e: getfield x/oca0802ec324.ĉ Ljava/util/Deque;
      // 61: invokeinterface java/util/Deque.clear ()V 1
      // 66: return
   }

   private void ö() {
      this.ρ(false);
   }

   private void Ԉ() {
      this.Ո.clear();
      this.č = false;
      this.Ӵ = 9023615820551514268L ^ -199756216303261540L;
   }

   private void Ǉ(S32PacketConfirmTransaction param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 26
      // 09: invokevirtual net/minecraft/network/play/server/S32PacketConfirmTransaction.func_148888_e ()Z
      // 0c: ifeq 25
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: bipush 0
      // 15: putfield x/oca0802ec324.č Z
      // 18: aload 0
      // 19: ldc2_w 5984192123428333263
      // 1c: ldc2_w -3239179913426442545
      // 1f: lxor
      // 20: putfield x/oca0802ec324.Ӵ J
      // 23: return
      // 24: athrow
      // 25: aload 1
      // 26: invokestatic x/oca0802ec324.Ƈ (Lnet/minecraft/network/play/server/S32PacketConfirmTransaction;)J
      // 29: lstore 3
      // 2a: aload 0
      // 2b: iload 2
      // 2c: ifne a5
      // 2f: getfield x/oca0802ec324.Ո Ljava/util/Set;
      // 32: invokeinterface java/util/Set.size ()I 1
      // 37: ldc_w -824796257
      // 3a: ldc_w -824796513
      // 3d: ixor
      // 3e: if_icmplt 91
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: getfield x/oca0802ec324.Ո Ljava/util/Set;
      // 49: lload 3
      // 4a: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 4d: iload 2
      // 4e: ifne 99
      // 51: goto 55
      // 54: athrow
      // 55: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 5a: ifne 91
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: getfield x/oca0802ec324.Ո Ljava/util/Set;
      // 65: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 6a: astore 5
      // 6c: iload 2
      // 6d: ifne a9
      // 70: aload 5
      // 72: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 77: ifeq 91
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 5
      // 80: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 85: pop
      // 86: aload 5
      // 88: invokeinterface java/util/Iterator.remove ()V 1
      // 8d: goto 91
      // 90: athrow
      // 91: aload 0
      // 92: getfield x/oca0802ec324.Ո Ljava/util/Set;
      // 95: lload 3
      // 96: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 99: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 9e: pop
      // 9f: aload 0
      // a0: bipush 1
      // a1: putfield x/oca0802ec324.č Z
      // a4: aload 0
      // a5: lload 3
      // a6: putfield x/oca0802ec324.Ӵ J
      // a9: return
   }

   private boolean đ() {
      int var1 = oc47731c13e2.ů;
      int var2 = 979358156 ^ -1260785899;

      while (true) {
         switch (var2) {
            case -2053763778:
               return true;
            case -1903804711:
               int var10000;
               label29: {
                  label28: {
                     try {
                        long var4;
                        var10000 = (var4 = System.nanoTime() - this.Т - я) == 0L ? 0 : (var4 < 0L ? -1 : 1);
                        if (var1 != 0) {
                           break label29;
                        }

                        if (var10000 < 0) {
                           break label28;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 827318827 ^ -1260785899;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -278838222 ^ -1260785899;
               }

               var2 = var10000;
               break;
            case 1538829095:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ƙ() {
      int var1 = oc47731c13e2.ů;
      int var2 = 634153988 ^ -70074250;

      while (true) {
         switch (var2) {
            case -1397797320:
               return true;
            case -568415118:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.м.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 1) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1467846222 ^ -70074250;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1157281782 ^ -70074250;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 1087867004:
               return false;
            default:
               throw null;
         }
      }
   }

   private void Ŵ(EntityPlayerSP var1) {
      var1.motionX = this.ȍ;
      var1.motionY = this.Ȥ;
      var1.motionZ = this.ª;
   }

   private static int ʰ(double param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: dload 0
      // 04: dstore 3
      // 05: bipush 0
      // 06: istore 5
      // 08: istore 2
      // 09: dload 3
      // 0a: ldc2_w -0.03125
      // 0d: dcmpl
      // 0e: iflt 3e
      // 11: iload 5
      // 13: iload 2
      // 14: ifne 52
      // 17: iload 2
      // 18: ifne 52
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ldc_w -1062647629
      // 22: ldc_w -1062647563
      // 25: ixor
      // 26: if_icmpge 3e
      // 29: goto 2d
      // 2c: athrow
      // 2d: dload 3
      // 2e: ldc2_w 0.08
      // 31: dsub
      // 32: ldc2_w 0.98
      // 35: dmul
      // 36: dstore 3
      // 37: iload 2
      // 38: iinc 5 1
      // 3b: ifeq 09
      // 3e: ldc_w -1062647555
      // 41: ldc_w -1062647563
      // 44: ixor
      // 45: iload 5
      // 47: ldc_w -1062647561
      // 4a: ldc_w -1062647563
      // 4d: ixor
      // 4e: iadd
      // 4f: invokestatic java/lang/Math.max (II)I
      // 52: ireturn
   }

   private void Ђ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 2e
      // 09: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0c: ifnull 29
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 40
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 1f: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 22: ifnonnull 37
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oca0802ec324.ĉ Ljava/util/Deque;
      // 31: invokeinterface java/util/Deque.clear ()V 1
      // 36: return
      // 37: aload 0
      // 38: getfield x/oca0802ec324.ĉ Ljava/util/Deque;
      // 3b: invokeinterface java/util/Deque.pollFirst ()Ljava/lang/Object; 1
      // 40: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 43: dup
      // 44: astore 2
      // 45: ifnull 54
      // 48: aload 2
      // 49: invokestatic x/ocd6ae010123.ĕ (Lnet/minecraft/network/Packet;)V
      // 4c: iload 1
      // 4d: ifeq 37
      // 50: goto 54
      // 53: athrow
      // 54: return
   }

   private static long Ƈ(S32PacketConfirmTransaction var0) {
      return Ǒ(var0.getWindowId(), var0.getActionNumber());
   }

   private static long գ(C0FPacketConfirmTransaction var0) {
      return Ǒ(var0.getWindowId(), var0.getUid());
   }

   private static long Ǒ(int var0, short var1) {
      return (long)var0 << (205369808 ^ 205369792) | var1 & (6678226835492568143L ^ 6678226835492504496L);
   }

   static {
      String[] var10000 = new String[-308940696 ^ -308940694];
      var10000[0] = "Flat";
      var10000[1] = "High";
      Ҹ = var10000;
   }
}
