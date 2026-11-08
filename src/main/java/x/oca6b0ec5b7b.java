package x;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S27PacketExplosion;

public class oca6b0ec5b7b extends oc69da1aa7f5 {
   private static final String[] Ĺ;
   private final Random ǔ = new Random();
   private final oc5adc975102 ь = new oc5adc975102(ocd6ae010123::Å);
   private final oc5adc975102 ѡ = new oc5adc975102(this::ƫ);
   public final oca9cc61aada х;
   public final oca9cc61aada ȏ;
   public final oca9cc61aada ĥ;
   public final occ2f8dff8d8 ұ;
   public final occ2f8dff8d8 Ƨ;
   public final oca9cc61aada Ҙ;
   private NetHandlerPlayClient ǌ;
   private WorldClient Ĕ;
   private long Ձ = 162488812222316822L ^ -9060883224632458986L;
   private long ǟ = 0L;
   private boolean ŉ;
   private boolean Ѱ;
   public static int º;

   public oca6b0ec5b7b() {
      super("RealLag", oce4cea752dd.ȁ, 0, "idle.miau.module.impl.player.RealLag");
      this.ą("FakeLag but Real !?!?!?!?!?");
      this.ʌ(this.х = new oca9cc61aada("Direction", 0, Ĺ));
      this.ʌ(this.ȏ = new oca9cc61aada("Delay", "ms", 150.0, 0.0, 1000.0, 10.0));
      this.ʌ(this.ĥ = new oca9cc61aada("Throttle", "ms", 0.0, 0.0, 1000.0, 25.0));
      this.ʌ(this.ұ = new occ2f8dff8d8("Safe packets", true));
      this.ʌ(this.Ƨ = new occ2f8dff8d8("Combat only", true));
      this.ʌ(this.Ҙ = new oca9cc61aada("Combat range", "m", 12.0, 3.0, 30.0, 1.0));
   }

   @Override
   public synchronized void onEnable() {
      this.ϛ();
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public synchronized void Ƃ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 08: iload 2
      // 09: ifne 1f
      // 0c: ifne 2b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: aload 1
      // 15: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 18: invokevirtual x/oca6b0ec5b7b.ϔ (Lnet/minecraft/network/Packet;)Z
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifeq 2b
      // 22: aload 1
      // 23: bipush 1
      // 24: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 27: goto 2b
      // 2a: athrow
      // 2b: return
   }

