# CSCI 1102 Computer Science 2

### Fall 2018

------

## Problem Set 4 : Deques

### 10 Points

### Due Sunday September 30, 2018 Midnight

This is a pair problem set. Find a partner soon. Notify the whole staff by having just one team member email the whole staff. The subject line should be exactly `Subject: CS2 PS4 Partners: Muller, Jiang`, where `Muller` and `Jiang` are the surnames of the partners. If you don't have a partner in mind, try using Piazza's partner finding tool for help. Or ask a staffer to help connect you with someone. 

### Part 1: Two Implementations of Deques

This is a variation of problem 1.3.33 of SW. Implement the Deque ADT.

```java
public interface Deque<T> {

  void pushLeft(T item);
  void pushRight(T item);
  T popLeft();
  T popRight();
  int size();
  boolean isEmpty();
  String toString();
}
```

In this problem set, you are to design and implement two classes implementing the above API. One class should be called `LinkedDeque<T>` and should use a doubly-linked list to implement the API. The other class should be called `ResizingArrayDeque<T>` and it should implement the API using a resizing array.

Following our usual practice, each implementation class should contain `main` functions that create values of type `Deque<T>` for testing purposes.

### Part 2: Using one ADT to Build Another

Use either one of your implementations of the generic Deque ADT to build a generic Queue ADT. The API should be as usual

```java
public interface Queue<Item> {

  void enqueue(Item item);
  Item dequeue();
  Item peek();

  boolean isEmpty();
  int size();
  String toString();
}
```

