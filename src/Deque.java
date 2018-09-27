/*
Deque API
Nick Hawk & Ryan Krawczyk
 */

public interface Deque<T> {
  
  void pushLeft(T item);
  T popLeft();
  T peekLeft();

  void pushRight(T item);
  T popRight();
  T peekRight();

  int size();
  boolean isEmpty();
  String toString();

}
