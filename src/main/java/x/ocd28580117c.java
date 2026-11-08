package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

public class ocd28580117c extends oc6031c5c531 {
   private static final String[] ѷ;
   private static final int Ю = 8;
   private static final int ռ = 8;
   private static final int Ɔ = 10;
   private static final int Ø = 30;
   private static final int Բ = 600;
   private static final int v = 128;
   private static final double ż = 0.03;
   private static final double ɯ = 0.0;
   private static final double Ĩ = 0.05;
   private static final long ß = Long.MIN_VALUE;
   public final oca9cc61aada Ӊ;
   public final oca9cc61aada Ƴ;
   private final oc47731c13e2 Ʉ;
   private final Deque<C0FPacketConfirmTransaction> Ŗ;
   private final Set<Long> Õ;
   private oca2018bee26 ӧ;
   private ocda5f5fdb38 ʨ;
   private boolean ʈ;
   private int Ǜ;
   private int Ծ;
   private int ŷ;
   private int Ö;
   private int ϱ;
   private int p;
   private int Տ;
   private int Δ;
   private float π;
   private long ȣ;
   private long Ҭ;
   private double վ;
   private double Ɖ;
   private double Ƽ;
   private int Ӏ;
   private boolean Ӿ;
   public static int Ŵ;

   public ocd28580117c(ocdacba68ccd var1) {
      super("GrimFireBall", var1);
      this.Ӊ = new oca9cc61aada("Mode", 0, ѷ);
      this.Ƴ = new oca9cc61aada("Loops", 2.0, 1.0, 10.0, 1.0);
      this.Ŗ = new ArrayDeque<>();
      this.Õ = new LinkedHashSet<>();
      this.ӧ = oca2018bee26.Γ;
      this.ʨ = ocda5f5fdb38.ͼ;
      this.ϱ = -1;
      this.Տ = -1;
      this.Δ = -1;
      this.ȣ = 1865167530679142122L ^ -7358204506175633686L;
      this.Ҭ = 1865167530679142122L ^ -7358204506175633686L;
      this.Ʉ = new oc47731c13e2(var1);
      this.Ʉ.ϊ.Ȟ(1.0);
      this.Ӏ = this.ƅ();
   }

   @Override
   public boolean z$th2zwshf7gtl() {
      return false;
   }

   @Override
   public void z$3g18l332rzhcd(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: aload 0
      // 04: invokevirtual x/ocd28580117c.ǭ ()V
      // 07: istore 2
      // 08: aload 0
      // 09: getfield x/ocd28580117c.Ӊ Lx/oca9cc61aada;
      // 0c: iload 1
      // 0d: iload 2
      // 0e: ifne 2c
      // 11: aload 0
      // 12: getfield x/oc6031c5c531.Ȓ Lx/ocdacba68ccd;
      // 15: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 18: aload 0
      // 19: getfield x/ocd28580117c.Ƴ Lx/oca9cc61aada;
      // 1c: iload 1
      // 1d: ifeq 3b
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: getfield x/ocd28580117c.Ӏ I
      // 28: goto 2c
      // 2b: athrow
      // 2c: iload 2
      // 2d: ifne 38
      // 30: ifne 3b
      // 33: goto 37
      // 36: athrow
      // 37: bipush 1
      // 38: goto 3c
      // 3b: bipush 0
      // 3c: aload 0
      // 3d: getfield x/oc6031c5c531.Ȓ Lx/ocdacba68ccd;
      // 40: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 43: iload 2
      // 44: ifeq 58
      // 47: bipush 0
      // 48: ifeq 54
      // 4b: goto 4f
      // 4e: athrow
      // 4f: bipush 0
      // 50: goto 55
      // 53: athrow
      // 54: bipush 1
      // 55: putstatic x/oc69da1aa7f5.Ҭ Z
      // 58: return
   }

   @Override
   public synchronized void z$30uo8shdqe5to() {
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
      // 06: ifne 28
      // 09: aload 0
      // 0a: invokevirtual x/ocd28580117c.ƅ ()I
      // 0d: putfield x/ocd28580117c.Ӏ I
      // 10: aload 0
      // 11: bipush 1
      // 12: putfield x/ocd28580117c.Ӿ Z
      // 15: aload 0
      // 16: getfield x/ocd28580117c.Ӏ I
      // 19: bipush 1
      // 1a: if_icmpne 27
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: invokevirtual x/ocd28580117c.Ɉ ()V
      // 25: return
      // 26: athrow
      // 27: aload 0
      // 28: invokevirtual x/ocd28580117c.Ҷ ()V
      // 2b: bipush 0
      // 2c: ifeq 3a
      // 2f: iinc 1 1
      // 32: iload 1
      // 33: putstatic x/oc47731c13e2.ů I
      // 36: goto 3a
      // 39: athrow
      // 3a: return
   }

   private void Ҷ() {
      this.Ǖ();
      this.Ŗ.clear();
      this.J();
   }

   @Override
   public synchronized void z$1q0da71f8mrae() {
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
      // 06: ifne 28
      // 09: getfield x/ocd28580117c.Ӏ I
      // 0c: bipush 1
      // 0d: if_icmpne 23
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 18: invokevirtual x/oc47731c13e2.z$1q0da71f8mrae ()V
      // 1b: iload 1
      // 1c: ifeq 2b
      // 1f: goto 23
      // 22: athrow
      // 23: aload 0
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual x/ocd28580117c.ě ()V
      // 2b: aload 0
      // 2c: bipush 0
      // 2d: putfield x/ocd28580117c.Ӿ Z
      // 30: return
   }

