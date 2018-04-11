import java.util.Observable;

public class ImageProcessor extends Observable{
    private Camera camera;
    public Image thisFrame;


    private String savePath = null;

    public ImageProcessor(Camera c) {
        setCamera(c);
    }

    public ImageProcessor(Camera c, String savePath) {
        this(c);
        setSavePath(savePath);
    }

    public void getNextImage(){
        thisFrame = camera.captureFrame();
        setChanged();
//        notifyObservers(thisFrame);
        notifyObservers();
    }

    public void saveImage(){
        thisFrame.saveImageJpg(savePath);
    }

    // getters and setters
    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Image getThisFrame() {
        return thisFrame;
    }

    public void setThisFrame(Image thisFrame) {
        this.thisFrame = thisFrame;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }


}
