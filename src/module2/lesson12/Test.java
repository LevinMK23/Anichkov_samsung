package module2.lesson12;

public class Test {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < 7; i++) {
            arr.add(i);
        }
        arr.add(3, 12);
        System.out.println(arr);
        arr.add(-12, 2);

    }
}
