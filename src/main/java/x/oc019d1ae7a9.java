package x;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class oc019d1ae7a9 {
   private static final String ƫ = "3.3.6";
   private static final String ģ = "org.lwjgl.librarypath";
   private static final String Ȏ = "miau.nativeCacheDir";
   public static boolean Ԟ;

   private oc019d1ae7a9() {
   }

   public static void ɧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc019d1ae7a9.Ԟ Z
      // 03: ldc "os.name"
      // 05: ldc ""
      // 07: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0a: ldc "os.arch"
      // 0c: ldc ""
      // 0e: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 11: invokestatic x/oce3c2bef62b.Φ (Ljava/lang/String;Ljava/lang/String;)Lx/oce3c2bef62b;
      // 14: astore 1
      // 15: istore 0
      // 16: aload 1
      // 17: ifnonnull 1c
      // 1a: return
      // 1b: athrow
      // 1c: invokestatic x/oc019d1ae7a9.Ͻ ()Ljava/nio/file/Path;
      // 1f: astore 2
      // 20: aload 1
      // 21: aload 2
      // 22: ldc x/oc019d1ae7a9
      // 24: invokevirtual java/lang/Class.getClassLoader ()Ljava/lang/ClassLoader;
      // 27: invokestatic x/oc019d1ae7a9.ɫ (Lx/oce3c2bef62b;Ljava/nio/file/Path;Ljava/lang/ClassLoader;)Ljava/nio/file/Path;
      // 2a: pop
      // 2b: goto 44
      // 2e: astore 3
      // 2f: new java/lang/IllegalStateException
      // 32: dup
      // 33: aload 1
      // 34: getfield x/oce3c2bef62b.Ę Ljava/lang/String;
      // 37: ldc "Could not prepare bundled LWJGL 3.3.6 natives for "
      // 39: swap
      // 3a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 3f: aload 3
      // 40: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 43: athrow
      // 44: bipush 0
      // 45: ifeq 59
      // 48: iload 0
      // 49: ifeq 55
      // 4c: goto 50
      // 4f: athrow
      // 50: bipush 0
      // 51: goto 56
      // 54: athrow
      // 55: bipush 1
      // 56: putstatic x/oc019d1ae7a9.Ԟ Z
      // 59: return
   }

   static Path ƿ(String param0, String param1, Path param2, ClassLoader param3) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc019d1ae7a9.Ԟ Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokestatic x/oce3c2bef62b.Φ (Ljava/lang/String;Ljava/lang/String;)Lx/oce3c2bef62b;
      // 08: astore 5
      // 0a: istore 4
      // 0c: aload 5
      // 0e: iload 4
      // 10: ifne 33
      // 13: ifnonnull 31
      // 16: goto 1a
      // 19: athrow
      // 1a: new java/io/IOException
      // 1d: dup
      // 1e: aload 0
      // 1f: aload 1
      // 20: ldc "Bundled LWJGL natives do not support "
      // 22: dup_x2
      // 23: pop
      // 24: ldc " / "
      // 26: swap
      // 27: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 2c: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 2f: athrow
      // 30: athrow
      // 31: aload 5
      // 33: aload 2
      // 34: aload 3
      // 35: invokestatic x/oc019d1ae7a9.ɫ (Lx/oce3c2bef62b;Ljava/nio/file/Path;Ljava/lang/ClassLoader;)Ljava/nio/file/Path;
      // 38: areturn
   }

   private static Path ɫ(oce3c2bef62b var0, Path var1, ClassLoader var2) throws IOException {
      boolean var3 = Ԟ;

      try {
         if (var1 == null) {
            throw new IOException("Native cache root is unavailable");
         }
      } catch (IOException var11) {
         throw var11;
      }

      try {
         if (var2 == null) {
            throw new IOException("Client class loader is not available");
         }
      } catch (IOException var13) {
         throw var13;
      }

      List var4 = ҩ(var0, var2);
      MessageDigest var5 = ԏ();

      for (oc2e4efea860 var7 : var4) {
         var5.update(var7.պ.getBytes(StandardCharsets.UTF_8));
         var5.update((byte)0);
         var5.update(var7.ͳ);
         if (var3) {
            break;
         }
      }

      String var14 = HexFormat.of().formatHex(var5.digest(), 0, -1228971475 ^ -1228971483);
      Path var15 = var1.toAbsolutePath().normalize();
      Path var8 = var15.resolve("lwjgl-3.3.6-" + var0.Ę + "-" + var14);
      Files.createDirectories(var8);
      ϐ(var8, "native cache directory");
      Iterator var9 = var4.iterator();

      while (true) {
         if (var9.hasNext()) {
            oc2e4efea860 var10 = (oc2e4efea860)var9.next();

            try {
               if (var3) {
                  break;
               }

               Ĳ(var8, var10);
               if (!var3) {
                  continue;
               }
            } catch (IOException var12) {
               throw var12;
            }
         }

         System.setProperty("org.lwjgl.librarypath", var8.toString());
         break;
      }

      return var8;
   }

   private static List<oc2e4efea860> ҩ(oce3c2bef62b param0, ClassLoader param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new java/util/ArrayList
      // 03: dup
      // 04: aload 0
      // 05: getfield x/oce3c2bef62b.Ҏ Ljava/util/List;
      // 08: invokeinterface java/util/List.size ()I 1
      // 0d: invokespecial java/util/ArrayList.<init> (I)V
      // 10: astore 3
      // 11: getstatic x/oc019d1ae7a9.Ԟ Z
      // 14: aload 0
      // 15: getfield x/oce3c2bef62b.Ҏ Ljava/util/List;
      // 18: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1d: astore 4
      // 1f: istore 2
      // 20: aload 4
      // 22: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 27: ifeq f4
      // 2a: aload 4
      // 2c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 31: checkcast x/ocf7a7942e84
      // 34: astore 5
      // 36: aload 0
      // 37: getfield x/oce3c2bef62b.İ Ljava/lang/String;
      // 3a: aload 5
      // 3c: getfield x/ocf7a7942e84.ϥ Ljava/lang/String;
      // 3f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 44: astore 6
      // 46: aload 1
      // 47: aload 6
      // 49: invokevirtual java/lang/ClassLoader.getResourceAsStream (Ljava/lang/String;)Ljava/io/InputStream;
      // 4c: astore 8
      // 4e: aload 8
      // 50: iload 2
      // 51: ifne 70
      // 54: ifnonnull 6e
      // 57: goto 5b
      // 5a: athrow
      // 5b: new java/io/IOException
      // 5e: dup
      // 5f: aload 6
      // 61: ldc "Bundled native resource is missing: "
      // 63: swap
      // 64: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 69: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 6c: athrow
      // 6d: athrow
      // 6e: aload 8
      // 70: invokevirtual java/io/InputStream.readAllBytes ()[B
      // 73: astore 7
      // 75: iload 2
      // 76: ifne 87
      // 79: aload 8
      // 7b: ifnull ad
      // 7e: aload 8
      // 80: invokevirtual java/io/InputStream.close ()V
      // 83: goto 87
      // 86: athrow
      // 87: goto ad
      // 8a: astore 9
      // 8c: iload 2
      // 8d: ifne 9e
      // 90: aload 8
      // 92: ifnull aa
      // 95: goto 99
      // 98: athrow
      // 99: aload 8
      // 9b: invokevirtual java/io/InputStream.close ()V
      // 9e: goto aa
      // a1: astore 10
      // a3: aload 9
      // a5: aload 10
      // a7: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // aa: aload 9
      // ac: athrow
      // ad: aload 7
      // af: arraylength
      // b0: iload 2
      // b1: ifne ef
      // b4: ldc -1833863509
      // b6: ldc -1833867605
      // b8: ixor
      // b9: if_icmpge d4
      // bc: goto c0
      // bf: athrow
      // c0: new java/io/IOException
      // c3: dup
      // c4: aload 6
      // c6: ldc_w "Bundled native resource is unexpectedly small: "
      // c9: swap
      // ca: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // cf: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // d2: athrow
      // d3: athrow
      // d4: aload 3
      // d5: new x/oc2e4efea860
      // d8: dup
      // d9: aload 6
      // db: aload 5
      // dd: getfield x/ocf7a7942e84.ǔ Ljava/lang/String;
      // e0: aload 7
      // e2: aload 7
      // e4: invokestatic x/oc019d1ae7a9.ο ([B)[B
      // e7: invokespecial x/oc2e4efea860.<init> (Ljava/lang/String;Ljava/lang/String;[B[B)V
      // ea: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // ef: pop
      // f0: iload 2
      // f1: ifeq 20
      // f4: aload 3
      // f5: areturn
   }

   private static void Ĳ(Path param0, oc2e4efea860 param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc019d1ae7a9.Ԟ Z
      // 003: aload 0
      // 004: aload 1
      // 005: getfield x/oc2e4efea860.ӷ Ljava/lang/String;
      // 008: invokeinterface java/nio/file/Path.resolve (Ljava/lang/String;)Ljava/nio/file/Path; 2
      // 00d: invokeinterface java/nio/file/Path.normalize ()Ljava/nio/file/Path; 1
      // 012: astore 3
      // 013: istore 2
      // 014: aload 3
      // 015: invokeinterface java/nio/file/Path.getParent ()Ljava/nio/file/Path; 1
      // 01a: iload 2
      // 01b: ifne 042
      // 01e: aload 0
      // 01f: invokeinterface java/nio/file/Path.equals (Ljava/lang/Object;)Z 2
      // 024: ifne 041
      // 027: goto 02b
      // 02a: athrow
      // 02b: new java/io/IOException
      // 02e: dup
      // 02f: aload 3
      // 030: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 033: ldc_w "Invalid native output path: "
      // 036: swap
      // 037: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 03c: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 03f: athrow
      // 040: athrow
      // 041: aload 3
      // 042: iload 2
      // 043: ifne 0cb
      // 046: bipush 1
      // 047: anewarray 290
      // 04a: dup
      // 04b: bipush 0
      // 04c: getstatic java/nio/file/LinkOption.NOFOLLOW_LINKS Ljava/nio/file/LinkOption;
      // 04f: aastore
      // 050: invokestatic java/nio/file/Files.exists (Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z
      // 053: ifeq 0b7
      // 056: goto 05a
      // 059: athrow
      // 05a: aload 3
      // 05b: iload 2
      // 05c: ifne 0cb
      // 05f: goto 063
      // 062: athrow
      // 063: ldc_w "native library"
      // 066: invokestatic x/oc019d1ae7a9.ϐ (Ljava/nio/file/Path;Ljava/lang/String;)V
      // 069: aload 3
      // 06a: bipush 1
      // 06b: anewarray 290
      // 06e: dup
      // 06f: bipush 0
      // 070: getstatic java/nio/file/LinkOption.NOFOLLOW_LINKS Ljava/nio/file/LinkOption;
      // 073: aastore
      // 074: invokestatic java/nio/file/Files.isRegularFile (Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z
      // 077: ifeq 0b7
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 3
      // 07f: iload 2
      // 080: ifne 0cb
      // 083: goto 087
      // 086: athrow
      // 087: invokestatic java/nio/file/Files.size (Ljava/nio/file/Path;)J
      // 08a: aload 1
      // 08b: getfield x/oc2e4efea860.ͳ [B
      // 08e: arraylength
      // 08f: i2l
      // 090: lcmp
      // 091: ifne 0b7
      // 094: goto 098
      // 097: athrow
      // 098: aload 3
      // 099: iload 2
      // 09a: ifne 0cb
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: invokestatic java/nio/file/Files.readAllBytes (Ljava/nio/file/Path;)[B
      // 0a4: invokestatic x/oc019d1ae7a9.ο ([B)[B
      // 0a7: aload 1
      // 0a8: getfield x/oc2e4efea860.ϸ [B
      // 0ab: invokestatic java/security/MessageDigest.isEqual ([B[B)Z
      // 0ae: ifeq 0b7
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: return
      // 0b6: athrow
      // 0b7: aload 0
      // 0b8: aload 1
      // 0b9: getfield x/oc2e4efea860.ӷ Ljava/lang/String;
      // 0bc: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001." ]
      // 0c1: ldc_w ".tmp"
      // 0c4: bipush 0
      // 0c5: anewarray 187
      // 0c8: invokestatic java/nio/file/Files.createTempFile (Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;
      // 0cb: astore 4
      // 0cd: aload 4
      // 0cf: aload 1
      // 0d0: getfield x/oc2e4efea860.ͳ [B
      // 0d3: bipush 0
      // 0d4: anewarray 329
      // 0d7: invokestatic java/nio/file/Files.write (Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;
      // 0da: pop
      // 0db: iload 2
      // 0dc: aload 4
      // 0de: invokestatic x/oc019d1ae7a9.ƞ (Ljava/nio/file/Path;)V
      // 0e1: ifne 12d
      // 0e4: aload 4
      // 0e6: invokestatic java/nio/file/Files.readAllBytes (Ljava/nio/file/Path;)[B
      // 0e9: invokestatic x/oc019d1ae7a9.ο ([B)[B
      // 0ec: aload 1
      // 0ed: getfield x/oc2e4efea860.ϸ [B
      // 0f0: invokestatic java/security/MessageDigest.isEqual ([B[B)Z
      // 0f3: ifne 110
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: new java/io/IOException
      // 0fd: dup
      // 0fe: aload 1
      // 0ff: getfield x/oc2e4efea860.պ Ljava/lang/String;
      // 102: ldc_w "Native extraction checksum mismatch: "
      // 105: swap
      // 106: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 10b: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 10e: athrow
      // 10f: athrow
      // 110: aload 4
      // 112: aload 3
      // 113: ldc_w -1984456354
      // 116: ldc_w -1984456356
      // 119: ixor
      // 11a: anewarray 343
      // 11d: dup
      // 11e: bipush 0
      // 11f: getstatic java/nio/file/StandardCopyOption.ATOMIC_MOVE Ljava/nio/file/StandardCopyOption;
      // 122: aastore
      // 123: dup
      // 124: bipush 1
      // 125: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 128: aastore
      // 129: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 12c: pop
      // 12d: goto 143
      // 130: astore 5
      // 132: aload 4
      // 134: aload 3
      // 135: bipush 1
      // 136: anewarray 343
      // 139: dup
      // 13a: bipush 0
      // 13b: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 13e: aastore
      // 13f: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 142: pop
      // 143: aload 3
      // 144: invokestatic x/oc019d1ae7a9.ƞ (Ljava/nio/file/Path;)V
      // 147: aload 4
      // 149: invokestatic java/nio/file/Files.deleteIfExists (Ljava/nio/file/Path;)Z
      // 14c: pop
      // 14d: goto 15b
      // 150: astore 6
      // 152: aload 4
      // 154: invokestatic java/nio/file/Files.deleteIfExists (Ljava/nio/file/Path;)Z
      // 157: pop
      // 158: aload 6
      // 15a: athrow
      // 15b: return
   }

   private static Path Ͻ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc019d1ae7a9.Ԟ Z
      // 03: ldc_w "miau.nativeCacheDir"
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
      // 21: anewarray 87
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
      // 44: new java/lang/IllegalStateException
      // 47: dup
      // 48: ldc_w "user.home is unavailable"
      // 4b: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 4e: athrow
      // 4f: athrow
      // 50: aload 2
      // 51: ldc_w 156588126
      // 54: ldc_w 156588125
      // 57: ixor
      // 58: anewarray 87
      // 5b: dup
      // 5c: bipush 0
      // 5d: ldc_w ".miau-launcher"
      // 60: aastore
      // 61: dup
      // 62: bipush 1
      // 63: ldc_w "runtime"
      // 66: aastore
      // 67: dup
      // 68: ldc_w 156588127
      // 6b: ldc_w 156588125
      // 6e: ixor
      // 6f: ldc_w "natives"
      // 72: aastore
      // 73: invokestatic java/nio/file/Path.of (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
      // 76: areturn
   }

   private static void ϐ(Path var0, String var1) throws IOException {
      try {
         if (Files.isSymbolicLink(var0)) {
            throw new IOException("Refusing symbolic-link " + var1 + ": " + var0);
         }
      } catch (IOException var2) {
         throw var2;
      }
   }

   private static void ƞ(Path var0) throws IOException {
      try {
         Files.setPosixFilePermissions(var0, Set.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE));
      } catch (UnsupportedOperationException var2) {
      }
   }

   private static byte[] ο(byte[] var0) throws IOException {
      return ԏ().digest(var0);
   }

   private static MessageDigest ԏ() throws IOException {
      try {
         return MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException var1) {
         throw new IOException("SHA-256 is unavailable", var1);
      }
   }
}
