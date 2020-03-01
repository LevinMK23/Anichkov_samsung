package module3.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(
                new File("src\\module3\\files\\output.txt")
        );
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000 / 10000; i++) {
            fos.write(new byte[10000]);
        }
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }
}
