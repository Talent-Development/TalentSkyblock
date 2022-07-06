package com.talent.talentskyblock.common.storage.manager;

import com.talent.talentskyblock.common.storage.Storage;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;
/**
 * @author BeyazPolis
 */
public class StorageManager {

  @NotNull
  private final ConcurrentMap<String, Storage> stores;

  public StorageManager(){
    this.stores = new ConcurrentHashMap<>();
  }

  public Optional<Storage> storage(@NotNull final String name){
    return Optional.ofNullable(stores.get(name));
  }

  public void add(@NotNull final String name,@NotNull final Storage store){
    this.stores.putIfAbsent(name,store);
  }

  public void remove(@NotNull final String name){
    this.stores.remove(name);
  }

}
