# Java Foundations

## Overview

Hi, welcome to this repository!

It contains files from a portion of a Java Foundations course from the class that I am attending for a simple Java Console application, and I would like to reflect on my learnings here. The design of the application was provided to me in class. I have no prior knowledge of Java. I have some experience in HTML, CSS, JavaScript, C# with ASP.NET Core, and Python from my prior classes, mostly picked up in 4 months prior to this class.

Do note that the application is not an executable, nor does it take any user inputs. Hence, if you want to test its functions, you will need to [clone](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository) the repository into your Java Workspace and run the project in your Java IDE. I used Eclipse as my IDE.

## Topics

This application includes various concepts such as:
* [Creating Simple Java Classes](https://github.com/zephyrdark/gdipsa-sa4105-clubApplication?tab=readme-ov-file#creating-simple-java-classes)
* [Inheritance and Arrays](https://github.com/zephyrdark/gdipsa-sa4105-clubApplication?tab=readme-ov-file#inheritance-and-arrays)
* [Java Library Classes and Collections](https://github.com/zephyrdark/gdipsa-sa4105-clubApplication?tab=readme-ov-file#java-library-classes-and-collections)
* [Functional Programming](https://github.com/zephyrdark/gdipsa-sa4105-clubApplication?tab=readme-ov-file#functional-programming)

### Creating Simple Java Classes

Coming from C#, the concept of Classes is familiar to me. I understand that classes are necessary to achieve the desired state of "high cohesiveness and low coupling" via Object-Oriented Programming concepts: Abstraction, Encapsulation, Inheritance, and Polymorphism.

In this application, the `Person` class was created to contain attributes such as `surName`, `firstName`, `lastName`, which are common data stored to identify persons in a Club environment. The `Person` class can then serve as a base for future classes that involve persons. The `Facility` class contains attributes `name` and `description`.

**Reflections**:
1. Getters & setters are more verbose, but can be auto-generated by the IDE.
2. Getters & setters are accessed by calling their respective functions i.e., `getName()` instead of variable names.

### Inheritance and Arrays

The concept of Inheritance encourages the extending of classes based on the reusability of attributes, constructors, and functions for functionally similar Objects.

A `Member` class is created to store data of individual club members. It extends the `Person` class. A `Club` class is also created so that the application can create multiple Club instances, where each of them stores data of their own club members.

A `Member[]` array is initially chosen to store the Club's Member Objects. Due to the fixed-size nature of arrays, it can run out of space to store the Member Objects. A function was therefore created to expand the Member array everytime a new Member needs to be added into it.

**Reflections**:
1. A parent class is referred to as `super` in Java.
2. If a child Class is extends from a super Class and implements a method with the same signature as the super Class's, there is no indication that the super Class's method is overriden in the said child class. Thus, the convention is to include an `@Override` annotation above the overriden method.

### Java Library Classes and Collections

The Java Library contains many useful Classes that are meant to solve common issues. Such Classes include the `List` and `ArrayList`, which are improved versions of `array` that can resize dynamically and contain commonly used `interface Collection<T>` methods such as `.add(E e)` `.remove(Object o)`. Using an arraylist, the Member array is now replaced with `ArrayList<Member>` which resizes dynamically. The previously implemented function to expand the Member array is not needed anymore.

Another pair of useful Classes are `Map` and `HashMap`. Similar to the concept of Dictionaries in Python, a map  holds *key-value* pairs that can use to store value of a specific key. It is used to implement hashmap. In this application, the Club class uses a hashmap to store String as *key*, and Facility Object as *value*.

As the Club application has a feature for Members to book (reserve) various facilities for use, a `Booking` class is implemented. It uses other Classes such as `LocalDateTime` and `DateTimeFormatter` to handle the date/time values. In the process of making a Booking, there may be a variety of errors that can occur such as invalid Facilities, invalid booking timings, overlaps in booking sessions. Thus, `Exception` is used and extended to a `BadBookingException` class, which is designated to handle Booking related exceptions.

The Booking objects are stored in another hashmap called `BookingRegister`, which consolidates all bookings of all facilities in a given Club. Methods are implemented to get and remove the bookings.

**Reflections**:
1. It is important to note that Exceptions extended from `Exception` are checked exceptions and hence if a function implements `throw new ExtendedException`, its function signature also needs to include `throws ExtendedException`.
2. It is possible to extend Exceptions from `RunTimeException` which would become unchecked exceptions and would not need `throws ExtendedException` included in functions that implements `throw new ExtendedException`.

### Functional Programming

Lambda expressions in Java are similar to the same in C#. The concept of `interface Comparable<T>`, `interface Comparator<T>`, and `interface Stream<T>` are new to me. When combined with `Method References`, they drastically reduce the lines of code needed.

In the Club class, `showFacilitiesSortedByDescription()` is implemented to show the existing Facilities in the Club, sorted by the facility description in lexiconical order. It needed to:
1. Access a hashmap of `facilities<String, Facility>`, 
2. Access the Facility description using a static method of Facility class - `getDescription()`,
3. Check if the Facility description is `null`,
4. Sort the `Facility` Objects by description,
5. Call the `System.out.println` function on each of the `Facility` Objects.

The implementation is as follows:

```
public void showFacilitiesSortedByDescription() {
    facilities.values().stream()
        .filter(x -> x.getDescription() != null)
        .sorted(Comparator.comparing(Facility::getDescription))
        .forEach(System.out::println);
}
```

**Reflections**
1. It is crucial to familiarise myself with the common functions of the Collections and Stream interfaces, in order to reduce the amount of code needed for implementing features.