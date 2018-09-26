/*
Queue ADT Applying Linked Deque
Nick Hawk & Ryan Krawczyk
 */

import java.lang.*;
import java.util.*;

public class LinkedDequeQueue<T> implements Queue<T> {

    private Deque<T> q;

    public LinkedDequeQueue() {
        this.q = new LinkedDeque<T>();
    }

    public void enqueue(T item) { this.q.pushRight(item); }

    public T dequeue() {
        if (this.q.isEmpty()) { throw new NoSuchElementException("EMPTY QUEUE"); }
        else { return this.q.popLeft(); }
    }

    public T peek() {
        if (this.q.isEmpty()) { throw new NoSuchElementException("EMPTY QUEUE"); }
        else { return this.q.farLeft.info; }
    }

    public boolean isEmpty() { return this.q.isEmpty(); }

    public int size() { return this.q.size(); }

    public String toString() { return this.q.toString(); }

    public static void main(String[] args) {
        /* Unit Testing */
        ArrayList<String> names = new ArrayList<String>();
        names.add("Gunther");
        names.add("Garth");
        names.add("Gary");
        names.add("Gus");
    }

}
