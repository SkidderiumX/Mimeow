package x;

import java.util.List;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.Vec3;

public class oc3c7a892f2f extends oc69da1aa7f5 {
   private static final double ֆ = 9.0;
   private static final String[] բ;
   private static final String[] Ȥ;
   public final oca9cc61aada Ǚ = new oca9cc61aada("Delay", "ms", 150.0, 0.0, 1000.0, 1.0);
   public final oca9cc61aada Ю = new oca9cc61aada("Range", 10.0, 3.0, 100.0, 0.1);
   public final oca9cc61aada ђ;
   private final occc831eff22 ȓ;
   public final occ2f8dff8d8 S;
   public final occ2f8dff8d8 Ъ;
   public final occ2f8dff8d8 Ğ;
   public final occ2f8dff8d8 Ĕ;
   public final oca9cc61aada Ŵ;
   private boolean Ѝ;
   private Vec3 ղ;
   private Vec3 ƃ;
   private boolean ʝ;
   private int ԝ;
   private int Ӛ;
   private int ſ;
   private boolean ώ;
   private boolean Ď;
   private double ž;
   private EntityPlayer ȗ;
   private oc3d1d10e2c1 Ü;
   private WorldClient Ƅ;
   private int Ր;
   private int ͻ;
   private long Ά;
   private int ʴ;
   private boolean Ǻ;
   private long Ё;
   private long ж;
   public static int Ӣ;

   public oc3c7a892f2f() {
      super("LagRange", oce4cea752dd.ȁ);
      this.ђ = new oca9cc61aada("Mode", 0, բ);
      this.ȓ = new occc831eff22("Condition");
      this.S = new occ2f8dff8d8(this.ȓ, "Weapons only", true);
      this.Ъ = new occ2f8dff8d8(this.ȓ, "Allow tools", false);
      this.Ğ = new occ2f8dff8d8(this.ȓ, "Bot check", true);
      this.Ĕ = new occ2f8dff8d8(this.ȓ, "Ignore teams", true, new String[]{"Teams"});
      this.Ŵ = new oca9cc61aada("Show position", 0, Ȥ);
      this.ſ = -1;
      this.ž = -1.0;
      this.Ր = -1;
      this.ͻ = -1;
      this.ą("Uses lag to keep you out of your opponent's range");
      this.ʌ(this.Ǚ);
      this.ʌ(this.Ю);
      this.ʌ(this.ђ);
      this.ʌ(this.ȓ);
      this.ʌ(this.S);
      this.ʌ(this.Ъ);
      this.ʌ(this.Ğ);
      this.ʌ(this.Ĕ);
      this.ʌ(this.Ŵ);
      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.Ǚ.ȉ(true, this);
      this.Ю.ȉ(true, this);
      this.ђ.ȉ(true, this);
      this.ȓ.ȉ(true, this);
      this.S.ȉ(true, this);
      this.Ъ.ȉ(this.S.ǭ(), this);
      this.Ğ.ȉ(true, this);
      this.Ĕ.ȉ(true, this);
      this.Ŵ.ȉ(true, this);
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      this.z$2u87utkr1isxg();
   }

   @Override
   public void onEnable() {
      this.Ǻ = false;
      this.Ѻ(false);
      this.Ր = (int)this.ђ.Ӂ();
      this.Ƅ = oc69da1aa7f5.ő.theWorld;
   }

   @Override
   public void onDisable() {
      this.Ǻ = false;
      this.Ѻ(true);
   }

   @Override
   public String getInfo() {
      return String.format("%dms", (int)this.Ǚ.Ӂ());
   }

   public boolean Д() {
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
      // 06: ifne 17
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifne 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: athrow
      // 16: aload 0
      // 17: iload 1
      // 18: ifne 66
      // 1b: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 1e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 21: d2i
      // 22: ifne 65
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oc3c7a892f2f.Ѝ Z
      // 2d: iload 1
      // 2e: ifne 60
      // 31: goto 35
      // 34: athrow
      // 35: ifne 5f
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 3f: iload 1
      // 40: ifne 51
      // 43: goto 47
      // 46: athrow
      // 47: ifnull 63
      // 4a: goto 4e
      // 4d: athrow
      // 4e: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 51: invokevirtual x/oc020457c099.Ԗ ()I
      // 54: iload 1
      // 55: ifne 60
      // 58: ifle 63
      // 5b: goto 5f
      // 5e: athrow
      // 5f: bipush 1
      // 60: goto 64
      // 63: bipush 0
      // 64: ireturn
      // 65: aload 0
      // 66: getfield x/oc3c7a892f2f.ʝ Z
      // 69: ireturn
   }

   public boolean ȼ() {
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
      // 06: ifne 17
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifne 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual x/oc3c7a892f2f.Д ()Z
      // 1a: iload 1
      // 1b: ifne 26
      // 1e: ifeq 27
      // 21: goto 25
      // 24: athrow
      // 25: bipush 1
      // 26: ireturn
      // 27: invokestatic java/lang/System.currentTimeMillis ()J
      // 2a: lstore 2
      // 2b: lload 2
      // 2c: aload 0
      // 2d: getfield x/oc3c7a892f2f.ж J
      // 30: lsub
      // 31: ldc2_w 1485552096702865460
      // 34: ldc2_w 1485552096702866196
      // 37: lxor
      // 38: lcmp
      // 39: iload 1
      // 3a: ifne 62
      // 3d: ifle 61
      // 40: goto 44
      // 43: athrow
      // 44: lload 2
      // 45: aload 0
      // 46: getfield x/oc3c7a892f2f.Ё J
      // 49: lsub
      // 4a: ldc2_w 1485552096702865460
      // 4d: ldc2_w 1485552096702866196
      // 50: lxor
      // 51: lcmp
      // 52: iload 1
      // 53: ifne 62
      // 56: goto 5a
      // 59: athrow
      // 5a: ifgt 65
      // 5d: goto 61
      // 60: athrow
      // 61: bipush 1
      // 62: goto 66
      // 65: bipush 0
      // 66: ireturn
   }

   public EntityPlayer պ() {
      return this.ȗ;
   }

   public EntityPlayer B() {
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
      // 09: getfield x/oc3c7a892f2f.ʝ Z
      // 0c: ifeq 3c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 1f: ifnull 3c
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 1
      // 2c: ifne 40
      // 2f: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 32: getfield net/minecraft/entity/player/EntityPlayer.isDead Z
      // 35: ifeq 3f
      // 38: goto 3c
      // 3b: athrow
      // 3c: aconst_null
      // 3d: areturn
      // 3e: athrow
      // 3f: aload 0
      // 40: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 43: areturn
   }

   public Vec3 у() {
      return this.ƃ;
   }

