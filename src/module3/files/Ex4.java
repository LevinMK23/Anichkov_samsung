package module3.files;

import java.io.File;
import java.io.IOException;

public class Ex4 {

    interface A{
        int test();
    }

    public static void main(String[] args) {

        A a = new A() {
            @Override
            public int test() {
                return 0;
            }
        };
        try {
            System.out.println(1 / 2);
            System.out.println((new int[2])[1]);
            String s = null;
            System.out.println(s);
        } catch (Throwable e) {
            System.out.println(e.getClass());
        }

    }

    class Test implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print("*");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public long createFile(String fileName){
        File file = new File(fileName);
        if (file.exists()) {
            return file.lastModified();
        } else {
            try {
                file.createNewFile();
                return file.lastModified();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
