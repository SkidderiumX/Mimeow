package x;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import net.minecraft.util.BlockPos;
import net.minecraft.util.BlockPos.MutableBlockPos;

public class oc8c951938d3 extends oc69da1aa7f5 {
   public final oca9cc61aada ɐ;
   public final occ2f8dff8d8 ş;
   public final occ2f8dff8d8 Ӎ;
   public final occ2f8dff8d8 ӂ;
   public final occ2f8dff8d8 ά;
   public final occ2f8dff8d8 Ƞ;
   public final occ2f8dff8d8 ɶ;
   public final occ2f8dff8d8 ʤ;
   private final EnumMap<oc89eb238246, occ2f8dff8d8> ʭ = new EnumMap<>(oc89eb238246.class);
   private final HashSet<String> ӏ = new HashSet<>();
   private long ȕ;
   private final MutableBlockPos â = new MutableBlockPos();
   private final HashMap<UUID, ocede28e21e9> Ɖ = new HashMap<>();
   private final HashMap<UUID, HashMap<oc89eb238246, Long>> Ȓ = new HashMap<>();
   private final HashMap<UUID, S25PacketBlockBreakAnim> Ƅ = new HashMap<>();
   private final HashMap<BlockPos, S25PacketBlockBreakAnim> ƃ = new HashMap<>();
   private final HashSet<String> ǟ = new HashSet<>();
   private String Ա;
   private String Ӣ;
   private long Ҩ;
   public static int Щ;

   public oc8c951938d3() {
      super("AntiCheat", oce4cea752dd.Ҧ);
      this.ą("Detects suspicious combat, movement and block interactions.");
      this.ʌ(this.ɐ = new oca9cc61aada("Flag interval", " seconds", 5.0, 0.0, 30.0, 1.0));
      this.ʌ(this.ş = new occ2f8dff8d8("Add cheaters as enemy", false));
      this.ʌ(this.Ӎ = new occ2f8dff8d8("Auto report", false));
      this.ʌ(this.ӂ = new occ2f8dff8d8("Disable outside minigames", false));
      this.ʌ(this.ά = new occ2f8dff8d8("Hide chat alerts", false));
      this.ʌ(this.Ƞ = new occ2f8dff8d8("Ignore teammates", false));
      this.ʌ(this.ɶ = new occ2f8dff8d8("Send party chat", false));
      this.ʌ(this.ʤ = new occ2f8dff8d8("Should ping", false));

      for (oc89eb238246 var4 : oc89eb238246.values()) {
         if (var4 != oc89eb238246.ͳ) {
            occ2f8dff8d8 var5 = new occ2f8dff8d8(var4.Š, !var4.Π);
            this.ʭ.put((Enum)var4, var5);
            this.ʌ(var5);
         }
      }

      this.ɮ = true;
   }

   private boolean ʒ(oc89eb238246 param1) {
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
      // 05: getfield x/oc8c951938d3.ʭ Ljava/util/EnumMap;
      // 08: aload 1
      // 09: iload 2
      // 0a: ifne 1e
      // 0d: getstatic x/oc89eb238246.ͳ Lx/oc89eb238246;
      // 10: if_acmpne 21
      // 13: goto 17
      // 16: athrow
      // 17: getstatic x/oc89eb238246.р Lx/oc89eb238246;
      // 1a: goto 1e
      // 1d: athrow
      // 1e: goto 22
      // 21: aload 1
      // 22: invokevirtual java/util/EnumMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 25: checkcast x/occ2f8dff8d8
      // 28: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2b: ireturn
   }

