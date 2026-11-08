package x;

import java.util.Arrays;
import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

public class oc2ff590173b extends oc69da1aa7f5 {
   public oca9cc61aada ʩ;
   public oca9cc61aada Ҙ;
   private int ӟ;
   private final List<String> Ɣ;
   private IBlockState Ӟ;
   private final List<BlockPos> դ;
   private final String[] ƥ;
   public static int Ƹ;

   public oc2ff590173b() {
      super("SumoFences", oce4cea752dd.Ԃ, 0);
      String[] var10001 = new String[224360434 ^ 224360438];
      var10001[0] = "Sumo";
      var10001[1] = "Space Mine";
      var10001[224360436 ^ 224360438] = "White Crystal";
      var10001[224360437 ^ 224360438] = "Fort";
      this.Ɣ = Arrays.asList(var10001);
      BlockPos[] var1 = new BlockPos[224360382 ^ 224360438];
      var1[0] = new BlockPos(224360447 ^ 224360438, 224360375 ^ 224360438, -224360440 ^ 224360438);
      var1[1] = new BlockPos(224360447 ^ 224360438, 224360375 ^ 224360438, -1);
      var1[224360436 ^ 224360438] = new BlockPos(224360447 ^ 224360438, 224360375 ^ 224360438, 0);
      var1[224360437 ^ 224360438] = new BlockPos(224360447 ^ 224360438, 224360375 ^ 224360438, 1);
      var1[224360434 ^ 224360438] = new BlockPos(224360447 ^ 224360438, 224360375 ^ 224360438, 224360436 ^ 224360438);
      var1[224360435 ^ 224360438] = new BlockPos(224360447 ^ 224360438, 224360375 ^ 224360438, 224360437 ^ 224360438);
      var1[224360432 ^ 224360438] = new BlockPos(224360446 ^ 224360438, 224360375 ^ 224360438, 224360437 ^ 224360438);
      var1[224360433 ^ 224360438] = new BlockPos(224360446 ^ 224360438, 224360375 ^ 224360438, 224360434 ^ 224360438);
      var1[224360446 ^ 224360438] = new BlockPos(224360446 ^ 224360438, 224360375 ^ 224360438, 224360435 ^ 224360438);
      var1[224360447 ^ 224360438] = new BlockPos(224360433 ^ 224360438, 224360375 ^ 224360438, 224360435 ^ 224360438);
      var1[224360444 ^ 224360438] = new BlockPos(224360433 ^ 224360438, 224360375 ^ 224360438, 224360432 ^ 224360438);
      var1[224360445 ^ 224360438] = new BlockPos(224360433 ^ 224360438, 224360375 ^ 224360438, 224360433 ^ 224360438);
      var1[224360442 ^ 224360438] = new BlockPos(224360432 ^ 224360438, 224360375 ^ 224360438, 224360433 ^ 224360438);
      var1[224360443 ^ 224360438] = new BlockPos(224360435 ^ 224360438, 224360375 ^ 224360438, 224360433 ^ 224360438);
      var1[224360440 ^ 224360438] = new BlockPos(224360435 ^ 224360438, 224360375 ^ 224360438, 224360446 ^ 224360438);
      var1[224360441 ^ 224360438] = new BlockPos(224360434 ^ 224360438, 224360375 ^ 224360438, 224360446 ^ 224360438);
      var1[224360422 ^ 224360438] = new BlockPos(224360437 ^ 224360438, 224360375 ^ 224360438, 224360446 ^ 224360438);
      var1[224360423 ^ 224360438] = new BlockPos(224360437 ^ 224360438, 224360375 ^ 224360438, 224360447 ^ 224360438);
      var1[224360420 ^ 224360438] = new BlockPos(224360436 ^ 224360438, 224360375 ^ 224360438, 224360447 ^ 224360438);
      var1[224360421 ^ 224360438] = new BlockPos(1, 224360375 ^ 224360438, 224360447 ^ 224360438);
      var1[224360418 ^ 224360438] = new BlockPos(0, 224360375 ^ 224360438, 224360447 ^ 224360438);
      var1[224360419 ^ 224360438] = new BlockPos(-1, 224360375 ^ 224360438, 224360447 ^ 224360438);
      var1[224360416 ^ 224360438] = new BlockPos(-224360440 ^ 224360438, 224360375 ^ 224360438, 224360447 ^ 224360438);
      var1[224360417 ^ 224360438] = new BlockPos(-224360437 ^ 224360438, 224360375 ^ 224360438, 224360447 ^ 224360438);
      var1[224360430 ^ 224360438] = new BlockPos(-224360437 ^ 224360438, 224360375 ^ 224360438, 224360446 ^ 224360438);
      var1[224360431 ^ 224360438] = new BlockPos(-224360438 ^ 224360438, 224360375 ^ 224360438, 224360446 ^ 224360438);
      var1[224360428 ^ 224360438] = new BlockPos(-224360435 ^ 224360438, 224360375 ^ 224360438, 224360446 ^ 224360438);
      var1[224360429 ^ 224360438] = new BlockPos(-224360435 ^ 224360438, 224360375 ^ 224360438, 224360433 ^ 224360438);
      var1[224360426 ^ 224360438] = new BlockPos(-224360436 ^ 224360438, 224360375 ^ 224360438, 224360433 ^ 224360438);
      var1[224360427 ^ 224360438] = new BlockPos(-224360433 ^ 224360438, 224360375 ^ 224360438, 224360433 ^ 224360438);
      var1[224360424 ^ 224360438] = new BlockPos(-224360433 ^ 224360438, 224360375 ^ 224360438, 224360432 ^ 224360438);
      var1[224360425 ^ 224360438] = new BlockPos(-224360433 ^ 224360438, 224360375 ^ 224360438, 224360435 ^ 224360438);
      var1[224360406 ^ 224360438] = new BlockPos(-224360434 ^ 224360438, 224360375 ^ 224360438, 224360435 ^ 224360438);
      var1[224360407 ^ 224360438] = new BlockPos(-224360434 ^ 224360438, 224360375 ^ 224360438, 224360434 ^ 224360438);
      var1[224360404 ^ 224360438] = new BlockPos(-224360434 ^ 224360438, 224360375 ^ 224360438, 224360437 ^ 224360438);
      var1[224360405 ^ 224360438] = new BlockPos(-224360447 ^ 224360438, 224360375 ^ 224360438, 224360437 ^ 224360438);
      var1[224360402 ^ 224360438] = new BlockPos(-224360447 ^ 224360438, 224360375 ^ 224360438, 224360436 ^ 224360438);
      var1[224360403 ^ 224360438] = new BlockPos(-224360447 ^ 224360438, 224360375 ^ 224360438, 1);
      var1[224360400 ^ 224360438] = new BlockPos(-224360447 ^ 224360438, 224360375 ^ 224360438, 0);
      var1[224360401 ^ 224360438] = new BlockPos(-224360447 ^ 224360438, 224360375 ^ 224360438, -1);
      var1[224360414 ^ 224360438] = new BlockPos(-224360447 ^ 224360438, 224360375 ^ 224360438, -224360440 ^ 224360438);
      var1[224360415 ^ 224360438] = new BlockPos(-224360447 ^ 224360438, 224360375 ^ 224360438, -224360437 ^ 224360438);
      var1[224360412 ^ 224360438] = new BlockPos(-224360434 ^ 224360438, 224360375 ^ 224360438, -224360437 ^ 224360438);
      var1[224360413 ^ 224360438] = new BlockPos(-224360434 ^ 224360438, 224360375 ^ 224360438, -224360438 ^ 224360438);
      var1[224360410 ^ 224360438] = new BlockPos(-224360434 ^ 224360438, 224360375 ^ 224360438, -224360435 ^ 224360438);
      var1[224360411 ^ 224360438] = new BlockPos(-224360433 ^ 224360438, 224360375 ^ 224360438, -224360435 ^ 224360438);
      var1[224360408 ^ 224360438] = new BlockPos(-224360433 ^ 224360438, 224360375 ^ 224360438, -224360436 ^ 224360438);
      var1[224360409 ^ 224360438] = new BlockPos(-224360433 ^ 224360438, 224360375 ^ 224360438, -224360433 ^ 224360438);
      var1[224360390 ^ 224360438] = new BlockPos(-224360436 ^ 224360438, 224360375 ^ 224360438, -224360433 ^ 224360438);
      var1[224360391 ^ 224360438] = new BlockPos(-224360435 ^ 224360438, 224360375 ^ 224360438, -224360433 ^ 224360438);
      var1[224360388 ^ 224360438] = new BlockPos(-224360435 ^ 224360438, 224360375 ^ 224360438, -224360434 ^ 224360438);
      var1[224360389 ^ 224360438] = new BlockPos(-224360438 ^ 224360438, 224360375 ^ 224360438, -224360434 ^ 224360438);
      var1[224360386 ^ 224360438] = new BlockPos(-224360437 ^ 224360438, 224360375 ^ 224360438, -224360434 ^ 224360438);
      var1[224360387 ^ 224360438] = new BlockPos(-224360437 ^ 224360438, 224360375 ^ 224360438, -224360447 ^ 224360438);
      var1[224360384 ^ 224360438] = new BlockPos(-224360440 ^ 224360438, 224360375 ^ 224360438, -224360447 ^ 224360438);
      var1[224360385 ^ 224360438] = new BlockPos(-1, 224360375 ^ 224360438, -224360447 ^ 224360438);
      var1[224360398 ^ 224360438] = new BlockPos(0, 224360375 ^ 224360438, -224360447 ^ 224360438);
      var1[224360399 ^ 224360438] = new BlockPos(1, 224360375 ^ 224360438, -224360447 ^ 224360438);
      var1[224360396 ^ 224360438] = new BlockPos(224360436 ^ 224360438, 224360375 ^ 224360438, -224360447 ^ 224360438);
      var1[224360397 ^ 224360438] = new BlockPos(224360437 ^ 224360438, 224360375 ^ 224360438, -224360447 ^ 224360438);
      var1[224360394 ^ 224360438] = new BlockPos(224360437 ^ 224360438, 224360375 ^ 224360438, -224360434 ^ 224360438);
      var1[224360395 ^ 224360438] = new BlockPos(224360434 ^ 224360438, 224360375 ^ 224360438, -224360434 ^ 224360438);
      var1[224360392 ^ 224360438] = new BlockPos(224360435 ^ 224360438, 224360375 ^ 224360438, -224360434 ^ 224360438);
      var1[224360393 ^ 224360438] = new BlockPos(224360435 ^ 224360438, 224360375 ^ 224360438, -224360433 ^ 224360438);
      var1[224360374 ^ 224360438] = new BlockPos(224360432 ^ 224360438, 224360375 ^ 224360438, -224360433 ^ 224360438);
      var1[224360375 ^ 224360438] = new BlockPos(224360433 ^ 224360438, 224360375 ^ 224360438, -224360433 ^ 224360438);
      var1[224360372 ^ 224360438] = new BlockPos(224360433 ^ 224360438, 224360375 ^ 224360438, -224360436 ^ 224360438);
      var1[224360373 ^ 224360438] = new BlockPos(224360433 ^ 224360438, 224360375 ^ 224360438, -224360435 ^ 224360438);
      var1[224360370 ^ 224360438] = new BlockPos(224360446 ^ 224360438, 224360375 ^ 224360438, -224360435 ^ 224360438);
      var1[224360371 ^ 224360438] = new BlockPos(224360446 ^ 224360438, 224360375 ^ 224360438, -224360438 ^ 224360438);
      var1[224360368 ^ 224360438] = new BlockPos(224360446 ^ 224360438, 224360375 ^ 224360438, -224360437 ^ 224360438);
      var1[224360369 ^ 224360438] = new BlockPos(224360447 ^ 224360438, 224360375 ^ 224360438, -224360437 ^ 224360438);
      this.դ = Arrays.asList(var1);
      var10001 = new String[224360434 ^ 224360438];
      var10001[0] = "Oak fence";
      var10001[1] = "Leaves";
      var10001[224360436 ^ 224360438] = "Glass";
      var10001[224360437 ^ 224360438] = "Barrier";
      this.ƥ = var10001;
      this.ą("Fences for Hypixel sumo.");
      this.Ӟ = Blocks.oak_fence.getDefaultState();
      this.ʌ(new oc4d46a99983("Fences for Hypixel sumo."));
      this.ʌ(this.ʩ = new oca9cc61aada("Fence height", 4.0, 1.0, 6.0, 1.0));
      this.ʌ(this.Ҙ = new oca9cc61aada("Block type", 0, this.ƥ));
   }

