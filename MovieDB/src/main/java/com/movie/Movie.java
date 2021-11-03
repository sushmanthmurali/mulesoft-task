package com.movie;

import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Movie {
  private String name;
  private String leadActor;
  private String leadActress;
  private int year;
  private String director;

  public static Movie readNewMovie(Scanner scan) {
    System.out.println("----------- Enter Movie Details -----------");
    System.out.println("Enter movie name");
    String name = scan.nextLine();
    System.out.println("Enter movie lead actor");
    String actor = scan.nextLine();
    System.out.println("Enter movie lead actress");
    String actress = scan.nextLine();
    System.out.println("Enter movie year");
    int year = scan.nextInt();
    scan.nextLine();
    System.out.println("Enter movie director");
    String director = scan.nextLine();
    return new Movie(name, actor, actress, year, director);
  }

  @Override
  public String toString() {
    return "Movie:: " +
        "Name='" + name + '\'' +
        ", Lead Actor='" + leadActor + '\'' +
        ", Lead Actress='" + leadActress + '\'' +
        ", Year=" + year +
        ", Director='" + director + '\'';
  }
}
