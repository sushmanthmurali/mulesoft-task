package com.movie;

import java.sql.SQLException;

public class MovieDbOpsSingleton {
  private static MovieDbOps instance = null;

  public static MovieDbOps getInstance() throws SQLException {
    if (instance == null) {
      instance = new MovieDbOps();
    }
    return instance;
  }
}
