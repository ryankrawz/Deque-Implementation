public class LinkedDeque<T> implements Deque<T> {

  private int N;
  private Node farLeft;
  private Node farRight;

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
    this.N = 0;
    this.farLeft = null;
    this.farRight = null;
  }

  public void pushLeft(T item) {
    this.farLeft = new Node(item, null, this.right);
    this.N++;
  }

  public T popLeft(){
    if (this.isEmpty()) {
        throw new RuntimeException("STACK UNDERFLOW");
    }
    else {
        T info = this.farLeft.info;
        this.farLeft = this.right;
        this.N--;
        return info;
    }
  }

  public void pushRight(T item) {
    this.farRight = new Node(item, this.left, null);
    this.N++;
  }
  public T popRight() {
    if (this.isEmpty()) {
        throw new RuntimeException("STACK UNDERFLOW");
    }
    else {
      T info = this.farRight.info;
      this.farRight = this.left;
      this.N--;
      return info;
  }
}

  public int size() {
    return this.N;
  }

  public boolean isEmpty() {
    return this.N == 0;
  }

  public String toString() {

  String result = "[";
  for (int i = 0; i < N ; i++) {

    result += " " + this.farLeft;
    this.farLeft = this.farLeft.right;
    if(i <= N - 1) {
      result += ",";
    }
  }
  result += " ]";
  return result;
  }

}
