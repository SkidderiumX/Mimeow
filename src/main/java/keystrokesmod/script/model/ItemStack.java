/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ItemStack {
    public String type;
    public String name;
    public String displayName;
    public int stackSize;
    public int maxStackSize;
    public int durability;
    public int maxDurability;
    public boolean isBlock;
    public net.minecraft.item.ItemStack itemStack;
    public int meta;

    public ItemStack(net.minecraft.item.ItemStack itemStack, byte by) {
        if (itemStack == null) {
            return;
        }
        this.itemStack = itemStack;
        Item item = itemStack.getItem();
        if (item == null) {
            this.type = "air";
            this.name = "air";
            this.displayName = "air";
            this.itemStack = null;
            return;
        }
        this.isBlock = item instanceof ItemBlock;
        this.type = this.isBlock ? ((ItemBlock)item).getBlock().getClass().getSimpleName() : item.getClass().getSimpleName();
        String string = item.getRegistryName();
        this.name = string == null ? "unknown" : (string.startsWith("minecraft:") ? string.substring(0x6BFB1451 ^ 0x6BFB145B) : string.toString());
        this.displayName = itemStack.getDisplayName();
        this.stackSize = itemStack.stackSize;
        this.maxStackSize = itemStack.getMaxStackSize();
        this.durability = itemStack.getMaxDamage() - itemStack.getItemDamage();
        this.maxDurability = itemStack.getMaxDamage();
        this.meta = itemStack.getMetadata();
    }

    public ItemStack(String string) {
        this(ItemStack.withMeta(string), 0);
    }

    private static net.minecraft.item.ItemStack withMeta(String string) {
        String[] stringArray = string.split(":");
        String string2 = stringArray[0];
        int n = 0;
        if (stringArray.length > 1) {
            n = ItemStack.parseMeta(stringArray[1]);
        }
        Item item = Item.itemRegistry.getObject(new ResourceLocation("minecraft:" + string2));
        return new net.minecraft.item.ItemStack(item, 1, n);
    }

    private static int parseMeta(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    public List<String> getTooltip() {
        if (this.itemStack == null) {
            return new ArrayList<String>();
        }
        return this.itemStack.getTooltip(Minecraft.getMinecraft().thePlayer, true);
    }

    public List<Object[]> getEnchantments() {
        if (this.itemStack == null) {
            return null;
        }
        Map<Integer, Integer> map = EnchantmentHelper.getEnchantments(this.itemStack);
        if (map.isEmpty()) {
            return null;
        }
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Enchantment enchantment = Enchantment.getEnchantmentById(entry.getKey());
            String string = StatCollector.translateToFallback(enchantment.getName()).toLowerCase().replace(" ", "_");
            Object[] objectArray = new Object[0x63CD3B8F ^ 0x63CD3B8D];
            objectArray[0] = string;
            objectArray[1] = entry.getValue();
            arrayList.add(objectArray);
        }
        return arrayList;
    }

    public static ItemStack convert(net.minecraft.item.ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        return new ItemStack(itemStack, 0);
    }

    public String toString() {
        return "ItemStack(" + this.type + "," + this.name + ")";
    }
}

