package x;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oca076f88ba2 extends oc161f4adba4 {
   public static int ĵ;

   public oca076f88ba2() {
      oc17aaf5d285 var10003 = oc17aaf5d285.ħ;
      String[] var10004 = new String[-919367672 ^ -919367670];
      var10004[0] = "binds";
      var10004[1] = "binds <key>";
      super("binds", "List active module key bindings.", var10003, var10004, new String[0]);
   }

   public void z$2uoow1halcq2f(ocaae9de8508 param1) {
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
      // 006: ifne 0b6
      // 009: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 00c: ifne 0b5
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: bipush 0
      // 015: invokevirtual x/oca076f88ba2.ӟ (I)Ljava/util/Map;
      // 018: astore 3
      // 019: aload 0
      // 01a: aload 3
      // 01b: invokevirtual x/oca076f88ba2.Ѿ (Ljava/util/Map;)I
      // 01e: istore 4
      // 020: aload 0
      // 021: iload 4
      // 023: iload 4
      // 025: bipush 1
      // 026: if_icmpne 02f
      // 029: ldc ""
      // 02b: goto 031
      // 02e: athrow
      // 02f: ldc "s"
      // 031: ldc "&b"
      // 033: dup_x2
      // 034: pop
      // 035: ldc " &7module"
      // 037: swap
      // 038: ldc " have keybinds."
      // 03a: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 03f: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 042: aload 3
      // 043: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 048: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 04d: astore 5
      // 04f: aload 5
      // 051: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 056: ifeq 0b4
      // 059: aload 5
      // 05b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 060: checkcast java/util/Map$Entry
      // 063: astore 6
      // 065: aload 6
      // 067: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 06c: checkcast java/util/List
      // 06f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 074: astore 7
      // 076: aload 7
      // 078: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 07d: ifeq 0b0
      // 080: aload 7
      // 082: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 087: checkcast java/lang/String
      // 08a: astore 8
      // 08c: iload 2
      // 08d: ifne 04f
      // 090: aload 0
      // 091: aload 6
      // 093: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 098: checkcast java/lang/String
      // 09b: aload 8
      // 09d: ldc " &b"
      // 09f: dup_x2
      // 0a0: pop
      // 0a1: ldc " &7"
      // 0a3: swap
      // 0a4: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 0a9: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 0ac: iload 2
      // 0ad: ifeq 076
      // 0b0: iload 2
      // 0b1: ifeq 04f
      // 0b4: return
      // 0b5: aload 1
      // 0b6: iload 2
      // 0b7: ifne 0cc
      // 0ba: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0bd: bipush 1
      // 0be: if_icmpeq 0cb
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 0
      // 0c6: invokevirtual x/oc161f4adba4.ǻ ()V
      // 0c9: return
      // 0ca: athrow
      // 0cb: aload 1
      // 0cc: bipush 0
      // 0cd: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 0d0: invokevirtual java/lang/String.toUpperCase ()Ljava/lang/String;
      // 0d3: invokestatic org/lwjgl/input/Keyboard.getKeyIndex (Ljava/lang/String;)I
      // 0d6: istore 3
      // 0d7: iload 2
      // 0d8: ifne 0ed
      // 0db: iload 3
      // 0dc: ifne 0ee
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 0
      // 0e4: ldc "&7Invalid key."
      // 0e6: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: return
      // 0ee: aload 0
      // 0ef: iload 3
      // 0f0: invokevirtual x/oca076f88ba2.ӟ (I)Ljava/util/Map;
      // 0f3: astore 4
      // 0f5: aload 0
      // 0f6: aload 4
      // 0f8: invokevirtual x/oca076f88ba2.Ѿ (Ljava/util/Map;)I
      // 0fb: istore 5
      // 0fd: aload 0
      // 0fe: iload 5
      // 100: iload 5
      // 102: bipush 1
      // 103: if_icmpne 10c
      // 106: ldc ""
      // 108: goto 10e
      // 10b: athrow
      // 10c: ldc "s"
      // 10e: aload 1
      // 10f: bipush 0
      // 110: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 113: invokevirtual java/lang/String.toUpperCase ()Ljava/lang/String;
      // 116: astore 10
      // 118: astore 11
      // 11a: istore 12
      // 11c: ldc "&b"
      // 11e: iload 12
      // 120: ldc " &7module"
      // 122: aload 11
      // 124: ldc " has keybind &b"
      // 126: aload 10
      // 128: ldc "&7."
      // 12a: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001\u0001\u0001" ]
      // 12f: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 132: aload 4
      // 134: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 139: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 13e: astore 6
      // 140: aload 6
      // 142: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 147: ifeq 1a5
      // 14a: aload 6
      // 14c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 151: checkcast java/util/Map$Entry
      // 154: astore 7
      // 156: aload 7
      // 158: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 15d: checkcast java/util/List
      // 160: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 165: astore 8
      // 167: aload 8
      // 169: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 16e: ifeq 1a1
      // 171: aload 8
      // 173: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 178: checkcast java/lang/String
      // 17b: astore 9
      // 17d: iload 2
      // 17e: ifne 140
      // 181: aload 0
      // 182: aload 7
      // 184: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 189: checkcast java/lang/String
      // 18c: aload 9
      // 18e: ldc " &b"
      // 190: dup_x2
      // 191: pop
      // 192: ldc " &7"
      // 194: swap
      // 195: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 19a: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 19d: iload 2
      // 19e: ifeq 167
      // 1a1: iload 2
      // 1a2: ifeq 140
      // 1a5: return
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   private Map<String, List<String>> ӟ(int var1) {
      HashMap var3 = new HashMap();
      int var10000 = oc24b4725b15.Ε;
      Iterator var4 = oc9755810e45.Ŕ.iterator();
      int var2 = var10000;

      while (true) {
         if (var4.hasNext()) {
            Object var8 = var4.next();
            if (var2 == 0) {
               oc69da1aa7f5 var5 = (oc69da1aa7f5)var8;
               this.Ő(var3, var5, var1);
               if (var2 == 0) {
                  continue;
               }

               var4 = oc2cf3d80e17.Á.ǹ.iterator();
            } else {
               oc151419fdfe var6 = (oc151419fdfe)var8;
               this.Ő(var3, var6.ǚ(), var1);
               if (var2 != 0) {
                  return var3;
               }
            }
         }

         for (oc151419fdfe var7 : oc2cf3d80e17.Á.ǹ) {
            this.Ő(var3, var7.ǚ(), var1);
            if (var2 != 0) {
               return var3;
            }
         }

         return var3;
      }
   }

   private void Ő(Map<String, List<String>> param1, oc69da1aa7f5 param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 4
      // 05: aload 2
      // 06: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 09: iload 4
      // 0b: ifne 17
      // 0e: ifne 16
      // 11: goto 15
      // 14: athrow
      // 15: return
      // 16: iload 3
      // 17: iload 4
      // 19: ifne 47
      // 1c: ifeq 3a
      // 1f: goto 23
      // 22: athrow
      // 23: aload 2
      // 24: iload 4
      // 26: ifne 3b
      // 29: goto 2d
      // 2c: athrow
      // 2d: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 30: iload 3
      // 31: if_icmpeq 3a
      // 34: goto 38
      // 37: athrow
      // 38: return
      // 39: athrow
      // 3a: aload 2
      // 3b: iload 4
      // 3d: ifne 63
      // 40: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 43: goto 47
      // 46: athrow
      // 47: ldc 1153418758
      // 49: ldc 1153418734
      // 4b: ixor
      // 4c: if_icmplt 62
      // 4f: aload 2
      // 50: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 53: ldc 1153418758
      // 55: ldc 1153418734
      // 57: ixor
      // 58: isub
      // 59: invokedynamic makeConcatWithConstants (I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "M\u0001" ]
      // 5e: goto 69
      // 61: athrow
      // 62: aload 2
      // 63: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 66: invokestatic org/lwjgl/input/Keyboard.getKeyName (I)Ljava/lang/String;
      // 69: astore 5
      // 6b: iload 4
      // 6d: aload 1
      // 6e: aload 5
      // 70: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 75: checkcast java/util/List
      // 78: astore 6
      // 7a: ifne a6
      // 7d: aload 6
      // 7f: ifnonnull 9a
      // 82: goto 86
      // 85: athrow
      // 86: new java/util/ArrayList
      // 89: dup
      // 8a: invokespecial java/util/ArrayList.<init> ()V
      // 8d: astore 6
      // 8f: aload 1
      // 90: aload 5
      // 92: aload 6
      // 94: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 99: pop
      // 9a: aload 6
      // 9c: aload 2
      // 9d: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // a0: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // a5: pop
      // a6: return
   }

   private int Ѿ(Map<String, List<String>> var1) {
      int var3 = 0;
      int var2 = oc24b4725b15.Ε;
      Iterator var4 = var1.values().iterator();

      int var10000;
      while (true) {
         if (var4.hasNext()) {
            List var5 = (List)var4.next();
            var10000 = var3;
            if (var2 != 0) {
               break;
            }

            var3 += var5.size();
            if (var2 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }
}
