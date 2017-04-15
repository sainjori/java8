package com.company;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by barry2 on 4/15/2017.
 */
public class Person
{
  public String name;
  public int age;

  public Person(String name, int age)
  {
    this.name = name;
    this.age = age;
  }

  public String getName()
  {
    return name;
  }

  public Person setName(String name)
  {
    this.name = name;
    return this;
  }

  public int getAge()
  {
    return age;
  }

  public Person setAge(int age)
  {
    this.age = age;
    return this;
  }

  public static final Person getRandomPerson()
  {
    String randomString = getRandomString();
    return new Person(randomString, new Random().nextInt());
  }

  private static String getRandomString()
  {
    final SecureRandom random = new SecureRandom();
    return new BigInteger(130, random).toString(32);
  }

  @Override public String toString()
  {
    return "Person{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
