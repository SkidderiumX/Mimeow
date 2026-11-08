package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class oc4e33ee9eaf extends oc69da1aa7f5 {
   private static final double ľ = 4.5;
   private static final double Ɩ = 0.05;
   private static final double ř = 0.2;
   private static final double ŷ = 0.2;
   private static final int Ι = (int)Math.round(5.0);
   private static final List<occd75b77c2f> ƃ = ƒ();
   private static final String[] Ǭ = ӏ();
   private final occ2f8dff8d8 Ȕ;
   private final occ2f8dff8d8 Ə;
   private final oca9cc61aada Ա;
   private final oca9cc61aada ɜ;
   private final oca9cc61aada Ȝ;
   private final oca9cc61aada a;
   private final oca9cc61aada ƀ;
   private final occ2f8dff8d8 ϗ;
   private final Map<String, Integer> Ӊ = new HashMap<>();
   private occd75b77c2f À;
   private BlockPos Ǐ;
   private BlockPos ԁ;
   private occc87ebdd7c Ӹ;
   private int Ы;
   private int Ԑ;
   private int ѐ;
   private int n;
   private int Ԡ;
   private float ô;
   private float Ä;
   private boolean Ų;
   private boolean Ǧ;
   public static boolean Ɣ;

   public oc4e33ee9eaf() {
      super("BedDefender", oce4cea752dd.з);
      this.ą("Automatically Defenses your beds.");
      this.ʌ(this.Ȕ = new occ2f8dff8d8("Only Top Beds", true));
      this.ʌ(this.Ə = new occ2f8dff8d8("Bedwars Only", true));
      this.ʌ(this.Ա = new oca9cc61aada("Delay After Swap", " ticks", 0.0, 0.0, 10.0, 1.0));
      this.ʌ(this.ɜ = new oca9cc61aada("Delay After Aiming", " ticks", 0.0, 0.0, 10.0, 1.0));
      this.ʌ(this.Ȝ = new oca9cc61aada("Sneak Hold Ticks", " ticks", 5.0, 0.0, 20.0, 1.0));
      this.ʌ(this.a = new oca9cc61aada("FOV", 180.0, 0.0, 180.0, 1.0));
      this.ʌ(this.ƀ = new oca9cc61aada("Defense", -1116147155 ^ -1116147153, Ǭ));
      this.ʌ(this.ϗ = new occ2f8dff8d8("Debug Logs", false));
   }

   @Override
   public void onEnable() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 34
      // 09: aconst_null
      // 0a: putfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 0d: aload 0
      // 0e: bipush 1
      // 0f: invokevirtual x/oc4e33ee9eaf.Ƽ (Z)V
      // 12: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 15: ifeq 33
      // 18: goto 1c
      // 1b: athrow
      // 1c: getstatic x/oc4e33ee9eaf.ƃ Ljava/util/List;
      // 1f: invokeinterface java/util/List.isEmpty ()Z 1
      // 24: iload 1
      // 25: ifne 4e
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifeq 38
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 37: return
      // 38: aload 0
      // 39: getfield x/oc4e33ee9eaf.ƀ Lx/oca9cc61aada;
      // 3c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 3f: d2i
      // 40: bipush 0
      // 41: getstatic x/oc4e33ee9eaf.ƃ Ljava/util/List;
      // 44: invokeinterface java/util/List.size ()I 1
      // 49: bipush 1
      // 4a: isub
      // 4b: invokestatic net/minecraft/util/MathHelper.clamp_int (III)I
      // 4e: istore 2
      // 4f: iload 1
      // 50: aload 0
      // 51: getstatic x/oc4e33ee9eaf.ƃ Ljava/util/List;
      // 54: iload 2
      // 55: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 5a: checkcast x/occd75b77c2f
      // 5d: putfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 60: ifne 9c
      // 63: aload 0
      // 64: aload 0
      // 65: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 68: invokevirtual x/oc4e33ee9eaf.փ (Lx/occd75b77c2f;)Z
      // 6b: ifne 7e
      // 6e: goto 72
      // 71: athrow
      // 72: aload 0
      // 73: ldc "No required blocks in hotbar"
      // 75: invokevirtual x/oc4e33ee9eaf.ѿ (Ljava/lang/String;)V
      // 78: aload 0
      // 79: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 7c: return
      // 7d: athrow
      // 7e: aload 0
      // 7f: getstatic x/oc75d51ec7eb.d [F
      // 82: bipush 0
      // 83: faload
      // 84: putfield x/oc4e33ee9eaf.ô F
      // 87: aload 0
      // 88: getstatic x/oc75d51ec7eb.d [F
      // 8b: bipush 1
      // 8c: faload
      // 8d: putfield x/oc4e33ee9eaf.Ä F
      // 90: aload 0
      // 91: aload 0
      // 92: getfield x/oc4e33ee9eaf.ɜ Lx/oca9cc61aada;
      // 95: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 98: d2i
      // 99: putfield x/oc4e33ee9eaf.n I
      // 9c: return
   }

   @Override
   public void onDisable() {
      this.À = null;
      this.Ƽ(true);
   }

   @oc66fa4f2195
   public void ε(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: ifeq 22
      // 0a: aload 0
      // 0b: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 0e: ifnull 22
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 1b: ifnull 24
      // 1e: goto 22
      // 21: athrow
      // 22: return
      // 23: athrow
      // 24: aload 0
      // 25: invokevirtual x/oc4e33ee9eaf.ʑ ()[F
      // 28: astore 3
      // 29: iload 2
      // 2a: ifne 47
      // 2d: aload 3
      // 2e: ifnonnull 37
      // 31: goto 35
      // 34: athrow
      // 35: return
      // 36: athrow
      // 37: aload 1
      // 38: aload 3
      // 39: bipush 0
      // 3a: faload
      // 3b: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 3e: aload 3
      // 3f: bipush 1
      // 40: faload
      // 41: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 44: invokevirtual x/oc86de9e2892.է (Ljava/lang/Float;Ljava/lang/Float;)V
      // 47: return
   }

   @oc66fa4f2195
   public void Ǐ(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: ifne 00c
      // 00a: return
      // 00b: athrow
      // 00c: aload 0
      // 00d: invokevirtual x/oc4e33ee9eaf.і ()V
      // 010: aload 0
      // 011: getfield x/oc4e33ee9eaf.Ӹ Lx/occc87ebdd7c;
      // 014: astore 3
      // 015: aload 0
      // 016: iload 2
      // 017: ifne 02b
      // 01a: aconst_null
      // 01b: putfield x/oc4e33ee9eaf.Ӹ Lx/occc87ebdd7c;
      // 01e: aload 3
      // 01f: ifnull 064
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: goto 02b
      // 02a: athrow
      // 02b: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 02e: ifnull 064
      // 031: aload 3
      // 032: getfield x/occc87ebdd7c.Г I
      // 035: iload 2
      // 036: ifne 059
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: getfield x/oc4e33ee9eaf.Ԑ I
      // 041: if_icmpne 064
      // 044: goto 048
      // 047: athrow
      // 048: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 04e: aload 3
      // 04f: getfield x/occc87ebdd7c.ʖ Lnet/minecraft/util/BlockPos;
      // 052: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 055: goto 059
      // 058: athrow
      // 059: iload 2
      // 05a: ifne 06d
      // 05d: ifne 065
      // 060: goto 064
      // 063: athrow
      // 064: return
      // 065: aload 0
      // 066: aload 3
      // 067: getfield x/occc87ebdd7c.Ң Ljava/lang/String;
      // 06a: invokevirtual x/oc4e33ee9eaf.Ϸ (Ljava/lang/String;)I
      // 06d: istore 4
      // 06f: iload 2
      // 070: ifne 090
      // 073: iload 4
      // 075: ifge 082
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 0
      // 07d: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 080: return
      // 081: athrow
      // 082: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 085: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 088: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 08b: iload 4
      // 08d: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 090: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 093: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 096: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 099: astore 5
      // 09b: aload 5
      // 09d: aload 3
      // 09e: getfield x/occc87ebdd7c.Ң Ljava/lang/String;
      // 0a1: invokestatic x/oc4e33ee9eaf.Đ (Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Z
      // 0a4: iload 2
      // 0a5: ifne 0d3
      // 0a8: ifne 0b0
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: return
      // 0b0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b3: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0b6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0bc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bf: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0c2: aload 5
      // 0c4: aload 3
      // 0c5: getfield x/occc87ebdd7c.Ӥ Lnet/minecraft/util/BlockPos;
      // 0c8: aload 3
      // 0c9: getfield x/occc87ebdd7c.ɘ Lnet/minecraft/util/EnumFacing;
      // 0cc: aload 3
      // 0cd: getfield x/occc87ebdd7c.ͽ Lnet/minecraft/util/Vec3;
      // 0d0: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 0d3: istore 6
      // 0d5: iload 2
      // 0d6: ifne 0f9
      // 0d9: iload 6
      // 0db: ifeq 11b
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 0eb: aload 0
      // 0ec: dup
      // 0ed: getfield x/oc4e33ee9eaf.Ԑ I
      // 0f0: bipush 1
      // 0f1: iadd
      // 0f2: putfield x/oc4e33ee9eaf.Ԑ I
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: aload 0
      // 0fa: aload 0
      // 0fb: getfield x/oc4e33ee9eaf.Ԑ I
      // 0fe: aload 0
      // 0ff: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 102: getfield x/occd75b77c2f.ъ Ljava/util/List;
      // 105: invokeinterface java/util/List.size ()I 1
      // 10a: ldc_w "Placed step "
      // 10d: dup_x2
      // 10e: pop
      // 10f: ldc_w " of "
      // 112: swap
      // 113: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 118: invokevirtual x/oc4e33ee9eaf.ѿ (Ljava/lang/String;)V
      // 11b: return
   }

   @oc66fa4f2195
   public void ϴ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 19
      // 09: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 0c: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 0f: ifne 18
      // 12: goto 16
      // 15: athrow
      // 16: return
      // 17: athrow
      // 18: aload 1
      // 19: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 1c: checkcast net/minecraft/network/play/client/C03PacketPlayer
      // 1f: astore 3
      // 20: iload 2
      // 21: ifne 3b
      // 24: aload 3
      // 25: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getRotating ()Z
      // 28: ifeq 43
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: aload 3
      // 31: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getYaw ()F
      // 34: putfield x/oc4e33ee9eaf.ô F
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: aload 3
      // 3d: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getPitch ()F
      // 40: putfield x/oc4e33ee9eaf.Ä F
      // 43: return
   }

   @oc66fa4f2195
   public void ȴ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/oc4e33ee9eaf.ԁ Lnet/minecraft/util/BlockPos;
      // 0c: ifnull 27
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc4e33ee9eaf.ԁ Lnet/minecraft/util/BlockPos;
      // 1b: ldc_w -485825529
      // 1e: ldc_w -2062935289
      // 21: ixor
      // 22: bipush 1
      // 23: bipush 1
      // 24: invokestatic x/ocbd4917c4b1.ь (Lnet/minecraft/util/BlockPos;IZZ)V
      // 27: return
   }

   @oc66fa4f2195
   public void Ľ(MouseEvent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 2c
      // 09: getfield x/MouseEvent.button I
      // 0c: ifeq 27
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: iload 2
      // 15: ifne 2c
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/MouseEvent.button I
      // 1f: bipush 1
      // 20: if_icmpne 30
      // 23: goto 27
      // 26: athrow
      // 27: aload 1
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 30: return
   }

   @oc66fa4f2195
   public void ŋ(ocbab3c9954b var1) {
      this.Ƽ(true);
   }

   private float[] ʑ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 02e
      // 009: getfield x/oc4e33ee9eaf.Ų Z
      // 00c: ifne 02d
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 1
      // 015: ifne 02e
      // 018: goto 01c
      // 01b: athrow
      // 01c: invokevirtual x/oc4e33ee9eaf.Ê ()Z
      // 01f: ifne 02d
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 02a: aconst_null
      // 02b: areturn
      // 02c: athrow
      // 02d: aload 0
      // 02e: getfield x/oc4e33ee9eaf.Ԑ I
      // 031: aload 0
      // 032: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 035: getfield x/occd75b77c2f.ъ Ljava/util/List;
      // 038: invokeinterface java/util/List.size ()I 1
      // 03d: if_icmpge 08f
      // 040: aload 0
      // 041: aload 0
      // 042: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 045: getfield x/occd75b77c2f.ъ Ljava/util/List;
      // 048: aload 0
      // 049: getfield x/oc4e33ee9eaf.Ԑ I
      // 04c: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 051: checkcast x/occ7b8f22a4a
      // 054: invokevirtual x/oc4e33ee9eaf.к (Lx/occ7b8f22a4a;)Lnet/minecraft/util/BlockPos;
      // 057: astore 2
      // 058: iload 1
      // 059: ifne 08b
      // 05c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 062: iload 1
      // 063: ifne 0c8
      // 066: goto 06a
      // 069: athrow
      // 06a: aload 2
      // 06b: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 06e: ifeq 07d
      // 071: goto 075
      // 074: athrow
      // 075: iload 1
      // 076: ifeq 08f
      // 079: goto 07d
      // 07c: athrow
      // 07d: aload 0
      // 07e: dup
      // 07f: getfield x/oc4e33ee9eaf.Ԑ I
      // 082: bipush 1
      // 083: iadd
      // 084: putfield x/oc4e33ee9eaf.Ԑ I
      // 087: goto 08b
      // 08a: athrow
      // 08b: iload 1
      // 08c: ifeq 02d
      // 08f: aload 0
      // 090: iload 1
      // 091: ifne 0c8
      // 094: getfield x/oc4e33ee9eaf.Ԑ I
      // 097: aload 0
      // 098: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 09b: getfield x/occd75b77c2f.ъ Ljava/util/List;
      // 09e: invokeinterface java/util/List.size ()I 1
      // 0a3: if_icmplt 0b8
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: aload 0
      // 0ab: ldc_w "Defense complete"
      // 0ae: invokevirtual x/oc4e33ee9eaf.ѿ (Ljava/lang/String;)V
      // 0b1: aload 0
      // 0b2: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 0b5: aconst_null
      // 0b6: areturn
      // 0b7: athrow
      // 0b8: aload 0
      // 0b9: getfield x/oc4e33ee9eaf.À Lx/occd75b77c2f;
      // 0bc: getfield x/occd75b77c2f.ъ Ljava/util/List;
      // 0bf: aload 0
      // 0c0: getfield x/oc4e33ee9eaf.Ԑ I
      // 0c3: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0c8: checkcast x/occ7b8f22a4a
      // 0cb: astore 2
      // 0cc: aload 0
      // 0cd: aload 2
      // 0ce: invokevirtual x/oc4e33ee9eaf.к (Lx/occ7b8f22a4a;)Lnet/minecraft/util/BlockPos;
      // 0d1: astore 3
      // 0d2: aload 0
      // 0d3: aload 3
      // 0d4: putfield x/oc4e33ee9eaf.ԁ Lnet/minecraft/util/BlockPos;
      // 0d7: aload 0
      // 0d8: aload 0
      // 0d9: getfield x/oc4e33ee9eaf.ô F
      // 0dc: aload 0
      // 0dd: getfield x/oc4e33ee9eaf.Ä F
      // 0e0: aload 3
      // 0e1: aload 2
      // 0e2: getfield x/occ7b8f22a4a.ʊ Ljava/lang/String;
      // 0e5: invokevirtual x/oc4e33ee9eaf.ԥ (FFLnet/minecraft/util/BlockPos;Ljava/lang/String;)[F
      // 0e8: astore 4
      // 0ea: aload 4
      // 0ec: iload 1
      // 0ed: ifne 0f9
      // 0f0: ifnull 0fa
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 4
      // 0f9: areturn
      // 0fa: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 100: fconst_1
      // 101: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 104: astore 5
      // 106: aload 0
      // 107: getfield x/oc4e33ee9eaf.a Lx/oca9cc61aada;
      // 10a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 10d: d2f
      // 10e: fstore 6
      // 110: fload 6
      // 112: ldc_w 90.0
      // 115: invokestatic java/lang/Math.min (FF)F
      // 118: fstore 7
      // 11a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 120: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 123: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 126: fstore 8
      // 128: aload 0
      // 129: getfield x/oc4e33ee9eaf.ô F
      // 12c: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 12f: fstore 9
      // 131: new java/util/ArrayList
      // 134: dup
      // 135: invokespecial java/util/ArrayList.<init> ()V
      // 138: astore 10
      // 13a: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 13d: astore 11
      // 13f: aload 11
      // 141: arraylength
      // 142: istore 12
      // 144: bipush 0
      // 145: istore 13
      // 147: iload 13
      // 149: iload 12
      // 14b: if_icmpge 1e9
      // 14e: aload 11
      // 150: iload 13
      // 152: aaload
      // 153: astore 14
      // 155: iload 1
      // 156: aload 3
      // 157: aload 14
      // 159: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 15c: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 15f: astore 15
      // 161: aload 15
      // 163: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 166: astore 16
      // 168: ifne 20d
      // 16b: aload 15
      // 16d: invokestatic x/occb1ed1ed8f.ɍ (Lnet/minecraft/util/BlockPos;)Z
      // 170: iload 1
      // 171: ifne 19a
      // 174: goto 178
      // 177: athrow
      // 178: ifeq 187
      // 17b: goto 17f
      // 17e: athrow
      // 17f: iload 1
      // 180: ifeq 1e2
      // 183: goto 187
      // 186: athrow
      // 187: aload 0
      // 188: iload 1
      // 189: ifne 1c2
      // 18c: goto 190
      // 18f: athrow
      // 190: getfield x/oc4e33ee9eaf.Ȕ Lx/occ2f8dff8d8;
      // 193: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 196: goto 19a
      // 199: athrow
      // 19a: ifeq 1bd
      // 19d: aload 16
      // 19f: instanceof net/minecraft/block/BlockBed
      // 1a2: ifeq 1bd
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: aload 14
      // 1ab: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 1ae: if_acmpeq 1bd
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: iload 1
      // 1b6: ifeq 1e2
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: aload 0
      // 1be: goto 1c2
      // 1c1: athrow
      // 1c2: aload 10
      // 1c4: aload 5
      // 1c6: aload 15
      // 1c8: aload 14
      // 1ca: fload 9
      // 1cc: aload 0
      // 1cd: getfield x/oc4e33ee9eaf.Ä F
      // 1d0: fload 8
      // 1d2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d8: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 1db: fload 6
      // 1dd: fload 7
      // 1df: invokevirtual x/oc4e33ee9eaf.ϡ (Ljava/util/List;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FFFFFF)V
      // 1e2: iinc 13 1
      // 1e5: iload 1
      // 1e6: ifeq 147
      // 1e9: aload 10
      // 1eb: iload 1
      // 1ec: ifne 20f
      // 1ef: invokeinterface java/util/List.isEmpty ()Z 1
      // 1f4: ifeq 1fe
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: aconst_null
      // 1fc: areturn
      // 1fd: athrow
      // 1fe: aload 10
      // 200: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/oc4e33ee9eaf.q3glj183t6d6ou (Lx/oc4852afa9a3;)D, (Lx/oc4852afa9a3;)D ]
      // 205: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 208: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 20d: aload 10
      // 20f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 214: astore 11
      // 216: aload 11
      // 218: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 21d: ifeq 260
      // 220: aload 11
      // 222: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 227: checkcast x/oc4852afa9a3
      // 22a: astore 12
      // 22c: aload 12
      // 22e: getfield x/oc4852afa9a3.Ҹ F
      // 231: aload 0
      // 232: getfield x/oc4e33ee9eaf.ô F
      // 235: invokestatic x/oc4e33ee9eaf.J (FF)F
      // 238: fstore 13
      // 23a: aload 0
      // 23b: fload 13
      // 23d: aload 12
      // 23f: getfield x/oc4852afa9a3.џ F
      // 242: aload 3
      // 243: aload 2
      // 244: getfield x/occ7b8f22a4a.ʊ Ljava/lang/String;
      // 247: invokevirtual x/oc4e33ee9eaf.ԥ (FFLnet/minecraft/util/BlockPos;Ljava/lang/String;)[F
      // 24a: astore 14
      // 24c: aload 14
      // 24e: iload 1
      // 24f: ifne 25b
      // 252: ifnull 25c
      // 255: goto 259
      // 258: athrow
      // 259: aload 14
      // 25b: areturn
      // 25c: iload 1
      // 25d: ifeq 216
      // 260: aconst_null
      // 261: areturn
   }

   private boolean Ê() {
      int var2 = 0;
      BlockPos var3 = null;
      int var1 = oc84f20a0bc5.ė;
      int var4 = -1209576530 ^ -443620169;

      while (true) {
         switch (var4) {
            case 578896635:
               this.ѿ("No bed in range");
               return false;
            case 1382659865:
               int var10000;
               label42: {
                  label41: {
                     try {
                        var10000 = this.Ə.ǭ();
                        if (var1 != 0) {
                           break label42;
                        }

                        if (var10000 == 0) {
                           break label41;
                        }
                     } catch (ocbde1165e4e var9) {
                        throw var9;
                     }

                     var4 = 128565765 ^ -443620169;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1712828058 ^ -443620169;
               }

               var4 = var10000;
               break;
            case 2087106001:
               var2 = -443620185 ^ -443620169;
               var4 = -721756672 ^ -443620169;
               if (var1 == 0) {
                  break;
               }
            case -500750670:
               var2 = -443620178 ^ -443620169;
               var4 = -721756672 ^ -443620169;
               if (var1 == 0) {
                  break;
               }
            case 829700791:
               var3 = this.Ξ(var2);

               label51: {
                  label50: {
                     try {
                        if (var1 != 0) {
                           break label51;
                        }

                        if (var3 != null) {
                           break label50;
                        }
                     } catch (ocbde1165e4e var10) {
                        throw var10;
                     }

                     var4 = -955275700 ^ -443620169;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var4 = -1704147220 ^ -443620169;
               }

               if (var1 == 0) {
                  break;
               }
            case 2145526363:
               this.Ǐ = var3;
               this.Ы = đ(occb1ed1ed8f.ϛ(var3).getMetaFromState(oc69da1aa7f5.ő.theWorld.getBlockState(var3)));
               this.Ų = true;
               String var10001 = this.À.Ȕ;
               int var10002 = var3.getX();
               int var5 = var3.getZ();
               int var6 = var3.getY();
               int var7 = var10002;
               String var8 = var10001;
               this.ѿ("Using " + var8 + " at " + var7 + "," + var6 + "," + var5);
               return true;
            default:
               throw null;
         }
      }
   }

   private void ϡ(
      List<oc4852afa9a3> param1,
      Vec3 param2,
      BlockPos param3,
      EnumFacing param4,
      float param5,
      float param6,
      float param7,
      float param8,
      float param9,
      float param10
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: ldc2_w 0.04000000000000001
      // 006: dstore 12
      // 008: istore 11
      // 00a: bipush 0
      // 00b: istore 14
      // 00d: iload 14
      // 00f: getstatic x/oc4e33ee9eaf.Ι I
      // 012: if_icmpgt 14c
      // 015: iload 14
      // 017: iload 11
      // 019: ifne 02a
      // 01c: bipush 1
      // 01d: iand
      // 01e: ifne 02d
      // 021: goto 025
      // 024: athrow
      // 025: bipush 1
      // 026: goto 02a
      // 029: athrow
      // 02a: goto 02e
      // 02d: bipush 0
      // 02e: istore 15
      // 030: iload 14
      // 032: i2d
      // 033: ldc2_w 0.2
      // 036: dmul
      // 037: dload 12
      // 039: invokestatic x/oc4e33ee9eaf.Ö (D)D
      // 03c: dadd
      // 03d: invokestatic x/oc4e33ee9eaf.Ћ (D)D
      // 040: dstore 16
      // 042: bipush 0
      // 043: istore 18
      // 045: iload 18
      // 047: getstatic x/oc4e33ee9eaf.Ι I
      // 04a: if_icmpgt 144
      // 04d: iload 18
      // 04f: i2d
      // 050: ldc2_w 0.2
      // 053: dmul
      // 054: iload 11
      // 056: ifne 040
      // 059: dload 12
      // 05b: invokestatic x/oc4e33ee9eaf.Ö (D)D
      // 05e: dadd
      // 05f: invokestatic x/oc4e33ee9eaf.Ћ (D)D
      // 062: dstore 19
      // 064: iload 15
      // 066: ifeq 06f
      // 069: dload 19
      // 06b: goto 073
      // 06e: athrow
      // 06f: dconst_1
      // 070: dload 19
      // 072: dsub
      // 073: dstore 21
      // 075: iload 11
      // 077: aload 3
      // 078: aload 4
      // 07a: dload 21
      // 07c: dload 16
      // 07e: invokestatic x/oc4e33ee9eaf.ѝ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;DD)Lnet/minecraft/util/Vec3;
      // 081: astore 23
      // 083: aload 2
      // 084: aload 23
      // 086: getfield net/minecraft/util/Vec3.xCoord D
      // 089: aload 23
      // 08b: getfield net/minecraft/util/Vec3.yCoord D
      // 08e: aload 23
      // 090: getfield net/minecraft/util/Vec3.zCoord D
      // 093: invokestatic x/oc75d51ec7eb.ӆ (Lnet/minecraft/util/Vec3;DDD)[F
      // 096: astore 24
      // 098: aload 24
      // 09a: bipush 0
      // 09b: faload
      // 09c: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 09f: fstore 25
      // 0a1: aload 24
      // 0a3: bipush 1
      // 0a4: faload
      // 0a5: fstore 26
      // 0a7: ifne 13f
      // 0aa: fload 25
      // 0ac: fload 7
      // 0ae: fsub
      // 0af: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0b2: invokestatic java/lang/Math.abs (F)F
      // 0b5: fload 9
      // 0b7: fcmpl
      // 0b8: ifgt 13c
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: fload 26
      // 0c1: fload 8
      // 0c3: fsub
      // 0c4: invokestatic java/lang/Math.abs (F)F
      // 0c7: fload 10
      // 0c9: iload 11
      // 0cb: ifne 0ef
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: fcmpl
      // 0d3: ifgt 13c
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: fload 26
      // 0dc: iload 11
      // 0de: ifne 114
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: invokestatic java/lang/Math.abs (F)F
      // 0e8: ldc_w 90.0
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: fcmpl
      // 0f0: ifle 0fc
      // 0f3: iload 11
      // 0f5: ifeq 13c
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: fload 25
      // 0fe: fload 5
      // 100: fsub
      // 101: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 104: invokestatic java/lang/Math.abs (F)F
      // 107: fload 26
      // 109: fload 6
      // 10b: fsub
      // 10c: invokestatic java/lang/Math.abs (F)F
      // 10f: fadd
      // 110: goto 114
      // 113: athrow
      // 114: f2d
      // 115: aload 4
      // 117: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 11a: if_acmpne 124
      // 11d: ldc2_w -0.25
      // 120: goto 125
      // 123: athrow
      // 124: dconst_0
      // 125: dadd
      // 126: dstore 27
      // 128: aload 1
      // 129: new x/oc4852afa9a3
      // 12c: dup
      // 12d: dload 27
      // 12f: fload 25
      // 131: fload 26
      // 133: invokespecial x/oc4852afa9a3.<init> (DFF)V
      // 136: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 13b: pop
      // 13c: iinc 18 1
      // 13f: iload 11
      // 141: ifeq 045
      // 144: iinc 14 1
      // 147: iload 11
      // 149: ifeq 00d
      // 14c: return
   }

   private float[] ԥ(float param1, float param2, BlockPos param3, String param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: ldc2_w 4.5
      // 006: fload 1
      // 007: fload 2
      // 008: invokestatic x/oc75d51ec7eb.ѭ (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 00b: astore 6
      // 00d: istore 5
      // 00f: aload 6
      // 011: iload 5
      // 013: ifne 01f
      // 016: ifnull 078
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 6
      // 01f: iload 5
      // 021: ifne 03c
      // 024: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 027: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 02a: if_acmpne 078
      // 02d: goto 031
      // 030: athrow
      // 031: aload 6
      // 033: iload 5
      // 035: ifne 048
      // 038: goto 03c
      // 03b: athrow
      // 03c: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 03f: ifnull 078
      // 042: aload 6
      // 044: goto 048
      // 047: athrow
      // 048: iload 5
      // 04a: ifne 05d
      // 04d: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 050: ifnull 078
      // 053: goto 057
      // 056: athrow
      // 057: aload 6
      // 059: goto 05d
      // 05c: athrow
      // 05d: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 060: iload 5
      // 062: ifne 080
      // 065: aload 6
      // 067: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 06a: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 06d: aload 3
      // 06e: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 071: ifne 07b
      // 074: goto 078
      // 077: athrow
      // 078: aconst_null
      // 079: areturn
      // 07a: athrow
      // 07b: aload 6
      // 07d: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 080: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 083: astore 7
      // 085: aload 0
      // 086: iload 5
      // 088: ifne 0c0
      // 08b: getfield x/oc4e33ee9eaf.Ȕ Lx/occ2f8dff8d8;
      // 08e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 091: ifeq 0bf
      // 094: goto 098
      // 097: athrow
      // 098: aload 7
      // 09a: instanceof net/minecraft/block/BlockBed
      // 09d: iload 5
      // 09f: ifne 0c5
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: ifeq 0bf
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: aload 6
      // 0af: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 0b2: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 0b5: if_acmpeq 0bf
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: aconst_null
      // 0bd: areturn
      // 0be: athrow
      // 0bf: aload 0
      // 0c0: aload 4
      // 0c2: invokevirtual x/oc4e33ee9eaf.Ϸ (Ljava/lang/String;)I
      // 0c5: istore 8
      // 0c7: iload 8
      // 0c9: iload 5
      // 0cb: ifne 0f7
      // 0ce: ifge 0eb
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 0
      // 0d6: aload 4
      // 0d8: ldc_w "Missing "
      // 0db: swap
      // 0dc: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0e1: invokevirtual x/oc4e33ee9eaf.ѿ (Ljava/lang/String;)V
      // 0e4: aload 0
      // 0e5: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 0e8: aconst_null
      // 0e9: areturn
      // 0ea: athrow
      // 0eb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ee: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f1: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0f4: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 0f7: iload 5
      // 0f9: ifne 127
      // 0fc: iload 8
      // 0fe: if_icmpeq 123
      // 101: goto 105
      // 104: athrow
      // 105: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 108: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 10e: iload 8
      // 110: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 113: aload 0
      // 114: aload 0
      // 115: getfield x/oc4e33ee9eaf.Ա Lx/oca9cc61aada;
      // 118: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 11b: d2i
      // 11c: putfield x/oc4e33ee9eaf.ѐ I
      // 11f: goto 123
      // 122: athrow
      // 123: aload 0
      // 124: getfield x/oc4e33ee9eaf.ѐ I
      // 127: iload 5
      // 129: ifne 155
      // 12c: ifle 150
      // 12f: goto 133
      // 132: athrow
      // 133: aload 0
      // 134: dup
      // 135: getfield x/oc4e33ee9eaf.ѐ I
      // 138: bipush 1
      // 139: isub
      // 13a: putfield x/oc4e33ee9eaf.ѐ I
      // 13d: ldc_w -613355942
      // 140: ldc_w -613355944
      // 143: ixor
      // 144: newarray 6
      // 146: dup
      // 147: bipush 0
      // 148: fload 1
      // 149: fastore
      // 14a: dup
      // 14b: bipush 1
      // 14c: fload 2
      // 14d: fastore
      // 14e: areturn
      // 14f: athrow
      // 150: aload 7
      // 152: instanceof net/minecraft/block/BlockBed
      // 155: iload 5
      // 157: ifne 16e
      // 15a: ifeq 194
      // 15d: goto 161
      // 160: athrow
      // 161: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 164: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 167: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSneaking ()Z
      // 16a: goto 16e
      // 16d: athrow
      // 16e: iload 5
      // 170: ifne 189
      // 173: ifne 194
      // 176: goto 17a
      // 179: athrow
      // 17a: aload 0
      // 17b: invokevirtual x/oc4e33ee9eaf.ɘ ()V
      // 17e: ldc_w -613355942
      // 181: ldc_w -613355944
      // 184: ixor
      // 185: goto 189
      // 188: athrow
      // 189: newarray 6
      // 18b: dup
      // 18c: bipush 0
      // 18d: fload 1
      // 18e: fastore
      // 18f: dup
      // 190: bipush 1
      // 191: fload 2
      // 192: fastore
      // 193: areturn
      // 194: fload 1
      // 195: aload 0
      // 196: getfield x/oc4e33ee9eaf.ô F
      // 199: fsub
      // 19a: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 19d: invokestatic java/lang/Math.abs (F)F
      // 1a0: fstore 9
      // 1a2: fload 2
      // 1a3: aload 0
      // 1a4: getfield x/oc4e33ee9eaf.Ä F
      // 1a7: fsub
      // 1a8: invokestatic java/lang/Math.abs (F)F
      // 1ab: fstore 10
      // 1ad: aload 0
      // 1ae: iload 5
      // 1b0: ifne 1ea
      // 1b3: getfield x/oc4e33ee9eaf.n I
      // 1b6: ifgt 1e9
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: fload 9
      // 1bf: ldc_w 25.0
      // 1c2: fcmpl
      // 1c3: iload 5
      // 1c5: ifne 1ed
      // 1c8: goto 1cc
      // 1cb: athrow
      // 1cc: ifgt 1e9
      // 1cf: goto 1d3
      // 1d2: athrow
      // 1d3: fload 10
      // 1d5: ldc_w 25.0
      // 1d8: fcmpl
      // 1d9: iload 5
      // 1db: ifne 1ed
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: ifle 219
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: aload 0
      // 1ea: getfield x/oc4e33ee9eaf.n I
      // 1ed: iload 5
      // 1ef: ifne 20e
      // 1f2: ifle 207
      // 1f5: goto 1f9
      // 1f8: athrow
      // 1f9: aload 0
      // 1fa: dup
      // 1fb: getfield x/oc4e33ee9eaf.n I
      // 1fe: bipush 1
      // 1ff: isub
      // 200: putfield x/oc4e33ee9eaf.n I
      // 203: goto 207
      // 206: athrow
      // 207: ldc_w -613355942
      // 20a: ldc_w -613355944
      // 20d: ixor
      // 20e: newarray 6
      // 210: dup
      // 211: bipush 0
      // 212: fload 1
      // 213: fastore
      // 214: dup
      // 215: bipush 1
      // 216: fload 2
      // 217: fastore
      // 218: areturn
      // 219: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 21c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 21f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 222: astore 11
      // 224: aload 11
      // 226: iload 5
      // 228: ifne 23d
      // 22b: aload 4
      // 22d: invokestatic x/oc4e33ee9eaf.Đ (Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Z
      // 230: ifeq 256
      // 233: goto 237
      // 236: athrow
      // 237: aload 11
      // 239: goto 23d
      // 23c: athrow
      // 23d: aload 6
      // 23f: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 242: aload 6
      // 244: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 247: invokestatic x/occb1ed1ed8f.ā (Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 24a: iload 5
      // 24c: ifne 28d
      // 24f: ifne 259
      // 252: goto 256
      // 255: athrow
      // 256: aconst_null
      // 257: areturn
      // 258: athrow
      // 259: aload 0
      // 25a: aload 0
      // 25b: getfield x/oc4e33ee9eaf.ɜ Lx/oca9cc61aada;
      // 25e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 261: d2i
      // 262: putfield x/oc4e33ee9eaf.n I
      // 265: aload 0
      // 266: new x/occc87ebdd7c
      // 269: dup
      // 26a: aload 0
      // 26b: getfield x/oc4e33ee9eaf.Ԑ I
      // 26e: aload 4
      // 270: aload 3
      // 271: aload 6
      // 273: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 276: aload 6
      // 278: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 27b: aload 6
      // 27d: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 280: invokespecial x/occc87ebdd7c.<init> (ILjava/lang/String;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)V
      // 283: putfield x/oc4e33ee9eaf.Ӹ Lx/occc87ebdd7c;
      // 286: ldc_w -613355942
      // 289: ldc_w -613355944
      // 28c: ixor
      // 28d: newarray 6
      // 28f: dup
      // 290: bipush 0
      // 291: fload 1
      // 292: fastore
      // 293: dup
      // 294: bipush 1
      // 295: fload 2
      // 296: fastore
      // 297: areturn
   }

   private void ɘ() {
      KeyBinding.setKeyBindState(oc69da1aa7f5.ő.gameSettings.keyBindSneak.getKeyCode(), true);
      this.Ǧ = true;
      this.Ԡ = (int)this.Ȝ.Ӂ();
   }

   private void і() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 16
      // 09: getfield x/oc4e33ee9eaf.Ǧ Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 1
      // 17: ifne 41
      // 1a: getfield x/oc4e33ee9eaf.Ԡ I
      // 1d: ifle 30
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: dup
      // 26: getfield x/oc4e33ee9eaf.Ԡ I
      // 29: bipush 1
      // 2a: isub
      // 2b: putfield x/oc4e33ee9eaf.Ԡ I
      // 2e: return
      // 2f: athrow
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 36: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 39: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 3c: bipush 0
      // 3d: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 40: aload 0
      // 41: bipush 0
      // 42: putfield x/oc4e33ee9eaf.Ǧ Z
      // 45: return
   }

   private BlockPos к(occ7b8f22a4a var1) {
      BlockPos var2 = ʑ(var1.ě, this.Ы);
      return this.Ǐ.add(var2.getX(), var2.getY(), var2.getZ());
   }

   private boolean փ(occd75b77c2f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 1
      // 04: getfield x/occd75b77c2f.ъ Ljava/util/List;
      // 07: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0c: astore 3
      // 0d: istore 2
      // 0e: aload 3
      // 0f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14: ifeq 44
      // 17: aload 3
      // 18: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1d: checkcast x/occ7b8f22a4a
      // 20: astore 4
      // 22: aload 0
      // 23: aload 4
      // 25: getfield x/occ7b8f22a4a.ʊ Ljava/lang/String;
      // 28: invokevirtual x/oc4e33ee9eaf.Ϸ (Ljava/lang/String;)I
      // 2b: iload 2
      // 2c: ifne 45
      // 2f: iload 2
      // 30: ifne 3f
      // 33: goto 37
      // 36: athrow
      // 37: iflt 40
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: ireturn
      // 40: iload 2
      // 41: ifeq 0e
      // 44: bipush 0
      // 45: ireturn
   }

   private int Ϸ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc4e33ee9eaf.Ӊ Ljava/util/Map;
      // 07: aload 1
      // 08: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0d: checkcast java/lang/Integer
      // 10: astore 3
      // 11: istore 2
      // 12: aload 3
      // 13: iload 2
      // 14: ifne 1f
      // 17: ifnull 71
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 3
      // 1f: invokevirtual java/lang/Integer.intValue ()I
      // 22: iload 2
      // 23: ifne 72
      // 26: iflt 71
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 3
      // 2e: invokevirtual java/lang/Integer.intValue ()I
      // 31: iload 2
      // 32: ifne 72
      // 35: goto 39
      // 38: athrow
      // 39: ldc_w 797021335
      // 3c: ldc_w 797021342
      // 3f: ixor
      // 40: if_icmpge 71
      // 43: goto 47
      // 46: athrow
      // 47: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4d: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 50: getfield net/minecraft/entity/player/InventoryPlayer.mainInventory [Lnet/minecraft/item/ItemStack;
      // 53: aload 3
      // 54: invokevirtual java/lang/Integer.intValue ()I
      // 57: aaload
      // 58: aload 1
      // 59: invokestatic x/oc4e33ee9eaf.Đ (Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Z
      // 5c: iload 2
      // 5d: ifne 72
      // 60: goto 64
      // 63: athrow
      // 64: ifeq 71
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 3
      // 6c: invokevirtual java/lang/Integer.intValue ()I
      // 6f: ireturn
      // 70: athrow
      // 71: bipush 0
      // 72: istore 4
      // 74: iload 4
      // 76: ldc_w 797021335
      // 79: ldc_w 797021342
      // 7c: ixor
      // 7d: if_icmpge c4
      // 80: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 83: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 86: iload 2
      // 87: ifne ce
      // 8a: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 8d: getfield net/minecraft/entity/player/InventoryPlayer.mainInventory [Lnet/minecraft/item/ItemStack;
      // 90: iload 2
      // 91: ifne b9
      // 94: goto 98
      // 97: athrow
      // 98: iload 4
      // 9a: aaload
      // 9b: aload 1
      // 9c: invokestatic x/oc4e33ee9eaf.Đ (Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Z
      // 9f: ifeq bd
      // a2: goto a6
      // a5: athrow
      // a6: aload 0
      // a7: getfield x/oc4e33ee9eaf.Ӊ Ljava/util/Map;
      // aa: aload 1
      // ab: iload 4
      // ad: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // b0: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // b5: goto b9
      // b8: athrow
      // b9: pop
      // ba: iload 4
      // bc: ireturn
      // bd: iinc 4 1
      // c0: iload 2
      // c1: ifeq 74
      // c4: aload 0
      // c5: getfield x/oc4e33ee9eaf.Ӊ Ljava/util/Map;
      // c8: aload 1
      // c9: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // ce: pop
      // cf: bipush -1
      // d0: ireturn
   }

   private static boolean Đ(ItemStack var0, String var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 1490664552 ^ 666731776;

      while (true) {
         switch (var3) {
            case -1314011046:
               if (((ItemBlock)var0.getItem()).getBlock() == Ŕ(var1)) {
                  var3 = 733295788 ^ 666731776;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 781341622 ^ 666731776;
               if (var2 == 0) {
                  break;
               }
            case 201896364:
               return true;
            case 1339669404:
               int var6;
               label60: {
                  label59: {
                     try {
                        var6 = var0.stackSize;
                        if (var2 != 0) {
                           break label60;
                        }

                        if (var0.stackSize <= 0) {
                           break label59;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 1403721659 ^ 666731776;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = 781341622 ^ 666731776;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }
            case 154130102:
               return false;
            case 2137274728:
               if (var0 != null) {
                  var3 = 1751400092 ^ 666731776;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 781341622 ^ 666731776;
               if (var2 == 0) {
                  break;
               }
            case 1947636411:
               int var10000;
               label51: {
                  label50: {
                     try {
                        var10000 = var0.getItem() instanceof ItemBlock;
                        if (var2 != 0) {
                           break label51;
                        }

                        if (var10000 == 0) {
                           break label50;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -1777316518 ^ 666731776;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 781341622 ^ 666731776;
               }

               var3 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private BlockPos Ξ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 009: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPosition ()Lnet/minecraft/util/BlockPos;
      // 00c: astore 3
      // 00d: aconst_null
      // 00e: astore 4
      // 010: ldc2_w 1.7976931348623157E308
      // 013: dstore 5
      // 015: new net/minecraft/util/BlockPos$MutableBlockPos
      // 018: dup
      // 019: invokespecial net/minecraft/util/BlockPos$MutableBlockPos.<init> ()V
      // 01c: astore 7
      // 01e: bipush 0
      // 01f: aload 3
      // 020: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 023: iload 1
      // 024: isub
      // 025: invokestatic java/lang/Math.max (II)I
      // 028: istore 8
      // 02a: istore 2
      // 02b: ldc_w -157312347
      // 02e: ldc_w -157312422
      // 031: ixor
      // 032: aload 3
      // 033: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 036: iload 1
      // 037: iadd
      // 038: invokestatic java/lang/Math.min (II)I
      // 03b: istore 9
      // 03d: aload 3
      // 03e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 041: iload 1
      // 042: isub
      // 043: istore 10
      // 045: iload 10
      // 047: aload 3
      // 048: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 04b: iload 1
      // 04c: iadd
      // 04d: if_icmpgt 126
      // 050: aload 3
      // 051: iload 2
      // 052: ifne 128
      // 055: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 058: iload 1
      // 059: isub
      // 05a: istore 11
      // 05c: iload 11
      // 05e: aload 3
      // 05f: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 062: iload 1
      // 063: iadd
      // 064: if_icmpgt 11f
      // 067: iload 2
      // 068: ifne 122
      // 06b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 071: aload 7
      // 073: iload 10
      // 075: aload 3
      // 076: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 079: iload 11
      // 07b: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 07e: bipush 0
      // 07f: invokevirtual net/minecraft/client/multiplayer/WorldClient.isBlockLoaded (Lnet/minecraft/util/BlockPos;Z)Z
      // 082: iload 2
      // 083: ifne 09f
      // 086: goto 08a
      // 089: athrow
      // 08a: ifne 099
      // 08d: goto 091
      // 090: athrow
      // 091: iload 2
      // 092: ifeq 118
      // 095: goto 099
      // 098: athrow
      // 099: iload 8
      // 09b: goto 09f
      // 09e: athrow
      // 09f: istore 12
      // 0a1: iload 12
      // 0a3: iload 9
      // 0a5: if_icmpgt 118
      // 0a8: iload 2
      // 0a9: ifne 11b
      // 0ac: aload 7
      // 0ae: iload 2
      // 0af: ifne 0e8
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: iload 10
      // 0b8: iload 12
      // 0ba: iload 11
      // 0bc: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 0bf: pop
      // 0c0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c3: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0c6: aload 7
      // 0c8: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0cb: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0d0: instanceof net/minecraft/block/BlockBed
      // 0d3: ifne 0e2
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: iload 2
      // 0db: ifeq 111
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 7
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 3
      // 0e9: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.distanceSq (Lnet/minecraft/util/Vec3i;)D
      // 0ec: dstore 13
      // 0ee: iload 2
      // 0ef: ifne 114
      // 0f2: dload 13
      // 0f4: dload 5
      // 0f6: dcmpg
      // 0f7: ifge 111
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: dload 13
      // 100: dstore 5
      // 102: new net/minecraft/util/BlockPos
      // 105: dup
      // 106: iload 10
      // 108: iload 12
      // 10a: iload 11
      // 10c: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 10f: astore 4
      // 111: iinc 12 1
      // 114: iload 2
      // 115: ifeq 0a1
      // 118: iinc 11 1
      // 11b: iload 2
      // 11c: ifeq 05c
      // 11f: iinc 10 1
      // 122: iload 2
      // 123: ifeq 045
      // 126: aload 4
      // 128: areturn
   }

   private void Ƽ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 20
      // 09: ifeq 4c
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 2
      // 12: ifne 7f
      // 15: goto 19
      // 18: athrow
      // 19: getfield x/oc4e33ee9eaf.Ǧ Z
      // 1c: goto 20
      // 1f: athrow
      // 20: ifeq 4c
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: iload 2
      // 27: ifne 3f
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 31: ifnull 4c
      // 34: goto 38
      // 37: athrow
      // 38: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3b: goto 3f
      // 3e: athrow
      // 3f: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 42: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 45: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 48: bipush 0
      // 49: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 4c: aload 0
      // 4d: aconst_null
      // 4e: putfield x/oc4e33ee9eaf.Ǐ Lnet/minecraft/util/BlockPos;
      // 51: aload 0
      // 52: aconst_null
      // 53: putfield x/oc4e33ee9eaf.ԁ Lnet/minecraft/util/BlockPos;
      // 56: aload 0
      // 57: aconst_null
      // 58: putfield x/oc4e33ee9eaf.Ӹ Lx/occc87ebdd7c;
      // 5b: aload 0
      // 5c: bipush 0
      // 5d: putfield x/oc4e33ee9eaf.Ы I
      // 60: aload 0
      // 61: bipush 0
      // 62: putfield x/oc4e33ee9eaf.Ԑ I
      // 65: aload 0
      // 66: bipush 0
      // 67: putfield x/oc4e33ee9eaf.ѐ I
      // 6a: aload 0
      // 6b: bipush 0
      // 6c: putfield x/oc4e33ee9eaf.n I
      // 6f: aload 0
      // 70: bipush 0
      // 71: putfield x/oc4e33ee9eaf.Ԡ I
      // 74: aload 0
      // 75: bipush 0
      // 76: putfield x/oc4e33ee9eaf.Ų Z
      // 79: aload 0
      // 7a: bipush 0
      // 7b: putfield x/oc4e33ee9eaf.Ǧ Z
      // 7e: aload 0
      // 7f: getfield x/oc4e33ee9eaf.Ӊ Ljava/util/Map;
      // 82: invokeinterface java/util/Map.clear ()V 1
      // 87: return
   }

   private void ѿ(String var1) {
      try {
         if (this.ϗ.ǭ()) {
            oc7ab2161b9f.ý("&7[Bed Defender] " + var1);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   static int ǯ() {
      return ƃ.size();
   }

   static int ɢ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: getstatic x/oc4e33ee9eaf.ƃ Ljava/util/List;
      // 06: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0b: astore 2
      // 0c: istore 1
      // 0d: aload 2
      // 0e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 13: ifeq 49
      // 16: aload 2
      // 17: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1c: checkcast x/occd75b77c2f
      // 1f: astore 3
      // 20: aload 3
      // 21: iload 1
      // 22: ifne 3c
      // 25: getfield x/occd75b77c2f.Ȕ Ljava/lang/String;
      // 28: aload 0
      // 29: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2c: iload 1
      // 2d: ifne 4a
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 45
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 3
      // 3c: getfield x/occd75b77c2f.ъ Ljava/util/List;
      // 3f: invokeinterface java/util/List.size ()I 1
      // 44: ireturn
      // 45: iload 1
      // 46: ifeq 0d
      // 49: bipush 0
      // 4a: ireturn
   }

   static int đ(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: iload 0
      // 05: iload 1
      // 06: ifne 67
      // 09: ldc_w -1794528427
      // 0c: ldc_w -1794528418
      // 0f: ixor
      // 10: iand
      // 11: tableswitch 85 0 11 64 69 67 77 85 85 85 85 67 77 64 69
      // 50: athrow
      // 51: bipush 0
      // 52: ireturn
      // 53: athrow
      // 54: bipush 1
      // 55: ireturn
      // 56: ldc_w -1794528420
      // 59: ldc_w -1794528418
      // 5c: ixor
      // 5d: ireturn
      // 5e: ldc_w -1794528419
      // 61: ldc_w -1794528418
      // 64: ixor
      // 65: ireturn
      // 66: bipush 0
      // 67: ireturn
   }

   static BlockPos ʑ(BlockPos var0, int var1) {
      int var2 = var0.getX();
      int var3 = var0.getY();
      int var4 = var0.getZ();

      try {
         switch (var1) {
            case 1:
               return new BlockPos(-var2, var3, -var4);
            case 2:
               return new BlockPos(-var4, var3, var2);
            case 3:
               return new BlockPos(var4, var3, -var2);
            default:
               return var0;
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }
   }

   private static Vec3 ѝ(BlockPos param0, EnumFacing param1, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 0.051000000000000004
      // 03: dstore 7
      // 05: getstatic x/oc84f20a0bc5.ė I
      // 08: ldc2_w 0.949
      // 0b: dstore 9
      // 0d: istore 6
      // 0f: aload 1
      // 10: iload 6
      // 12: ifne 24
      // 15: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 18: if_acmpeq 33
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 1
      // 20: goto 24
      // 23: athrow
      // 24: iload 6
      // 26: ifne 64
      // 29: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 2c: if_acmpne 63
      // 2f: goto 33
      // 32: athrow
      // 33: new net/minecraft/util/Vec3
      // 36: dup
      // 37: aload 0
      // 38: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 3b: i2d
      // 3c: dload 2
      // 3d: dadd
      // 3e: aload 0
      // 3f: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 42: i2d
      // 43: aload 1
      // 44: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 47: if_acmpne 54
      // 4a: goto 4e
      // 4d: athrow
      // 4e: dload 9
      // 50: goto 56
      // 53: athrow
      // 54: dload 7
      // 56: dadd
      // 57: aload 0
      // 58: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 5b: i2d
      // 5c: dload 4
      // 5e: dadd
      // 5f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 62: areturn
      // 63: aload 1
      // 64: iload 6
      // 66: ifne 78
      // 69: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 6c: if_acmpeq 7e
      // 6f: goto 73
      // 72: athrow
      // 73: aload 1
      // 74: goto 78
      // 77: athrow
      // 78: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 7b: if_acmpne ae
      // 7e: new net/minecraft/util/Vec3
      // 81: dup
      // 82: aload 0
      // 83: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 86: i2d
      // 87: dload 2
      // 88: dadd
      // 89: aload 0
      // 8a: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 8d: i2d
      // 8e: dload 4
      // 90: dadd
      // 91: aload 0
      // 92: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 95: i2d
      // 96: aload 1
      // 97: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 9a: if_acmpne a7
      // 9d: goto a1
      // a0: athrow
      // a1: dload 9
      // a3: goto a9
      // a6: athrow
      // a7: dload 7
      // a9: dadd
      // aa: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // ad: areturn
      // ae: new net/minecraft/util/Vec3
      // b1: dup
      // b2: aload 0
      // b3: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // b6: i2d
      // b7: aload 1
      // b8: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // bb: if_acmpne c4
      // be: dload 9
      // c0: goto c6
      // c3: athrow
      // c4: dload 7
      // c6: dadd
      // c7: aload 0
      // c8: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // cb: i2d
      // cc: dload 4
      // ce: dadd
      // cf: aload 0
      // d0: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // d3: i2d
      // d4: dload 2
      // d5: dadd
      // d6: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // d9: areturn
   }

   private static float J(float var0, float var1) {
      return var1 + MathHelper.wrapAngleTo180_float(var0 - var1);
   }

   private static double Ћ(double var0) {
      return Math.max(0.0, Math.min(1.0, var0));
   }

   private static double Ö(double var0) {
      return ThreadLocalRandom.current().nextDouble(-var0, var0);
   }

   private static String[] ӏ() {
      try {
         if (ƃ.isEmpty()) {
            return new String[]{"Unavailable"};
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      String[] var0 = new String[ƃ.size()];
      int var1 = 0;

      try {
         while (var1 < ƃ.size()) {
            var0[var1] = ƃ.get(var1).Ȕ;
            var1++;
         }

         return var0;
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   private static byte[] ʄ(byte[] param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: arraylength
      // 02: ldc_w 1967060509
      // 05: ldc_w 1967060505
      // 08: ixor
      // 09: if_icmplt c5
      // 0c: aload 0
      // 0d: bipush 0
      // 0e: baload
      // 0f: ldc_w 1967060710
      // 12: ldc_w 1967060505
      // 15: ixor
      // 16: iand
      // 17: ldc_w 1967060644
      // 1a: ldc_w 1967060505
      // 1d: ixor
      // 1e: if_icmpne c5
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: bipush 1
      // 27: baload
      // 28: ldc_w 1967060710
      // 2b: ldc_w 1967060505
      // 2e: ixor
      // 2f: iand
      // 30: ldc_w 1967060678
      // 33: ldc_w 1967060505
      // 36: ixor
      // 37: if_icmpne c5
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: ldc_w 1967060507
      // 42: ldc_w 1967060505
      // 45: ixor
      // 46: baload
      // 47: ldc_w 1967060710
      // 4a: ldc_w 1967060505
      // 4d: ixor
      // 4e: iand
      // 4f: bipush 1
      // 50: if_icmpne c5
      // 53: goto 57
      // 56: athrow
      // 57: aload 0
      // 58: ldc_w 1967060506
      // 5b: ldc_w 1967060505
      // 5e: ixor
      // 5f: baload
      // 60: ldc_w 1967060710
      // 63: ldc_w 1967060505
      // 66: ixor
      // 67: iand
      // 68: ifne c5
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 0
      // 70: arraylength
      // 71: ldc_w 1967060509
      // 74: ldc_w 1967060505
      // 77: ixor
      // 78: isub
      // 79: newarray 8
      // 7b: astore 1
      // 7c: ldc2_w 7904181305839816692
      // 7f: ldc2_w 2375660149610695608
      // 82: lxor
      // 83: lstore 2
      // 84: bipush 0
      // 85: istore 4
      // 87: iload 4
      // 89: aload 1
      // 8a: arraylength
      // 8b: if_icmpge c3
      // 8e: lload 2
      // 8f: ldc2_w 8694760368172283029
      // 92: ldc2_w 2375660149610695608
      // 95: lxor
      // 96: lmul
      // 97: ldc2_w 3818332507032472311
      // 9a: ldc2_w 2375660149610695608
      // 9d: lxor
      // 9e: ladd
      // 9f: lstore 2
      // a0: aload 1
      // a1: iload 4
      // a3: aload 0
      // a4: ldc_w 1967060509
      // a7: ldc_w 1967060505
      // aa: ixor
      // ab: iload 4
      // ad: iadd
      // ae: baload
      // af: i2l
      // b0: lload 2
      // b1: ldc_w 1967060537
      // b4: ldc_w 1967060505
      // b7: ixor
      // b8: lushr
      // b9: lxor
      // ba: l2i
      // bb: i2b
      // bc: bastore
      // bd: iinc 4 1
      // c0: goto 87
      // c3: aload 1
      // c4: areturn
      // c5: aload 0
      // c6: areturn
   }

   private static List<occd75b77c2f> ƒ() {
      InputStream var0 = oc4e33ee9eaf.class.getResourceAsStream("/assets/miau/bed_defenses.json");

      try {
         if (var0 == null) {
            return Collections.emptyList();
         }
      } catch (Throwable var22) {
         throw var22;
      }

      try {
         InputStream var1 = var0;

         List var24;
         label117: {
            List var23;
            try {
               label130: {
                  byte[] var2 = ʄ(var1.readAllBytes());
                  JsonElement var3 = new JsonParser().parse(new String(var2, StandardCharsets.UTF_8));

                  try {
                     if (var3 == null || !var3.isJsonObject()) {
                        break label130;
                     }
                  } catch (Throwable var16) {
                     throw var16;
                  }

                  ArrayList var4 = new ArrayList();

                  for (Entry var6 : var3.getAsJsonObject().entrySet()) {
                     try {
                        if (!((JsonElement)var6.getValue()).isJsonArray()) {
                           continue;
                        }
                     } catch (Throwable var19) {
                        throw var19;
                     }

                     ArrayList var7 = new ArrayList();

                     for (JsonElement var9 : ((JsonElement)var6.getValue()).getAsJsonArray()) {
                        try {
                           if (!var9.isJsonObject()) {
                              continue;
                           }
                        } catch (Throwable var18) {
                           throw var18;
                        }

                        JsonObject var10 = var9.getAsJsonObject();
                        String var11 = Օ(var10, "block");

                        try {
                           if (!Ս(var11)) {
                              continue;
                           }
                        } catch (Throwable var17) {
                           throw var17;
                        }

                        var7.add(new occ7b8f22a4a(var11, new BlockPos(Т(var10, "x"), Т(var10, "y"), Т(var10, "z"))));
                     }

                     try {
                        if (!var7.isEmpty()) {
                           var4.add(new occd75b77c2f((String)var6.getKey(), Collections.unmodifiableList(var7)));
                        }
                     } catch (Throwable var14) {
                        throw var14;
                     }
                  }

                  var24 = Collections.unmodifiableList(var4);
                  break label117;
               }

               var23 = Collections.emptyList();
            } catch (Throwable var20) {
               if (var0 != null) {
                  try {
                     var1.close();
                  } catch (Throwable var12) {
                     var20.addSuppressed(var12);
                  }
               }

               throw var20;
            }

            try {
               if (var1 != null) {
                  var1.close();
               }

               return var23;
            } catch (Throwable var15) {
               throw var15;
            }
         }

         try {
            if (var1 != null) {
               var1.close();
            }

            return var24;
         } catch (Throwable var13) {
            throw var13;
         }
      } catch (Exception var21) {
         return Collections.emptyList();
      }
   }

   private static String Օ(JsonObject param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 05: astore 2
      // 06: aload 2
      // 07: ifnull 1d
      // 0a: aload 2
      // 0b: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 0e: ifeq 1d
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 19: goto 20
      // 1c: athrow
      // 1d: ldc_w ""
      // 20: areturn
   }

   private static int Т(JsonObject var0, String var1) {
      JsonElement var2 = null;
      int var3 = 740513057 ^ -1996922881;

      while (true) {
         switch (var3) {
            case -1529214242:
               var2 = var0.get(var1);
               if (var2 != null) {
                  var3 = -2082929780 ^ -1996922881;
               } else {
                  var3 = -33097024 ^ -1996922881;
               }
               break;
            case -607376455:
               return var2.getAsInt();
            case 186670195:
               if (var2.isJsonPrimitive()) {
                  var3 = 1396012102 ^ -1996922881;
               } else {
                  var3 = -33097024 ^ -1996922881;
               }
               break;
            case 1996465471:
               return 0;
            default:
               throw null;
         }
      }
   }

   private static Block Ŕ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: ldc_w "end_stone"
      // 07: aload 0
      // 08: iload 1
      // 09: ifne 1f
      // 0c: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0f: ifeq 1b
      // 12: goto 16
      // 15: athrow
      // 16: getstatic net/minecraft/init/Blocks.end_stone Lnet/minecraft/block/Block;
      // 19: areturn
      // 1a: athrow
      // 1b: ldc_w "wool"
      // 1e: aload 0
      // 1f: iload 1
      // 20: ifne 36
      // 23: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 26: ifeq 32
      // 29: goto 2d
      // 2c: athrow
      // 2d: getstatic net/minecraft/init/Blocks.wool Lnet/minecraft/block/Block;
      // 30: areturn
      // 31: athrow
      // 32: ldc_w "stained_glass"
      // 35: aload 0
      // 36: iload 1
      // 37: ifne 4d
      // 3a: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 3d: ifeq 49
      // 40: goto 44
      // 43: athrow
      // 44: getstatic net/minecraft/init/Blocks.stained_glass Lnet/minecraft/block/BlockStainedGlass;
      // 47: areturn
      // 48: athrow
      // 49: ldc_w "planks"
      // 4c: aload 0
      // 4d: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 50: ifeq 58
      // 53: getstatic net/minecraft/init/Blocks.planks Lnet/minecraft/block/Block;
      // 56: areturn
      // 57: athrow
      // 58: aconst_null
      // 59: areturn
   }

   private static boolean Ս(String var0) {
      int var1 = -1477012673 ^ -1269765949;

      while (true) {
         switch (var1) {
            case -977966198:
               return false;
            case -840225799:
               return true;
            case -801459322:
               if (!"stained_glass".equalsIgnoreCase(var0)) {
                  var1 = -523945620 ^ -1269765949;
               } else {
                  var1 = 2042348346 ^ -1269765949;
               }
               break;
            case -278551786:
               if (!"wool".equalsIgnoreCase(var0)) {
                  var1 = 1684691781 ^ -1269765949;
               } else {
                  var1 = 2042348346 ^ -1269765949;
               }
               break;
            case 329677820:
               if (!"end_stone".equalsIgnoreCase(var0)) {
                  var1 = 1530219477 ^ -1269765949;
               } else {
                  var1 = 2042348346 ^ -1269765949;
               }
               break;
            case 1419104687:
               if ("planks".equalsIgnoreCase(var0)) {
                  var1 = 2042348346 ^ -1269765949;
               } else {
                  var1 = 1910866761 ^ -1269765949;
               }
               break;
            default:
               throw null;
         }
      }
   }
}
