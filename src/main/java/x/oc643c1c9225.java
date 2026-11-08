package x;

import net.minecraft.entity.player.InventoryPlayer;

public class oc643c1c9225 extends oc69da1aa7f5 {
   private final oca9cc61aada Ǒ;
   private final oca9cc61aada é;
   private final occ2f8dff8d8 Λ;
   private final occ2f8dff8d8 Ţ;
   private final ocb8b190c865 ъ = new ocb8b190c865();
   private final ocd299de7725 ɣ = new ocd299de7725();
   private final ocd299de7725 ԇ = new ocd299de7725();
   private InventoryPlayer ÿ;
   private int f = -1;
   private int ǖ;
   private int ǆ;
   private float գ;
   public static boolean ҩ;

   public oc643c1c9225() {
      super("AutoProjectile", oce4cea752dd.ȁ);
      this.ą("Automatically switches to snowballs or eggs, throws them and switches back.");
      this.ʌ(this.Ǒ = new oca9cc61aada("Throw speed", 5.0, 4.0, 20.0, 0.1));
      this.ʌ(this.é = new oca9cc61aada("Delay between actions", 0.5, 0.0, 2.0, 0.01));
      this.ʌ(this.Λ = new occ2f8dff8d8("Randomize delays", true));
      this.ʌ(this.Ţ = new occ2f8dff8d8("Always switch back to weapon", false));
   }

