/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Zsolt Ollé
 */
public class ScreenResolution {

    private Dimension screenSize;
    private int screenX, screenY;
    private static int resX, resY, tableX;

    public ScreenResolution() {

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenX = screenSize.width;
        screenY = screenSize.height;

        // Get and Set resolution
        if (screenX < 1024 && screenY < 768) {
            resX = 800;
            resY = 600;
        } else if (screenX == 1024 && screenY == 768) {
            resX = screenX;
            resY = screenY;
        } else if (screenX == 1280 && screenY == 1024) {
            resX = screenX;
            resY = screenY;
        } else if (screenX == 1600 && screenY == 1200) {
            resX = screenX;
            resY = screenY;
        } else if (screenX == 1920 && screenY == 1080) {

            resX = screenX;
            resY = screenY;
//            resX = 1920;
//            resY = 1080;
            resX = 1600;
            resY = 1200;
            System.out.println("X tengely: " + resX);
            System.out.println("Y tengely: " + resY);
        } else {
            resX = 1600;
            resY = 1200;
        }

        tableX = (resX * 60) / 100; // játékfelület méretének beállítása
//        System.out.println("Propben tableX: "+tableX);
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Dimension screenSize) {
        this.screenSize = screenSize;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public static int getResX() {
        return resX;
    }

    public static int getResY() {
        return resY;
    }

    public static int getTableX() {
        return tableX;
    }

}
