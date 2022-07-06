package com.talent.talentskyblock.plugin;

import com.talent.talentskyblock.api.Provider;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockBukkit extends JavaPlugin {

  @Override
  public void onEnable() {
    Provider.skyblock(new SkyblockPluginBukkit());
  }

  @Override
  public void onDisable() {

  }

}
