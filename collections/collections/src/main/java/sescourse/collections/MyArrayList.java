package sescourse.collections;

public class MyArrayList<T> {

    private T[] elements;
    private int size;
    public MyArrayList() {
        this.elements = (T[])new Object[4];
        this.size = 0;
    }

    int capacity() { return elements.length; }
    int size() { return size; }

    T get(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return elements[index];
    }

    void add(T element) {
        if (size() >= capacity()) {
            var oldElements = elements;
            elements = (T[])new Object[capacity() * 2];
            for (int i = 0; i < size(); i++) {
                elements[i] = oldElements[i];
            }
        }
        elements[size] = element;
        size++;
    }

    T last() { return get(size() - 1); }

    public void remove(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        // elements[index] = null;
        for (int i = index+1; i < size(); i++) {
            elements[i-1] = elements[i];
        }
        elements[size() - 1] = null;
        size--;
    }

}
