package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> list = Arrays.asList();

        Optional<Integer> red =
        list.stream()
          .reduce(Integer::max);

        System.out.println("red = " +red);


        List<Person> people = Arrays.asList(Person.getRandomPerson(), Person.getRandomPerson());

        people
    }
}
