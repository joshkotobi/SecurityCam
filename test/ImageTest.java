import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    //    String testImageFilepath = ".\\photos\\FakeCameraPhotos\\1.jpg";
    private String testImageFilepath = "C:\\Users\\josh\\IdeaProjects\\SecurityCam\\photos\\FakeCameraPhotos\\1.jpg";
    private String savePath = "C:\\Users\\josh\\IdeaProjects\\SecurityCam\\photos\\SecurityCamStoredImages";
    private Image img = new Image(testImageFilepath);

    @org.junit.jupiter.api.Test
    void saveImageJpg() {
        img.saveImageJpg(savePath);
    }

    @Test
    void saveImageJpg1() {
        img.saveImageJpg(savePath, "customImageName.jpg");
    }

    @Test
    void verifyLoadedImage() {
//        System.out.println(img.toString());
        BufferedImage img;
        File f = new File("C:/Users/josh/IdeaProjects/SecurityCam/photos/FakeCameraPhotos/1.jpg");
        try {
            img = ImageIO.read(f);
            ImageIO.write(img, ".jpg", new File("C:/Users/josh/IdeaProjects/SecurityCam/photos/SecurityCamStoredImages/1.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMatrix() {
        int[][] matrix = img.getMatrix();
        for(int j=0; j<matrix.length; j++){
            for(int i=0; i<matrix[j].length; i++){
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println("\n");
        }
    }


}