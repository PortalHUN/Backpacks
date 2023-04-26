package com.portalhun.backpacks.Models;

import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Backpack {
    public String ID;
    public List<Inventory> inv = new ArrayList<>();
    public Long Opened = new Date().getTime();
    public Backpack(){
        ID = UUID.randomUUID().toString();
    }
}
