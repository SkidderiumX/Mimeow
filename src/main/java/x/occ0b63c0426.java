/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S04PacketEntityEquipment;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.network.play.server.S3APacketTabComplete;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.network.play.server.S48PacketResourcePackSend;
import x.X;
import x.oc030ea82433;
import x.oc03a37356a3;
import x.oc045f64831f;
import x.oc053077e19a;
import x.oc10f20f846c;
import x.oc1b743e011d;
import x.oc1b9cbb9226;
import x.oc280b8a3c43;
import x.oc2d79e1dd0c;
import x.oc31b1967813;
import x.oc5a44124678;
import x.oc6ebd99bf0a;
import x.oc6f075f1cac;
import x.oc71be897b21;
import x.oc72c3e9656a;
import x.oc769a30268a;
import x.oc948d122621;
import x.oc97d4972555;
import x.oca05c637d94;
import x.oca0fa073d02;
import x.oca772d6b3da;
import x.ocaf819336d8;
import x.ocb5eb238adf;
import x.ocba842a160c;
import x.occ93111d57d;
import x.occf2b398b8e;
import x.ocd26db33720;
import x.ocd801a42c00;
import x.oce65c065a48;
import x.oce75251caf8;
import x.oced99401c02;
import x.ocfaf379fc4a;

public class occ0b63c0426 {
    public static int \u039f;

    private occ0b63c0426() {
    }

    public static ocb5eb238adf \u01cd(Packet<?> packet) {
        Packet<?> packet2;
        block79: {
            block80: {
                int n;
                block77: {
                    block78: {
                        block75: {
                            block76: {
                                block73: {
                                    block74: {
                                        block71: {
                                            block72: {
                                                block69: {
                                                    block70: {
                                                        block67: {
                                                            block68: {
                                                                block65: {
                                                                    block66: {
                                                                        block63: {
                                                                            block64: {
                                                                                block61: {
                                                                                    block62: {
                                                                                        block59: {
                                                                                            block60: {
                                                                                                block57: {
                                                                                                    block58: {
                                                                                                        block55: {
                                                                                                            block56: {
                                                                                                                n = \u039f;
                                                                                                                packet2 = packet;
                                                                                                                if (n != 0) break block55;
                                                                                                                if (!(packet2 instanceof C01PacketChatMessage)) break block56;
                                                                                                                return new oc71be897b21((C01PacketChatMessage)packet);
                                                                                                            }
                                                                                                            packet2 = packet;
                                                                                                        }
                                                                                                        if (n != 0) break block57;
                                                                                                        if (!(packet2 instanceof C02PacketUseEntity)) break block58;
                                                                                                        return new oc31b1967813((C02PacketUseEntity)packet);
                                                                                                    }
                                                                                                    packet2 = packet;
                                                                                                }
                                                                                                if (n != 0) break block59;
                                                                                                if (!(packet2 instanceof C03PacketPlayer)) break block60;
                                                                                                return new oc5a44124678((C03PacketPlayer)packet);
                                                                                            }
                                                                                            packet2 = packet;
                                                                                        }
                                                                                        if (n != 0) break block61;
                                                                                        if (!(packet2 instanceof C07PacketPlayerDigging)) break block62;
                                                                                        return new occ93111d57d((C07PacketPlayerDigging)packet);
                                                                                    }
                                                                                    packet2 = packet;
                                                                                }
                                                                                if (n != 0) break block63;
                                                                                if (!(packet2 instanceof C08PacketPlayerBlockPlacement)) break block64;
                                                                                return new occf2b398b8e((C08PacketPlayerBlockPlacement)packet);
                                                                            }
                                                                            packet2 = packet;
                                                                        }
                                                                        if (n != 0) break block65;
                                                                        if (!(packet2 instanceof C0BPacketEntityAction)) break block66;
                                                                        return new oc1b9cbb9226((C0BPacketEntityAction)packet);
                                                                    }
                                                                    packet2 = packet;
                                                                }
                                                                if (n != 0) break block67;
                                                                if (!(packet2 instanceof C09PacketHeldItemChange)) break block68;
                                                                return new oc6ebd99bf0a((C09PacketHeldItemChange)packet);
                                                            }
                                                            packet2 = packet;
                                                        }
                                                        if (n != 0) break block69;
                                                        if (!(packet2 instanceof C0APacketAnimation)) break block70;
                                                        return new oce65c065a48((C0APacketAnimation)packet);
                                                    }
                                                    packet2 = packet;
                                                }
                                                if (n != 0) break block71;
                                                if (!(packet2 instanceof C0DPacketCloseWindow)) break block72;
                                                return new oc948d122621((C0DPacketCloseWindow)packet);
                                            }
                                            packet2 = packet;
                                        }
                                        if (n != 0) break block73;
                                        if (!(packet2 instanceof C0EPacketClickWindow)) break block74;
                                        return new oc6f075f1cac((C0EPacketClickWindow)packet);
                                    }
                                    packet2 = packet;
                                }
                                if (n != 0) break block75;
                                if (!(packet2 instanceof C0FPacketConfirmTransaction)) break block76;
                                return new oca05c637d94((C0FPacketConfirmTransaction)packet);
                            }
                            packet2 = packet;
                        }
                        if (n != 0) break block77;
                        if (!(packet2 instanceof C10PacketCreativeInventoryAction)) break block78;
                        return new X((C10PacketCreativeInventoryAction)packet);
                    }
                    packet2 = packet;
                }
                if (n != 0) break block79;
                if (!(packet2 instanceof C13PacketPlayerAbilities)) break block80;
                return new oc72c3e9656a((C13PacketPlayerAbilities)packet);
            }
            packet2 = packet;
        }
        if (packet2 instanceof C16PacketClientStatus) {
            return new oc045f64831f((C16PacketClientStatus)packet);
        }
        return new ocb5eb238adf(packet);
    }

