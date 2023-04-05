/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;


/**
 *
 * @author Zsolt Ollé
 */
public class Draw extends JLabel {

//    private static int[][] btnPiec = new int[Level.getSzorzo()][Level.getSzorzo()];
//    private static int baseLineDistance = (ScreenResolution.getTableX() / Level.getSzorzo());
    private static int[][] btnPiec;
    private static int baseLineDistance;

    private int VH_line;
//    private final int sizeXY = ScreenResolution.getTableX(), imgSize = ButtonPlacement.btnSize;
    private  int sizeXY = ScreenResolution.getTableX(), imgSize;

    @Override
    protected void paintComponent(Graphics g) {
        btnPiec = new int[Level.getSzorzo()][Level.getSzorzo()];
        baseLineDistance = (ScreenResolution.getTableX() / Level.getSzorzo());
        
//        System.out.println("////// Draw-ban btn mérete "+btnPiec.length);
//        System.out.println("/////  Game State mérete: "+ButtonPlacement.getState().length);
        
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4)); // *****************************
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw 
        g.setColor(new Color(255, 230, 204));
        g.fillRect(0, 0, sizeXY, sizeXY);
        // For line
        g.setColor(Color.BLACK);

        // tábla vonalainak felrajzolása forciklussal
        VH_line = 0;
        for (int i = 0; i < Level.getSzorzo() - 1; i++) {
            VH_line += baseLineDistance;
            // Vertical
            g.drawLine(VH_line, 0, VH_line, sizeXY);
            // Horizontal
            g.drawLine(0, VH_line, sizeXY, VH_line);
        }

        // itt kell kirajzolni a jelet
        for (int i = 0; i < ButtonPlacement.getState().length; i++) {
            for (int j = 0; j < ButtonPlacement.getState()[i].length; j++) {
//                System.out.println("IMAGE MERETE "+ButtonPlacement.btnSize+" pixel");
                imgSize = ButtonPlacement.btnSize;
                if (ButtonPlacement.getState()[i][j] == 1) {
                    g.drawImage(ImageLoader.imgX, ButtonPlacement.getBtn()[i][j].getBounds().x, ButtonPlacement.getBtn()[i][j].getBounds().y, imgSize, imgSize, null);
                } else if (ButtonPlacement.getState()[i][j] == 2) {
                    g.drawImage(ImageLoader.imgO, ButtonPlacement.getBtn()[i][j].getBounds().x, ButtonPlacement.getBtn()[i][j].getBounds().y, imgSize, imgSize, null);
                }
            } 
        }
//        repaint();
    }

    public static int[][] getBtnPiec() {
        return btnPiec;
    }

    public static int getBaseLineDistance() {
        return baseLineDistance;
    }

}
