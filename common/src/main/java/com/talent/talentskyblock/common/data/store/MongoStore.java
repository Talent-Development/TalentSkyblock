package com.talent.talentskyblock.common.data.store;

import com.mongodb.client.MongoClient;
import com.talent.talentskyblock.common.data.Store;
import com.talent.talentskyblock.common.util.Assert;

/**
 * @author Furkan Doğan
 */
@SuppressWarnings("SpellCheckingInspection")
public class MongoStore implements Store {

  private final MongoClient mongoClient;

  public MongoStore(MongoClient mongoClient) {
    Assert.notNull(mongoClient, "Mongo client cannot be null");
    this.mongoClient = mongoClient;
  }

  @Override
  public void close() {
    this.mongoClient.close();
  }
}
