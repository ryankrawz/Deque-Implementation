/*
Queue API
Nick Hawk & Ryan Krawczyk
 */


public interface Queue<T> {

  void enqueue(T item);
  T dequeue();
  T peek();

  boolean isEmpty();
  int size();
  String toString();

}
