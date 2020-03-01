package module3.files;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class Ex1 {

    public static void main(String[] args) throws IOException {
        File file = new File("src\\module3\\files\\img.png");
        FileOutputStream fos = new FileOutputStream(
                new File("src\\module3\\files\\output.txt"));
        FileInputStream fis = new FileInputStream(file);
        int x;
        while((x = fis.read()) != -1){
            fos.write(x);
        }
        fos.close();
/*
        try (PrintWriter pr = new PrintWriter(
                new File("C:\\Users\\Михаил Левин\\IdeaProjects\\" +
                        "Anichkov_samsung\\src\\module3\\files\\output.txt"))){
            dfs(file, pr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public static void dfs(File file, PrintWriter out) {
        if (file!= null) {
            out.println(file);
            if (file.isDirectory()) {
                if (file.listFiles() != null) {
                    for (File f : file.listFiles()) {
                        dfs(f, out);
                    }
                }
            }
        }
    }
}
