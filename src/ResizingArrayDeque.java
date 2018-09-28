/*
Resizing Array Deque ADT
Nick Hawk & Ryan Krawczyk
 */

 import java.lang.*;
 import java.util.*;

 @SuppressWarnings("unchecked")

public class ResizingArrayDeque<T> implements Deque<T> {

  private int N;
  private int left, right;
  private T[] items;

  public ResizingArrayDeque() {
    this.N = 0;
    this.left = 0;
    this.right = 0;
    this.items = (T[]) new Object[2];
  }

  private void resize(int n) {
    T[] newItems = (T[]) new Object[n];
    for(int i = 0; i < this.N; i++) {
      newItems[i] = this.items[(this.left + i) % items.length];
      }
    items = newItems;
    this.left = 0;
    this.right = this.N;
  }

  public void pushLeft(T item) {
    if (this.N == this.items.length) {
      resize(this.N * 2);
    }
    if (this.left == 0) {
      this.left = items.length - 1;
    }
    else {
      this.left--;
    }
    items[this.left] = item;
    this.N++;
    if (this.right == this.items.length) {
      this.right = 0;
    }
  }

  public T popLeft() {
    if (this.N == 0) {
      throw new NoSuchElementException("EMPTY DEQUE");
    }
    T item = this.items[this.left];
    this.items[this.left++] = null;
    if (this.left == this.items.length) { this.left = 0; }

    this.N--;
    if (this.N < this.items.length / 4) {
      resize(this.items.length / 2);
    }
    return item;
  }

  public T peekLeft() { return this.items[this.left]; }

  public void pushRight(T item) {
    if (this.N == this.items.length) {
      resize(this.N * 2);
    }
    if (this.right == this.items.length) {
      this.right = 0;
    }
    else {
      this.right++;
    }
    items[this.right] = item;
    this.N++;
    if (this.right == this.items.length) {
      this.right = 0;
    }
  }

  public T popRight() {
    if (this.N == 0) {
      throw new NoSuchElementException("EMPTY DEQUE");
    }
    T item = this.items[this.right];
    this.items[this.right--] = null;
    if (this.right == 0) { this.right = this.items.length; }
    this.N--;
    if (this.N < this.items.length / 4) {
      resize(this.items.length / 2);
    }
    return item;
  }

  public T peekRight() { return this.items[this.right]; }

  public int size() { return this.N; }

  public boolean isEmpty() { return this.N == 0; }

  public String toString() {

    String f = "[ ";

    for (int i = 0; i < this.N; i++) {

      if (i + this.left >= items.length) {
        f += this.items[i + this.left - this.items.length];
        if(i != this.N-1) { f += " , "; }
      }
      else {
        f += this.items[i + this.left];
        if(i != this.N-1) { f += " , "; }
      }
  }
  f += " ]";
  return f;
  }

  public static void main(String[] args) {
    /* Unit Testing */
    Deque<String> testDeque = new ResizingArrayDeque<String>();
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
