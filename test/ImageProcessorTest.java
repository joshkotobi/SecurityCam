import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImageProcessorTest {
    //    String testImagesFolder = "C:\\Users\\josh\\Documents\\programming\\java\\CameraProject\\photos\\FakeCameraPhotos";
//    String testImagesFolder = ".\\photos\\FakeCameraPhotos";
    public String testImagesFolder = "C:\\Users\\josh\\IdeaProjects\\SecurityCam\\photos\\FakeCameraPhotos";
    public String savePath = "C:\\Users\\josh\\IdeaProjects\\SecurityCam\\photos\\SecurityCamStoredImages";
    public ImageProcessor imageProcessor = new ImageProcessor(new FakeCamera(testImagesFolder), savePath);

    @Test
    void saveImage() {
        for(int i=0; i<10; i++) {
            imageProcessor.getNextImage();
            imageProcessor.saveImage();
        }
    }

    @Test
    void getNextImage() {
        for (int i = 0; i < 10; i++) {
            imageProcessor.getNextImage();
            System.out.println(imageProcessor.thisFrame.getTimestamp());
            // TODO create assertion to see if the new Image was actually loaded
        }
    }

    @Test
    void testObservers() {
        MotionDetector md = new MotionDetector();
        imageProcessor.addObserver(md);

        for(int i=1; i<=10; i++) {
            imageProcessor.getNextImage();
            if(i < md.getMaxNumFrames()) {
                assertEquals(i, md.getNumFrames());
            } else {
                assertEquals(md.getMaxNumFrames(), md.getNumFrames());
            }
        }
    }

}