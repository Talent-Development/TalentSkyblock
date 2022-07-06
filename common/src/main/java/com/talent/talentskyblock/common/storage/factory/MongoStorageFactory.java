package com.talent.talentskyblock.common.storage.factory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.talent.talentskyblock.common.storage.storages.MongoStorage;
import com.talent.talentskyblock.common.storage.Storage;
import com.talent.talentskyblock.common.storage.StorageFactory;
import com.talent.talentskyblock.common.util.Assert;

import java.util.Map;
/**
 * @author Furkan Doğan
 */
@SuppressWarnings("SpellCheckingInspection")
public class MongoStorageFactory implements StorageFactory {

  @Override
  public Storage build(Map<String, Object> options) {
    this.checkPreconditions(options);

    String connectionString = this.buildConnectionString(options);
    MongoClient mongoClient = MongoClients.create(connectionString);

    return new MongoStorage(mongoClient);
  }

  private String buildConnectionString(Map<String, Object> options) {
    String protocol = (String) options.get("protocol");
    String user = (String) options.get("user");
    String password = (String) options.get("password");
    String host = (String) options.get("host");
    String port = String.valueOf(options.get("port"));
    String database = (String) options.getOrDefault("database", "");
    String connectionOptions = (String) options.get("connectionOptions");

    return String.format("%s://%s%s@%s:%s/%s%s",
      protocol,
      user,
      password == null || password.isBlank() ? "" : String.format(":%s", password),
      host,
      port,
      database,
      connectionOptions == null || connectionOptions.isBlank() ? "" : String.format("?%s", connectionOptions));
  }

  private void checkPreconditions(Map<String, Object> map) {
    Assert.keyNotNull(map, "protocol", "Protocol cannot be null");
    Assert.valueNotBlank(map, "protocol", "Protocol cannot be blank");
    Assert.keyNotNull(map, "user", "User cannot be null");
    Assert.valueNotBlank(map, "user", "User cannot be blank");
    Assert.keyNotNull(map, "host", "Host cannot be null");
    Assert.valueNotBlank(map, "host", "Host cannot be blank");
    Assert.keyNotNull(map, "port", "Port cannot be null");
    Assert.valueNotBlank(map, "port", "Port cannot be blank");
  }
}