   public synchronized boolean ɸ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 04: ifeq 18
      // 07: aload 0
      // 08: aload 1
      // 09: invokevirtual x/oca6b0ec5b7b.ϔ (Lnet/minecraft/network/Packet;)Z
      // 0c: ifeq 18
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 1
      // 14: goto 19
      // 17: athrow
      // 18: bipush 0
      // 19: ireturn
   }

   private boolean ϔ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oca6b0ec5b7b.ŉ Z
      // 04: ifne 1d
      // 07: aload 0
      // 08: getfield x/oca6b0ec5b7b.Ѱ Z
      // 0b: ifne 1d
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: invokevirtual x/oca6b0ec5b7b.Դ ()Z
      // 16: ifne 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush 0
      // 1e: ireturn
      // 1f: athrow
      // 20: aload 1
      // 21: ifnull 2f
      // 24: aload 1
      // 25: invokestatic x/ocb67361fd4e.Ф (Lnet/minecraft/network/Packet;)Z
      // 28: ifeq 32
      // 2b: goto 2f
      // 2e: athrow
      // 2f: bipush 0
      // 30: ireturn
      // 31: athrow
      // 32: aload 0
      // 33: aload 1
      // 34: invokevirtual x/oca6b0ec5b7b.џ (Lnet/minecraft/network/Packet;)Z
      // 37: ifeq 3d
      // 3a: bipush 0
      // 3b: ireturn
      // 3c: athrow
      // 3d: aload 1
      // 3e: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 41: ifeq 8b
      // 44: aload 1
      // 45: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 48: astore 2
      // 49: aload 2
      // 4a: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 4d: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 50: if_acmpne 8b
      // 53: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 56: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 59: ifnull 6e
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 2
      // 61: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 64: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 67: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getEntityFromWorld (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 6a: goto 6f
      // 6d: athrow
      // 6e: aconst_null
      // 6f: astore 3
      // 70: aload 3
      // 71: ifnull 80
      // 74: aload 0
      // 75: aload 3
      // 76: invokevirtual x/oca6b0ec5b7b.ɺ (Lnet/minecraft/entity/Entity;)Z
      // 79: ifne 8b
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 0
      // 81: invokestatic java/lang/System.currentTimeMillis ()J
      // 84: putfield x/oca6b0ec5b7b.ǟ J
      // 87: goto 8b
      // 8a: athrow
      // 8b: aload 0
      // 8c: invokevirtual x/oca6b0ec5b7b.Ϲ ()Z
      // 8f: ifne 9c
      // 92: aload 0
      // 93: getfield x/oca6b0ec5b7b.ѡ Lx/oc5adc975102;
      // 96: invokevirtual x/oc5adc975102.È ()V
      // 99: bipush 0
      // 9a: ireturn
      // 9b: athrow
      // 9c: invokestatic java/lang/System.nanoTime ()J
      // 9f: lstore 2
      // a0: aload 0
      // a1: getfield x/oca6b0ec5b7b.х Lx/oca9cc61aada;
      // a4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // a7: d2i
      // a8: bipush 1
      // a9: if_icmpeq c9
      // ac: lload 2
      // ad: aload 0
      // ae: getfield x/oca6b0ec5b7b.Ձ J
      // b1: lcmp
      // b2: iflt c9
      // b5: goto b9
      // b8: athrow
      // b9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // bc: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // bf: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isEntityAlive ()Z
      // c2: ifne d3
      // c5: goto c9
      // c8: athrow
      // c9: aload 0
      // ca: getfield x/oca6b0ec5b7b.ѡ Lx/oc5adc975102;
      // cd: invokevirtual x/oc5adc975102.È ()V
      // d0: bipush 0
      // d1: ireturn
      // d2: athrow
      // d3: aload 0
      // d4: aload 0
      // d5: getfield x/oca6b0ec5b7b.ѡ Lx/oc5adc975102;
      // d8: aload 1
      // d9: lload 2
      // da: invokevirtual x/oca6b0ec5b7b.Ͱ (Lx/oc5adc975102;Lnet/minecraft/network/Packet;J)Z
      // dd: ireturn
   }

   private void ƫ(Packet<?> var1) {
      this.Ѱ = true;

      try {
         ocd6ae010123.ĕ(var1);
      } finally {
         this.Ѱ = false;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST,
      receiveCanceled = true
   )
   public synchronized void Ľ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/oca6b0ec5b7b.ŉ Z
      // 0c: ifne 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/oca6b0ec5b7b.Դ ()Z
      // 1b: ifne 20
      // 1e: return
      // 1f: athrow
      // 20: aload 1
      // 21: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 24: astore 3
      // 25: aload 0
      // 26: iload 2
      // 27: ifne 41
      // 2a: aload 3
      // 2b: invokevirtual x/oca6b0ec5b7b.Ȇ (Lnet/minecraft/network/Packet;)Z
      // 2e: ifeq 40
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: invokestatic java/lang/System.currentTimeMillis ()J
      // 39: putfield x/oca6b0ec5b7b.ǟ J
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: iload 2
      // 42: ifne 57
      // 45: getfield x/oca6b0ec5b7b.ұ Lx/occ2f8dff8d8;
      // 48: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4b: ifeq 6e
      // 4e: goto 52
      // 51: athrow
      // 52: aload 0
      // 53: goto 57
      // 56: athrow
      // 57: iload 2
      // 58: ifne 6b
      // 5b: aload 3
      // 5c: invokevirtual x/oca6b0ec5b7b.ί (Lnet/minecraft/network/Packet;)Z
      // 5f: ifeq 6e
      // 62: goto 66
      // 65: athrow
      // 66: aload 0
      // 67: goto 6b
      // 6a: athrow
      // 6b: invokevirtual x/oca6b0ec5b7b.է ()V
      // 6e: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public synchronized void ɧ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/oca6b0ec5b7b.ŉ Z
      // 08: iload 2
      // 09: ifne 1b
      // 0c: ifne 31
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 17: goto 1b
      // 1a: athrow
      // 1b: iload 2
      // 1c: ifne 2e
      // 1f: ifne 31
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: invokevirtual x/oca6b0ec5b7b.Դ ()Z
      // 2a: goto 2e
      // 2d: athrow
      // 2e: ifne 32
      // 31: return
      // 32: aload 1
      // 33: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 36: astore 3
      // 37: aload 3
      // 38: iload 2
      // 39: ifne 44
      // 3c: ifnull 52
      // 3f: goto 43
      // 42: athrow
      // 43: aload 3
      // 44: invokestatic x/ocb67361fd4e.Ф (Lnet/minecraft/network/Packet;)Z
      // 47: iload 2
      // 48: ifne 5f
      // 4b: ifeq 53
      // 4e: goto 52
      // 51: athrow
      // 52: return
      // 53: aload 0
      // 54: iload 2
      // 55: ifne 63
      // 58: invokevirtual x/oca6b0ec5b7b.Ϲ ()Z
      // 5b: goto 5f
      // 5e: athrow
      // 5f: ifne 6a
      // 62: aload 0
      // 63: getfield x/oca6b0ec5b7b.ь Lx/oc5adc975102;
      // 66: invokevirtual x/oc5adc975102.È ()V
      // 69: return
      // 6a: invokestatic java/lang/System.nanoTime ()J
      // 6d: lstore 4
      // 6f: iload 2
      // 70: ifne bb
      // 73: aload 0
      // 74: getfield x/oca6b0ec5b7b.х Lx/oca9cc61aada;
      // 77: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 7a: d2i
      // 7b: ifeq b0
      // 7e: goto 82
      // 81: athrow
      // 82: lload 4
      // 84: aload 0
      // 85: getfield x/oca6b0ec5b7b.Ձ J
      // 88: lcmp
      // 89: iload 2
      // 8a: ifne a5
      // 8d: goto 91
      // 90: athrow
      // 91: iflt b0
      // 94: goto 98
      // 97: athrow
      // 98: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 9b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 9e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isEntityAlive ()Z
      // a1: goto a5
      // a4: athrow
      // a5: iload 2
      // a6: ifne c7
      // a9: ifne bc
      // ac: goto b0
      // af: athrow
      // b0: aload 0
      // b1: getfield x/oca6b0ec5b7b.ь Lx/oc5adc975102;
      // b4: invokevirtual x/oc5adc975102.È ()V
      // b7: goto bb
      // ba: athrow
      // bb: return
      // bc: aload 0
      // bd: aload 0
      // be: getfield x/oca6b0ec5b7b.ь Lx/oc5adc975102;
      // c1: aload 3
      // c2: lload 4
      // c4: invokevirtual x/oca6b0ec5b7b.Ͱ (Lx/oc5adc975102;Lnet/minecraft/network/Packet;J)Z
      // c7: ifeq d3
      // ca: aload 1
      // cb: bipush 1
      // cc: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // cf: goto d3
      // d2: athrow
      // d3: return
   }

   private boolean Ͱ(oc5adc975102 var1, Packet<?> var2, long var3) {
      long var5 = 0L;
      int var7 = -357772699 ^ 974266441;

      while (true) {
         switch (var7) {
            case -2122761959:
               var5 = TimeUnit.MILLISECONDS.toNanos((long)this.ĥ.Ӂ());
               var7 = -1450515452 ^ 974266441;
               break;
            case -1964750067:
               var5 = 0L;
               var7 = -1450515452 ^ 974266441;
               break;
            case -1818704819:
               return var1.ͽ(var2, var3, TimeUnit.MILLISECONDS.toNanos((long)this.ȏ.Ӂ()), var5);
            case -792792532:
               if (this.ĥ.Ӂ() > 0.0) {
                  var7 = 396420122 ^ 974266441;
               } else {
                  var7 = -1326027964 ^ 974266441;
               }
               break;
            case 766690387:
               if (this.ǔ.nextInt(974266445 ^ 974266441) == 0) {
                  var7 = -1150609072 ^ 974266441;
               } else {
                  var7 = -1326027964 ^ 974266441;
               }
               break;
            default:
               throw null;
         }
      }
   }

   public boolean ɺ(Entity param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ifnull 29
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: ifnull 2c
      // 0a: goto 0e
      // 0d: athrow
      // 0e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14: ifnull 2c
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 1
      // 1c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22: if_acmpne 2c
      // 25: goto 29
      // 28: athrow
      // 29: bipush 0
      // 2a: ireturn
      // 2b: athrow
      // 2c: getstatic x/oc9755810e45.Ǵ Lx/oca4f99d2d44;
      // 2f: ifnull 4f
      // 32: getstatic x/oc9755810e45.Ǵ Lx/oca4f99d2d44;
      // 35: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 38: ifeq 4f
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 1
      // 40: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 43: ifeq 4f
      // 46: goto 4a
      // 49: athrow
      // 4a: bipush 1
      // 4b: goto 50
      // 4e: athrow
      // 4f: bipush 0
      // 50: ireturn
   }

   public boolean Ϲ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oca6b0ec5b7b.Ƨ Lx/occ2f8dff8d8;
      // 04: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 07: ifne 0d
      // 0a: bipush 1
      // 0b: ireturn
      // 0c: athrow
      // 0d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 13: ifnull 23
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1c: ifnonnull 26
      // 1f: goto 23
      // 22: athrow
      // 23: bipush 0
      // 24: ireturn
      // 25: athrow
      // 26: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 29: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 2f: ifle 3c
      // 32: aload 0
      // 33: invokestatic java/lang/System.currentTimeMillis ()J
      // 36: putfield x/oca6b0ec5b7b.ǟ J
      // 39: bipush 1
      // 3a: ireturn
      // 3b: athrow
      // 3c: invokestatic java/lang/System.currentTimeMillis ()J
      // 3f: aload 0
      // 40: getfield x/oca6b0ec5b7b.ǟ J
      // 43: lsub
      // 44: ldc2_w -225147044083447140
      // 47: ldc2_w -225147044083449564
      // 4a: lxor
      // 4b: lcmp
      // 4c: ifge 52
      // 4f: bipush 1
      // 50: ireturn
      // 51: athrow
      // 52: aload 0
      // 53: invokevirtual x/oca6b0ec5b7b.é ()Z
      // 56: ireturn
   }

   private boolean é() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 06: ifnull 26
      // 09: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f: ifnull 26
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1c: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 1f: ifnonnull 29
      // 22: goto 26
      // 25: athrow
      // 26: bipush 0
      // 27: ireturn
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oca6b0ec5b7b.Ҙ Lx/oca9cc61aada;
      // 2d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 30: dstore 1
      // 31: dload 1
      // 32: dload 1
      // 33: dmul
      // 34: dstore 3
      // 35: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 38: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 3b: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 3e: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 43: astore 5
      // 45: aload 5
      // 47: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 4c: ifeq bb
      // 4f: aload 5
      // 51: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 56: checkcast net/minecraft/entity/player/EntityPlayer
      // 59: astore 6
      // 5b: aload 6
      // 5d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 60: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 63: if_acmpne 6a
      // 66: goto 45
      // 69: athrow
      // 6a: aload 6
      // 6c: getfield net/minecraft/entity/player/EntityPlayer.isDead Z
      // 6f: ifne 45
      // 72: aload 6
      // 74: invokevirtual net/minecraft/entity/player/EntityPlayer.getHealth ()F
      // 77: fconst_0
      // 78: fcmpg
      // 79: ifgt 80
      // 7c: goto 45
      // 7f: athrow
      // 80: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 83: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 86: aload 6
      // 88: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 8b: dload 3
      // 8c: dcmpg
      // 8d: ifgt b8
      // 90: aload 0
      // 91: aload 6
      // 93: invokevirtual x/oca6b0ec5b7b.ɺ (Lnet/minecraft/entity/Entity;)Z
      // 96: ifne b8
      // 99: goto 9d
      // 9c: athrow
      // 9d: aload 6
      // 9f: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // a2: ifne b8
      // a5: goto a9
      // a8: athrow
      // a9: aload 6
      // ab: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // ae: ifne b8
      // b1: goto b5
      // b4: athrow
      // b5: bipush 1
      // b6: ireturn
      // b7: athrow
      // b8: goto 45
      // bb: bipush 0
      // bc: ireturn
   }

   public boolean џ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 04: ifeq 66
      // 07: aload 1
      // 08: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 0b: astore 2
      // 0c: aload 2
      // 0d: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 10: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.INTERACT Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 13: if_acmpeq 24
      // 16: aload 2
      // 17: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 1a: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.INTERACT_AT Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 1d: if_acmpne 27
      // 20: goto 24
      // 23: athrow
      // 24: bipush 1
      // 25: ireturn
      // 26: athrow
      // 27: aload 2
      // 28: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 2b: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 2e: if_acmpne 66
      // 31: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 34: ifnull 66
      // 37: goto 3b
      // 3a: athrow
      // 3b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 41: ifnull 66
      // 44: goto 48
      // 47: athrow
      // 48: aload 2
      // 49: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 4f: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getEntityFromWorld (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 52: astore 3
      // 53: aload 3
      // 54: ifnull 66
      // 57: aload 0
      // 58: aload 3
      // 59: invokevirtual x/oca6b0ec5b7b.ɺ (Lnet/minecraft/entity/Entity;)Z
      // 5c: ifeq 66
      // 5f: goto 63
      // 62: athrow
      // 63: bipush 1
      // 64: ireturn
      // 65: athrow
      // 66: bipush 0
      // 67: ireturn
   }

   private boolean Ȇ(Packet<?> var1) {
      S19PacketEntityStatus var3 = null;
      int var4 = -796892275 ^ 1400010909;
      int var2 = oc5e549848f3.İ;

      while (true) {
         label136:
         while (true) {
            label132:
            while (true) {
               switch (var4) {
                  case -2081285360:
                     int var12;
                     label85: {
                        label84: {
                           try {
                              var12 = this.ί(var1);
                              if (var2 != 0) {
                                 break label85;
                              }

                              if (var12 != 0) {
                                 break label84;
                              }
                           } catch (ocbde1165e4e var6) {
                              throw var6;
                           }

                           var4 = 1752187905 ^ 1400010909;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var12 = -1213333362 ^ 1400010909;
                     }

                     var4 = var12;
                     if (var2 != 0) {
                        return false;
                     }
                     continue;
                  case -1741917081:
                     break;
                  case -1043560920:
                     break label132;
                  case -500439503:
                     return false;
                  case -455313389:
                     return true;
                  case -389116200:
                     int var10000;
                     label120: {
                        label119: {
                           try {
                              var10000 = var3.getOpCode();
                              if (var2 != 0) {
                                 break label120;
                              }

                              if (var10000 != (1400010911 ^ 1400010909)) {
                                 break label119;
                              }
                           } catch (ocbde1165e4e var9) {
                              throw var9;
                           }

                           var4 = -1213333362 ^ 1400010909;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var10000 = -1319526740 ^ 1400010909;
                     }

                     var4 = var10000;
                     if (var2 == 0) {
                        continue;
                     }
                  case -1633416160:
                     var3 = (S19PacketEntityStatus)var1;

                     label109: {
                        label108: {
                           try {
                              if (var2 != 0) {
                                 break label109;
                              }

                              if (oc69da1aa7f5.ő.theWorld == null) {
                                 break label108;
                              }
                           } catch (ocbde1165e4e var8) {
                              throw var8;
                           }

                           var4 = -883028742 ^ 1400010909;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var4 = -1319526740 ^ 1400010909;
                     }

                     if (var2 == 0) {
                        continue;
                     }
                     break;
                  case 990002332:
                     break label136;
                  default:
                     throw null;
               }

               if (var3.getEntity(oc69da1aa7f5.ő.theWorld) == oc69da1aa7f5.ő.thePlayer) {
                  var4 = -1145244091 ^ 1400010909;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var4 = -1319526740 ^ 1400010909;
               if (var2 != 0) {
                  break;
               }
            }

            int var10;
            label97: {
               label96: {
                  try {
                     var10 = var1 instanceof S19PacketEntityStatus;
                     if (var2 != 0) {
                        break label97;
                     }

                     if (var10 == 0) {
                        break label96;
                     }
                  } catch (ocbde1165e4e var7) {
                     throw var7;
                  }

                  var4 = -841583427 ^ 1400010909;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var10 = -1319526740 ^ 1400010909;
            }

            var4 = var10;
            if (var2 != 0) {
               break;
            }
         }

         int var11;
         label76: {
            label75: {
               try {
                  var11 = var1 instanceof S06PacketUpdateHealth;
                  if (var2 != 0) {
                     break label76;
                  }

                  if (var11 != 0) {
                     break label75;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var4 = -1832976715 ^ 1400010909;
               if (var2 == 0) {
                  continue;
               }
            }

            var11 = -1213333362 ^ 1400010909;
         }

         var4 = var11;
         if (var2 != 0) {
            return true;
         }
      }
   }

   private boolean ί(Packet<?> var1) {
      Object var3 = null;
      Object var4 = null;
      int var2 = oc5e549848f3.İ;
      int var5 = -579431945 ^ 1941013114;

      while (true) {
         label125:
         while (true) {
            switch (var5) {
               case -1751137756:
                  return true;
               case -1665355182:
                  int var10000;
                  label114: {
                     label113: {
                        try {
                           var10000 = var1 instanceof S27PacketExplosion;
                           if (var2 != 0) {
                              break label114;
                           }

                           if (var10000 != 0) {
                              break label113;
                           }
                        } catch (ocbde1165e4e var10) {
                           throw var10;
                        }

                        var5 = 727816140 ^ 1941013114;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var10000 = -466730914 ^ 1941013114;
                  }

                  var5 = var10000;
                  if (var2 == 0) {
                     continue;
                  }
               case -1362685043:
                  int var13;
                  label104: {
                     label103: {
                        try {
                           var13 = var1 instanceof S12PacketEntityVelocity;
                           if (var2 != 0) {
                              break label104;
                           }

                           if (var13 == 0) {
                              break label103;
                           }
                        } catch (ocbde1165e4e var9) {
                           throw var9;
                        }

                        var5 = 927090911 ^ 1941013114;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var13 = -284348376 ^ 1941013114;
                  }

                  var5 = var13;
                  if (var2 == 0) {
                     continue;
                  }
                  break;
               case -783704703:
                  return false;
               case 225891524:
                  var3 = (S06PacketUpdateHealth)var1;

                  label70: {
                     label69: {
                        try {
                           if (var2 != 0) {
                              break label70;
                           }

                           if (!(var3.getHealth() <= 0.0F)) {
                              break label69;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var5 = -466730914 ^ 1941013114;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var5 = -1560797189 ^ 1941013114;
                  }

                  if (var2 != 0) {
                     return false;
                  }
                  continue;
               case 1156827813:
                  break label125;
               case 1490032054:
                  break;
               default:
                  throw null;
            }

            int var14;
            label93: {
               label92: {
                  try {
                     var14 = var1 instanceof S06PacketUpdateHealth;
                     if (var2 != 0) {
                        break label93;
                     }

                     if (var14 == 0) {
                        break label92;
                     }
                  } catch (ocbde1165e4e var8) {
                     throw var8;
                  }

                  var5 = 2126993086 ^ 1941013114;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var14 = -1560797189 ^ 1941013114;
            }

            var5 = var14;
            if (var2 != 0) {
               break;
            }
         }

         var4 = (S12PacketEntityVelocity)var1;

         label80: {
            label79: {
               try {
                  if (var2 != 0) {
                     break label80;
                  }

                  if (var4.getEntityID() == oc69da1aa7f5.ő.thePlayer.getEntityId()) {
                     break label79;
                  }
               } catch (ocbde1165e4e var7) {
                  throw var7;
               }

               var5 = -284348376 ^ 1941013114;
               if (var2 == 0) {
                  continue;
               }
            }

            var5 = -466730914 ^ 1941013114;
         }

         if (var2 != 0) {
            return true;
         }
      }
   }

   @Override
   public synchronized void z$1m9j3ewef9s() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: invokevirtual x/oca6b0ec5b7b.Դ ()Z
      // 08: ifne 0d
      // 0b: return
      // 0c: athrow
      // 0d: invokestatic java/lang/System.nanoTime ()J
      // 10: lstore 2
      // 11: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 14: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 17: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isEntityAlive ()Z
      // 1a: iload 1
      // 1b: ifne 37
      // 1e: ifne 2b
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: invokevirtual x/oca6b0ec5b7b.ӡ ()V
      // 29: return
      // 2a: athrow
      // 2b: aload 0
      // 2c: iload 1
      // 2d: ifne 41
      // 30: invokevirtual x/oca6b0ec5b7b.Ϲ ()Z
      // 33: goto 37
      // 36: athrow
      // 37: ifne 40
      // 3a: aload 0
      // 3b: invokevirtual x/oca6b0ec5b7b.ӡ ()V
      // 3e: return
      // 3f: athrow
      // 40: aload 0
      // 41: iload 1
      // 42: ifne 68
      // 45: getfield x/oca6b0ec5b7b.х Lx/oca9cc61aada;
      // 48: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 4b: d2i
      // 4c: bipush 1
      // 4d: if_icmpne 63
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: getfield x/oca6b0ec5b7b.ѡ Lx/oc5adc975102;
      // 58: invokevirtual x/oc5adc975102.È ()V
      // 5b: iload 1
      // 5c: ifeq 6f
      // 5f: goto 63
      // 62: athrow
      // 63: aload 0
      // 64: goto 68
      // 67: athrow
      // 68: getfield x/oca6b0ec5b7b.ѡ Lx/oc5adc975102;
      // 6b: lload 2
      // 6c: invokevirtual x/oc5adc975102.ͳ (J)V
      // 6f: aload 0
      // 70: iload 1
      // 71: ifne 96
      // 74: getfield x/oca6b0ec5b7b.х Lx/oca9cc61aada;
      // 77: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 7a: d2i
      // 7b: ifne 91
      // 7e: goto 82
      // 81: athrow
      // 82: aload 0
      // 83: getfield x/oca6b0ec5b7b.ь Lx/oc5adc975102;
      // 86: invokevirtual x/oc5adc975102.È ()V
      // 89: iload 1
      // 8a: ifeq 9d
      // 8d: goto 91
      // 90: athrow
      // 91: aload 0
      // 92: goto 96
      // 95: athrow
      // 96: getfield x/oca6b0ec5b7b.ь Lx/oc5adc975102;
      // 99: lload 2
      // 9a: invokevirtual x/oc5adc975102.ͳ (J)V
      // 9d: return
   }

   private boolean Դ() {
      int var1 = 1784031673 ^ 876017392;

      while (true) {
         switch (var1) {
            case -1810890792:
               if (oc69da1aa7f5.ő.getNetHandler().getNetworkManager().isChannelOpen()) {
                  var1 = -131974494 ^ 876017392;
               } else {
                  var1 = -484378001 ^ 876017392;
               }
               break;
            case -1788557659:
               return true;
            case -1392348673:
               if (oc69da1aa7f5.ő.thePlayer != null) {
                  var1 = -600750071 ^ 876017392;
               } else {
                  var1 = -484378001 ^ 876017392;
               }
               break;
            case -873597089:
               if (this.Ĕ != oc69da1aa7f5.ő.theWorld) {
                  var1 = 1667440052 ^ 876017392;
               } else {
                  var1 = -1588449195 ^ 876017392;
               }
               break;
            case -871052206:
               if (!oc69da1aa7f5.ő.getNetHandler().isDoneLoadingTerrain()) {
                  var1 = -484378001 ^ 876017392;
               } else {
                  var1 = 2054395056 ^ 876017392;
               }
               break;
            case -686420833:
               this.ϛ();
               return false;
            case -402145543:
               if (oc69da1aa7f5.ő.theWorld != null) {
                  var1 = 2033050708 ^ 876017392;
               } else {
                  var1 = -484378001 ^ 876017392;
               }
               break;
            case 1293619876:
               if (oc69da1aa7f5.ő.getNetHandler() != null) {
                  var1 = -1606874840 ^ 876017392;
               } else {
                  var1 = -484378001 ^ 876017392;
               }
               break;
            case 1313169984:
               if (this.ǌ == oc69da1aa7f5.ő.getNetHandler()) {
                  var1 = -2424401 ^ 876017392;
               } else {
                  var1 = 1667440052 ^ 876017392;
               }
               break;
            case 1465248580:
               this.ϛ();
               this.ǌ = oc69da1aa7f5.ő.getNetHandler();
               this.Ĕ = oc69da1aa7f5.ő.theWorld;
               var1 = -1588449195 ^ 876017392;
               break;
            case 1583406921:
               if (oc69da1aa7f5.ő != null) {
                  var1 = -1724610801 ^ 876017392;
               } else {
                  var1 = -484378001 ^ 876017392;
               }
               break;
            default:
               throw null;
         }
      }
   }

   private void է() {
      this.Ձ = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(1763353521015613875L ^ 1763353521015613769L);
      this.ӡ();
   }

   public synchronized void ө() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 3e
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 39
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 3e
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokevirtual x/oca6b0ec5b7b.Դ ()Z
      // 1f: ifeq 39
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oca6b0ec5b7b.ѡ Lx/oc5adc975102;
      // 2a: invokevirtual x/oc5adc975102.Կ ()V
      // 2d: iload 1
      // 2e: aload 0
      // 2f: invokevirtual x/oca6b0ec5b7b.է ()V
      // 32: ifeq 41
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: invokevirtual x/oca6b0ec5b7b.ϛ ()V
      // 41: return
   }

   public synchronized void չ() {
      this.ϛ();
   }

   private void ӡ() {
      this.ŉ = true;

      try {
         this.ѡ.È();
         this.ь.È();
      } finally {
         this.ŉ = false;
      }
   }

   @oc66fa4f2195
   public synchronized void ʟ(oc79b0d8811c var1) {
      this.ϛ();
   }

   @Override
   public synchronized void onDisable() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1c
      // 09: invokevirtual x/oca6b0ec5b7b.Դ ()Z
      // 0c: ifeq 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oca6b0ec5b7b.ӡ ()V
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: invokevirtual x/oca6b0ec5b7b.ϛ ()V
      // 1f: return
   }

   private void ϛ() {
      this.ь.Ү();
      this.ѡ.Ү();
      this.ǌ = null;
      this.Ĕ = null;
      this.Ձ = -5602849206081084385L ^ 3620522830773691423L;
      this.ǟ = 0L;
   }

   @Override
   public String getInfo() {
      int var1 = Math.max(0, Math.min((int)this.х.Ӂ(), Ĺ.length - 1));
      return Ĺ[var1] + " " + (int)this.ȏ.Ӂ() + "ms";
   }

   static {
      String[] var10000 = new String[-1708151792 ^ -1708151789];
      var10000[0] = "Outbound";
      var10000[1] = "Inbound";
      var10000[-1708151791 ^ -1708151789] = "Both";
      Ĺ = var10000;
   }
}
