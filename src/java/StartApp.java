
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rafal on 09.04.16.
 */
public class StartApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        int x = 1;
        Scanner scanner = new Scanner(System.in);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture camera = new VideoCapture(0);

        Mat image = new Mat();



        FaceDetector faceDetector = new FaceDetector();
        while(true){
            camera.read(image);

            //Thread.sleep(10);

        faceDetector.detect(image,Integer.toString(x));
            System.out.println("to end enter x");
            if(scanner.next().equals("x"))
                break;
            x++;

       }
    }
}
