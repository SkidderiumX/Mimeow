package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class ocfbf6a7fb78 {
   private static final Minecraft ɸ = Minecraft.getMinecraft();
   private static final ocfbf6a7fb78 χ = new ocfbf6a7fb78();
   private final Map<Long, Set<BlockPos>> Ļ = new ConcurrentHashMap<>();
   private final Map<Long, Set<BlockPos>> E = new ConcurrentHashMap<>();
   private final Set<oc5627f01551> Џ = ConcurrentHashMap.newKeySet();
   private final Deque<oc607149f6c9> Ӄ = new ArrayDeque<>();
   private final Set<Long> ԏ = new HashSet<>();
   private oc3383be5a70 Ϧ;
   private boolean ʐ;
   private int Û;
   private int ы;
   private static final oc9e0ffe88b1 ħ = new oc9e0ffe88b1();
   public static boolean ɰ;

   private ocfbf6a7fb78() {
   }

   public static ocfbf6a7fb78 ā() {
      return χ;
   }

   public void ż(oc10354c7bb8 var1) {
      this.Ϧ = new oc3383be5a70(var1);
   }

   public void ã() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 21
      // 09: aconst_null
      // 0a: putfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 0d: aload 0
      // 0e: invokevirtual x/ocfbf6a7fb78.ĺ ()V
      // 11: aload 0
      // 12: invokevirtual x/ocfbf6a7fb78.ƽ ()Z
      // 15: ifne 24
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: goto 21
      // 20: athrow
      // 21: invokevirtual x/ocfbf6a7fb78.Ī ()V
      // 24: return
   }

   public void Ǎ() {
      this.ʐ = true;
   }

   public void ԛ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: bipush 0
      // 05: putfield x/ocfbf6a7fb78.ʐ Z
      // 08: istore 1
      // 09: aload 0
      // 0a: iload 1
      // 0b: ifne 21
      // 0e: invokevirtual x/ocfbf6a7fb78.Ϻ ()V
      // 11: aload 0
      // 12: invokevirtual x/ocfbf6a7fb78.ƽ ()Z
      // 15: ifne 24
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: goto 21
      // 20: athrow
      // 21: invokevirtual x/ocfbf6a7fb78.Ī ()V
      // 24: return
   }

   private boolean Ӊ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 0c: ifnull 2d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 1b: invokevirtual x/oc3383be5a70.z$2terxsjcchy0a ()Z
      // 1e: iload 1
      // 1f: ifne 2a
      // 22: ifeq 2d
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: ireturn
   }

   private boolean λ() {
      return this.ʐ;
   }

   public boolean ƽ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: invokevirtual x/ocfbf6a7fb78.Ӊ ()Z
      // 08: iload 1
      // 09: ifne 27
      // 0c: ifne 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/ocfbf6a7fb78.λ ()Z
      // 17: iload 1
      // 18: ifne 27
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifeq 2a
      // 22: goto 26
      // 25: athrow
      // 26: bipush 1
      // 27: goto 2b
      // 2a: bipush 0
      // 2b: ireturn
   }

   public void į() {
      this.ĺ();
      int var10000 = oc75d51ec7eb.ϩ;
      this.Ϻ();
      this.Ī();
      Iterator var2 = this.Џ.iterator();
      int var1 = var10000;

      while (var2.hasNext()) {
         oc5627f01551 var3 = (oc5627f01551)var2.next();
         var3.z$23uw3wn0ajcof();
         if (var1 != 0) {
            break;
         }
      }
   }

   public void Ƴ(oc5627f01551 var1) {
      try {
         if (var1 != null) {
            this.Џ.add(var1);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public void Ǣ(oc5627f01551 var1) {
      try {
         if (var1 != null) {
            this.Џ.remove(var1);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public void ѣ(int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: aload 0
      // 05: invokevirtual x/ocfbf6a7fb78.ƽ ()Z
      // 08: iload 3
      // 09: ifne 15
      // 0c: ifne 14
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: iload 1
      // 15: iload 2
      // 16: invokestatic x/ocfbf6a7fb78.Ϙ (II)J
      // 19: lstore 4
      // 1b: aload 0
      // 1c: iload 3
      // 1d: ifne 55
      // 20: getfield x/ocfbf6a7fb78.ԏ Ljava/util/Set;
      // 23: lload 4
      // 25: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 28: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 2d: ifne 36
      // 30: goto 34
      // 33: athrow
      // 34: return
      // 35: athrow
      // 36: aload 0
      // 37: lload 4
      // 39: invokevirtual x/ocfbf6a7fb78.Ҡ (J)V
      // 3c: aload 0
      // 3d: lload 4
      // 3f: invokevirtual x/ocfbf6a7fb78.ϋ (J)V
      // 42: aload 0
      // 43: getfield x/ocfbf6a7fb78.Ӄ Ljava/util/Deque;
      // 46: new x/oc607149f6c9
      // 49: dup
      // 4a: iload 1
      // 4b: iload 2
      // 4c: invokespecial x/oc607149f6c9.<init> (II)V
      // 4f: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 54: aload 0
      // 55: getfield x/ocfbf6a7fb78.Џ Ljava/util/Set;
      // 58: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 5d: astore 6
      // 5f: aload 6
      // 61: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 66: ifeq 82
      // 69: aload 6
      // 6b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 70: checkcast x/oc5627f01551
      // 73: astore 7
      // 75: iload 3
      // 76: aload 7
      // 78: iload 1
      // 79: iload 2
      // 7a: invokeinterface x/oc5627f01551.z$3o46zev0nf5ww (II)V 3
      // 7f: ifeq 5f
      // 82: return
   }

   public void ѱ(int var1, int var2) {
      long var4 = Ϙ(var1, var2);
      int var10000 = oc75d51ec7eb.ϩ;
      this.ԏ.remove(var4);
      this.Ӄ.removeIf(var2x -> {
         int var3x = oc75d51ec7eb.ϩ;

         try {
            long var5;
            int var10000x = (var5 = var2x.ɋ - var4) == 0L ? 0 : (var5 < 0L ? -1 : 1);
            if (var3x != 0) {
               return (boolean)var10000x;
            }

            if (!var10000x) {
               return (boolean)1;
            }
         } catch (ocbde1165e4e var4x) {
            throw var4x;
         }

         return (boolean)0;
      });
      this.Ҡ(var4);
      int var3 = var10000;
      this.ϋ(var4);

      for (oc5627f01551 var7 : this.Џ) {
         var7.z$vogd6cjwu453(var1, var2);
         if (var3 != 0) {
            break;
         }
      }
   }

   public void Ä() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 16
      // 09: invokevirtual x/ocfbf6a7fb78.ƽ ()Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual x/ocfbf6a7fb78.Ī ()V
      // 19: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 1c: iload 1
      // 1d: ifne 31
      // 20: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 23: ifnull 3f
      // 26: goto 2a
      // 29: athrow
      // 2a: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 2d: goto 31
      // 30: athrow
      // 31: iload 1
      // 32: ifne 44
      // 35: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 38: ifnonnull 41
      // 3b: goto 3f
      // 3e: athrow
      // 3f: return
      // 40: athrow
      // 41: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 44: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 47: getfield net/minecraft/client/settings/GameSettings.renderDistanceChunks I
      // 4a: istore 2
      // 4b: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 4e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 51: getfield net/minecraft/client/entity/EntityPlayerSP.chunkCoordX I
      // 54: istore 3
      // 55: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 58: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5b: getfield net/minecraft/client/entity/EntityPlayerSP.chunkCoordZ I
      // 5e: istore 4
      // 60: iload 3
      // 61: iload 2
      // 62: isub
      // 63: istore 5
      // 65: iload 5
      // 67: iload 3
      // 68: iload 2
      // 69: iadd
      // 6a: if_icmpgt c2
      // 6d: iload 4
      // 6f: iload 2
      // 70: isub
      // 71: istore 6
      // 73: iload 6
      // 75: iload 4
      // 77: iload 2
      // 78: iadd
      // 79: if_icmpgt bb
      // 7c: iload 1
      // 7d: ifne be
      // 80: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 83: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 86: iload 5
      // 88: iload 6
      // 8a: invokevirtual net/minecraft/client/multiplayer/WorldClient.getChunkFromChunkCoords (II)Lnet/minecraft/world/chunk/Chunk;
      // 8d: astore 7
      // 8f: iload 1
      // 90: ifne b7
      // 93: aload 7
      // 95: ifnull b4
      // 98: goto 9c
      // 9b: athrow
      // 9c: aload 7
      // 9e: instanceof net/minecraft/world/chunk/EmptyChunk
      // a1: ifne b4
      // a4: goto a8
      // a7: athrow
      // a8: aload 0
      // a9: iload 5
      // ab: iload 6
      // ad: invokevirtual x/ocfbf6a7fb78.ѣ (II)V
      // b0: goto b4
      // b3: athrow
      // b4: iinc 6 1
      // b7: iload 1
      // b8: ifeq 73
      // bb: iinc 5 1
      // be: iload 1
      // bf: ifeq 65
      // c2: return
   }

   public void ҩ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 2
      // 004: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 00a: ifnull 024
      // 00d: aload 0
      // 00e: invokevirtual x/ocfbf6a7fb78.ƽ ()Z
      // 011: iload 2
      // 012: ifne 021
      // 015: goto 019
      // 018: athrow
      // 019: ifeq 024
      // 01c: goto 020
      // 01f: athrow
      // 020: iload 1
      // 021: ifgt 025
      // 024: return
      // 025: aload 0
      // 026: iload 2
      // 027: ifne 039
      // 02a: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 02d: ifnull 03f
      // 030: goto 034
      // 033: athrow
      // 034: aload 0
      // 035: goto 039
      // 038: athrow
      // 039: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 03c: invokevirtual x/oc3383be5a70.z$1o3njpmxa1ma5 ()V
      // 03f: iload 1
      // 040: istore 3
      // 041: iload 3
      // 042: ifle 16b
      // 045: aload 0
      // 046: iload 2
      // 047: ifne 066
      // 04a: getfield x/ocfbf6a7fb78.Ӄ Ljava/util/Deque;
      // 04d: invokeinterface java/util/Deque.isEmpty ()Z 1
      // 052: ifne 16b
      // 055: goto 059
      // 058: athrow
      // 059: aload 0
      // 05a: getfield x/ocfbf6a7fb78.Ӄ Ljava/util/Deque;
      // 05d: invokeinterface java/util/Deque.peekFirst ()Ljava/lang/Object; 1
      // 062: goto 066
      // 065: athrow
      // 066: checkcast x/oc607149f6c9
      // 069: astore 4
      // 06b: iload 2
      // 06c: getstatic x/ocfbf6a7fb78.ɸ Lnet/minecraft/client/Minecraft;
      // 06f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 072: aload 4
      // 074: getfield x/oc607149f6c9.ɲ I
      // 077: aload 4
      // 079: getfield x/oc607149f6c9.u I
      // 07c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getChunkFromChunkCoords (II)Lnet/minecraft/world/chunk/Chunk;
      // 07f: astore 5
      // 081: ifne 0ab
      // 084: aload 5
      // 086: ifnull 0a1
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 5
      // 08f: iload 2
      // 090: ifne 0b1
      // 093: goto 097
      // 096: athrow
      // 097: instanceof net/minecraft/world/chunk/EmptyChunk
      // 09a: ifeq 0af
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: aload 0
      // 0a2: aload 4
      // 0a4: invokevirtual x/ocfbf6a7fb78.И (Lx/oc607149f6c9;)V
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: iload 2
      // 0ac: ifeq 041
      // 0af: aload 5
      // 0b1: invokevirtual net/minecraft/world/chunk/Chunk.getBlockStorageArray ()[Lnet/minecraft/world/chunk/storage/ExtendedBlockStorage;
      // 0b4: astore 6
      // 0b6: aload 4
      // 0b8: getfield x/oc607149f6c9.х I
      // 0bb: aload 6
      // 0bd: arraylength
      // 0be: if_icmpge 0e3
      // 0c1: aload 6
      // 0c3: iload 2
      // 0c4: ifne 066
      // 0c7: aload 4
      // 0c9: getfield x/oc607149f6c9.х I
      // 0cc: aaload
      // 0cd: ifnonnull 0e3
      // 0d0: aload 4
      // 0d2: dup
      // 0d3: getfield x/oc607149f6c9.х I
      // 0d6: bipush 1
      // 0d7: iadd
      // 0d8: putfield x/oc607149f6c9.х I
      // 0db: iload 2
      // 0dc: ifeq 0b6
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 4
      // 0e5: iload 2
      // 0e6: ifne 119
      // 0e9: getfield x/oc607149f6c9.х I
      // 0ec: aload 6
      // 0ee: arraylength
      // 0ef: if_icmplt 104
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 0
      // 0f7: aload 4
      // 0f9: invokevirtual x/ocfbf6a7fb78.И (Lx/oc607149f6c9;)V
      // 0fc: iload 2
      // 0fd: ifeq 041
      // 100: goto 104
      // 103: athrow
      // 104: aload 0
      // 105: aload 5
      // 107: aload 6
      // 109: aload 4
      // 10b: getfield x/oc607149f6c9.х I
      // 10e: aaload
      // 10f: aload 4
      // 111: getfield x/oc607149f6c9.х I
      // 114: invokevirtual x/ocfbf6a7fb78.ѱ (Lnet/minecraft/world/chunk/Chunk;Lnet/minecraft/world/chunk/storage/ExtendedBlockStorage;I)V
      // 117: aload 4
      // 119: dup
      // 11a: getfield x/oc607149f6c9.х I
      // 11d: bipush 1
      // 11e: iadd
      // 11f: putfield x/oc607149f6c9.х I
      // 122: iinc 3 -1
      // 125: aload 4
      // 127: getfield x/oc607149f6c9.х I
      // 12a: aload 6
      // 12c: arraylength
      // 12d: if_icmpge 152
      // 130: aload 6
      // 132: iload 2
      // 133: ifne 066
      // 136: aload 4
      // 138: getfield x/oc607149f6c9.х I
      // 13b: aaload
      // 13c: ifnonnull 152
      // 13f: aload 4
      // 141: dup
      // 142: getfield x/oc607149f6c9.х I
      // 145: bipush 1
      // 146: iadd
      // 147: putfield x/oc607149f6c9.х I
      // 14a: iload 2
      // 14b: ifeq 125
      // 14e: goto 152
      // 151: athrow
      // 152: aload 4
      // 154: getfield x/oc607149f6c9.х I
      // 157: aload 6
      // 159: arraylength
      // 15a: if_icmplt 167
      // 15d: aload 0
      // 15e: aload 4
      // 160: invokevirtual x/ocfbf6a7fb78.И (Lx/oc607149f6c9;)V
      // 163: goto 167
      // 166: athrow
      // 167: iload 2
      // 168: ifeq 041
      // 16b: return
   }

   public void ԕ(BlockPos param1, IBlockState param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 018
      // 009: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 00c: ifnull 01e
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: goto 018
      // 017: athrow
      // 018: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 01b: invokevirtual x/oc3383be5a70.z$1o3njpmxa1ma5 ()V
      // 01e: aload 1
      // 01f: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 022: ldc_w -1660901417
      // 025: ldc_w -1660901421
      // 028: ixor
      // 029: ishr
      // 02a: aload 1
      // 02b: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 02e: ldc_w -1660901417
      // 031: ldc_w -1660901421
      // 034: ixor
      // 035: ishr
      // 036: invokestatic x/ocfbf6a7fb78.Ϙ (II)J
      // 039: lstore 4
      // 03b: new net/minecraft/util/BlockPos
      // 03e: dup
      // 03f: aload 1
      // 040: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 043: aload 1
      // 044: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 047: aload 1
      // 048: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 04b: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 04e: astore 6
      // 050: aload 0
      // 051: iload 3
      // 052: ifne 0e2
      // 055: invokevirtual x/ocfbf6a7fb78.Ӊ ()Z
      // 058: ifeq 0e1
      // 05b: goto 05f
      // 05e: athrow
      // 05f: aload 0
      // 060: iload 3
      // 061: ifne 0bf
      // 064: goto 068
      // 067: athrow
      // 068: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 06b: aload 2
      // 06c: invokevirtual x/oc3383be5a70.z$11r2n2rw0zig9 (Lnet/minecraft/block/state/IBlockState;)Z
      // 06f: ifeq 0ba
      // 072: goto 076
      // 075: athrow
      // 076: aload 0
      // 077: iload 3
      // 078: ifne 0bf
      // 07b: goto 07f
      // 07e: athrow
      // 07f: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 082: aload 1
      // 083: aload 2
      // 084: invokevirtual x/oc3383be5a70.z$3mptsutoy1cyd (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Z
      // 087: ifeq 0ba
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 0
      // 08f: iload 3
      // 090: ifne 0e2
      // 093: goto 097
      // 096: athrow
      // 097: getfield x/ocfbf6a7fb78.Ļ Ljava/util/Map;
      // 09a: lload 4
      // 09c: aload 6
      // 09e: invokestatic x/ocfbf6a7fb78.Ľ (Ljava/util/Map;JLnet/minecraft/util/BlockPos;)Z
      // 0a1: ifeq 0e1
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: aload 0
      // 0a9: dup
      // 0aa: getfield x/ocfbf6a7fb78.Û I
      // 0ad: bipush 1
      // 0ae: iadd
      // 0af: putfield x/ocfbf6a7fb78.Û I
      // 0b2: iload 3
      // 0b3: ifeq 0e1
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: aload 0
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: iload 3
      // 0c0: ifne 0e2
      // 0c3: getfield x/ocfbf6a7fb78.Ļ Ljava/util/Map;
      // 0c6: lload 4
      // 0c8: aload 1
      // 0c9: invokestatic x/ocfbf6a7fb78.ӱ (Ljava/util/Map;JLnet/minecraft/util/BlockPos;)Z
      // 0cc: ifeq 0e1
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 0
      // 0d4: dup
      // 0d5: getfield x/ocfbf6a7fb78.Û I
      // 0d8: bipush 1
      // 0d9: isub
      // 0da: putfield x/ocfbf6a7fb78.Û I
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: aload 0
      // 0e2: iload 3
      // 0e3: ifne 171
      // 0e6: invokevirtual x/ocfbf6a7fb78.λ ()Z
      // 0e9: ifeq 170
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: getstatic x/ocfbf6a7fb78.ħ Lx/oc9e0ffe88b1;
      // 0f3: aload 2
      // 0f4: invokevirtual x/oc9e0ffe88b1.z$11r2n2rw0zig9 (Lnet/minecraft/block/state/IBlockState;)Z
      // 0f7: iload 3
      // 0f8: ifne 15f
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: ifeq 149
      // 102: goto 106
      // 105: athrow
      // 106: getstatic x/ocfbf6a7fb78.ħ Lx/oc9e0ffe88b1;
      // 109: aload 1
      // 10a: aload 2
      // 10b: invokevirtual x/oc9e0ffe88b1.z$3mptsutoy1cyd (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Z
      // 10e: iload 3
      // 10f: ifne 15f
      // 112: goto 116
      // 115: athrow
      // 116: ifeq 149
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: iload 3
      // 11f: ifne 171
      // 122: goto 126
      // 125: athrow
      // 126: getfield x/ocfbf6a7fb78.E Ljava/util/Map;
      // 129: lload 4
      // 12b: aload 6
      // 12d: invokestatic x/ocfbf6a7fb78.Ľ (Ljava/util/Map;JLnet/minecraft/util/BlockPos;)Z
      // 130: ifeq 170
      // 133: goto 137
      // 136: athrow
      // 137: aload 0
      // 138: dup
      // 139: getfield x/ocfbf6a7fb78.ы I
      // 13c: bipush 1
      // 13d: iadd
      // 13e: putfield x/ocfbf6a7fb78.ы I
      // 141: iload 3
      // 142: ifeq 170
      // 145: goto 149
      // 148: athrow
      // 149: aload 0
      // 14a: iload 3
      // 14b: ifne 171
      // 14e: goto 152
      // 151: athrow
      // 152: getfield x/ocfbf6a7fb78.E Ljava/util/Map;
      // 155: lload 4
      // 157: aload 1
      // 158: invokestatic x/ocfbf6a7fb78.ӱ (Ljava/util/Map;JLnet/minecraft/util/BlockPos;)Z
      // 15b: goto 15f
      // 15e: athrow
      // 15f: ifeq 170
      // 162: aload 0
      // 163: dup
      // 164: getfield x/ocfbf6a7fb78.ы I
      // 167: bipush 1
      // 168: isub
      // 169: putfield x/ocfbf6a7fb78.ы I
      // 16c: goto 170
      // 16f: athrow
      // 170: aload 0
      // 171: getfield x/ocfbf6a7fb78.Џ Ljava/util/Set;
      // 174: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 179: astore 7
      // 17b: aload 7
      // 17d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 182: ifeq 19f
      // 185: aload 7
      // 187: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 18c: checkcast x/oc5627f01551
      // 18f: astore 8
      // 191: iload 3
      // 192: aload 8
      // 194: aload 6
      // 196: aload 2
      // 197: invokeinterface x/oc5627f01551.z$186nhiptn04m0 (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)V 3
      // 19c: ifeq 17b
      // 19f: return
   }

   public void Ň() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1f
      // 09: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 0c: ifnull 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 17: invokevirtual x/oc3383be5a70.z$1o3njpmxa1ma5 ()V
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 0
      // 1f: invokevirtual x/ocfbf6a7fb78.ϴ ()V
      // 22: return
   }

   private void ϴ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokevirtual x/ocfbf6a7fb78.ĺ ()V
      // 07: istore 1
      // 08: aload 0
      // 09: iload 1
      // 0a: ifne 1e
      // 0d: invokevirtual x/ocfbf6a7fb78.Ī ()V
      // 10: aload 0
      // 11: invokevirtual x/ocfbf6a7fb78.ƽ ()Z
      // 14: ifne 1d
      // 17: goto 1b
      // 1a: athrow
      // 1b: return
      // 1c: athrow
      // 1d: aload 0
      // 1e: invokevirtual x/ocfbf6a7fb78.Ä ()V
      // 21: return
   }

   public Iterable<Entry<Long, Set<BlockPos>>> Ȣ() {
      return this.Ļ.entrySet();
   }

   public Iterable<Entry<Long, Set<BlockPos>>> ț() {
      return this.E.entrySet();
   }

   public int Ա() {
      return this.Û;
   }

   public int Ú() {
      return this.ы;
   }

   public boolean Ѭ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: aload 1
      // 14: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 17: ldc_w -695171583
      // 1a: ldc_w -695171579
      // 1d: ixor
      // 1e: ishr
      // 1f: aload 1
      // 20: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 23: ldc_w -695171583
      // 26: ldc_w -695171579
      // 29: ixor
      // 2a: ishr
      // 2b: invokestatic x/ocfbf6a7fb78.Ϙ (II)J
      // 2e: lstore 3
      // 2f: aload 0
      // 30: getfield x/ocfbf6a7fb78.Ļ Ljava/util/Map;
      // 33: lload 3
      // 34: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 37: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 3c: checkcast java/util/Set
      // 3f: astore 5
      // 41: aload 5
      // 43: iload 2
      // 44: ifne 50
      // 47: ifnull 65
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 5
      // 50: aload 1
      // 51: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 56: iload 2
      // 57: ifne 62
      // 5a: ifeq 65
      // 5d: goto 61
      // 60: athrow
      // 61: bipush 1
      // 62: goto 66
      // 65: bipush 0
      // 66: ireturn
   }

   public void Ϣ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 2
      // 004: aload 0
      // 005: invokevirtual x/ocfbf6a7fb78.ƽ ()Z
      // 008: iload 2
      // 009: ifne 023
      // 00c: ifne 014
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: aload 1
      // 015: iload 2
      // 016: ifne 043
      // 019: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 01c: instanceof net/minecraft/network/play/server/S23PacketBlockChange
      // 01f: goto 023
      // 022: athrow
      // 023: ifeq 03e
      // 026: aload 1
      // 027: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 02a: checkcast net/minecraft/network/play/server/S23PacketBlockChange
      // 02d: astore 3
      // 02e: iload 2
      // 02f: aload 0
      // 030: aload 3
      // 031: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockPosition ()Lnet/minecraft/util/BlockPos;
      // 034: aload 3
      // 035: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 038: invokevirtual x/ocfbf6a7fb78.ԕ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)V
      // 03b: ifeq 133
      // 03e: aload 1
      // 03f: goto 043
      // 042: athrow
      // 043: iload 2
      // 044: ifne 09e
      // 047: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 04a: instanceof net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 04d: ifeq 099
      // 050: goto 054
      // 053: athrow
      // 054: aload 1
      // 055: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 058: checkcast net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 05b: astore 3
      // 05c: aload 3
      // 05d: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange.getChangedBlocks ()[Lnet/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData;
      // 060: astore 4
      // 062: aload 4
      // 064: arraylength
      // 065: istore 5
      // 067: bipush 0
      // 068: istore 6
      // 06a: iload 6
      // 06c: iload 5
      // 06e: if_icmpge 095
      // 071: aload 4
      // 073: iload 6
      // 075: aaload
      // 076: astore 7
      // 078: iload 2
      // 079: ifne 133
      // 07c: aload 0
      // 07d: aload 7
      // 07f: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getPos ()Lnet/minecraft/util/BlockPos;
      // 082: aload 7
      // 084: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 087: invokevirtual x/ocfbf6a7fb78.ԕ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)V
      // 08a: iload 2
      // 08b: iinc 6 1
      // 08e: ifeq 06a
      // 091: goto 095
      // 094: athrow
      // 095: iload 2
      // 096: ifeq 133
      // 099: aload 1
      // 09a: goto 09e
      // 09d: athrow
      // 09e: iload 2
      // 09f: ifne 0f3
      // 0a2: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 0a5: instanceof net/minecraft/network/play/server/S21PacketChunkData
      // 0a8: ifeq 0ee
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 1
      // 0b0: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 0b3: checkcast net/minecraft/network/play/server/S21PacketChunkData
      // 0b6: astore 3
      // 0b7: iload 2
      // 0b8: ifne 0d6
      // 0bb: aload 3
      // 0bc: invokevirtual net/minecraft/network/play/server/S21PacketChunkData.getExtractedSize ()I
      // 0bf: ifne 0da
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: aload 3
      // 0c8: invokevirtual net/minecraft/network/play/server/S21PacketChunkData.getChunkX ()I
      // 0cb: aload 3
      // 0cc: invokevirtual net/minecraft/network/play/server/S21PacketChunkData.getChunkZ ()I
      // 0cf: invokevirtual x/ocfbf6a7fb78.ѱ (II)V
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: iload 2
      // 0d7: ifeq 0ea
      // 0da: aload 0
      // 0db: aload 3
      // 0dc: invokevirtual net/minecraft/network/play/server/S21PacketChunkData.getChunkX ()I
      // 0df: aload 3
      // 0e0: invokevirtual net/minecraft/network/play/server/S21PacketChunkData.getChunkZ ()I
      // 0e3: invokevirtual x/ocfbf6a7fb78.ѣ (II)V
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: iload 2
      // 0eb: ifeq 133
      // 0ee: aload 1
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: iload 2
      // 0f4: ifne 109
      // 0f7: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 0fa: instanceof net/minecraft/network/play/server/S26PacketMapChunkBulk
      // 0fd: ifeq 133
      // 100: goto 104
      // 103: athrow
      // 104: aload 1
      // 105: goto 109
      // 108: athrow
      // 109: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 10c: checkcast net/minecraft/network/play/server/S26PacketMapChunkBulk
      // 10f: astore 3
      // 110: bipush 0
      // 111: istore 4
      // 113: iload 4
      // 115: aload 3
      // 116: invokevirtual net/minecraft/network/play/server/S26PacketMapChunkBulk.getChunkCount ()I
      // 119: if_icmpge 133
      // 11c: aload 0
      // 11d: aload 3
      // 11e: iload 4
      // 120: invokevirtual net/minecraft/network/play/server/S26PacketMapChunkBulk.getChunkX (I)I
      // 123: aload 3
      // 124: iload 4
      // 126: invokevirtual net/minecraft/network/play/server/S26PacketMapChunkBulk.getChunkZ (I)I
      // 129: invokevirtual x/ocfbf6a7fb78.ѣ (II)V
      // 12c: iload 2
      // 12d: iinc 4 1
      // 130: ifeq 113
      // 133: return
   }

   private void ѱ(Chunk param1, ExtendedBlockStorage param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: aload 1
      // 001: getfield net/minecraft/world/chunk/Chunk.xPosition I
      // 004: aload 1
      // 005: getfield net/minecraft/world/chunk/Chunk.zPosition I
      // 008: invokestatic x/ocfbf6a7fb78.Ϙ (II)J
      // 00b: lstore 5
      // 00d: aload 1
      // 00e: getfield net/minecraft/world/chunk/Chunk.xPosition I
      // 011: ldc_w -188245759
      // 014: ldc_w -188245755
      // 017: ixor
      // 018: ishl
      // 019: istore 7
      // 01b: aload 1
      // 01c: getfield net/minecraft/world/chunk/Chunk.zPosition I
      // 01f: ldc_w -188245759
      // 022: ldc_w -188245755
      // 025: ixor
      // 026: ishl
      // 027: istore 8
      // 029: getstatic x/oc75d51ec7eb.ϩ I
      // 02c: iload 3
      // 02d: ldc_w -188245759
      // 030: ldc_w -188245755
      // 033: ixor
      // 034: ishl
      // 035: istore 9
      // 037: aload 0
      // 038: invokevirtual x/ocfbf6a7fb78.Ӊ ()Z
      // 03b: istore 10
      // 03d: istore 4
      // 03f: aload 0
      // 040: invokevirtual x/ocfbf6a7fb78.λ ()Z
      // 043: istore 11
      // 045: bipush 0
      // 046: istore 12
      // 048: iload 12
      // 04a: ldc_w -188245739
      // 04d: ldc_w -188245755
      // 050: ixor
      // 051: if_icmpge 1e0
      // 054: bipush 0
      // 055: istore 13
      // 057: iload 13
      // 059: ldc_w -188245739
      // 05c: ldc_w -188245755
      // 05f: ixor
      // 060: if_icmpge 1d8
      // 063: iload 4
      // 065: ifne 1db
      // 068: bipush 0
      // 069: istore 14
      // 06b: iload 14
      // 06d: ldc_w -188245739
      // 070: ldc_w -188245755
      // 073: ixor
      // 074: if_icmpge 1d0
      // 077: iload 4
      // 079: ifne 1d3
      // 07c: aload 2
      // 07d: iload 14
      // 07f: iload 12
      // 081: iload 13
      // 083: invokevirtual net/minecraft/world/chunk/storage/ExtendedBlockStorage.get (III)Lnet/minecraft/block/state/IBlockState;
      // 086: astore 15
      // 088: aload 15
      // 08a: ifnonnull 096
      // 08d: iload 4
      // 08f: ifeq 1c8
      // 092: goto 096
      // 095: athrow
      // 096: iload 10
      // 098: iload 4
      // 09a: ifne 0b5
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: ifeq 0c5
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: aload 0
      // 0a9: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 0ac: aload 15
      // 0ae: invokevirtual x/oc3383be5a70.z$11r2n2rw0zig9 (Lnet/minecraft/block/state/IBlockState;)Z
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: iload 4
      // 0b7: ifne 0c2
      // 0ba: ifeq 0c5
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: bipush 1
      // 0c2: goto 0c6
      // 0c5: bipush 0
      // 0c6: istore 16
      // 0c8: iload 11
      // 0ca: iload 4
      // 0cc: ifne 0e2
      // 0cf: ifeq 0f2
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: getstatic x/ocfbf6a7fb78.ħ Lx/oc9e0ffe88b1;
      // 0d9: aload 15
      // 0db: invokevirtual x/oc9e0ffe88b1.z$11r2n2rw0zig9 (Lnet/minecraft/block/state/IBlockState;)Z
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: iload 4
      // 0e4: ifne 0ef
      // 0e7: ifeq 0f2
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: bipush 1
      // 0ef: goto 0f3
      // 0f2: bipush 0
      // 0f3: istore 17
      // 0f5: iload 16
      // 0f7: iload 4
      // 0f9: ifne 105
      // 0fc: ifne 111
      // 0ff: goto 103
      // 102: athrow
      // 103: iload 17
      // 105: ifne 111
      // 108: iload 4
      // 10a: ifeq 1c8
      // 10d: goto 111
      // 110: athrow
      // 111: new net/minecraft/util/BlockPos
      // 114: dup
      // 115: iload 7
      // 117: iload 14
      // 119: iadd
      // 11a: iload 9
      // 11c: iload 12
      // 11e: iadd
      // 11f: iload 8
      // 121: iload 13
      // 123: iadd
      // 124: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 127: astore 18
      // 129: iload 16
      // 12b: iload 4
      // 12d: ifne 17d
      // 130: ifeq 17b
      // 133: goto 137
      // 136: athrow
      // 137: aload 0
      // 138: getfield x/ocfbf6a7fb78.Ϧ Lx/oc3383be5a70;
      // 13b: aload 18
      // 13d: aload 15
      // 13f: invokevirtual x/oc3383be5a70.z$3mptsutoy1cyd (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Z
      // 142: iload 4
      // 144: ifne 17d
      // 147: goto 14b
      // 14a: athrow
      // 14b: ifeq 17b
      // 14e: goto 152
      // 151: athrow
      // 152: aload 0
      // 153: getfield x/ocfbf6a7fb78.Ļ Ljava/util/Map;
      // 156: lload 5
      // 158: aload 18
      // 15a: invokestatic x/ocfbf6a7fb78.Ľ (Ljava/util/Map;JLnet/minecraft/util/BlockPos;)Z
      // 15d: iload 4
      // 15f: ifne 17d
      // 162: goto 166
      // 165: athrow
      // 166: ifeq 17b
      // 169: goto 16d
      // 16c: athrow
      // 16d: aload 0
      // 16e: dup
      // 16f: getfield x/ocfbf6a7fb78.Û I
      // 172: bipush 1
      // 173: iadd
      // 174: putfield x/ocfbf6a7fb78.Û I
      // 177: goto 17b
      // 17a: athrow
      // 17b: iload 17
      // 17d: iload 4
      // 17f: ifne 197
      // 182: ifeq 1c8
      // 185: goto 189
      // 188: athrow
      // 189: getstatic x/ocfbf6a7fb78.ħ Lx/oc9e0ffe88b1;
      // 18c: aload 18
      // 18e: aload 15
      // 190: invokevirtual x/oc9e0ffe88b1.z$3mptsutoy1cyd (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Z
      // 193: goto 197
      // 196: athrow
      // 197: iload 4
      // 199: ifne 1bb
      // 19c: ifeq 1c8
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: aload 0
      // 1a4: iload 4
      // 1a6: ifne 1bf
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: getfield x/ocfbf6a7fb78.E Ljava/util/Map;
      // 1b0: lload 5
      // 1b2: aload 18
      // 1b4: invokestatic x/ocfbf6a7fb78.Ľ (Ljava/util/Map;JLnet/minecraft/util/BlockPos;)Z
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: ifeq 1c8
      // 1be: aload 0
      // 1bf: dup
      // 1c0: getfield x/ocfbf6a7fb78.ы I
      // 1c3: bipush 1
      // 1c4: iadd
      // 1c5: putfield x/ocfbf6a7fb78.ы I
      // 1c8: iinc 14 1
      // 1cb: iload 4
      // 1cd: ifeq 06b
      // 1d0: iinc 13 1
      // 1d3: iload 4
      // 1d5: ifeq 057
      // 1d8: iinc 12 1
      // 1db: iload 4
      // 1dd: ifeq 048
      // 1e0: return
   }

   private void И(oc607149f6c9 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 30
      // 09: getfield x/ocfbf6a7fb78.Ӄ Ljava/util/Deque;
      // 0c: invokeinterface java/util/Deque.peekFirst ()Ljava/lang/Object; 1
      // 11: aload 1
      // 12: if_acmpne 2b
      // 15: goto 19
      // 18: athrow
      // 19: aload 0
      // 1a: getfield x/ocfbf6a7fb78.Ӄ Ljava/util/Deque;
      // 1d: invokeinterface java/util/Deque.pollFirst ()Ljava/lang/Object; 1
      // 22: pop
      // 23: iload 2
      // 24: ifeq 3a
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: goto 30
      // 2f: athrow
      // 30: getfield x/ocfbf6a7fb78.Ӄ Ljava/util/Deque;
      // 33: aload 1
      // 34: invokeinterface java/util/Deque.remove (Ljava/lang/Object;)Z 2
      // 39: pop
      // 3a: aload 0
      // 3b: getfield x/ocfbf6a7fb78.ԏ Ljava/util/Set;
      // 3e: aload 1
      // 3f: getfield x/oc607149f6c9.ɋ J
      // 42: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 45: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 4a: pop
      // 4b: return
   }

   private void Ī() {
      this.Ӄ.clear();
      this.ԏ.clear();
   }

   private void ĺ() {
      this.Ļ.clear();
      this.Û = 0;
   }

   private void Ϻ() {
      this.E.clear();
      this.ы = 0;
   }

   private void Ҡ(long var1) {
      Set var3 = this.Ļ.remove(var1);

      try {
         if (var3 != null) {
            this.Û = Math.max(0, this.Û - var3.size());
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }
   }

   private void ϋ(long var1) {
      Set var3 = this.E.remove(var1);

      try {
         if (var3 != null) {
            this.ы = Math.max(0, this.ы - var3.size());
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }
   }

   private static boolean Ľ(Map<Long, Set<BlockPos>> var0, long var1, BlockPos var3) {
      return var0.computeIfAbsent(var1, var0x -> ConcurrentHashMap.newKeySet()).add(var3);
   }

   private static boolean ӱ(Map<Long, Set<BlockPos>> param0, long param1, BlockPos param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: lload 1
      // 05: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 08: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0d: checkcast java/util/Set
      // 10: astore 5
      // 12: istore 4
      // 14: aload 5
      // 16: iload 4
      // 18: ifne 24
      // 1b: ifnull 36
      // 1e: goto 22
      // 21: athrow
      // 22: aload 5
      // 24: iload 4
      // 26: ifne 3b
      // 29: aload 3
      // 2a: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 2f: ifne 39
      // 32: goto 36
      // 35: athrow
      // 36: bipush 0
      // 37: ireturn
      // 38: athrow
      // 39: aload 5
      // 3b: invokeinterface java/util/Set.isEmpty ()Z 1
      // 40: iload 4
      // 42: ifne 5e
      // 45: ifeq 5d
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: lload 1
      // 4e: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 51: aload 5
      // 53: invokeinterface java/util/Map.remove (Ljava/lang/Object;Ljava/lang/Object;)Z 3
      // 58: pop
      // 59: goto 5d
      // 5c: athrow
      // 5d: bipush 1
      // 5e: ireturn
   }

   private static long Ϙ(int var0, int var1) {
      return (long)var0 << (231398289 ^ 231398321) | var1 & (953058394530747617L ^ 953058395060595486L);
   }
}
