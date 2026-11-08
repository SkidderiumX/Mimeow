/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import keystrokesmod.script.model.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;

public class ClientEntityManager {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final Map<net.minecraft.entity.Entity, ClientEntity> clientEntities = new IdentityHashMap<net.minecraft.entity.Entity, ClientEntity>();
    private static final Map<String, String> aliases = new HashMap<String, String>();
    private static int nextEntityId = -1;

    private ClientEntityManager() {
    }

    public static Entity spawnMob(String string, double d, double d2, double d3) {
        return ClientEntityManager.callOnClientThread(() -> ClientEntityManager.spawnMobNow(string, d, d2, d3), null);
    }

    public static boolean removeClientEntity(Entity entity) {
        return ClientEntityManager.callOnClientThread(() -> ClientEntityManager.removeClientEntityNow(entity), false);
    }

    public static void clearClientEntities() {
        ClientEntityManager.callOnClientThread(() -> {
            ClientEntityManager.clearClientEntitiesNow();
            return true;
        }, false);
    }

    private static Entity spawnMobNow(String string, double d, double d2, double d3) {
        WorldClient worldClient = ClientEntityManager.mc.theWorld;
        String string2 = ClientEntityManager.resolveEntityName(string);
        if (worldClient == null || string2 == null) {
            return null;
        }
        net.minecraft.entity.Entity entity = EntityList.createEntityByName(string2, worldClient);
        if (!(entity instanceof EntityLivingBase)) {
            return null;
        }
        int n = ClientEntityManager.allocateEntityId(worldClient);
        entity.setPositionAndRotation(d, d2, d3, 0.0f, 0.0f);
        worldClient.addEntityToWorld(n, entity);
        clientEntities.put(entity, new ClientEntity(worldClient, entity, n));
        return Entity.convert(entity);
    }

    private static boolean removeClientEntityNow(Entity entity) {
        if (entity == null || entity.entity == null) {
            return false;
        }
        ClientEntity clientEntity = clientEntities.remove(entity.entity);
        if (clientEntity == null) {
            return false;
        }
        ClientEntityManager.removeFromWorld(clientEntity);
        return true;
    }

    private static void clearClientEntitiesNow() {
        ArrayList<ClientEntity> arrayList = new ArrayList<ClientEntity>(clientEntities.values());
        clientEntities.clear();
        for (ClientEntity clientEntity : arrayList) {
            ClientEntityManager.removeFromWorld(clientEntity);
        }
        nextEntityId = -1;
    }

    private static void removeFromWorld(ClientEntity clientEntity) {
        if (clientEntity.world.getEntityByID(clientEntity.entityId) == clientEntity.entity) {
            clientEntity.world.removeEntityFromWorld(clientEntity.entityId);
        } else if (clientEntity.world.loadedEntityList.contains(clientEntity.entity)) {
            clientEntity.world.removeEntity(clientEntity.entity);
        }
    }

    private static int allocateEntityId(WorldClient worldClient) {
        while (worldClient.getEntityByID(nextEntityId) != null) {
            ClientEntityManager.decrementEntityId();
        }
        int n = nextEntityId;
        ClientEntityManager.decrementEntityId();
        return n;
    }

    private static void decrementEntityId() {
        nextEntityId = nextEntityId == (0x9835D0DA ^ 0x1835D0DA) ? -1 : nextEntityId - 1;
    }

    private static String resolveEntityName(String string) {
        if (string == null || string.trim().isEmpty()) {
            return null;
        }
        String string2 = ClientEntityManager.normalize(string);
        String string3 = aliases.get(string2);
        if (string3 != null) {
            return string3;
        }
        for (String string4 : EntityList.getEntityNameList()) {
            if (!ClientEntityManager.normalize(string4).equals(string2)) continue;
            return string4;
        }
        return null;
    }

    private static String normalize(String string) {
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.startsWith("minecraft:")) {
            string2 = string2.substring("minecraft:".length());
        }
        return string2.replace("_", "").replace("-", "").replace(" ", "");
    }

    private static <T> T callOnClientThread(Callable<T> callable, T t) {
        try {
            if (mc.isCallingFromMinecraftThread()) {
                return callable.call();
            }
            return (T)mc.addScheduledTask(callable).get();
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return t;
        }
        catch (Exception exception) {
            return t;
        }
    }

    static {
        aliases.put("wither", "WitherBoss");
        aliases.put("irongolem", "VillagerGolem");
        aliases.put("snowgolem", "SnowMan");
        aliases.put("mooshroom", "MushroomCow");
        aliases.put("zombiepigman", "PigZombie");
        aliases.put("magmacube", "LavaSlime");
        aliases.put("ocelot", "Ozelot");
        aliases.put("horse", "EntityHorse");
    }

    private static final class ClientEntity {
        private final WorldClient world;
        private final net.minecraft.entity.Entity entity;
        private final int entityId;

        private ClientEntity(WorldClient worldClient, net.minecraft.entity.Entity entity, int n) {
            this.world = worldClient;
            this.entity = entity;
            this.entityId = n;
        }
    }
}

