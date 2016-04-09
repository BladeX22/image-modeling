import java.io.IOException;

/**
 * Created by rafal on 09.04.16.
 */
public class StartApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        FaceDetector faceDetector = new FaceDetector();
        faceDetector.detect();
    }
}
