package ctci.chap3;

import java.util.NoSuchElementException;
import java.util.Optional;

public class SingleQueue<T> {

  private Object[] delegate;
    private int head = 0;
  private int tail = 0;
  private int size = 0;

  public SingleQueue(int size) {
    this.size = size;
    this.tail = size;
    this.head = size;
    delegate = new Object[size];
  }

  public void enqueue(T item) {
    if (tail == 0) {
      throw new IndexOutOfBoundsException();
    }
    delegate[--tail] = item;
  }

  public T dequeue() {
    if (head == size) {
      throw new NoSuchElementException();
    }
    try {
      return (T) delegate[--head];
    } finally {
      delegate[head] = null;
    }
  }

  public Optional<T> peek() {
    if (tail == size) {
      return Optional.empty();
    }
    return Optional.of((T) delegate[tail - 1]);
  }

  public static void main(String[] args) {
    SingleQueue<String> ts = new SingleQueue<>(2);
    System.out.println(ts.peek());
    ts.enqueue("10");
    ts.enqueue("20");
    System.out.println(ts.peek());
    System.out.println(ts.dequeue());
    System.out.println(ts.dequeue());
  }
}