   public Vec3 Ї() {
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
      // 06: ifne 17
      // 09: getfield x/oc3c7a892f2f.ʝ Z
      // 0c: ifne 16
      // 0f: goto 13
      // 12: athrow
      // 13: aconst_null
      // 14: areturn
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual x/oc3c7a892f2f.Ȓ ()Lnet/minecraft/util/Vec3;
      // 1a: areturn
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void Ķ(oc9adb807c19 param1) {
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
      // 06: ifne 1a
      // 09: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: ifeq 19
      // 13: goto 17
      // 16: athrow
      // 17: return
      // 18: athrow
      // 19: aload 0
      // 1a: iload 2
      // 1b: ifne 2b
      // 1e: invokevirtual x/oc3c7a892f2f.ΰ ()Z
      // 21: ifeq 2a
      // 24: goto 28
      // 27: athrow
      // 28: return
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 2
      // 2c: ifne 63
      // 2f: bipush 0
      // 30: invokevirtual x/oc3c7a892f2f.հ (I)V
      // 33: aload 1
      // 34: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 37: getstatic x/oc110d7f376c.START Lx/oc110d7f376c;
      // 3a: if_acmpne 5e
      // 3d: goto 41
      // 40: athrow
      // 41: aload 0
      // 42: iload 2
      // 43: ifne 57
      // 46: goto 4a
      // 49: athrow
      // 4a: invokevirtual x/oc3c7a892f2f.Ŀ ()Z
      // 4d: ifeq 56
      // 50: goto 54
      // 53: athrow
      // 54: return
      // 55: athrow
      // 56: aload 0
      // 57: invokevirtual x/oc3c7a892f2f.Է ()V
      // 5a: iload 2
      // 5b: ifeq 66
      // 5e: aload 0
      // 5f: goto 63
      // 62: athrow
      // 63: invokevirtual x/oc3c7a892f2f.Ғ ()V
      // 66: return
   }

   @oc66fa4f2195
   public void Ɂ(ocebec3dfd67 param1) {
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
      // 06: ifne 16
      // 09: invokevirtual x/oc3c7a892f2f.ΰ ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 38
      // 1a: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 1d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 20: d2i
      // 21: ifne 2a
      // 24: goto 28
      // 27: athrow
      // 28: return
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 2
      // 2c: ifne 6e
      // 2f: bipush 1
      // 30: invokevirtual x/oc3c7a892f2f.հ (I)V
      // 33: aload 0
      // 34: goto 38
      // 37: athrow
      // 38: invokevirtual x/oc3c7a892f2f.ƅ ()Z
      // 3b: ifeq 64
      // 3e: aload 0
      // 3f: iload 2
      // 40: ifne 6e
      // 43: goto 47
      // 46: athrow
      // 47: getfield x/oc3c7a892f2f.ʝ Z
      // 4a: ifeq 64
      // 4d: goto 51
      // 50: athrow
      // 51: aload 0
      // 52: iload 2
      // 53: ifne 74
      // 56: goto 5a
      // 59: athrow
      // 5a: getfield x/oc3c7a892f2f.Ѝ Z
      // 5d: ifne 73
      // 60: goto 64
      // 63: athrow
      // 64: aload 0
      // 65: aconst_null
      // 66: putfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 69: aload 0
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aconst_null
      // 6f: putfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 72: return
      // 73: aload 0
      // 74: invokevirtual x/oc3c7a892f2f.Ȓ ()Lnet/minecraft/util/Vec3;
      // 77: astore 3
      // 78: aload 0
      // 79: iload 2
      // 7a: ifne 99
      // 7d: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 80: ifnonnull 94
      // 83: goto 87
      // 86: athrow
      // 87: aload 0
      // 88: aload 3
      // 89: putfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 8c: iload 2
      // 8d: ifeq a0
      // 90: goto 94
      // 93: athrow
      // 94: aload 0
      // 95: goto 99
      // 98: athrow
      // 99: aload 0
      // 9a: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 9d: putfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // a0: aload 0
      // a1: aload 3
      // a2: putfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // a5: return
   }

   @oc66fa4f2195
   public void ŗ(oca27090789a param1) {
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
      // 05: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2i
      // 0c: ifeq 1c
      // 0f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 15: ifnull 1e
      // 18: goto 1c
      // 1b: athrow
      // 1c: return
      // 1d: athrow
      // 1e: aload 0
      // 1f: iload 2
      // 20: ifne 30
      // 23: invokevirtual x/oc3c7a892f2f.ΰ ()Z
      // 26: ifeq 2f
      // 29: goto 2d
      // 2c: athrow
      // 2d: return
      // 2e: athrow
      // 2f: aload 0
      // 30: iload 2
      // 31: ifne 4a
      // 34: invokevirtual x/oc3c7a892f2f.Ӆ ()Z
      // 37: ifeq 44
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: invokevirtual x/oc3c7a892f2f.ã ()V
      // 42: return
      // 43: athrow
      // 44: aload 0
      // 45: bipush 1
      // 46: invokevirtual x/oc3c7a892f2f.հ (I)V
      // 49: aload 0
      // 4a: invokevirtual x/oc3c7a892f2f.Ȼ ()V
      // 4d: return
   }

   @oc66fa4f2195
   public void Ǭ(oc25aa89b91f var1) {
      try {
         if (!this.ΰ()) {
            ;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195(
      receiveCanceled = true
   )
   public void Ϗ(oc9d4393f3ce param1) {
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
      // 06: ifne 1c
      // 09: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: ifne 44
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 1
      // 1d: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 20: invokevirtual x/oc3c7a892f2f.հ (Lnet/minecraft/network/Packet;)Z
      // 23: ifeq 44
      // 26: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 29: iload 2
      // 2a: ifne 3b
      // 2d: goto 31
      // 30: athrow
      // 31: ifnull 3f
      // 34: goto 38
      // 37: athrow
      // 38: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 3b: bipush 0
      // 3c: invokevirtual x/oc020457c099.Ͱ (I)V
      // 3f: aload 0
      // 40: bipush -1
      // 41: putfield x/oc3c7a892f2f.ͻ I
      // 44: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST,
      receiveCanceled = true
   )
   public void Χ(oce79181588d var1) {
      try {
         if (!(var1.Ҡ() instanceof S08PacketPlayerPosLook)) {
            return;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      this.Ѻ(false);
      this.ʴ = -288660224 ^ -288660219;
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void Ε(oc9d4393f3ce param1) {
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
      // 06: ifne 20
      // 09: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: ifeq 4c
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2f
      // 1c: goto 20
      // 1f: athrow
      // 20: invokevirtual x/oc3c7a892f2f.ΰ ()Z
      // 23: ifne 4c
      // 26: aload 0
      // 27: iload 2
      // 28: ifne 3a
      // 2b: goto 2f
      // 2e: athrow
      // 2f: invokevirtual x/oc3c7a892f2f.ƅ ()Z
      // 32: ifeq 4c
      // 35: aload 0
      // 36: goto 3a
      // 39: athrow
      // 3a: iload 2
      // 3b: ifne 4f
      // 3e: aload 1
      // 3f: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 42: invokevirtual x/oc3c7a892f2f.հ (Lnet/minecraft/network/Packet;)Z
      // 45: ifne 4e
      // 48: goto 4c
      // 4b: athrow
      // 4c: return
      // 4d: athrow
      // 4e: aload 0
      // 4f: invokevirtual x/oc3c7a892f2f.ã ()V
      // 52: return
   }

   @oc66fa4f2195
   public void ƭ(occ48acb5d22 param1) {
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
      // 06: ifne 1d
      // 09: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: bipush 1
      // 11: if_icmpne 43
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: goto 1d
      // 1c: athrow
      // 1d: getfield x/oc3c7a892f2f.ʝ Z
      // 20: ifeq 43
      // 23: aload 1
      // 24: getfield x/occ48acb5d22.Ǖ Lnet/minecraft/entity/player/EntityPlayer;
      // 27: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2d: if_acmpne 43
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: invokestatic java/lang/System.currentTimeMillis ()J
      // 38: putfield x/oc3c7a892f2f.ж J
      // 3b: aload 0
      // 3c: invokevirtual x/oc3c7a892f2f.ã ()V
      // 3f: goto 43
      // 42: athrow
      // 43: return
   }

   @oc66fa4f2195
   public void ә(ocf6b0e5bf86 var1) {
      try {
         if ((int)this.ђ.Ӂ() != 1) {
            return;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      try {
         if (oc69da1aa7f5.ő.currentScreen == null) {
            return;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      this.ã();
      this.Ѻ(false);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void q(oc746a23b244 param1) {
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
      // 006: ifne 016
      // 009: invokevirtual x/oc3c7a892f2f.ΰ ()Z
      // 00c: ifeq 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: getfield x/oc3c7a892f2f.Ŵ Lx/oca9cc61aada;
      // 019: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 01c: d2i
      // 01d: iload 2
      // 01e: ifne 035
      // 021: ifeq 06d
      // 024: goto 028
      // 027: athrow
      // 028: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 02e: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 031: goto 035
      // 034: athrow
      // 035: iload 2
      // 036: ifne 050
      // 039: ifeq 06d
      // 03c: goto 040
      // 03f: athrow
      // 040: aload 0
      // 041: iload 2
      // 042: ifne 054
      // 045: goto 049
      // 048: athrow
      // 049: getfield x/oc3c7a892f2f.Ѝ Z
      // 04c: goto 050
      // 04f: athrow
      // 050: ifeq 06d
      // 053: aload 0
      // 054: iload 2
      // 055: ifne 067
      // 058: getfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 05b: ifnull 06d
      // 05e: goto 062
      // 061: athrow
      // 062: aload 0
      // 063: goto 067
      // 066: athrow
      // 067: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 06a: ifnonnull 06f
      // 06d: return
      // 06e: athrow
      // 06f: new java/awt/Color
      // 072: dup
      // 073: bipush -1
      // 074: invokespecial java/awt/Color.<init> (I)V
      // 077: astore 3
      // 078: aload 0
      // 079: getfield x/oc3c7a892f2f.Ŵ Lx/oca9cc61aada;
      // 07c: iload 2
      // 07d: ifne 0ab
      // 080: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 083: d2i
      // 084: bipush 1
      // 085: if_icmpne 09b
      // 088: goto 08c
      // 08b: athrow
      // 08c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 092: fconst_1
      // 093: invokestatic x/ocdc8e6f6a42.ȇ (Lnet/minecraft/entity/player/EntityPlayer;F)Ljava/awt/Color;
      // 096: astore 3
      // 097: iload 2
      // 098: ifeq 0c6
      // 09b: aload 0
      // 09c: iload 2
      // 09d: ifne 0c7
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: getfield x/oc3c7a892f2f.Ŵ Lx/oca9cc61aada;
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0ae: d2i
      // 0af: ldc_w 2058269560
      // 0b2: ldc_w 2058269562
      // 0b5: ixor
      // 0b6: if_icmpne 0c6
      // 0b9: new java/awt/Color
      // 0bc: dup
      // 0bd: dconst_0
      // 0be: invokestatic x/ocd2958dac48.ů (D)I
      // 0c1: bipush 1
      // 0c2: invokespecial java/awt/Color.<init> (IZ)V
      // 0c5: astore 3
      // 0c6: aload 0
      // 0c7: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 0ca: getfield net/minecraft/util/Vec3.xCoord D
      // 0cd: aload 0
      // 0ce: getfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 0d1: getfield net/minecraft/util/Vec3.xCoord D
      // 0d4: aload 1
      // 0d5: getfield x/oc746a23b244.Ё F
      // 0d8: f2d
      // 0d9: invokestatic x/ocbd4917c4b1.ķ (DDD)D
      // 0dc: dstore 4
      // 0de: aload 0
      // 0df: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 0e2: getfield net/minecraft/util/Vec3.yCoord D
      // 0e5: aload 0
      // 0e6: getfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 0e9: getfield net/minecraft/util/Vec3.yCoord D
      // 0ec: aload 1
      // 0ed: getfield x/oc746a23b244.Ё F
      // 0f0: f2d
      // 0f1: invokestatic x/ocbd4917c4b1.ķ (DDD)D
      // 0f4: dstore 6
      // 0f6: aload 0
      // 0f7: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 0fa: getfield net/minecraft/util/Vec3.zCoord D
      // 0fd: aload 0
      // 0fe: getfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 101: getfield net/minecraft/util/Vec3.zCoord D
      // 104: aload 1
      // 105: getfield x/oc746a23b244.Ё F
      // 108: f2d
      // 109: invokestatic x/ocbd4917c4b1.ķ (DDD)D
      // 10c: dstore 8
      // 10e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 111: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 114: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getCollisionBorderSize ()F
      // 117: fstore 10
      // 119: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11c: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 11f: astore 11
      // 121: new net/minecraft/util/AxisAlignedBB
      // 124: dup
      // 125: dload 4
      // 127: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 12d: getfield net/minecraft/client/entity/EntityPlayerSP.width F
      // 130: f2d
      // 131: ldc2_w 2.0
      // 134: ddiv
      // 135: dsub
      // 136: dload 6
      // 138: dload 8
      // 13a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 140: getfield net/minecraft/client/entity/EntityPlayerSP.width F
      // 143: f2d
      // 144: ldc2_w 2.0
      // 147: ddiv
      // 148: dsub
      // 149: dload 4
      // 14b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 14e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 151: getfield net/minecraft/client/entity/EntityPlayerSP.width F
      // 154: f2d
      // 155: ldc2_w 2.0
      // 158: ddiv
      // 159: dadd
      // 15a: dload 6
      // 15c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 162: getfield net/minecraft/client/entity/EntityPlayerSP.height F
      // 165: f2d
      // 166: dadd
      // 167: dload 8
      // 169: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16f: getfield net/minecraft/client/entity/EntityPlayerSP.width F
      // 172: f2d
      // 173: ldc2_w 2.0
      // 176: ddiv
      // 177: dadd
      // 178: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 17b: fload 10
      // 17d: f2d
      // 17e: fload 10
      // 180: f2d
      // 181: fload 10
      // 183: f2d
      // 184: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 187: aload 11
      // 189: invokeinterface x/ocbc80def7d5.getRenderPosX ()D 1
      // 18e: dneg
      // 18f: aload 11
      // 191: invokeinterface x/ocbc80def7d5.getRenderPosY ()D 1
      // 196: dneg
      // 197: aload 11
      // 199: invokeinterface x/ocbc80def7d5.getRenderPosZ ()D 1
      // 19e: dneg
      // 19f: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 1a2: astore 12
      // 1a4: invokestatic x/ocbd4917c4b1.Є ()V
      // 1a7: aload 12
      // 1a9: aload 3
      // 1aa: invokevirtual java/awt/Color.getRed ()I
      // 1ad: aload 3
      // 1ae: invokevirtual java/awt/Color.getGreen ()I
      // 1b1: aload 3
      // 1b2: invokevirtual java/awt/Color.getBlue ()I
      // 1b5: invokestatic x/ocbd4917c4b1.ʅ (Lnet/minecraft/util/AxisAlignedBB;III)V
      // 1b8: invokestatic x/ocbd4917c4b1.Ӌ ()V
      // 1bb: return
   }

   private void հ(int param1) {
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
      // 06: ifne 2b
      // 09: getfield x/oc3c7a892f2f.Ր I
      // 0c: iload 1
      // 0d: if_icmpeq 2a
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: bipush 1
      // 16: invokevirtual x/oc3c7a892f2f.Ѻ (Z)V
      // 19: aload 0
      // 1a: iload 1
      // 1b: putfield x/oc3c7a892f2f.Ր I
      // 1e: aload 0
      // 1f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 22: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 25: putfield x/oc3c7a892f2f.Ƅ Lnet/minecraft/client/multiplayer/WorldClient;
      // 28: return
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 2
      // 2c: ifne 49
      // 2f: getfield x/oc3c7a892f2f.Ƅ Lnet/minecraft/client/multiplayer/WorldClient;
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 38: if_acmpeq 52
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: bipush 0
      // 41: invokevirtual x/oc3c7a892f2f.Ѻ (Z)V
      // 44: aload 0
      // 45: goto 49
      // 48: athrow
      // 49: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 4f: putfield x/oc3c7a892f2f.Ƅ Lnet/minecraft/client/multiplayer/WorldClient;
      // 52: return
   }

   private void Է() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 007: iload 1
      // 008: ifne 016
      // 00b: ifnonnull 013
      // 00e: goto 012
      // 011: athrow
      // 012: return
      // 013: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 016: bipush 0
      // 017: invokevirtual x/oc020457c099.Ͱ (I)V
      // 01a: iload 1
      // 01b: ifne 046
      // 01e: aload 0
      // 01f: bipush 0
      // 020: putfield x/oc3c7a892f2f.Ѝ Z
      // 023: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 026: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 029: ifnull 03d
      // 02c: goto 030
      // 02f: athrow
      // 030: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 033: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 036: ifnonnull 047
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: bipush -1
      // 03f: putfield x/oc3c7a892f2f.ͻ I
      // 042: goto 046
      // 045: athrow
      // 046: return
      // 047: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 04a: astore 2
      // 04b: aload 2
      // 04c: iload 1
      // 04d: ifne 058
      // 050: ifnull 07d
      // 053: goto 057
      // 056: athrow
      // 057: aload 2
      // 058: iload 1
      // 059: ifne 06b
      // 05c: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 05f: ifeq 07d
      // 062: goto 066
      // 065: athrow
      // 066: aload 2
      // 067: goto 06b
      // 06a: athrow
      // 06b: invokevirtual x/oc8edd24b1ed.Ќ ()Z
      // 06e: iload 1
      // 06f: ifne 07a
      // 072: ifeq 07d
      // 075: goto 079
      // 078: athrow
      // 079: bipush 1
      // 07a: goto 07e
      // 07d: bipush 0
      // 07e: istore 3
      // 07f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 082: iload 1
      // 083: ifne 097
      // 086: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 089: ifnull 0ae
      // 08c: goto 090
      // 08f: athrow
      // 090: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 093: goto 097
      // 096: athrow
      // 097: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 09a: invokeinterface x/oc51cbcffcfe.isHittingBlock ()Z 1
      // 09f: iload 1
      // 0a0: ifne 0ab
      // 0a3: ifeq 0ae
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: bipush 1
      // 0ab: goto 0af
      // 0ae: bipush 0
      // 0af: istore 4
      // 0b1: iload 1
      // 0b2: aload 0
      // 0b3: invokevirtual x/oc3c7a892f2f.ˁ ()Z
      // 0b6: istore 5
      // 0b8: ifne 112
      // 0bb: iload 3
      // 0bc: ifne 109
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: iload 4
      // 0c5: iload 1
      // 0c6: ifne 0e1
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: ifne 109
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0da: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: iload 1
      // 0e2: ifne 106
      // 0e5: ifeq 104
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ef: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f2: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isBlocking ()Z
      // 0f5: iload 1
      // 0f6: ifne 106
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: ifeq 109
      // 100: goto 104
      // 103: athrow
      // 104: iload 5
      // 106: ifne 113
      // 109: aload 0
      // 10a: bipush -1
      // 10b: putfield x/oc3c7a892f2f.ͻ I
      // 10e: goto 112
      // 111: athrow
      // 112: return
      // 113: aload 0
      // 114: invokevirtual x/oc3c7a892f2f.Ս ()Ljava/util/List;
      // 117: astore 6
      // 119: iload 1
      // 11a: ifne 134
      // 11d: aload 6
      // 11f: invokeinterface java/util/List.isEmpty ()Z 1
      // 124: ifeq 135
      // 127: goto 12b
      // 12a: athrow
      // 12b: aload 0
      // 12c: bipush -1
      // 12d: putfield x/oc3c7a892f2f.ͻ I
      // 130: goto 134
      // 133: athrow
      // 134: return
      // 135: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 138: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 13b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 13e: f2d
      // 13f: dstore 7
      // 141: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 144: invokevirtual x/oc020457c099.ů ()Lnet/minecraft/util/Vec3;
      // 147: dconst_0
      // 148: dload 7
      // 14a: dconst_0
      // 14b: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 14e: astore 9
      // 150: new net/minecraft/util/Vec3
      // 153: dup
      // 154: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 157: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 15a: getfield net/minecraft/client/entity/EntityPlayerSP.lastTickPosX D
      // 15d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 160: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 163: getfield net/minecraft/client/entity/EntityPlayerSP.lastTickPosY D
      // 166: dload 7
      // 168: dadd
      // 169: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16f: getfield net/minecraft/client/entity/EntityPlayerSP.lastTickPosZ D
      // 172: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 175: astore 10
      // 177: new net/minecraft/util/Vec3
      // 17a: dup
      // 17b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 181: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 184: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 187: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18a: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 18d: dload 7
      // 18f: dadd
      // 190: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 193: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 196: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 199: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 19c: astore 11
      // 19e: aload 6
      // 1a0: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1a5: astore 12
      // 1a7: aload 12
      // 1a9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1ae: ifeq 250
      // 1b1: aload 12
      // 1b3: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1b8: checkcast net/minecraft/entity/player/EntityPlayer
      // 1bb: astore 13
      // 1bd: aload 13
      // 1bf: aload 11
      // 1c1: invokestatic x/oc75d51ec7eb.Ğ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)D
      // 1c4: dstore 14
      // 1c6: dload 14
      // 1c8: iload 1
      // 1c9: ifne 1ea
      // 1cc: aload 0
      // 1cd: getfield x/oc3c7a892f2f.Ю Lx/oca9cc61aada;
      // 1d0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d3: dcmpl
      // 1d4: ifle 1e3
      // 1d7: goto 1db
      // 1da: athrow
      // 1db: iload 1
      // 1dc: ifeq 1a7
      // 1df: goto 1e3
      // 1e2: athrow
      // 1e3: aload 13
      // 1e5: aload 10
      // 1e7: invokestatic x/oc75d51ec7eb.Ğ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)D
      // 1ea: dstore 16
      // 1ec: aload 13
      // 1ee: aload 9
      // 1f0: invokestatic x/oc75d51ec7eb.Ğ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)D
      // 1f3: dstore 18
      // 1f5: dload 14
      // 1f7: dload 16
      // 1f9: dcmpg
      // 1fa: iload 1
      // 1fb: ifne 229
      // 1fe: iflt 219
      // 201: goto 205
      // 204: athrow
      // 205: dload 14
      // 207: dload 18
      // 209: dcmpg
      // 20a: iload 1
      // 20b: ifne 229
      // 20e: goto 212
      // 211: athrow
      // 212: ifge 24c
      // 215: goto 219
      // 218: athrow
      // 219: aload 0
      // 21a: iload 1
      // 21b: ifne 247
      // 21e: goto 222
      // 221: athrow
      // 222: getfield x/oc3c7a892f2f.ͻ I
      // 225: goto 229
      // 228: athrow
      // 229: ifge 23c
      // 22c: aload 0
      // 22d: invokevirtual x/oc3c7a892f2f.ĭ ()I
      // 230: pop
      // 231: aload 0
      // 232: invokestatic java/lang/System.currentTimeMillis ()J
      // 235: putfield x/oc3c7a892f2f.Ё J
      // 238: goto 23c
      // 23b: athrow
      // 23c: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 23f: aload 0
      // 240: getfield x/oc3c7a892f2f.ͻ I
      // 243: invokevirtual x/oc020457c099.Ͱ (I)V
      // 246: aload 0
      // 247: bipush 1
      // 248: putfield x/oc3c7a892f2f.Ѝ Z
      // 24b: return
      // 24c: iload 1
      // 24d: ifeq 1a7
      // 250: return
   }

   private void Ғ() {
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
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: ifnull 34
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1f: ifnull 34
      // 22: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 25: iload 1
      // 26: ifne 38
      // 29: goto 2d
      // 2c: athrow
      // 2d: ifnonnull 35
      // 30: goto 34
      // 33: athrow
      // 34: return
      // 35: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 38: invokevirtual x/oc020457c099.ů ()Lnet/minecraft/util/Vec3;
      // 3b: astore 2
      // 3c: aload 0
      // 3d: iload 1
      // 3e: ifne 5d
      // 41: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 44: ifnonnull 58
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 0
      // 4c: aload 2
      // 4d: putfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 50: iload 1
      // 51: ifeq 64
      // 54: goto 58
      // 57: athrow
      // 58: aload 0
      // 59: goto 5d
      // 5c: athrow
      // 5d: aload 0
      // 5e: getfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 61: putfield x/oc3c7a892f2f.ղ Lnet/minecraft/util/Vec3;
      // 64: aload 0
      // 65: aload 2
      // 66: putfield x/oc3c7a892f2f.ƃ Lnet/minecraft/util/Vec3;
      // 69: return
   }

   private int ĭ() {
      int var10000 = oc5e549848f3.İ;
      this.ͻ = 0;
      this.Ά = this.Ά + (long)this.Ǚ.Ӂ();
      int var1 = var10000;

      while (true) {
         if (this.Ά > 0L) {
            try {
               var3 = this;
               if (var1 != 0) {
                  break;
               }

               this.ͻ++;
               this.Ά -= -4297716858146053463L ^ -4297716858146053477L;
               if (var1 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var2) {
               throw var2;
            }
         }

         var3 = this;
         break;
      }

      return var3.ͻ;
   }

   private void Ȼ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 1
      // 008: ifne 027
      // 00b: ifeq 048
      // 00e: goto 012
      // 011: athrow
      // 012: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 015: iload 1
      // 016: ifne 02d
      // 019: goto 01d
      // 01c: athrow
      // 01d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 020: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 023: goto 027
      // 026: athrow
      // 027: ifne 048
      // 02a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02d: iload 1
      // 02e: ifne 042
      // 031: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 034: ifnull 048
      // 037: goto 03b
      // 03a: athrow
      // 03b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03e: goto 042
      // 041: athrow
      // 042: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 045: ifnonnull 052
      // 048: aload 0
      // 049: invokevirtual x/oc3c7a892f2f.ã ()V
      // 04c: aload 0
      // 04d: invokevirtual x/oc3c7a892f2f.Օ ()V
      // 050: return
      // 051: athrow
      // 052: aload 0
      // 053: bipush 0
      // 054: putfield x/oc3c7a892f2f.Ѝ Z
      // 057: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 05a: astore 2
      // 05b: aload 2
      // 05c: iload 1
      // 05d: ifne 068
      // 060: ifnull 07c
      // 063: goto 067
      // 066: athrow
      // 067: aload 2
      // 068: invokevirtual x/oc8edd24b1ed.Ƴ ()Z
      // 06b: iload 1
      // 06c: ifne 088
      // 06f: ifeq 07c
      // 072: goto 076
      // 075: athrow
      // 076: aload 0
      // 077: invokevirtual x/oc3c7a892f2f.ã ()V
      // 07a: return
      // 07b: athrow
      // 07c: aload 0
      // 07d: iload 1
      // 07e: ifne 08c
      // 081: invokevirtual x/oc3c7a892f2f.Ӆ ()Z
      // 084: goto 088
      // 087: athrow
      // 088: ifeq 090
      // 08b: aload 0
      // 08c: invokevirtual x/oc3c7a892f2f.ã ()V
      // 08f: return
      // 090: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 093: astore 3
      // 094: aload 3
      // 095: iload 1
      // 096: ifne 0a1
      // 099: ifnull 0ad
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 3
      // 0a1: invokevirtual x/oce3cc81daa8.ń ()Z
      // 0a4: ifeq 0ad
      // 0a7: aload 0
      // 0a8: invokevirtual x/oc3c7a892f2f.ã ()V
      // 0ab: return
      // 0ac: athrow
      // 0ad: aload 0
      // 0ae: getfield x/oc3c7a892f2f.Ю Lx/oca9cc61aada;
      // 0b1: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b4: aload 0
      // 0b5: getfield x/oc3c7a892f2f.Ю Lx/oca9cc61aada;
      // 0b8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0bb: dmul
      // 0bc: dstore 4
      // 0be: iload 1
      // 0bf: aload 0
      // 0c0: invokevirtual x/oc3c7a892f2f.M ()Z
      // 0c3: istore 6
      // 0c5: aload 0
      // 0c6: dload 4
      // 0c8: invokevirtual x/oc3c7a892f2f.Ƥ (D)Lnet/minecraft/entity/player/EntityPlayer;
      // 0cb: astore 7
      // 0cd: ifne 11d
      // 0d0: aload 0
      // 0d1: aload 7
      // 0d3: invokevirtual x/oc3c7a892f2f.Κ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 0d6: ifne 10f
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: invokevirtual x/oc3c7a892f2f.ã ()V
      // 0e1: aload 0
      // 0e2: ldc2_w -1.0
      // 0e5: putfield x/oc3c7a892f2f.ž D
      // 0e8: aload 0
      // 0e9: bipush -1
      // 0ea: iload 1
      // 0eb: ifne 108
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: putfield x/oc3c7a892f2f.ſ I
      // 0f5: aload 0
      // 0f6: aload 7
      // 0f8: ifnull 10b
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: aload 7
      // 101: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 104: goto 108
      // 107: athrow
      // 108: goto 10c
      // 10b: bipush 0
      // 10c: putfield x/oc3c7a892f2f.Ӛ I
      // 10f: aload 0
      // 110: iload 1
      // 111: ifne 141
      // 114: aload 7
      // 116: putfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 121: ifnonnull 140
      // 124: aload 0
      // 125: invokevirtual x/oc3c7a892f2f.ã ()V
      // 128: aload 0
      // 129: ldc2_w -1.0
      // 12c: putfield x/oc3c7a892f2f.ž D
      // 12f: aload 0
      // 130: bipush -1
      // 131: putfield x/oc3c7a892f2f.ſ I
      // 134: aload 0
      // 135: bipush 0
      // 136: putfield x/oc3c7a892f2f.Ӛ I
      // 139: aload 0
      // 13a: bipush 0
      // 13b: putfield x/oc3c7a892f2f.Ѝ Z
      // 13e: return
      // 13f: athrow
      // 140: aload 0
      // 141: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 144: invokestatic x/oc75d51ec7eb.Ώ (Lnet/minecraft/entity/Entity;)D
      // 147: dstore 8
      // 149: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 14c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14f: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 152: istore 10
      // 154: aload 0
      // 155: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 158: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 15b: istore 11
      // 15d: aload 0
      // 15e: getfield x/oc3c7a892f2f.ʝ Z
      // 161: iload 1
      // 162: ifne 36e
      // 165: ifeq 36c
      // 168: goto 16c
      // 16b: athrow
      // 16c: dload 8
      // 16e: iload 1
      // 16f: ifne 19b
      // 172: goto 176
      // 175: athrow
      // 176: dload 4
      // 178: dcmpl
      // 179: ifle 197
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 0
      // 181: invokevirtual x/oc3c7a892f2f.ã ()V
      // 184: aload 0
      // 185: dload 8
      // 187: putfield x/oc3c7a892f2f.ž D
      // 18a: aload 0
      // 18b: bipush -1
      // 18c: putfield x/oc3c7a892f2f.ſ I
      // 18f: aload 0
      // 190: iload 11
      // 192: putfield x/oc3c7a892f2f.Ӛ I
      // 195: return
      // 196: athrow
      // 197: aload 0
      // 198: getfield x/oc3c7a892f2f.ž D
      // 19b: dconst_0
      // 19c: dcmpl
      // 19d: iload 1
      // 19e: ifne 222
      // 1a1: iflt 220
      // 1a4: goto 1a8
      // 1a7: athrow
      // 1a8: dload 8
      // 1aa: aload 0
      // 1ab: getfield x/oc3c7a892f2f.ž D
      // 1ae: dcmpl
      // 1af: iload 1
      // 1b0: ifne 222
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: iflt 220
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: aload 0
      // 1bf: getfield x/oc3c7a892f2f.ſ I
      // 1c2: iload 1
      // 1c3: ifne 1e2
      // 1c6: goto 1ca
      // 1c9: athrow
      // 1ca: aload 0
      // 1cb: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 1ce: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 1d1: if_icmpne 1fe
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: dload 8
      // 1da: ldc2_w 9.0
      // 1dd: dcmpg
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: iload 1
      // 1e3: ifne 1ef
      // 1e6: ifgt 1fe
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: iload 10
      // 1ef: iload 1
      // 1f0: ifne 1fb
      // 1f3: ifne 1fe
      // 1f6: goto 1fa
      // 1f9: athrow
      // 1fa: bipush 1
      // 1fb: goto 1ff
      // 1fe: bipush 0
      // 1ff: istore 12
      // 201: iload 12
      // 203: iload 1
      // 204: ifne 222
      // 207: ifne 220
      // 20a: goto 20e
      // 20d: athrow
      // 20e: aload 0
      // 20f: invokevirtual x/oc3c7a892f2f.ã ()V
      // 212: aload 0
      // 213: dload 8
      // 215: putfield x/oc3c7a892f2f.ž D
      // 218: aload 0
      // 219: iload 11
      // 21b: putfield x/oc3c7a892f2f.Ӛ I
      // 21e: return
      // 21f: athrow
      // 220: iload 10
      // 222: aload 0
      // 223: getfield x/oc3c7a892f2f.ԝ I
      // 226: if_icmple 246
      // 229: aload 0
      // 22a: invokevirtual x/oc3c7a892f2f.ã ()V
      // 22d: aload 0
      // 22e: bipush -1
      // 22f: putfield x/oc3c7a892f2f.ſ I
      // 232: aload 0
      // 233: iload 10
      // 235: putfield x/oc3c7a892f2f.ԝ I
      // 238: aload 0
      // 239: dload 8
      // 23b: putfield x/oc3c7a892f2f.ž D
      // 23e: aload 0
      // 23f: iload 11
      // 241: putfield x/oc3c7a892f2f.Ӛ I
      // 244: return
      // 245: athrow
      // 246: aload 0
      // 247: iload 1
      // 248: ifne 287
      // 24b: iload 10
      // 24d: putfield x/oc3c7a892f2f.ԝ I
      // 250: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 253: ifnull 286
      // 256: goto 25a
      // 259: athrow
      // 25a: aload 0
      // 25b: iload 1
      // 25c: ifne 287
      // 25f: goto 263
      // 262: athrow
      // 263: getfield x/oc3c7a892f2f.Ü Lx/oc3d1d10e2c1;
      // 266: ifnull 286
      // 269: goto 26d
      // 26c: athrow
      // 26d: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 270: getstatic x/oc2f60cd9d1e.û Lx/oc2f60cd9d1e;
      // 273: aload 0
      // 274: getfield x/oc3c7a892f2f.Ü Lx/oc3d1d10e2c1;
      // 277: aload 0
      // 278: getfield x/oc3c7a892f2f.Ǚ Lx/oca9cc61aada;
      // 27b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 27e: d2l
      // 27f: invokevirtual x/oc8da5ba227c.ń (Lx/oc2f60cd9d1e;Lx/oc3d1d10e2c1;J)V
      // 282: goto 286
      // 285: athrow
      // 286: aload 0
      // 287: invokevirtual x/oc3c7a892f2f.ˁ ()Z
      // 28a: iload 1
      // 28b: ifne 2b0
      // 28e: ifne 2a7
      // 291: goto 295
      // 294: athrow
      // 295: aload 0
      // 296: invokevirtual x/oc3c7a892f2f.ã ()V
      // 299: aload 0
      // 29a: dload 8
      // 29c: putfield x/oc3c7a892f2f.ž D
      // 29f: aload 0
      // 2a0: iload 11
      // 2a2: putfield x/oc3c7a892f2f.Ӛ I
      // 2a5: return
      // 2a6: athrow
      // 2a7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2aa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2ad: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 2b0: istore 12
      // 2b2: iload 1
      // 2b3: ifne 2f0
      // 2b6: iload 12
      // 2b8: ifeq 2ea
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: aload 0
      // 2c0: iload 1
      // 2c1: ifne 2eb
      // 2c4: goto 2c8
      // 2c7: athrow
      // 2c8: getfield x/oc3c7a892f2f.ώ Z
      // 2cb: ifne 2ea
      // 2ce: goto 2d2
      // 2d1: athrow
      // 2d2: aload 0
      // 2d3: invokevirtual x/oc3c7a892f2f.ã ()V
      // 2d6: aload 0
      // 2d7: iload 12
      // 2d9: putfield x/oc3c7a892f2f.ώ Z
      // 2dc: aload 0
      // 2dd: dload 8
      // 2df: putfield x/oc3c7a892f2f.ž D
      // 2e2: aload 0
      // 2e3: iload 11
      // 2e5: putfield x/oc3c7a892f2f.Ӛ I
      // 2e8: return
      // 2e9: athrow
      // 2ea: aload 0
      // 2eb: iload 12
      // 2ed: putfield x/oc3c7a892f2f.ώ Z
      // 2f0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2f3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2f6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isBlocking ()Z
      // 2f9: istore 13
      // 2fb: iload 1
      // 2fc: ifne 341
      // 2ff: iload 13
      // 301: ifeq 333
      // 304: goto 308
      // 307: athrow
      // 308: aload 0
      // 309: iload 1
      // 30a: ifne 342
      // 30d: goto 311
      // 310: athrow
      // 311: getfield x/oc3c7a892f2f.Ď Z
      // 314: ifne 333
      // 317: goto 31b
      // 31a: athrow
      // 31b: aload 0
      // 31c: invokevirtual x/oc3c7a892f2f.ã ()V
      // 31f: aload 0
      // 320: iload 13
      // 322: putfield x/oc3c7a892f2f.Ď Z
      // 325: aload 0
      // 326: dload 8
      // 328: putfield x/oc3c7a892f2f.ž D
      // 32b: aload 0
      // 32c: iload 11
      // 32e: putfield x/oc3c7a892f2f.Ӛ I
      // 331: return
      // 332: athrow
      // 333: aload 0
      // 334: iload 1
      // 335: ifne 367
      // 338: iload 13
      // 33a: putfield x/oc3c7a892f2f.Ď Z
      // 33d: goto 341
      // 340: athrow
      // 341: aload 0
      // 342: invokevirtual x/oc3c7a892f2f.Ǉ ()Z
      // 345: ifeq 35a
      // 348: aload 0
      // 349: invokevirtual x/oc3c7a892f2f.ã ()V
      // 34c: aload 0
      // 34d: dload 8
      // 34f: putfield x/oc3c7a892f2f.ž D
      // 352: aload 0
      // 353: iload 11
      // 355: putfield x/oc3c7a892f2f.Ӛ I
      // 358: return
      // 359: athrow
      // 35a: aload 0
      // 35b: dload 8
      // 35d: putfield x/oc3c7a892f2f.ž D
      // 360: aload 0
      // 361: iload 11
      // 363: putfield x/oc3c7a892f2f.Ӛ I
      // 366: aload 0
      // 367: bipush 1
      // 368: putfield x/oc3c7a892f2f.Ѝ Z
      // 36b: return
      // 36c: iload 10
      // 36e: iload 1
      // 36f: ifne 3b0
      // 372: aload 0
      // 373: getfield x/oc3c7a892f2f.ԝ I
      // 376: if_icmple 386
      // 379: goto 37d
      // 37c: athrow
      // 37d: aload 0
      // 37e: bipush -1
      // 37f: putfield x/oc3c7a892f2f.ſ I
      // 382: goto 386
      // 385: athrow
      // 386: aload 0
      // 387: iload 10
      // 389: iload 1
      // 38a: ifne 3e9
      // 38d: putfield x/oc3c7a892f2f.ԝ I
      // 390: aload 0
      // 391: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 394: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 397: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 39a: putfield x/oc3c7a892f2f.ώ Z
      // 39d: aload 0
      // 39e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3a1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3a4: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isBlocking ()Z
      // 3a7: putfield x/oc3c7a892f2f.Ď Z
      // 3aa: iload 10
      // 3ac: goto 3b0
      // 3af: athrow
      // 3b0: ifne 3e6
      // 3b3: aload 0
      // 3b4: iload 1
      // 3b5: ifne 3ed
      // 3b8: goto 3bc
      // 3bb: athrow
      // 3bc: getfield x/oc3c7a892f2f.Ӛ I
      // 3bf: ifne 3e6
      // 3c2: goto 3c6
      // 3c5: athrow
      // 3c6: iload 11
      // 3c8: iload 1
      // 3c9: ifne 3fa
      // 3cc: goto 3d0
      // 3cf: athrow
      // 3d0: ifle 3e6
      // 3d3: goto 3d7
      // 3d6: athrow
      // 3d7: aload 0
      // 3d8: aload 0
      // 3d9: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 3dc: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 3df: putfield x/oc3c7a892f2f.ſ I
      // 3e2: goto 3e6
      // 3e5: athrow
      // 3e6: aload 0
      // 3e7: iload 11
      // 3e9: putfield x/oc3c7a892f2f.Ӛ I
      // 3ec: aload 0
      // 3ed: getfield x/oc3c7a892f2f.ž D
      // 3f0: dconst_0
      // 3f1: iload 1
      // 3f2: ifne 407
      // 3f5: dcmpl
      // 3f6: goto 3fa
      // 3f9: athrow
      // 3fa: iflt 417
      // 3fd: dload 8
      // 3ff: aload 0
      // 400: getfield x/oc3c7a892f2f.ž D
      // 403: goto 407
      // 406: athrow
      // 407: dcmpg
      // 408: iload 1
      // 409: ifne 414
      // 40c: ifge 417
      // 40f: goto 413
      // 412: athrow
      // 413: bipush 1
      // 414: goto 418
      // 417: bipush 0
      // 418: istore 12
      // 41a: dload 8
      // 41c: ldc2_w 9.0
      // 41f: dcmpl
      // 420: iload 1
      // 421: ifne 42c
      // 424: ifle 42f
      // 427: goto 42b
      // 42a: athrow
      // 42b: bipush 1
      // 42c: goto 430
      // 42f: bipush 0
      // 430: istore 13
      // 432: aload 0
      // 433: invokevirtual x/oc3c7a892f2f.ˁ ()Z
      // 436: istore 14
      // 438: aload 0
      // 439: getfield x/oc3c7a892f2f.ſ I
      // 43c: iload 1
      // 43d: ifne 458
      // 440: aload 0
      // 441: getfield x/oc3c7a892f2f.ȗ Lnet/minecraft/entity/player/EntityPlayer;
      // 444: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 447: if_icmpne 48e
      // 44a: goto 44e
      // 44d: athrow
      // 44e: dload 8
      // 450: ldc2_w 9.0
      // 453: dcmpg
      // 454: goto 458
      // 457: athrow
      // 458: iload 1
      // 459: ifne 465
      // 45c: ifgt 48e
      // 45f: goto 463
      // 462: athrow
      // 463: iload 10
      // 465: iload 1
      // 466: ifne 472
      // 469: ifne 48e
      // 46c: goto 470
      // 46f: athrow
      // 470: iload 6
      // 472: iload 1
      // 473: ifne 47f
      // 476: ifeq 48e
      // 479: goto 47d
      // 47c: athrow
      // 47d: iload 14
      // 47f: iload 1
      // 480: ifne 48b
      // 483: ifeq 48e
      // 486: goto 48a
      // 489: athrow
      // 48a: bipush 1
      // 48b: goto 48f
      // 48e: bipush 0
      // 48f: istore 15
      // 491: aload 0
      // 492: dload 8
      // 494: putfield x/oc3c7a892f2f.ž D
      // 497: iload 10
      // 499: iload 1
      // 49a: ifne 4a6
      // 49d: ifne 4f1
      // 4a0: goto 4a4
      // 4a3: athrow
      // 4a4: iload 14
      // 4a6: iload 1
      // 4a7: ifne 4b3
      // 4aa: ifeq 4f1
      // 4ad: goto 4b1
      // 4b0: athrow
      // 4b1: iload 6
      // 4b3: iload 1
      // 4b4: ifne 4c0
      // 4b7: ifeq 4f1
      // 4ba: goto 4be
      // 4bd: athrow
      // 4be: iload 12
      // 4c0: iload 1
      // 4c1: ifne 4de
      // 4c4: ifeq 4dc
      // 4c7: goto 4cb
      // 4ca: athrow
      // 4cb: iload 13
      // 4cd: iload 1
      // 4ce: ifne 4de
      // 4d1: goto 4d5
      // 4d4: athrow
      // 4d5: ifne 4e1
      // 4d8: goto 4dc
      // 4db: athrow
      // 4dc: iload 15
      // 4de: ifeq 4f1
      // 4e1: aload 0
      // 4e2: invokevirtual x/oc3c7a892f2f.ս ()V
      // 4e5: aload 0
      // 4e6: aload 0
      // 4e7: getfield x/oc3c7a892f2f.ʝ Z
      // 4ea: putfield x/oc3c7a892f2f.Ѝ Z
      // 4ed: goto 4f1
      // 4f0: athrow
      // 4f1: return
   }

   private void ս() {
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
      // 05: getfield x/oc3c7a892f2f.ʝ Z
      // 08: ifne 1d
      // 0b: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 0e: iload 1
      // 0f: ifne 3e
      // 12: goto 16
      // 15: athrow
      // 16: ifnonnull 1e
      // 19: goto 1d
      // 1c: athrow
      // 1d: return
      // 1e: aload 0
      // 1f: invokestatic java/lang/System.currentTimeMillis ()J
      // 22: putfield x/oc3c7a892f2f.Ё J
      // 25: aload 0
      // 26: new x/oc3d1d10e2c1
      // 29: dup
      // 2a: getstatic x/oc2f60cd9d1e.Ս Ljava/util/Set;
      // 2d: new x/oc5b52533f96
      // 30: dup
      // 31: aload 0
      // 32: invokespecial x/oc5b52533f96.<init> (Lx/oc69da1aa7f5;)V
      // 35: invokespecial x/oc3d1d10e2c1.<init> (Ljava/util/Set;Lx/oc93821aed5f;)V
      // 38: putfield x/oc3c7a892f2f.Ü Lx/oc3d1d10e2c1;
      // 3b: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 3e: aload 0
      // 3f: getfield x/oc3c7a892f2f.Ü Lx/oc3d1d10e2c1;
      // 42: invokevirtual x/oc8da5ba227c.ʕ (Lx/oc3d1d10e2c1;)V
      // 45: aload 0
      // 46: bipush 1
      // 47: putfield x/oc3c7a892f2f.ʝ Z
      // 4a: return
   }

   private void ã() {
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
      // 09: getfield x/oc3c7a892f2f.ʝ Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: invokestatic java/lang/System.currentTimeMillis ()J
      // 19: putfield x/oc3c7a892f2f.ж J
      // 1c: aload 0
      // 1d: getfield x/oc3c7a892f2f.Ü Lx/oc3d1d10e2c1;
      // 20: astore 2
      // 21: aload 0
      // 22: aconst_null
      // 23: putfield x/oc3c7a892f2f.Ü Lx/oc3d1d10e2c1;
      // 26: aload 0
      // 27: bipush 0
      // 28: putfield x/oc3c7a892f2f.ʝ Z
      // 2b: aload 0
      // 2c: bipush 0
      // 2d: putfield x/oc3c7a892f2f.Ѝ Z
      // 30: aload 2
      // 31: ifnull 5c
      // 34: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 37: iload 1
      // 38: ifne 49
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ifnull 51
      // 42: goto 46
      // 45: athrow
      // 46: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 49: aload 2
      // 4a: invokevirtual x/oc8da5ba227c.ɭ (Lx/oc3d1d10e2c1;)V
      // 4d: iload 1
      // 4e: ifeq 5c
      // 51: aload 2
      // 52: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 55: invokevirtual x/oc93821aed5f.å ()V
      // 58: goto 5c
      // 5b: athrow
      // 5c: return
   }

   public void ԝ() {
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
      // 06: ifne 25
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: invokestatic java/lang/System.currentTimeMillis ()J
      // 19: putfield x/oc3c7a892f2f.ж J
      // 1c: iload 1
      // 1d: ifne 7f
      // 20: aload 0
      // 21: goto 25
      // 24: athrow
      // 25: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 28: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2b: d2i
      // 2c: ifne 7b
      // 2f: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 32: iload 1
      // 33: ifne 44
      // 36: goto 3a
      // 39: athrow
      // 3a: ifnull 48
      // 3d: goto 41
      // 40: athrow
      // 41: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 44: bipush 0
      // 45: invokevirtual x/oc020457c099.Ͱ (I)V
      // 48: getstatic x/oc2cf3d80e17.Ҿ Lx/oc61f27421d1;
      // 4b: iload 1
      // 4c: ifne 59
      // 4f: ifnull 6b
      // 52: goto 56
      // 55: athrow
      // 56: getstatic x/oc2cf3d80e17.Ҿ Lx/oc61f27421d1;
      // 59: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5c: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 5f: ifnull 67
      // 62: bipush 1
      // 63: goto 68
      // 66: athrow
      // 67: bipush 0
      // 68: invokevirtual x/oc61f27421d1.Ћ (Z)V
      // 6b: aload 0
      // 6c: bipush -1
      // 6d: putfield x/oc3c7a892f2f.ͻ I
      // 70: aload 0
      // 71: lconst_0
      // 72: putfield x/oc3c7a892f2f.Ά J
      // 75: aload 0
      // 76: bipush 0
      // 77: putfield x/oc3c7a892f2f.Ѝ Z
      // 7a: return
      // 7b: aload 0
      // 7c: invokevirtual x/oc3c7a892f2f.ã ()V
      // 7f: return
   }

   private boolean ˁ() {
      int var1 = oc5e549848f3.İ;
      int var2 = 330479506 ^ -1099680864;

      while (true) {
         switch (var2) {
            case -1379498958:
               int var9;
               label75: {
                  label74: {
                     try {
                        var9 = this.S.ǭ();
                        if (var1 != 0) {
                           break label75;
                        }

                        if (var9 == 0) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = -2032855624 ^ -1099680864;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var9 = 111021801 ^ -1099680864;
               }

               var2 = var9;
               break;
            case -1349840818:
               return false;
            case -1192608439:
               return true;
            case -730842956:
               int var7;
               label88: {
                  label87: {
                     try {
                        var7 = this.Ъ.ǭ();
                        if (var1 != 0) {
                           break label88;
                        }

                        if (var7 == 0) {
                           break label87;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = 1455446968 ^ -1099680864;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var7 = 301933550 ^ -1099680864;
               }

               var2 = var7;
               if (var1 == 0) {
                  break;
               }
            case -390830056:
               int var8;
               label66: {
                  label65: {
                     try {
                        var8 = oc7fbc83d9b3.r();
                        if (var1 != 0) {
                           break label66;
                        }

                        if (var8 == 0) {
                           break label65;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 111021801 ^ -1099680864;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var8 = 301933550 ^ -1099680864;
               }

               var2 = var8;
               if (var1 == 0) {
                  break;
               }

               return false;
            case 950085144:
               int var10000;
               label57: {
                  label56: {
                     try {
                        var10000 = oc7fbc83d9b3.С();
                        if (var1 != 0) {
                           break label57;
                        }

                        if (var10000 != 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1778649876 ^ -1099680864;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 111021801 ^ -1099680864;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private boolean Ǉ() {
      ItemStack var2 = null;
      int var3 = -1862797615 ^ -413232516;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var3) {
            case -1424714144:
               return true;
            case 19158734:
               return false;
            case 1132375676:
               break;
            case 1275168540:
               int var10000;
               label79: {
                  label78: {
                     try {
                        var10000 = var2.getMetadata();
                        if (var1 != 0) {
                           break label79;
                        }

                        if (!ItemPotion.isSplash(var10000)) {
                           break label78;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = 1279919132 ^ -413232516;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -428161870 ^ -413232516;
               }

               var3 = var10000;
               if (var1 == 0) {
                  continue;
               }
            case 2007590061:
               var2 = oc69da1aa7f5.ő.thePlayer.getHeldItem();

               label68: {
                  label67: {
                     try {
                        if (var1 != 0) {
                           break label68;
                        }

                        if (!oc69da1aa7f5.ő.thePlayer.isUsingItem()) {
                           break label67;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -1139058001 ^ -413232516;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var3 = -428161870 ^ -413232516;
               }

               if (var1 == 0) {
                  continue;
               }
               break;
            case 1531300051:
               if (var2 != null) {
                  var3 = -1541391360 ^ -413232516;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var3 = -428161870 ^ -413232516;
               continue;
            default:
               throw null;
         }

         int var7;
         label55: {
            label54: {
               try {
                  var7 = var2.getItem() instanceof ItemPotion;
                  if (var1 != 0) {
                     break label55;
                  }

                  if (var7 == 0) {
                     break label54;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = -1419831968 ^ -413232516;
               if (var1 == 0) {
                  continue;
               }
            }

            var7 = -428161870 ^ -413232516;
         }

         var3 = var7;
         if (var1 != 0) {
            return false;
         }
      }
   }

   private boolean M() {
      int var1 = oc5e549848f3.İ;
      int var2 = -1128690102 ^ -726651415;

      while (true) {
         switch (var2) {
            case -1670570936:
               return false;
            case 265187350:
               int var5;
               label46: {
                  label45: {
                     try {
                        float var7;
                        var5 = (var7 = oc69da1aa7f5.ő.thePlayer.moveStrafing - 0.0F) == 0.0F ? 0 : (var7 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label46;
                        }

                        if (var5 == 0) {
                           break label45;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 173511736 ^ -726651415;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = 1222455713 ^ -726651415;
               }

               var2 = var5;
               if (var1 == 0) {
                  break;
               }
            case -555238959:
               return true;
            case 1745462179:
               int var10000;
               label37: {
                  label36: {
                     try {
                        float var6;
                        var10000 = (var6 = oc69da1aa7f5.ő.thePlayer.moveForward - 0.0F) == 0.0F ? 0 : (var6 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label37;
                        }

                        if (var10000 != 0) {
                           break label36;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -612475393 ^ -726651415;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 173511736 ^ -726651415;
               }

               var2 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private boolean Ӆ() {
      oc69da1aa7f5 var2 = null;
      int var3 = -1849144515 ^ 945056054;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var3) {
            case -1449385461:
               var2 = oc9755810e45.ʬ(oc668fce0dbf.class);

               label48: {
                  label47: {
                     try {
                        if (var1 != 0) {
                           break label48;
                        }

                        if (var2 == null) {
                           break label47;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 472977939 ^ 945056054;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var3 = 1131021832 ^ 945056054;
               }

               if (var1 == 0) {
                  break;
               }
            case 2067689278:
               return false;
            case 610630437:
               int var10000;
               label39: {
                  label38: {
                     try {
                        var10000 = var2.z$3rzb3dil7uydr();
                        if (var1 != 0) {
                           break label39;
                        }

                        if (var10000 == 0) {
                           break label38;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 1162555652 ^ 945056054;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1131021832 ^ 945056054;
               }

               var3 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 2099206194:
               return true;
            default:
               throw null;
         }
      }
   }

   boolean Շ(EntityPlayer param1) {
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
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 3b
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 27
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b: if_acmpeq 3b
      // 1e: goto 22
      // 21: athrow
      // 22: aload 1
      // 23: goto 27
      // 26: athrow
      // 27: iload 2
      // 28: ifne 44
      // 2b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 31: getfield net/minecraft/client/entity/EntityPlayerSP.ridingEntity Lnet/minecraft/entity/Entity;
      // 34: if_acmpne 3e
      // 37: goto 3b
      // 3a: athrow
      // 3b: bipush 0
      // 3c: ireturn
      // 3d: athrow
      // 3e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 41: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 44: astore 3
      // 45: aload 1
      // 46: iload 2
      // 47: ifne 57
      // 4a: aload 3
      // 4b: if_acmpeq 81
      // 4e: goto 52
      // 51: athrow
      // 52: aload 3
      // 53: goto 57
      // 56: athrow
      // 57: ifnull 6e
      // 5a: aload 1
      // 5b: iload 2
      // 5c: ifne 73
      // 5f: goto 63
      // 62: athrow
      // 63: aload 3
      // 64: getfield net/minecraft/entity/Entity.ridingEntity Lnet/minecraft/entity/Entity;
      // 67: if_acmpeq 81
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 1
      // 6f: goto 73
      // 72: athrow
      // 73: iload 2
      // 74: ifne 85
      // 77: getfield net/minecraft/entity/player/EntityPlayer.deathTime I
      // 7a: ifle 84
      // 7d: goto 81
      // 80: athrow
      // 81: bipush 0
      // 82: ireturn
      // 83: athrow
      // 84: aload 1
      // 85: invokestatic x/ocdc8e6f6a42.Ѻ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 88: iload 2
      // 89: ifne a5
      // 8c: ifeq 96
      // 8f: goto 93
      // 92: athrow
      // 93: bipush 0
      // 94: ireturn
      // 95: athrow
      // 96: aload 0
      // 97: getfield x/oc3c7a892f2f.Ĕ Lx/occ2f8dff8d8;
      // 9a: iload 2
      // 9b: ifne c3
      // 9e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // a1: goto a5
      // a4: athrow
      // a5: ifeq bb
      // a8: aload 1
      // a9: invokestatic x/ocdc8e6f6a42.Ę (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // ac: iload 2
      // ad: ifne c6
      // b0: goto b4
      // b3: athrow
      // b4: ifne e8
      // b7: goto bb
      // ba: athrow
      // bb: aload 0
      // bc: getfield x/oc3c7a892f2f.Ğ Lx/occ2f8dff8d8;
      // bf: goto c3
      // c2: athrow
      // c3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // c6: iload 2
      // c7: ifne e5
      // ca: ifeq e4
      // cd: goto d1
      // d0: athrow
      // d1: aload 1
      // d2: invokestatic x/ocdc8e6f6a42.ʉ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // d5: iload 2
      // d6: ifne e5
      // d9: goto dd
      // dc: athrow
      // dd: ifne e8
      // e0: goto e4
      // e3: athrow
      // e4: bipush 1
      // e5: goto e9
      // e8: bipush 0
      // e9: ireturn
   }

   List<EntityPlayer> Ս() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: new java/util/ArrayList
      // 06: dup
      // 07: invokespecial java/util/ArrayList.<init> ()V
      // 0a: astore 2
      // 0b: istore 1
      // 0c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f: iload 1
      // 10: ifne 23
      // 13: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 16: ifnonnull 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 2
      // 1e: areturn
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 26: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 29: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2e: astore 3
      // 2f: aload 3
      // 30: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 35: ifeq 7f
      // 38: aload 3
      // 39: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3e: checkcast net/minecraft/entity/Entity
      // 41: astore 4
      // 43: aload 4
      // 45: instanceof net/minecraft/entity/player/EntityPlayer
      // 48: iload 1
      // 49: ifne 60
      // 4c: ifeq 7b
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: aload 4
      // 56: checkcast net/minecraft/entity/player/EntityPlayer
      // 59: invokevirtual x/oc3c7a892f2f.Շ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 5c: goto 60
      // 5f: athrow
      // 60: iload 1
      // 61: ifne 7a
      // 64: ifeq 7b
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 2
      // 6c: aload 4
      // 6e: checkcast net/minecraft/entity/player/EntityPlayer
      // 71: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 76: goto 7a
      // 79: athrow
      // 7a: pop
      // 7b: iload 1
      // 7c: ifeq 2f
      // 7f: aload 2
      // 80: areturn
   }

   private EntityPlayer Ƥ(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 24
      // 09: getfield x/oc3c7a892f2f.Ğ Lx/occ2f8dff8d8;
      // 0c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f: ifeq 23
      // 12: goto 16
      // 15: athrow
      // 16: dload 1
      // 17: aload 0
      // 18: getfield x/oc3c7a892f2f.Ĕ Lx/occ2f8dff8d8;
      // 1b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1e: invokestatic x/oc5e08d6b90f.ß (DZ)Lnet/minecraft/entity/player/EntityPlayer;
      // 21: areturn
      // 22: athrow
      // 23: aload 0
      // 24: dload 1
      // 25: invokevirtual x/oc3c7a892f2f.գ (D)Lnet/minecraft/entity/player/EntityPlayer;
      // 28: astore 4
      // 2a: aload 4
      // 2c: iload 3
      // 2d: ifne 39
      // 30: ifnull 3a
      // 33: goto 37
      // 36: athrow
      // 37: aload 4
      // 39: areturn
      // 3a: aconst_null
      // 3b: astore 5
      // 3d: ldc2_w 1.7976931348623157E308
      // 40: dstore 6
      // 42: aload 0
      // 43: invokevirtual x/oc3c7a892f2f.Ս ()Ljava/util/List;
      // 46: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 4b: astore 8
      // 4d: aload 8
      // 4f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 54: ifeq 8a
      // 57: aload 8
      // 59: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 5e: checkcast net/minecraft/entity/player/EntityPlayer
      // 61: iload 3
      // 62: ifne 8c
      // 65: astore 9
      // 67: iload 3
      // 68: aload 9
      // 6a: invokestatic x/oc75d51ec7eb.Ώ (Lnet/minecraft/entity/Entity;)D
      // 6d: dstore 10
      // 6f: ifne 82
      // 72: dload 10
      // 74: dload 6
      // 76: dcmpg
      // 77: ifge 86
      // 7a: goto 7e
      // 7d: athrow
      // 7e: dload 10
      // 80: dstore 6
      // 82: aload 9
      // 84: astore 5
      // 86: iload 3
      // 87: ifeq 4d
      // 8a: aload 5
      // 8c: areturn
   }

   private EntityPlayer գ(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 3
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 3
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0e: ifnull 4b
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 3
      // 1d: ifne 37
      // 20: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 23: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 26: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.ENTITY Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 29: if_acmpne 4b
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: goto 37
      // 36: athrow
      // 37: iload 3
      // 38: ifne 51
      // 3b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 3e: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 41: instanceof net/minecraft/entity/player/EntityPlayer
      // 44: ifne 4e
      // 47: goto 4b
      // 4a: athrow
      // 4b: aconst_null
      // 4c: areturn
      // 4d: athrow
      // 4e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 51: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 54: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 57: checkcast net/minecraft/entity/player/EntityPlayer
      // 5a: astore 4
      // 5c: aload 0
      // 5d: aload 4
      // 5f: invokevirtual x/oc3c7a892f2f.Շ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 62: iload 3
      // 63: ifne 80
      // 66: ifeq 88
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 4
      // 6f: iload 3
      // 70: ifne 85
      // 73: goto 77
      // 76: athrow
      // 77: invokestatic x/oc75d51ec7eb.Ώ (Lnet/minecraft/entity/Entity;)D
      // 7a: dload 1
      // 7b: dcmpg
      // 7c: goto 80
      // 7f: athrow
      // 80: ifgt 88
      // 83: aload 4
      // 85: goto 89
      // 88: aconst_null
      // 89: areturn
   }

   private boolean հ(Packet<?> var1) {
      ItemStack var3 = null;
      int var4 = -1907721402 ^ 1683348179;
      int var2 = oc5e549848f3.İ;

      while (true) {
         switch (var4) {
            case -944290764:
               return false;
            case -902607188:
               int var12;
               label108: {
                  label107: {
                     try {
                        var12 = var1 instanceof C08PacketPlayerBlockPlacement;
                        if (var2 != 0) {
                           break label108;
                        }

                        if (var12 == 0) {
                           break label107;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var4 = 1763948890 ^ 1683348179;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var12 = -1297759629 ^ 1683348179;
               }

               var4 = var12;
               if (var2 == 0) {
                  continue;
               }

               return false;
            case -688908128:
               return false;
            case -619354618:
               return false;
            case -367025771:
               int var11;
               label128: {
                  label127: {
                     try {
                        var11 = var1 instanceof C02PacketUseEntity;
                        if (var2 != 0) {
                           break label128;
                        }

                        if (var11 == 0) {
                           break label127;
                        }
                     } catch (ocbde1165e4e var9) {
                        throw var9;
                     }

                     var4 = 709423193 ^ 1683348179;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var11 = -1981457149 ^ 1683348179;
               }

               var4 = var11;
               if (var2 == 0) {
                  continue;
               }
            case 1063844848:
               if (((C07PacketPlayerDigging)var1).getStatus() != Action.RELEASE_USE_ITEM) {
                  var4 = 537184930 ^ 1683348179;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var4 = -1086276395 ^ 1683348179;
               if (var2 == 0) {
                  continue;
               }
               break;
            case -307198000:
               int var10;
               label89: {
                  label88: {
                     try {
                        var10 = var1 instanceof C07PacketPlayerDigging;
                        if (var2 != 0) {
                           break label89;
                        }

                        if (var10 == 0) {
                           break label88;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 1530732835 ^ 1683348179;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10 = -1369009025 ^ 1683348179;
               }

               var4 = var10;
               if (var2 != 0) {
                  return true;
               }
               continue;
            case -112933826:
               return true;
            case 225862537:
               break;
            case 1146163313:
               return true;
            case 1310534282:
               return true;
            case 1516405251:
               int var10000;
               label80: {
                  label79: {
                     try {
                        var10000 = var3.getItem() instanceof ItemSword;
                        if (var2 != 0) {
                           break label80;
                        }

                        if (var10000 != 0) {
                           break label79;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = -1659822355 ^ 1683348179;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = -1545429273 ^ 1683348179;
               }

               var4 = var10000;
               if (var2 != 0) {
                  return true;
               }
               continue;
            default:
               throw null;
         }

         var3 = ((C08PacketPlayerBlockPlacement)var1).getStack();

         label98: {
            label97: {
               try {
                  if (var2 != 0) {
                     break label98;
                  }

                  if (var3 == null) {
                     break label97;
                  }
               } catch (ocbde1165e4e var7) {
                  throw var7;
               }

               var4 = 1043814608 ^ 1683348179;
               if (var2 == 0) {
                  continue;
               }
            }

            var4 = -1659822355 ^ 1683348179;
         }

         if (var2 != 0) {
            return false;
         }
      }
   }

   private boolean Κ(EntityPlayer var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = 1313560266 ^ -1613830029;

      while (true) {
         switch (var3) {
            case -1537390987:
               return true;
            case -779764039:
               if (this.ȗ != null) {
                  var3 = -768088182 ^ -1613830029;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -1873759522 ^ -1613830029;
               if (var2 == 0) {
                  break;
               }
            case 1308168185:
               if (var1 == null) {
                  var3 = -1873759522 ^ -1613830029;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 472166043 ^ -1613830029;
               if (var2 == 0) {
                  break;
               }
            case -2081798424:
               int var10000;
               label56: {
                  label55: {
                     try {
                        var10000 = this.ȗ.getEntityId();
                        if (var2 != 0) {
                           break label56;
                        }

                        if (var10000 != var1.getEntityId()) {
                           break label55;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 999534086 ^ -1613830029;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -458921111 ^ -1613830029;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 262036141:
               if (this.ȗ == var1) {
                  var3 = -837298755 ^ -1613830029;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 1636679450 ^ -1613830029;
               if (var2 == 0) {
                  break;
               }

               return false;
            case -29141143:
               return false;
            case 1373191630:
               return true;
            case 2070643482:
               return false;
            default:
               throw null;
         }
      }
   }

   private Vec3 Ȓ() {
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
      // 05: getfield x/oc3c7a892f2f.ђ Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2i
      // 0c: ifne 2e
      // 0f: getstatic x/oc2cf3d80e17.Ҿ Lx/oc61f27421d1;
      // 12: iload 1
      // 13: ifne 24
      // 16: goto 1a
      // 19: athrow
      // 1a: ifnull 2a
      // 1d: goto 21
      // 20: athrow
      // 21: getstatic x/oc2cf3d80e17.Ҿ Lx/oc61f27421d1;
      // 24: invokevirtual x/oc61f27421d1.ù ()Lnet/minecraft/util/Vec3;
      // 27: goto 46
      // 2a: aconst_null
      // 2b: goto 46
      // 2e: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 31: iload 1
      // 32: ifne 3f
      // 35: ifnull 45
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 3f: invokevirtual x/oc8da5ba227c.ɗ ()Lnet/minecraft/util/Vec3;
      // 42: goto 46
      // 45: aconst_null
      // 46: astore 2
      // 47: aload 2
      // 48: iload 1
      // 49: ifne 54
      // 4c: ifnull 57
      // 4f: goto 53
      // 52: athrow
      // 53: aload 2
      // 54: goto 79
      // 57: new net/minecraft/util/Vec3
      // 5a: dup
      // 5b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 61: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 64: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 67: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6a: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 6d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 70: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 73: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 76: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 79: areturn
   }

   private boolean ƅ() {
      int var1 = oc5e549848f3.İ;
      int var2 = 1715265260 ^ -53031313;

      while (true) {
         label86:
         while (true) {
            switch (var2) {
               case -1766149174:
                  if (oc69da1aa7f5.ő.theWorld != null) {
                     var2 = 1101544948 ^ -53031313;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var2 = -950759220 ^ -53031313;
                  if (var1 != 0) {
                     return false;
                  }
                  continue;
               case -1695936381:
                  int var10000;
                  label73: {
                     label72: {
                        try {
                           var10000 = oc69da1aa7f5.ő.isSingleplayer();
                           if (var1 != 0) {
                              break label73;
                           }

                           if (var10000 != 0) {
                              break label72;
                           }
                        } catch (ocbde1165e4e var4) {
                           throw var4;
                        }

                        var2 = 12776196 ^ -53031313;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10000 = -950759220 ^ -53031313;
                  }

                  var2 = var10000;
                  if (var1 == 0) {
                     continue;
                  }
               case -1691145025:
                  int var5;
                  label62: {
                     label61: {
                        try {
                           var5 = oc69da1aa7f5.ő.thePlayer.isDead;
                           if (var1 != 0) {
                              break label62;
                           }

                           if (oc69da1aa7f5.ő.thePlayer.isDead) {
                              break label61;
                           }
                        } catch (ocbde1165e4e var3) {
                           throw var3;
                        }

                        var2 = 1420670578 ^ -53031313;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var5 = -950759220 ^ -53031313;
                  }

                  var2 = var5;
                  if (var1 == 0) {
                     continue;
                  }
                  break;
               case -1468303331:
                  return true;
               case -1115753573:
                  break;
               case -65782421:
                  break label86;
               case 998399651:
                  return false;
               default:
                  throw null;
            }

            if (oc69da1aa7f5.ő.getNetHandler() != null) {
               var2 = 1743119056 ^ -53031313;
               if (var1 == 0) {
                  continue;
               }
            }

            var2 = -950759220 ^ -53031313;
            if (var1 != 0) {
               break;
            }
         }

         if (oc69da1aa7f5.ő.thePlayer != null) {
            var2 = 1785494949 ^ -53031313;
            if (var1 == 0) {
               continue;
            }
         }

         var2 = -950759220 ^ -53031313;
      }
   }

   public void յ() {
      this.ΰ();
   }

   private boolean ΰ() {
      int var1 = oc5e549848f3.İ;
      int var2 = 358701360 ^ 840232467;

      while (true) {
         switch (var2) {
            case -1009216732:
               return true;
            case 1132866747:
               int var5;
               label39: {
                  label38: {
                     try {
                        var5 = this.Ǻ;
                        if (var1 != 0) {
                           break label39;
                        }

                        if (this.Ǻ) {
                           break label38;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1333946140 ^ 840232467;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = -238256841 ^ 840232467;
               }

               var2 = var5;
               break;
            case 2107017487:
               this.Ѻ(true);
               this.Ǻ = true;
               var2 = -238256841 ^ 840232467;
               if (var1 == 0) {
                  break;
               }
            case 662026019:
               int var10000;
               label48: {
                  label47: {
                     try {
                        var10000 = oc51fb428ba0.ȃ();
                        if (var1 != 0) {
                           break label48;
                        }

                        if (var10000 != 0) {
                           break label47;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 840118822 ^ 840232467;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1905443496 ^ 840232467;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 515125:
               this.Ǻ = false;
               return false;
            default:
               throw null;
         }
      }
   }

   private void Օ() {
      this.ȗ = null;
      this.ž = -1.0;
      this.ʝ = false;
      this.ԝ = 0;
      this.Ӛ = 0;
      this.ſ = -1;
      this.ώ = false;
      this.Ď = false;
      this.Ü = null;
      this.Ѝ = false;
      this.ղ = null;
      this.ƃ = null;
      this.ͻ = -1;
      this.Ά = 0L;
      this.ʴ = 0;
   }

   private boolean Ŀ() {
      int var1 = oc5e549848f3.İ;
      int var2 = -2011035073 ^ 5608081;

      while (true) {
         switch (var2) {
            case -2005428050:
               int var10000;
               label40: {
                  label39: {
                     try {
                        var10000 = this.ʴ;
                        if (var1 != 0) {
                           break label40;
                        }

                        if (this.ʴ > 0) {
                           break label39;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -857151540 ^ 5608081;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 354117531 ^ 5608081;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }

               return true;
            case -859998883:
               return false;
            case 357496074:
               label52: {
                  label51: {
                     try {
                        this.ʴ--;
                        this.ͻ = -1;
                        if (var1 != 0) {
                           break label52;
                        }

                        this.Ѝ = false;
                        if (oc2cf3d80e17.ʭ == null) {
                           break label51;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 825211856 ^ 5608081;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var2 = 1035027368 ^ 5608081;
               }

               if (var1 == 0) {
                  break;
               }
            case 830089537:
               oc2cf3d80e17.ʭ.Ͱ(0);
               var2 = 1035027368 ^ 5608081;
               if (var1 == 0) {
                  break;
               }

               return false;
            case 1038405945:
               return true;
            default:
               throw null;
         }
      }
   }

   private void Ѻ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: invokevirtual x/oc3c7a892f2f.ã ()V
      // 07: istore 2
      // 08: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 0b: iload 2
      // 0c: ifne 19
      // 0f: ifnull 1d
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/oc2cf3d80e17.ʭ Lx/oc020457c099;
      // 19: bipush 0
      // 1a: invokevirtual x/oc020457c099.Ͱ (I)V
      // 1d: getstatic x/oc2cf3d80e17.Ҿ Lx/oc61f27421d1;
      // 20: iload 2
      // 21: ifne 2e
      // 24: ifnull 48
      // 27: goto 2b
      // 2a: athrow
      // 2b: getstatic x/oc2cf3d80e17.Ҿ Lx/oc61f27421d1;
      // 2e: iload 1
      // 2f: ifeq 44
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 38: ifnull 44
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush 1
      // 40: goto 45
      // 43: athrow
      // 44: bipush 0
      // 45: invokevirtual x/oc61f27421d1.Ћ (Z)V
      // 48: aload 0
      // 49: invokevirtual x/oc3c7a892f2f.Օ ()V
      // 4c: return
   }

   static {
      String[] var10000 = new String[-1199176218 ^ -1199176220];
      var10000[0] = "Delay";
      var10000[1] = "Lag";
      բ = var10000;
      var10000 = new String[-1199176217 ^ -1199176220];
      var10000[0] = "None";
      var10000[1] = "Default";
      var10000[-1199176218 ^ -1199176220] = "HUD";
      Ȥ = var10000;
   }
}
