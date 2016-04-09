
import com.github.sarxos.webcam.Webcam;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by rafal on 09.04.16.
 */
public class Camera {
    void run(){

        Webcam webcam = Webcam.getDefault();
        webcam.open();
        try {
            ImageIO.write(webcam.getImage(), "PNG", new File("resources/test.png"));
            System.out.println(webcam.close());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
