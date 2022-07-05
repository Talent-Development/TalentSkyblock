package com.talent.talentskyblock.plugin;

import com.talent.talentskyblock.api.Provider;
import com.talent.talentskyblock.api.Skyblock;
import org.bukkit.plugin.java.JavaPlugin;

public class TalentSkyblockPlugin extends JavaPlugin implements Skyblock {

  @Override
  public void onEnable() {
    Provider.skyblock(this);
  }

  @Override
  public void onDisable() {

  }
}
