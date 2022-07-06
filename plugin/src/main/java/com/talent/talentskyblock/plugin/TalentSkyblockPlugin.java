package com.talent.talentskyblock.plugin;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.talent.talentskyblock.api.Provider;
import com.talent.talentskyblock.api.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TalentSkyblockPlugin extends JavaPlugin implements Skyblock {

  @Override
  public void onEnable() {
    Provider.skyblock(this);
    SlimePlugin plugin = (SlimePlugin) Bukkit.getPluginManager().getPlugin("SlimeWorldManager");

  }

  @Override
  public void onDisable() {

  }
}
