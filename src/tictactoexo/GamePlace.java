/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.awt.Color;
import java.awt.Panel;
import javax.swing.JFrame;

/**
 *
 * @author Zsolt Ollé
 */
public class GamePlace {

    protected static Panel panGame = new Panel();
    private int tableX, tableY;
    protected static Draw draw;
    protected JFrame mainFR;

    
    public GamePlace() {
    }

    public GamePlace(JFrame mainFR) {

        tableX = ScreenResolution.getTableX();
        tableY = tableX;

        panGame.setBounds(10, 10, tableX, tableY);
        panGame.setLayout(null);
        panGame.setBackground(new Color(255, 230, 204));
        panGame.setVisible(true);

        draw = new Draw();
    }
}
