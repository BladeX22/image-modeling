package live_camera;
import org.opencv.core.*;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

/**
 * Created by rafal on 15.04.16.
 */
public class Main {
    public static void main(String[] args) {


    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        CascadeClassifier faceDetector = new CascadeClassifier("/home/rafal/Idea/resources/haarcascade_frontalface_alt.xml");
    VideoCapture cap = new VideoCapture(0);

    Mat image = new Mat();
    MyFrame frame = new MyFrame();
    frame.setVisible(true);
        MatOfRect faceDetections = new MatOfRect();


    // Main loop
    while(true)

    {
        // Read current camera frame into matrix
        cap.read(image);
        // Render frame if the camera is still acquiring images
        if (image != null) {
            faceDetector.detectMultiScale(image, faceDetections);
            for (Rect rect : faceDetections.toArray()) {
                Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                        new Scalar(0, 120, 0));
            }
            frame.render(image);

        } else {
            System.out.println("No captured frame -- camera disconnected");
            break;
        }
    }
}
}
