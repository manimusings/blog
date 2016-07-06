package ctci.chap3;

import java.util.NoSuchElementException;
import java.util.Optional;

public class SingleStack<T> {

  Object[] delegate;
  int index = 0;
  int size = 0;

  public SingleStack(int size) {
    this.size = size;
    delegate = new Object[size];
  }

  public void push(T item) {
    if (index == size) {
      throw new IndexOutOfBoundsException();
    }
    delegate[index++] = item;
  }

  public T pop() {
    if (index == 0) {
      throw new NoSuchElementException();
    }
    try {
      return (T) delegate[--index];
    } finally {
      delegate[index] = null;
    }
  }

  public Optional<T> peek() {
    if (index == 0) {
      return Optional.empty();
    }
    return Optional.of((T) delegate[index - 1]);
  }

  public static void main(String[] args) {
    SingleStack<String> ts = new SingleStack<>(1);
    System.out.println(ts.peek());
    ts.push("10");
    System.out.println(ts.peek());
    System.out.println(ts.pop());
    ts.push("20");
    System.out.println(ts.peek());
    System.out.println(ts.pop());
  }
}
