package module2.lesson12;

public class MyArray<T> {

    private int size, capacity;
    private Object [] data;

    public MyArray() {
        size = 0;
        capacity = 100;
        data = new Object[capacity];
    }

    public T get(int idx) {
        return (T) data[idx];
    }

    private void realloc(){
        capacity *= 2;
        Object [] tmp = new Object[capacity];
        if (size >= 0) {
            System.arraycopy(data, 0, tmp,
                    0, size);
        }
        data = tmp;
    }

    public void add(int index, T element){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("index = " + index);
        }
        if(size < capacity){
            for (int i = size; i > index; i--) {
                data[i] = data[i-1];
            }
            data[index] = element;
        }
        else{
            realloc();
            for (int i = size; i > index; i--) {
                data[i] = data[i-1];
            }
            data[index] = element;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(' ');
        }
        return sb.toString();
    }

    public void add(T element){
        if(size < capacity) {
            data[size] = element;
            size++;
        }
        else{
            realloc();
            data[size] = element;
            size++;
        }
    }
}
