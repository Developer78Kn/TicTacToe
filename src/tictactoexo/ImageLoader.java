/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Zsolt Ollé
 */
public class ImageLoader {

    static Image imgX, imgO;

    public ImageLoader() {
        try {
            imgX = ImageIO.read(new File("res/x.png"));
            imgO = ImageIO.read(new File("res/o.png"));
        } catch (IOException ex) {
            //System.out.println(ex);
            ex.printStackTrace();
        }
    }
}
