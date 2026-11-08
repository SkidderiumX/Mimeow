package x;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.Session;

public class ocfc2b827e17 extends GuiScreen {
   private static final int Ѩ = -5592406;
   private static final int ĝ = -1;
   private static final int Φ = -11141291;
   private static final int ƫ = -43691;
   private final GuiScreen Ӑ;
   private GuiButton ѧ = null;
   private GuiButton Τ = null;
   private GuiButton Ǫ = null;
   private GuiButton Ԓ = null;
   private GuiButton Ƶ = null;
   private oc6277b2748e շ = null;
   private ocb8a733cf81 J = null;
   private int ͺ = -1;
   private ExecutorService ͽ = null;
   private CompletableFuture<Void> ο = null;
   private String ҟ = "&eWorking...";
   private int Ѷ;
   private int ӹ;
   private int Ɩ;
   private int ʇ;
   private int Ķ;
   private int ά;
   private int ă;
   private int ʅ;
   private int Ԧ = -1;
   private int Ÿ = -1;
   private int ȸ = -1;
   private int ҏ = -1;
   private int Ȥ = -1;
   private int ǭ = -1;
   private int ɥ = -1;
   private int Ʈ = -1;
   public static int ʙ;

   public ocfc2b827e17(GuiScreen var1) {
      this.Ӑ = var1;
   }

   public ocfc2b827e17(GuiScreen var1, ocb8a733cf81 var2) {
      this.Ӑ = var1;
      this.J = var2;
   }

