package x;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;

public class ocfa5e00eb68 extends oc69da1aa7f5 {
   public static final String բ = "Bed Wars";
   public static final String ƃ = "idle.miau.module.impl.bedwar_utils.BedWars";
   public static final String ϯ = "idle.miau.module.impl.minigames.BedWars";
   private occ2f8dff8d8 ʀ;
   private occ2f8dff8d8 ƙ;
   private occ2f8dff8d8 ʠ;
   private occ2f8dff8d8 У;
   private occ2f8dff8d8 Ƕ;
   private List<String> ҹ = new ArrayList<>();
   private Map<String, String> ƒ = new ConcurrentHashMap<>();
   private Map<BlockPos, Long> Ș = new HashMap<>();
   public List<ocd682b1b69e> ո = new ArrayList<>();
   public List<Integer> Ո = new ArrayList<>();
   private int J = new Color(173517831 ^ 173517933, 173517920 ^ 173517933, 173518016 ^ 173517933).getRGB();
   public static boolean Ƞ;

   public ocfa5e00eb68() {
      super("BedWarsTracker", oce4cea752dd.Ԃ);
      this.ą("Alerts you to important enemy purchases in BedWars.");
      this.ʌ(new oc4d46a99983("Game alerts"));
      this.ʌ(this.ʀ = new occ2f8dff8d8("Diamond armor", true));
      this.ʌ(this.ƙ = new occ2f8dff8d8("Fireball", false));
      this.ʌ(this.У = new occ2f8dff8d8("Obsidian", true));
      this.ʌ(this.ʠ = new occ2f8dff8d8("Ender pearl", true));
      this.ʌ(this.Ƕ = new occ2f8dff8d8("Should ping", true));
      this.ɮ = true;
   }

