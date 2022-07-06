package com.talent.talentskyblock.common.storage;

import java.util.Map;
/**
 * @author Furkan Doğan
 */
public interface StorageFactory {

  Storage build(Map<String, Object> options);
}
