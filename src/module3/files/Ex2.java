package module3.files;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\module3\\files\\jpgimg.jpg");
        //boolean created = file.createNewFile();
        FileInputStream fis = new FileInputStream(
                new File("src\\module3\\files\\output.txt"));
        FileOutputStream fos = new FileOutputStream(file);

//        while((x = fis.read()) != -1){
//            if(cnt > 200 && cnt < 300) fos.write(x & 240);
//            else fos.write(x);
//            cnt++;
//        }
//        fos.close();
    }
}
