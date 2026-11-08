package x;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Timer;
import net.minecraft.util.Vec3;

public class oc51fb428ba0 extends oc69da1aa7f5 {
   private static final String[] Ƅ;
   private static final double Ƶ = 6.0;
   private static final long é = 10000000L;
   private static final Set<Packet<?>> ώ = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap<>()));
   private final ocaea619d4ce շ = new ocaea619d4ce();
   private final LongSupplier Ƨ;
   private final LongConsumer Ψ;
   private final oc63e3533dee ȥ;
   private final oc63e3533dee Ч;
   private final oca9cc61aada Ò;
   private final oca9cc61aada Ĳ;
   private final oca9cc61aada Ĺ;
   private final oca9cc61aada Ͷ;
   private final oca9cc61aada Җ;
   private final oca9cc61aada П;
   private final oca9cc61aada ȓ;
   private final oca9cc61aada Ƭ;
   private final oca9cc61aada Ū;
   private final oca9cc61aada ē;
   private final occ2f8dff8d8 Ǭ;
   private final occ2f8dff8d8 ɥ;
   private final occ2f8dff8d8 ŏ;
   private final occ2f8dff8d8 ϩ;
   private final occ2f8dff8d8 Ȧ;
   private EntityPlayer ɂ;
   private EntityPlayer È;
   private EntityPlayerSP ȣ;
   private WorldClient Ѡ;
   private NetHandlerPlayClient o;
   private Timer Ӓ;
   private float F = 1.0F;
   private long հ;
   private long ʪ;
   private long ċ;
   private long ɋ;
   private long җ;
   private long Ɏ = -6714303807757741078L ^ 2509068229097034730L;
   private long Ԕ = -6714303807757741078L ^ 2509068229097034730L;
   private boolean ѫ;
   private boolean Ƚ;
   private boolean պ;
   private boolean Ъ;
   private ItemStack Ѥ;
   public static int Ţ;

   public oc51fb428ba0() {
      this(System::nanoTime, oc51fb428ba0::ˣ, ocd6ae010123::Å);
   }

   oc51fb428ba0(LongSupplier var1, Consumer<Packet<?>> var2, Consumer<Packet<?>> var3) {
      this(var1, var2, var3, LockSupport::parkNanos);
   }

   oc51fb428ba0(LongSupplier var1, Consumer<Packet<?>> var2, Consumer<Packet<?>> var3, LongConsumer var4) {
      super("TimerRange", oce4cea752dd.ȁ);
      this.ą("Modifies your game timer speed to teleport you towards your opponent.");
      this.Ƨ = var1;
      this.Ψ = var4;
      this.Ч = new oc63e3533dee(var2);
      this.ȥ = new oc63e3533dee(var3);
      this.ʌ(this.Ò = new oca9cc61aada("Mode", 0, Ƅ));
      this.ʌ(this.Ĳ = new oca9cc61aada("Minimum distance", 3.0, 1.0, 6.0, 0.1));
      this.ʌ(this.Ĺ = new oca9cc61aada("Duration", "ms", 200.0, 50.0, 1000.0, 50.0));
      this.ʌ(this.Ͷ = new oca9cc61aada("Cooldown", "ms", 500.0, 0.0, 5000.0, 50.0));
      this.ʌ(this.Җ = new oca9cc61aada("Lag ticks", 3.0, 0.0, 20.0, 1.0));
      this.ʌ(this.П = new oca9cc61aada("Tick variation", 1.0, 0.0, 5.0, 1.0));
      this.ʌ(this.ȓ = new oca9cc61aada("Timer ticks", 3.0, 1.0, 10.0, 1.0));
      this.ʌ(this.Ƭ = new oca9cc61aada("Freeze ticks", 1.0, 1.0, 20.0, 1.0));
      this.ʌ(this.Ū = new oca9cc61aada("Max target hurt time", 10.0, 0.0, 10.0, 1.0));
      this.ʌ(this.ē = new oca9cc61aada("Delay", "ms", 250.0, 0.0, 5000.0, 50.0));
      this.ʌ(this.Ǭ = new occ2f8dff8d8("Ground only", false));
      this.ʌ(this.ɥ = new occ2f8dff8d8("Block while frozen", true));
      occc831eff22 var5 = new occc831eff22("Conditions");
      this.ʌ(var5);
      this.ʌ(this.ŏ = new occ2f8dff8d8(var5, "Left mouse button", true));
      this.ʌ(this.ϩ = new occ2f8dff8d8(var5, "Holding a weapon", true));
      this.ʌ(this.Ȧ = new occ2f8dff8d8(var5, "Not using an item", true));
      this.z$2u87utkr1isxg();
   }

   @Override
   public synchronized void onEnable() {
      this.Ϛ(false, false, true);
   }

   @Override
   public synchronized void onDisable() {
      this.Ϛ(true, false, true);
   }

   @Override
   public void z$2u87utkr1isxg() {
      int var10000 = oc5e549848f3.İ;
      boolean var2 = this.Ŭ();
      int var1 = var10000;

      boolean var10001;
      label39: {
         label38: {
            try {
               var5 = this.Ĺ;
               var10001 = var2;
               if (var1 != 0) {
                  break label39;
               }

               if (!var2) {
                  break label38;
               }
            } catch (RuntimeException var4) {
               throw var4;
            }

            var10001 = false;
            break label39;
         }

         var10001 = true;
      }

      label30: {
         label29: {
            try {
               var5.ȉ(var10001, this);
               var6 = this.Ͷ;
               var10001 = var2;
               if (var1 != 0) {
                  break label30;
               }

               if (!var2) {
                  break label29;
               }
            } catch (RuntimeException var3) {
               throw var3;
            }

            var10001 = false;
            break label30;
         }

         var10001 = true;
      }

      var6.ȉ(var10001, this);
      this.ȓ.ȉ(true, this);
      this.Ƭ.ȉ(var2, this);
      this.Ū.ȉ(var2, this);
      this.ē.ȉ(var2, this);
      this.Ǭ.ȉ(var2, this);
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      try {
         if (var1 == this.Ò) {
            this.z$2u87utkr1isxg();
         }
      } catch (RuntimeException var2) {
         throw var2;
      }
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      try {
         if (var1 == this.Ò) {
            this.z$2u87utkr1isxg();
         }
      } catch (RuntimeException var2) {
         throw var2;
      }
   }

   @Override
   public String getInfo() {
      return Ƅ[(int)this.Ò.Ӂ()];
   }

   public synchronized boolean Ǿ() {
      return this.շ.ȗ();
   }

   public synchronized boolean ա(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oc51fb428ba0.Ƨ Ljava/util/function/LongSupplier;
      // 04: invokeinterface java/util/function/LongSupplier.getAsLong ()J 1
      // 09: lstore 4
      // 0b: getstatic x/oc5e549848f3.İ I
      // 0e: lconst_0
      // 0f: lload 1
      // 10: invokestatic java/lang/Math.max (JJ)J
      // 13: ldc2_w 6287161672365622927
      // 16: ldc2_w 6287161672364885199
      // 19: lxor
      // 1a: lmul
      // 1b: lstore 6
      // 1d: istore 3
      // 1e: aload 0
      // 1f: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 22: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 25: iload 3
      // 26: ifne 99
      // 29: ifne 98
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 0
      // 31: getfield x/oc51fb428ba0.Ɏ J
      // 34: iload 3
      // 35: ifne 6c
      // 38: goto 3c
      // 3b: athrow
      // 3c: ldc2_w -2936210364489890609
      // 3f: ldc2_w 6287161672364885199
      // 42: lxor
      // 43: lcmp
      // 44: ifeq 64
      // 47: goto 4b
      // 4a: athrow
      // 4b: lload 4
      // 4d: aload 0
      // 4e: getfield x/oc51fb428ba0.Ɏ J
      // 51: lsub
      // 52: lload 6
      // 54: lcmp
      // 55: iload 3
      // 56: ifne 99
      // 59: goto 5d
      // 5c: athrow
      // 5d: ifle 98
      // 60: goto 64
      // 63: athrow
      // 64: aload 0
      // 65: getfield x/oc51fb428ba0.Ԕ J
      // 68: goto 6c
      // 6b: athrow
      // 6c: ldc2_w -2936210364489890609
      // 6f: ldc2_w 6287161672364885199
      // 72: lxor
      // 73: iload 3
      // 74: ifne 8c
      // 77: lcmp
      // 78: ifeq 9c
      // 7b: goto 7f
      // 7e: athrow
      // 7f: lload 4
      // 81: aload 0
      // 82: getfield x/oc51fb428ba0.Ԕ J
      // 85: lsub
      // 86: lload 6
      // 88: goto 8c
      // 8b: athrow
      // 8c: lcmp
      // 8d: iload 3
      // 8e: ifne 99
      // 91: ifgt 9c
      // 94: goto 98
      // 97: athrow
      // 98: bipush 1
      // 99: goto 9d
      // 9c: bipush 0
      // 9d: ireturn
   }

   public static boolean ȃ() {
      int var10000 = oc5e549848f3.İ;
      oc51fb428ba0 var1 = ӓ();
      int var0 = var10000;

      label33: {
         try {
            var4 = var1;
            if (var0 != 0) {
               break label33;
            }

            if (var1 == null) {
               return false;
            }
         } catch (RuntimeException var3) {
            throw var3;
         }

         var4 = var1;
      }

      try {
         boolean var5 = var4.Ǿ();
         if (var0 != 0) {
            return var5;
         }

         if (var5) {
            return true;
         }
      } catch (RuntimeException var2) {
         throw var2;
      }

      return false;
   }

   public static boolean Ɂ() {
      int var10000 = oc5e549848f3.İ;
      oc51fb428ba0 var1 = ӓ();
      int var0 = var10000;

      try {
         if (var1 == null) {
            return false;
         }
      } catch (RuntimeException var5) {
         throw var5;
      }

      synchronized (var1) {
         oca40eaa9ef8 var6 = var1.շ.ŝ();
         if (var0 == 0) {
            if (var6 == oca40eaa9ef8.С) {
               return true;
            }

            var6 = var1.շ.ŝ();
         }

         return var6 == oca40eaa9ef8.ħ;
      }
   }

   public static boolean ǳ() {
      oc51fb428ba0 var0 = ӓ();

      try {
         if (var0 == null) {
            return false;
         }
      } catch (RuntimeException var4) {
         throw var4;
      }

      synchronized (var0) {
         return var0.շ.ŝ() == oca40eaa9ef8.С;
      }
   }

   public static void к(Timer var0) {
      int var10000 = oc5e549848f3.İ;
      oc51fb428ba0 var2 = ӓ();
      int var1 = var10000;

      label20: {
         try {
            var4 = var2;
            if (var1 != 0) {
               break label20;
            }

            if (var2 == null) {
               return;
            }
         } catch (RuntimeException var3) {
            throw var3;
         }

         var4 = var2;
      }

      var4.ŋ(var0);
   }

   public static void Ⱥ(Timer var0) {
      int var10000 = oc5e549848f3.İ;
      oc51fb428ba0 var2 = ӓ();
      int var1 = var10000;

      label20: {
         try {
            var4 = var2;
            if (var1 != 0) {
               break label20;
            }

            if (var2 == null) {
               return;
            }
         } catch (RuntimeException var3) {
            throw var3;
         }

         var4 = var2;
      }

      var4.ġ(var0);
   }

   public static void ҧ(Timer var0) {
      int var10000 = oc5e549848f3.İ;
      oc51fb428ba0 var2 = ӓ();
      int var1 = var10000;

      try {
         if (var2 == null) {
            return;
         }
      } catch (RuntimeException var6) {
         throw var6;
      }

      synchronized (var2) {
         oca40eaa9ef8 var7 = var2.շ.ŝ();
         if (var1 == 0) {
            if (var7 == oca40eaa9ef8.С) {
               var0.elapsedTicks = 0;
               if (var1 == 0) {
                  return;
               }
            }

            var7 = var2.շ.ŝ();
         }

         if (var7 == oca40eaa9ef8.ħ) {
            var0.elapsedTicks = var0.elapsedTicks + var2.շ.џ(var2.հ, var0.elapsedTicks);
         }
      }
   }

   public static boolean ǻ() {
      return ǳ();
   }

   public static void ҷ() {
      oc51fb428ba0 var0 = ӓ();
      if (var0 != null) {
         synchronized (var0) {
            var0.շ.ɥ();
         }
      }
   }

   public static void ʒ() {
      oc51fb428ba0 var0 = ӓ();

      try {
         if (var0 == null) {
            return;
         }
      } catch (RuntimeException var5) {
         throw var5;
      }

      synchronized (var0) {
         if (var0.շ.ѕ(var0.հ)) {
            if (var0.Ӓ != null) {
               float var2 = var0.շ.Ĳ(var0.հ);
               var0.Ӓ.elapsedPartialTicks = var2;
               var0.Ӓ.renderPartialTicks = var2;
            }

            var0.Ϛ(true, true, false);
         }
      }
   }

   public static boolean ѐ(Packet<?> var0) {
      return ώ.contains(var0);
   }

   public static void տ(Packet<?> var0) {
      ώ.remove(var0);
   }

   public static boolean Ώ(Packet<?> param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: invokestatic x/oc51fb428ba0.ӓ ()Lx/oc51fb428ba0;
      // 03: astore 1
      // 04: aload 1
      // 05: ifnull 26
      // 08: aload 0
      // 09: ifnull 26
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: invokestatic x/oc51fb428ba0.ѐ (Lnet/minecraft/network/Packet;)Z
      // 14: ifne 26
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: invokestatic x/ocb67361fd4e.ԅ (Lnet/minecraft/network/Packet;)Z
      // 1f: ifne 29
      // 22: goto 26
      // 25: athrow
      // 26: bipush 0
      // 27: ireturn
      // 28: athrow
      // 29: aload 1
      // 2a: dup
      // 2b: astore 2
      // 2c: monitorenter
      // 2d: aload 1
      // 2e: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 31: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 34: ifeq 53
      // 37: aload 1
      // 38: getfield x/oc51fb428ba0.պ Z
      // 3b: ifne 53
      // 3e: aload 1
      // 3f: getfield x/oc51fb428ba0.ѫ Z
      // 42: ifne 53
      // 45: aload 1
      // 46: getfield x/oc51fb428ba0.Ƚ Z
      // 49: ifne 53
      // 4c: aload 1
      // 4d: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 50: ifne 57
      // 53: bipush 0
      // 54: aload 2
      // 55: monitorexit
      // 56: ireturn
      // 57: aload 1
      // 58: getfield x/oc51fb428ba0.Ч Lx/oc63e3533dee;
      // 5b: aload 0
      // 5c: invokevirtual x/oc63e3533dee.Ǭ (Lnet/minecraft/network/Packet;)V
      // 5f: bipush 1
      // 60: aload 2
      // 61: monitorexit
      // 62: ireturn
      // 63: astore 3
      // 64: aload 2
      // 65: monitorexit
      // 66: aload 3
      // 67: athrow
   }

   public static boolean Т(Packet<?> param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: invokestatic x/oc51fb428ba0.ӓ ()Lx/oc51fb428ba0;
      // 06: astore 2
      // 07: istore 1
      // 08: aload 2
      // 09: ifnull 2b
      // 0c: aload 0
      // 0d: iload 1
      // 0e: ifne 1d
      // 11: goto 15
      // 14: athrow
      // 15: ifnull 2b
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: invokestatic x/ocb67361fd4e.Ф (Lnet/minecraft/network/Packet;)Z
      // 20: iload 1
      // 21: ifne 2c
      // 24: ifeq 2d
      // 27: goto 2b
      // 2a: athrow
      // 2b: bipush 0
      // 2c: ireturn
      // 2d: aload 2
      // 2e: dup
      // 2f: astore 3
      // 30: monitorenter
      // 31: aload 2
      // 32: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 35: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 38: iload 1
      // 39: ifne 79
      // 3c: ifeq 78
      // 3f: aload 2
      // 40: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 43: invokevirtual x/ocaea619d4ce.ŝ ()Lx/oca40eaa9ef8;
      // 46: getstatic x/oca40eaa9ef8.ħ Lx/oca40eaa9ef8;
      // 49: if_acmpeq 78
      // 4c: aload 2
      // 4d: getfield x/oc51fb428ba0.պ Z
      // 50: iload 1
      // 51: ifne 79
      // 54: ifne 78
      // 57: aload 2
      // 58: getfield x/oc51fb428ba0.ѫ Z
      // 5b: iload 1
      // 5c: ifne 79
      // 5f: ifne 78
      // 62: aload 2
      // 63: getfield x/oc51fb428ba0.Ƚ Z
      // 66: iload 1
      // 67: ifne 79
      // 6a: ifne 78
      // 6d: aload 2
      // 6e: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 71: iload 1
      // 72: ifne 85
      // 75: ifne 7c
      // 78: bipush 0
      // 79: aload 3
      // 7a: monitorexit
      // 7b: ireturn
      // 7c: aload 2
      // 7d: getfield x/oc51fb428ba0.ȥ Lx/oc63e3533dee;
      // 80: aload 0
      // 81: invokevirtual x/oc63e3533dee.Ǭ (Lnet/minecraft/network/Packet;)V
      // 84: bipush 1
      // 85: aload 3
      // 86: monitorexit
      // 87: ireturn
      // 88: astore 4
      // 8a: aload 3
      // 8b: monitorexit
      // 8c: aload 4
      // 8e: athrow
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void u(oc507025139f var1) {
      try {
         if (Ɂ()) {
            var1.setCanceled(true);
         }
      } catch (RuntimeException var2) {
         throw var2;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ŋ(occ48acb5d22 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc51fb428ba0.Ɂ ()Z
      // 07: ifeq 2c
      // 0a: aload 1
      // 0b: iload 2
      // 0c: ifne 28
      // 0f: goto 13
      // 12: athrow
      // 13: getfield x/occ48acb5d22.Ǖ Lnet/minecraft/entity/player/EntityPlayer;
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: if_acmpne 2c
      // 1f: goto 23
      // 22: athrow
      // 23: aload 1
      // 24: goto 28
      // 27: athrow
      // 28: bipush 1
      // 29: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 2c: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ɟ(oce21f48fe00 var1) {
      try {
         if (Ɂ()) {
            var1.setCanceled(true);
         }
      } catch (RuntimeException var2) {
         throw var2;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public synchronized void Ǫ(ocf6b0e5bf86 param1) {
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
      // 06: ifne 1b
      // 09: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 0c: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 0f: ifne 59
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: iload 2
      // 1c: ifne 2e
      // 1f: getfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 22: ifnonnull 59
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 2
      // 2f: ifne 41
      // 32: invokevirtual x/oc51fb428ba0.ʕ ()Z
      // 35: ifne 59
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 0
      // 3d: goto 41
      // 40: athrow
      // 41: iload 2
      // 42: ifne 5c
      // 45: getfield x/oc51fb428ba0.Ƨ Ljava/util/function/LongSupplier;
      // 48: invokeinterface java/util/function/LongSupplier.getAsLong ()J 1
      // 4d: aload 0
      // 4e: getfield x/oc51fb428ba0.ċ J
      // 51: lcmp
      // 52: ifge 5b
      // 55: goto 59
      // 58: athrow
      // 59: return
      // 5a: athrow
      // 5b: aload 0
      // 5c: invokevirtual x/oc51fb428ba0.ӑ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 5f: astore 3
      // 60: aload 0
      // 61: iload 2
      // 62: ifne 75
      // 65: aload 3
      // 66: invokevirtual x/oc51fb428ba0.á (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 69: ifeq 79
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 0
      // 71: goto 75
      // 74: athrow
      // 75: aload 3
      // 76: putfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 79: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public synchronized void и(oce4fccf5a38 var1) {
      this.Ϛ(false, false, true);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public synchronized void ɴ(ocbab3c9954b var1) {
      this.Ϛ(false, false, true);
   }

   public synchronized void ɜ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: aconst_null
      // 07: putfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 0a: ifne 45
      // 0d: aload 0
      // 0e: getfield x/oc51fb428ba0.ȥ Lx/oc63e3533dee;
      // 11: invokevirtual x/oc63e3533dee.Ǯ ()V
      // 14: aload 0
      // 15: getfield x/oc51fb428ba0.Ч Lx/oc63e3533dee;
      // 18: invokevirtual x/oc63e3533dee.Ǯ ()V
      // 1b: aload 0
      // 1c: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 1f: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 22: ifne 3c
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: iload 1
      // 2b: ifne 46
      // 2e: goto 32
      // 31: athrow
      // 32: getfield x/oc51fb428ba0.Ӓ Lnet/minecraft/util/Timer;
      // 35: ifnull 4a
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 0
      // 3d: bipush 1
      // 3e: putfield x/oc51fb428ba0.Ƚ Z
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: bipush 0
      // 47: invokevirtual x/oc51fb428ba0.Ѽ (Z)V
      // 4a: return
   }

   public synchronized void Ȭ() {
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
      // 06: ifne 2c
      // 09: aconst_null
      // 0a: putfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 0d: aload 0
      // 0e: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 11: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 14: ifeq 30
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: bipush 1
      // 1d: putfield x/oc51fb428ba0.ѫ Z
      // 20: aload 0
      // 21: getfield x/oc51fb428ba0.Ч Lx/oc63e3533dee;
      // 24: invokevirtual x/oc63e3533dee.Û ()V
      // 27: aload 0
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: invokevirtual x/oc51fb428ba0.Ѽ (Z)V
      // 30: return
   }

   private void Ѽ(boolean var1) {
      long var2 = this.җ;
      oc69da1aa7f5.ő.addScheduledTask(() -> {
         oc51fb428ba0 var5 = this;
         synchronized (this){} // $VF: monitorenter 
         int var4 = oc5e549848f3.İ;

         try {
            label72: {
               long var9;
               int var10000 = (var9 = var2 - this.җ) == 0L ? 0 : (var9 < 0L ? -1 : 1);
               if (var4 == 0) {
                  if (var10000) {
                     break label72;
                  }

                  var10000 = this.Ƚ;
               }

               label60: {
                  if (var4 == 0) {
                     if (var10000) {
                        break label60;
                     }

                     var10000 = this.ѫ;
                  }

                  if (!var10000) {
                     break label72;
                  }
               }

               this.Ϛ(var1 && !this.Ƚ, true, this.Ƚ);
            }

            // $VF: monitorexit
         } finally {
            // $VF: monitorexit
         }
      });
   }

   private void ġ(Timer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: aload 0
      // 004: dup
      // 005: astore 5
      // 007: monitorenter
      // 008: istore 2
      // 009: aload 0
      // 00a: invokevirtual x/oc51fb428ba0.Ŭ ()Z
      // 00d: ifeq 01d
      // 010: aload 0
      // 011: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 014: invokevirtual x/ocaea619d4ce.ŝ ()Lx/oca40eaa9ef8;
      // 017: getstatic x/oca40eaa9ef8.С Lx/oca40eaa9ef8;
      // 01a: if_acmpeq 021
      // 01d: aload 5
      // 01f: monitorexit
      // 020: return
      // 021: aload 0
      // 022: getfield x/oc51fb428ba0.җ J
      // 025: lstore 3
      // 026: aload 5
      // 028: monitorexit
      // 029: goto 034
      // 02c: astore 6
      // 02e: aload 5
      // 030: monitorexit
      // 031: aload 6
      // 033: athrow
      // 034: invokestatic java/lang/Thread.currentThread ()Ljava/lang/Thread;
      // 037: invokevirtual java/lang/Thread.isInterrupted ()Z
      // 03a: ifne 0f3
      // 03d: aload 0
      // 03e: dup
      // 03f: astore 7
      // 041: monitorenter
      // 042: lload 3
      // 043: aload 0
      // 044: getfield x/oc51fb428ba0.җ J
      // 047: lcmp
      // 048: iload 2
      // 049: ifne 053
      // 04c: ifne 0a1
      // 04f: aload 0
      // 050: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 053: iload 2
      // 054: ifne 05e
      // 057: ifeq 0a1
      // 05a: aload 0
      // 05b: invokevirtual x/oc51fb428ba0.Ŭ ()Z
      // 05e: ifeq 0a1
      // 061: aload 0
      // 062: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 065: invokevirtual x/ocaea619d4ce.ŝ ()Lx/oca40eaa9ef8;
      // 068: getstatic x/oca40eaa9ef8.С Lx/oca40eaa9ef8;
      // 06b: if_acmpne 0a1
      // 06e: aload 0
      // 06f: getfield x/oc51fb428ba0.Ƚ Z
      // 072: iload 2
      // 073: ifne 07d
      // 076: ifne 0a1
      // 079: aload 0
      // 07a: getfield x/oc51fb428ba0.ѫ Z
      // 07d: iload 2
      // 07e: ifne 088
      // 081: ifne 0a1
      // 084: aload 0
      // 085: invokevirtual x/oc51fb428ba0.ʕ ()Z
      // 088: iload 2
      // 089: ifne 093
      // 08c: ifne 0a1
      // 08f: aload 0
      // 090: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 093: iload 2
      // 094: ifne 09e
      // 097: ifeq 0a1
      // 09a: aload 0
      // 09b: invokevirtual x/oc51fb428ba0.П ()Z
      // 09e: ifeq 0a7
      // 0a1: aload 7
      // 0a3: monitorexit
      // 0a4: goto 0f3
      // 0a7: aload 0
      // 0a8: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 0ab: aload 0
      // 0ac: getfield x/oc51fb428ba0.Ƨ Ljava/util/function/LongSupplier;
      // 0af: invokeinterface java/util/function/LongSupplier.getAsLong ()J 1
      // 0b4: invokevirtual x/ocaea619d4ce.ɫ (J)J
      // 0b7: lstore 5
      // 0b9: aload 7
      // 0bb: monitorexit
      // 0bc: goto 0c7
      // 0bf: astore 8
      // 0c1: aload 7
      // 0c3: monitorexit
      // 0c4: aload 8
      // 0c6: athrow
      // 0c7: lload 5
      // 0c9: lconst_0
      // 0ca: lcmp
      // 0cb: ifne 0d6
      // 0ce: iload 2
      // 0cf: ifeq 0f3
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: aload 0
      // 0d7: getfield x/oc51fb428ba0.Ψ Ljava/util/function/LongConsumer;
      // 0da: lload 5
      // 0dc: ldc2_w 2258134907147310312
      // 0df: ldc2_w 2258134907156185704
      // 0e2: lxor
      // 0e3: invokestatic java/lang/Math.min (JJ)J
      // 0e6: invokeinterface java/util/function/LongConsumer.accept (J)V 3
      // 0eb: iload 2
      // 0ec: ifeq 034
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: aload 0
      // 0f4: dup
      // 0f5: astore 5
      // 0f7: monitorenter
      // 0f8: aload 1
      // 0f9: getfield net/minecraft/util/Timer.timerSpeed F
      // 0fc: fstore 6
      // 0fe: aload 1
      // 0ff: fconst_0
      // 100: putfield net/minecraft/util/Timer.timerSpeed F
      // 103: aload 1
      // 104: invokevirtual net/minecraft/util/Timer.updateTimer ()V
      // 107: aload 1
      // 108: fload 6
      // 10a: putfield net/minecraft/util/Timer.timerSpeed F
      // 10d: goto 11b
      // 110: astore 9
      // 112: aload 1
      // 113: fload 6
      // 115: putfield net/minecraft/util/Timer.timerSpeed F
      // 118: aload 9
      // 11a: athrow
      // 11b: lload 3
      // 11c: aload 0
      // 11d: getfield x/oc51fb428ba0.җ J
      // 120: lcmp
      // 121: iload 2
      // 122: ifne 12c
      // 125: ifne 133
      // 128: aload 0
      // 129: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 12c: iload 2
      // 12d: ifne 13d
      // 130: ifne 137
      // 133: aload 5
      // 135: monitorexit
      // 136: return
      // 137: invokestatic java/lang/Thread.currentThread ()Ljava/lang/Thread;
      // 13a: invokevirtual java/lang/Thread.isInterrupted ()Z
      // 13d: ifeq 156
      // 140: aload 0
      // 141: aload 0
      // 142: getfield x/oc51fb428ba0.Ƚ Z
      // 145: ifne 14c
      // 148: bipush 1
      // 149: goto 14d
      // 14c: bipush 0
      // 14d: bipush 1
      // 14e: bipush 0
      // 14f: invokevirtual x/oc51fb428ba0.Ϛ (ZZZ)V
      // 152: aload 5
      // 154: monitorexit
      // 155: return
      // 156: aload 0
      // 157: aload 1
      // 158: invokevirtual x/oc51fb428ba0.ŋ (Lnet/minecraft/util/Timer;)V
      // 15b: aload 5
      // 15d: monitorexit
      // 15e: goto 169
      // 161: astore 10
      // 163: aload 5
      // 165: monitorexit
      // 166: aload 10
      // 168: athrow
      // 169: return
   }

   private synchronized void ŋ(Timer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 040
      // 009: aload 0
      // 00a: getfield x/oc51fb428ba0.հ J
      // 00d: putfield x/oc51fb428ba0.ʪ J
      // 010: aload 0
      // 011: aload 0
      // 012: getfield x/oc51fb428ba0.Ƨ Ljava/util/function/LongSupplier;
      // 015: invokeinterface java/util/function/LongSupplier.getAsLong ()J 1
      // 01a: putfield x/oc51fb428ba0.հ J
      // 01d: aload 0
      // 01e: getfield x/oc51fb428ba0.Ƚ Z
      // 021: ifne 03b
      // 024: goto 028
      // 027: athrow
      // 028: aload 0
      // 029: iload 2
      // 02a: ifne 05d
      // 02d: goto 031
      // 030: athrow
      // 031: getfield x/oc51fb428ba0.ѫ Z
      // 034: ifeq 05c
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: goto 040
      // 03f: athrow
      // 040: aload 0
      // 041: getfield x/oc51fb428ba0.Ƚ Z
      // 044: iload 2
      // 045: ifne 050
      // 048: ifne 053
      // 04b: goto 04f
      // 04e: athrow
      // 04f: bipush 1
      // 050: goto 054
      // 053: bipush 0
      // 054: bipush 1
      // 055: aload 0
      // 056: getfield x/oc51fb428ba0.Ƚ Z
      // 059: invokevirtual x/oc51fb428ba0.Ϛ (ZZZ)V
      // 05c: aload 0
      // 05d: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 060: iload 2
      // 061: ifne 0ae
      // 064: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 067: ifeq 0a2
      // 06a: goto 06e
      // 06d: athrow
      // 06e: aload 0
      // 06f: iload 2
      // 070: ifne 099
      // 073: goto 077
      // 076: athrow
      // 077: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 07a: ifeq 094
      // 07d: goto 081
      // 080: athrow
      // 081: aload 0
      // 082: iload 2
      // 083: ifne 0a3
      // 086: goto 08a
      // 089: athrow
      // 08a: invokevirtual x/oc51fb428ba0.ʕ ()Z
      // 08d: ifeq 0a2
      // 090: goto 094
      // 093: athrow
      // 094: aload 0
      // 095: goto 099
      // 098: athrow
      // 099: aload 0
      // 09a: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 09d: bipush 1
      // 09e: bipush 0
      // 09f: invokevirtual x/oc51fb428ba0.Ϛ (ZZZ)V
      // 0a2: aload 0
      // 0a3: iload 2
      // 0a4: ifne 0fa
      // 0a7: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 0b1: ifne 0f9
      // 0b4: aload 0
      // 0b5: getfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 0b8: astore 3
      // 0b9: aload 0
      // 0ba: iload 2
      // 0bb: ifne 0cf
      // 0be: aconst_null
      // 0bf: putfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 0c2: aload 3
      // 0c3: ifnull 0f1
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: aload 0
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: iload 2
      // 0d0: ifne 0e2
      // 0d3: invokevirtual x/oc51fb428ba0.ʕ ()Z
      // 0d6: ifne 0f1
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: iload 2
      // 0e3: ifne 0f4
      // 0e6: aload 3
      // 0e7: invokevirtual x/oc51fb428ba0.á (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 0ea: ifne 0f3
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: return
      // 0f2: athrow
      // 0f3: aload 0
      // 0f4: aload 3
      // 0f5: aload 1
      // 0f6: invokevirtual x/oc51fb428ba0.ϔ (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/util/Timer;)V
      // 0f9: aload 0
      // 0fa: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 0fd: invokevirtual x/ocaea619d4ce.ŝ ()Lx/oca40eaa9ef8;
      // 100: astore 3
      // 101: aload 0
      // 102: iload 2
      // 103: ifne 120
      // 106: invokevirtual x/oc51fb428ba0.П ()Z
      // 109: ifeq 11f
      // 10c: goto 110
      // 10f: athrow
      // 110: aload 0
      // 111: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 114: aload 0
      // 115: getfield x/oc51fb428ba0.հ J
      // 118: invokevirtual x/ocaea619d4ce.դ (J)V
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 0
      // 120: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 123: aload 0
      // 124: getfield x/oc51fb428ba0.հ J
      // 127: invokevirtual x/ocaea619d4ce.ѻ (J)Z
      // 12a: istore 4
      // 12c: aload 0
      // 12d: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 130: iload 2
      // 131: ifne 179
      // 134: invokevirtual x/ocaea619d4ce.ŝ ()Lx/oca40eaa9ef8;
      // 137: getstatic x/oca40eaa9ef8.ħ Lx/oca40eaa9ef8;
      // 13a: if_acmpne 169
      // 13d: goto 141
      // 140: athrow
      // 141: iload 4
      // 143: ifne 15d
      // 146: goto 14a
      // 149: athrow
      // 14a: aload 3
      // 14b: iload 2
      // 14c: ifne 17c
      // 14f: goto 153
      // 152: athrow
      // 153: getstatic x/oca40eaa9ef8.ħ Lx/oca40eaa9ef8;
      // 156: if_acmpeq 169
      // 159: goto 15d
      // 15c: athrow
      // 15d: aload 0
      // 15e: invokevirtual x/oc51fb428ba0.ր ()V
      // 161: iload 2
      // 162: ifeq 18a
      // 165: goto 169
      // 168: athrow
      // 169: aload 0
      // 16a: iload 2
      // 16b: ifne 18b
      // 16e: goto 172
      // 171: athrow
      // 172: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 175: goto 179
      // 178: athrow
      // 179: invokevirtual x/ocaea619d4ce.ŝ ()Lx/oca40eaa9ef8;
      // 17c: getstatic x/oca40eaa9ef8.С Lx/oca40eaa9ef8;
      // 17f: if_acmpne 18a
      // 182: aload 0
      // 183: invokevirtual x/oc51fb428ba0.Ė ()V
      // 186: goto 18a
      // 189: athrow
      // 18a: aload 0
      // 18b: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 18e: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 191: ifeq 1ac
      // 194: aload 1
      // 195: aload 0
      // 196: getfield x/oc51fb428ba0.F F
      // 199: aload 0
      // 19a: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 19d: aload 0
      // 19e: getfield x/oc51fb428ba0.հ J
      // 1a1: invokevirtual x/ocaea619d4ce.ց (J)F
      // 1a4: fmul
      // 1a5: putfield net/minecraft/util/Timer.timerSpeed F
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: return
   }

   private boolean П() {
      int var1 = oc5e549848f3.İ;
      int var2 = -1535124986 ^ -1445515753;

      while (true) {
         switch (var2) {
            case -1847784625:
               break;
            case -1782442979:
               int var6;
               label83: {
                  label82: {
                     try {
                        var6 = this.Ч.Մ();
                        if (var1 != 0) {
                           break label83;
                        }

                        if (var6 == 0) {
                           break label82;
                        }
                     } catch (RuntimeException var5) {
                        throw var5;
                     }

                     var2 = -1295474067 ^ -1445515753;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var6 = 1736120708 ^ -1445515753;
               }

               var2 = var6;
               if (var1 == 0) {
                  continue;
               }
            case 229176337:
               if (this.È != null) {
                  var2 = 940189016 ^ -1445515753;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -1295474067 ^ -1445515753;
               if (var1 == 0) {
                  continue;
               }

               return true;
            case -827574381:
               return false;
            case 215608561:
               int var10000;
               label74: {
                  label73: {
                     try {
                        var10000 = this.ȥ.Մ();
                        if (var1 != 0) {
                           break label74;
                        }

                        if (var10000 != 0) {
                           break label73;
                        }
                     } catch (RuntimeException var4) {
                        throw var4;
                     }

                     var2 = 1008024074 ^ -1445515753;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -1295474067 ^ -1445515753;
               }

               var2 = var10000;
               if (var1 == 0) {
                  continue;
               }
            case -1275914304:
               if (this.Ѡ.getEntityByID(this.È.getEntityId()) == this.È) {
                  var2 = -1525759258 ^ -1445515753;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -1295474067 ^ -1445515753;
               if (var1 == 0) {
                  continue;
               }
               break;
            case 455052410:
               return true;
            default:
               throw null;
         }

         int var7;
         label61: {
            label60: {
               try {
                  var7 = this.È.isDead;
                  if (var1 != 0) {
                     break label61;
                  }

                  if (this.È.isDead) {
                     break label60;
                  }
               } catch (RuntimeException var3) {
                  throw var3;
               }

               var2 = 438581719 ^ -1445515753;
               if (var1 == 0) {
                  continue;
               }
            }

            var7 = -1295474067 ^ -1445515753;
         }

         var2 = var7;
      }
   }

   private void ϔ(EntityPlayer param1, Timer param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: aload 0
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: putfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00d: aload 0
      // 00e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 011: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 014: putfield x/oc51fb428ba0.Ѡ Lnet/minecraft/client/multiplayer/WorldClient;
      // 017: aload 0
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 01e: putfield x/oc51fb428ba0.o Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 021: aload 0
      // 022: aload 1
      // 023: putfield x/oc51fb428ba0.È Lnet/minecraft/entity/player/EntityPlayer;
      // 026: istore 3
      // 027: aload 0
      // 028: aload 2
      // 029: putfield x/oc51fb428ba0.Ӓ Lnet/minecraft/util/Timer;
      // 02c: aload 0
      // 02d: aload 2
      // 02e: getfield net/minecraft/util/Timer.timerSpeed F
      // 031: putfield x/oc51fb428ba0.F F
      // 034: aload 0
      // 035: aload 0
      // 036: iload 3
      // 037: ifne 050
      // 03a: invokevirtual x/oc51fb428ba0.Ŭ ()Z
      // 03d: ifeq 04f
      // 040: goto 044
      // 043: athrow
      // 044: aload 0
      // 045: getfield x/oc51fb428ba0.ē Lx/oca9cc61aada;
      // 048: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 04b: goto 056
      // 04e: athrow
      // 04f: aload 0
      // 050: getfield x/oc51fb428ba0.Ͷ Lx/oca9cc61aada;
      // 053: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 056: d2l
      // 057: ldc2_w 3888789601790618365
      // 05a: ldc2_w 3888789601790798013
      // 05d: lxor
      // 05e: lmul
      // 05f: putfield x/oc51fb428ba0.ɋ J
      // 062: aload 0
      // 063: aload 0
      // 064: getfield x/oc51fb428ba0.հ J
      // 067: putfield x/oc51fb428ba0.Ɏ J
      // 06a: aload 0
      // 06b: iload 3
      // 06c: ifne 090
      // 06f: dup
      // 070: getfield x/oc51fb428ba0.җ J
      // 073: lconst_1
      // 074: ladd
      // 075: putfield x/oc51fb428ba0.җ J
      // 078: aload 0
      // 079: invokevirtual x/oc51fb428ba0.Ŭ ()Z
      // 07c: ifeq 08f
      // 07f: goto 083
      // 082: athrow
      // 083: aload 0
      // 084: getfield x/oc51fb428ba0.Ƭ Lx/oca9cc61aada;
      // 087: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08a: d2i
      // 08b: goto 09e
      // 08e: athrow
      // 08f: aload 0
      // 090: getfield x/oc51fb428ba0.Ĺ Lx/oca9cc61aada;
      // 093: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 096: ldc2_w 50.0
      // 099: ddiv
      // 09a: invokestatic java/lang/Math.ceil (D)D
      // 09d: d2i
      // 09e: istore 4
      // 0a0: aload 0
      // 0a1: aload 0
      // 0a2: getfield x/oc51fb428ba0.Җ Lx/oca9cc61aada;
      // 0a5: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a8: d2i
      // 0a9: bipush 0
      // 0aa: ldc_w 1189881014
      // 0ad: ldc_w 1189880994
      // 0b0: ixor
      // 0b1: invokevirtual x/oc51fb428ba0.Ӝ (III)I
      // 0b4: istore 5
      // 0b6: aload 0
      // 0b7: iload 4
      // 0b9: bipush 1
      // 0ba: ldc_w 1189881014
      // 0bd: ldc_w 1189880994
      // 0c0: ixor
      // 0c1: invokevirtual x/oc51fb428ba0.Ӝ (III)I
      // 0c4: istore 6
      // 0c6: aload 0
      // 0c7: iload 3
      // 0c8: ifne 0e0
      // 0cb: getfield x/oc51fb428ba0.ʪ J
      // 0ce: lconst_0
      // 0cf: lcmp
      // 0d0: ifne 0df
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 0
      // 0d8: getfield x/oc51fb428ba0.հ J
      // 0db: goto 0e3
      // 0de: athrow
      // 0df: aload 0
      // 0e0: getfield x/oc51fb428ba0.ʪ J
      // 0e3: lstore 7
      // 0e5: aload 0
      // 0e6: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 0e9: lload 7
      // 0eb: iload 5
      // 0ed: iload 6
      // 0ef: aload 0
      // 0f0: getfield x/oc51fb428ba0.ȓ Lx/oca9cc61aada;
      // 0f3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f6: d2i
      // 0f7: aload 2
      // 0f8: getfield net/minecraft/util/Timer.elapsedPartialTicks F
      // 0fb: aload 0
      // 0fc: getfield x/oc51fb428ba0.F F
      // 0ff: invokevirtual x/ocaea619d4ce.н (JIIIFF)V
      // 102: getstatic x/oc9755810e45.Ժ Lx/oc3c7a892f2f;
      // 105: iload 3
      // 106: ifne 113
      // 109: ifnull 12b
      // 10c: goto 110
      // 10f: athrow
      // 110: getstatic x/oc9755810e45.Ժ Lx/oc3c7a892f2f;
      // 113: iload 3
      // 114: ifne 128
      // 117: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 11a: ifeq 12b
      // 11d: goto 121
      // 120: athrow
      // 121: getstatic x/oc9755810e45.Ժ Lx/oc3c7a892f2f;
      // 124: goto 128
      // 127: athrow
      // 128: invokevirtual x/oc3c7a892f2f.յ ()V
      // 12b: return
   }

   private int Ӝ(int var1, int var2, int var3) {
      int var5 = 0;
      int var6 = 0;
      int var7 = 401060071 ^ 989813512;
      int var4 = oc5e549848f3.İ;

      while (true) {
         switch (var7) {
            case 756607983:
               int var10000 = (int)this.П.Ӂ();
               if (var4 == 0) {
                  var5 = var10000;
                  if (var5 == 0) {
                     var7 = 1045768740 ^ 989813512;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var10000 = 204571722 ^ 989813512;
               }

               var7 = var10000;
               if (var4 == 0) {
                  break;
               }
            case 78278956:
               var6 = 0;
               var7 = 1871005257 ^ 989813512;
               if (var4 == 0) {
                  break;
               }
            case 1434066241:
               return Math.max(var2, Math.min(var3, var1 + var6));
            case 919527234:
               var6 = ThreadLocalRandom.current().nextInt(-var5, var5 + 1);
               var7 = 1871005257 ^ 989813512;
               break;
            default:
               throw null;
         }
      }
   }

   private void ր() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: invokevirtual x/oc51fb428ba0.Һ ()V
      // 07: istore 1
      // 08: aload 0
      // 09: iload 1
      // 0a: ifne 27
      // 0d: invokevirtual x/oc51fb428ba0.ê ()V
      // 10: aload 0
      // 11: invokevirtual x/oc51fb428ba0.Ӳ ()Z
      // 14: ifne 2d
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/oc51fb428ba0.Ч Lx/oc63e3533dee;
      // 1f: invokevirtual x/oc63e3533dee.Û ()V
      // 22: aload 0
      // 23: goto 27
      // 26: athrow
      // 27: bipush 1
      // 28: bipush 1
      // 29: bipush 0
      // 2a: invokevirtual x/oc51fb428ba0.Ϛ (ZZZ)V
      // 2d: return
   }

   private void ê() {
      this.ȥ.Ǹ();
      this.ʰ();
   }

   private void Ϛ(boolean param1, boolean param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 004: invokevirtual x/ocaea619d4ce.ȗ ()Z
      // 007: istore 5
      // 009: getstatic x/oc5e549848f3.İ I
      // 00c: aload 0
      // 00d: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 010: istore 6
      // 012: istore 4
      // 014: iload 1
      // 015: iload 4
      // 017: ifne 023
      // 01a: ifeq 033
      // 01d: goto 021
      // 020: athrow
      // 021: iload 6
      // 023: iload 4
      // 025: ifne 030
      // 028: ifeq 033
      // 02b: goto 02f
      // 02e: athrow
      // 02f: bipush 1
      // 030: goto 034
      // 033: bipush 0
      // 034: istore 7
      // 036: iload 4
      // 038: aload 0
      // 039: getfield x/oc51fb428ba0.ɋ J
      // 03c: lstore 8
      // 03e: ifne 062
      // 041: iload 5
      // 043: ifeq 05b
      // 046: goto 04a
      // 049: athrow
      // 04a: aload 0
      // 04b: aload 0
      // 04c: getfield x/oc51fb428ba0.Ƨ Ljava/util/function/LongSupplier;
      // 04f: invokeinterface java/util/function/LongSupplier.getAsLong ()J 1
      // 054: putfield x/oc51fb428ba0.Ԕ J
      // 057: goto 05b
      // 05a: athrow
      // 05b: aload 0
      // 05c: getfield x/oc51fb428ba0.շ Lx/ocaea619d4ce;
      // 05f: invokevirtual x/ocaea619d4ce.ʰ ()V
      // 062: aload 0
      // 063: iload 7
      // 065: iload 4
      // 067: ifne 072
      // 06a: ifne 075
      // 06d: goto 071
      // 070: athrow
      // 071: bipush 1
      // 072: goto 076
      // 075: bipush 0
      // 076: putfield x/oc51fb428ba0.Ƚ Z
      // 079: aload 0
      // 07a: iload 4
      // 07c: ifne 0d9
      // 07f: invokevirtual x/oc51fb428ba0.ͽ ()V
      // 082: aload 0
      // 083: bipush 1
      // 084: putfield x/oc51fb428ba0.պ Z
      // 087: iload 7
      // 089: ifeq 09e
      // 08c: aload 0
      // 08d: getfield x/oc51fb428ba0.Ч Lx/oc63e3533dee;
      // 090: invokevirtual x/oc63e3533dee.Ǹ ()V
      // 093: aload 0
      // 094: getfield x/oc51fb428ba0.ȥ Lx/oc63e3533dee;
      // 097: invokevirtual x/oc63e3533dee.Ǹ ()V
      // 09a: aload 0
      // 09b: invokevirtual x/oc51fb428ba0.ʰ ()V
      // 09e: aload 0
      // 09f: invokevirtual x/oc51fb428ba0.Һ ()V
      // 0a2: aload 0
      // 0a3: getfield x/oc51fb428ba0.ȥ Lx/oc63e3533dee;
      // 0a6: invokevirtual x/oc63e3533dee.Ǯ ()V
      // 0a9: aload 0
      // 0aa: getfield x/oc51fb428ba0.Ч Lx/oc63e3533dee;
      // 0ad: invokevirtual x/oc63e3533dee.Ǯ ()V
      // 0b0: aload 0
      // 0b1: bipush 0
      // 0b2: putfield x/oc51fb428ba0.պ Z
      // 0b5: aload 0
      // 0b6: bipush 0
      // 0b7: putfield x/oc51fb428ba0.ѫ Z
      // 0ba: aload 0
      // 0bb: bipush 0
      // 0bc: putfield x/oc51fb428ba0.Ƚ Z
      // 0bf: aload 0
      // 0c0: aconst_null
      // 0c1: putfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 0c4: aload 0
      // 0c5: aconst_null
      // 0c6: putfield x/oc51fb428ba0.È Lnet/minecraft/entity/player/EntityPlayer;
      // 0c9: aload 0
      // 0ca: aconst_null
      // 0cb: putfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ce: aload 0
      // 0cf: aconst_null
      // 0d0: putfield x/oc51fb428ba0.Ѡ Lnet/minecraft/client/multiplayer/WorldClient;
      // 0d3: aload 0
      // 0d4: aconst_null
      // 0d5: putfield x/oc51fb428ba0.o Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 0d8: aload 0
      // 0d9: lconst_0
      // 0da: putfield x/oc51fb428ba0.ɋ J
      // 0dd: goto 120
      // 0e0: astore 10
      // 0e2: aload 0
      // 0e3: getfield x/oc51fb428ba0.ȥ Lx/oc63e3533dee;
      // 0e6: invokevirtual x/oc63e3533dee.Ǯ ()V
      // 0e9: aload 0
      // 0ea: getfield x/oc51fb428ba0.Ч Lx/oc63e3533dee;
      // 0ed: invokevirtual x/oc63e3533dee.Ǯ ()V
      // 0f0: aload 0
      // 0f1: bipush 0
      // 0f2: putfield x/oc51fb428ba0.պ Z
      // 0f5: aload 0
      // 0f6: bipush 0
      // 0f7: putfield x/oc51fb428ba0.ѫ Z
      // 0fa: aload 0
      // 0fb: bipush 0
      // 0fc: putfield x/oc51fb428ba0.Ƚ Z
      // 0ff: aload 0
      // 100: aconst_null
      // 101: putfield x/oc51fb428ba0.ɂ Lnet/minecraft/entity/player/EntityPlayer;
      // 104: aload 0
      // 105: aconst_null
      // 106: putfield x/oc51fb428ba0.È Lnet/minecraft/entity/player/EntityPlayer;
      // 109: aload 0
      // 10a: aconst_null
      // 10b: putfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10e: aload 0
      // 10f: aconst_null
      // 110: putfield x/oc51fb428ba0.Ѡ Lnet/minecraft/client/multiplayer/WorldClient;
      // 113: aload 0
      // 114: aconst_null
      // 115: putfield x/oc51fb428ba0.o Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 118: aload 0
      // 119: lconst_0
      // 11a: putfield x/oc51fb428ba0.ɋ J
      // 11d: aload 10
      // 11f: athrow
      // 120: iload 3
      // 121: iload 4
      // 123: ifne 141
      // 126: ifeq 13b
      // 129: goto 12d
      // 12c: athrow
      // 12d: aload 0
      // 12e: lconst_0
      // 12f: putfield x/oc51fb428ba0.ċ J
      // 132: iload 4
      // 134: ifeq 165
      // 137: goto 13b
      // 13a: athrow
      // 13b: iload 5
      // 13d: goto 141
      // 140: athrow
      // 141: iload 4
      // 143: ifne 14e
      // 146: ifeq 165
      // 149: goto 14d
      // 14c: athrow
      // 14d: iload 2
      // 14e: ifeq 165
      // 151: aload 0
      // 152: aload 0
      // 153: getfield x/oc51fb428ba0.Ƨ Ljava/util/function/LongSupplier;
      // 156: invokeinterface java/util/function/LongSupplier.getAsLong ()J 1
      // 15b: lload 8
      // 15d: ladd
      // 15e: putfield x/oc51fb428ba0.ċ J
      // 161: goto 165
      // 164: athrow
      // 165: return
   }

   private void ͽ() {
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
      // 06: ifne 28
      // 09: getfield x/oc51fb428ba0.Ӓ Lnet/minecraft/util/Timer;
      // 0c: ifnull 27
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc51fb428ba0.Ӓ Lnet/minecraft/util/Timer;
      // 17: aload 0
      // 18: getfield x/oc51fb428ba0.F F
      // 1b: putfield net/minecraft/util/Timer.timerSpeed F
      // 1e: aload 0
      // 1f: aconst_null
      // 20: putfield x/oc51fb428ba0.Ӓ Lnet/minecraft/util/Timer;
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: fconst_1
      // 29: putfield x/oc51fb428ba0.F F
      // 2c: return
   }

   private boolean Ӳ() {
      int var1 = oc5e549848f3.İ;
      int var2 = -565458380 ^ -1183537638;

      while (true) {
         label120:
         while (true) {
            label118:
            while (true) {
               label116:
               while (true) {
                  switch (var2) {
                     case -1860008890:
                        break label116;
                     case -1793734199:
                        break;
                     case -1734405082:
                        if (oc69da1aa7f5.ő.getNetHandler() != null) {
                           var2 = 1675383277 ^ -1183537638;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var2 = -614964647 ^ -1183537638;
                        if (var1 != 0) {
                           break label116;
                        }
                        continue;
                     case -1002348383:
                        int var10000;
                        label101: {
                           label100: {
                              try {
                                 var10000 = oc69da1aa7f5.ő.thePlayer.isEntityAlive();
                                 if (var1 != 0) {
                                    break label101;
                                 }

                                 if (var10000 == 0) {
                                    break label100;
                                 }
                              } catch (RuntimeException var5) {
                                 throw var5;
                              }

                              var2 = 569094716 ^ -1183537638;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var10000 = -614964647 ^ -1183537638;
                        }

                        var2 = var10000;
                        if (var1 == 0) {
                           continue;
                        }
                     case -626460681:
                        int var6;
                        label90: {
                           label89: {
                              try {
                                 var6 = oc69da1aa7f5.ő.getNetHandler().isDoneLoadingTerrain();
                                 if (var1 != 0) {
                                    break label90;
                                 }

                                 if (var6 == 0) {
                                    break label89;
                                 }
                              } catch (RuntimeException var4) {
                                 throw var4;
                              }

                              var2 = 676733532 ^ -1183537638;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var6 = -614964647 ^ -1183537638;
                        }

                        var2 = var6;
                        if (var1 == 0) {
                           continue;
                        }
                        break;
                     case -645137124:
                        return true;
                     case 1292954777:
                        break label120;
                     case 1647100995:
                        return false;
                     case 1732209710:
                        break label118;
                     default:
                        throw null;
                  }

                  if (oc69da1aa7f5.ő.theWorld != null) {
                     var2 = 2100676283 ^ -1183537638;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var2 = -614964647 ^ -1183537638;
                  if (var1 != 0) {
                     break label118;
                  }
               }

               int var7;
               label75: {
                  label74: {
                     try {
                        var7 = oc69da1aa7f5.ő.getNetHandler().getNetworkManager().isChannelOpen();
                        if (var1 != 0) {
                           break label75;
                        }

                        if (var7 == 0) {
                           break label74;
                        }
                     } catch (RuntimeException var3) {
                        throw var3;
                     }

                     var2 = 1627347718 ^ -1183537638;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var7 = -614964647 ^ -1183537638;
               }

               var2 = var7;
               if (var1 != 0) {
                  break label120;
               }
            }

            if (oc69da1aa7f5.ő != null) {
               var2 = -194753917 ^ -1183537638;
               if (var1 == 0) {
                  continue;
               }
            }

            var2 = -614964647 ^ -1183537638;
            if (var1 != 0) {
               return false;
            }
         }

         if (oc69da1aa7f5.ő.thePlayer != null) {
            var2 = 744583123 ^ -1183537638;
            if (var1 == 0) {
               continue;
            }
         }

         var2 = -614964647 ^ -1183537638;
      }
   }

   private boolean Ѣ() {
      int var1 = 1984919709 ^ -1191471693;

      while (true) {
         switch (var1) {
            case -827003602:
               if (this.ȣ != null) {
                  var1 = -86261998 ^ -1191471693;
               } else {
                  var1 = -32413583 ^ -1191471693;
               }
               break;
            case -715591204:
               if (oc69da1aa7f5.ő.theWorld == this.Ѡ) {
                  var1 = 1128027502 ^ -1191471693;
               } else {
                  var1 = -32413583 ^ -1191471693;
               }
               break;
            case -539839813:
               if (this.o.getNetworkManager().isChannelOpen()) {
                  var1 = -854241418 ^ -1191471693;
               } else {
                  var1 = -32413583 ^ -1191471693;
               }
               break;
            case -438794717:
               if (oc69da1aa7f5.ő.thePlayer == this.ȣ) {
                  var1 = 1839424623 ^ -1191471693;
               } else {
                  var1 = -32413583 ^ -1191471693;
               }
               break;
            case -70795043:
               if (oc69da1aa7f5.ő.getNetHandler() == this.o) {
                  var1 = 1730750216 ^ -1191471693;
               } else {
                  var1 = -32413583 ^ -1191471693;
               }
               break;
            case 1109404321:
               if (oc69da1aa7f5.ő != null) {
                  var1 = 1562579856 ^ -1191471693;
               } else {
                  var1 = -32413583 ^ -1191471693;
               }
               break;
            case 1189805506:
               return false;
            case 1978587845:
               return true;
            default:
               throw null;
         }
      }
   }

   private boolean ʕ() {
      int var1 = oc5e549848f3.İ;
      int var2 = 230982711 ^ 2000353542;

      while (true) {
         label142:
         while (true) {
            label140:
            while (true) {
               switch (var2) {
                  case -1566055133:
                     break label140;
                  case -1002696021:
                     return false;
                  case -463895863:
                     int var10;
                     label81: {
                        label80: {
                           try {
                              var10 = ŀ(oc9755810e45.Տ);
                              if (var1 != 0) {
                                 break label81;
                              }

                              if (var10 != 0) {
                                 break label80;
                              }
                           } catch (RuntimeException var3) {
                              throw var3;
                           }

                           var2 = -711123931 ^ 2000353542;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var10 = 1635192605 ^ 2000353542;
                     }

                     var2 = var10;
                     continue;
                  case -323237764:
                     break label142;
                  case 87023313:
                     break;
                  case 374208027:
                     return true;
                  case 1034522009:
                     int var10000;
                     label125: {
                        label124: {
                           try {
                              var10000 = ŀ(oc9755810e45.ů);
                              if (var1 != 0) {
                                 break label125;
                              }

                              if (var10000 != 0) {
                                 break label124;
                              }
                           } catch (RuntimeException var7) {
                              throw var7;
                           }

                           var2 = -1822196785 ^ 2000353542;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var10000 = 1635192605 ^ 2000353542;
                     }

                     var2 = var10000;
                     if (var1 == 0) {
                        continue;
                     }
                  case 2063498545:
                     int var8;
                     label114: {
                        label113: {
                           try {
                              var8 = this.Ӳ();
                              if (var1 != 0) {
                                 break label114;
                              }

                              if (var8 == 0) {
                                 break label113;
                              }
                           } catch (RuntimeException var6) {
                              throw var6;
                           }

                           var2 = -1686032006 ^ 2000353542;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var8 = 1635192605 ^ 2000353542;
                     }

                     var2 = var8;
                     if (var1 == 0) {
                        continue;
                     }
                     break;
                  case 1456834909:
                     if (oc69da1aa7f5.ő.currentScreen == null) {
                        var2 = 1251177631 ^ 2000353542;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var2 = 1635192605 ^ 2000353542;
                     if (var1 != 0) {
                        break label142;
                     }
                     continue;
                  default:
                     throw null;
               }

               int var9;
               label103: {
                  label102: {
                     try {
                        var9 = ŀ(oc9755810e45.G);
                        if (var1 != 0) {
                           break label103;
                        }

                        if (var9 == 0) {
                           break label102;
                        }
                     } catch (RuntimeException var5) {
                        throw var5;
                     }

                     var2 = 1635192605 ^ 2000353542;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var9 = -1291392083 ^ 2000353542;
               }

               var2 = var9;
               if (var1 != 0) {
                  break;
               }
            }

            int var11;
            label90: {
               label89: {
                  try {
                     var11 = ŀ(oc9755810e45.ſ);
                     if (var1 != 0) {
                        break label90;
                     }

                     if (var11 != 0) {
                        break label89;
                     }
                  } catch (RuntimeException var4) {
                     throw var4;
                  }

                  var2 = 1913989079 ^ 2000353542;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var11 = 1635192605 ^ 2000353542;
            }

            var2 = var11;
            if (var1 != 0) {
               return true;
            }
         }

         if (oc69da1aa7f5.ő.thePlayer.ridingEntity == null) {
            var2 = 569339995 ^ 2000353542;
            if (var1 == 0) {
               continue;
            }
         }

         var2 = 1635192605 ^ 2000353542;
         if (var1 != 0) {
            return false;
         }
      }
   }

   private static boolean ŀ(oc69da1aa7f5 var0) {
      int var1 = oc5e549848f3.İ;
      int var2 = -1217525774 ^ 589252021;

      while (true) {
         switch (var2) {
            case -1804516793:
               if (var0 != null) {
                  var2 = -1269728991 ^ 589252021;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 195804568 ^ 589252021;
               break;
            case -1756480364:
               int var10000;
               label34: {
                  label33: {
                     try {
                        var10000 = var0.z$3rzb3dil7uydr();
                        if (var1 != 0) {
                           break label34;
                        }

                        if (var10000 == 0) {
                           break label33;
                        }
                     } catch (RuntimeException var3) {
                        throw var3;
                     }

                     var2 = -973989438 ^ 589252021;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 195804568 ^ 589252021;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 682948653:
               return false;
            case -420651913:
               return true;
            default:
               throw null;
         }
      }
   }

   private EntityPlayer ӑ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0e: ifnull 4c
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 1
      // 1d: ifne 37
      // 20: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 23: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 26: instanceof net/minecraft/entity/player/EntityPlayer
      // 29: ifeq 4c
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: goto 37
      // 36: athrow
      // 37: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 3a: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 3d: checkcast net/minecraft/entity/player/EntityPlayer
      // 40: astore 2
      // 41: aload 0
      // 42: aload 2
      // 43: invokevirtual x/oc51fb428ba0.ɨ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 46: ifeq 4c
      // 49: aload 2
      // 4a: areturn
      // 4b: athrow
      // 4c: aconst_null
      // 4d: astore 2
      // 4e: ldc2_w 1.7976931348623157E308
      // 51: dstore 3
      // 52: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 55: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 58: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 5b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 60: astore 5
      // 62: aload 5
      // 64: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 69: ifeq b6
      // 6c: aload 5
      // 6e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 73: checkcast net/minecraft/entity/player/EntityPlayer
      // 76: iload 1
      // 77: ifne b7
      // 7a: astore 6
      // 7c: aload 0
      // 7d: iload 1
      // 7e: ifne 96
      // 81: aload 6
      // 83: invokevirtual x/oc51fb428ba0.ɨ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 86: ifne 95
      // 89: goto 8d
      // 8c: athrow
      // 8d: iload 1
      // 8e: ifeq 62
      // 91: goto 95
      // 94: athrow
      // 95: aload 0
      // 96: aload 6
      // 98: invokevirtual x/oc51fb428ba0.Ϫ (Lnet/minecraft/entity/Entity;)D
      // 9b: dstore 7
      // 9d: iload 1
      // 9e: ifne af
      // a1: dload 7
      // a3: dload 3
      // a4: dcmpg
      // a5: ifge b2
      // a8: goto ac
      // ab: athrow
      // ac: dload 7
      // ae: dstore 3
      // af: aload 6
      // b1: astore 2
      // b2: iload 1
      // b3: ifeq 62
      // b6: aload 2
      // b7: areturn
   }

   private boolean ɨ(EntityPlayer var1) {
      int var3 = 0;
      double var4 = 0.0;
      int var2 = oc5e549848f3.İ;
      int var6 = 1201028941 ^ 1808388187;

      while (true) {
         label252:
         while (true) {
            label250:
            while (true) {
               label248:
               while (true) {
                  label246:
                  while (true) {
                     label244:
                     do {
                        label240:
                        while (true) {
                           switch (var6) {
                              case -2041703794:
                                 break label248;
                              case -2013578030:
                                 break label244;
                              case -867330504:
                                 int var21;
                                 label201: {
                                    label200: {
                                       try {
                                          var21 = var1.hurtTime;
                                          if (var2 != 0) {
                                             break label201;
                                          }

                                          if (var1.hurtTime > var3) {
                                             break label200;
                                          }
                                       } catch (RuntimeException var14) {
                                          throw var14;
                                       }

                                       var6 = -309869867 ^ 1808388187;
                                       if (var2 == 0) {
                                          continue;
                                       }
                                    }

                                    var21 = 2131346465 ^ 1808388187;
                                 }

                                 var6 = var21;
                                 if (var2 == 0) {
                                    continue;
                                 }
                                 break label240;
                              case -627776655:
                                 break label246;
                              case 46072829:
                                 return false;
                              case 71435758:
                                 int var19;
                                 label176: {
                                    label175: {
                                       try {
                                          var19 = this.Ŭ();
                                          if (var2 != 0) {
                                             break label176;
                                          }

                                          if (var19 == 0) {
                                             break label175;
                                          }
                                       } catch (RuntimeException var12) {
                                          throw var12;
                                       }

                                       var6 = -1319292118 ^ 1808388187;
                                       if (var2 == 0) {
                                          continue;
                                       }
                                    }

                                    var19 = 1181552199 ^ 1808388187;
                                 }

                                 var6 = var19;
                                 if (var2 != 0) {
                                    break label248;
                                 }
                                 continue;
                              case 344025631:
                                 break label250;
                              case 348132474:
                                 return false;
                              case 364626180:
                                 break;
                              case 542677815:
                                 return false;
                              case 744484630:
                                 int var10000;
                                 label221: {
                                    label220: {
                                       try {
                                          var10000 = oc5e08d6b90f.Ƣ(var1);
                                          if (var2 != 0) {
                                             break label221;
                                          }

                                          if (var10000 == 0) {
                                             break label220;
                                          }
                                       } catch (RuntimeException var16) {
                                          throw var16;
                                       }

                                       var6 = 2121404767 ^ 1808388187;
                                       if (var2 == 0) {
                                          continue;
                                       }
                                    }

                                    var10000 = 1267813228 ^ 1808388187;
                                 }

                                 var6 = var10000;
                                 if (var2 == 0) {
                                    continue;
                                 }
                              case -1345774427:
                                 int var17;
                                 label210: {
                                    label209: {
                                       try {
                                          double var25;
                                          var17 = (var25 = var4 - 6.0) == 0.0 ? 0 : (var25 < 0.0 ? -1 : 1);
                                          if (var2 != 0) {
                                             break label210;
                                          }

                                          if (var17 > 0) {
                                             break label209;
                                          }
                                       } catch (RuntimeException var15) {
                                          throw var15;
                                       }

                                       var6 = 666077037 ^ 1808388187;
                                       if (var2 == 0) {
                                          continue;
                                       }
                                    }

                                    var17 = 1769395110 ^ 1808388187;
                                 }

                                 var6 = var17;
                                 if (var2 == 0) {
                                    continue;
                                 }
                                 break;
                              case 765779484:
                                 break label240;
                              case 1283086134:
                                 return true;
                              case 1585983972:
                                 break label252;
                              case 2070190419:
                                 var4 = this.Ϫ(var1);

                                 label125: {
                                    label124: {
                                       try {
                                          if (var2 != 0) {
                                             break label125;
                                          }

                                          if (!(var4 >= this.Ĳ.Ӂ())) {
                                             break label124;
                                          }
                                       } catch (RuntimeException var7) {
                                          throw var7;
                                       }

                                       var6 = -1006580482 ^ 1808388187;
                                       if (var2 == 0) {
                                          continue;
                                       }
                                    }

                                    var6 = 1769395110 ^ 1808388187;
                                 }

                                 if (var2 != 0) {
                                    return false;
                                 }
                                 continue;
                              default:
                                 throw null;
                           }

                           int var18;
                           label189: {
                              label188: {
                                 try {
                                    var18 = var1.isInvisible();
                                    if (var2 != 0) {
                                       break label189;
                                    }

                                    if (var18 != 0) {
                                       break label188;
                                    }
                                 } catch (RuntimeException var13) {
                                    throw var13;
                                 }

                                 var6 = 893510079 ^ 1808388187;
                                 if (var2 == 0) {
                                    continue;
                                 }
                              }

                              var18 = 1267813228 ^ 1808388187;
                           }

                           var6 = var18;
                           if (var2 != 0) {
                              break label246;
                           }
                        }

                        var3 = 1808388191 ^ 1808388187;
                        var6 = -1484503453 ^ 1808388187;
                     } while (var2 == 0);

                     int var22;
                     label167: {
                        label166: {
                           try {
                              var22 = oc69da1aa7f5.ő.thePlayer.canEntityBeSeen(var1);
                              if (var2 != 0) {
                                 break label167;
                              }

                              if (var22 != 0) {
                                 break label166;
                              }
                           } catch (RuntimeException var11) {
                              throw var11;
                           }

                           var6 = 1267813228 ^ 1808388187;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var22 = 1871435189 ^ 1808388187;
                     }

                     var6 = var22;
                     if (var2 != 0) {
                        break label250;
                     }
                  }

                  var3 = (int)this.Ū.Ӂ();
                  var6 = -1484503453 ^ 1808388187;
                  if (var2 != 0) {
                     break label252;
                  }
               }

               int var24;
               label153: {
                  label152: {
                     try {
                        var24 = this.Ŭ();
                        if (var2 != 0) {
                           break label153;
                        }

                        if (var24 != 0) {
                           break label152;
                        }
                     } catch (RuntimeException var10) {
                        throw var10;
                     }

                     var6 = 2135472708 ^ 1808388187;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var24 = 279791880 ^ 1808388187;
               }

               var6 = var24;
               if (var2 != 0) {
                  return true;
               }
            }

            int var23;
            label144: {
               label143: {
                  try {
                     var23 = var1.hurtResistantTime;
                     if (var2 != 0) {
                        break label144;
                     }

                     if (var1.hurtResistantTime <= (1808388181 ^ 1808388187)) {
                        break label143;
                     }
                  } catch (RuntimeException var9) {
                     throw var9;
                  }

                  var6 = 2131346465 ^ 1808388187;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var23 = 279791880 ^ 1808388187;
            }

            var6 = var23;
            if (var2 != 0) {
               return false;
            }
         }

         int var20;
         label135: {
            label134: {
               try {
                  float var26;
                  var20 = (var26 = var1.getHealth() - 0.0F) == 0.0F ? 0 : (var26 < 0.0F ? -1 : 1);
                  if (var2 != 0) {
                     break label135;
                  }

                  if (var20 <= 0) {
                     break label134;
                  }
               } catch (RuntimeException var8) {
                  throw var8;
               }

               var6 = -332206967 ^ 1808388187;
               if (var2 == 0) {
                  continue;
               }
            }

            var20 = 1267813228 ^ 1808388187;
         }

         var6 = var20;
         if (var2 != 0) {
            return false;
         }
      }
   }

   private boolean á(EntityPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 0
      // 005: invokevirtual x/oc51fb428ba0.Ӳ ()Z
      // 008: iload 2
      // 009: ifne 059
      // 00c: ifeq 054
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: ifnull 054
      // 017: goto 01b
      // 01a: athrow
      // 01b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01e: iload 2
      // 01f: ifne 037
      // 022: goto 026
      // 025: athrow
      // 026: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 029: ifnonnull 054
      // 02c: goto 030
      // 02f: athrow
      // 030: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 033: goto 037
      // 036: athrow
      // 037: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03a: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 03d: ifnull 054
      // 040: aload 0
      // 041: iload 2
      // 042: ifne 05b
      // 045: goto 049
      // 048: athrow
      // 049: aload 1
      // 04a: invokevirtual x/oc51fb428ba0.ɨ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 04d: ifne 05a
      // 050: goto 054
      // 053: athrow
      // 054: bipush 0
      // 055: goto 059
      // 058: athrow
      // 059: ireturn
      // 05a: aload 0
      // 05b: getfield x/oc51fb428ba0.ŏ Lx/occ2f8dff8d8;
      // 05e: iload 2
      // 05f: ifne 09b
      // 062: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 065: ifeq 097
      // 068: goto 06c
      // 06b: athrow
      // 06c: invokestatic org/lwjgl/input/Mouse.isCreated ()Z
      // 06f: iload 2
      // 070: ifne 096
      // 073: goto 077
      // 076: athrow
      // 077: ifeq 091
      // 07a: goto 07e
      // 07d: athrow
      // 07e: bipush 0
      // 07f: iload 2
      // 080: ifne 0a6
      // 083: goto 087
      // 086: athrow
      // 087: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 08a: ifne 097
      // 08d: goto 091
      // 090: athrow
      // 091: bipush 0
      // 092: goto 096
      // 095: athrow
      // 096: ireturn
      // 097: aload 0
      // 098: getfield x/oc51fb428ba0.ϩ Lx/occ2f8dff8d8;
      // 09b: iload 2
      // 09c: ifne 0ca
      // 09f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: ifeq 0be
      // 0a9: invokestatic x/oc7ab2161b9f.Ȓ ()Z
      // 0ac: iload 2
      // 0ad: ifne 0cd
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: ifne 0be
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: bipush 0
      // 0bc: ireturn
      // 0bd: athrow
      // 0be: aload 0
      // 0bf: iload 2
      // 0c0: ifne 10e
      // 0c3: getfield x/oc51fb428ba0.Ȧ Lx/occ2f8dff8d8;
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0cd: ifeq 10d
      // 0d0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0d9: iload 2
      // 0da: ifne 10c
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: ifne 10b
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 0eb: iload 2
      // 0ec: ifne 0fd
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: ifnull 10d
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 0fd: invokevirtual x/oce3cc81daa8.Ӿ ()Z
      // 100: iload 2
      // 101: ifne 111
      // 104: ifeq 10d
      // 107: goto 10b
      // 10a: athrow
      // 10b: bipush 0
      // 10c: ireturn
      // 10d: aload 0
      // 10e: invokevirtual x/oc51fb428ba0.Ŭ ()Z
      // 111: iload 2
      // 112: ifne 147
      // 115: ifeq 132
      // 118: goto 11c
      // 11b: athrow
      // 11c: aload 0
      // 11d: getfield x/oc51fb428ba0.Ǭ Lx/occ2f8dff8d8;
      // 120: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 123: iload 2
      // 124: ifne 147
      // 127: goto 12b
      // 12a: athrow
      // 12b: ifeq 14d
      // 12e: goto 132
      // 131: athrow
      // 132: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 135: iload 2
      // 136: ifne 150
      // 139: goto 13d
      // 13c: athrow
      // 13d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 140: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 143: goto 147
      // 146: athrow
      // 147: ifne 14d
      // 14a: bipush 0
      // 14b: ireturn
      // 14c: athrow
      // 14d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 150: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 153: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 156: getfield net/minecraft/util/MovementInput.moveForward F
      // 159: fstore 3
      // 15a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 160: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 163: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 166: fstore 4
      // 168: fload 3
      // 169: fconst_0
      // 16a: fcmpg
      // 16b: iload 2
      // 16c: ifne 1a0
      // 16f: iflt 19b
      // 172: goto 176
      // 175: athrow
      // 176: fload 3
      // 177: iload 2
      // 178: ifne 1aa
      // 17b: goto 17f
      // 17e: athrow
      // 17f: fconst_0
      // 180: fcmpl
      // 181: ifne 1a1
      // 184: goto 188
      // 187: athrow
      // 188: fload 4
      // 18a: iload 2
      // 18b: ifne 1aa
      // 18e: goto 192
      // 191: athrow
      // 192: fconst_0
      // 193: fcmpl
      // 194: ifne 1a1
      // 197: goto 19b
      // 19a: athrow
      // 19b: bipush 0
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: ireturn
      // 1a1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a7: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1aa: f2d
      // 1ab: invokestatic java/lang/Math.toRadians (D)D
      // 1ae: dstore 5
      // 1b0: fload 4
      // 1b2: f2d
      // 1b3: dload 5
      // 1b5: invokestatic java/lang/Math.cos (D)D
      // 1b8: dmul
      // 1b9: fload 3
      // 1ba: f2d
      // 1bb: dload 5
      // 1bd: invokestatic java/lang/Math.sin (D)D
      // 1c0: dmul
      // 1c1: dsub
      // 1c2: dstore 7
      // 1c4: fload 3
      // 1c5: f2d
      // 1c6: dload 5
      // 1c8: invokestatic java/lang/Math.cos (D)D
      // 1cb: dmul
      // 1cc: fload 4
      // 1ce: f2d
      // 1cf: dload 5
      // 1d1: invokestatic java/lang/Math.sin (D)D
      // 1d4: dmul
      // 1d5: dadd
      // 1d6: dstore 9
      // 1d8: dload 7
      // 1da: aload 1
      // 1db: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 1de: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e4: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 1e7: dsub
      // 1e8: dmul
      // 1e9: dload 9
      // 1eb: aload 1
      // 1ec: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 1ef: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f5: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 1f8: dsub
      // 1f9: dmul
      // 1fa: dadd
      // 1fb: dconst_0
      // 1fc: dcmpl
      // 1fd: iload 2
      // 1fe: ifne 209
      // 201: ifle 20c
      // 204: goto 208
      // 207: athrow
      // 208: bipush 1
      // 209: goto 20d
      // 20c: bipush 0
      // 20d: ireturn
   }

   private double Ϫ(Entity var1) {
      Vec3 var2 = oc69da1aa7f5.ő.thePlayer.getPositionEyes(1.0F);
      AxisAlignedBB var3 = var1.getEntityBoundingBox();

      try {
         if (var3 == null) {
            return Double.MAX_VALUE;
         }
      } catch (RuntimeException var10) {
         throw var10;
      }

      double var4 = var2.xCoord - Math.max(var3.minX, Math.min(var3.maxX, var2.xCoord));
      double var6 = var2.yCoord - Math.max(var3.minY, Math.min(var3.maxY, var2.yCoord));
      double var8 = var2.zCoord - Math.max(var3.minZ, Math.min(var3.maxZ, var2.zCoord));
      return Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
   }

   private void ʰ() {
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
      // 06: ifne 1d
      // 09: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 19: invokestatic x/oc51fb428ba0.ɪ (Lnet/minecraft/entity/Entity;)V
      // 1c: aload 0
      // 1d: getfield x/oc51fb428ba0.Ѡ Lnet/minecraft/client/multiplayer/WorldClient;
      // 20: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 23: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 28: astore 2
      // 29: aload 2
      // 2a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2f: ifeq 5e
      // 32: aload 2
      // 33: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 38: checkcast net/minecraft/entity/player/EntityPlayer
      // 3b: astore 3
      // 3c: iload 1
      // 3d: ifne 56
      // 40: aload 3
      // 41: instanceof net/minecraft/client/entity/EntityOtherPlayerMP
      // 44: ifeq 5a
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 3
      // 4c: checkcast net/minecraft/client/entity/EntityOtherPlayerMP
      // 4f: invokevirtual net/minecraft/client/entity/EntityOtherPlayerMP.snapToServerPosition ()V
      // 52: goto 56
      // 55: athrow
      // 56: aload 3
      // 57: invokestatic x/oc51fb428ba0.ɪ (Lnet/minecraft/entity/Entity;)V
      // 5a: iload 1
      // 5b: ifeq 29
      // 5e: return
   }

   private static void ɪ(Entity var0) {
      var0.lastTickPosX = var0.prevPosX = var0.posX;
      var0.lastTickPosY = var0.prevPosY = var0.posY;
      var0.lastTickPosZ = var0.prevPosZ = var0.posZ;
      var0.prevRotationYaw = var0.rotationYaw;
      var0.prevRotationPitch = var0.rotationPitch;
   }

   private void Ė() {
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
      // 06: ifne 18
      // 09: getfield x/oc51fb428ba0.Ъ Z
      // 0c: ifne 60
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2e
      // 1c: getfield x/oc51fb428ba0.ɥ Lx/occ2f8dff8d8;
      // 1f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22: ifeq 60
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 31: iload 1
      // 32: ifne 3f
      // 35: ifeq 60
      // 38: goto 3c
      // 3b: athrow
      // 3c: invokestatic x/oc7ab2161b9f.ө ()Z
      // 3f: iload 1
      // 40: ifne 5d
      // 43: ifeq 60
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: iload 1
      // 4c: ifne 75
      // 4f: goto 53
      // 52: athrow
      // 53: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 56: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 59: goto 5d
      // 5c: athrow
      // 5d: ifeq 61
      // 60: return
      // 61: aload 0
      // 62: aload 0
      // 63: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 66: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 69: putfield x/oc51fb428ba0.Ѥ Lnet/minecraft/item/ItemStack;
      // 6c: iload 1
      // 6d: ifne a4
      // 70: aload 0
      // 71: goto 75
      // 74: athrow
      // 75: getfield x/oc51fb428ba0.Ѥ Lnet/minecraft/item/ItemStack;
      // 78: ifnull a9
      // 7b: new net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 7e: dup
      // 7f: aload 0
      // 80: getfield x/oc51fb428ba0.Ѥ Lnet/minecraft/item/ItemStack;
      // 83: invokespecial net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.<init> (Lnet/minecraft/item/ItemStack;)V
      // 86: invokestatic x/oc51fb428ba0.ˣ (Lnet/minecraft/network/Packet;)V
      // 89: aload 0
      // 8a: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8d: aload 0
      // 8e: getfield x/oc51fb428ba0.Ѥ Lnet/minecraft/item/ItemStack;
      // 91: aload 0
      // 92: getfield x/oc51fb428ba0.Ѥ Lnet/minecraft/item/ItemStack;
      // 95: invokevirtual net/minecraft/item/ItemStack.getMaxItemUseDuration ()I
      // 98: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setItemInUse (Lnet/minecraft/item/ItemStack;I)V
      // 9b: bipush 1
      // 9c: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 9f: pop
      // a0: goto a4
      // a3: athrow
      // a4: aload 0
      // a5: bipush 1
      // a6: putfield x/oc51fb428ba0.Ъ Z
      // a9: return
   }

   private void Һ() {
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
      // 06: ifne 16
      // 09: getfield x/oc51fb428ba0.Ъ Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 1
      // 17: ifne 29
      // 1a: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d: ifnull 7a
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: goto 29
      // 28: athrow
      // 29: iload 1
      // 2a: ifne 4a
      // 2d: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 30: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getItemInUse ()Lnet/minecraft/item/ItemStack;
      // 33: aload 0
      // 34: getfield x/oc51fb428ba0.Ѥ Lnet/minecraft/item/ItemStack;
      // 37: if_acmpne 7a
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 42: invokevirtual net/minecraft/client/entity/EntityPlayerSP.clearItemInUse ()V
      // 45: aload 0
      // 46: goto 4a
      // 49: athrow
      // 4a: iload 1
      // 4b: ifne 5d
      // 4e: invokevirtual x/oc51fb428ba0.Ѣ ()Z
      // 51: ifeq 7a
      // 54: goto 58
      // 57: athrow
      // 58: aload 0
      // 59: goto 5d
      // 5c: athrow
      // 5d: getfield x/oc51fb428ba0.Ƚ Z
      // 60: ifne 7a
      // 63: new net/minecraft/network/play/client/C07PacketPlayerDigging
      // 66: dup
      // 67: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.RELEASE_USE_ITEM Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 6a: getstatic net/minecraft/util/BlockPos.ORIGIN Lnet/minecraft/util/BlockPos;
      // 6d: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 70: invokespecial net/minecraft/network/play/client/C07PacketPlayerDigging.<init> (Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 73: invokestatic x/oc51fb428ba0.ˣ (Lnet/minecraft/network/Packet;)V
      // 76: goto 7a
      // 79: athrow
      // 7a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7d: iload 1
      // 7e: ifne 8b
      // 81: ifnull 9e
      // 84: goto 88
      // 87: athrow
      // 88: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 8b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8e: aload 0
      // 8f: getfield x/oc51fb428ba0.ȣ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 92: if_acmpne 9e
      // 95: bipush 0
      // 96: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 99: pop
      // 9a: goto 9e
      // 9d: athrow
      // 9e: aload 0
      // 9f: aconst_null
      // a0: putfield x/oc51fb428ba0.Ѥ Lnet/minecraft/item/ItemStack;
      // a3: aload 0
      // a4: bipush 0
      // a5: putfield x/oc51fb428ba0.Ъ Z
      // a8: return
   }

   private static void ˣ(Packet<?> param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 33
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: iload 1
      // 16: ifne 2a
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: ifnull 33
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: goto 2a
      // 29: athrow
      // 2a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2d: getfield net/minecraft/client/entity/EntityPlayerSP.sendQueue Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 30: ifnonnull 35
      // 33: return
      // 34: athrow
      // 35: getstatic x/oc51fb428ba0.ώ Ljava/util/Set;
      // 38: aload 0
      // 39: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 3e: pop
      // 3f: aload 0
      // 40: invokestatic x/ocd6ae010123.ĕ (Lnet/minecraft/network/Packet;)V
      // 43: goto 53
      // 46: astore 2
      // 47: getstatic x/oc51fb428ba0.ώ Ljava/util/Set;
      // 4a: aload 0
      // 4b: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 50: pop
      // 51: aload 2
      // 52: athrow
      // 53: return
   }

   private boolean Ŭ() {
      int var1 = oc5e549848f3.İ;
      int var2 = -255211608 ^ -1891020178;

      while (true) {
         switch (var2) {
            case -1204720036:
               return false;
            case 2139133382:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.Ò.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 1) {
                           break label27;
                        }
                     } catch (RuntimeException var3) {
                        throw var3;
                     }

                     var2 = 2088200122 ^ -1891020178;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 930626610 ^ -1891020178;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -214026796:
               return true;
            default:
               throw null;
         }
      }
   }

   private static oc51fb428ba0 ӓ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc9755810e45.ώ Lx/oc51fb428ba0;
      // 03: astore 0
      // 04: aload 0
      // 05: ifnull 18
      // 08: aload 0
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 18
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 19
      // 17: athrow
      // 18: aconst_null
      // 19: areturn
   }

   static {
      String[] var10000 = new String[442281573 ^ 442281575];
      var10000[0] = "Regular";
      var10000[1] = "Custom";
      Ƅ = var10000;
   }
}