   @Override
   public void onEnable() {
      this.ӟ = 0;
   }

   @Override
   public void onDisable() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1a
      // 09: bipush 0
      // 0a: putfield x/oc2ff590173b.ӟ I
      // 0d: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 10: ifne 19
      // 13: goto 17
      // 16: athrow
      // 17: return
      // 18: athrow
      // 19: aload 0
      // 1a: getfield x/oc2ff590173b.դ Ljava/util/List;
      // 1d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 22: astore 2
      // 23: aload 2
      // 24: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 29: ifeq a8
      // 2c: aload 2
      // 2d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 32: checkcast net/minecraft/util/BlockPos
      // 35: astore 3
      // 36: bipush 0
      // 37: istore 4
      // 39: iload 4
      // 3b: i2d
      // 3c: aload 0
      // 3d: getfield x/oc2ff590173b.ʩ Lx/oca9cc61aada;
      // 40: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 43: dcmpg
      // 44: ifge a4
      // 47: new net/minecraft/util/BlockPos
      // 4a: dup
      // 4b: aload 3
      // 4c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 4f: aload 3
      // 50: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 53: iload 4
      // 55: iadd
      // 56: aload 3
      // 57: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 5a: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 5d: iload 1
      // 5e: ifne 35
      // 61: astore 5
      // 63: iload 1
      // 64: ifne a0
      // 67: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 6a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 6d: aload 5
      // 6f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 72: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 77: aload 0
      // 78: getfield x/oc2ff590173b.Ӟ Lnet/minecraft/block/state/IBlockState;
      // 7b: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 80: if_acmpne 9d
      // 83: goto 87
      // 86: athrow
      // 87: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 8a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 8d: aload 5
      // 8f: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 92: invokevirtual net/minecraft/block/Block.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 95: invokevirtual net/minecraft/client/multiplayer/WorldClient.setBlockState (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Z
      // 98: pop
      // 99: goto 9d
      // 9c: athrow
      // 9d: iinc 4 1
      // a0: iload 1
      // a1: ifeq 39
      // a4: iload 1
      // a5: ifeq 23
      // a8: return
   }

   @Override
   public void z$1m9j3ewef9s() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 1
      // 08: ifne 29
      // 0b: ifeq 33
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: iload 1
      // 14: ifne 43
      // 17: goto 1b
      // 1a: athrow
      // 1b: dup
      // 1c: getfield x/oc2ff590173b.ӟ I
      // 1f: bipush 1
      // 20: iadd
      // 21: dup_x1
      // 22: putfield x/oc2ff590173b.ӟ I
      // 25: goto 29
      // 28: athrow
      // 29: ldc_w 69502577
      // 2c: ldc_w 69502587
      // 2f: ixor
      // 30: if_icmpge 35
      // 33: return
      // 34: athrow
      // 35: aload 0
      // 36: iload 1
      // 37: ifne 4c
      // 3a: bipush 0
      // 3b: putfield x/oc2ff590173b.ӟ I
      // 3e: aload 0
      // 3f: goto 43
      // 42: athrow
      // 43: invokevirtual x/oc2ff590173b.ȫ ()Z
      // 46: ifne 4b
      // 49: return
      // 4a: athrow
      // 4b: aload 0
      // 4c: getfield x/oc2ff590173b.դ Ljava/util/List;
      // 4f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 54: astore 2
      // 55: aload 2
      // 56: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 5b: ifeq d2
      // 5e: aload 2
      // 5f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 64: checkcast net/minecraft/util/BlockPos
      // 67: astore 3
      // 68: bipush 0
      // 69: istore 4
      // 6b: iload 4
      // 6d: i2d
      // 6e: aload 0
      // 6f: getfield x/oc2ff590173b.ʩ Lx/oca9cc61aada;
      // 72: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 75: dcmpg
      // 76: ifge ce
      // 79: new net/minecraft/util/BlockPos
      // 7c: dup
      // 7d: aload 3
      // 7e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 81: aload 3
      // 82: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 85: iload 4
      // 87: iadd
      // 88: aload 3
      // 89: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 8c: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 8f: astore 5
      // 91: iload 1
      // 92: ifne 55
      // 95: iload 1
      // 96: ifne ca
      // 99: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 9c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 9f: aload 5
      // a1: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // a4: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // a9: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // ac: if_acmpne c7
      // af: goto b3
      // b2: athrow
      // b3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b6: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // b9: aload 5
      // bb: aload 0
      // bc: getfield x/oc2ff590173b.Ӟ Lnet/minecraft/block/state/IBlockState;
      // bf: invokevirtual net/minecraft/client/multiplayer/WorldClient.setBlockState (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Z
      // c2: pop
      // c3: goto c7
      // c6: athrow
      // c7: iinc 4 1
      // ca: iload 1
      // cb: ifeq 6b
      // ce: iload 1
      // cf: ifeq 55
      // d2: return
   }

   @oc66fa4f2195
   public void ȩ(MouseEvent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 018
      // 009: getfield x/MouseEvent.buttonstate Z
      // 00c: ifeq 105
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: goto 018
      // 017: athrow
      // 018: getfield x/MouseEvent.button I
      // 01b: iload 2
      // 01c: ifne 041
      // 01f: ifeq 03a
      // 022: goto 026
      // 025: athrow
      // 026: aload 1
      // 027: getfield x/MouseEvent.button I
      // 02a: iload 2
      // 02b: ifne 041
      // 02e: goto 032
      // 031: athrow
      // 032: bipush 1
      // 033: if_icmpne 105
      // 036: goto 03a
      // 039: athrow
      // 03a: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 03d: goto 041
      // 040: athrow
      // 041: iload 2
      // 042: ifne 054
      // 045: ifeq 105
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 0
      // 04d: invokevirtual x/oc2ff590173b.ȫ ()Z
      // 050: goto 054
      // 053: athrow
      // 054: ifeq 105
      // 057: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05a: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 05d: astore 3
      // 05e: aload 3
      // 05f: iload 2
      // 060: ifne 06b
      // 063: ifnull 105
      // 066: goto 06a
      // 069: athrow
      // 06a: aload 3
      // 06b: iload 2
      // 06c: ifne 081
      // 06f: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 072: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 075: if_acmpne 105
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 3
      // 07d: goto 081
      // 080: athrow
      // 081: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 084: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 087: istore 4
      // 089: aload 3
      // 08a: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 08d: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 090: istore 5
      // 092: aload 0
      // 093: getfield x/oc2ff590173b.դ Ljava/util/List;
      // 096: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 09b: astore 6
      // 09d: aload 6
      // 09f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0a4: ifeq 105
      // 0a7: aload 6
      // 0a9: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0ae: checkcast net/minecraft/util/BlockPos
      // 0b1: astore 7
      // 0b3: aload 7
      // 0b5: iload 2
      // 0b6: ifne 0cb
      // 0b9: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0bc: iload 4
      // 0be: if_icmpne 0fd
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 7
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0ce: iload 2
      // 0cf: ifne 0f0
      // 0d2: iload 5
      // 0d4: if_icmpne 0fd
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 1
      // 0dc: bipush 1
      // 0dd: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 0e0: iload 2
      // 0e1: ifne 0f9
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 1
      // 0e9: getfield x/MouseEvent.button I
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: ifne 0f6
      // 0f3: invokestatic x/oc7ab2161b9f.ք ()V
      // 0f6: invokestatic org/lwjgl/input/Mouse.poll ()V
      // 0f9: iload 2
      // 0fa: ifeq 105
      // 0fd: iload 2
      // 0fe: ifeq 09d
      // 101: goto 105
      // 104: athrow
      // 105: return
   }

   private boolean ȫ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Տ ()Z
      // 07: iload 1
      // 08: ifne 8f
      // 0b: ifeq 8e
      // 0e: goto 12
      // 11: athrow
      // 12: invokestatic x/oc7ab2161b9f.ð ()Ljava/util/List;
      // 15: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1a: astore 2
      // 1b: aload 2
      // 1c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 21: ifeq 8e
      // 24: aload 2
      // 25: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2a: checkcast java/lang/String
      // 2d: astore 3
      // 2e: aload 3
      // 2f: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 32: astore 4
      // 34: aload 4
      // 36: ldc_w "Map:"
      // 39: iload 1
      // 3a: ifne 7a
      // 3d: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 40: iload 1
      // 41: ifne 8f
      // 44: goto 48
      // 47: athrow
      // 48: ifeq 75
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 0
      // 50: getfield x/oc2ff590173b.Ɣ Ljava/util/List;
      // 53: aload 4
      // 55: ldc_w 1770263010
      // 58: ldc_w 1770263015
      // 5b: ixor
      // 5c: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 5f: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 64: iload 1
      // 65: ifne 74
      // 68: goto 6c
      // 6b: athrow
      // 6c: ifeq 8a
      // 6f: goto 73
      // 72: athrow
      // 73: bipush 1
      // 74: ireturn
      // 75: aload 4
      // 77: ldc_w "Mode: Sumo Duel"
      // 7a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7d: iload 1
      // 7e: ifne 89
      // 81: ifeq 8a
      // 84: goto 88
      // 87: athrow
      // 88: bipush 1
      // 89: ireturn
      // 8a: iload 1
      // 8b: ifeq 1b
      // 8e: bipush 0
      // 8f: ireturn
   }

   @Override
   public void z$2u87utkr1isxg() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 36
      // 09: getfield x/oc2ff590173b.Ҙ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: tableswitch 101 0 3 33 51 69 87
      // 30: athrow
      // 31: aload 0
      // 32: goto 36
      // 35: athrow
      // 36: getstatic net/minecraft/init/Blocks.oak_fence Lnet/minecraft/block/Block;
      // 39: invokevirtual net/minecraft/block/Block.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 3c: putfield x/oc2ff590173b.Ӟ Lnet/minecraft/block/state/IBlockState;
      // 3f: iload 1
      // 40: ifeq 75
      // 43: aload 0
      // 44: getstatic net/minecraft/init/Blocks.leaves Lnet/minecraft/block/BlockLeaves;
      // 47: invokevirtual net/minecraft/block/BlockLeaves.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 4a: putfield x/oc2ff590173b.Ӟ Lnet/minecraft/block/state/IBlockState;
      // 4d: iload 1
      // 4e: ifeq 75
      // 51: goto 55
      // 54: athrow
      // 55: aload 0
      // 56: getstatic net/minecraft/init/Blocks.glass Lnet/minecraft/block/Block;
      // 59: invokevirtual net/minecraft/block/Block.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 5c: putfield x/oc2ff590173b.Ӟ Lnet/minecraft/block/state/IBlockState;
      // 5f: iload 1
      // 60: ifeq 75
      // 63: goto 67
      // 66: athrow
      // 67: aload 0
      // 68: getstatic net/minecraft/init/Blocks.barrier Lnet/minecraft/block/Block;
      // 6b: invokevirtual net/minecraft/block/Block.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 6e: putfield x/oc2ff590173b.Ӟ Lnet/minecraft/block/state/IBlockState;
      // 71: goto 75
      // 74: athrow
      // 75: return
   }
}
