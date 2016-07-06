package ctci.chap3;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ThreeStacks<T> {

  Object[] delegate;
  private int[] stackSizes;
  private int[] stackIndices;
  private int[] delegateOffsets;
  private int size = 0;

  public ThreeStacks(int... sizes) {
    stackSizes = new int[sizes.length];
    stackIndices = new int[sizes.length];
    delegateOffsets = new int[sizes.length];
    for (int i = 0; i < sizes.length; ++i) {
      stackSizes[i] = sizes[i];
      this.size += sizes[i];
      stackIndices[i] = 0;
      if (i == 0) {
        delegateOffsets[i] = 0;
      } else {
        delegateOffsets[i] = delegateOffsets[i - 1] + sizes[i - 1];
      }
    }
    delegate = new Object[this.size];
  }

  public void push(int stack, T item) {
    if (stackIndices[stack] == stackSizes[stack]) {
      throw new IndexOutOfBoundsException();
    }
    delegate[delegateOffsets[stack] + stackIndices[stack]] = item;
    stackIndices[stack] += 1;
  }

  public T pop(int stack) {
    if (stackIndices[stack] == 0) {
      throw new NoSuchElementException();
    }
    stackIndices[stack] -= 1;
    return (T) delegate[delegateOffsets[stack] + stackIndices[stack]];
  }

  public Optional<T> peek(int stack) {
    if (stackIndices[stack] == 0) {
      return Optional.empty();
    }
    return Optional.of((T) delegate[delegateOffsets[stack] + stackIndices[stack] - 1]);
  }

  public static void main(String[] args) {
    ThreeStacks<String> ts = new ThreeStacks<>(1, 2, 3);
    System.out.println(ts.peek(0));
    System.out.println(ts.peek(1));
    System.out.println(ts.peek(2));
    ts.push(0, "10");
    ts.push(1, "11");
    ts.push(1, "12");
    ts.push(2, "13");
    ts.push(2, "14");
    ts.push(2, "15");
    System.out.println(ts.peek(0));
    System.out.println(ts.pop(0));
    System.out.println(ts.peek(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.pop(1));
    System.out.println(ts.peek(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
    System.out.println(ts.pop(2));
  }
}