    public static oc053077e19a \u046b(Packet<?> packet) {
        Packet<?> packet2;
        block97: {
            block98: {
                int n;
                block95: {
                    block96: {
                        block93: {
                            block94: {
                                block91: {
                                    block92: {
                                        block89: {
                                            block90: {
                                                block87: {
                                                    block88: {
                                                        block85: {
                                                            block86: {
                                                                block83: {
                                                                    block84: {
                                                                        block81: {
                                                                            block82: {
                                                                                block79: {
                                                                                    block80: {
                                                                                        block77: {
                                                                                            block78: {
                                                                                                block75: {
                                                                                                    block76: {
                                                                                                        block73: {
                                                                                                            block74: {
                                                                                                                block71: {
                                                                                                                    block72: {
                                                                                                                        block69: {
                                                                                                                            block70: {
                                                                                                                                block67: {
                                                                                                                                    block68: {
                                                                                                                                        n = \u039f;
                                                                                                                                        packet2 = packet;
                                                                                                                                        if (n != 0) break block67;
                                                                                                                                        if (!(packet2 instanceof S02PacketChat)) break block68;
                                                                                                                                        return new oca772d6b3da((S02PacketChat)packet);
                                                                                                                                    }
                                                                                                                                    packet2 = packet;
                                                                                                                                }
                                                                                                                                if (n != 0) break block69;
                                                                                                                                if (!(packet2 instanceof S04PacketEntityEquipment)) break block70;
                                                                                                                                return new oc1b743e011d((S04PacketEntityEquipment)packet);
                                                                                                                            }
                                                                                                                            packet2 = packet;
                                                                                                                        }
                                                                                                                        if (n != 0) break block71;
                                                                                                                        if (!(packet2 instanceof S06PacketUpdateHealth)) break block72;
                                                                                                                        return new oced99401c02((S06PacketUpdateHealth)packet);
                                                                                                                    }
                                                                                                                    packet2 = packet;
                                                                                                                }
                                                                                                                if (n != 0) break block73;
                                                                                                                if (!(packet2 instanceof S08PacketPlayerPosLook)) break block74;
                                                                                                                return new oc2d79e1dd0c((S08PacketPlayerPosLook)packet);
                                                                                                            }
                                                                                                            packet2 = packet;
                                                                                                        }
                                                                                                        if (n != 0) break block75;
                                                                                                        if (!(packet2 instanceof S0BPacketAnimation)) break block76;
                                                                                                        return new ocd801a42c00((S0BPacketAnimation)packet);
                                                                                                    }
                                                                                                    packet2 = packet;
                                                                                                }
                                                                                                if (n != 0) break block77;
                                                                                                if (!(packet2 instanceof S12PacketEntityVelocity)) break block78;
                                                                                                return new oc769a30268a((S12PacketEntityVelocity)packet);
                                                                                            }
                                                                                            packet2 = packet;
                                                                                        }
                                                                                        if (n != 0) break block79;
                                                                                        if (!(packet2 instanceof S14PacketEntity)) break block80;
                                                                                        return new ocaf819336d8((S14PacketEntity)packet);
                                                                                    }
                                                                                    packet2 = packet;
                                                                                }
                                                                                if (n != 0) break block81;
                                                                                if (!(packet2 instanceof S23PacketBlockChange)) break block82;
                                                                                return new ocba842a160c((S23PacketBlockChange)packet);
                                                                            }
                                                                            packet2 = packet;
                                                                        }
                                                                        if (n != 0) break block83;
                                                                        if (!(packet2 instanceof S25PacketBlockBreakAnim)) break block84;
                                                                        return new ocfaf379fc4a((S25PacketBlockBreakAnim)packet);
                                                                    }
                                                                    packet2 = packet;
                                                                }
                                                                if (n != 0) break block85;
                                                                if (!(packet2 instanceof S27PacketExplosion)) break block86;
                                                                return new oc280b8a3c43((S27PacketExplosion)packet);
                                                            }
                                                            packet2 = packet;
                                                        }
                                                        if (n != 0) break block87;
                                                        if (!(packet2 instanceof S29PacketSoundEffect)) break block88;
                                                        return new oce75251caf8((S29PacketSoundEffect)packet);
                                                    }
                                                    packet2 = packet;
                                                }
                                                if (n != 0) break block89;
                                                if (!(packet2 instanceof S2APacketParticles)) break block90;
                                                return new oc03a37356a3((S2APacketParticles)packet);
                                            }
                                            packet2 = packet;
                                        }
                                        if (n != 0) break block91;
                                        if (!(packet2 instanceof S2FPacketSetSlot)) break block92;
                                        return new ocd26db33720((S2FPacketSetSlot)packet);
                                    }
                                    packet2 = packet;
                                }
                                if (n != 0) break block93;
                                if (!(packet2 instanceof S3APacketTabComplete)) break block94;
                                return new oca0fa073d02((S3APacketTabComplete)packet);
                            }
                            packet2 = packet;
                        }
                        if (n != 0) break block95;
                        if (!(packet2 instanceof S3EPacketTeams)) break block96;
                        return new oc97d4972555((S3EPacketTeams)packet);
                    }
                    packet2 = packet;
                }
                if (n != 0) break block97;
                if (!(packet2 instanceof S45PacketTitle)) break block98;
                return new oc10f20f846c((S45PacketTitle)packet);
            }
            packet2 = packet;
        }
        if (packet2 instanceof S48PacketResourcePackSend) {
            return new oc030ea82433((S48PacketResourcePackSend)packet);
        }
        return new oc053077e19a(packet);
    }

