import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

import java.io.IOException;

/**
 * Created by rafal on 09.04.16.
 */
public class FaceDetector {
    void detect() throws IOException, InterruptedException {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture camera = new VideoCapture(0);

        System.out.println("\nRunning FaceDetector");

        CascadeClassifier faceDetector = new CascadeClassifier(FaceDetector.
                class.getResource("haarcascade_frontalface_alt.xml").getPath());

        Mat frame = new Mat();
        camera.read(frame);

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(frame, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

        String filename = "output/output.png";
        System.out.println(String.format("Writing %s", filename));
        Highgui.imwrite(filename, frame);
    }
}
