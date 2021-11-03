package com.movie;

import static com.movie.Constants.ADD_MOVIE_SQL;
import static com.movie.Constants.CREATE_TABLE_SQL;
import static com.movie.Constants.DB_PASSWORD;
import static com.movie.Constants.DB_URI;
import static com.movie.Constants.DB_USER;
import static com.movie.Constants.DRIVER_CLASS_MYSQL;
import static com.movie.Constants.GET_MOVIES_SQL;
import static com.movie.Constants.GET_MOVIES_WHERE_LIKE_SQL;
import static com.movie.Constants.GET_MOVIES_WHERE_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

public class MovieDbOps {

  public MovieDbOps() throws SQLException {
    loadClass(DRIVER_CLASS_MYSQL);
  }

  public void createTable() throws SQLException {
    try (Connection conn = getConnection()) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(CREATE_TABLE_SQL);
      }
    }
  }

  public void addMovie(Movie movie) throws SQLException {
    try (Connection conn = getConnection()) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(
            String.format(
                ADD_MOVIE_SQL,
                movie.getName(),
                movie.getLeadActor(),
                movie.getLeadActress(),
                movie.getYear(),
                movie.getDirector()));
      }
    }
  }

  public List<Movie> getAllMovies() throws SQLException {
    List<Movie> allMovies = new ArrayList<>();
    try (Connection conn = getConnection()) {
      try (Statement stmt = conn.createStatement();
          ResultSet resultSet = stmt.executeQuery(GET_MOVIES_SQL)) {

        while (resultSet.next()) {
          allMovies.add(
              new Movie(
                  (String) resultSet.getObject(2),
                  (String) resultSet.getObject(3),
                  (String) resultSet.getObject(4),
                  (int) resultSet.getObject(5),
                  (String) resultSet.getObject(6)));
        }
      }
    }
    return allMovies;
  }

  public List<Movie> getAllMoviesWithActor(String actor) throws SQLException {
    return getAllMoviesWithFilter(Pair.with("lead_actor", actor));
  }

  public List<Movie> getAllMoviesWithActress(String actress) throws SQLException {
    return getAllMoviesWithFilter(Pair.with("lead_actress", actress));
  }

  public List<Movie> getAllMoviesFromYear(int year) throws SQLException {
    return getAllMoviesWithFilter(Pair.with("year", year));
  }

  private List<Movie> getAllMoviesWithFilter(Pair<String, Object> filter) throws SQLException {
    List<Movie> allMovies = new ArrayList<>();
    String key = filter.getValue0();
    Object value = filter.getValue1();

    try (Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet =
            stmt.executeQuery(
                String.format(
                    value instanceof String ? GET_MOVIES_WHERE_LIKE_SQL : GET_MOVIES_WHERE_SQL,
                    key,
                    value))) {

      while (resultSet.next()) {
        allMovies.add(
            new Movie(
                (String) resultSet.getObject(2),
                (String) resultSet.getObject(3),
                (String) resultSet.getObject(4),
                (int) resultSet.getObject(5),
                (String) resultSet.getObject(6)));
      }
    }
    return allMovies;
  }

  private void loadClass(String driverClass) {
    try {
      Class.forName(driverClass);
    } catch (ClassNotFoundException ex) {
      System.out.println("Class Not Found: " + driverClass);
      throw new IllegalStateException("Class not Found", ex);
    }
  }

  private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(DB_URI, DB_USER, DB_PASSWORD);
  }
}
