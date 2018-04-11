import java.util.*;

/**
 * Created by josh on 4/8/2018.
 */
public class MotionDetector implements Observer {
    private Queue<Image> frames = new LinkedList<>();     // keep a queue of Image objects.  the size of this is the window for observing motion

    private int maxNumFrames;
    private static int MAX_NUM_FRAMES_DEFAULT = 5;

    public MotionDetector(){
        maxNumFrames = MAX_NUM_FRAMES_DEFAULT;
    }

    public MotionDetector(int maxNumFrames){
        setMaxNumFrames(maxNumFrames);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ImageProcessor){
            ImageProcessor imageProcessor = (ImageProcessor) o;
            frames.add(imageProcessor.getThisFrame());  // add the frame to frames
            if(frames.size() > MAX_NUM_FRAMES_DEFAULT){
                frames.remove(); // keep the window size constant, removing a frame since a new one was created
            }
        }
    }

    public int getNumFrames(){
        return frames.size();
    }

    public int getMaxNumFrames() {
        return maxNumFrames;
    }

    public void setMaxNumFrames(int maxNumFrames) {
        this.maxNumFrames = maxNumFrames;
    }
}
