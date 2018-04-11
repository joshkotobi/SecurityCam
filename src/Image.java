import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class Image {
    private BufferedImage img;
    private Instant timestamp;

    // constructors
    public Image(String imageFilepath) {
        this(new File(imageFilepath));
    }

    public Image(File imageFile) {
        setTimestamp();
        try {
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image(BufferedImage img){
        setTimestamp();
        this.img = img;
    }
    // --- end of constructors

    public void saveImageJpg(String filepath){
        saveImageJpg(filepath, getTimestamp().toString().replace(".","_").replace(":","_") + ".jpg"); // use the timestamp as the filename
    }

    public void saveImageJpg(String filepath, String filename){
        saveImageJpg(new File(filepath + "\\" + filename));
    }

    public void saveImageJpg(File file){
        try {
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] getMatrix(){
        int height = img.getHeight();
        int width = img.getWidth();
        int[][] returnMatrix = new int[height][width];
        Color pixelColor;

        for(int j=0; j<height; j++){
            for(int i=0; i<width; i++){
                pixelColor = new Color(img.getRGB(i,j));
                returnMatrix[j][i] = (pixelColor.getBlue() + pixelColor.getRed() + pixelColor.getGreen())/3;  // average the three colors to get some gray value
            }
        }
        return returnMatrix;
    }

    // getters and setters
    public void setTimestamp(){
        timestamp = Instant.now();
    }

    public void setTimestamp(Instant timestamp){
        this.timestamp = timestamp;
    }

    public Instant getTimestamp(){
        return timestamp;
    }

    public void setImage(BufferedImage img){
        this.img = img;
    }

    public BufferedImage getImage(){
        return img;
    }
}
