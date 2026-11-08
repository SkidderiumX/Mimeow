/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.GameProfile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S18PacketEntityTeleport;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.world.World;
import x.oc2cf3d80e17;
import x.oc46245c2b20;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc79b0d8811c;
import x.oc7ab2161b9f;
import x.oc89eb238246;
import x.oc9f46b676cd;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.ocdbf1bb859b;
import x.oce4cea752dd;
import x.oce79181588d;

public class oca74a5ae28a
extends oc69da1aa7f5 {
    private static final String[] n;
    private static final Set<String> \u00d9;
    private static final Set<String> \u01c9;
    public final oca9cc61aada \u0526 = new oca9cc61aada("Mode", 0, n);
    public final occ2f8dff8d8 \u0464 = new occ2f8dff8d8("Ghost Detect", true);
    public final occ2f8dff8d8 \u00f8 = new occ2f8dff8d8("Auto Leave", false);
    private final Set<Integer> \u0267 = new HashSet<Integer>();
    private final Set<Integer> \u0257 = new HashSet<Integer>();
    private final Set<UUID> \u01d6 = new HashSet<UUID>();
    private final Map<UUID, String> \u0144 = new HashMap<UUID, String>();
    public static int l;

    public oca74a5ae28a() {
        super("AntiStaff", oce4cea752dd.\u04a6);
        this.\u0105("Detects possible staff activity and can leave the server.");
        this.\u028c(this.\u0526);
        this.\u028c(this.\u0464);
        this.\u028c(this.\u00f8);
    }

    @Override
    public void onEnable() {
        block16: {
            Minecraft minecraft;
            int n;
            block17: {
                block15: {
                    this.\u013a();
                    n = oc89eb238246.\u0127;
                    minecraft = oc69da1aa7f5.\u0151;
                    if (n != 0) break block15;
                    if (minecraft == null) break block16;
                    minecraft = oc69da1aa7f5.\u0151;
                }
                if (n != 0) break block17;
                if (minecraft.getNetHandler() == null) break block16;
                minecraft = oc69da1aa7f5.\u0151;
            }
            for (NetworkPlayerInfo networkPlayerInfo : minecraft.getNetHandler().getPlayerInfoMap()) {
                block19: {
                    Object object;
                    GameProfile gameProfile;
                    block18: {
                        gameProfile = networkPlayerInfo.getGameProfile();
                        object = gameProfile;
                        if (n != 0) break block18;
                        if (((GameProfile)object).getId() == null) break block19;
                        object = gameProfile;
                    }
                    if (n != 0 || ((GameProfile)object).getName() == null) break block19;
                    object = this.\u0144.put(gameProfile.getId(), gameProfile.getName());
                }
                if (n == 0) continue;
            }
        }
    }

    @Override
    public void onDisable() {
        this.\u013a();
    }

    @Override
    public String getInfo() {
        return n[(int)this.\u0526.\u04c1()];
    }

    @oc66fa4f2195
    public void \u0251(oc79b0d8811c oc79b0d8811c2) {
        this.\u013a();
    }

    @oc66fa4f2195
    public void \u0159(ocdbf1bb859b ocdbf1bb859b2) {
        this.\u013a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0210(oce79181588d oce79181588d2) {
        Packet<?> packet;
        int n = oc89eb238246.\u0127;
        if (!this.z$3rzb3dil7uydr()) return;
        if (oc69da1aa7f5.\u0151 == null) {
            return;
        }
        Packet<?> packet2 = packet = oce79181588d2.\u04a0();
        if (n == 0) {
            if (packet2 instanceof S38PacketPlayerListItem) {
                this.\u0106((S38PacketPlayerListItem)packet);
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (n == 0) {
            if (packet2 instanceof S0CPacketSpawnPlayer) {
                this.\u0267.add(((S0CPacketSpawnPlayer)packet).getEntityID());
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (n == 0) {
            if (packet2 instanceof S13PacketDestroyEntities) {
                for (int n2 : ((S13PacketDestroyEntities)packet).getEntityIDs()) {
                    this.\u0267.remove(n2);
                    if (n != 0) return;
                    this.\u0257.remove(n2);
                    if (n == 0) continue;
                }
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (n == 0) {
            if (packet2 instanceof S14PacketEntity) {
                this.\u01fe(((S14PacketEntity)packet).getEntityId());
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (!(packet2 instanceof S18PacketEntityTeleport)) return;
        this.\u01fe(((S18PacketEntityTeleport)packet).getEntityId());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0106(S38PacketPlayerListItem s38PacketPlayerListItem) {
        NetHandlerPlayClient netHandlerPlayClient = oc69da1aa7f5.\u0151.getNetHandler();
        Iterator<S38PacketPlayerListItem.AddPlayerData> iterator2 = s38PacketPlayerListItem.getEntries().iterator();
        int n = oc89eb238246.\u0127;
        while (iterator2.hasNext()) {
            int n2;
            block35: {
                oca74a5ae28a oca74a5ae28a2;
                block36: {
                    UUID uUID;
                    S38PacketPlayerListItem.AddPlayerData addPlayerData;
                    S38PacketPlayerListItem.AddPlayerData addPlayerData2 = addPlayerData = iterator2.next();
                    if (n == 0) {
                        if (addPlayerData2 == null) continue;
                        addPlayerData2 = addPlayerData;
                    }
                    if (n == 0) {
                        if (addPlayerData2.getProfile() == null && n == 0) continue;
                        addPlayerData2 = addPlayerData;
                    }
                    if ((uUID = addPlayerData2.getProfile().getId()) == null || oc69da1aa7f5.\u0151.thePlayer != null && uUID.equals(oc69da1aa7f5.\u0151.thePlayer.getUniqueID()) && n == 0) continue;
                    String string = this.\u0276(addPlayerData.getProfile(), netHandlerPlayClient);
                    n2 = oc9f46b676cd.\u0414[s38PacketPlayerListItem.getAction().ordinal()];
                    if (n != 0) break block35;
                    switch (n2) {
                        case 1: {
                            String string2 = string;
                            if (n == 0 && string2 != null) {
                                string2 = this.\u0144.put(uUID, string);
                            }
                            this.\u01d6.remove(uUID);
                            oca74a5ae28a2 = this;
                            if (n == 0) {
                                if (!oca74a5ae28a2.\u01af(string)) break;
                                this.\u02b4(0x199CC90 ^ 0x199CC93, "Staff Online!", string + " joined the server", "&c&l[STAFF] &r&f" + string + " &ajoined the server!");
                                this.\u00f0();
                                if (n == 0) break;
                            }
                            break block36;
                        }
                        case 2: {
                            String string3 = string;
                            if (n == 0 && string3 != null) {
                                string3 = this.\u0144.put(uUID, string);
                            }
                            oca74a5ae28a2 = this;
                            if (n == 0) {
                                if (!oca74a5ae28a2.\u01af(string)) break;
                                this.\u02b4(0, "Staff Left", string + " left the server", "&a[STAFF] &f" + string + " &cleft the server.");
                                if (n == 0) break;
                            }
                            break block36;
                        }
                        case 3: 
                        case 4: 
                        case 5: {
                            oca74a5ae28a2 = this;
                            if (n != 0) break block36;
                            if (!oca74a5ae28a2.\u00f9()) break;
                            NetHandlerPlayClient netHandlerPlayClient2 = netHandlerPlayClient;
                            if (n == 0) {
                                if (netHandlerPlayClient2 == null) break;
                                netHandlerPlayClient2 = netHandlerPlayClient;
                            }
                            if (netHandlerPlayClient2.getPlayerInfo(uUID) != null) break;
                            this.\u03d9(uUID, string, "received a player update while hidden");
                        }
                    }
                    oca74a5ae28a2 = this;
                }
                n2 = oca74a5ae28a2.z$3rzb3dil7uydr() ? 1 : 0;
            }
            if (n2 == 0) {
                return;
            }
            if (n == 0) continue;
        }
    }

    private boolean \u00f9() {
        int n;
        block4: {
            block5: {
                int n2 = oc89eb238246.\u0127;
                n = (int)this.\u0526.\u04c1();
                if (n2 != 0) break block4;
                if (n != 1) break block5;
                n = 1;
                break block4;
            }
            n = 0;
        }
        return n != 0;
    }

    private boolean \u01af(String string) {
        oca74a5ae28a oca74a5ae28a2;
        block9: {
            block10: {
                block8: {
                    int n = oc89eb238246.\u0127;
                    if (string == null) break block8;
                    oca74a5ae28a2 = this;
                    if (n != 0) break block9;
                    if (!oca74a5ae28a2.\u00f9()) break block10;
                }
                return false;
            }
            oca74a5ae28a2 = this;
        }
        Set<String> set = (int)oca74a5ae28a2.\u0526.\u04c1() == (0xA11BB27F ^ 0xA11BB27D) ? \u01c9 : \u00d9;
        Set<String> set2 = set;
        return set2.contains(string.toLowerCase(Locale.ROOT));
    }

    private String \u0276(GameProfile gameProfile, NetHandlerPlayClient netHandlerPlayClient) {
        Object object;
        block25: {
            block26: {
                Object object2;
                int n;
                block22: {
                    GameProfile gameProfile2;
                    block24: {
                        NetworkPlayerInfo networkPlayerInfo;
                        block23: {
                            NetHandlerPlayClient netHandlerPlayClient2;
                            block21: {
                                block20: {
                                    GameProfile gameProfile3;
                                    block19: {
                                        n = oc89eb238246.\u0127;
                                        gameProfile3 = gameProfile;
                                        if (n != 0) break block19;
                                        if (gameProfile3.getName() == null) break block20;
                                        gameProfile3 = gameProfile;
                                    }
                                    return gameProfile3.getName();
                                }
                                netHandlerPlayClient2 = netHandlerPlayClient;
                                if (n != 0) break block21;
                                if (netHandlerPlayClient2 == null) break block22;
                                netHandlerPlayClient2 = netHandlerPlayClient;
                            }
                            object2 = netHandlerPlayClient2.getPlayerInfo(gameProfile.getId());
                            networkPlayerInfo = object2;
                            if (n != 0) break block23;
                            if (networkPlayerInfo == null) break block22;
                            networkPlayerInfo = object2;
                        }
                        gameProfile2 = networkPlayerInfo.getGameProfile();
                        if (n != 0) break block24;
                        if (gameProfile2.getName() == null) break block22;
                        gameProfile2 = ((NetworkPlayerInfo)object2).getGameProfile();
                    }
                    return gameProfile2.getName();
                }
                object = oc69da1aa7f5.\u0151;
                if (n != 0) break block25;
                if (((Minecraft)object).theWorld == null) break block26;
                object = oc69da1aa7f5.\u0151.theWorld;
                if (n != 0) break block25;
                object2 = ((World)object).getPlayerEntityByUUID(gameProfile.getId());
                if (object2 != null) {
                    return ((EntityPlayer)object2).getGameProfile().getName();
                }
            }
            object = this.\u0144.get(gameProfile.getId());
        }
        return (String)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void \u01fe(int n) {
        oca74a5ae28a oca74a5ae28a2;
        block36: {
            int n2;
            Set<Integer> set;
            block35: {
                oca74a5ae28a oca74a5ae28a3;
                int n3;
                block34: {
                    block31: {
                        Minecraft minecraft;
                        block30: {
                            n3 = oc89eb238246.\u0127;
                            minecraft = oc69da1aa7f5.\u0151;
                            if (n3 != 0) break block30;
                            if (minecraft.theWorld == null) return;
                            minecraft = oc69da1aa7f5.\u0151;
                        }
                        if (minecraft.thePlayer != null && n != oc69da1aa7f5.\u0151.thePlayer.getEntityId()) break block31;
                        return;
                    }
                    Entity entity = oc69da1aa7f5.\u0151.theWorld.getEntityByID(n);
                    if (entity != null) {
                        NetHandlerPlayClient netHandlerPlayClient;
                        block33: {
                            boolean bl;
                            NetHandlerPlayClient netHandlerPlayClient2;
                            block32: {
                                netHandlerPlayClient2 = oc69da1aa7f5.\u0151.getNetHandler();
                                bl = this.\u00f9();
                                if (n3 != 0) break block32;
                                if (!bl) return;
                                bl = entity instanceof EntityPlayer;
                            }
                            if (!bl) return;
                            netHandlerPlayClient = netHandlerPlayClient2;
                            if (n3 != 0) break block33;
                            if (netHandlerPlayClient == null) return;
                            netHandlerPlayClient = netHandlerPlayClient2;
                        }
                        if (netHandlerPlayClient.getPlayerInfo(entity.getUniqueID()) != null) return;
                        EntityPlayer entityPlayer = (EntityPlayer)entity;
                        this.\u03d9(entityPlayer.getUniqueID(), entityPlayer.getGameProfile().getName(), "moved while hidden from the player list");
                        return;
                    }
                    oca74a5ae28a3 = this;
                    if (n3 != 0) break block34;
                    if (!oca74a5ae28a3.\u0464.\u01ed()) return;
                    oca74a5ae28a3 = this;
                }
                set = oca74a5ae28a3.\u0267;
                n2 = n;
                if (n3 != 0) break block35;
                if (set.contains(n2)) return;
                oca74a5ae28a2 = this;
                if (n3 != 0) break block36;
                set = oca74a5ae28a2.\u0257;
                n2 = n;
            }
            if (!set.add(n2)) {
                return;
            }
            this.\u02b4(0x1AC8B781 ^ 0x1AC8B782, "Ghost Entity!", "Vanish detected (ID: " + n + ")", "&c&l[GHOST] &r&fVanish entity detected &7(ID: " + n + ")");
            oca74a5ae28a2 = this;
        }
        oca74a5ae28a2.\u00f0();
    }

    private void \u03d9(UUID uUID, String string, String string2) {
        String string3;
        block7: {
            block8: {
                int n = oc89eb238246.\u0127;
                if (!this.\u01d6.add(uUID)) {
                    return;
                }
                string3 = string;
                if (n != 0) break block7;
                if (string3 != null) break block8;
                string3 = uUID.toString().substring(0, 0xE64C7A15 ^ 0xE64C7A1D);
                break block7;
            }
            string3 = string;
        }
        String string4 = string3;
        this.\u02b4(0xE64C7A1E ^ 0xE64C7A1D, "Vanish Detected!", string4 + " " + string2, "&c&l[VANISH] &r&f" + string4 + " &c" + string2 + "!");
        this.\u00f0();
    }

    private void \u02b4(int n, String string, String string2, String string3) {
        block3: {
            oc46245c2b20 oc46245c2b202;
            block2: {
                int n2 = oc89eb238246.\u0127;
                oc46245c2b202 = oc2cf3d80e17.\u02e1;
                if (n2 != 0) break block2;
                if (oc46245c2b202 == null) break block3;
                oc46245c2b202 = oc2cf3d80e17.\u02e1;
            }
            oc46245c2b202.\u04e2(string + ": " + string2, "Staff", n);
        }
        oc7ab2161b9f.\u00fd(string3);
    }

    private void \u00f0() {
        block6: {
            Minecraft minecraft;
            block7: {
                int n = oc89eb238246.\u0127;
                if (!this.\u00f8.\u01ed()) break block6;
                minecraft = oc69da1aa7f5.\u0151;
                if (n != 0) break block7;
                if (minecraft.thePlayer == null) break block6;
                minecraft = oc69da1aa7f5.\u0151;
            }
            minecraft.thePlayer.sendChatMessage("/hub");
            this.z$1ca1cmv0s357();
        }
    }

    private void \u013a() {
        this.\u0267.clear();
        this.\u0257.clear();
        this.\u01d6.clear();
        this.\u0144.clear();
    }

    static {
        String[] stringArray = new String[0xB4865B4A ^ 0xB4865B49];
        stringArray[0] = "3FMC";
        stringArray[1] = "General";
        stringArray[0xB4865B4B ^ 0xB4865B49] = "LuckyVN";
        n = stringArray;
        \u00d9 = Set.of("vinghgaming", "cheesethesylveon", "thanhhau", "sennekoi", "lasgana", "novapev4", "khoaho01623");
        \u01c9 = Set.of("minh_dat", "appledepzai");
    }
}

