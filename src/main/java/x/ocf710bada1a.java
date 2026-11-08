package x;

public class ocf710bada1a extends oc69da1aa7f5 {
   private oca9cc61aada Η;
   private occ2f8dff8d8 ɾ;
   private occ2f8dff8d8 ĉ;
   private occ2f8dff8d8 đ;
   private occ2f8dff8d8 ε;
   private oca9cc61aada Ƿ;
   private occ2f8dff8d8 ҡ;
   private occ2f8dff8d8 Ջ;
   private oca9cc61aada Ɠ;
   private oca9cc61aada ʝ;
   private String[] Զ;
   private String[] Ɵ;
   private int į;
   private boolean Ǐ;
   public boolean Ù;
   public static boolean Ѡ;

   public ocf710bada1a() {
      super("AntiAFK", oce4cea752dd.з);
      String[] var10001 = new String[1850567711 ^ 1850567706];
      var10001[0] = "None";
      var10001[1] = "Wander";
      var10001[1850567704 ^ 1850567706] = "Lateral shuffle";
      var10001[1850567705 ^ 1850567706] = "Forward";
      var10001[1850567710 ^ 1850567706] = "Backward";
      this.Զ = var10001;
      var10001 = new String[1850567710 ^ 1850567706];
      var10001[0] = "None";
      var10001[1] = "Random";
      var10001[1850567704 ^ 1850567706] = "Right";
      var10001[1850567705 ^ 1850567706] = "Left";
      this.Ɵ = var10001;
      this.Ù = false;
      this.ʌ(this.Η = new oca9cc61aada("AFK", 0, this.Զ));
      this.ʌ(this.ɾ = new occ2f8dff8d8("Jump", false));
      this.ʌ(this.ĉ = new occ2f8dff8d8("Jump only when collided", false));
      this.ʌ(this.đ = new occ2f8dff8d8("Random clicks", false));
      this.ʌ(this.ε = new occ2f8dff8d8("Swap item", false));
      this.ʌ(this.Ƿ = new oca9cc61aada("Spin", 0, this.Ɵ));
      this.ʌ(this.ҡ = new occ2f8dff8d8("Randomize delta", true));
      this.ʌ(this.Ջ = new occ2f8dff8d8("Randomize pitch", true));
      this.ʌ(this.Ɠ = new oca9cc61aada("Minimum delay ticks", 10.0, 4.0, 160.0, 2.0));
      this.ʌ(this.ʝ = new oca9cc61aada("Maximum delay ticks", 80.0, 4.0, 160.0, 2.0));
   }

   @Override
   public void onEnable() {
      this.į = this.н();
      this.Ǐ = oc7ab2161b9f.û().nextBoolean();
   }

