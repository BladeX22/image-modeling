package face_detection;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

import java.io.IOException;

/**
 * Created by rafal on 09.04.16.
 */
public class FaceDetector {
    void detect(Mat image, String sign) throws IOException, InterruptedException {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


        System.out.println("\nRunning face_detection.FaceDetector");

        CascadeClassifier faceDetector = new CascadeClassifier(FaceDetector.
                class.getResource("haarcascade_frontalface_alt.xml").getPath());


        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 120, 0));
        }

        String filename = "output/output" + sign + ".png";
        System.out.println(String.format("Writing %s", filename));
        Highgui.imwrite(filename, image);

    }
}
