package x;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;

public class oce20150e0a5 extends oc69da1aa7f5 {
   private static final int Ձ = 0;
   private static final int ȹ = 1;
   private static final int ǟ = 2;
   private static final String[] Ȁ;
   private final oca9cc61aada Ā;
   private final occ2f8dff8d8 Ř;
   private final occ2f8dff8d8 ȋ;
   private final Queue<C0EPacketClickWindow> Ё = new ConcurrentLinkedQueue<>();
   private final Map<KeyBinding, Boolean> Э = new LinkedHashMap<>();
   private KeyBinding[] À = new KeyBinding[0];
   private boolean Ã;
   private boolean ϱ;
   private C16PacketClientStatus Č;
   private int Ӎ;
   public static boolean Đ;

   public oce20150e0a5() {
      super("InvMove", oce4cea752dd.ҕ);
      this.ą("Allows movement while selected menus are open.");
      this.ʌ(this.Ā = new oca9cc61aada("Mode", 0, Ȁ));
      this.ʌ(this.Ř = new occ2f8dff8d8("Click GUI", true));
      this.ʌ(this.ȋ = new occ2f8dff8d8("Lock move key", false));
      this.ʸ();
   }

   @Override
   public String getInfo() {
      return Ȁ[this.Ǆ()];
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      try {
         if (var1 == this.Ā) {
            this.C();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
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
      // 00: bipush 0
      // 01: istore 1
      // 02: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05: ifnull 2f
      // 08: aload 0
      // 09: iload 1
      // 0a: ifne 47
      // 0d: goto 11
      // 10: athrow
      // 11: getfield x/oce20150e0a5.Ã Z
      // 14: ifeq 2f
      // 17: goto 1b
      // 1a: athrow
      // 1b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 21: ifnull 2f
      // 24: goto 28
      // 27: athrow
      // 28: invokestatic net/minecraft/client/settings/KeyBinding.unPressAllKeys ()V
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: bipush 0
      // 31: putfield x/oce20150e0a5.Ã Z
      // 34: aload 0
      // 35: bipush 0
      // 36: putfield x/oce20150e0a5.ϱ Z
      // 39: aload 0
      // 3a: invokevirtual x/oce20150e0a5.Ĩ ()V
      // 3d: aload 0
      // 3e: invokevirtual x/oce20150e0a5.ć ()V
      // 41: aload 0
      // 42: bipush 0
      // 43: putfield x/oce20150e0a5.Ӎ I
      // 46: aload 0
      // 47: invokevirtual x/oce20150e0a5.ө ()V
      // 4a: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ο(oc9adb807c19 var1) {
      try {
         if (var1.Ұ == oc110d7f376c.START) {
            this.Ĩ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ù(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 07: astore 4
      // 09: istore 2
      // 0a: aload 4
      // 0c: instanceof x/oc1cb76bf763
      // 0f: iload 2
      // 10: ifne 41
      // 13: ifeq 35
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 4
      // 1c: checkcast x/oc1cb76bf763
      // 1f: astore 3
      // 20: aload 3
      // 21: invokevirtual x/oc1cb76bf763.Ы ()Z
      // 24: iload 2
      // 25: ifne 41
      // 28: ifne 35
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: invokevirtual x/oce20150e0a5.Ϻ ()V
      // 33: return
      // 34: athrow
      // 35: aload 0
      // 36: iload 2
      // 37: ifne 50
      // 3a: invokevirtual x/oce20150e0a5.Ǆ ()I
      // 3d: goto 41
      // 40: athrow
      // 41: ldc 1027795798
      // 43: ldc 1027795796
      // 45: ixor
      // 46: if_icmpne 4f
      // 49: aload 0
      // 4a: invokevirtual x/oce20150e0a5.Է ()V
      // 4d: return
      // 4e: athrow
      // 4f: aload 0
      // 50: iload 2
      // 51: ifne 7c
      // 54: invokevirtual x/oce20150e0a5.ӯ ()Z
      // 57: ifeq 7b
      // 5a: goto 5e
      // 5d: athrow
      // 5e: aload 0
      // 5f: iload 2
      // 60: ifne 7c
      // 63: goto 67
      // 66: athrow
      // 67: getfield x/oce20150e0a5.Ř Lx/occ2f8dff8d8;
      // 6a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 6d: ifeq 7b
      // 70: goto 74
      // 73: athrow
      // 74: aload 0
      // 75: bipush 1
      // 76: invokevirtual x/oce20150e0a5.Ǒ (Z)V
      // 79: return
      // 7a: athrow
      // 7b: aload 0
      // 7c: iload 2
      // 7d: ifne e1
      // 80: invokevirtual x/oce20150e0a5.Ү ()Z
      // 83: ifeq cc
      // 86: goto 8a
      // 89: athrow
      // 8a: aload 0
      // 8b: iload 2
      // 8c: ifne c4
      // 8f: goto 93
      // 92: athrow
      // 93: invokevirtual x/oce20150e0a5.Ɵ ()Z
      // 96: ifeq bf
      // 99: goto 9d
      // 9c: athrow
      // 9d: aload 0
      // 9e: iload 2
      // 9f: ifne c4
      // a2: goto a6
      // a5: athrow
      // a6: getfield x/oce20150e0a5.ȋ Lx/occ2f8dff8d8;
      // a9: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // ac: ifeq bf
      // af: goto b3
      // b2: athrow
      // b3: aload 0
      // b4: invokevirtual x/oce20150e0a5.ѡ ()V
      // b7: iload 2
      // b8: ifeq f5
      // bb: goto bf
      // be: athrow
      // bf: aload 0
      // c0: goto c4
      // c3: athrow
      // c4: bipush 1
      // c5: invokevirtual x/oce20150e0a5.Ǒ (Z)V
      // c8: iload 2
      // c9: ifeq f5
      // cc: aload 0
      // cd: invokevirtual x/oce20150e0a5.Ϻ ()V
      // d0: aload 0
      // d1: iload 2
      // d2: ifne ec
      // d5: goto d9
      // d8: athrow
      // d9: invokevirtual x/oce20150e0a5.ć ()V
      // dc: aload 0
      // dd: goto e1
      // e0: athrow
      // e1: getfield x/oce20150e0a5.Ӎ I
      // e4: ifle f5
      // e7: aload 0
      // e8: goto ec
      // eb: athrow
      // ec: dup
      // ed: getfield x/oce20150e0a5.Ӎ I
      // f0: bipush 1
      // f1: isub
      // f2: putfield x/oce20150e0a5.Ӎ I
      // f5: return
   }

   @oc66fa4f2195
   public void ӷ(oc1059074ce8 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: invokevirtual x/oce20150e0a5.Ǆ ()I
      // 06: iload 2
      // 07: ifne 2b
      // 0a: ldc 1949028376
      // 0c: ldc 1949028378
      // 0e: ixor
      // 0f: if_icmpne 54
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: iload 2
      // 1a: ifne 4d
      // 1d: goto 21
      // 20: athrow
      // 21: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 24: instanceof net/minecraft/client/gui/inventory/GuiInventory
      // 27: goto 2b
      // 2a: athrow
      // 2b: ifne 46
      // 2e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 31: iload 2
      // 32: ifne 4d
      // 35: goto 39
      // 38: athrow
      // 39: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 3c: instanceof net/minecraft/client/gui/inventory/GuiChest
      // 3f: ifeq 54
      // 42: goto 46
      // 45: athrow
      // 46: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 49: goto 4d
      // 4c: athrow
      // 4d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 50: bipush 0
      // 51: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 54: return
   }

   @oc66fa4f2195
   public void Ҟ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: invokevirtual x/oce20150e0a5.Ǆ ()I
      // 06: iload 2
      // 07: ifne 27
      // 0a: ldc -1117127339
      // 0c: ldc -1117127337
      // 0e: ixor
      // 0f: if_icmpne 18
      // 12: goto 16
      // 15: athrow
      // 16: return
      // 17: athrow
      // 18: aload 1
      // 19: iload 2
      // 1a: ifne 39
      // 1d: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 20: instanceof net/minecraft/network/play/client/C16PacketClientStatus
      // 23: goto 27
      // 26: athrow
      // 27: ifeq 38
      // 2a: aload 0
      // 2b: aload 1
      // 2c: aload 1
      // 2d: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 30: checkcast net/minecraft/network/play/client/C16PacketClientStatus
      // 33: invokevirtual x/oce20150e0a5.κ (Lx/oc9d4393f3ce;Lnet/minecraft/network/play/client/C16PacketClientStatus;)V
      // 36: return
      // 37: athrow
      // 38: aload 1
      // 39: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 3c: iload 2
      // 3d: ifne 5c
      // 40: instanceof net/minecraft/network/play/client/C0DPacketCloseWindow
      // 43: ifeq 58
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: aload 1
      // 4c: aload 1
      // 4d: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 50: checkcast net/minecraft/network/play/client/C0DPacketCloseWindow
      // 53: invokevirtual x/oce20150e0a5.ù (Lx/oc9d4393f3ce;Lnet/minecraft/network/play/client/C0DPacketCloseWindow;)V
      // 56: return
      // 57: athrow
      // 58: aload 1
      // 59: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 5c: instanceof net/minecraft/network/play/client/C0EPacketClickWindow
      // 5f: ifeq 72
      // 62: aload 0
      // 63: aload 1
      // 64: aload 1
      // 65: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 68: checkcast net/minecraft/network/play/client/C0EPacketClickWindow
      // 6b: invokevirtual x/oce20150e0a5.Ѻ (Lx/oc9d4393f3ce;Lnet/minecraft/network/play/client/C0EPacketClickWindow;)V
      // 6e: goto 72
      // 71: athrow
      // 72: return
   }

   private void κ(oc9d4393f3ce param1, C16PacketClientStatus param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oce20150e0a5.Ԃ ()V
      // 04: aload 0
      // 05: invokevirtual x/oce20150e0a5.Ǆ ()I
      // 08: ifne 27
      // 0b: aload 2
      // 0c: invokevirtual net/minecraft/network/play/client/C16PacketClientStatus.getStatus ()Lnet/minecraft/network/play/client/C16PacketClientStatus$EnumState;
      // 0f: getstatic net/minecraft/network/play/client/C16PacketClientStatus$EnumState.OPEN_INVENTORY_ACHIEVEMENT Lnet/minecraft/network/play/client/C16PacketClientStatus$EnumState;
      // 12: if_acmpne 27
      // 15: goto 19
      // 18: athrow
      // 19: aload 1
      // 1a: bipush 1
      // 1b: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 1e: aload 0
      // 1f: aload 2
      // 20: putfield x/oce20150e0a5.Č Lnet/minecraft/network/play/client/C16PacketClientStatus;
      // 23: goto 27
      // 26: athrow
      // 27: return
   }

   private void ù(oc9d4393f3ce param1, C0DPacketCloseWindow param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: aload 2
      // 03: invokevirtual net/minecraft/network/play/client/C0DPacketCloseWindow.getWindowId ()I
      // 06: ifne 2a
      // 09: aload 0
      // 0a: iload 3
      // 0b: ifne 21
      // 0e: goto 12
      // 11: athrow
      // 12: getfield x/oce20150e0a5.Č Lnet/minecraft/network/play/client/C16PacketClientStatus;
      // 15: ifnull 2a
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: goto 21
      // 20: athrow
      // 21: aconst_null
      // 22: putfield x/oce20150e0a5.Č Lnet/minecraft/network/play/client/C16PacketClientStatus;
      // 25: aload 1
      // 26: bipush 1
      // 27: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 2a: return
   }

   private void Ѻ(oc9d4393f3ce param1, C0EPacketClickWindow param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: aload 2
      // 03: invokestatic x/oce20150e0a5.ˁ (Lnet/minecraft/network/play/client/C0EPacketClickWindow;)Z
      // 06: iload 3
      // 07: ifne 4b
      // 0a: ifeq 3f
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: invokevirtual x/oce20150e0a5.Ǆ ()I
      // 15: iload 3
      // 16: ifne 2d
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush 1
      // 1e: if_icmpeq 38
      // 21: goto 25
      // 24: athrow
      // 25: aload 2
      // 26: invokevirtual net/minecraft/network/play/client/C0EPacketClickWindow.getWindowId ()I
      // 29: goto 2d
      // 2c: athrow
      // 2d: iload 3
      // 2e: ifne 4b
      // 31: ifne 3f
      // 34: goto 38
      // 37: athrow
      // 38: aload 1
      // 39: bipush 1
      // 3a: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 3d: return
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 3
      // 41: ifne 7f
      // 44: invokevirtual x/oce20150e0a5.Ǆ ()I
      // 47: goto 4b
      // 4a: athrow
      // 4b: ifne 7a
      // 4e: aload 2
      // 4f: invokevirtual net/minecraft/network/play/client/C0EPacketClickWindow.getWindowId ()I
      // 52: ifne a3
      // 55: goto 59
      // 58: athrow
      // 59: aload 0
      // 5a: iload 3
      // 5b: ifne a4
      // 5e: goto 62
      // 61: athrow
      // 62: getfield x/oce20150e0a5.Č Lnet/minecraft/network/play/client/C16PacketClientStatus;
      // 65: ifnull a3
      // 68: goto 6c
      // 6b: athrow
      // 6c: aload 0
      // 6d: aload 1
      // 6e: aload 2
      // 6f: invokevirtual x/oce20150e0a5.Ҁ (Lx/oc9d4393f3ce;Lnet/minecraft/network/play/client/C0EPacketClickWindow;)V
      // 72: iload 3
      // 73: ifeq a3
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 0
      // 7b: goto 7f
      // 7e: athrow
      // 7f: iload 3
      // 80: ifne a4
      // 83: invokevirtual x/oce20150e0a5.Ǆ ()I
      // 86: bipush 1
      // 87: if_icmpne a3
      // 8a: goto 8e
      // 8d: athrow
      // 8e: aload 0
      // 8f: aload 1
      // 90: aload 2
      // 91: invokevirtual x/oce20150e0a5.Ҁ (Lx/oc9d4393f3ce;Lnet/minecraft/network/play/client/C0EPacketClickWindow;)V
      // 94: aload 0
      // 95: ldc_w -1615906804
      // 98: ldc_w -1615906812
      // 9b: ixor
      // 9c: putfield x/oce20150e0a5.Ӎ I
      // 9f: goto a3
      // a2: athrow
      // a3: aload 0
      // a4: invokevirtual x/oce20150e0a5.ć ()V
      // a7: return
   }

   private void Ҁ(oc9d4393f3ce var1, C0EPacketClickWindow var2) {
      KeyBinding.unPressAllKeys();
      var1.setCanceled(true);
      this.Ё.offer(var2);
   }

   private boolean Ү() {
      boolean var1 = false;
      int var2 = 1836952697 ^ 1259035273;

      while (true) {
         label206:
         while (true) {
            label204:
            while (true) {
               label200:
               while (true) {
                  switch (var2) {
                     case -1648599952:
                        int var17;
                        label135: {
                           label134: {
                              try {
                                 var17 = this.Ӎ;
                                 if (var1) {
                                    break label135;
                                 }

                                 if (this.Ӎ != 0) {
                                    break label134;
                                 }
                              } catch (ocbde1165e4e var6) {
                                 throw var6;
                              }

                              var2 = -480775625 ^ 1259035273;
                              if (!var1) {
                                 continue;
                              }
                           }

                           var17 = 1082961013 ^ 1259035273;
                        }

                        var2 = var17;
                        if (var1) {
                           return false;
                        }
                        continue;
                     case -1470322498:
                        break;
                     case -1469539094:
                        return false;
                     case -1193028760:
                        int var12;
                        label183: {
                           label182: {
                              try {
                                 var12 = this.Ǆ();
                                 if (var1) {
                                    break label183;
                                 }

                                 if (var12 != 0) {
                                    break label182;
                                 }
                              } catch (ocbde1165e4e var10) {
                                 throw var10;
                              }

                              var2 = 1987370034 ^ 1259035273;
                              if (!var1) {
                                 continue;
                              }
                           }

                           var12 = 1773683262 ^ 1259035273;
                        }

                        var2 = var12;
                        if (!var1) {
                           continue;
                        }
                     case 645330672:
                        int var13;
                        label163: {
                           label162: {
                              try {
                                 var13 = oc69da1aa7f5.ő.currentScreen instanceof GuiContainer;
                                 if (var1) {
                                    break label163;
                                 }

                                 if (var13 == 0) {
                                    break label162;
                                 }
                              } catch (ocbde1165e4e var8) {
                                 throw var8;
                              }

                              var2 = 1473276076 ^ 1259035273;
                              if (!var1) {
                                 continue;
                              }
                           }

                           var13 = -480000413 ^ 1259035273;
                        }

                        var2 = var13;
                        if (!var1) {
                           continue;
                        }
                        break label200;
                     case -993308352:
                        return false;
                     case -721136599:
                        return true;
                     case -712610421:
                        break label200;
                     case 193459964:
                        return false;
                     case 484127269:
                        break label204;
                     case 582162615:
                        int var11;
                        label108: {
                           label107: {
                              try {
                                 var11 = this.Ǆ();
                                 if (var1) {
                                    break label108;
                                 }

                                 if (var11 != 1) {
                                    break label107;
                                 }
                              } catch (ocbde1165e4e var3) {
                                 throw var3;
                              }

                              var2 = -692648199 ^ 1259035273;
                              if (!var1) {
                                 continue;
                              }
                           }

                           var11 = 1082961013 ^ 1259035273;
                        }

                        var2 = var11;
                        if (!var1) {
                           continue;
                        }

                        return true;
                     case 665757440:
                        return true;
                     case 1031767739:
                        int var10000;
                        label172: {
                           label171: {
                              try {
                                 var10000 = oc69da1aa7f5.ő.currentScreen instanceof GuiInventory;
                                 if (var1) {
                                    break label172;
                                 }

                                 if (var10000 == 0) {
                                    break label171;
                                 }
                              } catch (ocbde1165e4e var9) {
                                 throw var9;
                              }

                              var2 = -1634912510 ^ 1259035273;
                              if (!var1) {
                                 continue;
                              }
                           }

                           var10000 = -1883239479 ^ 1259035273;
                        }

                        var2 = var10000;
                        if (!var1) {
                           continue;
                        }
                        break;
                     case 1246673954:
                        break label206;
                     default:
                        throw null;
                  }

                  int var15;
                  label150: {
                     label149: {
                        try {
                           var15 = this.Ё.isEmpty();
                           if (var1) {
                              break label150;
                           }

                           if (var15 == 0) {
                              break label149;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var2 = -1643180384 ^ 1259035273;
                        if (!var1) {
                           continue;
                        }
                     }

                     var15 = 1082961013 ^ 1259035273;
                  }

                  var2 = var15;
                  if (var1) {
                     break label204;
                  }
               }

               if (this.Č != null) {
                  var2 = 21358251 ^ 1259035273;
                  if (!var1) {
                     continue;
                  }
               }

               var2 = -1883239479 ^ 1259035273;
               if (var1) {
                  break label206;
               }
            }

            int var16;
            label126: {
               label125: {
                  try {
                     var16 = oc69da1aa7f5.ő.currentScreen instanceof GuiContainerCreative;
                     if (var1) {
                        break label126;
                     }

                     if (var16 == 0) {
                        break label125;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var2 = -480000413 ^ 1259035273;
                  if (!var1) {
                     continue;
                  }
               }

               var16 = -202864159 ^ 1259035273;
            }

            var2 = var16;
            if (var1) {
               return false;
            }
         }

         int var14;
         label117: {
            label116: {
               try {
                  var14 = this.Ё.isEmpty();
                  if (var1) {
                     break label117;
                  }

                  if (var14 == 0) {
                     break label116;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var2 = 1822817673 ^ 1259035273;
               if (!var1) {
                  continue;
               }
            }

            var14 = -1883239479 ^ 1259035273;
         }

         var2 = var14;
         if (var1) {
            return false;
         }
      }
   }

   private void Ǒ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: iload 2
      // 04: ifne 14
      // 07: invokevirtual x/oce20150e0a5.ʸ ()Z
      // 0a: ifne 13
      // 0d: goto 11
      // 10: athrow
      // 11: return
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oce20150e0a5.Э Ljava/util/Map;
      // 17: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 1c: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 21: astore 3
      // 22: aload 3
      // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28: ifeq 6e
      // 2b: aload 3
      // 2c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 31: checkcast net/minecraft/client/settings/KeyBinding
      // 34: astore 4
      // 36: iload 2
      // 37: ifne 9b
      // 3a: iload 1
      // 3b: ifeq 5c
      // 3e: goto 42
      // 41: athrow
      // 42: aload 4
      // 44: iload 2
      // 45: ifne 62
      // 48: goto 4c
      // 4b: athrow
      // 4c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4f: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 52: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 55: if_acmpeq 6a
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 4
      // 5e: goto 62
      // 61: athrow
      // 62: aload 4
      // 64: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 67: invokestatic x/oce20150e0a5.ʣ (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // 6a: iload 2
      // 6b: ifeq 22
      // 6e: getstatic x/oc9755810e45.à Lx/ocd2c4efd8d9;
      // 71: iload 2
      // 72: ifne 7f
      // 75: ifnull 96
      // 78: goto 7c
      // 7b: athrow
      // 7c: getstatic x/oc9755810e45.à Lx/ocd2c4efd8d9;
      // 7f: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 82: ifeq 96
      // 85: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 88: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 8b: getfield net/minecraft/client/settings/GameSettings.keyBindSprint Lnet/minecraft/client/settings/KeyBinding;
      // 8e: bipush 1
      // 8f: invokestatic x/oce20150e0a5.ʣ (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // 92: goto 96
      // 95: athrow
      // 96: aload 0
      // 97: bipush 1
      // 98: putfield x/oce20150e0a5.Ã Z
      // 9b: return
   }

   private void Ԃ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 14
      // 07: invokevirtual x/oce20150e0a5.ʸ ()Z
      // 0a: ifne 13
      // 0d: goto 11
      // 10: athrow
      // 11: return
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oce20150e0a5.Э Ljava/util/Map;
      // 17: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 1c: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 21: astore 2
      // 22: aload 2
      // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28: ifeq 4f
      // 2b: aload 2
      // 2c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 31: checkcast java/util/Map$Entry
      // 34: astore 3
      // 35: iload 1
      // 36: aload 3
      // 37: aload 3
      // 38: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 3d: checkcast net/minecraft/client/settings/KeyBinding
      // 40: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 43: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 46: invokeinterface java/util/Map$Entry.setValue (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 4b: pop
      // 4c: ifeq 22
      // 4f: return
   }

   private void ѡ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 14
      // 07: invokevirtual x/oce20150e0a5.ʸ ()Z
      // 0a: ifne 13
      // 0d: goto 11
      // 10: athrow
      // 11: return
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oce20150e0a5.Э Ljava/util/Map;
      // 17: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 1c: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 21: astore 2
      // 22: aload 2
      // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28: ifeq 59
      // 2b: aload 2
      // 2c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 31: checkcast java/util/Map$Entry
      // 34: astore 3
      // 35: aload 3
      // 36: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 3b: checkcast net/minecraft/client/settings/KeyBinding
      // 3e: aload 3
      // 3f: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 44: checkcast java/lang/Boolean
      // 47: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 4a: iload 1
      // 4b: ifne 7e
      // 4e: invokestatic x/oce20150e0a5.ʣ (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // 51: iload 1
      // 52: ifeq 22
      // 55: goto 59
      // 58: athrow
      // 59: getstatic x/oc9755810e45.à Lx/ocd2c4efd8d9;
      // 5c: iload 1
      // 5d: ifne 6a
      // 60: ifnull 81
      // 63: goto 67
      // 66: athrow
      // 67: getstatic x/oc9755810e45.à Lx/ocd2c4efd8d9;
      // 6a: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 6d: ifeq 81
      // 70: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 73: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 76: getfield net/minecraft/client/settings/GameSettings.keyBindSprint Lnet/minecraft/client/settings/KeyBinding;
      // 79: bipush 1
      // 7a: goto 7e
      // 7d: athrow
      // 7e: invokestatic x/oce20150e0a5.ʣ (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // 81: aload 0
      // 82: bipush 1
      // 83: putfield x/oce20150e0a5.Ã Z
      // 86: return
   }

   private void Ϻ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: getfield x/oce20150e0a5.Ã Z
      // 06: ifne 0b
      // 09: return
      // 0a: athrow
      // 0b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 11: ifnull 1f
      // 14: invokestatic net/minecraft/client/settings/KeyBinding.unPressAllKeys ()V
      // 17: iload 1
      // 18: ifeq 3f
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: iload 1
      // 21: ifne 40
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual x/oce20150e0a5.Ɵ ()Z
      // 2b: ifeq 3f
      // 2e: goto 32
      // 31: athrow
      // 32: aload 0
      // 33: invokevirtual x/oce20150e0a5.ө ()V
      // 36: aload 0
      // 37: bipush 0
      // 38: invokevirtual x/oce20150e0a5.Ǒ (Z)V
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: bipush 0
      // 41: putfield x/oce20150e0a5.Ã Z
      // 44: return
   }

   private void Է() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: invokevirtual x/oce20150e0a5.ʸ ()Z
      // 06: ifne 0b
      // 09: return
      // 0a: athrow
      // 0b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e: iload 1
      // 0f: ifne 26
      // 12: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 15: ifnonnull 23
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: bipush 1
      // 1e: invokevirtual x/oce20150e0a5.д (Z)V
      // 21: return
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 29: instanceof net/minecraft/client/gui/GuiChat
      // 2c: iload 1
      // 2d: ifne 47
      // 30: ifne 60
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: iload 1
      // 39: ifne 68
      // 3c: goto 40
      // 3f: athrow
      // 40: invokevirtual x/oce20150e0a5.ӯ ()Z
      // 43: goto 47
      // 46: athrow
      // 47: ifeq 67
      // 4a: aload 0
      // 4b: iload 1
      // 4c: ifne 68
      // 4f: goto 53
      // 52: athrow
      // 53: getfield x/oce20150e0a5.Ř Lx/occ2f8dff8d8;
      // 56: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 59: ifne 67
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 0
      // 61: bipush 0
      // 62: invokevirtual x/oce20150e0a5.д (Z)V
      // 65: return
      // 66: athrow
      // 67: aload 0
      // 68: iload 1
      // 69: ifne 84
      // 6c: getfield x/oce20150e0a5.ϱ Z
      // 6f: ifne 83
      // 72: goto 76
      // 75: athrow
      // 76: aload 0
      // 77: invokevirtual x/oce20150e0a5.Ԃ ()V
      // 7a: aload 0
      // 7b: bipush 1
      // 7c: putfield x/oce20150e0a5.ϱ Z
      // 7f: goto 83
      // 82: athrow
      // 83: aload 0
      // 84: getfield x/oce20150e0a5.À [Lnet/minecraft/client/settings/KeyBinding;
      // 87: astore 2
      // 88: aload 2
      // 89: arraylength
      // 8a: istore 3
      // 8b: bipush 0
      // 8c: istore 4
      // 8e: iload 4
      // 90: iload 3
      // 91: if_icmpge f4
      // 94: aload 2
      // 95: iload 4
      // 97: aaload
      // 98: astore 5
      // 9a: iload 1
      // 9b: ifne f9
      // 9e: aload 0
      // 9f: iload 1
      // a0: ifne b9
      // a3: goto a7
      // a6: athrow
      // a7: getfield x/oce20150e0a5.ȋ Lx/occ2f8dff8d8;
      // aa: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // ad: ifeq df
      // b0: goto b4
      // b3: athrow
      // b4: aload 0
      // b5: goto b9
      // b8: athrow
      // b9: iload 1
      // ba: ifne d6
      // bd: invokevirtual x/oce20150e0a5.Ɵ ()Z
      // c0: ifeq df
      // c3: goto c7
      // c6: athrow
      // c7: aload 0
      // c8: getfield x/oce20150e0a5.Э Ljava/util/Map;
      // cb: aload 5
      // cd: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // d2: goto d6
      // d5: athrow
      // d6: checkcast java/lang/Boolean
      // d9: invokevirtual java/lang/Boolean.booleanValue ()Z
      // dc: goto e4
      // df: aload 5
      // e1: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // e4: istore 6
      // e6: iload 1
      // e7: aload 5
      // e9: iload 6
      // eb: invokestatic x/oce20150e0a5.ʣ (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // ee: iinc 4 1
      // f1: ifeq 8e
      // f4: aload 0
      // f5: bipush 1
      // f6: putfield x/oce20150e0a5.Ã Z
      // f9: return
   }

   private void д(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: iload 2
      // 04: ifne 6e
      // 07: getfield x/oce20150e0a5.ϱ Z
      // 0a: ifeq 63
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: getfield x/oce20150e0a5.À [Lnet/minecraft/client/settings/KeyBinding;
      // 15: astore 3
      // 16: aload 3
      // 17: arraylength
      // 18: istore 4
      // 1a: bipush 0
      // 1b: istore 5
      // 1d: iload 5
      // 1f: iload 4
      // 21: if_icmpge 63
      // 24: aload 3
      // 25: iload 5
      // 27: aaload
      // 28: astore 6
      // 2a: iload 2
      // 2b: ifne 71
      // 2e: aload 6
      // 30: iload 1
      // 31: iload 2
      // 32: ifne 49
      // 35: goto 39
      // 38: athrow
      // 39: ifeq 58
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 6
      // 42: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 45: goto 49
      // 48: athrow
      // 49: iload 2
      // 4a: ifne 55
      // 4d: ifeq 58
      // 50: goto 54
      // 53: athrow
      // 54: bipush 1
      // 55: goto 59
      // 58: bipush 0
      // 59: invokestatic x/oce20150e0a5.ʣ (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // 5c: iload 2
      // 5d: iinc 5 1
      // 60: ifeq 1d
      // 63: aload 0
      // 64: bipush 0
      // 65: putfield x/oce20150e0a5.ϱ Z
      // 68: aload 0
      // 69: bipush 0
      // 6a: putfield x/oce20150e0a5.Ã Z
      // 6d: aload 0
      // 6e: invokevirtual x/oce20150e0a5.ө ()V
      // 71: return
   }

   private void Ĩ() {
      boolean var1 = false;

      while (!this.Ё.isEmpty()) {
         ocd6ae010123.ĕ((Packet)this.Ё.poll());
         if (var1) {
            break;
         }
      }
   }

   private void ć() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 1d
      // 07: getfield x/oce20150e0a5.Č Lnet/minecraft/network/play/client/C16PacketClientStatus;
      // 0a: ifnull 21
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: getfield x/oce20150e0a5.Č Lnet/minecraft/network/play/client/C16PacketClientStatus;
      // 15: invokestatic x/ocd6ae010123.ĕ (Lnet/minecraft/network/Packet;)V
      // 18: aload 0
      // 19: goto 1d
      // 1c: athrow
      // 1d: aconst_null
      // 1e: putfield x/oce20150e0a5.Č Lnet/minecraft/network/play/client/C16PacketClientStatus;
      // 21: return
   }

   private void C() {
      this.Ĩ();
      this.ć();
      this.Ӎ = 0;
      this.Ϻ();
      this.ϱ = false;
   }

   private void ө() {
      Iterator var2 = this.Э.entrySet().iterator();
      boolean var1 = false;

      while (var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var3.setValue(false);
         if (var1) {
            break;
         }
      }
   }

   private boolean Ɵ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: getfield x/oce20150e0a5.Э Ljava/util/Map;
      // 05: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 0a: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0f: astore 2
      // 10: istore 1
      // 11: aload 2
      // 12: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 17: ifeq 41
      // 1a: aload 2
      // 1b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20: checkcast java/lang/Boolean
      // 23: astore 3
      // 24: aload 3
      // 25: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 28: iload 1
      // 29: ifne 42
      // 2c: iload 1
      // 2d: ifne 3c
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 3d
      // 37: goto 3b
      // 3a: athrow
      // 3b: bipush 1
      // 3c: ireturn
      // 3d: iload 1
      // 3e: ifeq 11
      // 41: bipush 0
      // 42: ireturn
   }

   private boolean ӯ() {
      boolean var1 = false;
      int var2 = -1133520004 ^ 567917221;

      while (true) {
         switch (var2) {
            case -1648991783:
               int var5;
               label46: {
                  label45: {
                     try {
                        var5 = oc69da1aa7f5.ő.currentScreen instanceof oc2c25634a7e;
                        if (var1) {
                           break label46;
                        }

                        if (var5 != 0) {
                           break label45;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -616671924 ^ 567917221;
                     if (!var1) {
                        break;
                     }
                  }

                  var5 = -640335802 ^ 567917221;
               }

               var2 = var5;
               if (!var1) {
                  break;
               }
            case -1886210124:
               return false;
            case -133367069:
               return true;
            case -85463063:
               int var10000;
               label37: {
                  label36: {
                     try {
                        var10000 = oc69da1aa7f5.ő.currentScreen instanceof oc1cb76bf763;
                        if (var1) {
                           break label37;
                        }

                        if (var10000 == 0) {
                           break label36;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -640335802 ^ 567917221;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = -1370813167 ^ 567917221;
               }

               var2 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private static boolean ˁ(C0EPacketClickWindow var0) {
      boolean var1 = false;
      int var2 = -1136551432 ^ -484453036;

      while (true) {
         switch (var2) {
            case 440061047:
               int var6;
               label69: {
                  label68: {
                     try {
                        var6 = var0.getMode();
                        if (var1) {
                           break label69;
                        }

                        if (var6 != (-484453040 ^ -484453036)) {
                           break label68;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = 9123953 ^ -484453036;
                     if (!var1) {
                        break;
                     }
                  }

                  var6 = -1375683549 ^ -484453036;
               }

               var2 = var6;
               if (!var1) {
                  break;
               }
            case -476779227:
               int var7;
               label57: {
                  label56: {
                     try {
                        var7 = var0.getSlotId();
                        if (var1) {
                           break label57;
                        }

                        if (var7 != (484452685 ^ -484453036)) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -1661448916 ^ -484453036;
                     if (!var1) {
                        break;
                     }
                  }

                  var7 = -1375683549 ^ -484453036;
               }

               var2 = var7;
               if (!var1) {
                  break;
               }

               return false;
            case 1293904247:
               return false;
            case 1600015532:
               int var10000;
               label48: {
                  label47: {
                     try {
                        var10000 = var0.getMode();
                        if (var1) {
                           break label48;
                        }

                        if (var10000 == (-484453033 ^ -484453036)) {
                           break label47;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -115009245 ^ -484453036;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = 9123953 ^ -484453036;
               }

               var2 = var10000;
               if (!var1) {
                  break;
               }

               return true;
            case 2145884280:
               return true;
            default:
               throw null;
         }
      }
   }

   private static void ʣ(KeyBinding var0, boolean var1) {
      KeyBinding.setKeyBindState(var0.getKeyCode(), var1);
   }

   private int Ǆ() {
      return Math.max(0, Math.min((int)this.Ā.Ӂ(), Ȁ.length - 1));
   }

   private boolean ʸ() {
      boolean var1 = false;
      int var2 = -22022943 ^ 1516500527;

      while (true) {
         switch (var2) {
            case -2082865312:
               if (oc69da1aa7f5.ő.gameSettings == null) {
                  var2 = 266914640 ^ 1516500527;
                  if (!var1) {
                     break;
                  }
               }

               var2 = -176854331 ^ 1516500527;
               if (!var1) {
                  break;
               }
            case -1357472534:
               int var10000;
               label43: {
                  label42: {
                     try {
                        var10000 = this.Э.isEmpty();
                        if (var1) {
                           break label43;
                        }

                        if (var10000 != 0) {
                           break label42;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -486224944 ^ 1516500527;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = -1289890545 ^ 1516500527;
               }

               var2 = var10000;
               if (!var1) {
                  break;
               }
            case -1184416257:
               return true;
            case -1530133810:
               if (oc69da1aa7f5.ő != null) {
                  var2 = -642119345 ^ 1516500527;
                  if (!var1) {
                     break;
                  }
               }

               var2 = 266914640 ^ 1516500527;
               if (!var1) {
                  break;
               }
            case 1435188607:
               return false;
            case -377609440:
               this.Э.put(oc69da1aa7f5.ő.gameSettings.keyBindForward, false);
               this.Э.put(oc69da1aa7f5.ő.gameSettings.keyBindBack, false);
               this.Э.put(oc69da1aa7f5.ő.gameSettings.keyBindLeft, false);
               this.Э.put(oc69da1aa7f5.ő.gameSettings.keyBindRight, false);
               this.Э.put(oc69da1aa7f5.ő.gameSettings.keyBindJump, false);
               this.Э.put(oc69da1aa7f5.ő.gameSettings.keyBindSneak, false);
               this.Э.put(oc69da1aa7f5.ő.gameSettings.keyBindSprint, false);
               KeyBinding[] var10001 = new KeyBinding[1516500522 ^ 1516500527];
               var10001[0] = oc69da1aa7f5.ő.gameSettings.keyBindForward;
               var10001[1] = oc69da1aa7f5.ő.gameSettings.keyBindBack;
               var10001[1516500525 ^ 1516500527] = oc69da1aa7f5.ő.gameSettings.keyBindRight;
               var10001[1516500524 ^ 1516500527] = oc69da1aa7f5.ő.gameSettings.keyBindLeft;
               var10001[1516500523 ^ 1516500527] = oc69da1aa7f5.ő.gameSettings.keyBindJump;
               this.À = var10001;
               return true;
            default:
               throw null;
         }
      }
   }

   static {
      String[] var10000 = new String[-1662146925 ^ -1662146928];
      var10000[0] = "Legit";
      var10000[1] = "Hypixel";
      var10000[-1662146926 ^ -1662146928] = "Grim";
      Ȁ = var10000;
   }
}