   @oc66fa4f2195
   public void Ù(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: getfield x/ocf710bada1a.Ù Z
      // 008: ifeq 00d
      // 00b: return
      // 00c: athrow
      // 00d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 010: iload 2
      // 011: ifne 025
      // 014: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 017: ifnull 037
      // 01a: goto 01e
      // 01d: athrow
      // 01e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 021: goto 025
      // 024: athrow
      // 025: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 028: instanceof net/minecraft/client/gui/GuiChat
      // 02b: iload 2
      // 02c: ifne 051
      // 02f: ifne 037
      // 032: goto 036
      // 035: athrow
      // 036: return
      // 037: aload 0
      // 038: iload 2
      // 039: ifne 156
      // 03c: dup
      // 03d: getfield x/ocf710bada1a.į I
      // 040: bipush 1
      // 041: isub
      // 042: putfield x/ocf710bada1a.į I
      // 045: aload 0
      // 046: getfield x/ocf710bada1a.Η Lx/oca9cc61aada;
      // 049: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 04c: d2i
      // 04d: goto 051
      // 050: athrow
      // 051: tableswitch 260 1 4 31 150 216 240
      // 070: aload 0
      // 071: getfield x/ocf710bada1a.Ǐ Z
      // 074: iload 2
      // 075: ifne 0da
      // 078: goto 07c
      // 07b: athrow
      // 07c: ifeq 0b5
      // 07f: goto 083
      // 082: athrow
      // 083: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 086: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 089: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // 08c: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 08f: invokestatic x/oc7ab2161b9f.û ()Ljava/util/Random;
      // 092: invokevirtual java/util/Random.nextBoolean ()Z
      // 095: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 098: iload 2
      // 099: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 09f: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 0a2: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0a5: invokestatic x/oc7ab2161b9f.û ()Ljava/util/Random;
      // 0a8: invokevirtual java/util/Random.nextBoolean ()Z
      // 0ab: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 0ae: ifeq 155
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b8: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0bb: getfield net/minecraft/client/settings/GameSettings.keyBindBack Lnet/minecraft/client/settings/KeyBinding;
      // 0be: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0c1: invokestatic x/oc7ab2161b9f.û ()Ljava/util/Random;
      // 0c4: invokevirtual java/util/Random.nextBoolean ()Z
      // 0c7: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 0ca: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cd: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0d0: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 0d3: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: invokestatic x/oc7ab2161b9f.û ()Ljava/util/Random;
      // 0dd: invokevirtual java/util/Random.nextBoolean ()Z
      // 0e0: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 0e3: iload 2
      // 0e4: ifeq 155
      // 0e7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ea: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0ed: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 0f0: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0f3: aload 0
      // 0f4: getfield x/ocf710bada1a.Ǐ Z
      // 0f7: iload 2
      // 0f8: ifne 11e
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 102: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 105: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 108: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 10b: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 10e: aload 0
      // 10f: getfield x/ocf710bada1a.Ǐ Z
      // 112: ifne 121
      // 115: goto 119
      // 118: athrow
      // 119: bipush 1
      // 11a: goto 11e
      // 11d: athrow
      // 11e: goto 122
      // 121: bipush 0
      // 122: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 125: iload 2
      // 126: ifeq 155
      // 129: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 12f: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // 132: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 135: bipush 1
      // 136: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 139: iload 2
      // 13a: ifeq 155
      // 13d: goto 141
      // 140: athrow
      // 141: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 144: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 147: getfield net/minecraft/client/settings/GameSettings.keyBindBack Lnet/minecraft/client/settings/KeyBinding;
      // 14a: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 14d: bipush 1
      // 14e: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 151: goto 155
      // 154: athrow
      // 155: aload 0
      // 156: iload 2
      // 157: ifne 1e0
      // 15a: getfield x/ocf710bada1a.Ƿ Lx/oca9cc61aada;
      // 15d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 160: d2i
      // 161: tableswitch 126 1 3 28 64 97
      // 17c: athrow
      // 17d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 180: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 183: dup
      // 184: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 187: f2d
      // 188: aload 0
      // 189: aload 0
      // 18a: getfield x/ocf710bada1a.Ǐ Z
      // 18d: invokevirtual x/ocf710bada1a.ѳ (Z)D
      // 190: dadd
      // 191: d2f
      // 192: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 195: iload 2
      // 196: aload 0
      // 197: invokevirtual x/ocf710bada1a.ä ()V
      // 19a: ifeq 1df
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a7: dup
      // 1a8: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1ab: f2d
      // 1ac: aload 0
      // 1ad: bipush 1
      // 1ae: invokevirtual x/ocf710bada1a.ѳ (Z)D
      // 1b1: dadd
      // 1b2: d2f
      // 1b3: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1b6: iload 2
      // 1b7: aload 0
      // 1b8: invokevirtual x/ocf710bada1a.ä ()V
      // 1bb: ifeq 1df
      // 1be: goto 1c2
      // 1c1: athrow
      // 1c2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c8: dup
      // 1c9: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1cc: f2d
      // 1cd: aload 0
      // 1ce: bipush 0
      // 1cf: invokevirtual x/ocf710bada1a.ѳ (Z)D
      // 1d2: dadd
      // 1d3: d2f
      // 1d4: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1d7: aload 0
      // 1d8: invokevirtual x/ocf710bada1a.ä ()V
      // 1db: goto 1df
      // 1de: athrow
      // 1df: aload 0
      // 1e0: iload 2
      // 1e1: ifne 245
      // 1e4: getfield x/ocf710bada1a.ɾ Lx/occ2f8dff8d8;
      // 1e7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1ea: ifeq 244
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f7: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 1fa: iload 2
      // 1fb: ifne 250
      // 1fe: goto 202
      // 201: athrow
      // 202: ifeq 244
      // 205: goto 209
      // 208: athrow
      // 209: aload 0
      // 20a: getfield x/ocf710bada1a.ĉ Lx/occ2f8dff8d8;
      // 20d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 210: iload 2
      // 211: ifne 22c
      // 214: goto 218
      // 217: athrow
      // 218: ifeq 237
      // 21b: goto 21f
      // 21e: athrow
      // 21f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 222: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 225: getfield net/minecraft/client/entity/EntityPlayerSP.isCollidedHorizontally Z
      // 228: goto 22c
      // 22b: athrow
      // 22c: iload 2
      // 22d: ifne 250
      // 230: ifeq 244
      // 233: goto 237
      // 236: athrow
      // 237: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 23d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.jump ()V
      // 240: goto 244
      // 243: athrow
      // 244: aload 0
      // 245: iload 2
      // 246: ifne 254
      // 249: getfield x/ocf710bada1a.į I
      // 24c: goto 250
      // 24f: athrow
      // 250: ifne 2c0
      // 253: aload 0
      // 254: iload 2
      // 255: ifne 27f
      // 258: getfield x/ocf710bada1a.ε Lx/occ2f8dff8d8;
      // 25b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 25e: ifeq 27e
      // 261: goto 265
      // 264: athrow
      // 265: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 268: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 26e: bipush 0
      // 26f: ldc -539471987
      // 271: ldc -539471995
      // 273: ixor
      // 274: invokestatic x/oc7ab2161b9f.ե (II)I
      // 277: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 27a: goto 27e
      // 27d: athrow
      // 27e: aload 0
      // 27f: iload 2
      // 280: ifne 2ad
      // 283: getfield x/ocf710bada1a.đ Lx/occ2f8dff8d8;
      // 286: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 289: ifeq 29c
      // 28c: goto 290
      // 28f: athrow
      // 290: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 293: invokeinterface x/oc8ecfa69e1b.callClickMouse ()V 1
      // 298: goto 29c
      // 29b: athrow
      // 29c: aload 0
      // 29d: aload 0
      // 29e: invokevirtual x/ocf710bada1a.н ()I
      // 2a1: iload 2
      // 2a2: ifne 2b9
      // 2a5: putfield x/ocf710bada1a.į I
      // 2a8: aload 0
      // 2a9: goto 2ad
      // 2ac: athrow
      // 2ad: aload 0
      // 2ae: getfield x/ocf710bada1a.Ǐ Z
      // 2b1: ifne 2bc
      // 2b4: bipush 1
      // 2b5: goto 2b9
      // 2b8: athrow
      // 2b9: goto 2bd
      // 2bc: bipush 0
      // 2bd: putfield x/ocf710bada1a.Ǐ Z
      // 2c0: return
   }