   @Override
   public void z$2zw1jy3uhp6iv() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 24
      // 09: invokevirtual x/oc69da1aa7f5.ŷ ()Z
      // 0c: ifne 1f
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokespecial x/oc69da1aa7f5.z$2zw1jy3uhp6iv ()V
      // 17: iload 1
      // 18: ifeq 58
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: goto 24
      // 23: athrow
      // 24: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 27: iload 1
      // 28: ifne 51
      // 2b: invokestatic x/oc2922be51da.Ū (I)Z
      // 2e: ifeq 41
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: invokevirtual x/oc69da1aa7f5.Х ()V
      // 39: iload 1
      // 3a: ifeq 58
      // 3d: goto 41
      // 40: athrow
      // 41: aload 0
      // 42: iload 1
      // 43: ifne 55
      // 46: goto 4a
      // 49: athrow
      // 4a: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 4d: goto 51
      // 50: athrow
      // 51: ifeq 58
      // 54: aload 0
      // 55: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 58: return
   }

   @Override
   public void onEnable() {
      this.ʊ(true);
   }

   @Override
   public void onDisable() {
      this.ʊ(true);
   }

   @oc66fa4f2195
   public void Ю(ocbab3c9954b var1) {
      this.ʊ(true);
   }

   @oc66fa4f2195
   public void Ǥ(oc507025139f var1) {
      try {
         if (ocf5b7e839f8.ȱ() == this) {
            var1.setCanceled(true);
         }
      } catch (IllegalStateException var2) {
         throw var2;
      }
   }

   private int ɍ(InventoryPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: bipush 0
      // 04: istore 3
      // 05: istore 2
      // 06: iload 3
      // 07: ldc 850885753
      // 09: ldc 850885744
      // 0b: ixor
      // 0c: if_icmpge 52
      // 0f: aload 1
      // 10: iload 3
      // 11: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 14: invokestatic x/oc2922be51da.ц (Lnet/minecraft/item/ItemStack;)I
      // 17: iload 2
      // 18: ifne 53
      // 1b: istore 4
      // 1d: iload 4
      // 1f: iload 2
      // 20: ifne 4a
      // 23: ldc 850885948
      // 25: ldc 850885744
      // 27: ixor
      // 28: if_icmpeq 45
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iload 4
      // 31: iload 2
      // 32: ifne 4a
      // 35: goto 39
      // 38: athrow
      // 39: ldc 850885928
      // 3b: ldc 850885744
      // 3d: ixor
      // 3e: if_icmpne 4b
      // 41: goto 45
      // 44: athrow
      // 45: iload 3
      // 46: goto 4a
      // 49: athrow
      // 4a: ireturn
      // 4b: iinc 3 1
      // 4e: iload 2
      // 4f: ifeq 06
      // 52: bipush -1
      // 53: ireturn
   }

   private float ϖ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 30
      // 09: getfield x/oc643c1c9225.Λ Lx/occ2f8dff8d8;
      // 0c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f: ifeq 2f
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/oc643c1c9225.ъ Lx/ocb8b190c865;
      // 1a: aload 0
      // 1b: getfield x/oc643c1c9225.é Lx/oca9cc61aada;
      // 1e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 21: d2f
      // 22: invokestatic x/oca6eae151db.Ϫ ()D
      // 25: getstatic x/oca6eae151db.ő Lx/oca6eae151db;
      // 28: invokevirtual x/ocb8b190c865.ʈ (FDLx/oca6eae151db;)F
      // 2b: goto 37
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/oc643c1c9225.é Lx/oca9cc61aada;
      // 33: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 36: d2f
      // 37: freturn
   }

   private float Օ() {
      float var1 = (float)this.Ǒ.Ӂ();

      try {
         if (!this.Λ.ǭ()) {
            return 20.0F / var1;
         }
      } catch (IllegalStateException var6) {
         throw var6;
      }

      double var2 = oca6eae151db.Ϫ();
      oca6eae151db var4 = oca6eae151db.ő;
      float var5 = 20.0F / (var1 * this.ɣ.Զ(0.5F, 1.0F, 1.0, var2, var4));
      if (this.ԇ.È(0.01F, 0.03F, 30.0, var2, var4)) {
         var5 += var4.ŝ(1.0F, 2.0F);
      }

      return var5;
   }

   @oc66fa4f2195
   public void Ά(occb36f998dc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: invokestatic x/oc2922be51da.Ѽ ()Z
      // 007: ifeq 017
      // 00a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00d: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 010: ifnull 01e
      // 013: goto 017
      // 016: athrow
      // 017: aload 0
      // 018: bipush 1
      // 019: invokevirtual x/oc643c1c9225.ʊ (Z)V
      // 01c: return
      // 01d: athrow
      // 01e: bipush 0
      // 01f: istore 3
      // 020: iload 3
      // 021: ldc -1358295540
      // 023: ldc -1358295537
      // 025: ixor
      // 026: if_icmpge 28b
      // 029: aload 0
      // 02a: getfield x/oc643c1c9225.գ F
      // 02d: iload 2
      // 02e: ifne 049
      // 031: fconst_0
      // 032: fcmpl
      // 033: ifle 050
      // 036: goto 03a
      // 039: athrow
      // 03a: aload 0
      // 03b: dup
      // 03c: getfield x/oc643c1c9225.գ F
      // 03f: fconst_1
      // 040: fsub
      // 041: dup_x1
      // 042: putfield x/oc643c1c9225.գ F
      // 045: goto 049
      // 048: athrow
      // 049: fconst_0
      // 04a: fcmpl
      // 04b: ifle 050
      // 04e: return
      // 04f: athrow
      // 050: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 053: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 056: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 059: astore 4
      // 05b: aload 0
      // 05c: iload 2
      // 05d: ifne 0a9
      // 060: getfield x/oc643c1c9225.ǆ I
      // 063: ldc -1358295539
      // 065: ldc -1358295537
      // 067: ixor
      // 068: if_icmplt 0a8
      // 06b: goto 06f
      // 06e: athrow
      // 06f: aload 4
      // 071: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 074: iload 2
      // 075: ifne 0b4
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 0
      // 07d: getfield x/oc643c1c9225.ǖ I
      // 080: if_icmpeq 0a8
      // 083: goto 087
      // 086: athrow
      // 087: aload 0
      // 088: iload 2
      // 089: ifne 0a4
      // 08c: goto 090
      // 08f: athrow
      // 090: bipush 0
      // 091: invokevirtual x/oc643c1c9225.ʊ (Z)V
      // 094: aload 0
      // 095: invokevirtual x/oc69da1aa7f5.ŷ ()Z
      // 098: ifne 0a7
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 0
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 0a7: return
      // 0a8: aload 0
      // 0a9: iload 2
      // 0aa: ifne 0d5
      // 0ad: getfield x/oc643c1c9225.ǆ I
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: tableswitch 453 0 3 32 202 241 403
      // 0d4: aload 0
      // 0d5: aload 4
      // 0d7: invokevirtual x/oc643c1c9225.ɍ (Lnet/minecraft/entity/player/InventoryPlayer;)I
      // 0da: istore 5
      // 0dc: iload 5
      // 0de: iload 2
      // 0df: ifne 10c
      // 0e2: iflt 0fc
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: aload 0
      // 0ea: iload 2
      // 0eb: ifne 132
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: invokestatic x/ocf5b7e839f8.ӡ (Ljava/lang/Object;)Z
      // 0f5: ifne 114
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 0
      // 0fd: iload 2
      // 0fe: ifne 110
      // 101: goto 105
      // 104: athrow
      // 105: invokevirtual x/oc69da1aa7f5.ŷ ()Z
      // 108: goto 10c
      // 10b: athrow
      // 10c: ifne 113
      // 10f: aload 0
      // 110: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 113: return
      // 114: aload 0
      // 115: aload 4
      // 117: putfield x/oc643c1c9225.ÿ Lnet/minecraft/entity/player/InventoryPlayer;
      // 11a: aload 0
      // 11b: iload 2
      // 11c: ifne 156
      // 11f: aload 4
      // 121: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 124: putfield x/oc643c1c9225.f I
      // 127: aload 0
      // 128: iload 5
      // 12a: putfield x/oc643c1c9225.ǖ I
      // 12d: aload 0
      // 12e: goto 132
      // 131: athrow
      // 132: getfield x/oc643c1c9225.Ţ Lx/occ2f8dff8d8;
      // 135: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 138: ifeq 155
      // 13b: getstatic x/ocbd3640d420.L Lx/ocbd3640d420;
      // 13e: aload 4
      // 140: invokevirtual x/ocbd3640d420.Ō (Lnet/minecraft/entity/player/InventoryPlayer;)I
      // 143: istore 6
      // 145: iload 6
      // 147: bipush -1
      // 148: if_icmpeq 155
      // 14b: aload 0
      // 14c: iload 6
      // 14e: putfield x/oc643c1c9225.f I
      // 151: goto 155
      // 154: athrow
      // 155: aload 0
      // 156: aload 0
      // 157: getfield x/oc643c1c9225.ǖ I
      // 15a: iload 2
      // 15b: ifne 173
      // 15e: aload 4
      // 160: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 163: if_icmpne 176
      // 166: goto 16a
      // 169: athrow
      // 16a: ldc -1358295539
      // 16c: ldc -1358295537
      // 16e: ixor
      // 16f: goto 173
      // 172: athrow
      // 173: goto 177
      // 176: bipush 1
      // 177: putfield x/oc643c1c9225.ǆ I
      // 17a: iload 2
      // 17b: ifeq 284
      // 17e: aload 4
      // 180: aload 0
      // 181: getfield x/oc643c1c9225.ǖ I
      // 184: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 187: iload 2
      // 188: aload 0
      // 189: ldc -1358295539
      // 18b: ldc -1358295537
      // 18d: ixor
      // 18e: putfield x/oc643c1c9225.ǆ I
      // 191: aload 0
      // 192: dup
      // 193: getfield x/oc643c1c9225.գ F
      // 196: aload 0
      // 197: invokevirtual x/oc643c1c9225.ϖ ()F
      // 19a: fadd
      // 19b: putfield x/oc643c1c9225.գ F
      // 19e: ifeq 284
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: aload 0
      // 1a6: aload 4
      // 1a8: invokevirtual x/oc643c1c9225.ɍ (Lnet/minecraft/entity/player/InventoryPlayer;)I
      // 1ab: istore 6
      // 1ad: iload 6
      // 1af: iload 2
      // 1b0: ifne 1c7
      // 1b3: ifge 1c5
      // 1b6: goto 1ba
      // 1b9: athrow
      // 1ba: aload 0
      // 1bb: ldc -1358295540
      // 1bd: ldc -1358295537
      // 1bf: ixor
      // 1c0: putfield x/oc643c1c9225.ǆ I
      // 1c3: return
      // 1c4: athrow
      // 1c5: iload 6
      // 1c7: iload 2
      // 1c8: ifne 214
      // 1cb: aload 4
      // 1cd: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 1d0: if_icmpeq 1f7
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: aload 0
      // 1d8: iload 6
      // 1da: putfield x/oc643c1c9225.ǖ I
      // 1dd: iload 2
      // 1de: aload 0
      // 1df: bipush 1
      // 1e0: putfield x/oc643c1c9225.ǆ I
      // 1e3: aload 0
      // 1e4: dup
      // 1e5: getfield x/oc643c1c9225.գ F
      // 1e8: aload 0
      // 1e9: invokevirtual x/oc643c1c9225.ϖ ()F
      // 1ec: fadd
      // 1ed: putfield x/oc643c1c9225.գ F
      // 1f0: ifeq 284
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1fa: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1fd: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 200: bipush 1
      // 201: invokestatic x/oc2922be51da.Ƚ (Lnet/minecraft/client/settings/KeyBinding;I)V
      // 204: iload 2
      // 205: ifne 239
      // 208: goto 20c
      // 20b: athrow
      // 20c: aload 0
      // 20d: invokevirtual x/oc69da1aa7f5.ŷ ()Z
      // 210: goto 214
      // 213: athrow
      // 214: ifeq 22c
      // 217: aload 0
      // 218: dup
      // 219: getfield x/oc643c1c9225.գ F
      // 21c: aload 0
      // 21d: invokevirtual x/oc643c1c9225.Օ ()F
      // 220: fadd
      // 221: putfield x/oc643c1c9225.գ F
      // 224: iload 2
      // 225: ifeq 246
      // 228: goto 22c
      // 22b: athrow
      // 22c: aload 0
      // 22d: ldc -1358295540
      // 22f: ldc -1358295537
      // 231: ixor
      // 232: putfield x/oc643c1c9225.ǆ I
      // 235: goto 239
      // 238: athrow
      // 239: aload 0
      // 23a: dup
      // 23b: getfield x/oc643c1c9225.գ F
      // 23e: aload 0
      // 23f: invokevirtual x/oc643c1c9225.ϖ ()F
      // 242: fadd
      // 243: putfield x/oc643c1c9225.գ F
      // 246: return
      // 247: aload 0
      // 248: invokevirtual x/oc643c1c9225.Ѕ ()V
      // 24b: aload 0
      // 24c: invokestatic x/ocf5b7e839f8.İ (Ljava/lang/Object;)V
      // 24f: aload 0
      // 250: iload 2
      // 251: ifne 275
      // 254: bipush 0
      // 255: putfield x/oc643c1c9225.ǆ I
      // 258: aload 0
      // 259: dup
      // 25a: getfield x/oc643c1c9225.գ F
      // 25d: aload 0
      // 25e: invokevirtual x/oc643c1c9225.ϖ ()F
      // 261: fadd
      // 262: putfield x/oc643c1c9225.գ F
      // 265: aload 0
      // 266: invokevirtual x/oc69da1aa7f5.ŷ ()Z
      // 269: ifne 278
      // 26c: goto 270
      // 26f: athrow
      // 270: aload 0
      // 271: goto 275
      // 274: athrow
      // 275: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 278: return
      // 279: new java/lang/IllegalStateException
      // 27c: dup
      // 27d: ldc_w "Invalid projectile phase"
      // 280: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 283: athrow
      // 284: iinc 3 1
      // 287: iload 2
      // 288: ifeq 020
      // 28b: return
   }

   private void Ѕ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 3b
      // 09: getfield x/oc643c1c9225.ÿ Lnet/minecraft/entity/player/InventoryPlayer;
      // 0c: ifnull 35
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 3b
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oc643c1c9225.f I
      // 1f: iflt 35
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oc643c1c9225.ÿ Lnet/minecraft/entity/player/InventoryPlayer;
      // 2a: aload 0
      // 2b: getfield x/oc643c1c9225.f I
      // 2e: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: aconst_null
      // 37: putfield x/oc643c1c9225.ÿ Lnet/minecraft/entity/player/InventoryPlayer;
      // 3a: aload 0
      // 3b: bipush -1
      // 3c: putfield x/oc643c1c9225.f I
      // 3f: return
   }

   private void ʊ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: iload 1
      // 05: ifeq 14
      // 08: aload 0
      // 09: invokevirtual x/oc643c1c9225.Ѕ ()V
      // 0c: iload 2
      // 0d: ifeq 22
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: aconst_null
      // 16: putfield x/oc643c1c9225.ÿ Lnet/minecraft/entity/player/InventoryPlayer;
      // 19: aload 0
      // 1a: bipush -1
      // 1b: putfield x/oc643c1c9225.f I
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: invokestatic x/ocf5b7e839f8.İ (Ljava/lang/Object;)V
      // 26: aload 0
      // 27: bipush 0
      // 28: putfield x/oc643c1c9225.ǆ I
      // 2b: aload 0
      // 2c: fconst_0
      // 2d: putfield x/oc643c1c9225.գ F
      // 30: return
   }
}
