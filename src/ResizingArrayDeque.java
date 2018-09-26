/*
Resizing Array Deque ADT
Nick Hawk & Ryan Krawczyk
 */

 import java.lang.*;
 import java.util.NoSuchElementException;

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
      throw new NoSuchElementException("UNDERFLOW");
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
      throw new NoSuchElementException("UNDERFLOW");
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

  public int size() { return this.N; }
  public boolean isEmpty() { return this.N == 0; }
  // public String toString();



 }
