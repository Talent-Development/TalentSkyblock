package com.talent.talentskyblock.api;

import com.talent.talentskyblock.common.boostrap.SkyblockCommonBoostrap;
import com.talent.talentskyblock.common.storage.manager.StorageManager;
/**
 * @author BeyazPolis
 */
public interface SkyblockPlugin {
  /**
   * manager for manages stores.
   *
   * @return storage manager.
   */
  default StorageManager storageM(){
    return SkyblockCommonBoostrap.getBoostrap().getStorageManager();
  }



}
