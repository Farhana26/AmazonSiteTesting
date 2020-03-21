package com.pru.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

  private static final String DB_NAME = "test";
  private static final String DB_USERNAME = "root";
  private static final String DB_PASSWORD = "aroni156";

  private final Connection connection;

  private static DatabaseConnection sDatabaseConnection = null;

  private DatabaseConnection() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_USERNAME, DB_PASSWORD);

  }

  public List<String> getItems() throws ClassNotFoundException, SQLException {
    final List<String> items = new ArrayList<>();

    Statement stm = connection.createStatement();
    ResultSet result = stm.executeQuery("select itemname from items");
    while (result.next()) {
      items.add(result.getString("itemname"));
    }
    stm.close();

    return items;
  }

  public static DatabaseConnection getDatabaseConnection() throws SQLException, ClassNotFoundException {
    if (sDatabaseConnection == null) {
      sDatabaseConnection = new DatabaseConnection();
    }
    return sDatabaseConnection;
  }
}
