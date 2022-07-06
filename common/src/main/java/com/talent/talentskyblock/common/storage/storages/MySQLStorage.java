package com.talent.talentskyblock.common.storage.storages;

import com.talent.talentskyblock.common.storage.Storage;
import com.talent.talentskyblock.common.util.Assert;

import java.sql.Connection;
import java.util.Map;

/**
 * @author Furkan Doğan
 */
public class MySQLStorage implements Storage {

  private final Connection connection;

  public MySQLStorage(Connection connection) {
    Assert.notNull(connection, "Connection cannot be null");
    this.connection = connection;
  }

  @Override
  public void close() throws Exception {
    this.connection.close();
  }
}
