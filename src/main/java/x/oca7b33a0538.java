package x;

import java.util.List;

public class oca7b33a0538 extends oc161f4adba4 {
   private final oc69da1aa7f5 ǉ;
   public static int Ї;

   public oca7b33a0538(oc69da1aa7f5 var1) {
      super(Ø(var1.z$3i8m9vxwuvqj0()), "View or change " + var1.z$3i8m9vxwuvqj0() + " settings.", oc17aaf5d285.ħ, ώ(var1), new String[0]);
      this.ǉ = var1;
   }

   public boolean ӆ() {
      try {
         if (this.ǉ.ъ() == oce4cea752dd.ռ) {
            return true;
         }
      } catch (NumberFormatException var1) {
         throw var1;
      }

      return false;
   }

   private static String[] ώ(oc69da1aa7f5 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: aload 0
      // 04: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 07: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 0a: astore 2
      // 0b: istore 1
      // 0c: new java/util/ArrayList
      // 0f: dup
      // 10: invokespecial java/util/ArrayList.<init> ()V
      // 13: astore 3
      // 14: aload 3
      // 15: aload 2
      // 16: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1b: pop
      // 1c: aload 0
      // 1d: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 20: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 23: astore 4
      // 25: aload 4
      // 27: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2c: ifeq 6d
      // 2f: aload 4
      // 31: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 36: checkcast x/N
      // 39: astore 5
      // 3b: aload 5
      // 3d: instanceof x/occc831eff22
      // 40: iload 1
      // 41: ifne 68
      // 44: ifne 69
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 3
      // 4c: aload 2
      // 4d: aload 5
      // 4f: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 52: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 55: ldc " "
      // 57: swap
      // 58: ldc " <value>"
      // 5a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 5f: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 64: goto 68
      // 67: athrow
      // 68: pop
      // 69: iload 1
      // 6a: ifeq 25
      // 6d: aload 3
      // 6e: bipush 0
      // 6f: anewarray 53
      // 72: invokeinterface java/util/List.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // 77: checkcast [Ljava/lang/String;
      // 7a: areturn
   }

   public void z$2uoow1halcq2f(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 08: ifne 11
      // 0b: aload 0
      // 0c: invokevirtual x/oca7b33a0538.ȣ ()V
      // 0f: return
      // 10: athrow
      // 11: aload 0
      // 12: aload 1
      // 13: bipush 0
      // 14: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 17: invokevirtual x/oca7b33a0538.ƨ (Ljava/lang/String;)Lx/N;
      // 1a: astore 3
      // 1b: iload 2
      // 1c: ifne 3d
      // 1f: aload 3
      // 20: ifnonnull 3e
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: aload 0
      // 29: invokevirtual x/oc161f4adba4.σ ()Ljava/lang/String;
      // 2c: ldc "&cUnknown setting. &7Use &b."
      // 2e: swap
      // 2f: ldc "&7 to list available settings."
      // 31: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 36: invokevirtual x/oc161f4adba4.å (Ljava/lang/String;)V
      // 39: goto 3d
      // 3c: athrow
      // 3d: return
      // 3e: aload 1
      // 3f: iload 2
      // 40: ifne 6a
      // 43: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 46: bipush 1
      // 47: if_icmpne 69
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: aload 3
      // 50: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 53: aload 0
      // 54: aload 3
      // 55: invokevirtual x/oca7b33a0538.Á (Lx/N;)Ljava/lang/String;
      // 58: ldc "&b"
      // 5a: dup_x2
      // 5b: pop
      // 5c: ldc "&7: "
      // 5e: swap
      // 5f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 64: invokevirtual x/oc161f4adba4.å (Ljava/lang/String;)V
      // 67: return
      // 68: athrow
      // 69: aload 1
      // 6a: bipush 1
      // 6b: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 6e: astore 4
      // 70: iload 2
      // 71: aload 0
      // 72: aload 3
      // 73: aload 4
      // 75: invokevirtual x/oca7b33a0538.ƕ (Lx/N;Ljava/lang/String;)Ljava/lang/String;
      // 78: astore 5
      // 7a: ifne c3
      // 7d: aload 5
      // 7f: ifnull 96
      // 82: goto 86
      // 85: athrow
      // 86: aload 0
      // 87: aload 5
      // 89: ldc "&c"
      // 8b: swap
      // 8c: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 91: invokevirtual x/oc161f4adba4.å (Ljava/lang/String;)V
      // 94: return
      // 95: athrow
      // 96: aload 0
      // 97: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // 9a: invokevirtual x/oc69da1aa7f5.z$2u87utkr1isxg ()V
      // 9d: aload 0
      // 9e: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // a1: aload 3
      // a2: invokevirtual x/oc69da1aa7f5.z$3tl278wzjcayb (Lx/N;)V
      // a5: invokestatic x/oc2cf3d80e17.ӫ ()V
      // a8: aload 0
      // a9: aload 3
      // aa: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // ad: aload 0
      // ae: aload 3
      // af: invokevirtual x/oca7b33a0538.Á (Lx/N;)Ljava/lang/String;
      // b2: ldc "&aSet &b"
      // b4: dup_x2
      // b5: pop
      // b6: ldc " &ato "
      // b8: swap
      // b9: ldc "&a."
      // bb: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // c0: invokevirtual x/oc161f4adba4.å (Ljava/lang/String;)V
      // c3: return
   }

