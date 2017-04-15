package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

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

    Optional<Person> opt =
      stream.filter(person -> person.getAge() >= 20)
      .min(Comparator.comparing(Person::getAge));
    System.out.println(opt);

    Optional<Person> opt2 = persons.stream().max(Comparator.comparing(Person::getAge));
      System.out.println(opt2);

    Map<Integer, Long> map = persons.stream().collect(Collectors.groupingBy(Person::getAge, counting()));
    System.out.println(map);
  }
}