   private void ě() {
      this.ɨ();
      this.Ǖ();
      this.ę();
      this.J();
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
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1d
      // 09: invokevirtual x/ocd28580117c.ǭ ()V
      // 0c: aload 0
      // 0d: getfield x/ocd28580117c.Ӏ I
      // 10: bipush 1
      // 11: if_icmpne 25
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: goto 1d
      // 1c: athrow
      // 1d: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 20: aload 1
      // 21: invokevirtual x/oc47731c13e2.z$28gl8df6dqh8o (Lx/oce79181588d;)V
      // 24: return
      // 25: aload 1
      // 26: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 29: astore 3
      // 2a: iload 2
      // 2b: ifne 45
      // 2e: aload 3
      // 2f: instanceof net/minecraft/network/play/server/S32PacketConfirmTransaction
      // 32: ifeq 46
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: aload 3
      // 3b: checkcast net/minecraft/network/play/server/S32PacketConfirmTransaction
      // 3e: invokevirtual x/ocd28580117c.Գ (Lnet/minecraft/network/play/server/S32PacketConfirmTransaction;)V
      // 41: goto 45
      // 44: athrow
      // 45: return
      // 46: aload 0
      // 47: invokevirtual x/ocd28580117c.п ()J
      // 4a: lstore 4
      // 4c: aload 3
      // 4d: iload 2
      // 4e: ifne 62
      // 51: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 54: ifeq 61
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 0
      // 5c: invokevirtual x/ocd28580117c.m ()V
      // 5f: return
      // 60: athrow
      // 61: aload 3
      // 62: iload 2
      // 63: ifne 7e
      // 66: instanceof net/minecraft/network/play/server/S12PacketEntityVelocity
      // 69: ifeq 7d
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 0
      // 71: aload 1
      // 72: aload 3
      // 73: checkcast net/minecraft/network/play/server/S12PacketEntityVelocity
      // 76: lload 4
      // 78: invokevirtual x/ocd28580117c.V (Lx/oce79181588d;Lnet/minecraft/network/play/server/S12PacketEntityVelocity;J)V
      // 7b: return
      // 7c: athrow
      // 7d: aload 3
      // 7e: instanceof net/minecraft/network/play/server/S27PacketExplosion
      // 81: ifeq 92
      // 84: aload 0
      // 85: aload 3
      // 86: checkcast net/minecraft/network/play/server/S27PacketExplosion
      // 89: lload 4
      // 8b: invokevirtual x/ocd28580117c.Ƕ (Lnet/minecraft/network/play/server/S27PacketExplosion;J)V
      // 8e: goto 92
      // 91: athrow
      // 92: return
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
      // 03: aload 0
      // 04: invokevirtual x/ocd28580117c.ǭ ()V
      // 07: istore 2
      // 08: aload 0
      // 09: getfield x/ocd28580117c.Ӏ I
      // 0c: iload 2
      // 0d: ifne 29
      // 10: bipush 1
      // 11: if_icmpne 22
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 1c: aload 1
      // 1d: invokevirtual x/oc47731c13e2.z$eqd7gcilc76w (Lx/oc9d4393f3ce;)V
      // 20: return
      // 21: athrow
      // 22: aload 1
      // 23: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 26: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 29: iload 2
      // 2a: ifne 3c
      // 2d: ifeq 3f
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: invokevirtual x/ocd28580117c.Ē ()Z
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifne 40
      // 3f: return
      // 40: aload 1
      // 41: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 44: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 47: astore 3
      // 48: iload 2
      // 49: aload 3
      // 4a: invokestatic x/ocd28580117c.Ƅ (Lnet/minecraft/network/play/client/C0FPacketConfirmTransaction;)J
      // 4d: lstore 4
      // 4f: ifne 7f
      // 52: aload 0
      // 53: getfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 56: getstatic x/ocda5f5fdb38.І Lx/ocda5f5fdb38;
      // 59: if_acmpne 70
      // 5c: goto 60
      // 5f: athrow
      // 60: lload 4
      // 62: aload 0
      // 63: getfield x/ocd28580117c.ȣ J
      // 66: lcmp
      // 67: ifne 70
      // 6a: goto 6e
      // 6d: athrow
      // 6e: return
      // 6f: athrow
      // 70: aload 0
      // 71: getfield x/ocd28580117c.Ŗ Ljava/util/Deque;
      // 74: aload 3
      // 75: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 7a: aload 1
      // 7b: bipush 1
      // 7c: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 7f: return
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
      // 03: aload 0
      // 04: invokevirtual x/ocd28580117c.ǭ ()V
      // 07: istore 2
      // 08: aload 0
      // 09: getfield x/ocd28580117c.Ӏ I
      // 0c: iload 2
      // 0d: ifne 31
      // 10: bipush 1
      // 11: if_icmpne 22
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 1c: aload 1
      // 1d: invokevirtual x/oc47731c13e2.z$1ygb8gyji3zuv (Lx/oc6c7463093f;)V
      // 20: return
      // 21: athrow
      // 22: aload 1
      // 23: iload 2
      // 24: ifne 36
      // 27: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 2a: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 2d: goto 31
      // 30: athrow
      // 31: ifne 35
      // 34: return
      // 35: aload 1
      // 36: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 39: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 3c: invokestatic x/ocd28580117c.Ƅ (Lnet/minecraft/network/play/client/C0FPacketConfirmTransaction;)J
      // 3f: lstore 3
      // 40: aload 0
      // 41: getfield x/ocd28580117c.Õ Ljava/util/Set;
      // 44: lload 3
      // 45: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 48: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 4d: iload 2
      // 4e: ifne 6a
      // 51: pop
      // 52: aload 0
      // 53: getfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 56: getstatic x/ocda5f5fdb38.І Lx/ocda5f5fdb38;
      // 59: if_acmpne 75
      // 5c: goto 60
      // 5f: athrow
      // 60: lload 3
      // 61: aload 0
      // 62: getfield x/ocd28580117c.ȣ J
      // 65: lcmp
      // 66: goto 6a
      // 69: athrow
      // 6a: ifne 75
      // 6d: aload 0
      // 6e: invokevirtual x/ocd28580117c.ǿ ()V
      // 71: goto 75
      // 74: athrow
      // 75: return
   }

   @Override
   public synchronized void z$2chcnix6dewx9(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 23
      // 09: invokevirtual x/ocd28580117c.ǭ ()V
      // 0c: aload 0
      // 0d: getfield x/ocd28580117c.Ӏ I
      // 10: bipush 1
      // 11: if_icmpne 22
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 1c: aload 1
      // 1d: invokevirtual x/oc47731c13e2.z$2chcnix6dewx9 (Lx/oc2f61de30bc;)V
      // 20: return
      // 21: athrow
      // 22: aload 0
      // 23: iload 2
      // 24: ifne 37
      // 27: getfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 2a: getstatic x/ocda5f5fdb38.ͼ Lx/ocda5f5fdb38;
      // 2d: if_acmpne 36
      // 30: goto 34
      // 33: athrow
      // 34: return
      // 35: athrow
      // 36: aload 0
      // 37: iload 2
      // 38: ifne 5a
      // 3b: dup
      // 3c: getfield x/ocd28580117c.Ծ I
      // 3f: bipush 1
      // 40: iadd
      // 41: dup_x1
      // 42: putfield x/ocd28580117c.Ծ I
      // 45: ldc_w 494040440
      // 48: ldc_w 494040864
      // 4b: ixor
      // 4c: if_icmplt 59
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: invokevirtual x/ocd28580117c.m ()V
      // 57: return
      // 58: athrow
      // 59: aload 0
      // 5a: invokevirtual x/ocd28580117c.Ϊ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5d: astore 3
      // 5e: iload 2
      // 5f: ifne 90
      // 62: aload 3
      // 63: ifnull 88
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 3
      // 6b: iload 2
      // 6c: ifne 85
      // 6f: goto 73
      // 72: athrow
      // 73: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 76: ifne 88
      // 79: goto 7d
      // 7c: athrow
      // 7d: aload 3
      // 7e: getfield net/minecraft/client/entity/EntityPlayerSP.ridingEntity Lnet/minecraft/entity/Entity;
      // 81: goto 85
      // 84: athrow
      // 85: ifnull 91
      // 88: aload 0
      // 89: invokevirtual x/ocd28580117c.m ()V
      // 8c: goto 90
      // 8f: athrow
      // 90: return
      // 91: getstatic x/ocab38ebbb71.Ι [I
      // 94: aload 0
      // 95: getfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 98: invokevirtual java/lang/Enum.ordinal ()I
      // 9b: iaload
      // 9c: tableswitch 95 1 5 36 49 61 74 87
      // c0: aload 0
      // c1: aload 3
      // c2: invokevirtual x/ocd28580117c.ҵ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // c5: iload 2
      // c6: ifeq fb
      // c9: goto cd
      // cc: athrow
      // cd: aload 0
      // ce: invokevirtual x/ocd28580117c.Ώ ()V
      // d1: iload 2
      // d2: ifeq fb
      // d5: goto d9
      // d8: athrow
      // d9: aload 0
      // da: aload 3
      // db: invokevirtual x/ocd28580117c.ԡ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // de: iload 2
      // df: ifeq fb
      // e2: goto e6
      // e5: athrow
      // e6: aload 0
      // e7: aload 3
      // e8: invokevirtual x/ocd28580117c.Ԇ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // eb: iload 2
      // ec: ifeq fb
      // ef: goto f3
      // f2: athrow
      // f3: aload 0
      // f4: invokevirtual x/ocd28580117c.ć ()V
      // f7: goto fb
      // fa: athrow
      // fb: return
   }

