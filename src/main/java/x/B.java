package x;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Set;
import org.lwjgl.system.SharedLibrary;

public class B implements Y {
   private static final String т = "assets/idle.miau/fonts/product_sans_medium.ttf";
   private static final String ľ = "assets/idle.miau/fonts/product_sans_bold.ttf";
   private static final String х = "68f690d4d66bfe861bada25318be1c9aa54b453250d22241d0615db686cb2ee3";
   private static final String ј = "8dbeee804c249634fd860cae932f54afe759de8c17c136995fcae57c24348cf9";
   private static final String ѡ = "mimeow_vlkr_notifications_init";
   private static final String ȸ = "mimeow_vlkr_notifications_enqueue";
   private static final String ɢ = "mimeow_vlkr_notifications_enqueue_ex";
   private static final String у = "mimeow_vlkr_notifications_clear";
   private static final String ý = "mimeow_vlkr_notifications_render";
   private static final String п = "mimeow_vlkr_notifications_shutdown";
   private static final String Ϩ = "mimeow_vlkr_notifications_backend";
   private static final String i = "mimeow_vlkr_notifications_error";
   private SharedLibrary ɗ;
   private long Ć;
   private long Ӫ;
   private long ƈ;
   private long Ѣ;
   private long փ;
   private long ɰ;
   private long Ӌ;
   private long о;
   private boolean ǫ;
   private boolean Ž;
   private String ƺ = "";

   B() {
   }

