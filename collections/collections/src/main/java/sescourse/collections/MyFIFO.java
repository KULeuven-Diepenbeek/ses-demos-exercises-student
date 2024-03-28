package sescourse.collections;

public class MyFIFO<T> {
    private T[] elements;
    public MyFIFO(int capacity) {
        elements = (T[])new Object[capacity];
    }
    private int next = 0;
    private int head = 0;
    private int size = 0;

    public int size() {
        return size;
    }

    public T poll() {
        if (size() == 0) return null;
        var h = elements[head];
        elements[head] = null;
        size--;
        head = (head + 1) % elements.length;
        return h;
    }

    public boolean add(T element) {
        if (size() == elements.length) return false;
        elements[next] = element;
        size++;
        next = (next + 1) % elements.length;
        return true;
    }


}