   @Override
   public synchronized void z$f8mk1haurfvq(oc25aa89b91f param1) {
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
      // 06: ifne 23
      // 09: invokevirtual x/ocd28580117c.ǭ ()V
      // 0c: aload 0
      // 0d: getfield x/ocd28580117c.Ӏ I
      // 10: bipush 1
      // 11: if_icmpne 22
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 1c: aload 1
      // 1d: invokevirtual x/oc6031c5c531.z$f8mk1haurfvq (Lx/oc25aa89b91f;)V
      // 20: return
      // 21: athrow
      // 22: aload 0
      // 23: invokevirtual x/ocd28580117c.Ϊ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26: astore 3
      // 27: aload 3
      // 28: ifnull 35
      // 2b: aload 0
      // 2c: aload 1
      // 2d: aload 3
      // 2e: invokevirtual x/ocd28580117c.ď (Lx/oc25aa89b91f;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 31: goto 35
      // 34: athrow
      // 35: return
   }

   @Override
   public synchronized void z$rvfg1nz4abtc(ocbab3c9954b param1) {
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
      // 06: ifne 2c
      // 09: getfield x/ocd28580117c.Ӏ I
      // 0c: bipush 1
      // 0d: if_icmpne 1e
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 18: aload 1
      // 19: invokevirtual x/oc47731c13e2.z$rvfg1nz4abtc (Lx/ocbab3c9954b;)V
      // 1c: return
      // 1d: athrow
      // 1e: aload 0
      // 1f: invokevirtual x/ocd28580117c.Ǖ ()V
      // 22: aload 0
      // 23: getfield x/ocd28580117c.Ŗ Ljava/util/Deque;
      // 26: invokeinterface java/util/Deque.clear ()V 1
      // 2b: aload 0
      // 2c: invokevirtual x/ocd28580117c.J ()V
      // 2f: return
   }

