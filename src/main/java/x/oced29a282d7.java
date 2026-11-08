package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IChatComponent;

public class oced29a282d7 extends oc69da1aa7f5 {
   private static final long ռ = 250L;
   private static final int Ρ = 1;
   private static final String Ѓ = "miau";
   private static final String ŉ = "Player";
   public static String Ɏ = "miau";
   public static occ2f8dff8d8 Ӗ;
   public static oc321b4679dd ǳ;
   public static oc321b4679dd ϵ;
   private static final LinkedHashSet<String> Ü = new LinkedHashSet<>();
   private static String ö = "miau";
   private static String Ͷ = "Player";
   private static String ʚ;
   private static boolean F;
   private static List<String> ø = Collections.emptyList();
   private static Map<String, List<String>> Ϸ = Collections.emptyMap();
   private static List<Entry<String, String>> Ƀ = Collections.emptyList();
   private static Map<String, Integer> Ԁ = Collections.emptyMap();
   private static long Ĺ;
   private static int ý;
   private static int ǣ = -1;
   private static String ȓ;
   private static String r;
   public static int ѷ;

   public oced29a282d7() {
      super("NameHider", oce4cea752dd.Ҧ);
      this.ą("Replaces player names with aliases in displayed text.");
      this.ʌ(ǳ = new oc41d6282770(this, "Fake name", Ɏ, "Type a fake name...", -1543951515 ^ -1543951531));
      this.ʌ(Ӗ = new occ2f8dff8d8("Hide all names", false));
      this.ʌ(ϵ = new ocb958636f5d(this, "Hide-all prefix", "Player", "Type a prefix...", -1543951539 ^ -1543951531));
      ϵ.Ӏ = false;
      Ɨ(ǳ.Ê());
   }

