package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class oc62c8c02d34 extends oc161f4adba4 {
   public static int Ҫ;

   public oc62c8c02d34() {
      oc17aaf5d285 var10003 = oc17aaf5d285.ղ;
      String[] var10004 = new String[418527555 ^ 418527559];
      var10004[0] = "script";
      var10004[1] = "script load";
      var10004[418527557 ^ 418527559] = "script list";
      var10004[418527556 ^ 418527559] = "script refresh";
      super("script", "Manage Java scripts from miau/scripts.", var10003, var10004, new String[]{"scripts"});
   }

   public void z$2uoow1halcq2f(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 1a
      // 09: invokevirtual x/ocaae9de8508.у ()[Ljava/lang/String;
      // 0c: arraylength
      // 0d: bipush 1
      // 0e: if_icmplt 27
      // 11: goto 15
      // 14: athrow
      // 15: aload 1
      // 16: goto 1a
      // 19: athrow
      // 1a: bipush 0
      // 1b: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 1e: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 21: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 24: goto 29
      // 27: ldc "load"
      // 29: astore 3
      // 2a: aload 3
      // 2b: astore 4
      // 2d: bipush -1
      // 2e: istore 5
      // 30: aload 4
      // 32: invokevirtual java/lang/String.hashCode ()I
      // 35: iload 2
      // 36: ifne b6
      // 39: lookupswitch 123 3 3322014 36 3327206 94 1085444827 65
      // 5c: athrow
      // 5d: aload 4
      // 5f: ldc "list"
      // 61: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 64: iload 2
      // 65: ifne b6
      // 68: goto 6c
      // 6b: athrow
      // 6c: ifeq b4
      // 6f: goto 73
      // 72: athrow
      // 73: bipush 0
      // 74: istore 5
      // 76: iload 2
      // 77: ifeq b4
      // 7a: aload 4
      // 7c: ldc "refresh"
      // 7e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 81: iload 2
      // 82: ifne b6
      // 85: goto 89
      // 88: athrow
      // 89: ifeq b4
      // 8c: goto 90
      // 8f: athrow
      // 90: bipush 1
      // 91: istore 5
      // 93: iload 2
      // 94: ifeq b4
      // 97: aload 4
      // 99: ldc "load"
      // 9b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 9e: iload 2
      // 9f: ifne b6
      // a2: goto a6
      // a5: athrow
      // a6: ifeq b4
      // a9: goto ad
      // ac: athrow
      // ad: ldc 8472225
      // af: ldc 8472227
      // b1: ixor
      // b2: istore 5
      // b4: iload 5
      // b6: tableswitch 47 0 2 26 32 32
      // d0: aload 0
      // d1: invokevirtual x/oc62c8c02d34.ϔ ()V
      // d4: return
      // d5: athrow
      // d6: getstatic x/oc9755810e45.ř Lkeystrokesmod/script/Manager;
      // d9: invokestatic java/lang/System.currentTimeMillis ()J
      // dc: invokevirtual keystrokesmod/script/Manager.loadScripts (J)V
      // df: ldc "&7Scripts refreshed from &bmiau/scripts&7."
      // e1: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // e4: return
      // e5: ldc "&cUsage: .script <load|list|refresh>"
      // e7: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // ea: return
   }

   private void ϔ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 1
      // 004: getstatic keystrokesmod/oc502dfc7784.ң Lkeystrokesmod/script/ScriptManager;
      // 007: iload 1
      // 008: ifne 01c
      // 00b: ifnonnull 019
      // 00e: goto 012
      // 011: athrow
      // 012: ldc "&cScript manager is unavailable."
      // 014: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 017: return
      // 018: athrow
      // 019: getstatic keystrokesmod/oc502dfc7784.ң Lkeystrokesmod/script/ScriptManager;
      // 01c: getfield keystrokesmod/script/ScriptManager.scripts Ljava/util/LinkedHashMap;
      // 01f: astore 2
      // 020: iload 1
      // 021: ifne 03a
      // 024: aload 2
      // 025: invokeinterface java/util/Map.isEmpty ()Z 1
      // 02a: ifeq 03b
      // 02d: goto 031
      // 030: athrow
      // 031: ldc "&7No scripts loaded. Use &b.script refresh&7."
      // 033: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 036: goto 03a
      // 039: athrow
      // 03a: return
      // 03b: new java/util/ArrayList
      // 03e: dup
      // 03f: invokespecial java/util/ArrayList.<init> ()V
      // 042: astore 3
      // 043: aload 2
      // 044: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 049: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 04e: astore 4
      // 050: aload 4
      // 052: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 057: ifeq 0a9
      // 05a: aload 4
      // 05c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 061: iload 1
      // 062: ifne 0f4
      // 065: checkcast java/util/Map$Entry
      // 068: astore 5
      // 06a: aload 5
      // 06c: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 071: checkcast keystrokesmod/script/Script
      // 074: astore 6
      // 076: aload 6
      // 078: getfield keystrokesmod/script/Script.error Z
      // 07b: ifeq 084
      // 07e: ldc " &c[compile error]"
      // 080: goto 086
      // 083: athrow
      // 084: ldc ""
      // 086: astore 7
      // 088: iload 1
      // 089: aload 3
      // 08a: aload 6
      // 08c: getfield keystrokesmod/script/Script.name Ljava/lang/String;
      // 08f: aload 7
      // 091: astore 8
      // 093: astore 9
      // 095: ldc " &7- &f"
      // 097: aload 9
      // 099: aload 8
      // 09b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0a0: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0a5: pop
      // 0a6: ifeq 050
      // 0a9: aload 3
      // 0aa: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 0ad: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 0b2: aload 3
      // 0b3: invokeinterface java/util/List.size ()I 1
      // 0b8: aload 3
      // 0b9: invokeinterface java/util/List.size ()I 1
      // 0be: bipush 1
      // 0bf: if_icmpne 0c8
      // 0c2: ldc ""
      // 0c4: goto 0ca
      // 0c7: athrow
      // 0c8: ldc "s"
      // 0ca: ldc "&b"
      // 0cc: dup_x2
      // 0cd: pop
      // 0ce: ldc " &7script"
      // 0d0: swap
      // 0d1: ldc ":"
      // 0d3: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 0d8: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 0db: aload 3
      // 0dc: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0e1: astore 4
      // 0e3: aload 4
      // 0e5: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ea: ifeq 102
      // 0ed: aload 4
      // 0ef: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0f4: checkcast java/lang/String
      // 0f7: astore 5
      // 0f9: iload 1
      // 0fa: aload 5
      // 0fc: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 0ff: ifeq 0e3
      // 102: return
   }

   public List<String> z$9ofids0wyz4j(ocaae9de8508 var1) {
      if (var1.у().length <= 1) {
         ArrayList var2 = new ArrayList();
         var2.add("list");
         var2.add("refresh");
         var2.add("load");
         return var2;
      } else {
         return Collections.emptyList();
      }
   }

   public int z$7k2utc7u0w8s(ocaae9de8508 var1) {
      return 0;
   }
}
