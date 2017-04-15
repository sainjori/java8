package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main
{

  public static void main(String[] args)
  {
    // write your code here
    List<Person> persons = new ArrayList<>();

    try (
      BufferedReader reader =
        new BufferedReader(
          new InputStreamReader(Main.class.getResourceAsStream("people.txt")));

      Stream<String> stream = reader.lines();
    )
    {

      stream.map(line ->
      {
        String[] s = line.split(" ");
        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
        persons.add(p);
        return p;
      })
        .forEach(System.out::println);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    Stream<Person> stream = persons.stream();

  }
}
