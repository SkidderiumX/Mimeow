package x;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ocd6187963f3 {
   public static boolean Ļ;

   public static String ʭ(String var0) {
      String var2 = "";
      int var10000 = oc75d51ec7eb.ϩ;
      String var3 = oc3fe2a46456.Ҏ("https://api.mojang.com/users/configs/minecraft/" + var0, false);
      int var1 = var10000;

      try {
         if (var1 != 0) {
            return var3;
         }

         if (var3.isEmpty()) {
            return var2;
         }
      } catch (ArrayIndexOutOfBoundsException var6) {
         throw var6;
      }

      try {
         var2 = var3.split("d\":\"")[1].split("\"")[0];
      } catch (ArrayIndexOutOfBoundsException var5) {
      }

      return var2;
   }

   public static int[] Ǆ(String param0, oc468eeccdbe param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: ldc -26002552
      // 005: ldc -26002549
      // 007: ixor
      // 008: newarray 10
      // 00a: dup
      // 00b: bipush 0
      // 00c: bipush 0
      // 00d: iastore
      // 00e: dup
      // 00f: bipush 1
      // 010: bipush 0
      // 011: iastore
      // 012: dup
      // 013: ldc -26002551
      // 015: ldc -26002549
      // 017: ixor
      // 018: bipush 0
      // 019: iastore
      // 01a: astore 3
      // 01b: istore 2
      // 01c: aload 0
      // 01d: invokestatic x/ocd6187963f3.ʭ (Ljava/lang/String;)Ljava/lang/String;
      // 020: astore 4
      // 022: aload 4
      // 024: iload 2
      // 025: ifne 04e
      // 028: invokevirtual java/lang/String.isEmpty ()Z
      // 02b: ifeq 039
      // 02e: goto 032
      // 031: athrow
      // 032: aload 3
      // 033: bipush 0
      // 034: bipush -1
      // 035: iastore
      // 036: aload 3
      // 037: areturn
      // 038: athrow
      // 039: getstatic x/oc3fe2a46456.Ճ Ljava/lang/String;
      // 03c: aload 4
      // 03e: ldc "https://api.hypixel.net/player?key="
      // 040: dup_x2
      // 041: pop
      // 042: ldc "&uuid="
      // 044: swap
      // 045: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 04a: bipush 0
      // 04b: invokestatic x/oc3fe2a46456.Ҏ (Ljava/lang/String;Z)Ljava/lang/String;
      // 04e: astore 5
      // 050: aload 5
      // 052: iload 2
      // 053: ifne 065
      // 056: invokevirtual java/lang/String.isEmpty ()Z
      // 059: ifeq 063
      // 05c: goto 060
      // 05f: athrow
      // 060: aconst_null
      // 061: areturn
      // 062: athrow
      // 063: aload 5
      // 065: iload 2
      // 066: ifne 07e
      // 069: ldc "{\"success\":true,\"player\":null}"
      // 06b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 06e: ifeq 07c
      // 071: goto 075
      // 074: athrow
      // 075: aload 3
      // 076: bipush 0
      // 077: bipush -1
      // 078: iastore
      // 079: aload 3
      // 07a: areturn
      // 07b: athrow
      // 07c: aload 5
      // 07e: invokestatic x/ocd6187963f3.ɽ (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 081: ldc "player"
      // 083: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 086: astore 7
      // 088: aload 7
      // 08a: ldc "stats"
      // 08c: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 08f: ldc "Duels"
      // 091: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 094: astore 6
      // 096: goto 09d
      // 099: astore 7
      // 09b: aload 3
      // 09c: areturn
      // 09d: getstatic x/oc757fc46195.ʰ [I
      // 0a0: iload 2
      // 0a1: ifne 1f8
      // 0a4: aload 1
      // 0a5: invokevirtual java/lang/Enum.ordinal ()I
      // 0a8: iaload
      // 0a9: tableswitch 334 1 7 44 86 128 170 212 254 296
      // 0d4: athrow
      // 0d5: aload 3
      // 0d6: bipush 0
      // 0d7: aload 6
      // 0d9: ldc "wins"
      // 0db: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 0de: iastore
      // 0df: iload 2
      // 0e0: aload 3
      // 0e1: bipush 1
      // 0e2: aload 6
      // 0e4: ldc "losses"
      // 0e6: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 0e9: iastore
      // 0ea: aload 3
      // 0eb: ldc -26002551
      // 0ed: ldc -26002549
      // 0ef: ixor
      // 0f0: aload 6
      // 0f2: ldc "current_winstreak"
      // 0f4: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 0f7: iastore
      // 0f8: ifeq 1f7
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: aload 3
      // 100: bipush 0
      // 101: aload 6
      // 103: ldc "bridge_duel_wins"
      // 105: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 108: iastore
      // 109: iload 2
      // 10a: aload 3
      // 10b: bipush 1
      // 10c: aload 6
      // 10e: ldc "bridge_duel_losses"
      // 110: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 113: iastore
      // 114: aload 3
      // 115: ldc -26002551
      // 117: ldc -26002549
      // 119: ixor
      // 11a: aload 6
      // 11c: ldc "current_winstreak_mode_bridge_duel"
      // 11e: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 121: iastore
      // 122: ifeq 1f7
      // 125: goto 129
      // 128: athrow
      // 129: aload 3
      // 12a: bipush 0
      // 12b: aload 6
      // 12d: ldc "uhc_duel_wins"
      // 12f: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 132: iastore
      // 133: iload 2
      // 134: aload 3
      // 135: bipush 1
      // 136: aload 6
      // 138: ldc "uhc_duel_losses"
      // 13a: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 13d: iastore
      // 13e: aload 3
      // 13f: ldc -26002551
      // 141: ldc -26002549
      // 143: ixor
      // 144: aload 6
      // 146: ldc "current_winstreak_mode_uhc_duel"
      // 148: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 14b: iastore
      // 14c: ifeq 1f7
      // 14f: goto 153
      // 152: athrow
      // 153: aload 3
      // 154: bipush 0
      // 155: aload 6
      // 157: ldc "sw_duel_wins"
      // 159: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 15c: iastore
      // 15d: iload 2
      // 15e: aload 3
      // 15f: bipush 1
      // 160: aload 6
      // 162: ldc "sw_duel_losses"
      // 164: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 167: iastore
      // 168: aload 3
      // 169: ldc -26002551
      // 16b: ldc -26002549
      // 16d: ixor
      // 16e: aload 6
      // 170: ldc "current_winstreak_mode_sw_duel"
      // 172: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 175: iastore
      // 176: ifeq 1f7
      // 179: goto 17d
      // 17c: athrow
      // 17d: aload 3
      // 17e: bipush 0
      // 17f: aload 6
      // 181: ldc "classic_duel_wins"
      // 183: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 186: iastore
      // 187: iload 2
      // 188: aload 3
      // 189: bipush 1
      // 18a: aload 6
      // 18c: ldc "classic_duel_losses"
      // 18e: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 191: iastore
      // 192: aload 3
      // 193: ldc -26002551
      // 195: ldc -26002549
      // 197: ixor
      // 198: aload 6
      // 19a: ldc "current_winstreak_mode_classic_duel"
      // 19c: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 19f: iastore
      // 1a0: ifeq 1f7
      // 1a3: goto 1a7
      // 1a6: athrow
      // 1a7: aload 3
      // 1a8: bipush 0
      // 1a9: aload 6
      // 1ab: ldc "sumo_duel_wins"
      // 1ad: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 1b0: iastore
      // 1b1: iload 2
      // 1b2: aload 3
      // 1b3: bipush 1
      // 1b4: aload 6
      // 1b6: ldc "sumo_duel_losses"
      // 1b8: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 1bb: iastore
      // 1bc: aload 3
      // 1bd: ldc -26002551
      // 1bf: ldc -26002549
      // 1c1: ixor
      // 1c2: aload 6
      // 1c4: ldc "current_winstreak_mode_sumo_duel"
      // 1c6: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 1c9: iastore
      // 1ca: ifeq 1f7
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: aload 3
      // 1d2: bipush 0
      // 1d3: aload 6
      // 1d5: ldc "op_duel_wins"
      // 1d7: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 1da: iastore
      // 1db: aload 3
      // 1dc: bipush 1
      // 1dd: aload 6
      // 1df: ldc "op_duel_losses"
      // 1e1: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 1e4: iastore
      // 1e5: aload 3
      // 1e6: ldc -26002551
      // 1e8: ldc -26002549
      // 1ea: ixor
      // 1eb: aload 6
      // 1ed: ldc "current_winstreak_mode_op_duel"
      // 1ef: invokestatic x/ocd6187963f3.Ɖ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 1f2: iastore
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: aload 3
      // 1f8: areturn
   }

   public static JsonObject ɽ(String var0) {
      return new JsonParser().parse(var0).getAsJsonObject();
   }

   private static int Ɖ(JsonObject var0, String var1) {
      try {
         return var0.get(var1).getAsInt();
      } catch (NullPointerException var3) {
         return 0;
      }
   }
}
