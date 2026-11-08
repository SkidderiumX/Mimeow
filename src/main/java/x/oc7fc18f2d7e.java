package x;

public class oc7fc18f2d7e extends oc69da1aa7f5 {
   public final oca9cc61aada ə;
   public final occ2f8dff8d8 Ϩ;
   public final occ2f8dff8d8 º;
   private boolean Ǻ;
   private long գ;
   private String Ɣ;
   public static boolean Ƨ;

   public oc7fc18f2d7e() {
      super("FastPlace", oce4cea752dd.з);
      this.ą("Reduces the vanilla four-tick placement delay.");
      this.ʌ(this.ə = new oca9cc61aada("Delay", " ticks", 1.0, 1.0, 4.0, 1.0, "Tick delay"));
      this.ʌ(this.Ϩ = new occ2f8dff8d8("Blocks only", true, new String[]{"Filter.Blocks only"}));
      this.ʌ(this.º = new occ2f8dff8d8("Show block count", true));
      this.ɮ = true;
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
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: ifeq 034
      // 00a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00d: iload 1
      // 00e: ifne 026
      // 011: goto 015
      // 014: athrow
      // 015: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 018: ifnonnull 034
      // 01b: goto 01f
      // 01e: athrow
      // 01f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 022: goto 026
      // 025: athrow
      // 026: iload 1
      // 027: ifne 03e
      // 02a: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 02d: ifne 03b
      // 030: goto 034
      // 033: athrow
      // 034: aload 0
      // 035: bipush 0
      // 036: invokevirtual x/oc7fc18f2d7e.ҏ (Z)V
      // 039: return
      // 03a: athrow
      // 03b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 041: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 044: astore 2
      // 045: aload 2
      // 046: iload 1
      // 047: ifne 052
      // 04a: ifnull 0ab
      // 04d: goto 051
      // 050: athrow
      // 051: aload 2
      // 052: iload 1
      // 053: ifne 065
      // 056: getfield net/minecraft/item/ItemStack.stackSize I
      // 059: ifle 0ab
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 2
      // 061: goto 065
      // 064: athrow
      // 065: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 068: iload 1
      // 069: ifne 07e
      // 06c: instanceof net/minecraft/item/ItemBlock
      // 06f: ifeq 0ab
      // 072: goto 076
      // 075: athrow
      // 076: aload 2
      // 077: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 07a: goto 07e
      // 07d: athrow
      // 07e: checkcast net/minecraft/item/ItemBlock
      // 081: iload 1
      // 082: ifne 09d
      // 085: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 088: invokestatic x/occb1ed1ed8f.Ў (Lnet/minecraft/block/Block;)Z
      // 08b: ifeq 0ab
      // 08e: goto 092
      // 091: athrow
      // 092: aload 2
      // 093: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 096: checkcast net/minecraft/item/ItemBlock
      // 099: goto 09d
      // 09c: athrow
      // 09d: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 0a0: getstatic net/minecraft/init/Blocks.pumpkin Lnet/minecraft/block/Block;
      // 0a3: if_acmpeq 0ab
      // 0a6: bipush 1
      // 0a7: goto 0ac
      // 0aa: athrow
      // 0ab: bipush 0
      // 0ac: istore 3
      // 0ad: iload 3
      // 0ae: iload 1
      // 0af: ifne 0d7
      // 0b2: ifne 0d6
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 0
      // 0ba: getfield x/oc7fc18f2d7e.Ϩ Lx/occ2f8dff8d8;
      // 0bd: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0c0: iload 1
      // 0c1: ifne 0d7
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: ifeq 0d6
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 0
      // 0d0: bipush 0
      // 0d1: invokevirtual x/oc7fc18f2d7e.ҏ (Z)V
      // 0d4: return
      // 0d5: athrow
      // 0d6: iload 3
      // 0d7: iload 1
      // 0d8: ifne 0f5
      // 0db: ifeq 155
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 0
      // 0e3: iload 1
      // 0e4: ifne 15a
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: getfield x/oc7fc18f2d7e.º Lx/occ2f8dff8d8;
      // 0ee: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: ifeq 155
      // 0f8: aload 2
      // 0f9: getfield net/minecraft/item/ItemStack.stackSize I
      // 0fc: istore 4
      // 0fe: iload 4
      // 100: iload 1
      // 101: ifne 118
      // 104: ldc 5925195
      // 106: ldc 5925198
      // 108: ixor
      // 109: if_icmpgt 116
      // 10c: goto 110
      // 10f: athrow
      // 110: ldc "§c"
      // 112: goto 140
      // 115: athrow
      // 116: iload 4
      // 118: iload 1
      // 119: ifne 130
      // 11c: ldc 5925185
      // 11e: ldc 5925198
      // 120: ixor
      // 121: if_icmpgt 12e
      // 124: goto 128
      // 127: athrow
      // 128: ldc "§6"
      // 12a: goto 140
      // 12d: athrow
      // 12e: iload 4
      // 130: ldc 5925207
      // 132: ldc 5925198
      // 134: ixor
      // 135: if_icmpgt 13e
      // 138: ldc "§e"
      // 13a: goto 140
      // 13d: athrow
      // 13e: ldc ""
      // 140: astore 5
      // 142: iload 1
      // 143: aload 0
      // 144: aload 5
      // 146: iload 4
      // 148: ldc "§f blocks"
      // 14a: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 14f: putfield x/oc7fc18f2d7e.Ɣ Ljava/lang/String;
      // 152: ifeq 15e
      // 155: aload 0
      // 156: goto 15a
      // 159: athrow
      // 15a: aconst_null
      // 15b: putfield x/oc7fc18f2d7e.Ɣ Ljava/lang/String;
      // 15e: aload 0
      // 15f: bipush 1
      // 160: invokevirtual x/oc7fc18f2d7e.ҏ (Z)V
      // 163: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 166: astore 4
      // 168: aload 0
      // 169: getfield x/oc7fc18f2d7e.ə Lx/oca9cc61aada;
      // 16c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 16f: d2i
      // 170: istore 5
      // 172: iload 5
      // 174: iload 1
      // 175: ifne 193
      // 178: bipush 1
      // 179: if_icmpeq 19b
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 4
      // 182: iload 1
      // 183: ifne 1a1
      // 186: goto 18a
      // 189: athrow
      // 18a: invokeinterface x/oc8ecfa69e1b.getRightClickDelayTimer ()I 1
      // 18f: goto 193
      // 192: athrow
      // 193: ldc 5925194
      // 195: ldc 5925198
      // 197: ixor
      // 198: if_icmpne 1a8
      // 19b: aload 4
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: iload 5
      // 1a3: invokeinterface x/oc8ecfa69e1b.setRightClickDelayTimer (I)V 2
      // 1a8: return
   }

