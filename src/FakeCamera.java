import java.io.File;

public class FakeCamera extends Camera {
//    String imageFolderPath = "C:\\Users\\josh\\Documents\\programming\\java\\CameraProject\\photos\\FakeCameraPhotos";
    private String rootImageFolderPath;
    private File[] imageFilepaths;
    private int imgCounter=0;  // keep track of which image the camera is about to output

    public FakeCamera(String rootImageFolderPath){
        this.rootImageFolderPath = rootImageFolderPath;

        File dir = new File(rootImageFolderPath);
        imageFilepaths = dir.listFiles((d, name) -> name.endsWith(".jpg"));  // lambda function to call FilenameFilter
    }

    @Override
    public Image captureFrame() {
        Image returnImage = new Image(imageFilepaths[imgCounter]);

        if(imgCounter < imageFilepaths.length - 1) // set counter for next image.  loop if this is the last image
            imgCounter++;
        else
            imgCounter = 0;

        return returnImage;
    }
}

