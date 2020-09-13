package com.sber.lesson2.task5;

import java.util.Iterator;
import java.util.List;

public class MyList<T> implements Iterable<T> {

    private List<T> arrayList;
    private int currentSize;

    public MyList(List<T> newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.size();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = currentSize - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0 && arrayList.get(currentIndex) != null;
            }

            @Override
            public T next() {
                return arrayList.get(currentIndex--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
