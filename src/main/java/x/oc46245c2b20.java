package x;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class oc46245c2b20 {
   public static final int ȑ = 0;
   public static final int ʫ = 1;
   public static final int Ў = 2;
   public static final int ј = 3;
   public static final int ű = 10;
   public static final float Л = 5.0F;
   public static final float á = 0.2F;
   private final Y ÿ;
   private final ConcurrentLinkedQueue<oc4d040dc138> Ԟ = new ConcurrentLinkedQueue<>();
   private final Object ʅ = new Object();
   private final AtomicBoolean Ǚ = new AtomicBoolean();
   private final AtomicBoolean Ą = new AtomicBoolean();
   private boolean ô = true;
   private int ƕ;
   private int ϻ;
   private int ȭ;
   private String Ѧ = "";
   private String Ȣ = "";
   private int ĭ;
   private long ȁ;
   private volatile boolean ӕ;
   public static int ҥ;

   public oc46245c2b20() {
      this(new B());
   }

   oc46245c2b20(Y var1) {
      if (var1 == null) {
         throw new NullPointerException("backend");
      } else {
         this.ÿ = var1;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.NORMAL
   )
   public void Ԋ(oc2422fc1726 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc46245c2b20.ҥ I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 011
      // 009: ifnull 022
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 1
      // 011: invokevirtual x/oc2422fc1726.ҁ ()Lx/oc69da1aa7f5;
      // 014: ifnull 022
      // 017: aload 0
      // 018: getfield x/oc46245c2b20.ӕ Z
      // 01b: ifeq 024
      // 01e: goto 022
      // 021: athrow
      // 022: return
      // 023: athrow
      // 024: aload 1
      // 025: invokevirtual x/oc2422fc1726.ҁ ()Lx/oc69da1aa7f5;
      // 028: astore 3
      // 029: aload 3
      // 02a: iload 2
      // 02b: ifne 03d
      // 02e: getstatic x/oc9755810e45.ӛ Lx/oc3b38397625;
      // 031: if_acmpeq 043
      // 034: goto 038
      // 037: athrow
      // 038: aload 3
      // 039: goto 03d
      // 03c: athrow
      // 03d: getstatic x/oc9755810e45.ˤ Lx/oc6a43806f12;
      // 040: if_acmpne 045
      // 043: return
      // 044: athrow
      // 045: aload 0
      // 046: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 049: dup
      // 04a: astore 4
      // 04c: monitorenter
      // 04d: aload 0
      // 04e: iload 2
      // 04f: ifne 059
      // 052: getfield x/oc46245c2b20.ô Z
      // 055: ifne 0e4
      // 058: aload 0
      // 059: getfield x/oc46245c2b20.ƕ I
      // 05c: iload 2
      // 05d: ifne 066
      // 060: ifne 0e4
      // 063: invokestatic x/oc3b38397625.ӈ ()Z
      // 066: ifeq 0e4
      // 069: aload 3
      // 06a: getstatic x/oc3b38397625.Ƒ Lx/occ2f8dff8d8;
      // 06d: iload 2
      // 06e: ifne 077
      // 071: ifnull 085
      // 074: getstatic x/oc3b38397625.Ƒ Lx/occ2f8dff8d8;
      // 077: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 07a: iload 2
      // 07b: ifne 082
      // 07e: ifeq 085
      // 081: bipush 1
      // 082: goto 086
      // 085: bipush 0
      // 086: getstatic x/oc3b38397625.Ǒ Lx/occ2f8dff8d8;
      // 089: iload 2
      // 08a: ifne 093
      // 08d: ifnull 09d
      // 090: getstatic x/oc3b38397625.Ǒ Lx/occ2f8dff8d8;
      // 093: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 096: iload 2
      // 097: ifne 09e
      // 09a: ifeq 0a1
      // 09d: bipush 1
      // 09e: goto 0a2
      // 0a1: bipush 0
      // 0a2: getstatic x/oc3b38397625.Ԡ Lx/occ2f8dff8d8;
      // 0a5: iload 2
      // 0a6: ifne 0af
      // 0a9: ifnull 0b9
      // 0ac: getstatic x/oc3b38397625.Ԡ Lx/occ2f8dff8d8;
      // 0af: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b2: iload 2
      // 0b3: ifne 0ba
      // 0b6: ifeq 0bd
      // 0b9: bipush 1
      // 0ba: goto 0be
      // 0bd: bipush 0
      // 0be: getstatic x/oc3b38397625.л Lx/occ2f8dff8d8;
      // 0c1: iload 2
      // 0c2: ifne 0cb
      // 0c5: ifnull 0d5
      // 0c8: getstatic x/oc3b38397625.л Lx/occ2f8dff8d8;
      // 0cb: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0ce: iload 2
      // 0cf: ifne 0d6
      // 0d2: ifeq 0d9
      // 0d5: bipush 1
      // 0d6: goto 0da
      // 0d9: bipush 0
      // 0da: invokestatic x/oc46245c2b20.ȕ (Lx/oc69da1aa7f5;ZZZZ)Z
      // 0dd: iload 2
      // 0de: ifne 0ec
      // 0e1: ifne 0e8
      // 0e4: aload 4
      // 0e6: monitorexit
      // 0e7: return
      // 0e8: aload 1
      // 0e9: invokevirtual x/oc2422fc1726.Ʋ ()Z
      // 0ec: ifeq 105
      // 0ef: aload 0
      // 0f0: dup
      // 0f1: getfield x/oc46245c2b20.ϻ I
      // 0f4: bipush 1
      // 0f5: iadd
      // 0f6: putfield x/oc46245c2b20.ϻ I
      // 0f9: iload 2
      // 0fa: aload 0
      // 0fb: aload 3
      // 0fc: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 0ff: putfield x/oc46245c2b20.Ѧ Ljava/lang/String;
      // 102: ifeq 117
      // 105: aload 0
      // 106: dup
      // 107: getfield x/oc46245c2b20.ȭ I
      // 10a: bipush 1
      // 10b: iadd
      // 10c: putfield x/oc46245c2b20.ȭ I
      // 10f: aload 0
      // 110: aload 3
      // 111: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 114: putfield x/oc46245c2b20.Ȣ Ljava/lang/String;
      // 117: aload 4
      // 119: monitorexit
      // 11a: goto 125
      // 11d: astore 5
      // 11f: aload 4
      // 121: monitorexit
      // 122: aload 5
      // 124: athrow
      // 125: return
   }

   public void Ä() {
      synchronized (this.ʅ) {
         this.ô = false;
      }

      try {
         if (!oc3b38397625.ӈ()) {
            this.ј();
         }
      } catch (NullPointerException var3) {
         throw var3;
      }
   }

   public void Χ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: aload 0
      // 04: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 07: dup
      // 08: astore 2
      // 09: monitorenter
      // 0a: istore 1
      // 0b: aload 0
      // 0c: iload 1
      // 0d: ifne 17
      // 10: getfield x/oc46245c2b20.ô Z
      // 13: ifne 32
      // 16: aload 0
      // 17: iload 1
      // 18: ifne 22
      // 1b: getfield x/oc46245c2b20.ƕ I
      // 1e: ifne 32
      // 21: aload 0
      // 22: getfield x/oc46245c2b20.ӕ Z
      // 25: iload 1
      // 26: ifne 2f
      // 29: ifne 32
      // 2c: invokestatic x/oc3b38397625.ӈ ()Z
      // 2f: ifne 35
      // 32: aload 2
      // 33: monitorexit
      // 34: return
      // 35: aload 2
      // 36: monitorexit
      // 37: goto 3f
      // 3a: astore 3
      // 3b: aload 2
      // 3c: monitorexit
      // 3d: aload 3
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 1
      // 41: ifne 58
      // 44: getfield x/oc46245c2b20.Ǚ Ljava/util/concurrent/atomic/AtomicBoolean;
      // 47: bipush 0
      // 48: bipush 1
      // 49: invokevirtual java/util/concurrent/atomic/AtomicBoolean.compareAndSet (ZZ)Z
      // 4c: ifeq 5f
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: goto 58
      // 57: athrow
      // 58: ldc "Press RSHIFT to open GUI"
      // 5a: bipush 1
      // 5b: invokevirtual x/oc46245c2b20.ծ (Ljava/lang/String;I)Z
      // 5e: pop
      // 5f: return
   }

   public void Ϋ() {
      synchronized (this.ʅ) {
         this.ƕ++;
      }
   }

   public void ё() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: aload 0
      // 04: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 07: dup
      // 08: astore 3
      // 09: monitorenter
      // 0a: istore 1
      // 0b: aload 0
      // 0c: iload 1
      // 0d: ifne 21
      // 10: getfield x/oc46245c2b20.ƕ I
      // 13: ifle 20
      // 16: aload 0
      // 17: dup
      // 18: getfield x/oc46245c2b20.ƕ I
      // 1b: bipush 1
      // 1c: isub
      // 1d: putfield x/oc46245c2b20.ƕ I
      // 20: aload 0
      // 21: iload 1
      // 22: ifne 2c
      // 25: getfield x/oc46245c2b20.ƕ I
      // 28: ifne 44
      // 2b: aload 0
      // 2c: getfield x/oc46245c2b20.ô Z
      // 2f: iload 1
      // 30: ifne 39
      // 33: ifne 44
      // 36: invokestatic x/oc3b38397625.ӈ ()Z
      // 39: iload 1
      // 3a: ifne 41
      // 3d: ifeq 44
      // 40: bipush 1
      // 41: goto 45
      // 44: bipush 0
      // 45: istore 2
      // 46: aload 3
      // 47: monitorexit
      // 48: goto 52
      // 4b: astore 4
      // 4d: aload 3
      // 4e: monitorexit
      // 4f: aload 4
      // 51: athrow
      // 52: iload 2
      // 53: ifeq 62
      // 56: aload 0
      // 57: invokevirtual x/oc46245c2b20.Χ ()V
      // 5a: iload 1
      // 5b: ifeq 6a
      // 5e: goto 62
      // 61: athrow
      // 62: aload 0
      // 63: invokevirtual x/oc46245c2b20.ј ()V
      // 66: goto 6a
      // 69: athrow
      // 6a: bipush 0
      // 6b: ifeq 79
      // 6e: iinc 1 1
      // 71: iload 1
      // 72: putstatic x/oc46245c2b20.ҥ I
      // 75: goto 79
      // 78: athrow
      // 79: return
   }

   public boolean Ƽ() {
      int var1 = ҥ;

      try {
         if (var1 != 0) {
            return this.ӕ;
         }

         if (!this.ӕ) {
            return true;
         }
      } catch (NullPointerException var2) {
         throw var2;
      }

      return false;
   }

   public boolean Ѭ(String var1) {
      return this.ծ(var1, 1);
   }

   public boolean ծ(String var1, int var2) {
      return this.Ӣ(var1, null, var2);
   }

   public boolean Ӣ(String param1, String param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 4
      // 05: aload 1
      // 06: ifnull 1d
      // 09: aload 0
      // 0a: getfield x/oc46245c2b20.ӕ Z
      // 0d: iload 4
      // 0f: ifne 1e
      // 12: goto 16
      // 15: athrow
      // 16: ifeq 1f
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush 0
      // 1e: ireturn
      // 1f: aload 1
      // 20: invokestatic x/occda47ba572.ԥ (Ljava/lang/String;)[B
      // 23: astore 5
      // 25: iload 4
      // 27: ifne 5c
      // 2a: aload 2
      // 2b: ifnull 46
      // 2e: goto 32
      // 31: athrow
      // 32: aload 2
      // 33: invokevirtual java/lang/String.isEmpty ()Z
      // 36: iload 4
      // 38: ifne 7a
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ifeq 61
      // 42: goto 46
      // 45: athrow
      // 46: aload 0
      // 47: getfield x/oc46245c2b20.Ԟ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 4a: new x/ocd6d547d34a
      // 4d: dup
      // 4e: aload 5
      // 50: iload 3
      // 51: invokespecial x/ocd6d547d34a.<init> ([BI)V
      // 54: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.add (Ljava/lang/Object;)Z
      // 57: pop
      // 58: goto 5c
      // 5b: athrow
      // 5c: iload 4
      // 5e: ifeq 7b
      // 61: aload 0
      // 62: getfield x/oc46245c2b20.Ԟ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 65: new x/oc9db691c0d0
      // 68: dup
      // 69: aload 5
      // 6b: aload 2
      // 6c: invokestatic x/occda47ba572.ԥ (Ljava/lang/String;)[B
      // 6f: iload 3
      // 70: invokespecial x/oc9db691c0d0.<init> ([B[BI)V
      // 73: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.add (Ljava/lang/Object;)Z
      // 76: goto 7a
      // 79: athrow
      // 7a: pop
      // 7b: aload 0
      // 7c: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 7f: dup
      // 80: astore 6
      // 82: monitorenter
      // 83: aload 0
      // 84: ldc -951667676
      // 86: ldc -951667666
      // 88: ixor
      // 89: aload 0
      // 8a: getfield x/oc46245c2b20.ĭ I
      // 8d: bipush 1
      // 8e: iadd
      // 8f: invokestatic java/lang/Math.min (II)I
      // 92: putfield x/oc46245c2b20.ĭ I
      // 95: aload 6
      // 97: monitorexit
      // 98: goto a3
      // 9b: astore 7
      // 9d: aload 6
      // 9f: monitorexit
      // a0: aload 7
      // a2: athrow
      // a3: bipush 1
      // a4: ireturn
   }

   public void ј() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oc46245c2b20.Ԟ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 04: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.clear ()V
      // 07: getstatic x/oc46245c2b20.ҥ I
      // 0a: aload 0
      // 0b: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 0e: dup
      // 0f: astore 2
      // 10: monitorenter
      // 11: istore 1
      // 12: aload 0
      // 13: bipush 0
      // 14: putfield x/oc46245c2b20.ϻ I
      // 17: aload 0
      // 18: bipush 0
      // 19: putfield x/oc46245c2b20.ȭ I
      // 1c: aload 0
      // 1d: bipush 0
      // 1e: putfield x/oc46245c2b20.ĭ I
      // 21: aload 0
      // 22: lconst_0
      // 23: putfield x/oc46245c2b20.ȁ J
      // 26: aload 2
      // 27: monitorexit
      // 28: goto 30
      // 2b: astore 3
      // 2c: aload 2
      // 2d: monitorexit
      // 2e: aload 3
      // 2f: athrow
      // 30: aload 0
      // 31: iload 1
      // 32: ifne 40
      // 35: getfield x/oc46245c2b20.ӕ Z
      // 38: ifne 6d
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 1
      // 41: ifne 58
      // 44: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 47: invokeinterface x/Y.z$2jzxy5gazhwu4 ()Z 1
      // 4c: ifeq 62
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: goto 58
      // 57: athrow
      // 58: getfield x/oc46245c2b20.Ԟ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 5b: getstatic x/ocb55ca76a69.ʛ Lx/ocb55ca76a69;
      // 5e: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.add (Ljava/lang/Object;)Z
      // 61: pop
      // 62: goto 6d
      // 65: astore 2
      // 66: aload 0
      // 67: ldc "state check"
      // 69: aload 2
      // 6a: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 6d: return
   }

   public int Ӂ() {
      synchronized (this.ʅ) {
         return this.ĭ;
      }
   }

   public void ϩ(int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc46245c2b20.ҥ I
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 016
      // 009: getfield x/oc46245c2b20.ӕ Z
      // 00c: ifeq 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: invokevirtual x/oc46245c2b20.ȣ ()Z
      // 019: iload 3
      // 01a: ifne 04f
      // 01d: ifeq 048
      // 020: goto 024
      // 023: athrow
      // 024: aload 0
      // 025: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 028: dup
      // 029: astore 4
      // 02b: monitorenter
      // 02c: aload 0
      // 02d: bipush 0
      // 02e: putfield x/oc46245c2b20.ϻ I
      // 031: aload 0
      // 032: bipush 0
      // 033: putfield x/oc46245c2b20.ȭ I
      // 036: aload 4
      // 038: monitorexit
      // 039: goto 044
      // 03c: astore 5
      // 03e: aload 4
      // 040: monitorexit
      // 041: aload 5
      // 043: athrow
      // 044: iload 3
      // 045: ifeq 062
      // 048: invokestatic x/oc3b38397625.ӈ ()Z
      // 04b: goto 04f
      // 04e: athrow
      // 04f: iload 3
      // 050: ifne 06b
      // 053: ifeq 062
      // 056: goto 05a
      // 059: athrow
      // 05a: aload 0
      // 05b: invokevirtual x/oc46245c2b20.ҁ ()V
      // 05e: goto 062
      // 061: athrow
      // 062: aload 0
      // 063: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 066: invokeinterface x/Y.z$2jzxy5gazhwu4 ()Z 1
      // 06b: istore 4
      // 06d: goto 07b
      // 070: astore 5
      // 072: aload 0
      // 073: ldc "state check"
      // 075: aload 5
      // 077: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 07a: return
      // 07b: iload 4
      // 07d: iload 3
      // 07e: ifne 09b
      // 081: ifne 0c8
      // 084: goto 088
      // 087: athrow
      // 088: aload 0
      // 089: iload 3
      // 08a: ifne 0a0
      // 08d: goto 091
      // 090: athrow
      // 091: getfield x/oc46245c2b20.Ԟ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 094: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.isEmpty ()Z
      // 097: goto 09b
      // 09a: athrow
      // 09b: ifeq 09f
      // 09e: return
      // 09f: aload 0
      // 0a0: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 0a3: invokeinterface x/Y.z$2gday96yll2pf ()Z 1
      // 0a8: istore 5
      // 0aa: goto 0b9
      // 0ad: astore 6
      // 0af: aload 0
      // 0b0: ldc_w "initialize"
      // 0b3: aload 6
      // 0b5: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0b8: return
      // 0b9: iload 5
      // 0bb: ifne 0c8
      // 0be: aload 0
      // 0bf: ldc_w "initialize"
      // 0c2: aconst_null
      // 0c3: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0c6: return
      // 0c7: athrow
      // 0c8: aload 0
      // 0c9: getfield x/oc46245c2b20.Ԟ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 0cc: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.poll ()Ljava/lang/Object;
      // 0cf: checkcast x/oc4d040dc138
      // 0d2: dup
      // 0d3: astore 5
      // 0d5: ifnull 10f
      // 0d8: aload 5
      // 0da: aload 0
      // 0db: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 0de: invokeinterface x/oc4d040dc138.z$31q357ggzdzwj (Lx/Y;)Z 2
      // 0e3: istore 6
      // 0e5: goto 0f8
      // 0e8: astore 7
      // 0ea: aload 0
      // 0eb: aload 5
      // 0ed: invokeinterface x/oc4d040dc138.z$1as8rqlsd5xg1 ()Ljava/lang/String; 1
      // 0f2: aload 7
      // 0f4: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0f7: return
      // 0f8: iload 6
      // 0fa: ifne 10b
      // 0fd: aload 0
      // 0fe: aload 5
      // 100: invokeinterface x/oc4d040dc138.z$1as8rqlsd5xg1 ()Ljava/lang/String; 1
      // 105: aconst_null
      // 106: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 109: return
      // 10a: athrow
      // 10b: iload 3
      // 10c: ifeq 0c8
      // 10f: invokestatic java/lang/System.nanoTime ()J
      // 112: lstore 6
      // 114: aload 0
      // 115: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 118: dup
      // 119: astore 9
      // 11b: monitorenter
      // 11c: aload 0
      // 11d: getfield x/oc46245c2b20.ȁ J
      // 120: iload 3
      // 121: ifne 134
      // 124: lconst_0
      // 125: lcmp
      // 126: ifne 12d
      // 129: fconst_0
      // 12a: goto 139
      // 12d: lload 6
      // 12f: aload 0
      // 130: getfield x/oc46245c2b20.ȁ J
      // 133: lsub
      // 134: l2f
      // 135: ldc_w 1.0E9
      // 138: fdiv
      // 139: fstore 8
      // 13b: aload 0
      // 13c: lload 6
      // 13e: putfield x/oc46245c2b20.ȁ J
      // 141: aload 9
      // 143: monitorexit
      // 144: goto 14f
      // 147: astore 10
      // 149: aload 9
      // 14b: monitorexit
      // 14c: aload 10
      // 14e: athrow
      // 14f: aload 0
      // 150: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 153: iload 1
      // 154: iload 2
      // 155: fload 8
      // 157: invokestatic x/oc3b38397625.ʰ ()I
      // 15a: invokestatic x/oc3b38397625.ʨ ()F
      // 15d: invokestatic x/oc3b38397625.ô ()I
      // 160: invokeinterface x/Y.z$12vyxinw74gli (IIFIFI)Z 7
      // 165: istore 9
      // 167: goto 176
      // 16a: astore 10
      // 16c: aload 0
      // 16d: ldc_w "render"
      // 170: aload 10
      // 172: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 175: return
      // 176: iload 9
      // 178: ifne 187
      // 17b: aload 0
      // 17c: ldc_w "render"
      // 17f: aconst_null
      // 180: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 183: goto 187
      // 186: athrow
      // 187: return
   }

   public void Ԝ() {
      this.Ԟ.clear();
      synchronized (this.ʅ) {
         this.ϻ = 0;
         this.ȭ = 0;
         this.ĭ = 0;
         this.ȁ = 0L;
      }

      try {
         this.ÿ.z$38t27rg719lzv();
      } catch (Throwable var3) {
         this.ϥ("shutdown", var3, false);
      }
   }

   public int ԙ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 17
      // 09: getfield x/oc46245c2b20.ӕ Z
      // 0c: ifeq 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 1a: invokeinterface x/Y.z$9kdk14j2dxki ()I 1
      // 1f: ireturn
      // 20: astore 2
      // 21: aload 0
      // 22: ldc_w "backend query"
      // 25: aload 2
      // 26: invokevirtual x/oc46245c2b20.ȃ (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 29: bipush 0
      // 2a: ireturn
   }

   private void ҁ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: getstatic x/oc46245c2b20.ҥ I
      // 05: aconst_null
      // 06: astore 3
      // 07: istore 1
      // 08: aload 0
      // 09: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 0c: dup
      // 0d: astore 4
      // 0f: monitorenter
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 1c
      // 15: getfield x/oc46245c2b20.ϻ I
      // 18: ifeq 4d
      // 1b: aload 0
      // 1c: iload 1
      // 1d: ifne 38
      // 20: getfield x/oc46245c2b20.ϻ I
      // 23: bipush 1
      // 24: if_icmpne 37
      // 27: aload 0
      // 28: getfield x/oc46245c2b20.Ѧ Ljava/lang/String;
      // 2b: ldc_w "Enabled "
      // 2e: swap
      // 2f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 34: goto 47
      // 37: aload 0
      // 38: getfield x/oc46245c2b20.ϻ I
      // 3b: ldc_w "Enabled "
      // 3e: swap
      // 3f: ldc_w " mods"
      // 42: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 47: astore 2
      // 48: aload 0
      // 49: bipush 0
      // 4a: putfield x/oc46245c2b20.ϻ I
      // 4d: aload 0
      // 4e: iload 1
      // 4f: ifne 59
      // 52: getfield x/oc46245c2b20.ȭ I
      // 55: ifeq 8a
      // 58: aload 0
      // 59: iload 1
      // 5a: ifne 75
      // 5d: getfield x/oc46245c2b20.ȭ I
      // 60: bipush 1
      // 61: if_icmpne 74
      // 64: aload 0
      // 65: getfield x/oc46245c2b20.Ȣ Ljava/lang/String;
      // 68: ldc_w "Disabled "
      // 6b: swap
      // 6c: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 71: goto 84
      // 74: aload 0
      // 75: getfield x/oc46245c2b20.ȭ I
      // 78: ldc_w "Disabled "
      // 7b: swap
      // 7c: ldc_w " mods"
      // 7f: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 84: astore 3
      // 85: aload 0
      // 86: bipush 0
      // 87: putfield x/oc46245c2b20.ȭ I
      // 8a: aload 4
      // 8c: monitorexit
      // 8d: goto 98
      // 90: astore 5
      // 92: aload 4
      // 94: monitorexit
      // 95: aload 5
      // 97: athrow
      // 98: aload 2
      // 99: iload 1
      // 9a: ifne b0
      // 9d: ifnull af
      // a0: goto a4
      // a3: athrow
      // a4: aload 0
      // a5: aload 2
      // a6: bipush 1
      // a7: invokevirtual x/oc46245c2b20.ծ (Ljava/lang/String;I)Z
      // aa: pop
      // ab: goto af
      // ae: athrow
      // af: aload 3
      // b0: ifnull be
      // b3: aload 0
      // b4: aload 3
      // b5: bipush 1
      // b6: invokevirtual x/oc46245c2b20.ծ (Ljava/lang/String;I)Z
      // b9: pop
      // ba: goto be
      // bd: athrow
      // be: return
   }

   private boolean ȣ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 1
      // 04: getstatic x/oc3b38397625.ԟ Lx/occ2f8dff8d8;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 23
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc3b38397625.ԟ Lx/occ2f8dff8d8;
      // 15: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 18: iload 1
      // 19: ifne 24
      // 1c: ifne 25
      // 1f: goto 23
      // 22: athrow
      // 23: bipush 0
      // 24: ireturn
      // 25: getstatic x/oc2cf3d80e17.Х Lnet/minecraft/client/Minecraft;
      // 28: iload 1
      // 29: ifne 36
      // 2c: ifnull 5f
      // 2f: goto 33
      // 32: athrow
      // 33: getstatic x/oc2cf3d80e17.Х Lnet/minecraft/client/Minecraft;
      // 36: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 39: iload 1
      // 3a: ifne 51
      // 3d: instanceof x/oc2c25634a7e
      // 40: ifne 63
      // 43: goto 47
      // 46: athrow
      // 47: getstatic x/oc2cf3d80e17.Х Lnet/minecraft/client/Minecraft;
      // 4a: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 4d: goto 51
      // 50: athrow
      // 51: instanceof x/oc1cb76bf763
      // 54: iload 1
      // 55: ifne 60
      // 58: ifne 63
      // 5b: goto 5f
      // 5e: athrow
      // 5f: bipush 1
      // 60: goto 64
      // 63: bipush 0
      // 64: ireturn
   }

   private void ȃ(String var1, Throwable var2) {
      this.ϥ(var1, var2, true);
   }

   private void ϥ(String param1, Throwable param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc46245c2b20.ҥ I
      // 003: istore 4
      // 005: iload 4
      // 007: aload 0
      // 008: getfield x/oc46245c2b20.ʅ Ljava/lang/Object;
      // 00b: dup
      // 00c: astore 5
      // 00e: monitorenter
      // 00f: ifne 036
      // 012: aload 0
      // 013: getfield x/oc46245c2b20.ӕ Z
      // 016: ifeq 01d
      // 019: aload 5
      // 01b: monitorexit
      // 01c: return
      // 01d: aload 0
      // 01e: bipush 1
      // 01f: putfield x/oc46245c2b20.ӕ Z
      // 022: aload 0
      // 023: bipush 0
      // 024: putfield x/oc46245c2b20.ϻ I
      // 027: aload 0
      // 028: bipush 0
      // 029: putfield x/oc46245c2b20.ȭ I
      // 02c: aload 0
      // 02d: bipush 0
      // 02e: putfield x/oc46245c2b20.ĭ I
      // 031: aload 0
      // 032: lconst_0
      // 033: putfield x/oc46245c2b20.ȁ J
      // 036: aload 5
      // 038: monitorexit
      // 039: goto 044
      // 03c: astore 6
      // 03e: aload 5
      // 040: monitorexit
      // 041: aload 6
      // 043: athrow
      // 044: aload 0
      // 045: getfield x/oc46245c2b20.Ԟ Ljava/util/concurrent/ConcurrentLinkedQueue;
      // 048: invokevirtual java/util/concurrent/ConcurrentLinkedQueue.clear ()V
      // 04b: aload 2
      // 04c: iload 4
      // 04e: ifne 05f
      // 051: ifnonnull 05e
      // 054: goto 058
      // 057: athrow
      // 058: ldc ""
      // 05a: goto 062
      // 05d: athrow
      // 05e: aload 2
      // 05f: invokestatic x/oc46245c2b20.ϊ (Ljava/lang/Throwable;)Ljava/lang/String;
      // 062: astore 5
      // 064: aload 0
      // 065: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 068: invokeinterface x/Y.z$3kyzxig9p2tuo ()Ljava/lang/String; 1
      // 06d: astore 6
      // 06f: aload 6
      // 071: iload 4
      // 073: ifne 086
      // 076: ifnull 0d6
      // 079: goto 07d
      // 07c: athrow
      // 07d: aload 6
      // 07f: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 082: goto 086
      // 085: athrow
      // 086: iload 4
      // 088: ifne 09b
      // 08b: invokevirtual java/lang/String.isEmpty ()Z
      // 08e: ifne 0d6
      // 091: goto 095
      // 094: athrow
      // 095: aload 6
      // 097: goto 09b
      // 09a: athrow
      // 09b: iload 4
      // 09d: ifne 0b2
      // 0a0: aload 5
      // 0a2: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0a5: ifne 0d6
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: aload 5
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: iload 4
      // 0b4: ifne 0c9
      // 0b7: invokevirtual java/lang/String.isEmpty ()Z
      // 0ba: ifeq 0c7
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: aload 6
      // 0c3: goto 0d4
      // 0c6: athrow
      // 0c7: aload 5
      // 0c9: aload 6
      // 0cb: ldc_w "; "
      // 0ce: swap
      // 0cf: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0d4: astore 5
      // 0d6: goto 0f3
      // 0d9: astore 6
      // 0db: aload 5
      // 0dd: iload 4
      // 0df: ifne 0f5
      // 0e2: invokevirtual java/lang/String.isEmpty ()Z
      // 0e5: ifeq 0f3
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: aload 6
      // 0ee: invokestatic x/oc46245c2b20.ϊ (Ljava/lang/Throwable;)Ljava/lang/String;
      // 0f1: astore 5
      // 0f3: aload 5
      // 0f5: iload 4
      // 0f7: ifne 11c
      // 0fa: ifnull 119
      // 0fd: goto 101
      // 100: athrow
      // 101: aload 5
      // 103: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 106: invokevirtual java/lang/String.isEmpty ()Z
      // 109: iload 4
      // 10b: ifne 11f
      // 10e: goto 112
      // 111: athrow
      // 112: ifeq 11e
      // 115: goto 119
      // 118: athrow
      // 119: ldc_w "unknown native renderer error"
      // 11c: astore 5
      // 11e: iload 3
      // 11f: iload 4
      // 121: ifne 142
      // 124: ifeq 139
      // 127: goto 12b
      // 12a: athrow
      // 12b: aload 0
      // 12c: getfield x/oc46245c2b20.ÿ Lx/Y;
      // 12f: invokeinterface x/Y.z$38t27rg719lzv ()V 1
      // 134: goto 139
      // 137: astore 6
      // 139: aload 0
      // 13a: getfield x/oc46245c2b20.Ą Ljava/util/concurrent/atomic/AtomicBoolean;
      // 13d: bipush 0
      // 13e: bipush 1
      // 13f: invokevirtual java/util/concurrent/atomic/AtomicBoolean.compareAndSet (ZZ)Z
      // 142: ifeq 17c
      // 145: aload 1
      // 146: aload 5
      // 148: ldc_w "Notifications native "
      // 14b: dup_x2
      // 14c: pop
      // 14d: ldc_w " failed: "
      // 150: swap
      // 151: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 156: astore 6
      // 158: getstatic x/oc7ab2161b9f.ô Lorg/apache/logging/log4j/Logger;
      // 15b: aload 6
      // 15d: aload 2
      // 15e: invokeinterface org/apache/logging/log4j/Logger.error (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 163: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 166: ifeq 177
      // 169: aload 6
      // 16b: ldc_w "&c"
      // 16e: swap
      // 16f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 174: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 177: goto 17c
      // 17a: astore 7
      // 17c: getstatic x/oc9755810e45.ӛ Lx/oc3b38397625;
      // 17f: iload 4
      // 181: ifne 18e
      // 184: ifnull 1c1
      // 187: goto 18b
      // 18a: athrow
      // 18b: getstatic x/oc9755810e45.ӛ Lx/oc3b38397625;
      // 18e: iload 4
      // 190: ifne 1a0
      // 193: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 196: ifeq 1c1
      // 199: goto 19d
      // 19c: athrow
      // 19d: getstatic x/oc9755810e45.ӛ Lx/oc3b38397625;
      // 1a0: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 1a3: goto 1c1
      // 1a6: astore 6
      // 1a8: getstatic x/oc7ab2161b9f.ô Lorg/apache/logging/log4j/Logger;
      // 1ab: ldc_w "Could not disable Notifications after native failure"
      // 1ae: aload 6
      // 1b0: invokeinterface org/apache/logging/log4j/Logger.error (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 1b5: goto 1ba
      // 1b8: astore 7
      // 1ba: getstatic x/oc9755810e45.ӛ Lx/oc3b38397625;
      // 1bd: bipush 0
      // 1be: invokevirtual x/oc69da1aa7f5.ӂ (Z)V
      // 1c1: return
   }

   private static String ϊ(Throwable param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: aload 0
      // 04: invokevirtual java/lang/Throwable.getMessage ()Ljava/lang/String;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 0
      // 0a: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 0d: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 10: aload 2
      // 11: iload 1
      // 12: ifne 38
      // 15: ifnull 32
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 2
      // 1d: iload 1
      // 1e: ifne 3c
      // 21: goto 25
      // 24: athrow
      // 25: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 28: invokevirtual java/lang/String.isEmpty ()Z
      // 2b: ifeq 3b
      // 2e: goto 32
      // 31: athrow
      // 32: ldc ""
      // 34: goto 38
      // 37: athrow
      // 38: goto 45
      // 3b: aload 2
      // 3c: ldc_w ": "
      // 3f: swap
      // 40: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 45: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 4a: areturn
   }

   public static boolean ȕ(oc69da1aa7f5 param0, boolean param1, boolean param2, boolean param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 5
      // 05: aload 0
      // 06: ifnull 2e
      // 09: iload 1
      // 0a: iload 5
      // 0c: ifne 3c
      // 0f: goto 13
      // 12: athrow
      // 13: ifeq 31
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: invokevirtual x/oc69da1aa7f5.ŷ ()Z
      // 1e: iload 5
      // 20: ifne 3c
      // 23: goto 27
      // 26: athrow
      // 27: ifeq 31
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush 0
      // 2f: ireturn
      // 30: athrow
      // 31: getstatic x/oc2d388dc739.Ħ [I
      // 34: aload 0
      // 35: invokevirtual x/oc69da1aa7f5.ъ ()Lx/oce4cea752dd;
      // 38: invokevirtual java/lang/Enum.ordinal ()I
      // 3b: iaload
      // 3c: iload 5
      // 3e: ifne 64
      // 41: lookupswitch 33 2 1 28 2 31
      // 5c: athrow
      // 5d: iload 2
      // 5e: ireturn
      // 5f: athrow
      // 60: iload 3
      // 61: ireturn
      // 62: iload 4
      // 64: ireturn
   }

   public static float Ǚ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 1
      // 04: fload 0
      // 05: ldc 0.2
      // 07: iload 1
      // 08: ifne 28
      // 0b: fcmpg
      // 0c: ifge 1c
      // 0f: goto 13
      // 12: athrow
      // 13: fload 0
      // 14: ldc 0.2
      // 16: fdiv
      // 17: invokestatic x/oc46245c2b20.ӿ (F)F
      // 1a: freturn
      // 1b: athrow
      // 1c: fload 0
      // 1d: iload 1
      // 1e: ifne 39
      // 21: ldc_w 4.8
      // 24: goto 28
      // 27: athrow
      // 28: fcmpl
      // 29: ifle 38
      // 2c: ldc 5.0
      // 2e: fload 0
      // 2f: fsub
      // 30: ldc 0.2
      // 32: fdiv
      // 33: invokestatic x/oc46245c2b20.ӿ (F)F
      // 36: freturn
      // 37: athrow
      // 38: fconst_1
      // 39: freturn
   }

   public static boolean Ů(float var0) {
      int var1 = ҥ;

      try {
         float var3;
         int var10000 = (var3 = var0 - 5.0F) == 0.0F ? 0 : (var3 < 0.0F ? -1 : 1);
         if (var1 != 0) {
            return (boolean)var10000;
         }

         if (var10000 > 0) {
            return (boolean)1;
         }
      } catch (NullPointerException var2) {
         throw var2;
      }

      return (boolean)0;
   }

   private static float ӿ(float var0) {
      return (3.0F - 2.0F * var0) * var0 * var0;
   }
}
