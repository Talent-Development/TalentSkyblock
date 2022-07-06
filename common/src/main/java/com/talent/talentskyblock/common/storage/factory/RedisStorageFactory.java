package com.talent.talentskyblock.common.storage.factory;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;
import com.talent.talentskyblock.common.storage.Storage;
import com.talent.talentskyblock.common.storage.StorageFactory;
import com.talent.talentskyblock.common.storage.storages.RedisStorage;
import com.talent.talentskyblock.common.util.Assert;

import java.util.Map;

/**
 * @author Furkan Doğan
 */
public class RedisStorageFactory implements StorageFactory {

  @Override
  public Storage build(Map<String, Object> options) {
    this.checkPreconditions(options);

    String connectionString = this.buildConnectionString(options);
    RedisURI redisURI = RedisURI.create(connectionString);
    RedisClient redisClient = new RedisClient(redisURI);
    RedisConnection<String, String> redisConnection = redisClient.connect();

    return new RedisStorage(redisClient, redisConnection);
  }

  private String buildConnectionString(Map<String, Object> map) {
    String host = (String) map.get("host");
    String port = String.valueOf(map.get("port"));
    boolean useSSL = Boolean.parseBoolean(String.valueOf(map.get("useSSL")));
    String password = (String) map.getOrDefault("password", "");

    return String.format("redis%s://%s%s:%s", useSSL ? "s" : "", password == null || password.isBlank() ? "" : String.format("%s@", password), host, port);
  }

  private void checkPreconditions(Map<String, Object> map) {
    Assert.keyNotNull(map, "host", "Host cannot be null");
    Assert.valueNotBlank(map, "host", "Host cannot be blank");
    Assert.keyNotNull(map, "port", "Port cannot be null");
    Assert.valueNotBlank(map, "port", "Port cannot be blank");
  }
}
