package x;

import java.util.ArrayDeque;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ocbbcd2a57ff {
   @NotNull
   private final ocd3f0e2b0b5 S;
   @NotNull
   private final ocd3f0e2b0b5 Ǽ;
   public static int Ӊ;

   public ocbbcd2a57ff(@NotNull ocacfd09d720 var1) {
      this.S = new ocd3f0e2b0b5(new ArrayDeque<>(), var1);
      this.Ǽ = new ocd3f0e2b0b5(new ArrayDeque<>(), var1);
   }

   public void ӆ() {
      this.S.σ();
      this.Ǽ.σ();
   }

   public boolean ә(@Nullable Packet<?> param1, @Nullable oc2f60cd9d1e param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: istore 3
      // 04: aload 1
      // 05: ifnonnull 0d
      // 08: bipush 1
      // 09: goto 0e
      // 0c: athrow
      // 0d: bipush 0
      // 0e: aload 2
      // 0f: ifnonnull 17
      // 12: bipush 1
      // 13: goto 18
      // 16: athrow
      // 17: bipush 0
      // 18: if_icmpeq 24
      // 1b: new java/lang/NullPointerException
      // 1e: dup
      // 1f: invokespecial java/lang/NullPointerException.<init> ()V
      // 22: athrow
      // 23: athrow
      // 24: aload 2
      // 25: ifnonnull 3f
      // 28: aload 0
      // 29: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 2c: aconst_null
      // 2d: aconst_null
      // 2e: invokevirtual x/ocd3f0e2b0b5.с (Lnet/minecraft/network/Packet;Lx/oc2f60cd9d1e;)Z
      // 31: pop
      // 32: aload 0
      // 33: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 36: aconst_null
      // 37: aconst_null
      // 38: invokevirtual x/ocd3f0e2b0b5.с (Lnet/minecraft/network/Packet;Lx/oc2f60cd9d1e;)Z
      // 3b: pop
      // 3c: bipush 0
      // 3d: ireturn
      // 3e: athrow
      // 3f: getstatic x/oc67db2ec5ea.ў [I
      // 42: aload 2
      // 43: invokevirtual java/lang/Enum.ordinal ()I
      // 46: iaload
      // 47: iload 3
      // 48: ifne 7b
      // 4b: lookupswitch 47 2 1 26 2 37
      // 64: athrow
      // 65: aload 0
      // 66: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 69: aload 1
      // 6a: aload 2
      // 6b: invokevirtual x/ocd3f0e2b0b5.с (Lnet/minecraft/network/Packet;Lx/oc2f60cd9d1e;)Z
      // 6e: ireturn
      // 6f: athrow
      // 70: aload 0
      // 71: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 74: aload 1
      // 75: aload 2
      // 76: invokevirtual x/ocd3f0e2b0b5.с (Lnet/minecraft/network/Packet;Lx/oc2f60cd9d1e;)Z
      // 79: ireturn
      // 7a: bipush 0
      // 7b: iload 3
      // 7c: ifeq 90
      // 7f: bipush 0
      // 80: ifeq 8c
      // 83: goto 87
      // 86: athrow
      // 87: bipush 0
      // 88: goto 8d
      // 8b: athrow
      // 8c: bipush 1
      // 8d: putstatic x/oc69da1aa7f5.Ҭ Z
      // 90: ireturn
   }

   public void Ǟ(@NotNull oc3d1d10e2c1 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: aload 1
      // 04: invokevirtual x/oc3d1d10e2c1.Ś ()Ljava/util/Set;
      // 07: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0c: astore 3
      // 0d: istore 2
      // 0e: aload 3
      // 0f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14: ifeq 69
      // 17: aload 3
      // 18: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1d: checkcast x/oc2f60cd9d1e
      // 20: astore 4
      // 22: iload 2
      // 23: ifne 55
      // 26: getstatic x/oc67db2ec5ea.ў [I
      // 29: aload 4
      // 2b: invokevirtual java/lang/Enum.ordinal ()I
      // 2e: iaload
      // 2f: lookupswitch 54 2 1 42 2 26
      // 48: athrow
      // 49: aload 0
      // 4a: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 4d: aload 1
      // 4e: invokevirtual x/ocd3f0e2b0b5.Ĉ (Lx/oc3d1d10e2c1;)V
      // 51: goto 55
      // 54: athrow
      // 55: iload 2
      // 56: ifeq 65
      // 59: aload 0
      // 5a: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 5d: aload 1
      // 5e: invokevirtual x/ocd3f0e2b0b5.Ĉ (Lx/oc3d1d10e2c1;)V
      // 61: goto 65
      // 64: athrow
      // 65: iload 2
      // 66: ifeq 0e
      // 69: return
   }

   public int ц(@NotNull oc2f60cd9d1e param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: istore 2
      // 04: getstatic x/oc67db2ec5ea.ў [I
      // 07: aload 1
      // 08: invokevirtual java/lang/Enum.ordinal ()I
      // 0b: iaload
      // 0c: iload 2
      // 0d: ifne 3f
      // 10: lookupswitch 46 2 1 38 2 29
      // 2c: athrow
      // 2d: aload 0
      // 2e: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 31: invokevirtual x/ocd3f0e2b0b5.ό ()I
      // 34: ireturn
      // 35: athrow
      // 36: aload 0
      // 37: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 3a: invokevirtual x/ocd3f0e2b0b5.ό ()I
      // 3d: ireturn
      // 3e: bipush 0
      // 3f: ireturn
   }

   public void Р(@NotNull oc2f60cd9d1e param1, @NotNull oc3d1d10e2c1 param2, long param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: istore 5
      // 05: getstatic x/oc67db2ec5ea.ў [I
      // 08: aload 1
      // 09: invokevirtual java/lang/Enum.ordinal ()I
      // 0c: iaload
      // 0d: lookupswitch 58 2 1 45 2 27
      // 28: aload 0
      // 29: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 2c: aload 2
      // 2d: lload 3
      // 2e: invokevirtual x/ocd3f0e2b0b5.ψ (Lx/oc3d1d10e2c1;J)V
      // 31: iload 5
      // 33: ifeq 47
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 0
      // 3b: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 3e: aload 2
      // 3f: lload 3
      // 40: invokevirtual x/ocd3f0e2b0b5.ψ (Lx/oc3d1d10e2c1;J)V
      // 43: goto 47
      // 46: athrow
      // 47: return
   }

   public int ʡ(@NotNull oc2f60cd9d1e param1, @NotNull oc3d1d10e2c1 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: istore 3
      // 04: getstatic x/oc67db2ec5ea.ў [I
      // 07: aload 1
      // 08: invokevirtual java/lang/Enum.ordinal ()I
      // 0b: iaload
      // 0c: iload 3
      // 0d: ifne 41
      // 10: lookupswitch 48 2 1 39 2 29
      // 2c: athrow
      // 2d: aload 0
      // 2e: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 31: aload 2
      // 32: invokevirtual x/ocd3f0e2b0b5.Ɉ (Lx/oc3d1d10e2c1;)I
      // 35: ireturn
      // 36: athrow
      // 37: aload 0
      // 38: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 3b: aload 2
      // 3c: invokevirtual x/ocd3f0e2b0b5.Ɉ (Lx/oc3d1d10e2c1;)I
      // 3f: ireturn
      // 40: bipush 0
      // 41: ireturn
   }

   public boolean ʅ(@NotNull oc2f60cd9d1e param1, @NotNull oc3d1d10e2c1 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: istore 3
      // 04: getstatic x/oc67db2ec5ea.ў [I
      // 07: aload 1
      // 08: invokevirtual java/lang/Enum.ordinal ()I
      // 0b: iaload
      // 0c: iload 3
      // 0d: ifne 41
      // 10: lookupswitch 48 2 1 39 2 29
      // 2c: athrow
      // 2d: aload 0
      // 2e: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 31: aload 2
      // 32: invokevirtual x/ocd3f0e2b0b5.Ԗ (Lx/oc3d1d10e2c1;)Z
      // 35: ireturn
      // 36: athrow
      // 37: aload 0
      // 38: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 3b: aload 2
      // 3c: invokevirtual x/ocd3f0e2b0b5.Ԗ (Lx/oc3d1d10e2c1;)Z
      // 3f: ireturn
      // 40: bipush 1
      // 41: ireturn
   }

   public void Ζ(@NotNull oc3d1d10e2c1 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: aload 1
      // 04: invokevirtual x/oc3d1d10e2c1.Ś ()Ljava/util/Set;
      // 07: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0c: astore 3
      // 0d: istore 2
      // 0e: aload 3
      // 0f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14: ifeq 69
      // 17: aload 3
      // 18: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1d: checkcast x/oc2f60cd9d1e
      // 20: astore 4
      // 22: iload 2
      // 23: ifne 55
      // 26: getstatic x/oc67db2ec5ea.ў [I
      // 29: aload 4
      // 2b: invokevirtual java/lang/Enum.ordinal ()I
      // 2e: iaload
      // 2f: lookupswitch 54 2 1 42 2 26
      // 48: athrow
      // 49: aload 0
      // 4a: getfield x/ocbbcd2a57ff.Ǽ Lx/ocd3f0e2b0b5;
      // 4d: aload 1
      // 4e: invokevirtual x/ocd3f0e2b0b5.Û (Lx/oc3d1d10e2c1;)V
      // 51: goto 55
      // 54: athrow
      // 55: iload 2
      // 56: ifeq 65
      // 59: aload 0
      // 5a: getfield x/ocbbcd2a57ff.S Lx/ocd3f0e2b0b5;
      // 5d: aload 1
      // 5e: invokevirtual x/ocd3f0e2b0b5.Û (Lx/oc3d1d10e2c1;)V
      // 61: goto 65
      // 64: athrow
      // 65: iload 2
      // 66: ifeq 0e
      // 69: bipush 0
      // 6a: ifeq 78
      // 6d: iinc 2 1
      // 70: iload 2
      // 71: putstatic x/ocbbcd2a57ff.Ӊ I
      // 74: goto 78
      // 77: athrow
      // 78: return
   }
}
