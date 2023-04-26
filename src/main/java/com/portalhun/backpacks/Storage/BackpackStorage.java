package com.portalhun.backpacks.Storage;

import com.google.gson.Gson;
import com.portalhun.backpacks.Backpacks;
import com.portalhun.backpacks.Models.Backpack;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BackpackStorage {
  public static ArrayList<Backpack> bp = new ArrayList<>();

  public static void SaveBackpacks() throws IOException {
    Gson gson = new Gson();
    File file = new File(Backpacks.getPlugin().getDataFolder().getAbsolutePath()+"/backpacks.json");
    file.getParentFile().mkdir();
    file.createNewFile();
    Writer writer = new FileWriter(file);
    gson.toJson(bp, writer);
    writer.flush();
    writer.close();
    System.out.println("[Backpacks] Backpacks saved.");
  }

  public static void LoadBackpacks() throws IOException{
    Gson gson = new Gson();
    File file = new File(Backpacks.getPlugin().getDataFolder().getAbsolutePath()+"/backpacks.json");
    if(file.exists()){
      Reader reader = new FileReader(file);
      Backpack[] n = gson.fromJson(reader, Backpack[].class);
      bp = new ArrayList<>(Arrays.asList(n));
      System.out.println("[Backpacks] Backpacks loaded.");
    }
  }

  public static Backpack findBackpack(String UUID){
    for (Backpack b:bp) {
      if(b.ID.equalsIgnoreCase(UUID)) return b;
    }
    return null;
  }

  public static int findBackpackIndex(String UUID){
    for (int i =0 ;i<bp.size();i++){
      if(bp.get(i).ID.equalsIgnoreCase(UUID)){
        return i;
      }
    }
    return -1;
  }

  public static Backpack createBackpack(Backpack b) throws IOException {
    bp.add(b);
    SaveBackpacks();
    return b;
  }

  public static Backpack updateBackpack(Backpack b) throws IOException {
    int i = findBackpackIndex(b.ID);
    if(i != -1){
      bp.set(i, b);
      SaveBackpacks();
      return b;
    }else return null;
  }
}
