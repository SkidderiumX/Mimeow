package com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.BlockIdData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.MappingData1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.SoundSource1_12_2;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.SpawnEggMappings1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.IdAndData;
import com.viaversion.viaversion.util.Key;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

public class ItemPacketRewriter1_13 extends ItemRewriter<ClientboundPackets1_12_1, ServerboundPackets1_13, Protocol1_12_2To1_13> {
   public ItemPacketRewriter1_13(Protocol1_12_2To1_13 var1) {
      super(var1, Types.ITEM1_8, Types.ITEM1_8_SHORT_ARRAY, Types.ITEM1_13, Types.ITEM1_13_SHORT_ARRAY);
   }

   public void registerPackets() {
      ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.CONTAINER_SET_SLOT, new PacketHandlers() {
         public void register() {
            this.map(Types.BYTE);
            this.map(Types.SHORT);
            this.map(Types.ITEM1_8, Types.ITEM1_13);
            this.handler(var1 -> ItemPacketRewriter1_13.this.handleItemToClient(var1.user(), (Item)var1.get(Types.ITEM1_13, 0)));
         }
      });
      ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.CONTAINER_SET_CONTENT, new PacketHandlers() {
         public void register() {
            this.map(Types.UNSIGNED_BYTE);
            this.map(Types.ITEM1_8_SHORT_ARRAY, Types.ITEM1_13_SHORT_ARRAY);
            this.handler(var1 -> {
               Item[] var2 = (Item[])var1.get(Types.ITEM1_13_SHORT_ARRAY, 0);

               for (Item var6 : var2) {
                  ItemPacketRewriter1_13.this.handleItemToClient(var1.user(), var6);
               }
            });
         }
      });
      ((Protocol1_12_2To1_13)this.protocol)
         .registerClientbound(
            ClientboundPackets1_12_1.CONTAINER_SET_DATA,
            new PacketHandlers() {
               public void register() {
                  this.map(Types.UNSIGNED_BYTE);
                  this.map(Types.SHORT);
                  this.map(Types.SHORT);
                  this.handler(
                     var1 -> {
                        short var2 = (Short)var1.get(Types.SHORT, 0);
                        if (var2 >= 4 && var2 <= 6) {
                           var1.set(
                              Types.SHORT,
                              1,
                              (short)((Protocol1_12_2To1_13)ItemPacketRewriter1_13.this.protocol)
                                 .getMappingData()
                                 .getEnchantmentMappings()
                                 .getNewId((Short)var1.get(Types.SHORT, 1))
                           );
                        }
                     }
                  );
               }
            }
         );
      ((Protocol1_12_2To1_13)this.protocol)
         .registerClientbound(
            ClientboundPackets1_12_1.CUSTOM_PAYLOAD,
            new PacketHandlers() {
               public void register() {
                  this.map(Types.STRING);
                  this.handlerSoftFail(
                     var1 -> {
                        String var2 = (String)var1.get(Types.STRING, 0);
                        if (var2.equals("MC|StopSound")) {
                           String var12 = (String)var1.read(Types.STRING);
                           String var13 = (String)var1.read(Types.STRING);
                           var1.clearPacket();
                           var1.setPacketType(ClientboundPackets1_13.STOP_SOUND);
                           byte var14 = 0;
                           var1.write(Types.BYTE, var14);
                           if (!var12.isEmpty()) {
                              var14 = (byte)(var14 | 1);
                              Optional var15 = SoundSource1_12_2.findBySource(var12);
                              if (var15.isEmpty()) {
                                 if (Via.getConfig().logOtherConversionWarnings()) {
                                    Protocol1_12_2To1_13.LOGGER.warning("Could not handle unknown sound source " + var12 + " falling back to default: master");
                                 }

                                 var15 = Optional.of(SoundSource1_12_2.MASTER);
                              }

                              var1.write(Types.VAR_INT, ((SoundSource1_12_2)var15.get()).getId());
                           }

                           if (!var13.isEmpty()) {
                              var14 = (byte)(var14 | 2);
                              var1.write(Types.STRING, var13);
                           }

                           var1.set(Types.BYTE, 0, var14);
                        } else {
                           if (var2.equals("MC|TrList")) {
                              var2 = "minecraft:trader_list";
                              ItemPacketRewriter1_13.this.handleTradeList(var1);
                           } else {
                              var2 = ItemPacketRewriter1_13.getNewPluginChannelId(var2);
                              if (var2 == null) {
                                 if (Via.getConfig().logOtherConversionWarnings()) {
                                    ((Protocol1_12_2To1_13)ItemPacketRewriter1_13.this.protocol)
                                       .getLogger()
                                       .warning("Ignoring clientbound plugin message with channel: " + var2);
                                 }

                                 var1.cancel();
                                 return;
                              }

                              if (var2.equals("minecraft:register") || var2.equals("minecraft:unregister")) {
                                 String[] var4 = new String((byte[])var1.read(Types.REMAINING_BYTES), StandardCharsets.UTF_8).split("\u0000");
                                 ArrayList var5 = new ArrayList();

                                 for (String var9 : var4) {
                                    String var10 = ItemPacketRewriter1_13.getNewPluginChannelId(var9);
                                    if (var10 != null) {
                                       var5.add(var10);
                                    } else if (Via.getConfig().logOtherConversionWarnings()) {
                                       ((Protocol1_12_2To1_13)ItemPacketRewriter1_13.this.protocol)
                                          .getLogger()
                                          .warning(
                                             "Ignoring plugin channel in clientbound "
                                                + Key.stripMinecraftNamespace(var2).toUpperCase(Locale.ROOT)
                                                + ": "
                                                + var9
                                          );
                                    }
                                 }

                                 if (var5.isEmpty()) {
                                    var1.cancel();
                                    return;
                                 }

                                 var1.write(Types.REMAINING_BYTES, Joiner.on('\u0000').join(var5).getBytes(StandardCharsets.UTF_8));
                              }
                           }

                           var1.set(Types.STRING, 0, var2);
                        }
                     }
                  );
               }
            }
         );
      ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.SET_EQUIPPED_ITEM, new PacketHandlers() {
         public void register() {
            this.map(Types.VAR_INT);
            this.map(Types.VAR_INT);
            this.map(Types.ITEM1_8, Types.ITEM1_13);
            this.handler(var1 -> ItemPacketRewriter1_13.this.handleItemToClient(var1.user(), (Item)var1.get(Types.ITEM1_13, 0)));
         }
      });
      ((Protocol1_12_2To1_13)this.protocol).registerServerbound(ServerboundPackets1_13.CONTAINER_CLICK, new PacketHandlers() {
         public void register() {
            this.map(Types.BYTE);
            this.map(Types.SHORT);
            this.map(Types.BYTE);
            this.map(Types.SHORT);
            this.map(Types.VAR_INT);
            this.map(Types.ITEM1_13, Types.ITEM1_8);
            this.handler(var1 -> ItemPacketRewriter1_13.this.handleItemToServer(var1.user(), (Item)var1.get(Types.ITEM1_8, 0)));
         }
      });
      ((Protocol1_12_2To1_13)this.protocol)
         .registerServerbound(
            ServerboundPackets1_13.CUSTOM_PAYLOAD,
            new PacketHandlers() {
               public void register() {
                  this.map(Types.STRING);
                  this.handler(
                     var1 -> {
                        String var2 = (String)var1.get(Types.STRING, 0);
                        var2 = ItemPacketRewriter1_13.getOldPluginChannelId(var2);
                        if (var2 == null) {
                           if (Via.getManager().isDebug()) {
                              ((Protocol1_12_2To1_13)ItemPacketRewriter1_13.this.protocol)
                                 .getLogger()
                                 .warning("Ignoring serverbound plugin message with channel: " + var2);
                           }

                           var1.cancel();
                        } else {
                           if (var2.equals("REGISTER") || var2.equals("UNREGISTER")) {
                              String[] var4 = new String((byte[])var1.read(Types.SERVERBOUND_CUSTOM_PAYLOAD_DATA), StandardCharsets.UTF_8).split("\u0000");
                              ArrayList var5 = new ArrayList();

                              for (String var9 : var4) {
                                 String var10 = ItemPacketRewriter1_13.getOldPluginChannelId(var9);
                                 if (var10 != null) {
                                    var5.add(var10);
                                 } else if (Via.getManager().isDebug()) {
                                    ((Protocol1_12_2To1_13)ItemPacketRewriter1_13.this.protocol)
                                       .getLogger()
                                       .warning("Ignoring plugin channel in serverbound " + var2 + ": " + var9);
                                 }
                              }

                              var1.write(Types.SERVERBOUND_CUSTOM_PAYLOAD_DATA, Joiner.on('\u0000').join(var5).getBytes(StandardCharsets.UTF_8));
                           }

                           var1.set(Types.STRING, 0, var2);
                        }
                     }
                  );
               }
            }
         );
      ((Protocol1_12_2To1_13)this.protocol).registerServerbound(ServerboundPackets1_13.SET_CREATIVE_MODE_SLOT, new PacketHandlers() {
         public void register() {
            this.map(Types.SHORT);
            this.map(Types.ITEM1_13, Types.ITEM1_8);
            this.handler(var1 -> ItemPacketRewriter1_13.this.handleItemToServer(var1.user(), (Item)var1.get(Types.ITEM1_8, 0)));
         }
      });
   }

   public Item handleItemToClient(UserConnection var1, Item var2) {
      if (var2 == null) {
         return null;
      } else {
         CompoundTag var3 = var2.tag();
         int var4 = var2.identifier() << 16 | var2.data() & '\uffff';
         int var5 = IdAndData.toRawData(var2.identifier(), var2.data());
         if (isDamageable(var2.identifier())) {
            if (var3 == null) {
               var2.setTag(var3 = new CompoundTag());
            }

            var3.put("Damage", new IntTag(var2.data()));
         }

         if (var2.identifier() == 358) {
            if (var3 == null) {
               var2.setTag(var3 = new CompoundTag());
            }

            var3.put("map", new IntTag(var2.data()));
         }

         if (var3 != null) {
            boolean var6 = var2.identifier() == 425;
            if (var6 || var2.identifier() == 442) {
               CompoundTag var7 = var3.getCompoundTag("BlockEntityTag");
               if (var7 != null) {
                  NumberTag var8 = var7.getNumberTag("Base");
                  if (var8 != null) {
                     if (var6) {
                        var5 = 6800 + var8.asInt();
                     }

                     var7.putInt("Base", 15 - var8.asInt());
                  }

                  ListTag var9 = var7.getListTag("Patterns", CompoundTag.class);
                  if (var9 != null) {
                     for (CompoundTag var11 : var9) {
                        NumberTag var12 = var11.getNumberTag("Color");
                        if (var12 != null) {
                           var11.putInt("Color", 15 - var12.asInt());
                        }
                     }
                  }
               }
            }

            CompoundTag var23 = var3.getCompoundTag("display");
            if (var23 != null) {
               StringTag var24 = var23.getStringTag("Name");
               if (var24 != null) {
                  var23.putString(this.nbtTagName("Name"), var24.getValue());
                  var24.setValue(ComponentUtil.legacyToJsonString(var24.getValue(), true));
               }
            }

            ListTag var25 = var3.getListTag("ench", CompoundTag.class);
            if (var25 != null) {
               ListTag var26 = new ListTag(CompoundTag.class);

               for (CompoundTag var31 : var25) {
                  short var35 = var31.getShort("id", (short)0);
                  CompoundTag var13 = new CompoundTag();
                  String var14 = (String)Protocol1_12_2To1_13.MAPPINGS.getOldEnchantmentsIds().get(var35);
                  if (var14 == null) {
                     var14 = "viaversion:legacy/" + var35;
                  }

                  var13.putString("id", var14);
                  var13.putShort("lvl", var31.getShort("lvl", (short)0));
                  var26.add(var13);
               }

               var3.remove("ench");
               var3.put("Enchantments", var26);
            }

            ListTag var27 = var3.getListTag("StoredEnchantments", CompoundTag.class);
            if (var27 != null) {
               ListTag var29 = new ListTag(CompoundTag.class);

               for (CompoundTag var36 : var27) {
                  NumberTag var40 = var36.getNumberTag("id");
                  if (var40 != null) {
                     CompoundTag var44 = new CompoundTag();
                     short var15 = var40.asShort();
                     String var16 = (String)Protocol1_12_2To1_13.MAPPINGS.getOldEnchantmentsIds().get(var15);
                     if (var16 == null) {
                        var16 = "viaversion:legacy/" + var15;
                     }

                     var44.putString("id", var16);
                     NumberTag var17 = var36.getNumberTag("lvl");
                     if (var17 != null) {
                        var44.putShort("lvl", var17.asShort());
                     }

                     var29.add(var44);
                  }
               }

               var3.put("StoredEnchantments", var29);
            }

            ListTag var30 = var3.getListTag("CanPlaceOn");
            if (var30 != null) {
               ListTag var33 = new ListTag(StringTag.class);
               var3.put(this.nbtTagName("CanPlaceOn"), var30.copy());

               for (Tag var41 : var30) {
                  Object var45 = var41.getValue();
                  String var47 = Key.stripMinecraftNamespace(var45.toString());
                  String var49 = (String)BlockIdData.numberIdToString.get(Ints.tryParse(var47));
                  if (var49 != null) {
                     var47 = var49;
                  }

                  String[] var51 = (String[])BlockIdData.blockIdMapping.get(var47.toLowerCase(Locale.ROOT));
                  if (var51 != null) {
                     for (String var21 : var51) {
                        var33.add(new StringTag(var21));
                     }
                  } else {
                     var33.add(new StringTag(var47.toLowerCase(Locale.ROOT)));
                  }
               }

               var3.put("CanPlaceOn", var33);
            }

            ListTag var34 = var3.getListTag("CanDestroy");
            if (var34 != null) {
               ListTag var38 = new ListTag(StringTag.class);
               var3.put(this.nbtTagName("CanDestroy"), var34.copy());

               for (Tag var46 : var34) {
                  Object var48 = var46.getValue();
                  String var50 = Key.stripMinecraftNamespace(var48.toString());
                  String var52 = (String)BlockIdData.numberIdToString.get(Ints.tryParse(var50));
                  if (var52 != null) {
                     var50 = var52;
                  }

                  String[] var53 = (String[])BlockIdData.blockIdMapping.get(var50.toLowerCase(Locale.ROOT));
                  if (var53 != null) {
                     for (String var22 : var53) {
                        var38.add(new StringTag(var22));
                     }
                  } else {
                     var38.add(new StringTag(var50.toLowerCase(Locale.ROOT)));
                  }
               }

               var3.put("CanDestroy", var38);
            }

            if (var2.identifier() == 383) {
               CompoundTag var39 = var3.getCompoundTag("EntityTag");
               if (var39 != null) {
                  StringTag var43 = var39.getStringTag("id");
                  if (var43 != null) {
                     var5 = SpawnEggMappings1_13.getSpawnEggId(var43.getValue());
                     if (var5 == -1) {
                        var5 = 25100288;
                     } else {
                        var39.remove("id");
                        if (var39.isEmpty()) {
                           var3.remove("EntityTag");
                        }
                     }
                  } else {
                     var5 = 25100288;
                  }
               } else {
                  var5 = 25100288;
               }
            }

            if (var3.isEmpty()) {
               var3 = null;
               var2.setTag(null);
            }
         }

         if (Protocol1_12_2To1_13.MAPPINGS.getItemMappings().getNewId(var5) == -1) {
            if (!isDamageable(var2.identifier()) && var2.identifier() != 358) {
               if (var3 == null) {
                  var2.setTag(var3 = new CompoundTag());
               }

               var3.put(this.nbtTagName(), new IntTag(var4));
            }

            if (var2.identifier() == 31 && var2.data() == 0) {
               var5 = IdAndData.toRawData(32);
            } else if (Protocol1_12_2To1_13.MAPPINGS.getItemMappings().getNewId(IdAndData.removeData(var5)) != -1) {
               var5 = IdAndData.removeData(var5);
            } else {
               if (Via.getConfig().logOtherConversionWarnings()) {
                  ((Protocol1_12_2To1_13)this.protocol).getLogger().warning("Failed to get new item for " + var2.identifier());
               }

               var5 = 16;
            }
         }

         var2.setIdentifier(Protocol1_12_2To1_13.MAPPINGS.getItemMappings().getNewId(var5));
         var2.setData((short)0);
         return var2;
      }
   }

   public static String getNewPluginChannelId(String var0) {
      return switch (var0) {
         case "MC|TrList" -> "minecraft:trader_list";
         case "MC|Brand" -> "minecraft:brand";
         case "MC|BOpen" -> "minecraft:book_open";
         case "MC|DebugPath" -> "minecraft:debug/paths";
         case "MC|DebugNeighborsUpdate" -> "minecraft:debug/neighbors_update";
         case "REGISTER" -> "minecraft:register";
         case "UNREGISTER" -> "minecraft:unregister";
         case "BungeeCord" -> "bungeecord:main";
         case "bungeecord:main" -> null;
         default -> {
            String var3 = (String)Protocol1_12_2To1_13.MAPPINGS.getChannelMappings().get(var0);
            yield var3 != null ? var3 : MappingData1_13.validateNewChannel(var0);
         }
      };
   }

   public Item handleItemToServer(UserConnection var1, Item var2) {
      if (var2 == null) {
         return null;
      } else {
         Integer var3 = null;
         boolean var4 = false;
         CompoundTag var5 = var2.tag();
         if (var5 != null) {
            NumberTag var6 = var5.getNumberTag(this.nbtTagName());
            if (var6 != null) {
               var3 = var6.asInt();
               var5.remove(this.nbtTagName());
               var4 = true;
            }
         }

         if (var3 == null) {
            int var19 = Protocol1_12_2To1_13.MAPPINGS.getItemMappings().inverse().getNewId(var2.identifier());
            if (var19 != -1) {
               Optional var7 = SpawnEggMappings1_13.getEntityId(var19);
               if (var7.isPresent()) {
                  var3 = 25100288;
                  if (var5 == null) {
                     var2.setTag(var5 = new CompoundTag());
                  }

                  if (!var5.contains("EntityTag")) {
                     CompoundTag var8 = new CompoundTag();
                     var8.put("id", new StringTag((String)var7.get()));
                     var5.put("EntityTag", var8);
                  }
               } else {
                  var3 = IdAndData.getId(var19) << 16 | var19 & 15;
               }
            }
         }

         if (var3 == null) {
            if (Via.getConfig().logOtherConversionWarnings()) {
               ((Protocol1_12_2To1_13)this.protocol).getLogger().warning("Failed to get old item for " + var2.identifier());
            }

            var3 = 65536;
         }

         var2.setIdentifier((short)(var3 >> 16));
         var2.setData((short)(var3 & 65535));
         if (var5 != null) {
            if (isDamageable(var2.identifier())) {
               NumberTag var20 = var5.getNumberTag("Damage");
               if (var20 != null) {
                  if (!var4) {
                     var2.setData(var20.asShort());
                  }

                  var5.remove("Damage");
               }
            }

            if (var2.identifier() == 358) {
               NumberTag var21 = var5.getNumberTag("map");
               if (var21 != null) {
                  if (!var4) {
                     var2.setData(var21.asShort());
                  }

                  var5.remove("map");
               }
            }

            if (var2.identifier() == 442 || var2.identifier() == 425) {
               CompoundTag var22 = var5.getCompoundTag("BlockEntityTag");
               if (var22 != null) {
                  NumberTag var24 = var22.getNumberTag("Base");
                  if (var24 != null) {
                     var22.putInt("Base", 15 - var24.asInt());
                  }

                  ListTag var27 = var22.getListTag("Patterns", CompoundTag.class);
                  if (var27 != null) {
                     for (CompoundTag var10 : var27) {
                        NumberTag var11 = var10.getNumberTag("Color");
                        var10.putInt("Color", 15 - var11.asInt());
                     }
                  }
               }
            }

            CompoundTag var23 = var5.getCompoundTag("display");
            if (var23 != null) {
               StringTag var25 = var23.getStringTag("Name");
               if (var25 != null) {
                  Tag var28 = var23.remove(this.nbtTagName("Name"));
                  var25.setValue(var28 instanceof StringTag ? (String)var28.getValue() : ComponentUtil.jsonToLegacy(var25.getValue()));
               }
            }

            ListTag var26 = var5.getListTag("Enchantments", CompoundTag.class);
            if (var26 != null) {
               ListTag var29 = new ListTag(CompoundTag.class);

               for (CompoundTag var35 : var26) {
                  StringTag var39 = var35.getStringTag("id");
                  if (var39 != null) {
                     CompoundTag var12 = new CompoundTag();
                     String var13 = var39.getValue();
                     Short var14 = (Short)Protocol1_12_2To1_13.MAPPINGS.getOldEnchantmentsIds().inverse().get(var13);
                     if (var14 == null && var13.startsWith("viaversion:legacy/")) {
                        var14 = Short.valueOf(var13.substring(18));
                     }

                     if (var14 != null) {
                        var12.putShort("id", var14);
                        var12.putShort("lvl", var35.getShort("lvl", (short)0));
                        var29.add(var12);
                     }
                  }
               }

               var5.remove("Enchantments");
               var5.put("ench", var29);
            }

            ListTag var30 = var5.getListTag("StoredEnchantments", CompoundTag.class);
            if (var30 != null) {
               ListTag var32 = new ListTag(CompoundTag.class);

               for (CompoundTag var40 : var30) {
                  StringTag var43 = var40.getStringTag("id");
                  if (var43 != null) {
                     CompoundTag var46 = new CompoundTag();
                     String var49 = var43.getValue();
                     Short var15 = (Short)Protocol1_12_2To1_13.MAPPINGS.getOldEnchantmentsIds().inverse().get(var49);
                     if (var15 == null && var49.startsWith("viaversion:legacy/")) {
                        var15 = Short.valueOf(var49.substring(18));
                     }

                     if (var15 != null) {
                        var46.putShort("id", var15);
                        NumberTag var16 = var40.getNumberTag("lvl");
                        if (var16 != null) {
                           var46.putShort("lvl", var16.asShort());
                        }

                        var32.add(var46);
                     }
                  }
               }

               var5.put("StoredEnchantments", var32);
            }

            if (var5.getListTag(this.nbtTagName("CanPlaceOn")) != null) {
               var5.put("CanPlaceOn", var5.remove(this.nbtTagName("CanPlaceOn")));
            } else if (var5.getListTag("CanPlaceOn") != null) {
               ListTag var33 = var5.getListTag("CanPlaceOn");
               ListTag var37 = new ListTag(StringTag.class);

               for (Tag var44 : var33) {
                  Object var47 = var44.getValue();
                  String[] var50 = (String[])BlockIdData.fallbackReverseMapping
                     .get(var47 instanceof String ? Key.stripMinecraftNamespace((String)var47) : null);
                  if (var50 != null) {
                     for (String var18 : var50) {
                        var37.add(new StringTag(var18));
                     }
                  } else {
                     var37.add(new StringTag(var47.toString()));
                  }
               }

               var5.put("CanPlaceOn", var37);
            }

            if (var5.getListTag(this.nbtTagName("CanDestroy")) != null) {
               var5.put("CanDestroy", var5.remove(this.nbtTagName("CanDestroy")));
            } else if (var5.getListTag("CanDestroy") != null) {
               ListTag var34 = var5.getListTag("CanDestroy");
               ListTag var38 = new ListTag(StringTag.class);

               for (Tag var45 : var34) {
                  Object var48 = var45.getValue();
                  String[] var51 = (String[])BlockIdData.fallbackReverseMapping
                     .get(var48 instanceof String ? Key.stripMinecraftNamespace((String)var48) : null);
                  if (var51 != null) {
                     for (String var57 : var51) {
                        var38.add(new StringTag(var57));
                     }
                  } else {
                     var38.add(new StringTag(var45.getValue().toString()));
                  }
               }

               var5.put("CanDestroy", var38);
            }
         }

         return var2;
      }
   }

   public static String getOldPluginChannelId(String var0) {
      var0 = MappingData1_13.validateNewChannel(var0);
      if (var0 == null) {
         return null;
      } else {
         return switch (var0) {
            case "minecraft:trader_list" -> "MC|TrList";
            case "minecraft:book_open" -> "MC|BOpen";
            case "minecraft:debug/paths" -> "MC|DebugPath";
            case "minecraft:debug/neighbors_update" -> "MC|DebugNeighborsUpdate";
            case "minecraft:register" -> "REGISTER";
            case "minecraft:unregister" -> "UNREGISTER";
            case "minecraft:brand" -> "MC|Brand";
            case "bungeecord:main" -> "BungeeCord";
            default -> {
               String var3 = (String)Protocol1_12_2To1_13.MAPPINGS.getChannelMappings().inverse().get(var0);
               yield var3 != null ? var3 : (var0.length() > 20 ? var0.substring(0, 20) : var0);
            }
         };
      }
   }

   public static boolean isDamageable(int var0) {
      return var0 >= 256 && var0 <= 259
         || var0 == 261
         || var0 >= 267 && var0 <= 279
         || var0 >= 283 && var0 <= 286
         || var0 >= 290 && var0 <= 294
         || var0 >= 298 && var0 <= 317
         || var0 == 346
         || var0 == 359
         || var0 == 398
         || var0 == 442
         || var0 == 443;
   }
}
