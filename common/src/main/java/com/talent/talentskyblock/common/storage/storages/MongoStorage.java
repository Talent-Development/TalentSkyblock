package com.talent.talentskyblock.common.storage.storages;

import com.mongodb.client.MongoClient;
import com.talent.talentskyblock.common.storage.Storage;
import com.talent.talentskyblock.common.util.Assert;
/**
 * @author Furkan Doğan
 */
@SuppressWarnings("SpellCheckingInspection")
public class MongoStorage implements Storage {

  private final MongoClient mongoClient;

  public MongoStorage(MongoClient mongoClient) {
    Assert.notNull(mongoClient, "Mongo client cannot be null");
    this.mongoClient = mongoClient;
  }

  @Override
  public void close() {
    this.mongoClient.close();
  }
}
