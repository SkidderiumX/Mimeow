package x;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;

public class oc2c637ab2aa extends oc69da1aa7f5 {
   private final oca9cc61aada Η;
   private final oca9cc61aada Ȁ;
   private final Set<EntityLargeFireball> Ғ = new HashSet<>();
   private EntityFireball Ǚ;
   private EntityFireball Л;
   public static boolean Ӱ;

   public oc2c637ab2aa() {
      super("AntiFireball", oce4cea752dd.ȁ);
      this.ą("Automatically hits nearby enemy fireballs.");
      this.ʌ(this.Η = new oca9cc61aada("FOV", 360.0, 20.0, 360.0, 5.0));
      this.ʌ(this.Ȁ = new oca9cc61aada("Range", 10.0, 3.0, 20.0, 0.5));
   }

   @Override
   public void onEnable() {
      int var10000 = oc5e549848f3.İ;
      this.ր();
      int var1 = var10000;
      if (oc7ab2161b9f.Ð()) {
         for (Entity var3 : oc69da1aa7f5.ő.theWorld.loadedEntityList) {
            this.v(var3);
            if (var1 != 0) {
               break;
            }
         }
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void ĭ(oc2f61de30bc param1) {
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
      // 06: ifne 29
      // 09: aconst_null
      // 0a: putfield x/oc2c637ab2aa.Л Lnet/minecraft/entity/projectile/EntityFireball;
      // 0d: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 10: ifeq 24
      // 13: goto 17
      // 16: athrow
      // 17: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 1d: ifnull 2e
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: goto 29
      // 28: athrow
      // 29: aconst_null
      // 2a: putfield x/oc2c637ab2aa.Ǚ Lnet/minecraft/entity/projectile/EntityFireball;
      // 2d: return
      // 2e: aload 0
      // 2f: getfield x/oc2c637ab2aa.Ғ Ljava/util/Set;
      // 32: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, x/oc2c637ab2aa.q3u82xua3z3jf8 (Lnet/minecraft/entity/projectile/EntityLargeFireball;)Z, (Lnet/minecraft/entity/projectile/EntityLargeFireball;)Z ]
      // 37: invokeinterface java/util/Set.removeIf (Ljava/util/function/Predicate;)Z 2
      // 3c: iload 2
      // 3d: ifne 67
      // 40: pop
      // 41: aload 0
      // 42: aload 0
      // 43: invokevirtual x/oc2c637ab2aa.i ()Lnet/minecraft/entity/projectile/EntityFireball;
      // 46: putfield x/oc2c637ab2aa.Ǚ Lnet/minecraft/entity/projectile/EntityFireball;
      // 49: aload 0
      // 4a: getfield x/oc2c637ab2aa.Ǚ Lnet/minecraft/entity/projectile/EntityFireball;
      // 4d: ifnull 76
      // 50: goto 54
      // 53: athrow
      // 54: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 57: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5a: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 5d: ldc 1419440606
      // 5f: ldc 1419440604
      // 61: ixor
      // 62: irem
      // 63: goto 67
      // 66: athrow
      // 67: ifne 76
      // 6a: aload 0
      // 6b: aload 0
      // 6c: getfield x/oc2c637ab2aa.Ǚ Lnet/minecraft/entity/projectile/EntityFireball;
      // 6f: putfield x/oc2c637ab2aa.Л Lnet/minecraft/entity/projectile/EntityFireball;
      // 72: goto 76
      // 75: athrow
      // 76: return
   }

   private EntityFireball i() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: getfield x/oc2c637ab2aa.Ȁ Lx/oca9cc61aada;
      // 07: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a: aload 0
      // 0b: getfield x/oc2c637ab2aa.Ȁ Lx/oca9cc61aada;
      // 0e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 11: dmul
      // 12: dstore 2
      // 13: istore 1
      // 14: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1a: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 1d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 22: astore 4
      // 24: aload 4
      // 26: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2b: ifeq cf
      // 2e: aload 4
      // 30: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 35: checkcast net/minecraft/entity/Entity
      // 38: astore 5
      // 3a: aload 5
      // 3c: instanceof net/minecraft/entity/projectile/EntityLargeFireball
      // 3f: iload 1
      // 40: ifne 59
      // 43: ifeq cb
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: getfield x/oc2c637ab2aa.Ғ Ljava/util/Set;
      // 4e: aload 5
      // 50: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 55: goto 59
      // 58: athrow
      // 59: iload 1
      // 5a: ifne 75
      // 5d: ifeq cb
      // 60: goto 64
      // 63: athrow
      // 64: aload 5
      // 66: iload 1
      // 67: ifne 7a
      // 6a: goto 6e
      // 6d: athrow
      // 6e: getfield net/minecraft/entity/Entity.isDead Z
      // 71: goto 75
      // 74: athrow
      // 75: ifne cb
      // 78: aload 5
      // 7a: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 7d: iload 1
      // 7e: ifne a1
      // 81: ifeq cb
      // 84: goto 88
      // 87: athrow
      // 88: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 8b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8e: aload 5
      // 90: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 93: iload 1
      // 94: ifne b6
      // 97: goto 9b
      // 9a: athrow
      // 9b: dload 2
      // 9c: dcmpg
      // 9d: goto a1
      // a0: athrow
      // a1: ifgt cb
      // a4: aload 5
      // a6: iload 1
      // a7: ifne c7
      // aa: goto ae
      // ad: athrow
      // ae: invokestatic x/oc75d51ec7eb.ɟ (Lnet/minecraft/entity/Entity;)F
      // b1: f2d
      // b2: goto b6
      // b5: athrow
      // b6: aload 0
      // b7: getfield x/oc2c637ab2aa.Η Lx/oca9cc61aada;
      // ba: invokevirtual x/oca9cc61aada.Ӂ ()D
      // bd: dcmpg
      // be: ifgt cb
      // c1: aload 5
      // c3: goto c7
      // c6: athrow
      // c7: checkcast net/minecraft/entity/projectile/EntityFireball
      // ca: areturn
      // cb: iload 1
      // cc: ifeq 24
      // cf: aconst_null
      // d0: areturn
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void ͱ(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: ifeq 17
      // 0a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 10: ifnull 19
      // 13: goto 17
      // 16: athrow
      // 17: return
      // 18: athrow
      // 19: aload 0
      // 1a: aload 0
      // 1b: invokevirtual x/oc2c637ab2aa.i ()Lnet/minecraft/entity/projectile/EntityFireball;
      // 1e: putfield x/oc2c637ab2aa.Ǚ Lnet/minecraft/entity/projectile/EntityFireball;
      // 21: aload 0
      // 22: iload 2
      // 23: ifne 36
      // 26: getfield x/oc2c637ab2aa.Ǚ Lnet/minecraft/entity/projectile/EntityFireball;
      // 29: invokestatic x/ocd84af7ddf8.Ӧ (Lnet/minecraft/entity/Entity;)Z
      // 2c: ifne 35
      // 2f: goto 33
      // 32: athrow
      // 33: return
      // 34: athrow
      // 35: aload 0
      // 36: getfield x/oc2c637ab2aa.Ǚ Lnet/minecraft/entity/projectile/EntityFireball;
      // 39: aconst_null
      // 3a: invokestatic x/ocffa9e799de.Ð (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)[F
      // 3d: astore 3
      // 3e: aload 3
      // 3f: bipush 0
      // 40: faload
      // 41: aload 3
      // 42: bipush 1
      // 43: faload
      // 44: getstatic x/oc75d51ec7eb.d [F
      // 47: bipush 0
      // 48: faload
      // 49: getstatic x/oc75d51ec7eb.d [F
      // 4c: bipush 1
      // 4d: faload
      // 4e: invokestatic x/oc75d51ec7eb.Ĩ (FFFF)[F
      // 51: astore 3
      // 52: aload 1
      // 53: iload 2
      // 54: ifne 78
      // 57: aload 0
      // 58: ldc 1925766766
      // 5a: ldc 1925766978
      // 5c: ixor
      // 5d: aload 3
      // 5e: bipush 0
      // 5f: faload
      // 60: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 63: aload 3
      // 64: bipush 1
      // 65: faload
      // 66: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 69: invokevirtual x/oc86de9e2892.л (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;)Z
      // 6c: ifeq 7c
      // 6f: goto 73
      // 72: athrow
      // 73: aload 1
      // 74: goto 78
      // 77: athrow
      // 78: bipush 1
      // 79: invokevirtual x/oc86de9e2892.ʐ (Z)V
      // 7c: return
   }

   @oc66fa4f2195
   public void Ů(oc0e4b758d9a param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: getfield x/oc2c637ab2aa.Л Lnet/minecraft/entity/projectile/EntityFireball;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 0
      // 0a: aconst_null
      // 0b: putfield x/oc2c637ab2aa.Л Lnet/minecraft/entity/projectile/EntityFireball;
      // 0e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 11: ifeq ae
      // 14: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17: iload 2
      // 18: ifne 30
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 22: ifnonnull ae
      // 25: goto 29
      // 28: athrow
      // 29: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2c: goto 30
      // 2f: athrow
      // 30: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 33: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isBlocking ()Z
      // 36: iload 2
      // 37: ifne 51
      // 3a: ifne ae
      // 3d: goto 41
      // 40: athrow
      // 41: aload 3
      // 42: iload 2
      // 43: ifne 55
      // 46: goto 4a
      // 49: athrow
      // 4a: invokestatic x/ocd84af7ddf8.Ӧ (Lnet/minecraft/entity/Entity;)Z
      // 4d: goto 51
      // 50: athrow
      // 51: ifeq ae
      // 54: aload 3
      // 55: getfield net/minecraft/entity/projectile/EntityFireball.isDead Z
      // 58: iload 2
      // 59: ifne 81
      // 5c: ifne ae
      // 5f: goto 63
      // 62: athrow
      // 63: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 66: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 69: aload 3
      // 6a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 6d: aload 0
      // 6e: getfield x/oc2c637ab2aa.Ȁ Lx/oca9cc61aada;
      // 71: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 74: aload 0
      // 75: getfield x/oc2c637ab2aa.Ȁ Lx/oca9cc61aada;
      // 78: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 7b: dmul
      // 7c: dcmpl
      // 7d: goto 81
      // 80: athrow
      // 81: iload 2
      // 82: ifne 8f
      // 85: ifgt ae
      // 88: goto 8c
      // 8b: athrow
      // 8c: getstatic x/ocb5d5ed49ea.ҋ Z
      // 8f: iload 2
      // 90: ifne 9d
      // 93: ifne ae
      // 96: goto 9a
      // 99: athrow
      // 9a: getstatic x/ocb5d5ed49ea.ƃ Z
      // 9d: iload 2
      // 9e: ifne ab
      // a1: ifne ae
      // a4: goto a8
      // a7: athrow
      // a8: getstatic x/ocb5d5ed49ea.Ӿ Z
      // ab: ifeq af
      // ae: return
      // af: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // b5: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // b8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // bb: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // be: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // c1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // c4: aload 3
      // c5: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.attackEntity (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;)V
      // c8: return
   }

   public boolean І() {
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
      // 05: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08: iload 1
      // 09: ifne 16
      // 0c: ifeq 36
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 16: ifeq 36
      // 19: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 1f: ifnonnull 36
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: invokevirtual x/oc2c637ab2aa.i ()Lnet/minecraft/entity/projectile/EntityFireball;
      // 2a: ifnull 36
      // 2d: goto 31
      // 30: athrow
      // 31: bipush 1
      // 32: goto 37
      // 35: athrow
      // 36: bipush 0
      // 37: ireturn
   }

   private void v(Entity param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 1a
      // 0b: ifeq 6e
      // 0e: goto 12
      // 11: athrow
      // 12: aload 1
      // 13: instanceof net/minecraft/entity/projectile/EntityLargeFireball
      // 16: goto 1a
      // 19: athrow
      // 1a: iload 2
      // 1b: ifne 28
      // 1e: ifeq 6e
      // 21: goto 25
      // 24: athrow
      // 25: invokestatic x/oc7ab2161b9f.ս ()Z
      // 28: ifne 6e
      // 2b: aload 1
      // 2c: checkcast net/minecraft/entity/projectile/EntityLargeFireball
      // 2f: getfield net/minecraft/entity/projectile/EntityLargeFireball.shootingEntity Lnet/minecraft/entity/EntityLivingBase;
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 38: if_acmpeq 6e
      // 3b: goto 3f
      // 3e: athrow
      // 3f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 42: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 45: aload 1
      // 46: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 49: ldc2_w 20.0
      // 4c: dcmpl
      // 4d: iload 2
      // 4e: ifne 6d
      // 51: goto 55
      // 54: athrow
      // 55: ifle 6e
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 0
      // 5d: getfield x/oc2c637ab2aa.Ғ Ljava/util/Set;
      // 60: aload 1
      // 61: checkcast net/minecraft/entity/projectile/EntityLargeFireball
      // 64: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 69: goto 6d
      // 6c: athrow
      // 6d: pop
      // 6e: return
   }

   @oc66fa4f2195
   public void ċ(ocadfd5cc157 param1) {
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
      // 05: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 08: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: if_acmpne 1d
      // 11: aload 0
      // 12: invokevirtual x/oc2c637ab2aa.ր ()V
      // 15: iload 2
      // 16: ifeq 29
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 0
      // 1e: aload 1
      // 1f: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 22: invokevirtual x/oc2c637ab2aa.v (Lnet/minecraft/entity/Entity;)V
      // 25: goto 29
      // 28: athrow
      // 29: return
   }

   @oc66fa4f2195
   public void ς(oce4fccf5a38 var1) {
      this.ր();
   }

   @oc66fa4f2195
   public void ʯ(ocbab3c9954b var1) {
      this.ր();
   }

   @Override
   public void onDisable() {
      this.ր();
   }

   private void ր() {
      this.Ғ.clear();
      this.Ǚ = null;
      this.Л = null;
   }
}
