package sescourse.collections;

import java.util.Iterator;

class IntRangeIterator implements Iterator<Integer> {

    public IntRangeIterator(int lowest, int highest) {
        this.lowest = lowest;
        this.highest = highest;
        this.next = lowest;
    }
    private int lowest;
    private int highest;
    private int next;

    @Override
    public boolean hasNext() {
        return next <= highest;
    }

    @Override
    public Integer next() {
        return next++;
    }
}

record IntRange(int lowest, int highest)
        implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new IntRangeIterator(
                this.lowest(),
                this.highest());
    }
}

public class IntRangeMain {
    public static void main(String[] args) {
        var range = new IntRange(3, 6);
        for (var x : range) {
            System.out.println(x);
        }
    }
}