   private void ϩ(EntityPlayer param1, ocede28e21e9 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc89eb238246.ħ I
      // 003: aload 1
      // 004: getfield net/minecraft/entity/player/EntityPlayer.ticksExisted I
      // 007: istore 5
      // 009: istore 3
      // 00a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00d: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 010: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getCurrentGameType ()Lnet/minecraft/world/WorldSettings$GameType;
      // 013: getstatic net/minecraft/world/WorldSettings$GameType.ADVENTURE Lnet/minecraft/world/WorldSettings$GameType;
      // 016: if_acmpne 01e
      // 019: bipush 1
      // 01a: goto 01f
      // 01d: athrow
      // 01e: bipush 0
      // 01f: istore 6
      // 021: aload 0
      // 022: getstatic x/oc89eb238246.µ Lx/oc89eb238246;
      // 025: iload 3
      // 026: ifne 0ae
      // 029: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 02c: ifeq 0a2
      // 02f: goto 033
      // 032: athrow
      // 033: aload 1
      // 034: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 037: ldc_w -80.0
      // 03a: fcmpl
      // 03b: iload 3
      // 03c: ifne 0b1
      // 03f: goto 043
      // 042: athrow
      // 043: ifle 0a2
      // 046: goto 04a
      // 049: athrow
      // 04a: aload 1
      // 04b: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 04e: ldc_w 80.0
      // 051: fcmpg
      // 052: iload 3
      // 053: ifne 0b1
      // 056: goto 05a
      // 059: athrow
      // 05a: ifge 0a2
      // 05d: goto 061
      // 060: athrow
      // 061: aload 2
      // 062: getfield x/ocede28e21e9.Ū I
      // 065: iload 3
      // 066: ifne 0b1
      // 069: goto 06d
      // 06c: athrow
      // 06d: ldc_w 653966930
      // 070: ldc_w 653966923
      // 073: ixor
      // 074: if_icmplt 0a2
      // 077: goto 07b
      // 07a: athrow
      // 07b: iload 5
      // 07d: iload 3
      // 07e: ifne 0b1
      // 081: goto 085
      // 084: athrow
      // 085: aload 2
      // 086: getfield x/ocede28e21e9.v I
      // 089: isub
      // 08a: ldc_w 653966930
      // 08d: ldc_w 653966923
      // 090: ixor
      // 091: if_icmplt 0a2
      // 094: goto 098
      // 097: athrow
      // 098: aload 0
      // 099: aload 1
      // 09a: getstatic x/oc89eb238246.µ Lx/oc89eb238246;
      // 09d: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 0a0: return
      // 0a1: athrow
      // 0a2: aload 0
      // 0a3: iload 3
      // 0a4: ifne 124
      // 0a7: getstatic x/oc89eb238246.ȶ Lx/oc89eb238246;
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 0b1: ifeq 123
      // 0b4: iload 6
      // 0b6: iload 3
      // 0b7: ifne 132
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: ifne 123
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 2
      // 0c6: getfield x/ocede28e21e9.e I
      // 0c9: iload 3
      // 0ca: ifne 132
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: ldc_w 653966913
      // 0d4: ldc_w 653966923
      // 0d7: ixor
      // 0d8: if_icmplt 123
      // 0db: goto 0df
      // 0de: athrow
      // 0df: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e5: aload 1
      // 0e6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 0e9: ldc2_w 700.0
      // 0ec: dcmpg
      // 0ed: iload 3
      // 0ee: ifne 132
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: ifge 123
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 1
      // 0fd: invokevirtual net/minecraft/entity/player/EntityPlayer.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 100: dup
      // 101: astore 4
      // 103: iload 3
      // 104: ifne 110
      // 107: ifnull 119
      // 10a: goto 10e
      // 10d: athrow
      // 10e: aload 4
      // 110: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 113: getstatic net/minecraft/init/Items.fishing_rod Lnet/minecraft/item/ItemFishingRod;
      // 116: if_acmpeq 123
      // 119: aload 0
      // 11a: aload 1
      // 11b: getstatic x/oc89eb238246.ȶ Lx/oc89eb238246;
      // 11e: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 121: return
      // 122: athrow
      // 123: aload 0
      // 124: iload 3
      // 125: ifne 15a
      // 128: getstatic x/oc89eb238246.ͻ Lx/oc89eb238246;
      // 12b: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 12e: goto 132
      // 131: athrow
      // 132: ifeq 159
      // 135: aload 2
      // 136: getfield x/ocede28e21e9.ԕ I
      // 139: iload 3
      // 13a: ifne 168
      // 13d: goto 141
      // 140: athrow
      // 141: ldc_w 653966916
      // 144: ldc_w 653966923
      // 147: ixor
      // 148: if_icmplt 159
      // 14b: goto 14f
      // 14e: athrow
      // 14f: aload 0
      // 150: aload 1
      // 151: getstatic x/oc89eb238246.ͻ Lx/oc89eb238246;
      // 154: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 157: return
      // 158: athrow
      // 159: aload 0
      // 15a: getstatic x/oc89eb238246.Ϫ Lx/oc89eb238246;
      // 15d: iload 3
      // 15e: ifne 20b
      // 161: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 164: goto 168
      // 167: athrow
      // 168: ifeq 207
      // 16b: iload 6
      // 16d: iload 3
      // 16e: ifne 216
      // 171: goto 175
      // 174: athrow
      // 175: ifne 207
      // 178: goto 17c
      // 17b: athrow
      // 17c: aload 2
      // 17d: getfield x/ocede28e21e9.C I
      // 180: iload 3
      // 181: ifne 216
      // 184: goto 188
      // 187: athrow
      // 188: ldc_w 653966921
      // 18b: ldc_w 653966923
      // 18e: ixor
      // 18f: if_icmplt 207
      // 192: goto 196
      // 195: athrow
      // 196: aload 2
      // 197: getfield x/ocede28e21e9.ƫ I
      // 19a: iload 3
      // 19b: ifne 216
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: ldc_w 653966925
      // 1a5: ldc_w 653966923
      // 1a8: ixor
      // 1a9: if_icmplt 207
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: aload 2
      // 1b1: getfield x/ocede28e21e9.պ D
      // 1b4: ldc2_w 0.5
      // 1b7: dcmpl
      // 1b8: iload 3
      // 1b9: ifne 216
      // 1bc: goto 1c0
      // 1bf: athrow
      // 1c0: ifle 207
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: aload 2
      // 1c8: getfield x/ocede28e21e9.պ D
      // 1cb: ldc2_w 3.0
      // 1ce: dcmpg
      // 1cf: iload 3
      // 1d0: ifne 216
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: ifge 207
      // 1da: goto 1de
      // 1dd: athrow
      // 1de: invokestatic java/lang/System.currentTimeMillis ()J
      // 1e1: aload 0
      // 1e2: getfield x/oc8c951938d3.ȕ J
      // 1e5: lsub
      // 1e6: ldc2_w -3049041904171128772
      // 1e9: ldc2_w -3049041904171128744
      // 1ec: lxor
      // 1ed: lcmp
      // 1ee: iload 3
      // 1ef: ifne 216
      // 1f2: goto 1f6
      // 1f5: athrow
      // 1f6: ifge 207
      // 1f9: goto 1fd
      // 1fc: athrow
      // 1fd: aload 0
      // 1fe: aload 1
      // 1ff: getstatic x/oc89eb238246.Ϫ Lx/oc89eb238246;
      // 202: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 205: return
      // 206: athrow
      // 207: aload 0
      // 208: getstatic x/oc89eb238246.ђ Lx/oc89eb238246;
      // 20b: iload 3
      // 20c: ifne 241
      // 20f: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 212: goto 216
      // 215: athrow
      // 216: ifeq 23d
      // 219: aload 2
      // 21a: getfield x/ocede28e21e9.Ę I
      // 21d: iload 3
      // 21e: ifne 24c
      // 221: goto 225
      // 224: athrow
      // 225: ldc_w 653966920
      // 228: ldc_w 653966923
      // 22b: ixor
      // 22c: if_icmplt 23d
      // 22f: goto 233
      // 232: athrow
      // 233: aload 0
      // 234: aload 1
      // 235: getstatic x/oc89eb238246.ђ Lx/oc89eb238246;
      // 238: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 23b: return
      // 23c: athrow
      // 23d: aload 0
      // 23e: getstatic x/oc89eb238246.ɺ Lx/oc89eb238246;
      // 241: iload 3
      // 242: ifne 3ba
      // 245: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 248: goto 24c
      // 24b: athrow
      // 24c: ifeq 3ae
      // 24f: aload 2
      // 250: iload 3
      // 251: ifne 29b
      // 254: goto 258
      // 257: athrow
      // 258: getfield x/ocede28e21e9.Ǭ I
      // 25b: ldc_w 653966913
      // 25e: ldc_w 653966923
      // 261: ixor
      // 262: if_icmpne 29a
      // 265: goto 269
      // 268: athrow
      // 269: aload 2
      // 26a: iload 3
      // 26b: ifne 29b
      // 26e: goto 272
      // 271: athrow
      // 272: getfield x/ocede28e21e9.ġ Lnet/minecraft/block/Block;
      // 275: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 278: if_acmpne 29a
      // 27b: goto 27f
      // 27e: athrow
      // 27f: aload 2
      // 280: new net/minecraft/util/Vec3
      // 283: dup
      // 284: aload 1
      // 285: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 288: aload 1
      // 289: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 28c: aload 1
      // 28d: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 290: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 293: putfield x/ocede28e21e9.ǔ Lnet/minecraft/util/Vec3;
      // 296: goto 29a
      // 299: athrow
      // 29a: aload 2
      // 29b: getfield x/ocede28e21e9.ǔ Lnet/minecraft/util/Vec3;
      // 29e: ifnull 3ae
      // 2a1: aload 1
      // 2a2: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 2a5: iload 3
      // 2a6: ifne 2c9
      // 2a9: goto 2ad
      // 2ac: athrow
      // 2ad: ifeq 2c1
      // 2b0: goto 2b4
      // 2b3: athrow
      // 2b4: aload 2
      // 2b5: aconst_null
      // 2b6: putfield x/ocede28e21e9.ǔ Lnet/minecraft/util/Vec3;
      // 2b9: iload 3
      // 2ba: ifeq 3ae
      // 2bd: goto 2c1
      // 2c0: athrow
      // 2c1: aload 2
      // 2c2: getfield x/ocede28e21e9.ķ I
      // 2c5: goto 2c9
      // 2c8: athrow
      // 2c9: iload 3
      // 2ca: ifne 3bd
      // 2cd: ifle 3ae
      // 2d0: goto 2d4
      // 2d3: athrow
      // 2d4: aload 2
      // 2d5: getfield x/ocede28e21e9.ķ I
      // 2d8: iload 3
      // 2d9: ifne 3bd
      // 2dc: goto 2e0
      // 2df: athrow
      // 2e0: ldc_w 653966925
      // 2e3: ldc_w 653966923
      // 2e6: ixor
      // 2e7: if_icmpge 3ae
      // 2ea: goto 2ee
      // 2ed: athrow
      // 2ee: aload 2
      // 2ef: getfield x/ocede28e21e9.ġ Lnet/minecraft/block/Block;
      // 2f2: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 2f5: if_acmpeq 3ae
      // 2f8: goto 2fc
      // 2fb: athrow
      // 2fc: aload 1
      // 2fd: iload 3
      // 2fe: ifne 330
      // 301: goto 305
      // 304: athrow
      // 305: invokevirtual net/minecraft/entity/player/EntityPlayer.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 308: ifnull 32b
      // 30b: goto 30f
      // 30e: athrow
      // 30f: aload 1
      // 310: iload 3
      // 311: ifne 330
      // 314: goto 318
      // 317: athrow
      // 318: invokevirtual net/minecraft/entity/player/EntityPlayer.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 31b: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 31e: getstatic net/minecraft/init/Blocks.ladder Lnet/minecraft/block/Block;
      // 321: invokestatic net/minecraft/item/Item.getItemFromBlock (Lnet/minecraft/block/Block;)Lnet/minecraft/item/Item;
      // 324: if_acmpeq 3ae
      // 327: goto 32b
      // 32a: athrow
      // 32b: aload 1
      // 32c: goto 330
      // 32f: athrow
      // 330: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 333: aload 2
      // 334: getfield x/ocede28e21e9.ǔ Lnet/minecraft/util/Vec3;
      // 337: getfield net/minecraft/util/Vec3.xCoord D
      // 33a: dsub
      // 33b: dstore 7
      // 33d: aload 1
      // 33e: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 341: aload 2
      // 342: getfield x/ocede28e21e9.ǔ Lnet/minecraft/util/Vec3;
      // 345: getfield net/minecraft/util/Vec3.zCoord D
      // 348: dsub
      // 349: dstore 9
      // 34b: dload 7
      // 34d: dload 7
      // 34f: dmul
      // 350: dload 9
      // 352: dload 9
      // 354: dmul
      // 355: dadd
      // 356: dstore 11
      // 358: aload 1
      // 359: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 35c: aload 2
      // 35d: getfield x/ocede28e21e9.ǔ Lnet/minecraft/util/Vec3;
      // 360: getfield net/minecraft/util/Vec3.yCoord D
      // 363: dsub
      // 364: dstore 13
      // 366: aload 2
      // 367: aconst_null
      // 368: putfield x/ocede28e21e9.ǔ Lnet/minecraft/util/Vec3;
      // 36b: dload 11
      // 36d: ldc2_w 144.0
      // 370: dcmpg
      // 371: iload 3
      // 372: ifne 3bd
      // 375: ifge 3ae
      // 378: goto 37c
      // 37b: athrow
      // 37c: dload 13
      // 37e: ldc2_w -5.0
      // 381: dcmpg
      // 382: iload 3
      // 383: ifne 3bd
      // 386: goto 38a
      // 389: athrow
      // 38a: ifgt 3ae
      // 38d: goto 391
      // 390: athrow
      // 391: aload 0
      // 392: iload 3
      // 393: ifne 3af
      // 396: goto 39a
      // 399: athrow
      // 39a: invokevirtual x/oc8c951938d3.ƃ ()Z
      // 39d: ifne 3ae
      // 3a0: goto 3a4
      // 3a3: athrow
      // 3a4: aload 0
      // 3a5: aload 1
      // 3a6: getstatic x/oc89eb238246.ɺ Lx/oc89eb238246;
      // 3a9: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 3ac: return
      // 3ad: athrow
      // 3ae: aload 0
      // 3af: iload 3
      // 3b0: ifne 419
      // 3b3: getstatic x/oc89eb238246.Ë Lx/oc89eb238246;
      // 3b6: goto 3ba
      // 3b9: athrow
      // 3ba: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 3bd: ifeq 418
      // 3c0: aload 2
      // 3c1: getfield x/ocede28e21e9.Լ I
      // 3c4: iload 3
      // 3c5: ifne 427
      // 3c8: goto 3cc
      // 3cb: athrow
      // 3cc: ldc_w 653966912
      // 3cf: ldc_w 653966923
      // 3d2: ixor
      // 3d3: if_icmplt 418
      // 3d6: goto 3da
      // 3d9: athrow
      // 3da: aload 2
      // 3db: getfield x/ocede28e21e9.պ D
      // 3de: ldc2_w 0.08
      // 3e1: dcmpl
      // 3e2: iload 3
      // 3e3: ifne 427
      // 3e6: goto 3ea
      // 3e9: athrow
      // 3ea: iflt 418
      // 3ed: goto 3f1
      // 3f0: athrow
      // 3f1: iload 5
      // 3f3: iload 3
      // 3f4: ifne 427
      // 3f7: goto 3fb
      // 3fa: athrow
      // 3fb: aload 2
      // 3fc: getfield x/ocede28e21e9.ų I
      // 3ff: isub
      // 400: ldc_w 653966952
      // 403: ldc_w 653966923
      // 406: ixor
      // 407: if_icmplt 418
      // 40a: goto 40e
      // 40d: athrow
      // 40e: aload 0
      // 40f: aload 1
      // 410: getstatic x/oc89eb238246.Ë Lx/oc89eb238246;
      // 413: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 416: return
      // 417: athrow
      // 418: aload 0
      // 419: getstatic x/oc89eb238246.Ď Lx/oc89eb238246;
      // 41c: iload 3
      // 41d: ifne 51b
      // 420: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 423: goto 427
      // 426: athrow
      // 427: ifeq 517
      // 42a: aload 2
      // 42b: getfield x/ocede28e21e9.ǿ I
      // 42e: iload 3
      // 42f: ifne 51e
      // 432: goto 436
      // 435: athrow
      // 436: ifle 517
      // 439: goto 43d
      // 43c: athrow
      // 43d: iload 5
      // 43f: iload 3
      // 440: ifne 51e
      // 443: goto 447
      // 446: athrow
      // 447: aload 2
      // 448: getfield x/ocede28e21e9.Н I
      // 44b: isub
      // 44c: ldc_w 653966930
      // 44f: ldc_w 653966923
      // 452: ixor
      // 453: if_icmplt 517
      // 456: goto 45a
      // 459: athrow
      // 45a: iload 5
      // 45c: iload 3
      // 45d: ifne 4a7
      // 460: goto 464
      // 463: athrow
      // 464: aload 2
      // 465: getfield x/ocede28e21e9.ʖ I
      // 468: isub
      // 469: ldc_w 653966943
      // 46c: ldc_w 653966923
      // 46f: ixor
      // 470: if_icmpge 491
      // 473: goto 477
      // 476: athrow
      // 477: aload 2
      // 478: getfield x/ocede28e21e9.ǿ I
      // 47b: iload 3
      // 47c: ifne 51e
      // 47f: goto 483
      // 482: athrow
      // 483: ldc_w 653966930
      // 486: ldc_w 653966923
      // 489: ixor
      // 48a: if_icmple 517
      // 48d: goto 491
      // 490: athrow
      // 491: aload 0
      // 492: iload 3
      // 493: ifne 518
      // 496: goto 49a
      // 499: athrow
      // 49a: invokevirtual x/oc8c951938d3.T ()Ljava/lang/String;
      // 49d: ldc_w "BUILD BATTLE"
      // 4a0: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 4a3: goto 4a7
      // 4a6: athrow
      // 4a7: ifne 517
      // 4aa: bipush 1
      // 4ab: istore 7
      // 4ad: aload 1
      // 4ae: invokevirtual net/minecraft/entity/player/EntityPlayer.getPosition ()Lnet/minecraft/util/BlockPos;
      // 4b1: ldc_w 653966921
      // 4b4: ldc_w 653966923
      // 4b7: ixor
      // 4b8: invokevirtual net/minecraft/util/BlockPos.down (I)Lnet/minecraft/util/BlockPos;
      // 4bb: astore 8
      // 4bd: bipush 0
      // 4be: istore 9
      // 4c0: iload 9
      // 4c2: ldc_w 653966927
      // 4c5: ldc_w 653966923
      // 4c8: ixor
      // 4c9: if_icmpge 500
      // 4cc: iload 3
      // 4cd: ifne 517
      // 4d0: aload 8
      // 4d2: iload 3
      // 4d3: ifne 4f7
      // 4d6: goto 4da
      // 4d9: athrow
      // 4da: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 4dd: instanceof net/minecraft/block/BlockAir
      // 4e0: ifne 4ee
      // 4e3: goto 4e7
      // 4e6: athrow
      // 4e7: bipush 0
      // 4e8: istore 7
      // 4ea: iload 3
      // 4eb: ifeq 500
      // 4ee: aload 8
      // 4f0: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 4f3: goto 4f7
      // 4f6: athrow
      // 4f7: astore 8
      // 4f9: iload 3
      // 4fa: iinc 9 1
      // 4fd: ifeq 4c0
      // 500: iload 7
      // 502: iload 3
      // 503: ifne 51e
      // 506: ifeq 517
      // 509: goto 50d
      // 50c: athrow
      // 50d: aload 0
      // 50e: aload 1
      // 50f: getstatic x/oc89eb238246.Ď Lx/oc89eb238246;
      // 512: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 515: return
      // 516: athrow
      // 517: aload 0
      // 518: getstatic x/oc89eb238246.ч Lx/oc89eb238246;
      // 51b: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 51e: iload 3
      // 51f: ifne 538
      // 522: ifeq 547
      // 525: goto 529
      // 528: athrow
      // 529: aload 1
      // 52a: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 52d: invokestatic java/lang/Math.abs (F)F
      // 530: ldc_w 92.0
      // 533: fcmpl
      // 534: goto 538
      // 537: athrow
      // 538: iflt 547
      // 53b: aload 0
      // 53c: aload 1
      // 53d: getstatic x/oc89eb238246.ч Lx/oc89eb238246;
      // 540: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 543: goto 547
      // 546: athrow
      // 547: return
   }

