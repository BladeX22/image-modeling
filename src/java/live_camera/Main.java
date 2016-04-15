package live_camera;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

/**
 * Created by rafal on 15.04.16.
 */
public class Main {
    public static void main(String[] args) {


    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    VideoCapture cap = new VideoCapture(0);

    Mat image = new Mat();
    MyFrame frame = new MyFrame();
    frame.setVisible(true);

    // Main loop
    while(true)

    {
        // Read current camera frame into matrix
        cap.read(image);
        // Render frame if the camera is still acquiring images
        if (image != null) {
            frame.render(image);
        } else {
            System.out.println("No captured frame -- camera disconnected");
            break;
        }
    }
}
}
