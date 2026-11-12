 // seem like scaffold
package x;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class oc63a9b409d2 extends oc69da1aa7f5 {
   private static final float ǧ = -5.0F;
   private static final float Ș = 110.0F;
   private oca9cc61aada Б;
   private occ2f8dff8d8 Ϧ;
   private occ2f8dff8d8 ǿ;
   private occ2f8dff8d8 ˡ;
   private occ2f8dff8d8 Č;
   private occ2f8dff8d8 Զ;
   private occ2f8dff8d8 Լ;
   private oca9cc61aada Ѝ;
   private occ2f8dff8d8 Ȑ;
   private ConcurrentHashMap<BlockPos, oc2ae3d414e8> ƥ = new ConcurrentHashMap<>();
   private BlockPos ҡ;
   private boolean Э;
   private oc9b32a258fb մ;
   private boolean ʧ;
   private boolean ѫ;
   private int բ = -1;
   private boolean в;
   public List<BlockPos> Г;
   private boolean ӏ;
   private double Ӧ;
   private int ѷ;
   private boolean Ǆ;
   private float ȍ;
   private float Ɩ;
   private boolean ү;
   private float ʯ;
   private float Ͱ;
   public static int ɭ;

   public oc63a9b409d2() {
      super("SpeedBuilders", oce4cea752dd.Ԃ);
      BlockPos[] var10001 = new BlockPos[941207371 ^ 941207363];
      var10001[0] = new BlockPos(941207406 ^ 941207363, 941207300 ^ 941207363, -941207379 ^ 941207363);
      var10001[1] = new BlockPos(-941207373 ^ 941207363, 941207300 ^ 941207363, 941207406 ^ 941207363);
      var10001[941207361 ^ 941207363] = new BlockPos(941207377 ^ 941207363, 941207300 ^ 941207363, 941207406 ^ 941207363);
      var10001[941207360 ^ 941207363] = new BlockPos(941207406 ^ 941207363, 941207300 ^ 941207363, 941207379 ^ 941207363);
      var10001[941207367 ^ 941207363] = new BlockPos(-941207379 ^ 941207363, 941207300 ^ 941207363, -941207408 ^ 941207363);
      var10001[941207366 ^ 941207363] = new BlockPos(-941207408 ^ 941207363, 941207300 ^ 941207363, -941207373 ^ 941207363);
      var10001[941207365 ^ 941207363] = new BlockPos(-941207408 ^ 941207363, 941207300 ^ 941207363, 941207377 ^ 941207363);
      var10001[941207364 ^ 941207363] = new BlockPos(941207379 ^ 941207363, 941207300 ^ 941207363, -941207408 ^ 941207363);
      this.Г = Arrays.asList(var10001);
      this.ѷ = 0;
      this.ȍ = -5.0F;
      this.Ɩ = 110.0F;
      this.ą("Automate finish the SpeedBuilders.");
      this.ʌ(new oc4d46a99983("Middle click to toggle AutoBuild."));
      this.ʌ(this.Б = new oca9cc61aada("Place delay", " tick", 0.5, 0.0, 10.0, 0.5));
      this.ʌ(this.Ϧ = new occ2f8dff8d8("Anti miss", false));
      String[] var10006 = new String[941207360 ^ 941207363];
      var10006[0] = "setting.autoPlace";
      var10006[1] = "Auto place";
      var10006[941207361 ^ 941207363] = "autoPlace";
      this.ʌ(this.ǿ = new occ2f8dff8d8("AutoBuild", false, var10006));
      this.ʌ(this.ˡ = new occ2f8dff8d8("Auto swap", true));
      this.ʌ(this.Č = new occ2f8dff8d8("Hover place", true));
      this.ʌ(this.Զ = new occ2f8dff8d8("Info HUD", true));
      this.ʌ(this.Լ = new occ2f8dff8d8("Render blocks", true));
      var10006 = new String[941207361 ^ 941207363];
      var10006[0] = "Overlay";
      var10006[1] = "Block model";
      this.ʌ(this.Ѝ = new oca9cc61aada("Render mode", 0, var10006));
      this.ʌ(this.Ȑ = new occ2f8dff8d8("Render only placeable", false));
      this.օ();
   }

   @Override
   public void onDisable() {
      this.ѷ = 0;
      this.ү = false;
      this.ƺ();
   }

   @oc66fa4f2195
   public void բ(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 2
      // 004: iload 2
      // 005: aload 0
      // 006: invokevirtual x/oc63a9b409d2.ҿ ()I
      // 009: istore 3
      // 00a: ifne 031
      // 00d: iload 3
      // 00e: bipush -1
      // 00f: if_icmpeq 029
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: iload 2
      // 018: ifne 02e
      // 01b: goto 01f
      // 01e: athrow
      // 01f: getfield x/oc63a9b409d2.ҡ Lnet/minecraft/util/BlockPos;
      // 022: ifnonnull 032
      // 025: goto 029
      // 028: athrow
      // 029: aload 0
      // 02a: goto 02e
      // 02d: athrow
      // 02e: invokevirtual x/oc63a9b409d2.ƺ ()V
      // 031: return
      // 032: iload 3
      // 033: iload 2
      // 034: ifne 04d
      // 037: ldc 1050562370
      // 039: ldc 1050562374
      // 03b: ixor
      // 03c: if_icmpne 04c
      // 03f: goto 043
      // 042: athrow
      // 043: aload 0
      // 044: bipush 1
      // 045: putfield x/oc63a9b409d2.ӏ Z
      // 048: goto 04c
      // 04b: athrow
      // 04c: iload 3
      // 04d: iload 2
      // 04e: ifne 09f
      // 051: bipush 1
      // 052: if_icmpne 09e
      // 055: goto 059
      // 058: athrow
      // 059: aload 0
      // 05a: getfield x/oc63a9b409d2.ӏ Z
      // 05d: iload 2
      // 05e: ifne 09f
      // 061: goto 065
      // 064: athrow
      // 065: ifne 09e
      // 068: goto 06c
      // 06b: athrow
      // 06c: aload 0
      // 06d: aload 0
      // 06e: aload 0
      // 06f: getfield x/oc63a9b409d2.ҡ Lnet/minecraft/util/BlockPos;
      // 072: invokevirtual x/oc63a9b409d2.ӻ (Lnet/minecraft/util/BlockPos;)Ljava/util/concurrent/ConcurrentHashMap;
      // 075: putfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 078: aload 0
      // 079: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 07c: invokevirtual java/util/concurrent/ConcurrentHashMap.isEmpty ()Z
      // 07f: iload 2
      // 080: ifne 09f
      // 083: goto 087
      // 086: athrow
      // 087: ifne 09e
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 0
      // 08f: aload 0
      // 090: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 093: invokevirtual java/util/concurrent/ConcurrentHashMap.size ()I
      // 096: i2d
      // 097: putfield x/oc63a9b409d2.Ӧ D
      // 09a: goto 09e
      // 09d: athrow
      // 09e: iload 3
      // 09f: ldc_w 1050562372
      // 0a2: ldc 1050562374
      // 0a4: ixor
      // 0a5: if_icmpeq 0ae
      // 0a8: aload 0
      // 0a9: invokevirtual x/oc63a9b409d2.ǹ ()V
      // 0ac: return
      // 0ad: athrow
      // 0ae: aload 0
      // 0af: bipush 0
      // 0b0: putfield x/oc63a9b409d2.ӏ Z
      // 0b3: aload 0
      // 0b4: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 0b7: invokevirtual java/util/concurrent/ConcurrentHashMap.entrySet ()Ljava/util/Set;
      // 0ba: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0bf: astore 4
      // 0c1: aload 4
      // 0c3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0c8: ifeq 14c
      // 0cb: aload 4
      // 0cd: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d2: checkcast java/util/Map$Entry
      // 0d5: astore 5
      // 0d7: iload 2
      // 0d8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0db: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0de: aload 5
      // 0e0: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0e5: checkcast net/minecraft/util/BlockPos
      // 0e8: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0eb: astore 6
      // 0ed: ifne 17d
      // 0f0: aload 5
      // 0f2: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 0f7: checkcast x/oc2ae3d414e8
      // 0fa: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 0fd: astore 7
      // 0ff: iload 2
      // 100: ifne 12f
      // 103: aload 6
      // 105: ifnull 11d
      // 108: goto 10c
      // 10b: athrow
      // 10c: aload 7
      // 10e: iload 2
      // 10f: ifne 13a
      // 112: goto 116
      // 115: athrow
      // 116: ifnonnull 133
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 5
      // 11f: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 124: checkcast x/oc2ae3d414e8
      // 127: bipush 0
      // 128: putfield x/oc2ae3d414e8.ġ Z
      // 12b: goto 12f
      // 12e: athrow
      // 12f: iload 2
      // 130: ifeq 0c1
      // 133: aload 5
      // 135: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 13a: checkcast x/oc2ae3d414e8
      // 13d: aload 0
      // 13e: aload 6
      // 140: aload 7
      // 142: invokevirtual x/oc63a9b409d2.ӂ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/block/state/IBlockState;)Z
      // 145: putfield x/oc2ae3d414e8.ġ Z
      // 148: iload 2
      // 149: ifeq 0c1
      // 14c: aload 0
      // 14d: iload 2
      // 14e: ifne 17e
      // 151: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 154: ifnull 17d
      // 157: goto 15b
      // 15a: athrow
      // 15b: aload 0
      // 15c: iload 2
      // 15d: ifne 17e
      // 160: goto 164
      // 163: athrow
      // 164: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 167: aload 0
      // 168: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 16b: invokevirtual x/oc9b32a258fb.Ț (Ljava/util/Map;)Z
      // 16e: ifeq 17d
      // 171: goto 175
      // 174: athrow
      // 175: aload 0
      // 176: invokevirtual x/oc63a9b409d2.ǹ ()V
      // 179: goto 17d
      // 17c: athrow
      // 17d: aload 0
      // 17e: iload 2
      // 17f: ifne 197
      // 182: invokevirtual x/oc63a9b409d2.ǆ ()Z
      // 185: ifeq 192
      // 188: goto 18c
      // 18b: athrow
      // 18c: aload 0
      // 18d: invokevirtual x/oc63a9b409d2.Ƥ ()V
      // 190: return
      // 191: athrow
      // 192: aload 0
      // 193: invokevirtual x/oc63a9b409d2.ǹ ()V
      // 196: aload 0
      // 197: iload 2
      // 198: ifne 1aa
      // 19b: invokevirtual x/oc63a9b409d2.Ә ()Lnet/minecraft/util/MovingObjectPosition;
      // 19e: ifnull 378
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: aload 0
      // 1a6: goto 1aa
      // 1a9: athrow
      // 1aa: invokevirtual x/oc63a9b409d2.Ә ()Lnet/minecraft/util/MovingObjectPosition;
      // 1ad: astore 4
      // 1af: aload 4
      // 1b1: iload 2
      // 1b2: ifne 1c5
      // 1b5: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 1b8: ifnull 378
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: aload 4
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 1c8: astore 5
      // 1ca: aload 5
      // 1cc: aload 4
      // 1ce: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 1d1: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 1d4: astore 6
      // 1d6: aload 0
      // 1d7: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 1da: aload 6
      // 1dc: invokevirtual java/util/concurrent/ConcurrentHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 1df: checkcast x/oc2ae3d414e8
      // 1e2: astore 7
      // 1e4: aload 7
      // 1e6: iload 2
      // 1e7: ifne 1f3
      // 1ea: ifnull 378
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: aload 7
      // 1f3: getfield x/oc2ae3d414e8.ġ Z
      // 1f6: iload 2
      // 1f7: ifne 214
      // 1fa: ifne 378
      // 1fd: goto 201
      // 200: athrow
      // 201: aload 0
      // 202: getfield x/oc63a9b409d2.ˡ Lx/occ2f8dff8d8;
      // 205: iload 2
      // 206: ifne 28a
      // 209: goto 20d
      // 20c: athrow
      // 20d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 210: goto 214
      // 213: athrow
      // 214: ifeq 27e
      // 217: aload 7
      // 219: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 21c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 221: aload 7
      // 223: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 226: invokevirtual net/minecraft/block/Block.getMetaFromState (Lnet/minecraft/block/state/IBlockState;)I
      // 229: iload 2
      // 22a: ifne 28d
      // 22d: goto 231
      // 230: athrow
      // 231: istore 8
      // 233: aload 0
      // 234: aload 7
      // 236: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 239: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 23e: iload 8
      // 240: invokevirtual x/oc63a9b409d2.Ȕ (Lnet/minecraft/block/Block;I)I
      // 243: istore 9
      // 245: iload 9
      // 247: bipush -1
      // 248: if_icmpeq 27e
      // 24b: iload 9
      // 24d: iload 2
      // 24e: ifne 28d
      // 251: goto 255
      // 254: athrow
      // 255: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 258: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 25b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 25e: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 261: if_icmpeq 27e
      // 264: goto 268
      // 267: athrow
      // 268: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26e: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 271: iload 9
      // 273: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 276: aload 0
      // 277: invokevirtual x/oc63a9b409d2.π ()V
      // 27a: goto 27e
      // 27d: athrow
      // 27e: aload 0
      // 27f: iload 2
      // 280: ifne 291
      // 283: getfield x/oc63a9b409d2.Č Lx/occ2f8dff8d8;
      // 286: goto 28a
      // 289: athrow
      // 28a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 28d: ifeq 378
      // 290: aload 0
      // 291: iload 2
      // 292: ifne 2a9
      // 295: aload 7
      // 297: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 29a: invokevirtual x/oc63a9b409d2.в (Lnet/minecraft/block/state/IBlockState;)Z
      // 29d: ifeq 378
      // 2a0: goto 2a4
      // 2a3: athrow
      // 2a4: aload 0
      // 2a5: goto 2a9
      // 2a8: athrow
      // 2a9: dup
      // 2aa: getfield x/oc63a9b409d2.ѷ I
      // 2ad: dup_x1
      // 2ae: bipush 1
      // 2af: iadd
      // 2b0: putfield x/oc63a9b409d2.ѷ I
      // 2b3: i2d
      // 2b4: aload 0
      // 2b5: getfield x/oc63a9b409d2.Б Lx/oca9cc61aada;
      // 2b8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2bb: dcmpg
      // 2bc: ifge 2c1
      // 2bf: return
      // 2c0: athrow
      // 2c1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2c4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c7: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 2ca: astore 8
      // 2cc: aload 8
      // 2ce: aload 5
      // 2d0: aload 4
      // 2d2: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 2d5: invokestatic x/occb1ed1ed8f.ā (Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 2d8: iload 2
      // 2d9: ifne 306
      // 2dc: ifeq 373
      // 2df: goto 2e3
      // 2e2: athrow
      // 2e3: aload 0
      // 2e4: iload 2
      // 2e5: ifne 374
      // 2e8: goto 2ec
      // 2eb: athrow
      // 2ec: aload 7
      // 2ee: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 2f1: aload 5
      // 2f3: aload 4
      // 2f5: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 2f8: aload 4
      // 2fa: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 2fd: aload 8
      // 2ff: invokevirtual x/oc63a9b409d2.Ʋ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;Lnet/minecraft/item/ItemStack;)Z
      // 302: goto 306
      // 305: athrow
      // 306: ifeq 373
      // 309: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 30c: iload 2
      // 30d: ifne 327
      // 310: goto 314
      // 313: athrow
      // 314: invokeinterface x/oc8ecfa69e1b.getRightClickDelayTimer ()I 1
      // 319: ifgt 373
      // 31c: goto 320
      // 31f: athrow
      // 320: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 323: goto 327
      // 326: athrow
      // 327: iload 2
      // 328: ifne 362
      // 32b: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 32e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 331: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 334: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 337: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 33a: aload 8
      // 33c: aload 5
      // 33e: aload 4
      // 340: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 343: aload 4
      // 345: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 348: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 34b: ifeq 373
      // 34e: goto 352
      // 351: athrow
      // 352: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 355: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 358: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 35b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35e: goto 362
      // 361: athrow
      // 362: bipush 1
      // 363: aload 0
      // 364: getfield x/oc63a9b409d2.Б Lx/oca9cc61aada;
      // 367: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 36a: d2i
      // 36b: invokestatic java/lang/Math.max (II)I
      // 36e: invokeinterface x/oc8ecfa69e1b.setRightClickDelayTimer (I)V 2
      // 373: aload 0
      // 374: bipush 0
      // 375: putfield x/oc63a9b409d2.ѷ I
      // 378: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void ξ(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 082
      // 009: invokevirtual x/oc63a9b409d2.ǆ ()Z
      // 00c: ifeq 07d
      // 00f: goto 013
      // 012: athrow
      // 013: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 016: iload 2
      // 017: ifne 035
      // 01a: goto 01e
      // 01d: athrow
      // 01e: ifeq 07d
      // 021: goto 025
      // 024: athrow
      // 025: aload 0
      // 026: iload 2
      // 027: ifne 082
      // 02a: goto 02e
      // 02d: athrow
      // 02e: invokevirtual x/oc63a9b409d2.ҿ ()I
      // 031: goto 035
      // 034: athrow
      // 035: ldc_w -2126693375
      // 038: ldc_w -2126693373
      // 03b: ixor
      // 03c: if_icmpne 07d
      // 03f: aload 0
      // 040: iload 2
      // 041: ifne 082
      // 044: goto 048
      // 047: athrow
      // 048: getfield x/oc63a9b409d2.ҡ Lnet/minecraft/util/BlockPos;
      // 04b: ifnull 07d
      // 04e: goto 052
      // 051: athrow
      // 052: aload 0
      // 053: iload 2
      // 054: ifne 082
      // 057: goto 05b
      // 05a: athrow
      // 05b: getfield x/oc63a9b409d2.Ǆ Z
      // 05e: ifne 07d
      // 061: goto 065
      // 064: athrow
      // 065: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 068: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 06b: ifnonnull 07d
      // 06e: goto 072
      // 071: athrow
      // 072: aload 1
      // 073: invokevirtual x/oc86de9e2892.ň ()Z
      // 076: ifeq 086
      // 079: goto 07d
      // 07c: athrow
      // 07d: aload 0
      // 07e: goto 082
      // 081: athrow
      // 082: invokevirtual x/oc63a9b409d2.ƺ ()V
      // 085: return
      // 086: aload 0
      // 087: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 08a: astore 3
      // 08b: aload 3
      // 08c: ifnonnull 094
      // 08f: aconst_null
      // 090: goto 09c
      // 093: athrow
      // 094: aload 0
      // 095: aload 3
      // 096: getfield x/oc9b32a258fb.ϗ I
      // 099: invokevirtual x/oc63a9b409d2.щ (I)Lnet/minecraft/item/ItemStack;
      // 09c: astore 4
      // 09e: aload 3
      // 09f: iload 2
      // 0a0: ifne 0c8
      // 0a3: ifnull 0c0
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: aload 0
      // 0ab: iload 2
      // 0ac: ifne 0c5
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 3
      // 0b4: aload 4
      // 0b6: invokevirtual x/oc63a9b409d2.ԃ (Lx/oc9b32a258fb;Lnet/minecraft/item/ItemStack;)Z
      // 0b9: ifne 0c9
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aload 0
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: invokevirtual x/oc63a9b409d2.ÿ ()Lx/oc9b32a258fb;
      // 0c8: astore 3
      // 0c9: aload 3
      // 0ca: ifnonnull 0d3
      // 0cd: aload 0
      // 0ce: invokevirtual x/oc63a9b409d2.ǹ ()V
      // 0d1: return
      // 0d2: athrow
      // 0d3: aload 0
      // 0d4: getfield x/oc63a9b409d2.ˡ Lx/occ2f8dff8d8;
      // 0d7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0da: iload 2
      // 0db: ifne 0ed
      // 0de: ifeq 144
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 3
      // 0e6: getfield x/oc9b32a258fb.ϗ I
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: iload 2
      // 0ee: ifne 114
      // 0f1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f7: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0fa: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 0fd: if_icmpeq 144
      // 100: goto 104
      // 103: athrow
      // 104: aload 0
      // 105: iload 2
      // 106: ifne 141
      // 109: goto 10d
      // 10c: athrow
      // 10d: getfield x/oc63a9b409d2.ѫ Z
      // 110: goto 114
      // 113: athrow
      // 114: ifne 130
      // 117: aload 0
      // 118: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11e: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 121: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 124: putfield x/oc63a9b409d2.բ I
      // 127: aload 0
      // 128: bipush 1
      // 129: putfield x/oc63a9b409d2.ѫ Z
      // 12c: goto 130
      // 12f: athrow
      // 130: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 133: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 136: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 139: aload 3
      // 13a: getfield x/oc9b32a258fb.ϗ I
      // 13d: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 140: aload 0
      // 141: invokevirtual x/oc63a9b409d2.π ()V
      // 144: getstatic x/oc75d51ec7eb.d [F
      // 147: bipush 0
      // 148: faload
      // 149: fstore 5
      // 14b: getstatic x/oc75d51ec7eb.d [F
      // 14e: bipush 1
      // 14f: faload
      // 150: fstore 6
      // 152: aload 0
      // 153: aload 3
      // 154: getfield x/oc9b32a258fb.ӥ F
      // 157: aload 3
      // 158: getfield x/oc9b32a258fb.p F
      // 15b: fload 5
      // 15d: fload 6
      // 15f: invokevirtual x/oc63a9b409d2.Ě (FFFF)[F
      // 162: astore 7
      // 164: aload 0
      // 165: aload 3
      // 166: putfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 169: aload 0
      // 16a: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 16d: aload 7
      // 16f: bipush 0
      // 170: faload
      // 171: putfield x/oc9b32a258fb.E F
      // 174: aload 0
      // 175: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 178: aload 7
      // 17a: bipush 1
      // 17b: faload
      // 17c: putfield x/oc9b32a258fb.Ҝ F
      // 17f: aload 0
      // 180: bipush 1
      // 181: putfield x/oc63a9b409d2.ʧ Z
      // 184: aload 1
      // 185: aload 7
      // 187: bipush 0
      // 188: faload
      // 189: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 18c: invokevirtual x/oc86de9e2892.t (Ljava/lang/Float;)V
      // 18f: aload 1
      // 190: aload 7
      // 192: bipush 1
      // 193: faload
      // 194: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 197: invokevirtual x/oc86de9e2892.U (Ljava/lang/Float;)V
      // 19a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19d: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 1a0: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 1a3: f2d
      // 1a4: aload 7
      // 1a6: bipush 0
      // 1a7: faload
      // 1a8: aload 7
      // 1aa: bipush 1
      // 1ab: faload
      // 1ac: invokestatic x/oc75d51ec7eb.τ (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 1af: astore 8
      // 1b1: aload 0
      // 1b2: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 1b5: iload 2
      // 1b6: ifne 1d9
      // 1b9: aload 0
      // 1ba: aload 8
      // 1bc: aload 3
      // 1bd: invokevirtual x/oc63a9b409d2.ӂ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc9b32a258fb;)Z
      // 1c0: putfield x/oc9b32a258fb.I Z
      // 1c3: aload 0
      // 1c4: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 1c7: getfield x/oc9b32a258fb.I Z
      // 1ca: ifeq 1e1
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: aload 0
      // 1d2: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 1d5: goto 1d9
      // 1d8: athrow
      // 1d9: aload 8
      // 1db: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1de: putfield x/oc9b32a258fb.վ Lnet/minecraft/util/Vec3;
      // 1e1: return
   }

   @oc66fa4f2195
   public void Å(MouseEvent param1) {
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
      // 005: getfield x/MouseEvent.buttonstate Z
      // 008: iload 2
      // 009: ifne 016
      // 00c: ifeq 026
      // 00f: goto 013
      // 012: athrow
      // 013: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 016: ifeq 026
      // 019: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01c: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 01f: ifnull 028
      // 022: goto 026
      // 025: athrow
      // 026: return
      // 027: athrow
      // 028: aload 1
      // 029: iload 2
      // 02a: ifne 104
      // 02d: getfield x/MouseEvent.button I
      // 030: bipush 1
      // 031: if_icmpne 0ff
      // 034: goto 038
      // 037: athrow
      // 038: aload 0
      // 039: getfield x/oc63a9b409d2.Ϧ Lx/occ2f8dff8d8;
      // 03c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 03f: iload 2
      // 040: ifne 107
      // 043: goto 047
      // 046: athrow
      // 047: ifeq 0ff
      // 04a: goto 04e
      // 04d: athrow
      // 04e: aload 0
      // 04f: iload 2
      // 050: ifne 066
      // 053: goto 057
      // 056: athrow
      // 057: invokevirtual x/oc63a9b409d2.Ә ()Lnet/minecraft/util/MovingObjectPosition;
      // 05a: ifnull 0ff
      // 05d: goto 061
      // 060: athrow
      // 061: aload 0
      // 062: goto 066
      // 065: athrow
      // 066: invokevirtual x/oc63a9b409d2.ҿ ()I
      // 069: iload 2
      // 06a: ifne 107
      // 06d: ldc_w 1427737175
      // 070: ldc_w 1427737173
      // 073: ixor
      // 074: if_icmpne 0ff
      // 077: goto 07b
      // 07a: athrow
      // 07b: aload 0
      // 07c: invokevirtual x/oc63a9b409d2.Ә ()Lnet/minecraft/util/MovingObjectPosition;
      // 07f: astore 3
      // 080: aload 3
      // 081: iload 2
      // 082: ifne 094
      // 085: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 088: ifnull 0fb
      // 08b: goto 08f
      // 08e: athrow
      // 08f: aload 3
      // 090: goto 094
      // 093: athrow
      // 094: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 097: astore 4
      // 099: aload 4
      // 09b: aload 3
      // 09c: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 09f: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 0a2: astore 5
      // 0a4: aload 0
      // 0a5: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 0a8: aload 5
      // 0aa: invokevirtual java/util/concurrent/ConcurrentHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0ad: checkcast x/oc2ae3d414e8
      // 0b0: astore 6
      // 0b2: aload 6
      // 0b4: ifnull 0f2
      // 0b7: aload 0
      // 0b8: aload 6
      // 0ba: iload 2
      // 0bb: ifne 0d6
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 0c5: invokevirtual x/oc63a9b409d2.в (Lnet/minecraft/block/state/IBlockState;)Z
      // 0c8: ifeq 0f2
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 0
      // 0d0: aload 6
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 0d9: aload 4
      // 0db: aload 3
      // 0dc: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 0df: aload 3
      // 0e0: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0e3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e9: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0ec: invokevirtual x/oc63a9b409d2.Ʋ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;Lnet/minecraft/item/ItemStack;)Z
      // 0ef: ifne 0fb
      // 0f2: aload 1
      // 0f3: bipush 1
      // 0f4: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: iload 2
      // 0fc: ifeq 11c
      // 0ff: aload 1
      // 100: goto 104
      // 103: athrow
      // 104: getfield x/MouseEvent.button I
      // 107: ldc_w 1427737175
      // 10a: ldc_w 1427737173
      // 10d: ixor
      // 10e: if_icmpne 11c
      // 111: aload 0
      // 112: getfield x/oc63a9b409d2.ǿ Lx/occ2f8dff8d8;
      // 115: invokevirtual x/occ2f8dff8d8.ѝ ()V
      // 118: goto 11c
      // 11b: athrow
      // 11c: return
   }

   @oc66fa4f2195
   public void ǯ(oc9adb807c19 var1) {
      try {
         if (var1.Ұ == oc110d7f376c.END) {
            this.օ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ż(oc00038824c1 var1) {
      this.օ();
   }

   private void օ() {
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
      // 06: ifne 18
      // 09: getfield x/oc63a9b409d2.Լ Lx/occ2f8dff8d8;
      // 0c: ifnull 2d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc63a9b409d2.Լ Lx/occ2f8dff8d8;
      // 1b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1e: iload 1
      // 1f: ifne 2a
      // 22: ifeq 2d
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: istore 2
      // 2f: iload 1
      // 30: ifne 4e
      // 33: iload 2
      // 34: aload 0
      // 35: getfield x/oc63a9b409d2.в Z
      // 38: if_icmpne 41
      // 3b: goto 3f
      // 3e: athrow
      // 3f: return
      // 40: athrow
      // 41: aload 0
      // 42: iload 1
      // 43: ifne 63
      // 46: iload 2
      // 47: putfield x/oc63a9b409d2.в Z
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: getfield x/oc63a9b409d2.Ѝ Lx/oca9cc61aada;
      // 52: ifnull 62
      // 55: aload 0
      // 56: getfield x/oc63a9b409d2.Ѝ Lx/oca9cc61aada;
      // 59: iload 2
      // 5a: aload 0
      // 5b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 5e: goto 62
      // 61: athrow
      // 62: aload 0
      // 63: iload 1
      // 64: ifne 76
      // 67: getfield x/oc63a9b409d2.Ȑ Lx/occ2f8dff8d8;
      // 6a: ifnull 7e
      // 6d: goto 71
      // 70: athrow
      // 71: aload 0
      // 72: goto 76
      // 75: athrow
      // 76: getfield x/oc63a9b409d2.Ȑ Lx/occ2f8dff8d8;
      // 79: iload 2
      // 7a: aload 0
      // 7b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 7e: return
   }

   boolean ǉ() {
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
      // 06: ifne 18
      // 09: getfield x/oc63a9b409d2.в Z
      // 0c: ifeq 43
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2e
      // 1c: getfield x/oc63a9b409d2.Ѝ Lx/oca9cc61aada;
      // 1f: getfield x/N.Ӏ Z
      // 22: ifeq 43
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc63a9b409d2.Ȑ Lx/occ2f8dff8d8;
      // 31: getfield x/N.Ӏ Z
      // 34: iload 1
      // 35: ifne 40
      // 38: ifeq 43
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush 1
      // 40: goto 44
      // 43: bipush 0
      // 44: ireturn
   }

   @oc66fa4f2195
   public void Ƭ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 2
      // 008: ifne 022
      // 00b: ifeq 042
      // 00e: goto 012
      // 011: athrow
      // 012: aload 0
      // 013: iload 2
      // 014: ifne 031
      // 017: goto 01b
      // 01a: athrow
      // 01b: invokevirtual x/oc63a9b409d2.ҿ ()I
      // 01e: goto 022
      // 021: athrow
      // 022: ldc_w 375962133
      // 025: ldc_w 375962135
      // 028: ixor
      // 029: if_icmpne 042
      // 02c: aload 0
      // 02d: goto 031
      // 030: athrow
      // 031: iload 2
      // 032: ifne 045
      // 035: getfield x/oc63a9b409d2.Լ Lx/occ2f8dff8d8;
      // 038: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 03b: ifne 044
      // 03e: goto 042
      // 041: athrow
      // 042: return
      // 043: athrow
      // 044: aload 0
      // 045: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 048: invokevirtual java/util/concurrent/ConcurrentHashMap.entrySet ()Ljava/util/Set;
      // 04b: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 050: astore 3
      // 051: aload 3
      // 052: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 057: ifeq 164
      // 05a: aload 3
      // 05b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 060: checkcast java/util/Map$Entry
      // 063: astore 4
      // 065: aload 4
      // 067: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 06c: checkcast x/oc2ae3d414e8
      // 06f: astore 5
      // 071: aload 5
      // 073: iload 2
      // 074: ifne 080
      // 077: ifnull 051
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 5
      // 080: iload 2
      // 081: ifne 090
      // 084: getfield x/oc2ae3d414e8.ġ Z
      // 087: ifne 051
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 5
      // 090: iload 2
      // 091: ifne 0ad
      // 094: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 097: ifnonnull 0a6
      // 09a: goto 09e
      // 09d: athrow
      // 09e: iload 2
      // 09f: ifeq 051
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: aload 4
      // 0a8: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0ad: checkcast net/minecraft/util/BlockPos
      // 0b0: astore 6
      // 0b2: aload 0
      // 0b3: iload 2
      // 0b4: ifne 0fd
      // 0b7: getfield x/oc63a9b409d2.Ȑ Lx/occ2f8dff8d8;
      // 0ba: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0bd: ifeq 0fc
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 0
      // 0c5: aload 5
      // 0c7: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 0ca: invokevirtual x/oc63a9b409d2.թ (Lnet/minecraft/block/state/IBlockState;)I
      // 0cd: iload 2
      // 0ce: ifne 057
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: istore 7
      // 0d7: iload 7
      // 0d9: iflt 051
      // 0dc: aload 0
      // 0dd: iload 2
      // 0de: ifne 0fd
      // 0e1: aload 6
      // 0e3: aload 5
      // 0e5: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 0e8: iload 7
      // 0ea: invokevirtual x/oc63a9b409d2.Ȯ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Lx/oc9b32a258fb;
      // 0ed: ifnonnull 0fc
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: iload 2
      // 0f5: ifeq 051
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 0
      // 0fd: getfield x/oc63a9b409d2.Ѝ Lx/oca9cc61aada;
      // 100: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 103: d2i
      // 104: ifne 14f
      // 107: aload 5
      // 109: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 10c: aload 6
      // 10e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 111: i2d
      // 112: aload 6
      // 114: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 117: i2d
      // 118: aload 6
      // 11a: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 11d: i2d
      // 11e: new java/awt/Color
      // 121: dup
      // 122: ldc_w 375962120
      // 125: ldc_w 375962135
      // 128: ixor
      // 129: ldc_w 375962344
      // 12c: ldc_w 375962135
      // 12f: ixor
      // 130: ldc_w 375962113
      // 133: ldc_w 375962135
      // 136: ixor
      // 137: ldc_w 375962171
      // 13a: ldc_w 375962135
      // 13d: ixor
      // 13e: invokespecial java/awt/Color.<init> (IIII)V
      // 141: invokevirtual java/awt/Color.getRGB ()I
      // 144: invokestatic x/ocbd4917c4b1.τ (Lnet/minecraft/block/state/IBlockState;DDDI)V
      // 147: iload 2
      // 148: ifeq 160
      // 14b: goto 14f
      // 14e: athrow
      // 14f: aload 5
      // 151: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 154: aload 6
      // 156: ldc_w 0.34
      // 159: invokestatic x/ocbd4917c4b1.Ń (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;F)V
      // 15c: goto 160
      // 15f: athrow
      // 160: iload 2
      // 161: ifeq 051
      // 164: return
   }

   @oc66fa4f2195
   public void Ь(ocf923d5a814 param1) {
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
      // 005: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 008: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 00b: if_acmpeq 010
      // 00e: return
      // 00f: athrow
      // 010: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 013: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 016: instanceof net/minecraft/client/gui/GuiChat
      // 019: istore 3
      // 01a: iload 3
      // 01b: iload 2
      // 01c: ifne 032
      // 01f: ifne 02f
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: bipush 0
      // 028: putfield x/oc63a9b409d2.ү Z
      // 02b: goto 02f
      // 02e: athrow
      // 02f: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 032: ifeq 052
      // 035: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 038: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 03b: ifnull 053
      // 03e: goto 042
      // 041: athrow
      // 042: iload 3
      // 043: iload 2
      // 044: ifne 057
      // 047: goto 04b
      // 04a: athrow
      // 04b: ifne 053
      // 04e: goto 052
      // 051: athrow
      // 052: return
      // 053: aload 0
      // 054: invokevirtual x/oc63a9b409d2.ҿ ()I
      // 057: istore 4
      // 059: getstatic x/oc2cf3d80e17.ĥ Z
      // 05c: iload 2
      // 05d: ifne 078
      // 060: ifeq 071
      // 063: goto 067
      // 066: athrow
      // 067: aload 0
      // 068: iload 4
      // 06a: invokevirtual x/oc63a9b409d2.џ (I)V
      // 06d: goto 071
      // 070: athrow
      // 071: aload 0
      // 072: getfield x/oc63a9b409d2.Զ Lx/occ2f8dff8d8;
      // 075: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 078: ifeq 31a
      // 07b: new java/util/ArrayList
      // 07e: dup
      // 07f: invokespecial java/util/ArrayList.<init> ()V
      // 082: astore 5
      // 084: aload 5
      // 086: ldc_w "§6Speed Builders"
      // 089: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 08e: pop
      // 08f: aload 5
      // 091: iload 2
      // 092: ifne 17c
      // 095: aload 0
      // 096: iload 4
      // 098: invokevirtual x/oc63a9b409d2.ŗ (I)Ljava/lang/String;
      // 09b: ldc_w "§7Status: §b"
      // 09e: swap
      // 09f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0a4: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0a9: pop
      // 0aa: iload 4
      // 0ac: ldc_w -1023122944
      // 0af: ldc_w -1023122942
      // 0b2: ixor
      // 0b3: if_icmpne 17a
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: aload 0
      // 0bb: getfield x/oc63a9b409d2.Ǆ Z
      // 0be: ifne 17a
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: dconst_0
      // 0c6: dstore 6
      // 0c8: aload 0
      // 0c9: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 0cc: invokevirtual java/util/concurrent/ConcurrentHashMap.values ()Ljava/util/Collection;
      // 0cf: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0d4: astore 8
      // 0d6: aload 8
      // 0d8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0dd: ifeq 106
      // 0e0: aload 8
      // 0e2: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e7: checkcast x/oc2ae3d414e8
      // 0ea: astore 9
      // 0ec: iload 2
      // 0ed: ifne 17a
      // 0f0: aload 9
      // 0f2: getfield x/oc2ae3d414e8.ġ Z
      // 0f5: ifeq 102
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: dload 6
      // 0fe: dconst_1
      // 0ff: dadd
      // 100: dstore 6
      // 102: iload 2
      // 103: ifeq 0d6
      // 106: dconst_0
      // 107: dstore 8
      // 109: aload 0
      // 10a: iload 2
      // 10b: ifne 12b
      // 10e: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 111: invokevirtual java/util/concurrent/ConcurrentHashMap.isEmpty ()Z
      // 114: ifeq 12a
      // 117: goto 11b
      // 11a: athrow
      // 11b: ldc2_w 100.0
      // 11e: dstore 8
      // 120: iload 2
      // 121: aload 0
      // 122: getfield x/oc63a9b409d2.Ӧ D
      // 125: dstore 6
      // 127: ifeq 148
      // 12a: aload 0
      // 12b: getfield x/oc63a9b409d2.Ӧ D
      // 12e: dconst_0
      // 12f: dcmpl
      // 130: iload 2
      // 131: ifne 179
      // 134: ifle 148
      // 137: goto 13b
      // 13a: athrow
      // 13b: dload 6
      // 13d: aload 0
      // 13e: getfield x/oc63a9b409d2.Ӧ D
      // 141: ddiv
      // 142: ldc2_w 100.0
      // 145: dmul
      // 146: dstore 8
      // 148: aload 5
      // 14a: dload 6
      // 14c: d2i
      // 14d: aload 0
      // 14e: getfield x/oc63a9b409d2.Ӧ D
      // 151: d2i
      // 152: dload 8
      // 154: invokestatic java/lang/Math.round (D)J
      // 157: lstore 19
      // 159: istore 21
      // 15b: istore 22
      // 15d: ldc_w "§7Progress: §b"
      // 160: iload 22
      // 162: ldc_w "§7/§b"
      // 165: iload 21
      // 167: ldc_w " "
      // 16a: lload 19
      // 16c: ldc_w "%"
      // 16f: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001\u0001\u0001" ]
      // 174: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 179: pop
      // 17a: aload 5
      // 17c: aload 0
      // 17d: invokevirtual x/oc63a9b409d2.ǆ ()Z
      // 180: ifeq 18a
      // 183: ldc_w "§aENABLED"
      // 186: goto 18d
      // 189: athrow
      // 18a: ldc_w "§cDISABLED"
      // 18d: ldc_w "§7Auto: "
      // 190: swap
      // 191: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 196: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 19b: pop
      // 19c: invokestatic x/oce6044968f8.ԗ ()Lx/oc1378bc114d;
      // 19f: astore 6
      // 1a1: ldc_w -1023122944
      // 1a4: ldc_w -1023122942
      // 1a7: ixor
      // 1a8: invokestatic x/oce6044968f8.ǆ ()F
      // 1ab: invokestatic java/lang/Math.round (F)I
      // 1ae: invokestatic java/lang/Math.max (II)I
      // 1b1: istore 7
      // 1b3: bipush 0
      // 1b4: istore 8
      // 1b6: aload 5
      // 1b8: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1bd: astore 9
      // 1bf: aload 9
      // 1c1: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1c6: ifeq 1ff
      // 1c9: aload 9
      // 1cb: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1d0: checkcast java/lang/String
      // 1d3: astore 10
      // 1d5: iload 2
      // 1d6: ifne 31a
      // 1d9: aload 6
      // 1db: aload 10
      // 1dd: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 1e2: istore 11
      // 1e4: iload 11
      // 1e6: iload 2
      // 1e7: ifne 1f9
      // 1ea: iload 8
      // 1ec: if_icmple 1fb
      // 1ef: goto 1f3
      // 1f2: athrow
      // 1f3: iload 11
      // 1f5: goto 1f9
      // 1f8: athrow
      // 1f9: istore 8
      // 1fb: iload 2
      // 1fc: ifeq 1bf
      // 1ff: aload 6
      // 201: invokeinterface x/oc1378bc114d.z$1tqmx4tpnr6lq ()I 1
      // 206: istore 9
      // 208: ldc_w -1023122943
      // 20b: ldc_w -1023122942
      // 20e: ixor
      // 20f: istore 10
      // 211: aload 5
      // 213: invokeinterface java/util/List.size ()I 1
      // 218: iload 9
      // 21a: imul
      // 21b: aload 5
      // 21d: invokeinterface java/util/List.size ()I 1
      // 222: bipush 1
      // 223: isub
      // 224: iload 10
      // 226: imul
      // 227: iadd
      // 228: iload 7
      // 22a: ldc_w -1023122944
      // 22d: ldc_w -1023122942
      // 230: ixor
      // 231: imul
      // 232: iadd
      // 233: istore 11
      // 235: iload 8
      // 237: iload 7
      // 239: ldc_w -1023122944
      // 23c: ldc_w -1023122942
      // 23f: ixor
      // 240: imul
      // 241: iadd
      // 242: istore 12
      // 244: iload 12
      // 246: i2f
      // 247: ldc_w 7.0
      // 24a: fadd
      // 24b: fstore 13
      // 24d: iload 11
      // 24f: i2f
      // 250: fconst_2
      // 251: fsub
      // 252: fstore 14
      // 254: iload 3
      // 255: ifeq 2ae
      // 258: new net/minecraft/client/gui/ScaledResolution
      // 25b: dup
      // 25c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 25f: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 262: astore 15
      // 264: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 267: aload 15
      // 269: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 26c: imul
      // 26d: i2f
      // 26e: bipush 1
      // 26f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 272: getfield net/minecraft/client/Minecraft.displayWidth I
      // 275: invokestatic java/lang/Math.max (II)I
      // 278: i2f
      // 279: fdiv
      // 27a: fstore 16
      // 27c: aload 15
      // 27e: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 281: i2f
      // 282: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 285: aload 15
      // 287: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 28a: imul
      // 28b: i2f
      // 28c: bipush 1
      // 28d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 290: getfield net/minecraft/client/Minecraft.displayHeight I
      // 293: invokestatic java/lang/Math.max (II)I
      // 296: i2f
      // 297: fdiv
      // 298: fsub
      // 299: fconst_1
      // 29a: fsub
      // 29b: fstore 17
      // 29d: aload 0
      // 29e: bipush 1
      // 29f: bipush 0
      // 2a0: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 2a3: fload 16
      // 2a5: fload 17
      // 2a7: fload 13
      // 2a9: fload 14
      // 2ab: invokevirtual x/oc63a9b409d2.ʒ (ZZFFFF)V
      // 2ae: aload 0
      // 2af: getfield x/oc63a9b409d2.ȍ F
      // 2b2: fstore 15
      // 2b4: aload 0
      // 2b5: getfield x/oc63a9b409d2.Ɩ F
      // 2b8: fstore 16
      // 2ba: iload 3
      // 2bb: iload 2
      // 2bc: ifne 2cd
      // 2bf: ifeq 2ee
      // 2c2: goto 2c6
      // 2c5: athrow
      // 2c6: fload 15
      // 2c8: f2i
      // 2c9: goto 2cd
      // 2cc: athrow
      // 2cd: fload 16
      // 2cf: f2i
      // 2d0: fload 15
      // 2d2: fload 13
      // 2d4: fadd
      // 2d5: f2d
      // 2d6: invokestatic java/lang/Math.ceil (D)D
      // 2d9: d2i
      // 2da: fload 16
      // 2dc: fload 14
      // 2de: fadd
      // 2df: f2d
      // 2e0: invokestatic java/lang/Math.ceil (D)D
      // 2e3: d2i
      // 2e4: ldc_w -2080662019
      // 2e7: ldc_w -1023122942
      // 2ea: ixor
      // 2eb: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 2ee: fload 15
      // 2f0: iload 7
      // 2f2: i2f
      // 2f3: fadd
      // 2f4: fstore 17
      // 2f6: fload 16
      // 2f8: iload 7
      // 2fa: i2f
      // 2fb: fadd
      // 2fc: fstore 18
      // 2fe: fload 15
      // 300: fload 16
      // 302: fload 13
      // 304: fload 14
      // 306: aload 5
      // 308: aload 6
      // 30a: fload 17
      // 30c: fload 18
      // 30e: iload 9
      // 310: iload 10
      // 312: invokedynamic run (Ljava/util/List;Lx/oc1378bc114d;FFII)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc63a9b409d2.q68i91rfabe7 (Ljava/util/List;Lx/oc1378bc114d;FFII)V, ()V ]
      // 317: invokestatic x/oce6044968f8.ӱ (FFFFLjava/lang/Runnable;)V
      // 31a: return
   }

   void ʒ(boolean param1, boolean param2, float param3, float param4, float param5, float param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 7
      // 05: iload 1
      // 06: iload 7
      // 08: ifne 1d
      // 0b: ifne 19
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: bipush 0
      // 14: putfield x/oc63a9b409d2.ү Z
      // 17: return
      // 18: athrow
      // 19: aload 0
      // 1a: getfield x/oc63a9b409d2.ү Z
      // 1d: iload 7
      // 1f: ifne 4f
      // 22: ifeq 4e
      // 25: goto 29
      // 28: athrow
      // 29: iload 2
      // 2a: ifne 38
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: bipush 0
      // 33: putfield x/oc63a9b409d2.ү Z
      // 36: return
      // 37: athrow
      // 38: aload 0
      // 39: fload 3
      // 3a: aload 0
      // 3b: getfield x/oc63a9b409d2.ʯ F
      // 3e: fsub
      // 3f: putfield x/oc63a9b409d2.ȍ F
      // 42: aload 0
      // 43: fload 4
      // 45: aload 0
      // 46: getfield x/oc63a9b409d2.Ͱ F
      // 49: fsub
      // 4a: putfield x/oc63a9b409d2.Ɩ F
      // 4d: return
      // 4e: iload 2
      // 4f: iload 7
      // 51: ifne 6b
      // 54: ifne 5c
      // 57: goto 5b
      // 5a: athrow
      // 5b: return
      // 5c: fload 3
      // 5d: aload 0
      // 5e: getfield x/oc63a9b409d2.ȍ F
      // 61: iload 7
      // 63: ifne 7a
      // 66: fcmpl
      // 67: goto 6b
      // 6a: athrow
      // 6b: iflt bc
      // 6e: fload 3
      // 6f: aload 0
      // 70: getfield x/oc63a9b409d2.ȍ F
      // 73: fload 5
      // 75: fadd
      // 76: goto 7a
      // 79: athrow
      // 7a: iload 7
      // 7c: ifne 9a
      // 7f: fcmpg
      // 80: ifgt bc
      // 83: goto 87
      // 86: athrow
      // 87: fload 4
      // 89: aload 0
      // 8a: iload 7
      // 8c: ifne a5
      // 8f: goto 93
      // 92: athrow
      // 93: getfield x/oc63a9b409d2.Ɩ F
      // 96: goto 9a
      // 99: athrow
      // 9a: fcmpl
      // 9b: iflt bc
      // 9e: fload 4
      // a0: aload 0
      // a1: goto a5
      // a4: athrow
      // a5: getfield x/oc63a9b409d2.Ɩ F
      // a8: fload 6
      // aa: fadd
      // ab: fcmpg
      // ac: iload 7
      // ae: ifne b9
      // b1: ifgt bc
      // b4: goto b8
      // b7: athrow
      // b8: bipush 1
      // b9: goto bd
      // bc: bipush 0
      // bd: istore 8
      // bf: iload 7
      // c1: ifne e0
      // c4: iload 8
      // c6: ifeq eb
      // c9: goto cd
      // cc: athrow
      // cd: aload 0
      // ce: bipush 1
      // cf: putfield x/oc63a9b409d2.ү Z
      // d2: aload 0
      // d3: fload 3
      // d4: aload 0
      // d5: getfield x/oc63a9b409d2.ȍ F
      // d8: fsub
      // d9: putfield x/oc63a9b409d2.ʯ F
      // dc: goto e0
      // df: athrow
      // e0: aload 0
      // e1: fload 4
      // e3: aload 0
      // e4: getfield x/oc63a9b409d2.Ɩ F
      // e7: fsub
      // e8: putfield x/oc63a9b409d2.Ͱ F
      // eb: return
   }

   public float Ŝ() {
      return this.ȍ;
   }

   public float Ħ() {
      return this.Ɩ;
   }

   public void ϐ(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 3
      // 04: fload 1
      // 05: iload 3
      // 06: ifne 1d
      // 09: invokestatic java/lang/Float.isFinite (F)Z
      // 0c: ifeq 1c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: fload 1
      // 15: putfield x/oc63a9b409d2.ȍ F
      // 18: goto 1c
      // 1b: athrow
      // 1c: fload 2
      // 1d: invokestatic java/lang/Float.isFinite (F)Z
      // 20: ifeq 2c
      // 23: aload 0
      // 24: fload 2
      // 25: putfield x/oc63a9b409d2.Ɩ F
      // 28: goto 2c
      // 2b: athrow
      // 2c: return
   }

   boolean ś() {
      return this.ү;
   }

   private void џ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 2
      // 004: ldc_w -775974583
      // 007: ldc_w -775974582
      // 00a: ixor
      // 00b: anewarray 171
      // 00e: dup
      // 00f: bipush 0
      // 010: ldc_w "§6Debug"
      // 013: iload 2
      // 014: ifne 04c
      // 017: aastore
      // 018: dup
      // 019: bipush 1
      // 01a: aload 0
      // 01b: iload 1
      // 01c: invokevirtual x/oc63a9b409d2.ŗ (I)Ljava/lang/String;
      // 01f: iload 1
      // 020: ldc_w "§7Status: §b"
      // 023: dup_x2
      // 024: pop
      // 025: ldc_w " §8("
      // 028: swap
      // 029: ldc_w ")"
      // 02c: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 031: aastore
      // 032: dup
      // 033: ldc_w -775974584
      // 036: ldc_w -775974582
      // 039: ixor
      // 03a: aload 0
      // 03b: getfield x/oc63a9b409d2.Ǆ Z
      // 03e: ifeq 04f
      // 041: goto 045
      // 044: athrow
      // 045: ldc_w "§cYES"
      // 048: goto 04c
      // 04b: athrow
      // 04c: goto 052
      // 04f: ldc_w "§aNO"
      // 052: ldc_w "§7Eliminated: "
      // 055: swap
      // 056: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 05b: aastore
      // 05c: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 05f: astore 3
      // 060: ldc_w -775974577
      // 063: ldc_w -775974582
      // 066: ixor
      // 067: istore 4
      // 069: ldc_w -775974584
      // 06c: ldc_w -775974582
      // 06f: ixor
      // 070: istore 5
      // 072: bipush 0
      // 073: istore 6
      // 075: aload 3
      // 076: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 07b: astore 7
      // 07d: aload 7
      // 07f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 084: ifeq 0ad
      // 087: aload 7
      // 089: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08e: checkcast java/lang/String
      // 091: astore 8
      // 093: iload 6
      // 095: iload 2
      // 096: ifne 0b6
      // 099: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09c: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 09f: aload 8
      // 0a1: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 0a4: invokestatic java/lang/Math.max (II)I
      // 0a7: istore 6
      // 0a9: iload 2
      // 0aa: ifeq 07d
      // 0ad: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b0: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 0b3: getfield net/minecraft/client/gui/FontRenderer.FONT_HEIGHT I
      // 0b6: istore 7
      // 0b8: iload 6
      // 0ba: iload 4
      // 0bc: ldc_w -775974584
      // 0bf: ldc_w -775974582
      // 0c2: ixor
      // 0c3: imul
      // 0c4: iadd
      // 0c5: istore 8
      // 0c7: aload 3
      // 0c8: invokeinterface java/util/List.size ()I 1
      // 0cd: iload 7
      // 0cf: imul
      // 0d0: aload 3
      // 0d1: invokeinterface java/util/List.size ()I 1
      // 0d6: bipush 1
      // 0d7: isub
      // 0d8: iload 5
      // 0da: imul
      // 0db: iadd
      // 0dc: iload 4
      // 0de: ldc_w -775974584
      // 0e1: ldc_w -775974582
      // 0e4: ixor
      // 0e5: imul
      // 0e6: iadd
      // 0e7: istore 9
      // 0e9: ldc_w 775974577
      // 0ec: ldc_w -775974582
      // 0ef: ixor
      // 0f0: istore 10
      // 0f2: ldc_w -775974588
      // 0f5: ldc_w -775974582
      // 0f8: ixor
      // 0f9: istore 11
      // 0fb: iload 10
      // 0fd: i2f
      // 0fe: iload 11
      // 100: i2f
      // 101: iload 10
      // 103: iload 8
      // 105: iadd
      // 106: i2f
      // 107: iload 11
      // 109: iload 9
      // 10b: iadd
      // 10c: i2f
      // 10d: ldc_w 7.0
      // 110: getstatic java/awt/Color.black Ljava/awt/Color;
      // 113: invokevirtual java/awt/Color.getRGB ()I
      // 116: ldc_w -775974606
      // 119: ldc_w -775974582
      // 11c: ixor
      // 11d: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 120: invokestatic x/ocbd4917c4b1.Ӛ (FFFFFI)V
      // 123: bipush 0
      // 124: istore 12
      // 126: iload 12
      // 128: aload 3
      // 129: invokeinterface java/util/List.size ()I 1
      // 12e: if_icmpge 16c
      // 131: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 134: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 137: aload 3
      // 138: iload 12
      // 13a: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 13f: checkcast java/lang/String
      // 142: iload 10
      // 144: iload 4
      // 146: iadd
      // 147: ldc_w -775974584
      // 14a: ldc_w -775974582
      // 14d: ixor
      // 14e: iadd
      // 14f: i2f
      // 150: iload 11
      // 152: iload 4
      // 154: iadd
      // 155: iload 12
      // 157: iload 7
      // 159: iload 5
      // 15b: iadd
      // 15c: imul
      // 15d: iadd
      // 15e: i2f
      // 15f: bipush -1
      // 160: bipush 1
      // 161: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 164: pop
      // 165: iload 2
      // 166: iinc 12 1
      // 169: ifeq 126
      // 16c: return
   }

   private String ŗ(int var1) {
      try {
         switch (var1) {
            case -1:
               return "Disabled";
            case 0:
            default:
               return "Unknown";
            case 1:
            case 4:
               return "Showing";
            case 2:
               return "Building";
            case 3:
               return "Judging";
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ƙ(ocadfd5cc157 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: ifeq 1d
      // 0a: aload 1
      // 0b: iload 2
      // 0c: ifne 20
      // 0f: goto 13
      // 12: athrow
      // 13: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 16: ifnonnull 1f
      // 19: goto 1d
      // 1c: athrow
      // 1d: return
      // 1e: athrow
      // 1f: aload 1
      // 20: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: if_acmpne 4f
      // 2c: aload 0
      // 2d: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 30: invokevirtual java/util/concurrent/ConcurrentHashMap.clear ()V
      // 33: aload 0
      // 34: aconst_null
      // 35: putfield x/oc63a9b409d2.ҡ Lnet/minecraft/util/BlockPos;
      // 38: aload 0
      // 39: bipush 0
      // 3a: putfield x/oc63a9b409d2.Э Z
      // 3d: aload 0
      // 3e: bipush 0
      // 3f: putfield x/oc63a9b409d2.ӏ Z
      // 42: aload 0
      // 43: bipush 0
      // 44: putfield x/oc63a9b409d2.Ǆ Z
      // 47: aload 0
      // 48: invokevirtual x/oc63a9b409d2.ƺ ()V
      // 4b: goto 4f
      // 4e: athrow
      // 4f: return
   }

   void љ() {
      this.ƥ.clear();
      this.ҡ = null;
      this.Э = true;
      this.ӏ = false;
      this.Ӧ = 0.0;
      this.Ǆ = false;
      this.ƺ();
   }

   @oc66fa4f2195
   public void ϑ(oc02e6d57a60 param1) {
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
      // 005: getfield x/oc02e6d57a60.ρ B
      // 008: iload 2
      // 009: ifne 021
      // 00c: ldc_w -170260313
      // 00f: ldc_w -170260315
      // 012: ixor
      // 013: if_icmpeq 038
      // 016: goto 01a
      // 019: athrow
      // 01a: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 01d: goto 021
      // 020: athrow
      // 021: iload 2
      // 022: ifne 034
      // 025: ifeq 038
      // 028: goto 02c
      // 02b: athrow
      // 02c: aload 0
      // 02d: invokevirtual x/oc63a9b409d2.ҿ ()I
      // 030: goto 034
      // 033: athrow
      // 034: bipush -1
      // 035: if_icmpne 03a
      // 038: return
      // 039: athrow
      // 03a: aload 1
      // 03b: getfield x/oc02e6d57a60.ǫ Lnet/minecraft/util/IChatComponent;
      // 03e: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 043: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 046: astore 3
      // 047: aload 3
      // 048: iload 2
      // 049: ifne 059
      // 04c: invokevirtual java/lang/String.isEmpty ()Z
      // 04f: ifeq 058
      // 052: goto 056
      // 055: athrow
      // 056: return
      // 057: athrow
      // 058: aload 3
      // 059: iload 2
      // 05a: ifne 06f
      // 05d: ldc_w "Perfectly recreate the build you are shown each"
      // 060: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 063: ifne 080
      // 066: goto 06a
      // 069: athrow
      // 06a: aload 3
      // 06b: goto 06f
      // 06e: athrow
      // 06f: ldc_w "The game starts in 1 second!"
      // 072: iload 2
      // 073: ifne 08c
      // 076: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 079: ifeq 088
      // 07c: goto 080
      // 07f: athrow
      // 080: aload 0
      // 081: invokevirtual x/oc63a9b409d2.љ ()V
      // 084: goto 088
      // 087: athrow
      // 088: aload 3
      // 089: invokestatic x/oc7ab2161b9f.ӄ ()Ljava/lang/String;
      // 08c: iload 2
      // 08d: ifne 0ef
      // 090: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 093: ifeq 0da
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 3
      // 09b: ldc_w " got a perfect build in "
      // 09e: iload 2
      // 09f: ifne 0ef
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0a9: ifeq 0da
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: aload 3
      // 0b1: iload 2
      // 0b2: ifne 0db
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: ldc_w "s!"
      // 0bc: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 0bf: ifeq 0da
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 0ca: invokevirtual java/util/concurrent/ConcurrentHashMap.clear ()V
      // 0cd: aload 0
      // 0ce: bipush 0
      // 0cf: putfield x/oc63a9b409d2.ӏ Z
      // 0d2: aload 0
      // 0d3: invokevirtual x/oc63a9b409d2.ƺ ()V
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: aload 3
      // 0db: iload 2
      // 0dc: ifne 0fa
      // 0df: invokestatic x/oc7ab2161b9f.ӄ ()Ljava/lang/String;
      // 0e2: ldc_w "Player eliminated: "
      // 0e5: swap
      // 0e6: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0f2: ifeq 110
      // 0f5: aload 3
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: ldc_w "%)"
      // 0fd: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 100: ifeq 110
      // 103: aload 0
      // 104: bipush 1
      // 105: putfield x/oc63a9b409d2.Ǆ Z
      // 108: aload 0
      // 109: invokevirtual x/oc63a9b409d2.ƺ ()V
      // 10c: goto 110
      // 10f: athrow
      // 110: return
   }

   @oc66fa4f2195
   public void Ȇ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/oc63a9b409d2.Э Z
      // 08: iload 2
      // 09: ifne 16
      // 0c: ifeq 76
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 16: iload 2
      // 17: ifne 2c
      // 1a: ifeq 76
      // 1d: goto 21
      // 20: athrow
      // 21: aload 1
      // 22: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 25: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifeq 76
      // 2f: new net/minecraft/util/Vec3
      // 32: dup
      // 33: aload 1
      // 34: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 37: checkcast net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 3a: invokevirtual net/minecraft/network/play/server/S08PacketPlayerPosLook.getX ()D
      // 3d: aload 1
      // 3e: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 41: checkcast net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 44: invokevirtual net/minecraft/network/play/server/S08PacketPlayerPosLook.getY ()D
      // 47: aload 1
      // 48: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 4b: checkcast net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 4e: invokevirtual net/minecraft/network/play/server/S08PacketPlayerPosLook.getZ ()D
      // 51: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 54: astore 3
      // 55: aload 0
      // 56: iload 2
      // 57: ifne 72
      // 5a: getfield x/oc63a9b409d2.ҡ Lnet/minecraft/util/BlockPos;
      // 5d: ifnonnull 71
      // 60: goto 64
      // 63: athrow
      // 64: aload 0
      // 65: aload 0
      // 66: aload 3
      // 67: invokevirtual x/oc63a9b409d2.Α (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/BlockPos;
      // 6a: putfield x/oc63a9b409d2.ҡ Lnet/minecraft/util/BlockPos;
      // 6d: goto 71
      // 70: athrow
      // 71: aload 0
      // 72: bipush 0
      // 73: putfield x/oc63a9b409d2.Э Z
      // 76: return
   }

   public int ҿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: invokestatic x/oc7ab2161b9f.հ ()Ljava/util/List;
      // 006: astore 2
      // 007: istore 1
      // 008: aload 2
      // 009: iload 1
      // 00a: ifne 023
      // 00d: invokeinterface java/util/List.isEmpty ()Z 1
      // 012: ifeq 01c
      // 015: goto 019
      // 018: athrow
      // 019: bipush -1
      // 01a: ireturn
      // 01b: athrow
      // 01c: aload 2
      // 01d: bipush 0
      // 01e: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 023: checkcast java/lang/String
      // 026: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 029: ldc_w "BUILD BATTLE"
      // 02c: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 02f: iload 1
      // 030: ifne 03e
      // 033: ifne 03d
      // 036: goto 03a
      // 039: athrow
      // 03a: bipush -1
      // 03b: ireturn
      // 03c: athrow
      // 03d: bipush 0
      // 03e: istore 3
      // 03f: iload 3
      // 040: aload 2
      // 041: invokeinterface java/util/List.size ()I 1
      // 046: bipush 1
      // 047: isub
      // 048: if_icmpge 124
      // 04b: aload 2
      // 04c: iload 3
      // 04d: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 052: checkcast java/lang/String
      // 055: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 058: astore 4
      // 05a: iload 1
      // 05b: aload 2
      // 05c: iload 3
      // 05d: bipush 1
      // 05e: iadd
      // 05f: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 064: checkcast java/lang/String
      // 067: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 06a: astore 5
      // 06c: ifne 120
      // 06f: aload 4
      // 071: ldc_w "Round:"
      // 074: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 077: iload 1
      // 078: ifne 125
      // 07b: goto 07f
      // 07e: athrow
      // 07f: ifeq 11d
      // 082: goto 086
      // 085: athrow
      // 086: aload 5
      // 088: ldc_w "Starts In: 00:03"
      // 08b: iload 1
      // 08c: ifne 0d5
      // 08f: goto 093
      // 092: athrow
      // 093: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 096: ifeq 0d0
      // 099: goto 09d
      // 09c: athrow
      // 09d: aload 2
      // 09e: iload 3
      // 09f: ldc_w 2056814929
      // 0a2: ldc_w 2056814930
      // 0a5: ixor
      // 0a6: iadd
      // 0a7: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0ac: checkcast java/lang/String
      // 0af: iload 1
      // 0b0: ifne 0d2
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 0ba: ldc_w "Theme:"
      // 0bd: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0c0: ifeq 0d0
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: ldc_w 2056814934
      // 0ca: ldc_w 2056814930
      // 0cd: ixor
      // 0ce: ireturn
      // 0cf: athrow
      // 0d0: aload 5
      // 0d2: ldc_w "Starts In:"
      // 0d5: iload 1
      // 0d6: ifne 0eb
      // 0d9: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0dc: ifeq 0e6
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: bipush 1
      // 0e4: ireturn
      // 0e5: athrow
      // 0e6: aload 5
      // 0e8: ldc_w "Time Left:"
      // 0eb: iload 1
      // 0ec: ifne 107
      // 0ef: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0f2: ifeq 102
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: ldc_w 2056814928
      // 0fc: ldc_w 2056814930
      // 0ff: ixor
      // 100: ireturn
      // 101: athrow
      // 102: aload 5
      // 104: ldc_w "Judging:"
      // 107: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 10a: iload 1
      // 10b: ifne 11c
      // 10e: ifeq 11d
      // 111: goto 115
      // 114: athrow
      // 115: ldc_w 2056814929
      // 118: ldc_w 2056814930
      // 11b: ixor
      // 11c: ireturn
      // 11d: iinc 3 1
      // 120: iload 1
      // 121: ifeq 03f
      // 124: bipush 0
      // 125: ireturn
   }

   public BlockPos Α(Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 3
      // 02: ldc2_w 1.7976931348623157E308
      // 05: dstore 4
      // 07: getstatic x/ocfa11b18c57.ė I
      // 0a: ldc2_w 30.0
      // 0d: dstore 6
      // 0f: istore 2
      // 10: dload 6
      // 12: dload 6
      // 14: dmul
      // 15: dstore 8
      // 17: aload 0
      // 18: getfield x/oc63a9b409d2.Г Ljava/util/List;
      // 1b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 20: astore 10
      // 22: aload 10
      // 24: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 29: ifeq ac
      // 2c: aload 10
      // 2e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 33: checkcast net/minecraft/util/BlockPos
      // 36: astore 11
      // 38: aload 11
      // 3a: iload 2
      // 3b: ifne ad
      // 3e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 41: i2d
      // 42: aload 1
      // 43: getfield net/minecraft/util/Vec3.xCoord D
      // 46: dsub
      // 47: dstore 12
      // 49: aload 11
      // 4b: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 4e: i2d
      // 4f: aload 1
      // 50: getfield net/minecraft/util/Vec3.yCoord D
      // 53: dsub
      // 54: dstore 14
      // 56: aload 11
      // 58: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 5b: i2d
      // 5c: aload 1
      // 5d: getfield net/minecraft/util/Vec3.zCoord D
      // 60: dsub
      // 61: dstore 16
      // 63: dload 12
      // 65: dload 12
      // 67: dmul
      // 68: dload 14
      // 6a: dload 14
      // 6c: dmul
      // 6d: dadd
      // 6e: dload 16
      // 70: dload 16
      // 72: dmul
      // 73: dadd
      // 74: invokestatic java/lang/Math.abs (D)D
      // 77: dstore 18
      // 79: dload 18
      // 7b: dload 8
      // 7d: iload 2
      // 7e: ifne 99
      // 81: dcmpg
      // 82: ifgt a8
      // 85: goto 89
      // 88: athrow
      // 89: dload 18
      // 8b: iload 2
      // 8c: ifne a3
      // 8f: goto 93
      // 92: athrow
      // 93: dload 4
      // 95: goto 99
      // 98: athrow
      // 99: dcmpg
      // 9a: ifge a8
      // 9d: dload 18
      // 9f: goto a3
      // a2: athrow
      // a3: dstore 4
      // a5: aload 11
      // a7: astore 3
      // a8: iload 2
      // a9: ifeq 22
      // ac: aload 3
      // ad: areturn
   }

   public ConcurrentHashMap<BlockPos, oc2ae3d414e8> ӻ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: new java/util/concurrent/ConcurrentHashMap
      // 06: dup
      // 07: invokespecial java/util/concurrent/ConcurrentHashMap.<init> ()V
      // 0a: astore 3
      // 0b: aload 1
      // 0c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0f: ldc_w -412565289
      // 12: ldc_w -412565292
      // 15: ixor
      // 16: isub
      // 17: istore 4
      // 19: aload 1
      // 1a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 1d: ldc_w -412565289
      // 20: ldc_w -412565292
      // 23: ixor
      // 24: iadd
      // 25: istore 5
      // 27: istore 2
      // 28: aload 1
      // 29: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 2c: ldc_w -412565289
      // 2f: ldc_w -412565292
      // 32: ixor
      // 33: isub
      // 34: istore 6
      // 36: aload 1
      // 37: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 3a: ldc_w -412565289
      // 3d: ldc_w -412565292
      // 40: ixor
      // 41: iadd
      // 42: istore 7
      // 44: aload 1
      // 45: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 48: bipush 1
      // 49: iadd
      // 4a: istore 8
      // 4c: iload 8
      // 4e: ldc_w -412565302
      // 51: ldc_w -412565292
      // 54: ixor
      // 55: iadd
      // 56: istore 9
      // 58: iload 4
      // 5a: istore 10
      // 5c: iload 10
      // 5e: iload 5
      // 60: if_icmpgt e4
      // 63: iload 6
      // 65: istore 11
      // 67: iload 11
      // 69: iload 7
      // 6b: if_icmpgt dd
      // 6e: iload 2
      // 6f: ifne e0
      // 72: iload 8
      // 74: istore 12
      // 76: iload 12
      // 78: iload 9
      // 7a: if_icmpgt d6
      // 7d: iload 2
      // 7e: ifne d9
      // 81: new net/minecraft/util/BlockPos
      // 84: dup
      // 85: iload 10
      // 87: iload 12
      // 89: iload 11
      // 8b: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 8e: astore 13
      // 90: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 93: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 96: aload 13
      // 98: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 9b: astore 14
      // 9d: aload 14
      // 9f: iload 2
      // a0: ifne ce
      // a3: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // a8: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // ab: if_acmpne ba
      // ae: goto b2
      // b1: athrow
      // b2: iload 2
      // b3: ifeq cf
      // b6: goto ba
      // b9: athrow
      // ba: aload 3
      // bb: aload 13
      // bd: new x/oc2ae3d414e8
      // c0: dup
      // c1: aload 0
      // c2: aload 14
      // c4: invokespecial x/oc2ae3d414e8.<init> (Lx/oc63a9b409d2;Lnet/minecraft/block/state/IBlockState;)V
      // c7: invokevirtual java/util/concurrent/ConcurrentHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // ca: goto ce
      // cd: athrow
      // ce: pop
      // cf: iinc 12 1
      // d2: iload 2
      // d3: ifeq 76
      // d6: iinc 11 1
      // d9: iload 2
      // da: ifeq 67
      // dd: iinc 10 1
      // e0: iload 2
      // e1: ifeq 5c
      // e4: aload 3
      // e5: bipush 0
      // e6: ifeq f4
      // e9: iinc 2 1
      // ec: iload 2
      // ed: putstatic x/ocfa11b18c57.ė I
      // f0: goto f4
      // f3: athrow
      // f4: areturn
   }

   public boolean ǆ() {
      return this.ǿ.ǭ();
   }

   private boolean ӂ(IBlockState param1, IBlockState param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 3
      // 04: aload 1
      // 05: aload 2
      // 06: invokevirtual java/lang/Object.equals (Ljava/lang/Object;)Z
      // 09: iload 3
      // 0a: ifne 4b
      // 0d: ifne 4a
      // 10: goto 14
      // 13: athrow
      // 14: aload 2
      // 15: iload 3
      // 16: ifne 31
      // 19: goto 1d
      // 1c: athrow
      // 1d: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 22: instanceof net/minecraft/block/BlockLeaves
      // 25: ifeq 4e
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 1
      // 2d: goto 31
      // 30: athrow
      // 31: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 36: aload 2
      // 37: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 3c: invokevirtual java/lang/Object.equals (Ljava/lang/Object;)Z
      // 3f: iload 3
      // 40: ifne 4b
      // 43: ifeq 4e
      // 46: goto 4a
      // 49: athrow
      // 4a: bipush 1
      // 4b: goto 4f
      // 4e: bipush 0
      // 4f: ireturn
   }

   private void Ƥ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 1
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 00a: ifnonnull 042
      // 00d: aload 0
      // 00e: iload 1
      // 00f: ifne 047
      // 012: goto 016
      // 015: athrow
      // 016: getfield x/oc63a9b409d2.Ǆ Z
      // 019: ifne 042
      // 01c: goto 020
      // 01f: athrow
      // 020: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 023: iload 1
      // 024: ifne 03c
      // 027: goto 02b
      // 02a: athrow
      // 02b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02e: ifnull 042
      // 031: goto 035
      // 034: athrow
      // 035: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 038: goto 03c
      // 03b: athrow
      // 03c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 03f: ifnonnull 04b
      // 042: aload 0
      // 043: goto 047
      // 046: athrow
      // 047: invokevirtual x/oc63a9b409d2.ǹ ()V
      // 04a: return
      // 04b: aload 0
      // 04c: getfield x/oc63a9b409d2.ѷ I
      // 04f: iload 1
      // 050: ifne 07a
      // 053: i2d
      // 054: aload 0
      // 055: getfield x/oc63a9b409d2.Б Lx/oca9cc61aada;
      // 058: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 05b: dcmpg
      // 05c: ifge 06f
      // 05f: goto 063
      // 062: athrow
      // 063: aload 0
      // 064: dup
      // 065: getfield x/oc63a9b409d2.ѷ I
      // 068: bipush 1
      // 069: iadd
      // 06a: putfield x/oc63a9b409d2.ѷ I
      // 06d: return
      // 06e: athrow
      // 06f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 072: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 075: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 078: fconst_0
      // 079: fcmpl
      // 07a: ifgt 07e
      // 07d: return
      // 07e: aload 0
      // 07f: iload 1
      // 080: ifne 0b2
      // 083: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 086: ifnull 0ad
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 0
      // 08e: iload 1
      // 08f: ifne 0ba
      // 092: goto 096
      // 095: athrow
      // 096: aload 0
      // 097: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 09a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a0: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0a3: invokevirtual x/oc63a9b409d2.ԃ (Lx/oc9b32a258fb;Lnet/minecraft/item/ItemStack;)Z
      // 0a6: ifne 0b9
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: aload 0
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: aload 0
      // 0b3: invokevirtual x/oc63a9b409d2.ÿ ()Lx/oc9b32a258fb;
      // 0b6: putfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 0b9: aload 0
      // 0ba: iload 1
      // 0bb: ifne 0cd
      // 0be: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 0c1: ifnull 111
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: aload 0
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: iload 1
      // 0ce: ifne 0e0
      // 0d1: getfield x/oc63a9b409d2.ʧ Z
      // 0d4: ifeq 111
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 0
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: iload 1
      // 0e1: ifne 0f6
      // 0e4: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 0e7: getfield x/oc9b32a258fb.I Z
      // 0ea: ifeq 111
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: aload 0
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 0
      // 0f7: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 0fa: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 100: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 103: invokevirtual x/oc63a9b409d2.ԃ (Lx/oc9b32a258fb;Lnet/minecraft/item/ItemStack;)Z
      // 106: iload 1
      // 107: ifne 122
      // 10a: ifne 112
      // 10d: goto 111
      // 110: athrow
      // 111: return
      // 112: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 115: iload 1
      // 116: ifne 129
      // 119: invokeinterface x/oc8ecfa69e1b.getRightClickDelayTimer ()I 1
      // 11e: goto 122
      // 121: athrow
      // 122: ifle 126
      // 125: return
      // 126: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 129: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 12c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 12f: astore 2
      // 130: iload 1
      // 131: ifne 188
      // 134: aload 0
      // 135: aload 0
      // 136: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 139: getfield x/oc9b32a258fb.ԋ Lnet/minecraft/block/state/IBlockState;
      // 13c: invokevirtual x/oc63a9b409d2.в (Lnet/minecraft/block/state/IBlockState;)Z
      // 13f: ifeq 180
      // 142: goto 146
      // 145: athrow
      // 146: aload 0
      // 147: iload 1
      // 148: ifne 18a
      // 14b: goto 14f
      // 14e: athrow
      // 14f: aload 0
      // 150: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 153: getfield x/oc9b32a258fb.ԋ Lnet/minecraft/block/state/IBlockState;
      // 156: aload 0
      // 157: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 15a: getfield x/oc9b32a258fb.Ӱ Lnet/minecraft/util/BlockPos;
      // 15d: aload 0
      // 15e: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 161: getfield x/oc9b32a258fb.Ǒ Lnet/minecraft/util/EnumFacing;
      // 164: aload 0
      // 165: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 168: getfield x/oc9b32a258fb.վ Lnet/minecraft/util/Vec3;
      // 16b: aload 2
      // 16c: aload 0
      // 16d: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 170: getfield x/oc9b32a258fb.E F
      // 173: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 176: invokevirtual x/oc63a9b409d2.Ī (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;Lnet/minecraft/item/ItemStack;Ljava/lang/Float;)Z
      // 179: ifne 189
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 0
      // 181: invokevirtual x/oc63a9b409d2.ǹ ()V
      // 184: goto 188
      // 187: athrow
      // 188: return
      // 189: aload 0
      // 18a: invokevirtual x/oc63a9b409d2.π ()V
      // 18d: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 190: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 193: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 196: aload 0
      // 197: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 19a: getfield x/oc9b32a258fb.E F
      // 19d: aload 0
      // 19e: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 1a1: getfield x/oc9b32a258fb.Ҝ F
      // 1a4: bipush 1
      // 1a5: invokevirtual x/ocbb165642ef.Ҕ (Lnet/minecraft/entity/Entity;FFZ)V
      // 1a8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1ab: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 1ae: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b7: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1ba: aload 2
      // 1bb: aload 0
      // 1bc: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 1bf: getfield x/oc9b32a258fb.Ӱ Lnet/minecraft/util/BlockPos;
      // 1c2: aload 0
      // 1c3: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 1c6: getfield x/oc9b32a258fb.Ǒ Lnet/minecraft/util/EnumFacing;
      // 1c9: aload 0
      // 1ca: getfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 1cd: getfield x/oc9b32a258fb.վ Lnet/minecraft/util/Vec3;
      // 1d0: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 1d3: istore 3
      // 1d4: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 1d7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1da: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1dd: invokevirtual x/ocbb165642ef.ě (Lnet/minecraft/entity/Entity;)V
      // 1e0: goto 1f4
      // 1e3: astore 4
      // 1e5: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 1e8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1eb: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1ee: invokevirtual x/ocbb165642ef.ě (Lnet/minecraft/entity/Entity;)V
      // 1f1: aload 4
      // 1f3: athrow
      // 1f4: iload 3
      // 1f5: ifeq 228
      // 1f8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1fb: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1fe: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 201: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 204: bipush 1
      // 205: aload 0
      // 206: getfield x/oc63a9b409d2.Б Lx/oca9cc61aada;
      // 209: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 20c: d2i
      // 20d: invokestatic java/lang/Math.max (II)I
      // 210: invokeinterface x/oc8ecfa69e1b.setRightClickDelayTimer (I)V 2
      // 215: aload 0
      // 216: bipush 0
      // 217: putfield x/oc63a9b409d2.ѷ I
      // 21a: aload 0
      // 21b: aconst_null
      // 21c: putfield x/oc63a9b409d2.մ Lx/oc9b32a258fb;
      // 21f: aload 0
      // 220: bipush 0
      // 221: putfield x/oc63a9b409d2.ʧ Z
      // 224: goto 228
      // 227: athrow
      // 228: return
   }

   private oc9b32a258fb ÿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 1
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: iload 1
      // 008: ifne 01c
      // 00b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00e: ifnull 030
      // 011: goto 015
      // 014: athrow
      // 015: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 018: goto 01c
      // 01b: athrow
      // 01c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 01f: ifnull 030
      // 022: aload 0
      // 023: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 026: invokevirtual java/util/concurrent/ConcurrentHashMap.isEmpty ()Z
      // 029: ifeq 033
      // 02c: goto 030
      // 02f: athrow
      // 030: aconst_null
      // 031: areturn
      // 032: athrow
      // 033: aconst_null
      // 034: astore 2
      // 035: ldc2_w 1.7976931348623157E308
      // 038: dstore 3
      // 039: aload 0
      // 03a: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 03d: invokevirtual java/util/concurrent/ConcurrentHashMap.entrySet ()Ljava/util/Set;
      // 040: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 045: astore 5
      // 047: aload 5
      // 049: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 04e: ifeq 107
      // 051: aload 5
      // 053: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 058: checkcast java/util/Map$Entry
      // 05b: astore 6
      // 05d: aload 6
      // 05f: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 064: checkcast x/oc2ae3d414e8
      // 067: astore 7
      // 069: aload 7
      // 06b: iload 1
      // 06c: ifne 078
      // 06f: ifnull 047
      // 072: goto 076
      // 075: athrow
      // 076: aload 7
      // 078: iload 1
      // 079: ifne 088
      // 07c: getfield x/oc2ae3d414e8.ġ Z
      // 07f: ifne 047
      // 082: goto 086
      // 085: athrow
      // 086: aload 7
      // 088: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 08b: ifnonnull 096
      // 08e: iload 1
      // 08f: ifeq 047
      // 092: goto 096
      // 095: athrow
      // 096: aload 0
      // 097: aload 7
      // 099: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 09c: invokevirtual x/oc63a9b409d2.թ (Lnet/minecraft/block/state/IBlockState;)I
      // 09f: istore 8
      // 0a1: iload 8
      // 0a3: ifge 0ae
      // 0a6: iload 1
      // 0a7: ifeq 047
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 0
      // 0af: aload 6
      // 0b1: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0b6: checkcast net/minecraft/util/BlockPos
      // 0b9: aload 7
      // 0bb: getfield x/oc2ae3d414e8.ա Lnet/minecraft/block/state/IBlockState;
      // 0be: iload 8
      // 0c0: invokevirtual x/oc63a9b409d2.Ȯ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Lx/oc9b32a258fb;
      // 0c3: astore 9
      // 0c5: aload 9
      // 0c7: iload 1
      // 0c8: ifne 0dc
      // 0cb: ifnonnull 0da
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: iload 1
      // 0d3: ifeq 047
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: aload 9
      // 0dc: getfield x/oc9b32a258fb.վ Lnet/minecraft/util/Vec3;
      // 0df: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e5: fconst_1
      // 0e6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0e9: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0ec: dstore 10
      // 0ee: iload 1
      // 0ef: ifne 100
      // 0f2: dload 10
      // 0f4: dload 3
      // 0f5: dcmpg
      // 0f6: ifge 103
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: dload 10
      // 0ff: dstore 3
      // 100: aload 9
      // 102: astore 2
      // 103: iload 1
      // 104: ifeq 047
      // 107: aload 2
      // 108: areturn
   }

   private oc9b32a258fb Ȯ(BlockPos param1, IBlockState param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 4
      // 005: aload 1
      // 006: invokestatic x/occb1ed1ed8f.ɍ (Lnet/minecraft/util/BlockPos;)Z
      // 009: ifne 00f
      // 00c: aconst_null
      // 00d: areturn
      // 00e: athrow
      // 00f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 012: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 015: fconst_1
      // 016: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 019: astore 5
      // 01b: aload 1
      // 01c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 01f: i2d
      // 020: ldc2_w 0.5
      // 023: dadd
      // 024: dstore 6
      // 026: aload 1
      // 027: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 02a: i2d
      // 02b: ldc2_w 0.5
      // 02e: dadd
      // 02f: dstore 8
      // 031: aload 1
      // 032: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 035: i2d
      // 036: ldc2_w 0.5
      // 039: dadd
      // 03a: dstore 10
      // 03c: dload 6
      // 03e: aload 5
      // 040: getfield net/minecraft/util/Vec3.xCoord D
      // 043: dsub
      // 044: dstore 12
      // 046: dload 8
      // 048: aload 5
      // 04a: getfield net/minecraft/util/Vec3.yCoord D
      // 04d: dsub
      // 04e: dstore 14
      // 050: dload 10
      // 052: aload 5
      // 054: getfield net/minecraft/util/Vec3.zCoord D
      // 057: dsub
      // 058: dstore 16
      // 05a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05d: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 060: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 063: f2d
      // 064: dconst_1
      // 065: dadd
      // 066: dstore 18
      // 068: dload 12
      // 06a: dload 12
      // 06c: dmul
      // 06d: dload 14
      // 06f: dload 14
      // 071: dmul
      // 072: dadd
      // 073: dload 16
      // 075: dload 16
      // 077: dmul
      // 078: dadd
      // 079: dload 18
      // 07b: dload 18
      // 07d: dmul
      // 07e: dcmpl
      // 07f: ifle 085
      // 082: aconst_null
      // 083: areturn
      // 084: athrow
      // 085: aconst_null
      // 086: astore 20
      // 088: ldc2_w 1.7976931348623157E308
      // 08b: dstore 21
      // 08d: aload 0
      // 08e: iload 3
      // 08f: invokevirtual x/oc63a9b409d2.щ (I)Lnet/minecraft/item/ItemStack;
      // 092: astore 23
      // 094: aload 23
      // 096: ifnonnull 09c
      // 099: aconst_null
      // 09a: areturn
      // 09b: athrow
      // 09c: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 09f: astore 24
      // 0a1: aload 24
      // 0a3: arraylength
      // 0a4: istore 25
      // 0a6: bipush 0
      // 0a7: istore 26
      // 0a9: iload 26
      // 0ab: iload 25
      // 0ad: if_icmpge 1e0
      // 0b0: aload 24
      // 0b2: iload 26
      // 0b4: aaload
      // 0b5: astore 27
      // 0b7: iload 4
      // 0b9: aload 1
      // 0ba: aload 27
      // 0bc: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 0bf: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 0c2: astore 28
      // 0c4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c7: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0ca: aload 28
      // 0cc: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0cf: astore 29
      // 0d1: ifne 1db
      // 0d4: aload 29
      // 0d6: ifnull 1d8
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 29
      // 0df: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0e4: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 0e7: if_acmpeq 1d8
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: aload 23
      // 0f0: aload 28
      // 0f2: aload 27
      // 0f4: invokestatic x/occb1ed1ed8f.ā (Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 0f7: ifne 107
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: iload 4
      // 100: ifeq 1d8
      // 103: goto 107
      // 106: athrow
      // 107: aload 0
      // 108: aload 28
      // 10a: aload 27
      // 10c: invokevirtual x/oc63a9b409d2.Ӛ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/Vec3;
      // 10f: astore 30
      // 111: aload 0
      // 112: aload 30
      // 114: getstatic x/oc75d51ec7eb.d [F
      // 117: bipush 0
      // 118: faload
      // 119: getstatic x/oc75d51ec7eb.d [F
      // 11c: bipush 1
      // 11d: faload
      // 11e: invokevirtual x/oc63a9b409d2.Ŝ (Lnet/minecraft/util/Vec3;FF)[F
      // 121: astore 31
      // 123: aload 0
      // 124: aload 2
      // 125: aload 28
      // 127: aload 27
      // 129: aload 30
      // 12b: aload 23
      // 12d: aload 31
      // 12f: bipush 0
      // 130: faload
      // 131: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 134: invokevirtual x/oc63a9b409d2.Ī (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;Lnet/minecraft/item/ItemStack;Ljava/lang/Float;)Z
      // 137: iload 4
      // 139: ifne 161
      // 13c: ifne 14c
      // 13f: goto 143
      // 142: athrow
      // 143: iload 4
      // 145: ifeq 1d8
      // 148: goto 14c
      // 14b: athrow
      // 14c: aload 28
      // 14e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 151: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 154: fconst_1
      // 155: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 158: aload 30
      // 15a: invokestatic x/occb1ed1ed8f.Ũ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 15d: goto 161
      // 160: athrow
      // 161: ifne 16d
      // 164: iload 4
      // 166: ifeq 1d8
      // 169: goto 16d
      // 16c: athrow
      // 16d: aload 30
      // 16f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 172: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 175: fconst_1
      // 176: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 179: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 17c: dstore 32
      // 17e: iload 4
      // 180: ifne 1db
      // 183: dload 32
      // 185: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 188: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 18b: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 18e: f2d
      // 18f: dcmpl
      // 190: ifgt 1d8
      // 193: goto 197
      // 196: athrow
      // 197: dload 32
      // 199: iload 4
      // 19b: ifne 1bb
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: dload 21
      // 1a4: dcmpl
      // 1a5: iflt 1b5
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: iload 4
      // 1ae: ifeq 1d8
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: dload 32
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: dstore 21
      // 1bd: new x/oc9b32a258fb
      // 1c0: dup
      // 1c1: aload 0
      // 1c2: aload 1
      // 1c3: aload 28
      // 1c5: aload 27
      // 1c7: aload 30
      // 1c9: aload 2
      // 1ca: iload 3
      // 1cb: aload 31
      // 1cd: bipush 0
      // 1ce: faload
      // 1cf: aload 31
      // 1d1: bipush 1
      // 1d2: faload
      // 1d3: invokespecial x/oc9b32a258fb.<init> (Lx/oc63a9b409d2;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;Lnet/minecraft/block/state/IBlockState;IFF)V
      // 1d6: astore 20
      // 1d8: iinc 26 1
      // 1db: iload 4
      // 1dd: ifeq 0a9
      // 1e0: aload 20
      // 1e2: areturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private ItemStack щ(int var1) {
      int var2 = ocfa11b18c57.ė;

      label31: {
         int var10000;
         label30: {
            try {
               var10000 = var1;
               if (var2 != 0) {
                  break label30;
               }

               if (var1 < 0) {
                  break label31;
               }
            } catch (ocbde1165e4e var5) {
               throw var5;
            }

            var10000 = var1;
         }

         try {
            if (var10000 < (-749603070 ^ -749603061)) {
               return oc69da1aa7f5.ő.thePlayer.inventory.mainInventory[var1];
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }
      }

      try {
         return null;
      } catch (ocbde1165e4e var3) {
         throw var3;
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   Vec3 Ӛ(BlockPos var1, EnumFacing var2) {
      int var10000 = ocfa11b18c57.ė;
      double var4 = 0.15;
      double var6 = var1.getX() + 0.5;
      int var3 = var10000;
      double var8 = var1.getY() + 0.5;
      double var10 = var1.getZ() + 0.5;

      label138: {
         label144: {
            try {
               var27 = var2;
               if (var3 != 0) {
                  break label138;
               }

               if (var2 != EnumFacing.UP) {
                  break label144;
               }
            } catch (ocbde1165e4e var26) {
               throw var26;
            }

            var8 = var1.getY() + 1.0 - var4;

            try {
               if (var3 == 0) {
                  return new Vec3(var6, var8, var10);
               }
            } catch (ocbde1165e4e var25) {
               throw var25;
            }
         }

         try {
            var27 = var2;
         } catch (ocbde1165e4e var16) {
            throw var16;
         }
      }

      label125: {
         label145: {
            try {
               if (var3 != 0) {
                  break label125;
               }

               if (var27 != EnumFacing.DOWN) {
                  break label145;
               }
            } catch (ocbde1165e4e var24) {
               throw var24;
            }

            var8 = var1.getY() + var4;

            try {
               if (var3 == 0) {
                  return new Vec3(var6, var8, var10);
               }
            } catch (ocbde1165e4e var23) {
               throw var23;
            }
         }

         try {
            var27 = var2;
         } catch (ocbde1165e4e var15) {
            throw var15;
         }
      }

      label112: {
         label146: {
            try {
               if (var3 != 0) {
                  break label112;
               }

               if (var27 != EnumFacing.NORTH) {
                  break label146;
               }
            } catch (ocbde1165e4e var22) {
               throw var22;
            }

            var10 = var1.getZ() + var4;

            try {
               if (var3 == 0) {
                  return new Vec3(var6, var8, var10);
               }
            } catch (ocbde1165e4e var21) {
               throw var21;
            }
         }

         try {
            var27 = var2;
         } catch (ocbde1165e4e var14) {
            throw var14;
         }
      }

      label99: {
         label147: {
            try {
               if (var3 != 0) {
                  break label99;
               }

               if (var27 != EnumFacing.SOUTH) {
                  break label147;
               }
            } catch (ocbde1165e4e var20) {
               throw var20;
            }

            var10 = var1.getZ() + 1.0 - var4;

            try {
               if (var3 == 0) {
                  return new Vec3(var6, var8, var10);
               }
            } catch (ocbde1165e4e var19) {
               throw var19;
            }
         }

         try {
            var27 = var2;
         } catch (ocbde1165e4e var13) {
            throw var13;
         }
      }

      label86: {
         label148: {
            try {
               if (var3 != 0) {
                  break label86;
               }

               if (var27 != EnumFacing.WEST) {
                  break label148;
               }
            } catch (ocbde1165e4e var18) {
               throw var18;
            }

            var6 = var1.getX() + var4;

            try {
               if (var3 == 0) {
                  return new Vec3(var6, var8, var10);
               }
            } catch (ocbde1165e4e var17) {
               throw var17;
            }
         }

         try {
            var27 = var2;
         } catch (ocbde1165e4e var12) {
            throw var12;
         }
      }

      if (var27 == EnumFacing.EAST) {
         var6 = var1.getX() + 1.0 - var4;
      }

      return new Vec3(var6, var8, var10);
   }

   private float[] Ŝ(Vec3 var1, float var2, float var3) {
      double var4 = var1.xCoord - oc69da1aa7f5.ő.thePlayer.posX;
      double var6 = var1.yCoord - (oc69da1aa7f5.ő.thePlayer.posY + oc69da1aa7f5.ő.thePlayer.getEyeHeight());
      double var8 = var1.zCoord - oc69da1aa7f5.ő.thePlayer.posZ;
      float var10 = (float)(Math.atan2(var8, var4) * 180.0 / Math.PI) - 90.0F;
      float var11 = (float)(-(Math.atan2(var6, Math.sqrt(var4 * var4 + var8 * var8)) * 180.0 / Math.PI));
      float[] var10000 = new float[1087679776 ^ 1087679778];
      var10000[0] = var2 + MathHelper.wrapAngleTo180_float(var10 - var2);
      var10000[1] = oc75d51ec7eb.À(var3 + MathHelper.wrapAngleTo180_float(var11 - var3));
      return var10000;
   }

   private float[] Ě(float param1, float param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 09: getfield net/minecraft/client/settings/GameSettings.mouseSensitivity F
      // 0c: ldc_w 0.6
      // 0f: fmul
      // 10: ldc_w 0.2
      // 13: fadd
      // 14: fstore 6
      // 16: fload 6
      // 18: fload 6
      // 1a: fmul
      // 1b: fload 6
      // 1d: fmul
      // 1e: ldc_w 8.0
      // 21: fmul
      // 22: ldc_w 0.15
      // 25: fmul
      // 26: fstore 7
      // 28: istore 5
      // 2a: fload 7
      // 2c: iload 5
      // 2e: ifne 62
      // 31: fconst_0
      // 32: fcmpg
      // 33: ifgt 50
      // 36: goto 3a
      // 39: athrow
      // 3a: ldc_w 326258155
      // 3d: ldc_w 326258153
      // 40: ixor
      // 41: newarray 6
      // 43: dup
      // 44: bipush 0
      // 45: fload 1
      // 46: fastore
      // 47: dup
      // 48: bipush 1
      // 49: fload 2
      // 4a: invokestatic x/oc75d51ec7eb.À (F)F
      // 4d: fastore
      // 4e: areturn
      // 4f: athrow
      // 50: fload 3
      // 51: fload 1
      // 52: fload 3
      // 53: fsub
      // 54: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 57: fload 7
      // 59: fdiv
      // 5a: invokestatic java/lang/Math.round (F)I
      // 5d: i2f
      // 5e: fload 7
      // 60: fmul
      // 61: fadd
      // 62: fstore 8
      // 64: fload 4
      // 66: fload 2
      // 67: fload 4
      // 69: fsub
      // 6a: fload 7
      // 6c: fdiv
      // 6d: invokestatic java/lang/Math.round (F)I
      // 70: i2f
      // 71: fload 7
      // 73: fmul
      // 74: fadd
      // 75: fstore 9
      // 77: ldc_w 326258155
      // 7a: ldc_w 326258153
      // 7d: ixor
      // 7e: newarray 6
      // 80: dup
      // 81: bipush 0
      // 82: fload 8
      // 84: fastore
      // 85: dup
      // 86: bipush 1
      // 87: fload 9
      // 89: invokestatic x/oc75d51ec7eb.À (F)F
      // 8c: fastore
      // 8d: areturn
   }

   private boolean ӂ(MovingObjectPosition param1, oc9b32a258fb param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 3
      // 04: aload 1
      // 05: iload 3
      // 06: ifne 11
      // 09: ifnull 48
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 14: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 17: if_acmpne 48
      // 1a: aload 2
      // 1b: iload 3
      // 1c: ifne 39
      // 1f: goto 23
      // 22: athrow
      // 23: getfield x/oc9b32a258fb.Ӱ Lnet/minecraft/util/BlockPos;
      // 26: aload 1
      // 27: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 2a: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 2d: ifeq 48
      // 30: goto 34
      // 33: athrow
      // 34: aload 2
      // 35: goto 39
      // 38: athrow
      // 39: getfield x/oc9b32a258fb.Ǒ Lnet/minecraft/util/EnumFacing;
      // 3c: aload 1
      // 3d: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 40: if_acmpne 48
      // 43: bipush 1
      // 44: goto 49
      // 47: athrow
      // 48: bipush 0
      // 49: ireturn
   }

   private boolean ԃ(oc9b32a258fb param1, ItemStack param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 3
      // 04: aload 1
      // 05: iload 3
      // 06: ifne 11
      // 09: ifnull 3e
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 3
      // 12: ifne 24
      // 15: getfield x/oc9b32a258fb.ԋ Lnet/minecraft/block/state/IBlockState;
      // 18: ifnull 3e
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 1
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: getfield x/oc63a9b409d2.ƥ Ljava/util/concurrent/ConcurrentHashMap;
      // 28: invokevirtual x/oc9b32a258fb.Ț (Ljava/util/Map;)Z
      // 2b: iload 3
      // 2c: ifne 43
      // 2f: ifne 3e
      // 32: goto 36
      // 35: athrow
      // 36: aload 2
      // 37: ifnonnull 44
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 0
      // 3f: goto 43
      // 42: athrow
      // 43: ireturn
      // 44: aload 1
      // 45: getfield x/oc9b32a258fb.ѐ Lnet/minecraft/util/BlockPos;
      // 48: invokestatic x/occb1ed1ed8f.ɍ (Lnet/minecraft/util/BlockPos;)Z
      // 4b: iload 3
      // 4c: ifne 6f
      // 4f: ifeq 6e
      // 52: goto 56
      // 55: athrow
      // 56: aload 0
      // 57: aload 2
      // 58: aload 1
      // 59: getfield x/oc9b32a258fb.ԋ Lnet/minecraft/block/state/IBlockState;
      // 5c: invokevirtual x/oc63a9b409d2.ɇ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/state/IBlockState;)Z
      // 5f: iload 3
      // 60: ifne 7c
      // 63: goto 67
      // 66: athrow
      // 67: ifne 70
      // 6a: goto 6e
      // 6d: athrow
      // 6e: bipush 0
      // 6f: ireturn
      // 70: aload 2
      // 71: aload 1
      // 72: getfield x/oc9b32a258fb.Ӱ Lnet/minecraft/util/BlockPos;
      // 75: aload 1
      // 76: getfield x/oc9b32a258fb.Ǒ Lnet/minecraft/util/EnumFacing;
      // 79: invokestatic x/occb1ed1ed8f.ā (Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 7c: iload 3
      // 7d: ifne a7
      // 80: ifeq b6
      // 83: goto 87
      // 86: athrow
      // 87: aload 0
      // 88: aload 1
      // 89: getfield x/oc9b32a258fb.ԋ Lnet/minecraft/block/state/IBlockState;
      // 8c: aload 1
      // 8d: getfield x/oc9b32a258fb.Ӱ Lnet/minecraft/util/BlockPos;
      // 90: aload 1
      // 91: getfield x/oc9b32a258fb.Ǒ Lnet/minecraft/util/EnumFacing;
      // 94: aload 1
      // 95: getfield x/oc9b32a258fb.վ Lnet/minecraft/util/Vec3;
      // 98: aload 2
      // 99: aload 1
      // 9a: getfield x/oc9b32a258fb.E F
      // 9d: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // a0: invokevirtual x/oc63a9b409d2.Ī (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;Lnet/minecraft/item/ItemStack;Ljava/lang/Float;)Z
      // a3: goto a7
      // a6: athrow
      // a7: iload 3
      // a8: ifne b3
      // ab: ifeq b6
      // ae: goto b2
      // b1: athrow
      // b2: bipush 1
      // b3: goto b7
      // b6: bipush 0
      // b7: ireturn
   }

   private void ǹ() {
      this.մ = null;
      this.ʧ = false;
   }

   private void ƺ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: aload 0
      // 04: invokevirtual x/oc63a9b409d2.ǹ ()V
      // 07: istore 1
      // 08: aload 0
      // 09: bipush 0
      // 0a: putfield x/oc63a9b409d2.ѷ I
      // 0d: iload 1
      // 0e: ifne 74
      // 11: aload 0
      // 12: getfield x/oc63a9b409d2.ѫ Z
      // 15: ifeq 6a
      // 18: goto 1c
      // 1b: athrow
      // 1c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22: ifnull 6a
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: iload 1
      // 2b: ifne 70
      // 2e: goto 32
      // 31: athrow
      // 32: getfield x/oc63a9b409d2.բ I
      // 35: iflt 6a
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 0
      // 3d: iload 1
      // 3e: ifne 70
      // 41: goto 45
      // 44: athrow
      // 45: getfield x/oc63a9b409d2.բ I
      // 48: ldc_w -869306950
      // 4b: ldc_w -869306957
      // 4e: ixor
      // 4f: if_icmpge 6a
      // 52: goto 56
      // 55: athrow
      // 56: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 59: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 5f: aload 0
      // 60: getfield x/oc63a9b409d2.բ I
      // 63: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 0
      // 6b: bipush 0
      // 6c: putfield x/oc63a9b409d2.ѫ Z
      // 6f: aload 0
      // 70: bipush -1
      // 71: putfield x/oc63a9b409d2.բ I
      // 74: return
   }

   public boolean в(IBlockState param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 2
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: ifnull 2e
      // 0d: aload 0
      // 0e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 17: aload 1
      // 18: invokevirtual x/oc63a9b409d2.ɇ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/state/IBlockState;)Z
      // 1b: iload 2
      // 1c: ifne 2b
      // 1f: goto 23
      // 22: athrow
      // 23: ifeq 2e
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: goto 2f
      // 2e: bipush 0
      // 2f: ireturn
   }

   private boolean ɇ(ItemStack param1, IBlockState param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 3
      // 004: aload 1
      // 005: ifnull 023
      // 008: aload 2
      // 009: ifnull 023
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 1
      // 011: iload 3
      // 012: ifne 027
      // 015: goto 019
      // 018: athrow
      // 019: getfield net/minecraft/item/ItemStack.stackSize I
      // 01c: ifgt 026
      // 01f: goto 023
      // 022: athrow
      // 023: bipush 0
      // 024: ireturn
      // 025: athrow
      // 026: aload 1
      // 027: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 02a: astore 4
      // 02c: aload 2
      // 02d: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 032: astore 5
      // 034: aload 5
      // 036: iload 3
      // 037: ifne 04a
      // 03a: getstatic net/minecraft/init/Blocks.water Lnet/minecraft/block/BlockStaticLiquid;
      // 03d: if_acmpeq 050
      // 040: goto 044
      // 043: athrow
      // 044: aload 5
      // 046: goto 04a
      // 049: athrow
      // 04a: getstatic net/minecraft/init/Blocks.flowing_water Lnet/minecraft/block/BlockDynamicLiquid;
      // 04d: if_acmpne 067
      // 050: aload 4
      // 052: iload 3
      // 053: ifne 069
      // 056: goto 05a
      // 059: athrow
      // 05a: getstatic net/minecraft/init/Items.water_bucket Lnet/minecraft/item/Item;
      // 05d: if_acmpne 067
      // 060: goto 064
      // 063: athrow
      // 064: bipush 1
      // 065: ireturn
      // 066: athrow
      // 067: aload 4
      // 069: iload 3
      // 06a: ifne 07c
      // 06d: instanceof net/minecraft/item/ItemBlock
      // 070: ifne 07a
      // 073: goto 077
      // 076: athrow
      // 077: bipush 0
      // 078: ireturn
      // 079: athrow
      // 07a: aload 4
      // 07c: checkcast net/minecraft/item/ItemBlock
      // 07f: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 082: astore 6
      // 084: iload 3
      // 085: aload 1
      // 086: invokevirtual net/minecraft/item/ItemStack.getItemDamage ()I
      // 089: istore 7
      // 08b: aload 5
      // 08d: aload 2
      // 08e: invokevirtual net/minecraft/block/Block.getMetaFromState (Lnet/minecraft/block/state/IBlockState;)I
      // 091: istore 8
      // 093: ifne 0ba
      // 096: aload 5
      // 098: getstatic net/minecraft/init/Blocks.leaves Lnet/minecraft/block/BlockLeaves;
      // 09b: if_acmpeq 0ae
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: aload 5
      // 0a4: getstatic net/minecraft/init/Blocks.leaves2 Lnet/minecraft/block/BlockLeaves;
      // 0a7: if_acmpne 0c6
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: iload 8
      // 0b0: ldc_w 473262710
      // 0b3: ldc_w 473262709
      // 0b6: ixor
      // 0b7: iand
      // 0b8: istore 8
      // 0ba: iload 7
      // 0bc: ldc_w 473262710
      // 0bf: ldc_w 473262709
      // 0c2: ixor
      // 0c3: iand
      // 0c4: istore 7
      // 0c6: aload 0
      // 0c7: aload 6
      // 0c9: invokevirtual x/oc63a9b409d2.ȿ (Lnet/minecraft/block/Block;)Z
      // 0cc: iload 3
      // 0cd: ifne 0db
      // 0d0: ifeq 0dd
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: bipush 0
      // 0d8: istore 7
      // 0da: bipush 0
      // 0db: istore 8
      // 0dd: aload 6
      // 0df: aload 5
      // 0e1: if_acmpne 0ff
      // 0e4: iload 7
      // 0e6: iload 3
      // 0e7: ifne 0fc
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: iload 8
      // 0f0: if_icmpne 0ff
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: bipush 1
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: goto 100
      // 0ff: bipush 0
      // 100: ireturn
   }

   private int թ(IBlockState param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: ifnull 1d
      // 08: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b: iload 2
      // 0c: ifne 23
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: ifnonnull 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush -1
      // 1e: ireturn
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 29: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 2c: istore 3
      // 2d: aload 0
      // 2e: iload 2
      // 2f: ifne 46
      // 32: aload 0
      // 33: iload 3
      // 34: invokevirtual x/oc63a9b409d2.щ (I)Lnet/minecraft/item/ItemStack;
      // 37: aload 1
      // 38: invokevirtual x/oc63a9b409d2.ɇ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/state/IBlockState;)Z
      // 3b: ifeq 45
      // 3e: goto 42
      // 41: athrow
      // 42: iload 3
      // 43: ireturn
      // 44: athrow
      // 45: aload 0
      // 46: iload 2
      // 47: ifne 5b
      // 4a: getfield x/oc63a9b409d2.ˡ Lx/occ2f8dff8d8;
      // 4d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 50: ifne 5a
      // 53: goto 57
      // 56: athrow
      // 57: bipush -1
      // 58: ireturn
      // 59: athrow
      // 5a: aload 0
      // 5b: aload 1
      // 5c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 61: aload 1
      // 62: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 67: aload 1
      // 68: invokevirtual net/minecraft/block/Block.getMetaFromState (Lnet/minecraft/block/state/IBlockState;)I
      // 6b: invokevirtual x/oc63a9b409d2.Ȕ (Lnet/minecraft/block/Block;I)I
      // 6e: ireturn
   }

   private void π() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 1f
      // 0b: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0e: instanceof x/oc51cbcffcfe
      // 11: ifeq 27
      // 14: goto 18
      // 17: athrow
      // 18: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 22: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 27: return
   }

   public MovingObjectPosition Ә() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 09: astore 2
      // 0a: istore 1
      // 0b: aload 2
      // 0c: iload 1
      // 0d: ifne 18
      // 10: ifnull 3c
      // 13: goto 17
      // 16: athrow
      // 17: aload 2
      // 18: iload 1
      // 19: ifne 2e
      // 1c: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 1f: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 22: if_acmpne 3c
      // 25: goto 29
      // 28: athrow
      // 29: aload 2
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 1
      // 2f: ifne 45
      // 32: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 35: ifnonnull 3f
      // 38: goto 3c
      // 3b: athrow
      // 3c: aconst_null
      // 3d: areturn
      // 3e: athrow
      // 3f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 42: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 45: areturn
   }

   private int Ȕ(Block param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 3
      // 004: aload 0
      // 005: aload 1
      // 006: invokevirtual x/oc63a9b409d2.ȿ (Lnet/minecraft/block/Block;)Z
      // 009: iload 3
      // 00a: ifne 015
      // 00d: ifeq 016
      // 010: goto 014
      // 013: athrow
      // 014: bipush 0
      // 015: istore 2
      // 016: aload 1
      // 017: iload 3
      // 018: ifne 02a
      // 01b: getstatic net/minecraft/init/Blocks.leaves Lnet/minecraft/block/BlockLeaves;
      // 01e: if_acmpeq 030
      // 021: goto 025
      // 024: athrow
      // 025: aload 1
      // 026: goto 02a
      // 029: athrow
      // 02a: getstatic net/minecraft/init/Blocks.leaves2 Lnet/minecraft/block/BlockLeaves;
      // 02d: if_acmpne 03a
      // 030: iload 2
      // 031: ldc_w -583737456
      // 034: ldc_w -583737453
      // 037: ixor
      // 038: iand
      // 039: istore 2
      // 03a: bipush 0
      // 03b: istore 4
      // 03d: iload 4
      // 03f: ldc_w -583737446
      // 042: ldc_w -583737453
      // 045: ixor
      // 046: if_icmpge 113
      // 049: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 04f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 052: getfield net/minecraft/entity/player/InventoryPlayer.mainInventory [Lnet/minecraft/item/ItemStack;
      // 055: iload 4
      // 057: aaload
      // 058: astore 5
      // 05a: iload 3
      // 05b: ifne 10f
      // 05e: aload 5
      // 060: ifnull 10c
      // 063: goto 067
      // 066: athrow
      // 067: aload 5
      // 069: iload 3
      // 06a: ifne 084
      // 06d: goto 071
      // 070: athrow
      // 071: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 074: instanceof net/minecraft/item/ItemBlock
      // 077: ifeq 10c
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 5
      // 080: goto 084
      // 083: athrow
      // 084: iload 3
      // 085: ifne 098
      // 088: getfield net/minecraft/item/ItemStack.stackSize I
      // 08b: ifle 10c
      // 08e: goto 092
      // 091: athrow
      // 092: aload 5
      // 094: goto 098
      // 097: athrow
      // 098: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 09b: checkcast net/minecraft/item/ItemBlock
      // 09e: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 0a1: astore 6
      // 0a3: aload 5
      // 0a5: invokevirtual net/minecraft/item/ItemStack.getItemDamage ()I
      // 0a8: istore 7
      // 0aa: aload 0
      // 0ab: aload 1
      // 0ac: invokevirtual x/oc63a9b409d2.ȿ (Lnet/minecraft/block/Block;)Z
      // 0af: iload 3
      // 0b0: ifne 0bb
      // 0b3: ifeq 0bd
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: bipush 0
      // 0bb: istore 7
      // 0bd: aload 6
      // 0bf: iload 3
      // 0c0: ifne 0d3
      // 0c3: getstatic net/minecraft/init/Blocks.leaves Lnet/minecraft/block/BlockLeaves;
      // 0c6: if_acmpeq 0e1
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: aload 6
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: iload 3
      // 0d4: ifne 0ef
      // 0d7: getstatic net/minecraft/init/Blocks.leaves2 Lnet/minecraft/block/BlockLeaves;
      // 0da: if_acmpne 0ed
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: iload 7
      // 0e3: ldc_w -583737456
      // 0e6: ldc_w -583737453
      // 0e9: ixor
      // 0ea: iand
      // 0eb: istore 7
      // 0ed: aload 6
      // 0ef: aload 1
      // 0f0: if_acmpne 10c
      // 0f3: iload 7
      // 0f5: iload 3
      // 0f6: ifne 10b
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: iload 2
      // 0fe: if_icmpne 10c
      // 101: goto 105
      // 104: athrow
      // 105: iload 4
      // 107: goto 10b
      // 10a: athrow
      // 10b: ireturn
      // 10c: iinc 4 1
      // 10f: iload 3
      // 110: ifeq 03d
      // 113: bipush -1
      // 114: ireturn
   }

   private boolean ȿ(Block param1) {
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
      // 005: instanceof net/minecraft/block/BlockStairs
      // 008: iload 2
      // 009: ifne 16a
      // 00c: ifne 169
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: instanceof net/minecraft/block/BlockDoublePlant
      // 017: iload 2
      // 018: ifne 16a
      // 01b: goto 01f
      // 01e: athrow
      // 01f: ifne 169
      // 022: goto 026
      // 025: athrow
      // 026: aload 1
      // 027: instanceof net/minecraft/block/BlockFlower
      // 02a: iload 2
      // 02b: ifne 16a
      // 02e: goto 032
      // 031: athrow
      // 032: ifne 169
      // 035: goto 039
      // 038: athrow
      // 039: aload 1
      // 03a: instanceof net/minecraft/block/BlockSkull
      // 03d: iload 2
      // 03e: ifne 16a
      // 041: goto 045
      // 044: athrow
      // 045: ifne 169
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 1
      // 04d: instanceof net/minecraft/block/BlockLadder
      // 050: iload 2
      // 051: ifne 16a
      // 054: goto 058
      // 057: athrow
      // 058: ifne 169
      // 05b: goto 05f
      // 05e: athrow
      // 05f: aload 1
      // 060: instanceof net/minecraft/block/BlockPumpkin
      // 063: iload 2
      // 064: ifne 16a
      // 067: goto 06b
      // 06a: athrow
      // 06b: ifne 169
      // 06e: goto 072
      // 071: athrow
      // 072: aload 1
      // 073: instanceof net/minecraft/block/BlockCauldron
      // 076: iload 2
      // 077: ifne 16a
      // 07a: goto 07e
      // 07d: athrow
      // 07e: ifne 169
      // 081: goto 085
      // 084: athrow
      // 085: aload 1
      // 086: instanceof net/minecraft/block/BlockRail
      // 089: iload 2
      // 08a: ifne 16a
      // 08d: goto 091
      // 090: athrow
      // 091: ifne 169
      // 094: goto 098
      // 097: athrow
      // 098: aload 1
      // 099: instanceof net/minecraft/block/BlockRailBase
      // 09c: iload 2
      // 09d: ifne 16a
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: ifne 169
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aload 1
      // 0ac: instanceof net/minecraft/block/BlockTripWireHook
      // 0af: iload 2
      // 0b0: ifne 16a
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: ifne 169
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: aload 1
      // 0bf: instanceof net/minecraft/block/BlockTripWire
      // 0c2: iload 2
      // 0c3: ifne 16a
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: ifne 169
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: aload 1
      // 0d2: instanceof net/minecraft/block/BlockDispenser
      // 0d5: iload 2
      // 0d6: ifne 16a
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: ifne 169
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: aload 1
      // 0e5: instanceof net/minecraft/block/BlockDropper
      // 0e8: iload 2
      // 0e9: ifne 16a
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: ifne 169
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 1
      // 0f8: instanceof net/minecraft/block/BlockHopper
      // 0fb: iload 2
      // 0fc: ifne 16a
      // 0ff: goto 103
      // 102: athrow
      // 103: ifne 169
      // 106: goto 10a
      // 109: athrow
      // 10a: aload 1
      // 10b: instanceof net/minecraft/block/BlockTorch
      // 10e: iload 2
      // 10f: ifne 16a
      // 112: goto 116
      // 115: athrow
      // 116: ifne 169
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 1
      // 11e: instanceof net/minecraft/block/BlockButton
      // 121: iload 2
      // 122: ifne 16a
      // 125: goto 129
      // 128: athrow
      // 129: ifne 169
      // 12c: goto 130
      // 12f: athrow
      // 130: aload 1
      // 131: instanceof net/minecraft/block/BlockLever
      // 134: iload 2
      // 135: ifne 16a
      // 138: goto 13c
      // 13b: athrow
      // 13c: ifne 169
      // 13f: goto 143
      // 142: athrow
      // 143: aload 1
      // 144: instanceof net/minecraft/block/BlockTrapDoor
      // 147: iload 2
      // 148: ifne 16a
      // 14b: goto 14f
      // 14e: athrow
      // 14f: ifne 169
      // 152: goto 156
      // 155: athrow
      // 156: aload 1
      // 157: instanceof net/minecraft/block/BlockSlab
      // 15a: iload 2
      // 15b: ifne 16a
      // 15e: goto 162
      // 161: athrow
      // 162: ifeq 16d
      // 165: goto 169
      // 168: athrow
      // 169: bipush 1
      // 16a: goto 16e
      // 16d: bipush 0
      // 16e: ireturn
   }

   private boolean Ʋ(IBlockState var1, BlockPos var2, EnumFacing var3, Vec3 var4, ItemStack var5) {
      return this.Ī(var1, var2, var3, var4, var5, null);
   }

   private boolean Ī(IBlockState param1, BlockPos param2, EnumFacing param3, Vec3 param4, ItemStack param5, Float param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 7
      // 005: aload 1
      // 006: ifnull 048
      // 009: aload 2
      // 00a: ifnull 048
      // 00d: goto 011
      // 010: athrow
      // 011: aload 3
      // 012: ifnull 048
      // 015: goto 019
      // 018: athrow
      // 019: aload 4
      // 01b: ifnull 048
      // 01e: goto 022
      // 021: athrow
      // 022: aload 5
      // 024: iload 7
      // 026: ifne 036
      // 029: goto 02d
      // 02c: athrow
      // 02d: ifnull 048
      // 030: goto 034
      // 033: athrow
      // 034: aload 5
      // 036: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 039: instanceof net/minecraft/item/ItemBlock
      // 03c: iload 7
      // 03e: ifne 054
      // 041: ifne 04b
      // 044: goto 048
      // 047: athrow
      // 048: bipush 0
      // 049: ireturn
      // 04a: athrow
      // 04b: aload 1
      // 04c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 051: instanceof net/minecraft/block/BlockLeaves
      // 054: iload 7
      // 056: ifne 07a
      // 059: ifne 079
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 1
      // 061: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 066: instanceof net/minecraft/block/BlockButton
      // 069: iload 7
      // 06b: ifne 07a
      // 06e: goto 072
      // 071: athrow
      // 072: ifeq 07b
      // 075: goto 079
      // 078: athrow
      // 079: bipush 1
      // 07a: ireturn
      // 07b: aload 5
      // 07d: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 080: checkcast net/minecraft/item/ItemBlock
      // 083: astore 8
      // 085: aload 8
      // 087: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 08a: astore 9
      // 08c: aload 5
      // 08e: invokevirtual net/minecraft/item/ItemStack.getItemDamage ()I
      // 091: istore 10
      // 093: aload 4
      // 095: new net/minecraft/util/Vec3
      // 098: dup
      // 099: aload 2
      // 09a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 09d: i2d
      // 09e: aload 2
      // 09f: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0a2: i2d
      // 0a3: aload 2
      // 0a4: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0a7: i2d
      // 0a8: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ab: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 0ae: astore 11
      // 0b0: aload 2
      // 0b1: iload 7
      // 0b3: ifne 0c6
      // 0b6: invokestatic x/occb1ed1ed8f.ɍ (Lnet/minecraft/util/BlockPos;)Z
      // 0b9: ifeq 0c5
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aload 2
      // 0c1: goto 0ca
      // 0c4: athrow
      // 0c5: aload 2
      // 0c6: aload 3
      // 0c7: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 0ca: astore 12
      // 0cc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d2: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0d5: fstore 14
      // 0d7: aload 6
      // 0d9: ifnull 0ee
      // 0dc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0df: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e2: aload 6
      // 0e4: invokevirtual java/lang/Float.floatValue ()F
      // 0e7: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: aload 9
      // 0f0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f3: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0f6: aload 12
      // 0f8: aload 3
      // 0f9: aload 11
      // 0fb: getfield net/minecraft/util/Vec3.xCoord D
      // 0fe: d2f
      // 0ff: aload 11
      // 101: getfield net/minecraft/util/Vec3.yCoord D
      // 104: d2f
      // 105: aload 11
      // 107: getfield net/minecraft/util/Vec3.zCoord D
      // 10a: d2f
      // 10b: iload 10
      // 10d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 110: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 113: invokevirtual net/minecraft/block/Block.onBlockPlaced (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FFFILnet/minecraft/entity/EntityLivingBase;)Lnet/minecraft/block/state/IBlockState;
      // 116: astore 13
      // 118: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11e: fload 14
      // 120: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 123: goto 136
      // 126: astore 15
      // 128: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 12e: fload 14
      // 130: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 133: aload 15
      // 135: athrow
      // 136: aload 13
      // 138: iload 7
      // 13a: ifne 149
      // 13d: ifnonnull 147
      // 140: goto 144
      // 143: athrow
      // 144: bipush 0
      // 145: ireturn
      // 146: athrow
      // 147: aload 13
      // 149: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 14e: iload 7
      // 150: ifne 16a
      // 153: aload 1
      // 154: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 159: if_acmpeq 163
      // 15c: goto 160
      // 15f: athrow
      // 160: bipush 0
      // 161: ireturn
      // 162: athrow
      // 163: aload 13
      // 165: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 16a: aload 13
      // 16c: invokevirtual net/minecraft/block/Block.getMetaFromState (Lnet/minecraft/block/state/IBlockState;)I
      // 16f: istore 15
      // 171: aload 1
      // 172: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 177: aload 1
      // 178: invokevirtual net/minecraft/block/Block.getMetaFromState (Lnet/minecraft/block/state/IBlockState;)I
      // 17b: istore 16
      // 17d: iload 15
      // 17f: iload 7
      // 181: ifne 1a6
      // 184: iload 16
      // 186: if_icmpeq 190
      // 189: goto 18d
      // 18c: athrow
      // 18d: bipush 0
      // 18e: ireturn
      // 18f: athrow
      // 190: aload 13
      // 192: iload 7
      // 194: ifne 1f7
      // 197: invokeinterface net/minecraft/block/state/IBlockState.getProperties ()Lcom/google/common/collect/ImmutableMap; 1
      // 19c: getstatic net/minecraft/block/BlockDirectional.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 19f: invokevirtual com/google/common/collect/ImmutableMap.containsKey (Ljava/lang/Object;)Z
      // 1a2: goto 1a6
      // 1a5: athrow
      // 1a6: ifeq 1f5
      // 1a9: aload 1
      // 1aa: iload 7
      // 1ac: ifne 1f7
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: invokeinterface net/minecraft/block/state/IBlockState.getProperties ()Lcom/google/common/collect/ImmutableMap; 1
      // 1b8: getstatic net/minecraft/block/BlockDirectional.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 1bb: invokevirtual com/google/common/collect/ImmutableMap.containsKey (Ljava/lang/Object;)Z
      // 1be: ifeq 1f5
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: aload 13
      // 1c7: iload 7
      // 1c9: ifne 1f7
      // 1cc: goto 1d0
      // 1cf: athrow
      // 1d0: getstatic net/minecraft/block/BlockDirectional.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 1d3: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 1d8: checkcast net/minecraft/util/EnumFacing
      // 1db: astore 17
      // 1dd: aload 1
      // 1de: getstatic net/minecraft/block/BlockDirectional.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 1e1: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 1e6: checkcast net/minecraft/util/EnumFacing
      // 1e9: astore 18
      // 1eb: aload 17
      // 1ed: aload 18
      // 1ef: if_acmpeq 1f5
      // 1f2: bipush 0
      // 1f3: ireturn
      // 1f4: athrow
      // 1f5: aload 13
      // 1f7: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 1fc: instanceof net/minecraft/block/BlockStairs
      // 1ff: iload 7
      // 201: ifne 274
      // 204: ifeq 273
      // 207: goto 20b
      // 20a: athrow
      // 20b: aload 1
      // 20c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 211: instanceof net/minecraft/block/BlockStairs
      // 214: iload 7
      // 216: ifne 274
      // 219: goto 21d
      // 21c: athrow
      // 21d: ifeq 273
      // 220: goto 224
      // 223: athrow
      // 224: aload 13
      // 226: getstatic net/minecraft/block/BlockStairs.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 229: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 22e: checkcast net/minecraft/util/EnumFacing
      // 231: astore 17
      // 233: aload 1
      // 234: getstatic net/minecraft/block/BlockStairs.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 237: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 23c: checkcast net/minecraft/util/EnumFacing
      // 23f: astore 18
      // 241: aload 13
      // 243: getstatic net/minecraft/block/BlockStairs.HALF Lnet/minecraft/block/properties/PropertyEnum;
      // 246: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 24b: checkcast net/minecraft/block/BlockStairs$EnumHalf
      // 24e: astore 19
      // 250: aload 1
      // 251: getstatic net/minecraft/block/BlockStairs.HALF Lnet/minecraft/block/properties/PropertyEnum;
      // 254: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 259: checkcast net/minecraft/block/BlockStairs$EnumHalf
      // 25c: astore 20
      // 25e: aload 17
      // 260: aload 18
      // 262: if_acmpne 270
      // 265: aload 19
      // 267: aload 20
      // 269: if_acmpeq 273
      // 26c: goto 270
      // 26f: athrow
      // 270: bipush 0
      // 271: ireturn
      // 272: athrow
      // 273: bipush 1
      // 274: ireturn
   }
}
