/*
Linked Deque ADT
Nick Hawk & Ryan Krawczyk
 */

import java.lang.*;

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
    } else {
      this.farLeft = new Node(item, null, this.farLeft);
    }
    this.lN++;
  }

  public T popLeft(){
    if (this.isEmpty()) {
        throw new RuntimeException("STACK UNDERFLOW");
    }
    else {
        T info = this.farLeft.info;
        this.farLeft = this.farLeft.right;
        this.lN--;
        return info;
    }
  }

  public void pushRight(T item) {
    if (this.rN == 0 && this.lN == 1) {
      this.farRight = new Node(item, this.farLeft, null);
    } else {
      this.farRight = new Node(item, this.farRight, null);
    }
    this.rN++;
  }

  public T popRight() {
    if (this.isEmpty()) {
        throw new RuntimeException("STACK UNDERFLOW");
    }
    else {
      T info = this.farRight.info;
      this.farRight = this.farRight.left;
      this.rN--;
      return info;
    }
  }

  public int size() {
    return this.lN + this.rN;
  }

  public boolean isEmpty() {
    return this.lN + this.rN == 0;
  }

  public String toString() {
  String result = "[";
  Node current = this.farLeft;
  int limit = this.size();
  for (int i = 0; i < limit; i++) {
    result += " " + current.info;
    if (!(i == limit - 1)) { current = current.right; }
    if(i < limit - 1) {
      result += " ,";
    }
  }
  result += " ]";
  return result;
  }

//  public String toString() {
//    StringBuilder sb = new StringBuilder();
//    sb.append("[ ");
//    Node current = this.farLeft;
//    while (current != null) {
//      sb.append(current.info.toString() + " ");
//      current = current.right;
//    }
//    sb.append("]");
//    return sb.toString();
//  }

  public static void main(String[] args) {
    /* Unit Testing */
    Deque<String> testDeque = new LinkedDeque<String>();

    // Pushing
    testDeque.pushLeft("Gunther");
    System.out.format("After pushing Gunther left: %s%n", testDeque.toString());
    testDeque.pushRight("Garth");
    System.out.format("After pushing Garth right: %s%n", testDeque.toString());
    testDeque.pushLeft("Gary");
    System.out.format("After pushing Gary left: %s%n", testDeque.toString());
    testDeque.pushRight("Gus");
    System.out.format("After pushing Gus right: %s%n", testDeque.toString());
    System.out.format("Size of deque: %d%n%n", testDeque.size());

    // Popping

  }

}
