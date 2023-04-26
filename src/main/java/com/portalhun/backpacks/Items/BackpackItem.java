package com.portalhun.backpacks.Items;

import com.portalhun.backpacks.Backpacks;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BackpackItem {
  public static ItemStack get(Backpacks pl){
    ItemStack i = new ItemStack(Material.CHEST);
    ItemMeta m = i.getItemMeta();
    m.addEnchant(Enchantment.ARROW_DAMAGE,1, false);
    m.addEnchant(Enchantment.DAMAGE_ALL,1, false);
    m.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    m.setDisplayName(ChatColor.BLUE+"Backpack");
    i.setItemMeta(m);
    return i;
  }
 }
