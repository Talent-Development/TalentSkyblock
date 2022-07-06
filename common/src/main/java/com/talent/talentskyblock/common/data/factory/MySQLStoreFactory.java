package com.talent.talentskyblock.common.data.factory;

import com.talent.talentskyblock.common.data.Store;
import com.talent.talentskyblock.common.data.StoreFactory;
import com.talent.talentskyblock.common.data.store.MySQLStore;
import com.talent.talentskyblock.common.util.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * @author Furkan Doğan
 */
public class MySQLStoreFactory implements StoreFactory {

  @Override
  public Store build(Map<String, Object> options) {
    this.checkPreconditions(options);

    try {
      String user = (String) options.get("user");
      String password = (String) options.getOrDefault("password", "");
      String connectionString = this.buildConnectionString(options);

      Class.forName("com.mysql.jdbc.Driver");
      Connection connection = DriverManager.getConnection(connectionString, user, password);

      return new MySQLStore(connection);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private String buildConnectionString(Map<String, Object> map) {
    String host = (String) map.get("host");
    String port = String.valueOf(map.get("port"));
    String database = (String) map.getOrDefault("database", "");

    return String.format("jdbc:mysql://%s:%s/%s", host, port, database);
  }

  private void checkPreconditions(Map<String, Object> map) {
    Assert.keyNotNull(map, "host", "Host cannot be null");
    Assert.valueNotBlank(map, "host", "Host cannot be blank");
    Assert.keyNotNull(map, "port", "Port cannot be null");
    Assert.valueNotBlank(map, "port", "Port cannot be blank");
    Assert.keyNotNull(map, "user", "User cannot be null");
    Assert.valueNotBlank(map, "user", "User cannot be blank");
  }
}
