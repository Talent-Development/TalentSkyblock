package com.talent.talentskyblock.common.data;

import java.util.Map;

public interface StoreFactory {

  Store build(Map<String, Object> options);
}