   @oc66fa4f2195
   public void g(oc25aa89b91f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc89eb238246.ħ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 016
      // 009: invokevirtual x/oc8c951938d3.Ϟ ()Z
      // 00c: ifne 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: iload 2
      // 017: ifne 04c
      // 01a: getfield x/oc8c951938d3.Ա Ljava/lang/String;
      // 01d: ifnull 047
      // 020: goto 024
      // 023: athrow
      // 024: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 027: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02a: aload 0
      // 02b: getfield x/oc8c951938d3.Ա Ljava/lang/String;
      // 02e: ldc_w "/pc "
      // 031: swap
      // 032: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 037: invokevirtual net/minecraft/client/entity/EntityPlayerSP.sendChatMessage (Ljava/lang/String;)V
      // 03a: iload 2
      // 03b: aload 0
      // 03c: aconst_null
      // 03d: putfield x/oc8c951938d3.Ա Ljava/lang/String;
      // 040: ifeq 07c
      // 043: goto 047
      // 046: athrow
      // 047: aload 0
      // 048: goto 04c
      // 04b: athrow
      // 04c: iload 2
      // 04d: ifne 07d
      // 050: getfield x/oc8c951938d3.Ӣ Ljava/lang/String;
      // 053: ifnull 07c
      // 056: goto 05a
      // 059: athrow
      // 05a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 060: aload 0
      // 061: getfield x/oc8c951938d3.Ӣ Ljava/lang/String;
      // 064: ldc_w "/report "
      // 067: swap
      // 068: ldc_w " cheating"
      // 06b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 070: invokevirtual net/minecraft/client/entity/EntityPlayerSP.sendChatMessage (Ljava/lang/String;)V
      // 073: aload 0
      // 074: aconst_null
      // 075: putfield x/oc8c951938d3.Ӣ Ljava/lang/String;
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 0
      // 07d: invokevirtual x/oc8c951938d3.Կ ()V
      // 080: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 083: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 086: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 089: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 08e: astore 3
      // 08f: aload 3
      // 090: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 095: ifeq 109
      // 098: aload 3
      // 099: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 09e: checkcast net/minecraft/entity/player/EntityPlayer
      // 0a1: astore 4
      // 0a3: aload 0
      // 0a4: iload 2
      // 0a5: ifne 0c4
      // 0a8: aload 4
      // 0aa: invokevirtual x/oc8c951938d3.Ӛ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 0ad: ifeq 0b8
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: goto 08f
      // 0b7: athrow
      // 0b8: aload 0
      // 0b9: getfield x/oc8c951938d3.Ɖ Ljava/util/HashMap;
      // 0bc: aload 4
      // 0be: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 0c1: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0c4: checkcast x/ocede28e21e9
      // 0c7: astore 5
      // 0c9: iload 2
      // 0ca: ifne 105
      // 0cd: aload 5
      // 0cf: ifnonnull 0e0
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: new x/ocede28e21e9
      // 0d9: dup
      // 0da: aload 0
      // 0db: invokespecial x/ocede28e21e9.<init> (Lx/oc8c951938d3;)V
      // 0de: astore 5
      // 0e0: aload 5
      // 0e2: aload 4
      // 0e4: invokevirtual x/ocede28e21e9.ւ (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 0e7: aload 0
      // 0e8: aload 4
      // 0ea: aload 5
      // 0ec: invokevirtual x/oc8c951938d3.ϩ (Lnet/minecraft/entity/player/EntityPlayer;Lx/ocede28e21e9;)V
      // 0ef: aload 5
      // 0f1: aload 4
      // 0f3: invokevirtual x/ocede28e21e9.ϫ (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 0f6: aload 0
      // 0f7: getfield x/oc8c951938d3.Ɖ Ljava/util/HashMap;
      // 0fa: aload 4
      // 0fc: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 0ff: aload 5
      // 101: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 104: pop
      // 105: iload 2
      // 106: ifeq 08f
      // 109: return
   }

