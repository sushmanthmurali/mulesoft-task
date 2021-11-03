package com.movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MovieMain {

  public static void main(String[] args) throws SQLException {
    Scanner scan = new Scanner(System.in);
    int code = 0;
    do {
      System.out.println("\n\nChoose one of the following options:");
      System.out.println("1: Create 'movies' table in database");
      System.out.println("2: Add new movie");
      System.out.println("3: Fetch all movies");
      System.out.println("4: Fetch all movies for lead actor");
      System.out.println("5: Fetch all movies for lead actress");
      System.out.println("6: Fetch all movies of a particular year");
      System.out.println("0: Exit");
      System.out.println("-----------------------------------------");
      System.out.print("Choice: ");
      code = scan.nextInt();
      scan.nextLine();

      switch (code) {
        case 1:
          {
            MovieDbOps movieDbOps = MovieDbOpsSingleton.getInstance();
            movieDbOps.createTable();
            break;
          }

        case 2:
          {
            MovieDbOps movieDbOps = MovieDbOpsSingleton.getInstance();
            Movie movie = Movie.readNewMovie(scan);
            movieDbOps.addMovie(movie);
            System.out.println("----------- Movie Added -----------");
            break;
          }

        case 3:
          {
            MovieDbOps movieDbOps = MovieDbOpsSingleton.getInstance();
            List<Movie> allMovies = movieDbOps.getAllMovies();
            System.out.println("----------- Movie List -----------");
            if (allMovies.isEmpty()) {
              System.out.println("No movies added");
            }
            for (Movie movie : allMovies) {
              System.out.println(movie.toString());
            }
            System.out.println("----------------------------------");
            break;
          }

        case 4:
          {
            MovieDbOps movieDbOps = MovieDbOpsSingleton.getInstance();
            System.out.println("Enter movie lead actor");
            String actor = scan.nextLine();
            List<Movie> allMovies = movieDbOps.getAllMoviesWithActor(actor);
            System.out.println("----------- Movie List -----------");
            if (allMovies.isEmpty()) {
              System.out.println("No movies added");
            }
            for (Movie movie : allMovies) {
              System.out.println(movie.toString());
            }
            System.out.println("----------------------------------");
            break;
          }

        case 5:
          {
            MovieDbOps movieDbOps = MovieDbOpsSingleton.getInstance();
            System.out.println("Enter movie lead actress");
            String actress = scan.nextLine();
            List<Movie> allMovies = movieDbOps.getAllMoviesWithActress(actress);
            System.out.println("----------- Movie List -----------");
            if (allMovies.isEmpty()) {
              System.out.println("No movies added");
            }
            for (Movie movie : allMovies) {
              System.out.println(movie.toString());
            }
            System.out.println("----------------------------------");
            break;
          }

        case 6:
          {
            MovieDbOps movieDbOps = MovieDbOpsSingleton.getInstance();
            System.out.println("Enter movie's year of release");
            int year = scan.nextInt();
            List<Movie> allMovies = movieDbOps.getAllMoviesFromYear(year);
            System.out.println("----------- Movie List -----------");
            if (allMovies.isEmpty()) {
              System.out.println("No movies added");
            }
            for (Movie movie : allMovies) {
              System.out.println(movie.toString());
            }
            System.out.println("----------------------------------");
            break;
          }

        case 0:
          System.out.println("Exit!");
          break;

        default:
          System.out.println("Invalid Input");
          break;
      }
    } while (code != 0);
  }
}
