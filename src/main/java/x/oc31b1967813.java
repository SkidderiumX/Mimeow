package x;

import net.minecraft.network.play.client.C02PacketUseEntity;

public class oc31b1967813 extends ocb5eb238adf {
   public oc5fe36d3bb5 ո;
   public final String ƥ;
   public ocbf5a535fb8 ϒ;
   public static boolean е;

   public oc31b1967813(oc5fe36d3bb5 var1, String var2, ocbf5a535fb8 var3) {
      super(Ю(var1, var2, var3));
      this.ո = var1;
      this.ƥ = var2;
      this.ϒ = var3;
   }

   public oc31b1967813(C02PacketUseEntity var1) {
      super(var1);
      this.ƥ = var1.getAction() == null ? null : var1.getAction().name();
      this.ϒ = ocbf5a535fb8.É(var1.getHitVec());
      this.ո = null;
   }

   public C02PacketUseEntity z$3uoime2rixgf9() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/occ0b63c0426.Ο I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1b
      // 09: getfield x/ocb5eb238adf.ϣ Lnet/minecraft/network/Packet;
      // 0c: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 0f: ifeq 24
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: getfield x/ocb5eb238adf.ϣ Lnet/minecraft/network/Packet;
      // 1e: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 21: goto 25
      // 24: aconst_null
      // 25: areturn
   }

   private static C02PacketUseEntity Ю(oc5fe36d3bb5 param0, String param1, ocbf5a535fb8 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/occ0b63c0426.Ο I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 11
      // 09: ifnull 17
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: getfield x/oc5fe36d3bb5.տ Lnet/minecraft/entity/Entity;
      // 14: ifnonnull 1a
      // 17: aconst_null
      // 18: areturn
      // 19: athrow
      // 1a: aload 1
      // 1b: iload 3
      // 1c: ifne 2d
      // 1f: ifnonnull 2c
      // 22: goto 26
      // 25: athrow
      // 26: ldc "ATTACK"
      // 28: goto 33
      // 2b: athrow
      // 2c: aload 1
      // 2d: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 30: invokevirtual java/lang/String.toUpperCase (Ljava/util/Locale;)Ljava/lang/String;
      // 33: invokestatic net/minecraft/network/play/client/C02PacketUseEntity$Action.valueOf (Ljava/lang/String;)Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 36: astore 4
      // 38: goto 42
      // 3b: astore 5
      // 3d: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 40: astore 4
      // 42: aload 4
      // 44: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.INTERACT_AT Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 47: if_acmpne 65
      // 4a: aload 2
      // 4b: ifnull 65
      // 4e: goto 52
      // 51: athrow
      // 52: new net/minecraft/network/play/client/C02PacketUseEntity
      // 55: dup
      // 56: aload 0
      // 57: getfield x/oc5fe36d3bb5.տ Lnet/minecraft/entity/Entity;
      // 5a: aload 2
      // 5b: invokevirtual x/ocbf5a535fb8.љ ()Lnet/minecraft/util/Vec3;
      // 5e: invokespecial net/minecraft/network/play/client/C02PacketUseEntity.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 61: goto 72
      // 64: athrow
      // 65: new net/minecraft/network/play/client/C02PacketUseEntity
      // 68: dup
      // 69: aload 0
      // 6a: getfield x/oc5fe36d3bb5.տ Lnet/minecraft/entity/Entity;
      // 6d: aload 4
      // 6f: invokespecial net/minecraft/network/play/client/C02PacketUseEntity.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;)V
      // 72: areturn
   }
}
