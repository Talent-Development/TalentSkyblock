package com.talent.talentskyblock.common.storage.storages;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.talent.talentskyblock.common.storage.Storage;
import com.talent.talentskyblock.common.util.Assert;

/**
 * @author Furkan Doğan
 */
public class RedisStorage implements Storage {

  private final RedisClient redisClient;
  private final RedisConnection<String, String> redisConnection;

  public RedisStorage(RedisClient redisClient,
                      RedisConnection<String, String> redisConnection) {
    Assert.notNull(redisClient, "Redis Client cannot be null");
    Assert.notNull(redisConnection, "Redis Connection cannot be null");
    this.redisClient = redisClient;
    this.redisConnection = redisConnection;
  }

  @Override
  public void close() {
    this.redisConnection.close();
    this.redisClient.shutdown();
  }
}
