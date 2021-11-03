package com.movie;

public class Constants {

  public static final String DRIVER_CLASS_MYSQL = "com.mysql.cj.jdbc.Driver";

  public static final String DB_HOST = "127.0.0.1";
  public static final String DB_PORT = "3306";
  public static final String DB_SCHEMA_NAME = "movies_db";
  public static final String DB_URI = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_SCHEMA_NAME;
  public static final String DB_USER = "root";
  public static final String DB_PASSWORD = "root";

  public static final String CREATE_TABLE_SQL = "CREATE TABLE movies (id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), lead_actor VARCHAR(255), lead_actress VARCHAR(255), year INT, director VARCHAR(255))";
  public static final String ADD_MOVIE_SQL = "INSERT INTO movies (name, lead_actor, lead_actress, year, director) values ('%s', '%s', '%s', '%s', '%s')";
  public static final String GET_MOVIES_SQL = "SELECT * FROM movies";
  public static final String GET_MOVIES_WHERE_SQL = "SELECT * FROM movies WHERE %s = '%s'";
  public static final String GET_MOVIES_WHERE_LIKE_SQL = "SELECT * FROM movies WHERE %s LIKE '%%%s%%'";

  private Constants() {
  }

}