   @Override
   public void onDisable() {
      this.ӏ.clear();
      this.ȕ = 0L;
      this.Ɖ.clear();
      this.Ȓ.clear();
      this.Ƅ.clear();
      this.ƃ.clear();
      this.ǟ.clear();
      this.Ա = null;
      this.Ӣ = null;
      this.Ҩ = 0L;
   }

   private boolean Ӛ(EntityPlayer param1) {
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
      // 06: ifne 1b
      // 09: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f: if_acmpeq 4f
      // 12: goto 16
      // 15: athrow
      // 16: aload 1
      // 17: goto 1b
      // 1a: athrow
      // 1b: getfield net/minecraft/entity/player/EntityPlayer.isDead Z
      // 1e: iload 2
      // 1f: ifne 50
      // 22: ifne 4f
      // 25: goto 29
      // 28: athrow
      // 29: aload 1
      // 2a: getfield net/minecraft/entity/player/EntityPlayer.deathTime I
      // 2d: iload 2
      // 2e: ifne 50
      // 31: goto 35
      // 34: athrow
      // 35: ifne 4f
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 1
      // 3d: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 40: iload 2
      // 41: ifne 50
      // 44: goto 48
      // 47: athrow
      // 48: ifeq 53
      // 4b: goto 4f
      // 4e: athrow
      // 4f: bipush 1
      // 50: goto 54
      // 53: bipush 0
      // 54: ireturn
   }