   private double ǜ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.û ()Ljava/util/Random;
      // 07: invokevirtual java/util/Random.nextBoolean ()Z
      // 0a: iload 1
      // 0b: ifne 16
      // 0e: ifeq 19
      // 11: goto 15
      // 14: athrow
      // 15: bipush 1
      // 16: goto 1a
      // 19: bipush -1
      // 1a: istore 2
      // 1b: aload 0
      // 1c: getfield x/ocf710bada1a.ҡ Lx/occ2f8dff8d8;
      // 1f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22: iload 1
      // 23: ifne 4a
      // 26: ifne 39
      // 29: goto 2d
      // 2c: athrow
      // 2d: ldc_w -857560030
      // 30: ldc_w -857560032
      // 33: ixor
      // 34: iload 2
      // 35: imul
      // 36: i2d
      // 37: dreturn
      // 38: athrow
      // 39: ldc_w -857559996
      // 3c: ldc_w -857560032
      // 3f: ixor
      // 40: ldc_w -857559596
      // 43: ldc_w -857560032
      // 46: ixor
      // 47: invokestatic x/oc7ab2161b9f.ե (II)I
      // 4a: i2d
      // 4b: ldc2_w 100.0
      // 4e: ddiv
      // 4f: dstore 3
      // 50: dload 3
      // 51: dconst_1
      // 52: drem
      // 53: iload 1
      // 54: ifne 7a
      // 57: dconst_0
      // 58: dcmpl
      // 59: ifne 76
      // 5c: goto 60
      // 5f: athrow
      // 60: dload 3
      // 61: bipush 1
      // 62: ldc_w -857560022
      // 65: ldc_w -857560032
      // 68: ixor
      // 69: invokestatic x/oc7ab2161b9f.ե (II)I
      // 6c: i2d
      // 6d: ldc2_w 10.0
      // 70: ddiv
      // 71: iload 2
      // 72: i2d
      // 73: dmul
      // 74: dadd
      // 75: dstore 3
      // 76: dload 3
      // 77: iload 2
      // 78: i2d
      // 79: dmul
      // 7a: dreturn
   }

   @Override
   public void onDisable() {
      this.t(0);
      this.Ù = false;
   }

   private void t(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 69
      // 09: tableswitch 188 1 4 32 104 144 168
      // 28: athrow
      // 29: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 2f: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // 32: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 35: bipush 0
      // 36: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 39: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 3f: getfield net/minecraft/client/settings/GameSettings.keyBindBack Lnet/minecraft/client/settings/KeyBinding;
      // 42: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 45: bipush 0
      // 46: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 49: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 4f: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 52: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 55: bipush 0
      // 56: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 59: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 5f: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 62: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 65: goto 69
      // 68: athrow
      // 69: bipush 0
      // 6a: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 6d: iload 2
      // 6e: ifeq c5
      // 71: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 74: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 77: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 7a: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 7d: bipush 0
      // 7e: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 81: iload 2
      // 82: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 85: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 88: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 8b: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 8e: bipush 0
      // 8f: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 92: ifeq c5
      // 95: goto 99
      // 98: athrow
      // 99: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 9c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 9f: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // a2: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // a5: bipush 0
      // a6: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // a9: iload 2
      // aa: ifeq c5
      // ad: goto b1
      // b0: athrow
      // b1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b4: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // b7: getfield net/minecraft/client/settings/GameSettings.keyBindBack Lnet/minecraft/client/settings/KeyBinding;
      // ba: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // bd: bipush 0
      // be: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // c1: goto c5
      // c4: athrow
      // c5: return
   }

   private int н() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -831634169 ^ 1076933421;

      while (true) {
         switch (var2) {
            case -1906379222:
               int var10000;
               label28: {
                  label27: {
                     try {
                        double var4;
                        var10000 = (var4 = this.Ɠ.Ӂ() - this.ʝ.Ӂ()) == 0.0 ? 0 : (var4 < 0.0 ? -1 : 1);
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 0) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 482197829 ^ 1076933421;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1780513001 ^ 1076933421;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 705743812:
               return oc7ab2161b9f.ե((int)this.Ɠ.Ӂ(), (int)this.ʝ.Ӂ());
            case 1552773736:
               return (int)this.Ɠ.Ӂ();
            default:
               throw null;
         }
      }
   }

   private void ä() {
      try {
         if (this.Ջ.ǭ()) {
            oc69da1aa7f5.ő.thePlayer.rotationPitch = oc75d51ec7eb.À((float)(oc69da1aa7f5.ő.thePlayer.rotationPitch + this.ǜ()));
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }
   }

   private double ѳ(boolean param1) {
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
      // 06: ifne 11
      // 09: ifeq 14
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 1
      // 11: goto 15
      // 14: bipush -1
      // 15: istore 3
      // 16: aload 0
      // 17: getfield x/ocf710bada1a.ҡ Lx/occ2f8dff8d8;
      // 1a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1d: iload 2
      // 1e: ifne 45
      // 21: ifne 34
      // 24: goto 28
      // 27: athrow
      // 28: ldc_w 639858807
      // 2b: ldc_w 639858804
      // 2e: ixor
      // 2f: iload 3
      // 30: imul
      // 31: i2d
      // 32: dreturn
      // 33: athrow
      // 34: ldc_w 639858704
      // 37: ldc_w 639858804
      // 3a: ixor
      // 3b: ldc_w 639859612
      // 3e: ldc_w 639858804
      // 41: ixor
      // 42: invokestatic x/oc7ab2161b9f.ե (II)I
      // 45: i2d
      // 46: ldc2_w 100.0
      // 49: ddiv
      // 4a: dstore 4
      // 4c: dload 4
      // 4e: iload 2
      // 4f: ifne 7a
      // 52: dconst_1
      // 53: drem
      // 54: dconst_0
      // 55: dcmpl
      // 56: ifne 75
      // 59: goto 5d
      // 5c: athrow
      // 5d: dload 4
      // 5f: bipush 1
      // 60: ldc_w 639858814
      // 63: ldc_w 639858804
      // 66: ixor
      // 67: invokestatic x/oc7ab2161b9f.ե (II)I
      // 6a: i2d
      // 6b: ldc2_w 10.0
      // 6e: ddiv
      // 6f: iload 3
      // 70: i2d
      // 71: dmul
      // 72: dadd
      // 73: dstore 4
      // 75: dload 4
      // 77: iload 3
      // 78: i2d
      // 79: dmul
      // 7a: dreturn
   }
}