   @oc66fa4f2195
   public void Ű(oc9d4393f3ce param1) {
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
      // 06: ifne 1b
      // 09: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 0c: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 0f: ifeq 79
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
      // 24: ifne 3b
      // 27: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockDirection ()I
      // 2a: ldc -1294126108
      // 2c: ldc -1294126309
      // 2e: ixor
      // 2f: if_icmpne 79
      // 32: goto 36
      // 35: athrow
      // 36: aload 3
      // 37: goto 3b
      // 3a: athrow
      // 3b: iload 2
      // 3c: ifne 4e
      // 3f: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 42: ifnull 79
      // 45: goto 49
      // 48: athrow
      // 49: aload 3
      // 4a: goto 4e
      // 4d: athrow
      // 4e: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 51: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 54: instanceof net/minecraft/item/ItemBlock
      // 57: iload 2
      // 58: ifne 6d
      // 5b: ifeq 79
      // 5e: goto 62
      // 61: athrow
      // 62: invokestatic java/lang/Math.random ()D
      // 65: ldc2_w 0.4
      // 68: dcmpl
      // 69: goto 6d
      // 6c: athrow
      // 6d: ifle 79
      // 70: aload 1
      // 71: bipush 1
      // 72: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 75: goto 79
      // 78: athrow
      // 79: return
   }