   public void initGui() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic x/ocd6bc26d10b.č ()V
      // 003: bipush 1
      // 004: invokestatic org/lwjgl/input/Keyboard.enableRepeatEvents (Z)V
      // 007: aload 0
      // 008: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 00b: invokeinterface java/util/List.clear ()V 1
      // 010: getstatic x/ocf130f74f2a.ʡ Z
      // 013: ldc 345195728
      // 015: ldc 345195736
      // 017: ixor
      // 018: istore 2
      // 019: ldc 345195728
      // 01b: ldc 345195736
      // 01d: ixor
      // 01e: istore 3
      // 01f: aload 0
      // 020: ldc 345195702
      // 022: ldc 345195736
      // 024: ixor
      // 025: ldc 345195598
      // 027: ldc 345195736
      // 029: ixor
      // 02a: aload 0
      // 02b: getfield net/minecraft/client/gui/GuiScreen.width I
      // 02e: ldc 345195741
      // 030: ldc 345195736
      // 032: ixor
      // 033: idiv
      // 034: invokestatic java/lang/Math.min (II)I
      // 037: invokestatic java/lang/Math.max (II)I
      // 03a: putfield x/ocfc2b827e17.ӹ I
      // 03d: istore 1
      // 03e: aload 0
      // 03f: ldc 345195680
      // 041: ldc 345195736
      // 043: ixor
      // 044: ldc 345196020
      // 046: ldc 345195736
      // 048: ixor
      // 049: aload 0
      // 04a: getfield net/minecraft/client/gui/GuiScreen.width I
      // 04d: ldc 345195739
      // 04f: ldc 345195736
      // 051: ixor
      // 052: idiv
      // 053: invokestatic java/lang/Math.min (II)I
      // 056: invokestatic java/lang/Math.max (II)I
      // 059: putfield x/ocfc2b827e17.ά I
      // 05c: aload 0
      // 05d: iload 2
      // 05e: putfield x/ocfc2b827e17.Ѷ I
      // 061: aload 0
      // 062: aload 0
      // 063: getfield net/minecraft/client/gui/GuiScreen.width I
      // 066: iload 2
      // 067: isub
      // 068: aload 0
      // 069: getfield x/ocfc2b827e17.ά I
      // 06c: isub
      // 06d: putfield x/ocfc2b827e17.Ķ I
      // 070: aload 0
      // 071: aload 0
      // 072: getfield x/ocfc2b827e17.Ѷ I
      // 075: aload 0
      // 076: getfield x/ocfc2b827e17.ӹ I
      // 079: iadd
      // 07a: iload 3
      // 07b: iadd
      // 07c: putfield x/ocfc2b827e17.Ɩ I
      // 07f: aload 0
      // 080: aload 0
      // 081: getfield x/ocfc2b827e17.Ķ I
      // 084: iload 3
      // 085: isub
      // 086: putfield x/ocfc2b827e17.ʇ I
      // 089: aload 0
      // 08a: ldc 345195765
      // 08c: ldc 345195736
      // 08e: ixor
      // 08f: putfield x/ocfc2b827e17.ă I
      // 092: aload 0
      // 093: aload 0
      // 094: getfield net/minecraft/client/gui/GuiScreen.height I
      // 097: ldc 345195728
      // 099: ldc 345195736
      // 09b: ixor
      // 09c: isub
      // 09d: putfield x/ocfc2b827e17.ʅ I
      // 0a0: aload 0
      // 0a1: getfield x/ocfc2b827e17.Ѷ I
      // 0a4: ldc 345195740
      // 0a6: ldc 345195736
      // 0a8: ixor
      // 0a9: iadd
      // 0aa: istore 4
      // 0ac: aload 0
      // 0ad: getfield x/ocfc2b827e17.ӹ I
      // 0b0: ldc 345195728
      // 0b2: ldc 345195736
      // 0b4: ixor
      // 0b5: isub
      // 0b6: istore 5
      // 0b8: aload 0
      // 0b9: getfield x/ocfc2b827e17.ă I
      // 0bc: ldc 345195728
      // 0be: ldc 345195736
      // 0c0: ixor
      // 0c1: iadd
      // 0c2: istore 6
      // 0c4: ldc 345195729
      // 0c6: ldc 345195736
      // 0c8: ixor
      // 0c9: istore 7
      // 0cb: ldc 345195738
      // 0cd: ldc 345195736
      // 0cf: ixor
      // 0d0: istore 8
      // 0d2: aload 0
      // 0d3: getfield x/ocfc2b827e17.ʅ I
      // 0d6: iload 6
      // 0d8: isub
      // 0d9: istore 9
      // 0db: ldc 345195724
      // 0dd: ldc 345195736
      // 0df: ixor
      // 0e0: ldc 345195732
      // 0e2: ldc 345195736
      // 0e4: ixor
      // 0e5: iload 9
      // 0e7: iload 8
      // 0e9: iload 7
      // 0eb: bipush 1
      // 0ec: isub
      // 0ed: imul
      // 0ee: isub
      // 0ef: iload 7
      // 0f1: idiv
      // 0f2: invokestatic java/lang/Math.max (II)I
      // 0f5: invokestatic java/lang/Math.min (II)I
      // 0f8: istore 10
      // 0fa: iload 10
      // 0fc: iload 8
      // 0fe: iadd
      // 0ff: istore 11
      // 101: aload 0
      // 102: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 105: aload 0
      // 106: new net/minecraft/client/gui/GuiButton
      // 109: dup
      // 10a: bipush 0
      // 10b: iload 4
      // 10d: iload 6
      // 10f: iload 5
      // 111: iload 10
      // 113: ldc "Login"
      // 115: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 118: dup_x1
      // 119: putfield x/ocfc2b827e17.ѧ Lnet/minecraft/client/gui/GuiButton;
      // 11c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 121: pop
      // 122: aload 0
      // 123: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 126: aload 0
      // 127: new net/minecraft/client/gui/GuiButton
      // 12a: dup
      // 12b: ldc 345195738
      // 12d: ldc 345195736
      // 12f: ixor
      // 130: iload 4
      // 132: iload 6
      // 134: iload 11
      // 136: iadd
      // 137: dup
      // 138: istore 6
      // 13a: iload 5
      // 13c: iload 10
      // 13e: ldc "Delete"
      // 140: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 143: dup_x1
      // 144: putfield x/ocfc2b827e17.Τ Lnet/minecraft/client/gui/GuiButton;
      // 147: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 14c: pop
      // 14d: aload 0
      // 14e: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 151: new net/minecraft/client/gui/GuiButton
      // 154: dup
      // 155: bipush 1
      // 156: iload 4
      // 158: iload 6
      // 15a: iload 11
      // 15c: iadd
      // 15d: dup
      // 15e: istore 6
      // 160: iload 5
      // 162: iload 10
      // 164: ldc "Microsoft"
      // 166: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 169: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 16e: pop
      // 16f: aload 0
      // 170: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 173: new net/minecraft/client/gui/GuiButton
      // 176: dup
      // 177: ldc 345195741
      // 179: ldc 345195736
      // 17b: ixor
      // 17c: iload 4
      // 17e: iload 6
      // 180: iload 11
      // 182: iadd
      // 183: dup
      // 184: istore 6
      // 186: iload 5
      // 188: iload 10
      // 18a: ldc "Token / Session"
      // 18c: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 18f: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 194: pop
      // 195: aload 0
      // 196: iload 1
      // 197: ifne 2f2
      // 19a: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 19d: new net/minecraft/client/gui/GuiButton
      // 1a0: dup
      // 1a1: ldc 345195742
      // 1a3: ldc 345195736
      // 1a5: ixor
      // 1a6: iload 4
      // 1a8: iload 6
      // 1aa: iload 11
      // 1ac: iadd
      // 1ad: dup
      // 1ae: istore 6
      // 1b0: iload 5
      // 1b2: iload 10
      // 1b4: ldc "Cracked"
      // 1b6: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 1b9: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1be: pop
      // 1bf: aload 0
      // 1c0: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 1c3: aload 0
      // 1c4: new net/minecraft/client/gui/GuiButton
      // 1c7: dup
      // 1c8: ldc 345195729
      // 1ca: ldc 345195736
      // 1cc: ixor
      // 1cd: iload 4
      // 1cf: iload 6
      // 1d1: iload 11
      // 1d3: iadd
      // 1d4: dup
      // 1d5: istore 6
      // 1d7: iload 5
      // 1d9: iload 10
      // 1db: ldc "Random Cracked"
      // 1dd: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 1e0: dup_x1
      // 1e1: putfield x/ocfc2b827e17.Ƶ Lnet/minecraft/client/gui/GuiButton;
      // 1e4: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1e9: pop
      // 1ea: aload 0
      // 1eb: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 1ee: new net/minecraft/client/gui/GuiButton
      // 1f1: dup
      // 1f2: ldc 345195743
      // 1f4: ldc 345195736
      // 1f6: ixor
      // 1f7: iload 4
      // 1f9: iload 6
      // 1fb: iload 11
      // 1fd: iadd
      // 1fe: dup
      // 1ff: istore 6
      // 201: iload 5
      // 203: iload 10
      // 205: ldc "Cookie"
      // 207: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 20a: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 20f: pop
      // 210: aload 0
      // 211: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 214: new net/minecraft/client/gui/GuiButton
      // 217: dup
      // 218: ldc 345195728
      // 21a: ldc 345195736
      // 21c: ixor
      // 21d: iload 4
      // 21f: iload 6
      // 221: iload 11
      // 223: iadd
      // 224: dup
      // 225: istore 6
      // 227: iload 5
      // 229: iload 10
      // 22b: ldc "LocalTS"
      // 22d: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 230: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 235: pop
      // 236: aload 0
      // 237: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 23a: aload 0
      // 23b: new net/minecraft/client/gui/GuiButton
      // 23e: dup
      // 23f: ldc 345195739
      // 241: ldc 345195736
      // 243: ixor
      // 244: iload 4
      // 246: iload 6
      // 248: iload 11
      // 24a: iadd
      // 24b: dup
      // 24c: istore 6
      // 24e: iload 5
      // 250: iload 10
      // 252: ldc "Cancel"
      // 254: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 257: dup_x1
      // 258: putfield x/ocfc2b827e17.Ǫ Lnet/minecraft/client/gui/GuiButton;
      // 25b: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 260: pop
      // 261: invokestatic x/occ791aa07d0.Ä ()Lnet/minecraft/util/Session;
      // 264: ifnull 2f1
      // 267: invokestatic x/occ791aa07d0.Ä ()Lnet/minecraft/util/Session;
      // 26a: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 26d: astore 12
      // 26f: iload 1
      // 270: aload 12
      // 272: ldc "Restore: "
      // 274: swap
      // 275: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 27a: astore 13
      // 27c: ldc 345195536
      // 27e: ldc 345195736
      // 280: ixor
      // 281: aload 0
      // 282: getfield net/minecraft/client/gui/GuiScreen.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 285: aload 13
      // 287: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 28a: ldc 345195732
      // 28c: ldc 345195736
      // 28e: ixor
      // 28f: iadd
      // 290: invokestatic java/lang/Math.min (II)I
      // 293: istore 14
      // 295: aload 0
      // 296: new net/minecraft/client/gui/GuiButton
      // 299: dup
      // 29a: ldc 345195740
      // 29c: ldc 345195736
      // 29e: ixor
      // 29f: aload 0
      // 2a0: getfield net/minecraft/client/gui/GuiScreen.width I
      // 2a3: iload 14
      // 2a5: isub
      // 2a6: ldc 345195728
      // 2a8: ldc 345195736
      // 2aa: ixor
      // 2ab: isub
      // 2ac: ldc 345195728
      // 2ae: ldc 345195736
      // 2b0: ixor
      // 2b1: iload 14
      // 2b3: ldc 345195724
      // 2b5: ldc 345195736
      // 2b7: ixor
      // 2b8: aload 0
      // 2b9: getfield net/minecraft/client/gui/GuiScreen.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 2bc: aload 13
      // 2be: iload 14
      // 2c0: ldc 345195730
      // 2c2: ldc 345195736
      // 2c4: ixor
      // 2c5: isub
      // 2c6: invokevirtual net/minecraft/client/gui/FontRenderer.trimStringToWidth (Ljava/lang/String;I)Ljava/lang/String;
      // 2c9: invokespecial net/minecraft/client/gui/GuiButton.<init> (IIIIILjava/lang/String;)V
      // 2cc: putfield x/ocfc2b827e17.Ԓ Lnet/minecraft/client/gui/GuiButton;
      // 2cf: aload 0
      // 2d0: getfield net/minecraft/client/gui/GuiScreen.buttonList Ljava/util/List;
      // 2d3: aload 0
      // 2d4: getfield x/ocfc2b827e17.Ԓ Lnet/minecraft/client/gui/GuiButton;
      // 2d7: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2dc: pop
      // 2dd: ifeq 2f6
      // 2e0: bipush 0
      // 2e1: ifeq 2ed
      // 2e4: goto 2e8
      // 2e7: athrow
      // 2e8: bipush 0
      // 2e9: goto 2ee
      // 2ec: athrow
      // 2ed: bipush 1
      // 2ee: putstatic x/oc69da1aa7f5.Ҭ Z
      // 2f1: aload 0
      // 2f2: aconst_null
      // 2f3: putfield x/ocfc2b827e17.Ԓ Lnet/minecraft/client/gui/GuiButton;
      // 2f6: aload 0
      // 2f7: new x/oc6277b2748e
      // 2fa: dup
      // 2fb: aload 0
      // 2fc: aload 0
      // 2fd: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 300: invokespecial x/oc6277b2748e.<init> (Lx/ocfc2b827e17;Lnet/minecraft/client/Minecraft;)V
      // 303: putfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 306: aload 0
      // 307: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 30a: ldc_w 345195731
      // 30d: ldc 345195736
      // 30f: ixor
      // 310: ldc 345195732
      // 312: ldc 345195736
      // 314: ixor
      // 315: invokevirtual net/minecraft/client/gui/GuiSlot.registerScrollButtons (II)V
      // 318: aload 0
      // 319: invokevirtual x/ocfc2b827e17.updateScreen ()V
      // 31c: return
   }

   public void onGuiClosed() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: bipush 0
      // 04: invokestatic org/lwjgl/input/Keyboard.enableRepeatEvents (Z)V
      // 07: istore 1
      // 08: aload 0
      // 09: iload 1
      // 0a: ifne 3b
      // 0d: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 10: ifnull 3a
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: iload 1
      // 19: ifne 3b
      // 1c: goto 20
      // 1f: athrow
      // 20: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 23: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 26: ifne 3a
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 31: bipush 1
      // 32: invokevirtual java/util/concurrent/CompletableFuture.cancel (Z)Z
      // 35: pop
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 0
      // 3b: iload 1
      // 3c: ifne 4e
      // 3f: getfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 42: ifnull 57
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: goto 4e
      // 4d: athrow
      // 4e: getfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 51: invokeinterface java/util/concurrent/ExecutorService.shutdownNow ()Ljava/util/List; 1
      // 56: pop
      // 57: return
   }

   public void updateScreen() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocf130f74f2a.ʡ Z
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 07f
      // 009: getfield x/ocfc2b827e17.ѧ Lnet/minecraft/client/gui/GuiButton;
      // 00c: ifnull 07e
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 1
      // 015: ifne 07f
      // 018: goto 01c
      // 01b: athrow
      // 01c: getfield x/ocfc2b827e17.Τ Lnet/minecraft/client/gui/GuiButton;
      // 01f: ifnull 07e
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: getfield x/ocfc2b827e17.ѧ Lnet/minecraft/client/gui/GuiButton;
      // 02a: aload 0
      // 02b: getfield x/ocfc2b827e17.Τ Lnet/minecraft/client/gui/GuiButton;
      // 02e: aload 0
      // 02f: getfield x/ocfc2b827e17.ͺ I
      // 032: iload 1
      // 033: ifne 042
      // 036: goto 03a
      // 039: athrow
      // 03a: iflt 045
      // 03d: goto 041
      // 040: athrow
      // 041: bipush 1
      // 042: goto 046
      // 045: bipush 0
      // 046: dup_x1
      // 047: putfield net/minecraft/client/gui/GuiButton.enabled Z
      // 04a: putfield net/minecraft/client/gui/GuiButton.enabled Z
      // 04d: aload 0
      // 04e: iload 1
      // 04f: ifne 07f
      // 052: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 055: ifnull 07e
      // 058: goto 05c
      // 05b: athrow
      // 05c: aload 0
      // 05d: iload 1
      // 05e: ifne 07f
      // 061: goto 065
      // 064: athrow
      // 065: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 068: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 06b: ifne 07e
      // 06e: goto 072
      // 071: athrow
      // 072: aload 0
      // 073: getfield x/ocfc2b827e17.ѧ Lnet/minecraft/client/gui/GuiButton;
      // 076: bipush 0
      // 077: putfield net/minecraft/client/gui/GuiButton.enabled Z
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 0
      // 07f: iload 1
      // 080: ifne 0cd
      // 083: getfield x/ocfc2b827e17.Ԓ Lnet/minecraft/client/gui/GuiButton;
      // 086: ifnull 0cc
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 0
      // 08e: getfield x/ocfc2b827e17.Ԓ Lnet/minecraft/client/gui/GuiButton;
      // 091: invokestatic x/occ791aa07d0.Ў ()Z
      // 094: ifne 0c8
      // 097: goto 09b
      // 09a: athrow
      // 09b: aload 0
      // 09c: iload 1
      // 09d: ifne 0b3
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 0a7: ifnull 0c4
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 0
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 0b6: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 0b9: iload 1
      // 0ba: ifne 0c5
      // 0bd: ifeq 0c8
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: bipush 1
      // 0c5: goto 0c9
      // 0c8: bipush 0
      // 0c9: putfield net/minecraft/client/gui/GuiButton.enabled Z
      // 0cc: aload 0
      // 0cd: iload 1
      // 0ce: ifne 0e0
      // 0d1: getfield x/ocfc2b827e17.Ƶ Lnet/minecraft/client/gui/GuiButton;
      // 0d4: ifnull 110
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 0
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: getfield x/ocfc2b827e17.Ƶ Lnet/minecraft/client/gui/GuiButton;
      // 0e3: aload 0
      // 0e4: iload 1
      // 0e5: ifne 0f7
      // 0e8: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 0eb: ifnull 108
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: aload 0
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 0fa: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 0fd: iload 1
      // 0fe: ifne 109
      // 101: ifeq 10c
      // 104: goto 108
      // 107: athrow
      // 108: bipush 1
      // 109: goto 10d
      // 10c: bipush 0
      // 10d: putfield net/minecraft/client/gui/GuiButton.enabled Z
      // 110: return
   }

   public void drawScreen(int param1, int param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocf130f74f2a.ʡ Z
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 064
      // 00b: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 00e: ifnull 023
      // 011: goto 015
      // 014: athrow
      // 015: aload 0
      // 016: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 019: iload 1
      // 01a: iload 2
      // 01b: fload 3
      // 01c: invokevirtual net/minecraft/client/gui/GuiSlot.drawScreen (IIF)V
      // 01f: goto 023
      // 022: athrow
      // 023: aload 0
      // 024: getfield x/ocfc2b827e17.Ѷ I
      // 027: aload 0
      // 028: getfield x/ocfc2b827e17.ă I
      // 02b: aload 0
      // 02c: getfield x/ocfc2b827e17.Ѷ I
      // 02f: aload 0
      // 030: getfield x/ocfc2b827e17.ӹ I
      // 033: iadd
      // 034: aload 0
      // 035: getfield x/ocfc2b827e17.ʅ I
      // 038: ldc_w 1973394342
      // 03b: ldc_w 60791718
      // 03e: ixor
      // 03f: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 042: aload 0
      // 043: getfield x/ocfc2b827e17.Ɩ I
      // 046: aload 0
      // 047: getfield x/ocfc2b827e17.ă I
      // 04a: aload 0
      // 04b: getfield x/ocfc2b827e17.ʇ I
      // 04e: aload 0
      // 04f: getfield x/ocfc2b827e17.ʅ I
      // 052: ldc_w 1369414566
      // 055: ldc_w 60791718
      // 058: ixor
      // 059: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 05c: aload 0
      // 05d: iload 1
      // 05e: iload 2
      // 05f: fload 3
      // 060: invokespecial net/minecraft/client/gui/GuiScreen.drawScreen (IIF)V
      // 063: aload 0
      // 064: getfield net/minecraft/client/gui/GuiScreen.width I
      // 067: ldc_w 60791716
      // 06a: ldc_w 60791718
      // 06d: ixor
      // 06e: idiv
      // 06f: istore 5
      // 071: aload 0
      // 072: aload 0
      // 073: getfield net/minecraft/client/gui/GuiScreen.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 076: ldc_w "&cAccount Manager"
      // 079: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 07c: iload 5
      // 07e: ldc_w 60791720
      // 081: ldc_w 60791718
      // 084: ixor
      // 085: bipush -1
      // 086: invokevirtual net/minecraft/client/gui/Gui.drawCenteredString (Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V
      // 089: ldc_w "&aWaiting..."
      // 08c: astore 6
      // 08e: aload 0
      // 08f: iload 4
      // 091: ifne 0c5
      // 094: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 097: ifnull 0c0
      // 09a: goto 09e
      // 09d: athrow
      // 09e: aload 0
      // 09f: iload 4
      // 0a1: ifne 0c5
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 0ab: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 0ae: ifne 0c0
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: aload 0
      // 0b6: getfield x/ocfc2b827e17.ҟ Ljava/lang/String;
      // 0b9: astore 6
      // 0bb: iload 4
      // 0bd: ifeq 0f4
      // 0c0: aload 0
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: iload 4
      // 0c7: ifne 0f5
      // 0ca: getfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 0cd: ifnull 0f4
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: aload 0
      // 0d5: iload 4
      // 0d7: ifne 0f5
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: getfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 0e1: invokevirtual x/ocb8a733cf81.φ ()Z
      // 0e4: ifne 0f4
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 0
      // 0ec: getfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 0ef: invokevirtual x/ocb8a733cf81.Ŗ ()Ljava/lang/String;
      // 0f2: astore 6
      // 0f4: aload 0
      // 0f5: aload 0
      // 0f6: getfield net/minecraft/client/gui/GuiScreen.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 0f9: aload 6
      // 0fb: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 0fe: iload 5
      // 100: ldc_w 60791738
      // 103: ldc_w 60791718
      // 106: ixor
      // 107: bipush -1
      // 108: invokevirtual net/minecraft/client/gui/Gui.drawCenteredString (Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V
      // 10b: ldc_w "&7Username: &f%s &8[&7%s&8]&r"
      // 10e: ldc_w 60791716
      // 111: ldc_w 60791718
      // 114: ixor
      // 115: anewarray 340
      // 118: dup
      // 119: bipush 0
      // 11a: invokestatic x/occ791aa07d0.þ ()Lnet/minecraft/util/Session;
      // 11d: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 120: aastore
      // 121: dup
      // 122: bipush 1
      // 123: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 126: invokeinterface java/util/List.size ()I 1
      // 12b: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 12e: aastore
      // 12f: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 132: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 135: astore 7
      // 137: aload 0
      // 138: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 13b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 13e: aload 0
      // 13f: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 142: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 145: aload 7
      // 147: ldc_w 60791717
      // 14a: ldc_w 60791718
      // 14d: ixor
      // 14e: ldc_w 60791717
      // 151: ldc_w 60791718
      // 154: ixor
      // 155: bipush -1
      // 156: invokevirtual net/minecraft/client/gui/GuiScreen.drawString (Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V
      // 159: aload 0
      // 15a: getfield x/ocfc2b827e17.Ɩ I
      // 15d: bipush 0
      // 15e: aload 0
      // 15f: getfield x/ocfc2b827e17.ʇ I
      // 162: aload 0
      // 163: getfield x/ocfc2b827e17.Ɩ I
      // 166: isub
      // 167: invokestatic java/lang/Math.max (II)I
      // 16a: ldc_w 60791716
      // 16d: ldc_w 60791718
      // 170: ixor
      // 171: idiv
      // 172: iadd
      // 173: istore 8
      // 175: aload 0
      // 176: getfield x/ocfc2b827e17.ă I
      // 179: ldc_w 60791722
      // 17c: ldc_w 60791718
      // 17f: ixor
      // 180: iadd
      // 181: istore 9
      // 183: aload 0
      // 184: aload 0
      // 185: aload 0
      // 186: aload 0
      // 187: bipush -1
      // 188: dup_x1
      // 189: putfield x/ocfc2b827e17.ҏ I
      // 18c: dup_x1
      // 18d: putfield x/ocfc2b827e17.ȸ I
      // 190: dup_x1
      // 191: putfield x/ocfc2b827e17.Ÿ I
      // 194: putfield x/ocfc2b827e17.Ԧ I
      // 197: aload 0
      // 198: aload 0
      // 199: aload 0
      // 19a: aload 0
      // 19b: bipush -1
      // 19c: dup_x1
      // 19d: putfield x/ocfc2b827e17.Ʈ I
      // 1a0: dup_x1
      // 1a1: putfield x/ocfc2b827e17.ɥ I
      // 1a4: dup_x1
      // 1a5: putfield x/ocfc2b827e17.ǭ I
      // 1a8: putfield x/ocfc2b827e17.Ȥ I
      // 1ab: aload 0
      // 1ac: aload 0
      // 1ad: getfield net/minecraft/client/gui/GuiScreen.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 1b0: ldc_w "Detailed information:"
      // 1b3: iload 4
      // 1b5: ifne 363
      // 1b8: iload 8
      // 1ba: iload 9
      // 1bc: bipush -1
      // 1bd: invokevirtual net/minecraft/client/gui/Gui.drawCenteredString (Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V
      // 1c0: aload 0
      // 1c1: getfield x/ocfc2b827e17.ͺ I
      // 1c4: iflt 354
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: aload 0
      // 1cc: iload 4
      // 1ce: ifne 359
      // 1d1: goto 1d5
      // 1d4: athrow
      // 1d5: getfield x/ocfc2b827e17.ͺ I
      // 1d8: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 1db: invokeinterface java/util/List.size ()I 1
      // 1e0: if_icmpge 354
      // 1e3: goto 1e7
      // 1e6: athrow
      // 1e7: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 1ea: aload 0
      // 1eb: getfield x/ocfc2b827e17.ͺ I
      // 1ee: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 1f3: checkcast x/oc804fdd8d75
      // 1f6: astore 10
      // 1f8: iload 9
      // 1fa: ldc_w 60791720
      // 1fd: ldc_w 60791718
      // 200: ixor
      // 201: iadd
      // 202: istore 11
      // 204: aload 0
      // 205: ldc_w "Account: "
      // 208: aload 0
      // 209: aload 10
      // 20b: invokevirtual x/ocfc2b827e17.ǳ (Lx/oc804fdd8d75;)Ljava/lang/String;
      // 20e: iload 8
      // 210: iload 11
      // 212: ldc_w -63622900
      // 215: ldc_w 60791718
      // 218: ixor
      // 219: bipush -1
      // 21a: invokevirtual x/ocfc2b827e17.ω (Ljava/lang/String;Ljava/lang/String;IIII)[I
      // 21d: astore 12
      // 21f: aload 0
      // 220: aload 12
      // 222: bipush 0
      // 223: iaload
      // 224: putfield x/ocfc2b827e17.Ԧ I
      // 227: aload 0
      // 228: aload 12
      // 22a: bipush 1
      // 22b: iaload
      // 22c: putfield x/ocfc2b827e17.Ÿ I
      // 22f: aload 0
      // 230: iload 11
      // 232: putfield x/ocfc2b827e17.ȸ I
      // 235: aload 0
      // 236: iload 11
      // 238: ldc_w 60791727
      // 23b: ldc_w 60791718
      // 23e: ixor
      // 23f: iadd
      // 240: putfield x/ocfc2b827e17.ҏ I
      // 243: iload 9
      // 245: ldc_w 60791740
      // 248: ldc_w 60791718
      // 24b: ixor
      // 24c: iadd
      // 24d: istore 13
      // 24f: aload 0
      // 250: ldc_w "UID: "
      // 253: aload 0
      // 254: aload 10
      // 256: invokevirtual x/ocfc2b827e17.Þ (Lx/oc804fdd8d75;)Ljava/lang/String;
      // 259: iload 8
      // 25b: iload 13
      // 25d: ldc_w -63622900
      // 260: ldc_w 60791718
      // 263: ixor
      // 264: bipush -1
      // 265: invokevirtual x/ocfc2b827e17.ω (Ljava/lang/String;Ljava/lang/String;IIII)[I
      // 268: astore 14
      // 26a: aload 0
      // 26b: aload 14
      // 26d: bipush 0
      // 26e: iaload
      // 26f: putfield x/ocfc2b827e17.Ȥ I
      // 272: aload 0
      // 273: aload 14
      // 275: bipush 1
      // 276: iaload
      // 277: putfield x/ocfc2b827e17.ǭ I
      // 27a: aload 0
      // 27b: iload 13
      // 27d: putfield x/ocfc2b827e17.ɥ I
      // 280: aload 0
      // 281: iload 13
      // 283: ldc_w 60791727
      // 286: ldc_w 60791718
      // 289: ixor
      // 28a: iadd
      // 28b: putfield x/ocfc2b827e17.Ʈ I
      // 28e: aload 0
      // 28f: ldc_w "Type: "
      // 292: aload 0
      // 293: aload 10
      // 295: invokevirtual x/ocfc2b827e17.Ѽ (Lx/oc804fdd8d75;)Ljava/lang/String;
      // 298: iload 8
      // 29a: iload 9
      // 29c: ldc_w 60791680
      // 29f: ldc_w 60791718
      // 2a2: ixor
      // 2a3: iadd
      // 2a4: ldc_w -63622900
      // 2a7: ldc_w 60791718
      // 2aa: ixor
      // 2ab: bipush -1
      // 2ac: invokevirtual x/ocfc2b827e17.ω (Ljava/lang/String;Ljava/lang/String;IIII)[I
      // 2af: pop
      // 2b0: aload 0
      // 2b1: ldc_w "Last login: "
      // 2b4: aload 0
      // 2b5: aload 10
      // 2b7: invokevirtual x/ocfc2b827e17.Ȧ (Lx/oc804fdd8d75;)Ljava/lang/String;
      // 2ba: iload 8
      // 2bc: iload 9
      // 2be: ldc_w 60791700
      // 2c1: ldc_w 60791718
      // 2c4: ixor
      // 2c5: iadd
      // 2c6: ldc_w -63622900
      // 2c9: ldc_w 60791718
      // 2cc: ixor
      // 2cd: bipush -1
      // 2ce: invokevirtual x/ocfc2b827e17.ω (Ljava/lang/String;Ljava/lang/String;IIII)[I
      // 2d1: pop
      // 2d2: aload 0
      // 2d3: iload 4
      // 2d5: ifne 335
      // 2d8: ldc_w "Play time: "
      // 2db: aload 0
      // 2dc: aload 10
      // 2de: invokevirtual x/oc804fdd8d75.B ()J
      // 2e1: invokevirtual x/ocfc2b827e17.ˠ (J)Ljava/lang/String;
      // 2e4: iload 8
      // 2e6: iload 9
      // 2e8: ldc_w 60791704
      // 2eb: ldc_w 60791718
      // 2ee: ixor
      // 2ef: iadd
      // 2f0: ldc_w -63622900
      // 2f3: ldc_w 60791718
      // 2f6: ixor
      // 2f7: bipush -1
      // 2f8: invokevirtual x/ocfc2b827e17.ω (Ljava/lang/String;Ljava/lang/String;IIII)[I
      // 2fb: pop
      // 2fc: aload 0
      // 2fd: ldc_w "Hypixel State: "
      // 300: aload 0
      // 301: aload 10
      // 303: invokevirtual x/ocfc2b827e17.ʢ (Lx/oc804fdd8d75;)Ljava/lang/String;
      // 306: iload 8
      // 308: iload 9
      // 30a: ldc_w 60791788
      // 30d: ldc_w 60791718
      // 310: ixor
      // 311: iadd
      // 312: ldc_w -63622900
      // 315: ldc_w 60791718
      // 318: ixor
      // 319: aload 0
      // 31a: aload 10
      // 31c: invokevirtual x/ocfc2b827e17.ң (Lx/oc804fdd8d75;)I
      // 31f: invokevirtual x/ocfc2b827e17.ω (Ljava/lang/String;Ljava/lang/String;IIII)[I
      // 322: pop
      // 323: aload 0
      // 324: aload 10
      // 326: invokevirtual x/ocfc2b827e17.Ӂ (Lx/oc804fdd8d75;)Z
      // 329: ifeq 34f
      // 32c: goto 330
      // 32f: athrow
      // 330: aload 0
      // 331: goto 335
      // 334: athrow
      // 335: aload 0
      // 336: getfield net/minecraft/client/gui/GuiScreen.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 339: ldc_w "&aCurrent session"
      // 33c: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 33f: iload 8
      // 341: iload 9
      // 343: ldc_w 60791804
      // 346: ldc_w 60791718
      // 349: ixor
      // 34a: iadd
      // 34b: bipush -1
      // 34c: invokevirtual net/minecraft/client/gui/Gui.drawCenteredString (Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V
      // 34f: iload 4
      // 351: ifeq 373
      // 354: aload 0
      // 355: goto 359
      // 358: athrow
      // 359: aload 0
      // 35a: getfield net/minecraft/client/gui/GuiScreen.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 35d: ldc_w "&7Select an account"
      // 360: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 363: iload 8
      // 365: iload 9
      // 367: ldc_w 60791730
      // 36a: ldc_w 60791718
      // 36d: ixor
      // 36e: iadd
      // 36f: bipush -1
      // 370: invokevirtual net/minecraft/client/gui/Gui.drawCenteredString (Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V
      // 373: bipush 0
      // 374: ifeq 389
      // 377: iload 4
      // 379: ifeq 385
      // 37c: goto 380
      // 37f: athrow
      // 380: bipush 0
      // 381: goto 386
      // 384: athrow
      // 385: bipush 1
      // 386: putstatic x/ocf130f74f2a.ʡ Z
      // 389: return
   }

   private String ǳ(oc804fdd8d75 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 1e
      // 09: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 0c: invokestatic org/apache/commons/lang3/StringUtils.isBlank (Ljava/lang/CharSequence;)Z
      // 0f: ifeq 1d
      // 12: goto 16
      // 15: athrow
      // 16: ldc_w "?"
      // 19: goto 21
      // 1c: athrow
      // 1d: aload 1
      // 1e: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 21: areturn
   }

   private String Ѽ(oc804fdd8d75 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/ocf130f74f2a.ʡ Z
      // 003: aload 1
      // 004: invokevirtual x/oc804fdd8d75.ż ()Ljava/lang/String;
      // 007: astore 3
      // 008: bipush -1
      // 009: istore 4
      // 00b: istore 2
      // 00c: aload 3
      // 00d: invokevirtual java/lang/String.hashCode ()I
      // 010: iload 2
      // 011: ifne 0ea
      // 014: lookupswitch 212 5 -1354757532 82 110541305 111 1024911321 53 1085444827 181 1984987798 146
      // 048: athrow
      // 049: aload 3
      // 04a: ldc_w "cracked"
      // 04d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 050: iload 2
      // 051: ifne 0ea
      // 054: goto 058
      // 057: athrow
      // 058: ifeq 0e8
      // 05b: goto 05f
      // 05e: athrow
      // 05f: bipush 0
      // 060: istore 4
      // 062: iload 2
      // 063: ifeq 0e8
      // 066: aload 3
      // 067: ldc_w "cookie"
      // 06a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 06d: iload 2
      // 06e: ifne 0ea
      // 071: goto 075
      // 074: athrow
      // 075: ifeq 0e8
      // 078: goto 07c
      // 07b: athrow
      // 07c: bipush 1
      // 07d: istore 4
      // 07f: iload 2
      // 080: ifeq 0e8
      // 083: aload 3
      // 084: ldc_w "token"
      // 087: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 08a: iload 2
      // 08b: ifne 0ea
      // 08e: goto 092
      // 091: athrow
      // 092: ifeq 0e8
      // 095: goto 099
      // 098: athrow
      // 099: ldc_w 2131340186
      // 09c: ldc_w 2131340184
      // 09f: ixor
      // 0a0: istore 4
      // 0a2: iload 2
      // 0a3: ifeq 0e8
      // 0a6: aload 3
      // 0a7: ldc_w "session"
      // 0aa: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0ad: iload 2
      // 0ae: ifne 0ea
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: ifeq 0e8
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: ldc_w 2131340187
      // 0bf: ldc_w 2131340184
      // 0c2: ixor
      // 0c3: istore 4
      // 0c5: iload 2
      // 0c6: ifeq 0e8
      // 0c9: aload 3
      // 0ca: ldc_w "refresh"
      // 0cd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d0: iload 2
      // 0d1: ifne 0ea
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: ifeq 0e8
      // 0db: goto 0df
      // 0de: athrow
      // 0df: ldc_w 2131340188
      // 0e2: ldc_w 2131340184
      // 0e5: ixor
      // 0e6: istore 4
      // 0e8: iload 4
      // 0ea: tableswitch 53 0 4 34 38 41 45 49
      // 10c: ldc "Cracked"
      // 10e: areturn
      // 10f: athrow
      // 110: ldc "Cookie"
      // 112: areturn
      // 113: ldc_w "Token"
      // 116: areturn
      // 117: ldc_w "Session"
      // 11a: areturn
      // 11b: ldc_w "Refresh Token"
      // 11e: areturn
      // 11f: ldc "Microsoft"
      // 121: areturn
   }

   private String Þ(oc804fdd8d75 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 1e
      // 09: invokevirtual x/oc804fdd8d75.Ӽ ()Ljava/lang/String;
      // 0c: invokestatic org/apache/commons/lang3/StringUtils.isBlank (Ljava/lang/CharSequence;)Z
      // 0f: ifeq 1d
      // 12: goto 16
      // 15: athrow
      // 16: ldc_w "Unknown"
      // 19: goto 21
      // 1c: athrow
      // 1d: aload 1
      // 1e: invokevirtual x/oc804fdd8d75.Ӽ ()Ljava/lang/String;
      // 21: areturn
   }

   private String Ȧ(oc804fdd8d75 var1) {
      long var2 = var1.Ύ();

      try {
         if (var2 <= 0L) {
            return "Never";
         }
      } catch (CompletionException var7) {
         throw var7;
      }

      ZoneId var4 = ZoneId.systemDefault();
      LocalDate var5 = Instant.ofEpochMilli(var2).atZone(var4).toLocalDate();

      try {
         if (LocalDate.now(var4).equals(var5)) {
            return "Today";
         }
      } catch (CompletionException var6) {
         throw var6;
      }

      return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(Instant.ofEpochMilli(var2).atZone(var4));
   }

   private String ˠ(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: lconst_0
      // 04: lload 1
      // 05: invokestatic java/lang/Math.max (JJ)J
      // 08: ldc2_w 5871134453734796496
      // 0b: ldc2_w 5871134453734803120
      // 0e: lxor
      // 0f: ldiv
      // 10: lstore 4
      // 12: lload 4
      // 14: ldc2_w 5871134453734802192
      // 17: ldc2_w 5871134453734803120
      // 1a: lxor
      // 1b: ldiv
      // 1c: lstore 6
      // 1e: istore 3
      // 1f: lload 4
      // 21: ldc2_w 5871134453734802192
      // 24: ldc2_w 5871134453734803120
      // 27: lxor
      // 28: lrem
      // 29: ldc2_w 5871134453734803084
      // 2c: ldc2_w 5871134453734803120
      // 2f: lxor
      // 30: ldiv
      // 31: lstore 8
      // 33: lload 4
      // 35: ldc2_w 5871134453734803084
      // 38: ldc2_w 5871134453734803120
      // 3b: lxor
      // 3c: lrem
      // 3d: lstore 10
      // 3f: lload 6
      // 41: iload 3
      // 42: ifne 6d
      // 45: lconst_0
      // 46: lcmp
      // 47: ifle 6b
      // 4a: goto 4e
      // 4d: athrow
      // 4e: lload 6
      // 50: lload 8
      // 52: lload 10
      // 54: lstore 12
      // 56: lstore 14
      // 58: ldc_w "d "
      // 5b: lload 14
      // 5d: ldc_w "h "
      // 60: lload 12
      // 62: ldc_w "m"
      // 65: invokedynamic makeConcatWithConstants (JLjava/lang/String;JLjava/lang/String;JLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001\u0001" ]
      // 6a: areturn
      // 6b: lload 8
      // 6d: iload 3
      // 6e: ifne 8f
      // 71: lconst_0
      // 72: lcmp
      // 73: ifle 8d
      // 76: goto 7a
      // 79: athrow
      // 7a: lload 8
      // 7c: lload 10
      // 7e: ldc_w "h "
      // 81: dup_x2
      // 82: pop
      // 83: ldc_w "m"
      // 86: invokedynamic makeConcatWithConstants (JLjava/lang/String;JLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 8b: areturn
      // 8c: athrow
      // 8d: lload 10
      // 8f: invokedynamic makeConcatWithConstants (J)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001m" ]
      // 94: areturn
   }

   private String ʢ(oc804fdd8d75 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: aload 1
      // 04: invokevirtual x/oc804fdd8d75.ʏ ()J
      // 07: lstore 3
      // 08: istore 2
      // 09: lload 3
      // 0a: iload 2
      // 0b: ifne 21
      // 0e: lconst_0
      // 0f: lcmp
      // 10: ifge 1c
      // 13: goto 17
      // 16: athrow
      // 17: ldc_w "Banned permanently"
      // 1a: areturn
      // 1b: athrow
      // 1c: lload 3
      // 1d: invokestatic java/lang/System.currentTimeMillis ()J
      // 20: lsub
      // 21: lstore 5
      // 23: lload 5
      // 25: lconst_0
      // 26: lcmp
      // 27: ifle 3b
      // 2a: aload 0
      // 2b: lload 5
      // 2d: invokevirtual x/ocfc2b827e17.Ĭ (J)Ljava/lang/String;
      // 30: ldc_w "Banned - "
      // 33: swap
      // 34: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 39: areturn
      // 3a: athrow
      // 3b: ldc_w "Unbanned"
      // 3e: areturn
   }

   private int ң(oc804fdd8d75 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual x/oc804fdd8d75.ʏ ()J
      // 08: lconst_0
      // 09: lcmp
      // 0a: iload 2
      // 0b: ifne 33
      // 0e: iflt 2c
      // 11: goto 15
      // 14: athrow
      // 15: aload 1
      // 16: invokevirtual x/oc804fdd8d75.ʏ ()J
      // 19: invokestatic java/lang/System.currentTimeMillis ()J
      // 1c: lcmp
      // 1d: iload 2
      // 1e: ifne 33
      // 21: goto 25
      // 24: athrow
      // 25: ifle 36
      // 28: goto 2c
      // 2b: athrow
      // 2c: ldc_w 173100108
      // 2f: ldc_w -173139687
      // 32: ixor
      // 33: goto 3d
      // 36: ldc_w 184280652
      // 39: ldc_w -173139687
      // 3c: ixor
      // 3d: ireturn
   }

   private String Ĭ(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: lconst_1
      // 04: lload 1
      // 05: ldc2_w 8370517837284047548
      // 08: ldc2_w 8370517837284047188
      // 0b: lxor
      // 0c: ldiv
      // 0d: invokestatic java/lang/Math.max (JJ)J
      // 10: lstore 4
      // 12: lload 4
      // 14: ldc2_w 8370517837284092116
      // 17: ldc2_w 8370517837284047188
      // 1a: lxor
      // 1b: ldiv
      // 1c: lstore 6
      // 1e: istore 3
      // 1f: lload 4
      // 21: ldc2_w 8370517837284092116
      // 24: ldc2_w 8370517837284047188
      // 27: lxor
      // 28: lrem
      // 29: ldc2_w 8370517837284046660
      // 2c: ldc2_w 8370517837284047188
      // 2f: lxor
      // 30: ldiv
      // 31: lstore 8
      // 33: lload 4
      // 35: ldc2_w 8370517837284046660
      // 38: ldc2_w 8370517837284047188
      // 3b: lxor
      // 3c: lrem
      // 3d: ldc2_w 8370517837284047208
      // 40: ldc2_w 8370517837284047188
      // 43: lxor
      // 44: ldiv
      // 45: lstore 10
      // 47: lload 6
      // 49: iload 3
      // 4a: ifne 6b
      // 4d: lconst_0
      // 4e: lcmp
      // 4f: ifle 69
      // 52: goto 56
      // 55: athrow
      // 56: lload 6
      // 58: lload 8
      // 5a: ldc_w "d "
      // 5d: dup_x2
      // 5e: pop
      // 5f: ldc_w "h"
      // 62: invokedynamic makeConcatWithConstants (JLjava/lang/String;JLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 67: areturn
      // 68: athrow
      // 69: lload 8
      // 6b: iload 3
      // 6c: ifne 91
      // 6f: lconst_0
      // 70: lcmp
      // 71: ifle 8b
      // 74: goto 78
      // 77: athrow
      // 78: lload 8
      // 7a: lload 10
      // 7c: ldc_w "h "
      // 7f: dup_x2
      // 80: pop
      // 81: ldc_w "m"
      // 84: invokedynamic makeConcatWithConstants (JLjava/lang/String;JLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 89: areturn
      // 8a: athrow
      // 8b: lconst_1
      // 8c: lload 10
      // 8e: invokestatic java/lang/Math.max (JJ)J
      // 91: invokedynamic makeConcatWithConstants (J)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001m" ]
      // 96: areturn
   }

   private boolean Դ(int param1, int param2, int param3, int param4, int param5, int param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 7
      // 05: iload 1
      // 06: iload 7
      // 08: ifne 18
      // 0b: iload 3
      // 0c: if_icmplt 54
      // 0f: goto 13
      // 12: athrow
      // 13: iload 1
      // 14: goto 18
      // 17: athrow
      // 18: iload 7
      // 1a: ifne 2b
      // 1d: iload 5
      // 1f: if_icmpgt 54
      // 22: goto 26
      // 25: athrow
      // 26: iload 2
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 7
      // 2d: ifne 3e
      // 30: iload 4
      // 32: if_icmplt 54
      // 35: goto 39
      // 38: athrow
      // 39: iload 2
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 7
      // 40: ifne 51
      // 43: iload 6
      // 45: if_icmpgt 54
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush 1
      // 4d: goto 51
      // 50: athrow
      // 51: goto 55
      // 54: bipush 0
      // 55: ireturn
   }

   private int[] ω(String var1, String var2, int var3, int var4, int var5, int var6) {
      int var7 = super.fontRendererObj.getStringWidth(var1);
      int var8 = super.fontRendererObj.getStringWidth(var2);
      int var9 = var3 - (var7 + var8) / (-1377626657 ^ -1377626659);
      this.drawString(super.fontRendererObj, var1, var9, var4, var5);
      this.drawString(super.fontRendererObj, var2, var9 + var7, var4, var6);
      int[] var10000 = new int[-1377626657 ^ -1377626659];
      var10000[0] = var9;
      var10000[1] = var9 + var7 + var8;
      return var10000;
   }

   private void Ǌ(FontRenderer var1, String var2, String var3, int var4, int var5, int var6) {
      int var7 = var1.getStringWidth(var2);
      String var8 = var1.trimStringToWidth(var3, Math.max(0, var6 - var7));
      this.drawString(var1, var2, var4, var5, -319302893 ^ 324893113);
      this.drawString(var1, var8, var4 + var7, var5, -1);
   }

   private boolean Ӂ(oc804fdd8d75 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: aload 1
      // 04: invokevirtual x/oc804fdd8d75.Ć ()Ljava/lang/String;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 3
      // 0a: iload 2
      // 0b: ifne 39
      // 0e: invokestatic org/apache/commons/lang3/StringUtils.isBlank (Ljava/lang/CharSequence;)Z
      // 11: ifne 34
      // 14: goto 18
      // 17: athrow
      // 18: aload 3
      // 19: invokestatic x/occ791aa07d0.þ ()Lnet/minecraft/util/Session;
      // 1c: iload 2
      // 1d: ifne 3c
      // 20: goto 24
      // 23: athrow
      // 24: invokevirtual net/minecraft/util/Session.getToken ()Ljava/lang/String;
      // 27: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2a: ifeq 34
      // 2d: goto 31
      // 30: athrow
      // 31: bipush 1
      // 32: ireturn
      // 33: athrow
      // 34: aload 0
      // 35: aload 1
      // 36: invokevirtual x/ocfc2b827e17.ǳ (Lx/oc804fdd8d75;)Ljava/lang/String;
      // 39: invokestatic x/occ791aa07d0.þ ()Lnet/minecraft/util/Session;
      // 3c: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 3f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 42: ireturn
   }

   private void Ө(oc804fdd8d75 var1, String var2) {
      occ791aa07d0.б(occ791aa07d0.û(var1.Ō()));
      this.J = new ocb8a733cf81(oc54714bd439.Ǥ(String.format(var2, var1.Ō())), -2623101502195291934L ^ -2623101502195287190L);
   }

   private void ԁ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 37
      // 09: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 0c: ifnull 2b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 37
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 1f: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 22: ifne 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: aload 0
      // 2c: invokevirtual x/ocfc2b827e17.ǰ ()V
      // 2f: aload 0
      // 30: ldc_w "&eGenerating cracked account..."
      // 33: putfield x/ocfc2b827e17.ҟ Ljava/lang/String;
      // 36: aload 0
      // 37: new x/ocb8a733cf81
      // 3a: dup
      // 3b: aload 0
      // 3c: getfield x/ocfc2b827e17.ҟ Ljava/lang/String;
      // 3f: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 42: ldc2_w 899541599563042325
      // 45: ldc2_w -899541599563042326
      // 48: lxor
      // 49: invokespecial x/ocb8a733cf81.<init> (Ljava/lang/String;J)V
      // 4c: putfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 4f: new java/util/ArrayList
      // 52: dup
      // 53: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 56: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 59: astore 2
      // 5a: aload 0
      // 5b: aload 2
      // 5c: invokedynamic get (Ljava/util/ArrayList;)Ljava/util/function/Supplier; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()Ljava/lang/Object;, x/ocfc2b827e17.q2k54ld2qu2hcq (Ljava/util/ArrayList;)Ljava/lang/String;, ()Ljava/lang/String; ]
      // 61: aload 0
      // 62: getfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 65: invokestatic java/util/concurrent/CompletableFuture.supplyAsync (Ljava/util/function/Supplier;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 68: aload 0
      // 69: invokedynamic apply (Lx/ocfc2b827e17;)Ljava/util/function/BiFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, x/ocfc2b827e17.q6p9cezjcqt8g (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Void;, (Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Void; ]
      // 6e: invokevirtual java/util/concurrent/CompletableFuture.handle (Ljava/util/function/BiFunction;)Ljava/util/concurrent/CompletableFuture;
      // 71: putfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 74: aload 0
      // 75: invokevirtual x/ocfc2b827e17.updateScreen ()V
      // 78: return
   }

   private void ǰ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 30
      // 09: getfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 0c: ifnull 2b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 30
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 1f: invokeinterface java/util/concurrent/ExecutorService.isShutdown ()Z 1
      // 24: ifeq 3b
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: goto 30
      // 2f: athrow
      // 30: invokedynamic newThread ()Ljava/util/concurrent/ThreadFactory; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Runnable;)Ljava/lang/Thread;, x/ocfc2b827e17.q2z1srunaounn4 (Ljava/lang/Runnable;)Ljava/lang/Thread;, (Ljava/lang/Runnable;)Ljava/lang/Thread; ]
      // 35: invokestatic java/util/concurrent/Executors.newSingleThreadExecutor (Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
      // 38: putfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 3b: return
   }

   private void ǉ(oc804fdd8d75 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 1e
      // 09: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 0c: invokestatic org/apache/commons/lang3/StringUtils.isBlank (Ljava/lang/CharSequence;)Z
      // 0f: ifeq 1d
      // 12: goto 16
      // 15: athrow
      // 16: ldc_w "???"
      // 19: goto 21
      // 1c: athrow
      // 1d: aload 1
      // 1e: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 21: astore 3
      // 22: aload 0
      // 23: ldc_w "&eLogging in..."
      // 26: putfield x/ocfc2b827e17.ҟ Ljava/lang/String;
      // 29: aload 0
      // 2a: iload 2
      // 2b: ifne 71
      // 2e: new x/ocb8a733cf81
      // 31: dup
      // 32: ldc_w "&7Fetching your Minecraft profile... (%s)&r"
      // 35: bipush 1
      // 36: anewarray 340
      // 39: dup
      // 3a: bipush 0
      // 3b: aload 3
      // 3c: aastore
      // 3d: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 40: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 43: ldc2_w 4741074620080875061
      // 46: ldc2_w -4741074620080875062
      // 49: lxor
      // 4a: invokespecial x/ocb8a733cf81.<init> (Ljava/lang/String;J)V
      // 4d: putfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 50: aload 0
      // 51: invokevirtual x/ocfc2b827e17.ǰ ()V
      // 54: aload 1
      // 55: invokevirtual x/oc804fdd8d75.Ȣ ()Ljava/lang/String;
      // 58: invokevirtual java/lang/String.isEmpty ()Z
      // 5b: ifeq 6c
      // 5e: goto 62
      // 61: athrow
      // 62: aload 1
      // 63: invokevirtual x/oc804fdd8d75.ǣ ()Ljava/lang/String;
      // 66: invokevirtual java/lang/String.isEmpty ()Z
      // 69: ifne 90
      // 6c: aload 0
      // 6d: goto 71
      // 70: athrow
      // 71: aload 1
      // 72: invokedynamic get (Lx/oc804fdd8d75;)Ljava/util/function/Supplier; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()Ljava/lang/Object;, x/ocfc2b827e17.qv0a3d74e801q (Lx/oc804fdd8d75;)Lx/oc6bcef73ceb;, ()Lx/oc6bcef73ceb; ]
      // 77: aload 0
      // 78: getfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 7b: invokestatic java/util/concurrent/CompletableFuture.supplyAsync (Ljava/util/function/Supplier;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 7e: aload 0
      // 7f: aload 1
      // 80: aload 3
      // 81: invokedynamic apply (Lx/ocfc2b827e17;Lx/oc804fdd8d75;Ljava/lang/String;)Ljava/util/function/BiFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, x/ocfc2b827e17.q1r4xjt16i8kvv (Lx/oc804fdd8d75;Ljava/lang/String;Lx/oc6bcef73ceb;Ljava/lang/Throwable;)Ljava/lang/Void;, (Lx/oc6bcef73ceb;Ljava/lang/Throwable;)Ljava/lang/Void; ]
      // 86: invokevirtual java/util/concurrent/CompletableFuture.handle (Ljava/util/function/BiFunction;)Ljava/util/concurrent/CompletableFuture;
      // 89: putfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 8c: iload 2
      // 8d: ifeq ae
      // 90: aload 0
      // 91: aload 1
      // 92: invokevirtual x/oc804fdd8d75.Ć ()Ljava/lang/String;
      // 95: aload 0
      // 96: getfield x/ocfc2b827e17.ͽ Ljava/util/concurrent/ExecutorService;
      // 99: invokestatic x/ocb616b6fa2e.ņ (Ljava/lang/String;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 9c: aload 0
      // 9d: aload 1
      // 9e: aload 3
      // 9f: invokedynamic apply (Lx/ocfc2b827e17;Lx/oc804fdd8d75;Ljava/lang/String;)Ljava/util/function/BiFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, x/ocfc2b827e17.q3foaazvmtt9us (Lx/oc804fdd8d75;Ljava/lang/String;Lnet/minecraft/util/Session;Ljava/lang/Throwable;)Ljava/lang/Void;, (Lnet/minecraft/util/Session;Ljava/lang/Throwable;)Ljava/lang/Void; ]
      // a4: invokevirtual java/util/concurrent/CompletableFuture.handle (Ljava/util/function/BiFunction;)Ljava/util/concurrent/CompletableFuture;
      // a7: putfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // aa: goto ae
      // ad: athrow
      // ae: aload 0
      // af: invokevirtual x/ocfc2b827e17.updateScreen ()V
      // b2: return
   }

   private void б(oc804fdd8d75 var1, String var2, oc6bcef73ceb var3, Throwable var4) {
      try {
         if (super.mc.currentScreen != this) {
            return;
         }
      } catch (CompletionException var5) {
         throw var5;
      }

      try {
         if (var4 != null) {
            this.σ(var2, oc086240ae91.W(var4));
            return;
         }
      } catch (CompletionException var6) {
         throw var6;
      }

      var3.Ы(var1);
      ocd6bc26d10b.Շ();
      this.ҕ(var3.њ());
   }

   private void Ӊ(oc804fdd8d75 param1, String param2, Session param3, Throwable param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 04: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 07: aload 0
      // 08: if_acmpeq 0d
      // 0b: return
      // 0c: athrow
      // 0d: aload 4
      // 0f: ifnonnull 1a
      // 12: aload 3
      // 13: ifnonnull 26
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: aload 2
      // 1c: aload 4
      // 1e: invokestatic x/oc086240ae91.W (Ljava/lang/Throwable;)Ljava/lang/String;
      // 21: invokevirtual x/ocfc2b827e17.σ (Ljava/lang/String;Ljava/lang/String;)V
      // 24: return
      // 25: athrow
      // 26: aload 1
      // 27: aload 3
      // 28: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 2b: invokevirtual x/oc804fdd8d75.Ɋ (Ljava/lang/String;)V
      // 2e: aload 1
      // 2f: aload 3
      // 30: invokevirtual net/minecraft/util/Session.getPlayerID ()Ljava/lang/String;
      // 33: invokevirtual x/oc804fdd8d75.ѳ (Ljava/lang/String;)V
      // 36: aload 0
      // 37: aload 3
      // 38: invokevirtual x/ocfc2b827e17.ҕ (Lnet/minecraft/util/Session;)V
      // 3b: return
   }

   private void ҕ(Session var1) {
      occ791aa07d0.б(var1);
      this.J = new ocb8a733cf81(oc54714bd439.Ǥ(String.format("&aSuccessful login! (%s)&r", var1.getUsername())), 1283299180347155917L ^ 1283299180347160133L);
      this.updateScreen();
   }

   private void σ(String var1, String var2) {
      Object[] var10004 = new Object[1351315099 ^ 1351315097];
      var10004[0] = var2;
      var10004[1] = var1;
      this.J = new ocb8a733cf81(oc54714bd439.Ǥ(String.format("&c%s (%s)&r", var10004)), 6004112661665303169L ^ 6004112661665306889L);
      this.updateScreen();
   }

   void ҽ(ocb8a733cf81 var1) {
      this.J = var1;
   }

   public void handleMouseInput() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocf130f74f2a.ʡ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1f
      // 09: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 0c: ifnull 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 17: invokevirtual net/minecraft/client/gui/GuiSlot.handleMouseInput ()V
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 0
      // 1f: invokespecial net/minecraft/client/gui/GuiScreen.handleMouseInput ()V
      // 22: return
   }

   protected void mouseClicked(int param1, int param2, int param3) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocf130f74f2a.ʡ Z
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 01c
      // 00b: iload 1
      // 00c: iload 2
      // 00d: iload 3
      // 00e: invokespecial net/minecraft/client/gui/GuiScreen.mouseClicked (III)V
      // 011: iload 3
      // 012: ifeq 01b
      // 015: goto 019
      // 018: athrow
      // 019: return
      // 01a: athrow
      // 01b: aload 0
      // 01c: iload 4
      // 01e: ifne 09e
      // 021: iload 1
      // 022: iload 2
      // 023: aload 0
      // 024: getfield x/ocfc2b827e17.Ԧ I
      // 027: aload 0
      // 028: getfield x/ocfc2b827e17.ȸ I
      // 02b: aload 0
      // 02c: getfield x/ocfc2b827e17.Ÿ I
      // 02f: aload 0
      // 030: getfield x/ocfc2b827e17.ҏ I
      // 033: invokevirtual x/ocfc2b827e17.Դ (IIIIII)Z
      // 036: ifeq 09d
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: iload 4
      // 040: ifne 09e
      // 043: goto 047
      // 046: athrow
      // 047: getfield x/ocfc2b827e17.ͺ I
      // 04a: iflt 09d
      // 04d: goto 051
      // 050: athrow
      // 051: aload 0
      // 052: iload 4
      // 054: ifne 09e
      // 057: goto 05b
      // 05a: athrow
      // 05b: getfield x/ocfc2b827e17.ͺ I
      // 05e: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 061: invokeinterface java/util/List.size ()I 1
      // 066: if_icmpge 09d
      // 069: goto 06d
      // 06c: athrow
      // 06d: aload 0
      // 06e: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 071: aload 0
      // 072: getfield x/ocfc2b827e17.ͺ I
      // 075: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 07a: checkcast x/oc804fdd8d75
      // 07d: invokevirtual x/ocfc2b827e17.ǳ (Lx/oc804fdd8d75;)Ljava/lang/String;
      // 080: invokestatic net/minecraft/client/gui/GuiScreen.setClipboardString (Ljava/lang/String;)V
      // 083: aload 0
      // 084: new x/ocb8a733cf81
      // 087: dup
      // 088: ldc_w "&aAccount name copied"
      // 08b: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 08e: ldc2_w -1242956767796166566
      // 091: ldc2_w -1242956767796164726
      // 094: lxor
      // 095: invokespecial x/ocb8a733cf81.<init> (Ljava/lang/String;J)V
      // 098: putfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 09b: return
      // 09c: athrow
      // 09d: aload 0
      // 09e: iload 4
      // 0a0: ifne 137
      // 0a3: iload 1
      // 0a4: iload 2
      // 0a5: aload 0
      // 0a6: getfield x/ocfc2b827e17.Ȥ I
      // 0a9: aload 0
      // 0aa: getfield x/ocfc2b827e17.ɥ I
      // 0ad: aload 0
      // 0ae: getfield x/ocfc2b827e17.ǭ I
      // 0b1: aload 0
      // 0b2: getfield x/ocfc2b827e17.Ʈ I
      // 0b5: invokevirtual x/ocfc2b827e17.Դ (IIIIII)Z
      // 0b8: ifeq 136
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: aload 0
      // 0c0: iload 4
      // 0c2: ifne 137
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: getfield x/ocfc2b827e17.ͺ I
      // 0cc: iflt 136
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 0
      // 0d4: iload 4
      // 0d6: ifne 137
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: getfield x/ocfc2b827e17.ͺ I
      // 0e0: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 0e3: invokeinterface java/util/List.size ()I 1
      // 0e8: if_icmpge 136
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 0f2: aload 0
      // 0f3: getfield x/ocfc2b827e17.ͺ I
      // 0f6: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0fb: checkcast x/oc804fdd8d75
      // 0fe: invokevirtual x/oc804fdd8d75.Ӽ ()Ljava/lang/String;
      // 101: astore 5
      // 103: iload 4
      // 105: ifne 11d
      // 108: aload 5
      // 10a: invokestatic org/apache/commons/lang3/StringUtils.isBlank (Ljava/lang/CharSequence;)Z
      // 10d: ifne 135
      // 110: goto 114
      // 113: athrow
      // 114: aload 5
      // 116: invokestatic net/minecraft/client/gui/GuiScreen.setClipboardString (Ljava/lang/String;)V
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: new x/ocb8a733cf81
      // 121: dup
      // 122: ldc_w "&aUID copied"
      // 125: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 128: ldc2_w -1242956767796166566
      // 12b: ldc2_w -1242956767796164726
      // 12e: lxor
      // 12f: invokespecial x/ocb8a733cf81.<init> (Ljava/lang/String;J)V
      // 132: putfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 135: return
      // 136: aload 0
      // 137: iload 4
      // 139: ifne 14b
      // 13c: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 13f: ifnull 17e
      // 142: goto 146
      // 145: athrow
      // 146: aload 0
      // 147: goto 14b
      // 14a: athrow
      // 14b: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 14e: iload 1
      // 14f: iload 2
      // 150: invokevirtual net/minecraft/client/gui/GuiSlot.getSlotIndexFromScreenCoords (II)I
      // 153: istore 5
      // 155: iload 5
      // 157: iload 4
      // 159: ifne 165
      // 15c: iflt 17e
      // 15f: goto 163
      // 162: athrow
      // 163: iload 5
      // 165: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 168: invokeinterface java/util/List.size ()I 1
      // 16d: if_icmpge 17e
      // 170: aload 0
      // 171: iload 5
      // 173: putfield x/ocfc2b827e17.ͺ I
      // 176: aload 0
      // 177: invokevirtual x/ocfc2b827e17.updateScreen ()V
      // 17a: goto 17e
      // 17d: athrow
      // 17e: return
   }

   protected void keyTyped(char param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/ocf130f74f2a.ʡ Z
      // 003: istore 3
      // 004: iload 2
      // 005: iload 3
      // 006: ifne 113
      // 009: lookupswitch 254 5 1 242 28 210 200 52 208 126 211 226
      // 03c: athrow
      // 03d: aload 0
      // 03e: getfield x/ocfc2b827e17.ͺ I
      // 041: iload 3
      // 042: ifne 113
      // 045: goto 049
      // 048: athrow
      // 049: ifle 107
      // 04c: goto 050
      // 04f: athrow
      // 050: aload 0
      // 051: dup
      // 052: getfield x/ocfc2b827e17.ͺ I
      // 055: bipush 1
      // 056: isub
      // 057: putfield x/ocfc2b827e17.ͺ I
      // 05a: invokestatic net/minecraft/client/gui/GuiScreen.isCtrlKeyDown ()Z
      // 05d: iload 3
      // 05e: ifne 113
      // 061: goto 065
      // 064: athrow
      // 065: ifeq 107
      // 068: goto 06c
      // 06b: athrow
      // 06c: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 06f: aload 0
      // 070: getfield x/ocfc2b827e17.ͺ I
      // 073: aload 0
      // 074: getfield x/ocfc2b827e17.ͺ I
      // 077: bipush 1
      // 078: iadd
      // 079: invokestatic java/util/Collections.swap (Ljava/util/List;II)V
      // 07c: iload 3
      // 07d: invokestatic x/ocd6bc26d10b.Շ ()V
      // 080: ifeq 107
      // 083: goto 087
      // 086: athrow
      // 087: aload 0
      // 088: getfield x/ocfc2b827e17.ͺ I
      // 08b: iload 3
      // 08c: ifne 113
      // 08f: goto 093
      // 092: athrow
      // 093: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 096: invokeinterface java/util/List.size ()I 1
      // 09b: bipush 1
      // 09c: isub
      // 09d: if_icmpge 107
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: aload 0
      // 0a5: dup
      // 0a6: getfield x/ocfc2b827e17.ͺ I
      // 0a9: bipush 1
      // 0aa: iadd
      // 0ab: putfield x/ocfc2b827e17.ͺ I
      // 0ae: invokestatic net/minecraft/client/gui/GuiScreen.isCtrlKeyDown ()Z
      // 0b1: iload 3
      // 0b2: ifne 113
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: ifeq 107
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 0c3: aload 0
      // 0c4: getfield x/ocfc2b827e17.ͺ I
      // 0c7: aload 0
      // 0c8: getfield x/ocfc2b827e17.ͺ I
      // 0cb: bipush 1
      // 0cc: isub
      // 0cd: invokestatic java/util/Collections.swap (Ljava/util/List;II)V
      // 0d0: iload 3
      // 0d1: invokestatic x/ocd6bc26d10b.Շ ()V
      // 0d4: ifeq 107
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 0
      // 0dc: aload 0
      // 0dd: getfield x/ocfc2b827e17.ѧ Lnet/minecraft/client/gui/GuiButton;
      // 0e0: invokevirtual x/ocfc2b827e17.actionPerformed (Lnet/minecraft/client/gui/GuiButton;)V
      // 0e3: iload 3
      // 0e4: ifeq 107
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 0
      // 0ec: aload 0
      // 0ed: getfield x/ocfc2b827e17.Τ Lnet/minecraft/client/gui/GuiButton;
      // 0f0: invokevirtual x/ocfc2b827e17.actionPerformed (Lnet/minecraft/client/gui/GuiButton;)V
      // 0f3: iload 3
      // 0f4: ifeq 107
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: aload 0
      // 0fc: aload 0
      // 0fd: getfield x/ocfc2b827e17.Ǫ Lnet/minecraft/client/gui/GuiButton;
      // 100: invokevirtual x/ocfc2b827e17.actionPerformed (Lnet/minecraft/client/gui/GuiButton;)V
      // 103: goto 107
      // 106: athrow
      // 107: iload 2
      // 108: iload 3
      // 109: ifne 126
      // 10c: invokestatic net/minecraft/client/gui/GuiScreen.isKeyComboCtrlC (I)Z
      // 10f: goto 113
      // 112: athrow
      // 113: ifeq 142
      // 116: aload 0
      // 117: iload 3
      // 118: ifne 139
      // 11b: goto 11f
      // 11e: athrow
      // 11f: getfield x/ocfc2b827e17.ͺ I
      // 122: goto 126
      // 125: athrow
      // 126: iflt 142
      // 129: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 12c: aload 0
      // 12d: getfield x/ocfc2b827e17.ͺ I
      // 130: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 135: goto 139
      // 138: athrow
      // 139: checkcast x/oc804fdd8d75
      // 13c: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 13f: invokestatic net/minecraft/client/gui/GuiScreen.setClipboardString (Ljava/lang/String;)V
      // 142: return
   }

   protected void actionPerformed(GuiButton param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/ocf130f74f2a.ʡ Z
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 012
      // 009: ifnonnull 011
      // 00c: goto 010
      // 00f: athrow
      // 010: return
      // 011: aload 1
      // 012: iload 2
      // 013: ifne 025
      // 016: getfield net/minecraft/client/gui/GuiButton.enabled Z
      // 019: ifeq 1f5
      // 01c: goto 020
      // 01f: athrow
      // 020: aload 1
      // 021: goto 025
      // 024: athrow
      // 025: getfield net/minecraft/client/gui/GuiButton.id I
      // 028: tableswitch 449 0 9 56 161 184 264 375 283 306 329 352 437
      // 060: aload 0
      // 061: iload 2
      // 062: ifne 099
      // 065: goto 069
      // 068: athrow
      // 069: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 06c: ifnull 089
      // 06f: goto 073
      // 072: athrow
      // 073: aload 0
      // 074: iload 2
      // 075: ifne 099
      // 078: goto 07c
      // 07b: athrow
      // 07c: getfield x/ocfc2b827e17.ο Ljava/util/concurrent/CompletableFuture;
      // 07f: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 082: ifeq 1f5
      // 085: goto 089
      // 088: athrow
      // 089: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 08c: aload 0
      // 08d: getfield x/ocfc2b827e17.ͺ I
      // 090: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 095: goto 099
      // 098: athrow
      // 099: checkcast x/oc804fdd8d75
      // 09c: astore 3
      // 09d: iload 2
      // 09e: ifne 0c5
      // 0a1: aload 3
      // 0a2: invokevirtual x/oc804fdd8d75.Ҟ ()Z
      // 0a5: ifeq 0bc
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: aload 0
      // 0ad: aload 3
      // 0ae: ldc_w "&aSuccessful login! (%s)&r"
      // 0b1: invokevirtual x/ocfc2b827e17.Ө (Lx/oc804fdd8d75;Ljava/lang/String;)V
      // 0b4: iload 2
      // 0b5: ifeq 1f5
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: aload 0
      // 0bd: aload 3
      // 0be: invokevirtual x/ocfc2b827e17.ǉ (Lx/oc804fdd8d75;)V
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: iload 2
      // 0c6: ifeq 1f5
      // 0c9: aload 0
      // 0ca: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 0cd: new x/oc3aee363e08
      // 0d0: dup
      // 0d1: aload 0
      // 0d2: invokespecial x/oc3aee363e08.<init> (Lnet/minecraft/client/gui/GuiScreen;)V
      // 0d5: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 0d8: iload 2
      // 0d9: ifeq 1f5
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: aload 0
      // 0e1: iload 2
      // 0e2: ifne 0f9
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: getfield x/ocfc2b827e17.ͺ I
      // 0ec: bipush -1
      // 0ed: if_icmple 1f5
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: iload 2
      // 0fa: ifne 129
      // 0fd: getfield x/ocfc2b827e17.ͺ I
      // 100: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 103: invokeinterface java/util/List.size ()I 1
      // 108: if_icmpge 1f5
      // 10b: goto 10f
      // 10e: athrow
      // 10f: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 112: aload 0
      // 113: getfield x/ocfc2b827e17.ͺ I
      // 116: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 11b: pop
      // 11c: invokestatic x/ocd6bc26d10b.Շ ()V
      // 11f: aload 0
      // 120: bipush -1
      // 121: putfield x/ocfc2b827e17.ͺ I
      // 124: aload 0
      // 125: goto 129
      // 128: athrow
      // 129: invokevirtual x/ocfc2b827e17.updateScreen ()V
      // 12c: iload 2
      // 12d: ifeq 1f5
      // 130: aload 0
      // 131: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 134: aload 0
      // 135: getfield x/ocfc2b827e17.Ӑ Lnet/minecraft/client/gui/GuiScreen;
      // 138: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 13b: iload 2
      // 13c: ifeq 1f5
      // 13f: goto 143
      // 142: athrow
      // 143: aload 0
      // 144: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 147: new x/ocb62046b034
      // 14a: dup
      // 14b: aload 0
      // 14c: invokespecial x/ocb62046b034.<init> (Lnet/minecraft/client/gui/GuiScreen;)V
      // 14f: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 152: iload 2
      // 153: ifeq 1f5
      // 156: goto 15a
      // 159: athrow
      // 15a: aload 0
      // 15b: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 15e: new x/oc1fbb91e541
      // 161: dup
      // 162: aload 0
      // 163: invokespecial x/oc1fbb91e541.<init> (Lnet/minecraft/client/gui/GuiScreen;)V
      // 166: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 169: iload 2
      // 16a: ifeq 1f5
      // 16d: goto 171
      // 170: athrow
      // 171: aload 0
      // 172: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 175: new x/ocf0b373a94c
      // 178: dup
      // 179: aload 0
      // 17a: invokespecial x/ocf0b373a94c.<init> (Lnet/minecraft/client/gui/GuiScreen;)V
      // 17d: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 180: iload 2
      // 181: ifeq 1f5
      // 184: goto 188
      // 187: athrow
      // 188: aload 0
      // 189: getfield net/minecraft/client/gui/GuiScreen.mc Lnet/minecraft/client/Minecraft;
      // 18c: new x/oc2aee63e2ea
      // 18f: dup
      // 190: aload 0
      // 191: invokespecial x/oc2aee63e2ea.<init> (Lnet/minecraft/client/gui/GuiScreen;)V
      // 194: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 197: iload 2
      // 198: ifeq 1f5
      // 19b: goto 19f
      // 19e: athrow
      // 19f: invokestatic x/occ791aa07d0.Ǿ ()Z
      // 1a2: ifeq 1f5
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: aload 0
      // 1aa: new x/ocb8a733cf81
      // 1ad: dup
      // 1ae: ldc_w "&aRestored launch session! (%s)&r"
      // 1b1: bipush 1
      // 1b2: anewarray 340
      // 1b5: dup
      // 1b6: bipush 0
      // 1b7: invokestatic x/occ791aa07d0.þ ()Lnet/minecraft/util/Session;
      // 1ba: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 1bd: aastore
      // 1be: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 1c1: invokestatic x/oc54714bd439.Ǥ (Ljava/lang/String;)Ljava/lang/String;
      // 1c4: ldc2_w -7127347594268102864
      // 1c7: ldc2_w -7127347594268099400
      // 1ca: lxor
      // 1cb: invokespecial x/ocb8a733cf81.<init> (Ljava/lang/String;J)V
      // 1ce: putfield x/ocfc2b827e17.J Lx/ocb8a733cf81;
      // 1d1: iload 2
      // 1d2: aload 0
      // 1d3: invokevirtual x/ocfc2b827e17.updateScreen ()V
      // 1d6: ifeq 1f5
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: aload 0
      // 1de: invokevirtual x/ocfc2b827e17.ԁ ()V
      // 1e1: iload 2
      // 1e2: ifeq 1f5
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: aload 0
      // 1ea: getfield x/ocfc2b827e17.շ Lx/oc6277b2748e;
      // 1ed: aload 1
      // 1ee: invokevirtual net/minecraft/client/gui/GuiSlot.actionPerformed (Lnet/minecraft/client/gui/GuiButton;)V
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: return
   }
}
