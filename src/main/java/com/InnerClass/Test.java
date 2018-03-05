package com.InnerClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface CheckPerson {

    boolean testAge(Person p);

}

class CheckPersonEligibleForSelectiveService implements CheckPerson {

    public boolean testAge(Person p) {
        return p.getAge() >= 60;
    }

}

public class Test {

    public static void printPersonsOlderThan(List<Person> roster,  CheckPerson person) {

        for (Person p : roster) {

            if (person.testAge(p)) {

                System.out.println(p);

            }

        }

    }

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person(40, 30, "gagan"));
        list.add(new Person(60, 50, "shubham"));
        list.add(new Person(70, 60, "ajay"));
        list.add(new Person(80, 70, "kishore"));

        printPersonsOlderThan(list,

                (Person p) -> p.getAge() > 70

                );

        List names = Arrays.asList("Reflection","Collection","Stream");
        List result = (List) names.stream().sorted().collect(Collectors.toList());

        for (Object s : result){
            System.out.println(s);
        }

    }
}

 class Person {

    int age;
    int id;
    String name;

     @Override
     public String toString() {
         return "Person{" +
                 "age=" + age +
                 ", id=" + id +
                 ", name='" + name + '\'' +
                 '}';
     }

     public Person(int age, int id, String name) {
         this.age = age;
         this.id = id;
         this.name = name;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void printPerson(){
         System.out.println(this.toString());
     }

 }