   public synchronized boolean z$2gday96yll2pf() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc46245c2b20.ҥ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 017
      // 009: getfield x/B.ǫ Z
      // 00c: ifeq 016
      // 00f: goto 013
      // 012: athrow
      // 013: bipush 1
      // 014: ireturn
      // 015: athrow
      // 016: aload 0
      // 017: iload 1
      // 018: ifne 029
      // 01b: getfield x/B.Ž Z
      // 01e: ifeq 028
      // 021: goto 025
      // 024: athrow
      // 025: bipush 0
      // 026: ireturn
      // 027: athrow
      // 028: aload 0
      // 029: bipush 1
      // 02a: putfield x/B.Ž Z
      // 02d: aconst_null
      // 02e: astore 2
      // 02f: aconst_null
      // 030: astore 3
      // 031: ldc "os.name"
      // 033: ldc ""
      // 035: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 038: ldc "os.arch"
      // 03a: ldc ""
      // 03c: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 03f: invokestatic x/oc9e7110bab2.ʐ (Ljava/lang/String;Ljava/lang/String;)Lx/oc9e7110bab2;
      // 042: astore 4
      // 044: aload 4
      // 046: iload 1
      // 047: ifne 05e
      // 04a: ifnonnull 05c
      // 04d: goto 051
      // 050: athrow
      // 051: new java/io/IOException
      // 054: dup
      // 055: ldc "Notifications support only Linux x86-64 and Windows x86-64"
      // 057: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 05a: athrow
      // 05b: athrow
      // 05c: aload 4
      // 05e: invokestatic x/B.Ε (Lx/oc9e7110bab2;)Ljava/nio/file/Path;
      // 061: astore 5
      // 063: iload 1
      // 064: aload 0
      // 065: ldc x/B
      // 067: ldc "x"
      // 069: aload 5
      // 06b: invokeinterface java/nio/file/Path.toAbsolutePath ()Ljava/nio/file/Path; 1
      // 070: invokeinterface java/nio/file/Path.toString ()Ljava/lang/String; 1
      // 075: invokestatic org/lwjgl/system/Library.loadNative (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Lorg/lwjgl/system/SharedLibrary;
      // 078: putfield x/B.ɗ Lorg/lwjgl/system/SharedLibrary;
      // 07b: aload 0
      // 07c: aload 0
      // 07d: ldc "mimeow_vlkr_notifications_init"
      // 07f: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 082: putfield x/B.Ć J
      // 085: aload 0
      // 086: aload 0
      // 087: ldc "mimeow_vlkr_notifications_enqueue"
      // 089: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 08c: putfield x/B.Ӫ J
      // 08f: aload 0
      // 090: aload 0
      // 091: ldc "mimeow_vlkr_notifications_enqueue_ex"
      // 093: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 096: putfield x/B.ƈ J
      // 099: aload 0
      // 09a: aload 0
      // 09b: ldc "mimeow_vlkr_notifications_clear"
      // 09d: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 0a0: putfield x/B.Ѣ J
      // 0a3: aload 0
      // 0a4: aload 0
      // 0a5: ldc "mimeow_vlkr_notifications_render"
      // 0a7: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 0aa: putfield x/B.փ J
      // 0ad: aload 0
      // 0ae: aload 0
      // 0af: ldc "mimeow_vlkr_notifications_shutdown"
      // 0b1: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 0b4: putfield x/B.ɰ J
      // 0b7: aload 0
      // 0b8: aload 0
      // 0b9: ldc "mimeow_vlkr_notifications_backend"
      // 0bb: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 0be: putfield x/B.Ӌ J
      // 0c1: aload 0
      // 0c2: aload 0
      // 0c3: ldc "mimeow_vlkr_notifications_error"
      // 0c5: invokevirtual x/B.ʮ (Ljava/lang/String;)J
      // 0c8: putfield x/B.о J
      // 0cb: ldc "assets/idle.miau/fonts/product_sans_medium.ttf"
      // 0cd: ldc "68f690d4d66bfe861bada25318be1c9aa54b453250d22241d0615db686cb2ee3"
      // 0cf: invokestatic x/B.ì (Ljava/lang/String;Ljava/lang/String;)[B
      // 0d2: astore 6
      // 0d4: ldc "assets/idle.miau/fonts/product_sans_bold.ttf"
      // 0d6: ldc "8dbeee804c249634fd860cae932f54afe759de8c17c136995fcae57c24348cf9"
      // 0d8: invokestatic x/B.ì (Ljava/lang/String;Ljava/lang/String;)[B
      // 0db: astore 7
      // 0dd: aload 6
      // 0df: arraylength
      // 0e0: invokestatic org/lwjgl/system/MemoryUtil.memAlloc (I)Ljava/nio/ByteBuffer;
      // 0e3: astore 2
      // 0e4: aload 7
      // 0e6: arraylength
      // 0e7: invokestatic org/lwjgl/system/MemoryUtil.memAlloc (I)Ljava/nio/ByteBuffer;
      // 0ea: astore 3
      // 0eb: aload 2
      // 0ec: aload 6
      // 0ee: invokevirtual java/nio/ByteBuffer.put ([B)Ljava/nio/ByteBuffer;
      // 0f1: invokevirtual java/nio/ByteBuffer.flip ()Ljava/nio/ByteBuffer;
      // 0f4: pop
      // 0f5: aload 3
      // 0f6: aload 7
      // 0f8: invokevirtual java/nio/ByteBuffer.put ([B)Ljava/nio/ByteBuffer;
      // 0fb: invokevirtual java/nio/ByteBuffer.flip ()Ljava/nio/ByteBuffer;
      // 0fe: pop
      // 0ff: aload 2
      // 100: invokestatic org/lwjgl/system/MemoryUtil.memAddress (Ljava/nio/ByteBuffer;)J
      // 103: aload 2
      // 104: invokevirtual java/nio/ByteBuffer.remaining ()I
      // 107: aload 3
      // 108: invokestatic org/lwjgl/system/MemoryUtil.memAddress (Ljava/nio/ByteBuffer;)J
      // 10b: aload 3
      // 10c: invokevirtual java/nio/ByteBuffer.remaining ()I
      // 10f: aload 0
      // 110: getfield x/B.Ć J
      // 113: invokestatic org/lwjgl/system/JNI.invokePPI (JIJIJ)I
      // 116: istore 8
      // 118: ifne 13e
      // 11b: iload 8
      // 11d: ifne 133
      // 120: goto 124
      // 123: athrow
      // 124: new java/io/IOException
      // 127: dup
      // 128: aload 0
      // 129: ldc "native renderer initialization failed"
      // 12b: invokevirtual x/B.ұ (Ljava/lang/String;)Ljava/lang/String;
      // 12e: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 131: athrow
      // 132: athrow
      // 133: aload 0
      // 134: bipush 1
      // 135: putfield x/B.ǫ Z
      // 138: aload 0
      // 139: ldc ""
      // 13b: putfield x/B.ƺ Ljava/lang/String;
      // 13e: bipush 1
      // 13f: istore 9
      // 141: aload 2
      // 142: iload 1
      // 143: ifne 156
      // 146: ifnull 155
      // 149: goto 14d
      // 14c: athrow
      // 14d: aload 2
      // 14e: invokestatic org/lwjgl/system/MemoryUtil.memFree (Ljava/nio/ByteBuffer;)V
      // 151: goto 155
      // 154: athrow
      // 155: aload 3
      // 156: iload 1
      // 157: ifne 162
      // 15a: ifnull 165
      // 15d: goto 161
      // 160: athrow
      // 161: aload 3
      // 162: invokestatic org/lwjgl/system/MemoryUtil.memFree (Ljava/nio/ByteBuffer;)V
      // 165: iload 9
      // 167: ireturn
      // 168: astore 4
      // 16a: aload 0
      // 16b: aload 4
      // 16d: invokestatic x/B.Ҝ (Ljava/lang/Throwable;)Ljava/lang/String;
      // 170: putfield x/B.ƺ Ljava/lang/String;
      // 173: aload 0
      // 174: invokevirtual x/B.Ȝ ()V
      // 177: bipush 0
      // 178: istore 5
      // 17a: aload 2
      // 17b: iload 1
      // 17c: ifne 18f
      // 17f: ifnull 18e
      // 182: goto 186
      // 185: athrow
      // 186: aload 2
      // 187: invokestatic org/lwjgl/system/MemoryUtil.memFree (Ljava/nio/ByteBuffer;)V
      // 18a: goto 18e
      // 18d: athrow
      // 18e: aload 3
      // 18f: iload 1
      // 190: ifne 19b
      // 193: ifnull 19e
      // 196: goto 19a
      // 199: athrow
      // 19a: aload 3
      // 19b: invokestatic org/lwjgl/system/MemoryUtil.memFree (Ljava/nio/ByteBuffer;)V
      // 19e: iload 5
      // 1a0: ireturn
      // 1a1: astore 10
      // 1a3: aload 2
      // 1a4: iload 1
      // 1a5: ifne 1b8
      // 1a8: ifnull 1b7
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: aload 2
      // 1b0: invokestatic org/lwjgl/system/MemoryUtil.memFree (Ljava/nio/ByteBuffer;)V
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: aload 3
      // 1b8: iload 1
      // 1b9: ifne 1c4
      // 1bc: ifnull 1c7
      // 1bf: goto 1c3
      // 1c2: athrow
      // 1c3: aload 3
      // 1c4: invokestatic org/lwjgl/system/MemoryUtil.memFree (Ljava/nio/ByteBuffer;)V
      // 1c7: aload 10
      // 1c9: athrow
   }

   public synchronized boolean z$2jzxy5gazhwu4() {
      return this.ǫ;
   }

   public synchronized boolean z$2sgpmnl4ey18i(byte[] param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 3
      // 04: aload 0
      // 05: getfield x/B.ǫ Z
      // 08: iload 3
      // 09: ifne 20
      // 0c: ifeq 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: ifnonnull 21
      // 17: goto 1b
      // 1a: athrow
      // 1b: bipush 0
      // 1c: goto 20
      // 1f: athrow
      // 20: ireturn
      // 21: invokestatic org/lwjgl/system/MemoryStack.stackPush ()Lorg/lwjgl/system/MemoryStack;
      // 24: astore 4
      // 26: aload 4
      // 28: aload 1
      // 29: arraylength
      // 2a: invokevirtual org/lwjgl/system/MemoryStack.malloc (I)Ljava/nio/ByteBuffer;
      // 2d: astore 5
      // 2f: aload 5
      // 31: aload 1
      // 32: invokevirtual java/nio/ByteBuffer.put ([B)Ljava/nio/ByteBuffer;
      // 35: invokevirtual java/nio/ByteBuffer.flip ()Ljava/nio/ByteBuffer;
      // 38: pop
      // 39: aload 5
      // 3b: invokestatic org/lwjgl/system/MemoryUtil.memAddress (Ljava/nio/ByteBuffer;)J
      // 3e: iload 2
      // 3f: aload 0
      // 40: getfield x/B.Ӫ J
      // 43: invokestatic org/lwjgl/system/JNI.invokePI (JIJ)I
      // 46: istore 6
      // 48: iload 6
      // 4a: iload 3
      // 4b: ifne 65
      // 4e: ifne 63
      // 51: goto 55
      // 54: athrow
      // 55: aload 0
      // 56: aload 0
      // 57: ldc "native notification enqueue failed"
      // 59: invokevirtual x/B.ұ (Ljava/lang/String;)Ljava/lang/String;
      // 5c: putfield x/B.ƺ Ljava/lang/String;
      // 5f: goto 63
      // 62: athrow
      // 63: iload 6
      // 65: iload 3
      // 66: ifne 71
      // 69: ifeq 74
      // 6c: goto 70
      // 6f: athrow
      // 70: bipush 1
      // 71: goto 75
      // 74: bipush 0
      // 75: istore 7
      // 77: aload 4
      // 79: iload 3
      // 7a: ifne 86
      // 7d: ifnull 89
      // 80: goto 84
      // 83: athrow
      // 84: aload 4
      // 86: invokevirtual org/lwjgl/system/MemoryStack.close ()V
      // 89: iload 7
      // 8b: ireturn
      // 8c: astore 5
      // 8e: iload 3
      // 8f: ifne a0
      // 92: aload 4
      // 94: ifnull ac
      // 97: goto 9b
      // 9a: athrow
      // 9b: aload 4
      // 9d: invokevirtual org/lwjgl/system/MemoryStack.close ()V
      // a0: goto ac
      // a3: astore 6
      // a5: aload 5
      // a7: aload 6
      // a9: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // ac: aload 5
      // ae: athrow
   }

   public synchronized boolean z$6gfv3m6wg2to(byte[] param1, byte[] param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 4
      // 05: aload 0
      // 06: getfield x/B.ǫ Z
      // 09: iload 4
      // 0b: ifne 2b
      // 0e: ifeq 2a
      // 11: goto 15
      // 14: athrow
      // 15: aload 1
      // 16: iload 4
      // 18: ifne 27
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifnull 2a
      // 22: goto 26
      // 25: athrow
      // 26: aload 2
      // 27: ifnonnull 2c
      // 2a: bipush 0
      // 2b: ireturn
      // 2c: invokestatic org/lwjgl/system/MemoryStack.stackPush ()Lorg/lwjgl/system/MemoryStack;
      // 2f: astore 5
      // 31: aload 5
      // 33: aload 1
      // 34: arraylength
      // 35: invokevirtual org/lwjgl/system/MemoryStack.malloc (I)Ljava/nio/ByteBuffer;
      // 38: astore 6
      // 3a: aload 6
      // 3c: aload 1
      // 3d: invokevirtual java/nio/ByteBuffer.put ([B)Ljava/nio/ByteBuffer;
      // 40: invokevirtual java/nio/ByteBuffer.flip ()Ljava/nio/ByteBuffer;
      // 43: pop
      // 44: aload 5
      // 46: aload 2
      // 47: arraylength
      // 48: invokevirtual org/lwjgl/system/MemoryStack.malloc (I)Ljava/nio/ByteBuffer;
      // 4b: astore 7
      // 4d: aload 7
      // 4f: aload 2
      // 50: invokevirtual java/nio/ByteBuffer.put ([B)Ljava/nio/ByteBuffer;
      // 53: invokevirtual java/nio/ByteBuffer.flip ()Ljava/nio/ByteBuffer;
      // 56: pop
      // 57: aload 6
      // 59: invokestatic org/lwjgl/system/MemoryUtil.memAddress (Ljava/nio/ByteBuffer;)J
      // 5c: aload 7
      // 5e: invokestatic org/lwjgl/system/MemoryUtil.memAddress (Ljava/nio/ByteBuffer;)J
      // 61: iload 3
      // 62: aload 0
      // 63: getfield x/B.ƈ J
      // 66: invokestatic org/lwjgl/system/JNI.invokePPI (JJIJ)I
      // 69: istore 8
      // 6b: iload 8
      // 6d: iload 4
      // 6f: ifne 89
      // 72: ifne 87
      // 75: goto 79
      // 78: athrow
      // 79: aload 0
      // 7a: aload 0
      // 7b: ldc "native notification enqueue failed"
      // 7d: invokevirtual x/B.ұ (Ljava/lang/String;)Ljava/lang/String;
      // 80: putfield x/B.ƺ Ljava/lang/String;
      // 83: goto 87
      // 86: athrow
      // 87: iload 8
      // 89: iload 4
      // 8b: ifne 96
      // 8e: ifeq 99
      // 91: goto 95
      // 94: athrow
      // 95: bipush 1
      // 96: goto 9a
      // 99: bipush 0
      // 9a: istore 9
      // 9c: aload 5
      // 9e: iload 4
      // a0: ifne ac
      // a3: ifnull af
      // a6: goto aa
      // a9: athrow
      // aa: aload 5
      // ac: invokevirtual org/lwjgl/system/MemoryStack.close ()V
      // af: iload 9
      // b1: ireturn
      // b2: astore 6
      // b4: iload 4
      // b6: ifne c7
      // b9: aload 5
      // bb: ifnull d3
      // be: goto c2
      // c1: athrow
      // c2: aload 5
      // c4: invokevirtual org/lwjgl/system/MemoryStack.close ()V
      // c7: goto d3
      // ca: astore 7
      // cc: aload 6
      // ce: aload 7
      // d0: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // d3: aload 6
      // d5: athrow
   }

   public synchronized void z$32z3elc3pru6f() {
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
      // 06: ifne 18
      // 09: getfield x/B.ǫ Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/B.Ѣ J
      // 1b: invokestatic org/lwjgl/system/JNI.invokeV (J)V
      // 1e: return
   }

   public synchronized boolean z$12vyxinw74gli(int param1, int param2, float param3, int param4, float param5, int param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc46245c2b20.ҥ I
      // 003: istore 7
      // 005: aload 0
      // 006: getfield x/B.ǫ Z
      // 009: iload 7
      // 00b: ifne 016
      // 00e: ifne 017
      // 011: goto 015
      // 014: athrow
      // 015: bipush 0
      // 016: ireturn
      // 017: invokestatic org/lwjgl/system/MemoryStack.stackPush ()Lorg/lwjgl/system/MemoryStack;
      // 01a: astore 8
      // 01c: aload 8
      // 01e: ldc 1989087498
      // 020: ldc 1989087506
      // 022: ixor
      // 023: invokevirtual org/lwjgl/system/MemoryStack.calloc (I)Ljava/nio/ByteBuffer;
      // 026: invokestatic java/nio/ByteOrder.nativeOrder ()Ljava/nio/ByteOrder;
      // 029: invokevirtual java/nio/ByteBuffer.order (Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
      // 02c: astore 9
      // 02e: aload 9
      // 030: bipush 0
      // 031: iload 1
      // 032: invokevirtual java/nio/ByteBuffer.putInt (II)Ljava/nio/ByteBuffer;
      // 035: pop
      // 036: aload 9
      // 038: ldc_w 1989087510
      // 03b: ldc 1989087506
      // 03d: ixor
      // 03e: iload 2
      // 03f: invokevirtual java/nio/ByteBuffer.putInt (II)Ljava/nio/ByteBuffer;
      // 042: pop
      // 043: aload 9
      // 045: ldc_w 1989087514
      // 048: ldc 1989087506
      // 04a: ixor
      // 04b: fload 3
      // 04c: invokestatic java/lang/Float.floatToRawIntBits (F)I
      // 04f: invokevirtual java/nio/ByteBuffer.putInt (II)Ljava/nio/ByteBuffer;
      // 052: pop
      // 053: aload 9
      // 055: ldc_w 1989087518
      // 058: ldc 1989087506
      // 05a: ixor
      // 05b: iload 4
      // 05d: ldc_w 1987112685
      // 060: ldc 1989087506
      // 062: ixor
      // 063: iand
      // 064: invokevirtual java/nio/ByteBuffer.putInt (II)Ljava/nio/ByteBuffer;
      // 067: pop
      // 068: aload 9
      // 06a: ldc_w 1989087490
      // 06d: ldc 1989087506
      // 06f: ixor
      // 070: fload 5
      // 072: invokestatic java/lang/Float.floatToRawIntBits (F)I
      // 075: invokevirtual java/nio/ByteBuffer.putInt (II)Ljava/nio/ByteBuffer;
      // 078: pop
      // 079: aload 9
      // 07b: ldc_w 1989087494
      // 07e: ldc 1989087506
      // 080: ixor
      // 081: iload 6
      // 083: invokevirtual java/nio/ByteBuffer.putInt (II)Ljava/nio/ByteBuffer;
      // 086: pop
      // 087: aload 9
      // 089: invokestatic org/lwjgl/system/MemoryUtil.memAddress (Ljava/nio/ByteBuffer;)J
      // 08c: aload 0
      // 08d: getfield x/B.փ J
      // 090: invokestatic org/lwjgl/system/JNI.invokePI (JJ)I
      // 093: istore 10
      // 095: iload 10
      // 097: iload 7
      // 099: ifne 0b4
      // 09c: ifne 0b2
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: aload 0
      // 0a4: aload 0
      // 0a5: ldc_w "native notification render failed"
      // 0a8: invokevirtual x/B.ұ (Ljava/lang/String;)Ljava/lang/String;
      // 0ab: putfield x/B.ƺ Ljava/lang/String;
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: iload 10
      // 0b4: iload 7
      // 0b6: ifne 0c1
      // 0b9: ifeq 0c4
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: bipush 1
      // 0c1: goto 0c5
      // 0c4: bipush 0
      // 0c5: istore 11
      // 0c7: aload 8
      // 0c9: iload 7
      // 0cb: ifne 0d7
      // 0ce: ifnull 0da
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 8
      // 0d7: invokevirtual org/lwjgl/system/MemoryStack.close ()V
      // 0da: iload 11
      // 0dc: ireturn
      // 0dd: astore 9
      // 0df: iload 7
      // 0e1: ifne 0f2
      // 0e4: aload 8
      // 0e6: ifnull 0fe
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: aload 8
      // 0ef: invokevirtual org/lwjgl/system/MemoryStack.close ()V
      // 0f2: goto 0fe
      // 0f5: astore 10
      // 0f7: aload 9
      // 0f9: aload 10
      // 0fb: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 0fe: aload 9
      // 100: athrow
   }

   public synchronized int z$9kdk14j2dxki() {
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
      // 06: ifne 18
      // 09: getfield x/B.ǫ Z
      // 0c: ifeq 21
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/B.Ӌ J
      // 1b: invokestatic org/lwjgl/system/JNI.invokeI (J)I
      // 1e: goto 22
      // 21: bipush 0
      // 22: ireturn
   }

   public synchronized String z$3kyzxig9p2tuo() {
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
      // 06: ifne 42
      // 09: getfield x/B.ǫ Z
      // 0c: ifeq 41
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 42
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/B.о J
      // 1f: lconst_0
      // 20: lcmp
      // 21: ifeq 41
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: iload 1
      // 2a: ifne 42
      // 2d: goto 31
      // 30: athrow
      // 31: ldc ""
      // 33: invokevirtual x/B.ұ (Ljava/lang/String;)Ljava/lang/String;
      // 36: astore 2
      // 37: aload 2
      // 38: invokevirtual java/lang/String.isEmpty ()Z
      // 3b: ifne 41
      // 3e: aload 2
      // 3f: areturn
      // 40: athrow
      // 41: aload 0
      // 42: getfield x/B.ƺ Ljava/lang/String;
      // 45: areturn
   }

   public synchronized void z$38t27rg719lzv() {
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
      // 06: ifne 39
      // 09: getfield x/B.ǫ Z
      // 0c: ifeq 33
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 39
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/B.ɰ J
      // 1f: lconst_0
      // 20: lcmp
      // 21: ifeq 33
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: getfield x/B.ɰ J
      // 2c: invokestatic org/lwjgl/system/JNI.invokeV (J)V
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: bipush 0
      // 35: putfield x/B.ǫ Z
      // 38: aload 0
      // 39: invokevirtual x/B.Ȝ ()V
      // 3c: goto 4b
      // 3f: astore 2
      // 40: aload 0
      // 41: bipush 0
      // 42: putfield x/B.ǫ Z
      // 45: aload 0
      // 46: invokevirtual x/B.Ȝ ()V
      // 49: aload 2
      // 4a: athrow
      // 4b: return
   }

   private long ʮ(String param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: aload 0
      // 04: getfield x/B.ɗ Lorg/lwjgl/system/SharedLibrary;
      // 07: aload 1
      // 08: invokeinterface org/lwjgl/system/SharedLibrary.getFunctionAddress (Ljava/lang/CharSequence;)J 2
      // 0d: lstore 3
      // 0e: istore 2
      // 0f: lload 3
      // 10: iload 2
      // 11: ifne 31
      // 14: lconst_0
      // 15: lcmp
      // 16: ifne 30
      // 19: goto 1d
      // 1c: athrow
      // 1d: new java/io/IOException
      // 20: dup
      // 21: aload 1
      // 22: ldc_w "Bundled notification native is missing export "
      // 25: swap
      // 26: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 2b: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 2e: athrow
      // 2f: athrow
      // 30: lload 3
      // 31: lreturn
   }

   private String ұ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 19
      // 09: getfield x/B.о J
      // 0c: lconst_0
      // 0d: lcmp
      // 0e: ifne 18
      // 11: goto 15
      // 14: athrow
      // 15: aload 1
      // 16: areturn
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/B.о J
      // 1c: invokestatic org/lwjgl/system/JNI.invokeP (J)J
      // 1f: lstore 3
      // 20: lload 3
      // 21: iload 2
      // 22: ifne 32
      // 25: lconst_0
      // 26: lcmp
      // 27: ifne 31
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 1
      // 2f: areturn
      // 30: athrow
      // 31: lload 3
      // 32: invokestatic org/lwjgl/system/MemoryUtil.memUTF8 (J)Ljava/lang/String;
      // 35: astore 5
      // 37: aload 5
      // 39: iload 2
      // 3a: ifne 5d
      // 3d: ifnull 58
      // 40: goto 44
      // 43: athrow
      // 44: aload 5
      // 46: iload 2
      // 47: ifne 5d
      // 4a: goto 4e
      // 4d: athrow
      // 4e: invokevirtual java/lang/String.isEmpty ()Z
      // 51: ifeq 60
      // 54: goto 58
      // 57: athrow
      // 58: aload 1
      // 59: goto 5d
      // 5c: athrow
      // 5d: goto 62
      // 60: aload 5
      // 62: areturn
   }

   private void Ȝ() {
      int var1 = oc46245c2b20.ҥ;

      B var10000;
      label25: {
         label24: {
            try {
               var10000 = this;
               if (var1 != 0) {
                  break label25;
               }

               if (this.ɗ == null) {
                  break label24;
               }
            } catch (Throwable var4) {
               throw var4;
            }

            try {
               this.ɗ.free();
            } catch (Throwable var3) {
            }
         }

         this.ɗ = null;
         this.Ć = 0L;
         this.Ӫ = 0L;
         this.ƈ = 0L;
         this.Ѣ = 0L;
         this.փ = 0L;
         this.ɰ = 0L;
         this.Ӌ = 0L;
         var10000 = this;
      }

      var10000.о = 0L;
   }

   private static byte[] ì(String var0, String var1) throws IOException {
      byte[] var2 = ɲ(var0);
      String var3 = HexFormat.of().formatHex(Ż(var2));

      try {
         if (!var1.equals(var3)) {
            throw new IOException("Bundled font checksum mismatch for " + var0);
         } else {
            return var2;
         }
      } catch (IOException var4) {
         throw var4;
      }
   }

   private static Path Ε(oc9e7110bab2 param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc46245c2b20.ҥ I
      // 003: aload 0
      // 004: getfield x/oc9e7110bab2.Ǒ Ljava/lang/String;
      // 007: invokestatic x/B.ɲ (Ljava/lang/String;)[B
      // 00a: astore 2
      // 00b: istore 1
      // 00c: aload 2
      // 00d: iload 1
      // 00e: ifne 03a
      // 011: arraylength
      // 012: ldc_w 1814480773
      // 015: ldc_w 1814484869
      // 018: ixor
      // 019: if_icmpge 036
      // 01c: goto 020
      // 01f: athrow
      // 020: new java/io/IOException
      // 023: dup
      // 024: aload 0
      // 025: getfield x/oc9e7110bab2.Ǒ Ljava/lang/String;
      // 028: ldc_w "Bundled notification native is unexpectedly small: "
      // 02b: swap
      // 02c: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 031: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 034: athrow
      // 035: athrow
      // 036: aload 2
      // 037: invokestatic x/B.Ż ([B)[B
      // 03a: astore 3
      // 03b: invokestatic java/util/HexFormat.of ()Ljava/util/HexFormat;
      // 03e: aload 3
      // 03f: invokevirtual java/util/HexFormat.formatHex ([B)Ljava/lang/String;
      // 042: astore 4
      // 044: invokestatic x/B.ƥ ()Ljava/nio/file/Path;
      // 047: invokeinterface java/nio/file/Path.toAbsolutePath ()Ljava/nio/file/Path; 1
      // 04c: invokeinterface java/nio/file/Path.normalize ()Ljava/nio/file/Path; 1
      // 051: astore 5
      // 053: aload 5
      // 055: aload 0
      // 056: getfield x/oc9e7110bab2.Ğ Ljava/lang/String;
      // 059: aload 4
      // 05b: ldc_w "mimeow-notifications-"
      // 05e: dup_x2
      // 05f: pop
      // 060: ldc_w "-"
      // 063: swap
      // 064: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 069: invokeinterface java/nio/file/Path.resolve (Ljava/lang/String;)Ljava/nio/file/Path; 2
      // 06e: astore 6
      // 070: aload 6
      // 072: bipush 0
      // 073: anewarray 379
      // 076: invokestatic java/nio/file/Files.createDirectories (Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;
      // 079: pop
      // 07a: aload 6
      // 07c: ldc_w "notification native cache directory"
      // 07f: invokestatic x/B.į (Ljava/nio/file/Path;Ljava/lang/String;)V
      // 082: aload 6
      // 084: aload 0
      // 085: getfield x/oc9e7110bab2.Ӎ Ljava/lang/String;
      // 088: invokeinterface java/nio/file/Path.resolve (Ljava/lang/String;)Ljava/nio/file/Path; 2
      // 08d: invokeinterface java/nio/file/Path.normalize ()Ljava/nio/file/Path; 1
      // 092: astore 7
      // 094: aload 6
      // 096: iload 1
      // 097: ifne 0c6
      // 09a: aload 7
      // 09c: invokeinterface java/nio/file/Path.getParent ()Ljava/nio/file/Path; 1
      // 0a1: invokeinterface java/nio/file/Path.equals (Ljava/lang/Object;)Z 2
      // 0a6: ifne 0c4
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: new java/io/IOException
      // 0b0: dup
      // 0b1: aload 7
      // 0b3: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0b6: ldc_w "Invalid notification native output path: "
      // 0b9: swap
      // 0ba: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0bf: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 0c2: athrow
      // 0c3: athrow
      // 0c4: aload 7
      // 0c6: iload 1
      // 0c7: ifne 150
      // 0ca: bipush 1
      // 0cb: anewarray 406
      // 0ce: dup
      // 0cf: bipush 0
      // 0d0: getstatic java/nio/file/LinkOption.NOFOLLOW_LINKS Ljava/nio/file/LinkOption;
      // 0d3: aastore
      // 0d4: invokestatic java/nio/file/Files.exists (Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z
      // 0d7: ifeq 13b
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: aload 7
      // 0e0: ldc_w "notification native library"
      // 0e3: iload 1
      // 0e4: ifne 146
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: invokestatic x/B.į (Ljava/nio/file/Path;Ljava/lang/String;)V
      // 0ee: aload 7
      // 0f0: bipush 1
      // 0f1: anewarray 406
      // 0f4: dup
      // 0f5: bipush 0
      // 0f6: getstatic java/nio/file/LinkOption.NOFOLLOW_LINKS Ljava/nio/file/LinkOption;
      // 0f9: aastore
      // 0fa: invokestatic java/nio/file/Files.isRegularFile (Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z
      // 0fd: ifeq 13b
      // 100: goto 104
      // 103: athrow
      // 104: aload 7
      // 106: iload 1
      // 107: ifne 150
      // 10a: goto 10e
      // 10d: athrow
      // 10e: invokestatic java/nio/file/Files.size (Ljava/nio/file/Path;)J
      // 111: aload 2
      // 112: arraylength
      // 113: i2l
      // 114: lcmp
      // 115: ifne 13b
      // 118: goto 11c
      // 11b: athrow
      // 11c: aload 7
      // 11e: iload 1
      // 11f: ifne 150
      // 122: goto 126
      // 125: athrow
      // 126: invokestatic java/nio/file/Files.readAllBytes (Ljava/nio/file/Path;)[B
      // 129: invokestatic x/B.Ż ([B)[B
      // 12c: aload 3
      // 12d: invokestatic java/security/MessageDigest.isEqual ([B[B)Z
      // 130: ifeq 13b
      // 133: goto 137
      // 136: athrow
      // 137: aload 7
      // 139: areturn
      // 13a: athrow
      // 13b: aload 6
      // 13d: aload 0
      // 13e: getfield x/oc9e7110bab2.Ӎ Ljava/lang/String;
      // 141: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001." ]
      // 146: ldc_w ".tmp"
      // 149: bipush 0
      // 14a: anewarray 379
      // 14d: invokestatic java/nio/file/Files.createTempFile (Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;
      // 150: astore 8
      // 152: aload 8
      // 154: aload 2
      // 155: bipush 0
      // 156: anewarray 445
      // 159: invokestatic java/nio/file/Files.write (Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;
      // 15c: pop
      // 15d: aload 8
      // 15f: aload 0
      // 160: getstatic x/oc9e7110bab2.ƴ Lx/oc9e7110bab2;
      // 163: if_acmpne 16b
      // 166: bipush 1
      // 167: goto 16c
      // 16a: athrow
      // 16b: bipush 0
      // 16c: invokestatic x/B.ԅ (Ljava/nio/file/Path;Z)V
      // 16f: iload 1
      // 170: ifne 1b0
      // 173: aload 8
      // 175: invokestatic java/nio/file/Files.readAllBytes (Ljava/nio/file/Path;)[B
      // 178: invokestatic x/B.Ż ([B)[B
      // 17b: aload 3
      // 17c: invokestatic java/security/MessageDigest.isEqual ([B[B)Z
      // 17f: ifne 192
      // 182: goto 186
      // 185: athrow
      // 186: new java/io/IOException
      // 189: dup
      // 18a: ldc_w "Notification native extraction checksum mismatch"
      // 18d: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 190: athrow
      // 191: athrow
      // 192: aload 8
      // 194: aload 7
      // 196: ldc_w 1814484871
      // 199: ldc_w 1814484869
      // 19c: ixor
      // 19d: anewarray 462
      // 1a0: dup
      // 1a1: bipush 0
      // 1a2: getstatic java/nio/file/StandardCopyOption.ATOMIC_MOVE Ljava/nio/file/StandardCopyOption;
      // 1a5: aastore
      // 1a6: dup
      // 1a7: bipush 1
      // 1a8: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 1ab: aastore
      // 1ac: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 1af: pop
      // 1b0: goto 1c7
      // 1b3: astore 9
      // 1b5: aload 8
      // 1b7: aload 7
      // 1b9: bipush 1
      // 1ba: anewarray 462
      // 1bd: dup
      // 1be: bipush 0
      // 1bf: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 1c2: aastore
      // 1c3: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 1c6: pop
      // 1c7: aload 7
      // 1c9: aload 0
      // 1ca: getstatic x/oc9e7110bab2.ƴ Lx/oc9e7110bab2;
      // 1cd: if_acmpne 1d5
      // 1d0: bipush 1
      // 1d1: goto 1d6
      // 1d4: athrow
      // 1d5: bipush 0
      // 1d6: invokestatic x/B.ԅ (Ljava/nio/file/Path;Z)V
      // 1d9: aload 7
      // 1db: astore 9
      // 1dd: aload 8
      // 1df: invokestatic java/nio/file/Files.deleteIfExists (Ljava/nio/file/Path;)Z
      // 1e2: pop
      // 1e3: aload 9
      // 1e5: areturn
      // 1e6: astore 10
      // 1e8: aload 8
      // 1ea: invokestatic java/nio/file/Files.deleteIfExists (Ljava/nio/file/Path;)Z
      // 1ed: pop
      // 1ee: aload 10
      // 1f0: athrow
   }

   private static byte[] ɲ(String param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc x/B
      // 002: invokevirtual java/lang/Class.getClassLoader ()Ljava/lang/ClassLoader;
      // 005: astore 2
      // 006: getstatic x/oc46245c2b20.ҥ I
      // 009: aload 2
      // 00a: aload 0
      // 00b: invokevirtual java/lang/ClassLoader.getResourceAsStream (Ljava/lang/String;)Ljava/io/InputStream;
      // 00e: astore 3
      // 00f: istore 1
      // 010: aload 3
      // 011: iload 1
      // 012: ifne 036
      // 015: ifnull 035
      // 018: goto 01c
      // 01b: athrow
      // 01c: aload 3
      // 01d: invokevirtual java/io/InputStream.readAllBytes ()[B
      // 020: astore 4
      // 022: aload 3
      // 023: iload 1
      // 024: ifne 02f
      // 027: ifnull 032
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 3
      // 02f: invokevirtual java/io/InputStream.close ()V
      // 032: aload 4
      // 034: areturn
      // 035: aload 3
      // 036: iload 1
      // 037: ifne 042
      // 03a: ifnull 069
      // 03d: goto 041
      // 040: athrow
      // 041: aload 3
      // 042: invokevirtual java/io/InputStream.close ()V
      // 045: goto 069
      // 048: astore 4
      // 04a: iload 1
      // 04b: ifne 05a
      // 04e: aload 3
      // 04f: ifnull 066
      // 052: goto 056
      // 055: athrow
      // 056: aload 3
      // 057: invokevirtual java/io/InputStream.close ()V
      // 05a: goto 066
      // 05d: astore 5
      // 05f: aload 4
      // 061: aload 5
      // 063: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 066: aload 4
      // 068: athrow
      // 069: ldc_w "user.dir"
      // 06c: ldc_w "."
      // 06f: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 072: bipush 0
      // 073: anewarray 288
      // 076: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 079: invokeinterface java/nio/file/Path.toAbsolutePath ()Ljava/nio/file/Path; 1
      // 07e: invokeinterface java/nio/file/Path.normalize ()Ljava/nio/file/Path; 1
      // 083: astore 3
      // 084: ldc_w -1354157589
      // 087: ldc_w -1354157586
      // 08a: ixor
      // 08b: anewarray 92
      // 08e: dup
      // 08f: bipush 0
      // 090: aload 3
      // 091: ldc_w "build"
      // 094: ldc_w -1354157587
      // 097: ldc_w -1354157586
      // 09a: ixor
      // 09b: anewarray 288
      // 09e: dup
      // 09f: bipush 0
      // 0a0: ldc_w "resources"
      // 0a3: aastore
      // 0a4: dup
      // 0a5: bipush 1
      // 0a6: ldc_w "main"
      // 0a9: aastore
      // 0aa: dup
      // 0ab: ldc_w -1354157588
      // 0ae: ldc_w -1354157586
      // 0b1: ixor
      // 0b2: aload 0
      // 0b3: aastore
      // 0b4: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 0b7: invokeinterface java/nio/file/Path.resolve (Ljava/nio/file/Path;)Ljava/nio/file/Path; 2
      // 0bc: aastore
      // 0bd: dup
      // 0be: bipush 1
      // 0bf: aload 3
      // 0c0: ldc_w "build"
      // 0c3: ldc_w -1354157590
      // 0c6: ldc_w -1354157586
      // 0c9: ixor
      // 0ca: anewarray 288
      // 0cd: dup
      // 0ce: bipush 0
      // 0cf: ldc_w "generated"
      // 0d2: aastore
      // 0d3: dup
      // 0d4: bipush 1
      // 0d5: ldc_w "notification-resources"
      // 0d8: aastore
      // 0d9: dup
      // 0da: ldc_w -1354157588
      // 0dd: ldc_w -1354157586
      // 0e0: ixor
      // 0e1: ldc_w "windows"
      // 0e4: aastore
      // 0e5: dup
      // 0e6: ldc_w -1354157587
      // 0e9: ldc_w -1354157586
      // 0ec: ixor
      // 0ed: aload 0
      // 0ee: aastore
      // 0ef: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 0f2: invokeinterface java/nio/file/Path.resolve (Ljava/nio/file/Path;)Ljava/nio/file/Path; 2
      // 0f7: aastore
      // 0f8: dup
      // 0f9: ldc_w -1354157588
      // 0fc: ldc_w -1354157586
      // 0ff: ixor
      // 100: aload 3
      // 101: ldc_w "build"
      // 104: ldc_w -1354157590
      // 107: ldc_w -1354157586
      // 10a: ixor
      // 10b: anewarray 288
      // 10e: dup
      // 10f: bipush 0
      // 110: ldc_w "generated"
      // 113: aastore
      // 114: dup
      // 115: bipush 1
      // 116: ldc_w "notification-resources"
      // 119: aastore
      // 11a: dup
      // 11b: ldc_w -1354157588
      // 11e: ldc_w -1354157586
      // 121: ixor
      // 122: ldc_w "linux"
      // 125: aastore
      // 126: dup
      // 127: ldc_w -1354157587
      // 12a: ldc_w -1354157586
      // 12d: ixor
      // 12e: aload 0
      // 12f: aastore
      // 130: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 133: invokeinterface java/nio/file/Path.resolve (Ljava/nio/file/Path;)Ljava/nio/file/Path; 2
      // 138: aastore
      // 139: dup
      // 13a: ldc_w -1354157587
      // 13d: ldc_w -1354157586
      // 140: ixor
      // 141: aload 3
      // 142: ldc_w "src"
      // 145: ldc_w -1354157587
      // 148: ldc_w -1354157586
      // 14b: ixor
      // 14c: anewarray 288
      // 14f: dup
      // 150: bipush 0
      // 151: ldc_w "main"
      // 154: aastore
      // 155: dup
      // 156: bipush 1
      // 157: ldc_w "resources"
      // 15a: aastore
      // 15b: dup
      // 15c: ldc_w -1354157588
      // 15f: ldc_w -1354157586
      // 162: ixor
      // 163: aload 0
      // 164: aastore
      // 165: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 168: invokeinterface java/nio/file/Path.resolve (Ljava/nio/file/Path;)Ljava/nio/file/Path; 2
      // 16d: aastore
      // 16e: dup
      // 16f: ldc_w -1354157590
      // 172: ldc_w -1354157586
      // 175: ixor
      // 176: aload 3
      // 177: aload 0
      // 178: invokeinterface java/nio/file/Path.resolve (Ljava/lang/String;)Ljava/nio/file/Path; 2
      // 17d: aastore
      // 17e: astore 4
      // 180: aload 4
      // 182: astore 5
      // 184: aload 5
      // 186: arraylength
      // 187: istore 6
      // 189: bipush 0
      // 18a: istore 7
      // 18c: iload 7
      // 18e: iload 6
      // 190: if_icmpge 1bc
      // 193: aload 5
      // 195: iload 7
      // 197: aaload
      // 198: astore 8
      // 19a: iload 1
      // 19b: ifne 1b8
      // 19e: aload 8
      // 1a0: bipush 0
      // 1a1: anewarray 406
      // 1a4: invokestatic java/nio/file/Files.isRegularFile (Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z
      // 1a7: ifeq 1b5
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: aload 8
      // 1b0: invokestatic java/nio/file/Files.readAllBytes (Ljava/nio/file/Path;)[B
      // 1b3: areturn
      // 1b4: athrow
      // 1b5: iinc 7 1
      // 1b8: iload 1
      // 1b9: ifeq 18c
      // 1bc: new java/io/IOException
      // 1bf: dup
      // 1c0: aload 0
      // 1c1: ldc_w "Bundled notification resource is missing: "
      // 1c4: swap
      // 1c5: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1ca: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 1cd: athrow
   }

   private static Path ƥ() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc46245c2b20.ҥ I
      // 03: ldc_w "miau.notificationNativeCacheDir"
      // 06: ldc ""
      // 08: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0b: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0e: astore 1
      // 0f: istore 0
      // 10: aload 1
      // 11: iload 0
      // 12: ifne 34
      // 15: invokevirtual java/lang/String.isEmpty ()Z
      // 18: ifne 29
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 1
      // 20: bipush 0
      // 21: anewarray 288
      // 24: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 27: areturn
      // 28: athrow
      // 29: ldc_w "user.home"
      // 2c: ldc ""
      // 2e: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 31: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 34: astore 2
      // 35: aload 2
      // 36: iload 0
      // 37: ifne 51
      // 3a: invokevirtual java/lang/String.isEmpty ()Z
      // 3d: ifeq 50
      // 40: goto 44
      // 43: athrow
      // 44: new java/io/IOException
      // 47: dup
      // 48: ldc_w "user.home is unavailable"
      // 4b: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 4e: athrow
      // 4f: athrow
      // 50: aload 2
      // 51: ldc_w -1011098577
      // 54: ldc_w -1011098580
      // 57: ixor
      // 58: anewarray 288
      // 5b: dup
      // 5c: bipush 0
      // 5d: ldc_w ".miau-launcher"
      // 60: aastore
      // 61: dup
      // 62: bipush 1
      // 63: ldc_w "runtime"
      // 66: aastore
      // 67: dup
      // 68: ldc_w -1011098578
      // 6b: ldc_w -1011098580
      // 6e: ixor
      // 6f: ldc_w "natives"
      // 72: aastore
      // 73: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 76: areturn
   }

   private static void į(Path var0, String var1) throws IOException {
      try {
         if (Files.isSymbolicLink(var0)) {
            throw new IOException("Refusing symbolic-link " + var1 + ": " + var0);
         }
      } catch (IOException var2) {
         throw var2;
      }
   }

   private static void ԅ(Path var0, boolean var1) throws IOException {
      try {
         Set var10000;
         label20: {
            try {
               if (var1) {
                  var10000 = Set.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE);
                  break label20;
               }
            } catch (UnsupportedOperationException var3) {
               throw var3;
            }

            var10000 = Set.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE);
         }

         Set var2 = var10000;
         Files.setPosixFilePermissions(var0, var2);
      } catch (UnsupportedOperationException var4) {
      }
   }

   private static byte[] Ż(byte[] var0) throws IOException {
      try {
         return MessageDigest.getInstance("SHA-256").digest(var0);
      } catch (NoSuchAlgorithmException var2) {
         throw new IOException("SHA-256 is unavailable", var2);
      }
   }

   private static String Ҝ(Throwable param0) {
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
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 36
      // 0e: ifnull 2b
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: iload 1
      // 17: ifne 36
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 21: invokevirtual java/lang/String.isEmpty ()Z
      // 24: ifeq 39
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 2f: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 32: goto 36
      // 35: athrow
      // 36: goto 3a
      // 39: aload 2
      // 3a: areturn
   }
}
