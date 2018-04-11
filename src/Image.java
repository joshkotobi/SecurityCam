import javax.imageio.ImageIO;
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