   @oc66fa4f2195
   public void Ϭ(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 008: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 00b: if_acmpne 061
      // 00e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 011: ifeq 061
      // 014: goto 018
      // 017: athrow
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 01e: ifnonnull 061
      // 021: goto 025
      // 024: athrow
      // 025: aload 0
      // 026: iload 2
      // 027: ifne 040
      // 02a: goto 02e
      // 02d: athrow
      // 02e: getfield x/oc7fc18f2d7e.º Lx/occ2f8dff8d8;
      // 031: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 034: ifeq 061
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: goto 040
      // 03f: athrow
      // 040: getfield x/oc7fc18f2d7e.Ɣ Ljava/lang/String;
      // 043: ifnull 061
      // 046: getstatic x/oc9755810e45.ǜ Lx/oc668fce0dbf;
      // 049: iload 2
      // 04a: ifne 05b
      // 04d: goto 051
      // 050: athrow
      // 051: ifnull 063
      // 054: goto 058
      // 057: athrow
      // 058: getstatic x/oc9755810e45.ǜ Lx/oc668fce0dbf;
      // 05b: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 05e: ifeq 063
      // 061: return
      // 062: athrow
      // 063: fconst_1
      // 064: invokestatic java/lang/System.currentTimeMillis ()J
      // 067: aload 0
      // 068: getfield x/oc7fc18f2d7e.գ J
      // 06b: lsub
      // 06c: l2f
      // 06d: ldc_w 125.0
      // 070: fdiv
      // 071: invokestatic java/lang/Math.min (FF)F
      // 074: fstore 3
      // 075: ldc_w 240.0
      // 078: aload 0
      // 079: getfield x/oc7fc18f2d7e.Ǻ Z
      // 07c: ifeq 084
      // 07f: fload 3
      // 080: goto 087
      // 083: athrow
      // 084: fconst_1
      // 085: fload 3
      // 086: fsub
      // 087: fmul
      // 088: f2i
      // 089: istore 4
      // 08b: iload 4
      // 08d: iload 2
      // 08e: ifne 0a8
      // 091: ifgt 0b1
      // 094: goto 098
      // 097: athrow
      // 098: aload 0
      // 099: iload 2
      // 09a: ifne 0ac
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: getfield x/oc7fc18f2d7e.Ǻ Z
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: ifne 0b0
      // 0ab: aload 0
      // 0ac: aconst_null
      // 0ad: putfield x/oc7fc18f2d7e.Ɣ Ljava/lang/String;
      // 0b0: return
      // 0b1: new net/minecraft/client/gui/ScaledResolution
      // 0b4: dup
      // 0b5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b8: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0bb: astore 5
      // 0bd: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 0c0: ldc_w 155048489
      // 0c3: ldc_w 155048235
      // 0c6: ixor
      // 0c7: ldc_w 155048488
      // 0ca: ldc_w 155048235
      // 0cd: ixor
      // 0ce: bipush 1
      // 0cf: bipush 0
      // 0d0: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 0d3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d6: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 0d9: aload 0
      // 0da: getfield x/oc7fc18f2d7e.Ɣ Ljava/lang/String;
      // 0dd: aload 5
      // 0df: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 0e2: i2f
      // 0e3: fconst_2
      // 0e4: fdiv
      // 0e5: ldc_w 11.0
      // 0e8: fadd
      // 0e9: aload 5
      // 0eb: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 0ee: i2f
      // 0ef: fconst_2
      // 0f0: fdiv
      // 0f1: ldc_w 3.0
      // 0f4: fsub
      // 0f5: iload 4
      // 0f7: ldc_w 155048243
      // 0fa: ldc_w 155048235
      // 0fd: ixor
      // 0fe: ishl
      // 0ff: ldc_w 163718868
      // 102: ldc_w 155048235
      // 105: ixor
      // 106: ior
      // 107: bipush 1
      // 108: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 10b: pop
      // 10c: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 10f: return
   }

   @Override
   public void onDisable() {
      this.Ǻ = false;
      this.գ = 0L;
      this.Ɣ = null;
   }

   private void ҏ(boolean param1) {
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
      // 06: ifne 1e
      // 09: getfield x/oc7fc18f2d7e.Ǻ Z
      // 0c: iload 1
      // 0d: if_icmpeq 24
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: iload 1
      // 16: putfield x/oc7fc18f2d7e.Ǻ Z
      // 19: aload 0
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokestatic java/lang/System.currentTimeMillis ()J
      // 21: putfield x/oc7fc18f2d7e.գ J
      // 24: return
   }
}
