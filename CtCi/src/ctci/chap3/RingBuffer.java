package ctci.chap3;

import java.util.Arrays;

public class RingBuffer<T> {

    private Object[] delegate;
    private int capacity = 0;
    private int mod = 0;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        delegate = new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T item) {
        put(mod++, item);
        mod %= capacity;
    }

    public T remove() {
        try {
            return get(mod--);
        } finally {
            put(mod, null);
            mod %= capacity;
        }
    }

    public T get(int idx) {
        return (T) delegate[idx % capacity];

    }

    public void put(int idx, T item) {
        delegate[idx % capacity] = item;
    }

    public static <T> void sort(RingBuffer<T> buffer) {
        Arrays.sort(buffer.delegate);
        buffer.mod = 0;
    }

    @Override
    public String toString() {
        return "RingBuffer{" +
                "delegate=" + Arrays.toString(delegate) +
                ", capacity=" + capacity +
                ", mod=" + mod +
                '}';
    }

    public static void main(String[] args) {
        RingBuffer<Integer> ts = new RingBuffer<>(3);
        ts.add(100);
        ts.add(10);
        ts.add(20);
        System.out.println(ts);
        ts.add(110);
        System.out.println(ts);
        ts.add(120);
        System.out.println(ts);
        ts.add(30);
        System.out.println(ts);


        RingBuffer.sort(ts);
        System.out.println(ts);

        ts.put(2, 5);
        System.out.println(ts);


    }
}
