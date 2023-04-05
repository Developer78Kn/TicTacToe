/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import javax.swing.JButton;
import static tictactoexo.GamePlace.panGame;

/**
 *
 * @author Zsolt Ollé
 */
public class ButtonPlacement {

    protected static int btnDist, btnSize;

    protected static JButton[][] btn;
    private static int[][] state;

    public ButtonPlacement() {
    }

    public ButtonPlacement(JButton[][] btn) {
        this.btn = btn;
        place();
    }

    public static void btnMake() {
        btn = new JButton[Level.getSzorzo()][Level.getSzorzo()];
        state = new int[Level.getSzorzo()][Level.getSzorzo()];

        for (int i = 0; i < btn.length; i++) {
            for (int j = 0; j < btn[i].length; j++) {
                btn[i][j] = new JButton();
                btn[i][j].setVisible(true);
                btn[i][j].addActionListener(new ActionHandler());
                btn[i][j].setFocusPainted(false);
                btn[i][j].setContentAreaFilled(false);
                btn[i][j].setBorder(null);
                panGame.add(btn[i][j]);
            }
        }
    }

    public static void place() {
        btnMake();
        btnSize = (ScreenResolution.getTableX() / Level.getSzorzo()) - 10;
        System.out.println("IMG ++++++++++++++ IMG SIZE " + btnSize);

        int btnX = 5, btnY = 5;
        for (int i = 0; i < btn.length; i++) {
            btnX = 5;
            for (int j = 0; j < btn[i].length; j++) {
                btn[i][j].setBounds(btnX, btnY, btnSize, btnSize);
                btnX += btnSize + 10;
            }
            btnY += btnSize + 10;
        }
    }

    public static int getBtnDist() {
        return btnDist;
    }

    public static JButton[][] getBtn() {
        return btn;
    }

    public static int[][] getState() {
        return state;
    }

}
