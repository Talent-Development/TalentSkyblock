package com.talent.talentskyblock.common.data.store;

import com.talent.talentskyblock.common.data.Store;
import com.talent.talentskyblock.common.util.Assert;

import java.sql.Connection;
import java.util.Map;

/**
 * @author Furkan Doğan
 */
public class MySQLStore implements Store {

  private final Connection connection;

  public MySQLStore(Connection connection) {
    Assert.notNull(connection, "Connection cannot be null");
    this.connection = connection;
  }

  @Override
  public void close() {

  }
}
