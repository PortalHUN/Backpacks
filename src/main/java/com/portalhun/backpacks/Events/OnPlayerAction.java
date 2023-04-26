package com.portalhun.backpacks.Events;

import com.portalhun.backpacks.Backpacks;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnPlayerAction implements Listener {
  private final Backpacks pl;
  public OnPlayerAction(Backpacks pl){
    this.pl = pl;
  }
  @EventHandler
  public void onPlayerAction(PlayerInteractEvent e){

  }
}
