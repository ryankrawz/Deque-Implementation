/*
Linked Deque ADT
Nick Hawk & Ryan Krawczyk
 */

import java.lang.*;
import java.util.*;

public class LinkedDeque<T> implements Deque<T> {

  private int lN, rN;
  private Node farLeft, farRight;

  class Node {
    T info;
    Node right;
    Node left;
    Node(T info, Node left, Node right) {
      this.info = info;
      this.left = left;
      this.right = right;
    }
  }

  public LinkedDeque() {
    this.lN = 0;
    this.rN = 0;
    this.farLeft = null;
    this.farRight = null;
  }

  public void pushLeft(T item) {
    if (this.lN == 0 && this.rN == 1) {
      this.farLeft = new Node(item, null, this.farRight);
      this.farRight.left = this.farLeft;
    } else if (this.lN == 0 && this.rN == 0) {
      this.farLeft = new Node(item, null, null);
      this.farRight = this.farLeft;
    } else {
      this.farLeft.left = new Node(item, null, this.farLeft);
      this.farLeft = this.farLeft.left;
    }
    this.lN++;
  }

  public T popLeft() {
    if (this.isEmpty()) {
        throw new NoSuchElementException("EMPTY DEQUE");
    }
    else {
        T info = this.farLeft.info;
        this.farLeft = this.farLeft.right;
        this.lN--;
        return info;
    }
  }

  public T peekLeft() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("EMPTY DEQUE");
    }
    else {
      return this.farLeft.info;
    }
  }

  public void pushRight(T item) {
    if (this.rN == 0 && this.lN == 1) {
      this.farRight = new Node(item, this.farLeft, null);
      this.farLeft.right = this.farRight;
    } else if (this.rN == 0 && this.lN == 0) {
      this.farRight = new Node(item, null, null);
      this.farLeft = this.farRight;
    } else {
      this.farRight.right = new Node(item, this.farRight, null);
      this.farRight = this.farRight.right;
    }
    this.rN++;
  }

  public T popRight() {
    if (this.isEmpty()) {
        throw new NoSuchElementException("EMPTY DEQUE");
    }
    else {
      T info = this.farRight.info;
      this.farRight = this.farRight.left;
      this.rN--;
      return info;
    }
  }

  public T peekRight() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("EMPTY DEQUE");
    }
    else {
      return this.farRight.info;
    }
  }

  public int size() { return this.lN + this.rN; }

  public boolean isEmpty() { return this.lN + this.rN == 0; }

  public String toString() {
  String result = "[";
  Node current = this.farLeft;
  int limit = this.size();
  for (int i = 0; i < limit; i++) {
    result += " " + current.info.toString();
    if (!(i == limit - 1)) { current = current.right; }
    if(i < limit - 1) {
      result += " ,";
    }
  }
  result += " ]";
  return result;
  }

  public static void main(String[] args) {
    /* Unit Testing */
    Deque<String> testDeque = new LinkedDeque<String>();
    ArrayList<String> names = new ArrayList<String>();
    names.add("Gunther");
    names.add("Garth");
    names.add("Gary");
    names.add("Gus");

    // Pushing
    System.out.format("%n");
    for (int i = 0; i < names.size(); i++) {
      if (i % 2 == 0) {
        testDeque.pushLeft(names.get(i));
        System.out.format("After pushing %s left: %s%n", names.get(i), testDeque.toString());
      } else {
        testDeque.pushRight(names.get(i));
        System.out.format("After pushing %s right: %s%n", names.get(i), testDeque.toString());
      }
    }
    System.out.format("Size of deque: %d%n%n", testDeque.size());

    // Popping
    int roof = testDeque.size();
    for (int j = 0; j < roof; j++) {
      if (j % 2 == 0) {
        System.out.format("After popping %s left: %s%n", testDeque.popLeft(), testDeque.toString());
      } else {
        System.out.format("After popping %s right: %s%n", testDeque.popRight(), testDeque.toString());
      }
    }
    System.out.format("Size of deque: %d%n%n", testDeque.size());
  }

}
