package com.portalhun.backpacks;

import com.portalhun.backpacks.Events.OnPlayerAction;
import com.portalhun.backpacks.Models.Backpack;
import com.portalhun.backpacks.Storage.BackpackStorage;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Date;

public final class Backpacks extends JavaPlugin {

    private static Backpacks pl;
    @Override
    public void onEnable() {
        pl = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        //Events
        getServer().getPluginManager().registerEvents(new OnPlayerAction(this), this);

        //Commands



        try {
            BackpackStorage.LoadBackpacks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        try {
            BackpackStorage.SaveBackpacks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Backpacks getPlugin(){
        return pl;
    }
}
