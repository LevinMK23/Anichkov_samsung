package module4.Arrays;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArray<T> implements Iterable<T>{

    // TODO: 16.02.2020
    /*
    * remove(value) -> void (boolean)
    * remove(index) -> void
    * find(value) -> index
    * */

    @Override
    public Iterator<T> iterator() {
        final int[] pos = {0};
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return pos[0] < size;
            }

            @Override
            public T next() {
                T tmp = (T) data[pos[0]];
                pos[0]++;
                return tmp;
            }
        };
    }
    //for(Integer it : myClass)

    private Object [] data;
    private int capacity, size;

    public MyArray() {
        capacity = 100;
        data = new Object[capacity];
    }
    //.. .. .. .. .. .. .. .. N logN
    //N N / 100
    private void reallocate() {
        capacity *= 2;
        Object [] tmp = new Object[capacity];
        if (size >= 0) {
            System.arraycopy(data, 0, tmp, 0, size);
        }
        data = tmp;
    }

    public void add(T value) {
        if (size >= capacity) {
            reallocate();
        }
        data[size] = value;
        size++;
    }

    public void add(int index, T value) {
        if (size >= capacity) {
            reallocate();
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = value;
        size++;
    }

    public void remove() {
        size--;
    }

    @Override
    public String toString() {
        StringBuilder o = new StringBuilder();
        for (int i = 0; i < size; i++) {
            o.append(data[i]).append(' ');
        }
        return o.toString();
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }

}
