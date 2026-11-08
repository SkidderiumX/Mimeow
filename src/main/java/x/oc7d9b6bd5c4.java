package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.Logger;

public class oc7d9b6bd5c4 implements ocda171fe5d8 {
   private static final String ǣ = "default";
   private static final String Ч = "configs";
   private static final String H = "configs";
   private static final String ӂ = "active-config.txt";
   private static final int ȩ = 10;
   private static final int Ȃ = 3;
   private static final int Ɨ = 6;
   private static final int Π = 7;
   private static final int Ѫ = 8;
   private static final int ñ = 10;
   private static final char[] ț;
   public File ю;
   public List<oc151419fdfe> ǹ = new ArrayList<>();
   private final File ό;
   public static int Յ;
   private static final String[] a;
   private static final String[] b;
   private static final long[] c;
   private static final Integer[] d;
   private static final long e;

   public oc7d9b6bd5c4() {
      File var1 = oc8ccd9c3f55.պ(ocda171fe5d8.ǔ.mcDataDir);
      this.ό = new File(var1, "active-config.txt");
      this.ю = new File(var1, "configs");
      File var2 = new File(oc8ccd9c3f55.ζ(ocda171fe5d8.ǔ.mcDataDir), "configs");
      if (!this.ю.exists() && !this.ю.mkdirs()) {
         System.out.println("There was an issue creating configs directory.");
      } else {
         this.Ǥ(var2);
         if (this.ž().isEmpty()) {
            this.Ϧ(new oc151419fdfe("default", 0));
         }
      }
   }

   private void Ǥ(File var1) {
      try {
         oc8ccd9c3f55.Җ(var1, this.ю);
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public boolean Ϧ(oc151419fdfe param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w -3065127562113485425
      // 003: ldc2_w -3065218655286272551
      // 006: lxor
      // 007: lstore 2
      // 008: lload 2
      // 009: dup2
      // 00a: ldc2_w -3065249982819107011
      // 00d: ldc2_w -3065218655286272551
      // 010: lxor
      // 011: lxor
      // 012: lstore 4
      // 014: pop2
      // 015: getstatic x/oc151419fdfe.v Z
      // 018: istore 6
      // 01a: aload 1
      // 01b: iload 6
      // 01d: ifne 02b
      // 020: ifnonnull 02a
      // 023: goto 027
      // 026: athrow
      // 027: bipush 0
      // 028: ireturn
      // 029: athrow
      // 02a: aload 1
      // 02b: invokevirtual x/oc151419fdfe.ǚ ()Lx/ocdd0f49ff2f;
      // 02e: bipush 0
      // 02f: putfield x/ocdd0f49ff2f.Ƌ Z
      // 032: new com/google/gson/JsonObject
      // 035: dup
      // 036: invokespecial com/google/gson/JsonObject.<init> ()V
      // 039: astore 7
      // 03b: aload 7
      // 03d: invokestatic x/U.Ђ (Lcom/google/gson/JsonObject;)V
      // 040: aload 7
      // 042: ldc "formatVersion"
      // 044: ldc -812470698
      // 046: ldc -812470692
      // 048: ixor
      // 049: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 04c: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 04f: aload 7
      // 051: ldc "keybind"
      // 053: aload 1
      // 054: invokevirtual x/oc151419fdfe.ǚ ()Lx/ocdd0f49ff2f;
      // 057: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 05a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 05d: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 060: new com/google/gson/JsonArray
      // 063: dup
      // 064: invokespecial com/google/gson/JsonArray.<init> ()V
      // 067: astore 8
      // 069: getstatic x/oc2cf3d80e17.ļ Lx/oc9755810e45;
      // 06c: invokevirtual x/oc9755810e45.տ ()Ljava/util/List;
      // 06f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 074: astore 9
      // 076: aload 9
      // 078: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 07d: ifeq 0de
      // 080: aload 9
      // 082: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 087: checkcast x/oc69da1aa7f5
      // 08a: astore 10
      // 08c: iload 6
      // 08e: ifne 0e7
      // 091: aload 10
      // 093: iload 6
      // 095: ifne 0b1
      // 098: goto 09c
      // 09b: athrow
      // 09c: getfield x/oc69da1aa7f5.Ӻ Z
      // 09f: ifeq 0af
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: iload 6
      // 0a8: ifeq 076
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 10
      // 0b1: iload 6
      // 0b3: ifne 0cd
      // 0b6: getfield x/oc69da1aa7f5.Ӻ Z
      // 0b9: ifeq 0cb
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aload 10
      // 0c2: lload 4
      // 0c4: invokestatic x/oc7d9b6bd5c4.ʂ (Lx/oc69da1aa7f5;J)Lcom/google/gson/JsonObject;
      // 0c7: goto 0d0
      // 0ca: athrow
      // 0cb: aload 10
      // 0cd: invokestatic x/oc7d9b6bd5c4.s (Lx/oc69da1aa7f5;)Lcom/google/gson/JsonObject;
      // 0d0: astore 11
      // 0d2: iload 6
      // 0d4: aload 8
      // 0d6: aload 11
      // 0d8: invokevirtual com/google/gson/JsonArray.add (Lcom/google/gson/JsonElement;)V
      // 0db: ifeq 076
      // 0de: aload 7
      // 0e0: ldc "modules"
      // 0e2: aload 8
      // 0e4: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 0e7: new com/google/gson/JsonArray
      // 0ea: dup
      // 0eb: invokespecial com/google/gson/JsonArray.<init> ()V
      // 0ee: astore 9
      // 0f0: getstatic x/oc2c25634a7e.ʴ Ljava/util/ArrayList;
      // 0f3: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 0f6: astore 10
      // 0f8: aload 10
      // 0fa: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ff: ifeq 16c
      // 102: aload 10
      // 104: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 109: checkcast x/oc192c7e4083
      // 10c: astore 11
      // 10e: iload 6
      // 110: new com/google/gson/JsonObject
      // 113: dup
      // 114: invokespecial com/google/gson/JsonObject.<init> ()V
      // 117: astore 12
      // 119: aload 12
      // 11b: ldc_w "name"
      // 11e: aload 11
      // 120: getfield x/oc192c7e4083.ȩ Lx/oce4cea752dd;
      // 123: invokevirtual java/lang/Enum.name ()Ljava/lang/String;
      // 126: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 129: ifne 176
      // 12c: aload 12
      // 12e: ldc_w "x"
      // 131: aload 11
      // 133: invokevirtual x/oc192c7e4083.Ʃ ()F
      // 136: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 139: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 13c: iload 6
      // 13e: aload 12
      // 140: ldc_w "y"
      // 143: aload 11
      // 145: invokevirtual x/oc192c7e4083.І ()F
      // 148: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 14b: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 14e: aload 12
      // 150: ldc_w "opened"
      // 153: aload 11
      // 155: invokevirtual x/oc192c7e4083.Ɣ ()Z
      // 158: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 15b: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 15e: aload 9
      // 160: aload 12
      // 162: invokevirtual com/google/gson/JsonArray.add (Lcom/google/gson/JsonElement;)V
      // 165: ifeq 0f8
      // 168: goto 16c
      // 16b: athrow
      // 16c: aload 7
      // 16e: ldc_w "guiCategories"
      // 171: aload 9
      // 173: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 176: new java/io/File
      // 179: dup
      // 17a: aload 0
      // 17b: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 17e: aload 1
      // 17f: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 182: ldc_w ".json"
      // 185: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 18a: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 18d: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 190: astore 10
      // 192: aload 10
      // 194: aload 7
      // 196: invokestatic x/oc0326f6e039.Š (Ljava/nio/file/Path;Lcom/google/gson/JsonObject;)V
      // 199: goto 1b0
      // 19c: astore 11
      // 19e: aload 0
      // 19f: ldc_w "save"
      // 1a2: aload 1
      // 1a3: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 1a6: invokevirtual x/oc7d9b6bd5c4.ի (Ljava/lang/String;Ljava/lang/String;)V
      // 1a9: aload 11
      // 1ab: invokevirtual java/lang/Exception.printStackTrace ()V
      // 1ae: bipush 0
      // 1af: ireturn
      // 1b0: aload 1
      // 1b1: invokevirtual x/oc151419fdfe.ǚ ()Lx/ocdd0f49ff2f;
      // 1b4: bipush 1
      // 1b5: putfield x/ocdd0f49ff2f.Ƌ Z
      // 1b8: bipush 1
      // 1b9: ireturn
   }

   static void ų(Path param0, Path param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 8822674099073862929
      // 03: ldc2_w 8822573208504216253
      // 06: lxor
      // 07: lstore 2
      // 08: lload 2
      // 09: dup2
      // 0a: ldc2_w 8822563417819700963
      // 0d: ldc2_w 8822573208504216253
      // 10: lxor
      // 11: lxor
      // 12: lstore 4
      // 14: dup2
      // 15: ldc2_w 8822577122153228603
      // 18: ldc2_w 8822573208504216253
      // 1b: lxor
      // 1c: lxor
      // 1d: lstore 6
      // 1f: pop2
      // 20: getstatic x/oc151419fdfe.v Z
      // 23: aconst_null
      // 24: astore 9
      // 26: bipush 0
      // 27: istore 10
      // 29: istore 8
      // 2b: iload 10
      // 2d: ldc_w 1487551330
      // 30: ldc_w 1487551332
      // 33: ixor
      // 34: if_icmpge c6
      // 37: aload 1
      // 38: lload 4
      // 3a: invokestatic x/oc7d9b6bd5c4.Յ (Ljava/nio/file/Path;J)V
      // 3d: aload 0
      // 3e: aload 1
      // 3f: ldc_w 1487551334
      // 42: ldc_w 1487551332
      // 45: ixor
      // 46: anewarray 355
      // 49: dup
      // 4a: bipush 0
      // 4b: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 4e: aastore
      // 4f: dup
      // 50: bipush 1
      // 51: getstatic java/nio/file/StandardCopyOption.ATOMIC_MOVE Ljava/nio/file/StandardCopyOption;
      // 54: aastore
      // 55: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 58: pop
      // 59: goto 6e
      // 5c: astore 11
      // 5e: aload 0
      // 5f: aload 1
      // 60: bipush 1
      // 61: anewarray 355
      // 64: dup
      // 65: bipush 0
      // 66: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 69: aastore
      // 6a: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 6d: pop
      // 6e: return
      // 6f: astore 11
      // 71: aload 11
      // 73: astore 9
      // 75: aload 11
      // 77: instanceof java/nio/file/AccessDeniedException
      // 7a: iload 8
      // 7c: ifne 9e
      // 7f: ifne 9c
      // 82: goto 86
      // 85: athrow
      // 86: iload 10
      // 88: iload 8
      // 8a: ifne 9e
      // 8d: goto 91
      // 90: athrow
      // 91: ifle 9c
      // 94: goto 98
      // 97: athrow
      // 98: aload 11
      // 9a: athrow
      // 9b: athrow
      // 9c: iload 10
      // 9e: iload 8
      // a0: ifne b7
      // a3: ldc_w 1487551329
      // a6: ldc_w 1487551332
      // a9: ixor
      // aa: if_icmpge be
      // ad: goto b1
      // b0: athrow
      // b1: iload 10
      // b3: goto b7
      // b6: athrow
      // b7: lload 6
      // b9: aload 11
      // bb: invokestatic x/oc7d9b6bd5c4.ϥ (IJLjava/io/IOException;)V
      // be: iinc 10 1
      // c1: iload 8
      // c3: ifeq 2b
      // c6: aload 9
      // c8: athrow
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void Յ(Path var0, long var1) throws IOException {
      DosFileAttributeView var4 = null;
      int var10000 = oc151419fdfe.v;
      int var5 = a(605688368 ^ 605691383, -7112041832281956550L ^ -1437096776975481394L ^ var1);
      byte var3 = (byte)var10000;

      label142:
      while (true) {
         var10000 = var5;

         label136: {
            while (true) {
               label148: {
                  switch (var10000) {
                     case -1762560556:
                        label93: {
                           label92: {
                              long var18;
                              long var10002;
                              label91: {
                                 label152: {
                                    try {
                                       var10000 = var4.readAttributes().isReadOnly();
                                       if (var1 <= 1L) {
                                          break label93;
                                       }

                                       if (var3 != 0) {
                                          break label92;
                                       }

                                       if (var10000 == 0) {
                                          break label152;
                                       }
                                    } catch (IOException var9) {
                                       throw var9;
                                    }

                                    var10000 = 605708699 ^ 605691383;
                                    var18 = -8831574284241736535L ^ -1437096776975481394L;
                                    var10002 = var1;
                                    if (var1 < 1L) {
                                       break label91;
                                    }

                                    var5 = a(var10000, var18 ^ var1);
                                    if (var3 == 0) {
                                       continue label142;
                                    }
                                 }

                                 var10000 = 605692066 ^ 605691383;
                                 var18 = -6559397523758830146L ^ -1437096776975481394L;
                                 var10002 = var1;
                              }

                              var10000 = a(var10000, var18 ^ var10002);
                           }

                           var5 = var10000;
                           var10000 = var3;
                        }

                        if (var1 < 0L) {
                           continue;
                        }

                        if (var10000 == 0) {
                           continue label142;
                        }

                        return;
                     case -1613046042:
                        return;
                     case 114409951:
                        break label148;
                     case 619525885:
                        return;
                     case 1499728621:
                        var4.setReadOnly(false);
                        var10000 = var3;
                        if (var1 < 0L) {
                           break;
                        }

                        var5 = a(605713132 ^ 605691383, -1429678613574778891L ^ -1437096776975481394L ^ var1);
                        if (var3 == 0) {
                           continue label142;
                        }
                     case 217229082:
                        try {
                           var10000 = Files.exists(var0, LinkOption.NOFOLLOW_LINKS);
                           break;
                        } catch (IOException var6) {
                           throw var6;
                        }
                     default:
                        throw null;
                  }

                  label149: {
                     label119: {
                        long var10001;
                        label118: {
                           label150: {
                              try {
                                 if (var1 < 0L) {
                                    break label149;
                                 }

                                 if (var3 != 0) {
                                    break label119;
                                 }

                                 if (var10000 != 0) {
                                    break label150;
                                 }
                              } catch (IOException var10) {
                                 throw var10;
                              }

                              var10000 = 605697220 ^ 605691383;
                              var10001 = -6798832063276074521L ^ -1437096776975481394L ^ var1;
                              if (var1 < 0L) {
                                 break label118;
                              }

                              var5 = a(var10000, var10001);
                              if (var3 == 0) {
                                 continue label142;
                              }
                           }

                           var10000 = 605704396 ^ 605691383;
                           var10001 = -5742815432766923296L ^ -1437096776975481394L ^ var1;
                        }

                        var10000 = a(var10000, var10001);
                     }

                     var5 = var10000;
                     if (var1 < 0L) {
                        break;
                     }

                     var10000 = var3;
                  }

                  if (var10000 == 0) {
                     continue label142;
                  }
               }

               var14 = Files.getFileAttributeView(var0, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
               if (var1 < 1L) {
                  break label136;
               }

               var4 = var14;
               break;
            }

            try {
               if (var3 != 0) {
                  continue;
               }

               var14 = var4;
            } catch (IOException var7) {
               throw var7;
            }
         }

         long var17;
         label73: {
            label154: {
               try {
                  if (var14 == null) {
                     break label154;
                  }
               } catch (IOException var8) {
                  throw var8;
               }

               var10000 = 605686481 ^ 605691383;
               var17 = -8536951237786302486L ^ -1437096776975481394L;
               if (var1 <= 0L) {
                  break label73;
               }

               var5 = a(var10000, var17 ^ var1);
               if (var3 == 0) {
                  continue;
               }
            }

            var10000 = 605713132 ^ 605691383;
            var17 = -1429678613574778891L ^ -1437096776975481394L ^ var1;
         }

         var5 = a(var10000, var17);
      }
   }

   private static void ϥ(int var0, long var1, IOException var3) throws IOException {
      try {
         Thread.sleep(e * (var0 + 1L));
      } catch (InterruptedException var6) {
         Thread.currentThread().interrupt();
         IOException var5 = new IOException(
            a((-1710764224 ^ 1355807352) + (-1355787070 ^ 1355807352), (1710764208 ^ 1355807352) + (char)(-1355776020 ^ 1355807352), (int)var1), var6
         );
         var5.addSuppressed(var3);
         throw var5;
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void Ǽ(Path var0, long var1) {
      boolean var3 = oc151419fdfe.v;
      if (var1 > 1L) {
         Path var10000;
         label31: {
            try {
               var10000 = var0;
               if (var3) {
                  break label31;
               }

               if (var0 == null) {
                  return;
               }
            } catch (IOException var7) {
               throw var7;
            }

            try {
               var10000 = var0;
            } catch (IOException var6) {
               return;
            }
         }

         try {
            Files.deleteIfExists(var10000);
         } catch (IOException var5) {
         }
      }
   }

   public oc151419fdfe χ(String param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 7322618371789008987
      // 03: ldc2_w 7322651211379745607
      // 06: lxor
      // 07: lstore 3
      // 08: lload 3
      // 09: dup2
      // 0a: ldc2_w 7322580016317092820
      // 0d: ldc2_w 7322651211379745607
      // 10: lxor
      // 11: lxor
      // 12: lstore 5
      // 14: dup2
      // 15: ldc2_w 7322627430997212871
      // 18: ldc2_w 7322651211379745607
      // 1b: lxor
      // 1c: lxor
      // 1d: lstore 7
      // 1f: dup2
      // 20: ldc2_w 7322616410414373759
      // 23: ldc2_w 7322651211379745607
      // 26: lxor
      // 27: lxor
      // 28: lstore 9
      // 2a: pop2
      // 2b: getstatic x/oc151419fdfe.v Z
      // 2e: aload 0
      // 2f: aload 1
      // 30: lload 7
      // 32: invokevirtual x/oc7d9b6bd5c4.ǵ (Ljava/lang/String;J)Ljava/lang/String;
      // 35: astore 12
      // 37: istore 11
      // 39: aload 0
      // 3a: aload 12
      // 3c: lload 9
      // 3e: aconst_null
      // 3f: invokevirtual x/oc7d9b6bd5c4.ƈ (Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
      // 42: astore 13
      // 44: iload 11
      // 46: ifne 64
      // 49: aload 13
      // 4b: ifnull 66
      // 4e: goto 52
      // 51: athrow
      // 52: aload 13
      // 54: ldc_w "&c"
      // 57: swap
      // 58: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 5d: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 60: goto 64
      // 63: athrow
      // 64: aconst_null
      // 65: areturn
      // 66: new x/oc151419fdfe
      // 69: dup
      // 6a: aload 12
      // 6c: iload 2
      // 6d: invokespecial x/oc151419fdfe.<init> (Ljava/lang/String;I)V
      // 70: astore 14
      // 72: iload 11
      // 74: ifne 99
      // 77: aload 0
      // 78: aload 14
      // 7a: invokevirtual x/oc7d9b6bd5c4.Ϧ (Lx/oc151419fdfe;)Z
      // 7d: ifne 87
      // 80: goto 84
      // 83: athrow
      // 84: aconst_null
      // 85: areturn
      // 86: athrow
      // 87: aload 0
      // 88: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 8b: aload 14
      // 8d: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 92: pop
      // 93: aload 0
      // 94: lload 5
      // 96: invokevirtual x/oc7d9b6bd5c4.ҷ (J)V
      // 99: aload 14
      // 9b: areturn
   }

   public static JsonObject s(oc69da1aa7f5 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w -2055673287821812867
      // 003: ldc2_w -2055612762586289673
      // 006: lxor
      // 007: lstore 1
      // 008: lload 1
      // 009: dup2
      // 00a: ldc2_w -2055651355401893189
      // 00d: ldc2_w -2055612762586289673
      // 010: lxor
      // 011: lxor
      // 012: lstore 3
      // 013: pop2
      // 014: getstatic x/oc151419fdfe.v Z
      // 017: new com/google/gson/JsonObject
      // 01a: dup
      // 01b: invokespecial com/google/gson/JsonObject.<init> ()V
      // 01e: astore 6
      // 020: istore 5
      // 022: aload 6
      // 024: ldc_w "name"
      // 027: aload 0
      // 028: iload 5
      // 02a: ifne 04c
      // 02d: invokevirtual x/oc69da1aa7f5.ъ ()Lx/oce4cea752dd;
      // 030: getstatic x/oce4cea752dd.ռ Lx/oce4cea752dd;
      // 033: if_acmpne 04b
      // 036: goto 03a
      // 039: athrow
      // 03a: aload 0
      // 03b: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 03e: ldc_w "sc-"
      // 041: swap
      // 042: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 047: goto 04f
      // 04a: athrow
      // 04b: aload 0
      // 04c: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 04f: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 052: aload 0
      // 053: iload 5
      // 055: ifne 0a2
      // 058: getfield x/oc69da1aa7f5.ȭ Z
      // 05b: ifeq 0a1
      // 05e: goto 062
      // 061: athrow
      // 062: aload 6
      // 064: ldc_w "enabled"
      // 067: aload 0
      // 068: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 06b: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 06e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 071: aload 6
      // 073: ldc_w "hidden"
      // 076: aload 0
      // 077: invokevirtual x/oc69da1aa7f5.լ ()Z
      // 07a: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 07d: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 080: aload 6
      // 082: ldc "keybind"
      // 084: aload 0
      // 085: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 088: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 08b: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 08e: aload 6
      // 090: ldc_w "hold"
      // 093: aload 0
      // 094: invokevirtual x/oc69da1aa7f5.ŷ ()Z
      // 097: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 09a: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: aload 0
      // 0a2: iload 5
      // 0a4: ifne 146
      // 0a7: instanceof x/ocd2958dac48
      // 0aa: ifeq 145
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 0
      // 0b2: checkcast x/ocd2958dac48
      // 0b5: astore 7
      // 0b7: iload 5
      // 0b9: aload 6
      // 0bb: ldc_w "posX"
      // 0be: getstatic x/ocd2958dac48.Ƃ F
      // 0c1: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 0c4: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 0c7: aload 6
      // 0c9: ldc_w "posY"
      // 0cc: getstatic x/ocd2958dac48.ș F
      // 0cf: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 0d2: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 0d5: aload 6
      // 0d7: ldc_w "relPosX"
      // 0da: invokestatic x/ocd2958dac48.β ()F
      // 0dd: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 0e0: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 0e3: aload 6
      // 0e5: ldc_w "relPosY"
      // 0e8: invokestatic x/ocd2958dac48.Ş ()F
      // 0eb: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 0ee: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 0f1: aload 6
      // 0f3: ldc_w "modernRelPosX"
      // 0f6: aload 7
      // 0f8: invokevirtual x/ocd2958dac48.ʫ ()F
      // 0fb: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 0fe: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 101: aload 6
      // 103: ldc_w "modernRelPosY"
      // 106: aload 7
      // 108: invokevirtual x/ocd2958dac48.i ()F
      // 10b: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 10e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 111: aload 6
      // 113: ldc_w "potionPosX"
      // 116: aload 7
      // 118: invokevirtual x/ocd2958dac48.ҟ ()D
      // 11b: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 11e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 121: aload 6
      // 123: ldc_w "potionPosY"
      // 126: aload 7
      // 128: invokevirtual x/ocd2958dac48.ώ ()D
      // 12b: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 12e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 131: ifeq 25c
      // 134: bipush 0
      // 135: ifeq 141
      // 138: goto 13c
      // 13b: athrow
      // 13c: bipush 0
      // 13d: goto 142
      // 140: athrow
      // 141: bipush 1
      // 142: putstatic x/oc69da1aa7f5.Ҭ Z
      // 145: aload 0
      // 146: iload 5
      // 148: ifne 185
      // 14b: instanceof x/oced2c93b93e
      // 14e: ifeq 180
      // 151: goto 155
      // 154: athrow
      // 155: aload 0
      // 156: checkcast x/oced2c93b93e
      // 159: astore 7
      // 15b: iload 5
      // 15d: aload 6
      // 15f: ldc_w "posX"
      // 162: aload 7
      // 164: invokevirtual x/oced2c93b93e.ǌ ()D
      // 167: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 16a: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 16d: aload 6
      // 16f: ldc_w "posY"
      // 172: aload 7
      // 174: invokevirtual x/oced2c93b93e.ʚ ()D
      // 177: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 17a: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 17d: ifeq 25c
      // 180: aload 0
      // 181: goto 185
      // 184: athrow
      // 185: iload 5
      // 187: ifne 1c4
      // 18a: instanceof x/oc7ed5a3bedd
      // 18d: ifeq 1bf
      // 190: goto 194
      // 193: athrow
      // 194: aload 6
      // 196: ldc_w "posX"
      // 199: getstatic x/oc9755810e45.Ƿ Lx/oc7ed5a3bedd;
      // 19c: getfield x/oc7ed5a3bedd.Ș I
      // 19f: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1a2: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 1a5: iload 5
      // 1a7: aload 6
      // 1a9: ldc_w "posY"
      // 1ac: getstatic x/oc9755810e45.Ƿ Lx/oc7ed5a3bedd;
      // 1af: getfield x/oc7ed5a3bedd.ɐ I
      // 1b2: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1b5: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 1b8: ifeq 25c
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: aload 0
      // 1c0: goto 1c4
      // 1c3: athrow
      // 1c4: iload 5
      // 1c6: ifne 203
      // 1c9: instanceof x/oc63a9b409d2
      // 1cc: ifeq 1fe
      // 1cf: goto 1d3
      // 1d2: athrow
      // 1d3: aload 0
      // 1d4: checkcast x/oc63a9b409d2
      // 1d7: astore 7
      // 1d9: iload 5
      // 1db: aload 6
      // 1dd: ldc_w "hudPosX"
      // 1e0: aload 7
      // 1e2: invokevirtual x/oc63a9b409d2.Ŝ ()F
      // 1e5: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 1e8: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 1eb: aload 6
      // 1ed: ldc_w "hudPosY"
      // 1f0: aload 7
      // 1f2: invokevirtual x/oc63a9b409d2.Ħ ()F
      // 1f5: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 1f8: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 1fb: ifeq 25c
      // 1fe: aload 0
      // 1ff: goto 203
      // 202: athrow
      // 203: iload 5
      // 205: ifne 217
      // 208: instanceof x/oca4800eb63f
      // 20b: ifeq 25c
      // 20e: goto 212
      // 211: athrow
      // 212: aload 0
      // 213: goto 217
      // 216: athrow
      // 217: checkcast x/oca4800eb63f
      // 21a: astore 7
      // 21c: aload 6
      // 21e: ldc_w "posX"
      // 221: aload 7
      // 223: invokevirtual x/oca4800eb63f.Ɖ ()F
      // 226: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 229: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 22c: aload 6
      // 22e: ldc_w "posY"
      // 231: aload 7
      // 233: invokevirtual x/oca4800eb63f.Ǟ ()F
      // 236: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 239: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 23c: aload 6
      // 23e: ldc_w "relPosX"
      // 241: aload 7
      // 243: invokevirtual x/oca4800eb63f.ř ()F
      // 246: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 249: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 24c: aload 6
      // 24e: ldc_w "relPosY"
      // 251: aload 7
      // 253: invokevirtual x/oca4800eb63f.Ϻ ()F
      // 256: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 259: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 25c: new com/google/gson/JsonArray
      // 25f: dup
      // 260: invokespecial com/google/gson/JsonArray.<init> ()V
      // 263: astore 7
      // 265: aload 0
      // 266: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 269: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 26c: astore 8
      // 26e: aload 8
      // 270: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 275: ifeq 2e1
      // 278: aload 8
      // 27a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 27f: checkcast x/N
      // 282: astore 9
      // 284: iload 5
      // 286: ifne 2f7
      // 289: lload 3
      // 28a: aload 9
      // 28c: invokestatic x/oc7d9b6bd5c4.ϡ (JLx/N;)Lcom/google/gson/JsonElement;
      // 28f: astore 10
      // 291: iload 5
      // 293: ifne 2b5
      // 296: aload 10
      // 298: ifnonnull 2a8
      // 29b: goto 29f
      // 29e: athrow
      // 29f: iload 5
      // 2a1: ifeq 26e
      // 2a4: goto 2a8
      // 2a7: athrow
      // 2a8: aload 6
      // 2aa: aload 0
      // 2ab: aload 9
      // 2ad: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 2b0: aload 10
      // 2b2: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 2b5: new com/google/gson/JsonObject
      // 2b8: dup
      // 2b9: invokespecial com/google/gson/JsonObject.<init> ()V
      // 2bc: astore 11
      // 2be: iload 5
      // 2c0: aload 11
      // 2c2: ldc_w "name"
      // 2c5: aload 9
      // 2c7: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 2ca: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 2cd: aload 11
      // 2cf: ldc_w "value"
      // 2d2: aload 10
      // 2d4: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 2d7: aload 7
      // 2d9: aload 11
      // 2db: invokevirtual com/google/gson/JsonArray.add (Lcom/google/gson/JsonElement;)V
      // 2de: ifeq 26e
      // 2e1: aload 7
      // 2e3: invokevirtual com/google/gson/JsonArray.size ()I
      // 2e6: ifle 2f7
      // 2e9: aload 6
      // 2eb: ldc_w "portableSettings"
      // 2ee: aload 7
      // 2f0: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 2f3: goto 2f7
      // 2f6: athrow
      // 2f7: aload 6
      // 2f9: areturn
   }

   private static JsonElement ϡ(long param0, N param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc151419fdfe.v Z
      // 003: istore 3
      // 004: aload 2
      // 005: iload 3
      // 006: ifne 043
      // 009: instanceof x/occ2f8dff8d8
      // 00c: ifeq 042
      // 00f: goto 013
      // 012: athrow
      // 013: aload 2
      // 014: checkcast x/occ2f8dff8d8
      // 017: lload 0
      // 018: lconst_1
      // 019: lcmp
      // 01a: iflt 043
      // 01d: iload 3
      // 01e: ifne 043
      // 021: goto 025
      // 024: athrow
      // 025: getfield x/occ2f8dff8d8.ӽ Z
      // 028: ifne 042
      // 02b: goto 02f
      // 02e: athrow
      // 02f: new com/google/gson/JsonPrimitive
      // 032: dup
      // 033: aload 2
      // 034: checkcast x/occ2f8dff8d8
      // 037: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 03a: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 03d: invokespecial com/google/gson/JsonPrimitive.<init> (Ljava/lang/Boolean;)V
      // 040: areturn
      // 041: athrow
      // 042: aload 2
      // 043: iload 3
      // 044: lload 0
      // 045: lconst_0
      // 046: lcmp
      // 047: ifle 06c
      // 04a: ifne 06b
      // 04d: instanceof x/oca9cc61aada
      // 050: ifeq 06a
      // 053: goto 057
      // 056: athrow
      // 057: new com/google/gson/JsonPrimitive
      // 05a: dup
      // 05b: aload 2
      // 05c: checkcast x/oca9cc61aada
      // 05f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 062: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 065: invokespecial com/google/gson/JsonPrimitive.<init> (Ljava/lang/Number;)V
      // 068: areturn
      // 069: athrow
      // 06a: aload 2
      // 06b: iload 3
      // 06c: lload 0
      // 06d: lconst_1
      // 06e: lcmp
      // 06f: ifle 08a
      // 072: ifne 089
      // 075: instanceof x/ocf1568fef75
      // 078: ifeq 088
      // 07b: goto 07f
      // 07e: athrow
      // 07f: aload 2
      // 080: checkcast x/ocf1568fef75
      // 083: invokevirtual x/ocf1568fef75.Ղ ()Lcom/google/gson/JsonObject;
      // 086: areturn
      // 087: athrow
      // 088: aload 2
      // 089: iload 3
      // 08a: lload 0
      // 08b: lconst_0
      // 08c: lcmp
      // 08d: iflt 0a8
      // 090: ifne 0a7
      // 093: instanceof x/ocada7dda290
      // 096: ifeq 0a6
      // 099: goto 09d
      // 09c: athrow
      // 09d: aload 2
      // 09e: checkcast x/ocada7dda290
      // 0a1: invokevirtual x/ocada7dda290.ϳ ()Lcom/google/gson/JsonArray;
      // 0a4: areturn
      // 0a5: athrow
      // 0a6: aload 2
      // 0a7: iload 3
      // 0a8: lload 0
      // 0a9: lconst_0
      // 0aa: lcmp
      // 0ab: iflt 0d0
      // 0ae: ifne 0cf
      // 0b1: instanceof x/ocb23d192a35
      // 0b4: ifeq 0ce
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: new com/google/gson/JsonPrimitive
      // 0be: dup
      // 0bf: aload 2
      // 0c0: checkcast x/ocb23d192a35
      // 0c3: invokevirtual x/ocb23d192a35.Ǻ ()I
      // 0c6: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0c9: invokespecial com/google/gson/JsonPrimitive.<init> (Ljava/lang/Number;)V
      // 0cc: areturn
      // 0cd: athrow
      // 0ce: aload 2
      // 0cf: iload 3
      // 0d0: lload 0
      // 0d1: lconst_1
      // 0d2: lcmp
      // 0d3: ifle 105
      // 0d6: ifne 104
      // 0d9: instanceof x/oc321b4679dd
      // 0dc: ifeq 103
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 2
      // 0e4: checkcast x/oc321b4679dd
      // 0e7: astore 4
      // 0e9: aload 4
      // 0eb: invokevirtual x/oc321b4679dd.Ǽ ()Z
      // 0ee: ifeq 0f6
      // 0f1: aconst_null
      // 0f2: goto 102
      // 0f5: athrow
      // 0f6: new com/google/gson/JsonPrimitive
      // 0f9: dup
      // 0fa: aload 4
      // 0fc: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 0ff: invokespecial com/google/gson/JsonPrimitive.<init> (Ljava/lang/String;)V
      // 102: areturn
      // 103: aload 2
      // 104: iload 3
      // 105: lload 0
      // 106: lconst_1
      // 107: lcmp
      // 108: iflt 141
      // 10b: ifne 140
      // 10e: instanceof x/oc24a0a5bddf
      // 111: ifeq 13f
      // 114: goto 118
      // 117: athrow
      // 118: aload 2
      // 119: checkcast x/oc24a0a5bddf
      // 11c: astore 4
      // 11e: new com/google/gson/JsonPrimitive
      // 121: dup
      // 122: aload 4
      // 124: invokevirtual x/oc24a0a5bddf.ˀ ()I
      // 127: aload 4
      // 129: invokevirtual x/oc24a0a5bddf.z ()I
      // 12c: aload 4
      // 12e: invokevirtual x/oc24a0a5bddf.ц ()I
      // 131: aload 4
      // 133: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 136: invokedynamic makeConcatWithConstants (IIII)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001,\u0001,\u0001,\u0001" ]
      // 13b: invokespecial com/google/gson/JsonPrimitive.<init> (Ljava/lang/String;)V
      // 13e: areturn
      // 13f: aload 2
      // 140: iload 3
      // 141: lload 0
      // 142: lconst_1
      // 143: lcmp
      // 144: ifle 15f
      // 147: ifne 15e
      // 14a: instanceof x/oc10354c7bb8
      // 14d: ifeq 15d
      // 150: goto 154
      // 153: athrow
      // 154: aload 2
      // 155: checkcast x/oc10354c7bb8
      // 158: invokevirtual x/oc10354c7bb8.z$tvwb8ctrx7ou ()Lcom/google/gson/JsonArray;
      // 15b: areturn
      // 15c: athrow
      // 15d: aload 2
      // 15e: iload 3
      // 15f: ifne 171
      // 162: instanceof x/oc6af36febc3
      // 165: ifeq 178
      // 168: goto 16c
      // 16b: athrow
      // 16c: aload 2
      // 16d: goto 171
      // 170: athrow
      // 171: checkcast x/oc6af36febc3
      // 174: invokevirtual x/oc6af36febc3.ĭ ()Lcom/google/gson/JsonArray;
      // 177: areturn
      // 178: aconst_null
      // 179: areturn
   }

   static void а(oc63a9b409d2 var0, JsonObject var1) {
      long var2 = -92199548096758575L ^ -92318144523149385L;
      long var4 = var2 ^ -92183124406407657L ^ -92318144523149385L;
      float var6 = ҫ(var1, "hudPosX", var4, var0.Ŝ());
      float var7 = ҫ(var1, "hudPosY", var4, var0.Ħ());
      var0.ϐ(var6, var7);
   }

   static void À(oced2c93b93e param0, JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 413046190305099289
      // 03: ldc2_w 412939120979540226
      // 06: lxor
      // 07: lstore 2
      // 08: lload 2
      // 09: dup2
      // 0a: ldc2_w 412950162734596099
      // 0d: ldc2_w 412939120979540226
      // 10: lxor
      // 11: lxor
      // 12: lstore 4
      // 14: pop2
      // 15: aload 1
      // 16: ldc_w "posX"
      // 19: aload 1
      // 1a: ldc_w "setting.posX"
      // 1d: aload 1
      // 1e: ldc_w "Position X"
      // 21: aload 0
      // 22: invokevirtual x/oced2c93b93e.ǌ ()D
      // 25: lload 4
      // 27: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 2a: lload 4
      // 2c: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 2f: lload 4
      // 31: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 34: dstore 7
      // 36: getstatic x/oc151419fdfe.v Z
      // 39: aload 1
      // 3a: ldc_w "posY"
      // 3d: aload 1
      // 3e: ldc_w "setting.posY"
      // 41: aload 1
      // 42: ldc_w "Position Y"
      // 45: aload 0
      // 46: invokevirtual x/oced2c93b93e.ʚ ()D
      // 49: lload 4
      // 4b: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 4e: lload 4
      // 50: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 53: lload 4
      // 55: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 58: dstore 9
      // 5a: istore 6
      // 5c: aload 0
      // 5d: dload 7
      // 5f: dload 9
      // 61: invokevirtual x/oced2c93b93e.ɞ (DD)V
      // 64: bipush 0
      // 65: ifeq 7a
      // 68: iload 6
      // 6a: ifeq 76
      // 6d: goto 71
      // 70: athrow
      // 71: bipush 0
      // 72: goto 77
      // 75: athrow
      // 76: bipush 1
      // 77: putstatic x/oc151419fdfe.v Z
      // 7a: return
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static float ҫ(JsonObject var0, String var1, long var2, float var4) {
      float var6 = 0.0F;
      int var10000 = oc151419fdfe.v;
      int var7 = a(53856424 ^ 53861443, -2323989556400286173L ^ -3581622703704156426L ^ var2);
      byte var5 = (byte)var10000;

      label179:
      while (true) {
         var10000 = var7;

         do {
            label170: {
               label184: {
                  switch (var10000) {
                     case -1874501260:
                        return var6;
                     case -318409334:
                        break label184;
                     case 516591591:
                        return var4;
                     case 954503770:
                        return var4;
                     case 993858631:
                        label185: {
                           label159: {
                              label158: {
                                 label186: {
                                    try {
                                       var10000 = var0.get(var1).isJsonPrimitive();
                                       if (var2 < 1L) {
                                          break label185;
                                       }

                                       if (var5 != 0) {
                                          break label159;
                                       }

                                       if (var10000 == 0) {
                                          break label186;
                                       }
                                    } catch (RuntimeException var12) {
                                       throw var12;
                                    }

                                    var10000 = 53842879 ^ 53861443;
                                    if (var2 <= 0L) {
                                       break label158;
                                    }

                                    var7 = a(var10000, -7926623830851859199L ^ -3581622703704156426L ^ var2);
                                    if (var5 == 0) {
                                       continue label179;
                                    }
                                 }

                                 var10000 = 53858034 ^ 53861443;
                              }

                              var10000 = a(var10000, -4224286113191129066L ^ -3581622703704156426L ^ var2);
                           }

                           var7 = var10000;
                           if (var2 <= 1L) {
                              break;
                           }

                           var10000 = var5;
                        }

                        if (var10000 == 0) {
                           continue label179;
                        }
                     case -580917584:
                        var6 = var0.getAsJsonPrimitive(var1).getAsFloat();
                        break;
                     case 1672135473:
                        label92: {
                           label91: {
                              long var10001;
                              label90: {
                                 label192: {
                                    try {
                                       var10000 = var0.getAsJsonPrimitive(var1).isNumber();
                                       if (var2 <= 0L) {
                                          break label92;
                                       }

                                       if (var5 != 0) {
                                          break label91;
                                       }

                                       if (var10000 != 0) {
                                          break label192;
                                       }
                                    } catch (RuntimeException var9) {
                                       throw var9;
                                    }

                                    var10000 = 53852654 ^ 53861443;
                                    var10001 = -3669793635681212573L ^ -3581622703704156426L ^ var2;
                                    if (var2 <= 0L) {
                                       break label90;
                                    }

                                    var7 = a(var10000, var10001);
                                    if (var5 == 0) {
                                       continue label179;
                                    }
                                 }

                                 var10000 = 53846106 ^ 53861443;
                                 var10001 = -5224303273978102100L ^ -3581622703704156426L ^ var2;
                              }

                              var10000 = a(var10000, var10001);
                           }

                           var7 = var10000;
                           var10000 = var5;
                        }

                        if (var10000 == 0) {
                           continue label179;
                        }

                        return var4;
                     default:
                        throw null;
                  }

                  label139: {
                     label138: {
                        label137: {
                           label188: {
                              try {
                                 var10000 = var5;
                                 if (var2 < 1L) {
                                    break label139;
                                 }

                                 if (var5 != 0) {
                                    break label138;
                                 }

                                 var10000 = Float.isFinite(var6);
                                 if (var2 < 0L) {
                                    break label137;
                                 }

                                 if (var10000 == 0) {
                                    break label188;
                                 }
                              } catch (RuntimeException var11) {
                                 throw var11;
                              }

                              var10000 = a(53861592 ^ 53861443, -1122701654859054527L ^ -3581622703704156426L ^ var2);
                              if (var2 < 0L) {
                                 break label137;
                              }

                              var7 = var10000;
                              if (var5 == 0) {
                                 continue label179;
                              }
                           }

                           var10000 = a(53844829 ^ 53861443, -4945262446404286977L ^ -3581622703704156426L ^ var2);
                        }

                        var7 = var10000;
                     }

                     var10000 = var5;
                  }

                  if (var2 <= 1L) {
                     break label170;
                  }

                  if (var10000 == 0) {
                     continue label179;
                  }
               }

               try {
                  var10000 = var0.has(var1);
               } catch (RuntimeException var8) {
                  throw var8;
               }
            }

            label111: {
               long var20;
               long var10002;
               label110: {
                  label190: {
                     try {
                        if (var2 <= 1L) {
                           continue;
                        }

                        if (var5 != 0) {
                           break label111;
                        }

                        if (var10000 == 0) {
                           break label190;
                        }
                     } catch (RuntimeException var10) {
                        throw var10;
                     }

                     var10000 = 53869775 ^ 53861443;
                     var20 = -5697773150211038602L ^ -3581622703704156426L;
                     var10002 = var2;
                     if (var2 < 1L) {
                        break label110;
                     }

                     var7 = a(var10000, var20 ^ var2);
                     if (var5 == 0) {
                        continue label179;
                     }
                  }

                  var10000 = 53852654 ^ 53861443;
                  var20 = -3669793635681212573L ^ -3581622703704156426L;
                  var10002 = var2;
               }

               var10000 = a(var10000, var20 ^ var10002);
            }

            var7 = var10000;
            var10000 = var5;
         } while (var2 <= 0L);

         if (var10000 != 0) {
            return var4;
         }
      }
   }

   private static double l(JsonObject var0, String var1, double var2, long var4) {
      double var7 = 0.0;
      int var10000 = oc151419fdfe.v;
      int var9 = a(-1326705820 ^ -1326692550, -6151145948291121641L ^ -8737126141630541120L ^ var4);
      byte var6 = (byte)var10000;

      label175:
      while (true) {
         var10000 = var9;

         label168:
         while (true) {
            switch (var10000) {
               case -942622558:
                  label158: {
                     label183: {
                        label156: {
                           long var22;
                           label155: {
                              label184: {
                                 try {
                                    var10000 = var0.has(var1);
                                    if (var4 < 1L) {
                                       break label183;
                                    }

                                    if (var6 != 0) {
                                       break label156;
                                    }

                                    if (var10000 == 0) {
                                       break label184;
                                    }
                                 } catch (RuntimeException var13) {
                                    throw var13;
                                 }

                                 var10000 = -1326695494 ^ -1326692550;
                                 var22 = -7288264811018610985L ^ -8737126141630541120L;
                                 if (var4 < 0L) {
                                    break label155;
                                 }

                                 var9 = a(var10000, var22 ^ var4);
                                 if (var6 == 0) {
                                    continue label175;
                                 }
                              }

                              var10000 = -1326688918 ^ -1326692550;
                              var22 = -1441268648462288778L ^ -8737126141630541120L ^ var4;
                           }

                           var10000 = a(var10000, var22);
                        }

                        var9 = var10000;
                        if (var4 <= 1L) {
                           break label158;
                        }

                        var10000 = var6;
                     }

                     if (var10000 == 0) {
                        continue label175;
                     }
                  }
               case 1221027960:
                  label180: {
                     label135: {
                        label134: {
                           label181: {
                              try {
                                 var10000 = var0.get(var1).isJsonPrimitive();
                                 if (var4 < 0L) {
                                    break label180;
                                 }

                                 if (var6 != 0) {
                                    break label135;
                                 }

                                 if (var10000 == 0) {
                                    break label181;
                                 }
                              } catch (RuntimeException var12) {
                                 throw var12;
                              }

                              var10000 = -1326680565 ^ -1326692550;
                              if (var4 <= 1L) {
                                 break label134;
                              }

                              var9 = a(var10000, -5083458816696591550L ^ -8737126141630541120L ^ var4);
                              if (var6 == 0) {
                                 continue label175;
                              }
                           }

                           var10000 = -1326688918 ^ -1326692550;
                        }

                        var10000 = a(var10000, -1441268648462288778L ^ -8737126141630541120L ^ var4);
                     }

                     var9 = var10000;
                     if (var4 <= 1L) {
                        break label168;
                     }

                     var10000 = var6;
                  }

                  if (var10000 == 0) {
                     continue label175;
                  }
                  break;
               case -250519007:
                  label111: {
                     label110: {
                        long var10001;
                        long var10002;
                        label109: {
                           label186: {
                              try {
                                 var10000 = var0.getAsJsonPrimitive(var1).isNumber();
                                 if (var4 <= 1L) {
                                    break label111;
                                 }

                                 if (var6 != 0) {
                                    break label110;
                                 }

                                 if (var10000 != 0) {
                                    break label186;
                                 }
                              } catch (RuntimeException var11) {
                                 throw var11;
                              }

                              var10000 = -1326683198 ^ -1326692550;
                              var10001 = -4802578001753061651L ^ -8737126141630541120L;
                              var10002 = var4;
                              if (var4 < 0L) {
                                 break label109;
                              }

                              var9 = a(var10000, var10001 ^ var4);
                              if (var6 == 0) {
                                 continue label175;
                              }
                           }

                           var10000 = -1326682642 ^ -1326692550;
                           var10001 = -47566476368920438L ^ -8737126141630541120L;
                           var10002 = var4;
                        }

                        var10000 = a(var10000, var10001 ^ var10002);
                     }

                     var9 = var10000;
                     var10000 = var6;
                  }

                  if (var4 > 0L) {
                     if (var10000 == 0) {
                        continue label175;
                     }

                     return var2;
                  }
                  continue;
               case 136904678:
                  return var2;
               case 1620195263:
                  break;
               case 1638790094:
                  return var7;
               case 1655475118:
                  return var2;
               default:
                  throw null;
            }

            var7 = var0.getAsJsonPrimitive(var1).getAsDouble();
            break;
         }

         label91: {
            label90: {
               label89: {
                  label188: {
                     try {
                        var20 = var6;
                        if (var4 < 1L) {
                           break label91;
                        }

                        if (var6 != 0) {
                           break label90;
                        }

                        var10000 = Double.isFinite(var7);
                        if (var4 < 1L) {
                           break label89;
                        }

                        if (var10000 == 0) {
                           break label188;
                        }
                     } catch (RuntimeException var10) {
                        throw var10;
                     }

                     var10000 = -1326692897 ^ -1326692550;
                     if (var4 <= 0L) {
                        break label89;
                     }

                     var9 = a(var10000, -595776234958985008L ^ -8737126141630541120L ^ var4);
                     if (var6 == 0) {
                        continue;
                     }
                  }

                  var10000 = a(-1326708385 ^ -1326692550, -3774313705484671904L ^ -8737126141630541120L ^ var4);
               }

               var9 = var10000;
            }

            var20 = var6;
         }

         if (var20 != 0) {
            return var7;
         }
      }
   }

   private static JsonObject ʂ(oc69da1aa7f5 var0, long var1) {
      JsonObject var4 = null;
      int var10000 = oc151419fdfe.v;
      int var5 = a(-1375252153 ^ -1375257385, 6290005073205528063L ^ 8301933078942901312L ^ var1);
      byte var3 = (byte)var10000;

      while (true) {
         switch (var5) {
            case 155237677:
               var4 = new JsonObject();

               label51: {
                  label50: {
                     label49: {
                        label65: {
                           try {
                              var10000 = var3;
                              if (var1 < 1L) {
                                 break label51;
                              }

                              var4.addProperty(
                                 a(
                                    (256074347 ^ -1375257385) + -((char)(1375251830 ^ -1375257385)),
                                    (-256074349 ^ -1375257385) + (char)(1375248522 ^ -1375257385),
                                    (int)var1
                                 ),
                                 var0.z$3i8m9vxwuvqj0()
                              );
                              if (var3 != 0) {
                                 break label50;
                              }

                              var10000 = var0.ȭ;
                              if (var1 <= 1L) {
                                 break label49;
                              }

                              if (!var0.ȭ) {
                                 break label65;
                              }
                           } catch (RuntimeException var6) {
                              throw var6;
                           }

                           var10000 = a(-1375268742 ^ -1375257385, 6071665005400147097L ^ 8301933078942901312L ^ var1);
                           if (var1 < 1L) {
                              break label49;
                           }

                           var5 = var10000;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var10000 = a(-1375246227 ^ -1375257385, 6959939985560255628L ^ 8301933078942901312L ^ var1);
                     }

                     var5 = var10000;
                  }

                  var10000 = var3;
               }

               if (var1 <= 1L) {
                  break;
               }

               if (var10000 == 0) {
                  continue;
               }
            case 1526858995:
               var4.addProperty(
                  a((256074347 ^ -1375257385) + -((char)(1375251886 ^ -1375257385)), (256074347 ^ -1375257385) + -((char)(1375241415 ^ -1375257385)), (int)var1),
                  var0.z$3rzb3dil7uydr()
               );
               var10000 = -1375249029 ^ -1375257385;
               var4.addProperty(
                  a((256074347 ^ -1375257385) + -((char)(1375251896 ^ -1375257385)), (256074347 ^ -1375257385) + -((char)(1375250763 ^ -1375257385)), (int)var1),
                  var0.լ()
               );
               long var10001 = 8404196508120091080L ^ 8301933078942901312L ^ var1;
               var4.addProperty(
                  a((256074347 ^ -1375257385) + -((char)(1375251812 ^ -1375257385)), (256074347 ^ -1375257385) + (1375251184 ^ -1375257385), (int)var1),
                  var0.ɽ()
               );
               var4.addProperty(
                  a((256074347 ^ -1375257385) + -((char)(1375251834 ^ -1375257385)), (256074347 ^ -1375257385) + -((char)(1375243559 ^ -1375257385)), (int)var1),
                  var0.ŷ()
               );
               var10000 = a(var10000, var10001);
               break;
            case 175968652:
               return var4;
            default:
               throw null;
         }

         var5 = var10000;
      }
   }

   public String ˢ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oc7d9b6bd5c4.ό Ljava/io/File;
      // 08: invokevirtual java/io/File.isFile ()Z
      // 0b: ifne 12
      // 0e: ldc "default"
      // 10: areturn
      // 11: athrow
      // 12: new java/lang/String
      // 15: dup
      // 16: aload 0
      // 17: getfield x/oc7d9b6bd5c4.ό Ljava/io/File;
      // 1a: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 1d: invokestatic java/nio/file/Files.readAllBytes (Ljava/nio/file/Path;)[B
      // 20: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 23: invokespecial java/lang/String.<init> ([BLjava/nio/charset/Charset;)V
      // 26: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 29: astore 2
      // 2a: aload 2
      // 2b: iload 1
      // 2c: ifne 3f
      // 2f: invokevirtual java/lang/String.isEmpty ()Z
      // 32: ifeq 42
      // 35: goto 39
      // 38: athrow
      // 39: ldc "default"
      // 3b: goto 3f
      // 3e: athrow
      // 3f: goto 43
      // 42: aload 2
      // 43: areturn
      // 44: astore 2
      // 45: getstatic x/oc7ab2161b9f.ô Lorg/apache/logging/log4j/Logger;
      // 48: ldc_w "Unable to read selected config name"
      // 4b: aload 2
      // 4c: invokeinterface org/apache/logging/log4j/Logger.warn (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 51: ldc "default"
      // 53: areturn
   }

   private void ͻ(String var1, long var2) {
      try {
         Files.write(this.ό.toPath(), var1.getBytes(StandardCharsets.UTF_8));
      } catch (IOException var5) {
         Logger var10000 = oc7ab2161b9f.ô;
         String var10001 = a(
            (-1564565869 ^ -762375843) + (char)(762369167 ^ -762375843), (1564565871 ^ -762375843) + -((char)(762366780 ^ -762375843)), (int)var2
         );
         Object[] var10002 = new Object[-762375841 ^ -762375843];
         var10002[0] = var1;
         var10002[1] = var5;
         var10000.error(var10001, var10002);
      }
   }

   public boolean б(String var1) {
      long var2 = 2254660386145225923L ^ 2254748441545275826L;
      long var4 = var2 ^ 2254715749750772273L ^ 2254748441545275826L;
      return this.ʤ(var1, true, var4);
   }

   private boolean ʤ(String param1, boolean param2, long param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 0000: lload 3
      // 0001: dup2
      // 0002: ldc2_w -930534658019895050
      // 0005: ldc2_w -930440742247705406
      // 0008: lxor
      // 0009: lxor
      // 000a: lstore 5
      // 000c: dup2
      // 000d: ldc2_w -930550784256899924
      // 0010: ldc2_w -930440742247705406
      // 0013: lxor
      // 0014: lxor
      // 0015: lstore 7
      // 0017: dup2
      // 0018: ldc2_w -930446224022571990
      // 001b: ldc2_w -930440742247705406
      // 001e: lxor
      // 001f: lxor
      // 0020: lstore 9
      // 0022: dup2
      // 0023: ldc2_w -930553370645327867
      // 0026: ldc2_w -930440742247705406
      // 0029: lxor
      // 002a: lxor
      // 002b: lstore 11
      // 002d: dup2
      // 002e: ldc2_w -930527840795898575
      // 0031: ldc2_w -930440742247705406
      // 0034: lxor
      // 0035: lxor
      // 0036: lstore 13
      // 0038: dup2
      // 0039: ldc2_w -930445650787526575
      // 003c: ldc2_w -930440742247705406
      // 003f: lxor
      // 0040: lxor
      // 0041: lstore 15
      // 0043: dup2
      // 0044: ldc2_w -930539736774462914
      // 0047: ldc2_w -930440742247705406
      // 004a: lxor
      // 004b: lxor
      // 004c: dup2
      // 004d: ldc_w -421416234
      // 0050: ldc_w -421416218
      // 0053: ixor
      // 0054: lushr
      // 0055: l2i
      // 0056: istore 17
      // 0058: dup2
      // 0059: ldc_w -421416202
      // 005c: ldc_w -421416218
      // 005f: ixor
      // 0060: lshl
      // 0061: ldc_w -421416250
      // 0064: ldc_w -421416218
      // 0067: ixor
      // 0068: lushr
      // 0069: l2i
      // 006a: istore 18
      // 006c: dup2
      // 006d: ldc_w -421416234
      // 0070: ldc_w -421416218
      // 0073: ixor
      // 0074: lshl
      // 0075: ldc_w -421416234
      // 0078: ldc_w -421416218
      // 007b: ixor
      // 007c: lushr
      // 007d: l2i
      // 007e: istore 19
      // 0080: pop2
      // 0081: pop2
      // 0082: getstatic x/oc151419fdfe.v Z
      // 0085: istore 21
      // 0087: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 008a: iload 21
      // 008c: ifne 0099
      // 008f: ifnull 009c
      // 0092: goto 0096
      // 0095: athrow
      // 0096: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 0099: invokevirtual x/oc46245c2b20.Ϋ ()V
      // 009c: aload 0
      // 009d: aload 1
      // 009e: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 00a1: astore 22
      // 00a3: aload 22
      // 00a5: iload 21
      // 00a7: ifne 00b3
      // 00aa: ifnull 00b9
      // 00ad: goto 00b1
      // 00b0: athrow
      // 00b1: aload 22
      // 00b3: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 00b6: goto 00c0
      // 00b9: aload 0
      // 00ba: aload 1
      // 00bb: lload 7
      // 00bd: invokevirtual x/oc7d9b6bd5c4.ǵ (Ljava/lang/String;J)Ljava/lang/String;
      // 00c0: astore 23
      // 00c2: bipush 0
      // 00c3: istore 24
      // 00c5: aload 0
      // 00c6: invokevirtual x/oc7d9b6bd5c4.ž ()Ljava/util/List;
      // 00c9: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 00ce: astore 25
      // 00d0: aload 25
      // 00d2: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 00d7: ifeq 15c3
      // 00da: aload 25
      // 00dc: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 00e1: checkcast java/io/File
      // 00e4: astore 26
      // 00e6: iload 21
      // 00e8: ifne 1600
      // 00eb: aload 26
      // 00ed: lload 3
      // 00ee: lconst_0
      // 00ef: lcmp
      // 00f0: iflt 0182
      // 00f3: iload 21
      // 00f5: ifne 0182
      // 00f8: goto 00fc
      // 00fb: athrow
      // 00fc: invokevirtual java/io/File.exists ()Z
      // 00ff: ifne 0180
      // 0102: goto 0106
      // 0105: athrow
      // 0106: aload 0
      // 0107: ldc_w -1324213526
      // 010a: ldc_w -421416218
      // 010d: ixor
      // 010e: ldc_w 421413798
      // 0111: ldc_w -421416218
      // 0114: ixor
      // 0115: i2c
      // 0116: iadd
      // 0117: ldc_w -1324082452
      // 011a: ldc_w -421416218
      // 011d: ixor
      // 011e: ldc_w 421423836
      // 0121: ldc_w -421416218
      // 0124: ixor
      // 0125: i2c
      // 0126: isub
      // 0127: lload 3
      // 0128: l2i
      // 0129: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 012c: aload 23
      // 012e: invokevirtual x/oc7d9b6bd5c4.ի (Ljava/lang/String;Ljava/lang/String;)V
      // 0131: getstatic java/lang/System.out Ljava/io/PrintStream;
      // 0134: aload 23
      // 0136: ldc_w -1324213526
      // 0139: ldc_w -421416218
      // 013c: ixor
      // 013d: ldc_w 421413849
      // 0140: ldc_w -421416218
      // 0143: ixor
      // 0144: i2c
      // 0145: iadd
      // 0146: ldc_w 1324082448
      // 0149: ldc_w -421416218
      // 014c: ixor
      // 014d: ldc_w 421403802
      // 0150: ldc_w -421416218
      // 0153: ixor
      // 0154: i2c
      // 0155: ineg
      // 0156: isub
      // 0157: lload 3
      // 0158: l2i
      // 0159: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 015c: swap
      // 015d: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0162: invokevirtual java/io/PrintStream.println (Ljava/lang/String;)V
      // 0165: bipush 0
      // 0166: istore 27
      // 0168: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 016b: iload 21
      // 016d: ifne 017a
      // 0170: ifnull 017d
      // 0173: goto 0177
      // 0176: athrow
      // 0177: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 017a: invokevirtual x/oc46245c2b20.ё ()V
      // 017d: iload 27
      // 017f: ireturn
      // 0180: aload 26
      // 0182: iload 21
      // 0184: ifne 01da
      // 0187: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // 018a: aload 23
      // 018c: ldc_w -1324213526
      // 018f: ldc_w -421416218
      // 0192: ixor
      // 0193: ldc_w 421413869
      // 0196: ldc_w -421416218
      // 0199: ixor
      // 019a: i2c
      // 019b: iadd
      // 019c: ldc_w -1324213526
      // 019f: ldc_w -421416218
      // 01a2: ixor
      // 01a3: ldc_w 421424627
      // 01a6: ldc_w -421416218
      // 01a9: ixor
      // 01aa: i2c
      // 01ab: iadd
      // 01ac: lload 3
      // 01ad: l2i
      // 01ae: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 01b1: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 01b6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 01b9: lload 3
      // 01ba: lconst_1
      // 01bb: lcmp
      // 01bc: iflt 01d6
      // 01bf: ifne 01d5
      // 01c2: goto 01c6
      // 01c5: athrow
      // 01c6: iload 21
      // 01c8: ifeq 00d0
      // 01cb: lload 3
      // 01cc: lconst_0
      // 01cd: lcmp
      // 01ce: iflt 00e6
      // 01d1: goto 01d5
      // 01d4: athrow
      // 01d5: bipush 1
      // 01d6: istore 24
      // 01d8: aload 26
      // 01da: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 01dd: invokestatic x/oc0326f6e039.È (Ljava/nio/file/Path;)Lcom/google/gson/JsonObject;
      // 01e0: astore 27
      // 01e2: aload 27
      // 01e4: ldc_w -1324213526
      // 01e7: ldc_w -421416218
      // 01ea: ixor
      // 01eb: ldc_w 421413803
      // 01ee: ldc_w -421416218
      // 01f1: ixor
      // 01f2: i2c
      // 01f3: iadd
      // 01f4: ldc_w 1324213522
      // 01f7: ldc_w -421416218
      // 01fa: ixor
      // 01fb: ldc_w 421418852
      // 01fe: ldc_w -421416218
      // 0201: ixor
      // 0202: i2c
      // 0203: ineg
      // 0204: iadd
      // 0205: lload 3
      // 0206: l2i
      // 0207: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 020a: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 020d: astore 28
      // 020f: aload 27
      // 0211: invokestatic x/U.Ѕ (Lcom/google/gson/JsonObject;)Ljava/lang/String;
      // 0214: astore 29
      // 0216: aload 27
      // 0218: invokestatic x/U.ʖ (Lcom/google/gson/JsonObject;)Z
      // 021b: istore 30
      // 021d: aload 0
      // 021e: invokevirtual x/oc7d9b6bd5c4.α ()Ljava/util/List;
      // 0221: astore 31
      // 0223: aload 0
      // 0224: aload 31
      // 0226: lload 11
      // 0228: invokevirtual x/oc7d9b6bd5c4.ś (Ljava/util/List;J)Ljava/util/Map;
      // 022b: astore 32
      // 022d: new java/util/LinkedHashMap
      // 0230: dup
      // 0231: invokespecial java/util/LinkedHashMap.<init> ()V
      // 0234: astore 33
      // 0236: bipush 0
      // 0237: istore 34
      // 0239: bipush 0
      // 023a: istore 35
      // 023c: aload 0
      // 023d: aload 27
      // 023f: lload 13
      // 0241: ldc_w -1324213526
      // 0244: ldc_w -421416218
      // 0247: ixor
      // 0248: ldc_w 421413857
      // 024b: ldc_w -421416218
      // 024e: ixor
      // 024f: i2c
      // 0250: iadd
      // 0251: ldc_w -1324082452
      // 0254: ldc_w -421416218
      // 0257: ixor
      // 0258: ldc_w 421420388
      // 025b: ldc_w -421416218
      // 025e: ixor
      // 025f: i2c
      // 0260: isub
      // 0261: lload 3
      // 0262: l2i
      // 0263: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0266: invokevirtual x/oc7d9b6bd5c4.զ (Lcom/google/gson/JsonObject;JLjava/lang/String;)Ljava/util/Map;
      // 0269: astore 36
      // 026b: aload 27
      // 026d: iload 21
      // 026f: lload 3
      // 0270: lconst_0
      // 0271: lcmp
      // 0272: iflt 0288
      // 0275: ifne 02d7
      // 0278: ldc_w -1324213526
      // 027b: ldc_w -421416218
      // 027e: ixor
      // 027f: ldc_w 421413401
      // 0282: ldc_w -421416218
      // 0285: ixor
      // 0286: i2c
      // 0287: iadd
      // 0288: ldc_w 1324082448
      // 028b: ldc_w -421416218
      // 028e: ixor
      // 028f: ldc_w 421396489
      // 0292: ldc_w -421416218
      // 0295: ixor
      // 0296: i2c
      // 0297: ineg
      // 0298: isub
      // 0299: lload 3
      // 029a: l2i
      // 029b: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 029e: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 02a1: ifeq 02dd
      // 02a4: goto 02a8
      // 02a7: athrow
      // 02a8: aload 27
      // 02aa: ldc_w -1324213526
      // 02ad: ldc_w -421416218
      // 02b0: ixor
      // 02b1: ldc_w 421413856
      // 02b4: ldc_w -421416218
      // 02b7: ixor
      // 02b8: i2c
      // 02b9: iadd
      // 02ba: ldc_w 1324082448
      // 02bd: ldc_w -421416218
      // 02c0: ixor
      // 02c1: ldc_w 421422794
      // 02c4: ldc_w -421416218
      // 02c7: ixor
      // 02c8: i2c
      // 02c9: ineg
      // 02ca: isub
      // 02cb: lload 3
      // 02cc: l2i
      // 02cd: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 02d0: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 02d3: goto 02d7
      // 02d6: athrow
      // 02d7: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 02da: goto 02de
      // 02dd: bipush 1
      // 02de: istore 37
      // 02e0: iload 37
      // 02e2: lload 3
      // 02e3: lconst_0
      // 02e4: lcmp
      // 02e5: iflt 0306
      // 02e8: iload 21
      // 02ea: ifne 0306
      // 02ed: ldc_w -421416219
      // 02f0: ldc_w -421416218
      // 02f3: ixor
      // 02f4: if_icmpge 0304
      // 02f7: goto 02fb
      // 02fa: athrow
      // 02fb: aload 28
      // 02fd: invokestatic x/oc7d9b6bd5c4.Ћ (Lcom/google/gson/JsonArray;)V
      // 0300: goto 0304
      // 0303: athrow
      // 0304: iload 37
      // 0306: ldc_w -421400865
      // 0309: ldc_w -421416218
      // 030c: ixor
      // 030d: ldc2_w -8287306395010248559
      // 0310: ldc2_w -930440742247705406
      // 0313: lxor
      // 0314: lload 3
      // 0315: lxor
      // 0316: invokestatic x/oc7d9b6bd5c4.a (IJ)I
      // 0319: if_icmpge 0325
      // 031c: aload 28
      // 031e: invokestatic x/oc7d9b6bd5c4.Ƶ (Lcom/google/gson/JsonArray;)V
      // 0321: goto 0325
      // 0324: athrow
      // 0325: aload 28
      // 0327: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 032a: astore 38
      // 032c: aload 38
      // 032e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0333: ifeq 06fa
      // 0336: aload 38
      // 0338: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 033d: iload 21
      // 033f: ifne 1436
      // 0342: checkcast com/google/gson/JsonElement
      // 0345: astore 39
      // 0347: aload 39
      // 0349: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 034c: astore 40
      // 034e: aload 40
      // 0350: iload 21
      // 0352: lload 3
      // 0353: lconst_0
      // 0354: lcmp
      // 0355: iflt 036b
      // 0358: ifne 03b8
      // 035b: ldc_w -1324213526
      // 035e: ldc_w -421416218
      // 0361: ixor
      // 0362: ldc_w 421413859
      // 0365: ldc_w -421416218
      // 0368: ixor
      // 0369: i2c
      // 036a: iadd
      // 036b: ldc_w -1324082452
      // 036e: ldc_w -421416218
      // 0371: ixor
      // 0372: ldc_w 421416863
      // 0375: ldc_w -421416218
      // 0378: ixor
      // 0379: i2c
      // 037a: isub
      // 037b: lload 3
      // 037c: l2i
      // 037d: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0380: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0383: ifeq 03be
      // 0386: goto 038a
      // 0389: athrow
      // 038a: aload 40
      // 038c: ldc_w -1324213526
      // 038f: ldc_w -421416218
      // 0392: ixor
      // 0393: ldc_w 421413859
      // 0396: ldc_w -421416218
      // 0399: ixor
      // 039a: i2c
      // 039b: iadd
      // 039c: ldc_w -1324082452
      // 039f: ldc_w -421416218
      // 03a2: ixor
      // 03a3: ldc_w 421416863
      // 03a6: ldc_w -421416218
      // 03a9: ixor
      // 03aa: i2c
      // 03ab: isub
      // 03ac: lload 3
      // 03ad: l2i
      // 03ae: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 03b1: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 03b4: goto 03b8
      // 03b7: athrow
      // 03b8: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 03bb: goto 03c1
      // 03be: ldc_w ""
      // 03c1: astore 41
      // 03c3: aload 41
      // 03c5: lload 3
      // 03c6: lconst_0
      // 03c7: lcmp
      // 03c8: ifle 03d9
      // 03cb: iload 21
      // 03cd: ifne 03d9
      // 03d0: ifnull 032c
      // 03d3: goto 03d7
      // 03d6: athrow
      // 03d7: aload 41
      // 03d9: invokevirtual java/lang/String.isEmpty ()Z
      // 03dc: lload 3
      // 03dd: lconst_0
      // 03de: lcmp
      // 03df: iflt 0437
      // 03e2: iload 21
      // 03e4: ifne 0437
      // 03e7: ifeq 03fd
      // 03ea: goto 03ee
      // 03ed: athrow
      // 03ee: iload 21
      // 03f0: lload 3
      // 03f1: lconst_1
      // 03f2: lcmp
      // 03f3: ifle 0333
      // 03f6: ifeq 032c
      // 03f9: goto 03fd
      // 03fc: athrow
      // 03fd: aload 40
      // 03ff: iload 21
      // 0401: lload 3
      // 0402: lconst_0
      // 0403: lcmp
      // 0404: ifle 041a
      // 0407: ifne 0469
      // 040a: ldc_w -1324213526
      // 040d: ldc_w -421416218
      // 0410: ixor
      // 0411: ldc_w 421413860
      // 0414: ldc_w -421416218
      // 0417: ixor
      // 0418: i2c
      // 0419: iadd
      // 041a: ldc_w 1324213522
      // 041d: ldc_w -421416218
      // 0420: ixor
      // 0421: ldc_w 421414495
      // 0424: ldc_w -421416218
      // 0427: ixor
      // 0428: i2c
      // 0429: ineg
      // 042a: iadd
      // 042b: lload 3
      // 042c: l2i
      // 042d: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0430: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0433: goto 0437
      // 0436: athrow
      // 0437: ifeq 0472
      // 043a: aload 40
      // 043c: ldc_w -1324213526
      // 043f: ldc_w -421416218
      // 0442: ixor
      // 0443: ldc_w 421413860
      // 0446: ldc_w -421416218
      // 0449: ixor
      // 044a: i2c
      // 044b: iadd
      // 044c: ldc_w 1324213522
      // 044f: ldc_w -421416218
      // 0452: ixor
      // 0453: ldc_w 421414495
      // 0456: ldc_w -421416218
      // 0459: ixor
      // 045a: i2c
      // 045b: ineg
      // 045c: iadd
      // 045d: lload 3
      // 045e: l2i
      // 045f: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0462: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0465: goto 0469
      // 0468: athrow
      // 0469: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 046c: invokestatic x/oc9755810e45.ƭ (Ljava/lang/String;)Lx/oc69da1aa7f5;
      // 046f: goto 0473
      // 0472: aconst_null
      // 0473: astore 42
      // 0475: aload 42
      // 0477: lload 3
      // 0478: lconst_1
      // 0479: lcmp
      // 047a: iflt 0496
      // 047d: iload 21
      // 047f: ifne 0496
      // 0482: ifnonnull 0494
      // 0485: goto 0489
      // 0488: athrow
      // 0489: getstatic x/oc2cf3d80e17.ļ Lx/oc9755810e45;
      // 048c: pop
      // 048d: aload 41
      // 048f: invokestatic x/oc9755810e45.Ո (Ljava/lang/String;)Lx/oc69da1aa7f5;
      // 0492: astore 42
      // 0494: aload 42
      // 0496: iload 21
      // 0498: ifne 04c8
      // 049b: ifnonnull 04b1
      // 049e: goto 04a2
      // 04a1: athrow
      // 04a2: iload 21
      // 04a4: lload 3
      // 04a5: lconst_0
      // 04a6: lcmp
      // 04a7: ifle 0333
      // 04aa: ifeq 032c
      // 04ad: goto 04b1
      // 04b0: athrow
      // 04b1: aload 33
      // 04b3: aload 42
      // 04b5: aload 40
      // 04b7: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 04bc: iload 21
      // 04be: ifne 04e1
      // 04c1: pop
      // 04c2: aload 42
      // 04c4: goto 04c8
      // 04c7: athrow
      // 04c8: invokevirtual x/oc69da1aa7f5.canBeEnabled ()Z
      // 04cb: lload 3
      // 04cc: lconst_1
      // 04cd: lcmp
      // 04ce: iflt 06f7
      // 04d1: ifeq 06f5
      // 04d4: aload 32
      // 04d6: aload 42
      // 04d8: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 04dd: goto 04e1
      // 04e0: athrow
      // 04e1: checkcast x/oca04ceef104
      // 04e4: astore 43
      // 04e6: iload 21
      // 04e8: ifne 04ff
      // 04eb: aload 43
      // 04ed: ifnonnull 050b
      // 04f0: goto 04f4
      // 04f3: athrow
      // 04f4: new x/oca04ceef104
      // 04f7: dup
      // 04f8: bipush 0
      // 04f9: bipush 0
      // 04fa: invokespecial x/oca04ceef104.<init> (ZI)V
      // 04fd: astore 43
      // 04ff: aload 32
      // 0501: aload 42
      // 0503: aload 43
      // 0505: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 050a: pop
      // 050b: aload 40
      // 050d: ldc_w -1324213526
      // 0510: ldc_w -421416218
      // 0513: ixor
      // 0514: ldc_w 421413807
      // 0517: ldc_w -421416218
      // 051a: ixor
      // 051b: i2c
      // 051c: iadd
      // 051d: ldc_w -1324213526
      // 0520: ldc_w -421416218
      // 0523: ixor
      // 0524: ldc_w 421420294
      // 0527: ldc_w -421416218
      // 052a: ixor
      // 052b: i2c
      // 052c: iadd
      // 052d: lload 3
      // 052e: l2i
      // 052f: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0532: lload 3
      // 0533: lconst_1
      // 0534: lcmp
      // 0535: iflt 05b3
      // 0538: iload 21
      // 053a: ifne 05b3
      // 053d: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0540: ifeq 057d
      // 0543: goto 0547
      // 0546: athrow
      // 0547: aload 43
      // 0549: aload 40
      // 054b: ldc_w -1324213526
      // 054e: ldc_w -421416218
      // 0551: ixor
      // 0552: ldc_w 421413807
      // 0555: ldc_w -421416218
      // 0558: ixor
      // 0559: i2c
      // 055a: iadd
      // 055b: ldc_w -1324213526
      // 055e: ldc_w -421416218
      // 0561: ixor
      // 0562: ldc_w 421420294
      // 0565: ldc_w -421416218
      // 0568: ixor
      // 0569: i2c
      // 056a: iadd
      // 056b: lload 3
      // 056c: l2i
      // 056d: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0570: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0573: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 0576: putfield x/oca04ceef104.Σ Z
      // 0579: goto 057d
      // 057c: athrow
      // 057d: aload 40
      // 057f: lload 3
      // 0580: lconst_0
      // 0581: lcmp
      // 0582: iflt 061a
      // 0585: iload 21
      // 0587: ifne 061a
      // 058a: ldc_w -1324213526
      // 058d: ldc_w -421416218
      // 0590: ixor
      // 0591: ldc_w 421413406
      // 0594: ldc_w -421416218
      // 0597: ixor
      // 0598: i2c
      // 0599: iadd
      // 059a: ldc_w -1324082452
      // 059d: ldc_w -421416218
      // 05a0: ixor
      // 05a1: ldc_w 421424043
      // 05a4: ldc_w -421416218
      // 05a7: ixor
      // 05a8: i2c
      // 05a9: isub
      // 05aa: lload 3
      // 05ab: l2i
      // 05ac: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 05af: goto 05b3
      // 05b2: athrow
      // 05b3: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 05b6: lload 3
      // 05b7: lconst_1
      // 05b8: lcmp
      // 05b9: iflt 05ff
      // 05bc: ifeq 0618
      // 05bf: aload 43
      // 05c1: aload 40
      // 05c3: ldc_w -1324213526
      // 05c6: ldc_w -421416218
      // 05c9: ixor
      // 05ca: ldc_w 421413406
      // 05cd: ldc_w -421416218
      // 05d0: ixor
      // 05d1: i2c
      // 05d2: iadd
      // 05d3: ldc_w -1324082452
      // 05d6: ldc_w -421416218
      // 05d9: ixor
      // 05da: ldc_w 421424043
      // 05dd: ldc_w -421416218
      // 05e0: ixor
      // 05e1: i2c
      // 05e2: isub
      // 05e3: lload 3
      // 05e4: l2i
      // 05e5: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 05e8: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 05eb: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 05ee: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 05f1: putfield x/oca04ceef104.ӳ Ljava/lang/Boolean;
      // 05f4: iinc 34 1
      // 05f7: aload 43
      // 05f9: getfield x/oca04ceef104.ӳ Ljava/lang/Boolean;
      // 05fc: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 05ff: lload 3
      // 0600: lconst_1
      // 0601: lcmp
      // 0602: ifle 0651
      // 0605: iload 21
      // 0607: ifne 0651
      // 060a: goto 060e
      // 060d: athrow
      // 060e: ifne 0618
      // 0611: goto 0615
      // 0614: athrow
      // 0615: bipush 1
      // 0616: istore 35
      // 0618: aload 40
      // 061a: ldc_w -1324213526
      // 061d: ldc_w -421416218
      // 0620: ixor
      // 0621: ldc_w 421413875
      // 0624: ldc_w -421416218
      // 0627: ixor
      // 0628: i2c
      // 0629: iadd
      // 062a: ldc_w -1324082452
      // 062d: ldc_w -421416218
      // 0630: ixor
      // 0631: ldc_w 421417575
      // 0634: ldc_w -421416218
      // 0637: ixor
      // 0638: i2c
      // 0639: isub
      // 063a: lload 3
      // 063b: l2i
      // 063c: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 063f: lload 3
      // 0640: lconst_1
      // 0641: lcmp
      // 0642: ifle 06b2
      // 0645: iload 21
      // 0647: ifne 06b2
      // 064a: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 064d: goto 0651
      // 0650: athrow
      // 0651: ifeq 068a
      // 0654: aload 43
      // 0656: aload 40
      // 0658: ldc_w -1324213526
      // 065b: ldc_w -421416218
      // 065e: ixor
      // 065f: ldc_w 421413875
      // 0662: ldc_w -421416218
      // 0665: ixor
      // 0666: i2c
      // 0667: iadd
      // 0668: ldc_w -1324082452
      // 066b: ldc_w -421416218
      // 066e: ixor
      // 066f: ldc_w 421417575
      // 0672: ldc_w -421416218
      // 0675: ixor
      // 0676: i2c
      // 0677: isub
      // 0678: lload 3
      // 0679: l2i
      // 067a: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 067d: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0680: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 0683: putfield x/oca04ceef104.ĕ I
      // 0686: goto 068a
      // 0689: athrow
      // 068a: aload 40
      // 068c: ldc_w -1324213526
      // 068f: ldc_w -421416218
      // 0692: ixor
      // 0693: ldc_w 421413885
      // 0696: ldc_w -421416218
      // 0699: ixor
      // 069a: i2c
      // 069b: iadd
      // 069c: ldc_w 1324082448
      // 069f: ldc_w -421416218
      // 06a2: ixor
      // 06a3: ldc_w 421418497
      // 06a6: ldc_w -421416218
      // 06a9: ixor
      // 06aa: i2c
      // 06ab: ineg
      // 06ac: isub
      // 06ad: lload 3
      // 06ae: l2i
      // 06af: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 06b2: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 06b5: lload 3
      // 06b6: lconst_1
      // 06b7: lcmp
      // 06b8: ifle 06f7
      // 06bb: ifeq 06f5
      // 06be: aload 43
      // 06c0: aload 40
      // 06c2: ldc_w -1324213526
      // 06c5: ldc_w -421416218
      // 06c8: ixor
      // 06c9: ldc_w 421413885
      // 06cc: ldc_w -421416218
      // 06cf: ixor
      // 06d0: i2c
      // 06d1: iadd
      // 06d2: ldc_w 1324082448
      // 06d5: ldc_w -421416218
      // 06d8: ixor
      // 06d9: ldc_w 421418497
      // 06dc: ldc_w -421416218
      // 06df: ixor
      // 06e0: i2c
      // 06e1: ineg
      // 06e2: isub
      // 06e3: lload 3
      // 06e4: l2i
      // 06e5: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 06e8: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 06eb: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 06ee: putfield x/oca04ceef104.ͳ Z
      // 06f1: goto 06f5
      // 06f4: athrow
      // 06f5: iload 21
      // 06f7: ifeq 032c
      // 06fa: lload 3
      // 06fb: lconst_0
      // 06fc: lcmp
      // 06fd: ifle 14ac
      // 0700: iload 34
      // 0702: iload 21
      // 0704: ifne 0710
      // 0707: ifle 0765
      // 070a: goto 070e
      // 070d: athrow
      // 070e: iload 35
      // 0710: ifne 0765
      // 0713: aload 32
      // 0715: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 071a: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 071f: astore 38
      // 0721: aload 38
      // 0723: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0728: ifeq 0765
      // 072b: aload 38
      // 072d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0732: checkcast x/oca04ceef104
      // 0735: iload 21
      // 0737: ifne 1436
      // 073a: astore 39
      // 073c: aload 39
      // 073e: iload 21
      // 0740: lload 3
      // 0741: lconst_0
      // 0742: lcmp
      // 0743: ifle 075a
      // 0746: ifne 0759
      // 0749: getfield x/oca04ceef104.ӳ Ljava/lang/Boolean;
      // 074c: ifnull 0760
      // 074f: goto 0753
      // 0752: athrow
      // 0753: aload 39
      // 0755: goto 0759
      // 0758: athrow
      // 0759: bipush 0
      // 075a: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 075d: putfield x/oca04ceef104.ӳ Ljava/lang/Boolean;
      // 0760: iload 21
      // 0762: ifeq 0721
      // 0765: aload 31
      // 0767: lload 3
      // 0768: lconst_1
      // 0769: lcmp
      // 076a: iflt 0732
      // 076d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0772: astore 38
      // 0774: aload 38
      // 0776: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 077b: ifeq 07f6
      // 077e: aload 38
      // 0780: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0785: checkcast x/oc69da1aa7f5
      // 0788: astore 39
      // 078a: aload 32
      // 078c: lload 3
      // 078d: lconst_0
      // 078e: lcmp
      // 078f: iflt 079e
      // 0792: iload 21
      // 0794: ifne 1436
      // 0797: aload 39
      // 0799: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 079e: checkcast x/oca04ceef104
      // 07a1: astore 40
      // 07a3: aload 40
      // 07a5: lload 3
      // 07a6: lconst_0
      // 07a7: lcmp
      // 07a8: ifle 07c8
      // 07ab: iload 21
      // 07ad: ifne 07c8
      // 07b0: ifnonnull 07c6
      // 07b3: goto 07b7
      // 07b6: athrow
      // 07b7: iload 21
      // 07b9: lload 3
      // 07ba: lconst_0
      // 07bb: lcmp
      // 07bc: ifle 077b
      // 07bf: ifeq 0774
      // 07c2: goto 07c6
      // 07c5: athrow
      // 07c6: aload 40
      // 07c8: getfield x/oca04ceef104.Σ Z
      // 07cb: iload 21
      // 07cd: ifne 07e9
      // 07d0: ifne 07f1
      // 07d3: goto 07d7
      // 07d6: athrow
      // 07d7: aload 39
      // 07d9: iload 21
      // 07db: ifne 07ee
      // 07de: goto 07e2
      // 07e1: athrow
      // 07e2: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 07e5: goto 07e9
      // 07e8: athrow
      // 07e9: ifeq 07f1
      // 07ec: aload 39
      // 07ee: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 07f1: iload 21
      // 07f3: ifeq 0774
      // 07f6: lload 3
      // 07f7: lconst_1
      // 07f8: lcmp
      // 07f9: iflt 14ac
      // 07fc: aload 31
      // 07fe: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0803: astore 38
      // 0805: aload 38
      // 0807: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 080c: ifeq 0896
      // 080f: aload 38
      // 0811: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0816: checkcast x/oc69da1aa7f5
      // 0819: astore 39
      // 081b: iload 21
      // 081d: aload 32
      // 081f: aload 39
      // 0821: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0826: checkcast x/oca04ceef104
      // 0829: astore 40
      // 082b: lload 3
      // 082c: lconst_0
      // 082d: lcmp
      // 082e: ifle 0836
      // 0831: ifne 0878
      // 0834: iload 21
      // 0836: ifne 08aa
      // 0839: goto 083d
      // 083c: athrow
      // 083d: aload 40
      // 083f: ifnonnull 0855
      // 0842: goto 0846
      // 0845: athrow
      // 0846: iload 21
      // 0848: lload 3
      // 0849: lconst_0
      // 084a: lcmp
      // 084b: ifle 080c
      // 084e: ifeq 0805
      // 0851: goto 0855
      // 0854: athrow
      // 0855: aload 39
      // 0857: aload 40
      // 0859: lload 3
      // 085a: lconst_1
      // 085b: lcmp
      // 085c: iflt 086e
      // 085f: getfield x/oca04ceef104.ĕ I
      // 0862: iload 21
      // 0864: ifne 088e
      // 0867: invokevirtual x/oc69da1aa7f5.ӝ (I)V
      // 086a: aload 39
      // 086c: aload 40
      // 086e: getfield x/oca04ceef104.ͳ Z
      // 0871: invokevirtual x/oc69da1aa7f5.Ӂ (Z)V
      // 0874: goto 0878
      // 0877: athrow
      // 0878: aload 40
      // 087a: getfield x/oca04ceef104.ӳ Ljava/lang/Boolean;
      // 087d: ifnull 0891
      // 0880: aload 39
      // 0882: aload 40
      // 0884: getfield x/oca04ceef104.ӳ Ljava/lang/Boolean;
      // 0887: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 088a: goto 088e
      // 088d: athrow
      // 088e: invokevirtual x/oc69da1aa7f5.Ǥ (Z)V
      // 0891: iload 21
      // 0893: ifeq 0805
      // 0896: lload 3
      // 0897: lconst_1
      // 0898: lcmp
      // 0899: ifle 08aa
      // 089c: aload 33
      // 089e: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 08a3: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 08a8: astore 38
      // 08aa: aload 38
      // 08ac: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 08b1: ifeq 137d
      // 08b4: aload 38
      // 08b6: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08bb: checkcast java/util/Map$Entry
      // 08be: astore 39
      // 08c0: iload 21
      // 08c2: lload 3
      // 08c3: lconst_0
      // 08c4: lcmp
      // 08c5: iflt 1399
      // 08c8: aload 39
      // 08ca: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 08cf: checkcast x/oc69da1aa7f5
      // 08d2: astore 40
      // 08d4: ifne 138c
      // 08d7: aload 39
      // 08d9: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 08de: checkcast com/google/gson/JsonObject
      // 08e1: astore 41
      // 08e3: aload 40
      // 08e5: lload 3
      // 08e6: lconst_0
      // 08e7: lcmp
      // 08e8: ifle 0ce3
      // 08eb: iload 21
      // 08ed: ifne 0ce3
      // 08f0: instanceof x/ocd2958dac48
      // 08f3: ifeq 0cdd
      // 08f6: goto 08fa
      // 08f9: athrow
      // 08fa: aload 40
      // 08fc: checkcast x/ocd2958dac48
      // 08ff: astore 42
      // 0901: aload 41
      // 0903: ldc_w -1324213526
      // 0906: ldc_w -421416218
      // 0909: ixor
      // 090a: ldc_w 421413402
      // 090d: ldc_w -421416218
      // 0910: ixor
      // 0911: i2c
      // 0912: iadd
      // 0913: ldc_w 1324082448
      // 0916: ldc_w -421416218
      // 0919: ixor
      // 091a: ldc_w 421399333
      // 091d: ldc_w -421416218
      // 0920: ixor
      // 0921: i2c
      // 0922: ineg
      // 0923: isub
      // 0924: lload 3
      // 0925: l2i
      // 0926: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0929: lload 3
      // 092a: lconst_0
      // 092b: lcmp
      // 092c: ifle 09b2
      // 092f: iload 21
      // 0931: ifne 09b2
      // 0934: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0937: ifne 098b
      // 093a: goto 093e
      // 093d: athrow
      // 093e: aload 41
      // 0940: iload 21
      // 0942: lload 3
      // 0943: lconst_1
      // 0944: lcmp
      // 0945: iflt 099d
      // 0948: ifne 098d
      // 094b: goto 094f
      // 094e: athrow
      // 094f: ldc_w -1324213526
      // 0952: ldc_w -421416218
      // 0955: ixor
      // 0956: ldc_w 421413847
      // 0959: ldc_w -421416218
      // 095c: ixor
      // 095d: i2c
      // 095e: iadd
      // 095f: ldc_w 1324082448
      // 0962: ldc_w -421416218
      // 0965: ixor
      // 0966: ldc_w 421424499
      // 0969: ldc_w -421416218
      // 096c: ixor
      // 096d: i2c
      // 096e: ineg
      // 096f: isub
      // 0970: lload 3
      // 0971: l2i
      // 0972: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0975: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0978: ifne 098b
      // 097b: goto 097f
      // 097e: athrow
      // 097f: getstatic x/ocd2958dac48.Ć Lx/oca9cc61aada;
      // 0982: dconst_0
      // 0983: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 0986: pop2
      // 0987: goto 098b
      // 098a: athrow
      // 098b: aload 41
      // 098d: ldc_w -1324213526
      // 0990: ldc_w -421416218
      // 0993: ixor
      // 0994: ldc_w 421413882
      // 0997: ldc_w -421416218
      // 099a: ixor
      // 099b: i2c
      // 099c: iadd
      // 099d: ldc_w -1324213526
      // 09a0: ldc_w -421416218
      // 09a3: ixor
      // 09a4: ldc_w 421423357
      // 09a7: ldc_w -421416218
      // 09aa: ixor
      // 09ab: i2c
      // 09ac: iadd
      // 09ad: lload 3
      // 09ae: l2i
      // 09af: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 09b2: iload 21
      // 09b4: lload 3
      // 09b5: lconst_1
      // 09b6: lcmp
      // 09b7: ifle 0aa1
      // 09ba: ifne 0a9f
      // 09bd: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 09c0: ifeq 0a74
      // 09c3: goto 09c7
      // 09c6: athrow
      // 09c7: aload 41
      // 09c9: iload 21
      // 09cb: lload 3
      // 09cc: lconst_1
      // 09cd: lcmp
      // 09ce: iflt 0a8a
      // 09d1: ifne 0a7a
      // 09d4: goto 09d8
      // 09d7: athrow
      // 09d8: ldc_w -1324213526
      // 09db: ldc_w -421416218
      // 09de: ixor
      // 09df: ldc_w 421413850
      // 09e2: ldc_w -421416218
      // 09e5: ixor
      // 09e6: i2c
      // 09e7: iadd
      // 09e8: ldc_w 1324082448
      // 09eb: ldc_w -421416218
      // 09ee: ixor
      // 09ef: ldc_w 421403235
      // 09f2: ldc_w -421416218
      // 09f5: ixor
      // 09f6: i2c
      // 09f7: ineg
      // 09f8: isub
      // 09f9: lload 3
      // 09fa: l2i
      // 09fb: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 09fe: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0a01: ifeq 0a74
      // 0a04: goto 0a08
      // 0a07: athrow
      // 0a08: aload 41
      // 0a0a: ldc_w -1324213526
      // 0a0d: ldc_w -421416218
      // 0a10: ixor
      // 0a11: ldc_w 421413870
      // 0a14: ldc_w -421416218
      // 0a17: ixor
      // 0a18: i2c
      // 0a19: iadd
      // 0a1a: ldc_w -1324082452
      // 0a1d: ldc_w -421416218
      // 0a20: ixor
      // 0a21: ldc_w 421425960
      // 0a24: ldc_w -421416218
      // 0a27: ixor
      // 0a28: i2c
      // 0a29: isub
      // 0a2a: lload 3
      // 0a2b: l2i
      // 0a2c: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0a2f: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0a32: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 0a35: aload 41
      // 0a37: ldc_w -1324213526
      // 0a3a: ldc_w -421416218
      // 0a3d: ixor
      // 0a3e: ldc_w 421413827
      // 0a41: ldc_w -421416218
      // 0a44: ixor
      // 0a45: i2c
      // 0a46: iadd
      // 0a47: ldc_w -1324213526
      // 0a4a: ldc_w -421416218
      // 0a4d: ixor
      // 0a4e: ldc_w 421413732
      // 0a51: ldc_w -421416218
      // 0a54: ixor
      // 0a55: i2c
      // 0a56: iadd
      // 0a57: lload 3
      // 0a58: l2i
      // 0a59: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0a5c: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0a5f: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 0a62: invokestatic x/ocd2958dac48.Ĵ (FF)V
      // 0a65: lload 3
      // 0a66: lconst_1
      // 0a67: lcmp
      // 0a68: iflt 0c46
      // 0a6b: iload 21
      // 0a6d: ifeq 0bdf
      // 0a70: goto 0a74
      // 0a73: athrow
      // 0a74: aload 41
      // 0a76: goto 0a7a
      // 0a79: athrow
      // 0a7a: ldc_w -1324213526
      // 0a7d: ldc_w -421416218
      // 0a80: ixor
      // 0a81: ldc_w 421413862
      // 0a84: ldc_w -421416218
      // 0a87: ixor
      // 0a88: i2c
      // 0a89: iadd
      // 0a8a: ldc_w -1324213526
      // 0a8d: ldc_w -421416218
      // 0a90: ixor
      // 0a91: ldc_w 421419055
      // 0a94: ldc_w -421416218
      // 0a97: ixor
      // 0a98: i2c
      // 0a99: iadd
      // 0a9a: lload 3
      // 0a9b: l2i
      // 0a9c: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0a9f: iload 21
      // 0aa1: ifne 0b22
      // 0aa4: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0aa7: ifne 0aee
      // 0aaa: goto 0aae
      // 0aad: athrow
      // 0aae: aload 41
      // 0ab0: lload 3
      // 0ab1: lconst_1
      // 0ab2: lcmp
      // 0ab3: ifle 0c48
      // 0ab6: iload 21
      // 0ab8: ifne 0c48
      // 0abb: goto 0abf
      // 0abe: athrow
      // 0abf: ldc_w -1324213526
      // 0ac2: ldc_w -421416218
      // 0ac5: ixor
      // 0ac6: ldc_w 421413799
      // 0ac9: ldc_w -421416218
      // 0acc: ixor
      // 0acd: i2c
      // 0ace: iadd
      // 0acf: ldc_w -1324082452
      // 0ad2: ldc_w -421416218
      // 0ad5: ixor
      // 0ad6: ldc_w 421425545
      // 0ad9: ldc_w -421416218
      // 0adc: ixor
      // 0add: i2c
      // 0ade: isub
      // 0adf: lload 3
      // 0ae0: l2i
      // 0ae1: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0ae4: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0ae7: ifeq 0bdf
      // 0aea: goto 0aee
      // 0aed: athrow
      // 0aee: aload 41
      // 0af0: iload 21
      // 0af2: ifne 0b56
      // 0af5: goto 0af9
      // 0af8: athrow
      // 0af9: ldc_w -1324213526
      // 0afc: ldc_w -421416218
      // 0aff: ixor
      // 0b00: ldc_w 421413403
      // 0b03: ldc_w -421416218
      // 0b06: ixor
      // 0b07: i2c
      // 0b08: iadd
      // 0b09: ldc_w -1324082452
      // 0b0c: ldc_w -421416218
      // 0b0f: ixor
      // 0b10: ldc_w 421423684
      // 0b13: ldc_w -421416218
      // 0b16: ixor
      // 0b17: i2c
      // 0b18: isub
      // 0b19: lload 3
      // 0b1a: l2i
      // 0b1b: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0b1e: goto 0b22
      // 0b21: athrow
      // 0b22: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0b25: ifeq 0b5c
      // 0b28: aload 41
      // 0b2a: ldc_w -1324213526
      // 0b2d: ldc_w -421416218
      // 0b30: ixor
      // 0b31: ldc_w 421413403
      // 0b34: ldc_w -421416218
      // 0b37: ixor
      // 0b38: i2c
      // 0b39: iadd
      // 0b3a: ldc_w -1324082452
      // 0b3d: ldc_w -421416218
      // 0b40: ixor
      // 0b41: ldc_w 421423684
      // 0b44: ldc_w -421416218
      // 0b47: ixor
      // 0b48: i2c
      // 0b49: isub
      // 0b4a: lload 3
      // 0b4b: l2i
      // 0b4c: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0b4f: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0b52: goto 0b56
      // 0b55: athrow
      // 0b56: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 0b59: goto 0b5f
      // 0b5c: getstatic x/ocd2958dac48.Ƃ F
      // 0b5f: fstore 43
      // 0b61: aload 41
      // 0b63: iload 21
      // 0b65: lload 3
      // 0b66: lconst_1
      // 0b67: lcmp
      // 0b68: ifle 0b7e
      // 0b6b: ifne 0bcd
      // 0b6e: ldc_w -1324213526
      // 0b71: ldc_w -421416218
      // 0b74: ixor
      // 0b75: ldc_w 421413796
      // 0b78: ldc_w -421416218
      // 0b7b: ixor
      // 0b7c: i2c
      // 0b7d: iadd
      // 0b7e: ldc_w 1324213522
      // 0b81: ldc_w -421416218
      // 0b84: ixor
      // 0b85: ldc_w 421424986
      // 0b88: ldc_w -421416218
      // 0b8b: ixor
      // 0b8c: i2c
      // 0b8d: ineg
      // 0b8e: iadd
      // 0b8f: lload 3
      // 0b90: l2i
      // 0b91: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0b94: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0b97: ifeq 0bd3
      // 0b9a: goto 0b9e
      // 0b9d: athrow
      // 0b9e: aload 41
      // 0ba0: ldc_w -1324213526
      // 0ba3: ldc_w -421416218
      // 0ba6: ixor
      // 0ba7: ldc_w 421413796
      // 0baa: ldc_w -421416218
      // 0bad: ixor
      // 0bae: i2c
      // 0baf: iadd
      // 0bb0: ldc_w 1324213522
      // 0bb3: ldc_w -421416218
      // 0bb6: ixor
      // 0bb7: ldc_w 421424986
      // 0bba: ldc_w -421416218
      // 0bbd: ixor
      // 0bbe: i2c
      // 0bbf: ineg
      // 0bc0: iadd
      // 0bc1: lload 3
      // 0bc2: l2i
      // 0bc3: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0bc6: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0bc9: goto 0bcd
      // 0bcc: athrow
      // 0bcd: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 0bd0: goto 0bd6
      // 0bd3: getstatic x/ocd2958dac48.ș F
      // 0bd6: fstore 44
      // 0bd8: fload 43
      // 0bda: fload 44
      // 0bdc: invokestatic x/ocd2958dac48.Ͷ (FF)V
      // 0bdf: aload 42
      // 0be1: aload 41
      // 0be3: ldc_w -1324213526
      // 0be6: ldc_w -421416218
      // 0be9: ixor
      // 0bea: ldc_w 421413793
      // 0bed: ldc_w -421416218
      // 0bf0: ixor
      // 0bf1: i2c
      // 0bf2: iadd
      // 0bf3: ldc_w -1324213526
      // 0bf6: ldc_w -421416218
      // 0bf9: ixor
      // 0bfa: ldc_w 421416407
      // 0bfd: ldc_w -421416218
      // 0c00: ixor
      // 0c01: i2c
      // 0c02: iadd
      // 0c03: lload 3
      // 0c04: l2i
      // 0c05: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0c08: aload 42
      // 0c0a: invokevirtual x/ocd2958dac48.ҟ ()D
      // 0c0d: lload 9
      // 0c0f: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 0c12: aload 41
      // 0c14: ldc_w -1324213526
      // 0c17: ldc_w -421416218
      // 0c1a: ixor
      // 0c1b: ldc_w 421413395
      // 0c1e: ldc_w -421416218
      // 0c21: ixor
      // 0c22: i2c
      // 0c23: iadd
      // 0c24: ldc_w -1324213526
      // 0c27: ldc_w -421416218
      // 0c2a: ixor
      // 0c2b: ldc_w 421418843
      // 0c2e: ldc_w -421416218
      // 0c31: ixor
      // 0c32: i2c
      // 0c33: iadd
      // 0c34: lload 3
      // 0c35: l2i
      // 0c36: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0c39: aload 42
      // 0c3b: invokevirtual x/ocd2958dac48.ώ ()D
      // 0c3e: lload 9
      // 0c40: invokestatic x/oc7d9b6bd5c4.l (Lcom/google/gson/JsonObject;Ljava/lang/String;DJ)D
      // 0c43: invokevirtual x/ocd2958dac48.һ (DD)V
      // 0c46: aload 41
      // 0c48: iload 21
      // 0c4a: lload 3
      // 0c4b: lconst_1
      // 0c4c: lcmp
      // 0c4d: iflt 0c63
      // 0c50: ifne 0cc9
      // 0c53: ldc_w -1324213526
      // 0c56: ldc_w -421416218
      // 0c59: ixor
      // 0c5a: ldc_w 421413867
      // 0c5d: ldc_w -421416218
      // 0c60: ixor
      // 0c61: i2c
      // 0c62: iadd
      // 0c63: ldc_w 1324082448
      // 0c66: ldc_w -421416218
      // 0c69: ixor
      // 0c6a: ldc_w 421417390
      // 0c6d: ldc_w -421416218
      // 0c70: ixor
      // 0c71: i2c
      // 0c72: ineg
      // 0c73: isub
      // 0c74: lload 3
      // 0c75: l2i
      // 0c76: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0c79: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0c7c: ifne 0cc3
      // 0c7f: goto 0c83
      // 0c82: athrow
      // 0c83: aload 41
      // 0c85: iload 21
      // 0c87: ifne 0cc9
      // 0c8a: goto 0c8e
      // 0c8d: athrow
      // 0c8e: ldc_w -1324213526
      // 0c91: ldc_w -421416218
      // 0c94: ixor
      // 0c95: ldc_w 421413846
      // 0c98: ldc_w -421416218
      // 0c9b: ixor
      // 0c9c: i2c
      // 0c9d: iadd
      // 0c9e: ldc_w -1324213526
      // 0ca1: ldc_w -421416218
      // 0ca4: ixor
      // 0ca5: ldc_w 421419107
      // 0ca8: ldc_w -421416218
      // 0cab: ixor
      // 0cac: i2c
      // 0cad: iadd
      // 0cae: lload 3
      // 0caf: l2i
      // 0cb0: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0cb3: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0cb6: lload 3
      // 0cb7: lconst_1
      // 0cb8: lcmp
      // 0cb9: iflt 0cda
      // 0cbc: ifeq 0cd8
      // 0cbf: goto 0cc3
      // 0cc2: athrow
      // 0cc3: aload 41
      // 0cc5: goto 0cc9
      // 0cc8: athrow
      // 0cc9: astore 20
      // 0ccb: iload 17
      // 0ccd: i2c
      // 0cce: iload 18
      // 0cd0: aload 20
      // 0cd2: iload 19
      // 0cd4: i2s
      // 0cd5: invokestatic x/oc7d9b6bd5c4.Ȯ (CILcom/google/gson/JsonObject;S)V
      // 0cd8: iload 21
      // 0cda: ifeq 10ed
      // 0cdd: aload 40
      // 0cdf: goto 0ce3
      // 0ce2: athrow
      // 0ce3: iload 21
      // 0ce5: lload 3
      // 0ce6: lconst_1
      // 0ce7: lcmp
      // 0ce8: iflt 0d13
      // 0ceb: ifne 0d11
      // 0cee: instanceof x/oced2c93b93e
      // 0cf1: ifeq 0d0b
      // 0cf4: goto 0cf8
      // 0cf7: athrow
      // 0cf8: aload 40
      // 0cfa: checkcast x/oced2c93b93e
      // 0cfd: aload 41
      // 0cff: invokestatic x/oc7d9b6bd5c4.À (Lx/oced2c93b93e;Lcom/google/gson/JsonObject;)V
      // 0d02: iload 21
      // 0d04: ifeq 10ed
      // 0d07: goto 0d0b
      // 0d0a: athrow
      // 0d0b: aload 40
      // 0d0d: goto 0d11
      // 0d10: athrow
      // 0d11: iload 21
      // 0d13: lload 3
      // 0d14: lconst_0
      // 0d15: lcmp
      // 0d16: iflt 0e47
      // 0d19: ifne 0e45
      // 0d1c: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 0d1f: ldc_w -1324213526
      // 0d22: ldc_w -421416218
      // 0d25: ixor
      // 0d26: ldc_w 421413876
      // 0d29: ldc_w -421416218
      // 0d2c: ixor
      // 0d2d: i2c
      // 0d2e: iadd
      // 0d2f: ldc_w 1324213522
      // 0d32: ldc_w -421416218
      // 0d35: ixor
      // 0d36: ldc_w 421412977
      // 0d39: ldc_w -421416218
      // 0d3c: ixor
      // 0d3d: i2c
      // 0d3e: ineg
      // 0d3f: iadd
      // 0d40: lload 3
      // 0d41: l2i
      // 0d42: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0d45: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d48: ifeq 0e3f
      // 0d4b: goto 0d4f
      // 0d4e: athrow
      // 0d4f: aload 41
      // 0d51: lload 3
      // 0d52: lconst_0
      // 0d53: lcmp
      // 0d54: iflt 0dcd
      // 0d57: iload 21
      // 0d59: ifne 0dcd
      // 0d5c: goto 0d60
      // 0d5f: athrow
      // 0d60: invokestatic x/oc7d9b6bd5c4.ζ (Lcom/google/gson/JsonObject;)V
      // 0d63: aload 41
      // 0d65: ldc_w -1324213526
      // 0d68: ldc_w -421416218
      // 0d6b: ixor
      // 0d6c: ldc_w 421413403
      // 0d6f: ldc_w -421416218
      // 0d72: ixor
      // 0d73: i2c
      // 0d74: iadd
      // 0d75: ldc_w -1324082452
      // 0d78: ldc_w -421416218
      // 0d7b: ixor
      // 0d7c: ldc_w 421423684
      // 0d7f: ldc_w -421416218
      // 0d82: ixor
      // 0d83: i2c
      // 0d84: isub
      // 0d85: lload 3
      // 0d86: l2i
      // 0d87: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0d8a: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0d8d: ifeq 0dcb
      // 0d90: goto 0d94
      // 0d93: athrow
      // 0d94: aload 41
      // 0d96: ldc_w -1324213526
      // 0d99: ldc_w -421416218
      // 0d9c: ixor
      // 0d9d: ldc_w 421413403
      // 0da0: ldc_w -421416218
      // 0da3: ixor
      // 0da4: i2c
      // 0da5: iadd
      // 0da6: ldc_w -1324082452
      // 0da9: ldc_w -421416218
      // 0dac: ixor
      // 0dad: ldc_w 421423684
      // 0db0: ldc_w -421416218
      // 0db3: ixor
      // 0db4: i2c
      // 0db5: isub
      // 0db6: lload 3
      // 0db7: l2i
      // 0db8: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0dbb: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0dbe: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 0dc1: istore 42
      // 0dc3: getstatic x/oc9755810e45.Ƿ Lx/oc7ed5a3bedd;
      // 0dc6: iload 42
      // 0dc8: putfield x/oc7ed5a3bedd.Ș I
      // 0dcb: aload 41
      // 0dcd: ldc_w -1324213526
      // 0dd0: ldc_w -421416218
      // 0dd3: ixor
      // 0dd4: ldc_w 421413796
      // 0dd7: ldc_w -421416218
      // 0dda: ixor
      // 0ddb: i2c
      // 0ddc: iadd
      // 0ddd: ldc_w 1324213522
      // 0de0: ldc_w -421416218
      // 0de3: ixor
      // 0de4: ldc_w 421424986
      // 0de7: ldc_w -421416218
      // 0dea: ixor
      // 0deb: i2c
      // 0dec: ineg
      // 0ded: iadd
      // 0dee: lload 3
      // 0def: l2i
      // 0df0: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0df3: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0df6: iload 21
      // 0df8: ifne 10f6
      // 0dfb: ifeq 10ed
      // 0dfe: goto 0e02
      // 0e01: athrow
      // 0e02: aload 41
      // 0e04: ldc_w -1324213526
      // 0e07: ldc_w -421416218
      // 0e0a: ixor
      // 0e0b: ldc_w 421413796
      // 0e0e: ldc_w -421416218
      // 0e11: ixor
      // 0e12: i2c
      // 0e13: iadd
      // 0e14: ldc_w 1324213522
      // 0e17: ldc_w -421416218
      // 0e1a: ixor
      // 0e1b: ldc_w 421424986
      // 0e1e: ldc_w -421416218
      // 0e21: ixor
      // 0e22: i2c
      // 0e23: ineg
      // 0e24: iadd
      // 0e25: lload 3
      // 0e26: l2i
      // 0e27: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0e2a: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0e2d: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 0e30: istore 42
      // 0e32: iload 21
      // 0e34: getstatic x/oc9755810e45.Ƿ Lx/oc7ed5a3bedd;
      // 0e37: iload 42
      // 0e39: putfield x/oc7ed5a3bedd.ɐ I
      // 0e3c: ifeq 10ed
      // 0e3f: aload 40
      // 0e41: goto 0e45
      // 0e44: athrow
      // 0e45: iload 21
      // 0e47: lload 3
      // 0e48: lconst_1
      // 0e49: lcmp
      // 0e4a: ifle 0e75
      // 0e4d: ifne 0e73
      // 0e50: instanceof x/oc63a9b409d2
      // 0e53: ifeq 0e6d
      // 0e56: goto 0e5a
      // 0e59: athrow
      // 0e5a: aload 40
      // 0e5c: checkcast x/oc63a9b409d2
      // 0e5f: aload 41
      // 0e61: invokestatic x/oc7d9b6bd5c4.а (Lx/oc63a9b409d2;Lcom/google/gson/JsonObject;)V
      // 0e64: iload 21
      // 0e66: ifeq 10ed
      // 0e69: goto 0e6d
      // 0e6c: athrow
      // 0e6d: aload 40
      // 0e6f: goto 0e73
      // 0e72: athrow
      // 0e73: iload 21
      // 0e75: ifne 10ef
      // 0e78: instanceof x/oca4800eb63f
      // 0e7b: ifeq 10ed
      // 0e7e: goto 0e82
      // 0e81: athrow
      // 0e82: aload 40
      // 0e84: checkcast x/oca4800eb63f
      // 0e87: astore 42
      // 0e89: aload 41
      // 0e8b: ldc_w -1324213526
      // 0e8e: ldc_w -421416218
      // 0e91: ixor
      // 0e92: ldc_w 421413870
      // 0e95: ldc_w -421416218
      // 0e98: ixor
      // 0e99: i2c
      // 0e9a: iadd
      // 0e9b: ldc_w -1324082452
      // 0e9e: ldc_w -421416218
      // 0ea1: ixor
      // 0ea2: ldc_w 421425960
      // 0ea5: ldc_w -421416218
      // 0ea8: ixor
      // 0ea9: i2c
      // 0eaa: isub
      // 0eab: lload 3
      // 0eac: l2i
      // 0ead: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0eb0: lload 3
      // 0eb1: lconst_1
      // 0eb2: lcmp
      // 0eb3: ifle 0fa7
      // 0eb6: iload 21
      // 0eb8: ifne 0fa7
      // 0ebb: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0ebe: ifeq 0f6d
      // 0ec1: goto 0ec5
      // 0ec4: athrow
      // 0ec5: aload 41
      // 0ec7: lload 3
      // 0ec8: lconst_0
      // 0ec9: lcmp
      // 0eca: ifle 0f73
      // 0ecd: iload 21
      // 0ecf: ifne 0f73
      // 0ed2: goto 0ed6
      // 0ed5: athrow
      // 0ed6: ldc_w -1324213526
      // 0ed9: ldc_w -421416218
      // 0edc: ixor
      // 0edd: ldc_w 421413827
      // 0ee0: ldc_w -421416218
      // 0ee3: ixor
      // 0ee4: i2c
      // 0ee5: iadd
      // 0ee6: ldc_w -1324213526
      // 0ee9: ldc_w -421416218
      // 0eec: ixor
      // 0eed: ldc_w 421413732
      // 0ef0: ldc_w -421416218
      // 0ef3: ixor
      // 0ef4: i2c
      // 0ef5: iadd
      // 0ef6: lload 3
      // 0ef7: l2i
      // 0ef8: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0efb: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0efe: ifeq 0f6d
      // 0f01: goto 0f05
      // 0f04: athrow
      // 0f05: aload 42
      // 0f07: aload 41
      // 0f09: ldc_w -1324213526
      // 0f0c: ldc_w -421416218
      // 0f0f: ixor
      // 0f10: ldc_w 421413870
      // 0f13: ldc_w -421416218
      // 0f16: ixor
      // 0f17: i2c
      // 0f18: iadd
      // 0f19: ldc_w -1324082452
      // 0f1c: ldc_w -421416218
      // 0f1f: ixor
      // 0f20: ldc_w 421425960
      // 0f23: ldc_w -421416218
      // 0f26: ixor
      // 0f27: i2c
      // 0f28: isub
      // 0f29: lload 3
      // 0f2a: l2i
      // 0f2b: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0f2e: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0f31: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 0f34: aload 41
      // 0f36: ldc_w -1324213526
      // 0f39: ldc_w -421416218
      // 0f3c: ixor
      // 0f3d: ldc_w 421413827
      // 0f40: ldc_w -421416218
      // 0f43: ixor
      // 0f44: i2c
      // 0f45: iadd
      // 0f46: ldc_w -1324213526
      // 0f49: ldc_w -421416218
      // 0f4c: ixor
      // 0f4d: ldc_w 421413732
      // 0f50: ldc_w -421416218
      // 0f53: ixor
      // 0f54: i2c
      // 0f55: iadd
      // 0f56: lload 3
      // 0f57: l2i
      // 0f58: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0f5b: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0f5e: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 0f61: invokevirtual x/oca4800eb63f.ӑ (FF)V
      // 0f64: iload 21
      // 0f66: ifeq 10ed
      // 0f69: goto 0f6d
      // 0f6c: athrow
      // 0f6d: aload 41
      // 0f6f: goto 0f73
      // 0f72: athrow
      // 0f73: iload 21
      // 0f75: lload 3
      // 0f76: lconst_1
      // 0f77: lcmp
      // 0f78: ifle 0ff8
      // 0f7b: ifne 0ff6
      // 0f7e: ldc_w -1324213526
      // 0f81: ldc_w -421416218
      // 0f84: ixor
      // 0f85: ldc_w 421413403
      // 0f88: ldc_w -421416218
      // 0f8b: ixor
      // 0f8c: i2c
      // 0f8d: iadd
      // 0f8e: ldc_w -1324082452
      // 0f91: ldc_w -421416218
      // 0f94: ixor
      // 0f95: ldc_w 421423684
      // 0f98: ldc_w -421416218
      // 0f9b: ixor
      // 0f9c: i2c
      // 0f9d: isub
      // 0f9e: lload 3
      // 0f9f: l2i
      // 0fa0: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0fa3: goto 0fa7
      // 0fa6: athrow
      // 0fa7: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0faa: lload 3
      // 0fab: lconst_1
      // 0fac: lcmp
      // 0fad: iflt 0fde
      // 0fb0: ifne 0ff4
      // 0fb3: aload 41
      // 0fb5: ldc_w -1324213526
      // 0fb8: ldc_w -421416218
      // 0fbb: ixor
      // 0fbc: ldc_w 421413796
      // 0fbf: ldc_w -421416218
      // 0fc2: ixor
      // 0fc3: i2c
      // 0fc4: iadd
      // 0fc5: ldc_w 1324213522
      // 0fc8: ldc_w -421416218
      // 0fcb: ixor
      // 0fcc: ldc_w 421424986
      // 0fcf: ldc_w -421416218
      // 0fd2: ixor
      // 0fd3: i2c
      // 0fd4: ineg
      // 0fd5: iadd
      // 0fd6: lload 3
      // 0fd7: l2i
      // 0fd8: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0fdb: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0fde: lload 3
      // 0fdf: lconst_0
      // 0fe0: lcmp
      // 0fe1: ifle 10f6
      // 0fe4: iload 21
      // 0fe6: ifne 10f6
      // 0fe9: goto 0fed
      // 0fec: athrow
      // 0fed: ifeq 10ed
      // 0ff0: goto 0ff4
      // 0ff3: athrow
      // 0ff4: aload 41
      // 0ff6: iload 21
      // 0ff8: lload 3
      // 0ff9: lconst_1
      // 0ffa: lcmp
      // 0ffb: ifle 1011
      // 0ffe: ifne 105e
      // 1001: ldc_w -1324213526
      // 1004: ldc_w -421416218
      // 1007: ixor
      // 1008: ldc_w 421413403
      // 100b: ldc_w -421416218
      // 100e: ixor
      // 100f: i2c
      // 1010: iadd
      // 1011: ldc_w -1324082452
      // 1014: ldc_w -421416218
      // 1017: ixor
      // 1018: ldc_w 421423684
      // 101b: ldc_w -421416218
      // 101e: ixor
      // 101f: i2c
      // 1020: isub
      // 1021: lload 3
      // 1022: l2i
      // 1023: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1026: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 1029: ifeq 1064
      // 102c: goto 1030
      // 102f: athrow
      // 1030: aload 41
      // 1032: ldc_w -1324213526
      // 1035: ldc_w -421416218
      // 1038: ixor
      // 1039: ldc_w 421413403
      // 103c: ldc_w -421416218
      // 103f: ixor
      // 1040: i2c
      // 1041: iadd
      // 1042: ldc_w -1324082452
      // 1045: ldc_w -421416218
      // 1048: ixor
      // 1049: ldc_w 421423684
      // 104c: ldc_w -421416218
      // 104f: ixor
      // 1050: i2c
      // 1051: isub
      // 1052: lload 3
      // 1053: l2i
      // 1054: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1057: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 105a: goto 105e
      // 105d: athrow
      // 105e: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 1061: goto 1069
      // 1064: aload 42
      // 1066: invokevirtual x/oca4800eb63f.Ɖ ()F
      // 1069: fstore 43
      // 106b: aload 41
      // 106d: iload 21
      // 106f: lload 3
      // 1070: lconst_1
      // 1071: lcmp
      // 1072: iflt 1088
      // 1075: ifne 10d7
      // 1078: ldc_w -1324213526
      // 107b: ldc_w -421416218
      // 107e: ixor
      // 107f: ldc_w 421413796
      // 1082: ldc_w -421416218
      // 1085: ixor
      // 1086: i2c
      // 1087: iadd
      // 1088: ldc_w 1324213522
      // 108b: ldc_w -421416218
      // 108e: ixor
      // 108f: ldc_w 421424986
      // 1092: ldc_w -421416218
      // 1095: ixor
      // 1096: i2c
      // 1097: ineg
      // 1098: iadd
      // 1099: lload 3
      // 109a: l2i
      // 109b: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 109e: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 10a1: ifeq 10dd
      // 10a4: goto 10a8
      // 10a7: athrow
      // 10a8: aload 41
      // 10aa: ldc_w -1324213526
      // 10ad: ldc_w -421416218
      // 10b0: ixor
      // 10b1: ldc_w 421413796
      // 10b4: ldc_w -421416218
      // 10b7: ixor
      // 10b8: i2c
      // 10b9: iadd
      // 10ba: ldc_w 1324213522
      // 10bd: ldc_w -421416218
      // 10c0: ixor
      // 10c1: ldc_w 421424986
      // 10c4: ldc_w -421416218
      // 10c7: ixor
      // 10c8: i2c
      // 10c9: ineg
      // 10ca: iadd
      // 10cb: lload 3
      // 10cc: l2i
      // 10cd: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 10d0: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 10d3: goto 10d7
      // 10d6: athrow
      // 10d7: invokevirtual com/google/gson/JsonElement.getAsFloat ()F
      // 10da: goto 10e2
      // 10dd: aload 42
      // 10df: invokevirtual x/oca4800eb63f.Ǟ ()F
      // 10e2: fstore 44
      // 10e4: aload 42
      // 10e6: fload 43
      // 10e8: fload 44
      // 10ea: invokevirtual x/oca4800eb63f.Ӂ (FF)V
      // 10ed: aload 40
      // 10ef: aload 41
      // 10f1: invokestatic x/oc7d9b6bd5c4.ɍ (Lx/oc69da1aa7f5;Lcom/google/gson/JsonObject;)V
      // 10f4: iload 37
      // 10f6: iload 21
      // 10f8: lload 3
      // 10f9: lconst_1
      // 10fa: lcmp
      // 10fb: iflt 112a
      // 10fe: ifne 1128
      // 1101: ldc_w -421423013
      // 1104: ldc_w -421416218
      // 1107: ixor
      // 1108: ldc2_w -1725967617632459146
      // 110b: ldc2_w -930440742247705406
      // 110e: lxor
      // 110f: lload 3
      // 1110: lxor
      // 1111: invokestatic x/oc7d9b6bd5c4.a (IJ)I
      // 1114: if_icmpge 1126
      // 1117: goto 111b
      // 111a: athrow
      // 111b: aload 40
      // 111d: aload 41
      // 111f: invokestatic x/oc7d9b6bd5c4.Ѷ (Lx/oc69da1aa7f5;Lcom/google/gson/JsonObject;)V
      // 1122: goto 1126
      // 1125: athrow
      // 1126: iload 37
      // 1128: iload 21
      // 112a: lload 3
      // 112b: lconst_1
      // 112c: lcmp
      // 112d: ifle 1146
      // 1130: ifne 1175
      // 1133: ldc_w -421417956
      // 1136: ldc_w -421416218
      // 1139: ixor
      // 113a: ldc2_w -8806127448999685570
      // 113d: ldc2_w -930440742247705406
      // 1140: lxor
      // 1141: lload 3
      // 1142: lxor
      // 1143: invokestatic x/oc7d9b6bd5c4.a (IJ)I
      // 1146: if_icmpge 1173
      // 1149: goto 114d
      // 114c: athrow
      // 114d: aload 40
      // 114f: instanceof x/oc6a43806f12
      // 1152: lload 3
      // 1153: lconst_0
      // 1154: lcmp
      // 1155: ifle 1175
      // 1158: iload 21
      // 115a: ifne 1175
      // 115d: goto 1161
      // 1160: athrow
      // 1161: ifeq 1173
      // 1164: goto 1168
      // 1167: athrow
      // 1168: aload 40
      // 116a: aload 41
      // 116c: invokestatic x/oc7d9b6bd5c4.ԟ (Lx/oc69da1aa7f5;Lcom/google/gson/JsonObject;)V
      // 116f: goto 1173
      // 1172: athrow
      // 1173: iload 37
      // 1175: iload 21
      // 1177: lload 3
      // 1178: lconst_0
      // 1179: lcmp
      // 117a: iflt 1193
      // 117d: ifne 11c0
      // 1180: ldc_w -421404024
      // 1183: ldc_w -421416218
      // 1186: ixor
      // 1187: ldc2_w -2447278110914519858
      // 118a: ldc2_w -930440742247705406
      // 118d: lxor
      // 118e: lload 3
      // 118f: lxor
      // 1190: invokestatic x/oc7d9b6bd5c4.a (IJ)I
      // 1193: if_icmpge 11be
      // 1196: goto 119a
      // 1199: athrow
      // 119a: aload 40
      // 119c: instanceof x/oc714cf0262c
      // 119f: lload 3
      // 11a0: lconst_1
      // 11a1: lcmp
      // 11a2: ifle 11c0
      // 11a5: iload 21
      // 11a7: ifne 11c0
      // 11aa: goto 11ae
      // 11ad: athrow
      // 11ae: ifeq 11be
      // 11b1: goto 11b5
      // 11b4: athrow
      // 11b5: aload 41
      // 11b7: invokestatic x/oc7d9b6bd5c4.э (Lcom/google/gson/JsonObject;)V
      // 11ba: goto 11be
      // 11bd: athrow
      // 11be: iload 37
      // 11c0: iload 21
      // 11c2: lload 3
      // 11c3: lconst_0
      // 11c4: lcmp
      // 11c5: iflt 11de
      // 11c8: ifne 11f7
      // 11cb: ldc_w -421421639
      // 11ce: ldc_w -421416218
      // 11d1: ixor
      // 11d2: ldc2_w -6075732317183761534
      // 11d5: ldc2_w -930440742247705406
      // 11d8: lxor
      // 11d9: lload 3
      // 11da: lxor
      // 11db: invokestatic x/oc7d9b6bd5c4.a (IJ)I
      // 11de: if_icmpge 1203
      // 11e1: goto 11e5
      // 11e4: athrow
      // 11e5: aload 40
      // 11e7: iload 21
      // 11e9: ifne 1205
      // 11ec: goto 11f0
      // 11ef: athrow
      // 11f0: instanceof x/oce3cc81daa8
      // 11f3: goto 11f7
      // 11f6: athrow
      // 11f7: ifeq 1203
      // 11fa: aload 41
      // 11fc: invokestatic x/oc7d9b6bd5c4.ь (Lcom/google/gson/JsonObject;)V
      // 11ff: goto 1203
      // 1202: athrow
      // 1203: aload 40
      // 1205: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 1208: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 120b: astore 42
      // 120d: aload 42
      // 120f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1214: ifeq 1281
      // 1217: aload 42
      // 1219: iload 21
      // 121b: ifne 08ac
      // 121e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1223: checkcast x/N
      // 1226: astore 43
      // 1228: lload 3
      // 1229: lconst_0
      // 122a: lcmp
      // 122b: ifle 08c0
      // 122e: iload 21
      // 1230: lload 3
      // 1231: lconst_1
      // 1232: lcmp
      // 1233: iflt 127e
      // 1236: ifne 127c
      // 1239: aload 43
      // 123b: instanceof x/oc321b4679dd
      // 123e: ifeq 126c
      // 1241: goto 1245
      // 1244: athrow
      // 1245: aload 43
      // 1247: iload 21
      // 1249: ifne 1277
      // 124c: goto 1250
      // 124f: athrow
      // 1250: checkcast x/oc321b4679dd
      // 1253: invokevirtual x/oc321b4679dd.Ǽ ()Z
      // 1256: ifeq 126c
      // 1259: goto 125d
      // 125c: athrow
      // 125d: iload 21
      // 125f: lload 3
      // 1260: lconst_0
      // 1261: lcmp
      // 1262: ifle 1214
      // 1265: ifeq 120d
      // 1268: goto 126c
      // 126b: athrow
      // 126c: aload 40
      // 126e: aload 43
      // 1270: aload 41
      // 1272: invokestatic x/oc7d9b6bd5c4.O (Lx/oc69da1aa7f5;Lx/N;Lcom/google/gson/JsonObject;)V
      // 1275: aload 43
      // 1277: aload 41
      // 1279: invokevirtual x/N.z$3ktkzjg2sjswq (Lcom/google/gson/JsonObject;)V
      // 127c: iload 21
      // 127e: ifeq 120d
      // 1281: aload 40
      // 1283: lload 3
      // 1284: lconst_1
      // 1285: lcmp
      // 1286: iflt 1436
      // 1289: instanceof x/ocd2958dac48
      // 128c: iload 21
      // 128e: ifne 12d6
      // 1291: ifeq 1378
      // 1294: goto 1298
      // 1297: athrow
      // 1298: aload 41
      // 129a: lload 3
      // 129b: lconst_1
      // 129c: lcmp
      // 129d: iflt 12db
      // 12a0: iload 21
      // 12a2: ifne 12db
      // 12a5: goto 12a9
      // 12a8: athrow
      // 12a9: ldc_w -1324213526
      // 12ac: ldc_w -421416218
      // 12af: ixor
      // 12b0: ldc_w 421413848
      // 12b3: ldc_w -421416218
      // 12b6: ixor
      // 12b7: i2c
      // 12b8: iadd
      // 12b9: ldc_w 1324082448
      // 12bc: ldc_w -421416218
      // 12bf: ixor
      // 12c0: ldc_w 421427908
      // 12c3: ldc_w -421416218
      // 12c6: ixor
      // 12c7: i2c
      // 12c8: ineg
      // 12c9: isub
      // 12ca: lload 3
      // 12cb: l2i
      // 12cc: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 12cf: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 12d2: goto 12d6
      // 12d5: athrow
      // 12d6: ifeq 1378
      // 12d9: aload 41
      // 12db: ldc_w -1324213526
      // 12de: ldc_w -421416218
      // 12e1: ixor
      // 12e2: ldc_w 421413874
      // 12e5: ldc_w -421416218
      // 12e8: ixor
      // 12e9: i2c
      // 12ea: iadd
      // 12eb: ldc_w -1324213526
      // 12ee: ldc_w -421416218
      // 12f1: ixor
      // 12f2: ldc_w 421412973
      // 12f5: ldc_w -421416218
      // 12f8: ixor
      // 12f9: i2c
      // 12fa: iadd
      // 12fb: lload 3
      // 12fc: l2i
      // 12fd: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1300: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 1303: lload 3
      // 1304: lconst_0
      // 1305: lcmp
      // 1306: iflt 137a
      // 1309: ifeq 1378
      // 130c: aload 40
      // 130e: checkcast x/ocd2958dac48
      // 1311: aload 41
      // 1313: ldc_w -1324213526
      // 1316: ldc_w -421416218
      // 1319: ixor
      // 131a: ldc_w 421413878
      // 131d: ldc_w -421416218
      // 1320: ixor
      // 1321: i2c
      // 1322: iadd
      // 1323: ldc_w 1324213522
      // 1326: ldc_w -421416218
      // 1329: ixor
      // 132a: ldc_w 421415268
      // 132d: ldc_w -421416218
      // 1330: ixor
      // 1331: i2c
      // 1332: ineg
      // 1333: iadd
      // 1334: lload 3
      // 1335: l2i
      // 1336: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1339: lload 5
      // 133b: ldc_w NaN
      // 133e: invokestatic x/oc7d9b6bd5c4.ҫ (Lcom/google/gson/JsonObject;Ljava/lang/String;JF)F
      // 1341: aload 41
      // 1343: ldc_w -1324213526
      // 1346: ldc_w -421416218
      // 1349: ixor
      // 134a: ldc_w 421413871
      // 134d: ldc_w -421416218
      // 1350: ixor
      // 1351: i2c
      // 1352: iadd
      // 1353: ldc_w 1324082448
      // 1356: ldc_w -421416218
      // 1359: ixor
      // 135a: ldc_w 421396518
      // 135d: ldc_w -421416218
      // 1360: ixor
      // 1361: i2c
      // 1362: ineg
      // 1363: isub
      // 1364: lload 3
      // 1365: l2i
      // 1366: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1369: lload 5
      // 136b: ldc_w NaN
      // 136e: invokestatic x/oc7d9b6bd5c4.ҫ (Lcom/google/gson/JsonObject;Ljava/lang/String;JF)F
      // 1371: invokevirtual x/ocd2958dac48.Ǚ (FF)V
      // 1374: goto 1378
      // 1377: athrow
      // 1378: iload 21
      // 137a: ifeq 08aa
      // 137d: lload 3
      // 137e: lconst_0
      // 137f: lcmp
      // 1380: iflt 138c
      // 1383: aload 31
      // 1385: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 138a: astore 38
      // 138c: aload 38
      // 138e: lload 3
      // 138f: lconst_0
      // 1390: lcmp
      // 1391: iflt 1423
      // 1394: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1399: ifeq 1408
      // 139c: aload 38
      // 139e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 13a3: checkcast x/oc69da1aa7f5
      // 13a6: astore 39
      // 13a8: aload 32
      // 13aa: aload 39
      // 13ac: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 13b1: checkcast x/oca04ceef104
      // 13b4: iload 21
      // 13b6: ifne 1436
      // 13b9: astore 40
      // 13bb: aload 40
      // 13bd: lload 3
      // 13be: lconst_0
      // 13bf: lcmp
      // 13c0: ifle 13da
      // 13c3: iload 21
      // 13c5: ifne 13da
      // 13c8: ifnonnull 13d8
      // 13cb: goto 13cf
      // 13ce: athrow
      // 13cf: iload 21
      // 13d1: ifeq 138c
      // 13d4: goto 13d8
      // 13d7: athrow
      // 13d8: aload 40
      // 13da: getfield x/oca04ceef104.Σ Z
      // 13dd: iload 21
      // 13df: ifne 13fb
      // 13e2: ifeq 1403
      // 13e5: goto 13e9
      // 13e8: athrow
      // 13e9: aload 39
      // 13eb: iload 21
      // 13ed: ifne 1400
      // 13f0: goto 13f4
      // 13f3: athrow
      // 13f4: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 13f7: goto 13fb
      // 13fa: athrow
      // 13fb: ifne 1403
      // 13fe: aload 39
      // 1400: invokevirtual x/oc69da1aa7f5.Х ()V
      // 1403: iload 21
      // 1405: ifeq 138c
      // 1408: aload 0
      // 1409: aload 23
      // 140b: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 140e: putstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 1411: lload 3
      // 1412: lconst_1
      // 1413: lcmp
      // 1414: iflt 14ac
      // 1417: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 141a: invokevirtual x/oc2c25634a7e.Њ ()V
      // 141d: getstatic x/oc2c25634a7e.ʴ Ljava/util/ArrayList;
      // 1420: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 1423: astore 38
      // 1425: aload 38
      // 1427: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 142c: ifeq 1483
      // 142f: aload 38
      // 1431: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1436: checkcast x/oc192c7e4083
      // 1439: astore 39
      // 143b: lload 3
      // 143c: lconst_1
      // 143d: lcmp
      // 143e: ifle 14ac
      // 1441: iload 21
      // 1443: ifne 14ac
      // 1446: aload 36
      // 1448: aload 39
      // 144a: getfield x/oc192c7e4083.ȩ Lx/oce4cea752dd;
      // 144d: invokevirtual java/lang/Enum.name ()Ljava/lang/String;
      // 1450: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1455: checkcast x/ocddfa9d2661
      // 1458: astore 40
      // 145a: lload 3
      // 145b: lconst_0
      // 145c: lcmp
      // 145d: iflt 147a
      // 1460: aload 40
      // 1462: ifnull 147e
      // 1465: aload 39
      // 1467: aload 40
      // 1469: getfield x/ocddfa9d2661.ʌ F
      // 146c: aload 40
      // 146e: getfield x/ocddfa9d2661.ɜ F
      // 1471: aload 40
      // 1473: getfield x/ocddfa9d2661.đ Z
      // 1476: bipush 1
      // 1477: invokevirtual x/oc192c7e4083.ˡ (FFZZ)V
      // 147a: goto 147e
      // 147d: athrow
      // 147e: iload 21
      // 1480: ifeq 1425
      // 1483: lload 3
      // 1484: lconst_0
      // 1485: lcmp
      // 1486: ifle 14ac
      // 1489: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 148c: new x/oc00038824c1
      // 148f: dup
      // 1490: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 1493: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 1496: invokespecial x/oc00038824c1.<init> (Ljava/lang/String;)V
      // 1499: invokevirtual x/oc04596227b7.post (Lx/oc68d6b191af;)Z
      // 149c: lload 3
      // 149d: lconst_1
      // 149e: lcmp
      // 149f: iflt 1535
      // 14a2: iload 21
      // 14a4: ifne 1535
      // 14a7: pop
      // 14a8: goto 14ac
      // 14ab: athrow
      // 14ac: iload 30
      // 14ae: ifeq 1534
      // 14b1: aload 23
      // 14b3: aload 29
      // 14b5: ldc_w -1324213526
      // 14b8: ldc_w -421416218
      // 14bb: ixor
      // 14bc: ldc_w 421413883
      // 14bf: ldc_w -421416218
      // 14c2: ixor
      // 14c3: i2c
      // 14c4: iadd
      // 14c5: ldc_w 1324082448
      // 14c8: ldc_w -421416218
      // 14cb: ixor
      // 14cc: ldc_w 421424642
      // 14cf: ldc_w -421416218
      // 14d2: ixor
      // 14d3: i2c
      // 14d4: ineg
      // 14d5: isub
      // 14d6: lload 3
      // 14d7: l2i
      // 14d8: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 14db: dup_x2
      // 14dc: pop
      // 14dd: ldc_w -1324213526
      // 14e0: ldc_w -421416218
      // 14e3: ixor
      // 14e4: ldc_w 421413824
      // 14e7: ldc_w -421416218
      // 14ea: ixor
      // 14eb: i2c
      // 14ec: iadd
      // 14ed: ldc_w -1324213526
      // 14f0: ldc_w -421416218
      // 14f3: ixor
      // 14f4: ldc_w 421415216
      // 14f7: ldc_w -421416218
      // 14fa: ixor
      // 14fb: i2c
      // 14fc: iadd
      // 14fd: lload 3
      // 14fe: l2i
      // 14ff: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1502: swap
      // 1503: ldc_w -1324213526
      // 1506: ldc_w -421416218
      // 1509: ixor
      // 150a: ldc_w 421413804
      // 150d: ldc_w -421416218
      // 1510: ixor
      // 1511: i2c
      // 1512: iadd
      // 1513: ldc_w -1324213526
      // 1516: ldc_w -421416218
      // 1519: ixor
      // 151a: ldc_w 421414098
      // 151d: ldc_w -421416218
      // 1520: ixor
      // 1521: i2c
      // 1522: iadd
      // 1523: lload 3
      // 1524: l2i
      // 1525: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1528: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 152d: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 1530: goto 1534
      // 1533: athrow
      // 1534: iload 2
      // 1535: iload 21
      // 1537: ifne 155c
      // 153a: ifeq 155b
      // 153d: goto 1541
      // 1540: athrow
      // 1541: aload 0
      // 1542: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 1545: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 1548: lload 15
      // 154a: invokevirtual x/oc7d9b6bd5c4.ͻ (Ljava/lang/String;J)V
      // 154d: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 1550: invokevirtual x/oc151419fdfe.ǚ ()Lx/ocdd0f49ff2f;
      // 1553: bipush 1
      // 1554: putfield x/ocdd0f49ff2f.Ƌ Z
      // 1557: goto 155b
      // 155a: athrow
      // 155b: bipush 1
      // 155c: istore 38
      // 155e: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 1561: iload 21
      // 1563: ifne 1570
      // 1566: ifnull 1573
      // 1569: goto 156d
      // 156c: athrow
      // 156d: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 1570: invokevirtual x/oc46245c2b20.ё ()V
      // 1573: iload 38
      // 1575: ireturn
      // 1576: astore 27
      // 1578: aload 0
      // 1579: ldc_w -1324213526
      // 157c: ldc_w -421416218
      // 157f: ixor
      // 1580: ldc_w 421413887
      // 1583: ldc_w -421416218
      // 1586: ixor
      // 1587: i2c
      // 1588: iadd
      // 1589: ldc_w -1324082452
      // 158c: ldc_w -421416218
      // 158f: ixor
      // 1590: ldc_w 421402944
      // 1593: ldc_w -421416218
      // 1596: ixor
      // 1597: i2c
      // 1598: isub
      // 1599: lload 3
      // 159a: l2i
      // 159b: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 159e: aload 23
      // 15a0: invokevirtual x/oc7d9b6bd5c4.ի (Ljava/lang/String;Ljava/lang/String;)V
      // 15a3: aload 27
      // 15a5: invokevirtual java/lang/Exception.printStackTrace ()V
      // 15a8: bipush 0
      // 15a9: istore 28
      // 15ab: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 15ae: iload 21
      // 15b0: ifne 15bd
      // 15b3: ifnull 15c0
      // 15b6: goto 15ba
      // 15b9: athrow
      // 15ba: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 15bd: invokevirtual x/oc46245c2b20.ё ()V
      // 15c0: iload 28
      // 15c2: ireturn
      // 15c3: iload 24
      // 15c5: iload 21
      // 15c7: ifne 1601
      // 15ca: ifne 1600
      // 15cd: goto 15d1
      // 15d0: athrow
      // 15d1: aload 0
      // 15d2: ldc_w -1324213526
      // 15d5: ldc_w -421416218
      // 15d8: ixor
      // 15d9: ldc_w 421413887
      // 15dc: ldc_w -421416218
      // 15df: ixor
      // 15e0: i2c
      // 15e1: iadd
      // 15e2: ldc_w -1324082452
      // 15e5: ldc_w -421416218
      // 15e8: ixor
      // 15e9: ldc_w 421402944
      // 15ec: ldc_w -421416218
      // 15ef: ixor
      // 15f0: i2c
      // 15f1: isub
      // 15f2: lload 3
      // 15f3: l2i
      // 15f4: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 15f7: aload 23
      // 15f9: invokevirtual x/oc7d9b6bd5c4.ի (Ljava/lang/String;Ljava/lang/String;)V
      // 15fc: goto 1600
      // 15ff: athrow
      // 1600: bipush 0
      // 1601: istore 25
      // 1603: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 1606: iload 21
      // 1608: ifne 1615
      // 160b: ifnull 1618
      // 160e: goto 1612
      // 1611: athrow
      // 1612: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 1615: invokevirtual x/oc46245c2b20.ё ()V
      // 1618: iload 25
      // 161a: ireturn
      // 161b: astore 45
      // 161d: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 1620: iload 21
      // 1622: ifne 162f
      // 1625: ifnull 1632
      // 1628: goto 162c
      // 162b: athrow
      // 162c: getstatic x/oc2cf3d80e17.ˡ Lx/oc46245c2b20;
      // 162f: invokevirtual x/oc46245c2b20.ё ()V
      // 1632: aload 45
      // 1634: athrow
   }

   public boolean Ά(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w -2798514639501238729
      // 003: ldc2_w -2798496109681630113
      // 006: lxor
      // 007: lstore 2
      // 008: lload 2
      // 009: dup2
      // 00a: ldc2_w -2798516882637745440
      // 00d: ldc2_w -2798496109681630113
      // 010: lxor
      // 011: lxor
      // 012: lstore 4
      // 014: dup2
      // 015: ldc2_w -2798556130602875121
      // 018: ldc2_w -2798496109681630113
      // 01b: lxor
      // 01c: lxor
      // 01d: lstore 6
      // 01f: dup2
      // 020: ldc2_w -2798467749598789435
      // 023: ldc2_w -2798496109681630113
      // 026: lxor
      // 027: lxor
      // 028: lstore 8
      // 02a: pop2
      // 02b: getstatic x/oc151419fdfe.v Z
      // 02e: istore 10
      // 030: new com/google/gson/JsonParser
      // 033: dup
      // 034: invokespecial com/google/gson/JsonParser.<init> ()V
      // 037: aload 1
      // 038: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 03b: astore 12
      // 03d: aload 12
      // 03f: iload 10
      // 041: ifne 04d
      // 044: ifnull 05c
      // 047: goto 04b
      // 04a: athrow
      // 04b: aload 12
      // 04d: iload 10
      // 04f: ifne 060
      // 052: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 055: ifne 05e
      // 058: goto 05c
      // 05b: athrow
      // 05c: bipush 0
      // 05d: ireturn
      // 05e: aload 12
      // 060: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 063: astore 11
      // 065: aload 11
      // 067: ldc "modules"
      // 069: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 06c: iload 10
      // 06e: ifne 093
      // 071: ifeq 092
      // 074: goto 078
      // 077: athrow
      // 078: aload 11
      // 07a: ldc "modules"
      // 07c: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 07f: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 082: iload 10
      // 084: ifne 093
      // 087: goto 08b
      // 08a: athrow
      // 08b: ifne 094
      // 08e: goto 092
      // 091: athrow
      // 092: bipush 0
      // 093: ireturn
      // 094: goto 09b
      // 097: astore 12
      // 099: bipush 0
      // 09a: ireturn
      // 09b: invokestatic java/util/UUID.randomUUID ()Ljava/util/UUID;
      // 09e: invokevirtual java/util/UUID.toString ()Ljava/lang/String;
      // 0a1: ldc_w "-"
      // 0a4: ldc_w ""
      // 0a7: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 0aa: ldc_w "external-"
      // 0ad: swap
      // 0ae: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0b3: astore 12
      // 0b5: new java/io/File
      // 0b8: dup
      // 0b9: aload 0
      // 0ba: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 0bd: aload 12
      // 0bf: ldc_w ".json"
      // 0c2: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0c7: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 0ca: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0cd: astore 13
      // 0cf: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 0d2: astore 14
      // 0d4: new x/oc151419fdfe
      // 0d7: dup
      // 0d8: aload 12
      // 0da: bipush 0
      // 0db: invokespecial x/oc151419fdfe.<init> (Ljava/lang/String;I)V
      // 0de: astore 15
      // 0e0: bipush 0
      // 0e1: istore 16
      // 0e3: bipush 0
      // 0e4: istore 17
      // 0e6: aload 13
      // 0e8: aload 11
      // 0ea: invokestatic x/oc0326f6e039.Š (Ljava/nio/file/Path;Lcom/google/gson/JsonObject;)V
      // 0ed: iload 10
      // 0ef: aload 0
      // 0f0: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 0f3: aload 15
      // 0f5: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0fa: pop
      // 0fb: bipush 1
      // 0fc: istore 16
      // 0fe: aload 0
      // 0ff: aload 12
      // 101: bipush 0
      // 102: lload 8
      // 104: invokevirtual x/oc7d9b6bd5c4.ʤ (Ljava/lang/String;ZJ)Z
      // 107: istore 17
      // 109: iload 17
      // 10b: istore 18
      // 10d: ifne 12f
      // 110: iload 16
      // 112: ifeq 125
      // 115: aload 0
      // 116: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 119: aload 15
      // 11b: invokeinterface java/util/List.remove (Ljava/lang/Object;)Z 2
      // 120: pop
      // 121: goto 125
      // 124: athrow
      // 125: aload 14
      // 127: putstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 12a: iload 10
      // 12c: ifne 153
      // 12f: iload 17
      // 131: ifeq 144
      // 134: aload 14
      // 136: ifnull 144
      // 139: goto 13d
      // 13c: athrow
      // 13d: invokestatic x/oc2cf3d80e17.ӫ ()V
      // 140: goto 144
      // 143: athrow
      // 144: aload 13
      // 146: lload 6
      // 148: invokestatic x/oc7d9b6bd5c4.Ǽ (Ljava/nio/file/Path;J)V
      // 14b: aload 0
      // 14c: aload 12
      // 14e: lload 4
      // 150: invokevirtual x/oc7d9b6bd5c4.Ʌ (Ljava/lang/String;J)V
      // 153: iload 18
      // 155: ireturn
      // 156: astore 18
      // 158: iload 10
      // 15a: aload 18
      // 15c: invokevirtual java/lang/Exception.printStackTrace ()V
      // 15f: bipush 0
      // 160: istore 19
      // 162: ifne 184
      // 165: iload 16
      // 167: ifeq 17a
      // 16a: aload 0
      // 16b: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 16e: aload 15
      // 170: invokeinterface java/util/List.remove (Ljava/lang/Object;)Z 2
      // 175: pop
      // 176: goto 17a
      // 179: athrow
      // 17a: aload 14
      // 17c: putstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 17f: iload 10
      // 181: ifne 1a8
      // 184: iload 17
      // 186: ifeq 199
      // 189: aload 14
      // 18b: ifnull 199
      // 18e: goto 192
      // 191: athrow
      // 192: invokestatic x/oc2cf3d80e17.ӫ ()V
      // 195: goto 199
      // 198: athrow
      // 199: aload 13
      // 19b: lload 6
      // 19d: invokestatic x/oc7d9b6bd5c4.Ǽ (Ljava/nio/file/Path;J)V
      // 1a0: aload 0
      // 1a1: aload 12
      // 1a3: lload 4
      // 1a5: invokevirtual x/oc7d9b6bd5c4.Ʌ (Ljava/lang/String;J)V
      // 1a8: iload 19
      // 1aa: ireturn
      // 1ab: astore 20
      // 1ad: iload 10
      // 1af: ifne 1d1
      // 1b2: iload 16
      // 1b4: ifeq 1c7
      // 1b7: aload 0
      // 1b8: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 1bb: aload 15
      // 1bd: invokeinterface java/util/List.remove (Ljava/lang/Object;)Z 2
      // 1c2: pop
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: aload 14
      // 1c9: putstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 1cc: iload 10
      // 1ce: ifne 1f5
      // 1d1: iload 17
      // 1d3: ifeq 1e6
      // 1d6: aload 14
      // 1d8: ifnull 1e6
      // 1db: goto 1df
      // 1de: athrow
      // 1df: invokestatic x/oc2cf3d80e17.ӫ ()V
      // 1e2: goto 1e6
      // 1e5: athrow
      // 1e6: aload 13
      // 1e8: lload 6
      // 1ea: invokestatic x/oc7d9b6bd5c4.Ǽ (Ljava/nio/file/Path;J)V
      // 1ed: aload 0
      // 1ee: aload 12
      // 1f0: lload 4
      // 1f2: invokevirtual x/oc7d9b6bd5c4.Ʌ (Ljava/lang/String;J)V
      // 1f5: aload 20
      // 1f7: athrow
   }

   private void Ʌ(String var1, long var2) {
      long var4 = var2 ^ -5381774739798194688L ^ -5381735732552035345L;
      long var6 = var2 ^ -5381736876175418352L ^ -5381735732552035345L;
      boolean var10000 = oc151419fdfe.v;
      File[] var9 = this.ю
         .listFiles(
            (var3, var4x) -> {
               byte var5 = oc151419fdfe.v;
               int var6x = a(-894422246 ^ -894435276, 8827456530811027203L ^ 2216321117304031734L ^ var6);

               while (true) {
                  switch (var6x) {
                     case -915915875:
                        return false;
                     case 357500207:
                        label69: {
                           int var10000x;
                           label74: {
                              label67: {
                                 long var10001;
                                 label66: {
                                    label75: {
                                       try {
                                          var10000x = var4x.startsWith(
                                             var1
                                                + a(
                                                   (-1103787186 ^ -894435276) + (-894404274 ^ -894435276),
                                                   (1103787186 ^ -894435276) + -((char)(894419970 ^ -894435276)),
                                                   (int)var6
                                                )
                                          );
                                          if (var6 < 0L) {
                                             break label74;
                                          }

                                          if (var5 != 0) {
                                             break label67;
                                          }

                                          if (var10000x == 0) {
                                             break label75;
                                          }
                                       } catch (RuntimeException var8x) {
                                          throw var8x;
                                       }

                                       var10000x = -894426003 ^ -894435276;
                                       var10001 = 3396255599171561502L ^ 2216321117304031734L;
                                       if (var6 <= 0L) {
                                          break label66;
                                       }

                                       var6x = a(var10000x, var10001 ^ var6);
                                       if (var5 == 0) {
                                          break;
                                       }
                                    }

                                    var10000x = -894414653 ^ -894435276;
                                    var10001 = 2471845971409509599L ^ 2216321117304031734L ^ var6;
                                 }

                                 var10000x = a(var10000x, var10001);
                              }

                              var6x = var10000x;
                              if (var6 < 1L) {
                                 break label69;
                              }

                              var10000x = var5;
                           }

                           if (var10000x == 0) {
                              break;
                           }
                        }
                     case 258242738:
                        int var10x;
                        label48: {
                           long var12x;
                           long var10002;
                           label47: {
                              label73: {
                                 try {
                                    var10x = var4x.endsWith(
                                       a(
                                          (-1103787186 ^ -894435276) + (-894404271 ^ -894435276),
                                          (1103787186 ^ -894435276) + -((char)(894426457 ^ -894435276)),
                                          (int)var6
                                       )
                                    );
                                    if (var5 != 0) {
                                       break label48;
                                    }

                                    if (var10x == 0) {
                                       break label73;
                                    }
                                 } catch (RuntimeException var7) {
                                    throw var7;
                                 }

                                 var10x = -894404479 ^ -894435276;
                                 var12x = 8771836330380309632L ^ 2216321117304031734L;
                                 var10002 = var6;
                                 if (var6 <= 0L) {
                                    break label47;
                                 }

                                 var6x = a(var10x, var12x ^ var6);
                                 if (var5 == 0) {
                                    break;
                                 }
                              }

                              var10x = -894406379 ^ -894435276;
                              var12x = 1830713387442650406L ^ 2216321117304031734L;
                              var10002 = var6;
                           }

                           var10x = a(var10x, var12x ^ var10002);
                        }

                        var6x = var10x;
                        break;
                     case 1283023798:
                        return true;
                     default:
                        throw null;
                  }
               }
            }
         );
      boolean var8 = var10000;

      label32: {
         try {
            var15 = var9;
            if (var8) {
               break label32;
            }

            if (var9 == null) {
               return;
            }
         } catch (RuntimeException var14) {
            throw var14;
         }

         var15 = var9;
      }

      File[] var10 = var15;
      int var11 = var10.length;
      int var12 = 0;

      while (var12 < var11) {
         File var13 = var10[var12];
         Ǽ(var13.toPath(), var4);
         var12++;
         if (var8) {
            break;
         }
      }
   }

   static void Ћ(JsonArray param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w 1312979417602829438
      // 003: ldc2_w 1312998258342424469
      // 006: lxor
      // 007: lstore 1
      // 008: lload 1
      // 009: dup2
      // 00a: ldc2_w 1313055150599740064
      // 00d: ldc2_w 1312998258342424469
      // 010: lxor
      // 011: lxor
      // 012: lstore 3
      // 013: pop2
      // 014: getstatic x/oc151419fdfe.v Z
      // 017: istore 5
      // 019: aload 0
      // 01a: iload 5
      // 01c: ifne 028
      // 01f: ifnonnull 027
      // 022: goto 026
      // 025: athrow
      // 026: return
      // 027: aload 0
      // 028: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 02b: astore 6
      // 02d: aload 6
      // 02f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 034: ifeq 1f2
      // 037: aload 6
      // 039: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 03e: checkcast com/google/gson/JsonElement
      // 041: astore 7
      // 043: aload 7
      // 045: iload 5
      // 047: ifne 053
      // 04a: ifnull 02d
      // 04d: goto 051
      // 050: athrow
      // 051: aload 7
      // 053: iload 5
      // 055: ifne 06d
      // 058: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 05b: ifne 06b
      // 05e: goto 062
      // 061: athrow
      // 062: iload 5
      // 064: ifeq 02d
      // 067: goto 06b
      // 06a: athrow
      // 06b: aload 7
      // 06d: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 070: astore 8
      // 072: aload 8
      // 074: iload 5
      // 076: ifne 092
      // 079: ldc_w "name"
      // 07c: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 07f: ifeq 098
      // 082: goto 086
      // 085: athrow
      // 086: aload 8
      // 088: ldc_w "name"
      // 08b: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08e: goto 092
      // 091: athrow
      // 092: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 095: goto 09b
      // 098: ldc_w ""
      // 09b: astore 9
      // 09d: iload 5
      // 09f: ifne 0df
      // 0a2: ldc_w "HUD"
      // 0a5: aload 9
      // 0a7: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0aa: ifne 0c9
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: ldc_w "ArrayList"
      // 0b4: iload 5
      // 0b6: ifne 0eb
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aload 9
      // 0bf: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0c2: ifeq 0e4
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: aload 8
      // 0cb: ldc_w "setting.fontSize"
      // 0ce: ldc_w "Scale"
      // 0d1: ldc2_w 0.5
      // 0d4: lload 3
      // 0d5: ldc2_w 2.0
      // 0d8: invokestatic x/oc7d9b6bd5c4.р (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;DJD)V
      // 0db: goto 0df
      // 0de: athrow
      // 0df: iload 5
      // 0e1: ifeq 1ed
      // 0e4: ldc_w "Nametags"
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: iload 5
      // 0ed: ifne 11e
      // 0f0: aload 9
      // 0f2: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0f5: ifeq 117
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 8
      // 0fe: ldc_w "setting.scale"
      // 101: ldc_w "Scale"
      // 104: ldc2_w 0.1
      // 107: lload 3
      // 108: ldc2_w 2.0
      // 10b: invokestatic x/oc7d9b6bd5c4.р (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;DJD)V
      // 10e: iload 5
      // 110: ifeq 1ed
      // 113: goto 117
      // 116: athrow
      // 117: ldc_w "TNT Timer"
      // 11a: goto 11e
      // 11d: athrow
      // 11e: iload 5
      // 120: ifne 136
      // 123: aload 9
      // 125: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 128: ifne 147
      // 12b: goto 12f
      // 12e: athrow
      // 12f: ldc_w "TNTTimer"
      // 132: goto 136
      // 135: athrow
      // 136: aload 9
      // 138: iload 5
      // 13a: ifne 174
      // 13d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 140: ifeq 162
      // 143: goto 147
      // 146: athrow
      // 147: aload 8
      // 149: ldc_w "setting.scale"
      // 14c: ldc_w "Scale"
      // 14f: ldc2_w 0.5
      // 152: lload 3
      // 153: ldc2_w 3.0
      // 156: invokestatic x/oc7d9b6bd5c4.р (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;DJD)V
      // 159: iload 5
      // 15b: ifeq 1ed
      // 15e: goto 162
      // 161: athrow
      // 162: ldc_w "BedESP"
      // 165: iload 5
      // 167: ifne 19c
      // 16a: goto 16e
      // 16d: athrow
      // 16e: aload 9
      // 170: goto 174
      // 173: athrow
      // 174: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 177: ifeq 195
      // 17a: aload 8
      // 17c: ldc_w "setting.defenseScale"
      // 17f: ldc_w "Defense scale"
      // 182: ldc2_w 0.1
      // 185: lload 3
      // 186: ldc2_w 2.0
      // 189: invokestatic x/oc7d9b6bd5c4.р (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;DJD)V
      // 18c: iload 5
      // 18e: ifeq 1ed
      // 191: goto 195
      // 194: athrow
      // 195: ldc_w "KeyStrokes"
      // 198: goto 19c
      // 19b: athrow
      // 19c: aload 9
      // 19e: iload 5
      // 1a0: ifne 1d1
      // 1a3: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1a6: ifeq 1c8
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: aload 8
      // 1af: ldc_w "setting.hudScale"
      // 1b2: ldc_w "Scale"
      // 1b5: ldc2_w 0.5
      // 1b8: lload 3
      // 1b9: ldc2_w 2.0
      // 1bc: invokestatic x/oc7d9b6bd5c4.р (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;DJD)V
      // 1bf: iload 5
      // 1c1: ifeq 1ed
      // 1c4: goto 1c8
      // 1c7: athrow
      // 1c8: ldc_w "TargetHUD"
      // 1cb: aload 9
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1d4: ifeq 1ed
      // 1d7: aload 8
      // 1d9: ldc_w "setting.hudScale"
      // 1dc: ldc_w "Scale"
      // 1df: ldc2_w 0.5
      // 1e2: lload 3
      // 1e3: ldc2_w 2.0
      // 1e6: invokestatic x/oc7d9b6bd5c4.р (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;DJD)V
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: iload 5
      // 1ef: ifeq 02d
      // 1f2: return
   }

   static void Ƶ(JsonArray param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w 1692710312007431198
      // 003: ldc2_w 1692763295422822662
      // 006: lxor
      // 007: lstore 1
      // 008: lload 1
      // 009: dup2
      // 00a: ldc2_w 1692672354554716888
      // 00d: ldc2_w 1692763295422822662
      // 010: lxor
      // 011: lxor
      // 012: lstore 3
      // 013: pop2
      // 014: getstatic x/oc151419fdfe.v Z
      // 017: istore 5
      // 019: aload 0
      // 01a: iload 5
      // 01c: ifne 028
      // 01f: ifnonnull 027
      // 022: goto 026
      // 025: athrow
      // 026: return
      // 027: aload 0
      // 028: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 02b: astore 6
      // 02d: aload 6
      // 02f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 034: ifeq 1a3
      // 037: aload 6
      // 039: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 03e: checkcast com/google/gson/JsonElement
      // 041: astore 7
      // 043: aload 7
      // 045: iload 5
      // 047: ifne 04f
      // 04a: ifnull 02d
      // 04d: aload 7
      // 04f: iload 5
      // 051: ifne 069
      // 054: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 057: ifne 067
      // 05a: goto 05e
      // 05d: athrow
      // 05e: iload 5
      // 060: ifeq 02d
      // 063: goto 067
      // 066: athrow
      // 067: aload 7
      // 069: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 06c: astore 8
      // 06e: ldc_w "Animations"
      // 071: aload 8
      // 073: iload 5
      // 075: ifne 091
      // 078: ldc_w "name"
      // 07b: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 07e: ifeq 097
      // 081: goto 085
      // 084: athrow
      // 085: aload 8
      // 087: ldc_w "name"
      // 08a: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08d: goto 091
      // 090: athrow
      // 091: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 094: goto 09a
      // 097: ldc_w ""
      // 09a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 09d: ifne 0a9
      // 0a0: iload 5
      // 0a2: ifeq 02d
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: lload 3
      // 0aa: aload 8
      // 0ac: ldc_w "setting.mode"
      // 0af: invokestatic x/oc7d9b6bd5c4.ӟ (JLcom/google/gson/JsonObject;Ljava/lang/String;)V
      // 0b2: lload 3
      // 0b3: aload 8
      // 0b5: ldc_w "Mode"
      // 0b8: invokestatic x/oc7d9b6bd5c4.ӟ (JLcom/google/gson/JsonObject;Ljava/lang/String;)V
      // 0bb: aload 8
      // 0bd: ldc_w "portableSettings"
      // 0c0: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0c3: astore 9
      // 0c5: aload 9
      // 0c7: iload 5
      // 0c9: ifne 0d5
      // 0cc: ifnull 02d
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 9
      // 0d5: iload 5
      // 0d7: ifne 0ef
      // 0da: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 0dd: ifne 0ed
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: iload 5
      // 0e6: ifeq 02d
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: aload 9
      // 0ef: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 0f2: astore 10
      // 0f4: aload 10
      // 0f6: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 0f9: astore 11
      // 0fb: aload 11
      // 0fd: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 102: ifeq 19e
      // 105: aload 11
      // 107: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 10c: iload 5
      // 10e: ifne 03e
      // 111: checkcast com/google/gson/JsonElement
      // 114: astore 12
      // 116: aload 12
      // 118: iload 5
      // 11a: ifne 126
      // 11d: ifnull 0fb
      // 120: goto 124
      // 123: athrow
      // 124: aload 12
      // 126: iload 5
      // 128: ifne 140
      // 12b: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 12e: ifne 13e
      // 131: goto 135
      // 134: athrow
      // 135: iload 5
      // 137: ifeq 0fb
      // 13a: goto 13e
      // 13d: athrow
      // 13e: aload 12
      // 140: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 143: astore 13
      // 145: aload 13
      // 147: iload 5
      // 149: ifne 165
      // 14c: ldc_w "name"
      // 14f: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 152: ifeq 199
      // 155: goto 159
      // 158: athrow
      // 159: aload 13
      // 15b: ldc_w "name"
      // 15e: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 161: goto 165
      // 164: athrow
      // 165: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 168: iload 5
      // 16a: ifne 189
      // 16d: ifeq 199
      // 170: goto 174
      // 173: athrow
      // 174: ldc_w "Mode"
      // 177: aload 13
      // 179: ldc_w "name"
      // 17c: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 17f: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 182: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 185: goto 189
      // 188: athrow
      // 189: ifeq 199
      // 18c: lload 3
      // 18d: aload 13
      // 18f: ldc_w "value"
      // 192: invokestatic x/oc7d9b6bd5c4.ӟ (JLcom/google/gson/JsonObject;Ljava/lang/String;)V
      // 195: goto 199
      // 198: athrow
      // 199: iload 5
      // 19b: ifeq 0fb
      // 19e: iload 5
      // 1a0: ifeq 02d
      // 1a3: return
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void ӟ(long var0, JsonObject var2, String var3) {
      double var5 = 0.0;
      int var10000 = 56092286 ^ 56068199;
      int var7 = 0;
      byte var4 = oc151419fdfe.v;
      long var10001 = 6403299018435050915L ^ 6637795584497648598L ^ var0;
      int var8 = 0;
      int var9 = a(var10000, var10001);

      label411:
      while (true) {
         var10000 = var9;

         label414: {
            label404:
            while (true) {
               label416: {
                  label451: {
                     label418: {
                        label419: {
                           label398: {
                              label420: {
                                 label396: {
                                    label421: {
                                       label394: {
                                          label422: {
                                             label456: {
                                                long var10002;
                                                label390: {
                                                   label425: {
                                                      label388: {
                                                         label426: {
                                                            label386: {
                                                               label427: {
                                                                  switch (var10000) {
                                                                     case -1692406142:
                                                                        break label419;
                                                                     case -1621849112:
                                                                        break label426;
                                                                     case -1487529384:
                                                                        break label422;
                                                                     case -1355546265:
                                                                        label428: {
                                                                           label366: {
                                                                              label365: {
                                                                                 label429: {
                                                                                    try {
                                                                                       var10000 = var7;
                                                                                       if (var0 < 0L) {
                                                                                          break label428;
                                                                                       }

                                                                                       if (var4 != 0) {
                                                                                          break label366;
                                                                                       }

                                                                                       if (var7
                                                                                          <= a(
                                                                                             56092023 ^ 56068199,
                                                                                             7232089165962624734L ^ 6637795584497648598L ^ var0
                                                                                          )) {
                                                                                          break label429;
                                                                                       }
                                                                                    } catch (RuntimeException var19) {
                                                                                       throw var19;
                                                                                    }

                                                                                    var10000 = 56097752 ^ 56068199;
                                                                                    if (var0 < 0L) {
                                                                                       break label365;
                                                                                    }

                                                                                    var9 = a(var10000, 9156841328581943329L ^ 6637795584497648598L ^ var0);
                                                                                    if (var4 == 0) {
                                                                                       continue label411;
                                                                                    }
                                                                                 }

                                                                                 var10000 = 56090605 ^ 56068199;
                                                                              }

                                                                              var10000 = a(var10000, 8951909336715854969L ^ 6637795584497648598L ^ var0);
                                                                           }

                                                                           var9 = var10000;
                                                                           if (var0 <= 0L) {
                                                                              break;
                                                                           }

                                                                           var10000 = var4;
                                                                        }

                                                                        if (var10000 == 0) {
                                                                           continue label411;
                                                                        }
                                                                     case -856673226:
                                                                        var8 = 1;
                                                                        break;
                                                                     case -1185624349:
                                                                        break label451;
                                                                     case -1180960590:
                                                                        break label456;
                                                                     case -1173761756:
                                                                        label434: {
                                                                           label314: {
                                                                              label313: {
                                                                                 label435: {
                                                                                    try {
                                                                                       var10000 = var7;
                                                                                       if (var0 <= 0L) {
                                                                                          break label434;
                                                                                       }

                                                                                       if (var4 != 0) {
                                                                                          break label314;
                                                                                       }

                                                                                       if (var7 > (56068197 ^ 56068199)) {
                                                                                          break label435;
                                                                                       }
                                                                                    } catch (RuntimeException var17) {
                                                                                       throw var17;
                                                                                    }

                                                                                    var10000 = 56094150 ^ 56068199;
                                                                                    var10001 = 6848151744776517234L ^ 6637795584497648598L ^ var0;
                                                                                    if (var0 < 1L) {
                                                                                       break label313;
                                                                                    }

                                                                                    var9 = a(var10000, var10001);
                                                                                    if (var4 == 0) {
                                                                                       continue label411;
                                                                                    }
                                                                                 }

                                                                                 var10000 = 56090815 ^ 56068199;
                                                                                 var10001 = 2437218838201252704L ^ 6637795584497648598L ^ var0;
                                                                              }

                                                                              var10000 = a(var10000, var10001);
                                                                           }

                                                                           var9 = var10000;
                                                                           if (var0 <= 1L) {
                                                                              break label456;
                                                                           }

                                                                           var10000 = var4;
                                                                        }

                                                                        if (var10000 == 0) {
                                                                           continue label411;
                                                                        }
                                                                        break label456;
                                                                     case -227618658:
                                                                        break label421;
                                                                     case -104503375:
                                                                        break label414;
                                                                     case 490095976:
                                                                        return;
                                                                     case 597341808:
                                                                        break label404;
                                                                     case 1145944695:
                                                                        break label425;
                                                                     case 1179249633:
                                                                        break label398;
                                                                     case 1441521021:
                                                                        break label427;
                                                                     case 1852082391:
                                                                        return;
                                                                     default:
                                                                        throw null;
                                                                  }

                                                                  var10000 = var4;
                                                                  if (var0 <= 1L) {
                                                                     break label386;
                                                                  }

                                                                  var9 = a(56067256 ^ 56068199, 6603561898270678788L ^ 6637795584497648598L ^ var0);
                                                                  if (var4 == 0) {
                                                                     continue label411;
                                                                  }
                                                               }

                                                               try {
                                                                  var10000 = var7;
                                                               } catch (RuntimeException var10) {
                                                                  throw var10;
                                                               }
                                                            }

                                                            label431: {
                                                               label341: {
                                                                  label340: {
                                                                     label432: {
                                                                        try {
                                                                           if (var0 < 0L) {
                                                                              break label431;
                                                                           }

                                                                           if (var4 != 0) {
                                                                              break label341;
                                                                           }

                                                                           if (var10000 != (56068195 ^ 56068199)) {
                                                                              break label432;
                                                                           }
                                                                        } catch (RuntimeException var18) {
                                                                           throw var18;
                                                                        }

                                                                        var10000 = 56079640 ^ 56068199;
                                                                        if (var0 < 0L) {
                                                                           break label340;
                                                                        }

                                                                        var9 = a(var10000, 8963416754964983479L ^ 6637795584497648598L ^ var0);
                                                                        if (var4 == 0) {
                                                                           continue label411;
                                                                        }
                                                                     }

                                                                     var10000 = 56086865 ^ 56068199;
                                                                  }

                                                                  var10000 = a(var10000, 762521679766260466L ^ 6637795584497648598L ^ var0);
                                                               }

                                                               var9 = var10000;
                                                               if (var0 <= 0L) {
                                                                  break label388;
                                                               }

                                                               var10000 = var4;
                                                            }

                                                            if (var10000 == 0) {
                                                               continue label411;
                                                            }
                                                         }

                                                         var8 = 56068195 ^ 56068199;
                                                      }

                                                      var10000 = var4;
                                                      var41 = 56067256 ^ 56068199;
                                                      var10002 = 6603561898270678788L ^ 6637795584497648598L;
                                                      if (var0 <= 0L) {
                                                         break label390;
                                                      }

                                                      var9 = a(var41, var10002 ^ var0);
                                                      if (var4 == 0) {
                                                         continue label411;
                                                      }
                                                   }

                                                   var8 = 56068196 ^ 56068199;
                                                   var10000 = var4;
                                                   var41 = 56067256 ^ 56068199;
                                                   var10002 = 6603561898270678788L ^ 6637795584497648598L ^ var0;
                                                }

                                                var42 = a(var41, var10002);
                                                if (var0 <= 0L) {
                                                   break label394;
                                                }

                                                var9 = var42;
                                                if (var10000 == 0) {
                                                   continue label411;
                                                }
                                                break label422;
                                             }

                                             label437: {
                                                label290: {
                                                   label289: {
                                                      label438: {
                                                         try {
                                                            var10000 = var2.getAsJsonPrimitive(var3).isNumber();
                                                            if (var0 <= 1L) {
                                                               break label437;
                                                            }

                                                            if (var4 != 0) {
                                                               break label290;
                                                            }

                                                            if (var10000 != 0) {
                                                               break label438;
                                                            }
                                                         } catch (RuntimeException var16) {
                                                            throw var16;
                                                         }

                                                         var10000 = a(56070308 ^ 56068199, 2751068195657042691L ^ 6637795584497648598L ^ var0);
                                                         if (var0 < 1L) {
                                                            break label289;
                                                         }

                                                         var9 = var10000;
                                                         if (var4 == 0) {
                                                            continue label411;
                                                         }
                                                      }

                                                      var10000 = 56077267 ^ 56068199;
                                                   }

                                                   var10000 = a(var10000, 8877826172221517951L ^ 6637795584497648598L ^ var0);
                                                }

                                                var9 = var10000;
                                                if (var0 < 1L) {
                                                   break label396;
                                                }

                                                var10000 = var4;
                                             }

                                             if (var10000 == 0) {
                                                continue label411;
                                             }
                                             break label421;
                                          }

                                          try {
                                             var10000 = var7;
                                             if (var0 < 1L) {
                                                break label420;
                                             }

                                             var42 = var4;
                                          } catch (RuntimeException var15) {
                                             throw var15;
                                          }
                                       }

                                       label267: {
                                          label266: {
                                             label440: {
                                                try {
                                                   if (var42 != 0) {
                                                      break label267;
                                                   }

                                                   if (var10000 != a(56078214 ^ 56068199, 1472353209341572112L ^ 6637795584497648598L ^ var0)) {
                                                      break label440;
                                                   }
                                                } catch (RuntimeException var14) {
                                                   throw var14;
                                                }

                                                var10000 = 56072884 ^ 56068199;
                                                var10001 = 4033777398347677958L ^ 6637795584497648598L ^ var0;
                                                if (var0 < 0L) {
                                                   break label266;
                                                }

                                                var9 = a(var10000, var10001);
                                                if (var4 == 0) {
                                                   continue label411;
                                                }
                                             }

                                             var10000 = 56096438 ^ 56068199;
                                             var10001 = 3259817518023191893L ^ 6637795584497648598L ^ var0;
                                          }

                                          var10000 = a(var10000, var10001);
                                       }

                                       var9 = var10000;
                                       if (var0 < 1L) {
                                          break label398;
                                       }

                                       var10000 = var4;
                                       break label420;
                                    }

                                    var8 = var7;
                                 }

                                 var10000 = var4;
                                 var40 = a(56093561 ^ 56068199, 3398102886664155367L ^ 6637795584497648598L ^ var0);
                                 if (var0 < 0L) {
                                    break label418;
                                 }

                                 var9 = var40;
                                 if (var4 == 0) {
                                    continue label411;
                                 }
                                 break label419;
                              }

                              if (var10000 == 0) {
                                 continue label411;
                              }
                           }

                           label441: {
                              label245: {
                                 long var47;
                                 label244: {
                                    label442: {
                                       try {
                                          var10000 = var7;
                                          if (var0 < 1L) {
                                             break label441;
                                          }

                                          if (var4 != 0) {
                                             break label245;
                                          }

                                          if (var7 < 0) {
                                             break label442;
                                          }
                                       } catch (RuntimeException var13) {
                                          throw var13;
                                       }

                                       var10000 = 56066733 ^ 56068199;
                                       var10001 = 5217684193031805272L ^ 6637795584497648598L;
                                       var47 = var0;
                                       if (var0 <= 1L) {
                                          break label244;
                                       }

                                       var9 = a(var10000, var10001 ^ var0);
                                       if (var4 == 0) {
                                          continue label411;
                                       }
                                    }

                                    var10000 = 56097752 ^ 56068199;
                                    var10001 = 9156841328581943329L ^ 6637795584497648598L;
                                    var47 = var0;
                                 }

                                 var10000 = a(var10000, var10001 ^ var47);
                              }

                              var9 = var10000;
                              if (var0 < 1L) {
                                 break label451;
                              }

                              var10000 = var4;
                           }

                           if (var10000 == 0) {
                              continue label411;
                           }
                           break label451;
                        }

                        var5 = var2.getAsJsonPrimitive(var3).getAsDouble();
                        if (var0 <= 0L) {
                           break label416;
                        }

                        var10000 = (int)var5;
                        var40 = var4;
                     }

                     if (var40 == 0) {
                        long var49;
                        label220: {
                           var7 = var10000;
                           var10000 = var7;
                           if (var0 > 0L) {
                              if (var7 == var5) {
                                 var10000 = 56090271 ^ 56068199;
                                 var10001 = 6010276709197382916L ^ 6637795584497648598L;
                                 var49 = var0;
                                 if (var0 <= 0L) {
                                    break label220;
                                 }

                                 var9 = a(var10000, var10001 ^ var0);
                                 if (var4 == 0) {
                                    continue label411;
                                 }
                              }

                              var10000 = 56098560 ^ 56068199;
                           }

                           var10001 = 1924388336823018686L ^ 6637795584497648598L;
                           var49 = var0;
                        }

                        var10000 = a(var10000, var10001 ^ var49);
                     }

                     var9 = var10000;
                     break label416;
                  }

                  label445: {
                     label209: {
                        label208: {
                           label446: {
                              try {
                                 var10000 = var2.has(var3);
                                 if (var0 <= 1L) {
                                    break label445;
                                 }

                                 if (var4 != 0) {
                                    break label209;
                                 }

                                 if (var10000 == 0) {
                                    break label446;
                                 }
                              } catch (RuntimeException var12) {
                                 throw var12;
                              }

                              var10000 = a(56094071 ^ 56068199, 4858674729325180565L ^ 6637795584497648598L ^ var0);
                              if (var0 <= 1L) {
                                 break label208;
                              }

                              var9 = var10000;
                              if (var4 == 0) {
                                 continue label411;
                              }
                           }

                           var10000 = 56084277 ^ 56068199;
                        }

                        var10000 = a(var10000, 7353373582990580903L ^ 6637795584497648598L ^ var0);
                     }

                     var9 = var10000;
                     if (var0 <= 1L) {
                        break;
                     }

                     var10000 = var4;
                  }

                  if (var10000 == 0) {
                     continue label411;
                  }
                  break;
               }

               var10000 = var4;
               if (var0 > 1L) {
                  if (var4 == 0) {
                     continue label411;
                  }

                  return;
               }
            }

            label183: {
               label182: {
                  long var48;
                  label181: {
                     label448: {
                        try {
                           var10000 = var2.get(var3).isJsonPrimitive();
                           if (var0 <= 1L) {
                              break label183;
                           }

                           if (var4 != 0) {
                              break label182;
                           }

                           if (var10000 == 0) {
                              break label448;
                           }
                        } catch (RuntimeException var11) {
                           throw var11;
                        }

                        var10000 = 56090789 ^ 56068199;
                        var10001 = 7374052265533848405L ^ 6637795584497648598L;
                        var48 = var0;
                        if (var0 <= 1L) {
                           break label181;
                        }

                        var9 = a(var10000, var10001 ^ var0);
                        if (var4 == 0) {
                           continue;
                        }
                     }

                     var10000 = 56084277 ^ 56068199;
                     var10001 = 7353373582990580903L ^ 6637795584497648598L;
                     var48 = var0;
                  }

                  var10000 = a(var10000, var10001 ^ var48);
               }

               var9 = var10000;
               var10000 = var4;
            }

            if (var10000 == 0) {
               continue;
            }
         }

         var2.addProperty(var3, var8);
         return;
      }
   }

   static void Ѷ(oc69da1aa7f5 param0, JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc151419fdfe.v Z
      // 003: aload 0
      // 004: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 007: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 00a: astore 3
      // 00b: istore 2
      // 00c: aload 3
      // 00d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 012: ifeq 139
      // 015: aload 3
      // 016: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 01b: checkcast x/N
      // 01e: astore 4
      // 020: aload 4
      // 022: iload 2
      // 023: ifne 032
      // 026: instanceof x/oca9cc61aada
      // 029: ifeq 00c
      // 02c: goto 030
      // 02f: athrow
      // 030: aload 4
      // 032: checkcast x/oca9cc61aada
      // 035: astore 5
      // 037: aload 5
      // 039: iload 2
      // 03a: ifne 04d
      // 03d: getfield x/oca9cc61aada.Æ Z
      // 040: ifne 04b
      // 043: goto 047
      // 046: athrow
      // 047: goto 00c
      // 04a: athrow
      // 04b: aload 5
      // 04d: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 050: astore 6
      // 052: aload 6
      // 054: arraylength
      // 055: iload 2
      // 056: ifne 079
      // 059: ldc_w 846792270
      // 05c: ldc_w 846792269
      // 05f: ixor
      // 060: if_icmplt 00c
      // 063: goto 067
      // 066: athrow
      // 067: ldc_w "Minecraft"
      // 06a: aload 6
      // 06c: bipush 0
      // 06d: iload 2
      // 06e: ifne 082
      // 071: aaload
      // 072: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 075: goto 079
      // 078: athrow
      // 079: ifeq 00c
      // 07c: ldc_w "Sf-Bold"
      // 07f: aload 6
      // 081: bipush 1
      // 082: aaload
      // 083: iload 2
      // 084: ifne 0a6
      // 087: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 08a: ifeq 00c
      // 08d: goto 091
      // 090: athrow
      // 091: ldc_w "ProductSans"
      // 094: iload 2
      // 095: ifne 0b6
      // 098: aload 6
      // 09a: ldc_w 846792271
      // 09d: ldc_w 846792269
      // 0a0: ixor
      // 0a1: aaload
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0a9: ifne 0b0
      // 0ac: goto 00c
      // 0af: athrow
      // 0b0: aload 0
      // 0b1: aload 4
      // 0b3: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 0b6: astore 7
      // 0b8: aload 1
      // 0b9: iload 2
      // 0ba: ifne 0d4
      // 0bd: aload 7
      // 0bf: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0c2: ifeq 0d3
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: aload 1
      // 0ca: aload 7
      // 0cc: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0cf: goto 0dc
      // 0d2: athrow
      // 0d3: aload 1
      // 0d4: aload 4
      // 0d6: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 0d9: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0dc: astore 8
      // 0de: aload 8
      // 0e0: iload 2
      // 0e1: ifne 0ed
      // 0e4: ifnull 00c
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 8
      // 0ed: iload 2
      // 0ee: ifne 0fd
      // 0f1: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 0f4: ifeq 00c
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: aload 8
      // 0fd: iload 2
      // 0fe: ifne 114
      // 101: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 104: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 107: ifne 112
      // 10a: goto 10e
      // 10d: athrow
      // 10e: goto 00c
      // 111: athrow
      // 112: aload 8
      // 114: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 117: invokestatic x/oc3ebac73392.Ѡ (I)I
      // 11a: istore 9
      // 11c: iload 2
      // 11d: aload 1
      // 11e: aload 7
      // 120: iload 9
      // 122: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 125: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 128: aload 1
      // 129: aload 4
      // 12b: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 12e: iload 9
      // 130: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 133: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 136: ifeq 00c
      // 139: return
   }

   static void ԟ(oc69da1aa7f5 param0, JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: getstatic x/oc6a43806f12.j Lx/oca9cc61aada;
      // 06: astore 3
      // 07: istore 2
      // 08: aload 0
      // 09: aload 3
      // 0a: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 0d: astore 4
      // 0f: aload 1
      // 10: iload 2
      // 11: ifne 2b
      // 14: aload 4
      // 16: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 19: ifeq 2a
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 1
      // 21: aload 4
      // 23: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 26: goto 32
      // 29: athrow
      // 2a: aload 1
      // 2b: aload 3
      // 2c: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 2f: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 32: astore 5
      // 34: aload 5
      // 36: iload 2
      // 37: ifne 43
      // 3a: ifnull 68
      // 3d: goto 41
      // 40: athrow
      // 41: aload 5
      // 43: iload 2
      // 44: ifne 57
      // 47: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 4a: ifeq 68
      // 4d: goto 51
      // 50: athrow
      // 51: aload 5
      // 53: goto 57
      // 56: athrow
      // 57: iload 2
      // 58: ifne 6c
      // 5b: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 5e: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 61: ifne 6a
      // 64: goto 68
      // 67: athrow
      // 68: return
      // 69: athrow
      // 6a: aload 5
      // 6c: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 6f: istore 6
      // 71: iload 6
      // 73: iload 2
      // 74: ifne 85
      // 77: ifne 83
      // 7a: goto 7e
      // 7d: athrow
      // 7e: bipush 0
      // 7f: goto a6
      // 82: athrow
      // 83: iload 6
      // 85: iload 2
      // 86: ifne 9c
      // 89: ldc_w -2028855542
      // 8c: ldc_w -2028855544
      // 8f: ixor
      // 90: if_icmpne 9f
      // 93: goto 97
      // 96: athrow
      // 97: bipush 1
      // 98: goto 9c
      // 9b: athrow
      // 9c: goto a6
      // 9f: ldc_w -2028855542
      // a2: ldc_w -2028855544
      // a5: ixor
      // a6: istore 7
      // a8: aload 1
      // a9: aload 4
      // ab: iload 7
      // ad: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // b0: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // b3: aload 1
      // b4: aload 3
      // b5: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // b8: iload 7
      // ba: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // bd: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // c0: return
   }

   static void э(JsonObject param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: ldc_w -610716721
      // 06: ldc_w -610716723
      // 09: ixor
      // 0a: anewarray 493
      // 0d: dup
      // 0e: bipush 0
      // 0f: ldc_w "setting.mode"
      // 12: aastore
      // 13: dup
      // 14: bipush 1
      // 15: ldc_w "Mode"
      // 18: aastore
      // 19: astore 2
      // 1a: aload 2
      // 1b: arraylength
      // 1c: istore 3
      // 1d: bipush 0
      // 1e: istore 4
      // 20: istore 1
      // 21: iload 4
      // 23: iload 3
      // 24: if_icmpge dc
      // 27: aload 2
      // 28: iload 4
      // 2a: aaload
      // 2b: astore 5
      // 2d: iload 1
      // 2e: aload 0
      // 2f: aload 5
      // 31: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 34: astore 6
      // 36: ifne d8
      // 39: aload 6
      // 3b: ifnull d5
      // 3e: goto 42
      // 41: athrow
      // 42: aload 6
      // 44: iload 1
      // 45: ifne 60
      // 48: goto 4c
      // 4b: athrow
      // 4c: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 4f: ifeq d5
      // 52: goto 56
      // 55: athrow
      // 56: aload 6
      // 58: iload 1
      // 59: ifne 77
      // 5c: goto 60
      // 5f: athrow
      // 60: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 63: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 66: ifne 71
      // 69: iload 1
      // 6a: ifeq d5
      // 6d: goto 71
      // 70: athrow
      // 71: aload 6
      // 73: goto 77
      // 76: athrow
      // 77: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 7a: dstore 7
      // 7c: dload 7
      // 7e: iload 1
      // 7f: ifne 9a
      // 82: ldc2_w 4.0
      // 85: dcmpl
      // 86: ifne 98
      // 89: goto 8d
      // 8c: athrow
      // 8d: ldc_w -610716721
      // 90: ldc_w -610716723
      // 93: ixor
      // 94: goto c8
      // 97: athrow
      // 98: dload 7
      // 9a: ldc2_w 5.0
      // 9d: iload 1
      // 9e: ifne b7
      // a1: dcmpl
      // a2: ifne b4
      // a5: goto a9
      // a8: athrow
      // a9: ldc_w -610716722
      // ac: ldc_w -610716723
      // af: ixor
      // b0: goto c8
      // b3: athrow
      // b4: dload 7
      // b6: dconst_1
      // b7: dcmpl
      // b8: iload 1
      // b9: ifne c4
      // bc: ifne c7
      // bf: goto c3
      // c2: athrow
      // c3: bipush 1
      // c4: goto c8
      // c7: bipush 0
      // c8: istore 9
      // ca: aload 0
      // cb: aload 5
      // cd: iload 9
      // cf: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // d2: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // d5: iinc 4 1
      // d8: iload 1
      // d9: ifeq 21
      // dc: return
   }

   static void ь(JsonObject param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 2127070711819294829
      // 03: ldc2_w 2127010964016453424
      // 06: lxor
      // 07: lstore 1
      // 08: lload 1
      // 09: dup2
      // 0a: ldc2_w 2127020466049857818
      // 0d: ldc2_w 2127010964016453424
      // 10: lxor
      // 11: lxor
      // 12: lstore 3
      // 13: pop2
      // 14: getstatic x/oc151419fdfe.v Z
      // 17: aload 0
      // 18: ldc_w "setting.mode"
      // 1b: lload 3
      // 1c: ldc_w "Mode"
      // 1f: invokestatic x/oc7d9b6bd5c4.Ҙ (Lcom/google/gson/JsonObject;Ljava/lang/String;JLjava/lang/String;)Lcom/google/gson/JsonElement;
      // 22: astore 6
      // 24: istore 5
      // 26: aload 6
      // 28: iload 5
      // 2a: ifne 36
      // 2d: ifnull 5d
      // 30: goto 34
      // 33: athrow
      // 34: aload 6
      // 36: iload 5
      // 38: ifne 4b
      // 3b: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 3e: ifeq 5d
      // 41: goto 45
      // 44: athrow
      // 45: aload 6
      // 47: goto 4b
      // 4a: athrow
      // 4b: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 4e: iload 5
      // 50: ifne 61
      // 53: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 56: ifne 5f
      // 59: goto 5d
      // 5c: athrow
      // 5d: return
      // 5e: athrow
      // 5f: aload 6
      // 61: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 64: istore 7
      // 66: iload 7
      // 68: iload 5
      // 6a: ifne 88
      // 6d: ldc_w 934774621
      // 70: ldc_w 934774617
      // 73: ixor
      // 74: if_icmpne 86
      // 77: goto 7b
      // 7a: athrow
      // 7b: ldc_w 934774619
      // 7e: ldc_w 934774617
      // 81: ixor
      // 82: goto 9e
      // 85: athrow
      // 86: iload 7
      // 88: iload 5
      // 8a: ifne 9a
      // 8d: bipush 1
      // 8e: if_icmpne 9d
      // 91: goto 95
      // 94: athrow
      // 95: bipush 1
      // 96: goto 9a
      // 99: athrow
      // 9a: goto 9e
      // 9d: bipush 0
      // 9e: istore 8
      // a0: aload 0
      // a1: ldc_w "setting.mode"
      // a4: iload 8
      // a6: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // a9: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // ac: aload 0
      // ad: ldc_w "Mode"
      // b0: iload 8
      // b2: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // b5: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // b8: return
   }

   static void ζ(JsonObject param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 38
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: ldc_w "setting.ravenMode"
      // 14: iload 1
      // 15: ifne 2a
      // 18: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 1b: ifne 38
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: ldc_w "Raven mode"
      // 26: goto 2a
      // 29: athrow
      // 2a: iload 1
      // 2b: ifne 3e
      // 2e: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 31: ifeq 3a
      // 34: goto 38
      // 37: athrow
      // 38: return
      // 39: athrow
      // 3a: aload 0
      // 3b: ldc_w "setting.mode"
      // 3e: iload 1
      // 3f: ifne 57
      // 42: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 45: ifeq 53
      // 48: goto 4c
      // 4b: athrow
      // 4c: ldc_w "setting.mode"
      // 4f: goto 65
      // 52: athrow
      // 53: aload 0
      // 54: ldc_w "Mode"
      // 57: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 5a: ifeq 64
      // 5d: ldc_w "Mode"
      // 60: goto 65
      // 63: athrow
      // 64: aconst_null
      // 65: astore 2
      // 66: aload 2
      // 67: ifnull 81
      // 6a: aload 0
      // 6b: aload 2
      // 6c: iload 1
      // 6d: ifne 85
      // 70: goto 74
      // 73: athrow
      // 74: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 77: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 7a: ifne 83
      // 7d: goto 81
      // 80: athrow
      // 81: return
      // 82: athrow
      // 83: aload 0
      // 84: aload 2
      // 85: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 88: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 8b: istore 3
      // 8c: aload 0
      // 8d: aload 2
      // 8e: iload 3
      // 8f: iload 1
      // 90: ifne a6
      // 93: ldc_w 1599453424
      // 96: ldc_w 1599453427
      // 99: ixor
      // 9a: if_icmplt a9
      // 9d: goto a1
      // a0: athrow
      // a1: bipush 1
      // a2: goto a6
      // a5: athrow
      // a6: goto aa
      // a9: bipush 0
      // aa: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // ad: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // b0: goto b4
      // b3: astore 3
      // b4: return
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void р(JsonObject var0, String var1, String var2, double var3, long var5, double var7) {
      String var10 = null;
      double var11 = 0.0;
      int var10000 = oc151419fdfe.v;
      int var13 = a(-2038636387 ^ -2038638396, -525138015519765398L ^ -5260828863575063543L ^ var5);
      byte var9 = (byte)var10000;

      label188:
      while (true) {
         label186:
         while (true) {
            while (true) {
               int var29;
               label180: {
                  label179:
                  while (true) {
                     label177: {
                        switch (var13) {
                           case -2127215316:
                              return;
                           case -810378168:
                              break label188;
                           case -647788340:
                              label167: {
                                 label201: {
                                    label165: {
                                       long var10002;
                                       label164: {
                                          label202: {
                                             try {
                                                var10000 = var0.get(var10).isJsonPrimitive();
                                                if (var5 < 0L) {
                                                   break label201;
                                                }

                                                if (var9 != 0) {
                                                   break label165;
                                                }

                                                if (var10000 == 0) {
                                                   break label202;
                                                }
                                             } catch (RuntimeException var18) {
                                                throw var18;
                                             }

                                             var10000 = -2038631399 ^ -2038638396;
                                             var28 = -2941367254107383603L ^ -5260828863575063543L;
                                             var10002 = var5;
                                             if (var5 <= 0L) {
                                                break label164;
                                             }

                                             var13 = a(var10000, var28 ^ var5);
                                             if (var9 == 0) {
                                                continue;
                                             }
                                          }

                                          var10000 = -2038652312 ^ -2038638396;
                                          var28 = -3634381431638405404L ^ -5260828863575063543L;
                                          var10002 = var5;
                                       }

                                       var10000 = a(var10000, var28 ^ var10002);
                                    }

                                    var13 = var10000;
                                    if (var5 < 0L) {
                                       break label167;
                                    }

                                    var10000 = var9;
                                 }

                                 if (var10000 == 0) {
                                    continue;
                                 }
                              }
                           case -540967066:
                              label198: {
                                 label144: {
                                    label143: {
                                       label199: {
                                          try {
                                             var10000 = var0.getAsJsonPrimitive(var10).isNumber();
                                             if (var5 <= 0L) {
                                                break label198;
                                             }

                                             if (var9 != 0) {
                                                break label144;
                                             }

                                             if (var10000 != 0) {
                                                break label199;
                                             }
                                          } catch (RuntimeException var17) {
                                             throw var17;
                                          }

                                          var10000 = -2038652638 ^ -2038638396;
                                          if (var5 <= 1L) {
                                             break label143;
                                          }

                                          var13 = a(var10000, -6602233762770072111L ^ -5260828863575063543L ^ var5);
                                          if (var9 == 0) {
                                             continue;
                                          }
                                       }

                                       var10000 = -2038645427 ^ -2038638396;
                                    }

                                    var10000 = a(var10000, -2797087232371076649L ^ -5260828863575063543L ^ var5);
                                 }

                                 var13 = var10000;
                                 if (var5 < 0L) {
                                    break label177;
                                 }

                                 var10000 = var9;
                              }

                              if (var10000 == 0) {
                                 continue;
                              }
                              break;
                           case 552073401:
                              break label179;
                           case 708592632:
                              break label186;
                           case 1661746652:
                              break;
                           case 1703550987:
                              var10 = var1;
                              if (var5 > 0L) {
                                 var13 = a(-2038644357 ^ -2038638396, -2621051285736378890L ^ -5260828863575063543L ^ var5);
                                 if (var9 == 0) {
                                    continue;
                                 }
                              }
                              break label186;
                           default:
                              throw null;
                        }

                        var10 = var2;
                     }

                     var10000 = var9;
                     var29 = -2038644249 ^ -2038638396;
                     if (var5 < 1L) {
                        break label180;
                     }

                     var13 = a(var29, -6444865262870254295L ^ -5260828863575063543L ^ var5);
                     if (var9 != 0) {
                        break;
                     }
                  }

                  try {
                     var10000 = var0.has(var1);
                     if (var5 < 0L) {
                        break;
                     }

                     var29 = var9;
                  } catch (RuntimeException var16) {
                     throw var16;
                  }
               }

               label116: {
                  label115: {
                     label204: {
                        try {
                           if (var29 != 0) {
                              break label116;
                           }

                           if (var10000 == 0) {
                              break label204;
                           }
                        } catch (RuntimeException var15) {
                           throw var15;
                        }

                        var10000 = -2038638896 ^ -2038638396;
                        if (var5 <= 1L) {
                           break label115;
                        }

                        var13 = a(var10000, -2718486576032695720L ^ -5260828863575063543L ^ var5);
                        if (var9 == 0) {
                           continue;
                        }
                     }

                     var10000 = -2038659694 ^ -2038638396;
                  }

                  var10000 = a(var10000, -2179588639652779660L ^ -5260828863575063543L ^ var5);
               }

               var13 = var10000;
               if (var5 < 0L) {
                  return;
               }

               var10000 = var9;
               break;
            }

            if (var10000 != 0) {
               break label188;
            }
         }

         label96: {
            label95: {
               long var10001;
               label94: {
                  label205: {
                     try {
                        var10000 = var0.has(var10);
                        if (var5 < 1L) {
                           break label96;
                        }

                        if (var9 != 0) {
                           break label95;
                        }

                        if (var10000 == 0) {
                           break label205;
                        }
                     } catch (RuntimeException var14) {
                        throw var14;
                     }

                     var10000 = -2038648192 ^ -2038638396;
                     var10001 = -6790471568856326573L ^ -5260828863575063543L ^ var5;
                     if (var5 < 1L) {
                        break label94;
                     }

                     var13 = a(var10000, var10001);
                     if (var9 == 0) {
                        continue;
                     }
                  }

                  var10000 = -2038652638 ^ -2038638396;
                  var10001 = -6602233762770072111L ^ -5260828863575063543L ^ var5;
               }

               var10000 = a(var10000, var10001);
            }

            var13 = var10000;
            var10000 = var9;
         }

         if (var10000 != 0) {
            return;
         }
      }

      var11 = var0.getAsJsonPrimitive(var10).getAsDouble();
      var0.addProperty(var10, oc05d664c647.ȼ(var11, var3, var7));
   }

   private static void Ȯ(char var0, int var1, JsonObject var2, short var3) {
      long var4 = (long)var0 << (-870461469 ^ -870461485)
         | (long)var1 << (-870461453 ^ -870461485) >>> (-870461501 ^ -870461485)
         | (long)var3 << (-870461469 ^ -870461485) >>> (-870461469 ^ -870461485);
      long var6 = var4 ^ -390833148734333137L ^ -390921601320400990L;
      ǌ(
         var2,
         var6,
         a((-1509795277 ^ -870461485) - (char)(870472249 ^ -870461485), (-1509795277 ^ -870461485) - (char)(870459768 ^ -870461485), (int)var4),
         a((-1509795277 ^ -870461485) - (char)(870472254 ^ -870461485), (-1509926351 ^ -870461485) + (char)(870463738 ^ -870461485), (int)var4)
      );
      ǌ(
         var2,
         var6,
         a((-1509795277 ^ -870461485) - (char)(870472231 ^ -870461485), (-1509795277 ^ -870461485) - (char)(870476907 ^ -870461485), (int)var4),
         a((-1509795277 ^ -870461485) - (char)(870472142 ^ -870461485), (-1509795277 ^ -870461485) - (char)(870464012 ^ -870461485), (int)var4)
      );
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void ǌ(JsonObject var0, long var1, String var3, String var4) {
      byte var5 = oc151419fdfe.v;
      int var6 = a(825932304 ^ 825941501, 7078469028329563750L ^ 1201280251013277571L ^ var1);

      while (true) {
         JsonObject var11;
         String var14;
         label89: {
            label88:
            while (true) {
               switch (var6) {
                  case 1031632417:
                     break label88;
                  case 1202802821:
                     label97: {
                        label79: {
                           label78: {
                              label98: {
                                 try {
                                    var10000 = var0.has(var3);
                                    if (var1 <= 0L) {
                                       break label97;
                                    }

                                    if (var5 != 0) {
                                       break label79;
                                    }

                                    if (var10000 == 0) {
                                       break label98;
                                    }
                                 } catch (RuntimeException var9) {
                                    throw var9;
                                 }

                                 var10 = 825945056 ^ 825941501;
                                 var10001 = 3086822945392424839L ^ 1201280251013277571L ^ var1;
                                 if (var1 < 0L) {
                                    break label78;
                                 }

                                 var6 = a(var10, var10001);
                                 if (var5 == 0) {
                                    continue;
                                 }
                              }

                              var10 = 825932166 ^ 825941501;
                              var10001 = 6153326109941540346L ^ 1201280251013277571L ^ var1;
                           }

                           var10000 = a(var10, var10001);
                        }

                        var6 = var10000;
                        if (var1 < 1L) {
                           break;
                        }

                        var10000 = var5;
                     }

                     if (var10000 == 0) {
                        continue;
                     }
                  case 1934111999:
                     var11 = var0;
                     var14 = var4;
                     if (var1 < 1L) {
                        break label89;
                     }

                     var0.add(var4, var0.get(var3));
                     break;
                  case 1498069261:
                     return;
                  default:
                     throw null;
               }

               var6 = a(825923693 ^ 825941501, 587399605635548263L ^ 1201280251013277571L ^ var1);
               if (var5 != 0) {
                  break;
               }
            }

            try {
               var11 = var0;
               var14 = var4;
            } catch (RuntimeException var7) {
               throw var7;
            }
         }

         label54: {
            label53: {
               label100: {
                  try {
                     var12 = var11.has(var14);
                     if (var5 != 0) {
                        break label54;
                     }

                     if (var12 != 0) {
                        break label100;
                     }
                  } catch (RuntimeException var8) {
                     throw var8;
                  }

                  var13 = a(825933351 ^ 825941501, 4306884352698163712L ^ 1201280251013277571L ^ var1);
                  if (var1 < 1L) {
                     break label53;
                  }

                  var6 = var13;
                  if (var5 == 0) {
                     continue;
                  }
               }

               var13 = 825923693 ^ 825941501;
            }

            var12 = a(var13, 587399605635548263L ^ 1201280251013277571L ^ var1);
         }

         var6 = var12;
      }
   }

   public static void O(oc69da1aa7f5 param0, N param1, JsonObject param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 08: astore 4
      // 0a: istore 3
      // 0b: aload 2
      // 0c: aload 1
      // 0d: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 10: iload 3
      // 11: ifne 2d
      // 14: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 17: ifne 45
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 2
      // 1f: iload 3
      // 20: ifne 38
      // 23: goto 27
      // 26: athrow
      // 27: aload 4
      // 29: goto 2d
      // 2c: athrow
      // 2d: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 30: ifeq 45
      // 33: aload 2
      // 34: goto 38
      // 37: athrow
      // 38: aload 1
      // 39: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 3c: aload 2
      // 3d: aload 4
      // 3f: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 42: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 45: return
   }

   public static void ɍ(oc69da1aa7f5 param0, JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 4020606380236922741
      // 03: ldc2_w 4020639786093052561
      // 06: lxor
      // 07: lstore 2
      // 08: lload 2
      // 09: dup2
      // 0a: ldc2_w 4020714725687844048
      // 0d: ldc2_w 4020639786093052561
      // 10: lxor
      // 11: lxor
      // 12: lstore 4
      // 14: dup2
      // 15: ldc2_w 4020626673042532734
      // 18: ldc2_w 4020639786093052561
      // 1b: lxor
      // 1c: lxor
      // 1d: lstore 6
      // 1f: dup2
      // 20: ldc2_w 4020710244329882626
      // 23: ldc2_w 4020639786093052561
      // 26: lxor
      // 27: lxor
      // 28: lstore 8
      // 2a: dup2
      // 2b: ldc2_w 4020639710202518979
      // 2e: ldc2_w 4020639786093052561
      // 31: lxor
      // 32: lxor
      // 33: lstore 10
      // 35: dup2
      // 36: ldc2_w 4020707106206560142
      // 39: ldc2_w 4020639786093052561
      // 3c: lxor
      // 3d: lxor
      // 3e: lstore 12
      // 40: pop2
      // 41: aload 0
      // 42: ifnull 4d
      // 45: aload 1
      // 46: ifnonnull 4f
      // 49: goto 4d
      // 4c: athrow
      // 4d: return
      // 4e: athrow
      // 4f: aload 0
      // 50: aload 1
      // 51: lload 6
      // 53: invokestatic x/oc7d9b6bd5c4.Շ (Lx/oc69da1aa7f5;Lcom/google/gson/JsonObject;J)V
      // 56: lload 8
      // 58: aload 0
      // 59: aload 1
      // 5a: invokestatic x/oc7d9b6bd5c4.ϸ (JLx/oc69da1aa7f5;Lcom/google/gson/JsonObject;)V
      // 5d: aload 0
      // 5e: aload 1
      // 5f: lload 4
      // 61: invokestatic x/oc7d9b6bd5c4.Ʈ (Lx/oc69da1aa7f5;Lcom/google/gson/JsonObject;J)V
      // 64: aload 0
      // 65: aload 1
      // 66: lload 10
      // 68: invokestatic x/oc7d9b6bd5c4.ћ (Lx/oc69da1aa7f5;Lcom/google/gson/JsonObject;J)V
      // 6b: aload 0
      // 6c: aload 1
      // 6d: lload 12
      // 6f: invokestatic x/oc7d9b6bd5c4.ǝ (Lx/oc69da1aa7f5;Lcom/google/gson/JsonObject;J)V
      // 72: return
   }

   private static void Շ(oc69da1aa7f5 param0, JsonObject param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: lload 2
      // 001: dup2
      // 002: ldc2_w -6503055715594479735
      // 005: ldc2_w -6502957728581012514
      // 008: lxor
      // 009: lxor
      // 00a: lstore 4
      // 00c: pop2
      // 00d: getstatic x/oc151419fdfe.v Z
      // 010: istore 6
      // 012: aload 0
      // 013: instanceof x/occ39d36078d
      // 016: ifne 01b
      // 019: return
      // 01a: athrow
      // 01b: aload 1
      // 01c: ldc_w -223570127
      // 01f: ldc_w 1137367467
      // 022: ixor
      // 023: ldc_w -1137362197
      // 026: ldc_w 1137367467
      // 029: ixor
      // 02a: iadd
      // 02b: ldc_w 223570125
      // 02e: ldc_w 1137367467
      // 031: ixor
      // 032: ldc_w 1137366689
      // 035: ldc_w 1137367467
      // 038: ixor
      // 039: iadd
      // 03a: lload 2
      // 03b: l2i
      // 03c: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 03f: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 042: astore 7
      // 044: aload 7
      // 046: iload 6
      // 048: ifne 07f
      // 04b: ifnonnull 081
      // 04e: goto 052
      // 051: athrow
      // 052: lload 4
      // 054: aload 1
      // 055: ldc_w -223570127
      // 058: ldc_w 1137367467
      // 05b: ixor
      // 05c: ldc_w -1137362274
      // 05f: ldc_w 1137367467
      // 062: ixor
      // 063: iadd
      // 064: ldc_w 223570125
      // 067: ldc_w 1137367467
      // 06a: ixor
      // 06b: ldc_w 1137377202
      // 06e: ldc_w 1137367467
      // 071: ixor
      // 072: iadd
      // 073: lload 2
      // 074: l2i
      // 075: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 078: invokestatic x/oc7d9b6bd5c4.ǣ (JLcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 07b: goto 07f
      // 07e: athrow
      // 07f: astore 7
      // 081: ldc_w 1137367465
      // 084: ldc_w 1137367467
      // 087: ixor
      // 088: anewarray 493
      // 08b: dup
      // 08c: bipush 0
      // 08d: ldc_w -223570127
      // 090: ldc_w 1137367467
      // 093: ixor
      // 094: ldc_w -1137362188
      // 097: ldc_w 1137367467
      // 09a: ixor
      // 09b: iadd
      // 09c: ldc_w 223570125
      // 09f: ldc_w 1137367467
      // 0a2: ixor
      // 0a3: ldc_w 1137363958
      // 0a6: ldc_w 1137367467
      // 0a9: ixor
      // 0aa: iadd
      // 0ab: lload 2
      // 0ac: l2i
      // 0ad: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0b0: aastore
      // 0b1: dup
      // 0b2: bipush 1
      // 0b3: ldc_w -223570127
      // 0b6: ldc_w 1137367467
      // 0b9: ixor
      // 0ba: ldc_w -1137362292
      // 0bd: ldc_w 1137367467
      // 0c0: ixor
      // 0c1: iadd
      // 0c2: ldc_w 223570125
      // 0c5: ldc_w 1137367467
      // 0c8: ixor
      // 0c9: ldc_w 1137364368
      // 0cc: ldc_w 1137367467
      // 0cf: ixor
      // 0d0: iadd
      // 0d1: lload 2
      // 0d2: l2i
      // 0d3: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0d6: aastore
      // 0d7: astore 8
      // 0d9: ldc_w 1137367465
      // 0dc: ldc_w 1137367467
      // 0df: ixor
      // 0e0: anewarray 493
      // 0e3: dup
      // 0e4: bipush 0
      // 0e5: ldc_w -223570127
      // 0e8: ldc_w 1137367467
      // 0eb: ixor
      // 0ec: ldc_w -1137362273
      // 0ef: ldc_w 1137367467
      // 0f2: ixor
      // 0f3: iadd
      // 0f4: ldc_w 223570125
      // 0f7: ldc_w 1137367467
      // 0fa: ixor
      // 0fb: ldc_w 1137361378
      // 0fe: ldc_w 1137367467
      // 101: ixor
      // 102: iadd
      // 103: lload 2
      // 104: l2i
      // 105: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 108: aastore
      // 109: dup
      // 10a: bipush 1
      // 10b: ldc_w -223570127
      // 10e: ldc_w 1137367467
      // 111: ixor
      // 112: ldc_w -1137362280
      // 115: ldc_w 1137367467
      // 118: ixor
      // 119: iadd
      // 11a: ldc_w 223570125
      // 11d: ldc_w 1137367467
      // 120: ixor
      // 121: ldc_w 1137372691
      // 124: ldc_w 1137367467
      // 127: ixor
      // 128: iadd
      // 129: lload 2
      // 12a: l2i
      // 12b: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 12e: aastore
      // 12f: astore 9
      // 131: bipush 0
      // 132: istore 10
      // 134: iload 10
      // 136: aload 8
      // 138: arraylength
      // 139: if_icmpge 1a5
      // 13c: aload 1
      // 13d: iload 6
      // 13f: ifne 16f
      // 142: aload 8
      // 144: iload 10
      // 146: aaload
      // 147: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 14a: ifeq 160
      // 14d: goto 151
      // 150: athrow
      // 151: iload 6
      // 153: lload 2
      // 154: lconst_0
      // 155: lcmp
      // 156: ifle 1a2
      // 159: ifeq 19d
      // 15c: goto 160
      // 15f: athrow
      // 160: lload 4
      // 162: aload 1
      // 163: aload 9
      // 165: iload 10
      // 167: aaload
      // 168: invokestatic x/oc7d9b6bd5c4.ǣ (JLcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 16b: goto 16f
      // 16e: athrow
      // 16f: astore 11
      // 171: aload 11
      // 173: lload 2
      // 174: lconst_1
      // 175: lcmp
      // 176: ifle 18b
      // 179: iload 6
      // 17b: ifne 18b
      // 17e: ifnonnull 189
      // 181: goto 185
      // 184: athrow
      // 185: aload 7
      // 187: astore 11
      // 189: aload 11
      // 18b: ifnull 19d
      // 18e: aload 1
      // 18f: aload 8
      // 191: iload 10
      // 193: aaload
      // 194: aload 11
      // 196: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 199: goto 19d
      // 19c: athrow
      // 19d: iinc 10 1
      // 1a0: iload 6
      // 1a2: ifeq 134
      // 1a5: lload 2
      // 1a6: lconst_1
      // 1a7: lcmp
      // 1a8: ifle 13c
      // 1ab: return
   }

   private static JsonElement ǣ(long param0, JsonObject param2, String param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc151419fdfe.v Z
      // 003: istore 4
      // 005: aload 2
      // 006: iload 4
      // 008: ifne 04e
      // 00b: aload 3
      // 00c: lload 0
      // 00d: lconst_0
      // 00e: lcmp
      // 00f: ifle 04b
      // 012: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 015: ifeq 023
      // 018: goto 01c
      // 01b: athrow
      // 01c: aload 2
      // 01d: aload 3
      // 01e: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 021: areturn
      // 022: athrow
      // 023: aload 2
      // 024: ldc_w -2069691279
      // 027: ldc_w 1445145073
      // 02a: ixor
      // 02b: ldc_w -1445166717
      // 02e: ldc_w 1445145073
      // 031: ixor
      // 032: i2c
      // 033: ineg
      // 034: isub
      // 035: ldc_w -2069691279
      // 038: ldc_w 1445145073
      // 03b: ixor
      // 03c: ldc_w -1445140216
      // 03f: ldc_w 1445145073
      // 042: ixor
      // 043: i2c
      // 044: ineg
      // 045: isub
      // 046: lload 0
      // 047: l2i
      // 048: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 04b: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 04e: astore 5
      // 050: aload 5
      // 052: lload 0
      // 053: lconst_0
      // 054: lcmp
      // 055: ifle 066
      // 058: iload 4
      // 05a: ifne 066
      // 05d: ifnull 15a
      // 060: goto 064
      // 063: athrow
      // 064: aload 5
      // 066: iload 4
      // 068: ifne 07b
      // 06b: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 06e: ifeq 15a
      // 071: goto 075
      // 074: athrow
      // 075: aload 5
      // 077: goto 07b
      // 07a: athrow
      // 07b: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 07e: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 081: astore 6
      // 083: aload 6
      // 085: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 08a: ifeq 15a
      // 08d: aload 6
      // 08f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 094: checkcast com/google/gson/JsonElement
      // 097: astore 7
      // 099: aload 7
      // 09b: iload 4
      // 09d: ifne 0bb
      // 0a0: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 0a3: ifne 0b9
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: iload 4
      // 0ac: lload 0
      // 0ad: lconst_1
      // 0ae: lcmp
      // 0af: iflt 08a
      // 0b2: ifeq 083
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 7
      // 0bb: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0be: astore 8
      // 0c0: aload 8
      // 0c2: ldc_w -2069691279
      // 0c5: ldc_w 1445145073
      // 0c8: ixor
      // 0c9: ldc_w -1445166642
      // 0cc: ldc_w 1445145073
      // 0cf: ixor
      // 0d0: i2c
      // 0d1: ineg
      // 0d2: isub
      // 0d3: ldc_w -2069691279
      // 0d6: ldc_w 1445145073
      // 0d9: ixor
      // 0da: ldc_w -1445162674
      // 0dd: ldc_w 1445145073
      // 0e0: ixor
      // 0e1: i2c
      // 0e2: ineg
      // 0e3: isub
      // 0e4: lload 0
      // 0e5: l2i
      // 0e6: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0e9: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0ec: astore 9
      // 0ee: aload 9
      // 0f0: lload 0
      // 0f1: lconst_1
      // 0f2: lcmp
      // 0f3: ifle 104
      // 0f6: iload 4
      // 0f8: ifne 104
      // 0fb: ifnull 155
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 9
      // 104: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 107: lload 0
      // 108: lconst_1
      // 109: lcmp
      // 10a: iflt 126
      // 10d: iload 4
      // 10f: ifne 126
      // 112: ifeq 155
      // 115: goto 119
      // 118: athrow
      // 119: aload 3
      // 11a: aload 9
      // 11c: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 11f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 122: goto 126
      // 125: athrow
      // 126: ifeq 155
      // 129: aload 8
      // 12b: ldc_w -2069691279
      // 12e: ldc_w 1445145073
      // 131: ixor
      // 132: ldc_w -1445166707
      // 135: ldc_w 1445145073
      // 138: ixor
      // 139: i2c
      // 13a: ineg
      // 13b: isub
      // 13c: ldc_w 2069691249
      // 13f: ldc_w 1445145073
      // 142: ixor
      // 143: ldc_w 1445155678
      // 146: ldc_w 1445145073
      // 149: ixor
      // 14a: isub
      // 14b: lload 0
      // 14c: l2i
      // 14d: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 150: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 153: areturn
      // 154: athrow
      // 155: iload 4
      // 157: ifeq 083
      // 15a: aconst_null
      // 15b: areturn
   }

   private static void ǝ(oc69da1aa7f5 param0, JsonObject param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: lload 2
      // 001: dup2
      // 002: ldc2_w 7510448608571370642
      // 005: ldc2_w 7510434734919269662
      // 008: lxor
      // 009: lxor
      // 00a: lstore 4
      // 00c: dup2
      // 00d: ldc2_w 7510442004932278132
      // 010: ldc2_w 7510434734919269662
      // 013: lxor
      // 014: lxor
      // 015: lstore 6
      // 017: pop2
      // 018: getstatic x/oc151419fdfe.v Z
      // 01b: istore 8
      // 01d: aload 0
      // 01e: iload 8
      // 020: ifne 1aa
      // 023: instanceof x/oc42c8f83828
      // 026: ifeq 1a9
      // 029: goto 02d
      // 02c: athrow
      // 02d: aload 1
      // 02e: lload 2
      // 02f: lconst_1
      // 030: lcmp
      // 031: ifle 0e2
      // 034: ldc_w 1758552395
      // 037: ldc_w -1882359377
      // 03a: ixor
      // 03b: ldc_w 1882384346
      // 03e: ldc_w -1882359377
      // 041: ixor
      // 042: iadd
      // 043: ldc_w -1758552397
      // 046: ldc_w -1882359377
      // 049: ixor
      // 04a: ldc_w -1882379427
      // 04d: ldc_w -1882359377
      // 050: ixor
      // 051: iadd
      // 052: lload 2
      // 053: l2i
      // 054: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 057: iload 8
      // 059: ifne 0b8
      // 05c: goto 060
      // 05f: athrow
      // 060: lload 4
      // 062: ldc_w 1758552395
      // 065: ldc_w -1882359377
      // 068: ixor
      // 069: ldc_w 1882384264
      // 06c: ldc_w -1882359377
      // 06f: ixor
      // 070: iadd
      // 071: ldc_w -1758552397
      // 074: ldc_w -1882359377
      // 077: ixor
      // 078: ldc_w 1882390297
      // 07b: ldc_w -1882359377
      // 07e: ixor
      // 07f: i2c
      // 080: iadd
      // 081: lload 2
      // 082: l2i
      // 083: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 086: invokestatic x/oc7d9b6bd5c4.Ҙ (Lcom/google/gson/JsonObject;Ljava/lang/String;JLjava/lang/String;)Lcom/google/gson/JsonElement;
      // 089: ifnonnull 1a9
      // 08c: goto 090
      // 08f: athrow
      // 090: aload 1
      // 091: ldc_w 1758552395
      // 094: ldc_w -1882359377
      // 097: ixor
      // 098: ldc_w 1882384375
      // 09b: ldc_w -1882359377
      // 09e: ixor
      // 09f: iadd
      // 0a0: ldc_w -1758552397
      // 0a3: ldc_w -1882359377
      // 0a6: ixor
      // 0a7: ldc_w -1882378445
      // 0aa: ldc_w -1882359377
      // 0ad: ixor
      // 0ae: iadd
      // 0af: lload 2
      // 0b0: l2i
      // 0b1: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: lload 4
      // 0ba: ldc_w 1758552395
      // 0bd: ldc_w -1882359377
      // 0c0: ixor
      // 0c1: ldc_w 1882384256
      // 0c4: ldc_w -1882359377
      // 0c7: ixor
      // 0c8: iadd
      // 0c9: ldc_w 1758552395
      // 0cc: ldc_w -1882359377
      // 0cf: ixor
      // 0d0: ldc_w 1882385679
      // 0d3: ldc_w -1882359377
      // 0d6: ixor
      // 0d7: i2c
      // 0d8: ineg
      // 0d9: iadd
      // 0da: lload 2
      // 0db: l2i
      // 0dc: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0df: invokestatic x/oc7d9b6bd5c4.Ҙ (Lcom/google/gson/JsonObject;Ljava/lang/String;JLjava/lang/String;)Lcom/google/gson/JsonElement;
      // 0e2: astore 9
      // 0e4: aload 1
      // 0e5: ldc_w 1758552395
      // 0e8: ldc_w -1882359377
      // 0eb: ixor
      // 0ec: ldc_w 1882384352
      // 0ef: ldc_w -1882359377
      // 0f2: ixor
      // 0f3: iadd
      // 0f4: ldc_w -1758552397
      // 0f7: ldc_w -1882359377
      // 0fa: ixor
      // 0fb: ldc_w -1882380217
      // 0fe: ldc_w -1882359377
      // 101: ixor
      // 102: iadd
      // 103: lload 2
      // 104: l2i
      // 105: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 108: lload 4
      // 10a: ldc_w 1758552395
      // 10d: ldc_w -1882359377
      // 110: ixor
      // 111: ldc_w 1882384257
      // 114: ldc_w -1882359377
      // 117: ixor
      // 118: iadd
      // 119: ldc_w 1758552395
      // 11c: ldc_w -1882359377
      // 11f: ixor
      // 120: ldc_w 1882376981
      // 123: ldc_w -1882359377
      // 126: ixor
      // 127: iadd
      // 128: lload 2
      // 129: l2i
      // 12a: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 12d: invokestatic x/oc7d9b6bd5c4.Ҙ (Lcom/google/gson/JsonObject;Ljava/lang/String;JLjava/lang/String;)Lcom/google/gson/JsonElement;
      // 130: astore 10
      // 132: aload 9
      // 134: lload 2
      // 135: lconst_1
      // 136: lcmp
      // 137: iflt 148
      // 13a: iload 8
      // 13c: ifne 148
      // 13f: ifnonnull 14b
      // 142: goto 146
      // 145: athrow
      // 146: aload 10
      // 148: ifnull 1a9
      // 14b: aload 1
      // 14c: ldc_w 1758552395
      // 14f: ldc_w -1882359377
      // 152: ixor
      // 153: ldc_w 1882384353
      // 156: ldc_w -1882359377
      // 159: ixor
      // 15a: iadd
      // 15b: ldc_w -1758552397
      // 15e: ldc_w -1882359377
      // 161: ixor
      // 162: ldc_w 1882387880
      // 165: ldc_w -1882359377
      // 168: ixor
      // 169: i2c
      // 16a: iadd
      // 16b: lload 2
      // 16c: l2i
      // 16d: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 170: lload 6
      // 172: aload 9
      // 174: invokestatic x/oc7d9b6bd5c4.Չ (JLcom/google/gson/JsonElement;)Z
      // 177: iload 8
      // 179: ifne 19f
      // 17c: goto 180
      // 17f: athrow
      // 180: ifne 19e
      // 183: goto 187
      // 186: athrow
      // 187: lload 6
      // 189: aload 10
      // 18b: invokestatic x/oc7d9b6bd5c4.Չ (JLcom/google/gson/JsonElement;)Z
      // 18e: iload 8
      // 190: ifne 19f
      // 193: goto 197
      // 196: athrow
      // 197: ifeq 1a2
      // 19a: goto 19e
      // 19d: athrow
      // 19e: bipush 1
      // 19f: goto 1a3
      // 1a2: bipush 0
      // 1a3: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 1a6: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 1a9: aload 0
      // 1aa: iload 8
      // 1ac: ifne 281
      // 1af: instanceof x/oc446ce7e211
      // 1b2: ifeq 280
      // 1b5: goto 1b9
      // 1b8: athrow
      // 1b9: aload 1
      // 1ba: ldc_w 1758552395
      // 1bd: ldc_w -1882359377
      // 1c0: ixor
      // 1c1: ldc_w 1882384360
      // 1c4: ldc_w -1882359377
      // 1c7: ixor
      // 1c8: iadd
      // 1c9: ldc_w 1758552395
      // 1cc: ldc_w -1882359377
      // 1cf: ixor
      // 1d0: ldc_w 1882390296
      // 1d3: ldc_w -1882359377
      // 1d6: ixor
      // 1d7: i2c
      // 1d8: ineg
      // 1d9: iadd
      // 1da: lload 2
      // 1db: l2i
      // 1dc: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1df: lload 4
      // 1e1: ldc_w 1758552395
      // 1e4: ldc_w -1882359377
      // 1e7: ixor
      // 1e8: ldc_w 1882384260
      // 1eb: ldc_w -1882359377
      // 1ee: ixor
      // 1ef: iadd
      // 1f0: ldc_w 1758552395
      // 1f3: ldc_w -1882359377
      // 1f6: ixor
      // 1f7: ldc_w 1882375504
      // 1fa: ldc_w -1882359377
      // 1fd: ixor
      // 1fe: iadd
      // 1ff: lload 2
      // 200: l2i
      // 201: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 204: invokestatic x/oc7d9b6bd5c4.Ҙ (Lcom/google/gson/JsonObject;Ljava/lang/String;JLjava/lang/String;)Lcom/google/gson/JsonElement;
      // 207: lload 6
      // 209: dup2_x1
      // 20a: pop2
      // 20b: invokestatic x/oc7d9b6bd5c4.Չ (JLcom/google/gson/JsonElement;)Z
      // 20e: lload 2
      // 20f: lconst_0
      // 210: lcmp
      // 211: iflt 284
      // 214: iload 8
      // 216: ifne 284
      // 219: goto 21d
      // 21c: athrow
      // 21d: ifeq 280
      // 220: goto 224
      // 223: athrow
      // 224: aload 1
      // 225: ldc_w 1758552395
      // 228: ldc_w -1882359377
      // 22b: ixor
      // 22c: ldc_w 1882384273
      // 22f: ldc_w -1882359377
      // 232: ixor
      // 233: iadd
      // 234: ldc_w 1758552395
      // 237: ldc_w -1882359377
      // 23a: ixor
      // 23b: ldc_w 1882388134
      // 23e: ldc_w -1882359377
      // 241: ixor
      // 242: i2c
      // 243: ineg
      // 244: iadd
      // 245: lload 2
      // 246: l2i
      // 247: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 24a: bipush 1
      // 24b: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 24e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 251: aload 1
      // 252: ldc_w 1758552395
      // 255: ldc_w -1882359377
      // 258: ixor
      // 259: ldc_w 1882384320
      // 25c: ldc_w -1882359377
      // 25f: ixor
      // 260: iadd
      // 261: ldc_w 1758552395
      // 264: ldc_w -1882359377
      // 267: ixor
      // 268: ldc_w 1882368299
      // 26b: ldc_w -1882359377
      // 26e: ixor
      // 26f: iadd
      // 270: lload 2
      // 271: l2i
      // 272: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 275: bipush 1
      // 276: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 279: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 27c: goto 280
      // 27f: athrow
      // 280: aload 0
      // 281: instanceof x/ocd2958dac48
      // 284: iload 8
      // 286: ifne 2e7
      // 289: ifeq 3fa
      // 28c: goto 290
      // 28f: athrow
      // 290: aload 1
      // 291: ldc_w 1758552395
      // 294: ldc_w -1882359377
      // 297: ixor
      // 298: ldc_w 1882384348
      // 29b: ldc_w -1882359377
      // 29e: ixor
      // 29f: iadd
      // 2a0: ldc_w 1758552395
      // 2a3: ldc_w -1882359377
      // 2a6: ixor
      // 2a7: ldc_w 1882378690
      // 2aa: ldc_w -1882359377
      // 2ad: ixor
      // 2ae: iadd
      // 2af: lload 2
      // 2b0: l2i
      // 2b1: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 2b4: lload 4
      // 2b6: ldc_w 1758552395
      // 2b9: ldc_w -1882359377
      // 2bc: ixor
      // 2bd: ldc_w 1882384258
      // 2c0: ldc_w -1882359377
      // 2c3: ixor
      // 2c4: iadd
      // 2c5: ldc_w -1758552397
      // 2c8: ldc_w -1882359377
      // 2cb: ixor
      // 2cc: ldc_w -1882373842
      // 2cf: ldc_w -1882359377
      // 2d2: ixor
      // 2d3: iadd
      // 2d4: lload 2
      // 2d5: l2i
      // 2d6: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 2d9: invokestatic x/oc7d9b6bd5c4.Ҙ (Lcom/google/gson/JsonObject;Ljava/lang/String;JLjava/lang/String;)Lcom/google/gson/JsonElement;
      // 2dc: lload 6
      // 2de: dup2_x1
      // 2df: pop2
      // 2e0: invokestatic x/oc7d9b6bd5c4.Չ (JLcom/google/gson/JsonElement;)Z
      // 2e3: goto 2e7
      // 2e6: athrow
      // 2e7: ifeq 3fa
      // 2ea: aload 0
      // 2eb: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 2ee: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 2f1: astore 9
      // 2f3: aload 9
      // 2f5: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2fa: ifeq 3fa
      // 2fd: aload 9
      // 2ff: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 304: checkcast x/N
      // 307: astore 10
      // 309: aload 10
      // 30b: iload 8
      // 30d: ifne 322
      // 310: instanceof x/ocada7dda290
      // 313: lload 2
      // 314: lconst_1
      // 315: lcmp
      // 316: ifle 2fa
      // 319: ifeq 2f3
      // 31c: goto 320
      // 31f: athrow
      // 320: aload 10
      // 322: checkcast x/ocada7dda290
      // 325: astore 11
      // 327: ldc_w 1758552395
      // 32a: ldc_w -1882359377
      // 32d: ixor
      // 32e: ldc_w 1882384342
      // 331: ldc_w -1882359377
      // 334: ixor
      // 335: iadd
      // 336: ldc_w -1758552397
      // 339: ldc_w -1882359377
      // 33c: ixor
      // 33d: ldc_w -1882367482
      // 340: ldc_w -1882359377
      // 343: ixor
      // 344: iadd
      // 345: lload 2
      // 346: l2i
      // 347: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 34a: aload 10
      // 34c: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 34f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 352: ifne 359
      // 355: goto 2f3
      // 358: athrow
      // 359: new x/ocada7dda290
      // 35c: dup
      // 35d: aload 10
      // 35f: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 362: aload 11
      // 364: invokevirtual x/ocada7dda290.ǥ ()[Ljava/lang/String;
      // 367: bipush 0
      // 368: anewarray 493
      // 36b: invokespecial x/ocada7dda290.<init> (Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
      // 36e: astore 12
      // 370: iload 8
      // 372: aload 1
      // 373: aload 0
      // 374: aload 10
      // 376: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 379: aload 10
      // 37b: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 37e: lload 4
      // 380: dup2_x1
      // 381: pop2
      // 382: invokestatic x/oc7d9b6bd5c4.Ҙ (Lcom/google/gson/JsonObject;Ljava/lang/String;JLjava/lang/String;)Lcom/google/gson/JsonElement;
      // 385: astore 13
      // 387: ifne 3d9
      // 38a: aload 13
      // 38c: ifnull 3af
      // 38f: goto 393
      // 392: athrow
      // 393: new com/google/gson/JsonObject
      // 396: dup
      // 397: invokespecial com/google/gson/JsonObject.<init> ()V
      // 39a: astore 14
      // 39c: aload 14
      // 39e: aload 10
      // 3a0: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 3a3: aload 13
      // 3a5: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 3a8: aload 12
      // 3aa: aload 14
      // 3ac: invokevirtual x/ocada7dda290.z$3ktkzjg2sjswq (Lcom/google/gson/JsonObject;)V
      // 3af: aload 12
      // 3b1: ldc_w 1758552395
      // 3b4: ldc_w -1882359377
      // 3b7: ixor
      // 3b8: ldc_w 1882384365
      // 3bb: ldc_w -1882359377
      // 3be: ixor
      // 3bf: iadd
      // 3c0: ldc_w 1758552395
      // 3c3: ldc_w -1882359377
      // 3c6: ixor
      // 3c7: ldc_w 1882366164
      // 3ca: ldc_w -1882359377
      // 3cd: ixor
      // 3ce: iadd
      // 3cf: lload 2
      // 3d0: l2i
      // 3d1: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 3d4: bipush 1
      // 3d5: invokevirtual x/ocada7dda290.Ͼ (Ljava/lang/String;Z)Z
      // 3d8: pop
      // 3d9: aload 12
      // 3db: invokevirtual x/ocada7dda290.ϳ ()Lcom/google/gson/JsonArray;
      // 3de: astore 14
      // 3e0: aload 1
      // 3e1: aload 0
      // 3e2: aload 10
      // 3e4: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 3e7: aload 14
      // 3e9: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 3ec: aload 1
      // 3ed: aload 10
      // 3ef: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 3f2: aload 14
      // 3f4: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 3f7: goto 3fa
      // 3fa: return
   }

   private static boolean Չ(long var0, JsonElement var2) {
      byte var3 = oc151419fdfe.v;
      int var4 = a(812155990 ^ 812163030, -2420941762334611646L ^ -8556815411852033867L ^ var0);

      label142:
      while (true) {
         int var10000 = var4;

         while (true) {
            switch (var10000) {
               case -1959712881:
                  label108: {
                     label107: {
                        long var16;
                        long var10002;
                        label106: {
                           label148: {
                              try {
                                 var10000 = var2.getAsBoolean();
                                 if (var0 < 0L) {
                                    break label108;
                                 }

                                 if (var3 != 0) {
                                    break label107;
                                 }

                                 if (var10000 == 0) {
                                    break label148;
                                 }
                              } catch (RuntimeException var6) {
                                 throw var6;
                              }

                              var10000 = 812167685 ^ 812163030;
                              var16 = -6199018617869889178L ^ -8556815411852033867L;
                              var10002 = var0;
                              if (var0 <= 0L) {
                                 break label106;
                              }

                              var4 = a(var10000, var16 ^ var0);
                              if (var3 == 0) {
                                 continue label142;
                              }
                           }

                           var10000 = 812165326 ^ 812163030;
                           var16 = -2068475160953746448L ^ -8556815411852033867L;
                           var10002 = var0;
                        }

                        var10000 = a(var10000, var16 ^ var10002);
                     }

                     var4 = var10000;
                     var10000 = var3;
                  }

                  if (var0 <= 0L) {
                     return (boolean)var10000;
                  }

                  if (var10000 == 0) {
                     continue label142;
                  }

                  return (boolean)0;
               case -1159539201:
                  label127: {
                     label126: {
                        long var14;
                        label125: {
                           label151: {
                              try {
                                 var10000 = var2.isJsonPrimitive();
                                 if (var0 < 1L) {
                                    break label127;
                                 }

                                 if (var3 != 0) {
                                    break label126;
                                 }

                                 if (var10000 == 0) {
                                    break label151;
                                 }
                              } catch (RuntimeException var7) {
                                 throw var7;
                              }

                              var10000 = 812175518 ^ 812163030;
                              var14 = -2824520905726397505L ^ -8556815411852033867L ^ var0;
                              if (var0 < 1L) {
                                 break label125;
                              }

                              var4 = a(var10000, var14);
                              if (var3 == 0) {
                                 continue label142;
                              }
                           }

                           var10000 = 812166665 ^ 812163030;
                           var14 = -1178913273484341963L ^ -8556815411852033867L ^ var0;
                        }

                        var10000 = a(var10000, var14);
                     }

                     var4 = var10000;
                     var10000 = var3;
                  }

                  if (var0 <= 1L) {
                     break;
                  }

                  if (var10000 == 0) {
                     continue label142;
                  }
               case 773256059:
                  long var15;
                  label146: {
                     if (var2 != null) {
                        var10000 = 812160586 ^ 812163030;
                        var15 = -1876024835978807952L ^ -8556815411852033867L;
                        if (var0 < 1L) {
                           break label146;
                        }

                        var4 = a(var10000, var15 ^ var0);
                        if (var3 == 0) {
                           continue label142;
                        }
                     }

                     var10000 = 812166665 ^ 812163030;
                     if (var0 <= 0L) {
                        return (boolean)var10000;
                     }

                     var15 = -1178913273484341963L ^ -8556815411852033867L ^ var0;
                  }

                  var4 = a(var10000, var15);
                  if (var3 == 0) {
                     continue label142;
                  }

                  return (boolean)1;
               case 131475794:
                  label74: {
                     long var10001;
                     label73: {
                        label153: {
                           try {
                              var10000 = var2.getAsJsonPrimitive().isBoolean();
                              if (var3 != 0) {
                                 break label74;
                              }

                              if (var10000 == 0) {
                                 break label153;
                              }
                           } catch (RuntimeException var5) {
                              throw var5;
                           }

                           var10000 = 812163684 ^ 812163030;
                           var10001 = -3147054388112326300L ^ -8556815411852033867L ^ var0;
                           if (var0 < 1L) {
                              break label73;
                           }

                           var4 = a(var10000, var10001);
                           if (var3 == 0) {
                              continue label142;
                           }
                        }

                        var10000 = 812166665 ^ 812163030;
                        var10001 = -1178913273484341963L ^ -8556815411852033867L ^ var0;
                     }

                     var10000 = a(var10000, var10001);
                  }

                  var4 = var10000;
                  continue label142;
               case 872762863:
                  return (boolean)0;
               case 1582352382:
                  return (boolean)1;
               default:
                  throw null;
            }
         }
      }
   }

   private static JsonElement Ҙ(JsonObject param0, String param1, long param2, String param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: lload 2
      // 001: dup2
      // 002: ldc2_w 575161894776430616
      // 005: ldc2_w 575134477621327562
      // 008: lxor
      // 009: lxor
      // 00a: lstore 5
      // 00c: pop2
      // 00d: getstatic x/oc151419fdfe.v Z
      // 010: istore 7
      // 012: aload 0
      // 013: iload 7
      // 015: ifne 02b
      // 018: aload 1
      // 019: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 01c: ifeq 02a
      // 01f: goto 023
      // 022: athrow
      // 023: aload 0
      // 024: aload 1
      // 025: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 028: areturn
      // 029: athrow
      // 02a: aload 0
      // 02b: invokevirtual com/google/gson/JsonObject.entrySet ()Ljava/util/Set;
      // 02e: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 033: astore 8
      // 035: aload 8
      // 037: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 03c: ifeq 085
      // 03f: aload 8
      // 041: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 046: checkcast java/util/Map$Entry
      // 049: astore 9
      // 04b: aload 4
      // 04d: iload 7
      // 04f: ifne 07c
      // 052: aload 9
      // 054: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 059: checkcast java/lang/String
      // 05c: lload 5
      // 05e: invokestatic x/oc7d9b6bd5c4.ɖ (Ljava/lang/String;J)Ljava/lang/String;
      // 061: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 064: lload 2
      // 065: lconst_1
      // 066: lcmp
      // 067: ifle 082
      // 06a: ifeq 080
      // 06d: goto 071
      // 070: athrow
      // 071: aload 9
      // 073: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 078: goto 07c
      // 07b: athrow
      // 07c: checkcast com/google/gson/JsonElement
      // 07f: areturn
      // 080: iload 7
      // 082: ifeq 035
      // 085: aload 0
      // 086: lload 2
      // 087: lconst_0
      // 088: lcmp
      // 089: ifle 046
      // 08c: ldc_w -919075889
      // 08f: ldc_w -201080565
      // 092: ixor
      // 093: ldc_w 201073375
      // 096: ldc_w -201080565
      // 099: ixor
      // 09a: i2c
      // 09b: iadd
      // 09c: ldc_w 918682677
      // 09f: ldc_w -201080565
      // 0a2: ixor
      // 0a3: ldc_w 201065733
      // 0a6: ldc_w -201080565
      // 0a9: ixor
      // 0aa: i2c
      // 0ab: ineg
      // 0ac: isub
      // 0ad: lload 2
      // 0ae: l2i
      // 0af: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0b2: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0b5: astore 8
      // 0b7: aload 8
      // 0b9: lload 2
      // 0ba: lconst_0
      // 0bb: lcmp
      // 0bc: iflt 0cd
      // 0bf: iload 7
      // 0c1: ifne 0cd
      // 0c4: ifnull 1c0
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: aload 8
      // 0cd: iload 7
      // 0cf: ifne 0e2
      // 0d2: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 0d5: ifeq 1c0
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: aload 8
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 0e5: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 0e8: astore 9
      // 0ea: aload 9
      // 0ec: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0f1: ifeq 1c0
      // 0f4: aload 9
      // 0f6: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0fb: checkcast com/google/gson/JsonElement
      // 0fe: astore 10
      // 100: aload 10
      // 102: iload 7
      // 104: ifne 117
      // 107: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 10a: ifne 115
      // 10d: goto 111
      // 110: athrow
      // 111: goto 0ea
      // 114: athrow
      // 115: aload 10
      // 117: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 11a: astore 11
      // 11c: aload 11
      // 11e: ldc_w -919075889
      // 121: ldc_w -201080565
      // 124: ixor
      // 125: ldc_w 201073371
      // 128: ldc_w -201080565
      // 12b: ixor
      // 12c: i2c
      // 12d: iadd
      // 12e: ldc_w -919075889
      // 131: ldc_w -201080565
      // 134: ixor
      // 135: ldc_w 201069403
      // 138: ldc_w -201080565
      // 13b: ixor
      // 13c: i2c
      // 13d: iadd
      // 13e: lload 2
      // 13f: l2i
      // 140: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 143: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 146: astore 12
      // 148: aload 12
      // 14a: lload 2
      // 14b: lconst_0
      // 14c: lcmp
      // 14d: iflt 15e
      // 150: iload 7
      // 152: ifne 15e
      // 155: ifnull 1b5
      // 158: goto 15c
      // 15b: athrow
      // 15c: aload 12
      // 15e: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 161: lload 2
      // 162: lconst_0
      // 163: lcmp
      // 164: iflt 186
      // 167: iload 7
      // 169: ifne 186
      // 16c: ifeq 1b5
      // 16f: goto 173
      // 172: athrow
      // 173: aload 4
      // 175: aload 12
      // 177: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 17a: lload 5
      // 17c: invokestatic x/oc7d9b6bd5c4.ɖ (Ljava/lang/String;J)Ljava/lang/String;
      // 17f: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 182: goto 186
      // 185: athrow
      // 186: ifeq 1b5
      // 189: aload 11
      // 18b: ldc_w -919075889
      // 18e: ldc_w -201080565
      // 191: ixor
      // 192: ldc_w 201073333
      // 195: ldc_w -201080565
      // 198: ixor
      // 199: i2c
      // 19a: iadd
      // 19b: ldc_w -918682679
      // 19e: ldc_w -201080565
      // 1a1: ixor
      // 1a2: ldc_w 201075354
      // 1a5: ldc_w -201080565
      // 1a8: ixor
      // 1a9: i2c
      // 1aa: isub
      // 1ab: lload 2
      // 1ac: l2i
      // 1ad: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1b0: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 1b3: areturn
      // 1b4: athrow
      // 1b5: iload 7
      // 1b7: lload 2
      // 1b8: lconst_0
      // 1b9: lcmp
      // 1ba: ifle 0f1
      // 1bd: ifeq 0ea
      // 1c0: aconst_null
      // 1c1: areturn
   }

   private static void ϸ(long param0, oc69da1aa7f5 param2, JsonObject param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: lload 0
      // 001: dup2
      // 002: ldc2_w 5018838939475573805
      // 005: ldc2_w 5018774527541530879
      // 008: lxor
      // 009: lxor
      // 00a: lstore 4
      // 00c: dup2
      // 00d: ldc2_w 5018705441699679849
      // 010: ldc2_w 5018774527541530879
      // 013: lxor
      // 014: lxor
      // 015: dup2
      // 016: ldc_w 1094832985
      // 019: ldc_w 1094833017
      // 01c: ixor
      // 01d: lushr
      // 01e: l2i
      // 01f: istore 6
      // 021: dup2
      // 022: ldc_w 1094832985
      // 025: ldc_w 1094833017
      // 028: ixor
      // 029: lshl
      // 02a: ldc_w 1094832969
      // 02d: ldc_w 1094833017
      // 030: ixor
      // 031: lushr
      // 032: l2i
      // 033: istore 7
      // 035: dup2
      // 036: ldc_w 1094832969
      // 039: ldc_w 1094833017
      // 03c: ixor
      // 03d: lshl
      // 03e: ldc_w 1094832969
      // 041: ldc_w 1094833017
      // 044: ixor
      // 045: lushr
      // 046: l2i
      // 047: istore 8
      // 049: pop2
      // 04a: dup2
      // 04b: ldc2_w 5018788056495595888
      // 04e: ldc2_w 5018774527541530879
      // 051: lxor
      // 052: lxor
      // 053: lstore 9
      // 055: pop2
      // 056: getstatic x/oc151419fdfe.v Z
      // 059: istore 13
      // 05b: aload 2
      // 05c: instanceof x/ocd2958dac48
      // 05f: ifne 064
      // 062: return
      // 063: athrow
      // 064: aload 3
      // 065: ldc_w -16543033
      // 068: ldc_w 1094833017
      // 06b: ixor
      // 06c: ldc_w -1094813796
      // 06f: ldc_w 1094833017
      // 072: ixor
      // 073: i2c
      // 074: ineg
      // 075: iadd
      // 076: ldc_w -16543033
      // 079: ldc_w 1094833017
      // 07c: ixor
      // 07d: ldc_w -1094825707
      // 080: ldc_w 1094833017
      // 083: ixor
      // 084: i2c
      // 085: ineg
      // 086: iadd
      // 087: lload 0
      // 088: l2i
      // 089: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 08c: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08f: astore 14
      // 091: aload 14
      // 093: lload 0
      // 094: lconst_1
      // 095: lcmp
      // 096: ifle 0a7
      // 099: iload 13
      // 09b: ifne 0a7
      // 09e: ifnull 1f8
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: aload 14
      // 0a7: iload 13
      // 0a9: ifne 0bc
      // 0ac: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 0af: ifeq 1f8
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: aload 14
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 0bf: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 0c2: astore 15
      // 0c4: aload 15
      // 0c6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0cb: ifeq 1f8
      // 0ce: aload 15
      // 0d0: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d5: checkcast com/google/gson/JsonElement
      // 0d8: astore 16
      // 0da: aload 16
      // 0dc: iload 13
      // 0de: ifne 0f1
      // 0e1: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 0e4: ifne 0ef
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: goto 0c4
      // 0ee: athrow
      // 0ef: aload 16
      // 0f1: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0f4: astore 17
      // 0f6: aload 17
      // 0f8: ldc_w -16543033
      // 0fb: ldc_w 1094833017
      // 0fe: ixor
      // 0ff: ldc_w -1094814125
      // 102: ldc_w 1094833017
      // 105: ixor
      // 106: i2c
      // 107: ineg
      // 108: iadd
      // 109: ldc_w -16543033
      // 10c: ldc_w 1094833017
      // 10f: ixor
      // 110: ldc_w -1094827565
      // 113: ldc_w 1094833017
      // 116: ixor
      // 117: i2c
      // 118: ineg
      // 119: iadd
      // 11a: lload 0
      // 11b: l2i
      // 11c: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 11f: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 122: lload 0
      // 123: lconst_1
      // 124: lcmp
      // 125: iflt 194
      // 128: iload 13
      // 12a: ifne 194
      // 12d: ifeq 1ed
      // 130: goto 134
      // 133: athrow
      // 134: ldc_w -16543033
      // 137: ldc_w 1094833017
      // 13a: ixor
      // 13b: ldc_w -1094814126
      // 13e: ldc_w 1094833017
      // 141: ixor
      // 142: i2c
      // 143: ineg
      // 144: iadd
      // 145: ldc_w -16543033
      // 148: ldc_w 1094833017
      // 14b: ixor
      // 14c: ldc_w -1094813167
      // 14f: ldc_w 1094833017
      // 152: ixor
      // 153: iadd
      // 154: lload 0
      // 155: l2i
      // 156: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 159: aload 17
      // 15b: ldc_w -16543033
      // 15e: ldc_w 1094833017
      // 161: ixor
      // 162: ldc_w -1094814125
      // 165: ldc_w 1094833017
      // 168: ixor
      // 169: i2c
      // 16a: ineg
      // 16b: iadd
      // 16c: ldc_w -16543033
      // 16f: ldc_w 1094833017
      // 172: ixor
      // 173: ldc_w -1094827565
      // 176: ldc_w 1094833017
      // 179: ixor
      // 17a: i2c
      // 17b: ineg
      // 17c: iadd
      // 17d: lload 0
      // 17e: l2i
      // 17f: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 182: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 185: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 188: lload 4
      // 18a: invokestatic x/oc7d9b6bd5c4.ɖ (Ljava/lang/String;J)Ljava/lang/String;
      // 18d: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 190: goto 194
      // 193: athrow
      // 194: ifeq 1ed
      // 197: aload 17
      // 199: ldc_w -16543033
      // 19c: ldc_w 1094833017
      // 19f: ixor
      // 1a0: ldc_w -1094814125
      // 1a3: ldc_w 1094833017
      // 1a6: ixor
      // 1a7: i2c
      // 1a8: ineg
      // 1a9: iadd
      // 1aa: ldc_w -16543033
      // 1ad: ldc_w 1094833017
      // 1b0: ixor
      // 1b1: ldc_w -1094827565
      // 1b4: ldc_w 1094833017
      // 1b7: ixor
      // 1b8: i2c
      // 1b9: ineg
      // 1ba: iadd
      // 1bb: lload 0
      // 1bc: l2i
      // 1bd: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1c0: ldc_w -16543033
      // 1c3: ldc_w 1094833017
      // 1c6: ixor
      // 1c7: ldc_w -1094814115
      // 1ca: ldc_w 1094833017
      // 1cd: ixor
      // 1ce: i2c
      // 1cf: ineg
      // 1d0: iadd
      // 1d1: ldc_w 16543035
      // 1d4: ldc_w 1094833017
      // 1d7: ixor
      // 1d8: ldc_w -1094816845
      // 1db: ldc_w 1094833017
      // 1de: ixor
      // 1df: i2c
      // 1e0: iadd
      // 1e1: lload 0
      // 1e2: l2i
      // 1e3: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1e6: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: iload 13
      // 1ef: lload 0
      // 1f0: lconst_1
      // 1f1: lcmp
      // 1f2: ifle 0cb
      // 1f5: ifeq 0c4
      // 1f8: new java/util/ArrayList
      // 1fb: dup
      // 1fc: aload 3
      // 1fd: invokevirtual com/google/gson/JsonObject.entrySet ()Ljava/util/Set;
      // 200: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 203: astore 15
      // 205: aload 2
      // 206: lload 9
      // 208: invokestatic x/oc7d9b6bd5c4.ѹ (Lx/oc69da1aa7f5;J)Ljava/util/List;
      // 20b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 210: astore 16
      // 212: aload 16
      // 214: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 219: ifeq 315
      // 21c: aload 16
      // 21e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 223: checkcast x/N
      // 226: astore 17
      // 228: aload 3
      // 229: iload 13
      // 22b: ifne 240
      // 22e: aload 17
      // 230: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 233: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 236: lload 0
      // 237: lconst_0
      // 238: lcmp
      // 239: iflt 219
      // 23c: ifne 212
      // 23f: aload 3
      // 240: aload 2
      // 241: aload 17
      // 243: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 246: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 249: lload 0
      // 24a: lconst_1
      // 24b: lcmp
      // 24c: iflt 254
      // 24f: ifeq 261
      // 252: iload 13
      // 254: lload 0
      // 255: lconst_0
      // 256: lcmp
      // 257: iflt 219
      // 25a: ifeq 212
      // 25d: goto 261
      // 260: athrow
      // 261: aload 15
      // 263: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 268: astore 18
      // 26a: aload 18
      // 26c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 271: ifeq 310
      // 274: aload 18
      // 276: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 27b: checkcast java/util/Map$Entry
      // 27e: astore 19
      // 280: aload 17
      // 282: iload 13
      // 284: ifne 226
      // 287: lload 0
      // 288: lconst_1
      // 289: lcmp
      // 28a: ifle 223
      // 28d: iload 13
      // 28f: ifne 2ba
      // 292: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 295: aload 19
      // 297: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 29c: checkcast java/lang/String
      // 29f: lload 4
      // 2a1: invokestatic x/oc7d9b6bd5c4.ɖ (Ljava/lang/String;J)Ljava/lang/String;
      // 2a4: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 2a7: lload 0
      // 2a8: lconst_1
      // 2a9: lcmp
      // 2aa: ifle 303
      // 2ad: ifeq 301
      // 2b0: goto 2b4
      // 2b3: athrow
      // 2b4: aload 17
      // 2b6: goto 2ba
      // 2b9: athrow
      // 2ba: aload 19
      // 2bc: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 2c1: checkcast com/google/gson/JsonElement
      // 2c4: astore 11
      // 2c6: astore 12
      // 2c8: iload 6
      // 2ca: lload 0
      // 2cb: lconst_1
      // 2cc: lcmp
      // 2cd: iflt 303
      // 2d0: aload 12
      // 2d2: aload 11
      // 2d4: iload 7
      // 2d6: iload 8
      // 2d8: i2c
      // 2d9: invokestatic x/oc7d9b6bd5c4.ƙ (ILx/N;Lcom/google/gson/JsonElement;IC)Z
      // 2dc: ifeq 301
      // 2df: aload 3
      // 2e0: aload 17
      // 2e2: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 2e5: aload 19
      // 2e7: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 2ec: checkcast com/google/gson/JsonElement
      // 2ef: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 2f2: iload 13
      // 2f4: lload 0
      // 2f5: lconst_1
      // 2f6: lcmp
      // 2f7: ifle 312
      // 2fa: ifeq 310
      // 2fd: goto 301
      // 300: athrow
      // 301: iload 13
      // 303: ifeq 26a
      // 306: lload 0
      // 307: lconst_0
      // 308: lcmp
      // 309: iflt 280
      // 30c: goto 310
      // 30f: athrow
      // 310: iload 13
      // 312: ifeq 212
      // 315: lload 0
      // 316: lconst_1
      // 317: lcmp
      // 318: iflt 212
      // 31b: return
   }

   private static void Ʈ(oc69da1aa7f5 param0, JsonObject param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: lload 2
      // 001: dup2
      // 002: ldc2_w 3740712528218461100
      // 005: ldc2_w 3740721717673254416
      // 008: lxor
      // 009: lxor
      // 00a: lstore 4
      // 00c: dup2
      // 00d: ldc2_w 3740703422369316278
      // 010: ldc2_w 3740721717673254416
      // 013: lxor
      // 014: lxor
      // 015: lstore 6
      // 017: dup2
      // 018: ldc2_w 3740776426697136212
      // 01b: ldc2_w 3740721717673254416
      // 01e: lxor
      // 01f: lxor
      // 020: dup2
      // 021: ldc_w 2100357817
      // 024: ldc_w 2100357785
      // 027: ixor
      // 028: lushr
      // 029: l2i
      // 02a: istore 8
      // 02c: dup2
      // 02d: ldc_w 2100357817
      // 030: ldc_w 2100357785
      // 033: ixor
      // 034: lshl
      // 035: ldc_w 2100357801
      // 038: ldc_w 2100357785
      // 03b: ixor
      // 03c: lushr
      // 03d: l2i
      // 03e: istore 9
      // 040: dup2
      // 041: ldc_w 2100357801
      // 044: ldc_w 2100357785
      // 047: ixor
      // 048: lshl
      // 049: ldc_w 2100357801
      // 04c: ldc_w 2100357785
      // 04f: ixor
      // 050: lushr
      // 051: l2i
      // 052: istore 10
      // 054: pop2
      // 055: dup2
      // 056: ldc2_w 3740731457354659661
      // 059: ldc2_w 3740721717673254416
      // 05c: lxor
      // 05d: lxor
      // 05e: lstore 11
      // 060: dup2
      // 061: ldc2_w 3740711353591955359
      // 064: ldc2_w 3740721717673254416
      // 067: lxor
      // 068: lxor
      // 069: lstore 13
      // 06b: pop2
      // 06c: getstatic x/oc151419fdfe.v Z
      // 06f: aload 1
      // 070: ldc_w 1722879719
      // 073: ldc_w 2100357785
      // 076: ixor
      // 077: ldc_w -2100344086
      // 07a: ldc_w 2100357785
      // 07d: ixor
      // 07e: i2c
      // 07f: isub
      // 080: ldc_w 1722879719
      // 083: ldc_w 2100357785
      // 086: ixor
      // 087: ldc_w 2100334183
      // 08a: ldc_w 2100357785
      // 08d: ixor
      // 08e: isub
      // 08f: lload 2
      // 090: l2i
      // 091: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 094: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 097: astore 19
      // 099: istore 18
      // 09b: aload 19
      // 09d: iload 18
      // 09f: ifne 0ab
      // 0a2: ifnull 0b1
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 19
      // 0ab: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 0ae: ifne 0b3
      // 0b1: return
      // 0b2: athrow
      // 0b3: new java/util/ArrayList
      // 0b6: dup
      // 0b7: invokespecial java/util/ArrayList.<init> ()V
      // 0ba: astore 20
      // 0bc: aload 19
      // 0be: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 0c1: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 0c4: astore 21
      // 0c6: aload 21
      // 0c8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0cd: ifeq 15b
      // 0d0: aload 21
      // 0d2: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d7: checkcast com/google/gson/JsonElement
      // 0da: astore 22
      // 0dc: aload 22
      // 0de: lload 2
      // 0df: lconst_0
      // 0e0: lcmp
      // 0e1: ifle 0f2
      // 0e4: iload 18
      // 0e6: ifne 0f2
      // 0e9: ifnull 156
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: aload 22
      // 0f2: iload 18
      // 0f4: ifne 10d
      // 0f7: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 0fa: lload 2
      // 0fb: lconst_0
      // 0fc: lcmp
      // 0fd: iflt 158
      // 100: ifeq 156
      // 103: goto 107
      // 106: athrow
      // 107: aload 22
      // 109: goto 10d
      // 10c: athrow
      // 10d: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 110: ldc_w 1722879719
      // 113: ldc_w 2100357785
      // 116: ixor
      // 117: ldc_w -2100344096
      // 11a: ldc_w 2100357785
      // 11d: ixor
      // 11e: i2c
      // 11f: isub
      // 120: ldc_w -1722879717
      // 123: ldc_w 2100357785
      // 126: ixor
      // 127: ldc_w -2100346817
      // 12a: ldc_w 2100357785
      // 12d: ixor
      // 12e: i2c
      // 12f: ineg
      // 130: isub
      // 131: lload 2
      // 132: l2i
      // 133: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 136: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 139: iload 18
      // 13b: ifne 155
      // 13e: ifeq 156
      // 141: goto 145
      // 144: athrow
      // 145: aload 20
      // 147: aload 22
      // 149: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 14c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 151: goto 155
      // 154: athrow
      // 155: pop
      // 156: iload 18
      // 158: ifeq 0c6
      // 15b: aload 0
      // 15c: lload 2
      // 15d: lconst_0
      // 15e: lcmp
      // 15f: iflt 0d7
      // 162: lload 11
      // 164: invokestatic x/oc7d9b6bd5c4.ѹ (Lx/oc69da1aa7f5;J)Ljava/util/List;
      // 167: astore 21
      // 169: aload 20
      // 16b: invokeinterface java/util/List.size ()I 1
      // 170: newarray 4
      // 172: astore 22
      // 174: aload 0
      // 175: instanceof x/ocd2958dac48
      // 178: iload 18
      // 17a: ifne 1ad
      // 17d: ifne 1ac
      // 180: goto 184
      // 183: athrow
      // 184: aload 0
      // 185: instanceof x/oc42c8f83828
      // 188: iload 18
      // 18a: ifne 1ad
      // 18d: goto 191
      // 190: athrow
      // 191: ifne 1ac
      // 194: goto 198
      // 197: athrow
      // 198: aload 0
      // 199: instanceof x/oc446ce7e211
      // 19c: iload 18
      // 19e: ifne 1ad
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: ifeq 1b0
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: bipush 1
      // 1ad: goto 1b1
      // 1b0: bipush 0
      // 1b1: istore 23
      // 1b3: bipush 0
      // 1b4: istore 24
      // 1b6: iload 24
      // 1b8: aload 21
      // 1ba: invokeinterface java/util/List.size ()I 1
      // 1bf: if_icmpge 3f5
      // 1c2: aload 21
      // 1c4: iload 24
      // 1c6: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 1cb: checkcast x/N
      // 1ce: astore 25
      // 1d0: aload 1
      // 1d1: aload 0
      // 1d2: aload 25
      // 1d4: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 1d7: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 1da: iload 18
      // 1dc: ifne 208
      // 1df: ifeq 1f5
      // 1e2: goto 1e6
      // 1e5: athrow
      // 1e6: iload 18
      // 1e8: lload 2
      // 1e9: lconst_0
      // 1ea: lcmp
      // 1eb: ifle 3f2
      // 1ee: ifeq 3ed
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: aload 20
      // 1f7: lload 13
      // 1f9: aload 22
      // 1fb: aload 25
      // 1fd: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 200: bipush 0
      // 201: invokestatic x/oc7d9b6bd5c4.ѓ (Ljava/util/List;J[ZLjava/lang/String;Z)I
      // 204: goto 208
      // 207: athrow
      // 208: istore 26
      // 20a: iload 26
      // 20c: iload 18
      // 20e: ifne 243
      // 211: ifge 241
      // 214: goto 218
      // 217: athrow
      // 218: iload 23
      // 21a: lload 2
      // 21b: lconst_0
      // 21c: lcmp
      // 21d: iflt 243
      // 220: iload 18
      // 222: ifne 243
      // 225: goto 229
      // 228: athrow
      // 229: ifeq 241
      // 22c: goto 230
      // 22f: athrow
      // 230: aload 20
      // 232: lload 13
      // 234: aload 22
      // 236: aload 25
      // 238: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 23b: bipush 1
      // 23c: invokestatic x/oc7d9b6bd5c4.ѓ (Ljava/util/List;J[ZLjava/lang/String;Z)I
      // 23f: istore 26
      // 241: iload 26
      // 243: iload 18
      // 245: ifne 360
      // 248: ifge 35e
      // 24b: goto 24f
      // 24e: athrow
      // 24f: iload 24
      // 251: iload 18
      // 253: ifne 360
      // 256: goto 25a
      // 259: athrow
      // 25a: aload 20
      // 25c: invokeinterface java/util/List.size ()I 1
      // 261: if_icmpge 35e
      // 264: goto 268
      // 267: athrow
      // 268: aload 22
      // 26a: iload 24
      // 26c: baload
      // 26d: iload 18
      // 26f: ifne 360
      // 272: goto 276
      // 275: athrow
      // 276: ifne 35e
      // 279: goto 27d
      // 27c: athrow
      // 27d: aload 20
      // 27f: iload 18
      // 281: ifne 2d8
      // 284: goto 288
      // 287: athrow
      // 288: iload 24
      // 28a: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 28f: checkcast com/google/gson/JsonObject
      // 292: ldc_w 1722879719
      // 295: ldc_w 2100357785
      // 298: ixor
      // 299: ldc_w -2100344159
      // 29c: ldc_w 2100357785
      // 29f: ixor
      // 2a0: i2c
      // 2a1: isub
      // 2a2: ldc_w 1722879719
      // 2a5: ldc_w 2100357785
      // 2a8: ixor
      // 2a9: ldc_w 2100332065
      // 2ac: ldc_w 2100357785
      // 2af: ixor
      // 2b0: isub
      // 2b1: lload 2
      // 2b2: l2i
      // 2b3: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 2b6: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 2b9: ifeq 2d6
      // 2bc: goto 2c0
      // 2bf: athrow
      // 2c0: lload 4
      // 2c2: aload 0
      // 2c3: invokestatic x/oc7d9b6bd5c4.Ą (JLx/oc69da1aa7f5;)Z
      // 2c6: iload 18
      // 2c8: ifne 360
      // 2cb: goto 2cf
      // 2ce: athrow
      // 2cf: ifne 35e
      // 2d2: goto 2d6
      // 2d5: athrow
      // 2d6: aload 21
      // 2d8: aload 20
      // 2da: iload 24
      // 2dc: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 2e1: checkcast com/google/gson/JsonObject
      // 2e4: iload 23
      // 2e6: istore 15
      // 2e8: astore 16
      // 2ea: astore 17
      // 2ec: lload 6
      // 2ee: aload 17
      // 2f0: aload 16
      // 2f2: iload 15
      // 2f4: invokestatic x/oc7d9b6bd5c4.Ё (JLjava/util/List;Lcom/google/gson/JsonObject;Z)Z
      // 2f7: iload 18
      // 2f9: ifne 360
      // 2fc: ifne 35e
      // 2ff: goto 303
      // 302: athrow
      // 303: iload 8
      // 305: lload 2
      // 306: lconst_1
      // 307: lcmp
      // 308: iflt 360
      // 30b: aload 25
      // 30d: aload 20
      // 30f: iload 24
      // 311: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 316: checkcast com/google/gson/JsonObject
      // 319: ldc_w 1722879719
      // 31c: ldc_w 2100357785
      // 31f: ixor
      // 320: ldc_w -2100344096
      // 323: ldc_w 2100357785
      // 326: ixor
      // 327: i2c
      // 328: isub
      // 329: ldc_w -1722879717
      // 32c: ldc_w 2100357785
      // 32f: ixor
      // 330: ldc_w -2100346817
      // 333: ldc_w 2100357785
      // 336: ixor
      // 337: i2c
      // 338: ineg
      // 339: isub
      // 33a: lload 2
      // 33b: l2i
      // 33c: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 33f: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 342: iload 9
      // 344: iload 10
      // 346: i2c
      // 347: invokestatic x/oc7d9b6bd5c4.ƙ (ILx/N;Lcom/google/gson/JsonElement;IC)Z
      // 34a: iload 18
      // 34c: ifne 360
      // 34f: goto 353
      // 352: athrow
      // 353: ifeq 35e
      // 356: goto 35a
      // 359: athrow
      // 35a: iload 24
      // 35c: istore 26
      // 35e: iload 26
      // 360: ifge 372
      // 363: iload 18
      // 365: lload 2
      // 366: lconst_1
      // 367: lcmp
      // 368: iflt 3f2
      // 36b: ifeq 3ed
      // 36e: goto 372
      // 371: athrow
      // 372: aload 20
      // 374: iload 26
      // 376: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 37b: checkcast com/google/gson/JsonObject
      // 37e: ldc_w 1722879719
      // 381: ldc_w 2100357785
      // 384: ixor
      // 385: ldc_w -2100344096
      // 388: ldc_w 2100357785
      // 38b: ixor
      // 38c: i2c
      // 38d: isub
      // 38e: ldc_w -1722879717
      // 391: ldc_w 2100357785
      // 394: ixor
      // 395: ldc_w -2100346817
      // 398: ldc_w 2100357785
      // 39b: ixor
      // 39c: i2c
      // 39d: ineg
      // 39e: isub
      // 39f: lload 2
      // 3a0: l2i
      // 3a1: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 3a4: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 3a7: astore 27
      // 3a9: lload 2
      // 3aa: lconst_1
      // 3ab: lcmp
      // 3ac: ifle 3b4
      // 3af: iload 18
      // 3b1: ifne 3e2
      // 3b4: iload 8
      // 3b6: aload 25
      // 3b8: aload 27
      // 3ba: iload 9
      // 3bc: iload 10
      // 3be: i2c
      // 3bf: invokestatic x/oc7d9b6bd5c4.ƙ (ILx/N;Lcom/google/gson/JsonElement;IC)Z
      // 3c2: ifne 3d8
      // 3c5: goto 3c9
      // 3c8: athrow
      // 3c9: iload 18
      // 3cb: lload 2
      // 3cc: lconst_1
      // 3cd: lcmp
      // 3ce: ifle 3f2
      // 3d1: ifeq 3ed
      // 3d4: goto 3d8
      // 3d7: athrow
      // 3d8: aload 22
      // 3da: iload 26
      // 3dc: bipush 1
      // 3dd: bastore
      // 3de: goto 3e2
      // 3e1: athrow
      // 3e2: aload 1
      // 3e3: aload 25
      // 3e5: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 3e8: aload 27
      // 3ea: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 3ed: iinc 24 1
      // 3f0: iload 18
      // 3f2: ifeq 1b6
      // 3f5: return
   }

   private static boolean Ą(long var0, oc69da1aa7f5 var2) {
      byte var3 = oc151419fdfe.v;
      int var4 = a(-953319334 ^ -953288466, 6902305571136658630L ^ 9091424219759308025L ^ var0);

      while (true) {
         label278:
         while (true) {
            label274:
            while (true) {
               label272:
               while (true) {
                  switch (var4) {
                     case -1941818733:
                        return false;
                     case -1899601290:
                        break label278;
                     case -1877651078:
                        break label274;
                     case -1264066698:
                        int var19;
                        label153: {
                           label152: {
                              label151: {
                                 label307: {
                                    try {
                                       var19 = var2 instanceof oc491d322362;
                                       if (var0 <= 0L) {
                                          break label153;
                                       }

                                       if (var3 != 0) {
                                          break label152;
                                       }

                                       if (var19 != 0) {
                                          break label307;
                                       }
                                    } catch (RuntimeException var6) {
                                       throw var6;
                                    }

                                    var19 = -953294415 ^ -953288466;
                                    if (var0 < 1L) {
                                       break label151;
                                    }

                                    var4 = a(var19, 3159279758387756341L ^ 9091424219759308025L ^ var0);
                                    if (var3 == 0) {
                                       continue;
                                    }
                                 }

                                 var19 = -953312510 ^ -953288466;
                              }

                              var19 = a(var19, 8814777472926566362L ^ 9091424219759308025L ^ var0);
                           }

                           var4 = var19;
                           var19 = var3;
                        }

                        if (var0 < 1L) {
                           return (boolean)var19;
                        }

                        if (var19 != 0) {
                           return (boolean)1;
                        }
                        continue;
                     case 531373375:
                        label260: {
                           int var10000;
                           label295: {
                              label258: {
                                 long var10001;
                                 label257: {
                                    label296: {
                                       try {
                                          var10000 = var2 instanceof oc42c8f83828;
                                          if (var0 < 1L) {
                                             break label295;
                                          }

                                          if (var3 != 0) {
                                             break label258;
                                          }

                                          if (var10000 != 0) {
                                             break label296;
                                          }
                                       } catch (RuntimeException var11) {
                                          throw var11;
                                       }

                                       var10000 = -953312640 ^ -953288466;
                                       var10001 = 8517565746502452851L ^ 9091424219759308025L;
                                       if (var0 <= 0L) {
                                          break label257;
                                       }

                                       var4 = a(var10000, var10001 ^ var0);
                                       if (var3 == 0) {
                                          continue;
                                       }
                                    }

                                    var10000 = -953308134 ^ -953288466;
                                    var10001 = 1590519341313159382L ^ 9091424219759308025L ^ var0;
                                 }

                                 var10000 = a(var10000, var10001);
                              }

                              var4 = var10000;
                              if (var0 < 0L) {
                                 break label260;
                              }

                              var10000 = var3;
                           }

                           if (var10000 == 0) {
                              continue;
                           }
                        }
                     case 588678238:
                        int var13;
                        label292: {
                           label237: {
                              long var25;
                              label236: {
                                 label293: {
                                    try {
                                       var13 = var2 instanceof oc7ed5a3bedd;
                                       if (var0 <= 1L) {
                                          break label292;
                                       }

                                       if (var3 != 0) {
                                          break label237;
                                       }

                                       if (var13 != 0) {
                                          break label293;
                                       }
                                    } catch (RuntimeException var10) {
                                       throw var10;
                                    }

                                    var13 = -953314521 ^ -953288466;
                                    var25 = 4916935772298039201L ^ 9091424219759308025L;
                                    if (var0 <= 1L) {
                                       break label236;
                                    }

                                    var4 = a(var13, var25 ^ var0);
                                    if (var3 == 0) {
                                       continue;
                                    }
                                 }

                                 var13 = -953308134 ^ -953288466;
                                 var25 = 1590519341313159382L ^ 9091424219759308025L ^ var0;
                              }

                              var13 = a(var13, var25);
                           }

                           var4 = var13;
                           if (var0 < 1L) {
                              break;
                           }

                           var13 = var3;
                        }

                        if (var13 == 0) {
                           continue;
                        }
                        break;
                     case 638239378:
                        break label272;
                     case 1059921839:
                        break;
                     case 1660705742:
                        return (boolean)1;
                     default:
                        throw null;
                  }

                  int var15;
                  label298: {
                     label216: {
                        label215: {
                           label299: {
                              try {
                                 var15 = var2 instanceof ocd2958dac48;
                                 if (var0 < 0L) {
                                    break label298;
                                 }

                                 if (var3 != 0) {
                                    break label216;
                                 }

                                 if (var15 != 0) {
                                    break label299;
                                 }
                              } catch (RuntimeException var9) {
                                 throw var9;
                              }

                              var15 = -953304371 ^ -953288466;
                              if (var0 <= 0L) {
                                 break label215;
                              }

                              var4 = a(var15, 71876261229651520L ^ 9091424219759308025L ^ var0);
                              if (var3 == 0) {
                                 continue;
                              }
                           }

                           var15 = -953308134 ^ -953288466;
                        }

                        var15 = a(var15, 1590519341313159382L ^ 9091424219759308025L ^ var0);
                     }

                     var4 = var15;
                     if (var0 <= 1L) {
                        break;
                     }

                     var15 = var3;
                  }

                  if (var15 != 0) {
                     break;
                  }
               }

               int var17;
               label301: {
                  label194: {
                     long var26;
                     long var10002;
                     label193: {
                        label302: {
                           try {
                              var17 = var2 instanceof occ87a73ee8b;
                              if (var0 <= 0L) {
                                 break label301;
                              }

                              if (var3 != 0) {
                                 break label194;
                              }

                              if (var17 == 0) {
                                 break label302;
                              }
                           } catch (RuntimeException var8) {
                              throw var8;
                           }

                           var17 = -953308134 ^ -953288466;
                           var26 = 1590519341313159382L ^ 9091424219759308025L;
                           var10002 = var0;
                           if (var0 < 0L) {
                              break label193;
                           }

                           var4 = a(var17, var26 ^ var0);
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var17 = -953293817 ^ -953288466;
                        var26 = 3568022112720959650L ^ 9091424219759308025L;
                        var10002 = var0;
                     }

                     var17 = a(var17, var26 ^ var10002);
                  }

                  var4 = var17;
                  if (var0 <= 1L) {
                     break;
                  }

                  var17 = var3;
               }

               if (var17 != 0) {
                  break;
               }
            }

            int var21;
            label304: {
               label172: {
                  long var27;
                  label171: {
                     label305: {
                        try {
                           var21 = var2 instanceof oc446ce7e211;
                           if (var0 < 0L) {
                              break label304;
                           }

                           if (var3 != 0) {
                              break label172;
                           }

                           if (var21 != 0) {
                              break label305;
                           }
                        } catch (RuntimeException var7) {
                           throw var7;
                        }

                        var21 = -953297970 ^ -953288466;
                        var27 = 877532660953550638L ^ 9091424219759308025L ^ var0;
                        if (var0 < 0L) {
                           break label171;
                        }

                        var4 = a(var21, var27);
                        if (var3 == 0) {
                           continue;
                        }
                     }

                     var21 = -953308134 ^ -953288466;
                     var27 = 1590519341313159382L ^ 9091424219759308025L ^ var0;
                  }

                  var21 = a(var21, var27);
               }

               var4 = var21;
               if (var0 < 0L) {
                  break;
               }

               var21 = var3;
            }

            if (var21 != 0) {
               break;
            }
         }

         int var23;
         label131: {
            label130: {
               long var28;
               long var29;
               label129: {
                  label309: {
                     try {
                        var23 = var2 instanceof oced2c93b93e;
                        if (var0 <= 0L) {
                           break label131;
                        }

                        if (var3 != 0) {
                           break label130;
                        }

                        if (var23 != 0) {
                           break label309;
                        }
                     } catch (RuntimeException var5) {
                        throw var5;
                     }

                     var23 = -953310709 ^ -953288466;
                     var28 = 5252976264174403225L ^ 9091424219759308025L;
                     var29 = var0;
                     if (var0 <= 1L) {
                        break label129;
                     }

                     var4 = a(var23, var28 ^ var0);
                     if (var3 == 0) {
                        continue;
                     }
                  }

                  var23 = -953308134 ^ -953288466;
                  var28 = 1590519341313159382L ^ 9091424219759308025L;
                  var29 = var0;
               }

               var23 = a(var23, var28 ^ var29);
            }

            var4 = var23;
            var23 = var3;
         }

         if (var23 != 0) {
            return false;
         }
      }
   }

   private static boolean Ё(long param0, List param2, JsonObject param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: lload 0
      // 01: dup2
      // 02: ldc2_w 8217543164592526524
      // 05: ldc2_w 8217564295200867098
      // 08: lxor
      // 09: lxor
      // 0a: lstore 5
      // 0c: pop2
      // 0d: getstatic x/oc151419fdfe.v Z
      // 10: aload 3
      // 11: ldc_w 1826915401
      // 14: ldc_w -1165185583
      // 17: ixor
      // 18: ldc_w 1165175913
      // 1b: ldc_w -1165185583
      // 1e: ixor
      // 1f: isub
      // 20: ldc_w 1826915401
      // 23: ldc_w -1165185583
      // 26: ixor
      // 27: ldc_w 1165179113
      // 2a: ldc_w -1165185583
      // 2d: ixor
      // 2e: isub
      // 2f: lload 0
      // 30: l2i
      // 31: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 34: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 37: astore 8
      // 39: istore 7
      // 3b: aload 8
      // 3d: iload 7
      // 3f: ifne 4b
      // 42: ifnull 5a
      // 45: goto 49
      // 48: athrow
      // 49: aload 8
      // 4b: iload 7
      // 4d: ifne 5f
      // 50: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 53: ifne 5d
      // 56: goto 5a
      // 59: athrow
      // 5a: bipush 0
      // 5b: ireturn
      // 5c: athrow
      // 5d: aload 8
      // 5f: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 62: astore 9
      // 64: aload 2
      // 65: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 6a: astore 10
      // 6c: aload 10
      // 6e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 73: ifeq e5
      // 76: aload 10
      // 78: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 7d: checkcast x/N
      // 80: astore 11
      // 82: aload 11
      // 84: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 87: aload 9
      // 89: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 8c: iload 7
      // 8e: lload 0
      // 8f: lconst_0
      // 90: lcmp
      // 91: iflt 99
      // 94: ifne e6
      // 97: iload 7
      // 99: ifne df
      // 9c: goto a0
      // 9f: athrow
      // a0: ifne de
      // a3: goto a7
      // a6: athrow
      // a7: iload 4
      // a9: lload 0
      // aa: lconst_0
      // ab: lcmp
      // ac: iflt d2
      // af: iload 7
      // b1: ifne d2
      // b4: goto b8
      // b7: athrow
      // b8: ifeq e0
      // bb: goto bf
      // be: athrow
      // bf: aload 11
      // c1: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // c4: aload 9
      // c6: lload 5
      // c8: invokestatic x/oc7d9b6bd5c4.ɖ (Ljava/lang/String;J)Ljava/lang/String;
      // cb: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // ce: goto d2
      // d1: athrow
      // d2: iload 7
      // d4: ifne df
      // d7: ifeq e0
      // da: goto de
      // dd: athrow
      // de: bipush 1
      // df: ireturn
      // e0: iload 7
      // e2: ifeq 6c
      // e5: bipush 0
      // e6: ireturn
   }

   private static int ѓ(List param0, long param1, boolean[] param3, String param4, boolean param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: lload 1
      // 01: dup2
      // 02: ldc2_w 4768478129920049149
      // 05: ldc2_w 4768526446252960370
      // 08: lxor
      // 09: lxor
      // 0a: lstore 6
      // 0c: pop2
      // 0d: getstatic x/oc151419fdfe.v Z
      // 10: bipush 0
      // 11: istore 9
      // 13: istore 8
      // 15: iload 9
      // 17: aload 0
      // 18: invokeinterface java/util/List.size ()I 1
      // 1d: if_icmpge e1
      // 20: aload 3
      // 21: iload 8
      // 23: lload 1
      // 24: lconst_1
      // 25: lcmp
      // 26: iflt 2e
      // 29: ifne 54
      // 2c: iload 9
      // 2e: baload
      // 2f: iload 8
      // 31: ifne e8
      // 34: goto 38
      // 37: athrow
      // 38: ifeq 48
      // 3b: goto 3f
      // 3e: athrow
      // 3f: iload 8
      // 41: ifeq d9
      // 44: goto 48
      // 47: athrow
      // 48: aload 0
      // 49: iload 9
      // 4b: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 50: goto 54
      // 53: athrow
      // 54: checkcast com/google/gson/JsonObject
      // 57: ldc_w 452071155
      // 5a: ldc_w 1861059859
      // 5d: ixor
      // 5e: ldc_w 1861082362
      // 61: ldc_w 1861059859
      // 64: ixor
      // 65: iadd
      // 66: ldc_w 452071155
      // 69: ldc_w 1861059859
      // 6c: ixor
      // 6d: ldc_w 1861078906
      // 70: ldc_w 1861059859
      // 73: ixor
      // 74: iadd
      // 75: lload 1
      // 76: l2i
      // 77: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 7a: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 7d: astore 10
      // 7f: iload 8
      // 81: lload 1
      // 82: lconst_1
      // 83: lcmp
      // 84: iflt de
      // 87: ifne dc
      // 8a: aload 10
      // 8c: ifnull d9
      // 8f: goto 93
      // 92: athrow
      // 93: aload 10
      // 95: iload 8
      // 97: ifne ae
      // 9a: goto 9e
      // 9d: athrow
      // 9e: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // a1: ifeq d9
      // a4: goto a8
      // a7: athrow
      // a8: aload 10
      // aa: goto ae
      // ad: athrow
      // ae: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // b1: astore 11
      // b3: aload 4
      // b5: iload 5
      // b7: ifeq c5
      // ba: aload 11
      // bc: lload 6
      // be: invokestatic x/oc7d9b6bd5c4.ɖ (Ljava/lang/String;J)Ljava/lang/String;
      // c1: goto c7
      // c4: athrow
      // c5: aload 11
      // c7: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // ca: iload 8
      // cc: ifne d8
      // cf: ifeq d9
      // d2: goto d6
      // d5: athrow
      // d6: iload 9
      // d8: ireturn
      // d9: iinc 9 1
      // dc: iload 8
      // de: ifeq 15
      // e1: lload 1
      // e2: lconst_1
      // e3: lcmp
      // e4: iflt 20
      // e7: bipush -1
      // e8: ireturn
   }

   private static String ɖ(String var0, long var1) {
      return var0.substring(var0.lastIndexOf(a(-1244035940 ^ -1244009433, -6656803425804066729L ^ -2644674115887138378L ^ var1)) + 1);
   }

   private static void ћ(oc69da1aa7f5 param0, JsonObject param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: lload 2
      // 001: dup2
      // 002: ldc2_w -1351485179972326788
      // 005: ldc2_w -1351487119834043093
      // 008: lxor
      // 009: lxor
      // 00a: dup2
      // 00b: ldc_w -1077131217
      // 00e: ldc_w -1077131249
      // 011: ixor
      // 012: lushr
      // 013: l2i
      // 014: istore 4
      // 016: dup2
      // 017: ldc_w -1077131217
      // 01a: ldc_w -1077131249
      // 01d: ixor
      // 01e: lshl
      // 01f: ldc_w -1077131201
      // 022: ldc_w -1077131249
      // 025: ixor
      // 026: lushr
      // 027: l2i
      // 028: istore 5
      // 02a: dup2
      // 02b: ldc_w -1077131201
      // 02e: ldc_w -1077131249
      // 031: ixor
      // 032: lshl
      // 033: ldc_w -1077131201
      // 036: ldc_w -1077131249
      // 039: ixor
      // 03a: lushr
      // 03b: l2i
      // 03c: istore 6
      // 03e: pop2
      // 03f: dup2
      // 040: ldc2_w -1351405049812908699
      // 043: ldc2_w -1351487119834043093
      // 046: lxor
      // 047: lxor
      // 048: lstore 7
      // 04a: pop2
      // 04b: getstatic x/oc151419fdfe.v Z
      // 04e: istore 9
      // 050: aload 1
      // 051: iload 9
      // 053: ifne 0b5
      // 056: ldc_w -2080928821
      // 059: ldc_w -1077131249
      // 05c: ixor
      // 05d: ldc_w 1077135707
      // 060: ldc_w -1077131249
      // 063: ixor
      // 064: i2c
      // 065: iadd
      // 066: ldc_w -2080928821
      // 069: ldc_w -1077131249
      // 06c: ixor
      // 06d: ldc_w 1077146304
      // 070: ldc_w -1077131249
      // 073: ixor
      // 074: i2c
      // 075: lload 2
      // 076: lconst_0
      // 077: lcmp
      // 078: ifle 0af
      // 07b: iadd
      // 07c: lload 2
      // 07d: l2i
      // 07e: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 081: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 084: ifeq 08d
      // 087: goto 08b
      // 08a: athrow
      // 08b: return
      // 08c: athrow
      // 08d: aload 1
      // 08e: ldc_w -2080928821
      // 091: ldc_w -1077131249
      // 094: ixor
      // 095: ldc_w 1077135704
      // 098: ldc_w -1077131249
      // 09b: ixor
      // 09c: i2c
      // 09d: iadd
      // 09e: ldc_w 2080928819
      // 0a1: ldc_w -1077131249
      // 0a4: ixor
      // 0a5: ldc_w 1077149383
      // 0a8: ldc_w -1077131249
      // 0ab: ixor
      // 0ac: iadd
      // 0ad: lload 2
      // 0ae: l2i
      // 0af: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0b2: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0b5: astore 10
      // 0b7: aload 10
      // 0b9: lload 2
      // 0ba: lconst_1
      // 0bb: lcmp
      // 0bc: ifle 0cd
      // 0bf: iload 9
      // 0c1: ifne 0cd
      // 0c4: ifnull 0dc
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: aload 10
      // 0cd: iload 9
      // 0cf: ifne 0e0
      // 0d2: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 0d5: ifne 0de
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: return
      // 0dd: athrow
      // 0de: aload 10
      // 0e0: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 0e3: astore 11
      // 0e5: aload 11
      // 0e7: aload 0
      // 0e8: invokevirtual x/oc69da1aa7f5.ђ ()Ljava/lang/String;
      // 0eb: lload 2
      // 0ec: lconst_1
      // 0ed: lcmp
      // 0ee: iflt 139
      // 0f1: iload 9
      // 0f3: ifne 139
      // 0f6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0f9: ifne 16f
      // 0fc: goto 100
      // 0ff: athrow
      // 100: aload 11
      // 102: lload 2
      // 103: lconst_0
      // 104: lcmp
      // 105: iflt 145
      // 108: iload 9
      // 10a: ifne 145
      // 10d: goto 111
      // 110: athrow
      // 111: ldc_w -2080928821
      // 114: ldc_w -1077131249
      // 117: ixor
      // 118: ldc_w 1077135706
      // 11b: ldc_w -1077131249
      // 11e: ixor
      // 11f: i2c
      // 120: iadd
      // 121: ldc_w 2080928819
      // 124: ldc_w -1077131249
      // 127: ixor
      // 128: ldc_w 1077147783
      // 12b: ldc_w -1077131249
      // 12e: ixor
      // 12f: iadd
      // 130: lload 2
      // 131: l2i
      // 132: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 135: goto 139
      // 138: athrow
      // 139: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 13c: ifne 171
      // 13f: aload 11
      // 141: goto 145
      // 144: athrow
      // 145: ldc_w -2080928821
      // 148: ldc_w -1077131249
      // 14b: ixor
      // 14c: ldc_w 1077135787
      // 14f: ldc_w -1077131249
      // 152: ixor
      // 153: i2c
      // 154: iadd
      // 155: ldc_w 2080928819
      // 158: ldc_w -1077131249
      // 15b: ixor
      // 15c: ldc_w 1077140814
      // 15f: ldc_w -1077131249
      // 162: ixor
      // 163: iadd
      // 164: lload 2
      // 165: l2i
      // 166: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 169: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 16c: ifne 171
      // 16f: return
      // 170: athrow
      // 171: new java/util/ArrayList
      // 174: dup
      // 175: invokespecial java/util/ArrayList.<init> ()V
      // 178: astore 12
      // 17a: aload 1
      // 17b: invokevirtual com/google/gson/JsonObject.entrySet ()Ljava/util/Set;
      // 17e: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 183: astore 13
      // 185: aload 13
      // 187: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 18c: ifeq 1ed
      // 18f: aload 13
      // 191: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 196: checkcast java/util/Map$Entry
      // 199: astore 14
      // 19b: aload 14
      // 19d: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 1a2: checkcast java/lang/String
      // 1a5: ldc_w -2080928821
      // 1a8: ldc_w -1077131249
      // 1ab: ixor
      // 1ac: ldc_w 1077135807
      // 1af: ldc_w -1077131249
      // 1b2: ixor
      // 1b3: i2c
      // 1b4: iadd
      // 1b5: ldc_w 2080928819
      // 1b8: ldc_w -1077131249
      // 1bb: ixor
      // 1bc: ldc_w 1077141283
      // 1bf: ldc_w -1077131249
      // 1c2: ixor
      // 1c3: i2c
      // 1c4: ineg
      // 1c5: iadd
      // 1c6: lload 2
      // 1c7: l2i
      // 1c8: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1cb: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 1ce: iload 9
      // 1d0: ifne 1e7
      // 1d3: ifeq 1e8
      // 1d6: goto 1da
      // 1d9: athrow
      // 1da: aload 12
      // 1dc: aload 14
      // 1de: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1e3: goto 1e7
      // 1e6: athrow
      // 1e7: pop
      // 1e8: iload 9
      // 1ea: ifeq 185
      // 1ed: aload 0
      // 1ee: lload 2
      // 1ef: lconst_0
      // 1f0: lcmp
      // 1f1: ifle 196
      // 1f4: lload 7
      // 1f6: invokestatic x/oc7d9b6bd5c4.ѹ (Lx/oc69da1aa7f5;J)Ljava/util/List;
      // 1f9: astore 13
      // 1fb: aload 13
      // 1fd: invokeinterface java/util/List.size ()I 1
      // 202: aload 12
      // 204: invokeinterface java/util/List.size ()I 1
      // 209: invokestatic java/lang/Math.min (II)I
      // 20c: istore 14
      // 20e: bipush 0
      // 20f: istore 15
      // 211: iload 15
      // 213: iload 14
      // 215: if_icmpge 304
      // 218: aload 13
      // 21a: iload 15
      // 21c: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 221: checkcast x/N
      // 224: astore 16
      // 226: iload 9
      // 228: aload 0
      // 229: aload 16
      // 22b: invokevirtual x/oc69da1aa7f5.ɋ (Lx/N;)Ljava/lang/String;
      // 22e: astore 17
      // 230: aload 16
      // 232: invokevirtual x/N.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 235: astore 18
      // 237: lload 2
      // 238: lconst_1
      // 239: lcmp
      // 23a: ifle 246
      // 23d: ifne 2ff
      // 240: aload 1
      // 241: aload 17
      // 243: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 246: ifne 2fc
      // 249: goto 24d
      // 24c: athrow
      // 24d: aload 1
      // 24e: iload 9
      // 250: ifne 279
      // 253: goto 257
      // 256: athrow
      // 257: aload 18
      // 259: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 25c: ifeq 26c
      // 25f: goto 263
      // 262: athrow
      // 263: iload 9
      // 265: ifeq 2fc
      // 268: goto 26c
      // 26b: athrow
      // 26c: aload 12
      // 26e: iload 15
      // 270: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 275: goto 279
      // 278: athrow
      // 279: checkcast java/util/Map$Entry
      // 27c: astore 19
      // 27e: iload 9
      // 280: lload 2
      // 281: lconst_0
      // 282: lcmp
      // 283: iflt 301
      // 286: ifne 2ff
      // 289: aload 19
      // 28b: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 290: checkcast java/lang/String
      // 293: ldc_w -2080928821
      // 296: ldc_w -1077131249
      // 299: ixor
      // 29a: ldc_w 1077135763
      // 29d: ldc_w -1077131249
      // 2a0: ixor
      // 2a1: i2c
      // 2a2: iadd
      // 2a3: ldc_w -2080928821
      // 2a6: ldc_w -1077131249
      // 2a9: ixor
      // 2aa: ldc_w 1077135028
      // 2ad: ldc_w -1077131249
      // 2b0: ixor
      // 2b1: i2c
      // 2b2: iadd
      // 2b3: lload 2
      // 2b4: l2i
      // 2b5: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 2b8: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 2bb: ifeq 2fc
      // 2be: goto 2c2
      // 2c1: athrow
      // 2c2: iload 4
      // 2c4: aload 16
      // 2c6: aload 19
      // 2c8: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 2cd: checkcast com/google/gson/JsonElement
      // 2d0: iload 5
      // 2d2: iload 6
      // 2d4: i2c
      // 2d5: invokestatic x/oc7d9b6bd5c4.ƙ (ILx/N;Lcom/google/gson/JsonElement;IC)Z
      // 2d8: ifne 2e8
      // 2db: goto 2df
      // 2de: athrow
      // 2df: iload 9
      // 2e1: ifeq 2fc
      // 2e4: goto 2e8
      // 2e7: athrow
      // 2e8: aload 1
      // 2e9: aload 18
      // 2eb: aload 19
      // 2ed: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 2f2: checkcast com/google/gson/JsonElement
      // 2f5: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 2f8: goto 2fc
      // 2fb: athrow
      // 2fc: iinc 15 1
      // 2ff: iload 9
      // 301: ifeq 211
      // 304: return
   }

   private static List ѹ(oc69da1aa7f5 param0, long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: lload 1
      // 01: dup2
      // 02: ldc2_w 3914791169930320792
      // 05: ldc2_w 3914854065342958352
      // 08: lxor
      // 09: lxor
      // 0a: lstore 3
      // 0b: pop2
      // 0c: getstatic x/oc151419fdfe.v Z
      // 0f: new java/util/ArrayList
      // 12: dup
      // 13: invokespecial java/util/ArrayList.<init> ()V
      // 16: astore 6
      // 18: aload 0
      // 19: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 1c: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 1f: astore 7
      // 21: istore 5
      // 23: aload 7
      // 25: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2a: ifeq 5e
      // 2d: aload 7
      // 2f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 34: checkcast x/N
      // 37: astore 8
      // 39: lload 3
      // 3a: aload 8
      // 3c: invokestatic x/oc7d9b6bd5c4.Ʋ (JLx/N;)Z
      // 3f: iload 5
      // 41: ifne 58
      // 44: ifeq 59
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 6
      // 4d: aload 8
      // 4f: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 54: goto 58
      // 57: athrow
      // 58: pop
      // 59: iload 5
      // 5b: ifeq 23
      // 5e: aload 6
      // 60: lload 1
      // 61: lconst_1
      // 62: lcmp
      // 63: ifle 34
      // 66: areturn
   }

   private static boolean Ʋ(long param0, N param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 3
      // 04: aload 2
      // 05: lload 0
      // 06: lconst_1
      // 07: lcmp
      // 08: ifle 36
      // 0b: iload 3
      // 0c: ifne 36
      // 0f: instanceof x/occ2f8dff8d8
      // 12: ifeq 35
      // 15: goto 19
      // 18: athrow
      // 19: aload 2
      // 1a: checkcast x/occ2f8dff8d8
      // 1d: getfield x/occ2f8dff8d8.ӽ Z
      // 20: iload 3
      // 21: ifne 30
      // 24: goto 28
      // 27: athrow
      // 28: ifne 33
      // 2b: goto 2f
      // 2e: athrow
      // 2f: bipush 1
      // 30: goto 34
      // 33: bipush 0
      // 34: ireturn
      // 35: aload 2
      // 36: iload 3
      // 37: ifne 61
      // 3a: instanceof x/oc321b4679dd
      // 3d: ifeq 60
      // 40: goto 44
      // 43: athrow
      // 44: aload 2
      // 45: checkcast x/oc321b4679dd
      // 48: invokevirtual x/oc321b4679dd.Ǽ ()Z
      // 4b: iload 3
      // 4c: ifne 5b
      // 4f: goto 53
      // 52: athrow
      // 53: ifne 5e
      // 56: goto 5a
      // 59: athrow
      // 5a: bipush 1
      // 5b: goto 5f
      // 5e: bipush 0
      // 5f: ireturn
      // 60: aload 2
      // 61: instanceof x/oca9cc61aada
      // 64: iload 3
      // 65: ifne e2
      // 68: ifne e1
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 2
      // 70: instanceof x/ocf1568fef75
      // 73: iload 3
      // 74: ifne e2
      // 77: goto 7b
      // 7a: athrow
      // 7b: ifne e1
      // 7e: goto 82
      // 81: athrow
      // 82: aload 2
      // 83: instanceof x/ocada7dda290
      // 86: iload 3
      // 87: ifne e2
      // 8a: goto 8e
      // 8d: athrow
      // 8e: ifne e1
      // 91: goto 95
      // 94: athrow
      // 95: aload 2
      // 96: instanceof x/ocb23d192a35
      // 99: iload 3
      // 9a: ifne e2
      // 9d: goto a1
      // a0: athrow
      // a1: ifne e1
      // a4: goto a8
      // a7: athrow
      // a8: aload 2
      // a9: instanceof x/oc24a0a5bddf
      // ac: iload 3
      // ad: ifne e2
      // b0: goto b4
      // b3: athrow
      // b4: ifne e1
      // b7: goto bb
      // ba: athrow
      // bb: aload 2
      // bc: instanceof x/oc10354c7bb8
      // bf: iload 3
      // c0: ifne e2
      // c3: goto c7
      // c6: athrow
      // c7: ifne e1
      // ca: goto ce
      // cd: athrow
      // ce: aload 2
      // cf: instanceof x/oc6af36febc3
      // d2: iload 3
      // d3: ifne e2
      // d6: goto da
      // d9: athrow
      // da: ifeq e5
      // dd: goto e1
      // e0: athrow
      // e1: bipush 1
      // e2: goto e6
      // e5: bipush 0
      // e6: ireturn
   }

   private static boolean ƙ(int param0, N param1, JsonElement param2, int param3, char param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: iload 0
      // 001: i2l
      // 002: ldc_w -28194050
      // 005: ldc_w -28194082
      // 008: ixor
      // 009: lshl
      // 00a: iload 3
      // 00b: i2l
      // 00c: ldc_w -28194066
      // 00f: ldc_w -28194082
      // 012: ixor
      // 013: lshl
      // 014: ldc_w -28194050
      // 017: ldc_w -28194082
      // 01a: ixor
      // 01b: lushr
      // 01c: lor
      // 01d: iload 4
      // 01f: i2l
      // 020: ldc_w -28194066
      // 023: ldc_w -28194082
      // 026: ixor
      // 027: lshl
      // 028: ldc_w -28194066
      // 02b: ldc_w -28194082
      // 02e: ixor
      // 02f: lushr
      // 030: lor
      // 031: lstore 5
      // 033: getstatic x/oc151419fdfe.v Z
      // 036: istore 7
      // 038: aload 2
      // 039: iload 7
      // 03b: ifne 046
      // 03e: ifnull 059
      // 041: goto 045
      // 044: athrow
      // 045: aload 2
      // 046: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 049: iload 3
      // 04a: iflt 06d
      // 04d: iload 7
      // 04f: ifne 06d
      // 052: ifeq 05c
      // 055: goto 059
      // 058: athrow
      // 059: bipush 0
      // 05a: ireturn
      // 05b: athrow
      // 05c: aload 1
      // 05d: iload 0
      // 05e: iflt 0a7
      // 061: iload 7
      // 063: ifne 0a7
      // 066: instanceof x/occ2f8dff8d8
      // 069: goto 06d
      // 06c: athrow
      // 06d: ifeq 0a6
      // 070: aload 2
      // 071: iload 4
      // 073: iflt 08e
      // 076: iload 7
      // 078: ifne 08e
      // 07b: goto 07f
      // 07e: athrow
      // 07f: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 082: ifeq 0a4
      // 085: goto 089
      // 088: athrow
      // 089: aload 2
      // 08a: goto 08e
      // 08d: athrow
      // 08e: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 091: invokevirtual com/google/gson/JsonPrimitive.isBoolean ()Z
      // 094: iload 7
      // 096: ifne 0a1
      // 099: ifeq 0a4
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: bipush 1
      // 0a1: goto 0a5
      // 0a4: bipush 0
      // 0a5: ireturn
      // 0a6: aload 1
      // 0a7: instanceof x/oca9cc61aada
      // 0aa: iload 7
      // 0ac: ifne 0e3
      // 0af: ifne 0ce
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: aload 1
      // 0b7: iload 0
      // 0b8: ifle 100
      // 0bb: iload 7
      // 0bd: ifne 100
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: instanceof x/ocb23d192a35
      // 0c7: ifeq 0ff
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: aload 2
      // 0cf: iload 3
      // 0d0: iflt 0e7
      // 0d3: iload 7
      // 0d5: ifne 0e7
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: ifeq 0fd
      // 0e6: aload 2
      // 0e7: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 0ea: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 0ed: iload 7
      // 0ef: ifne 0fa
      // 0f2: ifeq 0fd
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: bipush 1
      // 0fa: goto 0fe
      // 0fd: bipush 0
      // 0fe: ireturn
      // 0ff: aload 1
      // 100: iload 7
      // 102: iload 0
      // 103: iflt 160
      // 106: ifne 15e
      // 109: instanceof x/ocf1568fef75
      // 10c: ifeq 15d
      // 10f: goto 113
      // 112: athrow
      // 113: aload 2
      // 114: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 117: iload 7
      // 119: ifne 158
      // 11c: goto 120
      // 11f: athrow
      // 120: ifne 157
      // 123: goto 127
      // 126: athrow
      // 127: aload 2
      // 128: iload 4
      // 12a: iflt 145
      // 12d: iload 7
      // 12f: ifne 145
      // 132: goto 136
      // 135: athrow
      // 136: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 139: ifeq 15b
      // 13c: goto 140
      // 13f: athrow
      // 140: aload 2
      // 141: goto 145
      // 144: athrow
      // 145: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 148: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 14b: iload 7
      // 14d: ifne 158
      // 150: ifeq 15b
      // 153: goto 157
      // 156: athrow
      // 157: bipush 1
      // 158: goto 15c
      // 15b: bipush 0
      // 15c: ireturn
      // 15d: aload 1
      // 15e: iload 7
      // 160: ifne 19c
      // 163: instanceof x/ocada7dda290
      // 166: ifeq 19b
      // 169: goto 16d
      // 16c: athrow
      // 16d: aload 2
      // 16e: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 171: iload 7
      // 173: ifne 196
      // 176: goto 17a
      // 179: athrow
      // 17a: ifne 195
      // 17d: goto 181
      // 180: athrow
      // 181: aload 2
      // 182: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 185: iload 7
      // 187: ifne 196
      // 18a: goto 18e
      // 18d: athrow
      // 18e: ifeq 199
      // 191: goto 195
      // 194: athrow
      // 195: bipush 1
      // 196: goto 19a
      // 199: bipush 0
      // 19a: ireturn
      // 19b: aload 1
      // 19c: instanceof x/oc321b4679dd
      // 19f: iload 7
      // 1a1: ifne 1c7
      // 1a4: ifne 1bf
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: aload 1
      // 1ac: instanceof x/oc24a0a5bddf
      // 1af: iload 7
      // 1b1: ifne 1cc
      // 1b4: goto 1b8
      // 1b7: athrow
      // 1b8: ifeq 1c8
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: aload 2
      // 1c0: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: ireturn
      // 1c8: aload 2
      // 1c9: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 1cc: ireturn
   }

   private List<oc69da1aa7f5> α() {
      return new ArrayList<>(oc2cf3d80e17.ó().տ());
   }

   private Map ś(List param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: new java/util/HashMap
      // 06: dup
      // 07: invokespecial java/util/HashMap.<init> ()V
      // 0a: astore 5
      // 0c: istore 4
      // 0e: aload 1
      // 0f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 14: astore 6
      // 16: aload 6
      // 18: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1d: ifeq 76
      // 20: aload 6
      // 22: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 27: checkcast x/oc69da1aa7f5
      // 2a: astore 7
      // 2c: aload 7
      // 2e: invokevirtual x/oc69da1aa7f5.canBeEnabled ()Z
      // 31: lload 2
      // 32: lconst_1
      // 33: lcmp
      // 34: iflt 73
      // 37: ifeq 71
      // 3a: aload 5
      // 3c: aload 7
      // 3e: new x/oca04ceef104
      // 41: dup
      // 42: aload 7
      // 44: instanceof x/oc3b38397625
      // 47: ifne 62
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 7
      // 50: instanceof x/ocd3ffe14280
      // 53: ifne 62
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 7
      // 5c: instanceof x/oced2c93b93e
      // 5f: ifeq 66
      // 62: bipush 1
      // 63: goto 67
      // 66: bipush 0
      // 67: bipush 0
      // 68: invokespecial x/oca04ceef104.<init> (ZI)V
      // 6b: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 70: pop
      // 71: iload 4
      // 73: ifeq 16
      // 76: aload 5
      // 78: lload 2
      // 79: lconst_0
      // 7a: lcmp
      // 7b: ifle 27
      // 7e: areturn
   }

   public boolean ŏ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w -3219862207442060876
      // 003: ldc2_w -3219892703321665238
      // 006: lxor
      // 007: lstore 2
      // 008: lload 2
      // 009: dup2
      // 00a: ldc2_w -3219812843960788421
      // 00d: ldc2_w -3219892703321665238
      // 010: lxor
      // 011: lxor
      // 012: lstore 4
      // 014: dup2
      // 015: ldc2_w -3219836082282498264
      // 018: ldc2_w -3219892703321665238
      // 01b: lxor
      // 01c: lxor
      // 01d: lstore 6
      // 01f: dup2
      // 020: ldc2_w -3219870510355645782
      // 023: ldc2_w -3219892703321665238
      // 026: lxor
      // 027: lxor
      // 028: lstore 8
      // 02a: pop2
      // 02b: getstatic x/oc151419fdfe.v Z
      // 02e: aload 0
      // 02f: aload 1
      // 030: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 033: astore 11
      // 035: istore 10
      // 037: aload 11
      // 039: iload 10
      // 03b: ifne 047
      // 03e: ifnull 04d
      // 041: goto 045
      // 044: athrow
      // 045: aload 11
      // 047: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 04a: goto 054
      // 04d: aload 0
      // 04e: aload 1
      // 04f: lload 6
      // 051: invokevirtual x/oc7d9b6bd5c4.ǵ (Ljava/lang/String;J)Ljava/lang/String;
      // 054: astore 12
      // 056: new java/io/File
      // 059: dup
      // 05a: aload 0
      // 05b: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 05e: aload 12
      // 060: ldc_w ".json"
      // 063: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 068: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 06b: astore 13
      // 06d: aload 13
      // 06f: iload 10
      // 071: ifne 084
      // 074: invokevirtual java/io/File.exists ()Z
      // 077: ifeq 0aa
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 13
      // 080: goto 084
      // 083: athrow
      // 084: iload 10
      // 086: ifne 099
      // 089: invokevirtual java/io/File.delete ()Z
      // 08c: ifne 0aa
      // 08f: goto 093
      // 092: athrow
      // 093: aload 13
      // 095: goto 099
      // 098: athrow
      // 099: invokevirtual java/io/File.exists ()Z
      // 09c: iload 10
      // 09e: ifne 0a9
      // 0a1: ifeq 0aa
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: bipush 0
      // 0a9: ireturn
      // 0aa: aload 11
      // 0ac: iload 10
      // 0ae: ifne 0bb
      // 0b1: ifnull 0c5
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 0bb: aload 11
      // 0bd: if_acmpne 0c5
      // 0c0: bipush 1
      // 0c1: goto 0c6
      // 0c4: athrow
      // 0c5: bipush 0
      // 0c6: istore 14
      // 0c8: aload 11
      // 0ca: ifnull 0dd
      // 0cd: aload 0
      // 0ce: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 0d1: aload 11
      // 0d3: invokeinterface java/util/List.remove (Ljava/lang/Object;)Z 2
      // 0d8: pop
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: iload 14
      // 0df: iload 10
      // 0e1: ifne 105
      // 0e4: ifeq 0f3
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aconst_null
      // 0ec: putstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: aload 0
      // 0f4: iload 10
      // 0f6: ifne 11a
      // 0f9: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 0fc: invokeinterface java/util/List.isEmpty ()Z 1
      // 101: goto 105
      // 104: athrow
      // 105: ifeq 119
      // 108: aload 0
      // 109: ldc "default"
      // 10b: bipush 0
      // 10c: invokevirtual x/oc7d9b6bd5c4.χ (Ljava/lang/String;I)Lx/oc151419fdfe;
      // 10f: ifnonnull 11f
      // 112: goto 116
      // 115: athrow
      // 116: bipush 0
      // 117: ireturn
      // 118: athrow
      // 119: aload 0
      // 11a: lload 4
      // 11c: invokevirtual x/oc7d9b6bd5c4.ҷ (J)V
      // 11f: iload 14
      // 121: ifeq 148
      // 124: aload 0
      // 125: lload 8
      // 127: invokevirtual x/oc7d9b6bd5c4.զ (J)Lx/oc151419fdfe;
      // 12a: iload 10
      // 12c: ifne 14a
      // 12f: goto 133
      // 132: athrow
      // 133: astore 15
      // 135: aload 15
      // 137: ifnull 148
      // 13a: aload 0
      // 13b: aload 15
      // 13d: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 140: invokevirtual x/oc7d9b6bd5c4.б (Ljava/lang/String;)Z
      // 143: pop
      // 144: goto 148
      // 147: athrow
      // 148: aload 11
      // 14a: ifnull 152
      // 14d: bipush 1
      // 14e: goto 153
      // 151: athrow
      // 152: bipush 0
      // 153: ireturn
   }

   public void Ё() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w 5837391744818211368
      // 003: ldc2_w 5837484781277642173
      // 006: lxor
      // 007: lstore 1
      // 008: lload 1
      // 009: dup2
      // 00a: ldc2_w 5837432558729562535
      // 00d: ldc2_w 5837484781277642173
      // 010: lxor
      // 011: lxor
      // 012: lstore 3
      // 013: pop2
      // 014: getstatic x/oc151419fdfe.v Z
      // 017: istore 5
      // 019: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 01c: iload 5
      // 01e: ifne 02b
      // 021: ifnull 031
      // 024: goto 028
      // 027: athrow
      // 028: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 02b: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 02e: goto 032
      // 031: aconst_null
      // 032: astore 6
      // 034: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 037: iload 5
      // 039: ifne 046
      // 03c: ifnull 058
      // 03f: goto 043
      // 042: athrow
      // 043: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 046: invokevirtual x/oc151419fdfe.ǚ ()Lx/ocdd0f49ff2f;
      // 049: getfield x/ocdd0f49ff2f.Ƌ Z
      // 04c: iload 5
      // 04e: ifne 059
      // 051: ifeq 05c
      // 054: goto 058
      // 057: athrow
      // 058: bipush 1
      // 059: goto 05d
      // 05c: bipush 0
      // 05d: istore 7
      // 05f: aload 0
      // 060: iload 5
      // 062: ifne 09b
      // 065: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 068: invokeinterface java/util/List.clear ()V 1
      // 06d: aload 0
      // 06e: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 071: invokevirtual java/io/File.exists ()Z
      // 074: ifne 09a
      // 077: goto 07b
      // 07a: athrow
      // 07b: aload 0
      // 07c: iload 5
      // 07e: ifne 09b
      // 081: goto 085
      // 084: athrow
      // 085: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 088: invokevirtual java/io/File.mkdirs ()Z
      // 08b: ifne 09a
      // 08e: goto 092
      // 091: athrow
      // 092: ldc_w "&cFailed to load configs."
      // 095: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 098: return
      // 099: athrow
      // 09a: aload 0
      // 09b: invokevirtual x/oc7d9b6bd5c4.ž ()Ljava/util/List;
      // 09e: astore 8
      // 0a0: aload 8
      // 0a2: iload 5
      // 0a4: ifne 0ca
      // 0a7: invokeinterface java/util/List.isEmpty ()Z 1
      // 0ac: ifeq 0c8
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 0
      // 0b4: new x/oc151419fdfe
      // 0b7: dup
      // 0b8: ldc "default"
      // 0ba: bipush 0
      // 0bb: invokespecial x/oc151419fdfe.<init> (Ljava/lang/String;I)V
      // 0be: invokevirtual x/oc7d9b6bd5c4.Ϧ (Lx/oc151419fdfe;)Z
      // 0c1: pop
      // 0c2: aload 0
      // 0c3: invokevirtual x/oc7d9b6bd5c4.ž ()Ljava/util/List;
      // 0c6: astore 8
      // 0c8: aload 8
      // 0ca: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0cf: astore 9
      // 0d1: aload 9
      // 0d3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0d8: ifeq 15e
      // 0db: aload 9
      // 0dd: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e2: checkcast java/io/File
      // 0e5: astore 10
      // 0e7: aload 10
      // 0e9: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0ec: invokestatic x/oc0326f6e039.È (Ljava/nio/file/Path;)Lcom/google/gson/JsonObject;
      // 0ef: astore 11
      // 0f1: iload 5
      // 0f3: aload 10
      // 0f5: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // 0f8: ldc_w ".json"
      // 0fb: ldc_w ""
      // 0fe: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 101: astore 12
      // 103: bipush 0
      // 104: istore 13
      // 106: ifne 1b2
      // 109: aload 11
      // 10b: ldc "keybind"
      // 10d: iload 5
      // 10f: ifne 128
      // 112: goto 116
      // 115: athrow
      // 116: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 119: ifeq 130
      // 11c: goto 120
      // 11f: athrow
      // 120: aload 11
      // 122: ldc "keybind"
      // 124: goto 128
      // 127: athrow
      // 128: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 12b: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 12e: istore 13
      // 130: new x/oc151419fdfe
      // 133: dup
      // 134: aload 12
      // 136: iload 13
      // 138: invokespecial x/oc151419fdfe.<init> (Ljava/lang/String;I)V
      // 13b: astore 14
      // 13d: aload 0
      // 13e: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 141: aload 14
      // 143: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 148: pop
      // 149: goto 159
      // 14c: astore 11
      // 14e: ldc_w "&cFailed to load configs."
      // 151: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 154: aload 11
      // 156: invokevirtual java/lang/Exception.printStackTrace ()V
      // 159: iload 5
      // 15b: ifeq 0d1
      // 15e: aload 6
      // 160: iload 5
      // 162: ifne 1af
      // 165: ifnull 197
      // 168: goto 16c
      // 16b: athrow
      // 16c: aload 0
      // 16d: iload 5
      // 16f: ifne 198
      // 172: goto 176
      // 175: athrow
      // 176: aload 6
      // 178: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 17b: putstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 17e: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 181: ifnull 197
      // 184: goto 188
      // 187: athrow
      // 188: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 18b: invokevirtual x/oc151419fdfe.ǚ ()Lx/ocdd0f49ff2f;
      // 18e: iload 7
      // 190: putfield x/ocdd0f49ff2f.Ƌ Z
      // 193: goto 197
      // 196: athrow
      // 197: aload 0
      // 198: lload 3
      // 199: invokevirtual x/oc7d9b6bd5c4.ҷ (J)V
      // 19c: aload 8
      // 19e: invokeinterface java/util/List.size ()I 1
      // 1a3: ldc_w "&b"
      // 1a6: swap
      // 1a7: ldc_w " &7configs loaded."
      // 1aa: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 1af: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 1b2: return
   }

   public List<File> ž() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: new java/util/ArrayList
      // 06: dup
      // 07: invokespecial java/util/ArrayList.<init> ()V
      // 0a: astore 2
      // 0b: istore 1
      // 0c: aload 0
      // 0d: iload 1
      // 0e: ifne 23
      // 11: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 14: invokevirtual java/io/File.exists ()Z
      // 17: ifeq 98
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 0
      // 1f: goto 23
      // 22: athrow
      // 23: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 26: invokevirtual java/io/File.listFiles ()[Ljava/io/File;
      // 29: astore 3
      // 2a: aload 3
      // 2b: iload 1
      // 2c: ifne 3a
      // 2f: ifnonnull 39
      // 32: goto 36
      // 35: athrow
      // 36: aload 2
      // 37: areturn
      // 38: athrow
      // 39: aload 3
      // 3a: astore 4
      // 3c: aload 4
      // 3e: arraylength
      // 3f: istore 5
      // 41: bipush 0
      // 42: istore 6
      // 44: iload 6
      // 46: iload 5
      // 48: if_icmpge 98
      // 4b: aload 4
      // 4d: iload 6
      // 4f: aaload
      // 50: astore 7
      // 52: iload 1
      // 53: ifne 94
      // 56: aload 7
      // 58: invokevirtual java/io/File.isFile ()Z
      // 5b: ifeq 91
      // 5e: goto 62
      // 61: athrow
      // 62: aload 7
      // 64: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // 67: ldc_w ".json"
      // 6a: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 6d: iload 1
      // 6e: ifne 90
      // 71: goto 75
      // 74: athrow
      // 75: ifne 84
      // 78: goto 7c
      // 7b: athrow
      // 7c: iload 1
      // 7d: ifeq 91
      // 80: goto 84
      // 83: athrow
      // 84: aload 2
      // 85: aload 7
      // 87: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 8c: goto 90
      // 8f: athrow
      // 90: pop
      // 91: iinc 6 1
      // 94: iload 1
      // 95: ifeq 44
      // 98: aload 2
      // 99: areturn
   }

   public oc151419fdfe Ӈ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: aload 0
      // 04: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 07: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0c: astore 3
      // 0d: istore 2
      // 0e: aload 3
      // 0f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14: ifeq 41
      // 17: aload 3
      // 18: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1d: checkcast x/oc151419fdfe
      // 20: astore 4
      // 22: aload 4
      // 24: iload 2
      // 25: ifne 3c
      // 28: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 2b: aload 1
      // 2c: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 2f: ifeq 3d
      // 32: goto 36
      // 35: athrow
      // 36: aload 4
      // 38: goto 3c
      // 3b: athrow
      // 3c: areturn
      // 3d: iload 2
      // 3e: ifeq 0e
      // 41: aconst_null
      // 42: areturn
   }

   public void Ē() {
      oc2cf3d80e17.ĕ = null;
   }

   public void ի(String var1, String var2) {
      oc7ab2161b9f.ý("&cFailed to " + var1 + ": &b" + var2);
   }

   public boolean ǽ(oc151419fdfe param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w 4555871972645240420
      // 003: ldc2_w 4555932710722309835
      // 006: lxor
      // 007: lstore 3
      // 008: lload 3
      // 009: dup2
      // 00a: ldc2_w 4555862913432711416
      // 00d: ldc2_w 4555932710722309835
      // 010: lxor
      // 011: lxor
      // 012: lstore 5
      // 014: dup2
      // 015: ldc2_w 4555873860735931712
      // 018: ldc2_w 4555932710722309835
      // 01b: lxor
      // 01c: lxor
      // 01d: lstore 7
      // 01f: dup2
      // 020: ldc2_w 4555898238395280389
      // 023: ldc2_w 4555932710722309835
      // 026: lxor
      // 027: lxor
      // 028: lstore 9
      // 02a: pop2
      // 02b: getstatic x/oc151419fdfe.v Z
      // 02e: istore 11
      // 030: aload 1
      // 031: iload 11
      // 033: ifne 047
      // 036: ifnonnull 046
      // 039: goto 03d
      // 03c: athrow
      // 03d: ldc_w "&cFailed to rename config."
      // 040: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 043: bipush 0
      // 044: ireturn
      // 045: athrow
      // 046: aload 1
      // 047: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 04a: astore 12
      // 04c: aload 0
      // 04d: aload 2
      // 04e: lload 5
      // 050: invokevirtual x/oc7d9b6bd5c4.ǵ (Ljava/lang/String;J)Ljava/lang/String;
      // 053: astore 13
      // 055: aload 0
      // 056: aload 13
      // 058: lload 7
      // 05a: aload 12
      // 05c: invokevirtual x/oc7d9b6bd5c4.ƈ (Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
      // 05f: astore 14
      // 061: aload 14
      // 063: iload 11
      // 065: ifne 082
      // 068: ifnull 080
      // 06b: goto 06f
      // 06e: athrow
      // 06f: aload 14
      // 071: ldc_w "&c"
      // 074: swap
      // 075: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 07a: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 07d: bipush 0
      // 07e: ireturn
      // 07f: athrow
      // 080: aload 12
      // 082: aload 13
      // 084: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 087: iload 11
      // 089: ifne 09e
      // 08c: ifeq 09f
      // 08f: goto 093
      // 092: athrow
      // 093: aload 1
      // 094: aload 13
      // 096: invokevirtual x/oc151419fdfe.ŝ (Ljava/lang/String;)V
      // 099: bipush 1
      // 09a: goto 09e
      // 09d: athrow
      // 09e: ireturn
      // 09f: new java/io/File
      // 0a2: dup
      // 0a3: aload 0
      // 0a4: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 0a7: aload 12
      // 0a9: ldc_w ".json"
      // 0ac: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0b1: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 0b4: astore 15
      // 0b6: iload 11
      // 0b8: new java/io/File
      // 0bb: dup
      // 0bc: aload 0
      // 0bd: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 0c0: aload 13
      // 0c2: ldc_w ".json"
      // 0c5: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0ca: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 0cd: astore 16
      // 0cf: ifne 102
      // 0d2: aload 15
      // 0d4: invokevirtual java/io/File.exists ()Z
      // 0d7: ifne 0ea
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: aload 0
      // 0df: ldc_w "rename"
      // 0e2: aload 12
      // 0e4: invokevirtual x/oc7d9b6bd5c4.ի (Ljava/lang/String;Ljava/lang/String;)V
      // 0e7: bipush 0
      // 0e8: ireturn
      // 0e9: athrow
      // 0ea: aload 15
      // 0ec: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0ef: aload 16
      // 0f1: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0f4: bipush 0
      // 0f5: anewarray 355
      // 0f8: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 0fb: pop
      // 0fc: aload 1
      // 0fd: aload 13
      // 0ff: invokevirtual x/oc151419fdfe.ŝ (Ljava/lang/String;)V
      // 102: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 105: aload 1
      // 106: if_acmpne 115
      // 109: aload 0
      // 10a: aload 13
      // 10c: lload 9
      // 10e: invokevirtual x/oc7d9b6bd5c4.ͻ (Ljava/lang/String;J)V
      // 111: goto 115
      // 114: athrow
      // 115: bipush 1
      // 116: ireturn
      // 117: astore 17
      // 119: aload 0
      // 11a: ldc_w "rename"
      // 11d: aload 12
      // 11f: invokevirtual x/oc7d9b6bd5c4.ի (Ljava/lang/String;Ljava/lang/String;)V
      // 122: aload 17
      // 124: invokevirtual java/lang/Exception.printStackTrace ()V
      // 127: bipush 0
      // 128: ireturn
   }

   private void ҷ(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 3
      // 04: getstatic x/oc2cf3d80e17.ե Lx/oc1cb76bf763;
      // 07: iload 3
      // 08: ifne 15
      // 0b: ifnull 18
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc2cf3d80e17.ե Lx/oc1cb76bf763;
      // 15: invokevirtual x/oc1cb76bf763.ϊ ()V
      // 18: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 1b: ifnull 89
      // 1e: getstatic x/oc2c25634a7e.ʴ Ljava/util/ArrayList;
      // 21: iload 3
      // 22: ifne 33
      // 25: goto 29
      // 28: athrow
      // 29: ifnull 89
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic x/oc2c25634a7e.ʴ Ljava/util/ArrayList;
      // 33: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 36: astore 4
      // 38: aload 4
      // 3a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3f: ifeq 89
      // 42: aload 4
      // 44: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 49: checkcast x/oc192c7e4083
      // 4c: astore 5
      // 4e: lload 1
      // 4f: lconst_0
      // 50: lcmp
      // 51: ifle 71
      // 54: iload 3
      // 55: ifne 71
      // 58: aload 5
      // 5a: getfield x/oc192c7e4083.ȩ Lx/oce4cea752dd;
      // 5d: getstatic x/oce4cea752dd.ԝ Lx/oce4cea752dd;
      // 60: if_acmpne 7b
      // 63: goto 67
      // 66: athrow
      // 67: aload 5
      // 69: bipush 1
      // 6a: invokevirtual x/oc192c7e4083.Ê (Z)V
      // 6d: goto 71
      // 70: athrow
      // 71: iload 3
      // 72: lload 1
      // 73: lconst_0
      // 74: lcmp
      // 75: iflt 7c
      // 78: ifeq 89
      // 7b: iload 3
      // 7c: ifeq 38
      // 7f: lload 1
      // 80: lconst_1
      // 81: lcmp
      // 82: ifle 54
      // 85: goto 89
      // 88: athrow
      // 89: return
   }

   private Map զ(JsonObject param1, long param2, String param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: lload 2
      // 001: dup2
      // 002: ldc2_w 6987996879501683145
      // 005: ldc2_w 6987986076548430862
      // 008: lxor
      // 009: lxor
      // 00a: lstore 5
      // 00c: pop2
      // 00d: getstatic x/oc151419fdfe.v Z
      // 010: new java/util/HashMap
      // 013: dup
      // 014: invokespecial java/util/HashMap.<init> ()V
      // 017: astore 8
      // 019: istore 7
      // 01b: aload 1
      // 01c: aload 4
      // 01e: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 021: astore 9
      // 023: aload 9
      // 025: iload 7
      // 027: ifne 037
      // 02a: ifnonnull 035
      // 02d: goto 031
      // 030: athrow
      // 031: aload 8
      // 033: areturn
      // 034: athrow
      // 035: aload 9
      // 037: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 03a: astore 10
      // 03c: aload 10
      // 03e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 043: ifeq 208
      // 046: aload 10
      // 048: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 04d: checkcast com/google/gson/JsonElement
      // 050: astore 11
      // 052: aload 11
      // 054: iload 7
      // 056: ifne 074
      // 059: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 05c: ifne 072
      // 05f: goto 063
      // 062: athrow
      // 063: iload 7
      // 065: lload 2
      // 066: lconst_0
      // 067: lcmp
      // 068: iflt 043
      // 06b: ifeq 03c
      // 06e: goto 072
      // 071: athrow
      // 072: aload 11
      // 074: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 077: astore 12
      // 079: aload 12
      // 07b: ldc_w -700366039
      // 07e: ldc_w 2077036893
      // 081: ixor
      // 082: ldc_w -2077049037
      // 085: ldc_w 2077036893
      // 088: ixor
      // 089: i2c
      // 08a: ineg
      // 08b: isub
      // 08c: ldc_w -700366039
      // 08f: ldc_w 2077036893
      // 092: ixor
      // 093: ldc_w -2077036109
      // 096: ldc_w 2077036893
      // 099: ixor
      // 09a: i2c
      // 09b: ineg
      // 09c: isub
      // 09d: lload 2
      // 09e: l2i
      // 09f: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 0a2: lload 2
      // 0a3: lconst_1
      // 0a4: lcmp
      // 0a5: ifle 0c2
      // 0a8: iload 7
      // 0aa: ifne 0c2
      // 0ad: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0b0: lload 2
      // 0b1: lconst_1
      // 0b2: lcmp
      // 0b3: ifle 043
      // 0b6: ifeq 03c
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aload 12
      // 0bf: ldc_w "x"
      // 0c2: iload 7
      // 0c4: ifne 0e5
      // 0c7: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0ca: lload 2
      // 0cb: lconst_1
      // 0cc: lcmp
      // 0cd: iflt 043
      // 0d0: ifeq 03c
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 12
      // 0d9: iload 7
      // 0db: ifne 102
      // 0de: ldc_w "y"
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0e8: lload 2
      // 0e9: lconst_1
      // 0ea: lcmp
      // 0eb: iflt 0f3
      // 0ee: ifne 100
      // 0f1: iload 7
      // 0f3: lload 2
      // 0f4: lconst_0
      // 0f5: lcmp
      // 0f6: ifle 043
      // 0f9: ifeq 03c
      // 0fc: goto 100
      // 0ff: athrow
      // 100: aload 12
      // 102: ldc_w "x"
      // 105: lload 5
      // 107: ldc_w NaN
      // 10a: invokestatic x/oc7d9b6bd5c4.ҫ (Lcom/google/gson/JsonObject;Ljava/lang/String;JF)F
      // 10d: fstore 13
      // 10f: aload 12
      // 111: ldc_w "y"
      // 114: lload 5
      // 116: ldc_w NaN
      // 119: invokestatic x/oc7d9b6bd5c4.ҫ (Lcom/google/gson/JsonObject;Ljava/lang/String;JF)F
      // 11c: fstore 14
      // 11e: fload 13
      // 120: lload 2
      // 121: lconst_1
      // 122: lcmp
      // 123: ifle 13d
      // 126: iload 7
      // 128: ifne 13d
      // 12b: invokestatic java/lang/Float.isFinite (F)Z
      // 12e: lload 2
      // 12f: lconst_0
      // 130: lcmp
      // 131: ifle 043
      // 134: ifeq 03c
      // 137: goto 13b
      // 13a: athrow
      // 13b: fload 14
      // 13d: invokestatic java/lang/Float.isFinite (F)Z
      // 140: lload 2
      // 141: lconst_0
      // 142: lcmp
      // 143: ifle 14b
      // 146: ifne 158
      // 149: iload 7
      // 14b: lload 2
      // 14c: lconst_1
      // 14d: lcmp
      // 14e: iflt 043
      // 151: ifeq 03c
      // 154: goto 158
      // 157: athrow
      // 158: aload 8
      // 15a: aload 12
      // 15c: ldc_w -700366039
      // 15f: ldc_w 2077036893
      // 162: ixor
      // 163: ldc_w -2077049037
      // 166: ldc_w 2077036893
      // 169: ixor
      // 16a: i2c
      // 16b: ineg
      // 16c: isub
      // 16d: ldc_w -700366039
      // 170: ldc_w 2077036893
      // 173: ixor
      // 174: ldc_w -2077036109
      // 177: ldc_w 2077036893
      // 17a: ixor
      // 17b: i2c
      // 17c: ineg
      // 17d: isub
      // 17e: lload 2
      // 17f: l2i
      // 180: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 183: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 186: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 189: new x/ocddfa9d2661
      // 18c: dup
      // 18d: fload 13
      // 18f: fload 14
      // 191: aload 12
      // 193: ldc_w -700366039
      // 196: ldc_w 2077036893
      // 199: ixor
      // 19a: ldc_w -2077048973
      // 19d: ldc_w 2077036893
      // 1a0: ixor
      // 1a1: i2c
      // 1a2: ineg
      // 1a3: isub
      // 1a4: ldc_w -700366039
      // 1a7: ldc_w 2077036893
      // 1aa: ixor
      // 1ab: ldc_w -2077045515
      // 1ae: ldc_w 2077036893
      // 1b1: ixor
      // 1b2: i2c
      // 1b3: ineg
      // 1b4: isub
      // 1b5: lload 2
      // 1b6: l2i
      // 1b7: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1ba: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 1bd: ifeq 1f5
      // 1c0: aload 12
      // 1c2: ldc_w -700366039
      // 1c5: ldc_w 2077036893
      // 1c8: ixor
      // 1c9: ldc_w -2077049077
      // 1cc: ldc_w 2077036893
      // 1cf: ixor
      // 1d0: i2c
      // 1d1: ineg
      // 1d2: isub
      // 1d3: ldc_w 700366033
      // 1d6: ldc_w 2077036893
      // 1d9: ixor
      // 1da: ldc_w -2077053260
      // 1dd: ldc_w 2077036893
      // 1e0: ixor
      // 1e1: i2c
      // 1e2: isub
      // 1e3: lload 2
      // 1e4: l2i
      // 1e5: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1e8: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 1eb: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 1ee: ifeq 1f9
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: bipush 1
      // 1f6: goto 1fa
      // 1f9: bipush 0
      // 1fa: invokespecial x/ocddfa9d2661.<init> (FFZ)V
      // 1fd: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 202: pop
      // 203: iload 7
      // 205: ifeq 03c
      // 208: lload 2
      // 209: lconst_1
      // 20a: lcmp
      // 20b: ifle 03c
      // 20e: aload 8
      // 210: areturn
   }

   private oc151419fdfe զ(long var1) {
      oc151419fdfe var4 = null;
      int var10000 = oc151419fdfe.v;
      int var5 = a(1169542136 ^ 1169524509, -7158185378271022504L ^ -1116635788740068571L ^ var1);
      byte var3 = (byte)var10000;

      label84:
      while (true) {
         var10000 = var5;

         while (true) {
            switch (var10000) {
               case -1160711310:
                  label58: {
                     label57: {
                        long var10001;
                        label56: {
                           label86: {
                              try {
                                 var10000 = this.ǹ.isEmpty();
                                 if (var1 < 0L) {
                                    break label58;
                                 }

                                 if (var3 != 0) {
                                    break label57;
                                 }

                                 if (var10000 == 0) {
                                    break label86;
                                 }
                              } catch (RuntimeException var6) {
                                 throw var6;
                              }

                              var10000 = 1169543117 ^ 1169524509;
                              var10001 = -1764393275822590409L ^ -1116635788740068571L;
                              if (var1 <= 1L) {
                                 break label56;
                              }

                              var5 = a(var10000, var10001 ^ var1);
                              if (var3 == 0) {
                                 continue label84;
                              }
                           }

                           var10000 = 1169551410 ^ 1169524509;
                           var10001 = -6812072155085927954L ^ -1116635788740068571L ^ var1;
                        }

                        var10000 = a(var10000, var10001);
                     }

                     var5 = var10000;
                     var10000 = var3;
                  }

                  if (var10000 == 0) {
                     continue label84;
                  }
               case 1315147523:
                  return this.ǹ.get(0);
               case -129972544:
                  var4 = this.Ӈ(a((-293481519 ^ 1169524509) - (-1169549546 ^ 1169524509), (293481513 ^ 1169524509) - (1169534105 ^ 1169524509), (int)var1));

                  label78: {
                     label77: {
                        label76: {
                           label89: {
                              try {
                                 var10000 = var3;
                                 if (var1 < 1L) {
                                    break label78;
                                 }

                                 if (var3 != 0) {
                                    break label77;
                                 }

                                 if (var4 == null) {
                                    break label89;
                                 }
                              } catch (RuntimeException var7) {
                                 throw var7;
                              }

                              var10000 = a(1169547225 ^ 1169524509, -4833720947791485411L ^ -1116635788740068571L ^ var1);
                              if (var1 < 1L) {
                                 break label76;
                              }

                              var5 = var10000;
                              if (var3 == 0) {
                                 continue label84;
                              }
                           }

                           var10000 = a(1169553893 ^ 1169524509, -683301075851804593L ^ -1116635788740068571L ^ var1);
                        }

                        var5 = var10000;
                     }

                     var10000 = var3;
                  }

                  if (var1 < 0L) {
                     break;
                  }

                  if (var10000 == 0) {
                     continue label84;
                  }
               case -1650213925:
                  return null;
               case 254388433:
                  return var4;
               default:
                  throw null;
            }
         }
      }
   }

   private String ƈ(String param1, long param2, String param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: lload 2
      // 001: dup2
      // 002: ldc2_w -6164480046278449579
      // 005: ldc2_w -6164446195250789233
      // 008: lxor
      // 009: lxor
      // 00a: lstore 5
      // 00c: pop2
      // 00d: getstatic x/oc151419fdfe.v Z
      // 010: istore 7
      // 012: aload 1
      // 013: iload 7
      // 015: ifne 048
      // 018: invokevirtual java/lang/String.isEmpty ()Z
      // 01b: ifeq 047
      // 01e: goto 022
      // 021: athrow
      // 022: ldc_w 1051007293
      // 025: ldc_w 1817228343
      // 028: ixor
      // 029: ldc_w 1817228333
      // 02c: ldc_w 1817228343
      // 02f: ixor
      // 030: isub
      // 031: ldc_w -1051007295
      // 034: ldc_w 1817228343
      // 037: ixor
      // 038: ldc_w -1817230410
      // 03b: ldc_w 1817228343
      // 03e: ixor
      // 03f: isub
      // 040: lload 2
      // 041: l2i
      // 042: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 045: areturn
      // 046: athrow
      // 047: aload 1
      // 048: iload 7
      // 04a: ifne 09e
      // 04d: ldc_w "."
      // 050: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 053: lload 2
      // 054: lconst_1
      // 055: lcmp
      // 056: iflt 086
      // 059: ifne 077
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 1
      // 061: iload 7
      // 063: ifne 0a0
      // 066: goto 06a
      // 069: athrow
      // 06a: ldc_w " "
      // 06d: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 070: ifeq 09f
      // 073: goto 077
      // 076: athrow
      // 077: ldc_w 1051007293
      // 07a: ldc_w 1817228343
      // 07d: ixor
      // 07e: ldc_w 1817228478
      // 081: ldc_w 1817228343
      // 084: ixor
      // 085: isub
      // 086: ldc_w -1051007295
      // 089: ldc_w 1817228343
      // 08c: ixor
      // 08d: ldc_w -1817219460
      // 090: ldc_w 1817228343
      // 093: ixor
      // 094: isub
      // 095: lload 2
      // 096: l2i
      // 097: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 09a: goto 09e
      // 09d: athrow
      // 09e: areturn
      // 09f: aload 1
      // 0a0: invokevirtual java/lang/String.toCharArray ()[C
      // 0a3: astore 8
      // 0a5: aload 8
      // 0a7: arraylength
      // 0a8: istore 9
      // 0aa: bipush 0
      // 0ab: istore 10
      // 0ad: iload 10
      // 0af: iload 9
      // 0b1: if_icmpge 124
      // 0b4: aload 8
      // 0b6: iload 10
      // 0b8: caload
      // 0b9: istore 11
      // 0bb: iload 11
      // 0bd: lload 2
      // 0be: lconst_1
      // 0bf: lcmp
      // 0c0: iflt 0f4
      // 0c3: iload 7
      // 0c5: ifne 0f4
      // 0c8: ldc_w 1817229649
      // 0cb: ldc_w 1817228343
      // 0ce: ixor
      // 0cf: ldc2_w -3169440802435931070
      // 0d2: ldc2_w -6164446195250789233
      // 0d5: lxor
      // 0d6: lload 2
      // 0d7: lconst_1
      // 0d8: lcmp
      // 0d9: iflt 116
      // 0dc: lload 2
      // 0dd: lxor
      // 0de: invokestatic x/oc7d9b6bd5c4.a (IJ)I
      // 0e1: if_icmplt 0f7
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 0
      // 0e9: lload 5
      // 0eb: iload 11
      // 0ed: invokevirtual x/oc7d9b6bd5c4.щ (JC)Z
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: ifeq 11c
      // 0f7: ldc_w 1051007293
      // 0fa: ldc_w 1817228343
      // 0fd: ixor
      // 0fe: ldc_w 1817228363
      // 101: ldc_w 1817228343
      // 104: ixor
      // 105: isub
      // 106: ldc_w 1051007293
      // 109: ldc_w 1817228343
      // 10c: ixor
      // 10d: ldc_w 1817220959
      // 110: ldc_w 1817228343
      // 113: ixor
      // 114: iadd
      // 115: lload 2
      // 116: l2i
      // 117: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 11a: areturn
      // 11b: athrow
      // 11c: iinc 10 1
      // 11f: iload 7
      // 121: ifeq 0ad
      // 124: aload 0
      // 125: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 128: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 12d: astore 8
      // 12f: aload 8
      // 131: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 136: ifeq 1cc
      // 139: aload 8
      // 13b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 140: checkcast x/oc151419fdfe
      // 143: astore 9
      // 145: aload 9
      // 147: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 14a: lload 2
      // 14b: lconst_1
      // 14c: lcmp
      // 14d: ifle 16c
      // 150: iload 7
      // 152: ifne 16c
      // 155: aload 1
      // 156: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 159: lload 2
      // 15a: lconst_0
      // 15b: lcmp
      // 15c: iflt 1c9
      // 15f: ifeq 1c7
      // 162: goto 166
      // 165: athrow
      // 166: aload 4
      // 168: goto 16c
      // 16b: athrow
      // 16c: iload 7
      // 16e: ifne 1c6
      // 171: ifnull 198
      // 174: goto 178
      // 177: athrow
      // 178: aload 9
      // 17a: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 17d: iload 7
      // 17f: ifne 1c6
      // 182: goto 186
      // 185: athrow
      // 186: aload 4
      // 188: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 18b: lload 2
      // 18c: lconst_1
      // 18d: lcmp
      // 18e: ifle 1c9
      // 191: ifne 1c7
      // 194: goto 198
      // 197: athrow
      // 198: aload 1
      // 199: ldc_w 1051007293
      // 19c: ldc_w 1817228343
      // 19f: ixor
      // 1a0: ldc_w 1817228309
      // 1a3: ldc_w 1817228343
      // 1a6: ixor
      // 1a7: isub
      // 1a8: ldc_w -1051007295
      // 1ab: ldc_w 1817228343
      // 1ae: ixor
      // 1af: ldc_w -1817245810
      // 1b2: ldc_w 1817228343
      // 1b5: ixor
      // 1b6: iadd
      // 1b7: lload 2
      // 1b8: l2i
      // 1b9: invokestatic x/oc7d9b6bd5c4.a (III)Ljava/lang/String;
      // 1bc: swap
      // 1bd: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: areturn
      // 1c7: iload 7
      // 1c9: ifeq 12f
      // 1cc: aconst_null
      // 1cd: areturn
   }

   private boolean щ(long param1, char param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: getstatic x/oc7d9b6bd5c4.ț [C
      // 06: astore 5
      // 08: istore 4
      // 0a: aload 5
      // 0c: arraylength
      // 0d: istore 6
      // 0f: bipush 0
      // 10: istore 7
      // 12: iload 7
      // 14: iload 6
      // 16: if_icmpge 45
      // 19: aload 5
      // 1b: iload 7
      // 1d: caload
      // 1e: iload 4
      // 20: ifne 46
      // 23: istore 8
      // 25: iload 4
      // 27: lload 1
      // 28: lconst_1
      // 29: lcmp
      // 2a: ifle 42
      // 2d: ifne 40
      // 30: iload 8
      // 32: iload 3
      // 33: if_icmpne 3d
      // 36: goto 3a
      // 39: athrow
      // 3a: bipush 1
      // 3b: ireturn
      // 3c: athrow
      // 3d: iinc 7 1
      // 40: iload 4
      // 42: ifeq 12
      // 45: bipush 0
      // 46: ireturn
   }

   private String ǵ(String var1, long var2) {
      boolean var4 = oc151419fdfe.v;
      int var5 = a(804778503 ^ 804752472, -2139930290168126657L ^ -8123728703199161047L ^ var2);

      while (true) {
         switch (var5) {
            case -1418864584:
               int var10000;
               long var10001;
               long var10002;
               label26: {
                  if (var1 == null) {
                     var10000 = 804780208 ^ 804752472;
                     var10001 = -2818024737930958371L ^ -8123728703199161047L;
                     var10002 = var2;
                     if (var2 < 1L) {
                        break label26;
                     }

                     var5 = a(var10000, var10001 ^ var2);
                     if (!var4) {
                        break;
                     }
                  }

                  var10000 = 804777580 ^ 804752472;
                  var10001 = -7147848007317373072L ^ -8123728703199161047L;
                  var10002 = var2;
               }

               var5 = a(var10000, var10001 ^ var10002);
               if (!var4) {
                  break;
               }
            case 2141674045:
               return "";
            case -423172367:
               return var1.trim();
            default:
               throw null;
         }
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      String[] var13 = new String[739377752 ^ 739377664];
      int var11 = 0;
      String var10 = "v»ø=úÛwCkcN:È\u0010\u0089:¯\u001c×À\u009d\u00adð\u008bþ³\u0097¤/µ\tF¦öSøNØ\u0098ï\u0018\u008d¹ñ-Òñ=Cì»Yµcd±\u00ad\u0001JÁ@ÉeG\u001f\u0013½Ä\u0000\u0014·âñðbJ{ßåöæØÊ\b´\u0010â\u001c§\u0093\u0018=fÔÁ\u0082z\u0007m\u0017S\u0017\u0004wm\u0003\u0093\u0005ÌÙn\u0018]\u0007bÎ\u008eí O\u0098\r\u009eÍåóY\u0002\u0003xå\u0004\u009fÖó\u000e\u0092\u0012@\bí}ç\u009d\\×\u0091\u0016f¥\u0005\u001a\u0019IÆ%\u000bì\u001ffó 1aUfça\u0004a\u009epV\r¦L\u009eËñ\u0016c£s\\\u0096\u0086#\r·\u0010\u00867\u008ab?/°\u008eP÷æ\u0004Iú¶(\u0006zuÜ#i9\u0002È\b\u0011Zô÷Ø\u0014êfLv©\u0084¡¢-ï(G\u000f4g}üCÐ\ri³!ÚÍ\u0007\u007fù\u0004z=ÐÐ\u000b\u0096m)½Éø\\lÁÀ\u0096\rÿòµ\u001c\u0094ìÏüæ·$ûu\u0006=¼4\u001at\u001e\u0004\u008cÜ\u0089s\u0005åwKÍù\u0005\u008fi·¸\r\u0017F¬3\u0085\u008aÿ4\u008c\u0092\u0087.`Cæõ¡®7ªû³)\u001f\n\u0089O©¯ß\u0004o²5\u001f\u0006ºÜ\u009d7ä§\u00076îü±Á¦û\u0018Æ(#\u0015\u0088ítÎ\u0095Ì\"o\u0080¬Æ>êó\u0007Æ¸¨\u00adq\u0004}.½\u008f\u0017²ý\u0081ö\u0085È\u0092\rë\fT£ü\u0006©\u0002ûM\u0004B¨vÙ\u0017Ñ\u0016\u0086\u0084:a£3À\u009d\u0093¤Ý6\fÛ¬UC97P\b\u000b\u009dEH¸åXÙxqG\u0081\u0006ý;ÊÚ\u008aG\rûæ\u0084Ì|Öê©E Dõ¼\u000eÅïCí\u0084òõ-·´'è\u0017Á\tû\u0088qÑb ªB<\fÏ\u0092\u0002B¬\u0007ð\u0093\u0006g6\u0000\r*\u001aKÊ\f³js\u0018½*`\u0006\t,\"\u009d\u008d++\u00833\u0019\bý-DµdùéL\u00075\u009cd§}\u00062\u0019n:\u001e\u007f\u0014Þ©K\u0081\u0090µ±\u0084÷$\u00adÖPÃU\u0014éðsõ&\u008e/Ý\u0089å¡;wÝ¦çîL³ï=.{\u001669RH1/\u0012_àß \rL\u009b\u009c\u001d\u008dàz\u0002%»\u000786\u001bÃÃ\u0082\u0091\u000780\rã\u00ad\u000b&\u0006\f\u0018e\u0003\u0015!\u0007î±\u001f\u0002\u0012²Þ\u000bÐ\u0014)\u0089\u001f\u000eoòxaä'¡Á²S¡\n;ó9÷\u0014hÆ\u0007Ö\u0018ioéw7µ\b¦\u0088Êé\u009c+)\u0096lg\u009bÎ`eX \f\u001bw\u0098þÿ\u0090\u009aaK9\u009fË\t lÿ\u009d\u0013ü\u0007ìë\u0004Äò\u008a\u0015\u001c\u0019\u0015ôë+kGv\\\u0092\u000eÍ°º\u0089\u0085oÊ0\u001a\u0001³}\u00ad»~«]\u0004`{\u0097$\r)\u008b\u0013;\u0087\u001bØ[\u009e`ðZ\u001e\u0007&W)ìe\u0006Ê\r%n_Ý\u0007ô\u0085í¨¨ùä\u000b\u000b2.½Õ[õ\u000eÍ\u008bñÞ\u0010ÿZa\u0010\u000eA¦\u009d\u0097\u008d\u0012s\n¼\u009c¶\u0002?$\u0019\u009dÃHhåBÙ;,q\u008c¶Ð7öÜÎ7\u0087\u0087\u001ax\u001f[Ô\u0002÷z(ì$JÍü¯½î\u0003\u0081å¯Íø&\u0018\u0094=ÎK\u001cã8Üh0òÅÄÂF\u009b \u0084\rW:ðPs\u0007v\u0081øjä(H\fù\u0089õ\u009déòÁ²\u0096C\u0000\u0084\u0004\u001b±?³\u0011\n®öX,V*ôñw»\f\n>To/\u00076Ëü\u0015Á2û4ÜÌÇÝA(\u0088\u007fz\u0094ª¡\u0015y1[ò\u0016!X¯\u0003È\u001b\fW\u000eKß\"(\u0080ÇX*ÖdãQFHãÏÆ¼×\u007fd\u001d\\À8.¶_\u0001¢\u0095B\u0090S¦6QY[(ô×À\u0080ÅT´Ùä6|Tx\u0016õ7\u0012\u001fA%Fu\u009fjü~\u0005\u0085þ\u0012mC\u000epJõYRd/ÿìîL£z¨\u0006ãG\tUò¶\u0005´ªÐÀá\n¹Í¯ÿ\u001f\u000ewó66\u0004\u001eíÑö\u0004éæ¢ª\u0004\u0010ä\u009dê\u0004\u0016¸Y\\\u0007À½Ú\u0083ª\u0082È\u0007á}Ñ©z®)";
      int var12 = "v»ø=úÛwCkcN:È\u0010\u0089:¯\u001c×À\u009d\u00adð\u008bþ³\u0097¤/µ\tF¦öSøNØ\u0098ï\u0018\u008d¹ñ-Òñ=Cì»Yµcd±\u00ad\u0001JÁ@ÉeG\u001f\u0013½Ä\u0000\u0014·âñðbJ{ßåöæØÊ\b´\u0010â\u001c§\u0093\u0018=fÔÁ\u0082z\u0007m\u0017S\u0017\u0004wm\u0003\u0093\u0005ÌÙn\u0018]\u0007bÎ\u008eí O\u0098\r\u009eÍåóY\u0002\u0003xå\u0004\u009fÖó\u000e\u0092\u0012@\bí}ç\u009d\\×\u0091\u0016f¥\u0005\u001a\u0019IÆ%\u000bì\u001ffó 1aUfça\u0004a\u009epV\r¦L\u009eËñ\u0016c£s\\\u0096\u0086#\r·\u0010\u00867\u008ab?/°\u008eP÷æ\u0004Iú¶(\u0006zuÜ#i9\u0002È\b\u0011Zô÷Ø\u0014êfLv©\u0084¡¢-ï(G\u000f4g}üCÐ\ri³!ÚÍ\u0007\u007fù\u0004z=ÐÐ\u000b\u0096m)½Éø\\lÁÀ\u0096\rÿòµ\u001c\u0094ìÏüæ·$ûu\u0006=¼4\u001at\u001e\u0004\u008cÜ\u0089s\u0005åwKÍù\u0005\u008fi·¸\r\u0017F¬3\u0085\u008aÿ4\u008c\u0092\u0087.`Cæõ¡®7ªû³)\u001f\n\u0089O©¯ß\u0004o²5\u001f\u0006ºÜ\u009d7ä§\u00076îü±Á¦û\u0018Æ(#\u0015\u0088ítÎ\u0095Ì\"o\u0080¬Æ>êó\u0007Æ¸¨\u00adq\u0004}.½\u008f\u0017²ý\u0081ö\u0085È\u0092\rë\fT£ü\u0006©\u0002ûM\u0004B¨vÙ\u0017Ñ\u0016\u0086\u0084:a£3À\u009d\u0093¤Ý6\fÛ¬UC97P\b\u000b\u009dEH¸åXÙxqG\u0081\u0006ý;ÊÚ\u008aG\rûæ\u0084Ì|Öê©E Dõ¼\u000eÅïCí\u0084òõ-·´'è\u0017Á\tû\u0088qÑb ªB<\fÏ\u0092\u0002B¬\u0007ð\u0093\u0006g6\u0000\r*\u001aKÊ\f³js\u0018½*`\u0006\t,\"\u009d\u008d++\u00833\u0019\bý-DµdùéL\u00075\u009cd§}\u00062\u0019n:\u001e\u007f\u0014Þ©K\u0081\u0090µ±\u0084÷$\u00adÖPÃU\u0014éðsõ&\u008e/Ý\u0089å¡;wÝ¦çîL³ï=.{\u001669RH1/\u0012_àß \rL\u009b\u009c\u001d\u008dàz\u0002%»\u000786\u001bÃÃ\u0082\u0091\u000780\rã\u00ad\u000b&\u0006\f\u0018e\u0003\u0015!\u0007î±\u001f\u0002\u0012²Þ\u000bÐ\u0014)\u0089\u001f\u000eoòxaä'¡Á²S¡\n;ó9÷\u0014hÆ\u0007Ö\u0018ioéw7µ\b¦\u0088Êé\u009c+)\u0096lg\u009bÎ`eX \f\u001bw\u0098þÿ\u0090\u009aaK9\u009fË\t lÿ\u009d\u0013ü\u0007ìë\u0004Äò\u008a\u0015\u001c\u0019\u0015ôë+kGv\\\u0092\u000eÍ°º\u0089\u0085oÊ0\u001a\u0001³}\u00ad»~«]\u0004`{\u0097$\r)\u008b\u0013;\u0087\u001bØ[\u009e`ðZ\u001e\u0007&W)ìe\u0006Ê\r%n_Ý\u0007ô\u0085í¨¨ùä\u000b\u000b2.½Õ[õ\u000eÍ\u008bñÞ\u0010ÿZa\u0010\u000eA¦\u009d\u0097\u008d\u0012s\n¼\u009c¶\u0002?$\u0019\u009dÃHhåBÙ;,q\u008c¶Ð7öÜÎ7\u0087\u0087\u001ax\u001f[Ô\u0002÷z(ì$JÍü¯½î\u0003\u0081å¯Íø&\u0018\u0094=ÎK\u001cã8Üh0òÅÄÂF\u009b \u0084\rW:ðPs\u0007v\u0081øjä(H\fù\u0089õ\u009déòÁ²\u0096C\u0000\u0084\u0004\u001b±?³\u0011\n®öX,V*ôñw»\f\n>To/\u00076Ëü\u0015Á2û4ÜÌÇÝA(\u0088\u007fz\u0094ª¡\u0015y1[ò\u0016!X¯\u0003È\u001b\fW\u000eKß\"(\u0080ÇX*ÖdãQFHãÏÆ¼×\u007fd\u001d\\À8.¶_\u0001¢\u0095B\u0090S¦6QY[(ô×À\u0080ÅT´Ùä6|Tx\u0016õ7\u0012\u001fA%Fu\u009fjü~\u0005\u0085þ\u0012mC\u000epJõYRd/ÿìîL£z¨\u0006ãG\tUò¶\u0005´ªÐÀá\n¹Í¯ÿ\u001f\u000ewó66\u0004\u001eíÑö\u0004éæ¢ª\u0004\u0010ä\u009dê\u0004\u0016¸Y\\\u0007À½Ú\u0083ª\u0082È\u0007á}Ñ©z®)"
         .length();
      int var9 = 739377677 ^ 739377664;
      int var17 = -1;

      label70:
      while (true) {
         String var10000 = var10.substring(++var17, var17 + var9);
         int var10001 = -1;

         while (true) {
            char[] var35;
            label65: {
               char[] var22 = var10000.toCharArray();
               int var10003 = var22.length;
               int var14 = 0;
               var35 = var22;
               var10001 = var10003;
               char[] var46;
               int var10004;
               if (var10003 <= 1) {
                  var46 = var22;
                  var10004 = var14;
               } else {
                  var35 = var22;
                  var10001 = var10003;
                  if (var10003 <= var14) {
                     break label65;
                  }

                  var46 = var22;
                  var10004 = var14;
               }

               while (true) {
                  var46[var10004] = (char)(var46[var10004] ^ switch (var14 % (739377671 ^ 739377664)) {
                     case 0 -> 739377693 ^ 739377664;
                     case 1 -> 739377756 ^ 739377664;
                     case 2 -> 739377713 ^ 739377664;
                     case 3 -> 739377702 ^ 739377664;
                     case 4 -> 739377753 ^ 739377664;
                     case 5 -> 739377695 ^ 739377664;
                     default -> 739377773 ^ 739377664;
                  });
                  var14++;
                  if (var10001 == 0) {
                     var10004 = var10001;
                     var46 = var35;
                  } else {
                     if (var10001 <= var14) {
                        break;
                     }

                     var46 = var35;
                     var10004 = var14;
                  }
               }
            }

            String var53 = new String(var35).intern();
            switch (var10001) {
               case 0:
                  var13[var11++] = var53;
                  if ((var17 += var9) >= var12) {
                     a = var13;
                     b = new String[739377752 ^ 739377664];
                     long var0 = 5933025416062069576L ^ 5933035901974082119L;
                     long[] var6 = new long[739377764 ^ 739377664];
                     int var3 = 0;
                     String var4 = "\u0004Â²3\u0096\u0096Ã¤.äC\u008cQW\u00adÉþæU><ß«\u000e\u0086ÞªÄ\u0081#tªpE\u0018×\u0011\u007fe4Ý~yè\u001bL\u0013\u000f\u00145<úM$cñÂN.yÿ§¸\u0096\\Uú\u009c\u000eâ}Gæl\u0014±\u00931·\u0013\u0095\u0001DÿÉX\u0010÷Ub9[7RªóÈø\u009eØ-\u009dZý¥(`³Ê\u008b\u0086ñg&nZ\u009f²·\u0097QrOìà[ÌsÌv½¼wi\u0018ß{\u0002GNÜjÕjü\u009e¬g2M,\u008aT¼á\b!®Râx\u0001~:<2lØú]\u0012f\u0080\rE\t«,Ì\u0089/{rÍ§O\u009bM«ö.SP\u0098 ±\u0083;\u008fËìé@¿\u0083?×'\u0010ç3]êÕF;³¾¡ÏG\u008dyÆ\u0094\u0080³)q\nÜµ\\0\tSg~9½Æí\nD\u009dä§ûv&µ¸Kô\u0094p\b\u0081]=ãàè2\u0087Íj'âA\u009bI¶\u001bÀ$\u008c,~\n\u0088[Ô\u0080ÕF\u0084ç\u0094kø\u001d\u00ad\u0096\"ú'ó\u0001\u000bÕX0·\nÌü\u0006\u0098ÉV·V_\u0086ÙægîËcü\u001bwË¦£%9ý\u0083\u0081<é¸\u0006\u0092Ñ/È;¿ïø\u0096\u0097+Õ &\u0019ByÕ\u0084bÉoß\u000b\u00ad:@±bÝØo\u0001ònçÕí÷\u0012èYÆ¼\u0081D\u0093\f×Ç\u009f\u000e]\u0005~\u0096\u0013¨ï£Uñiw±|\u001fo\u0082µçÙhó\u0088»\u0097\u008e5@\u001bw«o¾¿\u0086\rÒ\u0000»pßº¬æÂ¸²{\u008fÔè\u0006\\\u008f\u0096\u0084\u001dÇweQä´p\u0000Å}\rë1;A·æ\u001b;ej»yyR\u0005ÀÕ\u0099\u008e¡½n©ý\u0018a\u0003®Í0\u0001\t\u0015ðQÃ}dÿpö^W\u0002\r ô\u0093^\u0094Õv\u0094éceq|¦úÝÉ6ÜüÚZ\n¤cfG7p°aÓ!\u0082\u0084\ròuÍ@ò\u000eH+5%ÓFö\u0092\tÖ$+\u000f\u009cê\u008bz\u008e¯A\f\u0015Ô)VõKd\u0096GE\u0012Æ0Y§Cö\u00861Z\u0082yn|\u001dÆBø³Éâ\u0013ò¼\u0094 {¯\u0000ñe3À\u0090öm\u0004kê.\u0002à¤F\u0019¯ÃË\u0005#ø\u0094\u0084ÕL\u0092\u0015¬\u001aðVa½\u0088\u008fø³Qí÷Ú)Ã¨è½ÚáiyÃ}\u0004}\u008a¦ÅT\u009dwåV\u001azæ\u00011\u008bUÑn\u000eKô\u001a\u0000-P§!H)Ï/ÂRF´\u0002ÊEÖXÎ\u00833B³ \u0010ôsyÏ\u0002çOö×X\u001f,²]õ³bí\u009f\b½\u001ex\u0086\u0005âÛ\u0084[:ó`µ¡:;pòU|Mmþqý^Ìú\u0019\u000f¾ôíÕï¹õ\u0013øà|O\u001fsBî\"dÑWª\u0002\u0097Õ\u0013ñs\u0005Ì¶";
                     int var5 = "\u0004Â²3\u0096\u0096Ã¤.äC\u008cQW\u00adÉþæU><ß«\u000e\u0086ÞªÄ\u0081#tªpE\u0018×\u0011\u007fe4Ý~yè\u001bL\u0013\u000f\u00145<úM$cñÂN.yÿ§¸\u0096\\Uú\u009c\u000eâ}Gæl\u0014±\u00931·\u0013\u0095\u0001DÿÉX\u0010÷Ub9[7RªóÈø\u009eØ-\u009dZý¥(`³Ê\u008b\u0086ñg&nZ\u009f²·\u0097QrOìà[ÌsÌv½¼wi\u0018ß{\u0002GNÜjÕjü\u009e¬g2M,\u008aT¼á\b!®Râx\u0001~:<2lØú]\u0012f\u0080\rE\t«,Ì\u0089/{rÍ§O\u009bM«ö.SP\u0098 ±\u0083;\u008fËìé@¿\u0083?×'\u0010ç3]êÕF;³¾¡ÏG\u008dyÆ\u0094\u0080³)q\nÜµ\\0\tSg~9½Æí\nD\u009dä§ûv&µ¸Kô\u0094p\b\u0081]=ãàè2\u0087Íj'âA\u009bI¶\u001bÀ$\u008c,~\n\u0088[Ô\u0080ÕF\u0084ç\u0094kø\u001d\u00ad\u0096\"ú'ó\u0001\u000bÕX0·\nÌü\u0006\u0098ÉV·V_\u0086ÙægîËcü\u001bwË¦£%9ý\u0083\u0081<é¸\u0006\u0092Ñ/È;¿ïø\u0096\u0097+Õ &\u0019ByÕ\u0084bÉoß\u000b\u00ad:@±bÝØo\u0001ònçÕí÷\u0012èYÆ¼\u0081D\u0093\f×Ç\u009f\u000e]\u0005~\u0096\u0013¨ï£Uñiw±|\u001fo\u0082µçÙhó\u0088»\u0097\u008e5@\u001bw«o¾¿\u0086\rÒ\u0000»pßº¬æÂ¸²{\u008fÔè\u0006\\\u008f\u0096\u0084\u001dÇweQä´p\u0000Å}\rë1;A·æ\u001b;ej»yyR\u0005ÀÕ\u0099\u008e¡½n©ý\u0018a\u0003®Í0\u0001\t\u0015ðQÃ}dÿpö^W\u0002\r ô\u0093^\u0094Õv\u0094éceq|¦úÝÉ6ÜüÚZ\n¤cfG7p°aÓ!\u0082\u0084\ròuÍ@ò\u000eH+5%ÓFö\u0092\tÖ$+\u000f\u009cê\u008bz\u008e¯A\f\u0015Ô)VõKd\u0096GE\u0012Æ0Y§Cö\u00861Z\u0082yn|\u001dÆBø³Éâ\u0013ò¼\u0094 {¯\u0000ñe3À\u0090öm\u0004kê.\u0002à¤F\u0019¯ÃË\u0005#ø\u0094\u0084ÕL\u0092\u0015¬\u001aðVa½\u0088\u008fø³Qí÷Ú)Ã¨è½ÚáiyÃ}\u0004}\u008a¦ÅT\u009dwåV\u001azæ\u00011\u008bUÑn\u000eKô\u001a\u0000-P§!H)Ï/ÂRF´\u0002ÊEÖXÎ\u00833B³ \u0010ôsyÏ\u0002çOö×X\u001f,²]õ³bí\u009f\b½\u001ex\u0086\u0005âÛ\u0084[:ó`µ¡:;pòU|Mmþqý^Ìú\u0019\u000f¾ôíÕï¹õ\u0013øà|O\u001fsBî\"dÑWª\u0002\u0097Õ\u0013ñs\u0005Ì¶"
                        .length();
                     byte var2 = 0;

                     label44:
                     while (true) {
                        int var29 = var2;
                        var2 += 8;
                        byte[] var7 = var4.substring(var29, var2).getBytes("ISO-8859-1");
                        long[] var19 = var6;
                        var29 = var3++;
                        long var41 = (var7[0] & (5933035901974082232L ^ 5933035901974082119L)) << (739377720 ^ 739377664)
                           | (var7[1] & (5933035901974082232L ^ 5933035901974082119L)) << (739377712 ^ 739377664)
                           | (var7[739377666 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377704 ^ 739377664)
                           | (var7[739377667 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377696 ^ 739377664)
                           | (var7[739377668 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377688 ^ 739377664)
                           | (var7[739377669 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377680 ^ 739377664)
                           | (var7[739377670 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377672 ^ 739377664)
                           | var7[739377671 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L);
                        byte var54 = -1;

                        while (true) {
                           long var57 = var41 ^ var0;
                           switch (var54) {
                              case 0:
                                 var19[var29] = var57;
                                 if (var2 >= var5) {
                                    c = var6;
                                    d = new Integer[739377764 ^ 739377664];
                                    long var43 = 5933025416062069585L ^ 5933035901974082119L ^ var0;
                                    byte var32 = -1;
                                    e = var43;
                                    char[] var20 = new char[739377673 ^ 739377664];
                                    var20[0] = (char)(739377756 ^ 739377664);
                                    var20[1] = (char)(739377711 ^ 739377664);
                                    var20[739377666 ^ 739377664] = (char)(739377722 ^ 739377664);
                                    var20[739377667 ^ 739377664] = (char)(739377706 ^ 739377664);
                                    var20[739377668 ^ 739377664] = (char)(739377727 ^ 739377664);
                                    var20[739377669 ^ 739377664] = (char)(739377698 ^ 739377664);
                                    var20[739377670 ^ 739377664] = (char)(739377724 ^ 739377664);
                                    var20[739377671 ^ 739377664] = (char)(739377726 ^ 739377664);
                                    var20[739377672 ^ 739377664] = (char)(739377788 ^ 739377664);
                                    ț = var20;
                                    return;
                                 }
                                 break;
                              default:
                                 var19[var29] = var57;
                                 if (var2 < var5) {
                                    continue label44;
                                 }

                                 var4 = "¨\u0019ö\t\u0017e?_\u001c\u008aã»ÏÅ1Þ";
                                 var5 = "¨\u0019ö\t\u0017e?_\u001c\u008aã»ÏÅ1Þ".length();
                                 var2 = 0;
                           }

                           byte var31 = var2;
                           var2 += 8;
                           var7 = var4.substring(var31, var2).getBytes("ISO-8859-1");
                           var19 = var6;
                           var29 = var3++;
                           var41 = (var7[0] & (5933035901974082232L ^ 5933035901974082119L)) << (739377720 ^ 739377664)
                              | (var7[1] & (5933035901974082232L ^ 5933035901974082119L)) << (739377712 ^ 739377664)
                              | (var7[739377666 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377704 ^ 739377664)
                              | (var7[739377667 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377696 ^ 739377664)
                              | (var7[739377668 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377688 ^ 739377664)
                              | (var7[739377669 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377680 ^ 739377664)
                              | (var7[739377670 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L)) << (739377672 ^ 739377664)
                              | var7[739377671 ^ 739377664] & (5933035901974082232L ^ 5933035901974082119L);
                           var54 = 0;
                        }
                     }
                  }

                  var9 = var10.charAt(var17);
                  break;
               default:
                  var13[var11++] = var53;
                  if ((var17 += var9) < var12) {
                     var9 = var10.charAt(var17);
                     continue label70;
                  }

                  var10 = "Õ\n\u008c\u000bt\u001d¦\u009bQx\tY \u000fÄJíÅãæÓ¾À\u009f[Ç0X\u0095";
                  var12 = "Õ\n\u008c\u000bt\u001d¦\u009bQx\tY \u000fÄJíÅãæÓ¾À\u009f[Ç0X\u0095".length();
                  var9 = 739377677 ^ 739377664;
                  var17 = -1;
            }

            var10000 = var10.substring(++var17, var17 + var9);
            var10001 = 0;
         }
      }
   }

   private static String a(int var0, int var1, int var2) {
      int var3 = (var0 ^ var2 ^ -1965058987 ^ 1965052859) & (1965075524 ^ 1965052859);
      if (b[var3] == null) {
         char[] var4 = a[var3].toCharArray();

         int var5 = switch (var4[0] & (1965052740 ^ 1965052859)) {
            case 0 -> 1965052797 ^ 1965052859;
            case 1 -> 1965052707 ^ 1965052859;
            case 2 -> 1965052827 ^ 1965052859;
            case 3 -> 1965052680 ^ 1965052859;
            case 4 -> 1965052849 ^ 1965052859;
            case 5 -> 1965052846 ^ 1965052859;
            case 6 -> 1965052688 ^ 1965052859;
            case 7 -> 1965052689 ^ 1965052859;
            case 8 -> 1965052719 ^ 1965052859;
            case 9 -> 1965052845 ^ 1965052859;
            case 10 -> 1965052748 ^ 1965052859;
            case 11 -> 1965052832 ^ 1965052859;
            case 12 -> 1965052786 ^ 1965052859;
            case 13 -> 1965052918 ^ 1965052859;
            case 14 -> 1965052796 ^ 1965052859;
            case 15 -> 1965052755 ^ 1965052859;
            case 16 -> 1965052838 ^ 1965052859;
            case 17 -> 1965052890 ^ 1965052859;
            case 18 -> 1965052843 ^ 1965052859;
            case 19 -> 1965052717 ^ 1965052859;
            case 20 -> 1965052792 ^ 1965052859;
            case 21 -> 1965052907 ^ 1965052859;
            case 22 -> 1965052739 ^ 1965052859;
            case 23 -> 1965052772 ^ 1965052859;
            case 24 -> 1965052793 ^ 1965052859;
            case 25 -> 1965052831 ^ 1965052859;
            case 26 -> 1965052752 ^ 1965052859;
            case 27 -> 1965052706 ^ 1965052859;
            case 28 -> 1965052883 ^ 1965052859;
            case 29 -> 1965052848 ^ 1965052859;
            case 30 -> 1965052913 ^ 1965052859;
            case 31 -> 1965052718 ^ 1965052859;
            case 32 -> 1965052860 ^ 1965052859;
            case 33 -> 1965052852 ^ 1965052859;
            case 34 -> 1965052835 ^ 1965052859;
            case 35 -> 1965052675 ^ 1965052859;
            case 36 -> 1965052740 ^ 1965052859;
            case 37 -> 1965052886 ^ 1965052859;
            case 38 -> 1965052798 ^ 1965052859;
            case 39 -> 1965052818 ^ 1965052859;
            case 40 -> 1965052825 ^ 1965052859;
            case 41 -> 1965052746 ^ 1965052859;
            case 42 -> 1965052880 ^ 1965052859;
            case 43 -> 1965052779 ^ 1965052859;
            case 44 -> 1965052853 ^ 1965052859;
            case 45 -> 1965052705 ^ 1965052859;
            case 46 -> 1965052713 ^ 1965052859;
            case 47 -> 1965052836 ^ 1965052859;
            case 48 -> 1965052756 ^ 1965052859;
            case 49 -> 1965052819 ^ 1965052859;
            case 50 -> 1965052767 ^ 1965052859;
            case 51 -> 1965052851 ^ 1965052859;
            case 52 -> 1965052855 ^ 1965052859;
            case 53 -> 1965052750 ^ 1965052859;
            case 54 -> 1965052802 ^ 1965052859;
            case 55 -> 1965052737 ^ 1965052859;
            case 56 -> 1965052720 ^ 1965052859;
            case 57 -> 1965052893 ^ 1965052859;
            case 58 -> 1965052721 ^ 1965052859;
            case 59 -> 1965052816 ^ 1965052859;
            case 60 -> 1965052903 ^ 1965052859;
            case 61 -> 1965052864 ^ 1965052859;
            case 62 -> 1965052904 ^ 1965052859;
            case 63 -> 1965052844 ^ 1965052859;
            case 64 -> 1965052829 ^ 1965052859;
            case 65 -> 1965052695 ^ 1965052859;
            case 66 -> 1965052887 ^ 1965052859;
            case 67 -> 1965052734 ^ 1965052859;
            case 68 -> 1965052857 ^ 1965052859;
            case 69 -> 1965052738 ^ 1965052859;
            case 70 -> 1965052785 ^ 1965052859;
            case 71 -> 1965052757 ^ 1965052859;
            case 72 -> 1965052874 ^ 1965052859;
            case 73 -> 1965052866 ^ 1965052859;
            case 74 -> 1965052742 ^ 1965052859;
            case 75 -> 1965052902 ^ 1965052859;
            case 76 -> 1965052686 ^ 1965052859;
            case 77 -> 1965052771 ^ 1965052859;
            case 78 -> 1965052790 ^ 1965052859;
            case 79 -> 1965052685 ^ 1965052859;
            case 80 -> 1965052828 ^ 1965052859;
            case 81 -> 1965052896 ^ 1965052859;
            case 82 -> 1965052733 ^ 1965052859;
            case 83 -> 1965052723 ^ 1965052859;
            case 84 -> 1965052856 ^ 1965052859;
            case 85 -> 1965052821 ^ 1965052859;
            case 86 -> 1965052892 ^ 1965052859;
            case 87 -> 1965052758 ^ 1965052859;
            case 88 -> 1965052917 ^ 1965052859;
            case 89 -> 1965052867 ^ 1965052859;
            case 90 -> 1965052731 ^ 1965052859;
            case 91 -> 1965052699 ^ 1965052859;
            case 92 -> 1965052811 ^ 1965052859;
            case 93 -> 1965052876 ^ 1965052859;
            case 94 -> 1965052898 ^ 1965052859;
            case 95 -> 1965052910 ^ 1965052859;
            case 96 -> 1965052919 ^ 1965052859;
            case 97 -> 1965052803 ^ 1965052859;
            case 98 -> 1965052776 ^ 1965052859;
            case 99 -> 1965052770 ^ 1965052859;
            case 100 -> 1965052925 ^ 1965052859;
            case 101 -> 1965052884 ^ 1965052859;
            case 102 -> 1965052729 ^ 1965052859;
            case 103 -> 1965052728 ^ 1965052859;
            case 104 -> 0;
            case 105 -> 1965052823 ^ 1965052859;
            case 106 -> 1965052716 ^ 1965052859;
            case 107 -> 1965052865 ^ 1965052859;
            case 108 -> 1965052862 ^ 1965052859;
            case 109 -> 1965052780 ^ 1965052859;
            case 110 -> 1965052877 ^ 1965052859;
            case 111 -> 1965052760 ^ 1965052859;
            case 112 -> 1965052783 ^ 1965052859;
            case 113 -> 1965052882 ^ 1965052859;
            case 114 -> 1965052894 ^ 1965052859;
            case 115 -> 1965052678 ^ 1965052859;
            case 116 -> 1965052725 ^ 1965052859;
            case 117 -> 1965052817 ^ 1965052859;
            case 118 -> 1965052778 ^ 1965052859;
            case 119 -> 1965052681 ^ 1965052859;
            case 120 -> 1965052841 ^ 1965052859;
            case 121 -> 1;
            case 122 -> 1965052691 ^ 1965052859;
            case 123 -> 1965052782 ^ 1965052859;
            case 124 -> 1965052906 ^ 1965052859;
            case 125 -> 1965052833 ^ 1965052859;
            case 126 -> 1965052921 ^ 1965052859;
            case 127 -> 1965052794 ^ 1965052859;
            case 128 -> 1965052684 ^ 1965052859;
            case 129 -> 1965052812 ^ 1965052859;
            case 130 -> 1965052912 ^ 1965052859;
            case 131 -> 1965052909 ^ 1965052859;
            case 132 -> 1965052696 ^ 1965052859;
            case 133 -> 1965052839 ^ 1965052859;
            case 134 -> 1965052897 ^ 1965052859;
            case 135 -> 1965052878 ^ 1965052859;
            case 136 -> 1965052715 ^ 1965052859;
            case 137 -> 1965052787 ^ 1965052859;
            case 138 -> 1965052885 ^ 1965052859;
            case 139 -> 1965052920 ^ 1965052859;
            case 140 -> 1965052875 ^ 1965052859;
            case 141 -> 1965052765 ^ 1965052859;
            case 142 -> 1965052763 ^ 1965052859;
            case 143 -> 1965052724 ^ 1965052859;
            case 144 -> 1965052711 ^ 1965052859;
            case 145 -> 1965052873 ^ 1965052859;
            case 146 -> 1965052889 ^ 1965052859;
            case 147 -> 1965052753 ^ 1965052859;
            case 148 -> 1965052908 ^ 1965052859;
            case 149 -> 1965052815 ^ 1965052859;
            case 150 -> 1965052850 ^ 1965052859;
            case 151 -> 1965052749 ^ 1965052859;
            case 152 -> 1965052800 ^ 1965052859;
            case 153 -> 1965052805 ^ 1965052859;
            case 154 -> 1965052895 ^ 1965052859;
            case 155 -> 1965052922 ^ 1965052859;
            case 156 -> 1965052702 ^ 1965052859;
            case 157 -> 1965052679 ^ 1965052859;
            case 158 -> 1965052905 ^ 1965052859;
            case 159 -> 1965052768 ^ 1965052859;
            case 160 -> 1965052869 ^ 1965052859;
            case 161 -> 1965052868 ^ 1965052859;
            case 162 -> 1965052774 ^ 1965052859;
            case 163 -> 1965052690 ^ 1965052859;
            case 164 -> 1965052736 ^ 1965052859;
            case 165 -> 1965052791 ^ 1965052859;
            case 166 -> 1965052924 ^ 1965052859;
            case 167 -> 1965052814 ^ 1965052859;
            case 168 -> 1965052781 ^ 1965052859;
            case 169 -> 1965052693 ^ 1965052859;
            case 170 -> 1965052694 ^ 1965052859;
            case 171 -> 1965052700 ^ 1965052859;
            case 172 -> 1965052751 ^ 1965052859;
            case 173 -> 1965052687 ^ 1965052859;
            case 174 -> 1965052795 ^ 1965052859;
            case 175 -> 1965052708 ^ 1965052859;
            case 176 -> 1965052879 ^ 1965052859;
            case 177 -> 1965052804 ^ 1965052859;
            case 178 -> 1965052888 ^ 1965052859;
            case 179 -> 1965052704 ^ 1965052859;
            case 180 -> 1965052789 ^ 1965052859;
            case 181 -> 1965052710 ^ 1965052859;
            case 182 -> 1965052764 ^ 1965052859;
            case 183 -> 1965052682 ^ 1965052859;
            case 184 -> 1965052891 ^ 1965052859;
            case 185 -> 1965052747 ^ 1965052859;
            case 186 -> 1965052810 ^ 1965052859;
            case 187 -> 1965052744 ^ 1965052859;
            case 188 -> 1965052730 ^ 1965052859;
            case 189 -> 1965052788 ^ 1965052859;
            case 190 -> 1965052837 ^ 1965052859;
            case 191 -> 1965052683 ^ 1965052859;
            case 192 -> 1965052808 ^ 1965052859;
            case 193 -> 1965052784 ^ 1965052859;
            case 194 -> 1965052801 ^ 1965052859;
            case 195 -> 1965052847 ^ 1965052859;
            case 196 -> 1965052830 ^ 1965052859;
            case 197 -> 1965052773 ^ 1965052859;
            case 198 -> 1965052709 ^ 1965052859;
            case 199 -> 1965052915 ^ 1965052859;
            case 200 -> 1965052926 ^ 1965052859;
            case 201 -> 1965052914 ^ 1965052859;
            case 202 -> 1965052698 ^ 1965052859;
            case 203 -> 1965052759 ^ 1965052859;
            case 204 -> 1965052872 ^ 1965052859;
            case 205 -> 1965052806 ^ 1965052859;
            case 206 -> 1965052927 ^ 1965052859;
            case 207 -> 1965052735 ^ 1965052859;
            case 208 -> 1965052754 ^ 1965052859;
            case 209 -> 1965052777 ^ 1965052859;
            case 210 -> 1965052697 ^ 1965052859;
            case 211 -> 1965052871 ^ 1965052859;
            case 212 -> 1965052741 ^ 1965052859;
            case 213 -> 1965052854 ^ 1965052859;
            case 214 -> 1965052701 ^ 1965052859;
            case 215 -> 1965052824 ^ 1965052859;
            case 216 -> 1965052822 ^ 1965052859;
            case 217 -> 1965052762 ^ 1965052859;
            case 218 -> 1965052761 ^ 1965052859;
            case 219 -> 1965052672 ^ 1965052859;
            case 220 -> 1965052677 ^ 1965052859;
            case 221 -> 1965052769 ^ 1965052859;
            case 222 -> 1965052743 ^ 1965052859;
            case 223 -> 1965052834 ^ 1965052859;
            case 224 -> 1965052840 ^ 1965052859;
            case 225 -> 1965052813 ^ 1965052859;
            case 226 -> 1965052712 ^ 1965052859;
            case 227 -> 1965052799 ^ 1965052859;
            case 228 -> 1965052775 ^ 1965052859;
            case 229 -> 1965052674 ^ 1965052859;
            case 230 -> 1965052881 ^ 1965052859;
            case 231 -> 1965052807 ^ 1965052859;
            case 232 -> 1965052842 ^ 1965052859;
            case 233 -> 1965052916 ^ 1965052859;
            case 234 -> 1965052820 ^ 1965052859;
            case 235 -> 1965052745 ^ 1965052859;
            case 236 -> 1965052900 ^ 1965052859;
            case 237 -> 1965052863 ^ 1965052859;
            case 238 -> 1965052809 ^ 1965052859;
            case 239 -> 1965052692 ^ 1965052859;
            case 240 -> 1965052732 ^ 1965052859;
            case 241 -> 1965052703 ^ 1965052859;
            case 242 -> 1965052714 ^ 1965052859;
            case 243 -> 1965052911 ^ 1965052859;
            case 244 -> 1965052766 ^ 1965052859;
            case 245 -> 1965052726 ^ 1965052859;
            case 246 -> 1965052722 ^ 1965052859;
            case 247 -> 1965052861 ^ 1965052859;
            case 248 -> 1965052901 ^ 1965052859;
            case 249 -> 1965052826 ^ 1965052859;
            case 250 -> 1965052870 ^ 1965052859;
            case 251 -> 1965052676 ^ 1965052859;
            case 252 -> 1965052673 ^ 1965052859;
            case 253 -> 1965052899 ^ 1965052859;
            case 254 -> 1965052727 ^ 1965052859;
            default -> 1965052923 ^ 1965052859;
         };
         int var10;
         int var6 = ((var10 = var1 ^ var2) & (1965052740 ^ 1965052859)) - var5;
         if (var6 < 0) {
            var6 += 256;
         }

         int var7 = ((var10 & (1965075524 ^ 1965052859)) >>> (1965052851 ^ 1965052859)) - var5;
         if (var7 < 0) {
            var7 += 256;
         }

         for (int var8 = 0; var8 < var4.length; var8++) {
            int var9 = var8 % (1965052857 ^ 1965052859);
            char var10002 = var4[var8];
            if (var9 == 0) {
               var4[var8] = (char)(var10002 ^ var6);
               var6 = ((var6 >>> (1965052856 ^ 1965052859) | var6 << (1965052862 ^ 1965052859)) ^ var4[var8]) & (1965052740 ^ 1965052859);
            } else {
               var4[var8] = (char)(var10002 ^ var7);
               var7 = ((var7 >>> (1965052856 ^ 1965052859) | var7 << (1965052862 ^ 1965052859)) ^ var4[var8]) & (1965052740 ^ 1965052859);
            }
         }

         b[var3] = new String(var4).intern();
      }

      return b[var3];
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (-8786612127333831330L ^ -8786612127333821791L)) ^ -650693306 ^ -650693746;
      if (d[var3] == null) {
         d[var3] = (int)(c[var3] ^ var1);
      }

      return d[var3];
   }
}