   @Override
   public void onDisable() {
      this.ո.clear();
      this.Ո.clear();
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ь(oc746a23b244 param1) {
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
      // 07: iload 2
      // 08: ifne 25
      // 0b: ifeq d6
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: iload 2
      // 14: ifne 29
      // 17: goto 1b
      // 1a: athrow
      // 1b: getfield x/ocfa5e00eb68.У Lx/occ2f8dff8d8;
      // 1e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 21: goto 25
      // 24: athrow
      // 25: ifeq d6
      // 28: aload 0
      // 29: iload 2
      // 2a: ifne 3f
      // 2d: getfield x/ocfa5e00eb68.Ș Ljava/util/Map;
      // 30: invokeinterface java/util/Map.isEmpty ()Z 1
      // 35: ifeq 3e
      // 38: goto 3c
      // 3b: athrow
      // 3c: return
      // 3d: athrow
      // 3e: aload 0
      // 3f: getfield x/ocfa5e00eb68.Ș Ljava/util/Map;
      // 42: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 47: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 4c: astore 3
      // 4d: aload 3
      // 4e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 53: ifeq d2
      // 56: aload 3
      // 57: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 5c: checkcast java/util/Map$Entry
      // 5f: astore 4
      // 61: iload 2
      // 62: aload 4
      // 64: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 69: checkcast net/minecraft/util/BlockPos
      // 6c: astore 5
      // 6e: ifne d6
      // 71: aload 4
      // 73: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 78: checkcast java/lang/Long
      // 7b: astore 6
      // 7d: iload 2
      // 7e: ifne ce
      // 81: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 84: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 87: aload 5
      // 89: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 8c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 91: instanceof net/minecraft/block/BlockObsidian
      // 94: ifne c3
      // 97: goto 9b
      // 9a: athrow
      // 9b: invokestatic java/lang/System.currentTimeMillis ()J
      // 9e: aload 6
      // a0: invokevirtual java/lang/Long.longValue ()J
      // a3: invokestatic x/oc7ab2161b9f.Ҋ (JJ)J
      // a6: ldc2_w 2322949833501333930
      // a9: ldc2_w 2322949833501333598
      // ac: lxor
      // ad: lcmp
      // ae: iflt c3
      // b1: goto b5
      // b4: athrow
      // b5: aload 3
      // b6: invokeinterface java/util/Iterator.remove ()V 1
      // bb: iload 2
      // bc: ifeq 4d
      // bf: goto c3
      // c2: athrow
      // c3: aload 5
      // c5: aload 0
      // c6: getfield x/ocfa5e00eb68.J I
      // c9: bipush 0
      // ca: bipush 1
      // cb: invokestatic x/ocbd4917c4b1.ь (Lnet/minecraft/util/BlockPos;IZZ)V
      // ce: iload 2
      // cf: ifeq 4d
      // d2: goto d6
      // d5: astore 3
      // d6: return
   }

   @oc66fa4f2195
   public void Í(ocadfd5cc157 param1) {
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
      // 006: ifne 053
      // 009: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 00c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 012: if_acmpne 04e
      // 015: goto 019
      // 018: athrow
      // 019: aload 0
      // 01a: getfield x/ocfa5e00eb68.ҹ Ljava/util/List;
      // 01d: invokeinterface java/util/List.clear ()V 1
      // 022: iload 2
      // 023: aload 0
      // 024: getfield x/ocfa5e00eb68.ƒ Ljava/util/Map;
      // 027: invokeinterface java/util/Map.clear ()V 1
      // 02c: aload 0
      // 02d: getfield x/ocfa5e00eb68.Ș Ljava/util/Map;
      // 030: invokeinterface java/util/Map.clear ()V 1
      // 035: aload 0
      // 036: getfield x/ocfa5e00eb68.ո Ljava/util/List;
      // 039: invokeinterface java/util/List.clear ()V 1
      // 03e: aload 0
      // 03f: getfield x/ocfa5e00eb68.Ո Ljava/util/List;
      // 042: invokeinterface java/util/List.clear ()V 1
      // 047: ifeq 136
      // 04a: goto 04e
      // 04d: athrow
      // 04e: aload 1
      // 04f: goto 053
      // 052: athrow
      // 053: iload 2
      // 054: ifne 066
      // 057: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 05a: ifnull 136
      // 05d: goto 061
      // 060: athrow
      // 061: aload 1
      // 062: goto 066
      // 065: athrow
      // 066: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 069: instanceof net/minecraft/entity/monster/EntityIronGolem
      // 06c: iload 2
      // 06d: ifne 07a
      // 070: ifeq 136
      // 073: goto 077
      // 076: athrow
      // 077: invokestatic x/oc7ab2161b9f.Ҝ ()I
      // 07a: ldc_w 45937825
      // 07d: ldc_w 45937827
      // 080: ixor
      // 081: if_icmpeq 086
      // 084: return
      // 085: athrow
      // 086: new net/minecraft/util/Vec3
      // 089: dup
      // 08a: aload 1
      // 08b: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 08e: getfield net/minecraft/entity/Entity.posX D
      // 091: aload 1
      // 092: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 095: getfield net/minecraft/entity/Entity.posY D
      // 098: aload 1
      // 099: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 09c: getfield net/minecraft/entity/Entity.posZ D
      // 09f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0a2: astore 3
      // 0a3: aload 0
      // 0a4: getfield x/ocfa5e00eb68.ո Ljava/util/List;
      // 0a7: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0ac: astore 4
      // 0ae: aload 4
      // 0b0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0b5: ifeq 136
      // 0b8: aload 4
      // 0ba: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0bf: checkcast x/ocd682b1b69e
      // 0c2: astore 5
      // 0c4: aload 5
      // 0c6: getfield x/ocd682b1b69e.ŷ Lnet/minecraft/util/Vec3;
      // 0c9: aload 3
      // 0ca: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0cd: ldc2_w 3.0
      // 0d0: dcmpl
      // 0d1: iload 2
      // 0d2: ifne 103
      // 0d5: ifgt 106
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0df: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e2: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 0e5: iload 2
      // 0e6: ifne 11a
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: i2l
      // 0ee: aload 5
      // 0f0: getfield x/ocd682b1b69e.Ւ I
      // 0f3: i2l
      // 0f4: invokestatic x/oc7ab2161b9f.Ҋ (JJ)J
      // 0f7: ldc2_w 4930175167336564204
      // 0fa: ldc2_w 4930175167336564176
      // 0fd: lxor
      // 0fe: lcmp
      // 0ff: goto 103
      // 102: athrow
      // 103: ifle 107
      // 106: return
      // 107: aload 0
      // 108: getfield x/ocfa5e00eb68.ո Ljava/util/List;
      // 10b: iload 2
      // 10c: ifne 122
      // 10f: aload 5
      // 111: invokeinterface java/util/List.remove (Ljava/lang/Object;)Z 2
      // 116: goto 11a
      // 119: athrow
      // 11a: ifne 11e
      // 11d: return
      // 11e: aload 0
      // 11f: getfield x/ocfa5e00eb68.Ո Ljava/util/List;
      // 122: aload 1
      // 123: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 126: invokevirtual net/minecraft/entity/Entity.getEntityId ()I
      // 129: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 12c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 131: pop
      // 132: iload 2
      // 133: ifeq 0ae
      // 136: return
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
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ҝ ()I
      // 007: iload 1
      // 008: ifne 02c
      // 00b: ldc_w 1490850318
      // 00e: ldc_w 1490850316
      // 011: ixor
      // 012: if_icmpne 22a
      // 015: goto 019
      // 018: athrow
      // 019: aload 0
      // 01a: getfield x/ocfa5e00eb68.ʀ Lx/occ2f8dff8d8;
      // 01d: iload 1
      // 01e: ifne 037
      // 021: goto 025
      // 024: athrow
      // 025: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 028: goto 02c
      // 02b: athrow
      // 02c: ifne 053
      // 02f: aload 0
      // 030: getfield x/ocfa5e00eb68.ʠ Lx/occ2f8dff8d8;
      // 033: goto 037
      // 036: athrow
      // 037: iload 1
      // 038: ifne 04d
      // 03b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 03e: ifne 053
      // 041: goto 045
      // 044: athrow
      // 045: aload 0
      // 046: getfield x/ocfa5e00eb68.У Lx/occ2f8dff8d8;
      // 049: goto 04d
      // 04c: athrow
      // 04d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 050: ifeq 22a
      // 053: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 056: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 059: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 05c: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 061: astore 2
      // 062: aload 2
      // 063: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 068: ifeq 22a
      // 06b: aload 2
      // 06c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 071: checkcast net/minecraft/entity/player/EntityPlayer
      // 074: astore 3
      // 075: aload 3
      // 076: iload 1
      // 077: ifne 08a
      // 07a: ifnonnull 089
      // 07d: goto 081
      // 080: athrow
      // 081: iload 1
      // 082: ifeq 062
      // 085: goto 089
      // 088: athrow
      // 089: aload 3
      // 08a: iload 1
      // 08b: ifne 0a4
      // 08e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 091: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 094: if_acmpne 0a3
      // 097: goto 09b
      // 09a: athrow
      // 09b: iload 1
      // 09c: ifeq 062
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: aload 3
      // 0a4: iload 1
      // 0a5: ifne 0bb
      // 0a8: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 0ab: ifeq 0ba
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: iload 1
      // 0b3: ifeq 062
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: aload 3
      // 0bb: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // 0be: astore 4
      // 0c0: aload 3
      // 0c1: invokevirtual net/minecraft/entity/player/EntityPlayer.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0c4: astore 5
      // 0c6: aload 0
      // 0c7: getfield x/ocfa5e00eb68.ʀ Lx/occ2f8dff8d8;
      // 0ca: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0cd: ifeq 164
      // 0d0: aload 3
      // 0d1: getfield net/minecraft/entity/player/EntityPlayer.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0d4: getfield net/minecraft/entity/player/InventoryPlayer.armorInventory [Lnet/minecraft/item/ItemStack;
      // 0d7: bipush 1
      // 0d8: aaload
      // 0d9: iload 1
      // 0da: ifne 166
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: astore 6
      // 0e3: aload 0
      // 0e4: getfield x/ocfa5e00eb68.ҹ Ljava/util/List;
      // 0e7: aload 4
      // 0e9: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 0ee: ifne 164
      // 0f1: aload 3
      // 0f2: getfield net/minecraft/entity/player/EntityPlayer.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0f5: ifnull 164
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 6
      // 0fe: iload 1
      // 0ff: ifne 166
      // 102: goto 106
      // 105: athrow
      // 106: ifnull 164
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 6
      // 10f: iload 1
      // 110: ifne 166
      // 113: goto 117
      // 116: athrow
      // 117: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 11a: ifnull 164
      // 11d: goto 121
      // 120: athrow
      // 121: aload 6
      // 123: iload 1
      // 124: ifne 166
      // 127: goto 12b
      // 12a: athrow
      // 12b: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 12e: getstatic net/minecraft/init/Items.diamond_leggings Lnet/minecraft/item/ItemArmor;
      // 131: if_acmpne 164
      // 134: goto 138
      // 137: athrow
      // 138: aload 0
      // 139: getfield x/ocfa5e00eb68.ҹ Ljava/util/List;
      // 13c: aload 4
      // 13e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 143: pop
      // 144: aload 3
      // 145: invokevirtual net/minecraft/entity/player/EntityPlayer.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 148: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 14d: ldc_w "&eAlert: &r"
      // 150: swap
      // 151: ldc_w " &7has purchased &bDiamond Armor"
      // 154: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 159: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 15c: aload 0
      // 15d: invokevirtual x/ocfa5e00eb68.ɽ ()V
      // 160: goto 164
      // 163: athrow
      // 164: aload 5
      // 166: ifnull 1d2
      // 169: aload 0
      // 16a: iload 1
      // 16b: ifne 1d7
      // 16e: goto 172
      // 171: athrow
      // 172: getfield x/ocfa5e00eb68.ƒ Ljava/util/Map;
      // 175: aload 4
      // 177: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 17c: ifne 1d2
      // 17f: goto 183
      // 182: athrow
      // 183: aload 0
      // 184: aload 5
      // 186: invokevirtual x/ocfa5e00eb68.Ό (Lnet/minecraft/item/ItemStack;)Ljava/lang/String;
      // 189: astore 6
      // 18b: iload 1
      // 18c: ifne 1aa
      // 18f: aload 6
      // 191: ifnull 1ce
      // 194: goto 198
      // 197: athrow
      // 198: aload 0
      // 199: getfield x/ocfa5e00eb68.ƒ Ljava/util/Map;
      // 19c: aload 4
      // 19e: aload 6
      // 1a0: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1a5: pop
      // 1a6: goto 1aa
      // 1a9: athrow
      // 1aa: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1ad: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b0: aload 3
      // 1b1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // 1b4: invokestatic java/lang/Math.round (F)I
      // 1b7: i2d
      // 1b8: dstore 7
      // 1ba: aload 0
      // 1bb: aload 6
      // 1bd: aload 3
      // 1be: invokevirtual net/minecraft/entity/player/EntityPlayer.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 1c1: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 1c6: dload 7
      // 1c8: invokestatic x/oc7ab2161b9f.ɑ (D)Ljava/lang/String;
      // 1cb: invokevirtual x/ocfa5e00eb68.f (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      // 1ce: iload 1
      // 1cf: ifeq 226
      // 1d2: aload 0
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: getfield x/ocfa5e00eb68.ƒ Ljava/util/Map;
      // 1da: iload 1
      // 1db: ifne 1fb
      // 1de: aload 4
      // 1e0: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 1e5: ifeq 226
      // 1e8: goto 1ec
      // 1eb: athrow
      // 1ec: aload 0
      // 1ed: getfield x/ocfa5e00eb68.ƒ Ljava/util/Map;
      // 1f0: aload 4
      // 1f2: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: checkcast java/lang/String
      // 1fe: astore 6
      // 200: aload 6
      // 202: iload 1
      // 203: ifne 225
      // 206: aload 0
      // 207: aload 5
      // 209: invokevirtual x/ocfa5e00eb68.Ό (Lnet/minecraft/item/ItemStack;)Ljava/lang/String;
      // 20c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 20f: ifne 226
      // 212: goto 216
      // 215: athrow
      // 216: aload 0
      // 217: getfield x/ocfa5e00eb68.ƒ Ljava/util/Map;
      // 21a: aload 4
      // 21c: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 221: goto 225
      // 224: athrow
      // 225: pop
      // 226: iload 1
      // 227: ifeq 062
      // 22a: return
   }

   @oc66fa4f2195
   public void Ǣ(oc9d4393f3ce param1) {
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
      // 05: iload 2
      // 06: ifne 1b
      // 09: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 0c: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 0f: ifeq d0
      // 12: goto 16
      // 15: athrow
      // 16: aload 1
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 1e: checkcast net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 21: astore 3
      // 22: aload 3
      // 23: iload 2
      // 24: ifne 3d
      // 27: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockDirection ()I
      // 2a: ldc_w -356471523
      // 2d: ldc_w -356471326
      // 30: ixor
      // 31: if_icmpeq d0
      // 34: goto 38
      // 37: athrow
      // 38: aload 3
      // 39: goto 3d
      // 3c: athrow
      // 3d: iload 2
      // 3e: ifne 50
      // 41: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 44: ifnull d0
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 3
      // 4c: goto 50
      // 4f: athrow
      // 50: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 53: iload 2
      // 54: ifne 69
      // 57: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 5a: ifnull d0
      // 5d: goto 61
      // 60: athrow
      // 61: aload 3
      // 62: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 65: goto 69
      // 68: athrow
      // 69: iload 2
      // 6a: ifne 82
      // 6d: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 70: instanceof net/minecraft/item/ItemMonsterPlacer
      // 73: ifeq d0
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 3
      // 7b: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 7e: goto 82
      // 81: athrow
      // 82: invokevirtual net/minecraft/item/ItemStack.getMetadata ()I
      // 85: invokestatic net/minecraft/entity/EntityList.getClassFromID (I)Ljava/lang/Class;
      // 88: astore 4
      // 8a: aload 4
      // 8c: iload 2
      // 8d: ifne 9a
      // 90: ifnonnull 98
      // 93: goto 97
      // 96: athrow
      // 97: return
      // 98: aload 4
      // 9a: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 9d: ldc_w "EntityIronGolem"
      // a0: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // a3: iload 2
      // a4: ifne cf
      // a7: ifeq d0
      // aa: goto ae
      // ad: athrow
      // ae: aload 0
      // af: getfield x/ocfa5e00eb68.ո Ljava/util/List;
      // b2: new x/ocd682b1b69e
      // b5: dup
      // b6: aload 3
      // b7: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPosition ()Lnet/minecraft/util/BlockPos;
      // ba: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // bd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // c0: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // c3: invokespecial x/ocd682b1b69e.<init> (Lnet/minecraft/util/BlockPos;I)V
      // c6: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // cb: goto cf
      // ce: athrow
      // cf: pop
      // d0: return
   }

   @oc66fa4f2195
   public void ɀ(oce79181588d param1) {
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
      // 05: iload 2
      // 06: ifne 1b
      // 09: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 0c: instanceof net/minecraft/network/play/server/S23PacketBlockChange
      // 0f: ifeq 7b
      // 12: goto 16
      // 15: athrow
      // 16: aload 1
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 1e: checkcast net/minecraft/network/play/server/S23PacketBlockChange
      // 21: astore 3
      // 22: aload 3
      // 23: iload 2
      // 24: ifne 36
      // 27: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 2a: ifnull 7b
      // 2d: goto 31
      // 30: athrow
      // 31: aload 3
      // 32: goto 36
      // 35: athrow
      // 36: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 39: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 3e: instanceof net/minecraft/block/BlockObsidian
      // 41: iload 2
      // 42: ifne 60
      // 45: ifeq 7b
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: iload 2
      // 4e: ifne 7a
      // 51: goto 55
      // 54: athrow
      // 55: aload 3
      // 56: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockPosition ()Lnet/minecraft/util/BlockPos;
      // 59: invokevirtual x/ocfa5e00eb68.c (Lnet/minecraft/util/BlockPos;)Z
      // 5c: goto 60
      // 5f: athrow
      // 60: ifeq 7b
      // 63: aload 0
      // 64: getfield x/ocfa5e00eb68.Ș Ljava/util/Map;
      // 67: aload 3
      // 68: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockPosition ()Lnet/minecraft/util/BlockPos;
      // 6b: invokestatic java/lang/System.currentTimeMillis ()J
      // 6e: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 71: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 76: goto 7a
      // 79: athrow
      // 7a: pop
      // 7b: return
   }

   private boolean c(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 06: astore 3
      // 07: istore 2
      // 08: aload 3
      // 09: arraylength
      // 0a: istore 4
      // 0c: bipush 0
      // 0d: istore 5
      // 0f: iload 5
      // 11: iload 4
      // 13: if_icmpge 49
      // 16: aload 3
      // 17: iload 5
      // 19: aaload
      // 1a: astore 6
      // 1c: iload 2
      // 1d: aload 1
      // 1e: aload 6
      // 20: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 23: astore 7
      // 25: ifne 45
      // 28: aload 7
      // 2a: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 2d: instanceof net/minecraft/block/BlockBed
      // 30: iload 2
      // 31: ifne 4a
      // 34: goto 38
      // 37: athrow
      // 38: ifeq 42
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush 1
      // 40: ireturn
      // 41: athrow
      // 42: iinc 5 1
      // 45: iload 2
      // 46: ifeq 0f
      // 49: bipush 0
      // 4a: ireturn
   }

   private String Ό(ItemStack param1) {
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
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 1f
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 23
      // 15: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 18: ifnonnull 22
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aconst_null
      // 20: areturn
      // 21: athrow
      // 22: aload 1
      // 23: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 26: invokevirtual net/minecraft/item/Item.getUnlocalizedName ()Ljava/lang/String;
      // 29: astore 3
      // 2a: aload 1
      // 2b: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 2e: instanceof net/minecraft/item/ItemEnderPearl
      // 31: iload 2
      // 32: ifne 5e
      // 35: ifeq 57
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 0
      // 3d: getfield x/ocfa5e00eb68.ʠ Lx/occ2f8dff8d8;
      // 40: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 43: iload 2
      // 44: ifne 5e
      // 47: goto 4b
      // 4a: athrow
      // 4b: ifeq 57
      // 4e: goto 52
      // 51: athrow
      // 52: ldc_w "&7an §3Ender Pearl"
      // 55: areturn
      // 56: athrow
      // 57: aload 3
      // 58: ldc_w "tile.obsidian"
      // 5b: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 5e: iload 2
      // 5f: ifne 8b
      // 62: ifeq 84
      // 65: goto 69
      // 68: athrow
      // 69: aload 0
      // 6a: getfield x/ocfa5e00eb68.У Lx/occ2f8dff8d8;
      // 6d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 70: iload 2
      // 71: ifne 8b
      // 74: goto 78
      // 77: athrow
      // 78: ifeq 84
      // 7b: goto 7f
      // 7e: athrow
      // 7f: ldc_w "§dObsidian"
      // 82: areturn
      // 83: athrow
      // 84: aload 1
      // 85: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 88: instanceof net/minecraft/item/ItemFireball
      // 8b: iload 2
      // 8c: ifne a1
      // 8f: ifeq a9
      // 92: goto 96
      // 95: athrow
      // 96: aload 0
      // 97: getfield x/ocfa5e00eb68.ƙ Lx/occ2f8dff8d8;
      // 9a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 9d: goto a1
      // a0: athrow
      // a1: ifeq a9
      // a4: ldc_w "&7a §6Fireball"
      // a7: areturn
      // a8: athrow
      // a9: aconst_null
      // aa: areturn
   }

   private void f(String var1, String var2, String var3) {
      String var4 = "&eAlert: &r" + var2 + " &7is holding " + var1 + " &7(§d" + var3 + "m&7)";
      oc7ab2161b9f.ý(var4);
      this.ɽ();
   }

   private void ɽ() {
      try {
         if (this.Ƕ.ǭ()) {
            oc69da1aa7f5.ő.thePlayer.playSound("note.pling", 1.0F, 1.0F);
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }
   }
}