   private void ȣ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: aload 0
      // 04: aload 0
      // 05: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // 08: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 0b: ldc "&7"
      // 0d: swap
      // 0e: ldc " settings"
      // 10: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 15: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 18: istore 1
      // 19: aload 0
      // 1a: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // 1d: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 20: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 23: astore 2
      // 24: aload 2
      // 25: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2a: ifeq 72
      // 2d: aload 2
      // 2e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 33: checkcast x/N
      // 36: astore 3
      // 37: iload 1
      // 38: ifne 84
      // 3b: iload 1
      // 3c: ifne 6e
      // 3f: goto 43
      // 42: athrow
      // 43: aload 3
      // 44: instanceof x/occc831eff22
      // 47: ifeq 52
      // 4a: goto 4e
      // 4d: athrow
      // 4e: goto 24
      // 51: athrow
      // 52: aload 0
      // 53: aload 3
      // 54: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 57: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 5a: aload 0
      // 5b: aload 3
      // 5c: invokevirtual x/oca7b33a0538.Á (Lx/N;)Ljava/lang/String;
      // 5f: ldc " &b"
      // 61: dup_x2
      // 62: pop
      // 63: ldc " &7= "
      // 65: swap
      // 66: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 6b: invokevirtual x/oc161f4adba4.å (Ljava/lang/String;)V
      // 6e: iload 1
      // 6f: ifeq 24
      // 72: aload 0
      // 73: aload 0
      // 74: invokevirtual x/oc161f4adba4.σ ()Ljava/lang/String;
      // 77: ldc "&7Usage: &b."
      // 79: swap
      // 7a: ldc " <setting> <value>"
      // 7c: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 81: invokevirtual x/oc161f4adba4.å (Ljava/lang/String;)V
      // 84: return
   }

   private String ƕ(N param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 3
      // 004: aload 1
      // 005: iload 3
      // 006: ifne 027
      // 009: instanceof x/oc321b4679dd
      // 00c: ifeq 026
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: checkcast x/oc321b4679dd
      // 017: astore 4
      // 019: aload 4
      // 01b: aload 2
      // 01c: invokevirtual x/oc321b4679dd.z$1bnplyl2p7uqx (Ljava/lang/String;)V
      // 01f: aload 4
      // 021: invokevirtual x/oc321b4679dd.ƺ ()V
      // 024: aconst_null
      // 025: areturn
      // 026: aload 1
      // 027: iload 3
      // 028: ifne 0d8
      // 02b: instanceof x/occ2f8dff8d8
      // 02e: ifeq 0d7
      // 031: goto 035
      // 034: athrow
      // 035: aload 1
      // 036: checkcast x/occ2f8dff8d8
      // 039: astore 4
      // 03b: aload 4
      // 03d: getfield x/occ2f8dff8d8.ӽ Z
      // 040: iload 3
      // 041: ifne 05d
      // 044: ifeq 083
      // 047: goto 04b
      // 04a: athrow
      // 04b: aload 2
      // 04c: ldc "run"
      // 04e: iload 3
      // 04f: ifne 06f
      // 052: goto 056
      // 055: athrow
      // 056: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 059: goto 05d
      // 05c: athrow
      // 05d: ifne 07c
      // 060: aload 2
      // 061: iload 3
      // 062: ifne 07b
      // 065: goto 069
      // 068: athrow
      // 069: ldc "press"
      // 06b: goto 06f
      // 06e: athrow
      // 06f: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 072: ifne 07c
      // 075: ldc "Use 'run' for this action setting."
      // 077: goto 07b
      // 07a: athrow
      // 07b: areturn
      // 07c: aload 4
      // 07e: invokevirtual x/occ2f8dff8d8.ը ()V
      // 081: aconst_null
      // 082: areturn
      // 083: aload 0
      // 084: aload 2
      // 085: invokevirtual x/oca7b33a0538.ſ (Ljava/lang/String;)Ljava/lang/Boolean;
      // 088: astore 5
      // 08a: aload 2
      // 08b: ldc "toggle"
      // 08d: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 090: iload 3
      // 091: ifne 0a4
      // 094: ifeq 0b9
      // 097: goto 09b
      // 09a: athrow
      // 09b: aload 4
      // 09d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: iload 3
      // 0a5: ifne 0b0
      // 0a8: ifne 0b3
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: bipush 1
      // 0b0: goto 0b4
      // 0b3: bipush 0
      // 0b4: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 0b7: astore 5
      // 0b9: aload 5
      // 0bb: ifnonnull 0c2
      // 0be: ldc_w "Expected on/off, true/false, yes/no, or toggle."
      // 0c1: areturn
      // 0c2: aload 4
      // 0c4: aload 5
      // 0c6: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 0c9: invokevirtual x/occ2f8dff8d8.ϑ (Z)V
      // 0cc: aload 0
      // 0cd: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // 0d0: aload 4
      // 0d2: invokevirtual x/oc69da1aa7f5.guiButtonToggled (Lx/occ2f8dff8d8;)V
      // 0d5: aconst_null
      // 0d6: areturn
      // 0d7: aload 1
      // 0d8: iload 3
      // 0d9: ifne 1a3
      // 0dc: instanceof x/oca9cc61aada
      // 0df: ifeq 1a2
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 1
      // 0e7: checkcast x/oca9cc61aada
      // 0ea: astore 4
      // 0ec: aload 4
      // 0ee: iload 3
      // 0ef: ifne 102
      // 0f2: getfield x/oca9cc61aada.Æ Z
      // 0f5: ifeq 13b
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 4
      // 0fe: goto 102
      // 101: athrow
      // 102: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 105: astore 5
      // 107: iload 3
      // 108: aload 0
      // 109: aload 5
      // 10b: aload 2
      // 10c: invokevirtual x/oca7b33a0538.g ([Ljava/lang/String;Ljava/lang/String;)I
      // 10f: istore 6
      // 111: ifne 137
      // 114: iload 6
      // 116: ifge 12f
      // 119: goto 11d
      // 11c: athrow
      // 11d: ldc_w ", "
      // 120: aload 5
      // 122: invokestatic java/lang/String.join (Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Ljava/lang/String;
      // 125: ldc_w "Expected one of: "
      // 128: swap
      // 129: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 12e: areturn
      // 12f: aload 4
      // 131: iload 6
      // 133: i2d
      // 134: invokevirtual x/oca9cc61aada.ʫ (D)V
      // 137: iload 3
      // 138: ifeq 197
      // 13b: aload 2
      // 13c: invokestatic java/lang/Double.parseDouble (Ljava/lang/String;)D
      // 13f: dstore 5
      // 141: dload 5
      // 143: iload 3
      // 144: ifne 174
      // 147: aload 4
      // 149: invokevirtual x/oca9cc61aada.ԕ ()D
      // 14c: dcmpg
      // 14d: iflt 16b
      // 150: goto 154
      // 153: athrow
      // 154: dload 5
      // 156: iload 3
      // 157: ifne 174
      // 15a: goto 15e
      // 15d: athrow
      // 15e: aload 4
      // 160: invokevirtual x/oca9cc61aada.ȶ ()D
      // 163: dcmpl
      // 164: ifle 190
      // 167: goto 16b
      // 16a: athrow
      // 16b: aload 4
      // 16d: invokevirtual x/oca9cc61aada.ԕ ()D
      // 170: goto 174
      // 173: athrow
      // 174: aload 4
      // 176: invokevirtual x/oca9cc61aada.ȶ ()D
      // 179: dstore 7
      // 17b: dstore 9
      // 17d: ldc_w "Expected a number from "
      // 180: dload 9
      // 182: ldc_w " to "
      // 185: dload 7
      // 187: ldc_w "."
      // 18a: invokedynamic makeConcatWithConstants (Ljava/lang/String;DLjava/lang/String;DLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 18f: areturn
      // 190: aload 4
      // 192: dload 5
      // 194: invokevirtual x/oca9cc61aada.ʫ (D)V
      // 197: aload 0
      // 198: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // 19b: aload 4
      // 19d: invokevirtual x/oc69da1aa7f5.z$1sehylui0i4ix (Lx/oca9cc61aada;)V
      // 1a0: aconst_null
      // 1a1: areturn
      // 1a2: aload 1
      // 1a3: iload 3
      // 1a4: ifne 1bc
      // 1a7: instanceof x/ocada7dda290
      // 1aa: ifeq 1bb
      // 1ad: goto 1b1
      // 1b0: athrow
      // 1b1: aload 0
      // 1b2: aload 1
      // 1b3: checkcast x/ocada7dda290
      // 1b6: aload 2
      // 1b7: invokevirtual x/oca7b33a0538.ο (Lx/ocada7dda290;Ljava/lang/String;)Ljava/lang/String;
      // 1ba: areturn
      // 1bb: aload 1
      // 1bc: iload 3
      // 1bd: ifne 1d5
      // 1c0: instanceof x/oc24a0a5bddf
      // 1c3: ifeq 1d4
      // 1c6: goto 1ca
      // 1c9: athrow
      // 1ca: aload 0
      // 1cb: aload 1
      // 1cc: checkcast x/oc24a0a5bddf
      // 1cf: aload 2
      // 1d0: invokevirtual x/oca7b33a0538.ɤ (Lx/oc24a0a5bddf;Ljava/lang/String;)Ljava/lang/String;
      // 1d3: areturn
      // 1d4: aload 1
      // 1d5: iload 3
      // 1d6: ifne 259
      // 1d9: instanceof x/ocb23d192a35
      // 1dc: ifeq 258
      // 1df: goto 1e3
      // 1e2: athrow
      // 1e3: ldc_w "none"
      // 1e6: aload 2
      // 1e7: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 1ea: iload 3
      // 1eb: ifne 210
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: ifne 20f
      // 1f5: goto 1f9
      // 1f8: athrow
      // 1f9: ldc_w "unbound"
      // 1fc: aload 2
      // 1fd: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 200: iload 3
      // 201: ifne 210
      // 204: goto 208
      // 207: athrow
      // 208: ifeq 213
      // 20b: goto 20f
      // 20e: athrow
      // 20f: bipush 1
      // 210: goto 214
      // 213: bipush 0
      // 214: istore 4
      // 216: iload 4
      // 218: iload 3
      // 219: ifne 224
      // 21c: ifeq 227
      // 21f: goto 223
      // 222: athrow
      // 223: bipush 0
      // 224: goto 231
      // 227: aload 2
      // 228: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 22b: invokevirtual java/lang/String.toUpperCase (Ljava/util/Locale;)Ljava/lang/String;
      // 22e: invokestatic org/lwjgl/input/Keyboard.getKeyIndex (Ljava/lang/String;)I
      // 231: istore 5
      // 233: iload 3
      // 234: ifne 256
      // 237: iload 5
      // 239: ifne 24d
      // 23c: goto 240
      // 23f: athrow
      // 240: iload 4
      // 242: ifne 24d
      // 245: goto 249
      // 248: athrow
      // 249: ldc_w "Unknown keyboard key."
      // 24c: areturn
      // 24d: aload 1
      // 24e: checkcast x/ocb23d192a35
      // 251: iload 5
      // 253: invokevirtual x/ocb23d192a35.È (I)V
      // 256: aconst_null
      // 257: areturn
      // 258: aload 1
      // 259: iload 3
      // 25a: ifne 26c
      // 25d: instanceof x/oc6af36febc3
      // 260: ifeq 310
      // 263: goto 267
      // 266: athrow
      // 267: aload 1
      // 268: goto 26c
      // 26b: athrow
      // 26c: checkcast x/oc6af36febc3
      // 26f: astore 4
      // 271: aload 2
      // 272: ldc_w "\\s+"
      // 275: ldc_w -308567609
      // 278: ldc_w -308567611
      // 27b: ixor
      // 27c: invokevirtual java/lang/String.split (Ljava/lang/String;I)[Ljava/lang/String;
      // 27f: astore 5
      // 281: aload 5
      // 283: iload 3
      // 284: ifne 29f
      // 287: bipush 0
      // 288: aaload
      // 289: ldc_w "clear"
      // 28c: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 28f: ifeq 29d
      // 292: goto 296
      // 295: athrow
      // 296: aload 4
      // 298: invokevirtual x/oc6af36febc3.ů ()V
      // 29b: aconst_null
      // 29c: areturn
      // 29d: aload 5
      // 29f: iload 3
      // 2a0: ifne 2b8
      // 2a3: arraylength
      // 2a4: ldc_w -308567609
      // 2a7: ldc_w -308567611
      // 2aa: ixor
      // 2ab: if_icmpge 2b6
      // 2ae: goto 2b2
      // 2b1: athrow
      // 2b2: ldc_w "Use add <value>, remove <value>, or clear."
      // 2b5: areturn
      // 2b6: aload 5
      // 2b8: bipush 0
      // 2b9: iload 3
      // 2ba: ifne 2e4
      // 2bd: aaload
      // 2be: ldc_w "add"
      // 2c1: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 2c4: ifeq 2e1
      // 2c7: goto 2cb
      // 2ca: athrow
      // 2cb: aload 4
      // 2cd: aload 5
      // 2cf: bipush 1
      // 2d0: aaload
      // 2d1: invokevirtual x/oc6af36febc3.Զ (Ljava/lang/String;)Z
      // 2d4: ifne 2df
      // 2d7: goto 2db
      // 2da: athrow
      // 2db: ldc_w "Value is empty or already exists."
      // 2de: areturn
      // 2df: aconst_null
      // 2e0: areturn
      // 2e1: aload 5
      // 2e3: bipush 0
      // 2e4: aaload
      // 2e5: iload 3
      // 2e6: ifne 30f
      // 2e9: ldc_w "remove"
      // 2ec: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 2ef: ifeq 30c
      // 2f2: goto 2f6
      // 2f5: athrow
      // 2f6: aload 4
      // 2f8: aload 5
      // 2fa: bipush 1
      // 2fb: aaload
      // 2fc: invokevirtual x/oc6af36febc3.ĭ (Ljava/lang/String;)Z
      // 2ff: ifne 30a
      // 302: goto 306
      // 305: athrow
      // 306: ldc_w "Value was not found."
      // 309: areturn
      // 30a: aconst_null
      // 30b: areturn
      // 30c: ldc_w "Use add <value>, remove <value>, or clear."
      // 30f: areturn
      // 310: ldc_w "This setting type cannot be changed from chat."
      // 313: areturn
      // 314: astore 4
      // 316: ldc_w "Invalid number."
      // 319: areturn
   }

   private String ɤ(oc24a0a5bddf param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: aload 2
      // 004: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 007: astore 4
      // 009: istore 3
      // 00a: aload 4
      // 00c: iload 3
      // 00d: ifne 0c2
      // 010: ldc_w "#"
      // 013: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 016: ifeq 0c0
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 4
      // 01f: bipush 1
      // 020: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 023: ldc_w -474273024
      // 026: ldc_w -474273008
      // 029: ixor
      // 02a: invokestatic java/lang/Long.parseLong (Ljava/lang/String;I)J
      // 02d: lstore 5
      // 02f: aload 4
      // 031: iload 3
      // 032: ifne 071
      // 035: invokevirtual java/lang/String.length ()I
      // 038: ldc_w -474273001
      // 03b: ldc_w -474273008
      // 03e: ixor
      // 03f: if_icmpne 06b
      // 042: goto 046
      // 045: athrow
      // 046: aload 1
      // 047: lload 5
      // 049: ldc_w -474273024
      // 04c: ldc_w -474273008
      // 04f: ixor
      // 050: lshr
      // 051: l2i
      // 052: lload 5
      // 054: ldc_w -474273000
      // 057: ldc_w -474273008
      // 05a: ixor
      // 05b: lshr
      // 05c: l2i
      // 05d: lload 5
      // 05f: l2i
      // 060: invokevirtual x/oc24a0a5bddf.ӂ (III)V
      // 063: iload 3
      // 064: ifeq 0be
      // 067: goto 06b
      // 06a: athrow
      // 06b: aload 4
      // 06d: goto 071
      // 070: athrow
      // 071: iload 3
      // 072: ifne 0bd
      // 075: invokevirtual java/lang/String.length ()I
      // 078: ldc_w -474272999
      // 07b: ldc_w -474273008
      // 07e: ixor
      // 07f: if_icmpne 0b6
      // 082: goto 086
      // 085: athrow
      // 086: aload 1
      // 087: lload 5
      // 089: ldc_w -474273016
      // 08c: ldc_w -474273008
      // 08f: ixor
      // 090: lshr
      // 091: l2i
      // 092: lload 5
      // 094: ldc_w -474273024
      // 097: ldc_w -474273008
      // 09a: ixor
      // 09b: lshr
      // 09c: l2i
      // 09d: lload 5
      // 09f: ldc_w -474273000
      // 0a2: ldc_w -474273008
      // 0a5: ixor
      // 0a6: lshr
      // 0a7: l2i
      // 0a8: lload 5
      // 0aa: l2i
      // 0ab: invokevirtual x/oc24a0a5bddf.ƾ (IIII)V
      // 0ae: iload 3
      // 0af: ifeq 0be
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: ldc_w "Use #RRGGBB or #RRGGBBAA."
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: areturn
      // 0be: aconst_null
      // 0bf: areturn
      // 0c0: aload 4
      // 0c2: ldc_w "[,\\s]+"
      // 0c5: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 0c8: astore 5
      // 0ca: aload 5
      // 0cc: iload 3
      // 0cd: ifne 0fe
      // 0d0: arraylength
      // 0d1: ldc_w -474273005
      // 0d4: ldc_w -474273008
      // 0d7: ixor
      // 0d8: if_icmpeq 0fc
      // 0db: goto 0df
      // 0de: athrow
      // 0df: aload 5
      // 0e1: iload 3
      // 0e2: ifne 0fe
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: arraylength
      // 0ea: ldc_w -474273004
      // 0ed: ldc_w -474273008
      // 0f0: ixor
      // 0f1: if_icmpeq 0fc
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: ldc_w "Use R G B, R G B A, or #RRGGBB."
      // 0fb: areturn
      // 0fc: aload 5
      // 0fe: arraylength
      // 0ff: newarray 10
      // 101: astore 6
      // 103: bipush 0
      // 104: istore 7
      // 106: iload 7
      // 108: aload 5
      // 10a: arraylength
      // 10b: if_icmpge 151
      // 10e: aload 6
      // 110: iload 7
      // 112: iload 3
      // 113: ifne 13b
      // 116: aload 5
      // 118: iload 7
      // 11a: aaload
      // 11b: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 11e: iastore
      // 11f: iload 3
      // 120: ifne 186
      // 123: goto 127
      // 126: athrow
      // 127: aload 6
      // 129: iload 7
      // 12b: iaload
      // 12c: iflt 146
      // 12f: goto 133
      // 132: athrow
      // 133: aload 6
      // 135: iload 7
      // 137: goto 13b
      // 13a: athrow
      // 13b: iaload
      // 13c: ldc_w -474272785
      // 13f: ldc_w -474273008
      // 142: ixor
      // 143: if_icmple 14a
      // 146: ldc_w "Color channels must be from 0 to 255."
      // 149: areturn
      // 14a: iinc 7 1
      // 14d: iload 3
      // 14e: ifeq 106
      // 151: aload 6
      // 153: arraylength
      // 154: ldc_w -474273004
      // 157: ldc_w -474273008
      // 15a: ixor
      // 15b: if_icmpne 186
      // 15e: aload 1
      // 15f: aload 6
      // 161: bipush 0
      // 162: iaload
      // 163: aload 6
      // 165: bipush 1
      // 166: iaload
      // 167: aload 6
      // 169: ldc_w -474273006
      // 16c: ldc_w -474273008
      // 16f: ixor
      // 170: iaload
      // 171: aload 6
      // 173: ldc_w -474273005
      // 176: ldc_w -474273008
      // 179: ixor
      // 17a: iaload
      // 17b: invokevirtual x/oc24a0a5bddf.ƾ (IIII)V
      // 17e: iload 3
      // 17f: ifeq 19c
      // 182: goto 186
      // 185: athrow
      // 186: aload 1
      // 187: aload 6
      // 189: bipush 0
      // 18a: iaload
      // 18b: aload 6
      // 18d: bipush 1
      // 18e: iaload
      // 18f: aload 6
      // 191: ldc_w -474273006
      // 194: ldc_w -474273008
      // 197: ixor
      // 198: iaload
      // 199: invokevirtual x/oc24a0a5bddf.ӂ (III)V
      // 19c: aconst_null
      // 19d: areturn
      // 19e: astore 5
      // 1a0: ldc_w "Invalid color value."
      // 1a3: areturn
   }

   private N ƨ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: aload 1
      // 04: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 0
      // 0a: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // 0d: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 10: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 13: astore 4
      // 15: aload 4
      // 17: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1c: ifeq 7c
      // 1f: aload 4
      // 21: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 26: checkcast x/N
      // 29: astore 5
      // 2b: aload 5
      // 2d: iload 2
      // 2e: ifne 41
      // 31: instanceof x/occc831eff22
      // 34: ifne 78
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 5
      // 3d: goto 41
      // 40: athrow
      // 41: iload 2
      // 42: ifne 77
      // 45: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 48: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 4b: aload 3
      // 4c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 4f: ifne 71
      // 52: goto 56
      // 55: athrow
      // 56: aload 5
      // 58: iload 2
      // 59: ifne 77
      // 5c: goto 60
      // 5f: athrow
      // 60: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 63: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 66: aload 3
      // 67: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 6a: ifeq 78
      // 6d: goto 71
      // 70: athrow
      // 71: aload 5
      // 73: goto 77
      // 76: athrow
      // 77: areturn
      // 78: iload 2
      // 79: ifeq 15
      // 7c: aconst_null
      // 7d: areturn
   }

   public List<String> z$9ofids0wyz4j(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 2
      // 004: aload 1
      // 005: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 008: bipush 1
      // 009: if_icmpgt 064
      // 00c: new java/util/ArrayList
      // 00f: dup
      // 010: invokespecial java/util/ArrayList.<init> ()V
      // 013: astore 3
      // 014: aload 0
      // 015: getfield x/oca7b33a0538.ǉ Lx/oc69da1aa7f5;
      // 018: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 01b: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 01e: astore 4
      // 020: aload 4
      // 022: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 027: ifeq 05d
      // 02a: aload 4
      // 02c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 031: checkcast x/N
      // 034: astore 5
      // 036: aload 5
      // 038: instanceof x/occc831eff22
      // 03b: iload 2
      // 03c: ifne 058
      // 03f: ifne 059
      // 042: goto 046
      // 045: athrow
      // 046: aload 3
      // 047: aload 5
      // 049: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 04c: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 04f: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 054: goto 058
      // 057: athrow
      // 058: pop
      // 059: iload 2
      // 05a: ifeq 020
      // 05d: aload 0
      // 05e: aload 1
      // 05f: aload 3
      // 060: invokevirtual x/oc161f4adba4.ҕ (Lx/ocaae9de8508;Ljava/util/List;)Ljava/util/List;
      // 063: areturn
      // 064: aload 0
      // 065: aload 1
      // 066: bipush 0
      // 067: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 06a: invokevirtual x/oca7b33a0538.ƨ (Ljava/lang/String;)Lx/N;
      // 06d: astore 3
      // 06e: aload 3
      // 06f: iload 2
      // 070: ifne 0c8
      // 073: instanceof x/occ2f8dff8d8
      // 076: ifeq 0c7
      // 079: goto 07d
      // 07c: athrow
      // 07d: aload 0
      // 07e: aload 1
      // 07f: aload 3
      // 080: checkcast x/occ2f8dff8d8
      // 083: getfield x/occ2f8dff8d8.ӽ Z
      // 086: iload 2
      // 087: ifne 0a9
      // 08a: goto 08e
      // 08d: athrow
      // 08e: ifeq 0a2
      // 091: goto 095
      // 094: athrow
      // 095: bipush 1
      // 096: anewarray 53
      // 099: dup
      // 09a: bipush 0
      // 09b: ldc "run"
      // 09d: aastore
      // 09e: goto 0c3
      // 0a1: athrow
      // 0a2: ldc_w 485712968
      // 0a5: ldc_w 485712971
      // 0a8: ixor
      // 0a9: anewarray 53
      // 0ac: dup
      // 0ad: bipush 0
      // 0ae: ldc_w "on"
      // 0b1: aastore
      // 0b2: dup
      // 0b3: bipush 1
      // 0b4: ldc_w "off"
      // 0b7: aastore
      // 0b8: dup
      // 0b9: ldc_w 485712969
      // 0bc: ldc_w 485712971
      // 0bf: ixor
      // 0c0: ldc "toggle"
      // 0c2: aastore
      // 0c3: invokevirtual x/oc161f4adba4.Ġ (Lx/ocaae9de8508;[Ljava/lang/String;)Ljava/util/List;
      // 0c6: areturn
      // 0c7: aload 3
      // 0c8: iload 2
      // 0c9: ifne 0fe
      // 0cc: instanceof x/oca9cc61aada
      // 0cf: ifeq 0fd
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: aload 3
      // 0d7: checkcast x/oca9cc61aada
      // 0da: iload 2
      // 0db: ifne 0fe
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: getfield x/oca9cc61aada.Æ Z
      // 0e5: ifeq 0fd
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: aload 0
      // 0ed: aload 1
      // 0ee: aload 3
      // 0ef: checkcast x/oca9cc61aada
      // 0f2: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 0f5: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 0f8: invokevirtual x/oc161f4adba4.ҕ (Lx/ocaae9de8508;Ljava/util/List;)Ljava/util/List;
      // 0fb: areturn
      // 0fc: athrow
      // 0fd: aload 3
      // 0fe: iload 2
      // 0ff: ifne 13e
      // 102: instanceof x/ocada7dda290
      // 105: ifeq 13d
      // 108: goto 10c
      // 10b: athrow
      // 10c: new java/util/ArrayList
      // 10f: dup
      // 110: aload 3
      // 111: checkcast x/ocada7dda290
      // 114: invokevirtual x/ocada7dda290.ǥ ()[Ljava/lang/String;
      // 117: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 11a: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 11d: astore 4
      // 11f: aload 4
      // 121: ldc_w "all"
      // 124: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 129: pop
      // 12a: aload 4
      // 12c: ldc_w "clear"
      // 12f: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 134: pop
      // 135: aload 0
      // 136: aload 1
      // 137: aload 4
      // 139: invokevirtual x/oc161f4adba4.ҕ (Lx/ocaae9de8508;Ljava/util/List;)Ljava/util/List;
      // 13c: areturn
      // 13d: aload 3
      // 13e: instanceof x/oc6af36febc3
      // 141: ifeq 16d
      // 144: aload 0
      // 145: aload 1
      // 146: ldc_w 485712968
      // 149: ldc_w 485712971
      // 14c: ixor
      // 14d: anewarray 53
      // 150: dup
      // 151: bipush 0
      // 152: ldc_w "add"
      // 155: aastore
      // 156: dup
      // 157: bipush 1
      // 158: ldc_w "remove"
      // 15b: aastore
      // 15c: dup
      // 15d: ldc_w 485712969
      // 160: ldc_w 485712971
      // 163: ixor
      // 164: ldc_w "clear"
      // 167: aastore
      // 168: invokevirtual x/oc161f4adba4.Ġ (Lx/ocaae9de8508;[Ljava/lang/String;)Ljava/util/List;
      // 16b: areturn
      // 16c: athrow
      // 16d: new java/util/ArrayList
      // 170: dup
      // 171: invokespecial java/util/ArrayList.<init> ()V
      // 174: areturn
   }

   public int z$7k2utc7u0w8s(ocaae9de8508 var1) {
      return Math.max(0, var1.Ӿ() - 1);
   }

   public boolean T(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 08: iload 2
      // 09: ifne 2c
      // 0c: bipush 1
      // 0d: if_icmple 51
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: aload 1
      // 16: bipush 0
      // 17: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 1a: invokevirtual x/oca7b33a0538.ƨ (Ljava/lang/String;)Lx/N;
      // 1d: iload 2
      // 1e: ifne 3c
      // 21: goto 25
      // 24: athrow
      // 25: instanceof x/oc321b4679dd
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifeq 51
      // 2f: aload 0
      // 30: aload 1
      // 31: bipush 0
      // 32: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 35: invokevirtual x/oca7b33a0538.ƨ (Ljava/lang/String;)Lx/N;
      // 38: goto 3c
      // 3b: athrow
      // 3c: checkcast x/oc321b4679dd
      // 3f: invokevirtual x/oc321b4679dd.Ǽ ()Z
      // 42: iload 2
      // 43: ifne 4e
      // 46: ifeq 51
      // 49: goto 4d
      // 4c: athrow
      // 4d: bipush 1
      // 4e: goto 52
      // 51: bipush 0
      // 52: ireturn
   }

   private String Á(N param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 061
      // 009: instanceof x/oc321b4679dd
      // 00c: ifeq 060
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: iload 2
      // 015: ifne 050
      // 018: goto 01c
      // 01b: athrow
      // 01c: checkcast x/oc321b4679dd
      // 01f: invokevirtual x/oc321b4679dd.Ǽ ()Z
      // 022: ifeq 04f
      // 025: goto 029
      // 028: athrow
      // 029: aload 1
      // 02a: checkcast x/oc321b4679dd
      // 02d: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 030: iload 2
      // 031: ifne 04c
      // 034: goto 038
      // 037: athrow
      // 038: invokevirtual java/lang/String.isEmpty ()Z
      // 03b: ifeq 049
      // 03e: goto 042
      // 041: athrow
      // 042: ldc_w "&8<not set>"
      // 045: goto 05f
      // 048: athrow
      // 049: ldc_w "&8<redacted>"
      // 04c: goto 05f
      // 04f: aload 1
      // 050: checkcast x/oc321b4679dd
      // 053: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 056: ldc_w "&f"
      // 059: swap
      // 05a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 05f: areturn
      // 060: aload 1
      // 061: iload 2
      // 062: ifne 0a2
      // 065: instanceof x/occ2f8dff8d8
      // 068: ifeq 0a1
      // 06b: goto 06f
      // 06e: athrow
      // 06f: aload 1
      // 070: iload 2
      // 071: ifne 08d
      // 074: goto 078
      // 077: athrow
      // 078: checkcast x/occ2f8dff8d8
      // 07b: getfield x/occ2f8dff8d8.ӽ Z
      // 07e: ifeq 08c
      // 081: goto 085
      // 084: athrow
      // 085: ldc_w "&d<action>"
      // 088: goto 0a0
      // 08b: athrow
      // 08c: aload 1
      // 08d: checkcast x/occ2f8dff8d8
      // 090: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 093: ifeq 09d
      // 096: ldc_w "&aOn"
      // 099: goto 0a0
      // 09c: athrow
      // 09d: ldc_w "&cOff"
      // 0a0: areturn
      // 0a1: aload 1
      // 0a2: iload 2
      // 0a3: ifne 129
      // 0a6: instanceof x/oca9cc61aada
      // 0a9: ifeq 128
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: aload 1
      // 0b1: checkcast x/oca9cc61aada
      // 0b4: astore 3
      // 0b5: aload 3
      // 0b6: iload 2
      // 0b7: ifne 0da
      // 0ba: getfield x/oca9cc61aada.Æ Z
      // 0bd: ifeq 0d9
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 3
      // 0c5: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 0c8: aload 3
      // 0c9: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0cc: d2i
      // 0cd: aaload
      // 0ce: ldc_w "&f"
      // 0d1: swap
      // 0d2: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0d7: areturn
      // 0d8: athrow
      // 0d9: aload 3
      // 0da: iload 2
      // 0db: ifne 110
      // 0de: invokevirtual x/oca9cc61aada.ԅ ()Ljava/lang/String;
      // 0e1: ifnull 10f
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 3
      // 0e9: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0ec: iload 2
      // 0ed: ifne 113
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 3
      // 0f5: invokevirtual x/oca9cc61aada.ԕ ()D
      // 0f8: dcmpl
      // 0f9: ifne 10f
      // 0fc: goto 100
      // 0ff: athrow
      // 100: aload 3
      // 101: invokevirtual x/oca9cc61aada.ԅ ()Ljava/lang/String;
      // 104: ldc_w "&f"
      // 107: swap
      // 108: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 10d: areturn
      // 10e: athrow
      // 10f: aload 3
      // 110: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 113: aload 3
      // 114: invokevirtual x/oca9cc61aada.Ĝ ()Ljava/lang/String;
      // 117: astore 4
      // 119: dstore 5
      // 11b: ldc_w "&f"
      // 11e: dload 5
      // 120: aload 4
      // 122: invokedynamic makeConcatWithConstants (Ljava/lang/String;DLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 127: areturn
      // 128: aload 1
      // 129: iload 2
      // 12a: ifne 161
      // 12d: instanceof x/ocada7dda290
      // 130: ifeq 160
      // 133: goto 137
      // 136: athrow
      // 137: aload 1
      // 138: checkcast x/ocada7dda290
      // 13b: invokevirtual x/ocada7dda290.ԇ ()Ljava/util/List;
      // 13e: astore 3
      // 13f: aload 3
      // 140: invokeinterface java/util/List.isEmpty ()Z 1
      // 145: ifeq 14f
      // 148: ldc_w "&8None"
      // 14b: goto 15f
      // 14e: athrow
      // 14f: ldc_w ", "
      // 152: aload 3
      // 153: invokestatic java/lang/String.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 156: ldc_w "&f"
      // 159: swap
      // 15a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 15f: areturn
      // 160: aload 1
      // 161: iload 2
      // 162: ifne 189
      // 165: instanceof x/oc24a0a5bddf
      // 168: ifeq 188
      // 16b: goto 16f
      // 16e: athrow
      // 16f: ldc_w "&f#%06X"
      // 172: bipush 1
      // 173: anewarray 550
      // 176: dup
      // 177: bipush 0
      // 178: aload 1
      // 179: checkcast x/oc24a0a5bddf
      // 17c: invokevirtual x/oc24a0a5bddf.ǐ ()I
      // 17f: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 182: aastore
      // 183: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 186: areturn
      // 187: athrow
      // 188: aload 1
      // 189: iload 2
      // 18a: ifne 1c1
      // 18d: instanceof x/ocb23d192a35
      // 190: ifeq 1c0
      // 193: goto 197
      // 196: athrow
      // 197: aload 1
      // 198: checkcast x/ocb23d192a35
      // 19b: invokevirtual x/ocb23d192a35.Ǻ ()I
      // 19e: istore 3
      // 19f: iload 3
      // 1a0: iload 2
      // 1a1: ifne 1b3
      // 1a4: ifne 1b2
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: ldc_w "NONE"
      // 1ae: goto 1b6
      // 1b1: athrow
      // 1b2: iload 3
      // 1b3: invokestatic org/lwjgl/input/Keyboard.getKeyName (I)Ljava/lang/String;
      // 1b6: ldc_w "&f"
      // 1b9: swap
      // 1ba: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1bf: areturn
      // 1c0: aload 1
      // 1c1: iload 2
      // 1c2: ifne 1d4
      // 1c5: instanceof x/oc6af36febc3
      // 1c8: ifeq 1ec
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: aload 1
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: checkcast x/oc6af36febc3
      // 1d7: invokevirtual x/oc6af36febc3.Ď ()Ljava/util/List;
      // 1da: invokeinterface java/util/List.size ()I 1
      // 1df: ldc_w "&f"
      // 1e2: swap
      // 1e3: ldc_w " entries"
      // 1e6: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 1eb: areturn
      // 1ec: ldc_w "&8<unsupported>"
      // 1ef: areturn
   }

   private Boolean ſ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: ldc "toggle"
      // 07: iload 2
      // 08: ifne 1c
      // 0b: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0e: ifeq 18
      // 11: goto 15
      // 14: athrow
      // 15: aconst_null
      // 16: areturn
      // 17: athrow
      // 18: aload 1
      // 19: ldc_w "(?i)on|true|yes|1|enable|enabled"
      // 1c: iload 2
      // 1d: ifne 34
      // 20: invokevirtual java/lang/String.matches (Ljava/lang/String;)Z
      // 23: ifeq 30
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 2e: areturn
      // 2f: athrow
      // 30: aload 1
      // 31: ldc_w "(?i)off|false|no|0|disable|disabled"
      // 34: invokevirtual java/lang/String.matches (Ljava/lang/String;)Z
      // 37: iload 2
      // 38: ifne 43
      // 3b: ifeq 47
      // 3e: goto 42
      // 41: athrow
      // 42: bipush 0
      // 43: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 46: areturn
      // 47: aconst_null
      // 48: areturn
   }

   private String ο(ocada7dda290 param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 3
      // 004: iload 3
      // 005: aload 2
      // 006: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 009: astore 4
      // 00b: ifne 03c
      // 00e: aload 4
      // 010: ldc_w "clear"
      // 013: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 016: ifne 034
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 4
      // 01f: iload 3
      // 020: ifne 040
      // 023: goto 027
      // 026: athrow
      // 027: ldc_w "none"
      // 02a: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 02d: ifeq 03e
      // 030: goto 034
      // 033: athrow
      // 034: aload 1
      // 035: invokevirtual x/ocada7dda290.ƃ ()V
      // 038: goto 03c
      // 03b: athrow
      // 03c: aconst_null
      // 03d: areturn
      // 03e: aload 4
      // 040: iload 3
      // 041: ifne 05a
      // 044: ldc_w "all"
      // 047: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 04a: ifeq 058
      // 04d: goto 051
      // 050: athrow
      // 051: aload 1
      // 052: invokevirtual x/ocada7dda290.Л ()V
      // 055: aconst_null
      // 056: areturn
      // 057: athrow
      // 058: aload 4
      // 05a: ldc_w "\\s+"
      // 05d: ldc_w 595153256
      // 060: ldc_w 595153258
      // 063: ixor
      // 064: invokevirtual java/lang/String.split (Ljava/lang/String;I)[Ljava/lang/String;
      // 067: astore 5
      // 069: aload 5
      // 06b: iload 3
      // 06c: ifne 114
      // 06f: arraylength
      // 070: ldc_w 595153256
      // 073: ldc_w 595153258
      // 076: ixor
      // 077: if_icmpne 10c
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 0
      // 07f: aload 1
      // 080: invokevirtual x/ocada7dda290.ǥ ()[Ljava/lang/String;
      // 083: aload 5
      // 085: bipush 1
      // 086: aaload
      // 087: invokevirtual x/oca7b33a0538.Į ([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 08a: astore 6
      // 08c: aload 6
      // 08e: iload 3
      // 08f: ifne 0b2
      // 092: ifnonnull 0ae
      // 095: goto 099
      // 098: athrow
      // 099: ldc_w ", "
      // 09c: aload 1
      // 09d: invokevirtual x/ocada7dda290.ǥ ()[Ljava/lang/String;
      // 0a0: invokestatic java/lang/String.join (Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Ljava/lang/String;
      // 0a3: ldc_w "Expected one of: "
      // 0a6: swap
      // 0a7: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0ac: areturn
      // 0ad: athrow
      // 0ae: aload 5
      // 0b0: bipush 0
      // 0b1: aaload
      // 0b2: iload 3
      // 0b3: ifne 0d2
      // 0b6: ldc_w "(?i)add|on|enable|enabled"
      // 0b9: invokevirtual java/lang/String.matches (Ljava/lang/String;)Z
      // 0bc: ifeq 0ce
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: aload 1
      // 0c4: aload 6
      // 0c6: bipush 1
      // 0c7: invokevirtual x/ocada7dda290.Ͼ (Ljava/lang/String;Z)Z
      // 0ca: pop
      // 0cb: aconst_null
      // 0cc: areturn
      // 0cd: athrow
      // 0ce: aload 5
      // 0d0: bipush 0
      // 0d1: aaload
      // 0d2: iload 3
      // 0d3: ifne 0fa
      // 0d6: ldc_w "(?i)remove|off|disable|disabled"
      // 0d9: invokevirtual java/lang/String.matches (Ljava/lang/String;)Z
      // 0dc: ifeq 0ee
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 1
      // 0e4: aload 6
      // 0e6: bipush 0
      // 0e7: invokevirtual x/ocada7dda290.Ͼ (Ljava/lang/String;Z)Z
      // 0ea: pop
      // 0eb: aconst_null
      // 0ec: areturn
      // 0ed: athrow
      // 0ee: aload 5
      // 0f0: iload 3
      // 0f1: ifne 114
      // 0f4: bipush 0
      // 0f5: aaload
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: ldc "toggle"
      // 0fc: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0ff: ifeq 10c
      // 102: aload 1
      // 103: aload 6
      // 105: invokevirtual x/ocada7dda290.ѥ (Ljava/lang/String;)Z
      // 108: pop
      // 109: aconst_null
      // 10a: areturn
      // 10b: athrow
      // 10c: aload 4
      // 10e: ldc_w ","
      // 111: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 114: astore 6
      // 116: new java/util/ArrayList
      // 119: dup
      // 11a: invokespecial java/util/ArrayList.<init> ()V
      // 11d: astore 7
      // 11f: aload 6
      // 121: astore 8
      // 123: aload 8
      // 125: arraylength
      // 126: istore 9
      // 128: bipush 0
      // 129: istore 10
      // 12b: iload 10
      // 12d: iload 9
      // 12f: if_icmpge 17c
      // 132: aload 8
      // 134: iload 10
      // 136: aaload
      // 137: astore 11
      // 139: iload 3
      // 13a: ifne 180
      // 13d: aload 0
      // 13e: aload 1
      // 13f: invokevirtual x/ocada7dda290.ǥ ()[Ljava/lang/String;
      // 142: aload 11
      // 144: invokevirtual x/oca7b33a0538.Į ([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 147: astore 12
      // 149: iload 3
      // 14a: ifne 178
      // 14d: aload 12
      // 14f: ifnonnull 16b
      // 152: goto 156
      // 155: athrow
      // 156: ldc_w ", "
      // 159: aload 1
      // 15a: invokevirtual x/ocada7dda290.ǥ ()[Ljava/lang/String;
      // 15d: invokestatic java/lang/String.join (Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Ljava/lang/String;
      // 160: ldc_w "Expected one or more of: "
      // 163: swap
      // 164: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 169: areturn
      // 16a: athrow
      // 16b: aload 7
      // 16d: aload 12
      // 16f: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 174: pop
      // 175: iinc 10 1
      // 178: iload 3
      // 179: ifeq 12b
      // 17c: aload 1
      // 17d: invokevirtual x/ocada7dda290.ƃ ()V
      // 180: aload 7
      // 182: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 187: astore 8
      // 189: aload 8
      // 18b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 190: ifeq 1ab
      // 193: aload 8
      // 195: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 19a: checkcast java/lang/String
      // 19d: astore 9
      // 19f: iload 3
      // 1a0: aload 1
      // 1a1: aload 9
      // 1a3: bipush 1
      // 1a4: invokevirtual x/ocada7dda290.Ͼ (Ljava/lang/String;Z)Z
      // 1a7: pop
      // 1a8: ifeq 189
      // 1ab: aconst_null
      // 1ac: areturn
   }

   private int g(String[] param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: aload 2
      // 04: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 4
      // 09: istore 3
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: aload 1
      // 10: arraylength
      // 11: if_icmpge 3d
      // 14: aload 1
      // 15: iload 5
      // 17: aaload
      // 18: invokestatic x/oca7b33a0538.Ø (Ljava/lang/String;)Ljava/lang/String;
      // 1b: aload 4
      // 1d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 20: iload 3
      // 21: ifne 3e
      // 24: iload 3
      // 25: ifne 35
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifeq 36
      // 2f: goto 33
      // 32: athrow
      // 33: iload 5
      // 35: ireturn
      // 36: iinc 5 1
      // 39: iload 3
      // 3a: ifeq 0d
      // 3d: bipush -1
      // 3e: ireturn
   }

   private String Į(String[] var1, String var2) {
      int var3 = this.g(var1, var2);

      try {
         if (var3 < 0) {
            return null;
         }
      } catch (NumberFormatException var4) {
         throw var4;
      }

      return var1[var3];
   }

   public static String Ø(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1e
      // 09: ifnonnull 17
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc_w ""
      // 13: goto 27
      // 16: athrow
      // 17: aload 0
      // 18: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 1b: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 1e: ldc_w "[^a-z0-9]"
      // 21: ldc_w ""
      // 24: invokevirtual java/lang/String.replaceAll (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 27: areturn
   }
}
