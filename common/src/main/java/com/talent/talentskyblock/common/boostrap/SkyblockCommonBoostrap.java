package com.talent.talentskyblock.common.boostrap;

import com.talent.talentskyblock.common.storage.manager.StorageManager;
import lombok.Getter;

public class SkyblockCommonBoostrap {

  @Getter
  private final static SkyblockCommonBoostrap boostrap;

  @Getter
  private final StorageManager storageManager;

  public SkyblockCommonBoostrap(){
    this.storageManager = new StorageManager();
  }

  static {
    boostrap = new SkyblockCommonBoostrap();
  }

}