    private static String \u025b(Block block) {
        String string;
        block6: {
            Object k;
            block4: {
                Object k2;
                block5: {
                    k2 = Block.blockRegistry.getNameForObject(block);
                    int n = \u039f;
                    k = k2;
                    if (n != 0) break block4;
                    if (k != null) break block5;
                    string = "air";
                    break block6;
                }
                k = k2;
            }
            string = occ0b63c0426.\u0184(k.toString());
        }
        return string;
    }

    private static String \u0184(String string) {
        String string2;
        block15: {
            String string3;
            String string4;
            block13: {
                int n;
                block14: {
                    String string5;
                    block11: {
                        block12: {
                            n = \u039f;
                            string5 = string;
                            if (n != 0) break block11;
                            if (string5 != null) break block12;
                            return null;
                        }
                        string5 = string;
                    }
                    int n2 = string5.indexOf(0xF47AC402 ^ 0xF47AC438);
                    String string6 = n2 >= 0 ? string.substring(n2 + 1) : string;
                    string4 = string6;
                    string2 = string4;
                    string3 = "tile.";
                    if (n != 0) break block13;
                    if (!string2.startsWith(string3)) break block14;
                    string4 = string4.substring(0xF47AC43D ^ 0xF47AC438);
                }
                string2 = string4;
                if (n != 0) break block15;
                string3 = "item.";
            }
            if (string2.startsWith(string3)) {
                string4 = string4.substring(0xF47AC43D ^ 0xF47AC438);
            }
            string2 = string4;
        }
        return string2;
    }

    private static String \u03bb(String string) {
        String string2;
        block6: {
            String string3;
            block4: {
                block5: {
                    int n = \u039f;
                    string3 = string;
                    if (n != 0) break block4;
                    if (string3 != null) break block5;
                    string2 = null;
                    break block6;
                }
                string3 = string;
            }
            string2 = string3.replace((char)(0xD6B28C85 ^ 0xD6B28CA3), (char)(0xD6B28C04 ^ 0xD6B28CA3));
        }
        return string2;
    }
}

