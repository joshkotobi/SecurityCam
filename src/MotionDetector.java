import java.util.*;

/**
 * Created by josh on 4/8/2018.
 */
public class MotionDetector implements Observer {
    private Queue<Image> frames = new LinkedList<>();     // keep a queue of Image objects.  the size of this is the window for observing motion
    private Queue<int[][]> framesAsMatrices = new LinkedList<>();
    private int maxNumFrames;
    private static int MAX_NUM_FRAMES_DEFAULT = 5;

    public MotionDetector(){
        maxNumFrames = MAX_NUM_FRAMES_DEFAULT;
    }

    public MotionDetector(int maxNumFrames){
        setMaxNumFrames(maxNumFrames);
    }

    public boolean isMotion(){
        // todo implement this code by subtracting adjacent frames
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ImageProcessor){
            ImageProcessor imageProcessor = (ImageProcessor) o;
            Image newFrame = imageProcessor.getThisFrame();
            frames.add(newFrame);  // add the frame to frames
            framesAsMatrices.add(newFrame.getMatrix());

            if(frames.size() > MAX_NUM_FRAMES_DEFAULT){
                frames.remove(); // keep the window size constant, removing a frame since a new one was created
                framesAsMatrices.remove();
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