   private void ǭ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: aload 0
      // 04: invokevirtual x/ocd28580117c.ƅ ()I
      // 07: istore 2
      // 08: istore 1
      // 09: iload 2
      // 0a: iload 1
      // 0b: ifne 27
      // 0e: aload 0
      // 0f: getfield x/ocd28580117c.Ӏ I
      // 12: if_icmpne 1b
      // 15: goto 19
      // 18: athrow
      // 19: return
      // 1a: athrow
      // 1b: aload 0
      // 1c: iload 1
      // 1d: ifne 63
      // 20: getfield x/ocd28580117c.Ӿ Z
      // 23: goto 27
      // 26: athrow
      // 27: ifeq 55
      // 2a: aload 0
      // 2b: iload 1
      // 2c: ifne 52
      // 2f: goto 33
      // 32: athrow
      // 33: getfield x/ocd28580117c.Ӏ I
      // 36: bipush 1
      // 37: if_icmpne 4d
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: getfield x/ocd28580117c.Ʉ Lx/oc47731c13e2;
      // 42: invokevirtual x/oc47731c13e2.z$1q0da71f8mrae ()V
      // 45: iload 1
      // 46: ifeq 55
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 0
      // 4e: goto 52
      // 51: athrow
      // 52: invokevirtual x/ocd28580117c.ě ()V
      // 55: aload 0
      // 56: iload 1
      // 57: ifne 6e
      // 5a: iload 2
      // 5b: putfield x/ocd28580117c.Ӏ I
      // 5e: aload 0
      // 5f: goto 63
      // 62: athrow
      // 63: getfield x/ocd28580117c.Ӿ Z
      // 66: ifeq 91
      // 69: aload 0
      // 6a: goto 6e
      // 6d: athrow
      // 6e: iload 1
      // 6f: ifne 8e
      // 72: getfield x/ocd28580117c.Ӏ I
      // 75: bipush 1
      // 76: if_icmpne 89
      // 79: goto 7d
      // 7c: athrow
      // 7d: aload 0
      // 7e: invokevirtual x/ocd28580117c.Ɉ ()V
      // 81: iload 1
      // 82: ifeq 91
      // 85: goto 89
      // 88: athrow
      // 89: aload 0
      // 8a: goto 8e
      // 8d: athrow
      // 8e: invokevirtual x/ocd28580117c.Ҷ ()V
      // 91: return
   }

   private void Ɉ() {
      this.Ʉ.ϊ.Ȟ(1.0);
      this.Ʉ.z$30uo8shdqe5to();
   }

   private int ƅ() {
      return Math.max(0, Math.min(1, (int)this.Ӊ.Ӂ()));
   }

   private void V(oce79181588d param1, S12PacketEntityVelocity param2, long param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: aload 0
      // 04: invokevirtual x/ocd28580117c.Ϊ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07: astore 6
      // 09: istore 5
      // 0b: aload 6
      // 0d: ifnull 29
      // 10: aload 2
      // 11: iload 5
      // 13: ifne 2c
      // 16: goto 1a
      // 19: athrow
      // 1a: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getEntityID ()I
      // 1d: aload 6
      // 1f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityId ()I
      // 22: if_icmpeq 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: aload 2
      // 2c: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionX ()I
      // 2f: i2d
      // 30: ldc2_w 8000.0
      // 33: ddiv
      // 34: dstore 7
      // 36: aload 2
      // 37: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionY ()I
      // 3a: i2d
      // 3b: ldc2_w 8000.0
      // 3e: ddiv
      // 3f: dstore 9
      // 41: aload 2
      // 42: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionZ ()I
      // 45: i2d
      // 46: ldc2_w 8000.0
      // 49: ddiv
      // 4a: dstore 11
      // 4c: aload 0
      // 4d: getstatic x/oca2018bee26.Ζ Lx/oca2018bee26;
      // 50: lload 3
      // 51: dload 7
      // 53: dload 9
      // 55: dload 11
      // 57: invokevirtual x/ocd28580117c.ǩ (Lx/oca2018bee26;JDDD)Z
      // 5a: ifeq 66
      // 5d: aload 1
      // 5e: bipush 1
      // 5f: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 62: goto 66
      // 65: athrow
      // 66: return
   }

   private void Ƕ(S27PacketExplosion param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: aload 1
      // 04: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.func_149149_c ()F
      // 07: f2d
      // 08: dstore 5
      // 0a: istore 4
      // 0c: aload 1
      // 0d: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.func_149144_d ()F
      // 10: f2d
      // 11: dstore 7
      // 13: iload 4
      // 15: aload 1
      // 16: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.func_149147_e ()F
      // 19: f2d
      // 1a: dstore 9
      // 1c: ifne 45
      // 1f: aload 0
      // 20: getstatic x/oca2018bee26.ҫ Lx/oca2018bee26;
      // 23: lload 2
      // 24: dload 5
      // 26: dload 7
      // 28: dload 9
      // 2a: invokevirtual x/ocd28580117c.ǩ (Lx/oca2018bee26;JDDD)Z
      // 2d: ifne 36
      // 30: goto 34
      // 33: athrow
      // 34: return
      // 35: athrow
      // 36: aload 1
      // 37: fconst_0
      // 38: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.setPlayerMotionX (F)V
      // 3b: aload 1
      // 3c: fconst_0
      // 3d: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.setPlayerMotionY (F)V
      // 40: aload 1
      // 41: fconst_0
      // 42: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.setPlayerMotionZ (F)V
      // 45: return
   }

   private boolean ǩ(oca2018bee26 var1, long var2, double var4, double var6, double var8) {
      int var10 = oc47731c13e2.ů;
      int var11 = 2071154122 ^ -1816985024;

      while (true) {
         label114:
         while (true) {
            switch (var11) {
               case -2042541850:
                  label103: {
                     label102: {
                        try {
                           this.Ϧ();
                           this.Ú();
                           this.ʫ();
                           this.ę();
                           this.ӧ = var1;
                           if (var10 != 0) {
                              break label103;
                           }

                           this.վ = var4;
                           this.Ɖ = var6;
                           this.Ƽ = var8;
                           if (!this.Õ.contains(var2)) {
                              break label102;
                           }
                        } catch (ocbde1165e4e var15) {
                           throw var15;
                        }

                        var11 = -1945273543 ^ -1816985024;
                        if (var10 == 0) {
                           continue;
                        }
                     }

                     var11 = -2015817222 ^ -1816985024;
                  }

                  if (var10 == 0) {
                     continue;
                  }
               case 532576633:
                  this.ʨ = ocda5f5fdb38.І;
                  this.ȣ = var2;
                  var11 = -13308662 ^ -1816985024;
                  if (var10 == 0) {
                     continue;
                  }
                  break;
               case -2038664106:
                  break label114;
               case -1462169287:
                  if (this.ʨ == ocda5f5fdb38.ͼ) {
                     var11 = -1155925675 ^ -1816985024;
                     if (var10 == 0) {
                        continue;
                     }
                  }

                  var11 = 368200358 ^ -1816985024;
                  if (var10 == 0) {
                     continue;
                  }
               case -467219741:
                  int var10000;
                  label94: {
                     label93: {
                        try {
                           var10000 = ϗ(var4, var6, var8);
                           if (var10 != 0) {
                              break label94;
                           }

                           if (var10000 == 0) {
                              break label93;
                           }
                        } catch (ocbde1165e4e var14) {
                           throw var14;
                        }

                        var11 = 365917718 ^ -1816985024;
                        if (var10 == 0) {
                           continue;
                        }
                     }

                     var10000 = -1463536294 ^ -1816985024;
                  }

                  var11 = var10000;
                  if (var10 == 0) {
                     continue;
                  }
               case 682294037:
                  this.Ǜ = Math.max(1, (int)this.Ƴ.Ӂ());
                  this.Ծ = 0;
                  var11 = 368200358 ^ -1816985024;
                  if (var10 == 0) {
                     continue;
                  }
                  break label114;
               case -390049910:
                  break;
               case 342496186:
                  this.ǿ();
                  var11 = -13308662 ^ -1816985024;
                  continue;
               case 997668634:
                  return false;
               case 1820847946:
                  return true;
               default:
                  throw null;
            }

            int var17;
            label79: {
               label78: {
                  try {
                     long var18;
                     var17 = (var18 = var2 - (5462436578025524581L ^ -3760935458829251227L)) == 0L ? 0 : (var18 < 0L ? -1 : 1);
                     if (var10 != 0) {
                        break label79;
                     }

                     if (var17 == 0) {
                        break label78;
                     }
                  } catch (ocbde1165e4e var13) {
                     throw var13;
                  }

                  var11 = 2006304931 ^ -1816985024;
                  if (var10 == 0) {
                     continue;
                  }
               }

               var17 = -1463536294 ^ -1816985024;
            }

            var11 = var17;
            if (var10 != 0) {
               return true;
            }
         }

         int var16;
         label70: {
            label69: {
               try {
                  var16 = this.ϋ();
                  if (var10 != 0) {
                     break label70;
                  }

                  if (var16 != 0) {
                     break label69;
                  }
               } catch (ocbde1165e4e var12) {
                  throw var12;
               }

               var11 = -1463536294 ^ -1816985024;
               if (var10 == 0) {
                  continue;
               }
            }

            var16 = 996807545 ^ -1816985024;
         }

         var11 = var16;
         if (var10 != 0) {
            return false;
         }
      }
   }

   private boolean ϋ() {
      int var1 = oc47731c13e2.ů;
      int var2 = 631653535 ^ 1381994742;

      while (true) {
         switch (var2) {
            case -2038466323:
               if (this.ʨ != ocda5f5fdb38.ɜ) {
                  var2 = -76969606 ^ 1381994742;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 333641665 ^ 1381994742;
               if (var1 == 0) {
                  break;
               }
            case -1456072308:
               if (this.ʨ == ocda5f5fdb38.Վ) {
                  var2 = 333641665 ^ 1381994742;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -601156725 ^ 1381994742;
               if (var1 == 0) {
                  break;
               }
            case -1904966787:
               return false;
            case 371910695:
               if (this.ʨ != ocda5f5fdb38.ӏ) {
                  var2 = -736040933 ^ 1381994742;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 333641665 ^ 1381994742;
               if (var1 == 0) {
                  break;
               }
            case 2012861545:
               if (this.ʨ != ocda5f5fdb38.ͼ) {
                  var2 = 1148549329 ^ 1381994742;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 333641665 ^ 1381994742;
               break;
            case 1102931767:
               return true;
            default:
               throw null;
         }
      }
   }

   private void ǿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getstatic x/ocda5f5fdb38.ı Lx/ocda5f5fdb38;
      // 04: putfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 07: getstatic x/oc47731c13e2.ů I
      // 0a: aload 0
      // 0b: bipush 0
      // 0c: putfield x/ocd28580117c.ŷ I
      // 0f: aload 0
      // 10: ldc2_w -8723674363246787509
      // 13: ldc2_w 499697673607988299
      // 16: lxor
      // 17: putfield x/ocd28580117c.ȣ J
      // 1a: aload 0
      // 1b: invokevirtual x/ocd28580117c.Ϊ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e: astore 2
      // 1f: istore 1
      // 20: aload 2
      // 21: iload 1
      // 22: ifne 34
      // 25: invokestatic x/ocd28580117c.ƌ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 28: ifeq 4a
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 2
      // 30: goto 34
      // 33: athrow
      // 34: iload 1
      // 35: ifne 47
      // 38: invokestatic x/ocd28580117c.Ȝ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 3b: ifne 4a
      // 3e: goto 42
      // 41: athrow
      // 42: aload 2
      // 43: goto 47
      // 46: athrow
      // 47: invokevirtual net/minecraft/client/entity/EntityPlayerSP.jump ()V
      // 4a: return
   }

   private void ҵ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: iload 2
      // 05: aload 0
      // 06: dup
      // 07: getfield x/ocd28580117c.ŷ I
      // 0a: bipush 1
      // 0b: iadd
      // 0c: putfield x/ocd28580117c.ŷ I
      // 0f: ifne 50
      // 12: aload 0
      // 13: getfield x/ocd28580117c.ŷ I
      // 16: ldc_w 709259037
      // 19: ldc_w 709259029
      // 1c: ixor
      // 1d: if_icmpge 35
      // 20: goto 24
      // 23: athrow
      // 24: aload 1
      // 25: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 28: ldc2_w 0.03
      // 2b: dcmpl
      // 2c: ifle 35
      // 2f: goto 33
      // 32: athrow
      // 33: return
      // 34: athrow
      // 35: aload 0
      // 36: aload 1
      // 37: invokevirtual x/ocd28580117c.Ⱥ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 3a: aload 0
      // 3b: dup
      // 3c: getfield x/ocd28580117c.Ǜ I
      // 3f: bipush 1
      // 40: isub
      // 41: putfield x/ocd28580117c.Ǜ I
      // 44: aload 0
      // 45: getstatic x/ocda5f5fdb38.ĭ Lx/ocda5f5fdb38;
      // 48: putfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 4b: aload 0
      // 4c: bipush 0
      // 4d: putfield x/ocd28580117c.ŷ I
      // 50: return
   }

   private void Ώ() {
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
      // 09: invokevirtual x/ocd28580117c.ʫ ()V
      // 0c: aload 0
      // 0d: invokevirtual x/ocd28580117c.ę ()V
      // 10: aload 0
      // 11: getfield x/ocd28580117c.Ǜ I
      // 14: ifgt 21
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: invokevirtual x/ocd28580117c.Ǖ ()V
      // 1f: return
      // 20: athrow
      // 21: aload 0
      // 22: getstatic x/ocda5f5fdb38.ӏ Lx/ocda5f5fdb38;
      // 25: putfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 28: aload 0
      // 29: bipush 0
      // 2a: putfield x/ocd28580117c.Ö I
      // 2d: aload 0
      // 2e: invokevirtual x/ocd28580117c.Ú ()V
      // 31: return
   }

   private void ԡ(EntityPlayerSP param1) {
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
      // 06: ifne 18
      // 09: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 0c: ifne 75
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2b
      // 1c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInWater ()Z
      // 1f: ifne 75
      // 22: goto 26
      // 25: athrow
      // 26: aload 1
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 2
      // 2c: ifne 51
      // 2f: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 32: ifnull 4c
      // 35: goto 39
      // 38: athrow
      // 39: aload 1
      // 3a: iload 2
      // 3b: ifne 51
      // 3e: goto 42
      // 41: athrow
      // 42: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInLava ()Z
      // 45: ifne 75
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 1
      // 4d: goto 51
      // 50: athrow
      // 51: iload 2
      // 52: ifne 64
      // 55: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 58: ifnull 7b
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 1
      // 60: goto 64
      // 63: athrow
      // 64: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 67: getfield net/minecraft/util/MovementInput.sneak Z
      // 6a: iload 2
      // 6b: ifne 86
      // 6e: ifeq 7b
      // 71: goto 75
      // 74: athrow
      // 75: aload 0
      // 76: invokevirtual x/ocd28580117c.m ()V
      // 79: return
      // 7a: athrow
      // 7b: aload 0
      // 7c: dup
      // 7d: getfield x/ocd28580117c.Ö I
      // 80: bipush 1
      // 81: iadd
      // 82: dup_x1
      // 83: putfield x/ocd28580117c.Ö I
      // 86: iload 2
      // 87: ifne a2
      // 8a: ldc_w -2003663783
      // 8d: ldc_w -2003663791
      // 90: ixor
      // 91: if_icmplt ad
      // 94: goto 98
      // 97: athrow
      // 98: aload 1
      // 99: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 9c: dconst_0
      // 9d: dcmpl
      // 9e: goto a2
      // a1: athrow
      // a2: iload 2
      // a3: ifne bb
      // a6: ifle ae
      // a9: goto ad
      // ac: athrow
      // ad: return
      // ae: aload 0
      // af: iload 2
      // b0: ifne bf
      // b3: aload 1
      // b4: invokevirtual x/ocd28580117c.ø (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // b7: goto bb
      // ba: athrow
      // bb: ifeq c5
      // be: aload 0
      // bf: getstatic x/ocda5f5fdb38.ɜ Lx/ocda5f5fdb38;
      // c2: putfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // c5: return
   }

   private void Ԇ(EntityPlayerSP param1) {
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
      // 06: ifne 2b
      // 09: aload 1
      // 0a: invokevirtual x/ocd28580117c.r (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 0d: aload 0
      // 0e: dup
      // 0f: getfield x/ocd28580117c.p I
      // 12: bipush 1
      // 13: iadd
      // 14: dup_x1
      // 15: putfield x/ocd28580117c.p I
      // 18: ldc_w 1906464237
      // 1b: ldc_w 1906464231
      // 1e: ixor
      // 1f: if_icmple 2e
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: invokevirtual x/ocd28580117c.m ()V
      // 2e: return
   }

   private void ć() {
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
      // 06: ifne 26
      // 09: dup
      // 0a: getfield x/ocd28580117c.p I
      // 0d: bipush 1
      // 0e: iadd
      // 0f: dup_x1
      // 10: putfield x/ocd28580117c.p I
      // 13: ldc_w 1538910202
      // 16: ldc_w 1538910180
      // 19: ixor
      // 1a: if_icmple 29
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: goto 26
      // 25: athrow
      // 26: invokevirtual x/ocd28580117c.m ()V
      // 29: return
   }

   private void ď(oc25aa89b91f param1, EntityPlayerSP param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 1b
      // 09: getfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 0c: getstatic x/ocda5f5fdb38.ɜ Lx/ocda5f5fdb38;
      // 0f: if_acmpne 3d
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: iload 3
      // 1c: ifne 2e
      // 1f: getfield x/ocd28580117c.ϱ I
      // 22: iflt 3d
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 3
      // 2f: ifne 4b
      // 32: getfield x/ocd28580117c.ϱ I
      // 35: bipush 1
      // 36: if_icmple 3f
      // 39: goto 3d
      // 3c: athrow
      // 3d: return
      // 3e: athrow
      // 3f: aload 1
      // 40: aload 0
      // 41: getfield x/ocd28580117c.π F
      // 44: ldc_w 90.0
      // 47: invokevirtual x/oc25aa89b91f.Ŕ (FF)V
      // 4a: aload 0
      // 4b: dup
      // 4c: getfield x/ocd28580117c.ϱ I
      // 4f: dup_x1
      // 50: bipush 1
      // 51: iadd
      // 52: putfield x/ocd28580117c.ϱ I
      // 55: ifne 5a
      // 58: return
      // 59: athrow
      // 5a: aload 2
      // 5b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 5e: astore 4
      // 60: iload 3
      // 61: ifne 9a
      // 64: aload 4
      // 66: ifnull 92
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 4
      // 6f: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 72: getstatic net/minecraft/init/Items.fire_charge Lnet/minecraft/item/Item;
      // 75: if_acmpne 92
      // 78: goto 7c
      // 7b: athrow
      // 7c: aload 0
      // 7d: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 80: iload 3
      // 81: ifne 9f
      // 84: goto 88
      // 87: athrow
      // 88: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 8b: ifnonnull 9b
      // 8e: goto 92
      // 91: athrow
      // 92: aload 0
      // 93: invokevirtual x/ocd28580117c.m ()V
      // 96: goto 9a
      // 99: athrow
      // 9a: return
      // 9b: aload 0
      // 9c: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 9f: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // a2: new net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // a5: dup
      // a6: aload 4
      // a8: invokespecial net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.<init> (Lnet/minecraft/item/ItemStack;)V
      // ab: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // ae: aload 2
      // af: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // b2: aload 0
      // b3: invokevirtual x/ocd28580117c.Ϧ ()V
      // b6: aload 0
      // b7: ldc_w -1048258070
      // ba: ldc_w -1048258072
      // bd: ixor
      // be: putfield x/ocd28580117c.ϱ I
      // c1: aload 0
      // c2: bipush 0
      // c3: putfield x/ocd28580117c.p I
      // c6: aload 0
      // c7: getstatic x/ocda5f5fdb38.Վ Lx/ocda5f5fdb38;
      // ca: putfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // cd: return
   }

   private boolean ø(EntityPlayerSP var1) {
      int var3 = 0;
      int var4 = 846100911 ^ -425788667;
      int var2 = oc47731c13e2.ů;

      while (true) {
         switch (var4) {
            case -722435414:
               int var10000 = this.Ƥ(var1);
               if (var2 == 0) {
                  var3 = var10000;
                  if (var3 < 0) {
                     var4 = -298072753 ^ -425788667;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -2002280049 ^ -425788667;
               }

               var4 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 1849252490:
               this.Δ = var1.inventory.currentItem;
               this.Տ = var3;
               this.π = var1.rotationYaw - 180.0F;
               var1.inventory.currentItem = var3;
               this.ϱ = 0;
               this.p = 0;
               return true;
            case 145047114:
               return false;
            default:
               throw null;
         }
      }
   }

   private int Ƥ(EntityPlayerSP param1) {
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
      // 05: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 08: ifnonnull 0e
      // 0b: bipush -1
      // 0c: ireturn
      // 0d: athrow
      // 0e: bipush 0
      // 0f: istore 3
      // 10: iload 3
      // 11: ldc_w 1407269251
      // 14: ldc_w 1407269258
      // 17: ixor
      // 18: if_icmpge 4b
      // 1b: aload 1
      // 1c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1f: iload 3
      // 20: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 23: astore 4
      // 25: iload 2
      // 26: ifne 47
      // 29: aload 4
      // 2b: ifnull 44
      // 2e: goto 32
      // 31: athrow
      // 32: aload 4
      // 34: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 37: getstatic net/minecraft/init/Items.fire_charge Lnet/minecraft/item/Item;
      // 3a: if_acmpne 44
      // 3d: goto 41
      // 40: athrow
      // 41: iload 3
      // 42: ireturn
      // 43: athrow
      // 44: iinc 3 1
      // 47: iload 2
      // 48: ifeq 10
      // 4b: bipush -1
      // 4c: ireturn
   }

   private void r(EntityPlayerSP param1) {
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
      // 05: getfield x/ocd28580117c.Տ I
      // 08: iflt 2d
      // 0b: aload 1
      // 0c: iload 2
      // 0d: ifne 23
      // 10: goto 14
      // 13: athrow
      // 14: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 17: ifnull 2d
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 1
      // 1f: goto 23
      // 22: athrow
      // 23: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 26: aload 0
      // 27: getfield x/ocd28580117c.Տ I
      // 2a: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 2d: return
   }

   private void Ϧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: invokevirtual x/ocd28580117c.Ϊ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: astore 2
      // 0a: ifne 4c
      // 0d: aload 2
      // 0e: ifnull 42
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 19: ifnull 42
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: iload 1
      // 22: ifne 48
      // 25: goto 29
      // 28: athrow
      // 29: getfield x/ocd28580117c.Δ I
      // 2c: iflt 42
      // 2f: goto 33
      // 32: athrow
      // 33: aload 2
      // 34: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 37: aload 0
      // 38: getfield x/ocd28580117c.Δ I
      // 3b: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 3e: goto 42
      // 41: athrow
      // 42: aload 0
      // 43: bipush -1
      // 44: putfield x/ocd28580117c.Δ I
      // 47: aload 0
      // 48: bipush -1
      // 49: putfield x/ocd28580117c.Տ I
      // 4c: return
   }

   private void Ú() {
      this.ϱ = -1;
      this.p = 0;
      this.Տ = -1;
      this.Δ = -1;
      this.π = 0.0F;
   }

   private void ɨ() {
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
      // 06: ifne 2f
      // 09: getfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 0c: getstatic x/ocda5f5fdb38.І Lx/ocda5f5fdb38;
      // 0f: if_acmpeq 2e
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: iload 1
      // 18: ifne 2f
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getfield x/ocd28580117c.ʨ Lx/ocda5f5fdb38;
      // 22: getstatic x/ocda5f5fdb38.ı Lx/ocda5f5fdb38;
      // 25: if_acmpeq 2e
      // 28: goto 2c
      // 2b: athrow
      // 2c: return
      // 2d: athrow
      // 2e: aload 0
      // 2f: invokevirtual x/ocd28580117c.Ϊ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 32: astore 2
      // 33: aload 2
      // 34: ifnull 40
      // 37: aload 0
      // 38: aload 2
      // 39: invokevirtual x/ocd28580117c.Ⱥ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 3c: goto 40
      // 3f: athrow
      // 40: return
   }

   private void Ⱥ(EntityPlayerSP param1) {
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
      // 06: ifne 3b
      // 09: getfield x/ocd28580117c.ӧ Lx/oca2018bee26;
      // 0c: getstatic x/oca2018bee26.Ζ Lx/oca2018bee26;
      // 0f: if_acmpne 36
      // 12: goto 16
      // 15: athrow
      // 16: aload 1
      // 17: aload 0
      // 18: getfield x/ocd28580117c.վ D
      // 1b: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 1e: iload 2
      // 1f: aload 1
      // 20: aload 0
      // 21: getfield x/ocd28580117c.Ɖ D
      // 24: putfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 27: aload 1
      // 28: aload 0
      // 29: getfield x/ocd28580117c.Ƽ D
      // 2c: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 2f: ifeq 6f
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: goto 3b
      // 3a: athrow
      // 3b: getfield x/ocd28580117c.ӧ Lx/oca2018bee26;
      // 3e: getstatic x/oca2018bee26.ҫ Lx/oca2018bee26;
      // 41: if_acmpne 6f
      // 44: aload 1
      // 45: dup
      // 46: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 49: aload 0
      // 4a: getfield x/ocd28580117c.վ D
      // 4d: dadd
      // 4e: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 51: aload 1
      // 52: dup
      // 53: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 56: aload 0
      // 57: getfield x/ocd28580117c.Ɖ D
      // 5a: dadd
      // 5b: putfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 5e: aload 1
      // 5f: dup
      // 60: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 63: aload 0
      // 64: getfield x/ocd28580117c.Ƽ D
      // 67: dadd
      // 68: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 6b: goto 6f
      // 6e: athrow
      // 6f: return
   }

   private void m() {
      this.Ǖ();
      this.ę();
   }

   private void Ǖ() {
      this.Ϧ();
      this.ʫ();
      this.Ú();
      this.ʨ = ocda5f5fdb38.ͼ;
      this.Ǜ = 0;
      this.Ծ = 0;
      this.Ö = 0;
   }

   private void ʫ() {
      this.ӧ = oca2018bee26.Γ;
      this.ŷ = 0;
      this.ȣ = -343214733881649415L ^ 8880157302973126393L;
      this.վ = 0.0;
      this.Ɖ = 0.0;
      this.Ƽ = 0.0;
   }

   private void J() {
      this.Õ.clear();
      this.ʈ = false;
      this.Ҭ = -2998592589651861893L ^ 6224779447202913915L;
   }

   private long п() {
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
      // 06: ifne 18
      // 09: getfield x/ocd28580117c.ʈ Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/ocd28580117c.Ҭ J
      // 1b: goto 25
      // 1e: ldc2_w 6920142284301149385
      // 21: ldc2_w -2303229752553626423
      // 24: lxor
      // 25: lstore 2
      // 26: aload 0
      // 27: bipush 0
      // 28: putfield x/ocd28580117c.ʈ Z
      // 2b: aload 0
      // 2c: ldc2_w 6920142284301149385
      // 2f: ldc2_w -2303229752553626423
      // 32: lxor
      // 33: putfield x/ocd28580117c.Ҭ J
      // 36: lload 2
      // 37: lreturn
   }

   private void Գ(S32PacketConfirmTransaction param1) {
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
      // 15: putfield x/ocd28580117c.ʈ Z
      // 18: aload 0
      // 19: ldc2_w -2847451087167194035
      // 1c: ldc2_w 6375920949687581773
      // 1f: lxor
      // 20: putfield x/ocd28580117c.Ҭ J
      // 23: return
      // 24: athrow
      // 25: aload 1
      // 26: invokestatic x/ocd28580117c.ȫ (Lnet/minecraft/network/play/server/S32PacketConfirmTransaction;)J
      // 29: lstore 3
      // 2a: aload 0
      // 2b: iload 2
      // 2c: ifne a5
      // 2f: getfield x/ocd28580117c.Õ Ljava/util/Set;
      // 32: invokeinterface java/util/Set.size ()I 1
      // 37: ldc_w -1593225665
      // 3a: ldc_w -1593225537
      // 3d: ixor
      // 3e: if_icmplt 91
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: getfield x/ocd28580117c.Õ Ljava/util/Set;
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
      // 62: getfield x/ocd28580117c.Õ Ljava/util/Set;
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
      // 92: getfield x/ocd28580117c.Õ Ljava/util/Set;
      // 95: lload 3
      // 96: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 99: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 9e: pop
      // 9f: aload 0
      // a0: bipush 1
      // a1: putfield x/ocd28580117c.ʈ Z
      // a4: aload 0
      // a5: lload 3
      // a6: putfield x/ocd28580117c.Ҭ J
      // a9: return
   }

   private void ę() {
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
      // 06: ifne 18
      // 09: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0c: ifnull 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 1b: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 1e: ifnull 26
      // 21: bipush 1
      // 22: goto 27
      // 25: athrow
      // 26: bipush 0
      // 27: istore 2
      // 28: aload 0
      // 29: getfield x/ocd28580117c.Ŗ Ljava/util/Deque;
      // 2c: invokeinterface java/util/Deque.pollFirst ()Ljava/lang/Object; 1
      // 31: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 34: dup
      // 35: astore 3
      // 36: ifnull 5e
      // 39: aload 0
      // 3a: getfield x/ocd28580117c.Õ Ljava/util/Set;
      // 3d: aload 3
      // 3e: invokestatic x/ocd28580117c.Ƅ (Lnet/minecraft/network/play/client/C0FPacketConfirmTransaction;)J
      // 41: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 44: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 49: pop
      // 4a: iload 1
      // 4b: ifne 5a
      // 4e: iload 2
      // 4f: ifeq 28
      // 52: goto 56
      // 55: athrow
      // 56: aload 3
      // 57: invokestatic x/ocd6ae010123.ĕ (Lnet/minecraft/network/Packet;)V
      // 5a: iload 1
      // 5b: ifeq 28
      // 5e: return
   }

   private boolean Ē() {
      int var1 = oc47731c13e2.ů;
      int var2 = 94095562 ^ 2052253931;

      while (true) {
         switch (var2) {
            case -1619427897:
               if (this.ʨ == ocda5f5fdb38.ĭ) {
                  var2 = 173596905 ^ 2052253931;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -4251652 ^ 2052253931;
               if (var1 == 0) {
                  break;
               }
            case -2048002281:
               return false;
            case 1598709930:
               if (this.ʨ != ocda5f5fdb38.ı) {
                  var2 = -450128596 ^ 2052253931;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 173596905 ^ 2052253931;
               break;
            case 2143887393:
               if (this.ʨ != ocda5f5fdb38.І) {
                  var2 = 622364737 ^ 2052253931;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 173596905 ^ 2052253931;
               if (var1 == 0) {
                  break;
               }
            case 1879705602:
               return true;
            default:
               throw null;
         }
      }
   }

   private EntityPlayerSP Ϊ() {
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
      // 1f: areturn
   }

   private static boolean ƌ(EntityPlayerSP var0) {
      int var1 = oc47731c13e2.ů;
      int var2 = 1139595544 ^ -521830675;

      while (true) {
         label143:
         while (true) {
            label141:
            while (true) {
               switch (var2) {
                  case -1912247379:
                     if (var0.worldObj != null) {
                        var2 = -611494577 ^ -521830675;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var2 = 415059044 ^ -521830675;
                     if (var1 != 0) {
                        return true;
                     }
                     continue;
                  case -1559648267:
                     break label141;
                  case -644892843:
                     return false;
                  case -128437623:
                     return true;
                  case -127996358:
                     break;
                  case 529766439:
                     int var8;
                     label126: {
                        label125: {
                           try {
                              var8 = var0.onGround;
                              if (var1 != 0) {
                                 break label126;
                              }

                              if (!var0.onGround) {
                                 break label125;
                              }
                           } catch (ocbde1165e4e var7) {
                              throw var7;
                           }

                           var2 = -940165927 ^ -521830675;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var8 = -1639446946 ^ -521830675;
                     }

                     var2 = var8;
                     if (var1 == 0) {
                        continue;
                     }
                  case 655575604:
                     int var9;
                     label114: {
                        label113: {
                           try {
                              var9 = var0.isCollidedVertically;
                              if (var1 != 0) {
                                 break label114;
                              }

                              if (!var0.isCollidedVertically) {
                                 break label113;
                              }
                           } catch (ocbde1165e4e var6) {
                              throw var6;
                           }

                           var2 = 414945495 ^ -521830675;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var9 = -1639446946 ^ -521830675;
                     }

                     var2 = var9;
                     if (var1 == 0) {
                        continue;
                     }
                     break label141;
                  case 996682658:
                     break label143;
                  case 1128570986:
                     int var10000;
                     label105: {
                        label104: {
                           try {
                              var10000 = var0.isRiding();
                              if (var1 != 0) {
                                 break label105;
                              }

                              if (var10000 == 0) {
                                 break label104;
                              }
                           } catch (ocbde1165e4e var5) {
                              throw var5;
                           }

                           var2 = -1639446946 ^ -521830675;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var10000 = 1860179264 ^ -521830675;
                     }

                     var2 = var10000;
                     if (var1 == 0) {
                        continue;
                     }
                     break;
                  case 2125297843:
                     return false;
                  default:
                     throw null;
               }

               int var10;
               label82: {
                  label81: {
                     try {
                        var10 = var0.isInWater();
                        if (var1 != 0) {
                           break label82;
                        }

                        if (var10 != 0) {
                           break label81;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1549672825 ^ -521830675;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10 = -1639446946 ^ -521830675;
               }

               var2 = var10;
               if (var1 != 0) {
                  return false;
               }
            }

            if (var0 != null) {
               var2 = -8984886 ^ -521830675;
               if (var1 == 0) {
                  continue;
               }
            }

            var2 = -1639446946 ^ -521830675;
            if (var1 != 0) {
               break;
            }
         }

         int var11;
         label91: {
            label90: {
               try {
                  var11 = var0.isInLava();
                  if (var1 != 0) {
                     break label91;
                  }

                  if (var11 != 0) {
                     break label90;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var2 = 415059044 ^ -521830675;
               if (var1 == 0) {
                  continue;
               }
            }

            var11 = 963299768 ^ -521830675;
         }

         var2 = var11;
      }
   }

   private static boolean Ȝ(EntityPlayerSP var0) {
      int var1 = oc47731c13e2.ů;
      int var2 = 61389764 ^ -180560588;

      while (true) {
         switch (var2) {
            case -1952978962:
               return true;
            case -158046480:
               if (var0 != null) {
                  var2 = -116621244 ^ -180560588;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -31643037 ^ -180560588;
               if (var1 == 0) {
                  break;
               }
            case 248334732:
               int var10000;
               label45: {
                  label44: {
                     try {
                        var10000 = var0.movementInput.jump;
                        if (var1 != 0) {
                           break label45;
                        }

                        if (!var0.movementInput.jump) {
                           break label44;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 2125150938 ^ -180560588;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -31643037 ^ -180560588;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 204496240:
               if (var0.movementInput != null) {
                  var2 = -68053832 ^ -180560588;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -31643037 ^ -180560588;
               if (var1 == 0) {
                  break;
               }

               return true;
            case 186775383:
               return false;
            default:
               throw null;
         }
      }
   }

   private static boolean ϗ(double var0, double var2, double var4) {
      int var6 = oc47731c13e2.ů;
      int var7 = 2049046242 ^ 1448769617;

      while (true) {
         switch (var7) {
            case -1770938131:
               int var12;
               label90: {
                  label89: {
                     try {
                        var12 = Double.isFinite(var2);
                        if (var6 != 0) {
                           break label90;
                        }

                        if (var12 == 0) {
                           break label89;
                        }
                     } catch (ocbde1165e4e var11) {
                        throw var11;
                     }

                     var7 = -370996169 ^ 1448769617;
                     if (var6 == 0) {
                        continue;
                     }
                  }

                  var12 = -427121485 ^ 1448769617;
               }

               var7 = var12;
               if (var6 == 0) {
                  continue;
               }
            case 142380160:
               int var13;
               label79: {
                  label78: {
                     try {
                        double var15;
                        var13 = (var15 = var2 - 0.05) == 0.0 ? 0 : (var15 < 0.0 ? -1 : 1);
                        if (var6 != 0) {
                           break label79;
                        }

                        if (var13 <= 0) {
                           break label78;
                        }
                     } catch (ocbde1165e4e var10) {
                        throw var10;
                     }

                     var7 = 1932908192 ^ 1448769617;
                     if (var6 == 0) {
                        continue;
                     }
                  }

                  var13 = -427121485 ^ 1448769617;
               }

               var7 = var13;
               if (var6 == 0) {
                  continue;
               }
               break;
            case -1328489246:
               return false;
            case -1078365082:
               break;
            case 628076273:
               return true;
            case 746294963:
               int var10000;
               label58: {
                  label57: {
                     try {
                        var10000 = Double.isFinite(var0);
                        if (var6 != 0) {
                           break label58;
                        }

                        if (var10000 == 0) {
                           break label57;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var7 = -1070868292 ^ 1448769617;
                     if (var6 == 0) {
                        continue;
                     }
                  }

                  var10000 = -427121485 ^ 1448769617;
               }

               var7 = var10000;
               if (var6 != 0) {
                  return true;
               }
               continue;
            default:
               throw null;
         }

         int var14;
         label67: {
            label66: {
               try {
                  var14 = Double.isFinite(var4);
                  if (var6 != 0) {
                     break label67;
                  }

                  if (var14 == 0) {
                     break label66;
                  }
               } catch (ocbde1165e4e var9) {
                  throw var9;
               }

               var7 = 1579611345 ^ 1448769617;
               if (var6 == 0) {
                  continue;
               }
            }

            var14 = -427121485 ^ 1448769617;
         }

         var7 = var14;
         if (var6 != 0) {
            return false;
         }
      }
   }

   private static long ȫ(S32PacketConfirmTransaction var0) {
      return Ϛ(var0.getWindowId(), var0.getActionNumber());
   }

   private static long Ƅ(C0FPacketConfirmTransaction var0) {
      return Ϛ(var0.getWindowId(), var0.getUid());
   }

   private static long Ϛ(int var0, short var1) {
      return (long)var0 << (-1625913047 ^ -1625913031) | var1 & (-3463073141373784090L ^ -3463073141373743079L);
   }

   static {
      String[] var10000 = new String[-1806767901 ^ -1806767903];
      var10000[0] = "GrimLatest";
      var10000[1] = "3fmc";
      ѷ = var10000;
   }
}