   @oc66fa4f2195
   public void Ĵ(ocadfd5cc157 var1) {
      try {
         if (var1.Ц == oc69da1aa7f5.ő.thePlayer) {
            this.onDisable();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   private boolean Ϟ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 1
      // 08: ifne 1c
      // 0b: ifeq 61
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: invokevirtual net/minecraft/client/Minecraft.isSingleplayer ()Z
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 1
      // 1d: ifne 32
      // 20: ifne 61
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: getfield x/oc8c951938d3.ӂ Lx/occ2f8dff8d8;
      // 2b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2e: goto 32
      // 31: athrow
      // 32: iload 1
      // 33: ifne 5e
      // 36: ifeq 5d
      // 39: goto 3d
      // 3c: athrow
      // 3d: invokestatic x/oc7ab2161b9f.Տ ()Z
      // 40: iload 1
      // 41: ifne 52
      // 44: goto 48
      // 47: athrow
      // 48: ifeq 61
      // 4b: goto 4f
      // 4e: athrow
      // 4f: invokestatic x/oc7ab2161b9f.ս ()Z
      // 52: iload 1
      // 53: ifne 5e
      // 56: ifne 61
      // 59: goto 5d
      // 5c: athrow
      // 5d: bipush 1
      // 5e: goto 62
      // 61: bipush 0
      // 62: ireturn
   }

   @oc66fa4f2195
   public void Π(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc89eb238246.ħ I
      // 003: aload 1
      // 004: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 0
      // 00a: invokestatic java/lang/System.currentTimeMillis ()J
      // 00d: putfield x/oc8c951938d3.ȕ J
      // 010: aload 0
      // 011: invokevirtual x/oc8c951938d3.Ϟ ()Z
      // 014: iload 2
      // 015: ifne 02c
      // 018: ifne 020
      // 01b: goto 01f
      // 01e: athrow
      // 01f: return
      // 020: aload 3
      // 021: iload 2
      // 022: ifne 0a9
      // 025: instanceof net/minecraft/network/play/server/S25PacketBlockBreakAnim
      // 028: goto 02c
      // 02b: athrow
      // 02c: ifeq 0a8
      // 02f: aload 0
      // 030: getstatic x/oc89eb238246.ȶ Lx/oc89eb238246;
      // 033: iload 2
      // 034: ifne 04d
      // 037: goto 03b
      // 03a: athrow
      // 03b: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 03e: ifne 05b
      // 041: goto 045
      // 044: athrow
      // 045: aload 0
      // 046: getstatic x/oc89eb238246.ʩ Lx/oc89eb238246;
      // 049: goto 04d
      // 04c: athrow
      // 04d: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 050: iload 2
      // 051: ifne 0b4
      // 054: ifeq 0a8
      // 057: goto 05b
      // 05a: athrow
      // 05b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 061: aload 3
      // 062: checkcast net/minecraft/network/play/server/S25PacketBlockBreakAnim
      // 065: invokevirtual net/minecraft/network/play/server/S25PacketBlockBreakAnim.getBreakerId ()I
      // 068: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntityByID (I)Lnet/minecraft/entity/Entity;
      // 06b: dup
      // 06c: astore 4
      // 06e: instanceof net/minecraft/entity/player/EntityPlayer
      // 071: iload 2
      // 072: ifne 0b4
      // 075: ifeq 0a8
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 0
      // 07d: getfield x/oc8c951938d3.Ɖ Ljava/util/HashMap;
      // 080: aload 4
      // 082: invokevirtual net/minecraft/entity/Entity.getUniqueID ()Ljava/util/UUID;
      // 085: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 088: checkcast x/ocede28e21e9
      // 08b: astore 5
      // 08d: aload 5
      // 08f: iload 2
      // 090: ifne 09c
      // 093: ifnull 0a8
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 5
      // 09c: aload 4
      // 09e: checkcast net/minecraft/entity/player/EntityPlayer
      // 0a1: aload 3
      // 0a2: checkcast net/minecraft/network/play/server/S25PacketBlockBreakAnim
      // 0a5: invokevirtual x/ocede28e21e9.ү (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/network/play/server/S25PacketBlockBreakAnim;)V
      // 0a8: aload 3
      // 0a9: iload 2
      // 0aa: ifne 2d3
      // 0ad: instanceof net/minecraft/network/play/server/S23PacketBlockChange
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: ifeq 2ce
      // 0b7: aload 3
      // 0b8: checkcast net/minecraft/network/play/server/S23PacketBlockChange
      // 0bb: astore 5
      // 0bd: aload 5
      // 0bf: iload 2
      // 0c0: ifne 0db
      // 0c3: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 0c6: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0cb: instanceof net/minecraft/block/BlockAir
      // 0ce: ifeq 2ca
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 5
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockPosition ()Lnet/minecraft/util/BlockPos;
      // 0de: astore 6
      // 0e0: aload 6
      // 0e2: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 0e5: astore 7
      // 0e7: aload 7
      // 0e9: iload 2
      // 0ea: ifne 0fd
      // 0ed: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 0f0: if_acmpeq 13f
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 7
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: iload 2
      // 0fe: ifne 111
      // 101: getstatic net/minecraft/init/Blocks.bed Lnet/minecraft/block/Block;
      // 104: if_acmpeq 13f
      // 107: goto 10b
      // 10a: athrow
      // 10b: aload 7
      // 10d: goto 111
      // 110: athrow
      // 111: iload 2
      // 112: ifne 125
      // 115: getstatic net/minecraft/init/Blocks.ladder Lnet/minecraft/block/Block;
      // 118: if_acmpeq 13f
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 7
      // 121: goto 125
      // 124: athrow
      // 125: iload 2
      // 126: ifne 139
      // 129: instanceof net/minecraft/block/BlockBush
      // 12c: ifne 13f
      // 12f: goto 133
      // 132: athrow
      // 133: aload 7
      // 135: goto 139
      // 138: athrow
      // 139: instanceof net/minecraft/block/BlockLeaves
      // 13c: ifeq 141
      // 13f: return
      // 140: athrow
      // 141: aconst_null
      // 142: astore 8
      // 144: aload 0
      // 145: getfield x/oc8c951938d3.ƃ Ljava/util/HashMap;
      // 148: aload 6
      // 14a: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 14d: checkcast net/minecraft/network/play/server/S25PacketBlockBreakAnim
      // 150: astore 9
      // 152: aload 9
      // 154: ifnull 1cb
      // 157: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 15d: aload 9
      // 15f: invokevirtual net/minecraft/network/play/server/S25PacketBlockBreakAnim.getBreakerId ()I
      // 162: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntityByID (I)Lnet/minecraft/entity/Entity;
      // 165: astore 10
      // 167: aload 10
      // 169: iload 2
      // 16a: ifne 17d
      // 16d: instanceof net/minecraft/entity/player/EntityPlayer
      // 170: ifeq 1c1
      // 173: goto 177
      // 176: athrow
      // 177: aload 10
      // 179: goto 17d
      // 17c: athrow
      // 17d: checkcast net/minecraft/entity/player/EntityPlayer
      // 180: astore 8
      // 182: aload 9
      // 184: iload 2
      // 185: ifne 1ca
      // 188: invokevirtual net/minecraft/network/play/server/S25PacketBlockBreakAnim.getProgress ()I
      // 18b: ldc_w -875392182
      // 18e: ldc_w -875392178
      // 191: ixor
      // 192: if_icmple 1c1
      // 195: goto 199
      // 198: athrow
      // 199: aload 9
      // 19b: iload 2
      // 19c: ifne 1ca
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: invokevirtual net/minecraft/network/play/server/S25PacketBlockBreakAnim.getProgress ()I
      // 1a6: ldc_w -875392188
      // 1a9: ldc_w -875392178
      // 1ac: ixor
      // 1ad: if_icmpge 1c1
      // 1b0: goto 1b4
      // 1b3: athrow
      // 1b4: aload 0
      // 1b5: aload 8
      // 1b7: getstatic x/oc89eb238246.ʩ Lx/oc89eb238246;
      // 1ba: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: aload 0
      // 1c2: getfield x/oc8c951938d3.ƃ Ljava/util/HashMap;
      // 1c5: aload 6
      // 1c7: invokevirtual java/util/HashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 1ca: pop
      // 1cb: aload 0
      // 1cc: iload 2
      // 1cd: ifne 1e2
      // 1d0: getstatic x/oc89eb238246.р Lx/oc89eb238246;
      // 1d3: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 1d6: ifeq 2ca
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: aload 0
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: aload 6
      // 1e4: invokevirtual x/oc8c951938d3.Ԉ (Lnet/minecraft/util/BlockPos;)Z
      // 1e7: ifeq 1ec
      // 1ea: return
      // 1eb: athrow
      // 1ec: ldc2_w -1.0
      // 1ef: dstore 10
      // 1f1: aload 8
      // 1f3: iload 2
      // 1f4: ifne 2ba
      // 1f7: ifnonnull 2b8
      // 1fa: goto 1fe
      // 1fd: athrow
      // 1fe: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 201: iload 2
      // 202: ifne 213
      // 205: goto 209
      // 208: athrow
      // 209: ifnull 23f
      // 20c: goto 210
      // 20f: athrow
      // 210: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 213: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 216: iload 2
      // 217: ifne 23c
      // 21a: ifeq 23f
      // 21d: goto 221
      // 220: athrow
      // 221: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 224: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 227: iload 2
      // 228: ifne 2ba
      // 22b: goto 22f
      // 22e: athrow
      // 22f: aload 6
      // 231: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSq (Lnet/minecraft/util/BlockPos;)D
      // 234: ldc2_w 36.0
      // 237: dcmpg
      // 238: goto 23c
      // 23b: athrow
      // 23c: ifle 2b8
      // 23f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 242: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 245: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 248: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 24d: astore 12
      // 24f: aload 12
      // 251: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 256: ifeq 2b8
      // 259: aload 12
      // 25b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 260: checkcast net/minecraft/entity/player/EntityPlayer
      // 263: iload 2
      // 264: ifne 2ba
      // 267: goto 26b
      // 26a: athrow
      // 26b: astore 13
      // 26d: aload 0
      // 26e: aload 13
      // 270: invokevirtual x/oc8c951938d3.Ӛ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 273: ifeq 27a
      // 276: goto 24f
      // 279: athrow
      // 27a: aload 13
      // 27c: aload 6
      // 27e: invokevirtual net/minecraft/entity/player/EntityPlayer.getDistanceSq (Lnet/minecraft/util/BlockPos;)D
      // 281: dstore 14
      // 283: iload 2
      // 284: ifne 2b4
      // 287: dload 10
      // 289: ldc2_w -1.0
      // 28c: dcmpl
      // 28d: ifeq 2ac
      // 290: goto 294
      // 293: athrow
      // 294: dload 14
      // 296: iload 2
      // 297: ifne 2ae
      // 29a: goto 29e
      // 29d: athrow
      // 29e: dload 10
      // 2a0: dcmpg
      // 2a1: iflt 2ac
      // 2a4: goto 2a8
      // 2a7: athrow
      // 2a8: goto 24f
      // 2ab: athrow
      // 2ac: dload 14
      // 2ae: dstore 10
      // 2b0: aload 13
      // 2b2: astore 8
      // 2b4: iload 2
      // 2b5: ifeq 24f
      // 2b8: aload 8
      // 2ba: ifnull 2ca
      // 2bd: aload 0
      // 2be: aload 8
      // 2c0: getstatic x/oc89eb238246.р Lx/oc89eb238246;
      // 2c3: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 2c6: goto 2ca
      // 2c9: athrow
      // 2ca: iload 2
      // 2cb: ifeq 463
      // 2ce: aload 3
      // 2cf: goto 2d3
      // 2d2: athrow
      // 2d3: instanceof net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 2d6: iload 2
      // 2d7: ifne 2ec
      // 2da: ifeq 463
      // 2dd: goto 2e1
      // 2e0: athrow
      // 2e1: aload 0
      // 2e2: getstatic x/oc89eb238246.р Lx/oc89eb238246;
      // 2e5: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 2e8: goto 2ec
      // 2eb: athrow
      // 2ec: ifeq 463
      // 2ef: aload 3
      // 2f0: checkcast net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 2f3: astore 5
      // 2f5: aload 5
      // 2f7: iload 2
      // 2f8: ifne 311
      // 2fb: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange.getChangedBlocks ()[Lnet/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData;
      // 2fe: arraylength
      // 2ff: ldc_w -875392180
      // 302: ldc_w -875392178
      // 305: ixor
      // 306: if_icmpeq 30f
      // 309: goto 30d
      // 30c: athrow
      // 30d: return
      // 30e: athrow
      // 30f: aload 5
      // 311: iload 2
      // 312: ifne 330
      // 315: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange.getChangedBlocks ()[Lnet/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData;
      // 318: bipush 0
      // 319: aaload
      // 31a: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 31d: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 322: instanceof net/minecraft/block/BlockAir
      // 325: ifne 32e
      // 328: goto 32c
      // 32b: athrow
      // 32c: return
      // 32d: athrow
      // 32e: aload 5
      // 330: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange.getChangedBlocks ()[Lnet/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData;
      // 333: bipush 0
      // 334: aaload
      // 335: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getPos ()Lnet/minecraft/util/BlockPos;
      // 338: astore 6
      // 33a: aload 5
      // 33c: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange.getChangedBlocks ()[Lnet/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData;
      // 33f: bipush 1
      // 340: aaload
      // 341: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getPos ()Lnet/minecraft/util/BlockPos;
      // 344: astore 7
      // 346: aload 0
      // 347: aload 6
      // 349: iload 2
      // 34a: ifne 35e
      // 34d: invokevirtual x/oc8c951938d3.Ԉ (Lnet/minecraft/util/BlockPos;)Z
      // 350: ifne 364
      // 353: goto 357
      // 356: athrow
      // 357: aload 0
      // 358: aload 7
      // 35a: goto 35e
      // 35d: athrow
      // 35e: invokevirtual x/oc8c951938d3.Ԉ (Lnet/minecraft/util/BlockPos;)Z
      // 361: ifeq 366
      // 364: return
      // 365: athrow
      // 366: aconst_null
      // 367: astore 8
      // 369: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 36c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 36f: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 372: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 377: astore 9
      // 379: aload 9
      // 37b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 380: ifeq 451
      // 383: aload 9
      // 385: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 38a: checkcast net/minecraft/entity/player/EntityPlayer
      // 38d: astore 10
      // 38f: iload 2
      // 390: ifne 463
      // 393: aload 10
      // 395: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 398: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 39b: if_acmpne 401
      // 39e: goto 3a2
      // 3a1: athrow
      // 3a2: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 3a5: iload 2
      // 3a6: ifne 3b7
      // 3a9: goto 3ad
      // 3ac: athrow
      // 3ad: ifnull 401
      // 3b0: goto 3b4
      // 3b3: athrow
      // 3b4: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 3b7: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 3ba: iload 2
      // 3bb: ifne 40b
      // 3be: ifeq 401
      // 3c1: goto 3c5
      // 3c4: athrow
      // 3c5: aload 10
      // 3c7: iload 2
      // 3c8: ifne 3e5
      // 3cb: goto 3cf
      // 3ce: athrow
      // 3cf: aload 6
      // 3d1: invokevirtual net/minecraft/entity/player/EntityPlayer.getDistanceSq (Lnet/minecraft/util/BlockPos;)D
      // 3d4: ldc2_w 36.0
      // 3d7: dcmpg
      // 3d8: ifle 451
      // 3db: goto 3df
      // 3de: athrow
      // 3df: aload 10
      // 3e1: goto 3e5
      // 3e4: athrow
      // 3e5: aload 7
      // 3e7: invokevirtual net/minecraft/entity/player/EntityPlayer.getDistanceSq (Lnet/minecraft/util/BlockPos;)D
      // 3ea: ldc2_w 36.0
      // 3ed: dcmpg
      // 3ee: iload 2
      // 3ef: ifne 40b
      // 3f2: ifgt 401
      // 3f5: goto 3f9
      // 3f8: athrow
      // 3f9: iload 2
      // 3fa: ifeq 451
      // 3fd: goto 401
      // 400: athrow
      // 401: aload 0
      // 402: aload 10
      // 404: invokevirtual x/oc8c951938d3.Ӛ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 407: goto 40b
      // 40a: athrow
      // 40b: iload 2
      // 40c: ifne 429
      // 40f: ifne 379
      // 412: goto 416
      // 415: athrow
      // 416: aload 10
      // 418: iload 2
      // 419: ifne 44c
      // 41c: aload 6
      // 41e: invokevirtual net/minecraft/entity/player/EntityPlayer.getDistanceSq (Lnet/minecraft/util/BlockPos;)D
      // 421: ldc2_w 36.0
      // 424: dcmpl
      // 425: goto 429
      // 428: athrow
      // 429: ifle 44a
      // 42c: aload 10
      // 42e: iload 2
      // 42f: ifne 44c
      // 432: goto 436
      // 435: athrow
      // 436: aload 7
      // 438: invokevirtual net/minecraft/entity/player/EntityPlayer.getDistanceSq (Lnet/minecraft/util/BlockPos;)D
      // 43b: ldc2_w 36.0
      // 43e: dcmpl
      // 43f: ifle 44a
      // 442: goto 446
      // 445: athrow
      // 446: goto 379
      // 449: athrow
      // 44a: aload 10
      // 44c: astore 8
      // 44e: goto 451
      // 451: aload 8
      // 453: ifnull 463
      // 456: aload 0
      // 457: aload 8
      // 459: getstatic x/oc89eb238246.ͳ Lx/oc89eb238246;
      // 45c: invokevirtual x/oc8c951938d3.ӕ (Lnet/minecraft/entity/player/EntityPlayer;Lx/oc89eb238246;)V
      // 45f: goto 463
      // 462: athrow
      // 463: return
   }

   private void ӕ(EntityPlayer param1, oc89eb238246 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc89eb238246.ħ I
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 019
      // 009: aload 2
      // 00a: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 00d: ifeq 064
      // 010: goto 014
      // 013: athrow
      // 014: aload 0
      // 015: goto 019
      // 018: athrow
      // 019: aload 1
      // 01a: invokevirtual x/oc8c951938d3.Ӛ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 01d: iload 3
      // 01e: ifne 030
      // 021: ifne 064
      // 024: goto 028
      // 027: athrow
      // 028: aload 1
      // 029: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 02c: goto 030
      // 02f: athrow
      // 030: iload 3
      // 031: ifne 04e
      // 034: ifne 064
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: getfield x/oc8c951938d3.Ƞ Lx/occ2f8dff8d8;
      // 03f: iload 3
      // 040: ifne 06e
      // 043: goto 047
      // 046: athrow
      // 047: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 04a: goto 04e
      // 04d: athrow
      // 04e: ifeq 065
      // 051: aload 1
      // 052: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 055: iload 3
      // 056: ifne 071
      // 059: goto 05d
      // 05c: athrow
      // 05d: ifeq 065
      // 060: goto 064
      // 063: athrow
      // 064: return
      // 065: aload 0
      // 066: aload 1
      // 067: invokevirtual x/oc8c951938d3.Ų (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 06a: aload 0
      // 06b: getfield x/oc8c951938d3.ş Lx/occ2f8dff8d8;
      // 06e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 071: iload 3
      // 072: ifne 087
      // 075: ifeq 088
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 1
      // 07d: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // 080: invokestatic x/oc7ab2161b9f.ԓ (Ljava/lang/String;)Z
      // 083: goto 087
      // 086: athrow
      // 087: pop
      // 088: invokestatic java/lang/System.currentTimeMillis ()J
      // 08b: lstore 4
      // 08d: aload 0
      // 08e: getfield x/oc8c951938d3.Ȓ Ljava/util/HashMap;
      // 091: aload 1
      // 092: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 095: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc8c951938d3.qhb8xfbohmmx3 (Ljava/util/UUID;)Ljava/util/HashMap;, (Ljava/util/UUID;)Ljava/util/HashMap; ]
      // 09a: invokevirtual java/util/HashMap.computeIfAbsent (Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;
      // 09d: checkcast java/util/HashMap
      // 0a0: astore 6
      // 0a2: aload 6
      // 0a4: aload 2
      // 0a5: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0a8: checkcast java/lang/Long
      // 0ab: astore 7
      // 0ad: aload 0
      // 0ae: iload 3
      // 0af: ifne 102
      // 0b2: getfield x/oc8c951938d3.ɐ Lx/oca9cc61aada;
      // 0b5: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b8: dconst_0
      // 0b9: dcmpl
      // 0ba: ifle 0f7
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: aload 7
      // 0c3: iload 3
      // 0c4: ifne 102
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: ifnull 0f7
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: lload 4
      // 0d4: aload 7
      // 0d6: invokevirtual java/lang/Long.longValue ()J
      // 0d9: lsub
      // 0da: l2d
      // 0db: aload 0
      // 0dc: getfield x/oc8c951938d3.ɐ Lx/oca9cc61aada;
      // 0df: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0e2: ldc2_w 1000.0
      // 0e5: dmul
      // 0e6: dcmpg
      // 0e7: iload 3
      // 0e8: ifne 106
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: ifgt 0f7
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: return
      // 0f7: aload 6
      // 0f9: aload 2
      // 0fa: lload 4
      // 0fc: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0ff: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 102: pop
      // 103: invokestatic x/oc7ab2161b9f.Տ ()Z
      // 106: istore 8
      // 108: aload 1
      // 109: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // 10c: astore 9
      // 10e: iload 8
      // 110: iload 3
      // 111: ifne 126
      // 114: ifeq 158
      // 117: goto 11b
      // 11a: athrow
      // 11b: aload 0
      // 11c: getfield x/oc8c951938d3.Ӎ Lx/occ2f8dff8d8;
      // 11f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 122: goto 126
      // 125: athrow
      // 126: ifeq 158
      // 129: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12c: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 12f: ifnonnull 158
      // 132: goto 136
      // 135: athrow
      // 136: aload 0
      // 137: iload 3
      // 138: ifne 153
      // 13b: goto 13f
      // 13e: athrow
      // 13f: getfield x/oc8c951938d3.ǟ Ljava/util/HashSet;
      // 142: aload 9
      // 144: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 147: ifeq 158
      // 14a: goto 14e
      // 14d: athrow
      // 14e: aload 0
      // 14f: goto 153
      // 152: athrow
      // 153: aload 9
      // 155: putfield x/oc8c951938d3.Ӣ Ljava/lang/String;
      // 158: aload 1
      // 159: invokevirtual net/minecraft/entity/player/EntityPlayer.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 15c: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 161: aload 2
      // 162: getfield x/oc89eb238246.Š Ljava/lang/String;
      // 165: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 168: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16b: aload 1
      // 16c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // 16f: f2d
      // 170: bipush 1
      // 171: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 174: dstore 13
      // 176: astore 15
      // 178: ldc_w " &7detected for &d"
      // 17b: aload 15
      // 17d: ldc_w " &7("
      // 180: dload 13
      // 182: ldc_w "m)"
      // 185: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001\u0001" ]
      // 18a: astore 10
      // 18c: new net/minecraft/util/ChatComponentText
      // 18f: dup
      // 190: aload 10
      // 192: ldc_w "&8[&5AntiCheat&8]&r "
      // 195: swap
      // 196: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 19b: invokestatic x/oc7ab2161b9f.Ĭ (Ljava/lang/String;)Ljava/lang/String;
      // 19e: invokespecial net/minecraft/util/ChatComponentText.<init> (Ljava/lang/String;)V
      // 1a1: astore 11
      // 1a3: iload 8
      // 1a5: iload 3
      // 1a6: ifne 1e5
      // 1a9: ifeq 1d6
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: aload 0
      // 1b1: iload 3
      // 1b2: ifne 1d7
      // 1b5: goto 1b9
      // 1b8: athrow
      // 1b9: getfield x/oc8c951938d3.ɶ Lx/occ2f8dff8d8;
      // 1bc: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1bf: ifeq 1d6
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: aload 0
      // 1c7: aload 11
      // 1c9: invokevirtual net/minecraft/util/ChatComponentText.getUnformattedText ()Ljava/lang/String;
      // 1cc: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 1cf: putfield x/oc8c951938d3.Ա Ljava/lang/String;
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: aload 0
      // 1d7: iload 3
      // 1d8: ifne 261
      // 1db: getfield x/oc8c951938d3.ά Lx/occ2f8dff8d8;
      // 1de: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1e1: goto 1e5
      // 1e4: athrow
      // 1e5: ifne 260
      // 1e8: iload 8
      // 1ea: ifeq 255
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: new net/minecraft/util/ChatStyle
      // 1f4: dup
      // 1f5: invokespecial net/minecraft/util/ChatStyle.<init> ()V
      // 1f8: astore 12
      // 1fa: aload 12
      // 1fc: new net/minecraft/event/HoverEvent
      // 1ff: dup
      // 200: getstatic net/minecraft/event/HoverEvent$Action.SHOW_TEXT Lnet/minecraft/event/HoverEvent$Action;
      // 203: new net/minecraft/util/ChatComponentText
      // 206: dup
      // 207: aload 9
      // 209: ldc_w "/report "
      // 20c: swap
      // 20d: ldc_w " cheating"
      // 210: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 215: invokespecial net/minecraft/util/ChatComponentText.<init> (Ljava/lang/String;)V
      // 218: invokespecial net/minecraft/event/HoverEvent.<init> (Lnet/minecraft/event/HoverEvent$Action;Lnet/minecraft/util/IChatComponent;)V
      // 21b: invokevirtual net/minecraft/util/ChatStyle.setChatHoverEvent (Lnet/minecraft/event/HoverEvent;)Lnet/minecraft/util/ChatStyle;
      // 21e: pop
      // 21f: aload 12
      // 221: new net/minecraft/event/ClickEvent
      // 224: dup
      // 225: getstatic net/minecraft/event/ClickEvent$Action.RUN_COMMAND Lnet/minecraft/event/ClickEvent$Action;
      // 228: aload 9
      // 22a: ldc_w "/report "
      // 22d: swap
      // 22e: ldc_w " cheating"
      // 231: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 236: invokespecial net/minecraft/event/ClickEvent.<init> (Lnet/minecraft/event/ClickEvent$Action;Ljava/lang/String;)V
      // 239: invokevirtual net/minecraft/util/ChatStyle.setChatClickEvent (Lnet/minecraft/event/ClickEvent;)Lnet/minecraft/util/ChatStyle;
      // 23c: pop
      // 23d: aload 11
      // 23f: new net/minecraft/util/ChatComponentText
      // 242: dup
      // 243: ldc_w " &7[&cWDR&7]"
      // 246: invokestatic x/oc7ab2161b9f.Ĭ (Ljava/lang/String;)Ljava/lang/String;
      // 249: invokespecial net/minecraft/util/ChatComponentText.<init> (Ljava/lang/String;)V
      // 24c: aload 12
      // 24e: invokevirtual net/minecraft/util/ChatComponentText.setChatStyle (Lnet/minecraft/util/ChatStyle;)Lnet/minecraft/util/IChatComponent;
      // 251: invokevirtual net/minecraft/util/ChatComponentText.appendSibling (Lnet/minecraft/util/IChatComponent;)Lnet/minecraft/util/IChatComponent;
      // 254: pop
      // 255: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 258: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 25b: aload 11
      // 25d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.addChatMessage (Lnet/minecraft/util/IChatComponent;)V
      // 260: aload 0
      // 261: iload 3
      // 262: ifne 2a1
      // 265: getfield x/oc8c951938d3.ʤ Lx/occ2f8dff8d8;
      // 268: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 26b: ifeq 2a0
      // 26e: goto 272
      // 271: athrow
      // 272: lload 4
      // 274: aload 0
      // 275: getfield x/oc8c951938d3.Ҩ J
      // 278: lsub
      // 279: ldc2_w 284061028493126908
      // 27c: ldc2_w 284061028493125920
      // 27f: lxor
      // 280: lcmp
      // 281: ifle 2a0
      // 284: goto 288
      // 287: athrow
      // 288: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 28b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 28e: ldc_w "note.pling"
      // 291: fconst_1
      // 292: fconst_1
      // 293: invokevirtual net/minecraft/client/entity/EntityPlayerSP.playSound (Ljava/lang/String;FF)V
      // 296: aload 0
      // 297: lload 4
      // 299: putfield x/oc8c951938d3.Ҩ J
      // 29c: goto 2a0
      // 29f: athrow
      // 2a0: aload 0
      // 2a1: aload 2
      // 2a2: getfield x/oc89eb238246.Š Ljava/lang/String;
      // 2a5: aload 1
      // 2a6: invokevirtual x/oc8c951938d3.u (Ljava/lang/String;Lnet/minecraft/entity/Entity;)V
      // 2a9: return
   }

   public void Ų(EntityPlayer var1) {
      this.ӏ.add(var1.getName());
   }

   public boolean ȩ(EntityPlayer param1) {
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
      // 05: ifnull 26
      // 08: aload 0
      // 09: getfield x/oc8c951938d3.ӏ Ljava/util/HashSet;
      // 0c: aload 1
      // 0d: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // 10: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // 13: iload 2
      // 14: ifne 23
      // 17: goto 1b
      // 1a: athrow
      // 1b: ifeq 26
      // 1e: goto 22
      // 21: athrow
      // 22: bipush 1
      // 23: goto 27
      // 26: bipush 0
      // 27: ireturn
   }

   public void Կ() {
      int var1 = oc89eb238246.ħ;

      try {
         if (!oc7ab2161b9f.Ð()) {
            this.onDisable();
            return;
         }
      } catch (ocbde1165e4e var6) {
         throw var6;
      }

      HashSet var2 = new HashSet();
      Iterator var3 = oc69da1aa7f5.ő.theWorld.playerEntities.iterator();

      Object var10000;
      while (true) {
         if (var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();

            try {
               var10000 = var2;
               if (var1 != 0) {
                  break;
               }

               var2.add(var4.getUniqueID());
               if (var1 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var5) {
               throw var5;
            }
         }

         this.Ɖ.keySet().retainAll(var2);
         this.Ȓ.keySet().retainAll(var2);
         this.Ƅ.keySet().retainAll(var2);
         var10000 = this.ƃ.entrySet();
         break;
      }

      var10000.removeIf(var0 -> {
         try {
            if (oc69da1aa7f5.ő.theWorld.getEntityByID(((S25PacketBlockBreakAnim)var0.getValue()).getBreakerId()) == null) {
               return true;
            }
         } catch (ocbde1165e4e var1x) {
            throw var1x;
         }

         return false;
      });
   }

   public void u(String var1, Entity var2) {
      ocea775c9d5c.ų.post(new oc227cab88a2(var1, var2));
   }

   private boolean Ѣ(ItemStack var1) {
      int var2 = oc89eb238246.ħ;

      ItemStack var10000;
      label33: {
         try {
            var10000 = var1;
            if (var2 != 0) {
               break label33;
            }

            if (var1 == null) {
               return false;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         var10000 = var1;
      }

      try {
         boolean var5 = var10000.getItem() instanceof ItemBlock;
         if (var2 != 0) {
            return var5;
         }

         if (var5) {
            return true;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return false;
   }

   private boolean Ԉ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 03: astore 3
      // 04: aload 3
      // 05: arraylength
      // 06: istore 4
      // 08: getstatic x/oc89eb238246.ħ I
      // 0b: bipush 0
      // 0c: istore 5
      // 0e: istore 2
      // 0f: iload 5
      // 11: iload 4
      // 13: if_icmpge 45
      // 16: aload 3
      // 17: iload 5
      // 19: aaload
      // 1a: astore 6
      // 1c: iload 2
      // 1d: ifne 41
      // 20: aload 1
      // 21: aload 6
      // 23: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 26: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 29: invokevirtual net/minecraft/block/Block.isFullCube ()Z
      // 2c: iload 2
      // 2d: ifne 46
      // 30: goto 34
      // 33: athrow
      // 34: ifne 3e
      // 37: goto 3b
      // 3a: athrow
      // 3b: bipush 1
      // 3c: ireturn
      // 3d: athrow
      // 3e: iinc 5 1
      // 41: iload 2
      // 42: ifeq 0f
      // 45: bipush 0
      // 46: ireturn
   }

   private String T() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09: invokevirtual net/minecraft/client/multiplayer/WorldClient.getScoreboard ()Lnet/minecraft/scoreboard/Scoreboard;
      // 0c: bipush 1
      // 0d: invokevirtual net/minecraft/scoreboard/Scoreboard.getObjectiveInDisplaySlot (I)Lnet/minecraft/scoreboard/ScoreObjective;
      // 10: astore 2
      // 11: istore 1
      // 12: aload 2
      // 13: iload 1
      // 14: ifne 26
      // 17: ifnonnull 25
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ldc_w ""
      // 21: goto 32
      // 24: athrow
      // 25: aload 2
      // 26: invokevirtual net/minecraft/scoreboard/ScoreObjective.getDisplayName ()Ljava/lang/String;
      // 29: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 2c: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 2f: invokevirtual java/lang/String.toUpperCase (Ljava/util/Locale;)Ljava/lang/String;
      // 32: areturn
   }

   private boolean ƃ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: aload 0
      // 04: invokevirtual x/oc8c951938d3.T ()Ljava/lang/String;
      // 07: astore 2
      // 08: istore 1
      // 09: invokestatic x/oc7ab2161b9f.ս ()Z
      // 0c: iload 1
      // 0d: ifne 6c
      // 10: ifne 6b
      // 13: goto 17
      // 16: athrow
      // 17: invokestatic x/oc7ab2161b9f.Գ ()Z
      // 1a: iload 1
      // 1b: ifne 6c
      // 1e: goto 22
      // 21: athrow
      // 22: ifne 6b
      // 25: goto 29
      // 28: athrow
      // 29: aload 2
      // 2a: ldc_w "PIT"
      // 2d: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 30: iload 1
      // 31: ifne 6c
      // 34: goto 38
      // 37: athrow
      // 38: ifne 6b
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 2
      // 40: ldc_w "SKYWARS"
      // 43: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 46: iload 1
      // 47: ifne 6c
      // 4a: goto 4e
      // 4d: athrow
      // 4e: ifne 6b
      // 51: goto 55
      // 54: athrow
      // 55: aload 2
      // 56: ldc_w "BUILD BATTLE"
      // 59: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 5c: iload 1
      // 5d: ifne 6c
      // 60: goto 64
      // 63: athrow
      // 64: ifeq 6f
      // 67: goto 6b
      // 6a: athrow
      // 6b: bipush 1
      // 6c: goto 70
      // 6f: bipush 0
      // 70: ireturn
   }

   @oc66fa4f2195
   public void ư(ocbab3c9954b var1) {
      this.onDisable();
   }
}