   public static String ͷ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: aload 0
      // 05: invokestatic x/oced29a282d7.ŕ (Ljava/lang/String;)Z
      // 08: iload 1
      // 09: ifne 1c
      // 0c: ifne 16
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: areturn
      // 15: athrow
      // 16: invokestatic x/oced29a282d7.ս ()V
      // 19: getstatic x/oced29a282d7.ǣ I
      // 1c: iload 1
      // 1d: ifne 3d
      // 20: getstatic x/oced29a282d7.ý I
      // 23: if_icmpne 45
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 1
      // 2c: ifne 4f
      // 2f: goto 33
      // 32: athrow
      // 33: getstatic x/oced29a282d7.ȓ Ljava/lang/String;
      // 36: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 39: goto 3d
      // 3c: athrow
      // 3d: ifeq 45
      // 40: getstatic x/oced29a282d7.r Ljava/lang/String;
      // 43: areturn
      // 44: athrow
      // 45: aload 0
      // 46: getstatic x/oced29a282d7.ø Ljava/util/List;
      // 49: getstatic x/oced29a282d7.ö Ljava/lang/String;
      // 4c: invokestatic x/oced29a282d7.ģ (Ljava/lang/String;Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;
      // 4f: astore 2
      // 50: iload 1
      // 51: ifne aa
      // 54: getstatic x/oced29a282d7.F Z
      // 57: ifeq 9c
      // 5a: goto 5e
      // 5d: athrow
      // 5e: getstatic x/oced29a282d7.Ƀ Ljava/util/List;
      // 61: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 66: astore 3
      // 67: aload 3
      // 68: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 6d: ifeq 9c
      // 70: aload 3
      // 71: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 76: checkcast java/util/Map$Entry
      // 79: astore 4
      // 7b: iload 1
      // 7c: ifne aa
      // 7f: aload 2
      // 80: aload 4
      // 82: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 87: checkcast java/lang/String
      // 8a: aload 4
      // 8c: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 91: checkcast java/lang/String
      // 94: invokestatic x/oca222284e44.Ȋ (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 97: astore 2
      // 98: iload 1
      // 99: ifeq 67
      // 9c: aload 0
      // 9d: putstatic x/oced29a282d7.ȓ Ljava/lang/String;
      // a0: aload 2
      // a1: putstatic x/oced29a282d7.r Ljava/lang/String;
      // a4: getstatic x/oced29a282d7.ý I
      // a7: putstatic x/oced29a282d7.ǣ I
      // aa: aload 2
      // ab: areturn
   }

   public static IChatComponent Ҥ(EntityPlayer param0, IChatComponent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 2d
      // 09: ifnull 28
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 32
      // 15: goto 19
      // 18: athrow
      // 19: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 1e: invokestatic x/oced29a282d7.ŕ (Ljava/lang/String;)Z
      // 21: ifne 2e
      // 24: goto 28
      // 27: athrow
      // 28: aload 1
      // 29: goto 2d
      // 2c: athrow
      // 2d: areturn
      // 2e: invokestatic x/oced29a282d7.ս ()V
      // 31: aload 1
      // 32: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 37: astore 3
      // 38: aload 0
      // 39: aload 3
      // 3a: invokestatic x/oced29a282d7.ҵ (Lnet/minecraft/entity/player/EntityPlayer;Ljava/lang/String;)Ljava/lang/String;
      // 3d: astore 4
      // 3f: aload 3
      // 40: aload 4
      // 42: invokestatic java/util/Objects.equals (Ljava/lang/Object;Ljava/lang/Object;)Z
      // 45: ifeq 4b
      // 48: aload 1
      // 49: areturn
      // 4a: athrow
      // 4b: new net/minecraft/util/ChatComponentText
      // 4e: dup
      // 4f: aload 4
      // 51: invokespecial net/minecraft/util/ChatComponentText.<init> (Ljava/lang/String;)V
      // 54: astore 5
      // 56: aload 5
      // 58: aload 1
      // 59: invokeinterface net/minecraft/util/IChatComponent.getChatStyle ()Lnet/minecraft/util/ChatStyle; 1
      // 5e: invokevirtual net/minecraft/util/ChatStyle.createShallowCopy ()Lnet/minecraft/util/ChatStyle;
      // 61: invokevirtual net/minecraft/util/ChatComponentText.setChatStyle (Lnet/minecraft/util/ChatStyle;)Lnet/minecraft/util/IChatComponent;
      // 64: pop
      // 65: aload 5
      // 67: areturn
   }

   public static String я(NetworkPlayerInfo param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 1d
      // 09: invokestatic x/oced29a282d7.ŕ (Ljava/lang/String;)Z
      // 0c: ifne 16
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: areturn
      // 15: athrow
      // 16: invokestatic x/oced29a282d7.ս ()V
      // 19: aload 0
      // 1a: invokestatic x/oced29a282d7.û (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // 1d: astore 3
      // 1e: aload 3
      // 1f: iload 2
      // 20: ifne 2e
      // 23: ifnonnull 2d
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 1
      // 2b: areturn
      // 2c: athrow
      // 2d: aload 3
      // 2e: invokestatic x/oced29a282d7.Ő (Ljava/lang/String;)Z
      // 31: iload 2
      // 32: ifne 4d
      // 35: ifeq 4a
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 1
      // 3d: aload 0
      // 3e: aload 3
      // 3f: invokestatic x/oced29a282d7.Ԛ (Lnet/minecraft/client/network/NetworkPlayerInfo;Ljava/lang/String;)Ljava/util/List;
      // 42: getstatic x/oced29a282d7.ö Ljava/lang/String;
      // 45: invokestatic x/oced29a282d7.ģ (Ljava/lang/String;Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;
      // 48: areturn
      // 49: athrow
      // 4a: getstatic x/oced29a282d7.F Z
      // 4d: ifne 53
      // 50: aload 1
      // 51: areturn
      // 52: athrow
      // 53: aload 3
      // 54: invokestatic x/oced29a282d7.ş (Ljava/lang/String;)Ljava/lang/String;
      // 57: astore 4
      // 59: aload 4
      // 5b: iload 2
      // 5c: ifne 6c
      // 5f: ifnonnull 6b
      // 62: goto 66
      // 65: athrow
      // 66: aload 1
      // 67: goto 76
      // 6a: athrow
      // 6b: aload 1
      // 6c: aload 0
      // 6d: aload 3
      // 6e: invokestatic x/oced29a282d7.Ԛ (Lnet/minecraft/client/network/NetworkPlayerInfo;Ljava/lang/String;)Ljava/util/List;
      // 71: aload 4
      // 73: invokestatic x/oced29a282d7.ģ (Ljava/lang/String;Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;
      // 76: areturn
   }

   public static void Û(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: invokestatic x/oced29a282d7.Ӱ (Ljava/lang/String;)Ljava/lang/String;
      // 09: astore 2
      // 0a: ifne 3d
      // 0d: getstatic x/oced29a282d7.ǳ Lx/oc321b4679dd;
      // 10: ifnull 39
      // 13: goto 17
      // 16: athrow
      // 17: aload 2
      // 18: iload 1
      // 19: ifne 3a
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/oced29a282d7.ǳ Lx/oc321b4679dd;
      // 23: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 26: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 29: ifne 39
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic x/oced29a282d7.ǳ Lx/oc321b4679dd;
      // 33: aload 2
      // 34: invokevirtual x/oc321b4679dd.z$1bnplyl2p7uqx (Ljava/lang/String;)V
      // 37: return
      // 38: athrow
      // 39: aload 2
      // 3a: invokestatic x/oced29a282d7.Ɨ (Ljava/lang/String;)V
      // 3d: return
   }

   public static void р() {
      Û("miau");
   }

   public static String ԍ() {
      return "miau";
   }

   private static String ҵ(EntityPlayer param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: areturn
      // 12: athrow
      // 13: aload 0
      // 14: invokestatic x/oced29a282d7.ѵ (Lnet/minecraft/entity/player/EntityPlayer;)Ljava/lang/String;
      // 17: astore 3
      // 18: aload 0
      // 19: aload 3
      // 1a: invokestatic x/oced29a282d7.ʭ (Lnet/minecraft/entity/player/EntityPlayer;Ljava/lang/String;)Z
      // 1d: iload 2
      // 1e: ifne 39
      // 21: ifeq 36
      // 24: goto 28
      // 27: athrow
      // 28: aload 1
      // 29: aload 0
      // 2a: aload 3
      // 2b: invokestatic x/oced29a282d7.Ҭ (Lnet/minecraft/entity/player/EntityPlayer;Ljava/lang/String;)Ljava/util/List;
      // 2e: getstatic x/oced29a282d7.ö Ljava/lang/String;
      // 31: invokestatic x/oced29a282d7.ģ (Ljava/lang/String;Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;
      // 34: areturn
      // 35: athrow
      // 36: getstatic x/oced29a282d7.F Z
      // 39: ifne 3f
      // 3c: aload 1
      // 3d: areturn
      // 3e: athrow
      // 3f: aload 3
      // 40: invokestatic x/oced29a282d7.ş (Ljava/lang/String;)Ljava/lang/String;
      // 43: astore 4
      // 45: aload 4
      // 47: iload 2
      // 48: ifne 58
      // 4b: ifnonnull 57
      // 4e: goto 52
      // 51: athrow
      // 52: aload 1
      // 53: goto 62
      // 56: athrow
      // 57: aload 1
      // 58: aload 0
      // 59: aload 3
      // 5a: invokestatic x/oced29a282d7.Ҭ (Lnet/minecraft/entity/player/EntityPlayer;Ljava/lang/String;)Ljava/util/List;
      // 5d: aload 4
      // 5f: invokestatic x/oced29a282d7.ģ (Ljava/lang/String;Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;
      // 62: areturn
   }

   private static void ս() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc89eb238246.ħ I
      // 003: istore 0
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: ifnonnull 00f
      // 00d: return
      // 00e: athrow
      // 00f: getstatic x/oced29a282d7.Ӗ Lx/occ2f8dff8d8;
      // 012: iload 0
      // 013: ifne 020
      // 016: ifnull 032
      // 019: goto 01d
      // 01c: athrow
      // 01d: getstatic x/oced29a282d7.Ӗ Lx/occ2f8dff8d8;
      // 020: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 023: iload 0
      // 024: ifne 02f
      // 027: ifeq 032
      // 02a: goto 02e
      // 02d: athrow
      // 02e: bipush 1
      // 02f: goto 033
      // 032: bipush 0
      // 033: istore 1
      // 034: iload 0
      // 035: ifne 04e
      // 038: getstatic x/oced29a282d7.F Z
      // 03b: iload 1
      // 03c: if_icmpeq 051
      // 03f: goto 043
      // 042: athrow
      // 043: iload 1
      // 044: putstatic x/oced29a282d7.F Z
      // 047: invokestatic x/oced29a282d7.Ղ ()V
      // 04a: goto 04e
      // 04d: athrow
      // 04e: invokestatic x/oced29a282d7.յ ()V
      // 051: invokestatic x/oced29a282d7.Ѧ ()Ljava/lang/String;
      // 054: astore 2
      // 055: iload 0
      // 056: ifne 06f
      // 059: getstatic x/oced29a282d7.ʚ Ljava/lang/String;
      // 05c: aload 2
      // 05d: invokestatic java/util/Objects.equals (Ljava/lang/Object;Ljava/lang/Object;)Z
      // 060: ifne 072
      // 063: goto 067
      // 066: athrow
      // 067: aload 2
      // 068: putstatic x/oced29a282d7.ʚ Ljava/lang/String;
      // 06b: goto 06f
      // 06e: athrow
      // 06f: invokestatic x/oced29a282d7.յ ()V
      // 072: invokestatic x/oced29a282d7.j ()Ljava/util/List;
      // 075: astore 3
      // 076: aload 3
      // 077: getstatic x/oced29a282d7.ø Ljava/util/List;
      // 07a: invokeinterface java/util/List.equals (Ljava/lang/Object;)Z 2
      // 07f: iload 0
      // 080: ifne 096
      // 083: ifne 095
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 3
      // 08b: putstatic x/oced29a282d7.ø Ljava/util/List;
      // 08e: invokestatic x/oced29a282d7.յ ()V
      // 091: goto 095
      // 094: athrow
      // 095: iload 1
      // 096: ifne 09a
      // 099: return
      // 09a: invokestatic java/lang/System.currentTimeMillis ()J
      // 09d: lstore 4
      // 09f: lload 4
      // 0a1: iload 0
      // 0a2: ifne 0bc
      // 0a5: getstatic x/oced29a282d7.Ĺ J
      // 0a8: lsub
      // 0a9: ldc2_w 5934057986982904652
      // 0ac: ldc2_w 5934057986982904758
      // 0af: lxor
      // 0b0: lcmp
      // 0b1: ifge 0ba
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: return
      // 0b9: athrow
      // 0ba: lload 4
      // 0bc: putstatic x/oced29a282d7.Ĺ J
      // 0bf: iload 0
      // 0c0: aload 3
      // 0c1: invokestatic x/oced29a282d7.Ǹ (Ljava/util/List;)Lx/oc3ab96b9c8b;
      // 0c4: astore 6
      // 0c6: ifne 131
      // 0c9: aload 6
      // 0cb: getfield x/oc3ab96b9c8b.ξ Ljava/util/Map;
      // 0ce: getstatic x/oced29a282d7.Ϸ Ljava/util/Map;
      // 0d1: invokeinterface java/util/Map.equals (Ljava/lang/Object;)Z 2
      // 0d6: ifeq 115
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 6
      // 0df: iload 0
      // 0e0: ifne 12b
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: getfield x/oc3ab96b9c8b.ʟ Ljava/util/Map;
      // 0ea: getstatic x/oced29a282d7.Ԁ Ljava/util/Map;
      // 0ed: invokeinterface java/util/Map.equals (Ljava/lang/Object;)Z 2
      // 0f2: ifeq 115
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: aload 6
      // 0fb: iload 0
      // 0fc: ifne 12b
      // 0ff: goto 103
      // 102: athrow
      // 103: getfield x/oc3ab96b9c8b.Ţ Ljava/util/List;
      // 106: getstatic x/oced29a282d7.Ƀ Ljava/util/List;
      // 109: invokeinterface java/util/List.equals (Ljava/lang/Object;)Z 2
      // 10e: ifne 134
      // 111: goto 115
      // 114: athrow
      // 115: aload 6
      // 117: getfield x/oc3ab96b9c8b.ξ Ljava/util/Map;
      // 11a: putstatic x/oced29a282d7.Ϸ Ljava/util/Map;
      // 11d: aload 6
      // 11f: getfield x/oc3ab96b9c8b.ʟ Ljava/util/Map;
      // 122: putstatic x/oced29a282d7.Ԁ Ljava/util/Map;
      // 125: aload 6
      // 127: goto 12b
      // 12a: athrow
      // 12b: getfield x/oc3ab96b9c8b.Ţ Ljava/util/List;
      // 12e: putstatic x/oced29a282d7.Ƀ Ljava/util/List;
      // 131: invokestatic x/oced29a282d7.յ ()V
      // 134: return
   }

   private static oc3ab96b9c8b Ǹ(List<String> var0) {
      int var10000 = oc89eb238246.ħ;
      LinkedHashMap var2 = new LinkedHashMap();
      int var1 = var10000;
      HashSet var3 = new HashSet();
      Iterator var4 = var0.iterator();

      label108: {
         while (true) {
            if (var4.hasNext()) {
               String var5 = (String)var4.next();

               try {
                  var22 = var3.add(Ӌ(var5));
                  if (var1 != 0) {
                     break;
                  }

                  if (var1 == 0) {
                     continue;
                  }
               } catch (ocbde1165e4e var17) {
                  throw var17;
               }
            }

            try {
               ʶ(var2, var3);
               var23 = var2;
               if (var1 != 0) {
                  break label108;
               }

               Ո(var2, var3);
               var22 = var2.isEmpty();
               break;
            } catch (ocbde1165e4e var15) {
               throw var15;
            }
         }

         try {
            if (var22) {
               return oc3ab96b9c8b.ј;
            }
         } catch (ocbde1165e4e var16) {
            throw var16;
         }

         var23 = new LinkedHashMap();
      }

      LinkedHashMap var18 = var23;
      Iterator var19 = var2.entrySet().iterator();

      while (true) {
         if (var19.hasNext()) {
            Entry var6 = (Entry)var19.next();

            try {
               var24 = var18;
               if (var1 != 0) {
                  break;
               }

               var18.put((String)var6.getKey(), ʩ((Iterable<String>)var6.getValue()));
               if (var1 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var14) {
               throw var14;
            }
         }

         var24 = f(var18.keySet());
         break;
      }

      LinkedHashMap var20 = var24;
      ArrayList var21 = new ArrayList();
      Iterator var7 = var18.entrySet().iterator();

      label70:
      while (true) {
         if (var7.hasNext()) {
            Entry var8 = (Entry)var7.next();
            if (var1 != 0) {
               break;
            }

            Integer var9 = (Integer)var20.get(var8.getKey());

            try {
               if (var9 == null && var1 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var13) {
               throw var13;
            }

            String var10 = Ͷ + var9;

            for (String var12 : (List)var8.getValue()) {
               if (var1 != 0) {
                  continue label70;
               }

               var21.add(new SimpleEntry<>(var12, var10));
               if (var1 != 0) {
                  break;
               }
            }

            if (var1 == 0) {
               continue;
            }
         }

         var21.sort(new oc48bae949ec());
         break;
      }

      return new oc3ab96b9c8b(var18, var20, var21);
   }

   private static void ʶ(Map<String, LinkedHashSet<String>> param0, Set<String> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 2
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 2
      // 08: ifne 1c
      // 0b: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 0e: ifnull 25
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 1f: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfoMap ()Ljava/util/Collection;
      // 22: ifnonnull 27
      // 25: return
      // 26: athrow
      // 27: invokestatic x/oced29a282d7.ҷ ()Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 2a: astore 3
      // 2b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2e: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 31: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfoMap ()Ljava/util/Collection;
      // 34: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 39: astore 4
      // 3b: aload 4
      // 3d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 42: ifeq 7f
      // 45: aload 4
      // 47: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4c: checkcast net/minecraft/client/network/NetworkPlayerInfo
      // 4f: astore 5
      // 51: aload 5
      // 53: iload 2
      // 54: ifne 60
      // 57: ifnull 3b
      // 5a: goto 5e
      // 5d: athrow
      // 5e: aload 5
      // 60: aload 3
      // 61: if_acmpne 6c
      // 64: iload 2
      // 65: ifeq 3b
      // 68: goto 6c
      // 6b: athrow
      // 6c: aload 0
      // 6d: aload 1
      // 6e: aload 5
      // 70: invokestatic x/oced29a282d7.û (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // 73: aload 5
      // 75: invokestatic x/oced29a282d7.Ғ (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // 78: invokestatic x/oced29a282d7.ʵ (Ljava/util/Map;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;)V
      // 7b: iload 2
      // 7c: ifeq 3b
      // 7f: return
   }

   private static void Ո(Map<String, LinkedHashSet<String>> param0, Set<String> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 2
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 2
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e: ifnull 2d
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 2
      // 1d: ifne 32
      // 20: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 23: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 26: ifnonnull 2f
      // 29: goto 2d
      // 2c: athrow
      // 2d: return
      // 2e: athrow
      // 2f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 32: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 35: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 38: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3d: astore 3
      // 3e: aload 3
      // 3f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 44: ifeq d2
      // 47: aload 3
      // 48: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4d: checkcast net/minecraft/entity/player/EntityPlayer
      // 50: astore 4
      // 52: aload 4
      // 54: iload 2
      // 55: ifne 61
      // 58: ifnull 3e
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 4
      // 61: iload 2
      // 62: ifne 7c
      // 65: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 68: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6b: if_acmpne 7a
      // 6e: goto 72
      // 71: athrow
      // 72: iload 2
      // 73: ifeq 3e
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 4
      // 7c: invokestatic x/oced29a282d7.է (Lnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 7f: astore 5
      // 81: aload 5
      // 83: iload 2
      // 84: ifne 90
      // 87: ifnull 96
      // 8a: goto 8e
      // 8d: athrow
      // 8e: aload 5
      // 90: invokestatic x/oced29a282d7.û (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // 93: goto a3
      // 96: aload 4
      // 98: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 9b: aload 4
      // 9d: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // a0: invokestatic x/oced29a282d7.Ԁ (Ljava/util/UUID;Ljava/lang/String;)Ljava/lang/String;
      // a3: astore 6
      // a5: aload 0
      // a6: iload 2
      // a7: ifne c3
      // aa: aload 1
      // ab: aload 6
      // ad: aload 4
      // af: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // b2: invokestatic x/oced29a282d7.ʵ (Ljava/util/Map;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;)V
      // b5: aload 5
      // b7: ifnull ce
      // ba: goto be
      // bd: athrow
      // be: aload 0
      // bf: goto c3
      // c2: athrow
      // c3: aload 1
      // c4: aload 6
      // c6: aload 5
      // c8: invokestatic x/oced29a282d7.Ғ (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // cb: invokestatic x/oced29a282d7.ʵ (Ljava/util/Map;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;)V
      // ce: iload 2
      // cf: ifeq 3e
      // d2: return
   }

   private static void ʵ(Map<String, LinkedHashSet<String>> param0, Set<String> param1, String param2, String param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: aload 3
      // 04: invokestatic x/oced29a282d7.ӣ (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 5
      // 09: istore 4
      // 0b: aload 2
      // 0c: iload 4
      // 0e: ifne 1a
      // 11: ifnull 44
      // 14: goto 18
      // 17: athrow
      // 18: aload 5
      // 1a: invokevirtual java/lang/String.isEmpty ()Z
      // 1d: iload 4
      // 1f: ifne 41
      // 22: ifne 44
      // 25: goto 29
      // 28: athrow
      // 29: aload 1
      // 2a: iload 4
      // 2c: ifne 4c
      // 2f: goto 33
      // 32: athrow
      // 33: aload 5
      // 35: invokestatic x/oced29a282d7.Ӌ (Ljava/lang/String;)Ljava/lang/String;
      // 38: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 3d: goto 41
      // 40: athrow
      // 41: ifeq 45
      // 44: return
      // 45: aload 0
      // 46: aload 2
      // 47: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 4c: checkcast java/util/LinkedHashSet
      // 4f: astore 6
      // 51: iload 4
      // 53: ifne 7a
      // 56: aload 6
      // 58: ifnonnull 72
      // 5b: goto 5f
      // 5e: athrow
      // 5f: new java/util/LinkedHashSet
      // 62: dup
      // 63: invokespecial java/util/LinkedHashSet.<init> ()V
      // 66: astore 6
      // 68: aload 0
      // 69: aload 2
      // 6a: aload 6
      // 6c: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 71: pop
      // 72: aload 6
      // 74: aload 5
      // 76: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 79: pop
      // 7a: return
   }

   private static LinkedHashMap<String, Integer> f(Set<String> param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new java/util/LinkedHashMap
      // 03: dup
      // 04: invokespecial java/util/LinkedHashMap.<init> ()V
      // 07: astore 2
      // 08: getstatic x/oc89eb238246.ħ I
      // 0b: new java/util/HashSet
      // 0e: dup
      // 0f: invokespecial java/util/HashSet.<init> ()V
      // 12: astore 3
      // 13: istore 1
      // 14: aload 0
      // 15: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 1a: astore 4
      // 1c: aload 4
      // 1e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 23: ifeq 70
      // 26: aload 4
      // 28: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2d: checkcast java/lang/String
      // 30: astore 5
      // 32: getstatic x/oced29a282d7.Ԁ Ljava/util/Map;
      // 35: aload 5
      // 37: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 3c: checkcast java/lang/Integer
      // 3f: iload 1
      // 40: ifne 89
      // 43: astore 6
      // 45: aload 6
      // 47: ifnull 6c
      // 4a: aload 3
      // 4b: iload 1
      // 4c: ifne 6b
      // 4f: goto 53
      // 52: athrow
      // 53: aload 6
      // 55: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 58: ifeq 6c
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 2
      // 60: aload 5
      // 62: aload 6
      // 64: invokevirtual java/util/LinkedHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 67: goto 6b
      // 6a: athrow
      // 6b: pop
      // 6c: iload 1
      // 6d: ifeq 1c
      // 70: aload 0
      // 71: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 76: astore 4
      // 78: aload 4
      // 7a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 7f: ifeq e7
      // 82: aload 4
      // 84: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 89: checkcast java/lang/String
      // 8c: astore 5
      // 8e: aload 2
      // 8f: iload 1
      // 90: ifne e8
      // 93: aload 5
      // 95: invokevirtual java/util/LinkedHashMap.containsKey (Ljava/lang/Object;)Z
      // 98: iload 1
      // 99: ifne b0
      // 9c: goto a0
      // 9f: athrow
      // a0: ifeq af
      // a3: goto a7
      // a6: athrow
      // a7: iload 1
      // a8: ifeq 78
      // ab: goto af
      // ae: athrow
      // af: bipush 1
      // b0: istore 6
      // b2: aload 3
      // b3: iload 6
      // b5: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // b8: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // bb: ifeq cd
      // be: iload 1
      // bf: ifne e3
      // c2: iinc 6 1
      // c5: iload 1
      // c6: ifeq b2
      // c9: goto cd
      // cc: athrow
      // cd: aload 2
      // ce: aload 5
      // d0: iload 6
      // d2: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // d5: invokevirtual java/util/LinkedHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // d8: pop
      // d9: aload 3
      // da: iload 6
      // dc: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // df: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // e2: pop
      // e3: iload 1
      // e4: ifeq 78
      // e7: aload 2
      // e8: areturn
   }

   private static List<String> j() {
      int var10000 = oc89eb238246.ħ;
      և(oc69da1aa7f5.ő.thePlayer.getName());
      NetworkPlayerInfo var1 = ҷ();
      int var0 = var10000;

      label20: {
         try {
            var3 = var1;
            if (var0 != 0) {
               break label20;
            }

            if (var1 == null) {
               return ʩ(Ü);
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var3 = var1;
      }

      և(Ғ(var3));
      return ʩ(Ü);
   }

   private static boolean և(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: aload 0
      // 04: invokestatic x/oced29a282d7.ӣ (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: invokevirtual java/lang/String.isEmpty ()Z
      // 0d: iload 1
      // 0e: ifne 23
      // 11: ifne 32
      // 14: goto 18
      // 17: athrow
      // 18: getstatic x/oced29a282d7.Ü Ljava/util/LinkedHashSet;
      // 1b: aload 2
      // 1c: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 1f: goto 23
      // 22: athrow
      // 23: iload 1
      // 24: ifne 2f
      // 27: ifeq 32
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush 1
      // 2f: goto 33
      // 32: bipush 0
      // 33: ireturn
   }

   private static List<String> Ҭ(EntityPlayer var0, String var1) {
      LinkedHashSet var2 = new LinkedHashSet();
      č(var2, Ϸ.get(var1));
      F(var2, var0.getName());
      NetworkPlayerInfo var3 = է(var0);

      try {
         if (var3 != null) {
            F(var2, Ғ(var3));
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      try {
         if (ʭ(var0, var1)) {
            č(var2, ø);
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }

      return ʩ(var2);
   }

   private static List<String> Ԛ(NetworkPlayerInfo param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: new java/util/LinkedHashSet
      // 06: dup
      // 07: invokespecial java/util/LinkedHashSet.<init> ()V
      // 0a: astore 3
      // 0b: istore 2
      // 0c: aload 3
      // 0d: iload 2
      // 0e: ifne 3f
      // 11: getstatic x/oced29a282d7.Ϸ Ljava/util/Map;
      // 14: aload 1
      // 15: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1a: checkcast java/lang/Iterable
      // 1d: invokestatic x/oced29a282d7.č (Ljava/util/Set;Ljava/lang/Iterable;)V
      // 20: aload 3
      // 21: aload 0
      // 22: invokestatic x/oced29a282d7.Ғ (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // 25: invokestatic x/oced29a282d7.F (Ljava/util/Set;Ljava/lang/String;)V
      // 28: aload 1
      // 29: invokestatic x/oced29a282d7.Ő (Ljava/lang/String;)Z
      // 2c: ifeq 3e
      // 2f: goto 33
      // 32: athrow
      // 33: aload 3
      // 34: getstatic x/oced29a282d7.ø Ljava/util/List;
      // 37: invokestatic x/oced29a282d7.č (Ljava/util/Set;Ljava/lang/Iterable;)V
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 3
      // 3f: invokestatic x/oced29a282d7.ʩ (Ljava/lang/Iterable;)Ljava/util/List;
      // 42: areturn
   }

   private static void č(Set<String> var0, Iterable<String> var1) {
      int var2 = oc89eb238246.ħ;

      Iterable var10000;
      label32: {
         try {
            var10000 = var1;
            if (var2 != 0) {
               break label32;
            }

            if (var1 == null) {
               return;
            }
         } catch (ocbde1165e4e var5) {
            throw var5;
         }

         var10000 = var1;
      }

      for (String var4 : var10000) {
         F(var0, var4);
         if (var2 != 0) {
            break;
         }
      }
   }

   private static void F(Set<String> param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: aload 1
      // 04: invokestatic x/oced29a282d7.ӣ (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 3
      // 0a: invokevirtual java/lang/String.isEmpty ()Z
      // 0d: iload 2
      // 0e: ifne 23
      // 11: ifne 24
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: aload 3
      // 1a: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 1f: goto 23
      // 22: athrow
      // 23: pop
      // 24: return
   }

   private static List<String> ʩ(Iterable<String> param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: iload 1
      // 05: new java/util/ArrayList
      // 08: dup
      // 09: invokespecial java/util/ArrayList.<init> ()V
      // 0c: astore 2
      // 0d: ifne 79
      // 10: aload 0
      // 11: ifnull 6e
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: invokeinterface java/lang/Iterable.iterator ()Ljava/util/Iterator; 1
      // 1e: astore 3
      // 1f: aload 3
      // 20: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 25: ifeq 6e
      // 28: aload 3
      // 29: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2e: checkcast java/lang/String
      // 31: astore 4
      // 33: iload 1
      // 34: ifne 79
      // 37: aload 4
      // 39: invokestatic x/oced29a282d7.ӣ (Ljava/lang/String;)Ljava/lang/String;
      // 3c: astore 5
      // 3e: aload 5
      // 40: invokevirtual java/lang/String.isEmpty ()Z
      // 43: iload 1
      // 44: ifne 60
      // 47: ifne 6a
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 2
      // 4f: iload 1
      // 50: ifne 64
      // 53: goto 57
      // 56: athrow
      // 57: aload 5
      // 59: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 5c: goto 60
      // 5f: athrow
      // 60: ifne 6a
      // 63: aload 2
      // 64: aload 5
      // 66: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 69: pop
      // 6a: iload 1
      // 6b: ifeq 1f
      // 6e: aload 2
      // 6f: new x/oc36e8d7342a
      // 72: dup
      // 73: invokespecial x/oc36e8d7342a.<init> ()V
      // 76: invokestatic java/util/Collections.sort (Ljava/util/List;Ljava/util/Comparator;)V
      // 79: aload 2
      // 7a: areturn
   }

   private static String ģ(String var0, Iterable<String> var1, String var2) {
      int var10000 = oc89eb238246.ħ;
      String var4 = oca222284e44.ǰ(var0, var1, var2);
      int var3 = var10000;

      try {
         if (var3 != 0) {
            return var4;
         }

         if (var4 == null) {
            return var0;
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }

      return var4;
   }

   private static NetworkPlayerInfo ҷ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 0
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 0
      // 08: ifne 1c
      // 0b: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 0e: ifnull 2a
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 0
      // 1d: ifne 32
      // 20: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 23: ifnonnull 2f
      // 26: goto 2a
      // 29: athrow
      // 2a: aconst_null
      // 2b: goto 41
      // 2e: athrow
      // 2f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 32: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 35: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 38: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getUniqueID ()Ljava/util/UUID;
      // 3e: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfo (Ljava/util/UUID;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 41: areturn
   }

   private static NetworkPlayerInfo է(EntityPlayer param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 06: ifnull 11
      // 09: aload 0
      // 0a: ifnonnull 16
      // 0d: goto 11
      // 10: athrow
      // 11: aconst_null
      // 12: goto 23
      // 15: athrow
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 1c: aload 0
      // 1d: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 20: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfo (Ljava/util/UUID;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 23: areturn
   }

   private static String Ѧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: invokestatic x/oced29a282d7.ҷ ()Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 06: astore 1
      // 07: istore 0
      // 08: aload 1
      // 09: iload 0
      // 0a: ifne 15
      // 0d: ifnull 19
      // 10: goto 14
      // 13: athrow
      // 14: aload 1
      // 15: invokestatic x/oced29a282d7.û (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // 18: areturn
      // 19: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c: iload 0
      // 1d: ifne 32
      // 20: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 23: ifnonnull 2f
      // 26: goto 2a
      // 29: athrow
      // 2a: aconst_null
      // 2b: goto 44
      // 2e: athrow
      // 2f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 32: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 35: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getUniqueID ()Ljava/util/UUID;
      // 38: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getName ()Ljava/lang/String;
      // 41: invokestatic x/oced29a282d7.Ԁ (Ljava/util/UUID;Ljava/lang/String;)Ljava/lang/String;
      // 44: areturn
   }

   private static boolean ʭ(EntityPlayer param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 2
      // 04: aload 0
      // 05: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b: if_acmpeq 21
      // 0e: aload 1
      // 0f: invokestatic x/oced29a282d7.Ő (Ljava/lang/String;)Z
      // 12: iload 2
      // 13: ifne 22
      // 16: goto 1a
      // 19: athrow
      // 1a: ifeq 25
      // 1d: goto 21
      // 20: athrow
      // 21: bipush 1
      // 22: goto 26
      // 25: bipush 0
      // 26: ireturn
   }

   private static boolean Ő(String var0) {
      int var1 = oc89eb238246.ħ;

      String var10000;
      label33: {
         try {
            var10000 = var0;
            if (var1 != 0) {
               break label33;
            }

            if (var0 == null) {
               return false;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var10000 = var0;
      }

      try {
         boolean var4 = var10000.equals(ʚ);
         if (var1 != 0) {
            return var4;
         }

         if (var4) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   private static String ş(String var0) {
      Integer var1 = Ԁ.get(var0);

      try {
         if (var1 == null) {
            return null;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return Ͷ + var1;
   }

   private static String Ғ(NetworkPlayerInfo param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 16
      // 09: ifnonnull 15
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: goto 19
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 19: astore 2
      // 1a: aload 2
      // 1b: iload 1
      // 1c: ifne 2e
      // 1f: ifnonnull 2d
      // 22: goto 26
      // 25: athrow
      // 26: ldc_w ""
      // 29: goto 31
      // 2c: athrow
      // 2d: aload 2
      // 2e: invokevirtual com/mojang/authlib/GameProfile.getName ()Ljava/lang/String;
      // 31: areturn
   }

   private static String û(NetworkPlayerInfo param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 16
      // 09: ifnonnull 15
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: goto 19
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 19: astore 2
      // 1a: aload 2
      // 1b: iload 1
      // 1c: ifne 2c
      // 1f: ifnonnull 2b
      // 22: goto 26
      // 25: athrow
      // 26: aconst_null
      // 27: goto 36
      // 2a: athrow
      // 2b: aload 2
      // 2c: invokevirtual com/mojang/authlib/GameProfile.getId ()Ljava/util/UUID;
      // 2f: aload 2
      // 30: invokevirtual com/mojang/authlib/GameProfile.getName ()Ljava/lang/String;
      // 33: invokestatic x/oced29a282d7.Ԁ (Ljava/util/UUID;Ljava/lang/String;)Ljava/lang/String;
      // 36: areturn
   }

   private static String ѵ(EntityPlayer param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: aload 0
      // 04: invokestatic x/oced29a282d7.է (Lnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 16
      // 0e: ifnull 1a
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: invokestatic x/oced29a282d7.û (Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
      // 19: areturn
      // 1a: aload 0
      // 1b: iload 1
      // 1c: ifne 2c
      // 1f: ifnonnull 2b
      // 22: goto 26
      // 25: athrow
      // 26: aconst_null
      // 27: goto 36
      // 2a: athrow
      // 2b: aload 0
      // 2c: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 2f: aload 0
      // 30: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // 33: invokestatic x/oced29a282d7.Ԁ (Ljava/util/UUID;Ljava/lang/String;)Ljava/lang/String;
      // 36: areturn
   }

   private static String Ԁ(UUID var0, String var1) {
      int var2 = oc89eb238246.ħ;

      label47: {
         try {
            if (var2 != 0) {
               return var0.toString();
            }

            if (var0 == null) {
               break label47;
            }
         } catch (ocbde1165e4e var5) {
            throw var5;
         }

         return var0.toString();
      }

      String var3 = Ӌ(var1);

      try {
         if (var3.isEmpty()) {
            return null;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return var3;
   }

   private static String Ӱ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: ifnonnull 17
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc_w ""
      // 13: goto 1b
      // 16: athrow
      // 17: aload 0
      // 18: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1b: astore 2
      // 1c: aload 2
      // 1d: iload 1
      // 1e: ifne 32
      // 21: invokevirtual java/lang/String.isEmpty ()Z
      // 24: ifeq 35
      // 27: goto 2b
      // 2a: athrow
      // 2b: ldc_w "miau"
      // 2e: goto 32
      // 31: athrow
      // 32: goto 36
      // 35: aload 2
      // 36: areturn
   }

   private static String Ǣ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: ifnonnull 17
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc_w ""
      // 13: goto 1b
      // 16: athrow
      // 17: aload 0
      // 18: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1b: astore 2
      // 1c: aload 2
      // 1d: iload 1
      // 1e: ifne 31
      // 21: invokevirtual java/lang/String.isEmpty ()Z
      // 24: ifeq 34
      // 27: goto 2b
      // 2a: athrow
      // 2b: ldc "Player"
      // 2d: goto 31
      // 30: athrow
      // 31: goto 35
      // 34: aload 2
      // 35: areturn
   }

   private static String ӣ(String var0) {
      int var1 = oc89eb238246.ħ;

      try {
         if (var1 != 0) {
            return oc7ab2161b9f.ћ(var0).trim();
         }

         if (var0 == null) {
            return oc7ab2161b9f.ћ("").trim();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return oc7ab2161b9f.ћ(var0).trim();
   }

   private static String Ӌ(String var0) {
      return ӣ(var0).toLowerCase(Locale.ROOT);
   }

   private static boolean ŕ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 29
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: invokevirtual java/lang/String.isEmpty ()Z
      // 14: ifne 29
      // 17: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d: ifnull 29
      // 20: goto 24
      // 23: athrow
      // 24: bipush 1
      // 25: goto 2a
      // 28: athrow
      // 29: bipush 0
      // 2a: ireturn
   }

   private static void Ɨ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokestatic x/oced29a282d7.Ӱ (Ljava/lang/String;)Ljava/lang/String;
      // 04: astore 2
      // 05: getstatic x/oc89eb238246.ħ I
      // 08: aload 2
      // 09: invokestatic x/oc7ab2161b9f.Ĭ (Ljava/lang/String;)Ljava/lang/String;
      // 0c: astore 3
      // 0d: istore 1
      // 0e: aload 2
      // 0f: putstatic x/oc7ab2161b9f.Ҧ Ljava/lang/String;
      // 12: iload 1
      // 13: ifne 47
      // 16: getstatic x/oced29a282d7.Ɏ Ljava/lang/String;
      // 19: aload 2
      // 1a: invokestatic java/util/Objects.equals (Ljava/lang/Object;Ljava/lang/Object;)Z
      // 1d: ifeq 3c
      // 20: goto 24
      // 23: athrow
      // 24: getstatic x/oced29a282d7.ö Ljava/lang/String;
      // 27: iload 1
      // 28: ifne 41
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 3
      // 30: invokestatic java/util/Objects.equals (Ljava/lang/Object;Ljava/lang/Object;)Z
      // 33: ifeq 3c
      // 36: goto 3a
      // 39: athrow
      // 3a: return
      // 3b: athrow
      // 3c: aload 2
      // 3d: putstatic x/oced29a282d7.Ɏ Ljava/lang/String;
      // 40: aload 3
      // 41: putstatic x/oced29a282d7.ö Ljava/lang/String;
      // 44: invokestatic x/oced29a282d7.յ ()V
      // 47: return
   }

   private static void û(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: aload 0
      // 04: invokestatic x/oced29a282d7.Ǣ (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: invokestatic x/oc7ab2161b9f.Ĭ (Ljava/lang/String;)Ljava/lang/String;
      // 0d: astore 3
      // 0e: iload 1
      // 0f: ifne 2c
      // 12: getstatic x/oced29a282d7.Ͷ Ljava/lang/String;
      // 15: aload 3
      // 16: invokestatic java/util/Objects.equals (Ljava/lang/Object;Ljava/lang/Object;)Z
      // 19: ifeq 22
      // 1c: goto 20
      // 1f: athrow
      // 20: return
      // 21: athrow
      // 22: aload 3
      // 23: putstatic x/oced29a282d7.Ͷ Ljava/lang/String;
      // 26: invokestatic x/oced29a282d7.Ղ ()V
      // 29: invokestatic x/oced29a282d7.յ ()V
      // 2c: return
   }

   private static void Ղ() {
      Ϸ = Collections.emptyMap();
      Ƀ = Collections.emptyList();
      Ԁ = Collections.emptyMap();
      Ĺ = 0L;
   }

   private static void յ() {
      ý++;
      ǣ = -1;
      ȓ = null;
      r = null;
      Ĺ = 0L;
   }

   @Override
   public void z$2u87utkr1isxg() {
      ϵ.ȉ(Ӗ.ǭ(), this);
   }
}
