package com.talent.talentskyblock.common.data;

import com.talent.talentskyblock.common.data.Store;

import java.util.Map;

public interface StoreFactory {

  Store build(Map<String, Object> options);
}
